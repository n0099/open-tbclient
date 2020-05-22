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
import com.baidu.tbadk.core.data.bk;
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
    public static final String efp = m.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int dHZ;
    public Bundle diskPicOperate;
    public String eeT;
    public String eeU;
    public int efa;
    public String efb;
    public String efc;
    public OriginalThreadInfo.ShareInfo efd;
    public ForwardInfo efe;
    public String efk;
    public String efm;
    public int efn;
    public String efo;
    public String fName;
    public String fid;
    public String imageUrl;
    public String nid;
    private Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String topic;
    public int typeShareToSmallApp;
    public String uid;
    public boolean eeF = false;
    public boolean eeG = false;
    public boolean eeH = false;
    public boolean eeI = false;
    public boolean eeJ = false;
    public boolean eeK = false;
    public boolean eeL = false;
    public boolean eeM = false;
    public boolean eeN = false;
    public boolean isFromImageViewer = false;
    public boolean eeO = false;
    public boolean eeP = false;
    public String eeQ = "";
    public int eeV = 0;
    public int eeW = 3;
    public int eeX = 0;
    public int eeY = 0;
    public int eeZ = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean efg = true;
    public boolean efh = true;
    public boolean efi = true;
    public int efj = 0;
    public boolean canShareBySmartApp = true;
    public boolean efl = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String eeR = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> eff = null;
    public String eeS = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bbb() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bbc() {
        Bitmap bitmap;
        if (this.eff == null || (bitmap = this.eff.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void s(Bitmap bitmap) {
        this.eff = new WeakReference<>(bitmap);
    }

    public byte[] bbd() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.eff == null || (bitmap = this.eff.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [294=4, 295=4, 297=4, 298=4] */
    public void bbe() {
        FileOutputStream fileOutputStream = null;
        if (this.eff == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (m.checkSD()) {
                    File file = new File(efp);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bbd = bbd();
                    if (bbd != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bbd);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.eff = null;
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

        public static ForwardInfo generateForwardInfo(bk bkVar) {
            return generateForwardInfo(bkVar, 0);
        }

        public static ForwardInfo generateForwardInfo(bk bkVar, int i) {
            return generateForwardInfo(bkVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(bk bkVar, int i, PostData postData) {
            String str = null;
            if (bkVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (bkVar.isShareThread && bkVar.dHm != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bkVar.dHm.oriUgcInfo != null && !TextUtils.isEmpty(bkVar.dHm.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bkVar.dHm.aPl();
                forwardInfo.showPicUrl = bkVar.dHm.showPicUrl;
                forwardInfo.showType = bkVar.dHm.showType;
                forwardInfo.originalBaijiahaoData = bkVar.dHm.oriUgcInfo;
                forwardInfo.originalTid = bkVar.dHm.threadId;
                if (i == 1) {
                    if (postData != null && postData.ddw() != null) {
                        str = postData.ddw().toString();
                    } else if (bkVar.getAbstract() != null) {
                        str = bkVar.aPZ().toString();
                    }
                } else if (bkVar.aRu() != null) {
                    str = bkVar.aRu().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bkVar.aQx() != null && !TextUtils.isEmpty(bkVar.aQx().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bkVar.aQx().getName_show();
                }
                if (i == 1 && postData != null && aq.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.aQx() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.aQx().getName_show();
                }
                if (i == 2 && aq.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (bkVar.getBaijiahaoData() != null && !TextUtils.isEmpty(bkVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo s = OriginalThreadInfo.s(bkVar);
                if (s != null) {
                    forwardInfo.showText = s.aPl();
                    forwardInfo.showPicUrl = s.showPicUrl;
                    forwardInfo.showType = s.showType;
                }
                forwardInfo.originalTid = bkVar.getTid();
            }
            if (i == 1) {
                if (bkVar.dHm != null && bkVar.dHm.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bkVar.dHm.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bkVar.dHm.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bkVar.dHm.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bkVar.dHm.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bkVar.dHm.oriUgcInfo.forwardUrl;
                } else if (bkVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bkVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bkVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bkVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bkVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bkVar.getBaijiahaoData().forwardUrl;
                }
            } else if (bkVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = bkVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = bkVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = bkVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = bkVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = bkVar.getBaijiahaoData().forwardUrl;
            }
            if (bkVar.getBaijiahaoData() != null) {
                if (bkVar.getBaijiahaoData().oriUgcType == 2) {
                    if (bkVar.aQQ() != null) {
                        forwardInfo.video_duration = String.valueOf(bkVar.aQQ().video_duration);
                    }
                } else if ((bkVar.getBaijiahaoData().oriUgcType == 3 || bkVar.getBaijiahaoData().oriUgcType == 4) && bkVar.aQx() != null && !TextUtils.isEmpty(bkVar.aQx().getPortrait())) {
                    if (bkVar.aQx().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bkVar.aQx().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bkVar.aQx().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
