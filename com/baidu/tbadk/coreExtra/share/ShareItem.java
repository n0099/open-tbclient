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
    public static final String fhq = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eHo;
    public String extLiveInfo;
    public String fName;
    public String fgU;
    public String fgV;
    public int fhb;
    public String fhc;
    public String fhd;
    public OriginalThreadInfo.ShareInfo fhe;
    public ForwardInfo fhf;
    public String fhl;
    public String fhn;
    public int fho;
    public String fhp;
    public String fhr;
    public String fhs;
    public JSONArray fht;
    public JSONObject fhu;
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
    public boolean fgE = false;
    public boolean fgF = false;
    public boolean fgG = false;
    public boolean fgH = false;
    public boolean fgI = false;
    public boolean fgJ = false;
    public boolean fgK = false;
    public boolean fgL = false;
    public boolean fgM = false;
    public boolean isFromImageViewer = false;
    public boolean fgN = false;
    public boolean fgO = false;
    public boolean fgP = false;
    public boolean fgQ = false;
    public String fgR = "";
    public int fgW = 0;
    public int fgX = 3;
    public int fgY = 0;
    public int fgZ = 0;
    public int fha = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean fhh = true;
    public boolean fhi = true;
    public boolean fhj = true;
    public int fhk = 0;
    public boolean canShareBySmartApp = true;
    public boolean fhm = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String fgS = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> fhg = null;
    public String fgT = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bxt() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bxu() {
        Bitmap bitmap;
        if (this.fhg == null || (bitmap = this.fhg.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.fhg = new WeakReference<>(bitmap);
    }

    public byte[] bxv() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.fhg == null || (bitmap = this.fhg.get()) == null || bitmap.isRecycled()) {
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
    public void bxw() {
        FileOutputStream fileOutputStream = null;
        if (this.fhg == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(fhq);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bxv = bxv();
                    if (bxv != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bxv);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.fhg = null;
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

    public boolean bxx() {
        return this.fhb == 7 || this.fhb == 8 || this.fhb == 5 || this.fhb == 6;
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
            if (bwVar.isShareThread && bwVar.eGn != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bwVar.eGn.oriUgcInfo != null && !TextUtils.isEmpty(bwVar.eGn.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bwVar.eGn.blh();
                forwardInfo.showPicUrl = bwVar.eGn.showPicUrl;
                forwardInfo.showType = bwVar.eGn.showType;
                forwardInfo.originalBaijiahaoData = bwVar.eGn.oriUgcInfo;
                forwardInfo.originalTid = bwVar.eGn.threadId;
                if (i == 1) {
                    if (postData != null && postData.dKb() != null) {
                        str = postData.dKb().toString();
                    } else if (bwVar.getAbstract() != null) {
                        str = bwVar.bmb().toString();
                    }
                } else if (bwVar.bnw() != null) {
                    str = bwVar.bnw().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bwVar.bmA() != null && !TextUtils.isEmpty(bwVar.bmA().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bwVar.bmA().getName_show();
                }
                if (i == 1 && postData != null && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.bmA() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.bmA().getName_show();
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
                    forwardInfo.showText = t.blh();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = bwVar.getTid();
            }
            if (i == 1) {
                if (bwVar.eGn != null && bwVar.eGn.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bwVar.eGn.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bwVar.eGn.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bwVar.eGn.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bwVar.eGn.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bwVar.eGn.oriUgcInfo.forwardUrl;
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
                    if (bwVar.bmS() != null) {
                        forwardInfo.video_duration = String.valueOf(bwVar.bmS().video_duration);
                    }
                } else if ((bwVar.getBaijiahaoData().oriUgcType == 3 || bwVar.getBaijiahaoData().oriUgcType == 4) && bwVar.bmA() != null && !TextUtils.isEmpty(bwVar.bmA().getPortrait())) {
                    if (bwVar.bmA().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bwVar.bmA().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bwVar.bmA().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
