package com.baidu.tieba;

import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ai9 extends za5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean p;
    public boolean q;
    public int r;
    public TbPageContext s;
    public String t;
    public int u;
    public ThreadData v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai9(TbPageContext tbPageContext, ya5 ya5Var, int i) {
        super(tbPageContext, ya5Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, ya5Var, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ya5) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = false;
        this.q = false;
        this.r = 0;
        this.r = i;
        this.s = tbPageContext;
        if (i == 1) {
            super.k("4");
        } else if (i == 3) {
            super.k("5");
        } else if (i != 4 && i != 5 && i != 6) {
            super.k("0");
        } else {
            super.k("4");
        }
    }

    @Override // com.baidu.tieba.za5, android.view.View.OnClickListener
    public void onClick(View view2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || view2 == null || view2.getAlpha() < 0.4d) {
            return;
        }
        xa5 xa5Var = this.a;
        if (xa5Var != null) {
            str = xa5Var.getUserId();
        } else {
            str = "";
        }
        TiebaStatic.log(new StatisticItem("c12408").param("obj_source", s()).param("obj_id", str).param("tid", this.t));
        int i = this.r;
        int i2 = 8;
        int i3 = 0;
        if (i == 1) {
            i2 = 3;
        } else if (i == 3) {
            i2 = 2;
        } else if (i == 5) {
            i2 = 5;
        } else if (i == 7) {
            i2 = 7;
        } else if (i == 6) {
            i2 = 6;
        } else if (i == 4) {
            i2 = 4;
        } else if (i != 8) {
            i2 = 0;
        }
        StatisticItem statisticItem = new StatisticItem("c12507");
        statisticItem.param("obj_locate", i2);
        statisticItem.param("obj_id", str);
        statisticItem.param("tid", this.t);
        statisticItem.param("obj_param1", this.u);
        if (!bi.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            statisticItem.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
        }
        TiebaStatic.log(statisticItem);
        StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_CONCERN_BTN_CLICK);
        statisticItem2.param("obj_id", str);
        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
        statisticItem2.param("tid", this.t);
        ThreadData threadData = this.v;
        if (threadData != null) {
            statisticItem2.param("nid", threadData.getNid());
            if (this.v.getBaijiahaoData() != null && !bi.isEmpty(this.v.getBaijiahaoData().oriUgcVid)) {
                statisticItem2.param(TiebaStatic.Params.OBJ_PARAM6, this.v.getBaijiahaoData().oriUgcVid);
            }
            statisticItem2.param("recom_source", this.v.mRecomSource);
            statisticItem2.param("ab_tag", this.v.mRecomAbTag);
            statisticItem2.param("weight", this.v.mRecomWeight);
            statisticItem2.param("extra", this.v.mRecomExtra);
        }
        TbPageContext tbPageContext = this.s;
        if (tbPageContext != null) {
            gr5.e(tbPageContext.getPageActivity(), statisticItem2);
        }
        TiebaStatic.log(statisticItem2);
        super.onClick(view2);
        if (this.p && this.a != null) {
            TiebaStatic.log(new StatisticItem("c11924").param("obj_id", this.a.getUserId()));
        }
        if (this.q && this.a != null) {
            int i4 = this.r;
            if (i4 == 1) {
                i3 = 1;
            } else if (i4 == 2) {
                i3 = 2;
            }
            TiebaStatic.log(new StatisticItem("c12150").param("obj_locate", i3).param("obj_id", this.a.getUserId()));
        }
    }

    public final int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            String fromPageKey = UtilHelper.getFromPageKey(this.s);
            if (fromPageKey == null) {
                return 3;
            }
            if (fromPageKey.equals("a038")) {
                return 1;
            }
            if (fromPageKey.equals("a002")) {
                return 2;
            }
            if (fromPageKey.equals("a006")) {
                return 3;
            }
            if (fromPageKey.equals("a011")) {
                return 4;
            }
            if (fromPageKey.equals("a033")) {
                return 5;
            }
            if (fromPageKey.equals("a010")) {
                return 6;
            }
            return 7;
        }
        return invokeV.intValue;
    }

    public void t(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) {
            this.v = threadData;
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.u = i;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.t = str;
            n(str);
        }
    }
}
