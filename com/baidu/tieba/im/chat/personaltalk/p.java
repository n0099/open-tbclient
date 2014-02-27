package com.baidu.tieba.im.chat.personaltalk;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.view.HeadImageView;
import com.baidu.tieba.view.NavigationBar;
import com.baidu.tieba.view.UserIconBox;
import com.slidingmenu.lib.R;
import java.util.LinkedList;
import protobuf.QueryUserInfos.QueryUserInfosRes;
/* loaded from: classes.dex */
public final class p {
    public PersonaltalkSettingViewBlackManView a;
    public PersonalTalkSettingViewSettingView b;
    private PersonalTalkSettingActivity c;
    private NavigationBar d;
    private View e;
    private HeadImageView f;
    private TextView g;
    private UserIconBox h;
    private TextView i;

    public p(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.c = personalTalkSettingActivity;
        this.c.setContentView(R.layout.p2ptalk_setting_activity);
        this.e = this.c.findViewById(R.id.person_talk_setting_parent);
        this.d = (NavigationBar) this.e.findViewById(R.id.view_navigation_bar);
        this.d.a(this.c.getString(R.string.talk_detail));
        this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a = (PersonaltalkSettingViewBlackManView) this.c.findViewById(R.id.black_status_view);
        this.b = (PersonalTalkSettingViewSettingView) this.c.findViewById(R.id.setting_detail_view);
        this.f = (HeadImageView) this.c.findViewById(R.id.photo);
        this.f.setIsRound(true);
        this.g = (TextView) this.c.findViewById(R.id.name);
        this.h = (UserIconBox) this.c.findViewById(R.id.user_icon_box);
        this.i = (TextView) this.c.findViewById(R.id.user_desc);
    }

    public final void a(int i) {
        this.c.getLayoutMode().a(this.e);
        this.d.b(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(QueryUserInfosRes.DataRes dataRes) {
        if (dataRes != null) {
            this.g.setText(dataRes.getName());
            int i = 4;
            if (dataRes.getSex() == 1) {
                this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_boy, 0);
            } else {
                if (dataRes.getSex() == 2) {
                    if (dataRes.getIconInfoCount() > 0 && dataRes.getIconInfo(0).getName().equals(IconData.meizhi_icon_name)) {
                        this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                    } else {
                        this.g.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_pop_girl, 0);
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
                    this.h.a(linkedList, i, this.c.getResources().getDimensionPixelSize(R.dimen.person_icon_width), this.c.getResources().getDimensionPixelSize(R.dimen.person_icon_height), this.c.getResources().getDimensionPixelSize(R.dimen.person_icon_margin));
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
