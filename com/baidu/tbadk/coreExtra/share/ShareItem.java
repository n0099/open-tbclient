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
    public static final String eEQ = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public Bundle diskPicOperate;
    public int eEB;
    public String eEC;
    public String eED;
    public OriginalThreadInfo.ShareInfo eEE;
    public ForwardInfo eEF;
    public String eEL;
    public String eEN;
    public int eEO;
    public String eEP;
    public String eER;
    public String eES;
    public JSONArray eET;
    public JSONObject eEU;
    public String eEu;
    public String eEv;
    public int eeF;
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
    public boolean eEe = false;
    public boolean eEf = false;
    public boolean eEg = false;
    public boolean eEh = false;
    public boolean eEi = false;
    public boolean eEj = false;
    public boolean eEk = false;
    public boolean eEl = false;
    public boolean eEm = false;
    public boolean isFromImageViewer = false;
    public boolean eEn = false;
    public boolean eEo = false;
    public boolean eEp = false;
    public boolean eEq = false;
    public String eEr = "";
    public int eEw = 0;
    public int eEx = 3;
    public int eEy = 0;
    public int eEz = 0;
    public int eEA = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean eEH = true;
    public boolean eEI = true;
    public boolean eEJ = true;
    public int eEK = 0;
    public boolean canShareBySmartApp = true;
    public boolean eEM = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String eEs = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> eEG = null;
    public String eEt = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bpx() {
        return this.stats;
    }

    public void ae(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bpy() {
        Bitmap bitmap;
        if (this.eEG == null || (bitmap = this.eEG.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.eEG = new WeakReference<>(bitmap);
    }

    public byte[] bpz() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.eEG == null || (bitmap = this.eEG.get()) == null || bitmap.isRecycled()) {
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
    public void bpA() {
        FileOutputStream fileOutputStream = null;
        if (this.eEG == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(eEQ);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bpz = bpz();
                    if (bpz != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bpz);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.eEG = null;
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

    public void aZ(List<Integer> list) {
        this.mCommandChannelArray = list;
    }

    public List<Integer> getCommandChannelArray() {
        return this.mCommandChannelArray;
    }

    public boolean bpB() {
        return this.eEB == 7 || this.eEB == 8 || this.eEB == 5 || this.eEB == 6;
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
            if (bwVar.isShareThread && bwVar.edI != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bwVar.edI.oriUgcInfo != null && !TextUtils.isEmpty(bwVar.edI.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bwVar.edI.bdl();
                forwardInfo.showPicUrl = bwVar.edI.showPicUrl;
                forwardInfo.showType = bwVar.edI.showType;
                forwardInfo.originalBaijiahaoData = bwVar.edI.oriUgcInfo;
                forwardInfo.originalTid = bwVar.edI.threadId;
                if (i == 1) {
                    if (postData != null && postData.dwM() != null) {
                        str = postData.dwM().toString();
                    } else if (bwVar.getAbstract() != null) {
                        str = bwVar.bef().toString();
                    }
                } else if (bwVar.bfA() != null) {
                    str = bwVar.bfA().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bwVar.beE() != null && !TextUtils.isEmpty(bwVar.beE().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bwVar.beE().getName_show();
                }
                if (i == 1 && postData != null && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.beE() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.beE().getName_show();
                }
                if (i == 2 && at.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (bwVar.getBaijiahaoData() != null && !TextUtils.isEmpty(bwVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo s = OriginalThreadInfo.s(bwVar);
                if (s != null) {
                    forwardInfo.showText = s.bdl();
                    forwardInfo.showPicUrl = s.showPicUrl;
                    forwardInfo.showType = s.showType;
                }
                forwardInfo.originalTid = bwVar.getTid();
            }
            if (i == 1) {
                if (bwVar.edI != null && bwVar.edI.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bwVar.edI.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bwVar.edI.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bwVar.edI.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bwVar.edI.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bwVar.edI.oriUgcInfo.forwardUrl;
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
                    if (bwVar.beW() != null) {
                        forwardInfo.video_duration = String.valueOf(bwVar.beW().video_duration);
                    }
                } else if ((bwVar.getBaijiahaoData().oriUgcType == 3 || bwVar.getBaijiahaoData().oriUgcType == 4) && bwVar.beE() != null && !TextUtils.isEmpty(bwVar.beE().getPortrait())) {
                    if (bwVar.beE().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bwVar.beE().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bwVar.beE().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
