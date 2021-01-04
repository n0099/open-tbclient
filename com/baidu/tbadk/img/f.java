package com.baidu.tbadk.img;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.s;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.z;
import com.baidu.tieba.R;
import com.kwad.sdk.core.imageloader.utils.IoUtils;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private int bigHeight;
    private int bigWidth;
    private int fID;
    private a fIZ;
    private b fJa;
    private e fJb;
    public boolean fJc;
    private String from;
    private boolean isCancelled;
    private Object progressObject;
    private int smallHeight;
    private int smallWidth;
    private int chunkSize = IoUtils.DEFAULT_IMAGE_TOTAL_SIZE;
    private String groupId = "1";
    private z mNetwork = null;

    /* loaded from: classes.dex */
    public interface a {
        void onImageDataSentInBackground(String str, Object obj, long j, long j2);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(String str, Object obj, long j, long j2, int i, int i2);
    }

    public f(String str) {
        this.from = str;
    }

    public void sL(int i) {
        this.fID = i;
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.fIZ = aVar;
        this.progressObject = obj;
        if (aVar != null) {
            this.chunkSize = 10240;
        }
    }

    public void a(b bVar, Object obj) {
        this.fJa = bVar;
        this.progressObject = obj;
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.cancelNetConnect();
        }
    }

    public ErrorData b(WriteImagesInfo writeImagesInfo, boolean z) {
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖： 上传批量图片到server");
        ErrorData errorData = new ErrorData();
        if (writeImagesInfo == null || writeImagesInfo.size() == 0) {
            errorData.setError_code(-53);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：发送图片 上传图片 错误 无图");
            return errorData;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < chosedFiles.size(); i++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i);
            if (!imageFileInfo.isAlreadyUploadedToServer()) {
                linkedList.add(imageFileInfo);
            }
        }
        for (int i2 = 0; i2 < linkedList.size(); i2++) {
            ImageFileInfo imageFileInfo2 = (ImageFileInfo) linkedList.get(i2);
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：发送图片 上传图片 = " + i2 + " = " + imageFileInfo2.toJson().toString());
            if (this.isCancelled) {
                break;
            }
            ImageUploadResult a2 = a(imageFileInfo2, imageFileInfo2.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg(), z, i2 + 1, linkedList.size());
            if (a2 != null) {
                UploadedImageInfo uploadedPicInfo = a2.getUploadedPicInfo();
                if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                    uploadedPicInfo.isGif = imageFileInfo2.isGif();
                    uploadedPicInfo.isBJH = this.fJc;
                    imageFileInfo2.setServerImageCode(uploadedPicInfo.toPostString());
                } else {
                    errorData.setError_code(-53);
                    errorData.setError_msg(a2.error_msg);
                    com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：发送图片 上传图片 错误 1= " + i2 + " = " + imageFileInfo2.toJson().toString());
                    return errorData;
                }
            } else {
                errorData.setError_code(-53);
                errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：发送图片 上传图片 错误 2= " + i2 + " = " + imageFileInfo2.toJson().toString());
                return errorData;
            }
        }
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：发送图片 上传图片 成功返回");
        return null;
    }

    public void c(WriteImagesInfo writeImagesInfo, boolean z) {
        UploadedImageInfo uploadedPicInfo;
        if (writeImagesInfo != null && writeImagesInfo.size() != 0) {
            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
            for (int i = 0; i < chosedFiles.size(); i++) {
                ImageFileInfo imageFileInfo = chosedFiles.get(i);
                if (imageFileInfo != null && !imageFileInfo.isAlreadyUploadedToServer()) {
                    if (!this.isCancelled) {
                        ImageUploadResult a2 = a(imageFileInfo, writeImagesInfo.isOriginalImg() || imageFileInfo.isGif(), z);
                        if (a2 != null && (uploadedPicInfo = a2.getUploadedPicInfo()) != null) {
                            imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                            imageFileInfo.serverPicInfo = a2.picInfo;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public ImageUploadResult a(ImageFileInfo imageFileInfo, boolean z, boolean z2) {
        return a(imageFileInfo, z, z2, 1, 1);
    }

    private ImageUploadResult a(ImageFileInfo imageFileInfo, boolean z, boolean z2, int i, int i2) {
        if (imageFileInfo == null) {
            return null;
        }
        if (this.fJb == null) {
            this.fJb = new e();
        }
        return a(this.fJb.c(imageFileInfo, z), z, z2, i, i2);
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        return a(imageFileInfo, false, z);
    }

    public ImageUploadResult ay(String str, boolean z) {
        return f(str, false, z);
    }

    public ImageUploadResult f(String str, boolean z, boolean z2) {
        return a(str, z, z2, 1, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [492=6, 493=4] */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x04d9, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0511, code lost:
        r22.append("|startChunk=");
        r22.append(r8);
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：正在上传图片 上传失败 CHUNK_ERROR = pic = null    p = " + r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0537, code lost:
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x060e, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x060f, code lost:
        r7 = r6;
        r15 = r4;
        r13 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x061b, code lost:
        r6 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x021a, code lost:
        r22.append("|startChunk=");
        r22.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0227, code lost:
        r6 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x03c5, code lost:
        r22.append("|startChunk=");
        r22.append(r8);
        r22.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x03da, code lost:
        if (r14 != null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x03dc, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x03dd, code lost:
        r22.append(r5);
        r22.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x03ea, code lost:
        if (r14 == null) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x03ec, code lost:
        r22.append(r14.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x03f3, code lost:
        r6 = r14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult a(String str, boolean z, boolean z2, int i, int i2) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        Exception exc;
        ImageUploadResult imageUploadResult;
        ImageUploadResult imageUploadResult2;
        File file;
        long length;
        long j;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        int i3;
        com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：正在上传图片 = " + str);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth == 0 || options.outHeight == 0) {
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：正在上传图片 失败 = " + str);
            return null;
        }
        ImageUploadResult imageUploadResult3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                file = new File(str);
                length = file.length();
                j = 0;
            } catch (Exception e) {
                exc = e;
                randomAccessFile = null;
                imageUploadResult = null;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
        try {
            if ((z || length <= ImageUploadStrategy.FILE_SIZE_5M) && (!z || length <= 10485760)) {
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：正在上传图片 进行中 限制大小 = " + length + "    p = " + str);
                String md5 = s.toMd5(n.GetStreamFromFile(file));
                sb.append("path=");
                sb.append(str);
                sb.append("|length=");
                sb.append(length);
                sb.append("|md5=");
                sb.append(md5);
                if (length == 0 || md5 == null) {
                    imageUploadResult2 = new ImageUploadResult();
                    try {
                        imageUploadResult2.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult2.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                        TiebaStatic.imgError(-1007, "file error: " + imageUploadResult2.error_msg, sb.toString());
                        randomAccessFile2 = null;
                    } catch (Exception e2) {
                        exc = e2;
                        randomAccessFile = null;
                        imageUploadResult = imageUploadResult2;
                    }
                } else {
                    String str2 = md5 + this.chunkSize;
                    long j2 = length % ((long) this.chunkSize) == 0 ? length / this.chunkSize : (length / this.chunkSize) + 1;
                    sb.append("|chunkNo=");
                    sb.append(j2);
                    randomAccessFile2 = new RandomAccessFile(str, "r");
                    byte[] bArr2 = null;
                    try {
                        try {
                            sb.append("|width=");
                            sb.append(this.bigWidth);
                            sb.append("|height=");
                            sb.append(this.bigHeight);
                            sb.append("|smallWidth=");
                            sb.append(this.smallWidth);
                            sb.append("|smallHeight=");
                            sb.append(this.smallHeight);
                            sb.append("|groupId=");
                            sb.append(this.groupId);
                            int i4 = 1;
                            int i5 = 0;
                            while (true) {
                                ImageUploadResult imageUploadResult4 = imageUploadResult3;
                                if (i4 > j2) {
                                    imageUploadResult2 = imageUploadResult4;
                                    break;
                                }
                                try {
                                    if (!this.isCancelled) {
                                        int i6 = 0;
                                        if (i4 > j2) {
                                            i6 = 0;
                                            bArr = null;
                                        } else {
                                            if (i4 < j2) {
                                                i6 = this.chunkSize;
                                            } else if (i4 == j2) {
                                                i6 = (int) (length - (this.chunkSize * (j2 - 1)));
                                            }
                                            if (bArr2 == null || bArr2.length != i6) {
                                                bArr2 = new byte[i6];
                                            }
                                            randomAccessFile2.seek(this.chunkSize * (i4 - 1));
                                            randomAccessFile2.read(bArr2, 0, i6);
                                            bArr = bArr2;
                                        }
                                        this.mNetwork = new z(TbConfig.UPLOAD_IMG_URL);
                                        this.mNetwork.addPostData("resourceId", str2);
                                        this.mNetwork.addPostData("chunkNo", String.valueOf(i4));
                                        if (i4 >= j2) {
                                            this.mNetwork.addPostData("isFinish", String.valueOf(1));
                                        } else {
                                            this.mNetwork.addPostData("isFinish", String.valueOf(0));
                                        }
                                        if (this.fJc) {
                                            this.mNetwork.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(1));
                                        } else {
                                            this.mNetwork.addPostData(ImageViewerConfig.IS_BJH, String.valueOf(0));
                                        }
                                        if (this.bigWidth > 0 && this.bigHeight > 0) {
                                            this.mNetwork.addPostData("width", String.valueOf(this.bigWidth));
                                            this.mNetwork.addPostData("height", String.valueOf(this.bigHeight));
                                        }
                                        if (this.smallWidth > 0 && this.smallHeight > 0) {
                                            this.mNetwork.addPostData("smallWidth", String.valueOf(this.smallWidth));
                                            this.mNetwork.addPostData("smallHeight", String.valueOf(this.smallHeight));
                                        }
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
                                        if (this.fID != 0) {
                                            this.mNetwork.addPostData("pic_water_type", String.valueOf(this.fID));
                                        }
                                        if (z2) {
                                            int imageWaterType = k.bou().getImageWaterType();
                                            if (imageWaterType != 0) {
                                                this.mNetwork.addPostData("pic_water_type", String.valueOf(imageWaterType));
                                            }
                                            String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                            if (!StringUtils.isNull(currentAccountName) && imageWaterType == 1) {
                                                this.mNetwork.addPostData("user_name", currentAccountName);
                                            }
                                            String forumNameForWaterImage = k.bou().getForumNameForWaterImage();
                                            if (!StringUtils.isNull(forumNameForWaterImage) && imageWaterType == 2) {
                                                this.mNetwork.addPostData("forum_name", forumNameForWaterImage);
                                            }
                                        }
                                        String forumNameForWaterImage2 = k.bou().getForumNameForWaterImage();
                                        if (!StringUtils.isNull(forumNameForWaterImage2)) {
                                            this.mNetwork.addPostData("small_flow_fname", forumNameForWaterImage2);
                                        }
                                        String postMultiNetData = this.mNetwork.postMultiNetData();
                                        imageUploadResult3 = ImageUploadResult.parser(postMultiNetData);
                                        if (postMultiNetData == null || imageUploadResult3 == null) {
                                            break;
                                        }
                                        try {
                                            if (imageUploadResult3.error_code != 0 && imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                break;
                                            }
                                            if (imageUploadResult3.error_code == ImageUploadResult.CHUNK_ERROR) {
                                                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：正在上传图片 上传失败 CHUNK_ERROR = " + imageUploadResult3.error_code + "    p = " + str);
                                                if (i4 == imageUploadResult3.chunkNo || imageUploadResult3.chunkNo <= 0) {
                                                    break;
                                                }
                                                i3 = imageUploadResult3.chunkNo;
                                            } else {
                                                int i7 = i4 + 1;
                                                long j3 = j + i6;
                                                long j4 = i7 > 1 ? j3 + ((i7 - 1) * this.chunkSize) : j3;
                                                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：正在上传图片 已上传 = " + j4 + "    p = " + str);
                                                if (this.fIZ != null) {
                                                    this.fIZ.onImageDataSentInBackground(str, this.progressObject, j4, length);
                                                }
                                                if (this.fJa != null) {
                                                    this.fJa.a(str, this.progressObject, j4, length, i, i2);
                                                }
                                                i3 = i7;
                                                j = j3;
                                            }
                                            int i8 = i5 + 1;
                                            if (i8 > 2 * j2) {
                                                sb.append("|possbile dead loop found. tryCount=").append(i8).append(", chunkNo=").append(j2);
                                                imageUploadResult2 = imageUploadResult3;
                                                break;
                                            }
                                            i4 = i3;
                                            i5 = i8;
                                            bArr2 = bArr;
                                        } catch (Exception e3) {
                                            exc = e3;
                                            randomAccessFile = randomAccessFile2;
                                            imageUploadResult = imageUploadResult3;
                                        }
                                    } else {
                                        break;
                                    }
                                } catch (Exception e4) {
                                    exc = e4;
                                    randomAccessFile = randomAccessFile2;
                                    imageUploadResult = imageUploadResult4;
                                }
                            }
                        } catch (Exception e5) {
                            exc = e5;
                            randomAccessFile = randomAccessFile2;
                            imageUploadResult = null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        randomAccessFile = randomAccessFile2;
                        com.baidu.adp.lib.f.a.close(randomAccessFile);
                        this.mNetwork = null;
                        throw th;
                    }
                }
                com.baidu.adp.lib.f.a.close(randomAccessFile2);
                this.mNetwork = null;
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：上传图片 结束      p = " + str);
                return imageUploadResult2;
            }
            ImageUploadResult imageUploadResult5 = new ImageUploadResult();
            try {
                imageUploadResult5.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                imageUploadResult5.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：正在上传图片 失败 限制大小 = " + length + "    p = " + str);
                com.baidu.adp.lib.f.a.close((Closeable) null);
                this.mNetwork = null;
                return imageUploadResult5;
            } catch (Exception e6) {
                exc = e6;
                randomAccessFile = null;
                imageUploadResult = imageUploadResult5;
            }
            if (this.isCancelled) {
                sb.append("|request cancelled.");
            } else {
                BdLog.e(exc.getMessage());
            }
            int i9 = imageUploadResult != null ? imageUploadResult.error_code : -1002;
            String message = imageUploadResult != null ? imageUploadResult.error_msg : exc.getMessage();
            com.baidu.tbadk.core.d.a.a("img", -1L, -1, "imageUpload", i9, message, "comment", sb.toString());
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：正在上传图片 上传失败 = " + i9 + " " + message + "    p = " + str);
            com.baidu.adp.lib.f.a.close(randomAccessFile);
            this.mNetwork = null;
            imageUploadResult2 = imageUploadResult;
            com.baidu.tieba.tbadkCore.writeModel.b.d("发帖：上传图片 结束      p = " + str);
            return imageUploadResult2;
        } catch (Throwable th4) {
            th = th4;
            com.baidu.adp.lib.f.a.close(randomAccessFile);
            this.mNetwork = null;
            throw th;
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
