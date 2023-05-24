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
import com.baidu.tieba.d25;
import com.baidu.tieba.hd6;
import com.baidu.tieba.id6;
import com.baidu.tieba.p45;
import com.baidu.tieba.rd6;
import com.baidu.tieba.ri;
import com.baidu.tieba.view.NewVoteCountDownView;
import com.baidu.tieba.ym;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import tbclient.ElectionInfo.NoticeContent;
/* loaded from: classes5.dex */
public class VoteStatusCard extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public id6 c;
    public hd6 d;
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

    /* loaded from: classes4.dex */
    public interface c {
        void onRefresh();
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteStatusCard a;

        /* loaded from: classes4.dex */
        public class a implements d25.e {
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

            @Override // com.baidu.tieba.d25.e
            public void onClick(d25 d25Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, d25Var) == null) {
                    d25Var.dismiss();
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
                d25 d25Var = new d25((Activity) this.a.a);
                View inflate = LayoutInflater.from(this.a.a).inflate(R.layout.obfuscated_res_0x7f0d0147, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0903bb);
                textView.setText(this.a.a.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + this.a.a.getResources().getString(R.string.vote_ueg_tip_detail_2));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                d25Var.setContentView(inflate);
                d25Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0af1, new a(this));
                d25Var.create(((BaseActivity) this.a.a).getPageContext());
                SkinManager.setBackgroundShapeDrawable(d25Var.getRealView(), ri.g(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                d25Var.show();
            }
        }
    }

    /* loaded from: classes4.dex */
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
        public void onFinished() {
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
        this.b = rd6.b;
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
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090354);
            this.f = (VoteStatusView) findViewById(R.id.obfuscated_res_0x7f0928c8);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c6);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c1);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c5);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c2);
            this.k = (TextView) findViewById(R.id.vote_title);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f0928c6);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091cbf);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f091cbe);
            this.p = findViewById(R.id.obfuscated_res_0x7f0928b5);
            this.o = (NewVoteCountDownView) findViewById(R.id.obfuscated_res_0x7f0928b6);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0928d3);
            this.q = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(new b(this));
            }
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f0928d5);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f0928d4);
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
            setMinimumHeight(ri.g(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            int g = ri.g(this.a, R.dimen.tbds56);
            int g2 = ri.g(this.a, R.dimen.tbds52);
            setPadding(g, g2, g, g2);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d09c2, (ViewGroup) this, true);
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
                if (this.b > rd6.a) {
                    i2 = color;
                } else {
                    i2 = color2;
                }
                textView3.setTextColor(i2);
            }
            TextView textView4 = this.m;
            if (textView4 != null) {
                if (this.b <= rd6.b) {
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
            p45 d = p45.d(this.p);
            d.o(R.string.J_X06);
            d.f(R.color.CAM_X0206);
            p45 d2 = p45.d(this.q);
            d2.o(R.string.J_X06);
            d2.f(R.color.CAM_X0206);
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
            ym ymVar = new ym(drawable, 0);
            ymVar.b(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
            spannableString.setSpan(ymVar, str.length() - 1, str.length(), 17);
            this.r.setText(spannableString);
        }
    }

    public void setData(id6 id6Var) {
        long a2;
        hd6 a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, id6Var) == null) {
            this.c = id6Var;
            if (id6Var != null && id6Var.a() != null) {
                hd6 a4 = this.c.a();
                this.d = a4;
                int h = a4.h();
                this.b = h;
                this.f.setStatus(h);
                long d = this.d.d() * 1000;
                int i = (this.d.a() > 0L ? 1 : (this.d.a() == 0L ? 0 : -1));
                hd6 hd6Var = this.d;
                if (i == 0) {
                    a2 = hd6Var.i();
                } else {
                    a2 = hd6Var.a();
                }
                long g = this.d.g() * 1000;
                this.i.setText(StringHelper.getDateStringMd(d));
                this.j.setText(StringHelper.getDateStringMdHm(a2 * 1000));
                this.l.setText(StringHelper.getDateStringMdHm(this.d.i() * 1000));
                this.n.setText(StringHelper.getDateStringMdHm(this.d.e() * 1000));
                if (this.b == rd6.b) {
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
                if (i2 == rd6.c) {
                    this.q.setVisibility(0);
                } else if (i2 == rd6.b) {
                    this.q.setVisibility(8);
                } else {
                    this.q.setVisibility(8);
                }
                if (id6Var.a() != null && (a3 = id6Var.a()) != null) {
                    NoticeContent f = a3.f();
                    if (f != null && !TextUtils.isEmpty(f.public_notice)) {
                        g(f.public_notice + "占");
                        return;
                    }
                    g(this.a.getResources().getString(R.string.vote_ueg_tip) + "占");
                    return;
                }
                return;
            }
            setVisibility(8);
        }
    }
}
