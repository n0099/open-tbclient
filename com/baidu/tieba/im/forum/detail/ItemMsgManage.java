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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.coreExtra.view.SettingTextSwitchView;
import com.baidu.tieba.R;
import d.b.h0.z0.n;
import d.b.i0.d1.t.d;
import tbclient.GetForumDetail.ManagerApplyInfo;
import tbclient.GetForumDetail.ManagerElectionTab;
import tbclient.PriManagerApplyInfo;
import tbclient.RecommendForumInfo;
/* loaded from: classes3.dex */
public class ItemMsgManage extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public SettingTextSwitchView f17987e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f17988f;

    /* renamed from: g  reason: collision with root package name */
    public RelativeLayout f17989g;

    /* renamed from: h  reason: collision with root package name */
    public RelativeLayout f17990h;
    public RelativeLayout i;
    public TextView j;
    public RelativeLayout k;
    public RelativeLayout l;
    public TextView m;

    /* loaded from: classes3.dex */
    public class a implements n<Boolean> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Boolean bool) {
            if (bool == null) {
                return;
            }
            ItemMsgManage.this.setSwitch(bool.booleanValue());
        }
    }

    public ItemMsgManage(Context context) {
        super(context);
        a(context);
    }

    private void setShowState(RecommendForumInfo recommendForumInfo) {
        if (recommendForumInfo == null) {
            return;
        }
        int intValue = recommendForumInfo.forum_type.intValue();
        if (intValue == 0) {
            this.f17987e.setVisibility(8);
            this.f17988f.setVisibility(8);
            this.f17989g.setVisibility(8);
        } else if (intValue == 1) {
            setVisibility(0);
            this.f17987e.setVisibility(0);
            this.f17988f.setVisibility(0);
            this.f17989g.setVisibility(0);
        } else if (intValue == 2) {
            this.f17989g.setVisibility(8);
            this.f17988f.setVisibility(0);
            this.f17987e.setVisibility(0);
            setVisibility(0);
        }
    }

    public void a(Context context) {
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.forum_detail_msg_manage, (ViewGroup) this, true);
        SettingTextSwitchView settingTextSwitchView = (SettingTextSwitchView) findViewById(R.id.bar_notify);
        this.f17987e = settingTextSwitchView;
        settingTextSwitchView.setTextLeftMargin(R.dimen.ds20);
        this.f17988f = (RelativeLayout) findViewById(R.id.bar_info_clean_lay);
        this.f17989g = (RelativeLayout) findViewById(R.id.bar_info_history_lay);
        this.f17990h = (RelativeLayout) findViewById(R.id.bar_info_member_lay);
        this.i = (RelativeLayout) findViewById(R.id.bar_info_manager_lay);
        this.j = (TextView) findViewById(R.id.bar_info_member_status);
        this.k = (RelativeLayout) findViewById(R.id.bar_info_complaint_lay);
        this.l = (RelativeLayout) findViewById(R.id.bar_manager_apply_lay);
        this.m = (TextView) findViewById(R.id.bar_manager_apply_status);
        setVisibility(8);
    }

    public void b(ForumDetailActivity forumDetailActivity, int i) {
        forumDetailActivity.getLayoutMode().k(i == 1);
        forumDetailActivity.getLayoutMode().j(this);
        this.f17987e.d(i);
    }

    public void setData(RecommendForumInfo recommendForumInfo, boolean z, boolean z2, ManagerApplyInfo managerApplyInfo, PriManagerApplyInfo priManagerApplyInfo, ManagerElectionTab managerElectionTab) {
        boolean z3 = recommendForumInfo.is_private_forum.intValue() != 0;
        setShowState(recommendForumInfo);
        if (!TbadkCoreApplication.isLogin()) {
            setVisibility(8);
        } else {
            this.k.setVisibility(z2 ? 0 : 8);
            if (recommendForumInfo.is_like.intValue() == 0) {
                this.f17987e.setVisibility(8);
                this.f17988f.setVisibility(8);
                this.f17989g.setVisibility(8);
                this.k.setVisibility(8);
            }
            this.i.setVisibility(z ? 0 : 8);
            findViewById(R.id.bar_info_manager_divider).setVisibility(z ? 0 : 8);
            if (managerElectionTab != null) {
                if (managerElectionTab.is_new_strategy.intValue() == 1) {
                    this.l.setVisibility(0);
                    this.m.setText(managerElectionTab.new_strategy_text);
                } else {
                    this.l.setVisibility(8);
                }
            }
            setVisibility(0);
        }
        if (!z3) {
            this.j.setVisibility(8);
        } else if (priManagerApplyInfo != null) {
            int intValue = priManagerApplyInfo.assist_apply_status.intValue();
            int intValue2 = priManagerApplyInfo.assist_left_num.intValue();
            this.j.setVisibility(0);
            if (intValue == -1) {
                String format = String.format(getResources().getString(R.string.forum_detail_private_apply_left_num_tip), StringHelper.numberUniformFormat(intValue2));
                if (intValue2 > 0) {
                    this.j.setText(format);
                } else {
                    this.j.setVisibility(8);
                }
            } else if (intValue == 1) {
                this.j.setText(getResources().getString(R.string.forum_detail_private_applying));
            } else if (intValue == 2) {
                this.j.setText(getResources().getString(R.string.forum_detail_private_apply_failed));
            } else {
                this.j.setVisibility(8);
            }
        }
        d.j().d(TbadkCoreApplication.getCurrentAccount(), String.valueOf(recommendForumInfo.forum_id), new a());
    }

    public void setMsgOnClickListener(View.OnClickListener onClickListener) {
        this.f17988f.setOnClickListener(onClickListener);
        this.f17989g.setOnClickListener(onClickListener);
        this.f17990h.setOnClickListener(onClickListener);
        this.i.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
        this.l.setOnClickListener(onClickListener);
    }

    public void setSwitch(boolean z) {
        if (z) {
            this.f17987e.getSwitchView().k();
        } else {
            this.f17987e.getSwitchView().h();
        }
    }

    public void setSwitchChangeListener(BdSwitchView.b bVar) {
        this.f17987e.setSwitchStateChangeListener(bVar);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ItemMsgManage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void setShowState(RecommendForumInfo recommendForumInfo, boolean z) {
        setShowState(recommendForumInfo);
        if (!z) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }
}
