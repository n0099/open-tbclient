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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.e;
import com.baidu.tieba.im.settingcache.d;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView eHV;
    private RelativeLayout eHW;
    private RelativeLayout eHX;
    private RelativeLayout eHY;
    private RelativeLayout eHZ;
    private TextView eIa;

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
        LayoutInflater.from(context).inflate(e.h.forum_detail_msg_manage, (ViewGroup) this, true);
        this.eHV = (SettingTextSwitchView) findViewById(e.g.bar_notify);
        this.eHV.setTextLeftMargin(e.C0200e.ds20);
        this.eHW = (RelativeLayout) findViewById(e.g.bar_info_clean_lay);
        this.eHX = (RelativeLayout) findViewById(e.g.bar_info_history_lay);
        this.eHY = (RelativeLayout) findViewById(e.g.bar_info_member_lay);
        this.eHZ = (RelativeLayout) findViewById(e.g.bar_info_manager_lay);
        this.eIa = (TextView) findViewById(e.g.bar_info_member_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.eHV.setVisibility(8);
                this.eHW.setVisibility(8);
                this.eHX.setVisibility(8);
            }
            this.eHZ.setVisibility(z ? 0 : 8);
            findViewById(e.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (managerApplyInfo != null) {
            this.eIa.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format = String.format(getResources().getString(e.j.forum_detail_apply_left_num_tip), ao.I(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.eIa.setText(format);
                } else {
                    this.eIa.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.eIa.setText(getResources().getString(e.j.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.eIa.setText(getResources().getString(e.j.forum_detail_apply_failed));
            } else {
                this.eIa.setVisibility(8);
            }
        }
        d.aSs().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new h<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.eHV.setVisibility(8);
                this.eHW.setVisibility(8);
                this.eHX.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.eHV.setVisibility(0);
                this.eHW.setVisibility(0);
                this.eHX.setVisibility(0);
            } else if (intValue == 2) {
                this.eHX.setVisibility(8);
                this.eHW.setVisibility(0);
                this.eHV.setVisibility(0);
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
            this.eHV.getSwitchView().nQ();
        } else {
            this.eHV.getSwitchView().nR();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.eHW.setOnClickListener(onClickListener);
        this.eHX.setOnClickListener(onClickListener);
        this.eHY.setOnClickListener(onClickListener);
        this.eHZ.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.eHV.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.eHV.fg(i);
    }
}
