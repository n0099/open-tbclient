package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadlinesCardView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class gx extends ww {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HeadlinesCardView h;
    public jw4 i;
    public int j;
    public sy k;

    public void B(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements sy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx a;

        public a(gx gxVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gxVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gxVar;
        }

        @Override // com.baidu.tieba.sy
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.i != null && this.a.i.getThreadData() != null) {
                ThreadData threadData = this.a.i.getThreadData();
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", threadData.getTid()).param("fid", threadData.getFid()).param("obj_locate", this.a.j).param("obj_param1", 2));
            }
        }

        @Override // com.baidu.tieba.sy
        public void b() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.a.i != null && this.a.i.getThreadData() != null) {
                ThreadData threadData = this.a.i.getThreadData();
                TiebaStatic.log(new StatisticItem("c15023").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", threadData.getTid()).param("fid", threadData.getFid()).param("obj_locate", this.a.j).param("obj_param1", 1));
            }
        }

        @Override // com.baidu.tieba.sy
        public void onShow() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.a.i != null && this.a.i.getThreadData() != null) {
                ThreadData threadData = this.a.i.getThreadData();
                TiebaStatic.log(new StatisticItem("c15022").param("uid", TbadkCoreApplication.getCurrentAccount()).param("tid", threadData.getTid()).param("fid", threadData.getFid()).param("obj_locate", this.a.j));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gx(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        HeadlinesCardView headlinesCardView = new HeadlinesCardView(context);
        this.h = headlinesCardView;
        headlinesCardView.setOnStatListener(this.k);
        v(UtilHelper.getDimenPixelSize(R.dimen.tbds36));
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.j = i;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hx
    /* renamed from: z */
    public void a(jw4 jw4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, jw4Var) == null) {
            this.i = jw4Var;
            if (y(jw4Var)) {
                this.h.setVisibility(0);
                this.h.a(jw4Var);
                return;
            }
            this.h.setVisibility(8);
        }
    }

    @Override // com.baidu.tieba.pw
    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.baidu.tieba.ix
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.h.i(i);
        }
    }

    public final boolean y(jw4 jw4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, jw4Var)) == null) {
            if (jw4Var != null && jw4Var.getThreadData() != null && jw4Var.getThreadData().getTaskInfoData() != null && jw4Var.getThreadData().getTaskInfoData().e() != null && jw4Var.getThreadData().getTaskInfoData().h() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
