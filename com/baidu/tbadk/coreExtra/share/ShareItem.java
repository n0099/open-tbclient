package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.k;
import c.a.o0.s.q.c2;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ShareItem {
    public static /* synthetic */ Interceptable $ic;
    public static final String s0;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle A;
    public Location B;
    public String C;
    public String D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public String J;
    public String K;
    public String L;
    public int M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public long R;
    public String S;
    public OriginalThreadInfo.ShareInfo T;
    public ForwardInfo U;
    public String V;
    public int W;
    public WeakReference<Bitmap> X;
    public Bundle Y;
    public boolean Z;

    /* renamed from: a  reason: collision with root package name */
    public boolean f47870a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f47871b;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47872c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47873d;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47874e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47875f;
    public String f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47876g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47877h;
    public boolean h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f47878i;
    public String i0;

    /* renamed from: j  reason: collision with root package name */
    public boolean f47879j;
    public int j0;
    public boolean k;
    public String k0;
    public boolean l;
    public String l0;
    public boolean m;
    public String m0;
    public String n;
    public String n0;
    public int o;
    public String o0;
    public String p;
    public JSONArray p0;
    public String q;
    public JSONObject q0;
    public String r;
    public List<Integer> r0;
    public String s;
    public String t;
    public String u;
    public Uri v;
    public String w;
    public String x;
    public int y;
    public String z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1452161178, "Lcom/baidu/tbadk/coreExtra/share/ShareItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1452161178, "Lcom/baidu/tbadk/coreExtra/share/ShareItem;");
                return;
            }
        }
        s0 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    }

    public ShareItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f47870a = false;
        this.f47871b = false;
        this.f47872c = false;
        this.f47873d = false;
        this.f47874e = false;
        this.f47875f = false;
        this.f47876g = false;
        this.f47877h = false;
        this.f47878i = false;
        this.f47879j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = "";
        this.y = 0;
        this.E = 0;
        this.F = 3;
        this.G = 0;
        this.H = 0;
        this.I = 0;
        this.R = -1L;
        this.W = 0;
        this.Z = false;
        this.a0 = true;
        this.b0 = false;
        this.c0 = true;
        this.d0 = true;
        this.e0 = 0;
        this.g0 = true;
        this.h0 = false;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.B = null;
        this.X = null;
        this.C = null;
        this.q = null;
        this.x = null;
        this.z = null;
        this.y = 0;
    }

    public List<Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r0 : (List) invokeV.objValue;
    }

    public byte[] b() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
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
        return (byte[]) invokeV.objValue;
    }

    public Bitmap c() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WeakReference<Bitmap> weakReference = this.X;
            if (weakReference == null || (bitmap = weakReference.get()) == null || bitmap.isRecycled()) {
                return null;
            }
            return bitmap;
        }
        return (Bitmap) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    public Bundle e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.Y : (Bundle) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.M;
            return i2 == 7 || i2 == 8 || i2 == 5 || i2 == 6;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.X == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (FileHelper.checkSD()) {
                    File file = new File(s0);
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
            } catch (Exception e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void h(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.r0 = list;
        }
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) {
            this.X = new WeakReference<>(bitmap);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.Z = z;
        }
    }

    public void k(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            this.Y = bundle;
        }
    }

    /* loaded from: classes6.dex */
    public static class ForwardInfo extends OrmObject implements Serializable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
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

        public ForwardInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static ForwardInfo generateForwardInfo(OriginalThreadInfo.ShareInfo shareInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, shareInfo)) == null) {
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
            return (ForwardInfo) invokeL.objValue;
        }

        public static ForwardInfo generateForwardInfo(c2 c2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65537, null, c2Var)) == null) ? generateForwardInfo(c2Var, 0) : (ForwardInfo) invokeL.objValue;
        }

        public static ForwardInfo generateForwardInfo(c2 c2Var, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, c2Var, i2)) == null) ? generateForwardInfo(c2Var, i2, null) : (ForwardInfo) invokeLI.objValue;
        }

        public static ForwardInfo generateForwardInfo(c2 c2Var, int i2, PostData postData) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65539, null, c2Var, i2, postData)) == null) {
                String str = null;
                if (c2Var == null) {
                    return null;
                }
                ForwardInfo forwardInfo = new ForwardInfo();
                forwardInfo.isShareType = false;
                if (c2Var.w1 && c2Var.v1 != null) {
                    forwardInfo.isShareType = true;
                }
                if (forwardInfo.isShareType) {
                    BaijiahaoData baijiahaoData = c2Var.v1.p;
                    if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    forwardInfo.showText = c2Var.v1.d();
                    OriginalThreadInfo originalThreadInfo = c2Var.v1;
                    forwardInfo.showPicUrl = originalThreadInfo.f47197c;
                    forwardInfo.showType = originalThreadInfo.f47195a;
                    forwardInfo.originalBaijiahaoData = originalThreadInfo.p;
                    forwardInfo.originalTid = originalThreadInfo.f47200f;
                    if (i2 == 1) {
                        if (postData != null && postData.K() != null) {
                            str = postData.K().toString();
                        } else if (c2Var.o() != null) {
                            str = c2Var.p().toString();
                        }
                    } else if (c2Var.H2() != null) {
                        str = c2Var.H2().toString();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        forwardInfo.transmitOriginThreadComment = str;
                    }
                    if (c2Var.J() != null && !TextUtils.isEmpty(c2Var.J().getName_show())) {
                        forwardInfo.transmitThreadAuthorNameShow = c2Var.J().getName_show();
                    }
                    if (i2 == 1 && postData != null && k.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.t() != null) {
                        forwardInfo.transmitThreadAuthorNameShow = postData.t().getName_show();
                    }
                    if (i2 == 2 && k.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                        forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                    }
                } else {
                    if (c2Var.L() != null && !TextUtils.isEmpty(c2Var.L().oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    OriginalThreadInfo k = OriginalThreadInfo.k(c2Var);
                    if (k != null) {
                        forwardInfo.showText = k.d();
                        forwardInfo.showPicUrl = k.f47197c;
                        forwardInfo.showType = k.f47195a;
                    }
                    forwardInfo.originalTid = c2Var.q1();
                }
                if (i2 == 1) {
                    OriginalThreadInfo originalThreadInfo2 = c2Var.v1;
                    if (originalThreadInfo2 != null && originalThreadInfo2.p != null) {
                        BaijiahaoData baijiahaoData2 = new BaijiahaoData();
                        forwardInfo.baijiahaoData = baijiahaoData2;
                        BaijiahaoData baijiahaoData3 = c2Var.v1.p;
                        baijiahaoData2.oriUgcNid = baijiahaoData3.oriUgcNid;
                        baijiahaoData2.oriUgcTid = baijiahaoData3.oriUgcTid;
                        baijiahaoData2.oriUgcType = baijiahaoData3.oriUgcType;
                        baijiahaoData2.oriUgcVid = baijiahaoData3.oriUgcVid;
                        baijiahaoData2.forwardUrl = baijiahaoData3.forwardUrl;
                    } else if (c2Var.L() != null) {
                        BaijiahaoData baijiahaoData4 = new BaijiahaoData();
                        forwardInfo.baijiahaoData = baijiahaoData4;
                        baijiahaoData4.oriUgcNid = c2Var.L().oriUgcNid;
                        forwardInfo.baijiahaoData.oriUgcTid = c2Var.L().oriUgcTid;
                        forwardInfo.baijiahaoData.oriUgcType = c2Var.L().oriUgcType;
                        forwardInfo.baijiahaoData.oriUgcVid = c2Var.L().oriUgcVid;
                        forwardInfo.baijiahaoData.forwardUrl = c2Var.L().forwardUrl;
                    }
                } else if (c2Var.L() != null) {
                    BaijiahaoData baijiahaoData5 = new BaijiahaoData();
                    forwardInfo.baijiahaoData = baijiahaoData5;
                    baijiahaoData5.oriUgcNid = c2Var.L().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = c2Var.L().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = c2Var.L().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = c2Var.L().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = c2Var.L().forwardUrl;
                }
                if (c2Var.L() != null) {
                    if (c2Var.L().oriUgcType == 2) {
                        if (c2Var.o1() != null) {
                            forwardInfo.video_duration = String.valueOf(c2Var.o1().video_duration);
                        }
                    } else if ((c2Var.L().oriUgcType == 3 || c2Var.L().oriUgcType == 4) && c2Var.J() != null && !TextUtils.isEmpty(c2Var.J().getPortrait())) {
                        if (c2Var.J().getPortrait().startsWith("http")) {
                            forwardInfo.avatar = c2Var.J().getPortrait();
                        } else {
                            forwardInfo.avatar = TbConfig.getBigPhotoAdress() + c2Var.J().getPortrait() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX;
                        }
                    }
                }
                return forwardInfo;
            }
            return (ForwardInfo) invokeLIL.objValue;
        }
    }
}
