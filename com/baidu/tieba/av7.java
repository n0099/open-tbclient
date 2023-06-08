package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tieba.card.holder.CardViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class av7 extends in<vo6, CardViewHolder<qn6>> implements f56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId a;
    public TbPageContext<?> b;
    public qn6 c;
    public String d;
    public go6 e;

    /* loaded from: classes5.dex */
    public class a extends go6<vo6> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ av7 b;

        public a(av7 av7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {av7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = av7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.go6
        /* renamed from: d */
        public void a(View view2, vo6 vo6Var) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, vo6Var) == null) && view2 != null && this.b.c != null && this.b.c.h() != null && vo6Var != null && vo6Var.getThreadData() != null && !StringUtils.isNull(vo6Var.getThreadData().getTid())) {
                int i = 1;
                if (view2 == this.b.c.M()) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    i = 2;
                }
                xu7.b(view2, vo6Var, i);
                if (view2 != this.b.c.l.getCommentContainer() && view2 != this.b.c.m.getCommentContainer()) {
                    if (this.b.c.M() != null && view2.getId() == this.b.c.M().getId() && vo6Var.getThreadData() != null && vo6Var.getThreadData().getThreadAlaInfo() != null && vo6Var.getThreadData().getThreadAlaInfo().isLegalYYLiveData()) {
                        ThreadData threadData = vo6Var.getThreadData();
                        AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
                        int calculateLiveType = YYLiveUtil.calculateLiveType(vo6Var.getThreadData().getThreadAlaInfo());
                        String str = null;
                        if (!StringUtils.isNull(vo6Var.getThreadData().getThreadAlaInfo().appId)) {
                            str = vo6Var.getThreadData().getThreadAlaInfo().appId;
                        }
                        if (vo6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                            str = TiebaStatic.YYValues.YY_LIVE;
                        }
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_CLICK);
                        statisticItem.param("fid", threadData.getFid());
                        statisticItem.param("fname", threadData.getForum_name());
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("tid", threadData.getTid());
                        statisticItem.param("obj_type", threadData.getYYStaticticType());
                        statisticItem.param("obj_param1", calculateLiveType);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                        TiebaStaticHelper.addYYParam(statisticItem, threadAlaInfo.mYyExtData);
                        TiebaStatic.log(statisticItem);
                        return;
                    }
                    return;
                }
                StatisticItem statisticItem2 = new StatisticItem("c12942");
                statisticItem2.param("obj_locate", 7);
                statisticItem2.param("obj_type", 5);
                statisticItem2.param("tid", vo6Var.getThreadData().getTid());
                statisticItem2.param("nid", vo6Var.getThreadData().getNid());
                mr5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                if (findPageExtraByView != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                }
                if (TbPageExtraHelper.getPrePageKey() != null) {
                    statisticItem2.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                }
                TiebaStatic.log(statisticItem2);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public av7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new a(this);
        this.b = tbPageContext;
    }

    @Override // com.baidu.tieba.f56
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.d = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: t */
    public CardViewHolder<qn6> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, viewGroup)) == null) {
            qn6 qn6Var = new qn6(this.b, this.a);
            this.c = qn6Var;
            qn6Var.a0(true);
            BdUniqueId bdUniqueId = this.a;
            if (bdUniqueId != null) {
                this.c.Z(bdUniqueId);
            }
            return new CardViewHolder<>(this.c);
        }
        return (CardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.in
    /* renamed from: u */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, vo6 vo6Var, CardViewHolder<qn6> cardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), view2, viewGroup, vo6Var, cardViewHolder})) == null) {
            String str = null;
            if (vo6Var == null || cardViewHolder == null || cardViewHolder.a() == null) {
                return null;
            }
            vo6Var.B(i + 1);
            int i2 = 0;
            StatisticItem b0 = vo6Var.b0("c12351");
            if (vo6Var.getThreadData() != null && vo6Var.getThreadData().getThreadAlaInfo() != null) {
                i2 = YYLiveUtil.calculateLiveType(vo6Var.getThreadData().getThreadAlaInfo());
                if (vo6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                    TiebaStaticHelper.addYYParam(b0, vo6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                b0.param(TiebaStatic.Params.OBJ_PARAM3, i2);
            }
            zn6.b().a(b0);
            if (cardViewHolder.a() instanceof e56) {
                cardViewHolder.a().b(this.d);
            }
            cardViewHolder.a().i(vo6Var);
            cardViewHolder.a().k(this.e);
            if (vo6Var.getThreadData() != null) {
                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CONCERN_YY_LIVE_AVATER_SHOW);
                statisticItem.param("fid", vo6Var.getThreadData().getFid());
                statisticItem.param("fname", vo6Var.getThreadData().getForum_name());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                statisticItem.param("tid", vo6Var.getThreadData().getTid());
                if (vo6Var.getThreadData().getThreadAlaInfo() != null) {
                    if (!StringUtils.isNull(vo6Var.getThreadData().getThreadAlaInfo().appId)) {
                        str = vo6Var.getThreadData().getThreadAlaInfo().appId;
                    }
                    if (vo6Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                        str = TiebaStatic.YYValues.YY_LIVE;
                    }
                    statisticItem.param("obj_param1", i2);
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    TiebaStaticHelper.addYYParam(statisticItem, vo6Var.getThreadData().getThreadAlaInfo().mYyExtData);
                }
                TiebaStatic.log(statisticItem);
            }
            return cardViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
