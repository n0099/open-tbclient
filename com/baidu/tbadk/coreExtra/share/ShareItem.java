package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
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
import d.a.c.e.p.k;
import d.a.o0.r.q.b2;
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
    public static /* synthetic */ Interceptable $ic;
    public static final String r0;
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
    public boolean f12838a;
    public boolean a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f12839b;
    public boolean b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12840c;
    public boolean c0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f12841d;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f12842e;
    public String e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f12843f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12844g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12845h;
    public String h0;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12846i;
    public int i0;
    public boolean j;
    public String j0;
    public boolean k;
    public String k0;
    public boolean l;
    public String l0;
    public boolean m;
    public String m0;
    public String n;
    public String n0;
    public int o;
    public JSONArray o0;
    public String p;
    public JSONObject p0;
    public String q;
    public List<Integer> q0;
    public String r;
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
        r0 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
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
        this.f12838a = false;
        this.f12839b = false;
        this.f12840c = false;
        this.f12841d = false;
        this.f12842e = false;
        this.f12843f = false;
        this.f12844g = false;
        this.f12845h = false;
        this.f12846i = false;
        this.j = false;
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
        this.b0 = true;
        this.c0 = true;
        this.d0 = 0;
        this.f0 = true;
        this.g0 = false;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.q0 : (List) invokeV.objValue;
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
            this.q0 = list;
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

    /* loaded from: classes3.dex */
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, shareInfo)) == null) {
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

        public static ForwardInfo generateForwardInfo(b2 b2Var) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, b2Var)) == null) ? generateForwardInfo(b2Var, 0) : (ForwardInfo) invokeL.objValue;
        }

        public static ForwardInfo generateForwardInfo(b2 b2Var, int i2) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, b2Var, i2)) == null) ? generateForwardInfo(b2Var, i2, null) : (ForwardInfo) invokeLI.objValue;
        }

        public static ForwardInfo generateForwardInfo(b2 b2Var, int i2, PostData postData) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, b2Var, i2, postData)) == null) {
                String str = null;
                if (b2Var == null) {
                    return null;
                }
                ForwardInfo forwardInfo = new ForwardInfo();
                forwardInfo.isShareType = false;
                if (b2Var.v1 && b2Var.u1 != null) {
                    forwardInfo.isShareType = true;
                }
                if (forwardInfo.isShareType) {
                    BaijiahaoData baijiahaoData = b2Var.u1.p;
                    if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    forwardInfo.showText = b2Var.u1.c();
                    OriginalThreadInfo originalThreadInfo = b2Var.u1;
                    forwardInfo.showPicUrl = originalThreadInfo.f12249c;
                    forwardInfo.showType = originalThreadInfo.f12247a;
                    forwardInfo.originalBaijiahaoData = originalThreadInfo.p;
                    forwardInfo.originalTid = originalThreadInfo.f12252f;
                    if (i2 == 1) {
                        if (postData != null && postData.K() != null) {
                            str = postData.K().toString();
                        } else if (b2Var.h() != null) {
                            str = b2Var.j().toString();
                        }
                    } else if (b2Var.x2() != null) {
                        str = b2Var.x2().toString();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        forwardInfo.transmitOriginThreadComment = str;
                    }
                    if (b2Var.H() != null && !TextUtils.isEmpty(b2Var.H().getName_show())) {
                        forwardInfo.transmitThreadAuthorNameShow = b2Var.H().getName_show();
                    }
                    if (i2 == 1 && postData != null && k.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.t() != null) {
                        forwardInfo.transmitThreadAuthorNameShow = postData.t().getName_show();
                    }
                    if (i2 == 2 && k.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                        forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                    }
                } else {
                    if (b2Var.J() != null && !TextUtils.isEmpty(b2Var.J().oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    OriginalThreadInfo i3 = OriginalThreadInfo.i(b2Var);
                    if (i3 != null) {
                        forwardInfo.showText = i3.c();
                        forwardInfo.showPicUrl = i3.f12249c;
                        forwardInfo.showType = i3.f12247a;
                    }
                    forwardInfo.originalTid = b2Var.n1();
                }
                if (i2 == 1) {
                    OriginalThreadInfo originalThreadInfo2 = b2Var.u1;
                    if (originalThreadInfo2 != null && originalThreadInfo2.p != null) {
                        BaijiahaoData baijiahaoData2 = new BaijiahaoData();
                        forwardInfo.baijiahaoData = baijiahaoData2;
                        BaijiahaoData baijiahaoData3 = b2Var.u1.p;
                        baijiahaoData2.oriUgcNid = baijiahaoData3.oriUgcNid;
                        baijiahaoData2.oriUgcTid = baijiahaoData3.oriUgcTid;
                        baijiahaoData2.oriUgcType = baijiahaoData3.oriUgcType;
                        baijiahaoData2.oriUgcVid = baijiahaoData3.oriUgcVid;
                        baijiahaoData2.forwardUrl = baijiahaoData3.forwardUrl;
                    } else if (b2Var.J() != null) {
                        BaijiahaoData baijiahaoData4 = new BaijiahaoData();
                        forwardInfo.baijiahaoData = baijiahaoData4;
                        baijiahaoData4.oriUgcNid = b2Var.J().oriUgcNid;
                        forwardInfo.baijiahaoData.oriUgcTid = b2Var.J().oriUgcTid;
                        forwardInfo.baijiahaoData.oriUgcType = b2Var.J().oriUgcType;
                        forwardInfo.baijiahaoData.oriUgcVid = b2Var.J().oriUgcVid;
                        forwardInfo.baijiahaoData.forwardUrl = b2Var.J().forwardUrl;
                    }
                } else if (b2Var.J() != null) {
                    BaijiahaoData baijiahaoData5 = new BaijiahaoData();
                    forwardInfo.baijiahaoData = baijiahaoData5;
                    baijiahaoData5.oriUgcNid = b2Var.J().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = b2Var.J().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = b2Var.J().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = b2Var.J().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = b2Var.J().forwardUrl;
                }
                if (b2Var.J() != null) {
                    if (b2Var.J().oriUgcType == 2) {
                        if (b2Var.l1() != null) {
                            forwardInfo.video_duration = String.valueOf(b2Var.l1().video_duration);
                        }
                    } else if ((b2Var.J().oriUgcType == 3 || b2Var.J().oriUgcType == 4) && b2Var.H() != null && !TextUtils.isEmpty(b2Var.H().getPortrait())) {
                        if (b2Var.H().getPortrait().startsWith("http")) {
                            forwardInfo.avatar = b2Var.H().getPortrait();
                        } else {
                            forwardInfo.avatar = TbConfig.getBigPhotoAdress() + b2Var.H().getPortrait() + ".jpg";
                        }
                    }
                }
                return forwardInfo;
            }
            return (ForwardInfo) invokeLIL.objValue;
        }
    }
}
