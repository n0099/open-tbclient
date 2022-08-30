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
import com.baidu.tieba.c75;
import com.baidu.tieba.cn8;
import com.baidu.tieba.en8;
import com.baidu.tieba.iu4;
import com.baidu.tieba.og;
import com.baidu.tieba.tn4;
import com.baidu.tieba.u55;
import com.baidu.tieba.v55;
import com.baidu.tieba.w55;
import com.baidu.tieba.xi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
/* loaded from: classes3.dex */
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
    public u55 mUploadStrategy;
    public b multiProgressCallback;
    public a progressCallback;
    public Object progressObject;
    public int smallHeight;
    public int smallWidth;
    public int waterMaskType;
    public WriteData writeData;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str, Object obj, long j, long j2);
    }

    /* loaded from: classes3.dex */
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.bigHeight : invokeV.intValue;
    }

    public int getBigWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.bigWidth : invokeV.intValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.from : (String) invokeV.objValue;
    }

    public String getGroupId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.groupId : (String) invokeV.objValue;
    }

    public int getSmallHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.smallHeight : invokeV.intValue;
    }

    public int getSmallWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.smallWidth : invokeV.intValue;
    }

    public boolean isCancelled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.isCancelled : invokeV.booleanValue;
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

    public void setServersideResize(int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048591, this, i, i2, i3, i4) == null) {
            this.bigWidth = i;
            this.bigHeight = i2;
            this.smallWidth = i3;
            this.smallHeight = i4;
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

    public ImageUploadResult uploadInBackground(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048597, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? uploadInBackground(imageFileInfo, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    public void uploadInBackgroundIgnoreAlreadyUploaded(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048601, this, writeImagesInfo, z) == null) || writeImagesInfo == null || writeImagesInfo.size() == 0) {
            return;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i = 0; i < chosedFiles.size(); i++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i);
            if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.isCancelled) {
                    return;
                }
                ImageUploadResult uploadInBackground = uploadInBackground(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                if (uploadInBackground != null && (uploadedPicInfo = uploadInBackground.getUploadedPicInfo()) != null) {
                    imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    imageFileInfo.serverPicInfo = uploadInBackground.picInfo;
                }
            }
        }
    }

    public ErrorData uploadMustAllSuccInBackground(WriteImagesInfo writeImagesInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048602, this, writeImagesInfo, z)) == null) {
            ImageUploader imageUploader = this;
            en8.a("发帖： 上传批量图片到server");
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
                    w55 w55Var = new w55();
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    while (i < linkedList.size()) {
                        v55 v55Var = new v55(w55Var, linkedList, writeImagesInfo, z, i);
                        v55Var.c(imageUploader.writeData);
                        ArrayList arrayList3 = arrayList;
                        v55Var.b(imageUploader.chunkSize, imageUploader.bigWidth, imageUploader.bigHeight, imageUploader.smallWidth, imageUploader.smallHeight, imageUploader.isCancelled, imageUploader.waterMaskType, imageUploader.groupId, imageUploader.progressCallback, imageUploader.multiProgressCallback, imageUploader.progressObject, imageUploader.isFromBJH, imageUploader.imageChunkRetry);
                        arrayList2.add(v55Var);
                        arrayList3.add(new FutureTask<>(v55Var));
                        i++;
                        imageUploader = this;
                        arrayList = arrayList3;
                        linkedList = linkedList;
                        newFixedThreadPool = newFixedThreadPool;
                        w55Var = w55Var;
                    }
                    ExecutorService executorService = newFixedThreadPool;
                    w55 w55Var2 = w55Var;
                    ArrayList<FutureTask<Boolean>> arrayList4 = arrayList;
                    w55Var2.c(arrayList4);
                    w55Var2.b(arrayList2);
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
                    return w55Var2.c;
                }
                LinkedList linkedList2 = linkedList;
                int i3 = 0;
                while (i3 < linkedList2.size()) {
                    LinkedList linkedList3 = linkedList2;
                    ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList3.get(i3);
                    imageFileInfo2.setTempUploadFileName(null);
                    en8.a("发帖：发送图片 上传图片 = " + i3 + " = " + imageFileInfo2.toJson().toString());
                    if (this.isCancelled) {
                        break;
                    }
                    boolean isOriginalImg = imageFileInfo2.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg();
                    cn8.m(this.writeData, imageFileInfo2);
                    int i4 = i3 + 1;
                    ImageUploadResult uploadInBackground = uploadInBackground(imageFileInfo2, isOriginalImg, z, i4, linkedList3.size());
                    cn8.d(this.writeData, imageFileInfo2, uploadInBackground);
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
                            en8.a("发帖：发送图片 上传图片 错误 1= " + i3 + " = " + imageFileInfo2.toJson().toString());
                            return errorData;
                        }
                    } else {
                        errorData.setError_code(-52);
                        errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14d0));
                        en8.a("发帖：发送图片 上传图片 错误 2= " + i3 + " = " + imageFileInfo2.toJson().toString());
                        return errorData;
                    }
                }
                en8.a("发帖：发送图片 上传图片 成功返回");
                return null;
            }
            errorData.setError_code(-1002);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14d0));
            en8.a("发帖：发送图片 上传图片 错误 无图");
            return errorData;
        }
        return (ErrorData) invokeLZ.objValue;
    }

    private ImageUploadResult uploadInBackground(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, this, new Object[]{imageFileInfo, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (imageFileInfo == null) {
                return null;
            }
            if (this.mUploadStrategy == null) {
                this.mUploadStrategy = new u55();
            }
            ImageUploadResult uploadInBackground = uploadInBackground(this.mUploadStrategy.j(this.writeData, imageFileInfo, z), z, z2, i, i2);
            String filePath = imageFileInfo.getFilePath();
            if (c75.b.a(filePath)) {
                uploadInBackground.setSharpText(filePath);
            }
            return uploadInBackground;
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }

    public ImageUploadResult uploadInBackground(ImageFileInfo imageFileInfo, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048596, this, imageFileInfo, z)) == null) ? uploadInBackground(imageFileInfo, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult uploadInBackground(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048598, this, str, z)) == null) ? uploadInBackground(str, false, z) : (ImageUploadResult) invokeLZ.objValue;
    }

    public ImageUploadResult uploadInBackground(String str, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? uploadInBackground(str, z, z2, 1, 1) : (ImageUploadResult) invokeCommon.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v10, resolved type: com.baidu.tbadk.core.util.NetWork */
    /* JADX DEBUG: Multi-variable search result rejected for r12v13, resolved type: com.baidu.tbadk.core.util.NetWork */
    /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX DEBUG: Multi-variable search result rejected for r4v5, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: com.baidu.tbadk.img.ImageUploadResult */
    /* JADX WARN: Can't wrap try/catch for region: R(11:44|(15:48|49|(1:51)(1:311)|52|53|54|55|56|57|(2:58|(4:60|61|62|(1:282)(23:(1:65)(5:(2:275|276)(1:(2:260|261)(1:274))|(3:263|264|265)|272|273|267)|66|67|(5:241|242|243|244|245)(2:69|70)|71|72|(2:74|75)(1:239)|76|(1:80)|81|82|(1:84)|85|(1:87)(1:232)|88|89|(1:91)|(6:93|(1:95)|96|(1:100)|101|(6:103|(1:105)|106|(1:108)|109|(9:112|113|(3:203|204|(1:206))|115|(2:117|(2:121|122)(1:153))(4:154|155|156|(1:158)(13:159|(3:161|162|163)(1:198)|164|(1:166)|167|(5:183|184|185|186|187)(1:169)|170|171|(3:173|174|175)(1:177)|176|124|125|(2:128|129)(1:127)))|123|124|125|(0)(0))(2:230|229)))|231|106|(0)|109|(1:230)(9:112|113|(0)|115|(0)(0)|123|124|125|(0)(0))))(2:295|296))|130|131|132|36|37)|312|313|314|315|316|317|132|36|37) */
    /* JADX WARN: Can't wrap try/catch for region: R(9:(15:48|49|(1:51)(1:311)|52|53|54|55|56|57|(2:58|(4:60|61|62|(1:282)(23:(1:65)(5:(2:275|276)(1:(2:260|261)(1:274))|(3:263|264|265)|272|273|267)|66|67|(5:241|242|243|244|245)(2:69|70)|71|72|(2:74|75)(1:239)|76|(1:80)|81|82|(1:84)|85|(1:87)(1:232)|88|89|(1:91)|(6:93|(1:95)|96|(1:100)|101|(6:103|(1:105)|106|(1:108)|109|(9:112|113|(3:203|204|(1:206))|115|(2:117|(2:121|122)(1:153))(4:154|155|156|(1:158)(13:159|(3:161|162|163)(1:198)|164|(1:166)|167|(5:183|184|185|186|187)(1:169)|170|171|(3:173|174|175)(1:177)|176|124|125|(2:128|129)(1:127)))|123|124|125|(0)(0))(2:230|229)))|231|106|(0)|109|(1:230)(9:112|113|(0)|115|(0)(0)|123|124|125|(0)(0))))(2:295|296))|130|131|132|36|37)|313|314|315|316|317|132|36|37) */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0397, code lost:
        r3 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x0399, code lost:
        r3.append("|startChunk=");
        r3.append(r7);
        com.baidu.tieba.en8.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03b3, code lost:
        r15 = r4;
        r29 = r25;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03ba, code lost:
        r2 = r0;
        r11 = r3;
        r7 = r4;
        r29 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:212:0x04fa, code lost:
        r15 = r4;
        r29 = r25;
        r11 = r27;
        r24 = 0;
        r25 = r12;
        r12 = null;
        r11.append("|startChunk=");
        r11.append(r7);
        r11.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x050f, code lost:
        if (r15 != null) goto L221;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x0511, code lost:
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x0513, code lost:
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0514, code lost:
        r11.append(r9);
        r11.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x051c, code lost:
        if (r15 == null) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x051e, code lost:
        r11.append(r15.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x0523, code lost:
        if (r15 != null) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x0525, code lost:
        r7 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x052b, code lost:
        r7.error_code = -7;
        r7.error_msg = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x052f, code lost:
        r23 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0532, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x05b0, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:256:0x05b1, code lost:
        r2 = r0;
        r29 = null;
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:259:0x05ba, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0171, code lost:
        r15.append("|startChunk=");
        r15.append(r7);
        r3 = new com.baidu.tbadk.img.ImageUploadResult();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x017e, code lost:
        r3.error_code = -54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0180, code lost:
        r7 = r2;
        r23 = r3;
        r12 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0186, code lost:
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0187, code lost:
        r29 = r2;
        r7 = r3;
        r25 = r12;
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01c7, code lost:
        if (r14.length != r9) goto L272;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0331 A[Catch: all -> 0x0210, Exception -> 0x0212, TRY_ENTER, TRY_LEAVE, TryCatch #23 {Exception -> 0x0212, blocks: (B:80:0x0208, B:100:0x0240, B:105:0x027f, B:107:0x0283, B:110:0x02b5, B:113:0x02c0, B:119:0x02d5, B:121:0x02e2, B:123:0x02ec, B:124:0x02f5, B:128:0x0302, B:129:0x0309, B:133:0x031a, B:138:0x0331), top: B:322:0x0208 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0360 A[Catch: all -> 0x0210, Exception -> 0x0355, TRY_ENTER, TryCatch #18 {Exception -> 0x0355, blocks: (B:144:0x034b, B:151:0x0360, B:153:0x0380, B:156:0x0385, B:171:0x03f4, B:176:0x0402), top: B:317:0x034b }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04c6 A[LOOP:0: B:42:0x0166->B:202:0x04c6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05d1 A[Catch: all -> 0x065f, TryCatch #36 {all -> 0x065f, blocks: (B:267:0x05cd, B:269:0x05d1, B:273:0x05e2, B:276:0x05f3, B:278:0x05f7, B:280:0x05fe, B:279:0x05fa, B:270:0x05d7, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:301:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:270:0x05d7 A[Catch: all -> 0x065f, TryCatch #36 {all -> 0x065f, blocks: (B:267:0x05cd, B:269:0x05d1, B:273:0x05e2, B:276:0x05f3, B:278:0x05f7, B:280:0x05fe, B:279:0x05fa, B:270:0x05d7, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:301:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:273:0x05e2 A[Catch: all -> 0x065f, TryCatch #36 {all -> 0x065f, blocks: (B:267:0x05cd, B:269:0x05d1, B:273:0x05e2, B:276:0x05f3, B:278:0x05f7, B:280:0x05fe, B:279:0x05fa, B:270:0x05d7, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:301:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:274:0x05f0  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x05f3 A[Catch: all -> 0x065f, TryCatch #36 {all -> 0x065f, blocks: (B:267:0x05cd, B:269:0x05d1, B:273:0x05e2, B:276:0x05f3, B:278:0x05f7, B:280:0x05fe, B:279:0x05fa, B:270:0x05d7, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:301:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x05f7 A[Catch: all -> 0x065f, TryCatch #36 {all -> 0x065f, blocks: (B:267:0x05cd, B:269:0x05d1, B:273:0x05e2, B:276:0x05f3, B:278:0x05f7, B:280:0x05fe, B:279:0x05fa, B:270:0x05d7, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:301:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x05fa A[Catch: all -> 0x065f, TryCatch #36 {all -> 0x065f, blocks: (B:267:0x05cd, B:269:0x05d1, B:273:0x05e2, B:276:0x05f3, B:278:0x05f7, B:280:0x05fe, B:279:0x05fa, B:270:0x05d7, B:199:0x04b0, B:201:0x04b4, B:196:0x04a1, B:212:0x04fa, B:216:0x0514, B:218:0x051e, B:220:0x0525, B:222:0x052b), top: B:301:0x04b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:317:0x034b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x04b4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult uploadInBackground(String str, boolean z, boolean z2, int i, int i2) {
        InterceptResult invokeCommon;
        NetWork netWork;
        String str2;
        StringBuilder sb;
        char c;
        Exception exc;
        RandomAccessFile randomAccessFile;
        Throwable th;
        ImageUploadResult imageUploadResult;
        String str3;
        ImageUploadResult imageUploadResult2;
        File file;
        long length;
        RandomAccessFile randomAccessFile2;
        ImageUploadResult imageUploadResult3;
        int i3;
        StringBuilder sb2;
        byte[] bArr;
        long j;
        RandomAccessFile randomAccessFile3;
        ImageUploadResult imageUploadResult4;
        RandomAccessFile randomAccessFile4;
        String a2;
        String postMultiNetData;
        ImageUploadResult parser;
        ImageUploadResult imageUploadResult5;
        long j2;
        BitmapFactory.Options options;
        byte[] bArr2;
        long j3;
        long j4;
        String str4;
        NetWork netWork2;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            String str5 = str;
            String str6 = "    p = ";
            en8.a("发帖：正在上传图片 = " + str5);
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            boolean z3 = true;
            options2.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str5, options2);
            if (options2.outWidth != 0 && options2.outHeight != 0) {
                StringBuilder sb3 = new StringBuilder();
                RandomAccessFile randomAccessFile5 = null;
                ImageUploadResult imageUploadResult6 = null;
                RandomAccessFile randomAccessFile6 = null;
                NetWork netWork3 = null;
                try {
                    file = new File(str5);
                    length = file.length();
                    try {
                        try {
                        } catch (Exception e) {
                            exc = e;
                            randomAccessFile = null;
                            str2 = "    p = ";
                            sb = sb3;
                            c = 0;
                            netWork = null;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        netWork = null;
                    }
                } catch (Exception e2) {
                    str2 = "    p = ";
                    sb = sb3;
                    c = 0;
                    netWork = null;
                    exc = e2;
                } catch (Throwable th3) {
                    th = th3;
                    netWork = null;
                }
                if ((!z && length > 5242880) || (z && length > Config.FULL_TRACE_LOG_LIMIT)) {
                    ImageUploadResult imageUploadResult7 = new ImageUploadResult();
                    try {
                        imageUploadResult7.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult7.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0616);
                        en8.a("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str5);
                        og.b(null);
                        this.mNetwork = null;
                        return imageUploadResult7;
                    } catch (Exception e3) {
                        e = e3;
                        randomAccessFile = null;
                        str2 = "    p = ";
                        sb = sb3;
                        c = 0;
                        imageUploadResult3 = imageUploadResult7;
                        netWork = null;
                    }
                } else {
                    en8.a("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str5);
                    String b2 = xi.b(FileHelper.GetStreamFromFile(file));
                    sb3.append("path=");
                    sb3.append(str5);
                    sb3.append("|length=");
                    sb3.append(length);
                    sb3.append("|md5=");
                    sb3.append(b2);
                    long j5 = 0;
                    try {
                        if (length != 0 && b2 != null) {
                            String str7 = b2 + this.chunkSize;
                            long j6 = length % ((long) this.chunkSize) == 0 ? length / this.chunkSize : (length / this.chunkSize) + 1;
                            sb3.append("|chunkNo=");
                            sb3.append(j6);
                            try {
                                RandomAccessFile randomAccessFile7 = new RandomAccessFile(str5, "r");
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
                                        int i6 = 1;
                                        int i7 = 0;
                                        imageUploadResult = null;
                                        byte[] bArr3 = null;
                                        while (true) {
                                            int i8 = (i6 > j6 ? 1 : (i6 == j6 ? 0 : -1));
                                            if (i8 > 0) {
                                                randomAccessFile = randomAccessFile7;
                                                netWork = null;
                                                break;
                                            }
                                            try {
                                                if (this.isCancelled == z3) {
                                                    break;
                                                }
                                                if (i8 > 0) {
                                                    j = j6;
                                                    sb2 = sb3;
                                                    i3 = 0;
                                                    bArr = null;
                                                } else {
                                                    if (i8 < 0) {
                                                        try {
                                                            try {
                                                                i3 = this.chunkSize;
                                                                sb2 = sb3;
                                                            } catch (Exception e4) {
                                                                e = e4;
                                                                randomAccessFile = randomAccessFile7;
                                                                str2 = str6;
                                                                sb = sb3;
                                                                imageUploadResult3 = imageUploadResult;
                                                                netWork = null;
                                                                c = 0;
                                                                exc = e;
                                                                imageUploadResult6 = imageUploadResult3;
                                                                if (!this.isCancelled) {
                                                                }
                                                                if (imageUploadResult6 != null) {
                                                                }
                                                                if (imageUploadResult2 != null) {
                                                                }
                                                                if (imageUploadResult2 == null) {
                                                                }
                                                                Object[] objArr = new Object[2];
                                                                objArr[c] = "comment";
                                                                objArr[1] = sb.toString();
                                                                iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr);
                                                                StringBuilder sb4 = new StringBuilder();
                                                                sb4.append("发帖：正在上传图片 上传失败 = ");
                                                                sb4.append(r3);
                                                                sb4.append(" ");
                                                                sb4.append(r2);
                                                                sb4.append(str2);
                                                                str3 = str;
                                                                sb4.append(str3);
                                                                en8.a(sb4.toString());
                                                                og.b(randomAccessFile);
                                                                this.mNetwork = netWork;
                                                                imageUploadResult = imageUploadResult2;
                                                                en8.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        } catch (Throwable th4) {
                                                            th = th4;
                                                            randomAccessFile5 = randomAccessFile7;
                                                            netWork = null;
                                                            th = th;
                                                            randomAccessFile6 = randomAccessFile5;
                                                            og.b(randomAccessFile6);
                                                            this.mNetwork = netWork;
                                                            throw th;
                                                        }
                                                    } else if (i8 == 0) {
                                                        sb2 = sb3;
                                                        i3 = (int) (length - (this.chunkSize * (j6 - 1)));
                                                    } else {
                                                        sb2 = sb3;
                                                        i3 = 0;
                                                    }
                                                    if (bArr3 != null) {
                                                        bArr = bArr3;
                                                        try {
                                                        } catch (Exception e5) {
                                                            e = e5;
                                                            randomAccessFile = randomAccessFile7;
                                                            str2 = str6;
                                                            imageUploadResult3 = imageUploadResult;
                                                            sb = sb2;
                                                            netWork = null;
                                                            c = 0;
                                                            exc = e;
                                                            imageUploadResult6 = imageUploadResult3;
                                                            if (!this.isCancelled) {
                                                            }
                                                            if (imageUploadResult6 != null) {
                                                            }
                                                            if (imageUploadResult2 != null) {
                                                            }
                                                            if (imageUploadResult2 == null) {
                                                            }
                                                            Object[] objArr2 = new Object[2];
                                                            objArr2[c] = "comment";
                                                            objArr2[1] = sb.toString();
                                                            iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr2);
                                                            StringBuilder sb42 = new StringBuilder();
                                                            sb42.append("发帖：正在上传图片 上传失败 = ");
                                                            sb42.append(r3);
                                                            sb42.append(" ");
                                                            sb42.append(r2);
                                                            sb42.append(str2);
                                                            str3 = str;
                                                            sb42.append(str3);
                                                            en8.a(sb42.toString());
                                                            og.b(randomAccessFile);
                                                            this.mNetwork = netWork;
                                                            imageUploadResult = imageUploadResult2;
                                                            en8.a("发帖：上传图片 结束      p = " + str3);
                                                            return imageUploadResult;
                                                        }
                                                    }
                                                    try {
                                                        bArr = new byte[i3];
                                                        j = j6;
                                                        randomAccessFile7.seek(this.chunkSize * (i6 - 1));
                                                        randomAccessFile7.read(bArr, 0, i3);
                                                    } catch (Exception e6) {
                                                        e = e6;
                                                        randomAccessFile = randomAccessFile7;
                                                        str2 = str6;
                                                        sb = sb2;
                                                        netWork = null;
                                                        c = 0;
                                                        exc = e;
                                                        imageUploadResult6 = imageUploadResult;
                                                        if (!this.isCancelled) {
                                                        }
                                                        if (imageUploadResult6 != null) {
                                                        }
                                                        if (imageUploadResult2 != null) {
                                                        }
                                                        if (imageUploadResult2 == null) {
                                                        }
                                                        Object[] objArr22 = new Object[2];
                                                        objArr22[c] = "comment";
                                                        objArr22[1] = sb.toString();
                                                        iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr22);
                                                        StringBuilder sb422 = new StringBuilder();
                                                        sb422.append("发帖：正在上传图片 上传失败 = ");
                                                        sb422.append(r3);
                                                        sb422.append(" ");
                                                        sb422.append(r2);
                                                        sb422.append(str2);
                                                        str3 = str;
                                                        sb422.append(str3);
                                                        en8.a(sb422.toString());
                                                        og.b(randomAccessFile);
                                                        this.mNetwork = netWork;
                                                        imageUploadResult = imageUploadResult2;
                                                        en8.a("发帖：上传图片 结束      p = " + str3);
                                                        return imageUploadResult;
                                                    }
                                                }
                                                NetWork netWork4 = new NetWork(TbConfig.UPLOAD_IMG_URL);
                                                this.mNetwork = netWork4;
                                                netWork4.addPostData("resourceId", str7);
                                                this.mNetwork.addPostData("chunkNo", String.valueOf(i6));
                                                if (i8 >= 0) {
                                                    try {
                                                        randomAccessFile3 = randomAccessFile7;
                                                        try {
                                                            try {
                                                                this.mNetwork.addPostData("isFinish", String.valueOf(1));
                                                            } catch (Exception e7) {
                                                                e = e7;
                                                                exc = e;
                                                                imageUploadResult4 = imageUploadResult;
                                                                randomAccessFile = randomAccessFile3;
                                                                sb = sb2;
                                                                ImageUploadResult imageUploadResult8 = imageUploadResult4;
                                                                c = 0;
                                                                str2 = str6;
                                                                netWork = null;
                                                                imageUploadResult6 = imageUploadResult8;
                                                                if (!this.isCancelled) {
                                                                }
                                                                if (imageUploadResult6 != null) {
                                                                }
                                                                if (imageUploadResult2 != null) {
                                                                }
                                                                if (imageUploadResult2 == null) {
                                                                }
                                                                Object[] objArr222 = new Object[2];
                                                                objArr222[c] = "comment";
                                                                objArr222[1] = sb.toString();
                                                                iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr222);
                                                                StringBuilder sb4222 = new StringBuilder();
                                                                sb4222.append("发帖：正在上传图片 上传失败 = ");
                                                                sb4222.append(r3);
                                                                sb4222.append(" ");
                                                                sb4222.append(r2);
                                                                sb4222.append(str2);
                                                                str3 = str;
                                                                sb4222.append(str3);
                                                                en8.a(sb4222.toString());
                                                                og.b(randomAccessFile);
                                                                this.mNetwork = netWork;
                                                                imageUploadResult = imageUploadResult2;
                                                                en8.a("发帖：上传图片 结束      p = " + str3);
                                                                return imageUploadResult;
                                                            }
                                                        } catch (Throwable th5) {
                                                            th = th5;
                                                            th = th;
                                                            randomAccessFile4 = randomAccessFile3;
                                                            netWork = null;
                                                            randomAccessFile6 = randomAccessFile4;
                                                            og.b(randomAccessFile6);
                                                            this.mNetwork = netWork;
                                                            throw th;
                                                        }
                                                    } catch (Exception e8) {
                                                        e = e8;
                                                        randomAccessFile3 = randomAccessFile7;
                                                    } catch (Throwable th6) {
                                                        th = th6;
                                                        randomAccessFile3 = randomAccessFile7;
                                                        th = th;
                                                        randomAccessFile4 = randomAccessFile3;
                                                        netWork = null;
                                                        randomAccessFile6 = randomAccessFile4;
                                                        og.b(randomAccessFile6);
                                                        this.mNetwork = netWork;
                                                        throw th;
                                                    }
                                                } else {
                                                    randomAccessFile3 = randomAccessFile7;
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
                                                            int b3 = tn4.c().b();
                                                            if (b3 != 0) {
                                                                this.mNetwork.addPostData("pic_water_type", String.valueOf(b3));
                                                            }
                                                            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                            if (!StringUtils.isNull(currentAccountName) && b3 == 1) {
                                                                this.mNetwork.addPostData("user_name", currentAccountName);
                                                            }
                                                            String a3 = tn4.c().a();
                                                            if (!StringUtils.isNull(a3)) {
                                                                if (b3 == 2) {
                                                                    this.mNetwork.addPostData("forum_name", a3);
                                                                }
                                                                a2 = tn4.c().a();
                                                                if (!StringUtils.isNull(a2)) {
                                                                    this.mNetwork.addPostData("small_flow_fname", a2);
                                                                }
                                                                postMultiNetData = this.mNetwork.postMultiNetData(true);
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
                                                                        } catch (Exception e9) {
                                                                            exc = e9;
                                                                            imageUploadResult4 = parser;
                                                                            randomAccessFile = randomAccessFile3;
                                                                            sb = sb2;
                                                                            ImageUploadResult imageUploadResult82 = imageUploadResult4;
                                                                            c = 0;
                                                                            str2 = str6;
                                                                            netWork = null;
                                                                            imageUploadResult6 = imageUploadResult82;
                                                                            if (!this.isCancelled) {
                                                                            }
                                                                            if (imageUploadResult6 != null) {
                                                                            }
                                                                            if (imageUploadResult2 != null) {
                                                                            }
                                                                            if (imageUploadResult2 == null) {
                                                                            }
                                                                            Object[] objArr2222 = new Object[2];
                                                                            objArr2222[c] = "comment";
                                                                            objArr2222[1] = sb.toString();
                                                                            iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr2222);
                                                                            StringBuilder sb42222 = new StringBuilder();
                                                                            sb42222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb42222.append(r3);
                                                                            sb42222.append(" ");
                                                                            sb42222.append(r2);
                                                                            sb42222.append(str2);
                                                                            str3 = str;
                                                                            sb42222.append(str3);
                                                                            en8.a(sb42222.toString());
                                                                            og.b(randomAccessFile);
                                                                            this.mNetwork = netWork;
                                                                            imageUploadResult = imageUploadResult2;
                                                                            en8.a("发帖：上传图片 结束      p = " + str3);
                                                                            return imageUploadResult;
                                                                        }
                                                                    }
                                                                    try {
                                                                        try {
                                                                            if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                                                en8.a("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + parser.error_code + str6 + str5);
                                                                                if (i6 == parser.chunkNo || parser.chunkNo <= 0) {
                                                                                    break;
                                                                                }
                                                                                i6 = parser.chunkNo;
                                                                                imageUploadResult5 = parser;
                                                                                j4 = length;
                                                                                str4 = str7;
                                                                                i5 = i7 + 1;
                                                                                sb = sb2;
                                                                                c = 0;
                                                                                options = options2;
                                                                            } else {
                                                                                StringBuilder sb5 = sb2;
                                                                                try {
                                                                                    if (ImageUploadResult.shouldReply(parser.error_code)) {
                                                                                        sb = sb5;
                                                                                        imageUploadResult5 = parser;
                                                                                        j4 = length;
                                                                                        str4 = str7;
                                                                                        options = options2;
                                                                                        i5 = i7 + 1;
                                                                                        c = 0;
                                                                                    } else {
                                                                                        int i9 = i6 + 1;
                                                                                        j5 += i3;
                                                                                        long j7 = i9 > 1 ? j5 + ((i9 - 1) * this.chunkSize) : j5;
                                                                                        if (this.imagesInfo != null) {
                                                                                            this.imagesInfo.hasUploadFileSize += i3;
                                                                                        }
                                                                                        en8.a("发帖：正在上传图片 已上传 = " + j7 + str6 + str5);
                                                                                        if (this.progressCallback != null) {
                                                                                            try {
                                                                                                RandomAccessFile randomAccessFile8 = randomAccessFile3;
                                                                                                j2 = j7;
                                                                                                options = options2;
                                                                                                long j8 = j;
                                                                                                bArr2 = bArr;
                                                                                                j3 = j8;
                                                                                                randomAccessFile = randomAccessFile8;
                                                                                                imageUploadResult5 = parser;
                                                                                                j4 = length;
                                                                                                sb = sb5;
                                                                                                str4 = str7;
                                                                                                netWork2 = null;
                                                                                            } catch (Exception e10) {
                                                                                                randomAccessFile = randomAccessFile3;
                                                                                                sb = sb5;
                                                                                                exc = e10;
                                                                                                str2 = str6;
                                                                                                imageUploadResult6 = parser;
                                                                                                netWork = null;
                                                                                                c = 0;
                                                                                            } catch (Throwable th7) {
                                                                                                th = th7;
                                                                                                randomAccessFile4 = randomAccessFile3;
                                                                                                netWork = null;
                                                                                                randomAccessFile6 = randomAccessFile4;
                                                                                                og.b(randomAccessFile6);
                                                                                                this.mNetwork = netWork;
                                                                                                throw th;
                                                                                            }
                                                                                            try {
                                                                                                this.progressCallback.a(str, this.progressObject, j2, j4);
                                                                                            } catch (Exception e11) {
                                                                                                exc = e11;
                                                                                                str2 = str6;
                                                                                                imageUploadResult6 = imageUploadResult5;
                                                                                                c = 0;
                                                                                                netWork = null;
                                                                                            } catch (Throwable th8) {
                                                                                                th = th8;
                                                                                                netWork = null;
                                                                                                randomAccessFile6 = randomAccessFile;
                                                                                                og.b(randomAccessFile6);
                                                                                                this.mNetwork = netWork;
                                                                                                throw th;
                                                                                            }
                                                                                        } else {
                                                                                            imageUploadResult5 = parser;
                                                                                            j4 = length;
                                                                                            str4 = str7;
                                                                                            sb = sb5;
                                                                                            netWork2 = null;
                                                                                            options = options2;
                                                                                            long j9 = j;
                                                                                            bArr2 = bArr;
                                                                                            randomAccessFile = randomAccessFile3;
                                                                                            j3 = j9;
                                                                                            j2 = j7;
                                                                                        }
                                                                                        try {
                                                                                            if (this.multiProgressCallback != null) {
                                                                                                long j10 = j2;
                                                                                                str2 = str6;
                                                                                                c = 0;
                                                                                                netWork = netWork2;
                                                                                                i4 = i9;
                                                                                                this.multiProgressCallback.a(str, this.progressObject, j10, j4, i, i2);
                                                                                            } else {
                                                                                                i4 = i9;
                                                                                                str2 = str6;
                                                                                                c = 0;
                                                                                                netWork = netWork2;
                                                                                            }
                                                                                            i6 = i4;
                                                                                            i5 = i7;
                                                                                            if (i5 > this.imageChunkRetry) {
                                                                                                sb.append("|possbile dead loop found. tryCount=");
                                                                                                sb.append(i5);
                                                                                                sb.append(", chunkNo=");
                                                                                                sb.append(j3);
                                                                                                break;
                                                                                            }
                                                                                            i7 = i5;
                                                                                            j6 = j3;
                                                                                            imageUploadResult = imageUploadResult5;
                                                                                            str7 = str4;
                                                                                            str6 = str2;
                                                                                            options2 = options;
                                                                                            bArr3 = bArr2;
                                                                                            randomAccessFile7 = randomAccessFile;
                                                                                            length = j4;
                                                                                            z3 = true;
                                                                                            sb3 = sb;
                                                                                            str5 = str;
                                                                                        } catch (Exception e12) {
                                                                                            e = e12;
                                                                                            str2 = str6;
                                                                                            c = 0;
                                                                                            netWork = netWork2;
                                                                                            exc = e;
                                                                                            imageUploadResult6 = imageUploadResult5;
                                                                                            if (!this.isCancelled) {
                                                                                            }
                                                                                            if (imageUploadResult6 != null) {
                                                                                            }
                                                                                            if (imageUploadResult2 != null) {
                                                                                            }
                                                                                            if (imageUploadResult2 == null) {
                                                                                            }
                                                                                            Object[] objArr22222 = new Object[2];
                                                                                            objArr22222[c] = "comment";
                                                                                            objArr22222[1] = sb.toString();
                                                                                            iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr22222);
                                                                                            StringBuilder sb422222 = new StringBuilder();
                                                                                            sb422222.append("发帖：正在上传图片 上传失败 = ");
                                                                                            sb422222.append(r3);
                                                                                            sb422222.append(" ");
                                                                                            sb422222.append(r2);
                                                                                            sb422222.append(str2);
                                                                                            str3 = str;
                                                                                            sb422222.append(str3);
                                                                                            en8.a(sb422222.toString());
                                                                                            og.b(randomAccessFile);
                                                                                            this.mNetwork = netWork;
                                                                                            imageUploadResult = imageUploadResult2;
                                                                                            en8.a("发帖：上传图片 结束      p = " + str3);
                                                                                            return imageUploadResult;
                                                                                        } catch (Throwable th9) {
                                                                                            th = th9;
                                                                                            netWork = netWork2;
                                                                                            th = th;
                                                                                            randomAccessFile6 = randomAccessFile;
                                                                                            og.b(randomAccessFile6);
                                                                                            this.mNetwork = netWork;
                                                                                            throw th;
                                                                                        }
                                                                                    }
                                                                                } catch (Exception e13) {
                                                                                    e = e13;
                                                                                    sb = sb5;
                                                                                    imageUploadResult5 = parser;
                                                                                    randomAccessFile = randomAccessFile3;
                                                                                    c = 0;
                                                                                    str2 = str6;
                                                                                    netWork = null;
                                                                                    exc = e;
                                                                                    imageUploadResult6 = imageUploadResult5;
                                                                                    if (!this.isCancelled) {
                                                                                    }
                                                                                    if (imageUploadResult6 != null) {
                                                                                    }
                                                                                    if (imageUploadResult2 != null) {
                                                                                    }
                                                                                    if (imageUploadResult2 == null) {
                                                                                    }
                                                                                    Object[] objArr222222 = new Object[2];
                                                                                    objArr222222[c] = "comment";
                                                                                    objArr222222[1] = sb.toString();
                                                                                    iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr222222);
                                                                                    StringBuilder sb4222222 = new StringBuilder();
                                                                                    sb4222222.append("发帖：正在上传图片 上传失败 = ");
                                                                                    sb4222222.append(r3);
                                                                                    sb4222222.append(" ");
                                                                                    sb4222222.append(r2);
                                                                                    sb4222222.append(str2);
                                                                                    str3 = str;
                                                                                    sb4222222.append(str3);
                                                                                    en8.a(sb4222222.toString());
                                                                                    og.b(randomAccessFile);
                                                                                    this.mNetwork = netWork;
                                                                                    imageUploadResult = imageUploadResult2;
                                                                                    en8.a("发帖：上传图片 结束      p = " + str3);
                                                                                    return imageUploadResult;
                                                                                }
                                                                            }
                                                                            if (i5 > this.imageChunkRetry) {
                                                                            }
                                                                        } catch (Exception e14) {
                                                                            e = e14;
                                                                            exc = e;
                                                                            imageUploadResult6 = imageUploadResult5;
                                                                            if (!this.isCancelled) {
                                                                            }
                                                                            if (imageUploadResult6 != null) {
                                                                            }
                                                                            if (imageUploadResult2 != null) {
                                                                            }
                                                                            if (imageUploadResult2 == null) {
                                                                            }
                                                                            Object[] objArr2222222 = new Object[2];
                                                                            objArr2222222[c] = "comment";
                                                                            objArr2222222[1] = sb.toString();
                                                                            iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr2222222);
                                                                            StringBuilder sb42222222 = new StringBuilder();
                                                                            sb42222222.append("发帖：正在上传图片 上传失败 = ");
                                                                            sb42222222.append(r3);
                                                                            sb42222222.append(" ");
                                                                            sb42222222.append(r2);
                                                                            sb42222222.append(str2);
                                                                            str3 = str;
                                                                            sb42222222.append(str3);
                                                                            en8.a(sb42222222.toString());
                                                                            og.b(randomAccessFile);
                                                                            this.mNetwork = netWork;
                                                                            imageUploadResult = imageUploadResult2;
                                                                            en8.a("发帖：上传图片 结束      p = " + str3);
                                                                            return imageUploadResult;
                                                                        }
                                                                    } catch (Throwable th10) {
                                                                        th = th10;
                                                                        th = th;
                                                                        randomAccessFile6 = randomAccessFile;
                                                                        og.b(randomAccessFile6);
                                                                        this.mNetwork = netWork;
                                                                        throw th;
                                                                    }
                                                                    RandomAccessFile randomAccessFile9 = randomAccessFile3;
                                                                    str2 = str6;
                                                                    netWork = null;
                                                                    long j11 = j;
                                                                    bArr2 = bArr;
                                                                    randomAccessFile = randomAccessFile9;
                                                                    j3 = j11;
                                                                } catch (Exception e15) {
                                                                    e = e15;
                                                                    imageUploadResult5 = parser;
                                                                    randomAccessFile = randomAccessFile3;
                                                                    sb = sb2;
                                                                }
                                                            }
                                                        }
                                                        a2 = tn4.c().a();
                                                        if (!StringUtils.isNull(a2)) {
                                                        }
                                                        postMultiNetData = this.mNetwork.postMultiNetData(true);
                                                        parser = ImageUploadResult.parser(postMultiNetData);
                                                        if (postMultiNetData != null) {
                                                            break;
                                                        }
                                                        if (parser.error_code != 0) {
                                                        }
                                                        if (parser.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                        }
                                                        RandomAccessFile randomAccessFile92 = randomAccessFile3;
                                                        str2 = str6;
                                                        netWork = null;
                                                        long j112 = j;
                                                        bArr2 = bArr;
                                                        randomAccessFile = randomAccessFile92;
                                                        j3 = j112;
                                                        if (i5 > this.imageChunkRetry) {
                                                        }
                                                    } catch (Throwable th11) {
                                                        th = th11;
                                                        randomAccessFile = randomAccessFile3;
                                                        netWork = null;
                                                        th = th;
                                                        randomAccessFile6 = randomAccessFile;
                                                        og.b(randomAccessFile6);
                                                        this.mNetwork = netWork;
                                                        throw th;
                                                    }
                                                } catch (Exception e16) {
                                                    e = e16;
                                                    randomAccessFile = randomAccessFile3;
                                                    sb = sb2;
                                                    c = 0;
                                                    str2 = str6;
                                                    netWork = null;
                                                    exc = e;
                                                    imageUploadResult6 = imageUploadResult;
                                                    if (!this.isCancelled) {
                                                    }
                                                    if (imageUploadResult6 != null) {
                                                    }
                                                    if (imageUploadResult2 != null) {
                                                    }
                                                    if (imageUploadResult2 == null) {
                                                    }
                                                    Object[] objArr22222222 = new Object[2];
                                                    objArr22222222[c] = "comment";
                                                    objArr22222222[1] = sb.toString();
                                                    iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr22222222);
                                                    StringBuilder sb422222222 = new StringBuilder();
                                                    sb422222222.append("发帖：正在上传图片 上传失败 = ");
                                                    sb422222222.append(r3);
                                                    sb422222222.append(" ");
                                                    sb422222222.append(r2);
                                                    sb422222222.append(str2);
                                                    str3 = str;
                                                    sb422222222.append(str3);
                                                    en8.a(sb422222222.toString());
                                                    og.b(randomAccessFile);
                                                    this.mNetwork = netWork;
                                                    imageUploadResult = imageUploadResult2;
                                                    en8.a("发帖：上传图片 结束      p = " + str3);
                                                    return imageUploadResult;
                                                }
                                            } catch (Exception e17) {
                                                e = e17;
                                                randomAccessFile = randomAccessFile7;
                                                str2 = str6;
                                                sb = sb3;
                                            }
                                        }
                                        imageUploadResult = imageUploadResult5;
                                        randomAccessFile2 = randomAccessFile;
                                        og.b(randomAccessFile2);
                                        this.mNetwork = netWork;
                                        str3 = str;
                                    } catch (Exception e18) {
                                        randomAccessFile = randomAccessFile7;
                                        str2 = "    p = ";
                                        sb = sb3;
                                        netWork = null;
                                        c = 0;
                                        exc = e18;
                                        imageUploadResult6 = null;
                                    }
                                } catch (Throwable th12) {
                                    th = th12;
                                    randomAccessFile = randomAccessFile7;
                                }
                            } catch (Exception e19) {
                                e = e19;
                                str2 = "    p = ";
                                sb = sb3;
                                netWork = null;
                                c = 0;
                                exc = e;
                                netWork3 = netWork;
                                randomAccessFile = netWork3;
                                imageUploadResult6 = netWork3;
                                if (!this.isCancelled) {
                                }
                                if (imageUploadResult6 != null) {
                                }
                                if (imageUploadResult2 != null) {
                                }
                                if (imageUploadResult2 == null) {
                                }
                                Object[] objArr222222222 = new Object[2];
                                objArr222222222[c] = "comment";
                                objArr222222222[1] = sb.toString();
                                iu4.a("img", -1L, -1, "imageUpload", r3, r2, objArr222222222);
                                StringBuilder sb4222222222 = new StringBuilder();
                                sb4222222222.append("发帖：正在上传图片 上传失败 = ");
                                sb4222222222.append(r3);
                                sb4222222222.append(" ");
                                sb4222222222.append(r2);
                                sb4222222222.append(str2);
                                str3 = str;
                                sb4222222222.append(str3);
                                en8.a(sb4222222222.toString());
                                og.b(randomAccessFile);
                                this.mNetwork = netWork;
                                imageUploadResult = imageUploadResult2;
                                en8.a("发帖：上传图片 结束      p = " + str3);
                                return imageUploadResult;
                            } catch (Throwable th13) {
                                th = th13;
                                netWork = null;
                                th = th;
                                randomAccessFile6 = netWork;
                                og.b(randomAccessFile6);
                                this.mNetwork = netWork;
                                throw th;
                            }
                            en8.a("发帖：上传图片 结束      p = " + str3);
                            return imageUploadResult;
                        }
                        ImageUploadResult imageUploadResult9 = new ImageUploadResult();
                        imageUploadResult9.error_code = -1007;
                        imageUploadResult9.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0614);
                        imageUploadResult = imageUploadResult9;
                        randomAccessFile2 = null;
                        og.b(randomAccessFile2);
                        this.mNetwork = netWork;
                        str3 = str;
                        en8.a("发帖：上传图片 结束      p = " + str3);
                        return imageUploadResult;
                    } catch (Throwable th14) {
                        th = th14;
                        th = th;
                        randomAccessFile6 = netWork;
                        og.b(randomAccessFile6);
                        this.mNetwork = netWork;
                        throw th;
                    }
                    str2 = "    p = ";
                    sb = sb3;
                    c = 0;
                    netWork = null;
                }
                exc = e;
                imageUploadResult6 = imageUploadResult3;
                if (!this.isCancelled) {
                    sb.append("|request cancelled.");
                } else {
                    BdLog.e(exc.getMessage());
                }
                if (imageUploadResult6 != null) {
                    imageUploadResult2 = new ImageUploadResult();
                    imageUploadResult2.error_code = -1002;
                    imageUploadResult2.error_msg = exc.getMessage();
                } else {
                    imageUploadResult2 = imageUploadResult6;
                }
                int i10 = imageUploadResult2 != null ? imageUploadResult2.error_code : -1002;
                String message = imageUploadResult2 == null ? imageUploadResult2.error_msg : exc.getMessage();
                Object[] objArr2222222222 = new Object[2];
                objArr2222222222[c] = "comment";
                objArr2222222222[1] = sb.toString();
                iu4.a("img", -1L, -1, "imageUpload", i10, message, objArr2222222222);
                StringBuilder sb42222222222 = new StringBuilder();
                sb42222222222.append("发帖：正在上传图片 上传失败 = ");
                sb42222222222.append(i10);
                sb42222222222.append(" ");
                sb42222222222.append(message);
                sb42222222222.append(str2);
                str3 = str;
                sb42222222222.append(str3);
                en8.a(sb42222222222.toString());
                og.b(randomAccessFile);
                this.mNetwork = netWork;
                imageUploadResult = imageUploadResult2;
                en8.a("发帖：上传图片 结束      p = " + str3);
                return imageUploadResult;
            }
            en8.a("发帖：正在上传图片 失败 = " + str5);
            ImageUploadResult imageUploadResult10 = new ImageUploadResult();
            imageUploadResult10.error_code = -1007;
            imageUploadResult10.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0616);
            return imageUploadResult10;
        }
        return (ImageUploadResult) invokeCommon.objValue;
    }
}
