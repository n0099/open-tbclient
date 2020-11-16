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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import org.apache.http.HttpHost;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class ShareItem {
    public static final String fgy = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eFG;
    public String extLiveInfo;
    public String fName;
    public String fgA;
    public JSONArray fgB;
    public JSONObject fgC;
    public String fgc;
    public String fgd;
    public int fgj;
    public String fgk;
    public String fgl;
    public OriginalThreadInfo.ShareInfo fgm;
    public ForwardInfo fgn;
    public String fgt;
    public String fgv;
    public int fgw;
    public String fgx;
    public String fgz;
    public String fid;
    public String imageUrl;
    private List<Integer> mCommandChannelArray;
    public String mediaType;
    public String nid;
    public String pid;
    private Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String topic;
    public int typeShareToSmallApp;
    public String uid;
    public boolean ffM = false;
    public boolean ffN = false;
    public boolean ffO = false;
    public boolean ffP = false;
    public boolean ffQ = false;
    public boolean ffR = false;
    public boolean ffS = false;
    public boolean ffT = false;
    public boolean ffU = false;
    public boolean isFromImageViewer = false;
    public boolean ffV = false;
    public boolean ffW = false;
    public boolean ffX = false;
    public boolean ffY = false;
    public String ffZ = "";
    public int fge = 0;
    public int fgf = 3;
    public int fgg = 0;
    public int fgh = 0;
    public int fgi = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean fgp = true;
    public boolean fgq = true;
    public boolean fgr = true;
    public int fgs = 0;
    public boolean canShareBySmartApp = true;
    public boolean fgu = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String fga = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> fgo = null;
    public String fgb = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bwJ() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bwK() {
        Bitmap bitmap;
        if (this.fgo == null || (bitmap = this.fgo.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.fgo = new WeakReference<>(bitmap);
    }

    public byte[] bwL() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.fgo == null || (bitmap = this.fgo.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [314=4, 315=4, 317=4, 318=4] */
    public void bwM() {
        FileOutputStream fileOutputStream = null;
        if (this.fgo == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(fgy);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bwL = bwL();
                    if (bwL != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bwL);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.fgo = null;
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

    public void bx(List<Integer> list) {
        this.mCommandChannelArray = list;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }

    public boolean bwN() {
        return this.fgj == 7 || this.fgj == 8 || this.fgj == 5 || this.fgj == 6;
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

        public static ForwardInfo generateForwardInfo(bx bxVar) {
            return generateForwardInfo(bxVar, 0);
        }

        public static ForwardInfo generateForwardInfo(bx bxVar, int i) {
            return generateForwardInfo(bxVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(bx bxVar, int i, PostData postData) {
            String str = null;
            if (bxVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (bxVar.isShareThread && bxVar.eEF != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bxVar.eEF.oriUgcInfo != null && !TextUtils.isEmpty(bxVar.eEF.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bxVar.eEF.bkj();
                forwardInfo.showPicUrl = bxVar.eEF.showPicUrl;
                forwardInfo.showType = bxVar.eEF.showType;
                forwardInfo.originalBaijiahaoData = bxVar.eEF.oriUgcInfo;
                forwardInfo.originalTid = bxVar.eEF.threadId;
                if (i == 1) {
                    if (postData != null && postData.dJS() != null) {
                        str = postData.dJS().toString();
                    } else if (bxVar.getAbstract() != null) {
                        str = bxVar.bld().toString();
                    }
                } else if (bxVar.bmA() != null) {
                    str = bxVar.bmA().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bxVar.blC() != null && !TextUtils.isEmpty(bxVar.blC().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bxVar.blC().getName_show();
                }
                if (i == 1 && postData != null && au.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.blC() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.blC().getName_show();
                }
                if (i == 2 && au.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (bxVar.getBaijiahaoData() != null && !TextUtils.isEmpty(bxVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo t = OriginalThreadInfo.t(bxVar);
                if (t != null) {
                    forwardInfo.showText = t.bkj();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = bxVar.getTid();
            }
            if (i == 1) {
                if (bxVar.eEF != null && bxVar.eEF.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bxVar.eEF.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bxVar.eEF.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bxVar.eEF.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bxVar.eEF.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bxVar.eEF.oriUgcInfo.forwardUrl;
                } else if (bxVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bxVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bxVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bxVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bxVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bxVar.getBaijiahaoData().forwardUrl;
                }
            } else if (bxVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = bxVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = bxVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = bxVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = bxVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = bxVar.getBaijiahaoData().forwardUrl;
            }
            if (bxVar.getBaijiahaoData() != null) {
                if (bxVar.getBaijiahaoData().oriUgcType == 2) {
                    if (bxVar.blU() != null) {
                        forwardInfo.video_duration = String.valueOf(bxVar.blU().video_duration);
                    }
                } else if ((bxVar.getBaijiahaoData().oriUgcType == 3 || bxVar.getBaijiahaoData().oriUgcType == 4) && bxVar.blC() != null && !TextUtils.isEmpty(bxVar.blC().getPortrait())) {
                    if (bxVar.blC().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bxVar.blC().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bxVar.blC().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
