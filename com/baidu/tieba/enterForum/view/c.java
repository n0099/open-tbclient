package com.baidu.tieba.enterForum.view;

import android.graphics.Rect;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes7.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.d, com.baidu.tieba.enterForum.data.b> {
    private TextView aoj;
    private View bHD;
    private View cRr;
    private View caG;
    private ImageView fDp;
    private ViewEventCenter fQN;
    private TextView fXI;
    private TextView fXJ;
    private TextView fXK;
    private TextView fXL;
    private ImageView fXM;
    private TextView fXN;
    private BarImageView fXO;
    private TextView fXP;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fQN = viewEventCenter;
        this.bHD = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.bHD.findViewById(R.id.name);
        this.fXI = (TextView) this.bHD.findViewById(R.id.live_label);
        this.fXJ = (TextView) this.bHD.findViewById(R.id.pinpai_label);
        this.fXK = (TextView) this.bHD.findViewById(R.id.trial_label);
        this.fXL = (TextView) this.bHD.findViewById(R.id.edit_btn_label);
        this.fXM = (ImageView) this.bHD.findViewById(R.id.sign);
        this.fDp = (ImageView) this.bHD.findViewById(R.id.grade);
        this.fXN = (TextView) this.bHD.findViewById(R.id.owner_flag);
        this.cRr = this.bHD.findViewById(R.id.enterforum_item_divider);
        this.aoj = (TextView) this.bHD.findViewById(R.id.tv_add_love);
        this.fXO = (BarImageView) this.bHD.findViewById(R.id.forum_avatar);
        this.caG = this.bHD.findViewById(R.id.forum_top_divider);
        this.fXP = (TextView) this.bHD.findViewById(R.id.forum_intro);
        this.fXO.setPlaceHolder(2);
        this.fXO.setStrokeColorResId(R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void b(com.baidu.tieba.enterForum.data.b bVar) {
        super.b((c) bVar);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, am.getDrawable(R.color.cp_bg_line_c));
        stateListDrawable.addState(new int[0], am.getDrawable(R.color.cp_bg_line_e).mutate());
        this.bHD.setBackgroundDrawable(stateListDrawable);
        this.fXO.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ag(com.baidu.tieba.enterForum.data.d dVar) {
        super.ag(dVar);
        if (dVar != null) {
            b(dVar);
            am.setBackgroundColor(this.cRr, R.color.cp_bg_line_e);
            SvgManager.aEp().a(this.fXM, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) aNT();
            this.bHD.setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
            this.bHD.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.fXM.setVisibility(fVar.bwm() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.fDp.setVisibility(8);
                } else {
                    this.fDp.setVisibility(0);
                    am.setImageResource(this.fDp, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.fXO.setShowOval(true);
                this.fXO.startLoad(fVar.getAvatar(), 10, false);
                this.fXO.setShowOuterBorder(false);
                this.fXO.setShowInnerBorder(true);
                this.fXO.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.fXO.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.bwl() > 0) {
                    am.setBackgroundColor(this.caG, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.caG, R.color.transparent);
                }
                if (!fVar.bwk().isEmpty()) {
                    this.fXP.setText(fVar.bwk());
                }
                am.setViewTextColor(this.fXP, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.fXN.setVisibility((fVar.bwn() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bwo() == 1) {
                    this.fXJ.setVisibility(0);
                    this.fXJ.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.fXJ, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.fXJ, (int) R.color.cp_cont_a);
                    this.fXI.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.fXI.setVisibility(0);
                        this.fXI.setText("");
                        am.setBackgroundResource(this.fXI, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.fXI, (int) R.color.cp_cont_g);
                    } else {
                        this.fXI.setVisibility(8);
                    }
                    this.fXJ.setVisibility(8);
                }
                if (fVar.bwr()) {
                    this.fXK.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.fXK.setVisibility(8);
                    i = 0;
                }
                if (fVar.bws()) {
                    this.fXL.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.fXL.setVisibility(8);
                }
                this.fXL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.fQN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.fXM.setVisibility(8);
                this.fDp.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.fXN, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.fXN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.aoj.setVisibility(8);
            this.bHD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.byc());
                    bundle.putParcelable("info_forum_name_rect", c.this.byd());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.fQN.dispatchMvcEvent(bVar2);
                }
            });
            this.bHD.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.fQN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            e(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect byc() {
        Rect rect = new Rect();
        this.fXO.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect byd() {
        Rect rect = new Rect();
        this.mName.getGlobalVisibleRect(rect);
        return rect;
    }

    private void e(final TextView textView, final int i) {
        if (textView != null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.enterForum.view.c.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    int equipmentWidth;
                    if ((textView.getParent() instanceof ViewGroup) && (equipmentWidth = l.getEquipmentWidth(c.this.getContext())) != 0) {
                        textView.setMaxWidth(equipmentWidth - (i + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                        textView.postInvalidate();
                        textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }
}
