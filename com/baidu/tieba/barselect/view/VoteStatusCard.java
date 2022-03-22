package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.a.d.f.p.n;
import c.a.p0.e0.b.e;
import c.a.p0.e0.b.f;
import c.a.p0.e0.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NewVoteCountDownView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VoteStatusCard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public int f31607b;

    /* renamed from: c  reason: collision with root package name */
    public f f31608c;

    /* renamed from: d  reason: collision with root package name */
    public e f31609d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f31610e;

    /* renamed from: f  reason: collision with root package name */
    public VoteStatusView f31611f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f31612g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f31613h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public NewVoteCountDownView m;
    public View n;
    public Path o;
    public b p;
    public NewVoteCountDownView.b q;

    /* loaded from: classes5.dex */
    public class a implements NewVoteCountDownView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteStatusCard a;

        public a(VoteStatusCard voteStatusCard) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {voteStatusCard};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = voteStatusCard;
        }

        @Override // com.baidu.tieba.view.NewVoteCountDownView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.p == null) {
                return;
            }
            this.a.p.onRefresh();
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void onRefresh();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoteStatusCard(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f31610e = (TextView) findViewById(R.id.obfuscated_res_0x7f09031b);
            this.f31611f = (VoteStatusView) findViewById(R.id.obfuscated_res_0x7f09242c);
            this.f31612g = (TextView) findViewById(R.id.obfuscated_res_0x7f0902a1);
            this.f31613h = (TextView) findViewById(R.id.obfuscated_res_0x7f0902a0);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f092434);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f09242a);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f09194d);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f09194c);
            this.n = findViewById(R.id.obfuscated_res_0x7f092419);
            this.m = (NewVoteCountDownView) findViewById(R.id.obfuscated_res_0x7f09241a);
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Path path = new Path();
            this.o = path;
            path.moveTo(0.0f, 15.0f);
            this.o.lineTo(440.0f, 15.0f);
            this.o.lineTo(454.0f, 0.0f);
            this.o.lineTo(468.0f, 15.0f);
            this.o.lineTo(902.0f, 15.0f);
            this.o.lineTo(902.0f, 224.0f);
            this.o.lineTo(0.0f, 224.0f);
            this.o.lineTo(0.0f, 15.0f);
            this.o.close();
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a = getContext();
            setOrientation(1);
            setMinimumHeight(n.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            int f2 = n.f(this.a, R.dimen.tbds56);
            int f3 = n.f(this.a, R.dimen.tbds52);
            setPadding(f2, f3, f2, f3);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08b9, (ViewGroup) this, true);
            b();
            c();
        }
    }

    public void e() {
        NewVoteCountDownView newVoteCountDownView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (newVoteCountDownView = this.m) == null) {
            return;
        }
        newVoteCountDownView.e();
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            int color = SkinManager.getColor(i, (int) R.color.CAM_X0105);
            int color2 = SkinManager.getColor(i, (int) R.color.CAM_X0109);
            TextView textView = this.f31612g;
            if (textView != null) {
                textView.setTextColor(color);
            }
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setTextColor(this.f31607b > c.a ? color : color2);
            }
            TextView textView3 = this.k;
            if (textView3 != null) {
                if (this.f31607b <= c.f13760b) {
                    color = color2;
                }
                textView3.setTextColor(color);
            }
            VoteStatusView voteStatusView = this.f31611f;
            if (voteStatusView != null) {
                voteStatusView.b(i);
            }
            SkinManager.setViewTextColor(this.f31610e, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.f31613h, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i);
            SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
            NewVoteCountDownView newVoteCountDownView = this.m;
            if (newVoteCountDownView != null) {
                newVoteCountDownView.f(i);
            }
            int color3 = SkinManager.getColor(R.color.CAM_X0206);
            c.a.p0.q4.e eVar = new c.a.p0.q4.e(this.o, 902.0f, 224.0f);
            eVar.a(color3);
            this.n.setBackground(eVar);
        }
    }

    public void setData(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.f31608c = fVar;
            if (fVar != null && fVar.a() != null) {
                e a2 = this.f31608c.a();
                this.f31609d = a2;
                int g2 = a2.g();
                this.f31607b = g2;
                this.f31611f.setStatus(g2);
                long f2 = this.f31609d.f() * 1000;
                this.f31613h.setText(StringHelper.getDateStringMd(this.f31609d.c() * 1000));
                this.j.setText(StringHelper.getDateStringMdHm(this.f31609d.h() * 1000));
                this.l.setText(StringHelper.getDateStringMdHm(this.f31609d.d() * 1000));
                if (this.f31607b == c.f13760b) {
                    this.n.setVisibility(0);
                    NewVoteCountDownView.b bVar = this.q;
                    if (bVar != null) {
                        this.m.setOnCountDownFinished(bVar);
                    }
                    this.m.setData(f2);
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            setVisibility(8);
        }
    }

    public void setOnRefreshListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.p = bVar;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteStatusCard(Context context, AttributeSet attributeSet) {
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
        this.f31607b = c.f13760b;
        this.q = new a(this);
        d();
    }
}
