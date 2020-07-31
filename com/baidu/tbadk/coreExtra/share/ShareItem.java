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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.as;
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
    public static final String eum = n.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/" + TbConfig.TMP_SHARE_DIR_NAME + "/SHARED_IMAGE";
    public int dVb;
    public Bundle diskPicOperate;
    public String etQ;
    public String etR;
    public int etX;
    public String etY;
    public String etZ;
    public OriginalThreadInfo.ShareInfo eua;
    public ForwardInfo eub;
    public String euh;
    public String euj;
    public int euk;
    public String eul;
    public String eun;
    public String euo;
    public JSONArray eup;
    public JSONObject euq;
    public String extLiveInfo;
    public String fName;
    public String fid;
    public String imageUrl;
    private List<Integer> mCommandChannelArray;
    public String mediaType;
    public String nid;
    private Bundle stats;
    public String taskCompleteId;
    public String tid;
    public String topic;
    public int typeShareToSmallApp;
    public String uid;
    public boolean etC = false;
    public boolean etD = false;
    public boolean etE = false;
    public boolean etF = false;
    public boolean etG = false;
    public boolean etH = false;
    public boolean etI = false;
    public boolean etJ = false;
    public boolean etK = false;
    public boolean isFromImageViewer = false;
    public boolean etL = false;
    public boolean etM = false;
    public String etN = "";
    public int etS = 0;
    public int etT = 3;
    public int etU = 0;
    public int etV = 0;
    public int etW = 0;
    public long readCount = -1;
    public int shareType = 0;
    public boolean eud = true;
    public boolean eue = true;
    public boolean euf = true;
    public int eug = 0;
    public boolean canShareBySmartApp = true;
    public boolean eui = false;
    public String title = null;
    public String content = null;
    public String linkUrl = null;
    public String etO = null;
    public Uri imageUri = null;
    public Location location = null;
    private WeakReference<Bitmap> euc = null;
    public String etP = null;
    public String extData = null;
    public String localFile = null;

    public Bundle bgL() {
        return this.stats;
    }

    public void af(Bundle bundle) {
        this.stats = bundle;
    }

    public ShareItem() {
        this.typeShareToSmallApp = 0;
        this.typeShareToSmallApp = 0;
    }

    public Bitmap bgM() {
        Bitmap bitmap;
        if (this.euc == null || (bitmap = this.euc.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public void w(Bitmap bitmap) {
        this.euc = new WeakReference<>(bitmap);
    }

    public byte[] bgN() {
        Bitmap bitmap;
        byte[] bArr;
        if (this.euc == null || (bitmap = this.euc.get()) == null || bitmap.isRecycled()) {
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [309=4, 310=4, 312=4, 313=4] */
    public void bgO() {
        FileOutputStream fileOutputStream = null;
        if (this.euc == null) {
            return;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                if (n.checkSD()) {
                    File file = new File(eum);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] bgN = bgN();
                    if (bgN != null) {
                        FileOutputStream fileOutputStream3 = new FileOutputStream(file);
                        try {
                            fileOutputStream3.write(bgN);
                            fileOutputStream3.close();
                            this.imageUri = Uri.fromFile(file);
                            this.euc = null;
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

        public static ForwardInfo generateForwardInfo(bv bvVar) {
            return generateForwardInfo(bvVar, 0);
        }

        public static ForwardInfo generateForwardInfo(bv bvVar, int i) {
            return generateForwardInfo(bvVar, i, null);
        }

        public static ForwardInfo generateForwardInfo(bv bvVar, int i, PostData postData) {
            String str = null;
            if (bvVar == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (bvVar.isShareThread && bvVar.dUi != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                if (bvVar.dUi.oriUgcInfo != null && !TextUtils.isEmpty(bvVar.dUi.oriUgcInfo.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = bvVar.dUi.aUS();
                forwardInfo.showPicUrl = bvVar.dUi.showPicUrl;
                forwardInfo.showType = bvVar.dUi.showType;
                forwardInfo.originalBaijiahaoData = bvVar.dUi.oriUgcInfo;
                forwardInfo.originalTid = bvVar.dUi.threadId;
                if (i == 1) {
                    if (postData != null && postData.dlj() != null) {
                        str = postData.dlj().toString();
                    } else if (bvVar.getAbstract() != null) {
                        str = bvVar.aVM().toString();
                    }
                } else if (bvVar.aXh() != null) {
                    str = bvVar.aXh().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (bvVar.aWl() != null && !TextUtils.isEmpty(bvVar.aWl().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = bvVar.aWl().getName_show();
                }
                if (i == 1 && postData != null && as.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.aWl() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.aWl().getName_show();
                }
                if (i == 2 && as.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (bvVar.getBaijiahaoData() != null && !TextUtils.isEmpty(bvVar.getBaijiahaoData().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo s = OriginalThreadInfo.s(bvVar);
                if (s != null) {
                    forwardInfo.showText = s.aUS();
                    forwardInfo.showPicUrl = s.showPicUrl;
                    forwardInfo.showType = s.showType;
                }
                forwardInfo.originalTid = bvVar.getTid();
            }
            if (i == 1) {
                if (bvVar.dUi != null && bvVar.dUi.oriUgcInfo != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bvVar.dUi.oriUgcInfo.oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bvVar.dUi.oriUgcInfo.oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bvVar.dUi.oriUgcInfo.oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bvVar.dUi.oriUgcInfo.oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bvVar.dUi.oriUgcInfo.forwardUrl;
                } else if (bvVar.getBaijiahaoData() != null) {
                    forwardInfo.baijiahaoData = new BaijiahaoData();
                    forwardInfo.baijiahaoData.oriUgcNid = bvVar.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = bvVar.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = bvVar.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = bvVar.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = bvVar.getBaijiahaoData().forwardUrl;
                }
            } else if (bvVar.getBaijiahaoData() != null) {
                forwardInfo.baijiahaoData = new BaijiahaoData();
                forwardInfo.baijiahaoData.oriUgcNid = bvVar.getBaijiahaoData().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = bvVar.getBaijiahaoData().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = bvVar.getBaijiahaoData().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = bvVar.getBaijiahaoData().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = bvVar.getBaijiahaoData().forwardUrl;
            }
            if (bvVar.getBaijiahaoData() != null) {
                if (bvVar.getBaijiahaoData().oriUgcType == 2) {
                    if (bvVar.aWD() != null) {
                        forwardInfo.video_duration = String.valueOf(bvVar.aWD().video_duration);
                    }
                } else if ((bvVar.getBaijiahaoData().oriUgcType == 3 || bvVar.getBaijiahaoData().oriUgcType == 4) && bvVar.aWl() != null && !TextUtils.isEmpty(bvVar.aWl().getPortrait())) {
                    if (bvVar.aWl().getPortrait().startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                        forwardInfo.avatar = bvVar.aWl().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + bvVar.aWl().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
