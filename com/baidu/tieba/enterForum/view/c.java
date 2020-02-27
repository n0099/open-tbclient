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
/* loaded from: classes9.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.d, com.baidu.tieba.enterForum.data.b> {
    private TextView arB;
    private View bLI;
    private View cVt;
    private View ceM;
    private ImageView fFM;
    private ViewEventCenter fTi;
    private TextView fZI;
    private TextView fZJ;
    private TextView fZK;
    private TextView fZL;
    private ImageView fZM;
    private TextView fZN;
    private BarImageView fZO;
    private TextView fZP;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fTi = viewEventCenter;
        this.bLI = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.bLI.findViewById(R.id.name);
        this.fZI = (TextView) this.bLI.findViewById(R.id.live_label);
        this.fZJ = (TextView) this.bLI.findViewById(R.id.pinpai_label);
        this.fZK = (TextView) this.bLI.findViewById(R.id.trial_label);
        this.fZL = (TextView) this.bLI.findViewById(R.id.edit_btn_label);
        this.fZM = (ImageView) this.bLI.findViewById(R.id.sign);
        this.fFM = (ImageView) this.bLI.findViewById(R.id.grade);
        this.fZN = (TextView) this.bLI.findViewById(R.id.owner_flag);
        this.cVt = this.bLI.findViewById(R.id.enterforum_item_divider);
        this.arB = (TextView) this.bLI.findViewById(R.id.tv_add_love);
        this.fZO = (BarImageView) this.bLI.findViewById(R.id.forum_avatar);
        this.ceM = this.bLI.findViewById(R.id.forum_top_divider);
        this.fZP = (TextView) this.bLI.findViewById(R.id.forum_intro);
        this.fZO.setPlaceHolder(2);
        this.fZO.setStrokeColorResId(R.color.cp_bg_line_d);
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
        this.bLI.setBackgroundDrawable(stateListDrawable);
        this.fZO.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(com.baidu.tieba.enterForum.data.d dVar) {
        super.ai(dVar);
        if (dVar != null) {
            b(dVar);
            am.setBackgroundColor(this.cVt, R.color.cp_bg_line_e);
            SvgManager.aGA().a(this.fZM, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) aQn();
            this.bLI.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
            this.bLI.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.fZM.setVisibility(fVar.bxP() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.fFM.setVisibility(8);
                } else {
                    this.fFM.setVisibility(0);
                    am.setImageResource(this.fFM, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.fZO.setShowOval(true);
                this.fZO.startLoad(fVar.getAvatar(), 10, false);
                this.fZO.setShowOuterBorder(false);
                this.fZO.setShowInnerBorder(true);
                this.fZO.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.fZO.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.bxO() > 0) {
                    am.setBackgroundColor(this.ceM, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.ceM, R.color.transparent);
                }
                if (!fVar.bxN().isEmpty()) {
                    this.fZP.setText(fVar.bxN());
                }
                am.setViewTextColor(this.fZP, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.fZN.setVisibility((fVar.bxQ() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bxR() == 1) {
                    this.fZJ.setVisibility(0);
                    this.fZJ.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.fZJ, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.fZJ, (int) R.color.cp_cont_a);
                    this.fZI.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.fZI.setVisibility(0);
                        this.fZI.setText("");
                        am.setBackgroundResource(this.fZI, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.fZI, (int) R.color.cp_cont_g);
                    } else {
                        this.fZI.setVisibility(8);
                    }
                    this.fZJ.setVisibility(8);
                }
                if (fVar.bxU()) {
                    this.fZK.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.fZK.setVisibility(8);
                    i = 0;
                }
                if (fVar.bxV()) {
                    this.fZL.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.fZL.setVisibility(8);
                }
                this.fZL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.fTi.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.fZM.setVisibility(8);
                this.fFM.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.fZN, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.fZN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.arB.setVisibility(8);
            this.bLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bzE());
                    bundle.putParcelable("info_forum_name_rect", c.this.bzF());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.fTi.dispatchMvcEvent(bVar2);
                }
            });
            this.bLI.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.fTi.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            e(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bzE() {
        Rect rect = new Rect();
        this.fZO.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bzF() {
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
