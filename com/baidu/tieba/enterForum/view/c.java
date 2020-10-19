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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.data.u;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c extends com.baidu.tbadk.mvc.f.a<u, com.baidu.tieba.enterForum.data.c> {
    private BarImageView aiM;
    private TextView bgc;
    private View daT;
    private View eub;
    private ImageView hBF;
    private ViewEventCenter hPp;
    private TextView hZk;
    private TextView hZl;
    private TextView hZm;
    private TextView hZn;
    private ImageView hZo;
    private TextView hZp;
    private TextView hZq;
    private View hZr;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hPp = viewEventCenter;
        this.daT = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.daT.findViewById(R.id.name);
        this.hZk = (TextView) this.daT.findViewById(R.id.live_label);
        this.hZl = (TextView) this.daT.findViewById(R.id.pinpai_label);
        this.hZm = (TextView) this.daT.findViewById(R.id.trial_label);
        this.hZn = (TextView) this.daT.findViewById(R.id.edit_btn_label);
        this.hZo = (ImageView) this.daT.findViewById(R.id.sign);
        this.hBF = (ImageView) this.daT.findViewById(R.id.grade);
        this.hZp = (TextView) this.daT.findViewById(R.id.owner_flag);
        this.eub = this.daT.findViewById(R.id.enterforum_item_divider);
        this.bgc = (TextView) this.daT.findViewById(R.id.tv_add_love);
        this.aiM = (BarImageView) this.daT.findViewById(R.id.forum_avatar);
        this.hZr = this.daT.findViewById(R.id.forum_top_divider);
        this.hZq = (TextView) this.daT.findViewById(R.id.forum_intro);
        this.aiM.setPlaceHolder(2);
        this.aiM.setStrokeColorResId(R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.tbadkCore.s
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void b(com.baidu.tieba.enterForum.data.c cVar) {
        super.b((c) cVar);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, ap.getDrawable(R.color.cp_bg_line_c));
        stateListDrawable.addState(new int[0], ap.getDrawable(R.color.cp_bg_line_e).mutate());
        this.daT.setBackgroundDrawable(stateListDrawable);
        this.aiM.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(u uVar) {
        super.au(uVar);
        if (uVar != null) {
            b(uVar);
            ap.setBackgroundColor(this.eub, R.color.cp_bg_line_e);
            SvgManager.bmU().a(this.hZo, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final u uVar) {
        int i;
        int i2 = 0;
        if (uVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bxl();
            this.daT.setBackgroundDrawable(ap.oC(R.color.cp_bg_line_e));
            this.daT.setVisibility(0);
            this.mName.setVisibility(0);
            if (uVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
                this.mName.setText(fVar.getName());
                this.hZo.setVisibility(fVar.clv() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.hBF.setVisibility(8);
                } else {
                    this.hBF.setVisibility(0);
                    ap.setImageResource(this.hBF, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.aiM.setShowOval(true);
                this.aiM.startLoad(fVar.getAvatar(), 10, false);
                this.aiM.setShowOuterBorder(false);
                this.aiM.setShowInnerBorder(true);
                this.aiM.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.aiM.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.clu() > 0) {
                    ap.setBackgroundColor(this.hZr, R.color.cp_link_tip_a);
                } else {
                    ap.setBackgroundColor(this.hZr, R.color.transparent);
                }
                if (!fVar.clt().isEmpty()) {
                    this.hZq.setText(fVar.clt());
                }
                ap.setViewTextColor(this.hZq, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
                this.hZp.setVisibility((fVar.clw() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.clx() == 1) {
                    this.hZl.setVisibility(0);
                    this.hZl.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.hZl, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.hZl, R.color.cp_cont_a);
                    this.hZk.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.hZk.setVisibility(0);
                        this.hZk.setText("");
                        ap.setBackgroundResource(this.hZk, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.hZk, R.color.cp_cont_g);
                    } else {
                        this.hZk.setVisibility(8);
                    }
                    this.hZl.setVisibility(8);
                }
                if (fVar.clA()) {
                    this.hZm.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.hZm.setVisibility(8);
                    i = 0;
                }
                if (fVar.clB()) {
                    this.hZn.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.hZn.setVisibility(8);
                }
                this.hZn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.hPp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (uVar instanceof bi) {
                this.mName.setText(((bi) uVar).getForumName());
                this.hZo.setVisibility(8);
                this.hBF.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bi) uVar).getForumName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
            }
            ap.setBackgroundResource(this.hZp, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.hZp, R.color.cp_cont_a);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
            this.bgc.setVisibility(8);
            this.daT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.cnV());
                    bundle.putParcelable("info_forum_name_rect", c.this.cnW());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, uVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.hPp.dispatchMvcEvent(bVar);
                }
            });
            this.daT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.hPp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, uVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cnV() {
        Rect rect = new Rect();
        this.aiM.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cnW() {
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
