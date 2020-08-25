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
/* loaded from: classes16.dex */
public class c extends com.baidu.tbadk.mvc.f.a<u, com.baidu.tieba.enterForum.data.c> {
    private TextView aZQ;
    private BarImageView ahX;
    private View cMK;
    private View efA;
    private TextView hDh;
    private TextView hDi;
    private TextView hDj;
    private TextView hDk;
    private ImageView hDl;
    private TextView hDm;
    private TextView hDn;
    private View hDo;
    private ImageView hfG;
    private ViewEventCenter htj;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.htj = viewEventCenter;
        this.cMK = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.cMK.findViewById(R.id.name);
        this.hDh = (TextView) this.cMK.findViewById(R.id.live_label);
        this.hDi = (TextView) this.cMK.findViewById(R.id.pinpai_label);
        this.hDj = (TextView) this.cMK.findViewById(R.id.trial_label);
        this.hDk = (TextView) this.cMK.findViewById(R.id.edit_btn_label);
        this.hDl = (ImageView) this.cMK.findViewById(R.id.sign);
        this.hfG = (ImageView) this.cMK.findViewById(R.id.grade);
        this.hDm = (TextView) this.cMK.findViewById(R.id.owner_flag);
        this.efA = this.cMK.findViewById(R.id.enterforum_item_divider);
        this.aZQ = (TextView) this.cMK.findViewById(R.id.tv_add_love);
        this.ahX = (BarImageView) this.cMK.findViewById(R.id.forum_avatar);
        this.hDo = this.cMK.findViewById(R.id.forum_top_divider);
        this.hDn = (TextView) this.cMK.findViewById(R.id.forum_intro);
        this.ahX.setPlaceHolder(2);
        this.ahX.setStrokeColorResId(R.color.cp_bg_line_d);
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
        this.cMK.setBackgroundDrawable(stateListDrawable);
        this.ahX.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aq(u uVar) {
        super.aq(uVar);
        if (uVar != null) {
            b(uVar);
            ap.setBackgroundColor(this.efA, R.color.cp_bg_line_e);
            SvgManager.bjq().a(this.hDl, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final u uVar) {
        int i;
        int i2 = 0;
        if (uVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) btw();
            this.cMK.setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
            this.cMK.setVisibility(0);
            this.mName.setVisibility(0);
            if (uVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
                this.mName.setText(fVar.getName());
                this.hDl.setVisibility(fVar.ceJ() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.hfG.setVisibility(8);
                } else {
                    this.hfG.setVisibility(0);
                    ap.setImageResource(this.hfG, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.ahX.setShowOval(true);
                this.ahX.startLoad(fVar.getAvatar(), 10, false);
                this.ahX.setShowOuterBorder(false);
                this.ahX.setShowInnerBorder(true);
                this.ahX.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ahX.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.ceI() > 0) {
                    ap.setBackgroundColor(this.hDo, R.color.cp_link_tip_a);
                } else {
                    ap.setBackgroundColor(this.hDo, R.color.transparent);
                }
                if (!fVar.ceH().isEmpty()) {
                    this.hDn.setText(fVar.ceH());
                }
                ap.setViewTextColor(this.hDn, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
                this.hDm.setVisibility((fVar.ceK() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.ceL() == 1) {
                    this.hDi.setVisibility(0);
                    this.hDi.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.hDi, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.hDi, R.color.cp_cont_a);
                    this.hDh.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.hDh.setVisibility(0);
                        this.hDh.setText("");
                        ap.setBackgroundResource(this.hDh, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.hDh, R.color.cp_cont_g);
                    } else {
                        this.hDh.setVisibility(8);
                    }
                    this.hDi.setVisibility(8);
                }
                if (fVar.ceO()) {
                    this.hDj.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.hDj.setVisibility(8);
                    i = 0;
                }
                if (fVar.ceP()) {
                    this.hDk.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.hDk.setVisibility(8);
                }
                this.hDk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.htj.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (uVar instanceof bi) {
                this.mName.setText(((bi) uVar).getForumName());
                this.hDl.setVisibility(8);
                this.hfG.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bi) uVar).getForumName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
            }
            ap.setBackgroundResource(this.hDm, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.hDm, R.color.cp_cont_a);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
            this.aZQ.setVisibility(8);
            this.cMK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.chj());
                    bundle.putParcelable("info_forum_name_rect", c.this.chk());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, uVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.htj.dispatchMvcEvent(bVar);
                }
            });
            this.cMK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.htj.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, uVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect chj() {
        Rect rect = new Rect();
        this.ahX.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect chk() {
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
