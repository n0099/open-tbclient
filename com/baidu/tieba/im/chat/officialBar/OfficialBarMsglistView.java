package com.baidu.tieba.im.chat.officialBar;

import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarMsglistView extends CommonPersonalMsglistView {
    private TextView l;
    private LinearLayout m;
    private ImageView n;
    private LinearLayout o;
    private LinearLayout p;
    private LinearLayout q;
    private com.baidu.tieba.im.view.n r;
    private as[] s;

    public OfficialBarMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void a(TalkableActivity talkableActivity, boolean z) {
        super.a(talkableActivity, z);
        String string = talkableActivity.getString(com.baidu.tieba.y.msglist_officialInfo);
        if (string != null) {
            this.b = this.a.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, com.baidu.tieba.w.group_info_btn, talkableActivity);
            this.l = (TextView) this.b.findViewById(com.baidu.tieba.v.group_info_btn_txt);
            this.l.setText(string);
        }
        this.m = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_toggle_stub)).inflate();
        this.n = (ImageView) this.m.findViewById(com.baidu.tieba.v.official_bar_toggle_button);
        this.n.setVisibility(0);
        this.o = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_stub)).inflate();
        this.o.setVisibility(0);
        this.s = new as[3];
        as asVar = new as();
        asVar.a = false;
        asVar.b = (LinearLayout) this.o.findViewById(com.baidu.tieba.v.menu_frist);
        asVar.c = (TextView) this.o.findViewById(com.baidu.tieba.v.menu_frist_text);
        asVar.d = (ImageView) this.o.findViewById(com.baidu.tieba.v.menu_frist_tip);
        this.s[0] = asVar;
        as asVar2 = new as();
        asVar2.a = false;
        asVar2.b = (LinearLayout) this.o.findViewById(com.baidu.tieba.v.menu_second);
        asVar2.c = (TextView) this.o.findViewById(com.baidu.tieba.v.menu_second_text);
        asVar2.d = (ImageView) this.o.findViewById(com.baidu.tieba.v.menu_second_tip);
        this.s[1] = asVar2;
        as asVar3 = new as();
        asVar3.a = false;
        asVar3.b = (LinearLayout) this.o.findViewById(com.baidu.tieba.v.menu_third);
        asVar3.c = (TextView) this.o.findViewById(com.baidu.tieba.v.menu_third_text);
        asVar3.d = (ImageView) this.o.findViewById(com.baidu.tieba.v.menu_third_tip);
        this.s[2] = asVar3;
        for (int i = 0; i < 3; i++) {
            this.s[i].b.setOnClickListener(talkableActivity);
        }
        this.p = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_memu_down_line)).inflate();
        this.p.setVisibility(0);
        this.q = (LinearLayout) ((ViewStub) talkableActivity.findViewById(com.baidu.tieba.v.official_bar_menu_loading)).inflate();
        this.q.setVisibility(8);
        this.g.setVisibility(8);
        this.n.setOnClickListener(talkableActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void a(MsglistActivity msglistActivity) {
        super.a(msglistActivity);
        this.r = new com.baidu.tieba.im.view.n(msglistActivity);
        o().addView(this.r);
        this.r.setVisibility(8);
        this.r.setOnItemClickListener((OfficialBarChatActivity) msglistActivity);
    }

    public com.baidu.tieba.im.view.n S() {
        return this.r;
    }

    public void c(boolean z) {
        if (z) {
            this.m.setVisibility(8);
            this.o.setVisibility(8);
            this.g.setVisibility(0);
            this.p.setVisibility(8);
            return;
        }
        this.m.setVisibility(0);
        this.o.setVisibility(0);
        this.g.setVisibility(8);
        this.p.setVisibility(0);
    }

    public as[] T() {
        return this.s;
    }

    public void a(List<com.baidu.tieba.im.data.l> list) {
        if (list != null && list.size() == 3) {
            for (int i = 0; i < 3; i++) {
                com.baidu.tieba.im.data.l lVar = list.get(i);
                this.s[i].c.setText(lVar.b());
                if (lVar.c() != 0) {
                    this.s[i].d.setVisibility(8);
                }
            }
        }
    }

    public void d(boolean z) {
        this.q.setVisibility(z ? 0 : 8);
    }

    public void e(boolean z) {
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f, com.baidu.tieba.p.parent_menu_up);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f, com.baidu.tieba.p.parent_menu_down);
        loadAnimation2.setAnimationListener(new ar(this, z, loadAnimation));
        f();
        if (z()) {
            A();
        }
        e().startAnimation(loadAnimation2);
    }

    public void a(int i, boolean z) {
        as asVar = this.s[i];
        if (z) {
            asVar.d.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_s);
        } else {
            asVar.d.setImageResource(com.baidu.tieba.u.icon_bottombar_arrow_n);
        }
    }

    public int a(View view) {
        for (int i = 0; i < 3; i++) {
            if (view == this.s[i].b) {
                return i;
            }
        }
        return 0;
    }

    public ImageView U() {
        return this.n;
    }
}
