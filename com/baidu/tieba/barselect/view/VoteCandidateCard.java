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
import d.b.c.e.p.l;
import d.b.j0.v.b.d;
import d.b.j0.v.b.f;
import d.b.j0.v.e.a;
/* loaded from: classes4.dex */
public class VoteCandidateCard extends CardBasicLayout {
    public static int E = -1;
    public TextView A;
    public View B;
    public VoteAdapter C;
    public LinearLayout D;

    /* renamed from: h  reason: collision with root package name */
    public Context f14884h;
    public TextView i;
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

    private void setRankVisible(int i) {
        this.i.setVisibility(i);
        this.w.setVisibility(i);
    }

    public final void a() {
        this.j = findViewById(R.id.mine_vote_content);
        this.k = (TextView) findViewById(R.id.mine_vote_title);
        this.l = (TextView) findViewById(R.id.mine_vote_num);
        this.i = (TextView) findViewById(R.id.tv_voted_rank);
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
        this.f14884h = getContext();
        setClipChildren(false);
        setClipToPadding(false);
        setOrientation(1);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        LayoutInflater.from(getContext()).inflate(R.layout.vote_candidate_card, (ViewGroup) this, true);
        a();
    }

    public void c(int i) {
        this.n.d(i);
        this.m.c(i);
        if (this.p.getVisibility() == 0) {
            this.p.c(i);
        }
        this.o.d(i);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204, i);
        int i2 = this.f14864e;
        if (i2 == a.f63388d) {
            SkinManager.setBackgroundResource(this.x, R.drawable.bar_select_bg_shadow_and_radius, i);
            SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1, i);
            SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1, i);
        } else if (i2 == a.f63387c) {
            SkinManager.setBackgroundResource(this.x, R.drawable.bg_bazhu_shadow_and_radius, i);
        } else if (i2 == a.f63386b) {
            if (this.z == 1) {
                SkinManager.setBackgroundResource(this.x, R.drawable.bar_select_bg_top_round, i);
            } else {
                SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201, i);
            }
        } else if (i2 == a.f63385a) {
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0201, i);
            SkinManager.setViewTextColor(this.A, R.color.CAM_X0105, 1, i);
            SkinManager.setBackgroundColor(this.D, R.color.CAM_X0201, i);
            SkinManager.setBackgroundColor(this.B, R.color.CAM_X0203, i);
        }
        d dVar = this.f14866g;
        if (dVar == null) {
            return;
        }
        if (dVar.n()) {
            SkinManager.setViewTextColor(this.s, R.color.CAM_X0301, 1, i);
            SkinManager.setBackgroundResource(this.r, R.drawable.icon_use_tip_red, i);
        }
        int i3 = this.f14866g.i();
        if (i3 == 2) {
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0305, 1, i);
        } else if (i3 == 3) {
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0312, 1, i);
        } else {
            SkinManager.setViewTextColor(this.i, R.color.CAM_X0105, 1, i);
        }
    }

    @Override // com.baidu.tieba.barselect.segment.CardBasicLayout
    public void setData(int i, f fVar) {
        int i2;
        super.setData(i, fVar);
        this.z = i;
        if (this.f14865f != null && this.f14866g != null && (i2 = this.f14864e) >= 0) {
            if (i2 == a.f63388d) {
                this.x.setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
                this.j.setVisibility(0);
                TextView textView = this.l;
                textView.setText("当前排名" + this.f14866g.i());
                setRankVisible(8);
                this.v.setVisibility(8);
                this.o.setVisibility(0);
                this.p.setVisibility(8);
                this.o.setData(i, fVar);
                this.D.setVisibility(8);
            } else if (i2 == a.f63385a) {
                if (i == 0) {
                    this.v.setVisibility(8);
                } else {
                    this.v.setVisibility(8);
                    this.u.setVisibility(8);
                }
                this.x.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                this.j.setVisibility(8);
                setRankVisible(8);
                if (this.f14866g.f() == 2 && this.C.m() == -1) {
                    this.C.o(i);
                }
                if (this.f14866g.f() == 2) {
                    VoteAdapter voteAdapter = this.C;
                    if (voteAdapter != null && voteAdapter.m() == i) {
                        this.D.setVisibility(0);
                    } else {
                        this.D.setVisibility(8);
                    }
                    this.o.setVisibility(8);
                } else {
                    this.D.setVisibility(8);
                    this.o.setVisibility(0);
                    this.o.setData(i, fVar);
                }
                this.p.setVisibility(8);
            } else if (i2 == a.f63387c) {
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
                this.p.setData(i, fVar);
                this.y.setPadding(0, g2, 0, 0);
                this.D.setVisibility(8);
            } else if (i2 == a.f63386b) {
                if (i == 1) {
                    this.x.setBackgroundResource(R.drawable.bar_select_bg_top_round);
                    this.v.setVisibility(8);
                } else {
                    this.x.setBackgroundColor(getResources().getColor(R.color.CAM_X0201));
                    this.v.setVisibility(0);
                    this.u.setVisibility(0);
                }
                setRankVisible(0);
                this.j.setVisibility(8);
                int i3 = this.f14866g.i();
                if (i3 < 10) {
                    TextView textView2 = this.i;
                    textView2.setText("0" + i3);
                } else {
                    TextView textView3 = this.i;
                    textView3.setText("" + i3);
                }
                if (i3 == 2) {
                    this.i.setTextColor(getResources().getColor(R.color.common_color_10263));
                } else if (i3 == 3) {
                    this.i.setTextColor(getResources().getColor(R.color.common_color_10266));
                } else {
                    this.i.setTextColor(getResources().getColor(R.color.CAM_X0105));
                }
                this.o.setVisibility(8);
                this.p.setVisibility(0);
                this.p.setData(i, fVar);
                this.D.setVisibility(8);
            } else {
                setVisibility(8);
                return;
            }
            this.m.setData(i, fVar);
            this.n.setData(i, fVar);
            if (this.f14866g.n()) {
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
