package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.barselect.VoteAdapter;
import com.baidu.tieba.barselect.segment.CandidateInfoLayout;
import com.baidu.tieba.barselect.segment.CardBasicLayout;
import com.baidu.tieba.barselect.segment.NewAnounceLayout;
import com.baidu.tieba.barselect.segment.VoteAreaLayout;
import com.baidu.tieba.barselect.segment.VotedAreaLayout;
import d.a.c.e.p.l;
import d.a.k0.v.b.d;
import d.a.k0.v.b.f;
import d.a.k0.v.e.a;
/* loaded from: classes4.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int E = -1;
    public TextView A;
    public View B;
    public VoteAdapter C;
    public LinearLayout D;

    /* renamed from: h  reason: collision with root package name */
    public Context f14299h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14300i;
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

    public VoteCandidateCard(Context context) {
        this(context, null);
    }

    private void setRankVisible(int i2) {
        this.f14300i.setVisibility(i2);
        this.w.setVisibility(i2);
    }

    public final void a() {
        this.j = findViewById(R.id.mine_vote_content);
        this.k = (TextView) findViewById(R.id.mine_vote_title);
        this.l = (TextView) findViewById(R.id.mine_vote_num);
        this.f14300i = (TextView) findViewById(R.id.tv_voted_rank);
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

    public final void b() {
        this.f14299h = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_candidate_card, (ViewGroup) this, true);
        a();
    }

    public void c(int i2) {
        this.n.d(i2);
        this.m.c(i2);
        if (this.p.getVisibility() == 0) {
            this.p.c(i2);
        }
        this.o.d(i2);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204, i2);
        int i3 = this.f14274e;
        if (i3 == a.f62342d) {
            SkinManager.setBackgroundResource(this.x, R.drawable.bar_select_bg_shadow_and_radius, i2);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i2);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i2);
        } else if (i3 == a.f62341c) {
            SkinManager.setBackgroundResource(this.x, R.drawable.bg_bazhu_shadow_and_radius, i2);
        } else if (i3 == a.f62340b) {
            if (this.z == 1) {
                SkinManager.setBackgroundResource(this.x, R.drawable.bar_select_bg_top_round, i2);
            } else {
                SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201, i2);
            }
        } else if (i3 == a.f62339a) {
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201, i2);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0105, 1, i2);
            SkinManager.setBackgroundColor(this.D, R.color.CAM_X0201, i2);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203, i2);
        }
        d dVar = this.f14276g;
        if (dVar == null) {
            return;
        }
        if (dVar.n()) {
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0301, 1, i2);
            SkinManager.setBackgroundResource(this.r, R.drawable.icon_use_tip_red, i2);
        }
        int i4 = this.f14276g.i();
        if (i4 == 2) {
            SkinManager.setViewTextColor(this.f14300i, R.color.CAM_X0305, 1, i2);
        } else if (i4 == 3) {
            SkinManager.setViewTextColor(this.f14300i, R.color.CAM_X0312, 1, i2);
        } else {
            SkinManager.setViewTextColor(this.f14300i, R.color.CAM_X0105, 1, i2);
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i2, f fVar) {
        int i3;
        super.setData(i2, fVar);
        this.z = i2;
        if (this.f14275f != null && this.f14276g != null && (i3 = this.f14274e) >= 0) {
            if (i3 == a.f62342d) {
                this.x.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
                this.j.setVisibility(0);
                TextView textView = this.l;
                textView.setText("当前排名" + this.f14276g.i());
                setRankVisible(8);
                this.v.setVisibility(8);
                this.o.setVisibility(0);
                this.p.setVisibility(8);
                this.o.setData(i2, fVar);
                this.D.setVisibility(8);
            } else if (i3 == a.f62339a) {
                if (i2 == 0) {
                    this.v.setVisibility(8);
                } else {
                    this.v.setVisibility(8);
                    this.u.setVisibility(8);
                }
                this.x.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.j.setVisibility(8);
                setRankVisible(8);
                if (this.f14276g.f() == 2 && this.C.c() == -1) {
                    this.C.e(i2);
                }
                if (this.f14276g.f() == 2) {
                    VoteAdapter voteAdapter = this.C;
                    if (voteAdapter != null && voteAdapter.c() == i2) {
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
            } else if (i3 == a.f62341c) {
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
            } else if (i3 == a.f62340b) {
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
                int i4 = this.f14276g.i();
                if (i4 < 10) {
                    TextView textView2 = this.f14300i;
                    textView2.setText("0" + i4);
                } else {
                    TextView textView3 = this.f14300i;
                    textView3.setText("" + i4);
                }
                if (i4 == 2) {
                    this.f14300i.setTextColor(getResources().getColor(R.color.common_color_10263));
                } else if (i4 == 3) {
                    this.f14300i.setTextColor(getResources().getColor(R.color.common_color_10266));
                } else {
                    this.f14300i.setTextColor(getResources().getColor(R.color.CAM_X0105));
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
            if (this.f14276g.n()) {
                this.q.setVisibility(0);
            } else {
                this.q.setVisibility(8);
            }
            c(TbadkCoreApplication.getInst().getSkinType());
            return;
        }
        setVisibility(8);
    }

    public void setVoteAdaPter(VoteAdapter voteAdapter) {
        this.C = voteAdapter;
    }

    public VoteCandidateCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.z = -2;
        b();
    }
}
