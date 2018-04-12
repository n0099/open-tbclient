package com.baidu.tieba.forumMember.member;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tieba.d;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class n extends q.a {
    public LinearLayout cUA;
    public HeadImageView cUB;
    public HeadImageView cUC;
    public HeadImageView cUD;
    public HeadImageView cUE;
    public TextView cUF;
    public TextView cUG;
    public TextView cUH;
    public TextView cUI;
    public NoPressedLinearLayout cUJ;
    public View cUK;
    public LinearLayout cUx;
    public LinearLayout cUy;
    public LinearLayout cUz;
    public TextView mTitleView;

    public n(View view2, View.OnClickListener onClickListener) {
        super(view2);
        int e = com.baidu.adp.lib.util.l.e(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = ak.getColor(d.C0126d.black_alpha10);
        this.mTitleView = (TextView) view2.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.cUx = (LinearLayout) view2.findViewById(d.g.member1);
        this.cUB = (HeadImageView) view2.findViewById(d.g.imageview_user_photo1);
        this.cUF = (TextView) view2.findViewById(d.g.textview_user_name1);
        this.cUB.setIsRound(true);
        this.cUB.setBorderColor(color);
        this.cUB.setBorderWidth(e);
        this.cUB.setOnClickListener(onClickListener);
        this.cUy = (LinearLayout) view2.findViewById(d.g.member2);
        this.cUC = (HeadImageView) view2.findViewById(d.g.imageview_user_photo2);
        this.cUG = (TextView) view2.findViewById(d.g.textview_user_name2);
        this.cUC.setIsRound(true);
        this.cUC.setBorderColor(color);
        this.cUC.setBorderWidth(e);
        this.cUC.setOnClickListener(onClickListener);
        this.cUz = (LinearLayout) view2.findViewById(d.g.member3);
        this.cUD = (HeadImageView) view2.findViewById(d.g.imageview_user_photo3);
        this.cUH = (TextView) view2.findViewById(d.g.textview_user_name3);
        this.cUD.setIsRound(true);
        this.cUD.setBorderColor(color);
        this.cUD.setBorderWidth(e);
        this.cUD.setOnClickListener(onClickListener);
        this.cUA = (LinearLayout) view2.findViewById(d.g.member4);
        this.cUE = (HeadImageView) view2.findViewById(d.g.imageview_user_photo4);
        this.cUI = (TextView) view2.findViewById(d.g.textview_user_name4);
        this.cUE.setIsRound(true);
        this.cUE.setBorderColor(color);
        this.cUE.setBorderWidth(e);
        this.cUE.setOnClickListener(onClickListener);
        this.cUJ = (NoPressedLinearLayout) view2.findViewById(d.g.forum_member_team_item_view);
        this.cUK = view2.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.cUB.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cUB.setTag(bawuRoleInfoPub);
                    this.cUB.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cUF.setText(bawuRoleInfoPub.user_name);
                    this.cUx.setVisibility(0);
                    return;
                case 1:
                    this.cUC.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cUC.setTag(bawuRoleInfoPub);
                    this.cUC.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cUG.setText(bawuRoleInfoPub.user_name);
                    this.cUy.setVisibility(0);
                    return;
                case 2:
                    this.cUD.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cUD.setTag(bawuRoleInfoPub);
                    this.cUD.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cUH.setText(bawuRoleInfoPub.user_name);
                    this.cUz.setVisibility(0);
                    return;
                case 3:
                    this.cUE.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cUE.setTag(bawuRoleInfoPub);
                    this.cUE.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cUI.setText(bawuRoleInfoPub.user_name);
                    this.cUA.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fk(boolean z) {
        if (this.cUB.getVisibility() == 0) {
            this.cUB.setIsNight(z);
            this.cUB.refresh();
        }
        if (this.cUC.getVisibility() == 0) {
            this.cUC.setIsNight(z);
            this.cUC.refresh();
        }
        if (this.cUD.getVisibility() == 0) {
            this.cUD.setIsNight(z);
            this.cUD.refresh();
        }
        if (this.cUE.getVisibility() == 0) {
            this.cUE.setIsNight(z);
            this.cUE.refresh();
        }
    }
}
