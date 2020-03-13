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
    private TextView hzA;
    private SettingTextSwitchView hzs;
    private RelativeLayout hzt;
    private RelativeLayout hzu;
    private RelativeLayout hzv;
    private RelativeLayout hzw;
    private TextView hzx;
    private RelativeLayout hzy;
    private RelativeLayout hzz;

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
        this.hzs = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.hzs.setTextLeftMargin(R.dimen.ds20);
        this.hzt = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.hzu = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.hzv = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.hzw = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.hzx = (TextView) findViewById(R.id.bar_info_member_status);
        this.hzy = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.hzz = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.hzA = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.hzy.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.hzs.setVisibility(8);
                this.hzt.setVisibility(8);
                this.hzu.setVisibility(8);
                this.hzy.setVisibility(8);
            }
            this.hzw.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.hzz.setVisibility(0);
                    this.hzA.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.hzz.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.hzx.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), aq.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.hzx.setText(format);
                    } else {
                        this.hzx.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.hzx.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.hzx.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.hzx.setVisibility(8);
                }
            }
        } else {
            this.hzx.setVisibility(8);
        }
        d.bYc().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new l<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.hzs.setVisibility(8);
                this.hzt.setVisibility(8);
                this.hzu.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.hzs.setVisibility(0);
                this.hzt.setVisibility(0);
                this.hzu.setVisibility(0);
            } else if (intValue == 2) {
                this.hzu.setVisibility(8);
                this.hzt.setVisibility(0);
                this.hzs.setVisibility(0);
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
            this.hzs.getSwitchView().turnOnNoCallback();
        } else {
            this.hzs.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.hzt.setOnClickListener(onClickListener);
        this.hzu.setOnClickListener(onClickListener);
        this.hzv.setOnClickListener(onClickListener);
        this.hzw.setOnClickListener(onClickListener);
        this.hzy.setOnClickListener(onClickListener);
        this.hzz.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.hzs.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.hzs.me(i);
    }
}
