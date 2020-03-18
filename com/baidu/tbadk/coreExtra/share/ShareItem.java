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
    public static final String dqY = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int cUP;
    public Bundle diskPicOperate;
    public String dqC;
    public String dqD;
    public int dqJ;
    public String dqK;
    public String dqL;
    public OriginalThreadInfo.ShareInfo dqM;
    public ForwardInfo dqN;
    public String dqT;
    public String dqV;
    public int dqW;
    public String dqX;
    public String fName;
    public String fid;
    public String imageUrl;
    private Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String topic;
    public int typeShareToSmallApp;
    public String uid;
    public boolean dqn = false;
    public boolean dqo = false;
    public boolean dqp = false;
    public boolean dqq = false;
    public boolean dqr = false;
    public boolean dqs = false;
    public boolean dqt = false;
    public boolean dqu = false;
    public boolean dqv = false;
    public boolean dqw = false;
    public boolean dqx = false;
    public boolean dqy = false;
    public String dqz = "";
    public int dqE = 0;
    public int dqF = 3;
    public int dqG = 0;
    public int dqH = 0;
    public int dqI = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean dqP = true;
    public boolean dqQ = true;
    public boolean dqR = true;
    public int dqS = 0;
    public boolean canShareBySmartApp = true;
    public boolean dqU = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String dqA = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> dqO = null;
    public String dqB = null;
    public String extData = null;
    public String localFile = null;

    public Bundle aMw() {
        return this.stats;
    }

    public void Y(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap aMx() {
        Bitmap bitmap;
        if (this.dqO == null || (bitmap = this.dqO.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void p(Bitmap bitmap) {
        this.dqO = new WeakReference<>(bitmap);
    }

    public byte[] aMy() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.dqO == null || (bitmap = this.dqO.get()) == null || bitmap.isRecycled()) {
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
    public void aMz() {
        FileOutputStream fileOutputStream = null;
        if (this.dqO == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.checkSD()) {
                    File file = new File(dqY);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] aMy = aMy();
                    if (aMy != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(aMy);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.dqO = null;
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
            if (bjVar.isShareThread && bjVar.cUe != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bjVar.cUe.oriUgcInfo != null && !TextUtils.isEmpty(bjVar.cUe.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bjVar.cUe.aBf();
                forwardInfo.showPicUrl = bjVar.cUe.showPicUrl;
                forwardInfo.showType = bjVar.cUe.showType;
                forwardInfo.originalBaijiahaoData = bjVar.cUe.oriUgcInfo;
                forwardInfo.originalTid = bjVar.cUe.threadId;
                if (i == 1) {
                    if (postData != null && postData.cLx() != null) {
                        str = postData.cLx().toString();
                    } else if (bjVar.getAbstract() != null) {
                        str = bjVar.aBT().toString();
                    }
                } else if (bjVar.aDk() != null) {
                    str = bjVar.aDk().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bjVar.aCr() != null && !TextUtils.isEmpty(bjVar.aCr().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bjVar.aCr().getName_show();
                }
                if (i == 1 && postData != null && aq.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.aCr() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.aCr().getName_show();
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
                    forwardInfo.showText = r.aBf();
                    forwardInfo.showPicUrl = r.showPicUrl;
                    forwardInfo.showType = r.showType;
                }
                forwardInfo.originalTid = bjVar.getTid();
            }
            if (i == 1) {
                if (bjVar.cUe != null && bjVar.cUe.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bjVar.cUe.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bjVar.cUe.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bjVar.cUe.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bjVar.cUe.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bjVar.cUe.oriUgcInfo.forwardUrl;
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
                    if (bjVar.aCI() != null) {
                        forwardInfo.video_duration = String.valueOf(bjVar.aCI().video_duration);
                    }
                } else if ((bjVar.getBaijiahaoData().oriUgcType == 3 || bjVar.getBaijiahaoData().oriUgcType == 4) && bjVar.aCr() != null && !TextUtils.isEmpty(bjVar.aCr().getPortrait())) {
                    if (bjVar.aCr().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bjVar.aCr().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bjVar.aCr().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
