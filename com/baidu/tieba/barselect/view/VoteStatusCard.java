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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.jm;
import com.baidu.tieba.mi6;
import com.baidu.tieba.ni6;
import com.baidu.tieba.view.NewVoteCountDownView;
import com.baidu.tieba.wi6;
import com.baidu.tieba.z45;
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
    public ni6 c;
    public mi6 d;
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

    /* loaded from: classes5.dex */
    public interface c {
        void onRefresh();
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VoteStatusCard a;

        /* loaded from: classes5.dex */
        public class a implements z45.e {
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

            @Override // com.baidu.tieba.z45.e
            public void onClick(z45 z45Var) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, z45Var) == null) {
                    z45Var.dismiss();
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
                z45 z45Var = new z45((Activity) this.a.a);
                View inflate = LayoutInflater.from(this.a.a).inflate(R.layout.obfuscated_res_0x7f0d014e, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f0903c0);
                textView.setText(this.a.a.getResources().getString(R.string.vote_ueg_tip_detail_1) + "\n" + this.a.a.getResources().getString(R.string.vote_ueg_tip_detail_2));
                SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
                z45Var.setContentView(inflate);
                z45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b5b, new a(this));
                z45Var.create(((BaseActivity) this.a.a).getPageContext());
                SkinManager.setBackgroundShapeDrawable(z45Var.getRealView(), BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds30), R.color.CAM_X0201, R.color.CAM_X0201);
                z45Var.show();
            }
        }
    }

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
        this.b = wi6.b;
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
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090355);
            this.f = (VoteStatusView) findViewById(R.id.obfuscated_res_0x7f0929f8);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c9);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c4);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c8);
            this.j = (TextView) findViewById(R.id.obfuscated_res_0x7f0902c5);
            this.k = (TextView) findViewById(R.id.vote_title);
            this.l = (TextView) findViewById(R.id.obfuscated_res_0x7f0929f6);
            this.m = (TextView) findViewById(R.id.obfuscated_res_0x7f091d9e);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f091d9d);
            this.p = findViewById(R.id.obfuscated_res_0x7f0929e5);
            this.o = (NewVoteCountDownView) findViewById(R.id.obfuscated_res_0x7f0929e6);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f092a03);
            this.q = findViewById;
            if (findViewById != null) {
                findViewById.setOnClickListener(new b(this));
            }
            this.r = (TextView) findViewById(R.id.obfuscated_res_0x7f092a05);
            this.s = (TextView) findViewById(R.id.obfuscated_res_0x7f092a04);
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
            setMinimumHeight(BdUtilHelper.getDimens(getContext(), R.dimen.tbds90));
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
            int dimens = BdUtilHelper.getDimens(this.a, R.dimen.tbds56);
            int dimens2 = BdUtilHelper.getDimens(this.a, R.dimen.tbds52);
            setPadding(dimens, dimens2, dimens, dimens2);
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d0a2d, (ViewGroup) this, true);
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
                if (this.b > wi6.a) {
                    i2 = color;
                } else {
                    i2 = color2;
                }
                textView3.setTextColor(i2);
            }
            TextView textView4 = this.m;
            if (textView4 != null) {
                if (this.b <= wi6.b) {
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
            EMManager.from(this.p).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
            EMManager.from(this.q).setCorner(R.string.J_X06).setBackGroundColor(R.color.CAM_X0206);
        }
    }

    public final void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            SpannableString spannableString = new SpannableString(str);
            Drawable drawable = SkinManager.getDrawable(R.drawable.icon_common_explain12_gray66);
            drawable.setBounds(0, 0, UtilHelper.getDimenPixelSize(R.dimen.tbds32), UtilHelper.getDimenPixelSize(R.dimen.tbds32));
            jm jmVar = new jm(drawable, 0);
            jmVar.b(UtilHelper.getDimenPixelSize(R.dimen.tbds10));
            spannableString.setSpan(jmVar, str.length() - 1, str.length(), 17);
            this.r.setText(spannableString);
        }
    }

    public void setData(ni6 ni6Var) {
        long a2;
        mi6 a3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, ni6Var) == null) {
            this.c = ni6Var;
            if (ni6Var != null && ni6Var.a() != null) {
                mi6 a4 = this.c.a();
                this.d = a4;
                int h = a4.h();
                this.b = h;
                this.f.setStatus(h);
                long d = this.d.d() * 1000;
                if (this.d.a() == 0) {
                    a2 = this.d.i();
                } else {
                    a2 = this.d.a();
                }
                long g = this.d.g() * 1000;
                this.i.setText(StringHelper.getDateStringMd(d));
                this.j.setText(StringHelper.getDateStringMdHm(a2 * 1000));
                this.l.setText(StringHelper.getDateStringMdHm(this.d.i() * 1000));
                this.n.setText(StringHelper.getDateStringMdHm(this.d.e() * 1000));
                if (this.b == wi6.b) {
                    this.p.setVisibility(0);
                    NewVoteCountDownView.b bVar = this.u;
                    if (bVar != null) {
                        this.o.setOnCountDownFinished(bVar);
                    }
                    this.o.setData(g);
                } else {
                    this.p.setVisibility(8);
                }
                int i = this.b;
                if (i == wi6.c) {
                    this.q.setVisibility(0);
                } else if (i == wi6.b) {
                    this.q.setVisibility(8);
                } else {
                    this.q.setVisibility(8);
                }
                if (ni6Var.a() != null && (a3 = ni6Var.a()) != null) {
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
