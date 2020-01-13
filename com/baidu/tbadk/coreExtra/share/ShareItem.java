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
    public static final String dmo = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int cQy;
    public Bundle diskPicOperate;
    public String dlS;
    public String dlT;
    public int dlZ;
    public String dma;
    public String dmb;
    public OriginalThreadInfo.ShareInfo dmc;
    public ForwardInfo dmd;
    public String dmj;
    public String dml;
    public int dmm;
    public String dmn;
    public String fName;
    public String fid;
    public String imageUrl;
    private Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String topic;
    public int typeShareToSmallApp;
    public String uid;
    public boolean dlE = false;
    public boolean dlF = false;
    public boolean dlG = false;
    public boolean dlH = false;
    public boolean dlI = false;
    public boolean dlJ = false;
    public boolean dlK = false;
    public boolean dlL = false;
    public boolean dlM = false;
    public boolean dlN = false;
    public boolean dlO = false;
    public String dlP = "";
    public int dlU = 0;
    public int dlV = 3;
    public int dlW = 0;
    public int dlX = 0;
    public int dlY = 0;
    public int shareType = 0;
    public boolean dmf = true;
    public boolean dmg = true;
    public boolean dmh = true;
    public int dmi = 0;
    public boolean canShareBySmartApp = true;
    public boolean dmk = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String dlQ = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> dme = null;
    public String dlR = null;
    public String extData = null;
    public String localFile = null;

    public Bundle aJV() {
        return this.stats;
    }

    public void Y(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap aJW() {
        Bitmap bitmap;
        if (this.dme == null || (bitmap = this.dme.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void p(Bitmap bitmap) {
        this.dme = new WeakReference<>(bitmap);
    }

    public byte[] aJX() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.dme == null || (bitmap = this.dme.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [282=4, 283=4, 285=4, 286=4] */
    public void aJY() {
        FileOutputStream fileOutputStream = null;
        if (this.dme == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.checkSD()) {
                    File file = new File(dmo);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] aJX = aJX();
                    if (aJX != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(aJX);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.dme = null;
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
            if (bjVar.isShareThread && bjVar.cPN != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bjVar.cPN.oriUgcInfo != null && !TextUtils.isEmpty(bjVar.cPN.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bjVar.cPN.ayK();
                forwardInfo.showPicUrl = bjVar.cPN.showPicUrl;
                forwardInfo.showType = bjVar.cPN.showType;
                forwardInfo.originalBaijiahaoData = bjVar.cPN.oriUgcInfo;
                forwardInfo.originalTid = bjVar.cPN.threadId;
                if (i == 1) {
                    if (postData != null && postData.cJz() != null) {
                        str = postData.cJz().toString();
                    } else if (bjVar.getAbstract() != null) {
                        str = bjVar.azy().toString();
                    }
                } else if (bjVar.aAQ() != null) {
                    str = bjVar.aAQ().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bjVar.azX() != null && !TextUtils.isEmpty(bjVar.azX().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bjVar.azX().getName_show();
                }
                if (i == 1 && postData != null && aq.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.azX() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.azX().getName_show();
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
                    forwardInfo.showText = r.ayK();
                    forwardInfo.showPicUrl = r.showPicUrl;
                    forwardInfo.showType = r.showType;
                }
                forwardInfo.originalTid = bjVar.getTid();
            }
            if (i == 1) {
                if (bjVar.cPN != null && bjVar.cPN.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bjVar.cPN.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bjVar.cPN.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bjVar.cPN.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bjVar.cPN.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bjVar.cPN.oriUgcInfo.forwardUrl;
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
                    if (bjVar.aAo() != null) {
                        forwardInfo.video_duration = String.valueOf(bjVar.aAo().video_duration);
                    }
                } else if ((bjVar.getBaijiahaoData().oriUgcType == 3 || bjVar.getBaijiahaoData().oriUgcType == 4) && bjVar.azX() != null && !TextUtils.isEmpty(bjVar.azX().getPortrait())) {
                    if (bjVar.azX().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bjVar.azX().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bjVar.azX().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
