package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.Error;
import tbclient.Page;
import tbclient.PbFloor.DataRes;
import tbclient.SubPostList;
/* loaded from: classes3.dex */
public class aj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public bc9 b;
    public ArrayList<bc9> c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public AntiData i;
    public ThreadData j;
    public boolean k;
    public boolean l;
    public Error m;

    public aj8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = 20;
        this.h = -1;
        this.k = false;
        this.b = null;
        this.c = new ArrayList<>();
        this.d = 1;
    }

    public static aj8 w(DataRes dataRes) {
        InterceptResult invokeL;
        int intValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, dataRes)) == null) {
            if (dataRes == null) {
                return null;
            }
            try {
                aj8 aj8Var = new aj8();
                AntiData antiData = new AntiData();
                antiData.parserProtobuf(dataRes.anti);
                aj8Var.x(antiData);
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(dataRes.thread);
                aj8Var.E(threadData);
                ForumData forumData = new ForumData();
                forumData.parserProtobuf(dataRes.forum);
                aj8Var.A(forumData);
                bc9 bc9Var = new bc9();
                bc9Var.M0(forumData.isBrandForum);
                bc9Var.B0(dataRes.post, threadData);
                aj8Var.C(bc9Var);
                List<SubPostList> list = dataRes.subpost_list;
                int size = list.size();
                ArrayList<bc9> arrayList = new ArrayList<>();
                int E = bc9Var.E();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    bc9 bc9Var2 = new bc9();
                    bc9Var2.M0(forumData.isBrandForum);
                    bc9Var2.z0(list.get(i), false, threadData, E);
                    if (bc9Var2.o() != null && bc9Var2.o().baijiahaoData == null && threadData.getBaijiahaoData() != null) {
                        bc9Var2.o().baijiahaoData = threadData.getBaijiahaoData();
                    }
                    arrayList.add(bc9Var2);
                }
                aj8Var.D(arrayList);
                AntiData antiData2 = new AntiData();
                antiData2.parserProtobuf(dataRes.anti);
                aj8Var.x(antiData2);
                Page page = dataRes.page;
                if (page != null) {
                    int intValue2 = page.total_page.intValue();
                    if (page.page_size.intValue() == 0) {
                        intValue = 20;
                    } else {
                        intValue = page.page_size.intValue();
                    }
                    int intValue3 = page.current_page.intValue();
                    int intValue4 = page.total_count.intValue();
                    aj8Var.z(intValue3);
                    aj8Var.B(intValue);
                    aj8Var.F(intValue4);
                    aj8Var.G(intValue2);
                }
                if (dataRes.is_black_white.intValue() == 1) {
                    z = true;
                }
                aj8Var.y(z);
                return aj8Var;
            } catch (Exception e) {
                BdLog.detailException(e);
                return null;
            }
        }
        return (aj8) invokeL.objValue;
    }

    public void A(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void B(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && i != 0) {
            this.f = i;
        }
    }

    public void C(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bc9Var) == null) {
            this.b = bc9Var;
        }
    }

    public void D(ArrayList<bc9> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.c = arrayList;
        }
    }

    public void E(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, threadData) == null) {
            this.j = threadData;
        }
    }

    public void F(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.e = i;
        }
    }

    public void G(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d = i;
        }
    }

    public void x(AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, antiData) == null) {
            this.i = antiData;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.l = z;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.g = i;
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.h;
            if (i < 0) {
                this.h = this.g;
                return;
            }
            int i2 = this.g;
            if (i > i2) {
                this.h = i2;
            }
        }
    }

    public AntiData a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.i;
        }
        return (AntiData) invokeV.objValue;
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
    }

    public Error c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.m;
        }
        return (Error) invokeV.objValue;
    }

    public ForumData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.a;
        }
        return (ForumData) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f;
        }
        return invokeV.intValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.h;
        }
        return invokeV.intValue;
    }

    public bc9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return (bc9) invokeV.objValue;
    }

    public int j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (this.h == -1) {
                this.h = this.g;
            }
            return this.h;
        }
        return invokeV.intValue;
    }

    public ArrayList<bc9> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.c;
        }
        return (ArrayList) invokeV.objValue;
    }

    public ThreadData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.j;
        }
        return (ThreadData) invokeV.objValue;
    }

    public int m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.e;
        }
        return invokeV.intValue;
    }

    public int n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.g < this.d) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            ThreadData threadData = this.j;
            if (threadData != null && threadData.isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.l;
        }
        return invokeV.booleanValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ThreadData threadData = this.j;
            if (threadData != null && this.b != null && threadData.getAuthor() != null && this.j.getAuthor().getUserId() != null && this.b.r() != null && this.b.r().getUserId() != null && this.j.getAuthor().getUserId().equals(this.b.r().getUserId())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void r(aj8 aj8Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048601, this, aj8Var, z) != null) || aj8Var == null) {
            return;
        }
        x(aj8Var.a());
        A(aj8Var.d());
        C(aj8Var.i());
        E(aj8Var.l());
        y(aj8Var.q());
        if (aj8Var.k() != null) {
            z(aj8Var.b());
            B(aj8Var.g());
            F(aj8Var.m());
            G(aj8Var.n());
        }
        int size = this.c.size();
        if (z && size % this.f != 0) {
            for (int i = 0; i < size % this.f; i++) {
                ArrayList<bc9> arrayList = this.c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.c.addAll(aj8Var.k());
    }

    public void t(aj8 aj8Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048603, this, aj8Var, z) != null) || aj8Var == null) {
            return;
        }
        x(aj8Var.a());
        A(aj8Var.d());
        C(aj8Var.i());
        E(aj8Var.l());
        y(aj8Var.q());
        if (aj8Var.k() != null && aj8Var.k().size() > 0) {
            z(aj8Var.b());
            B(aj8Var.g());
            F(aj8Var.m());
            G(aj8Var.n());
        }
        int size = this.c.size();
        if (z && size % this.f != 0) {
            for (int i = 0; i < size % this.f; i++) {
                ArrayList<bc9> arrayList = this.c;
                arrayList.remove(arrayList.size() - 1);
            }
        }
        this.c.addAll(aj8Var.k());
        H();
    }

    public void s(aj8 aj8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, aj8Var) != null) || aj8Var == null) {
            return;
        }
        x(aj8Var.a());
        A(aj8Var.d());
        C(aj8Var.i());
        E(aj8Var.l());
        y(aj8Var.q());
        if (aj8Var.k() != null && aj8Var.k().size() > 0) {
            z(aj8Var.b());
            B(aj8Var.g());
            F(aj8Var.m());
            G(aj8Var.n());
            int i = this.f;
            int size = (this.g - (((aj8Var.k().size() - 1) + i) / i)) + 1;
            this.h = size;
            if (size < 0) {
                this.h = 0;
            }
        }
        this.c.addAll(aj8Var.k());
    }

    public void u(aj8 aj8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048604, this, aj8Var, z) == null) {
            v(aj8Var, z);
        }
    }

    public void v(aj8 aj8Var, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048605, this, aj8Var, z) != null) || aj8Var == null) {
            return;
        }
        x(aj8Var.a());
        this.h = aj8Var.b();
        A(aj8Var.d());
        B(aj8Var.g());
        E(aj8Var.l());
        F(aj8Var.m());
        G(aj8Var.n());
        y(aj8Var.q());
        this.c.addAll(0, aj8Var.k());
    }
}
