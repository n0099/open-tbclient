package com.baidu.tieba.frs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BarImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ci extends com.baidu.adp.base.g<FrsActivity> {
    private View LG;
    private LinearLayout aOV;
    private BdSwitchView aOW;
    private BdSwitchView aOX;
    private TextView aOY;
    private TextView aOZ;
    private LinearLayout aPa;
    private LinearLayout aPb;
    private LinearLayout aPc;
    private LinearLayout aPd;
    private LinearLayout aPe;
    private LinearLayout aPf;
    private LinearLayout aPg;
    public LinearLayout aPh;
    private View aPi;
    private TextView aPj;
    private View aPk;
    private View aPl;
    private View aPm;
    private View.OnClickListener aPn;
    private boolean aPo;
    private final com.baidu.adp.widget.BdSwitchView.b aPp;

    public ci(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aOV = null;
        this.aOW = null;
        this.aOX = null;
        this.LG = null;
        this.aOY = null;
        this.aOZ = null;
        this.aPa = null;
        this.aPb = null;
        this.aPc = null;
        this.aPd = null;
        this.aPe = null;
        this.aPf = null;
        this.aPg = null;
        this.aPh = null;
        this.aPi = null;
        this.aPj = null;
        this.aPk = null;
        this.aPn = null;
        this.aPp = new cj(this);
        initUI();
    }

    public View getView() {
        return this.LG;
    }

    public void init() {
        LO();
        LP();
    }

    private void initUI() {
        this.LG = com.baidu.adp.lib.g.b.hr().inflate(this.mContext.getPageActivity(), com.baidu.tieba.r.frs_sidebar, null);
        this.aPa = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.post_search_ll);
        this.aPb = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.show_content);
        this.aPj = (TextView) this.LG.findViewById(com.baidu.tieba.q.add_recommend);
        this.aPk = this.LG.findViewById(com.baidu.tieba.q.recommend_forum_layout_line);
        this.aPh = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.forum_manager_center);
        this.aPh.setVisibility(8);
        this.aPi = this.LG.findViewById(com.baidu.tieba.q.forum_manager_center_line);
        this.aPi.setVisibility(8);
        this.aOX = (BdSwitchView) this.LG.findViewById(com.baidu.tieba.q.thrift_mode_switch);
        com.baidu.adp.lib.util.n.a(this.mContext.getPageActivity(), this.aOX, 10, 10, 10, 10);
        this.aOV = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.eyeshield_mode);
        this.aOW = (BdSwitchView) this.LG.findViewById(com.baidu.tieba.q.eyeshield_mode_switch);
        com.baidu.adp.lib.util.n.a(this.mContext.getPageActivity(), this.aOW, 10, 10, 10, 10);
        this.aOY = (TextView) this.LG.findViewById(com.baidu.tieba.q.message_btn);
        this.aOZ = (TextView) this.LG.findViewById(com.baidu.tieba.q.mention_btn);
        this.aPc = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.message_layout);
        this.aPd = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.mention_layout);
        this.aPe = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.history_layout);
        this.aPf = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.bar_info_layout);
        this.aPg = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.recommend_forum_layout);
        this.aPl = this.LG.findViewById(com.baidu.tieba.q.unfollow_layout_line);
        this.aPm = this.LG.findViewById(com.baidu.tieba.q.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aPe.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aPf.setVisibility(8);
        }
        TextView textView = (TextView) this.LG.findViewById(com.baidu.tieba.q.content_title);
        if (this.aPe.getVisibility() == 8 && this.aPf.getVisibility() == 8) {
            textView.setVisibility(8);
        }
        if (!LL()) {
            this.aOV.setVisibility(8);
            this.aOW.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aPb.addView(createStateBarFillView(), 0);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean LL() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    public void cd(boolean z) {
        this.aPl.setVisibility(z ? 0 : 8);
        this.aPm.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aPh.setVisibility(0);
            this.aPi.setVisibility(0);
            return;
        }
        this.aPh.setVisibility(8);
        this.aPi.setVisibility(8);
    }

    public BdSwitchView LM() {
        return this.aOW;
    }

    public boolean LN() {
        return this.aPo;
    }

    public void ce(boolean z) {
        this.aPo = z;
    }

    public void LO() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aOW.mt();
        } else {
            this.aOW.mu();
        }
        this.aOW.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle_2));
        this.aOX.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle_2));
    }

    public void LP() {
        this.aOX.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.n.qc().qg()) {
            this.aOX.mt();
        } else {
            this.aOX.mu();
        }
        this.aOX.setOnSwitchStateChangeListener(this.aPp);
    }

    public void a(ce ceVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aOY.setVisibility(4);
            this.aOZ.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (ceVar != null) {
                j = ceVar.LK();
            }
            a(this.aOY, j);
        } else {
            this.aOY.setVisibility(4);
        }
        if (z2) {
            if (ceVar != null) {
                j = ceVar.LJ();
            }
            a(this.aOZ, j);
            return;
        }
        this.aOZ.setVisibility(4);
    }

    private void a(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.ay.i((View) textView, com.baidu.tieba.p.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.aPn = onClickListener;
        this.aPc.setOnClickListener(this.aPn);
        this.aPd.setOnClickListener(this.aPn);
        this.aPe.setOnClickListener(this.aPn);
        this.aPf.setOnClickListener(this.aPn);
        this.aPh.setOnClickListener(this.aPn);
        this.aPm.setOnClickListener(this.aPn);
        this.aPa.setOnClickListener(this.aPn);
    }

    public void y(ArrayList<com.baidu.tbadk.core.data.r> arrayList) {
        this.aPg.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aPj.setVisibility(8);
            this.aPk.setVisibility(0);
            return;
        }
        this.aPj.setVisibility(0);
        this.aPk.setVisibility(8);
        int size = arrayList.size();
        if (size != 0) {
            int i = size > 10 ? 10 : size;
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
            layoutMode.ab(skinType == 1);
            for (int i2 = 0; i2 < i; i2++) {
                LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.hr().inflate(this.mContext.getPageActivity(), com.baidu.tieba.r.frs_sidebar_item, null);
                layoutMode.j(linearLayout);
                String str = arrayList.get(i2).mForumName;
                String str2 = arrayList.get(i2).Qt;
                String str3 = arrayList.get(i2).Qv;
                ck ckVar = new ck(this);
                ckVar.name = str;
                ckVar.aPr = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.q.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.q.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aPn);
                linearLayout2.setTag(ckVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.q.recommend_forum_image)).c(str2, 10, false);
                this.aPg.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ab(i == 1);
        layoutMode.j(this.LG);
        if (i == 1) {
            this.aOW.mt();
        } else {
            this.aOW.mu();
        }
        this.aOW.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle_2));
        this.aOX.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle_2));
    }
}
