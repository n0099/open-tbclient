package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.repackage.dg;
import com.repackage.eg;
import com.repackage.id6;
import com.repackage.oi;
import com.repackage.t26;
/* loaded from: classes3.dex */
public class GameSpecialTopicAdapter extends id6<t26, CardFrsGameSpecialTopicHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String t;
    public dg<CardFrsGameSpecialTopicItemView> u;

    /* loaded from: classes3.dex */
    public class CardFrsGameSpecialTopicHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public LinearLayout a;
        public TextView b;
        public FlexibleHorizontalScrollView c;
        public CardFrsGameSpecialTopicLayout d;
        public View e;
        public View f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardFrsGameSpecialTopicHolder(GameSpecialTopicAdapter gameSpecialTopicAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameSpecialTopicAdapter, view2};
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
            this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090532);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c79);
            this.c = (FlexibleHorizontalScrollView) view2.findViewById(R.id.obfuscated_res_0x7f090c78);
            CardFrsGameSpecialTopicLayout cardFrsGameSpecialTopicLayout = (CardFrsGameSpecialTopicLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c77);
            this.d = cardFrsGameSpecialTopicLayout;
            cardFrsGameSpecialTopicLayout.setItemSpace(oi.f(view2.getContext(), R.dimen.tbds20));
            this.d.setItemWidth(((oi.f(view2.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f0907fe);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f0907ff);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements eg<CardFrsGameSpecialTopicItemView> {
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
        @Override // com.repackage.eg
        public /* bridge */ /* synthetic */ CardFrsGameSpecialTopicItemView a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView2 = cardFrsGameSpecialTopicItemView;
            e(cardFrsGameSpecialTopicItemView2);
            return cardFrsGameSpecialTopicItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.repackage.eg
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
        @Override // com.repackage.eg
        /* renamed from: f */
        public void b(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameSpecialTopicItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.eg
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
        this.u = new dg<>(new a(this), 10, 0);
        this.t = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.ho
    /* renamed from: n0 */
    public CardFrsGameSpecialTopicHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder = new CardFrsGameSpecialTopicHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0195, viewGroup, false));
            cardFrsGameSpecialTopicHolder.d.setViewPool(this.u);
            return cardFrsGameSpecialTopicHolder;
        }
        return (CardFrsGameSpecialTopicHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.id6, com.repackage.ho
    /* renamed from: o0 */
    public View S(int i, View view2, ViewGroup viewGroup, t26 t26Var, CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, t26Var, cardFrsGameSpecialTopicHolder})) == null) {
            if (t26Var != null && t26Var.a() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameSpecialTopicHolder.b.setText(t26Var.a().title);
                cardFrsGameSpecialTopicHolder.b.setTextColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0105));
                cardFrsGameSpecialTopicHolder.d.setPageContext(this.k);
                cardFrsGameSpecialTopicHolder.d.setData(t26Var.a().sub_nodes);
                cardFrsGameSpecialTopicHolder.c.setMaxOverScrollDistance(cardFrsGameSpecialTopicHolder.d.getChildItemWidth());
                cardFrsGameSpecialTopicHolder.a.setBackgroundColor(SkinManager.getColor(skinType, (int) R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f, R.color.CAM_X0205);
            }
            return cardFrsGameSpecialTopicHolder.b();
        }
        return (View) invokeCommon.objValue;
    }
}
