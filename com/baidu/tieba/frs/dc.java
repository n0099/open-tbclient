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
    private View aHA;
    private View aHB;
    private View.OnClickListener aHC;
    private boolean aHD;
    private final com.baidu.adp.widget.BdSwitchView.c aHE;
    private LinearLayout aHm;
    private BdSwitchView aHn;
    private BdSwitchView aHo;
    private TextView aHp;
    private TextView aHq;
    private LinearLayout aHr;
    private LinearLayout aHs;
    private LinearLayout aHt;
    private LinearLayout aHu;
    private LinearLayout aHv;
    public LinearLayout aHw;
    private View aHx;
    private TextView aHy;
    private View aHz;
    private View mParent;

    public dc(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aHm = null;
        this.aHn = null;
        this.aHo = null;
        this.mParent = null;
        this.aHp = null;
        this.aHq = null;
        this.aHr = null;
        this.aHs = null;
        this.aHt = null;
        this.aHu = null;
        this.aHv = null;
        this.aHw = null;
        this.aHx = null;
        this.aHy = null;
        this.aHz = null;
        this.aHC = null;
        this.aHE = new dd(this);
        initUI();
    }

    public View getView() {
        return this.mParent;
    }

    public void init() {
        Hv();
        Hw();
    }

    private void initUI() {
        this.mParent = com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getContext(), com.baidu.tieba.x.frs_sidebar, null);
        this.aHy = (TextView) this.mParent.findViewById(com.baidu.tieba.w.add_recommend);
        this.aHz = this.mParent.findViewById(com.baidu.tieba.w.recommend_forum_layout_line);
        this.aHw = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.forum_manager_center);
        this.aHw.setVisibility(8);
        this.aHx = this.mParent.findViewById(com.baidu.tieba.w.forum_manager_center_line);
        this.aHx.setVisibility(8);
        this.aHo = (BdSwitchView) this.mParent.findViewById(com.baidu.tieba.w.thrift_mode_switch);
        this.aHo.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aHm = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.eyeshield_mode);
        this.aHn = (BdSwitchView) this.mParent.findViewById(com.baidu.tieba.w.eyeshield_mode_switch);
        this.aHn.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.mContext.getOrignalPage());
        this.aHn.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aHp = (TextView) this.mParent.findViewById(com.baidu.tieba.w.message_btn);
        this.aHq = (TextView) this.mParent.findViewById(com.baidu.tieba.w.mention_btn);
        this.aHr = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.message_layout);
        this.aHs = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.mention_layout);
        this.aHt = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.history_layout);
        this.aHu = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.bar_info_layout);
        this.aHv = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.recommend_forum_layout);
        this.aHA = this.mParent.findViewById(com.baidu.tieba.w.unfollow_layout_line);
        this.aHB = this.mParent.findViewById(com.baidu.tieba.w.unfollow_layout);
        if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aHt.setVisibility(8);
        }
        if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aHu.setVisibility(8);
        }
        TextView textView = (TextView) this.mParent.findViewById(com.baidu.tieba.w.content_title);
        if (this.aHt.getVisibility() == 8 && this.aHu.getVisibility() == 8) {
            textView.setVisibility(8);
        }
    }

    public void bW(boolean z) {
        this.aHA.setVisibility(z ? 0 : 8);
        this.aHB.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aHw.setVisibility(0);
            this.aHx.setVisibility(0);
            return;
        }
        this.aHw.setVisibility(8);
        this.aHx.setVisibility(8);
    }

    public BdSwitchView Ht() {
        return this.aHn;
    }

    public boolean Hu() {
        return this.aHD;
    }

    public void bX(boolean z) {
        this.aHD = z;
    }

    public void Hv() {
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            this.aHn.iL();
        } else {
            this.aHn.iM();
        }
    }

    public void Hw() {
        this.aHo.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.mc().mg()) {
            this.aHo.iL();
        } else {
            this.aHo.iM();
        }
        this.aHo.setOnSwitchStateChangeListener(this.aHE);
    }

    public void a(cy cyVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aHp.setVisibility(4);
            this.aHq.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (cyVar != null) {
                j = cyVar.Hs();
            }
            a(this.aHp, j);
        } else {
            this.aHp.setVisibility(4);
        }
        if (z2) {
            if (cyVar != null) {
                j = cyVar.Hr();
            }
            a(this.aHq, j);
            return;
        }
        this.aHq.setVisibility(4);
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
        this.aHC = onClickListener;
        this.aHr.setOnClickListener(this.aHC);
        this.aHs.setOnClickListener(this.aHC);
        this.aHt.setOnClickListener(this.aHC);
        this.aHu.setOnClickListener(this.aHC);
        this.aHw.setOnClickListener(this.aHC);
        this.aHB.setOnClickListener(this.aHC);
    }

    public void D(ArrayList<com.baidu.tbadk.core.data.s> arrayList) {
        this.aHv.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aHy.setVisibility(8);
            this.aHz.setVisibility(0);
            return;
        }
        this.aHy.setVisibility(0);
        this.aHz.setVisibility(8);
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
                String str2 = arrayList.get(i2).En;
                String str3 = arrayList.get(i2).Ep;
                de deVar = new de(this);
                deVar.name = str;
                deVar.aHG = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aHC);
                linearLayout2.setTag(deVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_image)).d(str2, 10, false);
                this.aHv.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ab(i == 1);
        layoutMode.h(this.mParent);
    }
}
