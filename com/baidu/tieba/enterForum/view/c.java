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
/* loaded from: classes6.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.d, com.baidu.tieba.enterForum.data.b> {
    private TextView anw;
    private View bGT;
    private View cRh;
    private View cau;
    private ImageView fAe;
    private ViewEventCenter fNE;
    private TextView fUA;
    private TextView fUB;
    private TextView fUC;
    private ImageView fUD;
    private TextView fUE;
    private BarImageView fUF;
    private TextView fUG;
    private TextView fUz;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fNE = viewEventCenter;
        this.bGT = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.bGT.findViewById(R.id.name);
        this.fUz = (TextView) this.bGT.findViewById(R.id.live_label);
        this.fUA = (TextView) this.bGT.findViewById(R.id.pinpai_label);
        this.fUB = (TextView) this.bGT.findViewById(R.id.trial_label);
        this.fUC = (TextView) this.bGT.findViewById(R.id.edit_btn_label);
        this.fUD = (ImageView) this.bGT.findViewById(R.id.sign);
        this.fAe = (ImageView) this.bGT.findViewById(R.id.grade);
        this.fUE = (TextView) this.bGT.findViewById(R.id.owner_flag);
        this.cRh = this.bGT.findViewById(R.id.enterforum_item_divider);
        this.anw = (TextView) this.bGT.findViewById(R.id.tv_add_love);
        this.fUF = (BarImageView) this.bGT.findViewById(R.id.forum_avatar);
        this.cau = this.bGT.findViewById(R.id.forum_top_divider);
        this.fUG = (TextView) this.bGT.findViewById(R.id.forum_intro);
        this.fUF.setPlaceHolder(2);
        this.fUF.setStrokeColorResId(R.color.cp_bg_line_d);
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
        this.bGT.setBackgroundDrawable(stateListDrawable);
        this.fUF.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ag(com.baidu.tieba.enterForum.data.d dVar) {
        super.ag(dVar);
        if (dVar != null) {
            b(dVar);
            am.setBackgroundColor(this.cRh, R.color.cp_bg_line_e);
            SvgManager.aDW().a(this.fUD, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) aNA();
            this.bGT.setBackgroundDrawable(am.ke(R.color.cp_bg_line_e));
            this.bGT.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.fUD.setVisibility(fVar.bvk() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.fAe.setVisibility(8);
                } else {
                    this.fAe.setVisibility(0);
                    am.setImageResource(this.fAe, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.fUF.setShowOval(true);
                this.fUF.startLoad(fVar.getAvatar(), 10, false);
                this.fUF.setShowOuterBorder(false);
                this.fUF.setShowInnerBorder(true);
                this.fUF.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.fUF.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.bvj() > 0) {
                    am.setBackgroundColor(this.cau, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.cau, R.color.transparent);
                }
                if (!fVar.bvi().isEmpty()) {
                    this.fUG.setText(fVar.bvi());
                }
                am.setViewTextColor(this.fUG, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.fUE.setVisibility((fVar.bvl() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bvm() == 1) {
                    this.fUA.setVisibility(0);
                    this.fUA.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.fUA, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.fUA, (int) R.color.cp_cont_a);
                    this.fUz.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.fUz.setVisibility(0);
                        this.fUz.setText("");
                        am.setBackgroundResource(this.fUz, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.fUz, (int) R.color.cp_cont_g);
                    } else {
                        this.fUz.setVisibility(8);
                    }
                    this.fUA.setVisibility(8);
                }
                if (fVar.bvp()) {
                    this.fUB.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.fUB.setVisibility(8);
                    i = 0;
                }
                if (fVar.bvq()) {
                    this.fUC.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.fUC.setVisibility(8);
                }
                this.fUC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.fNE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.fUD.setVisibility(8);
                this.fAe.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.fUE, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.fUE, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.anw.setVisibility(8);
            this.bGT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bxa());
                    bundle.putParcelable("info_forum_name_rect", c.this.bxb());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.fNE.dispatchMvcEvent(bVar2);
                }
            });
            this.bGT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.fNE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            e(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bxa() {
        Rect rect = new Rect();
        this.fUF.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bxb() {
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
