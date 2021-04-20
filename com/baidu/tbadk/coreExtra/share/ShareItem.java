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
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.tbadkCore.data.PostData;
import d.b.c.e.p.k;
import d.b.h0.r.q.a2;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class ShareItem {
    public static final String p0 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public String C;
    public String I;
    public String J;
    public String K;
    public int L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String R;
    public OriginalThreadInfo.ShareInfo S;
    public ForwardInfo T;
    public String U;
    public Bundle X;
    public String c0;
    public String f0;
    public int g0;
    public String h0;
    public String i0;
    public String j0;
    public String k0;
    public String l0;
    public JSONArray m0;
    public JSONObject n0;
    public int o;
    public List<Integer> o0;
    public String p;
    public String w;
    public int y;
    public Bundle z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f13373a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f13374b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f13375c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f13376d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f13377e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13378f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f13379g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f13380h = false;
    public boolean i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public String n = "";
    public int D = 0;
    public int E = 3;
    public int F = 0;
    public int G = 0;
    public int H = 0;
    public long Q = -1;
    public int V = 0;
    public boolean Y = true;
    public boolean Z = true;
    public boolean a0 = true;
    public int b0 = 0;
    public boolean d0 = true;
    public boolean e0 = false;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public Uri v = null;
    public Location A = null;
    public WeakReference<Bitmap> W = null;
    public String B = null;
    public String q = null;
    public String x = null;

    public ShareItem() {
        this.y = 0;
        this.y = 0;
    }

    public List<Integer> a() {
        return this.o0;
    }

    public byte[] b() {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference = this.W;
        if (weakReference != null && (bitmap = weakReference.get()) != null && !bitmap.isRecycled()) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            r1 = bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream) ? byteArrayOutputStream.toByteArray() : null;
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused) {
            }
        }
        return r1;
    }

    public Bitmap c() {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference = this.W;
        if (weakReference == null || (bitmap = weakReference.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public Bundle d() {
        return this.X;
    }

    public boolean e() {
        int i = this.L;
        return i == 7 || i == 8 || i == 5 || i == 6;
    }

    public void f() {
        if (this.W == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (FileHelper.checkSD()) {
                    File file = new File(p0);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] b2 = b();
                    if (b2 != null) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(b2);
                            fileOutputStream2.close();
                            this.v = Uri.fromFile(file);
                            this.W = null;
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e2) {
                                BdLog.e(e2.toString());
                            }
                        } catch (Exception e3) {
                            e = e3;
                            fileOutputStream = fileOutputStream2;
                            BdLog.e(e.toString());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                    BdLog.e(e4.toString());
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e5) {
                                    BdLog.e(e5.toString());
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e6) {
            e = e6;
        }
    }

    public void g(List<Integer> list) {
        this.o0 = list;
    }

    public void h(Bitmap bitmap) {
        this.W = new WeakReference<>(bitmap);
    }

    public void i(Bundle bundle) {
        this.X = bundle;
    }

    /* loaded from: classes3.dex */
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
            BaijiahaoData baijiahaoData = shareInfo.oriUgcInfo;
            if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                forwardInfo.isDynamic = true;
                forwardInfo.baijiahaoData = shareInfo.oriUgcInfo;
            }
            return forwardInfo;
        }

        public static ForwardInfo generateForwardInfo(a2 a2Var) {
            return generateForwardInfo(a2Var, 0);
        }

        public static ForwardInfo generateForwardInfo(a2 a2Var, int i) {
            return generateForwardInfo(a2Var, i, null);
        }

        public static ForwardInfo generateForwardInfo(a2 a2Var, int i, PostData postData) {
            String str = null;
            if (a2Var == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (a2Var.s1 && a2Var.r1 != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                BaijiahaoData baijiahaoData = a2Var.r1.p;
                if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = a2Var.r1.c();
                OriginalThreadInfo originalThreadInfo = a2Var.r1;
                forwardInfo.showPicUrl = originalThreadInfo.f12874c;
                forwardInfo.showType = originalThreadInfo.f12872a;
                forwardInfo.originalBaijiahaoData = originalThreadInfo.p;
                forwardInfo.originalTid = originalThreadInfo.f12877f;
                if (i == 1) {
                    if (postData != null && postData.K() != null) {
                        str = postData.K().toString();
                    } else if (a2Var.C() != null) {
                        str = a2Var.D().toString();
                    }
                } else if (a2Var.G2() != null) {
                    str = a2Var.G2().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (a2Var.T() != null && !TextUtils.isEmpty(a2Var.T().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = a2Var.T().getName_show();
                }
                if (i == 1 && postData != null && k.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.t() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.t().getName_show();
                }
                if (i == 2 && k.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (a2Var.V() != null && !TextUtils.isEmpty(a2Var.V().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo i2 = OriginalThreadInfo.i(a2Var);
                if (i2 != null) {
                    forwardInfo.showText = i2.c();
                    forwardInfo.showPicUrl = i2.f12874c;
                    forwardInfo.showType = i2.f12872a;
                }
                forwardInfo.originalTid = a2Var.w1();
            }
            if (i == 1) {
                OriginalThreadInfo originalThreadInfo2 = a2Var.r1;
                if (originalThreadInfo2 != null && originalThreadInfo2.p != null) {
                    BaijiahaoData baijiahaoData2 = new BaijiahaoData();
                    forwardInfo.baijiahaoData = baijiahaoData2;
                    BaijiahaoData baijiahaoData3 = a2Var.r1.p;
                    baijiahaoData2.oriUgcNid = baijiahaoData3.oriUgcNid;
                    baijiahaoData2.oriUgcTid = baijiahaoData3.oriUgcTid;
                    baijiahaoData2.oriUgcType = baijiahaoData3.oriUgcType;
                    baijiahaoData2.oriUgcVid = baijiahaoData3.oriUgcVid;
                    baijiahaoData2.forwardUrl = baijiahaoData3.forwardUrl;
                } else if (a2Var.V() != null) {
                    BaijiahaoData baijiahaoData4 = new BaijiahaoData();
                    forwardInfo.baijiahaoData = baijiahaoData4;
                    baijiahaoData4.oriUgcNid = a2Var.V().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = a2Var.V().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = a2Var.V().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = a2Var.V().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = a2Var.V().forwardUrl;
                }
            } else if (a2Var.V() != null) {
                BaijiahaoData baijiahaoData5 = new BaijiahaoData();
                forwardInfo.baijiahaoData = baijiahaoData5;
                baijiahaoData5.oriUgcNid = a2Var.V().oriUgcNid;
                forwardInfo.baijiahaoData.oriUgcTid = a2Var.V().oriUgcTid;
                forwardInfo.baijiahaoData.oriUgcType = a2Var.V().oriUgcType;
                forwardInfo.baijiahaoData.oriUgcVid = a2Var.V().oriUgcVid;
                forwardInfo.baijiahaoData.forwardUrl = a2Var.V().forwardUrl;
            }
            if (a2Var.V() != null) {
                if (a2Var.V().oriUgcType == 2) {
                    if (a2Var.u1() != null) {
                        forwardInfo.video_duration = String.valueOf(a2Var.u1().video_duration);
                    }
                } else if ((a2Var.V().oriUgcType == 3 || a2Var.V().oriUgcType == 4) && a2Var.T() != null && !TextUtils.isEmpty(a2Var.T().getPortrait())) {
                    if (a2Var.T().getPortrait().startsWith("http")) {
                        forwardInfo.avatar = a2Var.T().getPortrait();
                    } else {
                        forwardInfo.avatar = TbConfig.getBigPhotoAdress() + a2Var.T().getPortrait() + ".jpg";
                    }
                }
            }
            return forwardInfo;
        }
    }
}
