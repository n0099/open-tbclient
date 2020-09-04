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
    private TextView aZS;
    private BarImageView ahZ;
    private View cMO;
    private View efE;
    private TextView hDn;
    private TextView hDo;
    private TextView hDp;
    private TextView hDq;
    private ImageView hDr;
    private TextView hDs;
    private TextView hDt;
    private View hDu;
    private ImageView hfK;
    private ViewEventCenter htp;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.htp = viewEventCenter;
        this.cMO = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.cMO.findViewById(R.id.name);
        this.hDn = (TextView) this.cMO.findViewById(R.id.live_label);
        this.hDo = (TextView) this.cMO.findViewById(R.id.pinpai_label);
        this.hDp = (TextView) this.cMO.findViewById(R.id.trial_label);
        this.hDq = (TextView) this.cMO.findViewById(R.id.edit_btn_label);
        this.hDr = (ImageView) this.cMO.findViewById(R.id.sign);
        this.hfK = (ImageView) this.cMO.findViewById(R.id.grade);
        this.hDs = (TextView) this.cMO.findViewById(R.id.owner_flag);
        this.efE = this.cMO.findViewById(R.id.enterforum_item_divider);
        this.aZS = (TextView) this.cMO.findViewById(R.id.tv_add_love);
        this.ahZ = (BarImageView) this.cMO.findViewById(R.id.forum_avatar);
        this.hDu = this.cMO.findViewById(R.id.forum_top_divider);
        this.hDt = (TextView) this.cMO.findViewById(R.id.forum_intro);
        this.ahZ.setPlaceHolder(2);
        this.ahZ.setStrokeColorResId(R.color.cp_bg_line_d);
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
        this.cMO.setBackgroundDrawable(stateListDrawable);
        this.ahZ.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aq(u uVar) {
        super.aq(uVar);
        if (uVar != null) {
            b(uVar);
            ap.setBackgroundColor(this.efE, R.color.cp_bg_line_e);
            SvgManager.bjq().a(this.hDr, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final u uVar) {
        int i;
        int i2 = 0;
        if (uVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) btx();
            this.cMO.setBackgroundDrawable(ap.nT(R.color.cp_bg_line_e));
            this.cMO.setVisibility(0);
            this.mName.setVisibility(0);
            if (uVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
                this.mName.setText(fVar.getName());
                this.hDr.setVisibility(fVar.ceK() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.hfK.setVisibility(8);
                } else {
                    this.hfK.setVisibility(0);
                    ap.setImageResource(this.hfK, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.ahZ.setShowOval(true);
                this.ahZ.startLoad(fVar.getAvatar(), 10, false);
                this.ahZ.setShowOuterBorder(false);
                this.ahZ.setShowInnerBorder(true);
                this.ahZ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ahZ.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.ceJ() > 0) {
                    ap.setBackgroundColor(this.hDu, R.color.cp_link_tip_a);
                } else {
                    ap.setBackgroundColor(this.hDu, R.color.transparent);
                }
                if (!fVar.ceI().isEmpty()) {
                    this.hDt.setText(fVar.ceI());
                }
                ap.setViewTextColor(this.hDt, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
                this.hDs.setVisibility((fVar.ceL() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.ceM() == 1) {
                    this.hDo.setVisibility(0);
                    this.hDo.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.hDo, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.hDo, R.color.cp_cont_a);
                    this.hDn.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.hDn.setVisibility(0);
                        this.hDn.setText("");
                        ap.setBackgroundResource(this.hDn, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.hDn, R.color.cp_cont_g);
                    } else {
                        this.hDn.setVisibility(8);
                    }
                    this.hDo.setVisibility(8);
                }
                if (fVar.ceP()) {
                    this.hDp.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.hDp.setVisibility(8);
                    i = 0;
                }
                if (fVar.ceQ()) {
                    this.hDq.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.hDq.setVisibility(8);
                }
                this.hDq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.htp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (uVar instanceof bi) {
                this.mName.setText(((bi) uVar).getForumName());
                this.hDr.setVisibility(8);
                this.hfK.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bi) uVar).getForumName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
            }
            ap.setBackgroundResource(this.hDs, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.hDs, R.color.cp_cont_a);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
            this.aZS.setVisibility(8);
            this.cMO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.chk());
                    bundle.putParcelable("info_forum_name_rect", c.this.chl());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, uVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.htp.dispatchMvcEvent(bVar);
                }
            });
            this.cMO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.htp.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, uVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect chk() {
        Rect rect = new Rect();
        this.ahZ.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect chl() {
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
