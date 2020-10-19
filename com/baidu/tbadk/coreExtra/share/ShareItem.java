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
    public static final String eTd = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public String eSH;
    public String eSI;
    public int eSO;
    public String eSP;
    public String eSQ;
    public OriginalThreadInfo.ShareInfo eSR;
    public ForwardInfo eSS;
    public String eSY;
    public String eTa;
    public int eTb;
    public String eTc;
    public String eTe;
    public String eTf;
    public JSONArray eTg;
    public JSONObject eTh;
    public int esZ;
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
    public boolean eSr = false;
    public boolean eSs = false;
    public boolean eSt = false;
    public boolean eSu = false;
    public boolean eSv = false;
    public boolean eSw = false;
    public boolean eSx = false;
    public boolean eSy = false;
    public boolean eSz = false;
    public boolean isFromImageViewer = false;
    public boolean eSA = false;
    public boolean eSB = false;
    public boolean eSC = false;
    public boolean eSD = false;
    public String eSE = "";
    public int eSJ = 0;
    public int eSK = 3;
    public int eSL = 0;
    public int eSM = 0;
    public int eSN = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean eSU = true;
    public boolean eSV = true;
    public boolean eSW = true;
    public int eSX = 0;
    public boolean canShareBySmartApp = true;
    public boolean eSZ = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String eSF = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> eST = null;
    public String eSG = null;
    public String extData = null;
    public String localFile = null;

    public Bundle btb() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap btc() {
        Bitmap bitmap;
        if (this.eST == null || (bitmap = this.eST.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.eST = new WeakReference<>(bitmap);
    }

    public byte[] btd() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.eST == null || (bitmap = this.eST.get()) == null || bitmap.isRecycled()) {
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
    public void bte() {
        FileOutputStream fileOutputStream = null;
        if (this.eST == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(eTd);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] btd = btd();
                    if (btd != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(btd);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.eST = null;
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

    public void bg(List<Integer> list) {
        this.mCommandChannelArray = list;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }

    public boolean btf() {
        return this.eSO == 7 || this.eSO == 8 || this.eSO == 5 || this.eSO == 6;
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
            if (bwVar.isShareThread && bwVar.erY != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bwVar.erY.oriUgcInfo != null && !TextUtils.isEmpty(bwVar.erY.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bwVar.erY.bgO();
                forwardInfo.showPicUrl = bwVar.erY.showPicUrl;
                forwardInfo.showType = bwVar.erY.showType;
                forwardInfo.originalBaijiahaoData = bwVar.erY.oriUgcInfo;
                forwardInfo.originalTid = bwVar.erY.threadId;
                if (i == 1) {
                    if (postData != null && postData.dEr() != null) {
                        str = postData.dEr().toString();
                    } else if (bwVar.getAbstract() != null) {
                        str = bwVar.bhI().toString();
                    }
                } else if (bwVar.bjd() != null) {
                    str = bwVar.bjd().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bwVar.bih() != null && !TextUtils.isEmpty(bwVar.bih().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bwVar.bih().getName_show();
                }
                if (i == 1 && postData != null && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.bih() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.bih().getName_show();
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
                    forwardInfo.showText = t.bgO();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = bwVar.getTid();
            }
            if (i == 1) {
                if (bwVar.erY != null && bwVar.erY.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bwVar.erY.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bwVar.erY.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bwVar.erY.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bwVar.erY.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bwVar.erY.oriUgcInfo.forwardUrl;
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
                    if (bwVar.biz() != null) {
                        forwardInfo.video_duration = String.valueOf(bwVar.biz().video_duration);
                    }
                } else if ((bwVar.getBaijiahaoData().oriUgcType == 3 || bwVar.getBaijiahaoData().oriUgcType == 4) && bwVar.bih() != null && !TextUtils.isEmpty(bwVar.bih().getPortrait())) {
                    if (bwVar.bih().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bwVar.bih().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bwVar.bih().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
