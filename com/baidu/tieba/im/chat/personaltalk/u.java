package com.baidu.tieba.im.chat.personaltalk;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class u {
    private final HeadImageView aBo;
    private final PersonalTalkSettingActivity aTX;
    private final UserIconBox aUb;
    public PersonaltalkSettingViewBlackManView aUc;
    public PersonalTalkSettingViewSettingView aUd;
    private final TextView axW;
    private final TextView azp;
    private final NavigationBar mNavigationBar;
    private final View mParent;

    public u(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aTX = personalTalkSettingActivity;
        this.aTX.setContentView(x.p2ptalk_setting_activity);
        this.mParent = this.aTX.findViewById(w.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.mParent.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aTX.getPageContext().getString(z.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aUc = (PersonaltalkSettingViewBlackManView) this.aTX.findViewById(w.black_status_view);
        this.aUd = (PersonalTalkSettingViewSettingView) this.aTX.findViewById(w.setting_detail_view);
        this.aBo = (HeadImageView) this.aTX.findViewById(w.photo);
        this.aBo.setIsRound(true);
        this.azp = (TextView) this.aTX.findViewById(w.name);
        this.aUb = (UserIconBox) this.aTX.findViewById(w.user_icon_box);
        this.axW = (TextView) this.aTX.findViewById(w.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.aTX.getLayoutMode().h(this.mParent);
        this.mNavigationBar.onChangeSkinType(this.aTX.getPageContext(), i);
    }

    public void c(boolean z, int i) {
        if (z) {
            this.aUc.setSex(i);
            this.aUc.setVisibility(0);
            this.aUd.setVisibility(8);
            return;
        }
        this.aUd.setVisibility(0);
        this.aUc.setVisibility(8);
    }

    public void cA(boolean z) {
        this.aUd.cA(z);
    }

    public void e(o oVar) {
        if (oVar != null) {
            c(oVar.KO(), oVar.KN().sex.intValue());
            cA(oVar.KM());
            a(oVar.KN());
            f(oVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.azp.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.azp.setCompoundDrawablesWithIntrinsicBounds(0, 0, v.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.azp.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.azp.setCompoundDrawablesWithIntrinsicBounds(0, 0, v.icon_pop_girl, 0);
            }
            this.axW.setText(dataRes.intro);
            if (this.aUb != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aUb.a(linkedList, i, this.aTX.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_width), this.aTX.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_height), this.aTX.getResources().getDimensionPixelSize(com.baidu.tieba.u.person_icon_margin));
            }
        }
    }

    public void f(o oVar) {
        String str;
        if (oVar != null && oVar.KN() != null && (str = oVar.KN().portrait) != null && str.length() > 0) {
            this.aBo.setImageResource(0);
            this.aBo.d(str, 12, false);
        }
    }

    public void a(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.aUd != null) {
            this.aUd.setSwitchStateChangeListener(cVar);
        }
    }
}
