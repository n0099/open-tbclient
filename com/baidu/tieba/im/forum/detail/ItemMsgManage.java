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
/* loaded from: classes25.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView kfk;
    private RelativeLayout kfl;
    private RelativeLayout kfm;
    private RelativeLayout kfn;
    private RelativeLayout kfo;
    private TextView kfp;
    private RelativeLayout kfq;
    private RelativeLayout kfr;
    private TextView kfs;

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
        this.kfk = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.kfk.setTextLeftMargin(R.dimen.ds20);
        this.kfl = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.kfm = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.kfn = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.kfo = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.kfp = (TextView) findViewById(R.id.bar_info_member_status);
        this.kfq = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.kfr = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.kfs = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.kfq.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.kfk.setVisibility(8);
                this.kfl.setVisibility(8);
                this.kfm.setVisibility(8);
                this.kfq.setVisibility(8);
            }
            this.kfo.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.kfr.setVisibility(0);
                    this.kfs.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.kfr.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.kfp.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), au.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.kfp.setText(format);
                    } else {
                        this.kfp.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.kfp.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.kfp.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.kfp.setVisibility(8);
                }
            }
        } else {
            this.kfp.setVisibility(8);
        }
        d.cUM().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new m<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.kfk.setVisibility(8);
                this.kfl.setVisibility(8);
                this.kfm.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.kfk.setVisibility(0);
                this.kfl.setVisibility(0);
                this.kfm.setVisibility(0);
            } else if (intValue == 2) {
                this.kfm.setVisibility(8);
                this.kfl.setVisibility(0);
                this.kfk.setVisibility(0);
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
            this.kfk.getSwitchView().turnOnNoCallback();
        } else {
            this.kfk.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.kfl.setOnClickListener(onClickListener);
        this.kfm.setOnClickListener(onClickListener);
        this.kfn.setOnClickListener(onClickListener);
        this.kfo.setOnClickListener(onClickListener);
        this.kfq.setOnClickListener(onClickListener);
        this.kfr.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.kfk.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.kfk.rx(i);
    }
}
