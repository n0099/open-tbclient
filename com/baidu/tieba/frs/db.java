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
public class db extends com.baidu.adp.base.g<FrsActivity> {
    private LinearLayout aGc;
    private BdSwitchView aGd;
    private BdSwitchView aGe;
    private TextView aGf;
    private TextView aGg;
    private LinearLayout aGh;
    private LinearLayout aGi;
    private LinearLayout aGj;
    private LinearLayout aGk;
    private LinearLayout aGl;
    public LinearLayout aGm;
    private View aGn;
    private TextView aGo;
    private View aGp;
    private View aGq;
    private View aGr;
    private View.OnClickListener aGs;
    private boolean aGt;
    private final com.baidu.adp.widget.BdSwitchView.c aGu;
    private View mParent;

    public db(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aGc = null;
        this.aGd = null;
        this.aGe = null;
        this.mParent = null;
        this.aGf = null;
        this.aGg = null;
        this.aGh = null;
        this.aGi = null;
        this.aGj = null;
        this.aGk = null;
        this.aGl = null;
        this.aGm = null;
        this.aGn = null;
        this.aGo = null;
        this.aGp = null;
        this.aGs = null;
        this.aGu = new dc(this);
        initUI();
    }

    public View getView() {
        return this.mParent;
    }

    public void init() {
        GX();
        GY();
    }

    private void initUI() {
        this.mParent = com.baidu.adp.lib.g.b.ek().inflate(this.mContext.getContext(), com.baidu.tieba.x.frs_sidebar, null);
        this.aGo = (TextView) this.mParent.findViewById(com.baidu.tieba.w.add_recommend);
        this.aGp = this.mParent.findViewById(com.baidu.tieba.w.recommend_forum_layout_line);
        this.aGm = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.forum_manager_center);
        this.aGm.setVisibility(8);
        this.aGn = this.mParent.findViewById(com.baidu.tieba.w.forum_manager_center_line);
        this.aGn.setVisibility(8);
        this.aGe = (BdSwitchView) this.mParent.findViewById(com.baidu.tieba.w.thrift_mode_switch);
        this.aGe.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aGc = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.eyeshield_mode);
        this.aGd = (BdSwitchView) this.mParent.findViewById(com.baidu.tieba.w.eyeshield_mode_switch);
        this.aGd.setOnSwitchStateChangeListener((com.baidu.adp.widget.BdSwitchView.c) this.mContext.getOrignalPage());
        this.aGd.setSwitchStyle(BdSwitchView.SwitchStyle.SIDE_BAR);
        this.aGf = (TextView) this.mParent.findViewById(com.baidu.tieba.w.message_btn);
        this.aGg = (TextView) this.mParent.findViewById(com.baidu.tieba.w.mention_btn);
        this.aGh = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.message_layout);
        this.aGi = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.mention_layout);
        this.aGj = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.history_layout);
        this.aGk = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.bar_info_layout);
        this.aGl = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.recommend_forum_layout);
        this.aGq = this.mParent.findViewById(com.baidu.tieba.w.unfollow_layout_line);
        this.aGr = this.mParent.findViewById(com.baidu.tieba.w.unfollow_layout);
        if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aGj.setVisibility(8);
        }
        if (!TbadkCoreApplication.m255getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aGk.setVisibility(8);
        }
        TextView textView = (TextView) this.mParent.findViewById(com.baidu.tieba.w.content_title);
        if (this.aGj.getVisibility() == 8 && this.aGk.getVisibility() == 8) {
            textView.setVisibility(8);
        }
    }

    public void bT(boolean z) {
        this.aGq.setVisibility(z ? 0 : 8);
        this.aGr.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aGm.setVisibility(0);
            this.aGn.setVisibility(0);
            return;
        }
        this.aGm.setVisibility(8);
        this.aGn.setVisibility(8);
    }

    public BdSwitchView GV() {
        return this.aGd;
    }

    public boolean GW() {
        return this.aGt;
    }

    public void bU(boolean z) {
        this.aGt = z;
    }

    public void GX() {
        if (TbadkCoreApplication.m255getInst().getSkinType() == 1) {
            this.aGd.iK();
        } else {
            this.aGd.iL();
        }
    }

    public void GY() {
        this.aGe.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.mc().mg()) {
            this.aGe.iK();
        } else {
            this.aGe.iL();
        }
        this.aGe.setOnSwitchStateChangeListener(this.aGu);
    }

    public void a(cx cxVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aGf.setVisibility(4);
            this.aGg.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (cxVar != null) {
                j = cxVar.GU();
            }
            a(this.aGf, j);
        } else {
            this.aGf.setVisibility(4);
        }
        if (z2) {
            if (cxVar != null) {
                j = cxVar.GT();
            }
            a(this.aGg, j);
            return;
        }
        this.aGg.setVisibility(4);
    }

    private void a(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ax.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ax.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.ax.i((View) textView, com.baidu.tieba.v.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.aGs = onClickListener;
        this.aGh.setOnClickListener(this.aGs);
        this.aGi.setOnClickListener(this.aGs);
        this.aGj.setOnClickListener(this.aGs);
        this.aGk.setOnClickListener(this.aGs);
        this.aGm.setOnClickListener(this.aGs);
        this.aGr.setOnClickListener(this.aGs);
    }

    public void C(ArrayList<com.baidu.tbadk.core.data.r> arrayList) {
        this.aGl.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aGo.setVisibility(8);
            this.aGp.setVisibility(0);
            return;
        }
        this.aGo.setVisibility(0);
        this.aGp.setVisibility(8);
        int size = arrayList.size();
        if (size != 0) {
            int i = size > 10 ? 10 : size;
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
            layoutMode.ab(skinType == 1);
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(this.mContext.getContext(), com.baidu.tieba.x.frs_sidebar_item, null);
                layoutMode.h(linearLayout);
                String str = arrayList.get(i2).mForumName;
                String str2 = arrayList.get(i2).Ej;
                String str3 = arrayList.get(i2).El;
                dd ddVar = new dd(this);
                ddVar.name = str;
                ddVar.aGw = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aGs);
                linearLayout2.setTag(ddVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.w.recommend_forum_image)).d(str2, 10, false);
                this.aGl.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ab(i == 1);
        layoutMode.h(this.mParent);
    }
}
