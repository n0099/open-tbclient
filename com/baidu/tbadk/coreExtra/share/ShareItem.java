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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.o;
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
    public static final String fwQ = o.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eVJ;
    public String extLiveInfo;
    public String fName;
    public String fid;
    public int fwB;
    public String fwC;
    public String fwD;
    public OriginalThreadInfo.ShareInfo fwE;
    public ForwardInfo fwF;
    public String fwL;
    public String fwN;
    public int fwO;
    public String fwP;
    public String fwR;
    public String fwS;
    public JSONArray fwT;
    public JSONObject fwU;
    public String fwu;
    public String fwv;
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
    public boolean fwe = false;
    public boolean fwf = false;
    public boolean fwg = false;
    public boolean fwh = false;
    public boolean fwi = false;
    public boolean fwj = false;
    public boolean fwk = false;
    public boolean fwl = false;
    public boolean fwm = false;
    public boolean isFromImageViewer = false;
    public boolean fwn = false;
    public boolean fwo = false;
    public boolean fwp = false;
    public boolean fwq = false;
    public String fwr = "";
    public int fww = 0;
    public int fwx = 3;
    public int fwy = 0;
    public int fwz = 0;
    public int fwA = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean fwH = true;
    public boolean fwI = true;
    public boolean fwJ = true;
    public int fwK = 0;
    public boolean canShareBySmartApp = true;
    public boolean fwM = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String fws = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> fwG = null;
    public String fwt = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bzf() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bzg() {
        Bitmap bitmap;
        if (this.fwG == null || (bitmap = this.fwG.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.fwG = new WeakReference<>(bitmap);
    }

    public byte[] bzh() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.fwG == null || (bitmap = this.fwG.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [315=4, 316=4, 318=4, 319=4] */
    public void bzi() {
        FileOutputStream fileOutputStream = null;
        if (this.fwG == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (o.checkSD()) {
                    File file = new File(fwQ);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bzh = bzh();
                    if (bzh != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bzh);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.fwG = null;
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

    public void bD(List<Integer> list) {
        this.mCommandChannelArray = list;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }

    public boolean bzj() {
        return this.fwB == 7 || this.fwB == 8 || this.fwB == 5 || this.fwB == 6;
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

        public static ForwardInfo generateForwardInfo(cb cbVar) {
            return generateForwardInfo(cbVar, 0);
        }

        public static ForwardInfo generateForwardInfo(cb cbVar, int i) {
            return generateForwardInfo(cbVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(cb cbVar, int i, PostData postData) {
            String str = null;
            if (cbVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (cbVar.isShareThread && cbVar.eUD != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (cbVar.eUD.oriUgcInfo != null && !TextUtils.isEmpty(cbVar.eUD.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = cbVar.eUD.bmy();
                forwardInfo.showPicUrl = cbVar.eUD.showPicUrl;
                forwardInfo.showType = cbVar.eUD.showType;
                forwardInfo.originalBaijiahaoData = cbVar.eUD.oriUgcInfo;
                forwardInfo.originalTid = cbVar.eUD.threadId;
                if (i == 1) {
                    if (postData != null && postData.dNQ() != null) {
                        str = postData.dNQ().toString();
                    } else if (cbVar.getAbstract() != null) {
                        str = cbVar.bnt().toString();
                    }
                } else if (cbVar.boP() != null) {
                    str = cbVar.boP().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (cbVar.bnS() != null && !TextUtils.isEmpty(cbVar.bnS().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = cbVar.bnS().getName_show();
                }
                if (i == 1 && postData != null && au.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.bnS() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.bnS().getName_show();
                }
                if (i == 2 && au.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (cbVar.getBaijiahaoData() != null && !TextUtils.isEmpty(cbVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo t = OriginalThreadInfo.t(cbVar);
                if (t != null) {
                    forwardInfo.showText = t.bmy();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = cbVar.getTid();
            }
            if (i == 1) {
                if (cbVar.eUD != null && cbVar.eUD.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = cbVar.eUD.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = cbVar.eUD.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = cbVar.eUD.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = cbVar.eUD.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = cbVar.eUD.oriUgcInfo.forwardUrl;
                } else if (cbVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = cbVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = cbVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = cbVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = cbVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = cbVar.getBaijiahaoData().forwardUrl;
                }
            } else if (cbVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = cbVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = cbVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = cbVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = cbVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = cbVar.getBaijiahaoData().forwardUrl;
            }
            if (cbVar.getBaijiahaoData() != null) {
                if (cbVar.getBaijiahaoData().oriUgcType == 2) {
                    if (cbVar.boj() != null) {
                        forwardInfo.video_duration = String.valueOf(cbVar.boj().video_duration);
                    }
                } else if ((cbVar.getBaijiahaoData().oriUgcType == 3 || cbVar.getBaijiahaoData().oriUgcType == 4) && cbVar.bnS() != null && !TextUtils.isEmpty(cbVar.bnS().getPortrait())) {
                    if (cbVar.bnS().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = cbVar.bnS().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + cbVar.bnS().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
