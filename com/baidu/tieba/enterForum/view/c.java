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
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.k;
/* loaded from: classes9.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.f, com.baidu.tieba.enterForum.data.d> {
    private TextView aQD;
    private View cwp;
    private View dIS;
    private ImageView gAv;
    private ViewEventCenter gNP;
    private BarImageView gOg;
    private TextView gXP;
    private TextView gXQ;
    private TextView gXR;
    private TextView gXS;
    private ImageView gXT;
    private TextView gXU;
    private TextView gXV;
    private View gXW;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gNP = viewEventCenter;
        this.cwp = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.cwp.findViewById(R.id.name);
        this.gXP = (TextView) this.cwp.findViewById(R.id.live_label);
        this.gXQ = (TextView) this.cwp.findViewById(R.id.pinpai_label);
        this.gXR = (TextView) this.cwp.findViewById(R.id.trial_label);
        this.gXS = (TextView) this.cwp.findViewById(R.id.edit_btn_label);
        this.gXT = (ImageView) this.cwp.findViewById(R.id.sign);
        this.gAv = (ImageView) this.cwp.findViewById(R.id.grade);
        this.gXU = (TextView) this.cwp.findViewById(R.id.owner_flag);
        this.dIS = this.cwp.findViewById(R.id.enterforum_item_divider);
        this.aQD = (TextView) this.cwp.findViewById(R.id.tv_add_love);
        this.gOg = (BarImageView) this.cwp.findViewById(R.id.forum_avatar);
        this.gXW = this.cwp.findViewById(R.id.forum_top_divider);
        this.gXV = (TextView) this.cwp.findViewById(R.id.forum_intro);
        this.gOg.setPlaceHolder(2);
        this.gOg.setStrokeColorResId(R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void b(com.baidu.tieba.enterForum.data.d dVar) {
        super.b((c) dVar);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, am.getDrawable(R.color.cp_bg_line_c));
        stateListDrawable.addState(new int[0], am.getDrawable(R.color.cp_bg_line_e).mutate());
        this.cwp.setBackgroundDrawable(stateListDrawable);
        this.gOg.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void an(com.baidu.tieba.enterForum.data.f fVar) {
        super.an(fVar);
        if (fVar != null) {
            b(fVar);
            am.setBackgroundColor(this.dIS, R.color.cp_bg_line_e);
            SvgManager.aUW().a(this.gXT, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.f fVar) {
        int i;
        int i2 = 0;
        if (fVar != null) {
            com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) beU();
            this.cwp.setBackgroundDrawable(am.le(R.color.cp_bg_line_e));
            this.cwp.setVisibility(0);
            this.mName.setVisibility(0);
            if (fVar instanceof h) {
                final h hVar = (h) fVar;
                this.mName.setText(hVar.getName());
                this.gXT.setVisibility(hVar.bOf() == 0 ? 8 : 0);
                if (hVar.getLevel() == 0) {
                    this.gAv.setVisibility(8);
                } else {
                    this.gAv.setVisibility(0);
                    am.setImageResource(this.gAv, BitmapHelper.getGradeResourceIdInEnterForum(hVar.getLevel()));
                }
                this.gOg.setShowOval(true);
                this.gOg.startLoad(hVar.getAvatar(), 10, false);
                this.gOg.setShowOuterBorder(false);
                this.gOg.setShowInnerBorder(true);
                this.gOg.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.gOg.setStrokeColorResId(R.color.cp_border_a);
                if (hVar.bOe() > 0) {
                    am.setBackgroundColor(this.gXW, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.gXW, R.color.transparent);
                }
                if (!hVar.bOd().isEmpty()) {
                    this.gXV.setText(hVar.bOd());
                }
                am.setViewTextColor(this.gXV, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(hVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.gXU.setVisibility((hVar.bOg() == 1 && hVar.isPrivateForum() == 1) ? 0 : 8);
                if (hVar.bOh() == 1) {
                    this.gXQ.setVisibility(0);
                    this.gXQ.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.gXQ, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.gXQ, (int) R.color.cp_cont_a);
                    this.gXP.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(hVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.gXP.setVisibility(0);
                        this.gXP.setText("");
                        am.setBackgroundResource(this.gXP, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.gXP, (int) R.color.cp_cont_g);
                    } else {
                        this.gXP.setVisibility(8);
                    }
                    this.gXQ.setVisibility(8);
                }
                if (hVar.bOk()) {
                    this.gXR.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.gXR.setVisibility(8);
                    i = 0;
                }
                if (hVar.bOl()) {
                    this.gXS.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.gXS.setVisibility(8);
                }
                this.gXS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.gNP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, hVar, null, null));
                    }
                });
                i2 = i;
            } else if (fVar instanceof k) {
                this.mName.setText(((k) fVar).getForumName());
                this.gXT.setVisibility(8);
                this.gAv.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((k) fVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.gXU, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.gXU, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.aQD.setVisibility(8);
            this.cwp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bQz());
                    bundle.putParcelable("info_forum_name_rect", c.this.bQA());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, fVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.gNP.dispatchMvcEvent(bVar);
                }
            });
            this.cwp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.gNP.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, fVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bQz() {
        Rect rect = new Rect();
        this.gOg.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bQA() {
        Rect rect = new Rect();
        this.mName.getGlobalVisibleRect(rect);
        return rect;
    }

    private void f(final TextView textView, final int i) {
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
