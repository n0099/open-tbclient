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
    public static final String fvr = o.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eUk;
    public String extLiveInfo;
    public String fName;
    public String fid;
    public String fuV;
    public String fuW;
    public int fvc;
    public String fvd;
    public String fve;
    public OriginalThreadInfo.ShareInfo fvf;
    public ForwardInfo fvg;
    public String fvm;
    public String fvo;
    public int fvp;
    public String fvq;
    public String fvs;
    public String fvt;
    public JSONArray fvu;
    public JSONObject fvv;
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
    public boolean fuF = false;
    public boolean fuG = false;
    public boolean fuH = false;
    public boolean fuI = false;
    public boolean fuJ = false;
    public boolean fuK = false;
    public boolean fuL = false;
    public boolean fuM = false;
    public boolean fuN = false;
    public boolean isFromImageViewer = false;
    public boolean fuO = false;
    public boolean fuP = false;
    public boolean fuQ = false;
    public boolean fuR = false;
    public String fuS = "";
    public int fuX = 0;
    public int fuY = 3;
    public int fuZ = 0;
    public int fva = 0;
    public int fvb = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean fvi = true;
    public boolean fvj = true;
    public boolean fvk = true;
    public int fvl = 0;
    public boolean canShareBySmartApp = true;
    public boolean fvn = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String fuT = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> fvh = null;
    public String fuU = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bzc() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bzd() {
        Bitmap bitmap;
        if (this.fvh == null || (bitmap = this.fvh.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.fvh = new WeakReference<>(bitmap);
    }

    public byte[] bze() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.fvh == null || (bitmap = this.fvh.get()) == null || bitmap.isRecycled()) {
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
    public void bzf() {
        FileOutputStream fileOutputStream = null;
        if (this.fvh == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (o.checkSD()) {
                    File file = new File(fvr);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bze = bze();
                    if (bze != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bze);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.fvh = null;
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

    public boolean bzg() {
        return this.fvc == 7 || this.fvc == 8 || this.fvc == 5 || this.fvc == 6;
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
            if (cbVar.isShareThread && cbVar.eTc != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (cbVar.eTc.oriUgcInfo != null && !TextUtils.isEmpty(cbVar.eTc.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = cbVar.eTc.bmw();
                forwardInfo.showPicUrl = cbVar.eTc.showPicUrl;
                forwardInfo.showType = cbVar.eTc.showType;
                forwardInfo.originalBaijiahaoData = cbVar.eTc.oriUgcInfo;
                forwardInfo.originalTid = cbVar.eTc.threadId;
                if (i == 1) {
                    if (postData != null && postData.dNz() != null) {
                        str = postData.dNz().toString();
                    } else if (cbVar.getAbstract() != null) {
                        str = cbVar.bnr().toString();
                    }
                } else if (cbVar.boN() != null) {
                    str = cbVar.boN().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (cbVar.bnQ() != null && !TextUtils.isEmpty(cbVar.bnQ().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = cbVar.bnQ().getName_show();
                }
                if (i == 1 && postData != null && au.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.bnQ() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.bnQ().getName_show();
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
                    forwardInfo.showText = t.bmw();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = cbVar.getTid();
            }
            if (i == 1) {
                if (cbVar.eTc != null && cbVar.eTc.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = cbVar.eTc.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = cbVar.eTc.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = cbVar.eTc.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = cbVar.eTc.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = cbVar.eTc.oriUgcInfo.forwardUrl;
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
                    if (cbVar.boh() != null) {
                        forwardInfo.video_duration = String.valueOf(cbVar.boh().video_duration);
                    }
                } else if ((cbVar.getBaijiahaoData().oriUgcType == 3 || cbVar.getBaijiahaoData().oriUgcType == 4) && cbVar.bnQ() != null && !TextUtils.isEmpty(cbVar.bnQ().getPortrait())) {
                    if (cbVar.bnQ().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = cbVar.bnQ().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + cbVar.bnQ().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
