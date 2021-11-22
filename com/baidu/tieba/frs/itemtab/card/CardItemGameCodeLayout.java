package com.baidu.tieba.frs.itemtab.card;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.a.e.f.p.l;
import b.a.l.q;
import b.a.q0.s.g0.p.b;
import b.a.q0.s.u.c;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.e1;
import b.a.r0.x0.i1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.frs.itemtab.gamecode.GameCodeListDialog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.GameCodeList;
/* loaded from: classes9.dex */
public class CardItemGameCodeLayout extends RelativeLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f49648e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f49649f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f49650g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f49651h;

    /* renamed from: i  reason: collision with root package name */
    public GameCodeListDialog f49652i;
    public int j;
    public List<GameCodeList> k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemGameCodeLayout f49653e;

        public a(CardItemGameCodeLayout cardItemGameCodeLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemGameCodeLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49653e = cardItemGameCodeLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ListUtils.isEmpty(this.f49653e.k)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(14)));
            if (this.f49653e.f49652i == null) {
                this.f49653e.f49652i = new GameCodeListDialog(view.getContext());
            }
            this.f49653e.f49652i.setData(this.f49653e.k);
            this.f49653e.f49652i.show((ViewGroup) ((Activity) view.getContext()).findViewById(16908290));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemGameCodeLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        d(context);
    }

    public final void d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
            setPadding(l.g(context, d1.M_W_X006), l.g(context, d1.M_H_X005), l.g(context, d1.M_W_X006), l.g(context, d1.M_H_X005));
            ImageView imageView = new ImageView(context);
            this.f49648e = imageView;
            imageView.setId(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.g(context, d1.tbds62), l.g(context, d1.tbds62));
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            this.f49648e.setLayoutParams(layoutParams);
            addView(this.f49648e);
            this.f49649f = new TextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.setMargins(l.g(context, d1.tbds23), 0, 0, 0);
            layoutParams2.addRule(1, this.f49648e.getId());
            layoutParams2.addRule(15);
            this.f49649f.setLayoutParams(layoutParams2);
            this.f49649f.setText(TbadkCoreApplication.getInst().getString(i1.frs_item_tab_game_code_title));
            addView(this.f49649f);
            ImageView imageView2 = new ImageView(context);
            this.f49651h = imageView2;
            imageView2.setId(2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(l.g(context, d1.tbds42), l.g(context, d1.tbds42));
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            this.f49651h.setLayoutParams(layoutParams3);
            addView(this.f49651h);
            this.f49650g = new TextView(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams4.addRule(0, this.f49651h.getId());
            layoutParams4.addRule(15);
            this.f49650g.setLayoutParams(layoutParams4);
            addView(this.f49650g);
            setOnClickListener(new a(this));
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            c d2 = c.d(this.f49649f);
            d2.v(c1.CAM_X0105);
            d2.z(d1.T_X07);
            c d3 = c.d(this.f49650g);
            d3.v(c1.CAM_X0107);
            d3.z(d1.T_X08);
            c d4 = c.d(this);
            d4.n(i1.J_X06);
            d4.f(c1.CAM_X0205);
            WebPManager.setMaskDrawable(this.f49648e, e1.icon_mask_giftcode, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.f49651h, e1.icon_pure_arrow12_right, c1.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            GameCodeListDialog gameCodeListDialog = this.f49652i;
            if (gameCodeListDialog != null) {
                gameCodeListDialog.onChangeSkinType();
            }
        }
    }

    public void setData(b.a.r0.x0.m2.g.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        this.j = cVar.i();
        this.k = cVar.g();
        if (this.j != 0) {
            this.f49650g.setText(String.format(TbadkCoreApplication.getInst().getString(i1.available_game_code_text), Integer.valueOf(this.j)));
        } else {
            this.f49650g.setText(TbadkCoreApplication.getInst().getString(i1.unavailable_game_code_text));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemGameCodeLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        d(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemGameCodeLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        d(context);
    }
}
