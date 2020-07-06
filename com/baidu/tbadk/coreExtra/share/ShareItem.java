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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.n;
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
    public static final String eoa = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int dOP;
    public Bundle diskPicOperate;
    public String enE;
    public String enF;
    public int enL;
    public String enM;
    public String enN;
    public OriginalThreadInfo.ShareInfo enO;
    public ForwardInfo enP;
    public String enV;
    public String enX;
    public int enY;
    public String enZ;
    public String extLiveInfo;
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
    public boolean enp = false;
    public boolean enq = false;
    public boolean enr = false;
    public boolean ens = false;
    public boolean ent = false;
    public boolean enu = false;
    public boolean enw = false;
    public boolean enx = false;
    public boolean eny = false;
    public boolean isFromImageViewer = false;
    public boolean enz = false;
    public boolean enA = false;
    public String enB = "";
    public int enG = 0;
    public int enH = 3;
    public int enI = 0;
    public int enJ = 0;
    public int enK = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean enR = true;
    public boolean enS = true;
    public boolean enT = true;
    public int enU = 0;
    public boolean canShareBySmartApp = true;
    public boolean enW = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String enC = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> enQ = null;
    public String enD = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bde() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bdf() {
        Bitmap bitmap;
        if (this.enQ == null || (bitmap = this.enQ.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void t(Bitmap bitmap) {
        this.enQ = new WeakReference<>(bitmap);
    }

    public byte[] bdg() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.enQ == null || (bitmap = this.enQ.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [296=4, 297=4, 299=4, 300=4] */
    public void bdh() {
        FileOutputStream fileOutputStream = null;
        if (this.enQ == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(eoa);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bdg = bdg();
                    if (bdg != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bdg);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.enQ = null;
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

        public static ForwardInfo generateForwardInfo(bu buVar) {
            return generateForwardInfo(buVar, 0);
        }

        public static ForwardInfo generateForwardInfo(bu buVar, int i) {
            return generateForwardInfo(buVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(bu buVar, int i, PostData postData) {
            String str = null;
            if (buVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (buVar.isShareThread && buVar.dNX != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (buVar.dNX.oriUgcInfo != null && !TextUtils.isEmpty(buVar.dNX.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = buVar.dNX.aQW();
                forwardInfo.showPicUrl = buVar.dNX.showPicUrl;
                forwardInfo.showType = buVar.dNX.showType;
                forwardInfo.originalBaijiahaoData = buVar.dNX.oriUgcInfo;
                forwardInfo.originalTid = buVar.dNX.threadId;
                if (i == 1) {
                    if (postData != null && postData.dib() != null) {
                        str = postData.dib().toString();
                    } else if (buVar.getAbstract() != null) {
                        str = buVar.aRQ().toString();
                    }
                } else if (buVar.aTl() != null) {
                    str = buVar.aTl().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (buVar.aSp() != null && !TextUtils.isEmpty(buVar.aSp().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = buVar.aSp().getName_show();
                }
                if (i == 1 && postData != null && ar.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.aSp() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.aSp().getName_show();
                }
                if (i == 2 && ar.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (buVar.getBaijiahaoData() != null && !TextUtils.isEmpty(buVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo r = OriginalThreadInfo.r(buVar);
                if (r != null) {
                    forwardInfo.showText = r.aQW();
                    forwardInfo.showPicUrl = r.showPicUrl;
                    forwardInfo.showType = r.showType;
                }
                forwardInfo.originalTid = buVar.getTid();
            }
            if (i == 1) {
                if (buVar.dNX != null && buVar.dNX.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = buVar.dNX.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = buVar.dNX.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = buVar.dNX.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = buVar.dNX.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = buVar.dNX.oriUgcInfo.forwardUrl;
                } else if (buVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = buVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = buVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = buVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = buVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = buVar.getBaijiahaoData().forwardUrl;
                }
            } else if (buVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = buVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = buVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = buVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = buVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = buVar.getBaijiahaoData().forwardUrl;
            }
            if (buVar.getBaijiahaoData() != null) {
                if (buVar.getBaijiahaoData().oriUgcType == 2) {
                    if (buVar.aSH() != null) {
                        forwardInfo.video_duration = String.valueOf(buVar.aSH().video_duration);
                    }
                } else if ((buVar.getBaijiahaoData().oriUgcType == 3 || buVar.getBaijiahaoData().oriUgcType == 4) && buVar.aSp() != null && !TextUtils.isEmpty(buVar.aSp().getPortrait())) {
                    if (buVar.aSp().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = buVar.aSp().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + buVar.aSp().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
