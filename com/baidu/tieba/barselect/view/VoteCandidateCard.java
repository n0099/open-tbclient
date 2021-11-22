package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b.a.e.f.p.l;
import b.a.r0.y.b.d;
import b.a.r0.y.b.f;
import b.a.r0.y.e.a;
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
/* loaded from: classes8.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static int MINE_VOTE = -1;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout A;

    /* renamed from: e  reason: collision with root package name */
    public Context f48238e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f48239f;

    /* renamed from: g  reason: collision with root package name */
    public View f48240g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f48241h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f48242i;
    public CandidateInfoLayout j;
    public NewAnounceLayout k;
    public VoteAreaLayout l;
    public VotedAreaLayout m;
    public View n;
    public TextView o;
    public TextView p;
    public View q;
    public View r;
    public View s;
    public View t;
    public View u;
    public View v;
    public int w;
    public TextView x;
    public View y;
    public VoteAdapter z;

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
            this.f48239f.setVisibility(i2);
            this.t.setVisibility(i2);
        }
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f48240g = findViewById(R.id.mine_vote_content);
            this.f48241h = (TextView) findViewById(R.id.mine_vote_title);
            this.f48242i = (TextView) findViewById(R.id.mine_vote_num);
            this.f48239f = (TextView) findViewById(R.id.tv_voted_rank);
            this.j = (CandidateInfoLayout) findViewById(R.id.candidate_info_layout);
            this.k = (NewAnounceLayout) findViewById(R.id.announce_layout);
            this.l = (VoteAreaLayout) findViewById(R.id.vote_area_layout);
            this.m = (VotedAreaLayout) findViewById(R.id.voted_area_layout);
            this.q = findViewById(R.id.divider_line);
            this.r = findViewById(R.id.divider_empty_view);
            this.s = findViewById(R.id.divider_line_container);
            this.t = findViewById(R.id.empty_view);
            this.u = findViewById(R.id.main_container);
            this.v = findViewById(R.id.info_container);
            this.n = findViewById(R.id.vote_ueg_warn_container);
            this.o = (TextView) findViewById(R.id.vote_ueg_warn_img);
            this.p = (TextView) findViewById(R.id.vote_ueg_warn_tv);
            this.y = findViewById(R.id.divider_top_line);
            this.x = (TextView) findViewById(R.id.title_notpass_tv);
            this.A = (LinearLayout) findViewById(R.id.not_allow_view);
        }
    }

    public final void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f48238e = getContext();
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            LayoutInflater.from(getContext()).inflate(R.layout.vote_candidate_card, (ViewGroup) this, true);
            a();
        }
    }

    public void onSkinChange(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.k.onSkinChange(i2);
            this.j.onSkinChange(i2);
            if (this.m.getVisibility() == 0) {
                this.m.onSkinChange(i2);
            }
            this.l.onSkinChange(i2);
            SkinManager.setBackgroundColor(this.q, R.color.CAM_X0204, i2);
            int i3 = this.status;
            if (i3 == a.f28726d) {
                SkinManager.setBackgroundResource(this.u, R.drawable.bar_select_bg_shadow_and_radius, i2);
                SkinManager.setViewTextColor(this.f48242i, R.color.CAM_X0105, 1, i2);
                SkinManager.setViewTextColor(this.f48241h, R.color.CAM_X0105, 1, i2);
            } else if (i3 == a.f28725c) {
                SkinManager.setBackgroundResource(this.u, R.drawable.bg_bazhu_shadow_and_radius, i2);
            } else if (i3 == a.f28724b) {
                if (this.w == 1) {
                    SkinManager.setBackgroundResource(this.u, R.drawable.bar_select_bg_top_round, i2);
                } else {
                    SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201, i2);
                }
            } else if (i3 == a.f28723a) {
                SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201, i2);
                SkinManager.setViewTextColor(this.x, R.color.CAM_X0105, 1, i2);
                SkinManager.setBackgroundColor(this.A, R.color.CAM_X0201, i2);
                SkinManager.setBackgroundColor(this.y, R.color.CAM_X0203, i2);
            }
            d dVar = this.mElectionData;
            if (dVar == null) {
                return;
            }
            if (dVar.n()) {
                SkinManager.setViewTextColor(this.p, R.color.CAM_X0301, 1, i2);
                SkinManager.setBackgroundResource(this.o, R.drawable.icon_use_tip_red, i2);
            }
            int i4 = this.mElectionData.i();
            if (i4 == 2) {
                SkinManager.setViewTextColor(this.f48239f, R.color.CAM_X0305, 1, i2);
            } else if (i4 == 3) {
                SkinManager.setViewTextColor(this.f48239f, R.color.CAM_X0312, 1, i2);
            } else {
                SkinManager.setViewTextColor(this.f48239f, R.color.CAM_X0105, 1, i2);
            }
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048579, this, i2, fVar) == null) {
            super.setData(i2, fVar);
            this.w = i2;
            if (this.mData != null && this.mElectionData != null && (i3 = this.status) >= 0) {
                if (i3 == a.f28726d) {
                    this.u.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
                    this.f48240g.setVisibility(0);
                    TextView textView = this.f48242i;
                    textView.setText("当前排名" + this.mElectionData.i());
                    setRankVisible(8);
                    this.s.setVisibility(8);
                    this.l.setVisibility(0);
                    this.m.setVisibility(8);
                    this.l.setData(i2, fVar);
                    this.A.setVisibility(8);
                } else if (i3 == a.f28723a) {
                    if (i2 == 0) {
                        this.s.setVisibility(8);
                    } else {
                        this.s.setVisibility(8);
                        this.r.setVisibility(8);
                    }
                    this.u.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                    this.f48240g.setVisibility(8);
                    setRankVisible(8);
                    if (this.mElectionData.f() == 2 && this.z.getFirstNotAllowPosition() == -1) {
                        this.z.setFirstNotAllowPosition(i2);
                    }
                    if (this.mElectionData.f() == 2) {
                        VoteAdapter voteAdapter = this.z;
                        if (voteAdapter != null && voteAdapter.getFirstNotAllowPosition() == i2) {
                            this.A.setVisibility(0);
                        } else {
                            this.A.setVisibility(8);
                        }
                        this.l.setVisibility(8);
                    } else {
                        this.A.setVisibility(8);
                        this.l.setVisibility(0);
                        this.l.setData(i2, fVar);
                    }
                    this.m.setVisibility(8);
                } else if (i3 == a.f28725c) {
                    int g2 = l.g(getContext(), R.dimen.tbds22);
                    int g3 = l.g(getContext(), R.dimen.tbds10);
                    int g4 = l.g(getContext(), R.dimen.tbds20);
                    int g5 = l.g(getContext(), R.dimen.tbds30);
                    this.u.setBackgroundResource(R.drawable.bg_bazhu_shadow_and_radius);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(g5, 0, g5, g4);
                    this.u.setLayoutParams(layoutParams);
                    this.u.setPadding(g3, 0, g3, g5);
                    this.f48240g.setVisibility(8);
                    this.s.setVisibility(8);
                    setRankVisible(8);
                    this.l.setVisibility(8);
                    this.m.setVisibility(0);
                    this.m.setData(i2, fVar);
                    this.v.setPadding(0, g2, 0, 0);
                    this.A.setVisibility(8);
                } else if (i3 == a.f28724b) {
                    if (i2 == 1) {
                        this.u.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                        this.s.setVisibility(8);
                    } else {
                        this.u.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                        this.s.setVisibility(0);
                        this.r.setVisibility(0);
                    }
                    setRankVisible(0);
                    this.f48240g.setVisibility(8);
                    int i4 = this.mElectionData.i();
                    if (i4 < 10) {
                        TextView textView2 = this.f48239f;
                        textView2.setText("0" + i4);
                    } else {
                        TextView textView3 = this.f48239f;
                        textView3.setText("" + i4);
                    }
                    if (i4 == 2) {
                        this.f48239f.setTextColor(getResources().getColor(R.color.common_color_10263));
                    } else if (i4 == 3) {
                        this.f48239f.setTextColor(getResources().getColor(R.color.common_color_10266));
                    } else {
                        this.f48239f.setTextColor(getResources().getColor(R.color.CAM_X0105));
                    }
                    this.l.setVisibility(8);
                    this.m.setVisibility(0);
                    this.m.setData(i2, fVar);
                    this.A.setVisibility(8);
                } else {
                    setVisibility(8);
                    return;
                }
                this.j.setData(i2, fVar);
                this.k.setData(i2, fVar);
                if (this.mElectionData.n()) {
                    this.n.setVisibility(0);
                } else {
                    this.n.setVisibility(8);
                }
                onSkinChange(TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            setVisibility(8);
        }
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, voteAdapter) == null) {
            this.z = voteAdapter;
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
        this.w = -2;
        initUI();
    }
}
