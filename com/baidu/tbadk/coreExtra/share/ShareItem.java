package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import org.apache.http.HttpHost;
/* loaded from: classes.dex */
public class ShareItem {
    public static final String dQR = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int dQC;
    public String dQD;
    public String dQE;
    public OriginalThreadInfo.ShareInfo dQF;
    public ForwardInfo dQG;
    public String dQM;
    public String dQO;
    public int dQP;
    public String dQQ;
    public String dQv;
    public String dQw;
    public Bundle diskPicOperate;
    public int dua;
    public String fName;
    public String fid;
    public String imageUrl;
    private Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String topic;
    public int typeShareToSmallApp;
    public String uid;
    public boolean dQg = false;
    public boolean dQh = false;
    public boolean dQi = false;
    public boolean dQj = false;
    public boolean dQk = false;
    public boolean dQl = false;
    public boolean dQm = false;
    public boolean dQn = false;
    public boolean dQo = false;
    public boolean dQp = false;
    public boolean dQq = false;
    public boolean dQr = false;
    public String dQs = "";
    public int dQx = 0;
    public int dQy = 3;
    public int dQz = 0;
    public int dQA = 0;
    public int dQB = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean dQI = true;
    public boolean dQJ = true;
    public boolean dQK = true;
    public int dQL = 0;
    public boolean canShareBySmartApp = true;
    public boolean dQN = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String dQt = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> dQH = null;
    public String dQu = null;
    public String extData = null;
    public String localFile = null;

    public Bundle aUT() {
        return this.stats;
    }

    public void Y(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap aUU() {
        Bitmap bitmap;
        if (this.dQH == null || (bitmap = this.dQH.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void r(Bitmap bitmap) {
        this.dQH = new WeakReference<>(bitmap);
    }

    public byte[] aUV() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.dQH == null || (bitmap = this.dQH.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (!bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream)) {
            bArr = null;
        } else {
            bArr = byteArrayOutputStream.toByteArray();
        }
        try {
            byteArrayOutputStream.close();
            return bArr;
        } catch (IOException e) {
            return bArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [293=4, 294=4, 296=4, 297=4] */
    public void aUW() {
        FileOutputStream fileOutputStream = null;
        if (this.dQH == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.checkSD()) {
                    File file = new File(dQR);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] aUV = aUV();
                    if (aUV != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(aUV);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.dQH = null;
                            if (fileOutputStream3 != null) {
                                try {
                                    fileOutputStream3.close();
                                    return;
                                } catch (IOException e) {
                                    BdLog.e(e.toString());
                                    return;
                                }
                            }
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream3;
                            BdLog.e(e.toString());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                    return;
                                } catch (IOException e3) {
                                    BdLog.e(e3.toString());
                                    return;
                                }
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream3;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    BdLog.e(e4.toString());
                                }
                            }
                            throw th;
                        }
                    }
                }
                if (0 != 0) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        BdLog.e(e5.toString());
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    /* loaded from: classes.dex */
    public static class ForwardInfo extends OrmObject implements Serializable {
        public String avatar;
        public BaijiahaoData baijiahaoData;
        public boolean isDynamic;
        public boolean isShareType;
        public BaijiahaoData originalBaijiahaoData;
        public String originalTid;
        public String showPicUrl;
        public String showText;
        public int showType;
        public String transmitOriginThreadComment;
        public String transmitThreadAuthorNameShow;
        public String url;
        public String video_duration;

        public static ForwardInfo generateForwardInfo(OriginalThreadInfo.ShareInfo shareInfo) {
            if (shareInfo == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            forwardInfo.showText = shareInfo.showText;
            forwardInfo.showPicUrl = shareInfo.showPicUrl;
            forwardInfo.showType = shareInfo.showType;
            forwardInfo.originalTid = shareInfo.threadId;
            if (shareInfo.oriUgcInfo != null && !TextUtils.isEmpty(shareInfo.oriUgcInfo.oriUgcNid)) {
                forwardInfo.isDynamic = true;
                forwardInfo.baijiahaoData = shareInfo.oriUgcInfo;
                return forwardInfo;
            }
            return forwardInfo;
        }

        public static ForwardInfo generateForwardInfo(bj bjVar) {
            return generateForwardInfo(bjVar, 0);
        }

        public static ForwardInfo generateForwardInfo(bj bjVar, int i) {
            return generateForwardInfo(bjVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(bj bjVar, int i, PostData postData) {
            String str = null;
            if (bjVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (bjVar.isShareThread && bjVar.dto != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bjVar.dto.oriUgcInfo != null && !TextUtils.isEmpty(bjVar.dto.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bjVar.dto.aJs();
                forwardInfo.showPicUrl = bjVar.dto.showPicUrl;
                forwardInfo.showType = bjVar.dto.showType;
                forwardInfo.originalBaijiahaoData = bjVar.dto.oriUgcInfo;
                forwardInfo.originalTid = bjVar.dto.threadId;
                if (i == 1) {
                    if (postData != null && postData.cWt() != null) {
                        str = postData.cWt().toString();
                    } else if (bjVar.getAbstract() != null) {
                        str = bjVar.aKg().toString();
                    }
                } else if (bjVar.aLx() != null) {
                    str = bjVar.aLx().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bjVar.aKE() != null && !TextUtils.isEmpty(bjVar.aKE().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bjVar.aKE().getName_show();
                }
                if (i == 1 && postData != null && aq.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.aKE() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.aKE().getName_show();
                }
                if (i == 2 && aq.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (bjVar.getBaijiahaoData() != null && !TextUtils.isEmpty(bjVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo r = OriginalThreadInfo.r(bjVar);
                if (r != null) {
                    forwardInfo.showText = r.aJs();
                    forwardInfo.showPicUrl = r.showPicUrl;
                    forwardInfo.showType = r.showType;
                }
                forwardInfo.originalTid = bjVar.getTid();
            }
            if (i == 1) {
                if (bjVar.dto != null && bjVar.dto.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bjVar.dto.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bjVar.dto.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bjVar.dto.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bjVar.dto.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bjVar.dto.oriUgcInfo.forwardUrl;
                } else if (bjVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bjVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bjVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bjVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bjVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bjVar.getBaijiahaoData().forwardUrl;
                }
            } else if (bjVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = bjVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = bjVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = bjVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = bjVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = bjVar.getBaijiahaoData().forwardUrl;
            }
            if (bjVar.getBaijiahaoData() != null) {
                if (bjVar.getBaijiahaoData().oriUgcType == 2) {
                    if (bjVar.aKV() != null) {
                        forwardInfo.video_duration = String.valueOf(bjVar.aKV().video_duration);
                    }
                } else if ((bjVar.getBaijiahaoData().oriUgcType == 3 || bjVar.getBaijiahaoData().oriUgcType == 4) && bjVar.aKE() != null && !TextUtils.isEmpty(bjVar.aKE().getPortrait())) {
                    if (bjVar.aKE().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bjVar.aKE().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bjVar.aKE().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
