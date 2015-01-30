package com.baidu.tieba.im.chat.personaltalk;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.z;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class x {
    private final TextView aAq;
    private final HeadImageView aCp;
    private final PersonalTalkSettingActivity aVq;
    private final UserIconBox aVu;
    public PersonaltalkSettingViewBlackManView aVv;
    public PersonalTalkSettingViewSettingView aVw;
    private final TextView ayW;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public x(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aVq = personalTalkSettingActivity;
        this.aVq.setContentView(com.baidu.tieba.x.p2ptalk_setting_activity);
        this.mParent = this.aVq.findViewById(com.baidu.tieba.w.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aVq.getPageContext().getString(z.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVv = (PersonaltalkSettingViewBlackManView) this.aVq.findViewById(com.baidu.tieba.w.black_status_view);
        this.aVw = (PersonalTalkSettingViewSettingView) this.aVq.findViewById(com.baidu.tieba.w.setting_detail_view);
        this.aCp = (HeadImageView) this.aVq.findViewById(com.baidu.tieba.w.photo);
        this.aCp.setIsRound(true);
        this.aAq = (TextView) this.aVq.findViewById(com.baidu.tieba.w.name);
        this.aVu = (UserIconBox) this.aVq.findViewById(com.baidu.tieba.w.user_icon_box);
        this.ayW = (TextView) this.aVq.findViewById(com.baidu.tieba.w.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.aVq.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.aVq.getPageContext(), i);
    }

    public void c(boolean z, int i) {
        if (z) {
            this.aVv.setSex(i);
            this.aVv.setVisibility(0);
            this.aVw.setVisibility(8);
            return;
        }
        this.aVw.setVisibility(0);
        this.aVv.setVisibility(8);
    }

    public void cF(boolean z) {
        this.aVw.cF(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            c(rVar.Lj(), rVar.Li().sex.intValue());
            cF(rVar.Lh());
            a(rVar.Li());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.aAq.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.aAq.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.v.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.aAq.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aAq.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.v.icon_pop_girl, 0);
            }
            this.ayW.setText(dataRes.intro);
            if (this.aVu != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aVu.a(linkedList, i, this.aVq.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_width), this.aVq.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_height), this.aVq.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.Li() != null && (str = rVar.Li().portrait) != null && str.length() > 0) {
            this.aCp.setImageResource(0);
            this.aCp.d(str, 12, false);
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.aVw != null) {
            this.aVw.setSwitchStateChangeListener(cVar);
        }
    }
}
