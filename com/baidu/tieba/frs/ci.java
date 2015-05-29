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
    private LinearLayout aOU;
    private BdSwitchView aOV;
    private BdSwitchView aOW;
    private TextView aOX;
    private TextView aOY;
    private LinearLayout aOZ;
    private LinearLayout aPa;
    private LinearLayout aPb;
    private LinearLayout aPc;
    private LinearLayout aPd;
    private LinearLayout aPe;
    private LinearLayout aPf;
    public LinearLayout aPg;
    private View aPh;
    private TextView aPi;
    private View aPj;
    private View aPk;
    private View aPl;
    private View.OnClickListener aPm;
    private boolean aPn;
    private final com.baidu.adp.widget.BdSwitchView.b aPo;

    public ci(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.aOU = null;
        this.aOV = null;
        this.aOW = null;
        this.LG = null;
        this.aOX = null;
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
        this.aPm = null;
        this.aPo = new cj(this);
        initUI();
    }

    public View getView() {
        return this.LG;
    }

    public void init() {
        LN();
        LO();
    }

    private void initUI() {
        this.LG = com.baidu.adp.lib.g.b.hr().inflate(this.mContext.getPageActivity(), com.baidu.tieba.r.frs_sidebar, null);
        this.aOZ = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.post_search_ll);
        this.aPa = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.show_content);
        this.aPi = (TextView) this.LG.findViewById(com.baidu.tieba.q.add_recommend);
        this.aPj = this.LG.findViewById(com.baidu.tieba.q.recommend_forum_layout_line);
        this.aPg = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.forum_manager_center);
        this.aPg.setVisibility(8);
        this.aPh = this.LG.findViewById(com.baidu.tieba.q.forum_manager_center_line);
        this.aPh.setVisibility(8);
        this.aOW = (BdSwitchView) this.LG.findViewById(com.baidu.tieba.q.thrift_mode_switch);
        com.baidu.adp.lib.util.n.a(this.mContext.getPageActivity(), this.aOW, 10, 10, 10, 10);
        this.aOU = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.eyeshield_mode);
        this.aOV = (BdSwitchView) this.LG.findViewById(com.baidu.tieba.q.eyeshield_mode_switch);
        com.baidu.adp.lib.util.n.a(this.mContext.getPageActivity(), this.aOV, 10, 10, 10, 10);
        this.aOX = (TextView) this.LG.findViewById(com.baidu.tieba.q.message_btn);
        this.aOY = (TextView) this.LG.findViewById(com.baidu.tieba.q.mention_btn);
        this.aPb = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.message_layout);
        this.aPc = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.mention_layout);
        this.aPd = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.history_layout);
        this.aPe = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.bar_info_layout);
        this.aPf = (LinearLayout) this.LG.findViewById(com.baidu.tieba.q.recommend_forum_layout);
        this.aPk = this.LG.findViewById(com.baidu.tieba.q.unfollow_layout_line);
        this.aPl = this.LG.findViewById(com.baidu.tieba.q.unfollow_layout);
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.aPd.setVisibility(8);
        }
        if (!TbadkCoreApplication.m411getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.aPe.setVisibility(8);
        }
        TextView textView = (TextView) this.LG.findViewById(com.baidu.tieba.q.content_title);
        if (this.aPd.getVisibility() == 8 && this.aPe.getVisibility() == 8) {
            textView.setVisibility(8);
        }
        if (!LK()) {
            this.aOU.setVisibility(8);
            this.aOV.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            this.aPa.addView(createStateBarFillView(), 0);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean LK() {
        return MessageManager.getInstance().runTask(2001288, Boolean.class) != null;
    }

    public void cd(boolean z) {
        this.aPk.setVisibility(z ? 0 : 8);
        this.aPl.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.aPg.setVisibility(0);
            this.aPh.setVisibility(0);
            return;
        }
        this.aPg.setVisibility(8);
        this.aPh.setVisibility(8);
    }

    public BdSwitchView LL() {
        return this.aOV;
    }

    public boolean LM() {
        return this.aPn;
    }

    public void ce(boolean z) {
        this.aPn = z;
    }

    public void LN() {
        if (TbadkCoreApplication.m411getInst().getSkinType() == 1) {
            this.aOV.mt();
        } else {
            this.aOV.mu();
        }
        this.aOV.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle_2));
        this.aOW.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle_2));
    }

    public void LO() {
        this.aOW.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.n.qc().qg()) {
            this.aOW.mt();
        } else {
            this.aOW.mu();
        }
        this.aOW.setOnSwitchStateChangeListener(this.aPo);
    }

    public void a(ce ceVar, boolean z, boolean z2) {
        if (!z && !z2) {
            this.aOX.setVisibility(4);
            this.aOY.setVisibility(4);
            return;
        }
        long j = 0;
        if (z) {
            if (ceVar != null) {
                j = ceVar.LJ();
            }
            a(this.aOX, j);
        } else {
            this.aOX.setVisibility(4);
        }
        if (z2) {
            if (ceVar != null) {
                j = ceVar.LI();
            }
            a(this.aOY, j);
            return;
        }
        this.aOY.setVisibility(4);
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
        this.aPm = onClickListener;
        this.aPb.setOnClickListener(this.aPm);
        this.aPc.setOnClickListener(this.aPm);
        this.aPd.setOnClickListener(this.aPm);
        this.aPe.setOnClickListener(this.aPm);
        this.aPg.setOnClickListener(this.aPm);
        this.aPl.setOnClickListener(this.aPm);
        this.aOZ.setOnClickListener(this.aPm);
    }

    public void y(ArrayList<com.baidu.tbadk.core.data.r> arrayList) {
        this.aPf.removeAllViews();
        if (arrayList == null || arrayList.size() == 0) {
            this.aPi.setVisibility(8);
            this.aPj.setVisibility(0);
            return;
        }
        this.aPi.setVisibility(0);
        this.aPj.setVisibility(8);
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
                ckVar.aPq = str3;
                LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(com.baidu.tieba.q.recommend_forum_item_layout);
                ((TextView) linearLayout.findViewById(com.baidu.tieba.q.recommend_forum_name)).setText(str);
                linearLayout2.setOnClickListener(this.aPm);
                linearLayout2.setTag(ckVar);
                ((BarImageView) linearLayout.findViewById(com.baidu.tieba.q.recommend_forum_image)).c(str2, 10, false);
                this.aPf.addView(linearLayout);
            }
        }
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ab(i == 1);
        layoutMode.j(this.LG);
        if (i == 1) {
            this.aOV.mt();
        } else {
            this.aOV.mu();
        }
        this.aOV.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle_2));
        this.aOW.a(com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_open_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.bg_game_switch_close_2), com.baidu.tbadk.core.util.ay.ck(com.baidu.tieba.p.btn_game_handle_2));
    }
}
