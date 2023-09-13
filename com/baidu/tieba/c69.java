package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.h69;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestRankingViewHolder;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class c69 extends pm<h69, SearchSuggestRankingViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes5.dex */
    public class a implements mn {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ c69 b;

        public a(c69 c69Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c69Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = c69Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.mn
        public void b(View view2, cn cnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            h69 h69Var;
            h69.a b;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, cnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(cnVar instanceof h69) || (b = (h69Var = (h69) cnVar).b()) == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("tab_id", b.d() + "");
            hashMap.put("sort_type", b.c() + "");
            hashMap.put("rank_type", b.b() + "");
            hashMap.put("rank_code", b.a() + "");
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "ItemRecommendList", hashMap)));
            this.b.u(h69Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c69(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
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
        this.a = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this, context));
    }

    public final void t(StatisticItem statisticItem, h69 h69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, statisticItem, h69Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("obj_name", h69Var.c());
        }
    }

    public final void A(h69 h69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h69Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_RANKING_SHOW);
            t(statisticItem, h69Var);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void u(h69 h69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, h69Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_RANKING_CLICK);
            t(statisticItem, h69Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.pm
    /* renamed from: x */
    public SearchSuggestRankingViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new SearchSuggestRankingViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d08a6, viewGroup, false));
        }
        return (SearchSuggestRankingViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.pm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, h69 h69Var, SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        y(i, view2, viewGroup, h69Var, searchSuggestRankingViewHolder);
        return view2;
    }

    public View y(int i, View view2, ViewGroup viewGroup, h69 h69Var, SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, h69Var, searchSuggestRankingViewHolder})) == null) {
            if (h69Var == null) {
                return view2;
            }
            z(searchSuggestRankingViewHolder);
            WebPManager.setMaskDrawable(searchSuggestRankingViewHolder.c, R.drawable.obfuscated_res_0x7f080c89, null);
            x59.a(searchSuggestRankingViewHolder.b, h69Var.d(), h69Var.a());
            A(h69Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(SearchSuggestRankingViewHolder searchSuggestRankingViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestRankingViewHolder) == null) {
            EMManager.from(searchSuggestRankingViewHolder.b).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X06);
            SkinManager.setBackgroundResource(searchSuggestRankingViewHolder.a, R.drawable.addresslist_item_bg);
            EMManager.from(searchSuggestRankingViewHolder.d).setBackGroundColor(R.color.CAM_X0203);
        }
    }
}
