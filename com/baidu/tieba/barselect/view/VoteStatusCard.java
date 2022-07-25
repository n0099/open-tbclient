package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NewVoteCountDownView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.nw5;
import com.repackage.ow5;
import com.repackage.pi;
import com.repackage.xt8;
import com.repackage.xw5;
/* loaded from: classes3.dex */
public class VoteStatusCard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public ow5 c;
    public nw5 d;
    public TextView e;
    public VoteStatusView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public NewVoteCountDownView m;
    public View n;
    public Path o;
    public b p;
    public NewVoteCountDownView.b q;

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
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
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f09031f);
            this.f = (VoteStatusView) findViewById(R.id.obfuscated_res_0x7f0924ab);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f09029e);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f09029d);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0924b3);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0924a9);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f0919c2);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f0919c1);
            this.n = findViewById(R.id.obfuscated_res_0x7f092498);
            this.m = (NewVoteCountDownView) findViewById(R.id.obfuscated_res_0x7f092499);
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
            setMinimumHeight(pi.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            int f = pi.f(this.a, R.dimen.tbds56);
            int f2 = pi.f(this.a, R.dimen.tbds52);
            setPadding(f, f2, f, f2);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d08c0, (ViewGroup) this, true);
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
            TextView textView = this.g;
            if (textView != null) {
                textView.setTextColor(color);
            }
            TextView textView2 = this.i;
            if (textView2 != null) {
                textView2.setTextColor(this.b > xw5.a ? color : color2);
            }
            TextView textView3 = this.k;
            if (textView3 != null) {
                if (this.b <= xw5.b) {
                    color = color2;
                }
                textView3.setTextColor(color);
            }
            VoteStatusView voteStatusView = this.f;
            if (voteStatusView != null) {
                voteStatusView.b(i);
            }
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.h, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i);
            SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
            NewVoteCountDownView newVoteCountDownView = this.m;
            if (newVoteCountDownView != null) {
                newVoteCountDownView.f(i);
            }
            int color3 = SkinManager.getColor(R.color.CAM_X0206);
            xt8 xt8Var = new xt8(this.o, 902.0f, 224.0f);
            xt8Var.a(color3);
            this.n.setBackground(xt8Var);
        }
    }

    public void setData(ow5 ow5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ow5Var) == null) {
            this.c = ow5Var;
            if (ow5Var != null && ow5Var.a() != null) {
                nw5 a2 = this.c.a();
                this.d = a2;
                int g = a2.g();
                this.b = g;
                this.f.setStatus(g);
                long f = this.d.f() * 1000;
                this.h.setText(StringHelper.getDateStringMd(this.d.c() * 1000));
                this.j.setText(StringHelper.getDateStringMdHm(this.d.h() * 1000));
                this.l.setText(StringHelper.getDateStringMdHm(this.d.d() * 1000));
                if (this.b == xw5.b) {
                    this.n.setVisibility(0);
                    NewVoteCountDownView.b bVar = this.q;
                    if (bVar != null) {
                        this.m.setOnCountDownFinished(bVar);
                    }
                    this.m.setData(f);
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
        this.b = xw5.b;
        this.q = new a(this);
        d();
    }
}
