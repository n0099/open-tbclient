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
/* loaded from: classes21.dex */
public class c extends com.baidu.tbadk.mvc.f.a<u, com.baidu.tieba.enterForum.data.c> {
    private BarImageView aiu;
    private TextView bcq;
    private View cOO;
    private View ehT;
    private ViewEventCenter hAu;
    private TextView hKp;
    private TextView hKq;
    private TextView hKr;
    private TextView hKs;
    private ImageView hKt;
    private TextView hKu;
    private TextView hKv;
    private View hKw;
    private ImageView hmL;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hAu = viewEventCenter;
        this.cOO = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.cOO.findViewById(R.id.name);
        this.hKp = (TextView) this.cOO.findViewById(R.id.live_label);
        this.hKq = (TextView) this.cOO.findViewById(R.id.pinpai_label);
        this.hKr = (TextView) this.cOO.findViewById(R.id.trial_label);
        this.hKs = (TextView) this.cOO.findViewById(R.id.edit_btn_label);
        this.hKt = (ImageView) this.cOO.findViewById(R.id.sign);
        this.hmL = (ImageView) this.cOO.findViewById(R.id.grade);
        this.hKu = (TextView) this.cOO.findViewById(R.id.owner_flag);
        this.ehT = this.cOO.findViewById(R.id.enterforum_item_divider);
        this.bcq = (TextView) this.cOO.findViewById(R.id.tv_add_love);
        this.aiu = (BarImageView) this.cOO.findViewById(R.id.forum_avatar);
        this.hKw = this.cOO.findViewById(R.id.forum_top_divider);
        this.hKv = (TextView) this.cOO.findViewById(R.id.forum_intro);
        this.aiu.setPlaceHolder(2);
        this.aiu.setStrokeColorResId(R.color.cp_bg_line_d);
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
        this.cOO.setBackgroundDrawable(stateListDrawable);
        this.aiu.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ar(u uVar) {
        super.ar(uVar);
        if (uVar != null) {
            b(uVar);
            ap.setBackgroundColor(this.ehT, R.color.cp_bg_line_e);
            SvgManager.bkl().a(this.hKt, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final u uVar) {
        int i;
        int i2 = 0;
        if (uVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) buB();
            this.cOO.setBackgroundDrawable(ap.of(R.color.cp_bg_line_e));
            this.cOO.setVisibility(0);
            this.mName.setVisibility(0);
            if (uVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
                this.mName.setText(fVar.getName());
                this.hKt.setVisibility(fVar.chZ() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.hmL.setVisibility(8);
                } else {
                    this.hmL.setVisibility(0);
                    ap.setImageResource(this.hmL, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.aiu.setShowOval(true);
                this.aiu.startLoad(fVar.getAvatar(), 10, false);
                this.aiu.setShowOuterBorder(false);
                this.aiu.setShowInnerBorder(true);
                this.aiu.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.aiu.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.chY() > 0) {
                    ap.setBackgroundColor(this.hKw, R.color.cp_link_tip_a);
                } else {
                    ap.setBackgroundColor(this.hKw, R.color.transparent);
                }
                if (!fVar.chX().isEmpty()) {
                    this.hKv.setText(fVar.chX());
                }
                ap.setViewTextColor(this.hKv, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
                this.hKu.setVisibility((fVar.cia() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.cib() == 1) {
                    this.hKq.setVisibility(0);
                    this.hKq.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.hKq, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.hKq, R.color.cp_cont_a);
                    this.hKp.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.hKp.setVisibility(0);
                        this.hKp.setText("");
                        ap.setBackgroundResource(this.hKp, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.hKp, R.color.cp_cont_g);
                    } else {
                        this.hKp.setVisibility(8);
                    }
                    this.hKq.setVisibility(8);
                }
                if (fVar.cie()) {
                    this.hKr.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.hKr.setVisibility(8);
                    i = 0;
                }
                if (fVar.cif()) {
                    this.hKs.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.hKs.setVisibility(8);
                }
                this.hKs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.hAu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (uVar instanceof bi) {
                this.mName.setText(((bi) uVar).getForumName());
                this.hKt.setVisibility(8);
                this.hmL.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bi) uVar).getForumName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
            }
            ap.setBackgroundResource(this.hKu, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.hKu, R.color.cp_cont_a);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
            this.bcq.setVisibility(8);
            this.cOO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.ckz());
                    bundle.putParcelable("info_forum_name_rect", c.this.ckA());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, uVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.hAu.dispatchMvcEvent(bVar);
                }
            });
            this.cOO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.hAu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, uVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect ckz() {
        Rect rect = new Rect();
        this.aiu.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect ckA() {
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
