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
    private TextView arC;
    private View bLK;
    private View cVv;
    private View ceO;
    private ImageView fGb;
    private ViewEventCenter fTx;
    private TextView fZX;
    private TextView fZY;
    private TextView fZZ;
    private TextView gaa;
    private ImageView gab;
    private TextView gac;
    private BarImageView gad;
    private TextView gae;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.fTx = viewEventCenter;
        this.bLK = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.bLK.findViewById(R.id.name);
        this.fZX = (TextView) this.bLK.findViewById(R.id.live_label);
        this.fZY = (TextView) this.bLK.findViewById(R.id.pinpai_label);
        this.fZZ = (TextView) this.bLK.findViewById(R.id.trial_label);
        this.gaa = (TextView) this.bLK.findViewById(R.id.edit_btn_label);
        this.gab = (ImageView) this.bLK.findViewById(R.id.sign);
        this.fGb = (ImageView) this.bLK.findViewById(R.id.grade);
        this.gac = (TextView) this.bLK.findViewById(R.id.owner_flag);
        this.cVv = this.bLK.findViewById(R.id.enterforum_item_divider);
        this.arC = (TextView) this.bLK.findViewById(R.id.tv_add_love);
        this.gad = (BarImageView) this.bLK.findViewById(R.id.forum_avatar);
        this.ceO = this.bLK.findViewById(R.id.forum_top_divider);
        this.gae = (TextView) this.bLK.findViewById(R.id.forum_intro);
        this.gad.setPlaceHolder(2);
        this.gad.setStrokeColorResId(R.color.cp_bg_line_d);
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
        this.bLK.setBackgroundDrawable(stateListDrawable);
        this.gad.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(com.baidu.tieba.enterForum.data.d dVar) {
        super.ai(dVar);
        if (dVar != null) {
            b(dVar);
            am.setBackgroundColor(this.cVv, R.color.cp_bg_line_e);
            SvgManager.aGC().a(this.gab, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) aQq();
            this.bLK.setBackgroundDrawable(am.kv(R.color.cp_bg_line_e));
            this.bLK.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.gab.setVisibility(fVar.bxS() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.fGb.setVisibility(8);
                } else {
                    this.fGb.setVisibility(0);
                    am.setImageResource(this.fGb, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.gad.setShowOval(true);
                this.gad.startLoad(fVar.getAvatar(), 10, false);
                this.gad.setShowOuterBorder(false);
                this.gad.setShowInnerBorder(true);
                this.gad.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.gad.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.bxR() > 0) {
                    am.setBackgroundColor(this.ceO, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.ceO, R.color.transparent);
                }
                if (!fVar.bxQ().isEmpty()) {
                    this.gae.setText(fVar.bxQ());
                }
                am.setViewTextColor(this.gae, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.gac.setVisibility((fVar.bxT() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bxU() == 1) {
                    this.fZY.setVisibility(0);
                    this.fZY.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.fZY, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.fZY, (int) R.color.cp_cont_a);
                    this.fZX.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.fZX.setVisibility(0);
                        this.fZX.setText("");
                        am.setBackgroundResource(this.fZX, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.fZX, (int) R.color.cp_cont_g);
                    } else {
                        this.fZX.setVisibility(8);
                    }
                    this.fZY.setVisibility(8);
                }
                if (fVar.bxX()) {
                    this.fZZ.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.fZZ.setVisibility(8);
                    i = 0;
                }
                if (fVar.bxY()) {
                    this.gaa.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.gaa.setVisibility(8);
                }
                this.gaa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.fTx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.gab.setVisibility(8);
                this.fGb.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.gac, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.gac, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.arC.setVisibility(8);
            this.bLK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bzH());
                    bundle.putParcelable("info_forum_name_rect", c.this.bzI());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.fTx.dispatchMvcEvent(bVar2);
                }
            });
            this.bLK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.fTx.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            e(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bzH() {
        Rect rect = new Rect();
        this.gad.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bzI() {
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
