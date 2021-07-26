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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.q0.x.b.d;
import d.a.q0.x.b.f;
import d.a.q0.x.e.a;
/* loaded from: classes4.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int E = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public View B;
    public VoteAdapter C;
    public LinearLayout D;

    /* renamed from: h  reason: collision with root package name */
    public Context f14515h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14516i;
    public View j;
    public TextView k;
    public TextView l;
    public CandidateInfoLayout m;
    public NewAnounceLayout n;
    public VoteAreaLayout o;
    public VotedAreaLayout p;
    public View q;
    public TextView r;
    public TextView s;
    public View t;
    public View u;
    public View v;
    public View w;
    public View x;
    public View y;
    public int z;

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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setRankVisible(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            this.f14516i.setVisibility(i2);
            this.w.setVisibility(i2);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.j = findViewById(R.id.mine_vote_content);
            this.k = (TextView) findViewById(R.id.mine_vote_title);
            this.l = (TextView) findViewById(R.id.mine_vote_num);
            this.f14516i = (TextView) findViewById(R.id.tv_voted_rank);
            this.m = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
            this.n = (NewAnounceLayout) findViewById(R.id.announce_layout);
            this.o = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
            this.p = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
            this.t = findViewById(R.id.divider_line);
            this.u = findViewById(R.id.divider_empty_view);
            this.v = findViewById(R.id.divider_line_container);
            this.w = findViewById(R.id.empty_view);
            this.x = findViewById(R.id.main_container);
            this.y = findViewById(R.id.info_container);
            this.q = findViewById(R.id.vote_ueg_warn_container);
            this.r = (TextView) findViewById(R.id.vote_ueg_warn_img);
            this.s = (TextView) findViewById(R.id.vote_ueg_warn_tv);
            this.B = findViewById(R.id.divider_top_line);
            this.A = (TextView) findViewById(R.id.title_notpass_tv);
            this.D = (LinearLayout) findViewById(R.id.not_allow_view);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f14515h = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.vote_candidate_card, (ViewGroup) this, true);
            a();
        }
    }

    public void c(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.n.d(i2);
            this.m.c(i2);
            if (this.p.getVisibility() == 0) {
                this.p.c(i2);
            }
            this.o.d(i2);
            SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204, i2);
            int i3 = this.f14490e;
            if (i3 == a.f66849d) {
                SkinManager.setBackgroundResource(this.x, R.drawable.bar_select_bg_shadow_and_radius, i2);
                SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
            } else if (i3 == a.f66848c) {
                SkinManager.setBackgroundResource(this.x, R.drawable.bg_bazhu_shadow_and_radius, i2);
            } else if (i3 == a.f66847b) {
                if (this.z == 1) {
                    SkinManager.setBackgroundResource(this.x, R.drawable.bar_select_bg_top_round, i2);
                } else {
                    SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201, i2);
                }
            } else if (i3 == a.f66846a) {
                SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201, i2);
                SkinManager.setViewTextColor(this.A, R.color.CAM_X0105, 1, i2);
                SkinManager.setBackgroundColor(this.D, R.color.CAM_X0201, i2);
                SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203, i2);
            }
            d dVar = this.f14492g;
            if (dVar == null) {
                return;
            }
            if (dVar.n()) {
                SkinManager.setViewTextColor(this.s, R.color.CAM_X0301, 1, i2);
                SkinManager.setBackgroundResource(this.r, R.drawable.icon_use_tip_red, i2);
            }
            int i4 = this.f14492g.i();
            if (i4 == 2) {
                SkinManager.setViewTextColor(this.f14516i, R.color.CAM_X0305, 1, i2);
            } else if (i4 == 3) {
                SkinManager.setViewTextColor(this.f14516i, R.color.CAM_X0312, 1, i2);
            } else {
                SkinManager.setViewTextColor(this.f14516i, R.color.CAM_X0105, 1, i2);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            this.z = i2;
            if (this.f14491f != null && this.f14492g != null && (i3 = this.f14490e) >= 0) {
                if (i3 == a.f66849d) {
                    this.x.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
                    this.j.setVisibility(0);
                    TextView textView = this.l;
                    textView.setText("当前排名" + this.f14492g.i());
                    setRankVisible(8);
                    this.v.setVisibility(8);
                    this.o.setVisibility(0);
                    this.p.setVisibility(8);
                    this.o.setData(i2, fVar);
                    this.D.setVisibility(8);
                } else if (i3 == a.f66846a) {
                    if (i2 == 0) {
                        this.v.setVisibility(8);
                    } else {
                        this.v.setVisibility(8);
                        this.u.setVisibility(8);
                    }
                    this.x.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                    this.j.setVisibility(8);
                    setRankVisible(8);
                    if (this.f14492g.f() == 2 && this.C.d() == -1) {
                        this.C.f(i2);
                    }
                    if (this.f14492g.f() == 2) {
                        VoteAdapter voteAdapter = this.C;
                        if (voteAdapter != null && voteAdapter.d() == i2) {
                            this.D.setVisibility(0);
                        } else {
                            this.D.setVisibility(8);
                        }
                        this.o.setVisibility(8);
                    } else {
                        this.D.setVisibility(8);
                        this.o.setVisibility(0);
                        this.o.setData(i2, fVar);
                    }
                    this.p.setVisibility(8);
                } else if (i3 == a.f66848c) {
                    int g2 = l.g(getContext(), R.dimen.tbds22);
                    int g3 = l.g(getContext(), R.dimen.tbds10);
                    int g4 = l.g(getContext(), R.dimen.tbds20);
                    int g5 = l.g(getContext(), R.dimen.tbds30);
                    this.x.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(g5, 0, g5, g4);
                    this.x.setLayoutParams(layoutParams);
                    this.x.setPadding(g3, 0, g3, g5);
                    this.j.setVisibility(8);
                    this.v.setVisibility(8);
                    setRankVisible(8);
                    this.o.setVisibility(8);
                    this.p.setVisibility(0);
                    this.p.setData(i2, fVar);
                    this.y.setPadding(0, g2, 0, 0);
                    this.D.setVisibility(8);
                } else if (i3 == a.f66847b) {
                    if (i2 == 1) {
                        this.x.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                        this.v.setVisibility(8);
                    } else {
                        this.x.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                        this.v.setVisibility(0);
                        this.u.setVisibility(0);
                    }
                    setRankVisible(0);
                    this.j.setVisibility(8);
                    int i4 = this.f14492g.i();
                    if (i4 < 10) {
                        TextView textView2 = this.f14516i;
                        textView2.setText("0" + i4);
                    } else {
                        TextView textView3 = this.f14516i;
                        textView3.setText("" + i4);
                    }
                    if (i4 == 2) {
                        this.f14516i.setTextColor(getResources().getColor(R.color.common_color_10263));
                    } else if (i4 == 3) {
                        this.f14516i.setTextColor(getResources().getColor(R.color.common_color_10266));
                    } else {
                        this.f14516i.setTextColor(getResources().getColor(R.color.CAM_X0105));
                    }
                    this.o.setVisibility(8);
                    this.p.setVisibility(0);
                    this.p.setData(i2, fVar);
                    this.D.setVisibility(8);
                } else {
                    setVisibility(8);
                    return;
                }
                this.m.setData(i2, fVar);
                this.n.setData(i2, fVar);
                if (this.f14492g.n()) {
                    this.q.setVisibility(0);
                } else {
                    this.q.setVisibility(8);
                }
                c(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            setVisibility(8);
        }
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, voteAdapter) == null) {
            this.C = voteAdapter;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.z = -2;
        b();
    }
}
