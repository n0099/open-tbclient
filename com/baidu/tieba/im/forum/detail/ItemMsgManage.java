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
    private SettingTextSwitchView kGZ;
    private RelativeLayout kHa;
    private RelativeLayout kHb;
    private RelativeLayout kHc;
    private RelativeLayout kHd;
    private TextView kHe;
    private RelativeLayout kHf;
    private RelativeLayout kHg;
    private TextView kHh;

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
        this.kGZ = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.kGZ.setTextLeftMargin(R.dimen.ds20);
        this.kHa = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.kHb = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.kHc = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.kHd = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.kHe = (TextView) findViewById(R.id.bar_info_member_status);
        this.kHf = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.kHg = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.kHh = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.kHf.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.kGZ.setVisibility(8);
                this.kHa.setVisibility(8);
                this.kHb.setVisibility(8);
                this.kHf.setVisibility(8);
            }
            this.kHd.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.kHg.setVisibility(0);
                    this.kHh.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.kHg.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.kHe.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), au.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.kHe.setText(format);
                    } else {
                        this.kHe.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.kHe.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.kHe.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.kHe.setVisibility(8);
                }
            }
        } else {
            this.kHe.setVisibility(8);
        }
        d.cXT().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new m<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.kGZ.setVisibility(8);
                this.kHa.setVisibility(8);
                this.kHb.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.kGZ.setVisibility(0);
                this.kHa.setVisibility(0);
                this.kHb.setVisibility(0);
            } else if (intValue == 2) {
                this.kHb.setVisibility(8);
                this.kHa.setVisibility(0);
                this.kGZ.setVisibility(0);
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
            this.kGZ.getSwitchView().turnOnNoCallback();
        } else {
            this.kGZ.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.kHa.setOnClickListener(onClickListener);
        this.kHb.setOnClickListener(onClickListener);
        this.kHc.setOnClickListener(onClickListener);
        this.kHd.setOnClickListener(onClickListener);
        this.kHf.setOnClickListener(onClickListener);
        this.kHg.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.kGZ.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.kGZ.qJ(i);
    }
}
