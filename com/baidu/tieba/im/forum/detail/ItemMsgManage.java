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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.d;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView erC;
    private RelativeLayout erD;
    private RelativeLayout erE;
    private RelativeLayout erF;
    private RelativeLayout erG;
    private TextView erH;

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
        LayoutInflater.from(context).inflate(d.h.forum_detail_msg_manage, (ViewGroup) this, true);
        this.erC = (SettingTextSwitchView) findViewById(d.g.bar_notify);
        this.erC.setTextLeftMargin(d.e.ds20);
        this.erD = (RelativeLayout) findViewById(d.g.bar_info_clean_lay);
        this.erE = (RelativeLayout) findViewById(d.g.bar_info_history_lay);
        this.erF = (RelativeLayout) findViewById(d.g.bar_info_member_lay);
        this.erG = (RelativeLayout) findViewById(d.g.bar_info_manager_lay);
        this.erH = (TextView) findViewById(d.g.bar_info_member_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.erC.setVisibility(8);
                this.erD.setVisibility(8);
                this.erE.setVisibility(8);
            }
            this.erG.setVisibility(z ? 0 : 8);
            findViewById(d.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (managerApplyInfo != null) {
            this.erH.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format = String.format(getResources().getString(d.j.forum_detail_apply_left_num_tip), ap.A(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.erH.setText(format);
                } else {
                    this.erH.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.erH.setText(getResources().getString(d.j.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.erH.setText(getResources().getString(d.j.forum_detail_apply_failed));
            } else {
                this.erH.setVisibility(8);
            }
        }
        com.baidu.tieba.im.settingcache.d.aNv().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new g<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.g
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
                this.erC.setVisibility(8);
                this.erD.setVisibility(8);
                this.erE.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.erC.setVisibility(0);
                this.erD.setVisibility(0);
                this.erE.setVisibility(0);
            } else if (intValue == 2) {
                this.erE.setVisibility(8);
                this.erD.setVisibility(0);
                this.erC.setVisibility(0);
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
            this.erC.getSwitchView().mC();
        } else {
            this.erC.getSwitchView().mD();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.erD.setOnClickListener(onClickListener);
        this.erE.setOnClickListener(onClickListener);
        this.erF.setOnClickListener(onClickListener);
        this.erG.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.erC.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.erC.ey(i);
    }
}
