package com.baidu.tieba.im.chat.personaltalk;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import java.util.LinkedList;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public final class q {
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
        this.c.setContentView(com.baidu.tieba.im.i.p2ptalk_setting_activity);
        this.e = this.c.findViewById(com.baidu.tieba.im.h.person_talk_setting_parent);
        this.d = (NavigationBar) this.e.findViewById(com.baidu.tieba.im.h.view_navigation_bar);
        this.d.a(this.c.getString(com.baidu.tieba.im.j.talk_detail));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (PersonaltalkSettingViewBlackManView) this.c.findViewById(com.baidu.tieba.im.h.black_status_view);
        this.b = (PersonalTalkSettingViewSettingView) this.c.findViewById(com.baidu.tieba.im.h.setting_detail_view);
        this.f = (HeadImageView) this.c.findViewById(com.baidu.tieba.im.h.photo);
        this.f.setIsRound(true);
        this.g = (TextView) this.c.findViewById(com.baidu.tieba.im.h.name);
        this.h = (UserIconBox) this.c.findViewById(com.baidu.tieba.im.h.user_icon_box);
        this.i = (TextView) this.c.findViewById(com.baidu.tieba.im.h.user_desc);
    }

    public final void a(int i) {
        this.c.getLayoutMode().a(this.e);
        this.d.b(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(QueryUserInfosRes.DataRes dataRes) {
        if (dataRes != null) {
            this.g.setText(dataRes.getName());
            int i = 4;
            if (dataRes.getSex() == 1) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.im.g.icon_pop_boy, 0);
            } else {
                if (dataRes.getSex() == 2) {
                    if (dataRes.getIconInfoCount() > 0 && dataRes.getIconInfo(0).getName().equals(IconData.meizhi_icon_name)) {
                        this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    } else {
                        this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.im.g.icon_pop_girl, 0);
                    }
                }
                this.i.setText(dataRes.getIntro());
                if (this.h == null) {
                    LinkedList linkedList = new LinkedList();
                    for (QueryUserInfosRes.IconInfo iconInfo : dataRes.getIconInfoList()) {
                        IconData iconData = new IconData();
                        iconData.setIconName(iconInfo.getName());
                        iconData.setIcon(iconInfo.getIconUrl());
                        linkedList.add(iconData);
                    }
                    this.h.a(linkedList, i, this.c.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.person_icon_width), this.c.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.person_icon_height), this.c.getResources().getDimensionPixelSize(com.baidu.tieba.im.f.person_icon_margin));
                    return;
                }
                return;
            }
            i = 3;
            this.i.setText(dataRes.getIntro());
            if (this.h == null) {
            }
        }
    }
}
