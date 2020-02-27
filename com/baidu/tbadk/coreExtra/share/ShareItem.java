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
    public static final String dqx = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int cUA;
    public Bundle diskPicOperate;
    public String dqb;
    public String dqc;
    public int dqi;
    public String dqj;
    public String dqk;
    public OriginalThreadInfo.ShareInfo dql;
    public ForwardInfo dqm;
    public String dqs;
    public String dqu;
    public int dqv;
    public String dqw;
    public String fName;
    public String fid;
    public String imageUrl;
    private Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String topic;
    public int typeShareToSmallApp;
    public String uid;
    public boolean dpM = false;
    public boolean dpN = false;
    public boolean dpO = false;
    public boolean dpP = false;
    public boolean dpQ = false;
    public boolean dpR = false;
    public boolean dpS = false;
    public boolean dpT = false;
    public boolean dpU = false;
    public boolean dpV = false;
    public boolean dpW = false;
    public boolean dpX = false;
    public String dpY = "";
    public int dqd = 0;
    public int dqe = 3;
    public int dqf = 0;
    public int dqg = 0;
    public int dqh = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean dqo = true;
    public boolean dqp = true;
    public boolean dqq = true;
    public int dqr = 0;
    public boolean canShareBySmartApp = true;
    public boolean dqt = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String dpZ = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> dqn = null;
    public String dqa = null;
    public String extData = null;
    public String localFile = null;

    public Bundle aMp() {
        return this.stats;
    }

    public void Y(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap aMq() {
        Bitmap bitmap;
        if (this.dqn == null || (bitmap = this.dqn.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void p(Bitmap bitmap) {
        this.dqn = new WeakReference<>(bitmap);
    }

    public byte[] aMr() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.dqn == null || (bitmap = this.dqn.get()) == null || bitmap.isRecycled()) {
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
    public void aMs() {
        FileOutputStream fileOutputStream = null;
        if (this.dqn == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.checkSD()) {
                    File file = new File(dqx);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] aMr = aMr();
                    if (aMr != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(aMr);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.dqn = null;
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
            if (bjVar.isShareThread && bjVar.cTP != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bjVar.cTP.oriUgcInfo != null && !TextUtils.isEmpty(bjVar.cTP.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bjVar.cTP.aBa();
                forwardInfo.showPicUrl = bjVar.cTP.showPicUrl;
                forwardInfo.showType = bjVar.cTP.showType;
                forwardInfo.originalBaijiahaoData = bjVar.cTP.oriUgcInfo;
                forwardInfo.originalTid = bjVar.cTP.threadId;
                if (i == 1) {
                    if (postData != null && postData.cLa() != null) {
                        str = postData.cLa().toString();
                    } else if (bjVar.getAbstract() != null) {
                        str = bjVar.aBO().toString();
                    }
                } else if (bjVar.aDf() != null) {
                    str = bjVar.aDf().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bjVar.aCm() != null && !TextUtils.isEmpty(bjVar.aCm().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bjVar.aCm().getName_show();
                }
                if (i == 1 && postData != null && aq.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.aCm() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.aCm().getName_show();
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
                    forwardInfo.showText = r.aBa();
                    forwardInfo.showPicUrl = r.showPicUrl;
                    forwardInfo.showType = r.showType;
                }
                forwardInfo.originalTid = bjVar.getTid();
            }
            if (i == 1) {
                if (bjVar.cTP != null && bjVar.cTP.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bjVar.cTP.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bjVar.cTP.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bjVar.cTP.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bjVar.cTP.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bjVar.cTP.oriUgcInfo.forwardUrl;
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
                    if (bjVar.aCD() != null) {
                        forwardInfo.video_duration = String.valueOf(bjVar.aCD().video_duration);
                    }
                } else if ((bjVar.getBaijiahaoData().oriUgcType == 3 || bjVar.getBaijiahaoData().oriUgcType == 4) && bjVar.aCm() != null && !TextUtils.isEmpty(bjVar.aCm().getPortrait())) {
                    if (bjVar.aCm().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bjVar.aCm().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bjVar.aCm().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
