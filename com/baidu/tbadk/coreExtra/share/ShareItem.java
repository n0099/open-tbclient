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
    public static final String dqL = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int cUC;
    public Bundle diskPicOperate;
    public ForwardInfo dqA;
    public String dqG;
    public String dqI;
    public int dqJ;
    public String dqK;
    public String dqp;
    public String dqq;
    public int dqw;
    public String dqx;
    public String dqy;
    public OriginalThreadInfo.ShareInfo dqz;
    public String fName;
    public String fid;
    public String imageUrl;
    private Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String topic;
    public int typeShareToSmallApp;
    public String uid;
    public boolean dqa = false;
    public boolean dqb = false;
    public boolean dqc = false;
    public boolean dqd = false;
    public boolean dqe = false;
    public boolean dqf = false;
    public boolean dqg = false;
    public boolean dqh = false;
    public boolean dqi = false;
    public boolean dqj = false;
    public boolean dqk = false;
    public boolean dql = false;
    public String dqm = "";
    public int dqr = 0;
    public int dqs = 3;
    public int dqt = 0;
    public int dqu = 0;
    public int dqv = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean dqC = true;
    public boolean dqD = true;
    public boolean dqE = true;
    public int dqF = 0;
    public boolean canShareBySmartApp = true;
    public boolean dqH = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String dqn = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> dqB = null;
    public String dqo = null;
    public String extData = null;
    public String localFile = null;

    public Bundle aMs() {
        return this.stats;
    }

    public void Y(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap aMt() {
        Bitmap bitmap;
        if (this.dqB == null || (bitmap = this.dqB.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void p(Bitmap bitmap) {
        this.dqB = new WeakReference<>(bitmap);
    }

    public byte[] aMu() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.dqB == null || (bitmap = this.dqB.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [292=4, 293=4, 295=4, 296=4] */
    public void aMv() {
        FileOutputStream fileOutputStream = null;
        if (this.dqB == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.checkSD()) {
                    File file = new File(dqL);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] aMu = aMu();
                    if (aMu != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(aMu);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.dqB = null;
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
            if (bjVar.isShareThread && bjVar.cTR != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bjVar.cTR.oriUgcInfo != null && !TextUtils.isEmpty(bjVar.cTR.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bjVar.cTR.aBc();
                forwardInfo.showPicUrl = bjVar.cTR.showPicUrl;
                forwardInfo.showType = bjVar.cTR.showType;
                forwardInfo.originalBaijiahaoData = bjVar.cTR.oriUgcInfo;
                forwardInfo.originalTid = bjVar.cTR.threadId;
                if (i == 1) {
                    if (postData != null && postData.cLd() != null) {
                        str = postData.cLd().toString();
                    } else if (bjVar.getAbstract() != null) {
                        str = bjVar.aBQ().toString();
                    }
                } else if (bjVar.aDh() != null) {
                    str = bjVar.aDh().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bjVar.aCo() != null && !TextUtils.isEmpty(bjVar.aCo().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bjVar.aCo().getName_show();
                }
                if (i == 1 && postData != null && aq.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.aCo() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.aCo().getName_show();
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
                    forwardInfo.showText = r.aBc();
                    forwardInfo.showPicUrl = r.showPicUrl;
                    forwardInfo.showType = r.showType;
                }
                forwardInfo.originalTid = bjVar.getTid();
            }
            if (i == 1) {
                if (bjVar.cTR != null && bjVar.cTR.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bjVar.cTR.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bjVar.cTR.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bjVar.cTR.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bjVar.cTR.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bjVar.cTR.oriUgcInfo.forwardUrl;
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
                    if (bjVar.aCF() != null) {
                        forwardInfo.video_duration = String.valueOf(bjVar.aCF().video_duration);
                    }
                } else if ((bjVar.getBaijiahaoData().oriUgcType == 3 || bjVar.getBaijiahaoData().oriUgcType == 4) && bjVar.aCo() != null && !TextUtils.isEmpty(bjVar.aCo().getPortrait())) {
                    if (bjVar.aCo().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bjVar.aCo().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bjVar.aCo().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
