package com.baidu.tieba;

import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.PreLoadImageInfo;
import com.baidu.tbadk.core.util.PreLoadImageProvider;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public abstract class eh6 extends jw4 implements PreLoadImageProvider {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId D;
    public static final BdUniqueId E;
    public static final BdUniqueId F;
    public static final BdUniqueId G;
    public static final BdUniqueId H;
    public static final BdUniqueId I;
    public static final BdUniqueId J;
    public static final BdUniqueId K;
    public static final BdUniqueId L;
    public static final BdUniqueId M;
    public static final BdUniqueId N;
    public static final ArrayList<BdUniqueId> O;
    public static final ArrayList<BdUniqueId> P;
    public static BdUniqueId[][] Q;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public int C;
    public ThreadData a;
    public String b;
    public String c;
    public int d;
    public String e;
    public int f;
    public String g;
    public String h;
    public Integer i;
    public int j;
    public int k;
    public int l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public void H(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
        }
    }

    public StatisticItem d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            return null;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jw4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public StatisticItem s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947734390, "Lcom/baidu/tieba/eh6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947734390, "Lcom/baidu/tieba/eh6;");
                return;
            }
        }
        D = BdUniqueId.gen();
        E = BdUniqueId.gen();
        F = BdUniqueId.gen();
        G = BdUniqueId.gen();
        H = BdUniqueId.gen();
        I = BdUniqueId.gen();
        J = BdUniqueId.gen();
        K = BdUniqueId.gen();
        L = BdUniqueId.gen();
        M = BdUniqueId.gen();
        N = BdUniqueId.gen();
        O = new ArrayList<>();
        P = new ArrayList<>();
        O.add(D);
        O.add(E);
        P.add(I);
        P.add(F);
        P.add(H);
        P.add(G);
        Q = (BdUniqueId[][]) Array.newInstance(BdUniqueId.class, O.size(), P.size());
        for (int i = 0; i < O.size(); i++) {
            for (int i2 = 0; i2 < P.size(); i2++) {
                Q[i][i2] = BdUniqueId.gen();
            }
        }
    }

    public eh6() {
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
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = 0;
    }

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.h = str;
        }
    }

    public void D(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, num) == null) {
            this.i = num;
        }
    }

    public void E(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.d = i;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.c = str;
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.l = i;
        }
    }

    public void I(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.b = str;
        }
    }

    public StatisticItem l(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            return o(str, false);
        }
        return (StatisticItem) invokeL.objValue;
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.e = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData != null) {
                return threadData.getImages();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    public Integer h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.i;
        }
        return (Integer) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (this.l == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.jw4
    public hy4 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (getThreadData() != null && (sparseArray = this.feedBackReasonMap) != null && sparseArray.size() > 0) {
                hy4 hy4Var = new hy4();
                hy4Var.o(getThreadData().getTid());
                hy4Var.k(getThreadData().getFid());
                hy4Var.n(getThreadData().getNid());
                hy4Var.j(this.feedBackReasonMap);
                hy4Var.k = this.b;
                hy4Var.l = this.c;
                hy4Var.m = this.h;
                hy4Var.n = getThreadData().threadType;
                return hy4Var;
            }
            return null;
        }
        return (hy4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.jw4
    public String getPbInputLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.c + "#" + this.d + "#" + this.e;
        }
        return (String) invokeV.objValue;
    }

    public final int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ThreadData threadData = getThreadData();
            int i = 0;
            if (threadData == null) {
                return 0;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            if (medias != null) {
                Iterator<MediaData> it = medias.iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        i++;
                    }
                }
            }
            return i;
        }
        return invokeV.intValue;
    }

    public StatisticItem m(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048597, this, str, i)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData == null) {
                return null;
            }
            StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(threadData.getFid())).param("tid", String.valueOf(threadData.getTid())).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_param1", w()).param("obj_source", k()).param("obj_locate", i()).param("obj_name", c()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, jg6.e());
            if (i == 0) {
                param.param("obj_type", q());
            } else {
                param.param("obj_type", i);
            }
            param.param("obj_id", e());
            return param;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem o(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048598, this, str, z)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData != null && str.length() != 0) {
                int i = 1;
                StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(threadData.getFid())).param("fname", threadData.getForum_name()).param("tid", String.valueOf(threadData.getTid())).param("nid", threadData.getNid()).param("obj_id", e()).param("obj_param1", w()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_source", k()).param("obj_locate", i()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, jg6.e()).param("ab_tag", c()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0);
                if (!z) {
                    param.param("obj_type", q());
                } else {
                    if (threadData.middle_page_num > 0) {
                        param.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
                    } else {
                        param.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
                    }
                    param.param(TiebaStatic.Params.IS_VERTICAL, h().intValue());
                }
                if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().a0() != null && threadData.getTopAgreePost().a0().S() != null && threadData.getTopAgreePost().a0().S().size() > 0) {
                    if (threadData.getTopAgreePost().N) {
                        i = 2;
                    }
                    param.param(TiebaStatic.Params.OBJ_TO, i);
                }
                return param;
            }
            return null;
        }
        return (StatisticItem) invokeLZ.objValue;
    }
}
