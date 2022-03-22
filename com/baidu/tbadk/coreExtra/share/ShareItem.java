package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
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
/* loaded from: classes5.dex */
public class ShareItem {
    public static /* synthetic */ Interceptable $ic;
    public static final String B0;
    public transient /* synthetic */ FieldHolder $fh;
    public Bundle A;
    public Uri A0;
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
    public long U;
    public String V;
    public ForwardInfo W;
    public String X;
    @Nullable
    public String Y;
    @Nullable
    public String Z;
    public boolean a;
    @Nullable
    public String a0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30352b;
    public int b0;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30353c;
    public WeakReference<Bitmap> c0;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30354d;
    public Bundle d0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30355e;
    public boolean e0;

    /* renamed from: f  reason: collision with root package name */
    public boolean f30356f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f30357g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public boolean f30358h;
    public boolean h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public int j0;
    public boolean k;
    public String k0;
    public boolean l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public String n;
    public boolean n0;
    public int o;
    public String o0;
    public String p;
    public int p0;
    public String q;
    public String q0;
    public String r;
    public String r0;
    public String s;
    public String s0;
    public String t;
    public String t0;
    public String u;
    public String u0;
    public Uri v;
    public JSONArray v0;
    public String w;
    public JSONObject w0;
    public String x;
    public List<Integer> x0;
    public int y;
    public String y0;
    public String z;
    public String z0;

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
        B0 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
    }

    public ShareItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f30352b = false;
        this.f30353c = false;
        this.f30354d = false;
        this.f30355e = false;
        this.f30356f = false;
        this.f30357g = false;
        this.f30358h = false;
        this.i = false;
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
        this.U = 0L;
        this.b0 = 0;
        this.e0 = false;
        this.f0 = true;
        this.g0 = false;
        this.h0 = true;
        this.i0 = true;
        this.j0 = 0;
        this.m0 = true;
        this.n0 = false;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.B = null;
        this.c0 = null;
        this.C = null;
        this.q = null;
        this.x = null;
        this.z = null;
        this.y = 0;
    }

    public List<Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.x0 : (List) invokeV.objValue;
    }

    public byte[] b() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WeakReference<Bitmap> weakReference = this.c0;
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
            WeakReference<Bitmap> weakReference = this.c0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e0 : invokeV.booleanValue;
    }

    public Bundle e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.d0 : (Bundle) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.M;
            return i == 7 || i == 8 || i == 5 || i == 6;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.c0 == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (FileHelper.checkSD()) {
                    File file = new File(B0);
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
                            this.c0 = null;
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
            this.x0 = list;
        }
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) {
            this.c0 = new WeakReference<>(bitmap);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.e0 = z;
        }
    }

    public void k(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            this.d0 = bundle;
        }
    }

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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

        public static ForwardInfo generateForwardInfo(ThreadData threadData) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) ? generateForwardInfo(threadData, 0) : (ForwardInfo) invokeL.objValue;
        }

        public static ForwardInfo generateForwardInfo(ThreadData threadData, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, threadData, i)) == null) ? generateForwardInfo(threadData, i, null) : (ForwardInfo) invokeLI.objValue;
        }

        public static ForwardInfo generateForwardInfo(ThreadData threadData, int i, PostData postData) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, i, postData)) == null) {
                String str = null;
                if (threadData == null) {
                    return null;
                }
                ForwardInfo forwardInfo = new ForwardInfo();
                forwardInfo.isShareType = false;
                if (threadData.isShareThread && threadData.originalThreadData != null) {
                    forwardInfo.isShareType = true;
                }
                if (forwardInfo.isShareType) {
                    BaijiahaoData baijiahaoData = threadData.originalThreadData.p;
                    if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    forwardInfo.showText = threadData.originalThreadData.d();
                    OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
                    forwardInfo.showPicUrl = originalThreadInfo.f29823c;
                    forwardInfo.showType = originalThreadInfo.a;
                    forwardInfo.originalBaijiahaoData = originalThreadInfo.p;
                    forwardInfo.originalTid = originalThreadInfo.f29826f;
                    if (i == 1) {
                        if (postData != null && postData.N() != null) {
                            str = postData.N().toString();
                        } else if (threadData.getAbstract() != null) {
                            str = threadData.getAbstractText().toString();
                        }
                    } else if (threadData.parseFirstFloorContent() != null) {
                        str = threadData.parseFirstFloorContent().toString();
                    }
                    if (!TextUtils.isEmpty(str)) {
                        forwardInfo.transmitOriginThreadComment = str;
                    }
                    if (threadData.getAuthor() != null && !TextUtils.isEmpty(threadData.getAuthor().getName_show())) {
                        forwardInfo.transmitThreadAuthorNameShow = threadData.getAuthor().getName_show();
                    }
                    if (i == 1 && postData != null && m.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.s() != null) {
                        forwardInfo.transmitThreadAuthorNameShow = postData.s().getName_show();
                    }
                    if (i == 2 && m.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                        forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                    }
                } else {
                    if (threadData.getBaijiahaoData() != null && !TextUtils.isEmpty(threadData.getBaijiahaoData().oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    OriginalThreadInfo l = OriginalThreadInfo.l(threadData);
                    if (l != null) {
                        forwardInfo.showText = l.d();
                        forwardInfo.showPicUrl = l.f29823c;
                        forwardInfo.showType = l.a;
                    }
                    forwardInfo.originalTid = threadData.getTid();
                }
                if (i == 1) {
                    OriginalThreadInfo originalThreadInfo2 = threadData.originalThreadData;
                    if (originalThreadInfo2 != null && originalThreadInfo2.p != null) {
                        BaijiahaoData baijiahaoData2 = new BaijiahaoData();
                        forwardInfo.baijiahaoData = baijiahaoData2;
                        BaijiahaoData baijiahaoData3 = threadData.originalThreadData.p;
                        baijiahaoData2.oriUgcNid = baijiahaoData3.oriUgcNid;
                        baijiahaoData2.oriUgcTid = baijiahaoData3.oriUgcTid;
                        baijiahaoData2.oriUgcType = baijiahaoData3.oriUgcType;
                        baijiahaoData2.oriUgcVid = baijiahaoData3.oriUgcVid;
                        baijiahaoData2.forwardUrl = baijiahaoData3.forwardUrl;
                    } else if (threadData.getBaijiahaoData() != null) {
                        BaijiahaoData baijiahaoData4 = new BaijiahaoData();
                        forwardInfo.baijiahaoData = baijiahaoData4;
                        baijiahaoData4.oriUgcNid = threadData.getBaijiahaoData().oriUgcNid;
                        forwardInfo.baijiahaoData.oriUgcTid = threadData.getBaijiahaoData().oriUgcTid;
                        forwardInfo.baijiahaoData.oriUgcType = threadData.getBaijiahaoData().oriUgcType;
                        forwardInfo.baijiahaoData.oriUgcVid = threadData.getBaijiahaoData().oriUgcVid;
                        forwardInfo.baijiahaoData.forwardUrl = threadData.getBaijiahaoData().forwardUrl;
                    }
                } else if (threadData.getBaijiahaoData() != null) {
                    BaijiahaoData baijiahaoData5 = new BaijiahaoData();
                    forwardInfo.baijiahaoData = baijiahaoData5;
                    baijiahaoData5.oriUgcNid = threadData.getBaijiahaoData().oriUgcNid;
                    forwardInfo.baijiahaoData.oriUgcTid = threadData.getBaijiahaoData().oriUgcTid;
                    forwardInfo.baijiahaoData.oriUgcType = threadData.getBaijiahaoData().oriUgcType;
                    forwardInfo.baijiahaoData.oriUgcVid = threadData.getBaijiahaoData().oriUgcVid;
                    forwardInfo.baijiahaoData.forwardUrl = threadData.getBaijiahaoData().forwardUrl;
                }
                if (threadData.getBaijiahaoData() != null) {
                    if (threadData.getBaijiahaoData().oriUgcType == 2) {
                        if (threadData.getThreadVideoInfo() != null) {
                            forwardInfo.video_duration = String.valueOf(threadData.getThreadVideoInfo().video_duration);
                        }
                    } else if ((threadData.getBaijiahaoData().oriUgcType == 3 || threadData.getBaijiahaoData().oriUgcType == 4) && threadData.getAuthor() != null && !TextUtils.isEmpty(threadData.getAuthor().getPortrait())) {
                        if (threadData.getAuthor().getPortrait().startsWith("http")) {
                            forwardInfo.avatar = threadData.getAuthor().getPortrait();
                        } else {
                            forwardInfo.avatar = TbConfig.getBigPhotoAdress() + threadData.getAuthor().getPortrait() + ".jpg";
                        }
                    }
                }
                return forwardInfo;
            }
            return (ForwardInfo) invokeLIL.objValue;
        }
    }
}
