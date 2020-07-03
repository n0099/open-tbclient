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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c extends com.baidu.tbadk.mvc.f.a<t, com.baidu.tieba.enterForum.data.c> {
    private TextView aTj;
    private BarImageView agX;
    private View cAZ;
    private View dPI;
    private ImageView gNh;
    private ViewEventCenter haL;
    private TextView hkF;
    private TextView hkG;
    private TextView hkH;
    private TextView hkI;
    private ImageView hkJ;
    private TextView hkK;
    private TextView hkL;
    private View hkM;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.haL = viewEventCenter;
        this.cAZ = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.cAZ.findViewById(R.id.name);
        this.hkF = (TextView) this.cAZ.findViewById(R.id.live_label);
        this.hkG = (TextView) this.cAZ.findViewById(R.id.pinpai_label);
        this.hkH = (TextView) this.cAZ.findViewById(R.id.trial_label);
        this.hkI = (TextView) this.cAZ.findViewById(R.id.edit_btn_label);
        this.hkJ = (ImageView) this.cAZ.findViewById(R.id.sign);
        this.gNh = (ImageView) this.cAZ.findViewById(R.id.grade);
        this.hkK = (TextView) this.cAZ.findViewById(R.id.owner_flag);
        this.dPI = this.cAZ.findViewById(R.id.enterforum_item_divider);
        this.aTj = (TextView) this.cAZ.findViewById(R.id.tv_add_love);
        this.agX = (BarImageView) this.cAZ.findViewById(R.id.forum_avatar);
        this.hkM = this.cAZ.findViewById(R.id.forum_top_divider);
        this.hkL = (TextView) this.cAZ.findViewById(R.id.forum_intro);
        this.agX.setPlaceHolder(2);
        this.agX.setStrokeColorResId(R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.tbadkCore.r
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
        stateListDrawable.addState(new int[]{16842910, 16842919}, an.getDrawable(R.color.cp_bg_line_c));
        stateListDrawable.addState(new int[0], an.getDrawable(R.color.cp_bg_line_e).mutate());
        this.cAZ.setBackgroundDrawable(stateListDrawable);
        this.agX.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ao(t tVar) {
        super.ao(tVar);
        if (tVar != null) {
            b(tVar);
            an.setBackgroundColor(this.dPI, R.color.cp_bg_line_e);
            SvgManager.aWQ().a(this.hkJ, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final t tVar) {
        int i;
        int i2 = 0;
        if (tVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bgZ();
            this.cAZ.setBackgroundDrawable(an.ls(R.color.cp_bg_line_e));
            this.cAZ.setVisibility(0);
            this.mName.setVisibility(0);
            if (tVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) tVar;
                this.mName.setText(fVar.getName());
                this.hkJ.setVisibility(fVar.bRl() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.gNh.setVisibility(8);
                } else {
                    this.gNh.setVisibility(0);
                    an.setImageResource(this.gNh, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.agX.setShowOval(true);
                this.agX.startLoad(fVar.getAvatar(), 10, false);
                this.agX.setShowOuterBorder(false);
                this.agX.setShowInnerBorder(true);
                this.agX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.agX.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.bRk() > 0) {
                    an.setBackgroundColor(this.hkM, R.color.cp_link_tip_a);
                } else {
                    an.setBackgroundColor(this.hkM, R.color.transparent);
                }
                if (!fVar.bRj().isEmpty()) {
                    this.hkL.setText(fVar.bRj());
                }
                an.setViewTextColor(this.hkL, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new ao("c12887"));
                }
                this.hkK.setVisibility((fVar.bRm() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bRn() == 1) {
                    this.hkG.setVisibility(0);
                    this.hkG.setText(R.string.brand_label_ba_text);
                    an.setBackgroundResource(this.hkG, R.drawable.enter_forum_brand_label_bg_shape);
                    an.setViewTextColor(this.hkG, (int) R.color.cp_cont_a);
                    this.hkF.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.hkF.setVisibility(0);
                        this.hkF.setText("");
                        an.setBackgroundResource(this.hkF, R.drawable.icon_ba_list_live);
                        an.setViewTextColor(this.hkF, (int) R.color.cp_cont_g);
                    } else {
                        this.hkF.setVisibility(8);
                    }
                    this.hkG.setVisibility(8);
                }
                if (fVar.bRq()) {
                    this.hkH.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.hkH.setVisibility(8);
                    i = 0;
                }
                if (fVar.bRr()) {
                    this.hkI.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.hkI.setVisibility(8);
                }
                this.hkI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.haL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (tVar instanceof bg) {
                this.mName.setText(((bg) tVar).getForumName());
                this.hkJ.setVisibility(8);
                this.gNh.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bg) tVar).getForumName())) {
                    TiebaStatic.log(new ao("c12887"));
                }
            }
            an.setBackgroundResource(this.hkK, R.drawable.icon_owner_bg);
            an.setViewTextColor(this.hkK, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.aTj.setVisibility(8);
            this.cAZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bTC());
                    bundle.putParcelable("info_forum_name_rect", c.this.bTD());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, tVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.haL.dispatchMvcEvent(bVar);
                }
            });
            this.cAZ.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.haL.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, tVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bTC() {
        Rect rect = new Rect();
        this.agX.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bTD() {
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
