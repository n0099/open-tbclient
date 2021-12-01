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
import c.a.d.f.p.l;
import c.a.k.q;
import c.a.q0.s.g0.p.b;
import c.a.q0.s.u.c;
import c.a.r0.d1.c1;
import c.a.r0.d1.d1;
import c.a.r0.d1.e1;
import c.a.r0.d1.i1;
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
/* loaded from: classes10.dex */
public class CardItemGameCodeLayout extends RelativeLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f44504e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f44505f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f44506g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f44507h;

    /* renamed from: i  reason: collision with root package name */
    public GameCodeListDialog f44508i;

    /* renamed from: j  reason: collision with root package name */
    public int f44509j;

    /* renamed from: k  reason: collision with root package name */
    public List<GameCodeList> f44510k;

    /* loaded from: classes10.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemGameCodeLayout f44511e;

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
            this.f44511e = cardItemGameCodeLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || ListUtils.isEmpty(this.f44511e.f44510k)) {
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b(14)));
            if (this.f44511e.f44508i == null) {
                this.f44511e.f44508i = new GameCodeListDialog(view.getContext());
            }
            this.f44511e.f44508i.setData(this.f44511e.f44510k);
            this.f44511e.f44508i.show((ViewGroup) ((Activity) view.getContext()).findViewById(16908290));
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
            setPadding(l.f(context, d1.M_W_X006), l.f(context, d1.M_H_X005), l.f(context, d1.M_W_X006), l.f(context, d1.M_H_X005));
            ImageView imageView = new ImageView(context);
            this.f44504e = imageView;
            imageView.setId(1);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.f(context, d1.tbds62), l.f(context, d1.tbds62));
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            this.f44504e.setLayoutParams(layoutParams);
            addView(this.f44504e);
            this.f44505f = new TextView(context);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams2.setMargins(l.f(context, d1.tbds23), 0, 0, 0);
            layoutParams2.addRule(1, this.f44504e.getId());
            layoutParams2.addRule(15);
            this.f44505f.setLayoutParams(layoutParams2);
            this.f44505f.setText(TbadkCoreApplication.getInst().getString(i1.frs_item_tab_game_code_title));
            addView(this.f44505f);
            ImageView imageView2 = new ImageView(context);
            this.f44507h = imageView2;
            imageView2.setId(2);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(l.f(context, d1.tbds42), l.f(context, d1.tbds42));
            layoutParams3.addRule(11);
            layoutParams3.addRule(15);
            this.f44507h.setLayoutParams(layoutParams3);
            addView(this.f44507h);
            this.f44506g = new TextView(context);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -1);
            layoutParams4.addRule(0, this.f44507h.getId());
            layoutParams4.addRule(15);
            this.f44506g.setLayoutParams(layoutParams4);
            addView(this.f44506g);
            setOnClickListener(new a(this));
        }
    }

    @Override // c.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            c d2 = c.d(this.f44505f);
            d2.v(c1.CAM_X0105);
            d2.z(d1.T_X07);
            c d3 = c.d(this.f44506g);
            d3.v(c1.CAM_X0107);
            d3.z(d1.T_X08);
            c d4 = c.d(this);
            d4.n(i1.J_X06);
            d4.f(c1.CAM_X0205);
            WebPManager.setMaskDrawable(this.f44504e, e1.icon_mask_giftcode, WebPManager.ResourceStateType.NORMAL);
            WebPManager.setPureDrawable(this.f44507h, e1.icon_pure_arrow12_right, c1.CAM_X0107, WebPManager.ResourceStateType.NORMAL);
            GameCodeListDialog gameCodeListDialog = this.f44508i;
            if (gameCodeListDialog != null) {
                gameCodeListDialog.onChangeSkinType();
            }
        }
    }

    public void setData(c.a.r0.d1.m2.g.c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cVar) == null) || cVar == null) {
            return;
        }
        this.f44509j = cVar.i();
        this.f44510k = cVar.g();
        if (this.f44509j != 0) {
            this.f44506g.setText(String.format(TbadkCoreApplication.getInst().getString(i1.available_game_code_text), Integer.valueOf(this.f44509j)));
        } else {
            this.f44506g.setText(TbadkCoreApplication.getInst().getString(i1.unavailable_game_code_text));
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
