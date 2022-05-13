package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
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
import com.repackage.li;
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
    public static final String F0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public JSONObject A0;
    public String B;
    public List<Integer> B0;
    public Bundle C;
    public String C0;
    public Location D;
    public String D0;
    public String E;
    public Uri E0;
    public String F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public String L;
    public String M;
    public String N;
    public int O;
    public String P;
    public String Q;
    public String R;
    public String S;
    public long T;
    public String U;
    public OriginalThreadInfo.ShareInfo V;
    public long W;
    public String X;
    public ForwardInfo Y;
    public transient ThreadData Z;
    public boolean a;
    public String a0;
    public boolean b;
    @Nullable
    public String b0;
    public boolean c;
    @Nullable
    public String c0;
    public boolean d;
    @Nullable
    public String d0;
    public boolean e;
    public ForumData e0;
    public boolean f;
    public int f0;
    public boolean g;
    public WeakReference<Bitmap> g0;
    public boolean h;
    public Bundle h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public boolean j0;
    public boolean k;
    public boolean k0;
    public boolean l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public boolean n;
    public int n0;
    public boolean o;
    public String o0;
    public String p;
    public boolean p0;
    public int q;
    public boolean q0;
    public String r;
    public boolean r0;
    public String s;
    public String s0;
    public String t;
    public int t0;
    public String u;
    public String u0;
    public String v;
    public String v0;
    public String w;
    public String w0;
    public Uri x;
    public String x0;
    public String y;
    public String y0;
    public String z;
    public JSONArray z0;

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
        F0 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
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
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.h = false;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = "";
        this.A = 0;
        this.G = 0;
        this.H = 3;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.T = -1L;
        this.W = 0L;
        this.f0 = 0;
        this.i0 = false;
        this.j0 = true;
        this.k0 = false;
        this.l0 = true;
        this.m0 = true;
        this.n0 = 0;
        this.q0 = true;
        this.r0 = false;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.D = null;
        this.g0 = null;
        this.E = null;
        this.s = null;
        this.z = null;
        this.B = null;
        this.A = 0;
    }

    public List<Integer> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.B0 : (List) invokeV.objValue;
    }

    public byte[] b() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WeakReference<Bitmap> weakReference = this.g0;
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
            WeakReference<Bitmap> weakReference = this.g0;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i0 : invokeV.booleanValue;
    }

    public Bundle e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h0 : (Bundle) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.O;
            return i == 7 || i == 8 || i == 5 || i == 6;
        }
        return invokeV.booleanValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.g0 == null) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (FileHelper.checkSD()) {
                    File file = new File(F0);
                    if (file.exists()) {
                        file.delete();
                    }
                    File parentFile = file.getParentFile();
                    if (parentFile != null && !parentFile.exists()) {
                        parentFile.mkdirs();
                    }
                    byte[] b = b();
                    if (b != null) {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            fileOutputStream2.write(b);
                            fileOutputStream2.close();
                            this.x = Uri.fromFile(file);
                            this.g0 = null;
                            try {
                                fileOutputStream2.close();
                            } catch (IOException e) {
                                BdLog.e(e.toString());
                            }
                        } catch (Exception e2) {
                            e = e2;
                            fileOutputStream = fileOutputStream2;
                            BdLog.e(e.toString());
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e3) {
                                    BdLog.e(e3.toString());
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream = fileOutputStream2;
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
            } catch (Exception e5) {
                e = e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void h(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.B0 = list;
        }
    }

    public void i(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bitmap) == null) {
            this.g0 = new WeakReference<>(bitmap);
        }
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.i0 = z;
        }
    }

    public void k(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bundle) == null) {
            this.h0 = bundle;
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
                    forwardInfo.showText = threadData.originalThreadData.e();
                    OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
                    forwardInfo.showPicUrl = originalThreadInfo.c;
                    forwardInfo.showType = originalThreadInfo.a;
                    forwardInfo.originalBaijiahaoData = originalThreadInfo.p;
                    forwardInfo.originalTid = originalThreadInfo.f;
                    if (i == 1) {
                        if (postData != null && postData.P() != null) {
                            str = postData.P().toString();
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
                    if (i == 1 && postData != null && li.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && postData.s() != null) {
                        forwardInfo.transmitThreadAuthorNameShow = postData.s().getName_show();
                    }
                    if (i == 2 && li.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                        forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                    }
                } else {
                    if (threadData.getBaijiahaoData() != null && !TextUtils.isEmpty(threadData.getBaijiahaoData().oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    OriginalThreadInfo m = OriginalThreadInfo.m(threadData);
                    if (m != null) {
                        forwardInfo.showText = m.e();
                        forwardInfo.showPicUrl = m.c;
                        forwardInfo.showType = m.a;
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
