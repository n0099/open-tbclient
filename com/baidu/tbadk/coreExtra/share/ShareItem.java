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
import d.a.c.e.p.k;
import d.a.m0.r.q.a2;
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
    public static final String r0 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    public Bundle A;
    public String D;
    public String J;
    public String K;
    public String L;
    public int M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String S;
    public OriginalThreadInfo.ShareInfo T;
    public ForwardInfo U;
    public String V;
    public Bundle Y;
    public String e0;
    public String h0;
    public int i0;
    public String j0;
    public String k0;
    public String l0;
    public String m0;
    public String n0;
    public int o;
    public JSONArray o0;
    public String p;
    public JSONObject p0;
    public List<Integer> q0;
    public String w;
    public int y;

    /* renamed from: a  reason: collision with root package name */
    public boolean f12657a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12658b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12659c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12660d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12661e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12662f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12663g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12664h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12665i = false;
    public boolean j = false;
    public boolean k = false;
    public boolean l = false;
    public boolean m = false;
    public String n = "";
    public int E = 0;
    public int F = 3;
    public int G = 0;
    public int H = 0;
    public int I = 0;
    public long R = -1;
    public int W = 0;
    public boolean Z = false;
    public boolean a0 = true;
    public boolean b0 = true;
    public boolean c0 = true;
    public int d0 = 0;
    public boolean f0 = true;
    public boolean g0 = false;
    public String r = null;
    public String s = null;
    public String t = null;
    public String u = null;
    public Uri v = null;
    public Location B = null;
    public WeakReference<Bitmap> X = null;
    public String C = null;
    public String q = null;
    public String x = null;
    public String z = null;

    public ShareItem() {
        this.y = 0;
        this.y = 0;
    }

    public List<Integer> a() {
        return this.q0;
    }

    public byte[] b() {
        Bitmap bitmap;
        WeakReference<Bitmap> weakReference = this.X;
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
        WeakReference<Bitmap> weakReference = this.X;
        if (weakReference == null || (bitmap = weakReference.get()) == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public boolean d() {
        return this.Z;
    }

    public Bundle e() {
        return this.Y;
    }

    public boolean f() {
        int i2 = this.M;
        return i2 == 7 || i2 == 8 || i2 == 5 || i2 == 6;
    }

    public void g() {
        if (this.X == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (FileHelper.checkSD()) {
                    File file = new File(r0);
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
                            this.X = null;
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

    public void h(List<Integer> list) {
        this.q0 = list;
    }

    public void i(Bitmap bitmap) {
        this.X = new WeakReference<>(bitmap);
    }

    public void j(boolean z) {
        this.Z = z;
    }

    public void k(Bundle bundle) {
        this.Y = bundle;
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

        public static ForwardInfo generateForwardInfo(a2 a2Var, int i2) {
            return generateForwardInfo(a2Var, i2, null);
        }

        public static ForwardInfo generateForwardInfo(a2 a2Var, int i2, PostData postData) {
            String str = null;
            if (a2Var == null) {
                return null;
            }
            ForwardInfo forwardInfo = new ForwardInfo();
            forwardInfo.isShareType = false;
            if (a2Var.u1 && a2Var.t1 != null) {
                forwardInfo.isShareType = true;
            }
            if (forwardInfo.isShareType) {
                BaijiahaoData baijiahaoData = a2Var.t1.p;
                if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                forwardInfo.showText = a2Var.t1.c();
                OriginalThreadInfo originalThreadInfo = a2Var.t1;
                forwardInfo.showPicUrl = originalThreadInfo.f12097c;
                forwardInfo.showType = originalThreadInfo.f12095a;
                forwardInfo.originalBaijiahaoData = originalThreadInfo.p;
                forwardInfo.originalTid = originalThreadInfo.f12100f;
                if (i2 == 1) {
                    if (postData != null && postData.K() != null) {
                        str = postData.K().toString();
                    } else if (a2Var.C() != null) {
                        str = a2Var.D().toString();
                    }
                } else if (a2Var.K2() != null) {
                    str = a2Var.K2().toString();
                }
                if (!TextUtils.isEmpty(str)) {
                    forwardInfo.transmitOriginThreadComment = str;
                }
                if (a2Var.T() != null && !TextUtils.isEmpty(a2Var.T().getName_show())) {
                    forwardInfo.transmitThreadAuthorNameShow = a2Var.T().getName_show();
                }
                if (i2 == 1 && postData != null && k.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.t() != null) {
                    forwardInfo.transmitThreadAuthorNameShow = postData.t().getName_show();
                }
                if (i2 == 2 && k.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                    forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                }
            } else {
                if (a2Var.V() != null && !TextUtils.isEmpty(a2Var.V().oriUgcNid)) {
                    forwardInfo.isDynamic = true;
                }
                OriginalThreadInfo i3 = OriginalThreadInfo.i(a2Var);
                if (i3 != null) {
                    forwardInfo.showText = i3.c();
                    forwardInfo.showPicUrl = i3.f12097c;
                    forwardInfo.showType = i3.f12095a;
                }
                forwardInfo.originalTid = a2Var.z1();
            }
            if (i2 == 1) {
                OriginalThreadInfo originalThreadInfo2 = a2Var.t1;
                if (originalThreadInfo2 != null && originalThreadInfo2.p != null) {
                    BaijiahaoData baijiahaoData2 = new BaijiahaoData();
                    forwardInfo.baijiahaoData = baijiahaoData2;
                    BaijiahaoData baijiahaoData3 = a2Var.t1.p;
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
                    if (a2Var.x1() != null) {
                        forwardInfo.video_duration = String.valueOf(a2Var.x1().video_duration);
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
