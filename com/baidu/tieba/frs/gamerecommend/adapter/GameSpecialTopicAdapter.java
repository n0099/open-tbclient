package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.k.b;
import c.a.d.f.k.c;
import c.a.d.f.p.n;
import c.a.p0.f1.k;
import c.a.p0.o0.h;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.horizonalScrollListView.FlexibleHorizontalScrollView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.CardFrsGameSpecialTopicItemView;
import com.baidu.tieba.card.CardFrsGameSpecialTopicLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class GameSpecialTopicAdapter extends k<h, CardFrsGameSpecialTopicHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public b<CardFrsGameSpecialTopicItemView> u;

    /* loaded from: classes5.dex */
    public class CardFrsGameSpecialTopicHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f32590b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f32591c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameSpecialTopicLayout f32592d;

        /* renamed from: e  reason: collision with root package name */
        public View f32593e;

        /* renamed from: f  reason: collision with root package name */
        public View f32594f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardFrsGameSpecialTopicHolder(GameSpecialTopicAdapter gameSpecialTopicAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameSpecialTopicAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09052a);
            this.f32590b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090c6c);
            this.f32591c = (FlexibleHorizontalScrollView) view.findViewById(R.id.obfuscated_res_0x7f090c6b);
            CardFrsGameSpecialTopicLayout cardFrsGameSpecialTopicLayout = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.obfuscated_res_0x7f090c6a);
            this.f32592d = cardFrsGameSpecialTopicLayout;
            cardFrsGameSpecialTopicLayout.setItemSpace(n.f(view.getContext(), R.dimen.tbds20));
            this.f32592d.setItemWidth(((n.f(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.f32593e = view.findViewById(R.id.obfuscated_res_0x7f0907f5);
            this.f32594f = view.findViewById(R.id.obfuscated_res_0x7f0907f6);
        }
    }

    /* loaded from: classes5.dex */
    public class a implements c<CardFrsGameSpecialTopicItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ GameSpecialTopicAdapter a;

        public a(GameSpecialTopicAdapter gameSpecialTopicAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameSpecialTopicAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gameSpecialTopicAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ CardFrsGameSpecialTopicItemView a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView2 = cardFrsGameSpecialTopicItemView;
            e(cardFrsGameSpecialTopicItemView2);
            return cardFrsGameSpecialTopicItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.d.f.k.c
        public /* bridge */ /* synthetic */ CardFrsGameSpecialTopicItemView c(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView2 = cardFrsGameSpecialTopicItemView;
            h(cardFrsGameSpecialTopicItemView2);
            return cardFrsGameSpecialTopicItemView2;
        }

        public CardFrsGameSpecialTopicItemView e(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cardFrsGameSpecialTopicItemView)) == null) ? cardFrsGameSpecialTopicItemView : (CardFrsGameSpecialTopicItemView) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: f */
        public void b(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameSpecialTopicItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.d.f.k.c
        /* renamed from: g */
        public CardFrsGameSpecialTopicItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(this.a.a);
                cardFrsGameSpecialTopicItemView.setForumId(this.a.t);
                return cardFrsGameSpecialTopicItemView;
            }
            return (CardFrsGameSpecialTopicItemView) invokeV.objValue;
        }

        public CardFrsGameSpecialTopicItemView h(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, cardFrsGameSpecialTopicItemView)) == null) ? cardFrsGameSpecialTopicItemView : (CardFrsGameSpecialTopicItemView) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameSpecialTopicAdapter(TbPageContext tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2, String str) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.u = new b<>(new a(this), 10, 0);
        this.t = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: n0 */
    public CardFrsGameSpecialTopicHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder = new CardFrsGameSpecialTopicHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0191, viewGroup, false));
            cardFrsGameSpecialTopicHolder.f32592d.setViewPool(this.u);
            return cardFrsGameSpecialTopicHolder;
        }
        return (CardFrsGameSpecialTopicHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.p0.f1.k, c.a.d.o.e.a
    /* renamed from: o0 */
    public View S(int i, View view, ViewGroup viewGroup, h hVar, CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, hVar, cardFrsGameSpecialTopicHolder})) == null) {
            if (hVar != null && hVar.a() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameSpecialTopicHolder.f32590b.setText(hVar.a().title);
                cardFrsGameSpecialTopicHolder.f32590b.setTextColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0105));
                cardFrsGameSpecialTopicHolder.f32592d.setPageContext(this.k);
                cardFrsGameSpecialTopicHolder.f32592d.setData(hVar.a().sub_nodes);
                cardFrsGameSpecialTopicHolder.f32591c.setMaxOverScrollDistance(cardFrsGameSpecialTopicHolder.f32592d.getChildItemWidth());
                cardFrsGameSpecialTopicHolder.a.setBackgroundColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f32593e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f32594f, R.color.CAM_X0205);
            }
            return cardFrsGameSpecialTopicHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
