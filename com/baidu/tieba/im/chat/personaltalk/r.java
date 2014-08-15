package com.baidu.tieba.im.chat.personaltalk;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.s;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class r {
    public PersonaltalkSettingViewBlackManView a;
    public PersonalTalkSettingViewSettingView b;
    private final PersonalTalkSettingActivity c;
    private final NavigationBar d;
    private final View e;
    private final HeadImageView f;
    private final TextView g;
    private final UserIconBox h;
    private final TextView i;

    public r(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.c = personalTalkSettingActivity;
        this.c.setContentView(v.p2ptalk_setting_activity);
        this.e = this.c.findViewById(u.person_talk_setting_parent);
        this.d = (NavigationBar) this.e.findViewById(u.view_navigation_bar);
        this.d.a(this.c.getString(x.talk_detail));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (PersonaltalkSettingViewBlackManView) this.c.findViewById(u.black_status_view);
        this.b = (PersonalTalkSettingViewSettingView) this.c.findViewById(u.setting_detail_view);
        this.f = (HeadImageView) this.c.findViewById(u.photo);
        this.f.setIsRound(true);
        this.g = (TextView) this.c.findViewById(u.name);
        this.h = (UserIconBox) this.c.findViewById(u.user_icon_box);
        this.i = (TextView) this.c.findViewById(u.user_desc);
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
        this.b.a(z);
    }

    public void a(l lVar) {
        if (lVar != null) {
            a(lVar.c(), lVar.b().sex.intValue());
            a(lVar.a());
            a(lVar.b());
            b(lVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.g.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, t.icon_pop_girl, 0);
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
                this.h.a(linkedList, i, this.c.getResources().getDimensionPixelSize(s.person_icon_width), this.c.getResources().getDimensionPixelSize(s.person_icon_height), this.c.getResources().getDimensionPixelSize(s.person_icon_margin));
            }
        }
    }

    public void b(l lVar) {
        String str;
        if (lVar != null && lVar.b() != null && (str = lVar.b().portrait) != null && str.length() > 0) {
            this.f.setImageResource(0);
            this.f.a(str, 12, false);
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.b != null) {
            this.b.setSwitchStateChangeListener(cVar);
        }
    }
}
