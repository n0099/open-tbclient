package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.VoteAdapter;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
import com.baidu.tieba.mh6;
import com.baidu.tieba.oh6;
import com.baidu.tieba.vh6;
import com.baidu.tieba.vi;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int A = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public Context d;
    public TextView e;
    public View f;
    public TextView g;
    public TextView h;
    public CandidateInfoLayout i;
    public NewAnounceLayout j;
    public VoteAreaLayout k;
    public VotedAreaLayout l;
    public View m;
    public TextView n;
    public TextView o;
    public View p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public int v;
    public TextView w;
    public View x;
    public VoteAdapter y;
    public LinearLayout z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1354838674, "Lcom/baidu/tieba/barselect/view/VoteCandidateCard;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1354838674, "Lcom/baidu/tieba/barselect/view/VoteCandidateCard;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VoteCandidateCard(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoteCandidateCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.v = -2;
        b();
    }

    private void setRankVisible(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            this.e.setVisibility(i);
            this.s.setVisibility(i);
        }
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, voteAdapter) == null) {
            this.y = voteAdapter;
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f = findViewById(R.id.obfuscated_res_0x7f091725);
            this.g = (TextView) findViewById(R.id.obfuscated_res_0x7f091727);
            this.h = (TextView) findViewById(R.id.obfuscated_res_0x7f091726);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f0926d7);
            this.i = (CandidateInfoLayout) findViewById(R.id.obfuscated_res_0x7f09053b);
            this.j = (NewAnounceLayout) findViewById(R.id.obfuscated_res_0x7f090296);
            this.k = (VoteAreaLayout) findViewById(R.id.obfuscated_res_0x7f0928ea);
            this.l = (VotedAreaLayout) findViewById(R.id.obfuscated_res_0x7f092915);
            this.p = findViewById(R.id.obfuscated_res_0x7f0908f4);
            this.q = findViewById(R.id.obfuscated_res_0x7f0908ef);
            this.r = findViewById(R.id.obfuscated_res_0x7f0908fa);
            this.s = findViewById(R.id.empty_view);
            this.t = findViewById(R.id.main_container);
            this.u = findViewById(R.id.info_container);
            this.m = findViewById(R.id.obfuscated_res_0x7f09290f);
            this.n = (TextView) findViewById(R.id.obfuscated_res_0x7f092910);
            this.o = (TextView) findViewById(R.id.obfuscated_res_0x7f092911);
            this.x = findViewById(R.id.obfuscated_res_0x7f090905);
            this.w = (TextView) findViewById(R.id.obfuscated_res_0x7f0924c0);
            this.z = (LinearLayout) findViewById(R.id.obfuscated_res_0x7f091908);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.d = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d09d7, (ViewGroup) this, true);
            a();
        }
    }

    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.j.d(i);
            this.i.c(i);
            if (this.l.getVisibility() == 0) {
                this.l.c(i);
            }
            this.k.d(i);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204, i);
            int i2 = this.a;
            if (i2 == vh6.d) {
                SkinManager.setBackgroundResource(this.t, R.drawable.bar_select_bg_shadow_and_radius, i);
                SkinManager.setViewTextColor(this.h, R.color.CAM_X0105, 1, i);
                SkinManager.setViewTextColor(this.g, R.color.CAM_X0105, 1, i);
            } else if (i2 == vh6.c) {
                SkinManager.setBackgroundResource(this.t, R.drawable.bg_bazhu_shadow_and_radius, i);
            } else if (i2 == vh6.b) {
                if (this.v == 1) {
                    SkinManager.setBackgroundResource(this.t, R.drawable.bar_select_bg_top_round, i);
                } else {
                    SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201, i);
                }
            } else if (i2 == vh6.a) {
                SkinManager.setBackgroundColor(this.t, R.color.CAM_X0201, i);
                SkinManager.setViewTextColor(this.w, R.color.CAM_X0105, 1, i);
                SkinManager.setBackgroundColor(this.z, R.color.CAM_X0201, i);
                SkinManager.setBackgroundColor(this.x, R.color.CAM_X0203, i);
            }
            mh6 mh6Var = this.c;
            if (mh6Var == null) {
                return;
            }
            if (mh6Var.n()) {
                SkinManager.setViewTextColor(this.o, R.color.CAM_X0301, 1, i);
                SkinManager.setBackgroundResource(this.n, R.drawable.icon_use_tip_red, i);
            }
            int i3 = this.c.i();
            if (i3 == 2) {
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0305, 1, i);
            } else if (i3 == 3) {
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0312, 1, i);
            } else {
                SkinManager.setViewTextColor(this.e, R.color.CAM_X0105, 1, i);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, oh6 oh6Var) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i, oh6Var) == null) {
            super.setData(i, oh6Var);
            this.v = i;
            if (this.b != null && this.c != null && (i2 = this.a) >= 0) {
                if (i2 == vh6.d) {
                    this.t.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
                    this.f.setVisibility(0);
                    TextView textView = this.h;
                    textView.setText("当前排名" + this.c.i());
                    setRankVisible(8);
                    this.r.setVisibility(8);
                    this.k.setVisibility(0);
                    this.l.setVisibility(8);
                    this.k.setData(i, oh6Var);
                    this.z.setVisibility(8);
                } else if (i2 == vh6.a) {
                    if (i == 0) {
                        this.r.setVisibility(8);
                    } else {
                        this.r.setVisibility(8);
                        this.q.setVisibility(8);
                    }
                    this.t.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                    this.f.setVisibility(8);
                    setRankVisible(8);
                    if (this.c.f() == 2 && this.y.k() == -1) {
                        this.y.m(i);
                    }
                    if (this.c.f() == 2) {
                        VoteAdapter voteAdapter = this.y;
                        if (voteAdapter != null && voteAdapter.k() == i) {
                            this.z.setVisibility(0);
                        } else {
                            this.z.setVisibility(8);
                        }
                        this.k.setVisibility(8);
                    } else {
                        this.z.setVisibility(8);
                        this.k.setVisibility(0);
                        this.k.setData(i, oh6Var);
                    }
                    this.l.setVisibility(8);
                } else if (i2 == vh6.c) {
                    int g = vi.g(getContext(), R.dimen.tbds22);
                    int g2 = vi.g(getContext(), R.dimen.tbds10);
                    int g3 = vi.g(getContext(), R.dimen.tbds20);
                    int g4 = vi.g(getContext(), R.dimen.tbds30);
                    this.t.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(g4, 0, g4, g3);
                    this.t.setLayoutParams(layoutParams);
                    this.t.setPadding(g2, 0, g2, g4);
                    this.f.setVisibility(8);
                    this.r.setVisibility(8);
                    setRankVisible(8);
                    this.k.setVisibility(8);
                    this.l.setVisibility(0);
                    this.l.setData(i, oh6Var);
                    this.u.setPadding(0, g, 0, 0);
                    this.z.setVisibility(8);
                } else if (i2 == vh6.b) {
                    if (i == 1) {
                        this.t.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                        this.r.setVisibility(8);
                    } else {
                        this.t.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                        this.r.setVisibility(0);
                        this.q.setVisibility(0);
                    }
                    setRankVisible(0);
                    this.f.setVisibility(8);
                    int i3 = this.c.i();
                    if (i3 < 10) {
                        TextView textView2 = this.e;
                        textView2.setText("0" + i3);
                    } else {
                        TextView textView3 = this.e;
                        textView3.setText("" + i3);
                    }
                    if (i3 == 2) {
                        this.e.setTextColor(getResources().getColor(R.color.common_color_10263));
                    } else if (i3 == 3) {
                        this.e.setTextColor(getResources().getColor(R.color.common_color_10266));
                    } else {
                        this.e.setTextColor(getResources().getColor(R.color.CAM_X0105));
                    }
                    this.k.setVisibility(8);
                    this.l.setVisibility(0);
                    this.l.setData(i, oh6Var);
                    this.z.setVisibility(8);
                } else {
                    setVisibility(8);
                    return;
                }
                this.i.setData(i, oh6Var);
                this.j.setData(i, oh6Var);
                if (this.c.n()) {
                    this.m.setVisibility(0);
                } else {
                    this.m.setVisibility(8);
                }
                c(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            setVisibility(8);
        }
    }
}
