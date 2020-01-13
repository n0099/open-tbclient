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
/* loaded from: classes11.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView hxf;
    private RelativeLayout hxg;
    private RelativeLayout hxh;
    private RelativeLayout hxi;
    private RelativeLayout hxj;
    private TextView hxk;
    private RelativeLayout hxl;
    private RelativeLayout hxm;
    private TextView hxn;

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
        this.hxf = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.hxf.setTextLeftMargin(R.dimen.ds20);
        this.hxg = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.hxh = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.hxi = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.hxj = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.hxk = (TextView) findViewById(R.id.bar_info_member_status);
        this.hxl = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.hxm = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.hxn = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.hxl.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.hxf.setVisibility(8);
                this.hxg.setVisibility(8);
                this.hxh.setVisibility(8);
                this.hxl.setVisibility(8);
            }
            this.hxj.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.hxm.setVisibility(0);
                    this.hxn.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.hxm.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.hxk.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), aq.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.hxk.setText(format);
                    } else {
                        this.hxk.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.hxk.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.hxk.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.hxk.setVisibility(8);
                }
            }
        } else {
            this.hxk.setVisibility(8);
        }
        d.bWy().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new l<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.hxf.setVisibility(8);
                this.hxg.setVisibility(8);
                this.hxh.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.hxf.setVisibility(0);
                this.hxg.setVisibility(0);
                this.hxh.setVisibility(0);
            } else if (intValue == 2) {
                this.hxh.setVisibility(8);
                this.hxg.setVisibility(0);
                this.hxf.setVisibility(0);
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
            this.hxf.getSwitchView().turnOnNoCallback();
        } else {
            this.hxf.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.hxg.setOnClickListener(onClickListener);
        this.hxh.setOnClickListener(onClickListener);
        this.hxi.setOnClickListener(onClickListener);
        this.hxj.setOnClickListener(onClickListener);
        this.hxl.setOnClickListener(onClickListener);
        this.hxm.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.hxf.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.hxf.lM(i);
    }
}
