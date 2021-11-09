package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import b.a.e.e.p.l;
import b.a.l.q;
import b.a.q0.s.u.c;
import b.a.r0.x0.b1;
import b.a.r0.x0.c1;
import b.a.r0.x0.e1;
import b.a.r0.x0.f1;
import b.a.r0.x0.h1;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.MultiLineEllipsizeTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecentUpdate;
/* loaded from: classes9.dex */
public class CardItemRecentUpdateLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f48847e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f48848f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f48849g;

    /* renamed from: h  reason: collision with root package name */
    public View f48850h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f48851i;
    public MultiLineEllipsizeTextView j;
    public EMTextView k;
    public String l;
    public boolean m;

    /* loaded from: classes9.dex */
    public class a implements MultiLineEllipsizeTextView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CardItemRecentUpdateLayout f48852a;

        public a(CardItemRecentUpdateLayout cardItemRecentUpdateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecentUpdateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48852a = cardItemRecentUpdateLayout;
        }

        @Override // com.baidu.tbadk.core.view.MultiLineEllipsizeTextView.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f48852a.k.setVisibility((z || this.f48852a.m) ? 0 : 8);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemRecentUpdateLayout f48853e;

        public b(CardItemRecentUpdateLayout cardItemRecentUpdateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecentUpdateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48853e = cardItemRecentUpdateLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CardItemRecentUpdateLayout cardItemRecentUpdateLayout = this.f48853e;
                cardItemRecentUpdateLayout.m = !cardItemRecentUpdateLayout.m;
                if (!this.f48853e.m) {
                    this.f48853e.k.setText(h1.expand);
                    this.f48853e.j.setMaxLines(3);
                    return;
                }
                this.f48853e.k.setText(h1.fold);
                this.f48853e.j.setMaxLines(Integer.MAX_VALUE);
                this.f48853e.j.setText(this.f48853e.l);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new b.a.q0.s.g0.p.b(10)));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecentUpdateLayout(Context context) {
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
        f(context);
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            LayoutInflater.from(context).inflate(f1.card_item_recent_update, this);
            this.f48847e = (TextView) findViewById(e1.item_recent_update_title);
            this.f48848f = (TextView) findViewById(e1.item_recent_update_version_code);
            this.f48849g = (TextView) findViewById(e1.item_recent_update_date);
            this.f48850h = findViewById(e1.item_recent_update_spilt_line);
            this.f48851i = (FrameLayout) findViewById(e1.item_recent_update_log);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView = new MultiLineEllipsizeTextView(context);
            this.j = multiLineEllipsizeTextView;
            multiLineEllipsizeTextView.setMaxLines(3);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView2 = this.j;
            multiLineEllipsizeTextView2.setIconWidthForLastLine((int) multiLineEllipsizeTextView2.getPaint().measureText(String.valueOf(getResources().getText(h1.expand))));
            c d2 = c.d(this.j);
            d2.z(c1.T_X06);
            d2.w(c1.M_T_X002);
            this.j.setPadding(l.g(context, c1.M_W_X005), 0, 0, l.g(context, c1.M_H_X005));
            this.f48851i.addView(this.j, new LinearLayout.LayoutParams(-1, -2));
            this.j.setOnTextMeasuredCallback(new a(this));
            EMTextView eMTextView = new EMTextView(context);
            this.k = eMTextView;
            eMTextView.setText(h1.expand);
            c.d(this.j).z(c1.T_X06);
            this.k.setPadding(l.g(context, c1.M_W_X005), l.g(context, c1.M_H_X005), 0, l.g(context, c1.M_H_X005));
            this.k.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            this.f48851i.addView(this.k, layoutParams);
            this.k.setOnClickListener(new b(this));
        }
    }

    @Override // b.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            c d2 = c.d(this);
            d2.n(h1.J_X06);
            d2.f(b1.CAM_X0201);
            c d3 = c.d(this.f48847e);
            d3.A(h1.F_X02);
            d3.v(b1.CAM_X0105);
            c d4 = c.d(this.f48848f);
            d4.A(h1.F_X01);
            d4.v(b1.CAM_X0108);
            c d5 = c.d(this.f48849g);
            d5.A(h1.F_X01);
            d5.v(b1.CAM_X0108);
            c d6 = c.d(this.j);
            d6.A(h1.F_X01);
            d6.v(b1.CAM_X0105);
            c d7 = c.d(this.k);
            d7.A(h1.F_X01);
            d7.v(b1.CAM_X0304);
            c.d(this.f48850h).f(b1.CAM_X0111);
        }
    }

    public void setData(RecentUpdate recentUpdate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recentUpdate) == null) || recentUpdate == null) {
            return;
        }
        String str = recentUpdate.log;
        this.l = str;
        this.j.setText(str);
        this.f48848f.setText(recentUpdate.version);
        this.f48849g.setText(recentUpdate.update_time);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecentUpdateLayout(Context context, @Nullable AttributeSet attributeSet) {
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
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemRecentUpdateLayout(Context context, @Nullable AttributeSet attributeSet, int i2) {
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
        f(context);
    }
}
