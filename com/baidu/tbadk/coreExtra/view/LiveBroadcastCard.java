package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.view.GroupImageView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public class LiveBroadcastCard extends RelativeLayout {
    private boolean A;
    private long B;
    private int C;
    private String D;
    private int E;
    private CustomMessageListener F;
    private ad a;
    private ag b;
    private Context c;
    private ViewGroup d;
    private GroupImageView e;
    private ViewGroup f;
    private TextView g;
    private ViewGroup h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    private ViewGroup m;
    private ViewGroup n;
    private TextView o;
    private TextView p;
    private ViewGroup q;
    private TextView r;
    private TextView s;
    private Button t;
    private ImageView u;
    private ImageView v;
    private ImageView w;
    private boolean x;
    private boolean y;
    private boolean z;

    public void setCardClickListener(ad adVar) {
        this.a = adVar;
    }

    public void setDeleteButtonClickListener(ag agVar) {
        this.b = agVar;
    }

    public String getStatisticsKey() {
        return this.D;
    }

    public void setStatisticsKey(String str) {
        this.D = str;
    }

    public void setIsTopTipShow(boolean z) {
        this.z = z;
    }

    public void setIsHideSHow(boolean z) {
        this.A = z;
    }

    public LiveBroadcastCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.E = 0;
        this.F = new aa(this, 2012113);
        a(context, attributeSet);
    }

    public LiveBroadcastCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = 0;
        this.F = new aa(this, 2012113);
        a(context, attributeSet);
    }

    public LiveBroadcastCard(Context context) {
        super(context);
        this.E = 0;
        this.F = new aa(this, 2012113);
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.c = context;
        View a = com.baidu.adp.lib.e.b.a().a(context, com.baidu.tieba.v.livebroadcastcardview, this);
        this.d = (ViewGroup) a.findViewById(com.baidu.tieba.u.card_root);
        this.e = (GroupImageView) a.findViewById(com.baidu.tieba.u.card_head);
        this.e.setDrawBorder(true);
        this.e.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f = (ViewGroup) a.findViewById(com.baidu.tieba.u.card_middle);
        this.g = (TextView) a.findViewById(com.baidu.tieba.u.card_name);
        this.h = (ViewGroup) a.findViewById(com.baidu.tieba.u.card_texts_center);
        this.i = (TextView) a.findViewById(com.baidu.tieba.u.card_listener_count);
        this.j = (TextView) a.findViewById(com.baidu.tieba.u.card_liker_count);
        this.k = (TextView) a.findViewById(com.baidu.tieba.u.card_author);
        this.l = (TextView) a.findViewById(com.baidu.tieba.u.card_intro);
        this.m = (ViewGroup) a.findViewById(com.baidu.tieba.u.card_right);
        this.n = (ViewGroup) a.findViewById(com.baidu.tieba.u.card_state);
        this.o = (TextView) a.findViewById(com.baidu.tieba.u.card_state_living);
        this.p = (TextView) a.findViewById(com.baidu.tieba.u.card_time);
        this.q = (ViewGroup) a.findViewById(com.baidu.tieba.u.card_state_willstart_layout);
        this.r = (TextView) a.findViewById(com.baidu.tieba.u.card_state_willstart_text);
        this.s = (TextView) a.findViewById(com.baidu.tieba.u.card_state_close);
        this.t = (Button) a.findViewById(com.baidu.tieba.u.card_delete);
        this.u = (ImageView) a.findViewById(com.baidu.tieba.u.card_top_image);
        this.v = (ImageView) a.findViewById(com.baidu.tieba.u.card_listener_iamge);
        this.w = (ImageView) a.findViewById(com.baidu.tieba.u.card_liker_image);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.tieba.z.LiveBroadcastCard);
            this.x = obtainStyledAttributes.getBoolean(0, false);
            this.y = obtainStyledAttributes.getBoolean(1, true);
            obtainStyledAttributes.recycle();
        }
        if (this.y) {
            this.f.measure(0, 0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams.height = this.f.getMeasuredHeight();
            this.m.setLayoutParams(layoutParams);
            this.l.setSingleLine();
        }
        setOnClickListener(new ab(this));
        this.t.setOnClickListener(new ac(this));
    }

    public void setData(LiveCardData liveCardData) {
        int color;
        if (liveCardData != null) {
            ae.a().b(this);
            b();
            this.C = liveCardData.getGroupId();
            this.g.setText(liveCardData.getName());
            this.i.setText(b(liveCardData.getListeners()));
            this.j.setText(b(liveCardData.getLikers()));
            this.k.setText(liveCardData.getPublisherName());
            this.l.setText(liveCardData.getIntro());
            this.t.setTag(liveCardData);
            this.e.setTag(null);
            if (!TextUtils.isEmpty(liveCardData.getPortrait())) {
                this.e.a(liveCardData.getPortrait(), 10, false);
            } else if (!TextUtils.isEmpty(liveCardData.getPublisherPortrait())) {
                this.e.a(liveCardData.getPublisherPortrait(), 12, false);
            } else {
                this.e.a((String) null, 10, false);
                this.e.a((String) null, 12, false);
            }
            int status = liveCardData.getStatus();
            if (!this.x || status == 1) {
                this.m.setVisibility(8);
            } else {
                this.m.setVisibility(0);
                if (!this.A) {
                    switch (status) {
                        case 2:
                            a(liveCardData.getStartTime());
                            break;
                        case 3:
                        case 4:
                        case 5:
                            c();
                            break;
                        case 6:
                            d();
                            break;
                        default:
                            d();
                            break;
                    }
                } else {
                    e();
                }
            }
            this.u.setVisibility(this.z ? 0 : 8);
            if (this.A) {
                com.baidu.tbadk.core.util.ay.a(this.g, com.baidu.tieba.r.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.a(this.i, com.baidu.tieba.r.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.a(this.j, com.baidu.tieba.r.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.a(this.k, com.baidu.tieba.r.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.a(this.l, com.baidu.tieba.r.cp_cont_e, 1);
                com.baidu.tbadk.core.util.ay.c(this.v, com.baidu.tieba.t.icon_live_list_pop_d);
                com.baidu.tbadk.core.util.ay.c(this.w, com.baidu.tieba.t.icon_live_list_like_d);
                GroupImageView groupImageView = this.e;
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    color = this.c.getResources().getColor(com.baidu.tieba.r.live_broadcast_card_head_mask_1);
                } else {
                    color = this.c.getResources().getColor(com.baidu.tieba.r.live_broadcast_card_head_mask);
                }
                groupImageView.setForegroundColor(color);
                return;
            }
            com.baidu.tbadk.core.util.ay.a(this.g, com.baidu.tieba.r.cp_cont_b, 1);
            com.baidu.tbadk.core.util.ay.a(this.i, com.baidu.tieba.r.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ay.a(this.j, com.baidu.tieba.r.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ay.a(this.k, com.baidu.tieba.r.cp_cont_c, 1);
            com.baidu.tbadk.core.util.ay.a(this.l, com.baidu.tieba.r.cp_cont_d, 1);
            com.baidu.tbadk.core.util.ay.c(this.v, com.baidu.tieba.t.icon_live_list_pop);
            com.baidu.tbadk.core.util.ay.c(this.w, com.baidu.tieba.t.icon_live_list_like);
            this.e.setForegroundColor(0);
        }
    }

    public void setEditState(boolean z) {
        if (this.x) {
            if (z) {
                this.n.setVisibility(8);
                this.t.setVisibility(0);
                return;
            }
            this.n.setVisibility(0);
            this.t.setVisibility(8);
        }
    }

    private String b(int i) {
        if (i <= 0) {
            return String.valueOf(i);
        }
        if (i > 99999) {
            return "99999+";
        }
        return String.valueOf(i);
    }

    public void a(boolean z, String str) {
        setEditState(z);
        this.t.setText(str);
    }

    private void a() {
        MessageManager.getInstance().registerListener(this.F);
    }

    private void b() {
        MessageManager.getInstance().unRegisterListener(this.F);
    }

    private void c() {
        this.o.setVisibility(0);
        this.q.setVisibility(8);
        this.s.setVisibility(8);
        this.E = 3;
        ae.a().b(this);
        b();
    }

    private void a(long j) {
        this.o.setVisibility(8);
        this.q.setVisibility(0);
        this.s.setVisibility(8);
        this.B = j;
        this.E = 0;
        i();
        a();
        ae.a().a(this);
    }

    private void d() {
        this.o.setVisibility(8);
        this.q.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setText(com.baidu.tieba.x.live_card_close);
        com.baidu.tbadk.core.util.ay.a(this.s, com.baidu.tieba.r.cp_cont_d, 1);
        this.s.setTextSize(0, getResources().getDimensionPixelSize(com.baidu.tieba.s.ds28));
        this.E = 4;
    }

    private void e() {
        this.o.setVisibility(8);
        this.q.setVisibility(8);
        this.s.setVisibility(0);
        this.s.setText(com.baidu.tieba.x.live_card_hide);
        com.baidu.tbadk.core.util.ay.a(this.s, com.baidu.tieba.r.cp_cont_d, 1);
        this.s.setTextSize(0, getResources().getDimensionPixelSize(com.baidu.tieba.s.ds32));
        this.E = 5;
    }

    private void f() {
        this.r.setText(com.baidu.tieba.x.live_card_count_down);
        com.baidu.tbadk.core.util.ay.f((View) this.r, com.baidu.tieba.t.bg_live_orange);
        this.E = 2;
    }

    private void g() {
        this.p.setText(c(this.B));
        this.r.setText(com.baidu.tieba.x.live_card_foreshowt);
        com.baidu.tbadk.core.util.ay.f((View) this.r, com.baidu.tieba.t.bg_live_yellow);
        this.E = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.am(this.c, this.C)));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ae.a().b(this);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= this.B) {
            if (this.E != 3) {
                c();
                return;
            }
            return;
        }
        long j = this.B - currentTimeMillis;
        if (j <= 300) {
            if (this.E != 2) {
                f();
            }
            this.p.setText(b(j));
        } else if (this.E != 1) {
            g();
        }
    }

    private String b(long j) {
        return new SimpleDateFormat("mm:ss", Locale.CHINA).format(new Date(1000 * j));
    }

    private String c(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(1000 * j));
    }

    public void a(int i) {
        if (this.c instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) this.c;
            baseActivity.getLayoutMode().a(i == 1);
            baseActivity.getLayoutMode().a((View) this.d);
        } else if (this.c instanceof BaseFragmentActivity) {
            BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) this.c;
            baseFragmentActivity.c().a(i == 1);
            baseFragmentActivity.c().a((View) this.d);
        }
    }

    public void setmHasStatus(boolean z) {
        this.x = z;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
    }
}
