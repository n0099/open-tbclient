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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.d;
import tbclient.ManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView eCE;
    private RelativeLayout eCF;
    private RelativeLayout eCG;
    private RelativeLayout eCH;
    private RelativeLayout eCI;
    private TextView eCJ;

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
        this.eCE = (SettingTextSwitchView) findViewById(d.g.bar_notify);
        this.eCE.setTextLeftMargin(d.e.ds20);
        this.eCF = (RelativeLayout) findViewById(d.g.bar_info_clean_lay);
        this.eCG = (RelativeLayout) findViewById(d.g.bar_info_history_lay);
        this.eCH = (RelativeLayout) findViewById(d.g.bar_info_member_lay);
        this.eCI = (RelativeLayout) findViewById(d.g.bar_info_manager_lay);
        this.eCJ = (TextView) findViewById(d.g.bar_info_member_status);
        setVisibility(8);
    }

    public void b(RecommendForumInfo recommendForumInfo, boolean z, ManagerApplyInfo managerApplyInfo) {
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.eCE.setVisibility(8);
                this.eCF.setVisibility(8);
                this.eCG.setVisibility(8);
            }
            this.eCI.setVisibility(z ? 0 : 8);
            findViewById(d.g.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            setVisibility(0);
        }
        if (managerApplyInfo != null) {
            this.eCJ.setVisibility(0);
            if (managerApplyInfo.manager_apply_status.intValue() == -1) {
                String format = String.format(getResources().getString(d.j.forum_detail_apply_left_num_tip), am.C(managerApplyInfo.manager_left_num.intValue()));
                if (managerApplyInfo.manager_left_num.intValue() > 0) {
                    this.eCJ.setText(format);
                } else {
                    this.eCJ.setVisibility(8);
                }
            } else if (managerApplyInfo.manager_apply_status.intValue() == 1) {
                this.eCJ.setText(getResources().getString(d.j.forum_detail_applying));
            } else if (managerApplyInfo.manager_apply_status.intValue() == 2) {
                this.eCJ.setText(getResources().getString(d.j.forum_detail_apply_failed));
            } else {
                this.eCJ.setVisibility(8);
            }
        }
        com.baidu.tieba.im.settingcache.d.aLV().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new h<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.eCE.setVisibility(8);
                this.eCF.setVisibility(8);
                this.eCG.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.eCE.setVisibility(0);
                this.eCF.setVisibility(0);
                this.eCG.setVisibility(0);
            } else if (intValue == 2) {
                this.eCG.setVisibility(8);
                this.eCF.setVisibility(0);
                this.eCE.setVisibility(0);
                setVisibility(0);
            }
        }
    }

    public void c(RecommendForumInfo recommendForumInfo, boolean z) {
        setShowState(recommendForumInfo);
        if (!z) {
            setVisibility(8);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.eCE.getSwitchView().rH();
        } else {
            this.eCE.getSwitchView().rI();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.eCF.setOnClickListener(onClickListener);
        this.eCG.setOnClickListener(onClickListener);
        this.eCH.setOnClickListener(onClickListener);
        this.eCI.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.eCE.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().aQ(i == 1);
        forumDetailActivity.getLayoutMode().aM(this);
        this.eCE.hr(i);
    }
}
