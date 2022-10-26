package com.baidu.tieba.barselect.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.d16;
import com.baidu.tieba.fj;
import com.baidu.tieba.ln;
import com.baidu.tieba.nv4;
import com.baidu.tieba.pu4;
import com.baidu.tieba.t06;
import com.baidu.tieba.u06;
import com.baidu.tieba.view.NewVoteCountDownView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes3.dex */
public class VoteStatusCard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public u06 c;
    public t06 d;
    public TextView e;
    public VoteStatusView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public NewVoteCountDownView o;
    public View p;
    public View q;
    public TextView r;
    public TextView s;
    public c t;
    public NewVoteCountDownView.b u;

    /* loaded from: classes3.dex */
    public interface c {
        void onRefresh();
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteStatusCard a;

        /* loaded from: classes3.dex */
        public class a implements pu4.e {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(b bVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            @Override // com.baidu.tieba.pu4.e
            public void onClick(pu4 pu4Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                    pu4Var.dismiss();
                }
            }
        }

        public b(VoteStatusCard voteStatusCard) {
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

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                pu4 pu4Var = new pu4((Activity) this.a.a);
                View inflate = LayoutInflater.from(this.a.a).inflate(R.layout.obfuscated_res_0x7f0d013f, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f090367);
                textView.setText(this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f15ca) + "\n" + this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f15cb));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                pu4Var.setContentView(inflate);
                pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f09c4, new a(this));
                pu4Var.create(((BaseActivity) this.a.a).getPageContext());
                SkinManager.setBackgroundShapeDrawable(pu4Var.getRealView(), fj.f(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                pu4Var.show();
            }
        }
    }

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
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.t != null) {
                this.a.t.onRefresh();
            }
        }
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
        this.b = d16.b;
        this.u = new a(this);
        d();
    }

    public void setOnRefreshListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.t = cVar;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090340);
            this.f = (VoteStatusView) findViewById(R.id.obfuscated_res_0x7f092622);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0902b8);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0902b3);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0902b7);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0902b4);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f09262a);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f092620);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091ad9);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f091ad8);
            this.p = findViewById(R.id.obfuscated_res_0x7f09260f);
            this.o = (NewVoteCountDownView) findViewById(R.id.obfuscated_res_0x7f092610);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f09262d);
            this.q = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(new b(this));
            }
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f09262f);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f09262e);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            Context context = getContext();
            this.a = context;
            if (context == null) {
                return;
            }
            setOrientation(1);
            setMinimumHeight(fj.f(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            int f = fj.f(this.a, R.dimen.tbds56);
            int f2 = fj.f(this.a, R.dimen.tbds52);
            setPadding(f, f2, f, f2);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d090e, (ViewGroup) this, true);
            c();
        }
    }

    public void e() {
        NewVoteCountDownView newVoteCountDownView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (newVoteCountDownView = this.o) != null) {
            newVoteCountDownView.e();
        }
    }

    public void f(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int color = SkinManager.getColor(i, (int) R.color.CAM_X0105);
            int color2 = SkinManager.getColor(i, (int) R.color.CAM_X0109);
            TextView textView = this.g;
            if (textView != null) {
                textView.setTextColor(color);
            }
            TextView textView2 = this.h;
            if (textView2 != null) {
                textView2.setTextColor(color);
            }
            TextView textView3 = this.k;
            if (textView3 != null) {
                if (this.b > d16.a) {
                    i2 = color;
                } else {
                    i2 = color2;
                }
                textView3.setTextColor(i2);
            }
            TextView textView4 = this.m;
            if (textView4 != null) {
                if (this.b <= d16.b) {
                    color = color2;
                }
                textView4.setTextColor(color);
            }
            VoteStatusView voteStatusView = this.f;
            if (voteStatusView != null) {
                voteStatusView.b(i);
            }
            SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.j, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1, i);
            SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i);
            SkinManager.setViewTextColor(this.r, R.color.CAM_X0105, 1, i);
            SkinManager.setBackgroundResource(this.s, R.drawable.icon_common_explain12_gray66, i);
            NewVoteCountDownView newVoteCountDownView = this.o;
            if (newVoteCountDownView != null) {
                newVoteCountDownView.f(i);
            }
            nv4 d = nv4.d(this.p);
            d.n(R.string.J_X06);
            d.f(R.color.CAM_X0206);
            nv4 d2 = nv4.d(this.q);
            d2.n(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
            ln lnVar = new ln(drawable, 0);
            lnVar.b(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
            spannableString.setSpan(lnVar, str.length() - 1, str.length(), 17);
            this.r.setText(spannableString);
        }
    }

    public void setData(u06 u06Var) {
        long a2;
        t06 a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, u06Var) == null) {
            this.c = u06Var;
            if (u06Var != null && u06Var.a() != null) {
                t06 a4 = this.c.a();
                this.d = a4;
                int h = a4.h();
                this.b = h;
                this.f.setStatus(h);
                long d = this.d.d() * 1000;
                int i = (this.d.a() > 0L ? 1 : (this.d.a() == 0L ? 0 : -1));
                t06 t06Var = this.d;
                if (i == 0) {
                    a2 = t06Var.i();
                } else {
                    a2 = t06Var.a();
                }
                long g = this.d.g() * 1000;
                this.i.setText(StringHelper.getDateStringMd(d));
                this.j.setText(StringHelper.getDateStringMdHm(a2 * 1000));
                this.l.setText(StringHelper.getDateStringMdHm(this.d.i() * 1000));
                this.n.setText(StringHelper.getDateStringMdHm(this.d.e() * 1000));
                if (this.b == d16.b) {
                    this.p.setVisibility(0);
                    NewVoteCountDownView.b bVar = this.u;
                    if (bVar != null) {
                        this.o.setOnCountDownFinished(bVar);
                    }
                    this.o.setData(g);
                } else {
                    this.p.setVisibility(8);
                }
                int i2 = this.b;
                if (i2 == d16.c) {
                    this.q.setVisibility(0);
                } else if (i2 == d16.b) {
                    this.q.setVisibility(8);
                } else {
                    this.q.setVisibility(8);
                }
                if (u06Var.a() != null && (a3 = u06Var.a()) != null) {
                    NoticeContent f = a3.f();
                    if (f != null && !TextUtils.isEmpty(f.public_notice)) {
                        g(f.public_notice + "占");
                        return;
                    }
                    g(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f15c9) + "占");
                    return;
                }
                return;
            }
            setVisibility(8);
        }
    }
}
