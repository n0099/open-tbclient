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
import com.baidu.tbadk.core.data.by;
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
    public static final String fnY = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eMJ;
    public String extLiveInfo;
    public String fName;
    public String fid;
    public String fnC;
    public String fnD;
    public int fnJ;
    public String fnK;
    public String fnL;
    public OriginalThreadInfo.ShareInfo fnM;
    public ForwardInfo fnN;
    public String fnT;
    public String fnV;
    public int fnW;
    public String fnX;
    public String fnZ;
    public String foa;
    public JSONArray fob;
    public JSONObject foc;
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
    public boolean fnm = false;
    public boolean fnn = false;
    public boolean fno = false;
    public boolean fnp = false;
    public boolean fnq = false;
    public boolean fnr = false;
    public boolean fns = false;
    public boolean fnt = false;
    public boolean fnu = false;
    public boolean isFromImageViewer = false;
    public boolean fnv = false;
    public boolean fnw = false;
    public boolean fnx = false;
    public boolean fny = false;
    public String fnz = "";
    public int fnE = 0;
    public int fnF = 3;
    public int fnG = 0;
    public int fnH = 0;
    public int fnI = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean fnP = true;
    public boolean fnQ = true;
    public boolean fnR = true;
    public int fnS = 0;
    public boolean canShareBySmartApp = true;
    public boolean fnU = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String fnA = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> fnO = null;
    public String fnB = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bAj() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bAk() {
        Bitmap bitmap;
        if (this.fnO == null || (bitmap = this.fnO.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.fnO = new WeakReference<>(bitmap);
    }

    public byte[] bAl() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.fnO == null || (bitmap = this.fnO.get()) == null || bitmap.isRecycled()) {
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
    public void bAm() {
        FileOutputStream fileOutputStream = null;
        if (this.fnO == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(fnY);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bAl = bAl();
                    if (bAl != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bAl);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.fnO = null;
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

    public void bB(List<Integer> list) {
        this.mCommandChannelArray = list;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }

    public boolean bAn() {
        return this.fnJ == 7 || this.fnJ == 8 || this.fnJ == 5 || this.fnJ == 6;
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

        public static ForwardInfo generateForwardInfo(by byVar) {
            return generateForwardInfo(byVar, 0);
        }

        public static ForwardInfo generateForwardInfo(by byVar, int i) {
            return generateForwardInfo(byVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(by byVar, int i, PostData postData) {
            String str = null;
            if (byVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (byVar.isShareThread && byVar.eLH != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (byVar.eLH.oriUgcInfo != null && !TextUtils.isEmpty(byVar.eLH.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = byVar.eLH.bnw();
                forwardInfo.showPicUrl = byVar.eLH.showPicUrl;
                forwardInfo.showType = byVar.eLH.showType;
                forwardInfo.originalBaijiahaoData = byVar.eLH.oriUgcInfo;
                forwardInfo.originalTid = byVar.eLH.threadId;
                if (i == 1) {
                    if (postData != null && postData.dPi() != null) {
                        str = postData.dPi().toString();
                    } else if (byVar.getAbstract() != null) {
                        str = byVar.boq().toString();
                    }
                } else if (byVar.bpN() != null) {
                    str = byVar.bpN().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (byVar.boP() != null && !TextUtils.isEmpty(byVar.boP().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = byVar.boP().getName_show();
                }
                if (i == 1 && postData != null && au.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.boP() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.boP().getName_show();
                }
                if (i == 2 && au.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (byVar.getBaijiahaoData() != null && !TextUtils.isEmpty(byVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo t = OriginalThreadInfo.t(byVar);
                if (t != null) {
                    forwardInfo.showText = t.bnw();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = byVar.getTid();
            }
            if (i == 1) {
                if (byVar.eLH != null && byVar.eLH.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = byVar.eLH.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = byVar.eLH.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = byVar.eLH.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = byVar.eLH.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = byVar.eLH.oriUgcInfo.forwardUrl;
                } else if (byVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = byVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = byVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = byVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = byVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = byVar.getBaijiahaoData().forwardUrl;
                }
            } else if (byVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = byVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = byVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = byVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = byVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = byVar.getBaijiahaoData().forwardUrl;
            }
            if (byVar.getBaijiahaoData() != null) {
                if (byVar.getBaijiahaoData().oriUgcType == 2) {
                    if (byVar.bph() != null) {
                        forwardInfo.video_duration = String.valueOf(byVar.bph().video_duration);
                    }
                } else if ((byVar.getBaijiahaoData().oriUgcType == 3 || byVar.getBaijiahaoData().oriUgcType == 4) && byVar.boP() != null && !TextUtils.isEmpty(byVar.boP().getPortrait())) {
                    if (byVar.boP().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = byVar.boP().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + byVar.boP().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
