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
    public static final String fsZ = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eRW;
    public String extLiveInfo;
    public String fName;
    public String fid;
    public String fsD;
    public String fsE;
    public int fsK;
    public String fsL;
    public String fsM;
    public OriginalThreadInfo.ShareInfo fsN;
    public ForwardInfo fsO;
    public String fsU;
    public String fsW;
    public int fsX;
    public String fsY;
    public String fta;
    public String ftb;
    public JSONArray ftc;
    public JSONObject ftd;
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
    public boolean fsn = false;
    public boolean fso = false;
    public boolean fsp = false;
    public boolean fsq = false;
    public boolean fsr = false;
    public boolean fss = false;
    public boolean fst = false;
    public boolean fsu = false;
    public boolean fsv = false;
    public boolean isFromImageViewer = false;
    public boolean fsw = false;
    public boolean fsx = false;
    public boolean fsy = false;
    public boolean fsz = false;
    public String fsA = "";
    public int fsF = 0;
    public int fsG = 3;
    public int fsH = 0;
    public int fsI = 0;
    public int fsJ = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean fsQ = true;
    public boolean fsR = true;
    public boolean fsS = true;
    public int fsT = 0;
    public boolean canShareBySmartApp = true;
    public boolean fsV = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String fsB = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> fsP = null;
    public String fsC = null;
    public String extData = null;
    public String localFile = null;

    public Bundle byK() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap byL() {
        Bitmap bitmap;
        if (this.fsP == null || (bitmap = this.fsP.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void x(Bitmap bitmap) {
        this.fsP = new WeakReference<>(bitmap);
    }

    public byte[] byM() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.fsP == null || (bitmap = this.fsP.get()) == null || bitmap.isRecycled()) {
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
    public void byN() {
        FileOutputStream fileOutputStream = null;
        if (this.fsP == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(fsZ);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] byM = byM();
                    if (byM != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(byM);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.fsP = null;
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

    public boolean byO() {
        return this.fsK == 7 || this.fsK == 8 || this.fsK == 5 || this.fsK == 6;
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
            if (bzVar.isShareThread && bzVar.eQQ != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bzVar.eQQ.oriUgcInfo != null && !TextUtils.isEmpty(bzVar.eQQ.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bzVar.eQQ.bmd();
                forwardInfo.showPicUrl = bzVar.eQQ.showPicUrl;
                forwardInfo.showType = bzVar.eQQ.showType;
                forwardInfo.originalBaijiahaoData = bzVar.eQQ.oriUgcInfo;
                forwardInfo.originalTid = bzVar.eQQ.threadId;
                if (i == 1) {
                    if (postData != null && postData.dLo() != null) {
                        str = postData.dLo().toString();
                    } else if (bzVar.getAbstract() != null) {
                        str = bzVar.bmY().toString();
                    }
                } else if (bzVar.bov() != null) {
                    str = bzVar.bov().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bzVar.bnx() != null && !TextUtils.isEmpty(bzVar.bnx().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bzVar.bnx().getName_show();
                }
                if (i == 1 && postData != null && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.bnx() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.bnx().getName_show();
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
                    forwardInfo.showText = t.bmd();
                    forwardInfo.showPicUrl = t.showPicUrl;
                    forwardInfo.showType = t.showType;
                }
                forwardInfo.originalTid = bzVar.getTid();
            }
            if (i == 1) {
                if (bzVar.eQQ != null && bzVar.eQQ.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bzVar.eQQ.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bzVar.eQQ.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bzVar.eQQ.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bzVar.eQQ.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bzVar.eQQ.oriUgcInfo.forwardUrl;
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
                    if (bzVar.bnO() != null) {
                        forwardInfo.video_duration = String.valueOf(bzVar.bnO().video_duration);
                    }
                } else if ((bzVar.getBaijiahaoData().oriUgcType == 3 || bzVar.getBaijiahaoData().oriUgcType == 4) && bzVar.bnx() != null && !TextUtils.isEmpty(bzVar.bnx().getPortrait())) {
                    if (bzVar.bnx().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bzVar.bnx().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bzVar.bnx().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
