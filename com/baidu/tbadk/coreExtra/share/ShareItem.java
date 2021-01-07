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
import com.baidu.tbadk.core.data.bz;
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
    public static final String fxI = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eWH;
    public String extLiveInfo;
    public String fName;
    public String fid;
    public String fxD;
    public String fxF;
    public int fxG;
    public String fxH;
    public String fxJ;
    public String fxK;
    public JSONArray fxL;
    public JSONObject fxM;
    public String fxm;
    public String fxn;
    public int fxt;
    public String fxu;
    public String fxv;
    public OriginalThreadInfo.ShareInfo fxw;
    public ForwardInfo fxx;
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
    public boolean fwW = false;
    public boolean fwX = false;
    public boolean fwY = false;
    public boolean fwZ = false;
    public boolean fxa = false;
    public boolean fxb = false;
    public boolean fxc = false;
    public boolean fxd = false;
    public boolean fxe = false;
    public boolean isFromImageViewer = false;
    public boolean fxf = false;
    public boolean fxg = false;
    public boolean fxh = false;
    public boolean fxi = false;
    public String fxj = "";
    public int fxo = 0;
    public int fxp = 3;
    public int fxq = 0;
    public int fxr = 0;
    public int fxs = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean fxz = true;
    public boolean fxA = true;
    public boolean fxB = true;
    public int fxC = 0;
    public boolean canShareBySmartApp = true;
    public boolean fxE = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String fxk = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> fxy = null;
    public String fxl = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bCE() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bCF() {
        Bitmap bitmap;
        if (this.fxy == null || (bitmap = this.fxy.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void x(Bitmap bitmap) {
        this.fxy = new WeakReference<>(bitmap);
    }

    public byte[] bCG() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.fxy == null || (bitmap = this.fxy.get()) == null || bitmap.isRecycled()) {
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
    public void bCH() {
        FileOutputStream fileOutputStream = null;
        if (this.fxy == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(fxI);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bCG = bCG();
                    if (bCG != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bCG);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.fxy = null;
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

    public void bI(List<Integer> list) {
        this.mCommandChannelArray = list;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }

    public boolean bCI() {
        return this.fxt == 7 || this.fxt == 8 || this.fxt == 5 || this.fxt == 6;
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

        public static ForwardInfo generateForwardInfo(bz bzVar) {
            return generateForwardInfo(bzVar, 0);
        }

        public static ForwardInfo generateForwardInfo(bz bzVar, int i) {
            return generateForwardInfo(bzVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(bz bzVar, int i, PostData postData) {
            String str = null;
            if (bzVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (bzVar.isShareThread && bzVar.eVB != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bzVar.eVB.oriUgcInfo != null && !TextUtils.isEmpty(bzVar.eVB.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bzVar.eVB.bpX();
                forwardInfo.showPicUrl = bzVar.eVB.showPicUrl;
                forwardInfo.showType = bzVar.eVB.showType;
                forwardInfo.originalBaijiahaoData = bzVar.eVB.oriUgcInfo;
                forwardInfo.originalTid = bzVar.eVB.threadId;
                if (i == 1) {
                    if (postData != null && postData.dPg() != null) {
                        str = postData.dPg().toString();
                    } else if (bzVar.getAbstract() != null) {
                        str = bzVar.bqS().toString();
                    }
                } else if (bzVar.bsp() != null) {
                    str = bzVar.bsp().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bzVar.brr() != null && !TextUtils.isEmpty(bzVar.brr().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bzVar.brr().getName_show();
                }
                if (i == 1 && postData != null && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.brr() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.brr().getName_show();
                }
                if (i == 2 && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (bzVar.getBaijiahaoData() != null && !TextUtils.isEmpty(bzVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo t = OriginalThreadInfo.t(bzVar);
                if (t != null) {
                    forwardInfo.showText = t.bpX();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = bzVar.getTid();
            }
            if (i == 1) {
                if (bzVar.eVB != null && bzVar.eVB.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bzVar.eVB.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bzVar.eVB.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bzVar.eVB.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bzVar.eVB.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bzVar.eVB.oriUgcInfo.forwardUrl;
                } else if (bzVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bzVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bzVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bzVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bzVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bzVar.getBaijiahaoData().forwardUrl;
                }
            } else if (bzVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = bzVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = bzVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = bzVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = bzVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = bzVar.getBaijiahaoData().forwardUrl;
            }
            if (bzVar.getBaijiahaoData() != null) {
                if (bzVar.getBaijiahaoData().oriUgcType == 2) {
                    if (bzVar.brI() != null) {
                        forwardInfo.video_duration = String.valueOf(bzVar.brI().video_duration);
                    }
                } else if ((bzVar.getBaijiahaoData().oriUgcType == 3 || bzVar.getBaijiahaoData().oriUgcType == 4) && bzVar.brr() != null && !TextUtils.isEmpty(bzVar.brr().getPortrait())) {
                    if (bzVar.brr().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bzVar.brr().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bzVar.brr().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
