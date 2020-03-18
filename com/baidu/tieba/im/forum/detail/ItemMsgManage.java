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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.d;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes13.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView hAS;
    private RelativeLayout hAT;
    private RelativeLayout hAU;
    private RelativeLayout hAV;
    private RelativeLayout hAW;
    private TextView hAX;
    private RelativeLayout hAY;
    private RelativeLayout hAZ;
    private TextView hBa;

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
        LayoutInflater.from(context).inflate(R.layout.forum_detail_msg_manage, (ViewGroup) this, true);
        this.hAS = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.hAS.setTextLeftMargin(R.dimen.ds20);
        this.hAT = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.hAU = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.hAV = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.hAW = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.hAX = (TextView) findViewById(R.id.bar_info_member_status);
        this.hAY = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.hAZ = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.hBa = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.hAY.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.hAS.setVisibility(8);
                this.hAT.setVisibility(8);
                this.hAU.setVisibility(8);
                this.hAY.setVisibility(8);
            }
            this.hAW.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.hAZ.setVisibility(0);
                    this.hBa.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.hAZ.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.hAX.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), aq.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.hAX.setText(format);
                    } else {
                        this.hAX.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.hAX.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.hAX.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.hAX.setVisibility(8);
                }
            }
        } else {
            this.hAX.setVisibility(8);
        }
        d.bYu().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new l<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.l
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
                this.hAS.setVisibility(8);
                this.hAT.setVisibility(8);
                this.hAU.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.hAS.setVisibility(0);
                this.hAT.setVisibility(0);
                this.hAU.setVisibility(0);
            } else if (intValue == 2) {
                this.hAU.setVisibility(8);
                this.hAT.setVisibility(0);
                this.hAS.setVisibility(0);
                setVisibility(0);
            }
        }
    }

    public void setShowState(RecommendForumInfo recommendForumInfo, boolean z) {
        setShowState(recommendForumInfo);
        if (!z) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.hAS.getSwitchView().turnOnNoCallback();
        } else {
            this.hAS.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.hAT.setOnClickListener(onClickListener);
        this.hAU.setOnClickListener(onClickListener);
        this.hAV.setOnClickListener(onClickListener);
        this.hAW.setOnClickListener(onClickListener);
        this.hAY.setOnClickListener(onClickListener);
        this.hAZ.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.hAS.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.hAS.mg(i);
    }
}
