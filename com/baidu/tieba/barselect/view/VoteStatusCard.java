package com.baidu.tieba.barselect.view;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.view.NewVoteCountDownView;
import d.a.c.e.p.l;
import d.a.n0.x.b.e;
import d.a.n0.x.b.f;
import d.a.n0.x.e.c;
/* loaded from: classes4.dex */
public class VoteStatusCard extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f14261e;

    /* renamed from: f  reason: collision with root package name */
    public int f14262f;

    /* renamed from: g  reason: collision with root package name */
    public f f14263g;

    /* renamed from: h  reason: collision with root package name */
    public e f14264h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f14265i;
    public VoteStatusView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public NewVoteCountDownView q;
    public View r;
    public Path s;
    public b t;
    public NewVoteCountDownView.b u;

    /* loaded from: classes4.dex */
    public class a implements NewVoteCountDownView.b {
        public a() {
        }

        @Override // com.baidu.tieba.view.NewVoteCountDownView.b
        public void a() {
            if (VoteStatusCard.this.t != null) {
                VoteStatusCard.this.t.onRefresh();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void onRefresh();
    }

    public VoteStatusCard(Context context) {
        this(context, null);
    }

    public final void b() {
        this.f14265i = (TextView) findViewById(R.id.bar_maneger_apply_title);
        this.j = (VoteStatusView) findViewById(R.id.vote_status_view);
        this.k = (TextView) findViewById(R.id.apply_title);
        this.l = (TextView) findViewById(R.id.apply_start_time);
        this.m = (TextView) findViewById(R.id.vote_title);
        this.n = (TextView) findViewById(R.id.vote_start_time);
        this.o = (TextView) findViewById(R.id.publicity_title);
        this.p = (TextView) findViewById(R.id.publicity_start_time);
        this.r = findViewById(R.id.vote_count_down_container);
        this.q = (NewVoteCountDownView) findViewById(R.id.vote_count_down_view);
    }

    public final void c() {
        Path path = new Path();
        this.s = path;
        path.moveTo(0.0f, 15.0f);
        this.s.lineTo(440.0f, 15.0f);
        this.s.lineTo(454.0f, 0.0f);
        this.s.lineTo(468.0f, 15.0f);
        this.s.lineTo(902.0f, 15.0f);
        this.s.lineTo(902.0f, 224.0f);
        this.s.lineTo(0.0f, 224.0f);
        this.s.lineTo(0.0f, 15.0f);
        this.s.close();
    }

    public final void d() {
        this.f14261e = getContext();
        setOrientation(1);
        setMinimumHeight(l.g(getContext(), R.dimen.tbds90));
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setBackgroundResource(R.drawable.bar_select_bg_shadow_and_radius);
        int g2 = l.g(this.f14261e, R.dimen.tbds56);
        int g3 = l.g(this.f14261e, R.dimen.tbds52);
        setPadding(g2, g3, g2, g3);
        LayoutInflater.from(getContext()).inflate(R.layout.vote_status_card, (ViewGroup) this, true);
        b();
        c();
    }

    public void e() {
        NewVoteCountDownView newVoteCountDownView = this.q;
        if (newVoteCountDownView != null) {
            newVoteCountDownView.e();
        }
    }

    public void f(int i2) {
        int color = SkinManager.getColor(i2, R.color.CAM_X0105);
        int color2 = SkinManager.getColor(i2, R.color.CAM_X0109);
        TextView textView = this.k;
        if (textView != null) {
            textView.setTextColor(color);
        }
        TextView textView2 = this.m;
        if (textView2 != null) {
            textView2.setTextColor(this.f14262f > c.f66920a ? color : color2);
        }
        TextView textView3 = this.o;
        if (textView3 != null) {
            if (this.f14262f <= c.f66921b) {
                color = color2;
            }
            textView3.setTextColor(color);
        }
        VoteStatusView voteStatusView = this.j;
        if (voteStatusView != null) {
            voteStatusView.b(i2);
        }
        SkinManager.setViewTextColor(this.f14265i, R.color.CAM_X0105, 1, i2);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0109, 1, i2);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0109, 1, i2);
        SkinManager.setViewTextColor(this.p, R.color.CAM_X0109, 1, i2);
        SkinManager.setBackgroundResource(this, R.drawable.bar_select_bg_shadow_and_radius, i2);
        NewVoteCountDownView newVoteCountDownView = this.q;
        if (newVoteCountDownView != null) {
            newVoteCountDownView.f(i2);
        }
        int color3 = SkinManager.getColor(R.color.CAM_X0206);
        d.a.n0.v3.e eVar = new d.a.n0.v3.e(this.s, 902.0f, 224.0f);
        eVar.a(color3);
        this.r.setBackground(eVar);
    }

    public void setData(f fVar) {
        this.f14263g = fVar;
        if (fVar != null && fVar.a() != null) {
            e a2 = this.f14263g.a();
            this.f14264h = a2;
            int g2 = a2.g();
            this.f14262f = g2;
            this.j.setStatus(g2);
            long f2 = this.f14264h.f() * 1000;
            this.l.setText(StringHelper.getDateStringMd(this.f14264h.c() * 1000));
            this.n.setText(StringHelper.getDateStringMdHm(this.f14264h.h() * 1000));
            this.p.setText(StringHelper.getDateStringMdHm(this.f14264h.d() * 1000));
            if (this.f14262f == c.f66921b) {
                this.r.setVisibility(0);
                NewVoteCountDownView.b bVar = this.u;
                if (bVar != null) {
                    this.q.setOnCountDownFinished(bVar);
                }
                this.q.setData(f2);
                return;
            }
            this.r.setVisibility(8);
            return;
        }
        setVisibility(8);
    }

    public void setOnRefreshListener(b bVar) {
        this.t = bVar;
    }

    public VoteStatusCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14262f = c.f66921b;
        this.u = new a();
        d();
    }
}
