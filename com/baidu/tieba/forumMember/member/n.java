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
import com.baidu.tieba.e;
import tbclient.BawuRoleInfoPub;
/* loaded from: classes3.dex */
public class n extends q.a {
    public LinearLayout dFe;
    public LinearLayout dFf;
    public LinearLayout dFg;
    public LinearLayout dFh;
    public HeadImageView dFi;
    public HeadImageView dFj;
    public HeadImageView dFk;
    public HeadImageView dFl;
    public TextView dFm;
    public TextView dFn;
    public TextView dFo;
    public TextView dFp;
    public NoPressedLinearLayout dFq;
    public View dFr;
    public TextView mTitleView;

    public n(View view, View.OnClickListener onClickListener) {
        super(view);
        int h = com.baidu.adp.lib.util.l.h(BdBaseApplication.getInst().getApp(), e.C0210e.ds1);
        int color = al.getColor(e.d.black_alpha10);
        this.mTitleView = (TextView) view.findViewById(e.g.title_text_view);
        this.mTitleView.setOnClickListener(onClickListener);
        this.dFe = (LinearLayout) view.findViewById(e.g.member1);
        this.dFi = (HeadImageView) view.findViewById(e.g.imageview_user_photo1);
        this.dFm = (TextView) view.findViewById(e.g.textview_user_name1);
        this.dFi.setIsRound(true);
        this.dFi.setBorderColor(color);
        this.dFi.setBorderWidth(h);
        this.dFi.setOnClickListener(onClickListener);
        this.dFf = (LinearLayout) view.findViewById(e.g.member2);
        this.dFj = (HeadImageView) view.findViewById(e.g.imageview_user_photo2);
        this.dFn = (TextView) view.findViewById(e.g.textview_user_name2);
        this.dFj.setIsRound(true);
        this.dFj.setBorderColor(color);
        this.dFj.setBorderWidth(h);
        this.dFj.setOnClickListener(onClickListener);
        this.dFg = (LinearLayout) view.findViewById(e.g.member3);
        this.dFk = (HeadImageView) view.findViewById(e.g.imageview_user_photo3);
        this.dFo = (TextView) view.findViewById(e.g.textview_user_name3);
        this.dFk.setIsRound(true);
        this.dFk.setBorderColor(color);
        this.dFk.setBorderWidth(h);
        this.dFk.setOnClickListener(onClickListener);
        this.dFh = (LinearLayout) view.findViewById(e.g.member4);
        this.dFl = (HeadImageView) view.findViewById(e.g.imageview_user_photo4);
        this.dFp = (TextView) view.findViewById(e.g.textview_user_name4);
        this.dFl.setIsRound(true);
        this.dFl.setBorderColor(color);
        this.dFl.setBorderWidth(h);
        this.dFl.setOnClickListener(onClickListener);
        this.dFq = (NoPressedLinearLayout) view.findViewById(e.g.forum_member_team_item_view);
        this.dFr = view.findViewById(e.g.team_divider_line1);
    }

    public void a(BawuRoleInfoPub bawuRoleInfoPub, int i) {
        if (bawuRoleInfoPub != null && i >= 0 && i <= 3) {
            switch (i) {
                case 0:
                    this.dFi.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dFi.setTag(bawuRoleInfoPub);
                    this.dFi.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dFm.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dFe.setVisibility(0);
                    return;
                case 1:
                    this.dFj.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dFj.setTag(bawuRoleInfoPub);
                    this.dFj.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dFn.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dFf.setVisibility(0);
                    return;
                case 2:
                    this.dFk.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dFk.setTag(bawuRoleInfoPub);
                    this.dFk.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dFo.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dFg.setVisibility(0);
                    return;
                case 3:
                    this.dFl.startLoad(bawuRoleInfoPub.portrait, 12, false);
                    this.dFl.setTag(bawuRoleInfoPub);
                    this.dFl.setContentDescription(bawuRoleInfoPub.user_name);
                    this.dFp.setText(StringUtils.isNull(bawuRoleInfoPub.name_show) ? bawuRoleInfoPub.user_name : bawuRoleInfoPub.name_show);
                    this.dFh.setVisibility(0);
                    return;
                default:
                    return;
            }
        }
    }

    public void gl(boolean z) {
        if (this.dFi.getVisibility() == 0) {
            this.dFi.setIsNight(z);
            this.dFi.refresh();
        }
        if (this.dFj.getVisibility() == 0) {
            this.dFj.setIsNight(z);
            this.dFj.refresh();
        }
        if (this.dFk.getVisibility() == 0) {
            this.dFk.setIsNight(z);
            this.dFk.refresh();
        }
        if (this.dFl.getVisibility() == 0) {
            this.dFl.setIsNight(z);
            this.dFl.refresh();
        }
    }
}
