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
    private TextView arM;
    private View bLV;
    private View cVI;
    private View ceZ;
    private ImageView fGJ;
    private ViewEventCenter fUg;
    private TextView gaF;
    private TextView gaG;
    private TextView gaH;
    private TextView gaI;
    private ImageView gaJ;
    private TextView gaK;
    private BarImageView gaL;
    private TextView gaM;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fUg = viewEventCenter;
        this.bLV = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.bLV.findViewById(R.id.name);
        this.gaF = (TextView) this.bLV.findViewById(R.id.live_label);
        this.gaG = (TextView) this.bLV.findViewById(R.id.pinpai_label);
        this.gaH = (TextView) this.bLV.findViewById(R.id.trial_label);
        this.gaI = (TextView) this.bLV.findViewById(R.id.edit_btn_label);
        this.gaJ = (ImageView) this.bLV.findViewById(R.id.sign);
        this.fGJ = (ImageView) this.bLV.findViewById(R.id.grade);
        this.gaK = (TextView) this.bLV.findViewById(R.id.owner_flag);
        this.cVI = this.bLV.findViewById(R.id.enterforum_item_divider);
        this.arM = (TextView) this.bLV.findViewById(R.id.tv_add_love);
        this.gaL = (BarImageView) this.bLV.findViewById(R.id.forum_avatar);
        this.ceZ = this.bLV.findViewById(R.id.forum_top_divider);
        this.gaM = (TextView) this.bLV.findViewById(R.id.forum_intro);
        this.gaL.setPlaceHolder(2);
        this.gaL.setStrokeColorResId(R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.tbadkCore.r
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
        this.bLV.setBackgroundDrawable(stateListDrawable);
        this.gaL.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(com.baidu.tieba.enterForum.data.d dVar) {
        super.ai(dVar);
        if (dVar != null) {
            b(dVar);
            am.setBackgroundColor(this.cVI, R.color.cp_bg_line_e);
            SvgManager.aGG().a(this.gaJ, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) aQu();
            this.bLV.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
            this.bLV.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.gaJ.setVisibility(fVar.bxX() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.fGJ.setVisibility(8);
                } else {
                    this.fGJ.setVisibility(0);
                    am.setImageResource(this.fGJ, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.gaL.setShowOval(true);
                this.gaL.startLoad(fVar.getAvatar(), 10, false);
                this.gaL.setShowOuterBorder(false);
                this.gaL.setShowInnerBorder(true);
                this.gaL.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.gaL.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.bxW() > 0) {
                    am.setBackgroundColor(this.ceZ, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.ceZ, R.color.transparent);
                }
                if (!fVar.bxV().isEmpty()) {
                    this.gaM.setText(fVar.bxV());
                }
                am.setViewTextColor(this.gaM, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.gaK.setVisibility((fVar.bxY() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bxZ() == 1) {
                    this.gaG.setVisibility(0);
                    this.gaG.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.gaG, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.gaG, (int) R.color.cp_cont_a);
                    this.gaF.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.gaF.setVisibility(0);
                        this.gaF.setText("");
                        am.setBackgroundResource(this.gaF, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.gaF, (int) R.color.cp_cont_g);
                    } else {
                        this.gaF.setVisibility(8);
                    }
                    this.gaG.setVisibility(8);
                }
                if (fVar.byc()) {
                    this.gaH.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.gaH.setVisibility(8);
                    i = 0;
                }
                if (fVar.byd()) {
                    this.gaI.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.gaI.setVisibility(8);
                }
                this.gaI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.fUg.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.gaJ.setVisibility(8);
                this.fGJ.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.gaK, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.gaK, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.arM.setVisibility(8);
            this.bLV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bzN());
                    bundle.putParcelable("info_forum_name_rect", c.this.bzO());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.fUg.dispatchMvcEvent(bVar2);
                }
            });
            this.bLV.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.fUg.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            e(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bzN() {
        Rect rect = new Rect();
        this.gaL.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bzO() {
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
