package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class n extends q.a {
    public LinearLayout deN;
    public LinearLayout deO;
    public LinearLayout deP;
    public LinearLayout deQ;
    public HeadImageView deR;
    public HeadImageView deS;
    public HeadImageView deT;
    public HeadImageView deU;
    public TextView deV;
    public TextView deW;
    public TextView deX;
    public TextView deY;
    public NoPressedLinearLayout deZ;
    public View dfa;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int e = com.baidu.adp.lib.util.l.e(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = al.getColor(d.C0141d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.deN = (LinearLayout) view.findViewById(d.g.member1);
        this.deR = (HeadImageView) view.findViewById(d.g.imageview_user_photo1);
        this.deV = (TextView) view.findViewById(d.g.textview_user_name1);
        this.deR.setIsRound(true);
        this.deR.setBorderColor(color);
        this.deR.setBorderWidth(e);
        this.deR.setOnClickListener(onClickListener);
        this.deO = (LinearLayout) view.findViewById(d.g.member2);
        this.deS = (HeadImageView) view.findViewById(d.g.imageview_user_photo2);
        this.deW = (TextView) view.findViewById(d.g.textview_user_name2);
        this.deS.setIsRound(true);
        this.deS.setBorderColor(color);
        this.deS.setBorderWidth(e);
        this.deS.setOnClickListener(onClickListener);
        this.deP = (LinearLayout) view.findViewById(d.g.member3);
        this.deT = (HeadImageView) view.findViewById(d.g.imageview_user_photo3);
        this.deX = (TextView) view.findViewById(d.g.textview_user_name3);
        this.deT.setIsRound(true);
        this.deT.setBorderColor(color);
        this.deT.setBorderWidth(e);
        this.deT.setOnClickListener(onClickListener);
        this.deQ = (LinearLayout) view.findViewById(d.g.member4);
        this.deU = (HeadImageView) view.findViewById(d.g.imageview_user_photo4);
        this.deY = (TextView) view.findViewById(d.g.textview_user_name4);
        this.deU.setIsRound(true);
        this.deU.setBorderColor(color);
        this.deU.setBorderWidth(e);
        this.deU.setOnClickListener(onClickListener);
        this.deZ = (NoPressedLinearLayout) view.findViewById(d.g.forum_member_team_item_view);
        this.dfa = view.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.deR.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.deR.setTag(bawuRoleInfoPub);
                    this.deR.setContentDescription(bawuRoleInfoPub.user_name);
                    this.deV.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.deN.setVisibility(0);
                    return;
                case 1:
                    this.deS.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.deS.setTag(bawuRoleInfoPub);
                    this.deS.setContentDescription(bawuRoleInfoPub.user_name);
                    this.deW.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.deO.setVisibility(0);
                    return;
                case 2:
                    this.deT.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.deT.setTag(bawuRoleInfoPub);
                    this.deT.setContentDescription(bawuRoleInfoPub.user_name);
                    this.deX.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.deP.setVisibility(0);
                    return;
                case 3:
                    this.deU.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.deU.setTag(bawuRoleInfoPub);
                    this.deU.setContentDescription(bawuRoleInfoPub.user_name);
                    this.deY.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.deQ.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fp(boolean z) {
        if (this.deR.getVisibility() == 0) {
            this.deR.setIsNight(z);
            this.deR.refresh();
        }
        if (this.deS.getVisibility() == 0) {
            this.deS.setIsNight(z);
            this.deS.refresh();
        }
        if (this.deT.getVisibility() == 0) {
            this.deT.setIsNight(z);
            this.deT.refresh();
        }
        if (this.deU.getVisibility() == 0) {
            this.deU.setIsNight(z);
            this.deU.refresh();
        }
    }
}
