package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.mainentrance.searchsuggestlist.viewholder.SearchSuggestLiveViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class b39 extends ln<g39, SearchSuggestLiveViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* loaded from: classes5.dex */
    public class a implements io {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ b39 b;

        public a(b39 b39Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b39Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = b39Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.io
        public void b(View view2, yn ynVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, ynVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(ynVar instanceof g39)) {
                return;
            }
            g39 g39Var = (g39) ynVar;
            this.b.u(g39Var);
            TbPageContext tbPageContext = (TbPageContext) r9.a(this.a);
            String c = g39Var.c();
            String d = g39Var.d();
            String f = g39Var.f();
            YYLiveUtil.jumpToYYLiveRoom(tbPageContext, c, d, f, "" + g39Var.b(), "search_sug_live");
            yi.A(this.a, view2);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TBLottieAnimationView a;

        public b(b39 b39Var, TBLottieAnimationView tBLottieAnimationView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b39Var, tBLottieAnimationView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = tBLottieAnimationView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b39(Context context, BdUniqueId bdUniqueId) {
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

    public final void t(StatisticItem statisticItem, g39 g39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, statisticItem, g39Var) == null) {
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
            statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
            statisticItem.param(TiebaStatic.Params.FRIEND_UID, g39Var.g());
            statisticItem.param(TiebaStatic.Params.ZHIBO_TYPE, g39Var.i());
            statisticItem.param(TiebaStatic.YYParams.YYSID, g39Var.c());
            statisticItem.param(TiebaStatic.YYParams.YYSSID, g39Var.d());
            statisticItem.param("yyuid", g39Var.h());
            statisticItem.param("template_id", g39Var.f());
        }
    }

    public final void A(SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, searchSuggestLiveViewHolder) == null) {
            d85 d = d85.d(searchSuggestLiveViewHolder.b);
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X06);
            d85 d2 = d85.d(searchSuggestLiveViewHolder.f);
            d2.x(R.color.CAM_X0101);
            d2.C(R.dimen.T_X10);
            SkinManager.setBackgroundResource(searchSuggestLiveViewHolder.a, R.drawable.addresslist_item_bg);
            d85.d(searchSuggestLiveViewHolder.g).f(R.color.CAM_X0203);
        }
    }

    public final void B(g39 g39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, g39Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_SHOW);
            t(statisticItem, g39Var);
            TiebaStatic.log(statisticItem);
        }
    }

    public final void C(TBLottieAnimationView tBLottieAnimationView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tBLottieAnimationView) == null) {
            tBLottieAnimationView.cancelAnimation();
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.obfuscated_res_0x7f110053);
            tBLottieAnimationView.setRepeatCount(-1);
            tBLottieAnimationView.post(new b(this, tBLottieAnimationView));
        }
    }

    public final void u(g39 g39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, g39Var) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SEARCH_SUG_LIVE_CLICK);
            t(statisticItem, g39Var);
            statisticItem.param("source", "search_sug_live");
            TiebaStatic.log(statisticItem);
        }
    }

    public final void x(TextView textView) {
        Context context;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, textView) == null) && (context = this.a) != null && textView != null) {
            textView.setMaxWidth(yi.l(context) - yi.g(this.a, R.dimen.tbds297));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ln
    /* renamed from: y */
    public SearchSuggestLiveViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            return new SearchSuggestLiveViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0880, viewGroup, false));
        }
        return (SearchSuggestLiveViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.ln
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, g39 g39Var, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        z(i, view2, viewGroup, g39Var, searchSuggestLiveViewHolder);
        return view2;
    }

    public View z(int i, View view2, ViewGroup viewGroup, g39 g39Var, SearchSuggestLiveViewHolder searchSuggestLiveViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), view2, viewGroup, g39Var, searchSuggestLiveViewHolder})) == null) {
            if (g39Var == null) {
                return view2;
            }
            A(searchSuggestLiveViewHolder);
            WebPManager.setPureDrawable(searchSuggestLiveViewHolder.c, R.drawable.icon_search_scan, R.color.CAM_X0109, null);
            d85 d = d85.d(searchSuggestLiveViewHolder.e);
            d.o(R.string.J_X01);
            d.f(R.color.CAM_X0308);
            x29.a(searchSuggestLiveViewHolder.b, g39Var.e(), g39Var.a());
            x(searchSuggestLiveViewHolder.b);
            C(searchSuggestLiveViewHolder.d);
            B(g39Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
