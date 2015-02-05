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
    private final TextView aAn;
    private final HeadImageView aCm;
    private final PersonalTalkSettingActivity aVp;
    private final UserIconBox aVt;
    public PersonaltalkSettingViewBlackManView aVu;
    public PersonalTalkSettingViewSettingView aVv;
    private final TextView ayT;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public x(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aVp = personalTalkSettingActivity;
        this.aVp.setContentView(com.baidu.tieba.x.p2ptalk_setting_activity);
        this.mParent = this.aVp.findViewById(com.baidu.tieba.w.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(com.baidu.tieba.w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aVp.getPageContext().getString(z.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aVu = (PersonaltalkSettingViewBlackManView) this.aVp.findViewById(com.baidu.tieba.w.black_status_view);
        this.aVv = (PersonalTalkSettingViewSettingView) this.aVp.findViewById(com.baidu.tieba.w.setting_detail_view);
        this.aCm = (HeadImageView) this.aVp.findViewById(com.baidu.tieba.w.photo);
        this.aCm.setIsRound(true);
        this.aAn = (TextView) this.aVp.findViewById(com.baidu.tieba.w.name);
        this.aVt = (UserIconBox) this.aVp.findViewById(com.baidu.tieba.w.user_icon_box);
        this.ayT = (TextView) this.aVp.findViewById(com.baidu.tieba.w.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.aVp.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.aVp.getPageContext(), i);
    }

    public void c(boolean z, int i) {
        if (z) {
            this.aVu.setSex(i);
            this.aVu.setVisibility(0);
            this.aVv.setVisibility(8);
            return;
        }
        this.aVv.setVisibility(0);
        this.aVu.setVisibility(8);
    }

    public void cF(boolean z) {
        this.aVv.cF(z);
    }

    public void e(r rVar) {
        if (rVar != null) {
            c(rVar.Le(), rVar.Ld().sex.intValue());
            cF(rVar.Lc());
            a(rVar.Ld());
            f(rVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.aAn.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.aAn.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.v.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.aAn.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.aAn.setCompoundDrawablesWithIntrinsicBounds(0, 0, com.baidu.tieba.v.icon_pop_girl, 0);
            }
            this.ayT.setText(dataRes.intro);
            if (this.aVt != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aVt.a(linkedList, i, this.aVp.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_width), this.aVp.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_height), this.aVp.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_margin));
            }
        }
    }

    public void f(r rVar) {
        String str;
        if (rVar != null && rVar.Ld() != null && (str = rVar.Ld().portrait) != null && str.length() > 0) {
            this.aCm.setImageResource(0);
            this.aCm.d(str, 12, false);
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.aVv != null) {
            this.aVv.setSwitchStateChangeListener(cVar);
        }
    }
}
