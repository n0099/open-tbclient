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
    private SettingTextSwitchView eGD;
    private RelativeLayout eGE;
    private RelativeLayout eGF;
    private RelativeLayout eGG;
    private RelativeLayout eGH;
    private TextView eGI;

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
        this.eGD = (SettingTextSwitchView) findViewById(e.g.bar_notify);
        this.eGD.setTextLeftMargin(e.C0175e.ds20);
        this.eGE = (RelativeLayout) findViewById(e.g.bar_info_clean_lay);
        this.eGF = (RelativeLayout) findViewById(e.g.bar_info_history_lay);
        this.eGG = (RelativeLayout) findViewById(e.g.bar_info_member_lay);
        this.eGH = (RelativeLayout) findViewById(e.g.bar_info_manager_lay);
        this.eGI = (TextView) findViewById(e.g.bar_info_member_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.eGD.setVisibility(8);
                this.eGE.setVisibility(8);
                this.eGF.setVisibility(8);
            }
            this.eGH.setVisibility(z ? 0 : 8);
            findViewById(e.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (managerApplyInfo != null) {
            this.eGI.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format = String.format(getResources().getString(e.j.forum_detail_apply_left_num_tip), ao.G(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.eGI.setText(format);
                } else {
                    this.eGI.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.eGI.setText(getResources().getString(e.j.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.eGI.setText(getResources().getString(e.j.forum_detail_apply_failed));
            } else {
                this.eGI.setVisibility(8);
            }
        }
        d.aSV().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new h<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.eGD.setVisibility(8);
                this.eGE.setVisibility(8);
                this.eGF.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.eGD.setVisibility(0);
                this.eGE.setVisibility(0);
                this.eGF.setVisibility(0);
            } else if (intValue == 2) {
                this.eGF.setVisibility(8);
                this.eGE.setVisibility(0);
                this.eGD.setVisibility(0);
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
            this.eGD.getSwitchView().nS();
        } else {
            this.eGD.getSwitchView().nT();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.eGE.setOnClickListener(onClickListener);
        this.eGF.setOnClickListener(onClickListener);
        this.eGG.setOnClickListener(onClickListener);
        this.eGH.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.eGD.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.eGD.eS(i);
    }
}
