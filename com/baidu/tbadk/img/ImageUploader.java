package com.baidu.tbadk.img;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.R;
import com.baidu.tieba.a15;
import com.baidu.tieba.fj;
import com.baidu.tieba.kn5;
import com.baidu.tieba.ln5;
import com.baidu.tieba.mn5;
import com.baidu.tieba.pp5;
import com.baidu.tieba.s95;
import com.baidu.tieba.tea;
import com.baidu.tieba.vea;
import com.baidu.tieba.vg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes4.dex */
public class ImageUploader {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_CHUNK_SIZE = 104857600;
    public static final int PICTURE_WATERMARK_TYPE_FORUM_NAME = 2;
    public static final int PICTURE_WATERMARK_TYPE_NOT_DISPLAY = 3;
    public static final int PICTURE_WATERMARK_TYPE_USER_NAME = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int bigHeight;
    public int bigWidth;
    public int chunkSize;
    public String from;
    public String groupId;
    public int imageChunkRetry;
    public WriteImagesInfo imagesInfo;
    public boolean isCancelled;
    public boolean isFromBJH;
    public NetWork mNetwork;
    public kn5 mUploadStrategy;
    public b multiProgressCallback;
    public a progressCallback;
    public Object progressObject;
    public int smallHeight;
    public int smallWidth;
    public int waterMaskType;
    public WriteData writeData;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str, Object obj, long j, long j2, int i, int i2);
    }

    public ImageUploader(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.chunkSize = 512000;
        this.groupId = "1";
        this.mNetwork = null;
        this.from = str;
    }

    private ImageUploadResult uploadInBackground(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.mUploadStrategy == null) {
                this.mUploadStrategy = new kn5();
            }
            ImageUploadResult uploadInBackground = uploadInBackground(this.mUploadStrategy.j(this.writeData, imageFileInfo, z), z, z2, i, i2);
            String filePath = imageFileInfo.getFilePath();
            if (pp5.b.a(filePath)) {
                uploadInBackground.setSharpText(filePath);
            }
            return uploadInBackground;
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.isCancelled = true;
            NetWork netWork = this.mNetwork;
            if (netWork != null) {
                netWork.cancelNetConnect();
            }
        }
    }

    public int getBigHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bigHeight;
        }
        return invokeV.intValue;
    }

    public int getBigWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bigWidth;
        }
        return invokeV.intValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.from;
        }
        return (String) invokeV.objValue;
    }

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.groupId;
        }
        return (String) invokeV.objValue;
    }

    public int getSmallHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.smallHeight;
        }
        return invokeV.intValue;
    }

    public int getSmallWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.smallWidth;
        }
        return invokeV.intValue;
    }

    public boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.isCancelled;
        }
        return invokeV.booleanValue;
    }

    public void setBigHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.bigHeight = i;
        }
    }

    public void setBigWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.bigWidth = i;
        }
    }

    public void setChunkSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.chunkSize = i;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            this.from = str;
        }
    }

    public void setGroupId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.groupId = str;
        }
    }

    public void setSmallHeight(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.smallHeight = i;
        }
    }

    public void setSmallWidth(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.smallWidth = i;
        }
    }

    public void setWaterMaskType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.waterMaskType = i;
        }
    }

    public void setWriteData(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, writeData) == null) {
            this.writeData = writeData;
        }
    }

    public void setImageUploadProgressCallback(a aVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, aVar, obj) == null) {
            this.progressCallback = aVar;
            this.progressObject = obj;
            if (aVar != null) {
                this.chunkSize = 10240;
            }
        }
    }

    public void setMultiImageUploadProgressCallback(b bVar, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, bVar, obj) == null) {
            this.multiProgressCallback = bVar;
            this.progressObject = obj;
        }
    }

    public ImageUploadResult uploadInBackground(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048596, this, imageFileInfo, z)) == null) {
            return uploadInBackground(imageFileInfo, false, z);
        }
        return (ImageUploadResult) invokeLZ.objValue;
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) {
            this.bigWidth = i;
            this.bigHeight = i2;
            this.smallWidth = i3;
            this.smallHeight = i4;
        }
    }

    public ImageUploadResult uploadInBackground(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return uploadInBackground(imageFileInfo, z, z2, 1, 1);
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public ImageUploadResult uploadInBackground(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048598, this, str, z)) == null) {
            return uploadInBackground(str, false, z);
        }
        return (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult uploadInBackground(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            return uploadInBackground(str, z, z2, 1, 1);
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:227:0x056a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:235:0x057f */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:237:0x0581 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:303:0x06ba */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x03e0, code lost:
        r10 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x03e2, code lost:
        r10.append("|startChunk=");
        r10.append(r9);
        com.baidu.tieba.vea.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03fd, code lost:
        r15 = r3;
        r31 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0402, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0403, code lost:
        r9 = r3;
        r11 = r10;
        r21 = r12;
        r31 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x053f, code lost:
        r15 = r3;
        r21 = r12;
        r31 = r25;
        r11 = r27;
        r12 = 2;
        r24 = 0;
        r11.append("|startChunk=");
        r11.append(r9);
        r11.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x0555, code lost:
        if (r15 != null) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0557, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x0559, code lost:
        r7 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x055a, code lost:
        r11.append(r7);
        r11.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0563, code lost:
        if (r15 == null) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x0565, code lost:
        r11.append(r15.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x056a, code lost:
        if (r15 != null) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x056c, code lost:
        r9 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:230:0x0572, code lost:
        r9.error_code = -7;
        r9.error_msg = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x0576, code lost:
        r23 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0579, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x057a, code lost:
        r3 = r0;
        r31 = r31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0180, code lost:
        r15.append("|startChunk=");
        r15.append(r9);
        r3 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x018d, code lost:
        r3.error_code = -54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x018f, code lost:
        r9 = r2;
        r23 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0194, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0195, code lost:
        r31 = r2;
        r9 = r3;
        r21 = r12;
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01d6, code lost:
        if (r10.length != r7) goto L297;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0370 A[Catch: all -> 0x0224, Exception -> 0x0226, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0224, blocks: (B:81:0x021c, B:98:0x024d, B:103:0x028d, B:105:0x0291, B:108:0x02c5, B:111:0x02d1, B:117:0x02e7, B:119:0x02f4, B:121:0x02fe, B:122:0x0307, B:126:0x0314, B:127:0x031c, B:129:0x0328, B:131:0x0334, B:132:0x033a, B:136:0x0343, B:141:0x0358, B:143:0x0364, B:146:0x0370, B:152:0x038b, B:159:0x03a5, B:161:0x03c6, B:164:0x03cb, B:167:0x03e2, B:179:0x043c, B:186:0x0455), top: B:319:0x021c }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03a5 A[Catch: all -> 0x0224, Exception -> 0x0395, TRY_ENTER, TryCatch #3 {all -> 0x0224, blocks: (B:81:0x021c, B:98:0x024d, B:103:0x028d, B:105:0x0291, B:108:0x02c5, B:111:0x02d1, B:117:0x02e7, B:119:0x02f4, B:121:0x02fe, B:122:0x0307, B:126:0x0314, B:127:0x031c, B:129:0x0328, B:131:0x0334, B:132:0x033a, B:136:0x0343, B:141:0x0358, B:143:0x0364, B:146:0x0370, B:152:0x038b, B:159:0x03a5, B:161:0x03c6, B:164:0x03cb, B:167:0x03e2, B:179:0x043c, B:186:0x0455), top: B:319:0x021c }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0506 A[LOOP:0: B:42:0x0174->B:209:0x0506, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x0630 A[Catch: all -> 0x06bc, TRY_ENTER, TRY_LEAVE, TryCatch #18 {all -> 0x06bc, blocks: (B:280:0x0620, B:297:0x0657, B:296:0x0653, B:286:0x0630), top: B:342:0x0620 }] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x063b A[Catch: all -> 0x062b, TRY_ENTER, TryCatch #7 {all -> 0x062b, blocks: (B:282:0x0624, B:289:0x063b, B:292:0x064c, B:294:0x0650), top: B:325:0x0624 }] */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0649  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x064c A[Catch: all -> 0x062b, TryCatch #7 {all -> 0x062b, blocks: (B:282:0x0624, B:289:0x063b, B:292:0x064c, B:294:0x0650), top: B:325:0x0624 }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0650 A[Catch: all -> 0x062b, TRY_LEAVE, TryCatch #7 {all -> 0x062b, blocks: (B:282:0x0624, B:289:0x063b, B:292:0x064c, B:294:0x0650), top: B:325:0x0624 }] */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0653 A[Catch: all -> 0x06bc, TRY_ENTER, TryCatch #18 {all -> 0x06bc, blocks: (B:280:0x0620, B:297:0x0657, B:296:0x0653, B:286:0x0630), top: B:342:0x0620 }] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0624 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:355:0x038b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x04f3 A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v119 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v56 */
    /* JADX WARN: Type inference failed for: r2v57 */
    /* JADX WARN: Type inference failed for: r2v82 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r31v4 */
    /* JADX WARN: Type inference failed for: r31v44 */
    /* JADX WARN: Type inference failed for: r31v5 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v37 */
    /* JADX WARN: Type inference failed for: r3v9, types: [com.baidu.tbadk.core.util.NetWork] */
    /* JADX WARN: Type inference failed for: r3v94 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult uploadInBackground(String str, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        RandomAccessFile randomAccessFile;
        ?? r2;
        String str2;
        StringBuilder sb;
        int i3;
        char c;
        Exception exc;
        RandomAccessFile randomAccessFile2;
        RandomAccessFile randomAccessFile3;
        RandomAccessFile randomAccessFile4;
        Throwable th;
        NetWork netWork;
        ImageUploadResult imageUploadResult;
        String str3;
        NetWork netWork2;
        ImageUploadResult imageUploadResult2;
        String message;
        File file;
        long length;
        RandomAccessFile randomAccessFile5;
        RandomAccessFile randomAccessFile6;
        long j;
        RandomAccessFile randomAccessFile7;
        RandomAccessFile randomAccessFile8;
        RandomAccessFile randomAccessFile9;
        RandomAccessFile randomAccessFile10;
        RandomAccessFile randomAccessFile11;
        int i4;
        StringBuilder sb2;
        byte[] bArr;
        RandomAccessFile randomAccessFile12;
        RandomAccessFile randomAccessFile13;
        RandomAccessFile randomAccessFile14;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult3;
        long j2;
        long j3;
        BitmapFactory.Options options;
        byte[] bArr2;
        long j4;
        String str4;
        long j5;
        int i5;
        int i6;
        RandomAccessFile randomAccessFile15;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            String str5 = str;
            String str6 = "    p = ";
            vea.a("发帖：正在上传图片 = " + str5);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            boolean z3 = true;
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str5, options2);
            if (options2.outWidth != 0 && options2.outHeight != 0) {
                StringBuilder sb3 = new StringBuilder();
                ImageUploadResult imageUploadResult4 = null;
                Closeable closeable = null;
                imageUploadResult4 = null;
                try {
                    file = new File(str5);
                    length = file.length();
                    try {
                        try {
                        } catch (Throwable th2) {
                            th = th2;
                            netWork = 0;
                        }
                    } catch (Exception e) {
                        exc = e;
                        r2 = null;
                        randomAccessFile5 = null;
                        str2 = "    p = ";
                        sb = sb3;
                    }
                } catch (Exception e2) {
                    r2 = null;
                    str2 = "    p = ";
                    sb = sb3;
                    i3 = 2;
                    c = 0;
                    exc = e2;
                } catch (Throwable th3) {
                    th = th3;
                    randomAccessFile = null;
                }
                try {
                    try {
                        if ((!z && length > 5242880) || (z && length > Config.FULL_TRACE_LOG_LIMIT)) {
                            ImageUploadResult imageUploadResult5 = new ImageUploadResult();
                            try {
                                imageUploadResult5.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                                imageUploadResult5.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                                vea.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                                vg.b(null);
                                this.mNetwork = null;
                                return imageUploadResult5;
                            } catch (Exception e3) {
                                exc = e3;
                                randomAccessFile2 = null;
                                str2 = "    p = ";
                                sb = sb3;
                                i3 = 2;
                                c = 0;
                                imageUploadResult4 = imageUploadResult5;
                                r2 = null;
                            }
                        } else {
                            vea.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                            String b2 = fj.b(FileHelper.GetStreamFromFile(file));
                            sb3.append("path=");
                            sb3.append(str5);
                            sb3.append("|length=");
                            sb3.append(length);
                            sb3.append("|md5=");
                            sb3.append(b2);
                            long j6 = 0;
                            if (length == 0 || b2 == null) {
                                str2 = "    p = ";
                                sb = sb3;
                                i3 = 2;
                                c = 0;
                                try {
                                    try {
                                        imageUploadResult4 = new ImageUploadResult();
                                        try {
                                            imageUploadResult4.error_code = -1007;
                                            imageUploadResult4.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                                            imageUploadResult = imageUploadResult4;
                                            randomAccessFile6 = null;
                                        } catch (Exception e4) {
                                            r2 = null;
                                            exc = e4;
                                            randomAccessFile2 = null;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        randomAccessFile = null;
                                        RandomAccessFile randomAccessFile16 = randomAccessFile;
                                        randomAccessFile3 = randomAccessFile16;
                                        randomAccessFile4 = randomAccessFile16;
                                        th = th;
                                        netWork = randomAccessFile4;
                                        closeable = randomAccessFile3;
                                        vg.b(closeable);
                                        this.mNetwork = netWork;
                                        throw th;
                                    }
                                } catch (Exception e5) {
                                    r2 = null;
                                    exc = e5;
                                    imageUploadResult4 = null;
                                    randomAccessFile2 = imageUploadResult4;
                                    if (!this.isCancelled) {
                                    }
                                    int i7 = -1002;
                                    if (imageUploadResult4 != null) {
                                    }
                                    if (imageUploadResult2 != null) {
                                    }
                                    if (imageUploadResult2 == null) {
                                    }
                                    Object[] objArr = new Object[i3];
                                    objArr[c] = "comment";
                                    objArr[1] = sb.toString();
                                    s95.a("img", -1L, -1, "imageUpload", i7, message, objArr);
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("发帖：正在上传图片 上传失败 = ");
                                    sb4.append(i7);
                                    sb4.append(" ");
                                    sb4.append(message);
                                    sb4.append(str2);
                                    netWork2 = r2;
                                    str3 = str;
                                    sb4.append(str3);
                                    vea.a(sb4.toString());
                                    vg.b(randomAccessFile2);
                                    this.mNetwork = netWork2;
                                    imageUploadResult = imageUploadResult2;
                                    vea.a("发帖：上传图片 结束      p = " + str3);
                                    return imageUploadResult;
                                }
                            } else {
                                try {
                                    String str7 = b2 + this.chunkSize;
                                    if (length % this.chunkSize == 0) {
                                        j = length / this.chunkSize;
                                    } else {
                                        j = (length / this.chunkSize) + 1;
                                    }
                                    long j7 = j;
                                    sb3.append("|chunkNo=");
                                    sb3.append(j7);
                                    RandomAccessFile randomAccessFile17 = new RandomAccessFile(str5, "r");
                                    try {
                                        try {
                                            sb3.append("|width=");
                                            sb3.append(this.bigWidth);
                                            sb3.append("|height=");
                                            sb3.append(this.bigHeight);
                                            sb3.append("|smallWidth=");
                                            sb3.append(this.smallWidth);
                                            sb3.append("|smallHeight=");
                                            sb3.append(this.smallHeight);
                                            sb3.append("|groupId=");
                                            sb3.append(this.groupId);
                                            String str8 = str7;
                                            int i8 = 1;
                                            byte[] bArr3 = null;
                                            int i9 = 0;
                                            imageUploadResult = null;
                                            while (true) {
                                                int i10 = (i8 > j7 ? 1 : (i8 == j7 ? 0 : -1));
                                                if (i10 <= 0) {
                                                    try {
                                                        if (this.isCancelled == z3) {
                                                            break;
                                                        }
                                                        if (i10 > 0) {
                                                            sb2 = sb3;
                                                            i4 = 0;
                                                            bArr = null;
                                                        } else {
                                                            if (i10 < 0) {
                                                                try {
                                                                    try {
                                                                        i4 = this.chunkSize;
                                                                        sb2 = sb3;
                                                                    } catch (Throwable th5) {
                                                                        th = th5;
                                                                        randomAccessFile3 = randomAccessFile17;
                                                                        randomAccessFile4 = null;
                                                                        th = th;
                                                                        netWork = randomAccessFile4;
                                                                        closeable = randomAccessFile3;
                                                                        vg.b(closeable);
                                                                        this.mNetwork = netWork;
                                                                        throw th;
                                                                    }
                                                                } catch (Exception e6) {
                                                                    exc = e6;
                                                                    randomAccessFile11 = randomAccessFile17;
                                                                    str2 = str6;
                                                                    sb = sb3;
                                                                    imageUploadResult4 = imageUploadResult;
                                                                    r2 = null;
                                                                    randomAccessFile5 = randomAccessFile11;
                                                                    i3 = 2;
                                                                    c = 0;
                                                                    randomAccessFile2 = randomAccessFile5;
                                                                    if (!this.isCancelled) {
                                                                    }
                                                                    int i72 = -1002;
                                                                    if (imageUploadResult4 != null) {
                                                                    }
                                                                    if (imageUploadResult2 != null) {
                                                                    }
                                                                    if (imageUploadResult2 == null) {
                                                                    }
                                                                    Object[] objArr2 = new Object[i3];
                                                                    objArr2[c] = "comment";
                                                                    objArr2[1] = sb.toString();
                                                                    s95.a("img", -1L, -1, "imageUpload", i72, message, objArr2);
                                                                    StringBuilder sb42 = new StringBuilder();
                                                                    sb42.append("发帖：正在上传图片 上传失败 = ");
                                                                    sb42.append(i72);
                                                                    sb42.append(" ");
                                                                    sb42.append(message);
                                                                    sb42.append(str2);
                                                                    netWork2 = r2;
                                                                    str3 = str;
                                                                    sb42.append(str3);
                                                                    vea.a(sb42.toString());
                                                                    vg.b(randomAccessFile2);
                                                                    this.mNetwork = netWork2;
                                                                    imageUploadResult = imageUploadResult2;
                                                                    vea.a("发帖：上传图片 结束      p = " + str3);
                                                                    return imageUploadResult;
                                                                }
                                                            } else if (i10 == 0) {
                                                                sb2 = sb3;
                                                                i4 = (int) (length - (this.chunkSize * (j7 - 1)));
                                                            } else {
                                                                sb2 = sb3;
                                                                i4 = 0;
                                                            }
                                                            if (bArr3 != null) {
                                                                try {
                                                                } catch (Exception e7) {
                                                                    exc = e7;
                                                                    randomAccessFile12 = randomAccessFile17;
                                                                    str2 = str6;
                                                                    imageUploadResult4 = imageUploadResult;
                                                                    sb = sb2;
                                                                    randomAccessFile11 = randomAccessFile12;
                                                                    r2 = null;
                                                                    randomAccessFile5 = randomAccessFile11;
                                                                    i3 = 2;
                                                                    c = 0;
                                                                    randomAccessFile2 = randomAccessFile5;
                                                                    if (!this.isCancelled) {
                                                                    }
                                                                    int i722 = -1002;
                                                                    if (imageUploadResult4 != null) {
                                                                    }
                                                                    if (imageUploadResult2 != null) {
                                                                    }
                                                                    if (imageUploadResult2 == null) {
                                                                    }
                                                                    Object[] objArr22 = new Object[i3];
                                                                    objArr22[c] = "comment";
                                                                    objArr22[1] = sb.toString();
                                                                    s95.a("img", -1L, -1, "imageUpload", i722, message, objArr22);
                                                                    StringBuilder sb422 = new StringBuilder();
                                                                    sb422.append("发帖：正在上传图片 上传失败 = ");
                                                                    sb422.append(i722);
                                                                    sb422.append(" ");
                                                                    sb422.append(message);
                                                                    sb422.append(str2);
                                                                    netWork2 = r2;
                                                                    str3 = str;
                                                                    sb422.append(str3);
                                                                    vea.a(sb422.toString());
                                                                    vg.b(randomAccessFile2);
                                                                    this.mNetwork = netWork2;
                                                                    imageUploadResult = imageUploadResult2;
                                                                    vea.a("发帖：上传图片 结束      p = " + str3);
                                                                    return imageUploadResult;
                                                                }
                                                            }
                                                            try {
                                                                bArr3 = new byte[i4];
                                                                randomAccessFile17.seek(this.chunkSize * (i8 - 1));
                                                                randomAccessFile17.read(bArr3, 0, i4);
                                                                bArr = bArr3;
                                                            } catch (Exception e8) {
                                                                e = e8;
                                                                randomAccessFile13 = randomAccessFile17;
                                                                str2 = str6;
                                                                sb = sb2;
                                                                randomAccessFile9 = randomAccessFile13;
                                                                i3 = 2;
                                                                c = 0;
                                                                exc = e;
                                                                imageUploadResult4 = imageUploadResult;
                                                                randomAccessFile10 = randomAccessFile9;
                                                                r2 = null;
                                                                randomAccessFile2 = randomAccessFile10;
                                                                if (!this.isCancelled) {
                                                                }
                                                                int i7222 = -1002;
                                                                if (imageUploadResult4 != null) {
                                                                }
                                                                if (imageUploadResult2 != null) {
                                                                }
                                                                if (imageUploadResult2 == null) {
                                                                }
                                                                Object[] objArr222 = new Object[i3];
                                                                objArr222[c] = "comment";
                                                                objArr222[1] = sb.toString();
                                                                s95.a("img", -1L, -1, "imageUpload", i7222, message, objArr222);
                                                                StringBuilder sb4222 = new StringBuilder();
                                                                sb4222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb4222.append(i7222);
                                                                sb4222.append(" ");
                                                                sb4222.append(message);
                                                                sb4222.append(str2);
                                                                netWork2 = r2;
                                                                str3 = str;
                                                                sb4222.append(str3);
                                                                vea.a(sb4222.toString());
                                                                vg.b(randomAccessFile2);
                                                                this.mNetwork = netWork2;
                                                                imageUploadResult = imageUploadResult2;
                                                                vea.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        }
                                                        NetWork netWork3 = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                                        this.mNetwork = netWork3;
                                                        long j8 = j7;
                                                        String str9 = str8;
                                                        netWork3.addPostData("resourceId", str9);
                                                        this.mNetwork.addPostData("chunkNo", String.valueOf(i8));
                                                        if (i10 >= 0) {
                                                            try {
                                                                randomAccessFile14 = randomAccessFile17;
                                                                try {
                                                                    try {
                                                                        this.mNetwork.addPostData("isFinish", String.valueOf(1));
                                                                    } catch (Throwable th6) {
                                                                        th = th6;
                                                                        th = th;
                                                                        randomAccessFile8 = randomAccessFile14;
                                                                        netWork = 0;
                                                                        closeable = randomAccessFile8;
                                                                        vg.b(closeable);
                                                                        this.mNetwork = netWork;
                                                                        throw th;
                                                                    }
                                                                } catch (Exception e9) {
                                                                    e = e9;
                                                                    exc = e;
                                                                    str2 = str6;
                                                                    imageUploadResult4 = imageUploadResult;
                                                                    randomAccessFile12 = randomAccessFile14;
                                                                    sb = sb2;
                                                                    randomAccessFile11 = randomAccessFile12;
                                                                    r2 = null;
                                                                    randomAccessFile5 = randomAccessFile11;
                                                                    i3 = 2;
                                                                    c = 0;
                                                                    randomAccessFile2 = randomAccessFile5;
                                                                    if (!this.isCancelled) {
                                                                    }
                                                                    int i72222 = -1002;
                                                                    if (imageUploadResult4 != null) {
                                                                    }
                                                                    if (imageUploadResult2 != null) {
                                                                    }
                                                                    if (imageUploadResult2 == null) {
                                                                    }
                                                                    Object[] objArr2222 = new Object[i3];
                                                                    objArr2222[c] = "comment";
                                                                    objArr2222[1] = sb.toString();
                                                                    s95.a("img", -1L, -1, "imageUpload", i72222, message, objArr2222);
                                                                    StringBuilder sb42222 = new StringBuilder();
                                                                    sb42222.append("发帖：正在上传图片 上传失败 = ");
                                                                    sb42222.append(i72222);
                                                                    sb42222.append(" ");
                                                                    sb42222.append(message);
                                                                    sb42222.append(str2);
                                                                    netWork2 = r2;
                                                                    str3 = str;
                                                                    sb42222.append(str3);
                                                                    vea.a(sb42222.toString());
                                                                    vg.b(randomAccessFile2);
                                                                    this.mNetwork = netWork2;
                                                                    imageUploadResult = imageUploadResult2;
                                                                    vea.a("发帖：上传图片 结束      p = " + str3);
                                                                    return imageUploadResult;
                                                                }
                                                            } catch (Exception e10) {
                                                                e = e10;
                                                                randomAccessFile14 = randomAccessFile17;
                                                            } catch (Throwable th7) {
                                                                th = th7;
                                                                randomAccessFile14 = randomAccessFile17;
                                                                th = th;
                                                                randomAccessFile8 = randomAccessFile14;
                                                                netWork = 0;
                                                                closeable = randomAccessFile8;
                                                                vg.b(closeable);
                                                                this.mNetwork = netWork;
                                                                throw th;
                                                            }
                                                        } else {
                                                            randomAccessFile14 = randomAccessFile17;
                                                            this.mNetwork.addPostData("isFinish", String.valueOf(0));
                                                        }
                                                        if (this.isFromBJH) {
                                                            this.mNetwork.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                                        } else {
                                                            this.mNetwork.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                                        }
                                                        this.mNetwork.addPostData("size", String.valueOf(length));
                                                        this.mNetwork.addPostData("width", String.valueOf(options2.outWidth));
                                                        this.mNetwork.addPostData("height", String.valueOf(options2.outHeight));
                                                        if (this.smallWidth > 0 && this.smallHeight > 0) {
                                                            this.mNetwork.addPostData("smallWidth", String.valueOf(this.smallWidth));
                                                            this.mNetwork.addPostData("smallHeight", String.valueOf(this.smallHeight));
                                                        }
                                                        try {
                                                            try {
                                                                this.mNetwork.addPostData(TbEnum.SystemMessage.KEY_GROUP_ID, String.valueOf(this.groupId));
                                                                this.mNetwork.addPostData("alt", "json");
                                                                if (bArr != null) {
                                                                    this.mNetwork.addPostData("chunk", bArr);
                                                                }
                                                                if (z) {
                                                                    this.mNetwork.addPostData("saveOrigin", "1");
                                                                } else {
                                                                    this.mNetwork.addPostData("saveOrigin", "0");
                                                                }
                                                                if (this.waterMaskType != 0) {
                                                                    this.mNetwork.addPostData("pic_water_type", String.valueOf(this.waterMaskType));
                                                                }
                                                                if (z2) {
                                                                    int b3 = a15.c().b();
                                                                    if (b3 != 0) {
                                                                        this.mNetwork.addPostData("pic_water_type", String.valueOf(b3));
                                                                    }
                                                                    String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                                    if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                                        this.mNetwork.addPostData("user_name", currentAccountName);
                                                                    }
                                                                    String a3 = a15.c().a();
                                                                    if (this.writeData != null && !TextUtils.isEmpty(this.writeData.getForumName())) {
                                                                        a3 = this.writeData.getForumName();
                                                                    }
                                                                    if (!StringUtils.isNull(a3)) {
                                                                        if (b3 == 2) {
                                                                            this.mNetwork.addPostData("forum_name", a3);
                                                                        }
                                                                        a2 = a15.c().a();
                                                                        if (this.writeData != null && !TextUtils.isEmpty(this.writeData.getForumName())) {
                                                                            a2 = this.writeData.getForumName();
                                                                        }
                                                                        if (!StringUtils.isNull(a2)) {
                                                                            this.mNetwork.addPostData("small_flow_fname", a2);
                                                                        }
                                                                        postMultiNetData = this.mNetwork.postMultiNetData(false);
                                                                        parser = ImageUploadResult.parser(postMultiNetData);
                                                                        if (postMultiNetData != null || parser == null) {
                                                                            break;
                                                                            break;
                                                                        }
                                                                        try {
                                                                            if (parser.error_code != 0) {
                                                                                try {
                                                                                    if (!ImageUploadResult.shouldReply(parser.error_code)) {
                                                                                        break;
                                                                                    }
                                                                                } catch (Exception e11) {
                                                                                    e = e11;
                                                                                    imageUploadResult4 = parser;
                                                                                    str2 = str6;
                                                                                    RandomAccessFile randomAccessFile18 = randomAccessFile14;
                                                                                    sb = sb2;
                                                                                    r2 = null;
                                                                                    i3 = 2;
                                                                                    c = 0;
                                                                                    exc = e;
                                                                                    randomAccessFile2 = randomAccessFile18;
                                                                                    if (!this.isCancelled) {
                                                                                    }
                                                                                    int i722222 = -1002;
                                                                                    if (imageUploadResult4 != null) {
                                                                                    }
                                                                                    if (imageUploadResult2 != null) {
                                                                                    }
                                                                                    if (imageUploadResult2 == null) {
                                                                                    }
                                                                                    Object[] objArr22222 = new Object[i3];
                                                                                    objArr22222[c] = "comment";
                                                                                    objArr22222[1] = sb.toString();
                                                                                    s95.a("img", -1L, -1, "imageUpload", i722222, message, objArr22222);
                                                                                    StringBuilder sb422222 = new StringBuilder();
                                                                                    sb422222.append("发帖：正在上传图片 上传失败 = ");
                                                                                    sb422222.append(i722222);
                                                                                    sb422222.append(" ");
                                                                                    sb422222.append(message);
                                                                                    sb422222.append(str2);
                                                                                    netWork2 = r2;
                                                                                    str3 = str;
                                                                                    sb422222.append(str3);
                                                                                    vea.a(sb422222.toString());
                                                                                    vg.b(randomAccessFile2);
                                                                                    this.mNetwork = netWork2;
                                                                                    imageUploadResult = imageUploadResult2;
                                                                                    vea.a("发帖：上传图片 结束      p = " + str3);
                                                                                    return imageUploadResult;
                                                                                }
                                                                            }
                                                                        } catch (Exception e12) {
                                                                            e = e12;
                                                                            imageUploadResult3 = parser;
                                                                            str2 = str6;
                                                                            randomAccessFile7 = randomAccessFile14;
                                                                            sb = sb2;
                                                                        }
                                                                        try {
                                                                            try {
                                                                                if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                                                    vea.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + str6 + str5);
                                                                                    if (i8 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                                        break;
                                                                                    }
                                                                                    i8 = parser.chunkNo;
                                                                                    imageUploadResult3 = parser;
                                                                                    str4 = str9;
                                                                                    str2 = str6;
                                                                                    i6 = i9 + 1;
                                                                                    randomAccessFile15 = randomAccessFile14;
                                                                                    sb = sb2;
                                                                                    i3 = 2;
                                                                                    c = 0;
                                                                                    options = options2;
                                                                                } else {
                                                                                    StringBuilder sb5 = sb2;
                                                                                    try {
                                                                                        if (ImageUploadResult.shouldReply(parser.error_code)) {
                                                                                            imageUploadResult3 = parser;
                                                                                            str4 = str9;
                                                                                            sb = sb5;
                                                                                            str2 = str6;
                                                                                            options = options2;
                                                                                            i6 = i9 + 1;
                                                                                            randomAccessFile15 = randomAccessFile14;
                                                                                            i3 = 2;
                                                                                            c = 0;
                                                                                        } else {
                                                                                            int i11 = i8 + 1;
                                                                                            j6 += i4;
                                                                                            if (i11 > 1) {
                                                                                                try {
                                                                                                    j2 = j6 + ((i11 - 1) * this.chunkSize);
                                                                                                } catch (Exception e13) {
                                                                                                    exc = e13;
                                                                                                    sb = sb5;
                                                                                                    str2 = str6;
                                                                                                    imageUploadResult4 = parser;
                                                                                                    randomAccessFile11 = randomAccessFile14;
                                                                                                    r2 = null;
                                                                                                    randomAccessFile5 = randomAccessFile11;
                                                                                                    i3 = 2;
                                                                                                    c = 0;
                                                                                                    randomAccessFile2 = randomAccessFile5;
                                                                                                    if (!this.isCancelled) {
                                                                                                    }
                                                                                                    int i7222222 = -1002;
                                                                                                    if (imageUploadResult4 != null) {
                                                                                                    }
                                                                                                    if (imageUploadResult2 != null) {
                                                                                                    }
                                                                                                    if (imageUploadResult2 == null) {
                                                                                                    }
                                                                                                    Object[] objArr222222 = new Object[i3];
                                                                                                    objArr222222[c] = "comment";
                                                                                                    objArr222222[1] = sb.toString();
                                                                                                    s95.a("img", -1L, -1, "imageUpload", i7222222, message, objArr222222);
                                                                                                    StringBuilder sb4222222 = new StringBuilder();
                                                                                                    sb4222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                                    sb4222222.append(i7222222);
                                                                                                    sb4222222.append(" ");
                                                                                                    sb4222222.append(message);
                                                                                                    sb4222222.append(str2);
                                                                                                    netWork2 = r2;
                                                                                                    str3 = str;
                                                                                                    sb4222222.append(str3);
                                                                                                    vea.a(sb4222222.toString());
                                                                                                    vg.b(randomAccessFile2);
                                                                                                    this.mNetwork = netWork2;
                                                                                                    imageUploadResult = imageUploadResult2;
                                                                                                    vea.a("发帖：上传图片 结束      p = " + str3);
                                                                                                    return imageUploadResult;
                                                                                                }
                                                                                            } else {
                                                                                                j2 = j6;
                                                                                            }
                                                                                            try {
                                                                                                if (this.imagesInfo != null) {
                                                                                                    this.imagesInfo.hasUploadFileSize += i4;
                                                                                                }
                                                                                                vea.a("发帖：正在上传图片 已上传 = " + j2 + str6 + str5);
                                                                                                if (this.progressCallback != null) {
                                                                                                    try {
                                                                                                        RandomAccessFile randomAccessFile19 = randomAccessFile14;
                                                                                                        j3 = j2;
                                                                                                        options = options2;
                                                                                                        bArr2 = bArr;
                                                                                                        j4 = j8;
                                                                                                        str4 = str9;
                                                                                                        j5 = length;
                                                                                                        randomAccessFile7 = randomAccessFile19;
                                                                                                        c = 0;
                                                                                                        imageUploadResult3 = parser;
                                                                                                    } catch (Exception e14) {
                                                                                                        e = e14;
                                                                                                        imageUploadResult3 = parser;
                                                                                                        randomAccessFile7 = randomAccessFile14;
                                                                                                        c = 0;
                                                                                                    }
                                                                                                    try {
                                                                                                        this.progressCallback.a(str, this.progressObject, j3, j5);
                                                                                                    } catch (Exception e15) {
                                                                                                        e = e15;
                                                                                                        exc = e;
                                                                                                        sb = sb5;
                                                                                                        str2 = str6;
                                                                                                        imageUploadResult4 = imageUploadResult3;
                                                                                                        r2 = null;
                                                                                                        i3 = 2;
                                                                                                        randomAccessFile2 = randomAccessFile7;
                                                                                                        if (!this.isCancelled) {
                                                                                                        }
                                                                                                        int i72222222 = -1002;
                                                                                                        if (imageUploadResult4 != null) {
                                                                                                        }
                                                                                                        if (imageUploadResult2 != null) {
                                                                                                        }
                                                                                                        if (imageUploadResult2 == null) {
                                                                                                        }
                                                                                                        Object[] objArr2222222 = new Object[i3];
                                                                                                        objArr2222222[c] = "comment";
                                                                                                        objArr2222222[1] = sb.toString();
                                                                                                        s95.a("img", -1L, -1, "imageUpload", i72222222, message, objArr2222222);
                                                                                                        StringBuilder sb42222222 = new StringBuilder();
                                                                                                        sb42222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                                        sb42222222.append(i72222222);
                                                                                                        sb42222222.append(" ");
                                                                                                        sb42222222.append(message);
                                                                                                        sb42222222.append(str2);
                                                                                                        netWork2 = r2;
                                                                                                        str3 = str;
                                                                                                        sb42222222.append(str3);
                                                                                                        vea.a(sb42222222.toString());
                                                                                                        vg.b(randomAccessFile2);
                                                                                                        this.mNetwork = netWork2;
                                                                                                        imageUploadResult = imageUploadResult2;
                                                                                                        vea.a("发帖：上传图片 结束      p = " + str3);
                                                                                                        return imageUploadResult;
                                                                                                    }
                                                                                                } else {
                                                                                                    options = options2;
                                                                                                    imageUploadResult3 = parser;
                                                                                                    randomAccessFile7 = randomAccessFile14;
                                                                                                    c = 0;
                                                                                                    j3 = j2;
                                                                                                    str4 = str9;
                                                                                                    bArr2 = bArr;
                                                                                                    j5 = length;
                                                                                                    j4 = j8;
                                                                                                }
                                                                                                try {
                                                                                                    if (this.multiProgressCallback != null) {
                                                                                                        i5 = i11;
                                                                                                        sb = sb5;
                                                                                                        str2 = str6;
                                                                                                        i3 = 2;
                                                                                                        this.multiProgressCallback.a(str, this.progressObject, j3, j5, i, i2);
                                                                                                    } else {
                                                                                                        i5 = i11;
                                                                                                        sb = sb5;
                                                                                                        str2 = str6;
                                                                                                        i3 = 2;
                                                                                                    }
                                                                                                    i8 = i5;
                                                                                                    i6 = i9;
                                                                                                    randomAccessFile7 = randomAccessFile7;
                                                                                                    if (i6 > this.imageChunkRetry) {
                                                                                                        sb.append("|possbile dead loop found. tryCount=");
                                                                                                        sb.append(i6);
                                                                                                        sb.append(", chunkNo=");
                                                                                                        sb.append(j4);
                                                                                                        break;
                                                                                                    }
                                                                                                    i9 = i6;
                                                                                                    j7 = j4;
                                                                                                    str6 = str2;
                                                                                                    str8 = str4;
                                                                                                    options2 = options;
                                                                                                    bArr3 = bArr2;
                                                                                                    length = j5;
                                                                                                    randomAccessFile17 = randomAccessFile7;
                                                                                                    z3 = true;
                                                                                                    imageUploadResult = imageUploadResult3;
                                                                                                    sb3 = sb;
                                                                                                    str5 = str;
                                                                                                } catch (Exception e16) {
                                                                                                    e = e16;
                                                                                                    sb = sb5;
                                                                                                    str2 = str6;
                                                                                                    i3 = 2;
                                                                                                    exc = e;
                                                                                                    imageUploadResult4 = imageUploadResult3;
                                                                                                    randomAccessFile10 = randomAccessFile7;
                                                                                                    r2 = null;
                                                                                                    randomAccessFile2 = randomAccessFile10;
                                                                                                    if (!this.isCancelled) {
                                                                                                    }
                                                                                                    int i722222222 = -1002;
                                                                                                    if (imageUploadResult4 != null) {
                                                                                                    }
                                                                                                    if (imageUploadResult2 != null) {
                                                                                                    }
                                                                                                    if (imageUploadResult2 == null) {
                                                                                                    }
                                                                                                    Object[] objArr22222222 = new Object[i3];
                                                                                                    objArr22222222[c] = "comment";
                                                                                                    objArr22222222[1] = sb.toString();
                                                                                                    s95.a("img", -1L, -1, "imageUpload", i722222222, message, objArr22222222);
                                                                                                    StringBuilder sb422222222 = new StringBuilder();
                                                                                                    sb422222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                                    sb422222222.append(i722222222);
                                                                                                    sb422222222.append(" ");
                                                                                                    sb422222222.append(message);
                                                                                                    sb422222222.append(str2);
                                                                                                    netWork2 = r2;
                                                                                                    str3 = str;
                                                                                                    sb422222222.append(str3);
                                                                                                    vea.a(sb422222222.toString());
                                                                                                    vg.b(randomAccessFile2);
                                                                                                    this.mNetwork = netWork2;
                                                                                                    imageUploadResult = imageUploadResult2;
                                                                                                    vea.a("发帖：上传图片 结束      p = " + str3);
                                                                                                    return imageUploadResult;
                                                                                                }
                                                                                            } catch (Exception e17) {
                                                                                                e = e17;
                                                                                                sb = sb5;
                                                                                                str2 = str6;
                                                                                                imageUploadResult3 = parser;
                                                                                                randomAccessFile7 = randomAccessFile14;
                                                                                                i3 = 2;
                                                                                                c = 0;
                                                                                                exc = e;
                                                                                                imageUploadResult4 = imageUploadResult3;
                                                                                                randomAccessFile10 = randomAccessFile7;
                                                                                                r2 = null;
                                                                                                randomAccessFile2 = randomAccessFile10;
                                                                                                if (!this.isCancelled) {
                                                                                                }
                                                                                                int i7222222222 = -1002;
                                                                                                if (imageUploadResult4 != null) {
                                                                                                }
                                                                                                if (imageUploadResult2 != null) {
                                                                                                }
                                                                                                if (imageUploadResult2 == null) {
                                                                                                }
                                                                                                Object[] objArr222222222 = new Object[i3];
                                                                                                objArr222222222[c] = "comment";
                                                                                                objArr222222222[1] = sb.toString();
                                                                                                s95.a("img", -1L, -1, "imageUpload", i7222222222, message, objArr222222222);
                                                                                                StringBuilder sb4222222222 = new StringBuilder();
                                                                                                sb4222222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                                sb4222222222.append(i7222222222);
                                                                                                sb4222222222.append(" ");
                                                                                                sb4222222222.append(message);
                                                                                                sb4222222222.append(str2);
                                                                                                netWork2 = r2;
                                                                                                str3 = str;
                                                                                                sb4222222222.append(str3);
                                                                                                vea.a(sb4222222222.toString());
                                                                                                vg.b(randomAccessFile2);
                                                                                                this.mNetwork = netWork2;
                                                                                                imageUploadResult = imageUploadResult2;
                                                                                                vea.a("发帖：上传图片 结束      p = " + str3);
                                                                                                return imageUploadResult;
                                                                                            }
                                                                                        }
                                                                                    } catch (Exception e18) {
                                                                                        e = e18;
                                                                                        imageUploadResult3 = parser;
                                                                                        sb = sb5;
                                                                                        str2 = str6;
                                                                                    }
                                                                                }
                                                                                if (i6 > this.imageChunkRetry) {
                                                                                }
                                                                            } catch (Throwable th8) {
                                                                                th = th8;
                                                                                th = th;
                                                                                randomAccessFile8 = randomAccessFile7;
                                                                                netWork = 0;
                                                                                closeable = randomAccessFile8;
                                                                                vg.b(closeable);
                                                                                this.mNetwork = netWork;
                                                                                throw th;
                                                                            }
                                                                        } catch (Exception e19) {
                                                                            e = e19;
                                                                            exc = e;
                                                                            imageUploadResult4 = imageUploadResult3;
                                                                            randomAccessFile10 = randomAccessFile7;
                                                                            r2 = null;
                                                                            randomAccessFile2 = randomAccessFile10;
                                                                            if (!this.isCancelled) {
                                                                            }
                                                                            int i72222222222 = -1002;
                                                                            if (imageUploadResult4 != null) {
                                                                            }
                                                                            if (imageUploadResult2 != null) {
                                                                            }
                                                                            if (imageUploadResult2 == null) {
                                                                            }
                                                                            Object[] objArr2222222222 = new Object[i3];
                                                                            objArr2222222222[c] = "comment";
                                                                            objArr2222222222[1] = sb.toString();
                                                                            s95.a("img", -1L, -1, "imageUpload", i72222222222, message, objArr2222222222);
                                                                            StringBuilder sb42222222222 = new StringBuilder();
                                                                            sb42222222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb42222222222.append(i72222222222);
                                                                            sb42222222222.append(" ");
                                                                            sb42222222222.append(message);
                                                                            sb42222222222.append(str2);
                                                                            netWork2 = r2;
                                                                            str3 = str;
                                                                            sb42222222222.append(str3);
                                                                            vea.a(sb42222222222.toString());
                                                                            vg.b(randomAccessFile2);
                                                                            this.mNetwork = netWork2;
                                                                            imageUploadResult = imageUploadResult2;
                                                                            vea.a("发帖：上传图片 结束      p = " + str3);
                                                                            return imageUploadResult;
                                                                        }
                                                                        bArr2 = bArr;
                                                                        j5 = length;
                                                                        j4 = j8;
                                                                        randomAccessFile7 = randomAccessFile15;
                                                                    }
                                                                }
                                                                a2 = a15.c().a();
                                                                if (this.writeData != null) {
                                                                    a2 = this.writeData.getForumName();
                                                                }
                                                                if (!StringUtils.isNull(a2)) {
                                                                }
                                                                postMultiNetData = this.mNetwork.postMultiNetData(false);
                                                                parser = ImageUploadResult.parser(postMultiNetData);
                                                                if (postMultiNetData != null) {
                                                                    break;
                                                                }
                                                                if (parser.error_code != 0) {
                                                                }
                                                                if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                                }
                                                                bArr2 = bArr;
                                                                j5 = length;
                                                                j4 = j8;
                                                                randomAccessFile7 = randomAccessFile15;
                                                                if (i6 > this.imageChunkRetry) {
                                                                }
                                                            } catch (Throwable th9) {
                                                                th = th9;
                                                                randomAccessFile7 = randomAccessFile14;
                                                            }
                                                        } catch (Exception e20) {
                                                            e = e20;
                                                            str2 = str6;
                                                            randomAccessFile13 = randomAccessFile14;
                                                            sb = sb2;
                                                            randomAccessFile9 = randomAccessFile13;
                                                            i3 = 2;
                                                            c = 0;
                                                            exc = e;
                                                            imageUploadResult4 = imageUploadResult;
                                                            randomAccessFile10 = randomAccessFile9;
                                                            r2 = null;
                                                            randomAccessFile2 = randomAccessFile10;
                                                            if (!this.isCancelled) {
                                                            }
                                                            int i722222222222 = -1002;
                                                            if (imageUploadResult4 != null) {
                                                            }
                                                            if (imageUploadResult2 != null) {
                                                            }
                                                            if (imageUploadResult2 == null) {
                                                            }
                                                            Object[] objArr22222222222 = new Object[i3];
                                                            objArr22222222222[c] = "comment";
                                                            objArr22222222222[1] = sb.toString();
                                                            s95.a("img", -1L, -1, "imageUpload", i722222222222, message, objArr22222222222);
                                                            StringBuilder sb422222222222 = new StringBuilder();
                                                            sb422222222222.append("发帖：正在上传图片 上传失败 = ");
                                                            sb422222222222.append(i722222222222);
                                                            sb422222222222.append(" ");
                                                            sb422222222222.append(message);
                                                            sb422222222222.append(str2);
                                                            netWork2 = r2;
                                                            str3 = str;
                                                            sb422222222222.append(str3);
                                                            vea.a(sb422222222222.toString());
                                                            vg.b(randomAccessFile2);
                                                            this.mNetwork = netWork2;
                                                            imageUploadResult = imageUploadResult2;
                                                            vea.a("发帖：上传图片 结束      p = " + str3);
                                                            return imageUploadResult;
                                                        }
                                                    } catch (Exception e21) {
                                                        e = e21;
                                                        randomAccessFile9 = randomAccessFile17;
                                                        str2 = str6;
                                                        sb = sb3;
                                                    }
                                                } else {
                                                    randomAccessFile7 = randomAccessFile17;
                                                    break;
                                                }
                                            }
                                            imageUploadResult = imageUploadResult3;
                                            randomAccessFile6 = randomAccessFile7;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            randomAccessFile7 = randomAccessFile17;
                                        }
                                    } catch (Exception e22) {
                                        randomAccessFile2 = randomAccessFile17;
                                        str2 = "    p = ";
                                        sb = sb3;
                                        i3 = 2;
                                        c = 0;
                                        exc = e22;
                                        r2 = null;
                                        imageUploadResult4 = null;
                                    }
                                } catch (Exception e23) {
                                    str2 = "    p = ";
                                    sb = sb3;
                                    i3 = 2;
                                    c = 0;
                                    exc = e23;
                                    r2 = null;
                                    imageUploadResult4 = null;
                                    randomAccessFile2 = null;
                                } catch (Throwable th11) {
                                    th = th11;
                                    netWork = 0;
                                    closeable = null;
                                }
                            }
                            vg.b(randomAccessFile6);
                            this.mNetwork = null;
                            str3 = str;
                            vea.a("发帖：上传图片 结束      p = " + str3);
                            return imageUploadResult;
                        }
                        sb422222222222.append(str3);
                        vea.a(sb422222222222.toString());
                        vg.b(randomAccessFile2);
                        this.mNetwork = netWork2;
                        imageUploadResult = imageUploadResult2;
                        vea.a("发帖：上传图片 结束      p = " + str3);
                        return imageUploadResult;
                    } catch (Throwable th12) {
                        th = th12;
                        th = th;
                        closeable = randomAccessFile2;
                        netWork = netWork2;
                        vg.b(closeable);
                        this.mNetwork = netWork;
                        throw th;
                    }
                    if (!this.isCancelled) {
                        try {
                            sb.append("|request cancelled.");
                        } catch (Throwable th13) {
                            th = th13;
                            randomAccessFile4 = r2;
                            randomAccessFile3 = randomAccessFile2;
                            th = th;
                            netWork = randomAccessFile4;
                            closeable = randomAccessFile3;
                            vg.b(closeable);
                            this.mNetwork = netWork;
                            throw th;
                        }
                    } else {
                        BdLog.e(exc.getMessage());
                    }
                    int i7222222222222 = -1002;
                    if (imageUploadResult4 != null) {
                        imageUploadResult2 = new ImageUploadResult();
                        imageUploadResult2.error_code = -1002;
                        imageUploadResult2.error_msg = exc.getMessage();
                    } else {
                        imageUploadResult2 = imageUploadResult4;
                    }
                    if (imageUploadResult2 != null) {
                        i7222222222222 = imageUploadResult2.error_code;
                    }
                    if (imageUploadResult2 == null) {
                        message = imageUploadResult2.error_msg;
                    } else {
                        message = exc.getMessage();
                    }
                    Object[] objArr222222222222 = new Object[i3];
                    objArr222222222222[c] = "comment";
                    objArr222222222222[1] = sb.toString();
                    s95.a("img", -1L, -1, "imageUpload", i7222222222222, message, objArr222222222222);
                    StringBuilder sb4222222222222 = new StringBuilder();
                    sb4222222222222.append("发帖：正在上传图片 上传失败 = ");
                    sb4222222222222.append(i7222222222222);
                    sb4222222222222.append(" ");
                    sb4222222222222.append(message);
                    sb4222222222222.append(str2);
                    netWork2 = r2;
                    str3 = str;
                } catch (Throwable th14) {
                    th = th14;
                    netWork2 = r2;
                }
            } else {
                vea.a("发帖：正在上传图片 失败 = " + str5);
                ImageUploadResult imageUploadResult6 = new ImageUploadResult();
                imageUploadResult6.error_code = -1007;
                imageUploadResult6.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                return imageUploadResult6;
            }
        } else {
            return (ImageUploadResult) invokeCommon.objValue;
        }
    }

    public void uploadInBackgroundIgnoreAlreadyUploaded(WriteImagesInfo writeImagesInfo, boolean z) {
        boolean z2;
        UploadedImageInfo uploadedPicInfo;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(1048601, this, writeImagesInfo, z) == null) && writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            for (int i = 0; i < chosedFiles.size(); i++) {
                ImageFileInfo imageFileInfo = chosedFiles.get(i);
                if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                    if (!this.isCancelled) {
                        if (!writeImagesInfo.isOriginalImg() && !imageFileInfo.isGif()) {
                            z2 = false;
                        } else {
                            z2 = true;
                        }
                        ImageUploadResult uploadInBackground = uploadInBackground(imageFileInfo, z2, z);
                        if (uploadInBackground != null && (uploadedPicInfo = uploadInBackground.getUploadedPicInfo()) != null) {
                            imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                            imageFileInfo.serverPicInfo = uploadInBackground.picInfo;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public ErrorData uploadMustAllSuccInBackground(WriteImagesInfo writeImagesInfo, boolean z) {
        InterceptResult invokeLZ;
        boolean isOriginalImg;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, writeImagesInfo, z)) == null) {
            ImageUploader imageUploader = this;
            vea.a("发帖： 上传批量图片到server");
            ErrorData errorData = new ErrorData();
            if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
                LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                imageUploader.imagesInfo = writeImagesInfo;
                int i = 0;
                writeImagesInfo.allImageFileSize = 0;
                writeImagesInfo.hasUploadFileSize = 0;
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < chosedFiles.size(); i2++) {
                    ImageFileInfo imageFileInfo = chosedFiles.get(i2);
                    if (!imageFileInfo.isAlreadyUploadedToServer()) {
                        File file = new File(imageFileInfo.getFilePath());
                        if (imageFileInfo.getImageType() == 1) {
                            linkedList.add(imageFileInfo);
                        } else if (file.exists()) {
                            writeImagesInfo.allImageFileSize = (int) (writeImagesInfo.allImageFileSize + file.length());
                            linkedList.add(imageFileInfo);
                        }
                    }
                }
                imageUploader.imageChunkRetry = writeImagesInfo.imageChunkRetry;
                if (imageUploader.writeData.getAsyncPublishStatData() != null && imageUploader.writeData.startPublishTime() > 0 && writeImagesInfo.needImageParallel) {
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(writeImagesInfo.imageUploadConcurrency);
                    mn5 mn5Var = new mn5();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (i < linkedList.size()) {
                        ln5 ln5Var = new ln5(mn5Var, linkedList, writeImagesInfo, z, i);
                        ln5Var.c(imageUploader.writeData);
                        ArrayList arrayList3 = arrayList;
                        ln5Var.b(imageUploader.chunkSize, imageUploader.bigWidth, imageUploader.bigHeight, imageUploader.smallWidth, imageUploader.smallHeight, imageUploader.isCancelled, imageUploader.waterMaskType, imageUploader.groupId, imageUploader.progressCallback, imageUploader.multiProgressCallback, imageUploader.progressObject, imageUploader.isFromBJH, imageUploader.imageChunkRetry);
                        arrayList2.add(ln5Var);
                        arrayList3.add(new FutureTask<>(ln5Var));
                        i++;
                        imageUploader = this;
                        arrayList = arrayList3;
                        linkedList = linkedList;
                        newFixedThreadPool = newFixedThreadPool;
                        mn5Var = mn5Var;
                    }
                    ExecutorService executorService = newFixedThreadPool;
                    mn5 mn5Var2 = mn5Var;
                    ArrayList<FutureTask<Boolean>> arrayList4 = arrayList;
                    mn5Var2.c(arrayList4);
                    mn5Var2.b(arrayList2);
                    for (FutureTask<Boolean> futureTask : arrayList4) {
                        executorService.submit(futureTask);
                    }
                    for (FutureTask<Boolean> futureTask2 : arrayList4) {
                        try {
                            futureTask2.get();
                        } catch (Exception unused) {
                        }
                    }
                    executorService.shutdown();
                    return mn5Var2.c;
                }
                LinkedList linkedList2 = linkedList;
                int i3 = 0;
                while (i3 < linkedList2.size()) {
                    LinkedList linkedList3 = linkedList2;
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList3.get(i3);
                    imageFileInfo2.setTempUploadFileName(null);
                    vea.a("发帖：发送图片 上传图片 = " + i3 + " = " + imageFileInfo2.toJson().toString());
                    if (this.isCancelled) {
                        break;
                    }
                    if (imageFileInfo2.getImageType() == 1) {
                        isOriginalImg = false;
                    } else {
                        isOriginalImg = writeImagesInfo.isOriginalImg();
                    }
                    tea.m(this.writeData, imageFileInfo2);
                    int i4 = i3 + 1;
                    ImageUploadResult uploadInBackground = uploadInBackground(imageFileInfo2, isOriginalImg, z, i4, linkedList3.size());
                    tea.d(this.writeData, imageFileInfo2, uploadInBackground);
                    if (uploadInBackground != null) {
                        UploadedImageInfo uploadedPicInfo = uploadInBackground.getUploadedPicInfo();
                        if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                            uploadedPicInfo.isGif = imageFileInfo2.isGif();
                            uploadedPicInfo.isBJH = this.isFromBJH;
                            imageFileInfo2.setServerImageCode(uploadedPicInfo.toPostString());
                            linkedList2 = linkedList3;
                            i3 = i4;
                        } else {
                            errorData.setError_code(uploadInBackground.error_code);
                            errorData.setError_msg(uploadInBackground.error_msg);
                            vea.a("发帖：发送图片 上传图片 错误 1= " + i3 + " = " + imageFileInfo2.toJson().toString());
                            return errorData;
                        }
                    } else {
                        errorData.setError_code(-52);
                        errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                        vea.a("发帖：发送图片 上传图片 错误 2= " + i3 + " = " + imageFileInfo2.toJson().toString());
                        return errorData;
                    }
                }
                vea.a("发帖：发送图片 上传图片 成功返回");
                return null;
            }
            errorData.setError_code(-1002);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            vea.a("发帖：发送图片 上传图片 错误 无图");
            return errorData;
        }
        return (ErrorData) invokeLZ.objValue;
    }
}
