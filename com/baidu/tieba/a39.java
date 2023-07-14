package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestItemViewHolder;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes5.dex */
public class a39 extends ln<f39, SearchSuggestItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes5.dex */
    public class a implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ a39 b;

        public a(a39 a39Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a39Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = a39Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(ynVar instanceof f39)) {
                return;
            }
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            f39 f39Var = (f39) ynVar;
            sb.append(f39Var.b());
            sb.append("");
            hashMap.put("itemID", sb.toString());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "GameItemDetailsPage", hashMap)));
            this.b.u(f39Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a39(Context context, BdUniqueId bdUniqueId) {
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

    public final void t(StatisticItem statisticItem, f39 f39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, statisticItem, f39Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("item_id", f39Var.b().longValue());
        }
    }

    public final void A(f39 f39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, f39Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_SHOW);
            t(statisticItem, f39Var);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void u(f39 f39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, f39Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_ITEM_CLICK);
            t(statisticItem, f39Var);
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: x */
    public SearchSuggestItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, viewGroup)) == null) {
            return new SearchSuggestItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d087f, viewGroup, false));
        }
        return (SearchSuggestItemViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, f39 f39Var, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        y(i, view2, viewGroup, f39Var, searchSuggestItemViewHolder);
        return view2;
    }

    public View y(int i, View view2, ViewGroup viewGroup, f39 f39Var, SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Integer.valueOf(i), view2, viewGroup, f39Var, searchSuggestItemViewHolder})) == null) {
            if (f39Var == null) {
                return view2;
            }
            z(searchSuggestItemViewHolder);
            searchSuggestItemViewHolder.b.setConrers(15);
            searchSuggestItemViewHolder.b.setRadiusById(R.string.J_X06);
            searchSuggestItemViewHolder.b.N(f39Var.a(), 10, false);
            searchSuggestItemViewHolder.c.setText(f39Var.c());
            searchSuggestItemViewHolder.f.setStarSpacing(yi.g(this.a, R.dimen.M_W_X002));
            searchSuggestItemViewHolder.f.setStarCount(f39Var.e().intValue());
            TextView textView = searchSuggestItemViewHolder.d;
            StringBuilder sb = new StringBuilder();
            sb.append(f39Var.d());
            String str = "";
            sb.append("");
            textView.setText(sb.toString());
            if (f39Var.f() != null) {
                for (String str2 : f39Var.f()) {
                    if (!StringUtils.isNull(str2)) {
                        if (!StringUtils.isNull(str)) {
                            str2 = str + " " + str2;
                        }
                        str = str2;
                    }
                }
            }
            searchSuggestItemViewHolder.e.setText(str);
            A(f39Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(SearchSuggestItemViewHolder searchSuggestItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, searchSuggestItemViewHolder) == null) {
            d85 d = d85.d(searchSuggestItemViewHolder.c);
            d.D(R.string.F_X02);
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X06);
            d85 d2 = d85.d(searchSuggestItemViewHolder.d);
            d2.x(R.color.CAM_X0108);
            d2.C(R.dimen.T_X09);
            d85 d3 = d85.d(searchSuggestItemViewHolder.e);
            d3.x(R.color.CAM_X0108);
            d3.C(R.dimen.T_X09);
            SkinManager.setBackgroundResource(searchSuggestItemViewHolder.a, R.drawable.addresslist_item_bg);
            d85.d(searchSuggestItemViewHolder.g).f(R.color.CAM_X0203);
        }
    }
}
