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
    private ImageView gAk;
    private ViewEventCenter gNE;
    private BarImageView gNV;
    private TextView gXE;
    private TextView gXF;
    private TextView gXG;
    private TextView gXH;
    private ImageView gXI;
    private TextView gXJ;
    private TextView gXK;
    private View gXL;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gNE = viewEventCenter;
        this.cwp = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.cwp.findViewById(R.id.name);
        this.gXE = (TextView) this.cwp.findViewById(R.id.live_label);
        this.gXF = (TextView) this.cwp.findViewById(R.id.pinpai_label);
        this.gXG = (TextView) this.cwp.findViewById(R.id.trial_label);
        this.gXH = (TextView) this.cwp.findViewById(R.id.edit_btn_label);
        this.gXI = (ImageView) this.cwp.findViewById(R.id.sign);
        this.gAk = (ImageView) this.cwp.findViewById(R.id.grade);
        this.gXJ = (TextView) this.cwp.findViewById(R.id.owner_flag);
        this.dIS = this.cwp.findViewById(R.id.enterforum_item_divider);
        this.aQD = (TextView) this.cwp.findViewById(R.id.tv_add_love);
        this.gNV = (BarImageView) this.cwp.findViewById(R.id.forum_avatar);
        this.gXL = this.cwp.findViewById(R.id.forum_top_divider);
        this.gXK = (TextView) this.cwp.findViewById(R.id.forum_intro);
        this.gNV.setPlaceHolder(2);
        this.gNV.setStrokeColorResId(R.color.cp_bg_line_d);
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
        this.gNV.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void an(com.baidu.tieba.enterForum.data.f fVar) {
        super.an(fVar);
        if (fVar != null) {
            b(fVar);
            am.setBackgroundColor(this.dIS, R.color.cp_bg_line_e);
            SvgManager.aUV().a(this.gXI, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.f fVar) {
        int i;
        int i2 = 0;
        if (fVar != null) {
            com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) beT();
            this.cwp.setBackgroundDrawable(am.lc(R.color.cp_bg_line_e));
            this.cwp.setVisibility(0);
            this.mName.setVisibility(0);
            if (fVar instanceof h) {
                final h hVar = (h) fVar;
                this.mName.setText(hVar.getName());
                this.gXI.setVisibility(hVar.bOd() == 0 ? 8 : 0);
                if (hVar.getLevel() == 0) {
                    this.gAk.setVisibility(8);
                } else {
                    this.gAk.setVisibility(0);
                    am.setImageResource(this.gAk, BitmapHelper.getGradeResourceIdInEnterForum(hVar.getLevel()));
                }
                this.gNV.setShowOval(true);
                this.gNV.startLoad(hVar.getAvatar(), 10, false);
                this.gNV.setShowOuterBorder(false);
                this.gNV.setShowInnerBorder(true);
                this.gNV.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.gNV.setStrokeColorResId(R.color.cp_border_a);
                if (hVar.bOc() > 0) {
                    am.setBackgroundColor(this.gXL, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.gXL, R.color.transparent);
                }
                if (!hVar.bOb().isEmpty()) {
                    this.gXK.setText(hVar.bOb());
                }
                am.setViewTextColor(this.gXK, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(hVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.gXJ.setVisibility((hVar.bOe() == 1 && hVar.isPrivateForum() == 1) ? 0 : 8);
                if (hVar.bOf() == 1) {
                    this.gXF.setVisibility(0);
                    this.gXF.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.gXF, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.gXF, (int) R.color.cp_cont_a);
                    this.gXE.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(hVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.gXE.setVisibility(0);
                        this.gXE.setText("");
                        am.setBackgroundResource(this.gXE, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.gXE, (int) R.color.cp_cont_g);
                    } else {
                        this.gXE.setVisibility(8);
                    }
                    this.gXF.setVisibility(8);
                }
                if (hVar.bOi()) {
                    this.gXG.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.gXG.setVisibility(8);
                    i = 0;
                }
                if (hVar.bOj()) {
                    this.gXH.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.gXH.setVisibility(8);
                }
                this.gXH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.gNE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, hVar, null, null));
                    }
                });
                i2 = i;
            } else if (fVar instanceof k) {
                this.mName.setText(((k) fVar).getForumName());
                this.gXI.setVisibility(8);
                this.gAk.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((k) fVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.gXJ, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.gXJ, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.aQD.setVisibility(8);
            this.cwp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bQx());
                    bundle.putParcelable("info_forum_name_rect", c.this.bQy());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, fVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.gNE.dispatchMvcEvent(bVar);
                }
            });
            this.cwp.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.gNE.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, fVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bQx() {
        Rect rect = new Rect();
        this.gNV.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bQy() {
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
