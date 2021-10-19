package com.baidu.tieba.frs.gamerecommend.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.e.e.k.b;
import c.a.e.e.k.c;
import c.a.e.e.p.l;
import c.a.r0.h0.h;
import c.a.r0.x0.k;
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
/* loaded from: classes7.dex */
public class GameSpecialTopicAdapter extends k<h, CardFrsGameSpecialTopicHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String x;
    public b<CardFrsGameSpecialTopicItemView> y;

    /* loaded from: classes7.dex */
    public class CardFrsGameSpecialTopicHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public LinearLayout f51286a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f51287b;

        /* renamed from: c  reason: collision with root package name */
        public FlexibleHorizontalScrollView f51288c;

        /* renamed from: d  reason: collision with root package name */
        public CardFrsGameSpecialTopicLayout f51289d;

        /* renamed from: e  reason: collision with root package name */
        public View f51290e;

        /* renamed from: f  reason: collision with root package name */
        public View f51291f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CardFrsGameSpecialTopicHolder(GameSpecialTopicAdapter gameSpecialTopicAdapter, View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameSpecialTopicAdapter, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51286a = (LinearLayout) view.findViewById(R.id.card_game_special_topic_content);
            this.f51287b = (TextView) view.findViewById(R.id.game_special_topic_title);
            this.f51288c = (FlexibleHorizontalScrollView) view.findViewById(R.id.game_special_topic_scroll_container);
            CardFrsGameSpecialTopicLayout cardFrsGameSpecialTopicLayout = (CardFrsGameSpecialTopicLayout) view.findViewById(R.id.game_special_topic_container);
            this.f51289d = cardFrsGameSpecialTopicLayout;
            cardFrsGameSpecialTopicLayout.setItemSpace(l.g(view.getContext(), R.dimen.tbds20));
            this.f51289d.setItemWidth(((l.g(view.getContext(), R.dimen.tbds170) * 2) * 21) / 9);
            this.f51290e = view.findViewById(R.id.divider_line_1);
            this.f51291f = view.findViewById(R.id.divider_line_2);
        }
    }

    /* loaded from: classes7.dex */
    public class a implements c<CardFrsGameSpecialTopicItemView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ GameSpecialTopicAdapter f51292a;

        public a(GameSpecialTopicAdapter gameSpecialTopicAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gameSpecialTopicAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51292a = gameSpecialTopicAdapter;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
        public /* bridge */ /* synthetic */ CardFrsGameSpecialTopicItemView a(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView2 = cardFrsGameSpecialTopicItemView;
            e(cardFrsGameSpecialTopicItemView2);
            return cardFrsGameSpecialTopicItemView2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // c.a.e.e.k.c
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
        @Override // c.a.e.e.k.c
        /* renamed from: f */
        public void b(CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, cardFrsGameSpecialTopicItemView) == null) {
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.a.e.e.k.c
        /* renamed from: g */
        public CardFrsGameSpecialTopicItemView d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                CardFrsGameSpecialTopicItemView cardFrsGameSpecialTopicItemView = new CardFrsGameSpecialTopicItemView(this.f51292a.f2958e);
                cardFrsGameSpecialTopicItemView.setForumId(this.f51292a.x);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.y = new b<>(new a(this), 10, 0);
        this.x = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.e.l.e.a
    /* renamed from: w0 */
    public CardFrsGameSpecialTopicHolder U(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder = new CardFrsGameSpecialTopicHolder(this, LayoutInflater.from(this.f2958e).inflate(R.layout.card_frs_game_special_topic_layout, viewGroup, false));
            cardFrsGameSpecialTopicHolder.f51289d.setViewPool(this.y);
            return cardFrsGameSpecialTopicHolder;
        }
        return (CardFrsGameSpecialTopicHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.r0.x0.k, c.a.e.l.e.a
    /* renamed from: x0 */
    public View a0(int i2, View view, ViewGroup viewGroup, h hVar, CardFrsGameSpecialTopicHolder cardFrsGameSpecialTopicHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, hVar, cardFrsGameSpecialTopicHolder})) == null) {
            if (hVar != null && hVar.b() != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                cardFrsGameSpecialTopicHolder.f51287b.setText(hVar.b().title);
                cardFrsGameSpecialTopicHolder.f51287b.setTextColor(SkinManager.getColor(skinType, R.color.CAM_X0105));
                cardFrsGameSpecialTopicHolder.f51289d.setPageContext(this.o);
                cardFrsGameSpecialTopicHolder.f51289d.setData(hVar.b().sub_nodes);
                cardFrsGameSpecialTopicHolder.f51288c.setMaxOverScrollDistance(cardFrsGameSpecialTopicHolder.f51289d.getChildItemWidth());
                cardFrsGameSpecialTopicHolder.f51286a.setBackgroundColor(SkinManager.getColor(skinType, R.color.CAM_X0201));
                SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f51290e, R.color.CAM_X0205);
                SkinManager.setBackgroundResource(cardFrsGameSpecialTopicHolder.f51291f, R.color.CAM_X0205);
            }
            return cardFrsGameSpecialTopicHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
