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
/* loaded from: classes3.dex */
public abstract class c26 extends lq4 implements PreLoadImageProvider {
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

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622914, "Lcom/baidu/tieba/c26;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622914, "Lcom/baidu/tieba/c26;");
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

    public c26() {
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

    public StatisticItem A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public StatisticItem C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.l == 1 : invokeV.booleanValue;
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.e = str;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.h = str;
        }
    }

    public void H(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, num) == null) {
            this.i = num;
        }
    }

    public void I(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.d = i;
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.c = str;
        }
    }

    public void K(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.l = i;
        }
    }

    public void L(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
        }
    }

    public void M(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.b = str;
        }
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public StatisticItem f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            return null;
        }
        return (StatisticItem) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.core.util.PreLoadImageProvider
    public ArrayList<PreLoadImageInfo> getImages() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData != null) {
                return threadData.getImages();
            }
            return null;
        }
        return (ArrayList) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lq4
    public is4 getNegFeedBackData() {
        InterceptResult invokeV;
        SparseArray<String> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            if (getThreadData() == null || (sparseArray = this.feedBackReasonMap) == null || sparseArray.size() <= 0) {
                return null;
            }
            is4 is4Var = new is4();
            is4Var.o(getThreadData().getTid());
            is4Var.k(getThreadData().getFid());
            is4Var.n(getThreadData().getNid());
            is4Var.j(this.feedBackReasonMap);
            is4Var.k = this.b;
            is4Var.l = this.c;
            is4Var.m = this.h;
            is4Var.n = getThreadData().threadType;
            return is4Var;
        }
        return (is4) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lq4
    public String getPbInputLocate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.c + "#" + this.d + "#" + this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.lq4
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean isVideoThreadType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public StatisticItem j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return null;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public Integer l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.i : (Integer) invokeV.objValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.d : invokeV.intValue;
    }

    public String r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.c : (String) invokeV.objValue;
    }

    public StatisticItem s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? w(str, false) : (StatisticItem) invokeL.objValue;
    }

    public StatisticItem t(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048603, this, str, i)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData == null) {
                return null;
            }
            StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(threadData.getFid())).param("tid", String.valueOf(threadData.getTid())).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_param1", D()).param("obj_source", r()).param("obj_locate", n()).param("obj_name", c()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, g16.e());
            if (i == 0) {
                param.param("obj_type", z());
            } else {
                param.param("obj_type", i);
            }
            param.param("obj_id", h());
            return param;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem w(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048604, this, str, z)) == null) {
            ThreadData threadData = getThreadData();
            if (threadData == null || str.length() == 0) {
                return null;
            }
            StatisticItem param = new StatisticItem(str).param("fid", String.valueOf(threadData.getFid())).param("fname", threadData.getForum_name()).param("tid", String.valueOf(threadData.getTid())).param("nid", threadData.getNid()).param("obj_id", h()).param("obj_param1", D()).param(TiebaStatic.Params.OBJ_PARAM2, 1).param("obj_source", r()).param("obj_locate", n()).param("uid", TbadkCoreApplication.getCurrentAccount()).param(TiebaStatic.Params.OBJ_PARAM3, g16.e()).param("ab_tag", c()).param(TiebaStatic.Params.IS_ZP, threadData.isWorksInfo() ? 1 : 0);
            if (!z) {
                param.param("obj_type", z());
            } else {
                if (threadData.middle_page_num > 0) {
                    param.param(TiebaStatic.Params.MID_PAGE_FLAG, 1);
                } else {
                    param.param(TiebaStatic.Params.MID_PAGE_FLAG, 0);
                }
                param.param(TiebaStatic.Params.IS_VERTICAL, l().intValue());
            }
            if (threadData.getTopAgreePost() != null && threadData.getTopAgreePost().W() != null && threadData.getTopAgreePost().W().B() != null && threadData.getTopAgreePost().W().B().size() > 0) {
                param.param(TiebaStatic.Params.OBJ_TO, threadData.getTopAgreePost().L ? 2 : 1);
            }
            return param;
        }
        return (StatisticItem) invokeLZ.objValue;
    }

    public final int z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
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
}
