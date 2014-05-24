package com.baidu.tieba.im.live.livenotify;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.ae;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/* loaded from: classes.dex */
public class LiveNotifyCardView extends RelativeLayout {
    private Context a;
    private ViewGroup b;
    private ViewGroup c;
    private TextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private ViewGroup i;
    private TextView j;
    private TextView k;
    private ViewGroup l;
    private TextView m;
    private TextView n;
    private long o;
    private int p;
    private String q;
    private int r;
    private CustomMessageListener s;

    public String getStatisticsKey() {
        return this.q;
    }

    public void setStatisticsKey(String str) {
        this.q = str;
    }

    public LiveNotifyCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.r = 0;
        this.s = new f(this, CmdConfig.LIVE_CARD_TIME_UPDATE);
        a(context, attributeSet);
    }

    public LiveNotifyCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = 0;
        this.s = new f(this, CmdConfig.LIVE_CARD_TIME_UPDATE);
        a(context, attributeSet);
    }

    public LiveNotifyCardView(Context context) {
        super(context);
        this.r = 0;
        this.s = new f(this, CmdConfig.LIVE_CARD_TIME_UPDATE);
        a(context, null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(w.live_notify_card_view, this);
        this.b = (ViewGroup) inflate.findViewById(v.live_notify_card_root);
        this.c = (ViewGroup) inflate.findViewById(v.live_notify_card_card_middle);
        this.d = (TextView) inflate.findViewById(v.live_notify_card_card_name);
        this.e = (TextView) inflate.findViewById(v.live_notify_card_card_listener_count);
        this.f = (TextView) inflate.findViewById(v.live_notify_card_card_liker_count);
        this.g = (TextView) inflate.findViewById(v.live_notify_card_card_author);
        this.h = (TextView) inflate.findViewById(v.live_notify_card_card_intro);
        this.i = (ViewGroup) inflate.findViewById(v.live_notify_card_card_right);
        this.j = (TextView) inflate.findViewById(v.live_notify_card_card_state_living);
        this.k = (TextView) inflate.findViewById(v.live_notify_card_card_time);
        this.l = (ViewGroup) inflate.findViewById(v.live_notify_card_card_state_willstart_layout);
        this.m = (TextView) inflate.findViewById(v.live_notify_card_card_state_willstart_text);
        this.n = (TextView) inflate.findViewById(v.live_notify_card_card_state_close);
        this.c.measure(0, 0);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.height = this.c.getMeasuredHeight();
        this.i.setLayoutParams(layoutParams);
        this.h.setSingleLine();
        setOnClickListener(new g(this));
    }

    public void setData(LiveCardData liveCardData) {
        if (liveCardData != null) {
            h.a().b(this);
            b();
            this.p = liveCardData.getGroupId();
            String name = liveCardData.getName();
            if (!TextUtils.isEmpty(name) && name.length() > 7) {
                name = String.valueOf(name.substring(0, 7)) + "...";
            }
            this.d.setText(name);
            this.e.setText(String.valueOf(liveCardData.getListeners() >= 0 ? liveCardData.getListeners() : 0));
            this.f.setText(String.valueOf(liveCardData.getLikers() >= 0 ? liveCardData.getLikers() : 0));
            this.g.setText(liveCardData.getPublisherName());
            this.h.setText(liveCardData.getIntro());
            this.i.setVisibility(0);
            switch (liveCardData.getStatus()) {
                case 2:
                    a(liveCardData.getStartTime());
                    return;
                case 3:
                case 4:
                case 5:
                    c();
                    return;
                case 6:
                    d();
                    return;
                default:
                    d();
                    return;
            }
        }
    }

    private void a() {
        MessageManager.getInstance().registerListener(this.s);
    }

    private void b() {
        MessageManager.getInstance().unRegisterListener(this.s);
    }

    private void c() {
        this.j.setVisibility(0);
        this.l.setVisibility(8);
        this.n.setVisibility(8);
        this.r = 3;
        h.a().b(this);
        b();
    }

    private void a(long j) {
        this.j.setVisibility(8);
        this.l.setVisibility(0);
        this.n.setVisibility(8);
        this.o = j;
        this.r = 0;
        h();
        a();
        h.a().a(this);
    }

    private void d() {
        this.j.setVisibility(8);
        this.l.setVisibility(8);
        this.n.setVisibility(0);
        this.r = 4;
    }

    private void e() {
        this.m.setText(y.live_card_count_down);
        bc.f((View) this.m, u.bg_live_orange);
        this.r = 2;
    }

    private void f() {
        this.k.setText(c(this.o));
        this.m.setText(y.live_card_foreshowt);
        bc.f((View) this.m, u.bg_live_yellow);
        this.r = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        MessageManager.getInstance().sendMessage(new CustomMessage(2003001, new ae(this.a, this.p)));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h.a().b(this);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis >= this.o) {
            if (this.r != 3) {
                c();
                return;
            }
            return;
        }
        long j = this.o - currentTimeMillis;
        if (j <= 300) {
            if (this.r != 2) {
                e();
            }
            this.k.setText(b(j));
        } else if (this.r != 1) {
            f();
        }
    }

    private String b(long j) {
        return new SimpleDateFormat("mm:ss", Locale.CHINA).format(new Date(1000 * j));
    }

    private String c(long j) {
        return new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date(1000 * j));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
    }
}
