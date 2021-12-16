package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.m;
import c.a.l.q;
import c.a.r0.s.v.c;
import c.a.s0.d1.c1;
import c.a.s0.d1.d1;
import c.a.s0.d1.f1;
import c.a.s0.d1.g1;
import c.a.s0.d1.i1;
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
/* loaded from: classes12.dex */
public class CardItemRecentUpdateLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public TextView f45053e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f45054f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45055g;

    /* renamed from: h  reason: collision with root package name */
    public View f45056h;

    /* renamed from: i  reason: collision with root package name */
    public FrameLayout f45057i;

    /* renamed from: j  reason: collision with root package name */
    public MultiLineEllipsizeTextView f45058j;

    /* renamed from: k  reason: collision with root package name */
    public EMTextView f45059k;
    public String l;
    public boolean m;

    /* loaded from: classes12.dex */
    public class a implements MultiLineEllipsizeTextView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemRecentUpdateLayout a;

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
            this.a = cardItemRecentUpdateLayout;
        }

        @Override // com.baidu.tbadk.core.view.MultiLineEllipsizeTextView.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.f45059k.setVisibility((z || this.a.m) ? 0 : 8);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemRecentUpdateLayout f45060e;

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
            this.f45060e = cardItemRecentUpdateLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CardItemRecentUpdateLayout cardItemRecentUpdateLayout = this.f45060e;
                cardItemRecentUpdateLayout.m = !cardItemRecentUpdateLayout.m;
                if (!this.f45060e.m) {
                    this.f45060e.f45059k.setText(i1.expand);
                    this.f45060e.f45058j.setMaxLines(3);
                    return;
                }
                this.f45060e.f45059k.setText(i1.fold);
                this.f45060e.f45058j.setMaxLines(Integer.MAX_VALUE);
                this.f45060e.f45058j.setText(this.f45060e.l);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.r0.s.i0.p.b(10)));
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
            LayoutInflater.from(context).inflate(g1.card_item_recent_update, this);
            this.f45053e = (TextView) findViewById(f1.item_recent_update_title);
            this.f45054f = (TextView) findViewById(f1.item_recent_update_version_code);
            this.f45055g = (TextView) findViewById(f1.item_recent_update_date);
            this.f45056h = findViewById(f1.item_recent_update_spilt_line);
            this.f45057i = (FrameLayout) findViewById(f1.item_recent_update_log);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView = new MultiLineEllipsizeTextView(context);
            this.f45058j = multiLineEllipsizeTextView;
            multiLineEllipsizeTextView.setMaxLines(3);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView2 = this.f45058j;
            multiLineEllipsizeTextView2.setIconWidthForLastLine((int) multiLineEllipsizeTextView2.getPaint().measureText(String.valueOf(getResources().getText(i1.expand))));
            c d2 = c.d(this.f45058j);
            d2.z(d1.T_X06);
            d2.w(d1.M_T_X002);
            this.f45058j.setPadding(m.f(context, d1.M_W_X005), 0, 0, m.f(context, d1.M_H_X005));
            this.f45057i.addView(this.f45058j, new LinearLayout.LayoutParams(-1, -2));
            this.f45058j.setOnTextMeasuredCallback(new a(this));
            EMTextView eMTextView = new EMTextView(context);
            this.f45059k = eMTextView;
            eMTextView.setText(i1.expand);
            c.d(this.f45058j).z(d1.T_X06);
            this.f45059k.setPadding(m.f(context, d1.M_W_X005), m.f(context, d1.M_H_X005), 0, m.f(context, d1.M_H_X005));
            this.f45059k.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            this.f45057i.addView(this.f45059k, layoutParams);
            this.f45059k.setOnClickListener(new b(this));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            c d2 = c.d(this);
            d2.n(i1.J_X06);
            d2.f(c1.CAM_X0201);
            c d3 = c.d(this.f45053e);
            d3.A(i1.F_X02);
            d3.v(c1.CAM_X0105);
            c d4 = c.d(this.f45054f);
            d4.A(i1.F_X01);
            d4.v(c1.CAM_X0108);
            c d5 = c.d(this.f45055g);
            d5.A(i1.F_X01);
            d5.v(c1.CAM_X0108);
            c d6 = c.d(this.f45058j);
            d6.A(i1.F_X01);
            d6.v(c1.CAM_X0105);
            c d7 = c.d(this.f45059k);
            d7.A(i1.F_X01);
            d7.v(c1.CAM_X0304);
            c.d(this.f45056h).f(c1.CAM_X0111);
        }
    }

    public void setData(RecentUpdate recentUpdate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recentUpdate) == null) || recentUpdate == null) {
            return;
        }
        String str = recentUpdate.log;
        this.l = str;
        this.f45058j.setText(str);
        this.f45054f.setText(recentUpdate.version);
        this.f45055g.setText(recentUpdate.update_time);
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
