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
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.R;
import java.io.Closeable;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class f {
    private int bigHeight;
    private int bigWidth;
    private String from;
    private int fyY;
    private a fzu;
    private e fzv;
    public boolean fzw;
    private boolean isCancelled;
    private Object progressObject;
    private int smallHeight;
    private int smallWidth;
    private int chunkSize = 512000;
    private String groupId = "1";
    private aa mNetwork = null;

    /* loaded from: classes.dex */
    public interface a {
        void onImageDataSentInBackground(String str, Object obj, long j, long j2);
    }

    public f(String str) {
        this.from = str;
    }

    public void sz(int i) {
        this.fyY = i;
    }

    public void setServersideResize(int i, int i2, int i3, int i4) {
        this.bigWidth = i;
        this.bigHeight = i2;
        this.smallWidth = i3;
        this.smallHeight = i4;
    }

    public void a(a aVar, Object obj) {
        this.fzu = aVar;
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
                        uploadedPicInfo.isBJH = this.fzw;
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
        if (this.fzv == null) {
            this.fzv = new e();
        }
        return f(this.fzv.c(imageFileInfo, z), z, z2);
    }

    public ImageUploadResult d(ImageFileInfo imageFileInfo, boolean z) {
        return a(imageFileInfo, false, z);
    }

    public ImageUploadResult ay(String str, boolean z) {
        return f(str, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [456=6, 457=4] */
    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: java.io.File */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x042c, code lost:
        r5 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x042d, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x043c, code lost:
        r6 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x043d, code lost:
        r13 = r4;
        r4 = null;
        r5 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x049e, code lost:
        com.baidu.adp.lib.util.BdLog.e(r5.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x04a7, code lost:
        r4 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x04a8, code lost:
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x04ab, code lost:
        r10 = -1002;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x04af, code lost:
        r11 = r5.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:?, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x018d, code lost:
        r20.append("|startChunk=");
        r20.append(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01a4, code lost:
        if (r25.isCancelled != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x01a6, code lost:
        r20.append("|request cancelled.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01ae, code lost:
        if (r4 != null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01b0, code lost:
        r10 = r4.error_code;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01b2, code lost:
        if (r4 != null) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x01b4, code lost:
        r11 = r4.error_msg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01b6, code lost:
        com.baidu.tbadk.core.d.a.a("img", -1, -1, "imageUpload", r10, r11, "comment", r20.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x01d2, code lost:
        com.baidu.adp.lib.f.a.close(r13);
        r25.mNetwork = null;
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
        int i;
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
                    if ((!z && length > ImageUploadStrategy.FILE_SIZE_5M) || (z && length > 10485760)) {
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
                                int i2 = 1;
                                int i3 = 0;
                                while (true) {
                                    long j3 = j;
                                    i = i2;
                                    imageUploadResult2 = imageUploadResult3;
                                    if (i > j2) {
                                        break;
                                    }
                                    try {
                                        if (!this.isCancelled) {
                                            int i4 = 0;
                                            if (i > j2) {
                                                i4 = 0;
                                                bArr = null;
                                            } else {
                                                if (i < j2) {
                                                    i4 = this.chunkSize;
                                                } else if (i == j2) {
                                                    i4 = (int) (length - (this.chunkSize * (j2 - 1)));
                                                }
                                                if (bArr2 == null || bArr2.length != i4) {
                                                    bArr2 = new byte[i4];
                                                }
                                                randomAccessFile2.seek(this.chunkSize * (i - 1));
                                                randomAccessFile2.read(bArr2, 0, i4);
                                                bArr = bArr2;
                                            }
                                            this.mNetwork = new aa(TbConfig.UPLOAD_IMG_URL);
                                            this.mNetwork.addPostData("resourceId", str2);
                                            this.mNetwork.addPostData("chunkNo", String.valueOf(i));
                                            if (i >= j2) {
                                                this.mNetwork.addPostData("isFinish", String.valueOf(1));
                                            } else {
                                                this.mNetwork.addPostData("isFinish", String.valueOf(0));
                                            }
                                            if (this.fzw) {
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
                                            if (this.fyY != 0) {
                                                this.mNetwork.addPostData("pic_water_type", String.valueOf(this.fyY));
                                            }
                                            if (z2) {
                                                int imageWaterType = k.blV().getImageWaterType();
                                                if (imageWaterType != 0) {
                                                    this.mNetwork.addPostData("pic_water_type", String.valueOf(imageWaterType));
                                                }
                                                String currentAccountName = TbadkCoreApplication.getCurrentAccountName();
                                                if (!StringUtils.isNull(currentAccountName) && imageWaterType == 1) {
                                                    this.mNetwork.addPostData("user_name", currentAccountName);
                                                }
                                                String forumNameForWaterImage = k.blV().getForumNameForWaterImage();
                                                if (!StringUtils.isNull(forumNameForWaterImage) && imageWaterType == 2) {
                                                    this.mNetwork.addPostData("forum_name", forumNameForWaterImage);
                                                }
                                            }
                                            String forumNameForWaterImage2 = k.blV().getForumNameForWaterImage();
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
                                                    int i5 = i + 1;
                                                    long j4 = j3 + i4;
                                                    long j5 = i5 > 1 ? j4 + ((i5 - 1) * this.chunkSize) : j4;
                                                    if (this.fzu != null) {
                                                        this.fzu.onImageDataSentInBackground(str, this.progressObject, j5, length);
                                                    }
                                                    i2 = i5;
                                                    j = j4;
                                                } else if (i == imageUploadResult3.chunkNo || imageUploadResult3.chunkNo <= 0) {
                                                    break;
                                                } else {
                                                    i2 = imageUploadResult3.chunkNo;
                                                    j = j3;
                                                }
                                                int i6 = i3 + 1;
                                                if (i6 > 2 * j2) {
                                                    sb.append("|possbile dead loop found. tryCount=").append(i6).append(", chunkNo=").append(j2);
                                                    imageUploadResult2 = imageUploadResult3;
                                                    break;
                                                }
                                                i3 = i6;
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
                                sb.append("|startChunk=");
                                sb.append(i);
                                sb.append("|picNull=");
                                sb.append(imageUploadResult3 == null);
                                sb.append("|picErrNo=");
                                if (imageUploadResult3 != null) {
                                    sb.append(imageUploadResult3.error_code);
                                    imageUploadResult2 = imageUploadResult3;
                                } else {
                                    imageUploadResult2 = imageUploadResult3;
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
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            randomAccessFile = null;
            e = e6;
            imageUploadResult = null;
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
