package com.baidu.tbadk.coreExtra.share;

import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.ShareIMCommonCardData;
import com.baidu.tieba.jy9;
import com.baidu.tieba.ui;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ShareItem {
    public static /* synthetic */ Interceptable $ic;
    public static final String Q0;
    public transient /* synthetic */ FieldHolder $fh;
    public String A;
    public String A0;
    public String B;
    public String B0;
    public int C;
    public String C0;
    public String D;
    public String D0;
    public Bundle E;
    public String E0;
    public Location F;
    public JSONArray F0;
    public String G;
    public JSONObject G0;
    public String H;
    public List<Integer> H0;
    public int I;
    public String I0;
    public int J;
    public String J0;
    public int K;
    public Uri K0;
    public int L;
    public GroupInfoData L0;
    public int M;
    public boolean M0;
    public String N;
    public int N0;
    public String O;
    public String O0;
    public String P;
    public ShareIMCommonCardData P0;
    public String Q;
    public int R;
    public String S;

    /* renamed from: T  reason: collision with root package name */
    public String f1080T;
    public String U;
    public String V;
    public long W;
    public String X;
    public String Y;
    public String Z;
    public boolean a;
    public OriginalThreadInfo.ShareInfo a0;
    public boolean b;
    public long b0;
    public boolean c;
    public String c0;
    public boolean d;
    public ForwardInfo d0;
    public boolean e;
    public transient ThreadData e0;
    public boolean f;
    public String f0;
    public boolean g;
    @Nullable
    public String g0;
    public boolean h;
    @Nullable
    public String h0;
    public boolean i;
    @Nullable
    public String i0;
    public boolean j;
    public ForumData j0;
    public boolean k;
    public int k0;
    public boolean l;
    public WeakReference<Bitmap> l0;
    public boolean m;
    public Bundle m0;
    public boolean n;
    public boolean n0;
    public boolean o;
    public boolean o0;
    public boolean p;
    public boolean p0;
    public boolean q;
    public boolean q0;
    public String r;
    public boolean r0;
    public int s;
    public int s0;
    public String t;
    public String t0;
    public String u;
    public boolean u0;
    public String v;
    public boolean v0;
    public String w;
    public boolean w0;
    public String x;
    public String x0;
    public String y;
    public int y0;
    public Uri z;
    public String z0;

    /* loaded from: classes4.dex */
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadData)) == null) {
                return generateForwardInfo(threadData, 0);
            }
            return (ForwardInfo) invokeL.objValue;
        }

        public static ForwardInfo generateForwardInfo(ThreadData threadData, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, threadData, i)) == null) {
                return generateForwardInfo(threadData, i, null);
            }
            return (ForwardInfo) invokeLI.objValue;
        }

        public static ForwardInfo generateForwardInfo(ThreadData threadData, int i, jy9 jy9Var) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(InputDeviceCompat.SOURCE_TRACKBALL, null, threadData, i, jy9Var)) == null) {
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
                        if (jy9Var != null && jy9Var.a0() != null) {
                            str = jy9Var.a0().toString();
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
                    if (i == 1 && jy9Var != null && ui.isEmpty(forwardInfo.transmitThreadAuthorNameShow) && jy9Var.p() != null) {
                        forwardInfo.transmitThreadAuthorNameShow = jy9Var.p().getName_show();
                    }
                    if (i == 2 && ui.isEmpty(forwardInfo.transmitThreadAuthorNameShow)) {
                        forwardInfo.transmitThreadAuthorNameShow = TbadkCoreApplication.getCurrentAccountNameShow();
                    }
                } else {
                    if (threadData.getBaijiahaoData() != null && !TextUtils.isEmpty(threadData.getBaijiahaoData().oriUgcNid)) {
                        forwardInfo.isDynamic = true;
                    }
                    OriginalThreadInfo n = OriginalThreadInfo.n(threadData);
                    if (n != null) {
                        forwardInfo.showText = n.e();
                        forwardInfo.showPicUrl = n.c;
                        forwardInfo.showType = n.a;
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
        Q0 = FileHelper.EXTERNAL_STORAGE_DIRECTORY + "/" + TbConfig.getTempDirName() + "/share/SHARED_IMAGE";
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
        this.p = false;
        this.q = false;
        this.r = "";
        this.C = 0;
        this.I = 0;
        this.J = 3;
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.W = -1L;
        this.b0 = 0L;
        this.k0 = 0;
        this.n0 = false;
        this.o0 = true;
        this.p0 = false;
        this.q0 = true;
        this.r0 = true;
        this.s0 = 0;
        this.v0 = true;
        this.w0 = false;
        this.M0 = false;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.F = null;
        this.l0 = null;
        this.G = null;
        this.u = null;
        this.B = null;
        this.D = null;
        this.C = 0;
        this.L0 = null;
        this.P0 = null;
        this.M0 = false;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && this.l0 != null) {
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    if (FileHelper.checkSD()) {
                        File file = new File(Q0);
                        if (file.exists()) {
                            file.delete();
                        }
                        File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        byte[] c = c();
                        if (c != null) {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                fileOutputStream2.write(c);
                                fileOutputStream2.close();
                                this.z = Uri.fromFile(file);
                                this.l0 = null;
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
    }

    public static ShareItem a(@NonNull JSONObject jSONObject, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, jSONObject, z)) == null) {
            ShareItem shareItem = new ShareItem();
            String optString = jSONObject.optString("title");
            String optString2 = jSONObject.optString("desc");
            String optString3 = jSONObject.optString("img");
            String optString4 = jSONObject.optString("url");
            String optString5 = jSONObject.optString("topic");
            String optString6 = jSONObject.optString("wbtitle");
            String optString7 = jSONObject.optString("wbcontent");
            shareItem.v = optString;
            shareItem.x = optString4;
            shareItem.w = optString2;
            if (!TextUtils.isEmpty(optString3)) {
                shareItem.z = Uri.parse(optString3);
            }
            shareItem.f1080T = optString5;
            shareItem.U = optString6;
            shareItem.V = optString7;
            shareItem.k0 = jSONObject.optInt("shareimg");
            shareItem.s0 = jSONObject.optInt("weixin_disable");
            String optString8 = jSONObject.optString("extdata");
            if (!StringUtils.isNull(optString8)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString8);
                    String optString9 = jSONObject2.optString("activityid");
                    String optString10 = jSONObject2.optString("missionid");
                    if (!StringUtils.isNull(optString9) && !StringUtils.isNull(optString10)) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(optString9, optString10);
                        shareItem.X = jSONObject3.toString();
                    }
                } catch (JSONException unused) {
                }
            }
            shareItem.L0 = GroupInfoData.fromJsonH5(jSONObject);
            shareItem.P0 = ShareIMCommonCardData.fromJsonH5(jSONObject);
            return shareItem;
        }
        return (ShareItem) invokeLZ.objValue;
    }

    public List<Integer> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.H0;
        }
        return (List) invokeV.objValue;
    }

    public Bitmap d() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WeakReference<Bitmap> weakReference = this.l0;
            if (weakReference != null && (bitmap = weakReference.get()) != null && !bitmap.isRecycled()) {
                return bitmap;
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.n0;
        }
        return invokeV.booleanValue;
    }

    @Nullable
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.O0;
        }
        return (String) invokeV.objValue;
    }

    public Bundle g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m0;
        }
        return (Bundle) invokeV.objValue;
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if ((j() || i() || k()) && !this.q) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return ShareIMCommonCardData.isValidAlbum(this.P0);
        }
        return invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            GroupInfoData groupInfoData = this.L0;
            if (groupInfoData != null && groupInfoData.getGroupId() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return ShareIMCommonCardData.isValidTopic(this.P0);
        }
        return invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.R;
            if (i != 7 && i != 8 && i != 5 && i != 6 && i != 11 && !h()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public byte[] c() {
        InterceptResult invokeV;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WeakReference<Bitmap> weakReference = this.l0;
            byte[] bArr = null;
            if (weakReference != null && (bitmap = weakReference.get()) != null && !bitmap.isRecycled()) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                if (bitmap.compress(Bitmap.CompressFormat.PNG, 85, byteArrayOutputStream)) {
                    bArr = byteArrayOutputStream.toByteArray();
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
            }
            return bArr;
        }
        return (byte[]) invokeV.objValue;
    }

    public void n(List<Integer> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, list) == null) {
            this.H0 = list;
        }
    }

    public void o(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bitmap) == null) {
            this.l0 = new WeakReference<>(bitmap);
        }
    }

    public void p(@NonNull String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, str) == null) {
            this.O0 = str;
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.n0 = z;
        }
    }

    public void r(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, bundle) == null) {
            this.m0 = bundle;
        }
    }
}
