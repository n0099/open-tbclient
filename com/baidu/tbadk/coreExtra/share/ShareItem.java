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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.at;
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
    public static final String fbz = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eBz;
    public String extLiveInfo;
    public String fName;
    public String fbA;
    public String fbB;
    public JSONArray fbC;
    public JSONObject fbD;
    public String fbd;
    public String fbe;
    public int fbk;
    public String fbl;
    public String fbm;
    public OriginalThreadInfo.ShareInfo fbn;
    public ForwardInfo fbo;
    public String fbu;
    public String fbw;
    public int fbx;
    public String fby;
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
    public boolean faN = false;
    public boolean faO = false;
    public boolean faP = false;
    public boolean faQ = false;
    public boolean faR = false;
    public boolean faS = false;
    public boolean faT = false;
    public boolean faU = false;
    public boolean faV = false;
    public boolean isFromImageViewer = false;
    public boolean faW = false;
    public boolean faX = false;
    public boolean faY = false;
    public boolean faZ = false;
    public String fba = "";
    public int fbf = 0;
    public int fbg = 3;
    public int fbh = 0;
    public int fbi = 0;
    public int fbj = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean fbq = true;
    public boolean fbr = true;
    public boolean fbs = true;
    public int fbt = 0;
    public boolean canShareBySmartApp = true;
    public boolean fbv = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String fbb = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> fbp = null;
    public String fbc = null;
    public String extData = null;
    public String localFile = null;

    public Bundle buU() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap buV() {
        Bitmap bitmap;
        if (this.fbp == null || (bitmap = this.fbp.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.fbp = new WeakReference<>(bitmap);
    }

    public byte[] buW() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.fbp == null || (bitmap = this.fbp.get()) == null || bitmap.isRecycled()) {
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
    public void buX() {
        FileOutputStream fileOutputStream = null;
        if (this.fbp == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(fbz);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] buW = buW();
                    if (buW != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(buW);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.fbp = null;
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

    public void bq(List<Integer> list) {
        this.mCommandChannelArray = list;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }

    public boolean buY() {
        return this.fbk == 7 || this.fbk == 8 || this.fbk == 5 || this.fbk == 6;
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

        public static ForwardInfo generateForwardInfo(bw bwVar) {
            return generateForwardInfo(bwVar, 0);
        }

        public static ForwardInfo generateForwardInfo(bw bwVar, int i) {
            return generateForwardInfo(bwVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(bw bwVar, int i, PostData postData) {
            String str = null;
            if (bwVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (bwVar.isShareThread && bwVar.eAy != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bwVar.eAy.oriUgcInfo != null && !TextUtils.isEmpty(bwVar.eAy.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bwVar.eAy.biH();
                forwardInfo.showPicUrl = bwVar.eAy.showPicUrl;
                forwardInfo.showType = bwVar.eAy.showType;
                forwardInfo.originalBaijiahaoData = bwVar.eAy.oriUgcInfo;
                forwardInfo.originalTid = bwVar.eAy.threadId;
                if (i == 1) {
                    if (postData != null && postData.dHz() != null) {
                        str = postData.dHz().toString();
                    } else if (bwVar.getAbstract() != null) {
                        str = bwVar.bjB().toString();
                    }
                } else if (bwVar.bkW() != null) {
                    str = bwVar.bkW().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bwVar.bka() != null && !TextUtils.isEmpty(bwVar.bka().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bwVar.bka().getName_show();
                }
                if (i == 1 && postData != null && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.bka() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.bka().getName_show();
                }
                if (i == 2 && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (bwVar.getBaijiahaoData() != null && !TextUtils.isEmpty(bwVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo t = OriginalThreadInfo.t(bwVar);
                if (t != null) {
                    forwardInfo.showText = t.biH();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = bwVar.getTid();
            }
            if (i == 1) {
                if (bwVar.eAy != null && bwVar.eAy.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bwVar.eAy.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bwVar.eAy.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bwVar.eAy.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bwVar.eAy.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bwVar.eAy.oriUgcInfo.forwardUrl;
                } else if (bwVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bwVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bwVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bwVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bwVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bwVar.getBaijiahaoData().forwardUrl;
                }
            } else if (bwVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = bwVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = bwVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = bwVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = bwVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = bwVar.getBaijiahaoData().forwardUrl;
            }
            if (bwVar.getBaijiahaoData() != null) {
                if (bwVar.getBaijiahaoData().oriUgcType == 2) {
                    if (bwVar.bks() != null) {
                        forwardInfo.video_duration = String.valueOf(bwVar.bks().video_duration);
                    }
                } else if ((bwVar.getBaijiahaoData().oriUgcType == 3 || bwVar.getBaijiahaoData().oriUgcType == 4) && bwVar.bka() != null && !TextUtils.isEmpty(bwVar.bka().getPortrait())) {
                    if (bwVar.bka().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bwVar.bka().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bwVar.bka().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
