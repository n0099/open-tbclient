package com.baidu.tieba.frs;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.widget.TbImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class WorldCupView extends RelativeLayout {
    private Context a;
    private RelativeLayout b;
    private TextView c;
    private View d;
    private RelativeLayout e;
    private TextView f;
    private TextView g;
    private TbImageView h;
    private View i;
    private RelativeLayout j;
    private RelativeLayout k;
    private RelativeLayout l;
    private RelativeLayout m;
    private TbImageView n;
    private TextView o;
    private TbImageView p;
    private TextView q;
    private TextView r;
    private TextView s;
    private View t;

    public WorldCupView(Context context) {
        this(context, null);
    }

    public WorldCupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WorldCupView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        a();
    }

    private void a() {
        LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.worldcup_view, (ViewGroup) this, true);
        this.b = (RelativeLayout) findViewById(com.baidu.tieba.v.news);
        this.c = (TextView) findViewById(com.baidu.tieba.v.news_title);
        this.d = findViewById(com.baidu.tieba.v.news_divider);
        this.e = (RelativeLayout) findViewById(com.baidu.tieba.v.pk);
        this.f = (TextView) findViewById(com.baidu.tieba.v.pk_sum_game);
        this.g = (TextView) findViewById(com.baidu.tieba.v.pk_sum_bonus);
        this.h = (TbImageView) findViewById(com.baidu.tieba.v.pk_prize_image);
        this.i = findViewById(com.baidu.tieba.v.pk_divider);
        this.j = (RelativeLayout) findViewById(com.baidu.tieba.v.prize_lay);
        this.k = (RelativeLayout) findViewById(com.baidu.tieba.v.lottery_score);
        this.l = (RelativeLayout) findViewById(com.baidu.tieba.v.lottery);
        this.m = (RelativeLayout) findViewById(com.baidu.tieba.v.score_lay);
        this.n = (TbImageView) findViewById(com.baidu.tieba.v.logo_team1);
        this.o = (TextView) findViewById(com.baidu.tieba.v.name_team1);
        this.p = (TbImageView) findViewById(com.baidu.tieba.v.logo_team2);
        this.q = (TextView) findViewById(com.baidu.tieba.v.name_team2);
        this.r = (TextView) findViewById(com.baidu.tieba.v.game_title);
        this.s = (TextView) findViewById(com.baidu.tieba.v.game_status);
        this.t = findViewById(com.baidu.tieba.v.lottery_score_divider);
        setNewsLayVisible(false);
        setPkLayVisible(false);
        setLotteryGameLayVisible(false);
    }

    public void setData(com.baidu.tbadk.core.data.p pVar) {
        if (pVar == null) {
            setNewsLayVisible(false);
            setPkLayVisible(false);
            setLotteryGameLayVisible(false);
            return;
        }
        setNewsData(pVar.a());
        setPkData(pVar.b());
        a(pVar.c(), pVar.d());
    }

    private void setNewsData(com.baidu.tbadk.core.data.s sVar) {
        if (sVar == null) {
            setNewsLayVisible(false);
        } else if (!TextUtils.isEmpty(sVar.b())) {
            setNewsLayVisible(true);
            this.c.setText(sVar.b());
            this.b.setOnClickListener(new du(this, sVar));
        } else {
            setNewsLayVisible(false);
        }
    }

    private void setPkData(com.baidu.tbadk.core.data.t tVar) {
        if (tVar == null) {
            setPkLayVisible(false);
        } else if (TextUtils.isEmpty(tVar.a()) || TextUtils.isEmpty(tVar.b())) {
            setPkLayVisible(false);
        } else {
            setPkLayVisible(true);
            String str = "";
            if (!TextUtils.isEmpty(tVar.a())) {
                str = tVar.a();
            }
            this.f.setText(str);
            String str2 = "";
            if (!TextUtils.isEmpty(tVar.b())) {
                str2 = tVar.b();
            }
            this.g.setText(str2);
            if (TextUtils.isEmpty(tVar.c())) {
                this.j.setVisibility(8);
            } else {
                this.j.setVisibility(0);
            }
            this.h.a(tVar.c(), 10, false);
            this.e.setOnClickListener(new dv(this, tVar));
        }
    }

    private void a(com.baidu.tbadk.core.data.r rVar, com.baidu.tbadk.core.data.q qVar) {
        String str;
        String str2;
        if (rVar == null || qVar == null) {
            setLotteryGameLayVisible(false);
            return;
        }
        setLotteryGameLayVisible(true);
        this.l.setOnClickListener(new dw(this, rVar));
        ArrayList<com.baidu.tbadk.core.data.u> a = qVar.a();
        if (a != null && a.size() == 2) {
            com.baidu.tbadk.core.data.u uVar = a.get(0);
            this.n.setDrawBorder(true);
            this.n.a(uVar.b(), 10, false);
            if (TextUtils.isEmpty(uVar.a())) {
                str = "";
            } else {
                str = uVar.a();
            }
            this.o.setText(str);
            com.baidu.tbadk.core.data.u uVar2 = a.get(1);
            this.p.setDrawBorder(true);
            this.p.a(uVar2.b(), 10, false);
            if (TextUtils.isEmpty(uVar2.a())) {
                str2 = "";
            } else {
                str2 = uVar2.a();
            }
            this.q.setText(str2);
            String str3 = "";
            if (!TextUtils.isEmpty(qVar.b())) {
                str3 = qVar.b();
            }
            this.r.setText(str3);
            String str4 = "";
            if (!TextUtils.isEmpty(qVar.c())) {
                str4 = qVar.c();
            }
            this.s.setText(str4);
            this.m.setOnClickListener(new dx(this, qVar));
            return;
        }
        setLotteryGameLayVisible(false);
    }

    private void setNewsLayVisible(boolean z) {
        if (z) {
            this.b.setVisibility(0);
            this.d.setVisibility(0);
            return;
        }
        this.b.setVisibility(8);
        this.d.setVisibility(8);
    }

    private void setPkLayVisible(boolean z) {
        if (z) {
            this.e.setVisibility(0);
            this.i.setVisibility(0);
            return;
        }
        this.e.setVisibility(8);
        this.i.setVisibility(8);
    }

    private void setLotteryGameLayVisible(boolean z) {
        if (z) {
            this.k.setVisibility(0);
            this.t.setVisibility(0);
            return;
        }
        this.k.setVisibility(8);
        this.t.setVisibility(8);
    }

    public void a(int i) {
        if (this.a instanceof BaseActivity) {
            ((BaseActivity) this.a).getLayoutMode().a(i == 1);
            ((BaseActivity) this.a).getLayoutMode().a((View) this);
        } else if (this.a instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) this.a).c().a(i == 1);
            ((BaseFragmentActivity) this.a).c().a((View) this);
        }
    }
}
