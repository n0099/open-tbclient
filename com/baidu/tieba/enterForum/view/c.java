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
/* loaded from: classes4.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.d, com.baidu.tieba.enterForum.data.b> {
    private TextView afu;
    private View bef;
    private View ceJ;
    private View doX;
    private ImageView eIh;
    private ViewEventCenter eYW;
    private TextView ffV;
    private TextView ffW;
    private TextView ffX;
    private TextView ffY;
    private ImageView ffZ;
    private TextView fga;
    private BarImageView fgb;
    private TextView fgc;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eYW = viewEventCenter;
        this.bef = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.bef.findViewById(R.id.name);
        this.ffV = (TextView) this.bef.findViewById(R.id.live_label);
        this.ffW = (TextView) this.bef.findViewById(R.id.pinpai_label);
        this.ffX = (TextView) this.bef.findViewById(R.id.trial_label);
        this.ffY = (TextView) this.bef.findViewById(R.id.edit_btn_label);
        this.ffZ = (ImageView) this.bef.findViewById(R.id.sign);
        this.eIh = (ImageView) this.bef.findViewById(R.id.grade);
        this.fga = (TextView) this.bef.findViewById(R.id.owner_flag);
        this.ceJ = this.bef.findViewById(R.id.enterforum_item_divider);
        this.afu = (TextView) this.bef.findViewById(R.id.tv_add_love);
        this.fgb = (BarImageView) this.bef.findViewById(R.id.forum_avatar);
        this.doX = this.bef.findViewById(R.id.forum_top_divider);
        this.fgc = (TextView) this.bef.findViewById(R.id.forum_intro);
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
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
        this.bef.setBackgroundDrawable(stateListDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ab(com.baidu.tieba.enterForum.data.d dVar) {
        super.ab(dVar);
        if (dVar != null) {
            b(dVar);
            am.setBackgroundColor(this.ceJ, R.color.cp_bg_line_e);
            SvgManager.amL().a(this.ffZ, R.drawable.icon_pure_ba_checkedin_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) avQ();
            this.bef.setBackgroundDrawable(am.is(R.color.cp_bg_line_e));
            this.bef.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.ffZ.setVisibility(fVar.bdO() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.eIh.setVisibility(8);
                } else {
                    this.eIh.setVisibility(0);
                    am.setImageResource(this.eIh, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.fgb.setShowOval(true);
                this.fgb.startLoad(fVar.getAvatar(), 10, false);
                if (fVar.bdN() > 0) {
                    am.setBackgroundColor(this.doX, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.doX, R.color.transparent);
                }
                if (!fVar.bdM().isEmpty()) {
                    this.fgc.setText(fVar.bdM());
                }
                am.setViewTextColor(this.fgc, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.fga.setVisibility((fVar.bdP() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bdQ() == 1) {
                    this.ffW.setVisibility(0);
                    this.ffW.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.ffW, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.ffW, (int) R.color.cp_cont_a);
                    this.ffV.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.ffV.setVisibility(0);
                        this.ffV.setText("");
                        am.setBackgroundResource(this.ffV, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.ffV, (int) R.color.cp_cont_g);
                    } else {
                        this.ffV.setVisibility(8);
                    }
                    this.ffW.setVisibility(8);
                }
                if (fVar.bdT()) {
                    this.ffX.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.ffX.setVisibility(8);
                    i = 0;
                }
                if (fVar.bdU()) {
                    this.ffY.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.ffY.setVisibility(8);
                }
                this.ffY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.eYW.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.ffZ.setVisibility(8);
                this.eIh.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.fga, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.fga, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.afu.setVisibility(8);
            this.bef.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bfF());
                    bundle.putParcelable("info_forum_name_rect", c.this.bfG());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.eYW.dispatchMvcEvent(bVar2);
                }
            });
            this.bef.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.eYW.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            e(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bfF() {
        Rect rect = new Rect();
        this.fgb.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bfG() {
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
