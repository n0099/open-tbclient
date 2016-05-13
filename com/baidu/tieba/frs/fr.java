package com.baidu.tieba.frs;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.ForumMemberActivityConfig;
import com.baidu.tbadk.core.atomData.FrsGroupActivityConfig;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class fr extends com.baidu.adp.base.f<FrsActivity> {
    private View Dn;
    private LinearLayout aPG;
    private RelativeLayout bmW;
    private BdSwitchView bmX;
    private BdSwitchView bmY;
    private TextView bmZ;
    private LinearLayout bna;
    private LinearLayout bnb;
    private TextView bnc;
    private TextView bnd;
    private TextView bne;
    private TextView bnf;
    public TextView bng;
    private TextView bnh;
    private View bni;
    private View bnj;
    private TextView bnk;
    private TextView bnl;
    private TextView bnm;
    private View.OnClickListener bnn;
    private boolean bno;
    private long bnp;
    private final BdSwitchView.a bnq;

    public fr(TbPageContext<FrsActivity> tbPageContext) {
        super(tbPageContext);
        this.bmW = null;
        this.bmX = null;
        this.bmY = null;
        this.Dn = null;
        this.bmZ = null;
        this.bna = null;
        this.aPG = null;
        this.bnb = null;
        this.bnc = null;
        this.bnd = null;
        this.bne = null;
        this.bnf = null;
        this.bng = null;
        this.bnh = null;
        this.bni = null;
        this.bnn = null;
        this.bnp = 0L;
        this.bnq = new fs(this);
        nq();
    }

    public View getView() {
        return this.Dn;
    }

    public void init() {
        RY();
        RZ();
    }

    private void RU() {
    }

    private void nq() {
        this.Dn = LayoutInflater.from(this.mContext.getPageActivity()).inflate(t.h.frs_sidebar, (ViewGroup) null);
        RU();
        this.bna = (LinearLayout) this.Dn.findViewById(t.g.post_search_ll);
        this.aPG = (LinearLayout) this.Dn.findViewById(t.g.show_content);
        this.bnh = (TextView) this.Dn.findViewById(t.g.add_recommend);
        this.bni = this.Dn.findViewById(t.g.recommend_forum_layout_line);
        this.bng = (TextView) this.Dn.findViewById(t.g.forum_manager_center);
        this.bng.setVisibility(8);
        this.bmY = (BdSwitchView) this.Dn.findViewById(t.g.thrift_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bmY, 10, 10, 10, 10);
        this.bmW = (RelativeLayout) this.Dn.findViewById(t.g.eyeshield_mode);
        this.bmX = (BdSwitchView) this.Dn.findViewById(t.g.eyeshield_mode_switch);
        com.baidu.adp.lib.util.k.a(this.mContext.getPageActivity(), this.bmX, 10, 10, 10, 10);
        this.bmX.a(com.baidu.tbadk.core.util.at.cz(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cz(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cz(t.f.btn_game_handle_2));
        this.bmY.a(com.baidu.tbadk.core.util.at.cz(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cz(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cz(t.f.btn_game_handle_2));
        this.bmZ = (TextView) this.Dn.findViewById(t.g.message_btn);
        this.bnb = (LinearLayout) this.Dn.findViewById(t.g.message_layout);
        this.bnc = (TextView) this.Dn.findViewById(t.g.history_tv);
        this.bnd = (TextView) this.Dn.findViewById(t.g.bar_info_tv);
        this.bne = (TextView) this.Dn.findViewById(t.g.forum_member);
        this.bnf = (TextView) this.Dn.findViewById(t.g.frs_group);
        this.bnk = (TextView) this.Dn.findViewById(t.g.frs_sidebar_good_tv);
        this.bnm = (TextView) this.Dn.findViewById(t.g.bar_share_tv);
        this.bnl = (TextView) this.Dn.findViewById(t.g.frs_sidebar_add_to_desktop);
        this.bnj = this.Dn.findViewById(t.g.unfollow_layout);
        if (!TbadkCoreApplication.m11getInst().appResponseToIntentClass(PbHistoryActivityConfig.class)) {
            this.bnc.setVisibility(8);
        }
        if (!TbadkCoreApplication.m11getInst().appResponseToIntentClass(ForumDetailActivityConfig.class)) {
            this.bnd.setVisibility(8);
        }
        if (!TbadkCoreApplication.m11getInst().appResponseToIntentClass(ForumMemberActivityConfig.class)) {
            this.bne.setVisibility(8);
        }
        if (!TbadkCoreApplication.m11getInst().appResponseToIntentClass(FrsGroupActivityConfig.class)) {
            this.bnf.setVisibility(8);
        }
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_START_FRS_GOOD_ACTIVITY) == null) {
            this.bnk.setVisibility(8);
        }
        if (!RV()) {
            this.bmW.setVisibility(8);
            this.bmX.setVisibility(8);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((ViewGroup) this.Dn).addView(createStateBarFillView(), 0);
        }
    }

    @Override // com.baidu.adp.base.f
    public void destroy() {
        if (this.Dn != null) {
            this.Dn.setBackgroundDrawable(null);
        }
    }

    private View createStateBarFillView() {
        View view = new View(this.mContext.getPageActivity());
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.getStatusBarHeight()));
        return view;
    }

    public boolean RV() {
        return MessageManager.getInstance().runTask(CmdConfigCustom.CMD_NIGHT_RESOURCE_AVAILABLE, Boolean.class) != null;
    }

    public void da(boolean z) {
        this.bnj.setVisibility(z ? 0 : 8);
    }

    public void setIsManager(boolean z) {
        if (z) {
            this.bng.setVisibility(0);
        } else {
            this.bng.setVisibility(8);
        }
    }

    public BdSwitchView RW() {
        return this.bmX;
    }

    public boolean RX() {
        return this.bno;
    }

    public void db(boolean z) {
        this.bno = z;
    }

    public void RY() {
        if (TbadkCoreApplication.m11getInst().getSkinType() == 1) {
            this.bmX.iy();
            this.bmX.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_on));
            return;
        }
        this.bmX.iz();
        this.bmX.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_off));
    }

    public void RZ() {
        this.bmY.setOnSwitchStateChangeListener(null);
        if (com.baidu.tbadk.core.l.ob().oh()) {
            this.bmY.iy();
            this.bmY.setContentDescription(String.valueOf(this.mContext.getString(t.j.image_show_setting)) + this.mContext.getString(t.j.now_state_on));
        } else {
            this.bmY.iz();
            this.bmY.setContentDescription(String.valueOf(this.mContext.getString(t.j.image_show_setting)) + this.mContext.getString(t.j.now_state_off));
        }
        this.bmY.setOnSwitchStateChangeListener(this.bnq);
    }

    public void a(ed edVar, boolean z) {
        long j = 0;
        if (!z) {
            this.bmZ.setVisibility(4);
            this.bnp = 0L;
            return;
        }
        if (edVar != null) {
            j = edVar.Rz() - edVar.RA();
            if (!com.baidu.tbadk.coreExtra.messageCenter.c.xG().yb()) {
                j -= edVar.RB();
            }
        }
        this.bnp = j;
        c(this.bmZ, j);
    }

    private void c(TextView textView, long j) {
        if (textView != null) {
            if (j > 0) {
                textView.setVisibility(0);
                if (j < 10) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_one);
                    return;
                } else if (j < 100) {
                    textView.setText(String.valueOf(j));
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_two);
                    return;
                } else {
                    textView.setText("   ");
                    com.baidu.tbadk.core.util.at.k(textView, t.f.icon_news_head_prompt_more);
                    return;
                }
            }
            textView.setVisibility(4);
        }
    }

    public void setCommonClickListener(View.OnClickListener onClickListener) {
        this.bnn = onClickListener;
        this.bnb.setOnClickListener(this.bnn);
        this.bnc.setOnClickListener(this.bnn);
        this.bnd.setOnClickListener(this.bnn);
        this.bng.setOnClickListener(this.bnn);
        this.bnj.setOnClickListener(this.bnn);
        this.bna.setOnClickListener(this.bnn);
        this.bnk.setOnClickListener(this.bnn);
        this.bnl.setOnClickListener(this.bnn);
        this.bnm.setOnClickListener(this.bnn);
        this.bne.setOnClickListener(this.bnn);
        this.bnf.setOnClickListener(this.bnn);
    }

    public void changeSkinType(int i) {
        com.baidu.tbadk.core.c layoutMode = ((TbPageContext) this.mContext).getLayoutMode();
        layoutMode.ae(i == 1);
        layoutMode.x(this.Dn);
        c(this.bmZ, this.bnp);
        if (i == 1) {
            this.bmX.iy();
            this.bmX.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_on));
        } else {
            this.bmX.iz();
            this.bmX.setContentDescription(String.valueOf(this.mContext.getString(t.j.eyeshield_mode)) + this.mContext.getString(t.j.now_state_off));
        }
        this.Dn.setBackgroundDrawable(new BitmapDrawable(com.baidu.tbadk.core.util.at.cA(t.f.s_rightbar_bg)));
        this.bmX.a(com.baidu.tbadk.core.util.at.cz(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cz(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cz(t.f.btn_game_handle_2));
        this.bmY.a(com.baidu.tbadk.core.util.at.cz(t.f.s_switch_open_bg), com.baidu.tbadk.core.util.at.cz(t.f.s_switch_close_bg), com.baidu.tbadk.core.util.at.cz(t.f.btn_game_handle_2));
    }
}
