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
import com.baidu.tbadk.core.util.at;
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
    private SettingTextSwitchView jxh;
    private RelativeLayout jxi;
    private RelativeLayout jxj;
    private RelativeLayout jxk;
    private RelativeLayout jxl;
    private TextView jxm;
    private RelativeLayout jxn;
    private RelativeLayout jxo;
    private TextView jxp;

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
        this.jxh = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.jxh.setTextLeftMargin(R.dimen.ds20);
        this.jxi = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.jxj = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.jxk = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.jxl = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.jxm = (TextView) findViewById(R.id.bar_info_member_status);
        this.jxn = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.jxo = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.jxp = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.jxn.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.jxh.setVisibility(8);
                this.jxi.setVisibility(8);
                this.jxj.setVisibility(8);
                this.jxn.setVisibility(8);
            }
            this.jxl.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.jxo.setVisibility(0);
                    this.jxp.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.jxo.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.jxm.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), at.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.jxm.setText(format);
                    } else {
                        this.jxm.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.jxm.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.jxm.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.jxm.setVisibility(8);
                }
            }
        } else {
            this.jxm.setVisibility(8);
        }
        d.cLQ().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new m<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.jxh.setVisibility(8);
                this.jxi.setVisibility(8);
                this.jxj.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.jxh.setVisibility(0);
                this.jxi.setVisibility(0);
                this.jxj.setVisibility(0);
            } else if (intValue == 2) {
                this.jxj.setVisibility(8);
                this.jxi.setVisibility(0);
                this.jxh.setVisibility(0);
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
            this.jxh.getSwitchView().turnOnNoCallback();
        } else {
            this.jxh.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.jxi.setOnClickListener(onClickListener);
        this.jxj.setOnClickListener(onClickListener);
        this.jxk.setOnClickListener(onClickListener);
        this.jxl.setOnClickListener(onClickListener);
        this.jxn.setOnClickListener(onClickListener);
        this.jxo.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.jxh.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.jxh.qg(i);
    }
}
