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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tbadk.util.m;
import com.baidu.tieba.R;
import com.baidu.tieba.im.settingcache.d;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes8.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView kHn;
    private RelativeLayout kHo;
    private RelativeLayout kHp;
    private RelativeLayout kHq;
    private RelativeLayout kHr;
    private TextView kHs;
    private RelativeLayout kHt;
    private RelativeLayout kHu;
    private TextView kHv;

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
        this.kHn = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.kHn.setTextLeftMargin(R.dimen.ds20);
        this.kHo = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.kHp = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.kHq = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.kHr = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.kHs = (TextView) findViewById(R.id.bar_info_member_status);
        this.kHt = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.kHu = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.kHv = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.kHt.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.kHn.setVisibility(8);
                this.kHo.setVisibility(8);
                this.kHp.setVisibility(8);
                this.kHt.setVisibility(8);
            }
            this.kHr.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.kHu.setVisibility(0);
                    this.kHv.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.kHu.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.kHs.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), au.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.kHs.setText(format);
                    } else {
                        this.kHs.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.kHs.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.kHs.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.kHs.setVisibility(8);
                }
            }
        } else {
            this.kHs.setVisibility(8);
        }
        d.cYa().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new m<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tbadk.util.m
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
                this.kHn.setVisibility(8);
                this.kHo.setVisibility(8);
                this.kHp.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.kHn.setVisibility(0);
                this.kHo.setVisibility(0);
                this.kHp.setVisibility(0);
            } else if (intValue == 2) {
                this.kHp.setVisibility(8);
                this.kHo.setVisibility(0);
                this.kHn.setVisibility(0);
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
            this.kHn.getSwitchView().turnOnNoCallback();
        } else {
            this.kHn.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.kHo.setOnClickListener(onClickListener);
        this.kHp.setOnClickListener(onClickListener);
        this.kHq.setOnClickListener(onClickListener);
        this.kHr.setOnClickListener(onClickListener);
        this.kHt.setOnClickListener(onClickListener);
        this.kHu.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.kHn.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.kHn.qJ(i);
    }
}
