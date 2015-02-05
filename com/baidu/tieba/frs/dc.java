package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dc extends com.baidu.adp.base.g<FrsActivity> {
    private boolean aHA;
    private final com.baidu.adp.widget.BdSwitchView.c aHB;
    private LinearLayout aHj;
    private BdSwitchView aHk;
    private BdSwitchView aHl;
    private TextView aHm;
    private TextView aHn;
    private LinearLayout aHo;
    private LinearLayout aHp;
    private LinearLayout aHq;
    private LinearLayout aHr;
    private LinearLayout aHs;
    public LinearLayout aHt;
    private View aHu;
    private TextView aHv;
    private View aHw;
    private View aHx;
    private View aHy;
    private View.OnClickListener aHz;
    private View mParent;

    public dc(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aHj = null;
        this.aHk = null;
        this.aHl = null;
        this.mParent = null;
        this.aHm = null;
        this.aHn = null;
        this.aHo = null;
        this.aHp = null;
        this.aHq = null;
        this.aHr = null;
        this.aHs = null;
        this.aHt = null;
        this.aHu = null;
        this.aHv = null;
        this.aHw = null;
        this.aHz = null;
        this.aHB = new dd(this);
        initUI();
    }

    public View getView() {
        return this.mParent;
    }

    public void init() {
        Hp();
        Hq();
    }

    private void initUI() {
        this.mParent = com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getContext(), com.baidu.tieba.x.frs_sidebar, null);
        this.aHv = (TextView) this.mParent.findViewById(com.baidu.tieba.w.add_recommend);
        this.aHw = this.mParent.findViewById(com.baidu.tieba.w.recommend_forum_layout_line);
        this.aHt = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.forum_manager_center);
        this.aHt.setVisibility(8);
        this.aHu = this.mParent.findViewById(com.baidu.tieba.w.forum_manager_center_line);
        this.aHu.setVisibility(8);
        this.aHl = (BdSwitchView) this.mParent.findViewById(com.baidu.tieba.w.thrift_mode_switch);
        this.aHl.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aHj = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.eyeshield_mode);
        this.aHk = (BdSwitchView) this.mParent.findViewById(com.baidu.tieba.w.eyeshield_mode_switch);
        this.aHk.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.mContext.getOrignalPage());
        this.aHk.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aHm = (TextView) this.mParent.findViewById(com.baidu.tieba.w.message_btn);
        this.aHn = (TextView) this.mParent.findViewById(com.baidu.tieba.w.mention_btn);
        this.aHo = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.message_layout);
        this.aHp = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.mention_layout);
        this.aHq = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.history_layout);
        this.aHr = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.bar_info_layout);
        this.aHs = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.recommend_forum_layout);
        this.aHx = this.mParent.findViewById(com.baidu.tieba.w.unfollow_layout_line);
        this.aHy = this.mParent.findViewById(com.baidu.tieba.w.unfollow_layout);
        if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aHq.setVisibility(8);
        }
        if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aHr.setVisibility(8);
        }
        TextView textView = (TextView) this.mParent.findViewById(com.baidu.tieba.w.content_title);
        if (this.aHq.getVisibility() == 8 && this.aHr.getVisibility() == 8) {
            textView.setVisibility(8);
        }
    }

    public void bW(boolean z) {
        this.aHx.setVisibility(z ? 0 : 8);
        this.aHy.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aHt.setVisibility(0);
            this.aHu.setVisibility(0);
            return;
        }
        this.aHt.setVisibility(8);
        this.aHu.setVisibility(8);
    }

    public BdSwitchView Hn() {
        return this.aHk;
    }

    public boolean Ho() {
        return this.aHA;
    }

    public void bX(boolean z) {
        this.aHA = z;
    }

    public void Hp() {
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            this.aHk.iE();
        } else {
            this.aHk.iF();
        }
    }

    public void Hq() {
        this.aHl.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.lV().lZ()) {
            this.aHl.iE();
        } else {
            this.aHl.iF();
        }
        this.aHl.setOnSwitchStateChangeListener(this.aHB);
    }

    public void a(cy cyVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aHm.setVisibility(4);
            this.aHn.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (cyVar != null) {
                j = cyVar.Hm();
            }
            a(this.aHm, j);
        } else {
            this.aHm.setVisibility(4);
        }
        if (z2) {
            if (cyVar != null) {
                j = cyVar.Hl();
            }
            a(this.aHn, j);
            return;
        }
        this.aHn.setVisibility(4);
    }

    private void a(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.bc.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.bc.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.bc.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.aHz = onClickListener;
        this.aHo.setOnClickListener(this.aHz);
        this.aHp.setOnClickListener(this.aHz);
        this.aHq.setOnClickListener(this.aHz);
        this.aHr.setOnClickListener(this.aHz);
        this.aHt.setOnClickListener(this.aHz);
        this.aHy.setOnClickListener(this.aHz);
    }

    public void D(ArrayList<com.baidu.tbadk.core.data.s> arrayList) {
        this.aHs.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aHv.setVisibility(8);
            this.aHw.setVisibility(0);
            return;
        }
        this.aHv.setVisibility(0);
        this.aHw.setVisibility(8);
        int size = arrayList.size();
        if (size != 0) {
            int i = size > 10 ? 10 : size;
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
            layoutMode.ab(skinType == 1);
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getContext(), com.baidu.tieba.x.frs_sidebar_item, null);
                layoutMode.h(linearLayout);
                String str = arrayList.get(i2).mForumName;
                String str2 = arrayList.get(i2).Ek;
                String str3 = arrayList.get(i2).Em;
                de deVar = new de(this);
                deVar.name = str;
                deVar.aHD = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aHz);
                linearLayout2.setTag(deVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_image)).d(str2, 10, false);
                this.aHs.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ab(i == 1);
        layoutMode.h(this.mParent);
    }
}
