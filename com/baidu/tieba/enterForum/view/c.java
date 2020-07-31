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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c extends com.baidu.tbadk.mvc.f.a<t, com.baidu.tieba.enterForum.data.c> {
    private TextView aUC;
    private BarImageView agO;
    private View cDM;
    private View dWa;
    private ImageView gSN;
    private ViewEventCenter hgq;
    private TextView hqq;
    private TextView hqr;
    private TextView hqs;
    private TextView hqt;
    private ImageView hqu;
    private TextView hqv;
    private TextView hqw;
    private View hqx;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.hgq = viewEventCenter;
        this.cDM = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.cDM.findViewById(R.id.name);
        this.hqq = (TextView) this.cDM.findViewById(R.id.live_label);
        this.hqr = (TextView) this.cDM.findViewById(R.id.pinpai_label);
        this.hqs = (TextView) this.cDM.findViewById(R.id.trial_label);
        this.hqt = (TextView) this.cDM.findViewById(R.id.edit_btn_label);
        this.hqu = (ImageView) this.cDM.findViewById(R.id.sign);
        this.gSN = (ImageView) this.cDM.findViewById(R.id.grade);
        this.hqv = (TextView) this.cDM.findViewById(R.id.owner_flag);
        this.dWa = this.cDM.findViewById(R.id.enterforum_item_divider);
        this.aUC = (TextView) this.cDM.findViewById(R.id.tv_add_love);
        this.agO = (BarImageView) this.cDM.findViewById(R.id.forum_avatar);
        this.hqx = this.cDM.findViewById(R.id.forum_top_divider);
        this.hqw = (TextView) this.cDM.findViewById(R.id.forum_intro);
        this.agO.setPlaceHolder(2);
        this.agO.setStrokeColorResId(R.color.cp_bg_line_d);
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
        stateListDrawable.addState(new int[]{16842910, 16842919}, ao.getDrawable(R.color.cp_bg_line_c));
        stateListDrawable.addState(new int[0], ao.getDrawable(R.color.cp_bg_line_e).mutate());
        this.cDM.setBackgroundDrawable(stateListDrawable);
        this.agO.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ao(t tVar) {
        super.ao(tVar);
        if (tVar != null) {
            b(tVar);
            ao.setBackgroundColor(this.dWa, R.color.cp_bg_line_e);
            SvgManager.baR().a(this.hqu, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final t tVar) {
        int i;
        int i2 = 0;
        if (tVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bkK();
            this.cDM.setBackgroundDrawable(ao.lM(R.color.cp_bg_line_e));
            this.cDM.setVisibility(0);
            this.mName.setVisibility(0);
            if (tVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) tVar;
                this.mName.setText(fVar.getName());
                this.hqu.setVisibility(fVar.bUy() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.gSN.setVisibility(8);
                } else {
                    this.gSN.setVisibility(0);
                    ao.setImageResource(this.gSN, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.agO.setShowOval(true);
                this.agO.startLoad(fVar.getAvatar(), 10, false);
                this.agO.setShowOuterBorder(false);
                this.agO.setShowInnerBorder(true);
                this.agO.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.agO.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.bUx() > 0) {
                    ao.setBackgroundColor(this.hqx, R.color.cp_link_tip_a);
                } else {
                    ao.setBackgroundColor(this.hqx, R.color.transparent);
                }
                if (!fVar.bUw().isEmpty()) {
                    this.hqw.setText(fVar.bUw());
                }
                ao.setViewTextColor(this.hqw, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new ap("c12887"));
                }
                this.hqv.setVisibility((fVar.bUz() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bUA() == 1) {
                    this.hqr.setVisibility(0);
                    this.hqr.setText(R.string.brand_label_ba_text);
                    ao.setBackgroundResource(this.hqr, R.drawable.enter_forum_brand_label_bg_shape);
                    ao.setViewTextColor(this.hqr, R.color.cp_cont_a);
                    this.hqq.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.hqq.setVisibility(0);
                        this.hqq.setText("");
                        ao.setBackgroundResource(this.hqq, R.drawable.icon_ba_list_live);
                        ao.setViewTextColor(this.hqq, R.color.cp_cont_g);
                    } else {
                        this.hqq.setVisibility(8);
                    }
                    this.hqr.setVisibility(8);
                }
                if (fVar.bUD()) {
                    this.hqs.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.hqs.setVisibility(8);
                    i = 0;
                }
                if (fVar.bUE()) {
                    this.hqt.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.hqt.setVisibility(8);
                }
                this.hqt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.hgq.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (tVar instanceof bh) {
                this.mName.setText(((bh) tVar).getForumName());
                this.hqu.setVisibility(8);
                this.gSN.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bh) tVar).getForumName())) {
                    TiebaStatic.log(new ap("c12887"));
                }
            }
            ao.setBackgroundResource(this.hqv, R.drawable.icon_owner_bg);
            ao.setViewTextColor(this.hqv, R.color.cp_cont_a);
            ao.setViewTextColor(this.mName, R.color.cp_cont_b);
            this.aUC.setVisibility(8);
            this.cDM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bWW());
                    bundle.putParcelable("info_forum_name_rect", c.this.bWX());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, tVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.hgq.dispatchMvcEvent(bVar);
                }
            });
            this.cDM.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.hgq.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, tVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bWW() {
        Rect rect = new Rect();
        this.agO.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bWX() {
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
