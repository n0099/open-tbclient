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
    public static final String eGW = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public String eGA;
    public String eGB;
    public int eGH;
    public String eGI;
    public String eGJ;
    public OriginalThreadInfo.ShareInfo eGK;
    public ForwardInfo eGL;
    public String eGR;
    public String eGT;
    public int eGU;
    public String eGV;
    public String eGX;
    public String eGY;
    public JSONArray eGZ;
    public JSONObject eHa;
    public int egT;
    public String extLiveInfo;
    public String fName;
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
    public boolean eGk = false;
    public boolean eGl = false;
    public boolean eGm = false;
    public boolean eGn = false;
    public boolean eGo = false;
    public boolean eGp = false;
    public boolean eGq = false;
    public boolean eGr = false;
    public boolean eGs = false;
    public boolean isFromImageViewer = false;
    public boolean eGt = false;
    public boolean eGu = false;
    public boolean eGv = false;
    public boolean eGw = false;
    public String eGx = "";
    public int eGC = 0;
    public int eGD = 3;
    public int eGE = 0;
    public int eGF = 0;
    public int eGG = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean eGN = true;
    public boolean eGO = true;
    public boolean eGP = true;
    public int eGQ = 0;
    public boolean canShareBySmartApp = true;
    public boolean eGS = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String eGy = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> eGM = null;
    public String eGz = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bqr() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bqs() {
        Bitmap bitmap;
        if (this.eGM == null || (bitmap = this.eGM.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.eGM = new WeakReference<>(bitmap);
    }

    public byte[] bqt() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.eGM == null || (bitmap = this.eGM.get()) == null || bitmap.isRecycled()) {
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
    public void bqu() {
        FileOutputStream fileOutputStream = null;
        if (this.eGM == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(eGW);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bqt = bqt();
                    if (bqt != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bqt);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.eGM = null;
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

    public void bd(List<Integer> list) {
        this.mCommandChannelArray = list;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }

    public boolean bqv() {
        return this.eGH == 7 || this.eGH == 8 || this.eGH == 5 || this.eGH == 6;
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
            if (bwVar.isShareThread && bwVar.efS != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bwVar.efS.oriUgcInfo != null && !TextUtils.isEmpty(bwVar.efS.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bwVar.efS.bef();
                forwardInfo.showPicUrl = bwVar.efS.showPicUrl;
                forwardInfo.showType = bwVar.efS.showType;
                forwardInfo.originalBaijiahaoData = bwVar.efS.oriUgcInfo;
                forwardInfo.originalTid = bwVar.efS.threadId;
                if (i == 1) {
                    if (postData != null && postData.dAF() != null) {
                        str = postData.dAF().toString();
                    } else if (bwVar.getAbstract() != null) {
                        str = bwVar.beZ().toString();
                    }
                } else if (bwVar.bgu() != null) {
                    str = bwVar.bgu().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bwVar.bfy() != null && !TextUtils.isEmpty(bwVar.bfy().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bwVar.bfy().getName_show();
                }
                if (i == 1 && postData != null && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.bfy() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.bfy().getName_show();
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
                    forwardInfo.showText = t.bef();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = bwVar.getTid();
            }
            if (i == 1) {
                if (bwVar.efS != null && bwVar.efS.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bwVar.efS.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bwVar.efS.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bwVar.efS.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bwVar.efS.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bwVar.efS.oriUgcInfo.forwardUrl;
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
                    if (bwVar.bfQ() != null) {
                        forwardInfo.video_duration = String.valueOf(bwVar.bfQ().video_duration);
                    }
                } else if ((bwVar.getBaijiahaoData().oriUgcType == 3 || bwVar.getBaijiahaoData().oriUgcType == 4) && bwVar.bfy() != null && !TextUtils.isEmpty(bwVar.bfy().getPortrait())) {
                    if (bwVar.bfy().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bwVar.bfy().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bwVar.bfy().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
