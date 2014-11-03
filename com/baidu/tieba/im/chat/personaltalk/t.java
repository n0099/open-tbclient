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
    private final PersonalTalkSettingActivity aSK;
    private final UserIconBox aSO;
    public PersonaltalkSettingViewBlackManView aSP;
    public PersonalTalkSettingViewSettingView aSQ;
    private final View agI;
    private final TextView auM;
    private final TextView awi;
    private final HeadImageView azt;
    private final NavigationBar mNavigationBar;

    public t(PersonalTalkSettingActivity personalTalkSettingActivity) {
        this.aSK = personalTalkSettingActivity;
        this.aSK.setContentView(w.p2ptalk_setting_activity);
        this.agI = this.aSK.findViewById(v.person_talk_setting_parent);
        this.mNavigationBar = (NavigationBar) this.agI.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(this.aSK.getString(y.talk_detail));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.aSP = (PersonaltalkSettingViewBlackManView) this.aSK.findViewById(v.black_status_view);
        this.aSQ = (PersonalTalkSettingViewSettingView) this.aSK.findViewById(v.setting_detail_view);
        this.azt = (HeadImageView) this.aSK.findViewById(v.photo);
        this.azt.setIsRound(true);
        this.awi = (TextView) this.aSK.findViewById(v.name);
        this.aSO = (UserIconBox) this.aSK.findViewById(v.user_icon_box);
        this.auM = (TextView) this.aSK.findViewById(v.user_desc);
    }

    public void onChangeSkinType(int i) {
        this.aSK.getLayoutMode().h(this.agI);
        this.mNavigationBar.onChangeSkinType(i);
    }

    public void c(boolean z, int i) {
        if (z) {
            this.aSP.setSex(i);
            this.aSP.setVisibility(0);
            this.aSQ.setVisibility(8);
            return;
        }
        this.aSQ.setVisibility(0);
        this.aSP.setVisibility(8);
    }

    public void cN(boolean z) {
        this.aSQ.cN(z);
    }

    public void e(n nVar) {
        if (nVar != null) {
            c(nVar.KM(), nVar.KL().sex.intValue());
            cN(nVar.KK());
            a(nVar.KL());
            f(nVar);
        }
    }

    public void a(DataRes dataRes) {
        int i = 3;
        if (dataRes != null) {
            this.awi.setText(dataRes.name);
            if (dataRes.sex.intValue() == 1) {
                this.awi.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.icon_pop_boy, 0);
            } else if (dataRes.sex.intValue() != 2) {
                i = 4;
            } else if (dataRes.iconInfo.size() > 0 && dataRes.iconInfo.get(0).name.equals(IconData.meizhi_icon_name)) {
                this.awi.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            } else {
                this.awi.setCompoundDrawablesWithIntrinsicBounds(0, 0, u.icon_pop_girl, 0);
            }
            this.auM.setText(dataRes.intro);
            if (this.aSO != null) {
                LinkedList linkedList = new LinkedList();
                for (IconInfo iconInfo : dataRes.iconInfo) {
                    IconData iconData = new IconData();
                    iconData.setIconName(iconInfo.name);
                    iconData.setIcon(iconInfo.iconUrl);
                    linkedList.add(iconData);
                }
                this.aSO.a(linkedList, i, this.aSK.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_width), this.aSK.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_height), this.aSK.getResources().getDimensionPixelSize(com.baidu.tieba.t.person_icon_margin));
            }
        }
    }

    public void f(n nVar) {
        String str;
        if (nVar != null && nVar.KL() != null && (str = nVar.KL().portrait) != null && str.length() > 0) {
            this.azt.setImageResource(0);
            this.azt.c(str, 12, false);
        }
    }

    public void b(com.baidu.adp.widget.BdSwitchView.c cVar) {
        if (this.aSQ != null) {
            this.aSQ.setSwitchStateChangeListener(cVar);
        }
    }
}
