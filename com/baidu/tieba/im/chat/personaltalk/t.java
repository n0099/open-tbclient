package com.baidu.tieba.im.chat.personaltalk;

import android.view.View;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
import java.util.LinkedList;
import protobuf.QueryUserInfos.DataRes;
import protobuf.QueryUserInfos.IconInfo;
/* loaded from: classes.dex */
public class t {
    private final UserIconBox aSA;
    public PersonaltalkSettingViewBlackManView aSB;
    public PersonalTalkSettingViewSettingView aSC;
    private final PersonalTalkSettingActivity aSw;
    private final View agA;
    private final TextView auD;
    private final TextView avZ;
    private final HeadImageView azk;
    private final NavigationBar mNavigationBar;

    public t(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aSw = personalTalkSettingActivity;
        this.aSw.setContentView(w.p2ptalk_setting_activity);
        this.agA = this.aSw.findViewById(v.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.agA.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aSw.getString(y.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aSB = (PersonaltalkSettingViewBlackManView) this.aSw.findViewById(v.black_status_view);
        this.aSC = (PersonalTalkSettingViewSettingView) this.aSw.findViewById(v.setting_detail_view);
        this.azk = (HeadImageView) this.aSw.findViewById(v.photo);
        this.azk.setIsRound(true);
        this.avZ = (TextView) this.aSw.findViewById(v.name);
        this.aSA = (UserIconBox) this.aSw.findViewById(v.user_icon_box);
        this.auD = (TextView) this.aSw.findViewById(v.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.aSw.getLayoutMode().h(this.agA);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public void c(boolean z, int i) {
        if (z) {
            this.aSB.setSex(i);
            this.aSB.setVisibility(0);
            this.aSC.setVisibility(8);
            return;
        }
        this.aSC.setVisibility(0);
        this.aSB.setVisibility(8);
    }

    public void cN(boolean z) {
        this.aSC.cN(z);
    }

    public void e(n nVar) {
        if (nVar != null) {
            c(nVar.KI(), nVar.KH().sex.intValue());
            cN(nVar.KG());
            a(nVar.KH());
            f(nVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.avZ.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.avZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.avZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.avZ.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.icon_pop_girl, 0);
            }
            this.auD.setText(dataRes.intro);
            if (this.aSA != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aSA.a(linkedList, i, this.aSw.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_width), this.aSw.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_height), this.aSw.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_margin));
            }
        }
    }

    public void f(n nVar) {
        String str;
        if (nVar != null && nVar.KH() != null && (str = nVar.KH().portrait) != null && str.length() > 0) {
            this.azk.setImageResource(0);
            this.azk.c(str, 12, false);
        }
    }

    public void b(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.aSC != null) {
            this.aSC.setSwitchStateChangeListener(cVar);
        }
    }
}
