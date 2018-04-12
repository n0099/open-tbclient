package com.baidu.tieba.im.forum.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.d;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private RelativeLayout dXA;
    private RelativeLayout dXB;
    private RelativeLayout dXC;
    private TextView dXD;
    private SettingTextSwitchView dXy;
    private RelativeLayout dXz;

    public ItemMsgManage(Context context) {
        super(context);
        init(context);
    }

    public ItemMsgManage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public void init(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(d.i.forum_detail_msg_manage, (ViewGroup) this, true);
        this.dXy = (SettingTextSwitchView) findViewById(d.g.bar_notify);
        this.dXy.setTextLeftMargin(d.e.ds20);
        this.dXz = (RelativeLayout) findViewById(d.g.bar_info_clean_lay);
        this.dXA = (RelativeLayout) findViewById(d.g.bar_info_history_lay);
        this.dXB = (RelativeLayout) findViewById(d.g.bar_info_member_lay);
        this.dXC = (RelativeLayout) findViewById(d.g.bar_info_manager_lay);
        this.dXD = (TextView) findViewById(d.g.bar_info_member_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.dXy.setVisibility(8);
                this.dXz.setVisibility(8);
                this.dXA.setVisibility(8);
            }
            this.dXC.setVisibility(z ? 0 : 8);
            findViewById(d.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (managerApplyInfo != null) {
            this.dXD.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format = String.format(getResources().getString(d.k.forum_detail_apply_left_num_tip), an.v(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.dXD.setText(format);
                } else {
                    this.dXD.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.dXD.setText(getResources().getString(d.k.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.dXD.setText(getResources().getString(d.k.forum_detail_apply_failed));
            } else {
                this.dXD.setVisibility(8);
            }
        }
        com.baidu.tieba.im.settingcache.d.aGW().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new h<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.h
            public void onReturnDataInUI(Boolean bool) {
                if (bool != null) {
                    ItemMsgManage.this.setSwitch(bool.booleanValue());
                }
            }
        });
    }

    private void setShowState(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo != null) {
            int intValue = recommendForumInfo.forum_type.intValue();
            if (intValue == 0) {
                this.dXy.setVisibility(8);
                this.dXz.setVisibility(8);
                this.dXA.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.dXy.setVisibility(0);
                this.dXz.setVisibility(0);
                this.dXA.setVisibility(0);
            } else if (intValue == 2) {
                this.dXA.setVisibility(8);
                this.dXz.setVisibility(0);
                this.dXy.setVisibility(0);
                setVisibility(0);
            }
        }
    }

    public void setShowState(RecommendForumInfo recommendForumInfo, boolean z) {
        setShowState(recommendForumInfo);
        if (!z) {
            setVisibility(8);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.dXy.getSwitchView().jM();
        } else {
            this.dXy.getSwitchView().jN();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.dXz.setOnClickListener(onClickListener);
        this.dXA.setOnClickListener(onClickListener);
        this.dXB.setOnClickListener(onClickListener);
        this.dXC.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.dXy.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().u(this);
        this.dXy.eq(i);
    }
}
