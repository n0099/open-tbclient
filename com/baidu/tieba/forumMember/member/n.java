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
    public HeadImageView cUA;
    public HeadImageView cUB;
    public TextView cUC;
    public TextView cUD;
    public TextView cUE;
    public TextView cUF;
    public NoPressedLinearLayout cUG;
    public View cUH;
    public LinearLayout cUu;
    public LinearLayout cUv;
    public LinearLayout cUw;
    public LinearLayout cUx;
    public HeadImageView cUy;
    public HeadImageView cUz;
    public TextView mTitleView;

    public n(View view2, View.OnClickListener onClickListener) {
        super(view2);
        int e = com.baidu.adp.lib.util.l.e(BdBaseApplication.getInst().getApp(), d.e.ds1);
        int color = ak.getColor(d.C0126d.black_alpha10);
        this.mTitleView = (TextView) view2.findViewById(d.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.cUu = (LinearLayout) view2.findViewById(d.g.member1);
        this.cUy = (HeadImageView) view2.findViewById(d.g.imageview_user_photo1);
        this.cUC = (TextView) view2.findViewById(d.g.textview_user_name1);
        this.cUy.setIsRound(true);
        this.cUy.setBorderColor(color);
        this.cUy.setBorderWidth(e);
        this.cUy.setOnClickListener(onClickListener);
        this.cUv = (LinearLayout) view2.findViewById(d.g.member2);
        this.cUz = (HeadImageView) view2.findViewById(d.g.imageview_user_photo2);
        this.cUD = (TextView) view2.findViewById(d.g.textview_user_name2);
        this.cUz.setIsRound(true);
        this.cUz.setBorderColor(color);
        this.cUz.setBorderWidth(e);
        this.cUz.setOnClickListener(onClickListener);
        this.cUw = (LinearLayout) view2.findViewById(d.g.member3);
        this.cUA = (HeadImageView) view2.findViewById(d.g.imageview_user_photo3);
        this.cUE = (TextView) view2.findViewById(d.g.textview_user_name3);
        this.cUA.setIsRound(true);
        this.cUA.setBorderColor(color);
        this.cUA.setBorderWidth(e);
        this.cUA.setOnClickListener(onClickListener);
        this.cUx = (LinearLayout) view2.findViewById(d.g.member4);
        this.cUB = (HeadImageView) view2.findViewById(d.g.imageview_user_photo4);
        this.cUF = (TextView) view2.findViewById(d.g.textview_user_name4);
        this.cUB.setIsRound(true);
        this.cUB.setBorderColor(color);
        this.cUB.setBorderWidth(e);
        this.cUB.setOnClickListener(onClickListener);
        this.cUG = (NoPressedLinearLayout) view2.findViewById(d.g.forum_member_team_item_view);
        this.cUH = view2.findViewById(d.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.cUy.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cUy.setTag(bawuRoleInfoPub);
                    this.cUy.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cUC.setText(bawuRoleInfoPub.user_name);
                    this.cUu.setVisibility(0);
                    return;
                case 1:
                    this.cUz.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cUz.setTag(bawuRoleInfoPub);
                    this.cUz.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cUD.setText(bawuRoleInfoPub.user_name);
                    this.cUv.setVisibility(0);
                    return;
                case 2:
                    this.cUA.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cUA.setTag(bawuRoleInfoPub);
                    this.cUA.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cUE.setText(bawuRoleInfoPub.user_name);
                    this.cUw.setVisibility(0);
                    return;
                case 3:
                    this.cUB.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.cUB.setTag(bawuRoleInfoPub);
                    this.cUB.setContentDescription(bawuRoleInfoPub.user_name);
                    this.cUF.setText(bawuRoleInfoPub.user_name);
                    this.cUx.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void fk(boolean z) {
        if (this.cUy.getVisibility() == 0) {
            this.cUy.setIsNight(z);
            this.cUy.refresh();
        }
        if (this.cUz.getVisibility() == 0) {
            this.cUz.setIsNight(z);
            this.cUz.refresh();
        }
        if (this.cUA.getVisibility() == 0) {
            this.cUA.setIsNight(z);
            this.cUA.refresh();
        }
        if (this.cUB.getVisibility() == 0) {
            this.cUB.setIsNight(z);
            this.cUB.refresh();
        }
    }
}
