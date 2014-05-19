package com.baidu.tieba.im.chat.personaltalk;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class q {
    public PersonaltalkSettingViewBlackManView a;
    public PersonalTalkSettingViewSettingView b;
    private final PersonalTalkSettingActivity c;
    private final NavigationBar d;
    private final View e;
    private final HeadImageView f;
    private final TextView g;
    private final UserIconBox h;
    private final TextView i;

    public q(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.c = personalTalkSettingActivity;
        this.c.setContentView(s.p2ptalk_setting_activity);
        this.e = this.c.findViewById(com.baidu.tieba.r.person_talk_setting_parent);
        this.d = (NavigationBar) this.e.findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.d.a(this.c.getString(u.talk_detail));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (PersonaltalkSettingViewBlackManView) this.c.findViewById(com.baidu.tieba.r.black_status_view);
        this.b = (PersonalTalkSettingViewSettingView) this.c.findViewById(com.baidu.tieba.r.setting_detail_view);
        this.f = (HeadImageView) this.c.findViewById(com.baidu.tieba.r.photo);
        this.f.setIsRound(true);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.r.name);
        this.h = (UserIconBox) this.c.findViewById(com.baidu.tieba.r.user_icon_box);
        this.i = (TextView) this.c.findViewById(com.baidu.tieba.r.user_desc);
    }

    public void a(int i) {
        this.c.getLayoutMode().a(this.e);
        this.d.c(i);
    }

    public void a(boolean z, int i) {
        if (z) {
            this.a.setSex(i);
            this.a.setVisibility(0);
            this.b.setVisibility(8);
            return;
        }
        this.b.setVisibility(0);
        this.a.setVisibility(8);
    }

    public void a(boolean z) {
        this.b.b(z);
    }

    public void b(boolean z) {
        this.b.a(z);
    }

    public void a(k kVar) {
        if (kVar != null) {
            a(kVar.d(), kVar.b().sex.intValue());
            a(kVar.c());
            b(kVar.a());
            a(kVar.b());
            b(kVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.g.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.q.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.q.icon_pop_girl, 0);
            }
            this.i.setText(dataRes.intro);
            if (this.h != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.h.a(linkedList, i, this.c.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_width), this.c.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_height), this.c.getResources().getDimensionPixelSize(com.baidu.tieba.p.person_icon_margin));
            }
        }
    }

    public void b(k kVar) {
        String str;
        if (kVar != null && kVar.b() != null && (str = kVar.b().portrait) != null && str.length() > 0) {
            kVar.f().c(str, new r(this));
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.b != null) {
            this.b.setSwitchStateChangeListener(cVar);
        }
    }
}
