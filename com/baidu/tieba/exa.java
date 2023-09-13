package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.NegativeFeedBackData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.ThreadInfo;
/* loaded from: classes5.dex */
public class exa extends b15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<cn> a;
    public int b;
    public int c;
    public String d;
    public String e;

    @Override // com.baidu.tieba.b15
    public NegativeFeedBackData getNegFeedBackData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return null;
        }
        return (NegativeFeedBackData) invokeV.objValue;
    }

    @Override // com.baidu.tieba.b15
    public ThreadData getThreadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ThreadData) invokeV.objValue;
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
        }
    }

    public exa() {
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
        this.b = 0;
        this.c = 0;
        this.d = "";
        this.e = "";
        this.a = new ArrayList();
    }

    public static boolean c(axa axaVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65537, null, axaVar, z)) == null) {
            if (axaVar != null && axaVar.b() != null) {
                String str = "key_recommand_collect_cover_freq";
                String str2 = "key_recommand_collect_cover_show_time";
                if (z) {
                    str2 = "key_recommand_collect_cover_show_time_frs";
                    str = "key_recommand_collect_cover_freq_frs";
                }
                String[] split = SharedPrefHelper.getInstance().getString(str, "0-0-0").split("-");
                if (split.length == 3) {
                    int parseInt = Integer.parseInt(split[0]);
                    int parseInt2 = Integer.parseInt(split[1]);
                    int parseInt3 = Integer.parseInt(split[2]);
                    long j = parseInt;
                    if (j == axaVar.b().c().longValue()) {
                        long j2 = parseInt2;
                        if (j2 == axaVar.b().a().longValue() && parseInt3 == axaVar.b().b().longValue()) {
                            int i = SharedPrefHelper.getInstance().getInt(str2, 0);
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            if (i < parseInt3 && currentTimeMillis >= j && currentTimeMillis <= j2) {
                                SharedPrefHelper.getInstance().putInt(str2, i + 1);
                                return true;
                            }
                        }
                    }
                    SharedPrefHelper.getInstance().putString(str, axaVar.b().c() + "-" + axaVar.b().a() + "-" + axaVar.b().b());
                    SharedPrefHelper.getInstance().putInt(str2, 0);
                    return true;
                }
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public static boolean i(bxa bxaVar, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, null, bxaVar, z)) == null) {
            if (TbadkCoreApplication.isLogin() && bxaVar != null && (ListUtils.isNotEmpty(bxaVar.d()) || c(bxaVar.c(), z))) {
                return true;
            }
            return false;
        }
        return invokeLZ.booleanValue;
    }

    public void d(bxa bxaVar) {
        String b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, bxaVar) != null) || bxaVar == null) {
            return;
        }
        this.a.clear();
        if (bxaVar.c() != null && bxaVar.c().c() != null && !TextUtils.isEmpty(bxaVar.c().c().a())) {
            b = bxaVar.c().c().a();
        } else {
            b = bxaVar.b();
        }
        if (StringUtils.isNotNull(b)) {
            hxa hxaVar = new hxa();
            hxaVar.b(b);
            this.a.add(hxaVar);
        }
        if (bxaVar.c() != null) {
            if (bxaVar.c().a() != null) {
                bxaVar.c().a();
            }
            if (bxaVar.c().c() != null) {
                fxa fxaVar = new fxa();
                fxaVar.e(bxaVar.c().c());
                fxaVar.h(this.c);
                fxaVar.f(this.d);
                fxaVar.g(this.e);
                this.a.add(fxaVar);
                if (ListUtils.isNotEmpty(bxaVar.c().c().l())) {
                    gxa gxaVar = new gxa();
                    gxaVar.b(bxaVar.c().c(), this.c, this.d, this.e);
                    this.a.add(gxaVar);
                }
                if (ListUtils.isNotEmpty(bxaVar.c().c().o())) {
                    for (ThreadInfo threadInfo : bxaVar.c().c().o()) {
                        ThreadData threadData = new ThreadData();
                        threadData.setNeedCheckNTitle(false);
                        threadData.parserProtobuf(threadInfo);
                        if (threadData.getTitleText() != null && StringUtils.isNotNull(bxaVar.c().c().b())) {
                            ThreadCardUtils.setUniversalPrefix(threadData.getTitleText(), bxaVar.c().c().b(), R.color.CAM_X0302, R.color.CAM_X0101);
                        }
                        this.a.add(threadData);
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (ListUtils.isNotEmpty(bxaVar.d())) {
            for (int i = 0; i < bxaVar.d().size(); i++) {
                ThreadData threadData2 = new ThreadData();
                threadData2.setNeedCheckNTitle(false);
                threadData2.parserProtobuf(bxaVar.d().get(i));
                this.a.add(threadData2);
            }
        }
        bxaVar.a();
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.d = str;
        }
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.e = str;
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.c = i;
        }
    }

    public List<cn> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (List) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.cn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return cq6.A0;
        }
        return (BdUniqueId) invokeV.objValue;
    }
}
