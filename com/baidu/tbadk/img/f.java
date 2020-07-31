package com.baidu.tbadk.img;

import android.graphics.BitmapFactory;
import android.text.TextUtils;
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
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private int bigHeight;
    private int bigWidth;
    private a eEC;
    private e eED;
    public boolean eEE;
    private int eEg;
    private String from;
    private boolean isCancelled;
    private Object progressObject;
    private int smallHeight;
    private int smallWidth;
    private int chunkSize = 512000;
    private String groupId = "1";
    private z mNetwork = null;

    /* loaded from: classes.dex */
    public interface a {
        void onImageDataSentInBackground(String str, Object obj, long j, long j2);
    }

    public f(String str) {
        this.from = str;
    }

    public void of(int i) {
        this.eEg = i;
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.eEC = aVar;
        this.progressObject = obj;
        if (aVar != null) {
            this.chunkSize = 10240;
        }
    }

    public void cancel() {
        this.isCancelled = true;
        if (this.mNetwork != null) {
            this.mNetwork.cancelNetConnect();
        }
    }

    public ErrorData b(WriteImagesInfo writeImagesInfo, boolean z) {
        ErrorData errorData = new ErrorData();
        if (writeImagesInfo == null || writeImagesInfo.size() == 0) {
            errorData.setError_code(-53);
            errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
            return errorData;
        }
        LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
        for (int i = 0; i < chosedFiles.size(); i++) {
            ImageFileInfo imageFileInfo = chosedFiles.get(i);
            if (!imageFileInfo.isAlreadyUploadedToServer()) {
                if (this.isCancelled) {
                    break;
                }
                ImageUploadResult a2 = a(imageFileInfo, imageFileInfo.getImageType() == 1 ? false : writeImagesInfo.isOriginalImg(), z);
                if (a2 != null) {
                    UploadedImageInfo uploadedPicInfo = a2.getUploadedPicInfo();
                    if (uploadedPicInfo != null && !TextUtils.isEmpty(uploadedPicInfo.toPostString())) {
                        uploadedPicInfo.isGif = imageFileInfo.isGif();
                        uploadedPicInfo.isBJH = this.eEE;
                        imageFileInfo.setServerImageCode(uploadedPicInfo.toPostString());
                    } else {
                        errorData.setError_code(-53);
                        errorData.setError_msg(a2.error_msg);
                        return errorData;
                    }
                } else {
                    errorData.setError_code(-53);
                    errorData.setError_msg(TbadkCoreApplication.getInst().getString(R.string.upload_error));
                    return errorData;
                }
            }
        }
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
        if (imageFileInfo == null) {
            return null;
        }
        if (this.eED == null) {
            this.eED = new e();
        }
        return f(this.eED.c(imageFileInfo, z), z, z2);
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        return a(imageFileInfo, false, z);
    }

    public ImageUploadResult an(String str, boolean z) {
        return f(str, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [454=6, 455=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: java.io.File */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x0380, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0381, code lost:
        r20.append(r5);
        r20.append("|picErrNo=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x038e, code lost:
        if (r12 == null) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0390, code lost:
        r20.append(r12.error_code);
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0397, code lost:
        r5 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0410, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x0421, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0422, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x0431, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0432, code lost:
        r13 = r4;
        r4 = null;
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0493, code lost:
        com.baidu.adp.lib.util.BdLog.e(r5.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x049c, code lost:
        r4 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x049d, code lost:
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x04a0, code lost:
        r10 = -1002;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x04a4, code lost:
        r11 = r5.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x04c5, code lost:
        r5 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:?, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0182, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0199, code lost:
        if (r25.isCancelled != false) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x019b, code lost:
        r20.append("|request cancelled.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01a3, code lost:
        if (r4 != null) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x01a5, code lost:
        r10 = r4.error_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01a7, code lost:
        if (r4 != null) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01a9, code lost:
        r11 = r4.error_msg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01ab, code lost:
        com.baidu.tbadk.core.d.a.a("img", -1, -1, "imageUpload", r10, r11, "comment", r20.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01c7, code lost:
        com.baidu.adp.lib.f.a.close(r13);
        r25.mNetwork = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0369, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
        r20.append("|picNull=");
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x037e, code lost:
        if (r12 != null) goto L94;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ImageUploadResult f(String str, boolean z, boolean z2) {
        RandomAccessFile randomAccessFile;
        Exception e;
        ImageUploadResult imageUploadResult;
        ImageUploadResult imageUploadResult2;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        if (options.outWidth == 0 || options.outHeight == 0) {
            return null;
        }
        ImageUploadResult imageUploadResult3 = null;
        RandomAccessFile randomAccessFile3 = null;
        StringBuilder sb = new StringBuilder();
        try {
            try {
                File file = new File(str);
                long length = file.length();
                long j = 0;
                try {
                    if (length > ImageUploadStrategy.FILE_SIZE_5M) {
                        ImageUploadResult imageUploadResult4 = new ImageUploadResult();
                        imageUploadResult4.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult4.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_size_over);
                        com.baidu.adp.lib.f.a.close((Closeable) null);
                        this.mNetwork = null;
                        return imageUploadResult4;
                    }
                    String md5 = s.toMd5(n.GetStreamFromFile(file));
                    sb.append("path=");
                    sb.append(str);
                    sb.append("|length=");
                    sb.append(length);
                    sb.append("|md5=");
                    sb.append(md5);
                    if (length == 0 || md5 == null) {
                        ImageUploadResult imageUploadResult5 = new ImageUploadResult();
                        imageUploadResult5.error_code = ImageUploadResult.INTER_ERROR_FILE_ERROR;
                        imageUploadResult5.error_msg = TbadkCoreApplication.getInst().getApp().getString(R.string.file_not_exist);
                        TiebaStatic.imgError(-1007, "file error: " + imageUploadResult5.error_msg, sb.toString());
                        imageUploadResult2 = imageUploadResult5;
                        randomAccessFile2 = null;
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
                                int i = 1;
                                int i2 = 0;
                                while (true) {
                                    long j3 = j;
                                    int i3 = i;
                                    imageUploadResult2 = imageUploadResult3;
                                    if (i3 > j2) {
                                        break;
                                    }
                                    try {
                                        if (!this.isCancelled) {
                                            int i4 = 0;
                                            if (i3 > j2) {
                                                i4 = 0;
                                                bArr = null;
                                            } else {
                                                if (i3 < j2) {
                                                    i4 = this.chunkSize;
                                                } else if (i3 == j2) {
                                                    i4 = (int) (length - (this.chunkSize * (j2 - 1)));
                                                }
                                                if (bArr2 == null || bArr2.length != i4) {
                                                    bArr2 = new byte[i4];
                                                }
                                                randomAccessFile2.seek(this.chunkSize * (i3 - 1));
                                                randomAccessFile2.read(bArr2, 0, i4);
                                                bArr = bArr2;
                                            }
                                            this.mNetwork = new z(TbConfig.UPLOAD_IMG_URL);
                                            this.mNetwork.addPostData("resourceId", str2);
                                            this.mNetwork.addPostData("chunkNo", String.valueOf(i3));
                                            if (i3 >= j2) {
                                                this.mNetwork.addPostData("isFinish", String.valueOf(1));
                                            } else {
                                                this.mNetwork.addPostData("isFinish", String.valueOf(0));
                                            }
                                            if (this.eEE) {
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
                                            if (this.eEg != 0) {
                                                this.mNetwork.addPostData("pic_water_type", String.valueOf(this.eEg));
                                            }
                                            if (z2) {
                                                int imageWaterType = k.aTv().getImageWaterType();
                                                if (imageWaterType != 0) {
                                                    this.mNetwork.addPostData("pic_water_type", String.valueOf(imageWaterType));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && imageWaterType == 1) {
                                                    this.mNetwork.addPostData("user_name", currentAccountName);
                                                }
                                                String forumNameForWaterImage = k.aTv().getForumNameForWaterImage();
                                                if (!StringUtils.isNull(forumNameForWaterImage) && imageWaterType == 2) {
                                                    this.mNetwork.addPostData("forum_name", forumNameForWaterImage);
                                                }
                                            }
                                            String forumNameForWaterImage2 = k.aTv().getForumNameForWaterImage();
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
                                                if (imageUploadResult3.error_code != ImageUploadResult.CHUNK_ERROR) {
                                                    int i5 = i3 + 1;
                                                    long j4 = j3 + i4;
                                                    long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.chunkSize) : j4;
                                                    if (this.eEC != null) {
                                                        this.eEC.onImageDataSentInBackground(str, this.progressObject, j5, length);
                                                    }
                                                    i = i5;
                                                    j = j4;
                                                } else if (i3 == imageUploadResult3.chunkNo || imageUploadResult3.chunkNo <= 0) {
                                                    break;
                                                } else {
                                                    i = imageUploadResult3.chunkNo;
                                                    j = j3;
                                                }
                                                int i6 = i2 + 1;
                                                if (i6 > 2 * j2) {
                                                    sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                                    imageUploadResult2 = imageUploadResult3;
                                                    break;
                                                }
                                                i2 = i6;
                                                bArr2 = bArr;
                                            } catch (Exception e2) {
                                                e = e2;
                                                randomAccessFile = randomAccessFile2;
                                                imageUploadResult = imageUploadResult3;
                                            }
                                        } else {
                                            break;
                                        }
                                    } catch (Exception e3) {
                                        randomAccessFile = randomAccessFile2;
                                        imageUploadResult = imageUploadResult2;
                                        e = e3;
                                    }
                                }
                            } catch (Throwable th) {
                                randomAccessFile3 = randomAccessFile2;
                                th = th;
                                com.baidu.adp.lib.f.a.close(randomAccessFile3);
                                this.mNetwork = null;
                                throw th;
                            }
                        } catch (Exception e4) {
                            e = e4;
                            randomAccessFile = randomAccessFile2;
                            imageUploadResult = null;
                        }
                    }
                    com.baidu.adp.lib.f.a.close(randomAccessFile2);
                    this.mNetwork = null;
                    return imageUploadResult2;
                } catch (Exception e5) {
                    randomAccessFile = null;
                    e = e5;
                    imageUploadResult = file;
                }
            } catch (Exception e6) {
                randomAccessFile = null;
                e = e6;
                imageUploadResult = null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
