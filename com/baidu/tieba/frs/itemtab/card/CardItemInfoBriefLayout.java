package com.baidu.tieba.frs.itemtab.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import c.a.d.f.p.n;
import c.a.l.q;
import c.a.s0.s.u.c;
import c.a.t0.e1.c1;
import c.a.t0.e1.d1;
import c.a.t0.e1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.view.MultiLineEllipsizeTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ItemInfo;
/* loaded from: classes12.dex */
public class CardItemInfoBriefLayout extends FrameLayout implements q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MultiLineEllipsizeTextView f43594e;

    /* renamed from: f  reason: collision with root package name */
    public EMTextView f43595f;

    /* renamed from: g  reason: collision with root package name */
    public String f43596g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f43597h;

    /* loaded from: classes12.dex */
    public class a implements MultiLineEllipsizeTextView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CardItemInfoBriefLayout a;

        public a(CardItemInfoBriefLayout cardItemInfoBriefLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoBriefLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cardItemInfoBriefLayout;
        }

        @Override // com.baidu.tbadk.core.view.MultiLineEllipsizeTextView.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.a.f43595f.setVisibility((z || this.a.f43597h) ? 0 : 8);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CardItemInfoBriefLayout f43598e;

        public b(CardItemInfoBriefLayout cardItemInfoBriefLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cardItemInfoBriefLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f43598e = cardItemInfoBriefLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                CardItemInfoBriefLayout cardItemInfoBriefLayout = this.f43598e;
                cardItemInfoBriefLayout.f43597h = !cardItemInfoBriefLayout.f43597h;
                if (!this.f43598e.f43597h) {
                    this.f43598e.f43595f.setText(i1.expand);
                    this.f43598e.f43594e.setMaxLines(3);
                    return;
                }
                this.f43598e.f43595f.setText(i1.fold);
                this.f43598e.f43594e.setMaxLines(Integer.MAX_VALUE);
                this.f43598e.f43594e.setText(this.f43598e.f43596g);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoBriefLayout(Context context) {
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
        f();
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setPadding(n.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X005), n.f(TbadkCoreApplication.getInst().getContext(), d1.M_H_X004), n.f(TbadkCoreApplication.getInst().getContext(), d1.M_W_X005), 0);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView = new MultiLineEllipsizeTextView(getContext());
            this.f43594e = multiLineEllipsizeTextView;
            multiLineEllipsizeTextView.setMaxLines(3);
            MultiLineEllipsizeTextView multiLineEllipsizeTextView2 = this.f43594e;
            multiLineEllipsizeTextView2.setIconWidthForLastLine((int) multiLineEllipsizeTextView2.getPaint().measureText(String.valueOf(getResources().getText(i1.expand))));
            c d2 = c.d(this.f43594e);
            d2.z(d1.T_X07);
            d2.w(d1.M_T_X002);
            this.f43594e.setPadding(0, 0, 0, n.f(getContext(), d1.M_H_X005));
            addView(this.f43594e, new FrameLayout.LayoutParams(-1, -2));
            this.f43594e.setOnTextMeasuredCallback(new a(this));
            EMTextView eMTextView = new EMTextView(getContext());
            this.f43595f = eMTextView;
            eMTextView.setText(i1.expand);
            c.d(this.f43594e).z(d1.T_X07);
            this.f43595f.setPadding(n.f(getContext(), d1.M_W_X005), n.f(getContext(), d1.M_H_X005), 0, n.f(getContext(), d1.M_H_X005));
            this.f43595f.setVisibility(8);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 85;
            addView(this.f43595f, layoutParams);
            this.f43595f.setOnClickListener(new b(this));
        }
    }

    @Override // c.a.l.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i2) == null) {
            c d2 = c.d(this);
            d2.m(2);
            d2.n(i1.J_X06);
            d2.f(c1.CAM_X0205);
            c.d(this.f43594e).v(c1.CAM_X0105);
            c.d(this.f43595f).v(c1.CAM_X0304);
        }
    }

    public void setData(ItemInfo itemInfo) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, itemInfo) == null) || itemInfo == null) {
            return;
        }
        String str = itemInfo.brief;
        this.f43596g = str;
        this.f43594e.setText(str);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoBriefLayout(Context context, AttributeSet attributeSet) {
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
        f();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardItemInfoBriefLayout(Context context, AttributeSet attributeSet, int i2) {
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
        f();
    }
}
