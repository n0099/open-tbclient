package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.o0.r.v.c;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.MultiLineEllipsizeTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.RecentUpdate;
/* loaded from: classes5.dex */
public class CardItemRecentUpdateLayout extends LinearLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f32727b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f32728c;

    /* renamed from: d  reason: collision with root package name */
    public View f32729d;

    /* renamed from: e  reason: collision with root package name */
    public FrameLayout f32730e;

    /* renamed from: f  reason: collision with root package name */
    public MultiLineEllipsizeTextView f32731f;

    /* renamed from: g  reason: collision with root package name */
    public EMTextView f32732g;

    /* renamed from: h  reason: collision with root package name */
    public String f32733h;
    public boolean i;

    /* loaded from: classes5.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
                this.a.f32732g.setVisibility((z || this.a.i) ? 0 : 8);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemRecentUpdateLayout a;

        public b(CardItemRecentUpdateLayout cardItemRecentUpdateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemRecentUpdateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemRecentUpdateLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CardItemRecentUpdateLayout cardItemRecentUpdateLayout = this.a;
                cardItemRecentUpdateLayout.i = !cardItemRecentUpdateLayout.i;
                if (!this.a.i) {
                    this.a.f32732g.setText(R.string.obfuscated_res_0x7f0f05ba);
                    this.a.f32731f.setMaxLines(3);
                    return;
                }
                this.a.f32732g.setText(R.string.obfuscated_res_0x7f0f0620);
                this.a.f32731f.setMaxLines(Integer.MAX_VALUE);
                this.a.f32731f.setText(this.a.f32733h);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921573, new c.a.o0.r.l0.p.b(10)));
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01a7, this);
            this.a = (TextView) findViewById(R.id.obfuscated_res_0x7f090f93);
            this.f32727b = (TextView) findViewById(R.id.obfuscated_res_0x7f090f94);
            this.f32728c = (TextView) findViewById(R.id.obfuscated_res_0x7f090f90);
            this.f32729d = findViewById(R.id.obfuscated_res_0x7f090f92);
            this.f32730e = (FrameLayout) findViewById(R.id.obfuscated_res_0x7f090f91);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView = new MultiLineEllipsizeTextView(context);
            this.f32731f = multiLineEllipsizeTextView;
            multiLineEllipsizeTextView.setMaxLines(3);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView2 = this.f32731f;
            multiLineEllipsizeTextView2.setIconWidthForLastLine((int) multiLineEllipsizeTextView2.getPaint().measureText(String.valueOf(getResources().getText(R.string.obfuscated_res_0x7f0f05ba))));
            c d2 = c.d(this.f32731f);
            d2.z(R.dimen.T_X06);
            d2.w(R.dimen.M_T_X002);
            this.f32731f.setPadding(n.f(context, R.dimen.M_W_X005), 0, 0, n.f(context, R.dimen.M_H_X005));
            this.f32730e.addView(this.f32731f, new LinearLayout.LayoutParams(-1, -2));
            this.f32731f.setOnTextMeasuredCallback(new a(this));
            EMTextView eMTextView = new EMTextView(context);
            this.f32732g = eMTextView;
            eMTextView.setText(R.string.obfuscated_res_0x7f0f05ba);
            c.d(this.f32731f).z(R.dimen.T_X06);
            this.f32732g.setPadding(n.f(context, R.dimen.M_W_X005), n.f(context, R.dimen.M_H_X005), 0, n.f(context, R.dimen.M_H_X005));
            this.f32732g.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            this.f32730e.addView(this.f32732g, layoutParams);
            this.f32732g.setOnClickListener(new b(this));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            c d2 = c.d(this);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0201);
            c d3 = c.d(this.a);
            d3.A(R.string.F_X02);
            d3.v(R.color.CAM_X0105);
            c d4 = c.d(this.f32727b);
            d4.A(R.string.F_X01);
            d4.v(R.color.CAM_X0108);
            c d5 = c.d(this.f32728c);
            d5.A(R.string.F_X01);
            d5.v(R.color.CAM_X0108);
            c d6 = c.d(this.f32731f);
            d6.A(R.string.F_X01);
            d6.v(R.color.CAM_X0105);
            c d7 = c.d(this.f32732g);
            d7.A(R.string.F_X01);
            d7.v(R.color.CAM_X0304);
            c.d(this.f32729d).f(R.color.CAM_X0111);
        }
    }

    public void setData(RecentUpdate recentUpdate) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, recentUpdate) == null) || recentUpdate == null) {
            return;
        }
        String str = recentUpdate.log;
        this.f32733h = str;
        this.f32731f.setText(str);
        this.f32727b.setText(recentUpdate.version);
        this.f32728c.setText(recentUpdate.update_time);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
    public CardItemRecentUpdateLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
