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
/* loaded from: classes26.dex */
public class ItemMsgManage extends LinearLayout {
    private SettingTextSwitchView keA;
    private RelativeLayout keB;
    private RelativeLayout keC;
    private RelativeLayout keD;
    private RelativeLayout keE;
    private TextView keF;
    private RelativeLayout keG;
    private RelativeLayout keH;
    private TextView keI;

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
        this.keA = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.keA.setTextLeftMargin(R.dimen.ds20);
        this.keB = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.keC = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.keD = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.keE = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.keF = (TextView) findViewById(R.id.bar_info_member_status);
        this.keG = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.keH = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.keI = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.keG.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.keA.setVisibility(8);
                this.keB.setVisibility(8);
                this.keC.setVisibility(8);
                this.keG.setVisibility(8);
            }
            this.keE.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.keH.setVisibility(0);
                    this.keI.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.keH.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (z3) {
            if (priManagerApplyInfo != null) {
                int intValue = priManagerApplyInfo.assist_apply_status.intValue();
                int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
                this.keF.setVisibility(0);
                if (intValue == -1) {
                    String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), at.numberUniformFormat(intValue2));
                    if (intValue2 > 0) {
                        this.keF.setText(format);
                    } else {
                        this.keF.setVisibility(8);
                    }
                } else if (intValue == 1) {
                    this.keF.setText(getResources().getString(R.string.forum_detail_private_applying));
                } else if (intValue == 2) {
                    this.keF.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
                } else {
                    this.keF.setVisibility(8);
                }
            }
        } else {
            this.keF.setVisibility(8);
        }
        d.cVg().a(TbadkApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new m<Boolean>() { // from class: com.baidu.tieba.im.forum.detail.ItemMsgManage.1
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
                this.keA.setVisibility(8);
                this.keB.setVisibility(8);
                this.keC.setVisibility(8);
            } else if (intValue == 1) {
                setVisibility(0);
                this.keA.setVisibility(0);
                this.keB.setVisibility(0);
                this.keC.setVisibility(0);
            } else if (intValue == 2) {
                this.keC.setVisibility(8);
                this.keB.setVisibility(0);
                this.keA.setVisibility(0);
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
            this.keA.getSwitchView().turnOnNoCallback();
        } else {
            this.keA.getSwitchView().turnOffNoCallback();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.keB.setOnClickListener(onClickListener);
        this.keC.setOnClickListener(onClickListener);
        this.keD.setOnClickListener(onClickListener);
        this.keE.setOnClickListener(onClickListener);
        this.keG.setOnClickListener(onClickListener);
        this.keH.setOnClickListener(onClickListener);
    }

    public void setSwitchChangeListener(BdSwitchView.a aVar) {
        this.keA.setSwitchStateChangeListener(aVar);
    }

    public void a(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().setNightMode(i == 1);
        forumDetailActivity.getLayoutMode().onModeChanged(this);
        this.keA.qZ(i);
    }
}
