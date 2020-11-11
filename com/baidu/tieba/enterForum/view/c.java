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
    private BarImageView aiN;
    private TextView biN;
    private View dpq;
    private View eIp;
    private ImageView hTY;
    private ViewEventCenter ihN;
    private TextView irJ;
    private TextView irK;
    private TextView irL;
    private TextView irM;
    private ImageView irN;
    private TextView irO;
    private TextView irP;
    private View irQ;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.ihN = viewEventCenter;
        this.dpq = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.dpq.findViewById(R.id.name);
        this.irJ = (TextView) this.dpq.findViewById(R.id.live_label);
        this.irK = (TextView) this.dpq.findViewById(R.id.pinpai_label);
        this.irL = (TextView) this.dpq.findViewById(R.id.trial_label);
        this.irM = (TextView) this.dpq.findViewById(R.id.edit_btn_label);
        this.irN = (ImageView) this.dpq.findViewById(R.id.sign);
        this.hTY = (ImageView) this.dpq.findViewById(R.id.grade);
        this.irO = (TextView) this.dpq.findViewById(R.id.owner_flag);
        this.eIp = this.dpq.findViewById(R.id.enterforum_item_divider);
        this.biN = (TextView) this.dpq.findViewById(R.id.tv_add_love);
        this.aiN = (BarImageView) this.dpq.findViewById(R.id.forum_avatar);
        this.irQ = this.dpq.findViewById(R.id.forum_top_divider);
        this.irP = (TextView) this.dpq.findViewById(R.id.forum_intro);
        this.aiN.setPlaceHolder(2);
        this.aiN.setStrokeColorResId(R.color.cp_bg_line_d);
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
        this.dpq.setBackgroundDrawable(stateListDrawable);
        this.aiN.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(u uVar) {
        super.au(uVar);
        if (uVar != null) {
            b(uVar);
            ap.setBackgroundColor(this.eIp, R.color.cp_bg_line_e);
            SvgManager.brn().a(this.irN, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final u uVar) {
        int i;
        int i2 = 0;
        if (uVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bBD();
            this.dpq.setBackgroundDrawable(ap.oX(R.color.cp_bg_line_e));
            this.dpq.setVisibility(0);
            this.mName.setVisibility(0);
            if (uVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) uVar;
                this.mName.setText(fVar.getName());
                this.irN.setVisibility(fVar.crd() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.hTY.setVisibility(8);
                } else {
                    this.hTY.setVisibility(0);
                    ap.setImageResource(this.hTY, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.aiN.setShowOval(true);
                this.aiN.startLoad(fVar.getAvatar(), 10, false);
                this.aiN.setShowOuterBorder(false);
                this.aiN.setShowInnerBorder(true);
                this.aiN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.aiN.setStrokeColorResId(R.color.cp_border_a);
                if (fVar.crc() > 0) {
                    ap.setBackgroundColor(this.irQ, R.color.cp_link_tip_a);
                } else {
                    ap.setBackgroundColor(this.irQ, R.color.transparent);
                }
                if (!fVar.crb().isEmpty()) {
                    this.irP.setText(fVar.crb());
                }
                ap.setViewTextColor(this.irP, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
                this.irO.setVisibility((fVar.cre() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.crf() == 1) {
                    this.irK.setVisibility(0);
                    this.irK.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.irK, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.irK, R.color.cp_cont_a);
                    this.irJ.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.irJ.setVisibility(0);
                        this.irJ.setText("");
                        ap.setBackgroundResource(this.irJ, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.irJ, R.color.cp_cont_g);
                    } else {
                        this.irJ.setVisibility(8);
                    }
                    this.irK.setVisibility(8);
                }
                if (fVar.cri()) {
                    this.irL.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.irL.setVisibility(8);
                    i = 0;
                }
                if (fVar.crj()) {
                    this.irM.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.irM.setVisibility(8);
                }
                this.irM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.ihN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (uVar instanceof bi) {
                this.mName.setText(((bi) uVar).getForumName());
                this.irN.setVisibility(8);
                this.hTY.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bi) uVar).getForumName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
            }
            ap.setBackgroundResource(this.irO, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.irO, R.color.cp_cont_a);
            ap.setViewTextColor(this.mName, R.color.cp_cont_b);
            this.biN.setVisibility(8);
            this.dpq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.ctD());
                    bundle.putParcelable("info_forum_name_rect", c.this.ctE());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, uVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.ihN.dispatchMvcEvent(bVar);
                }
            });
            this.dpq.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.ihN.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, uVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect ctD() {
        Rect rect = new Rect();
        this.aiN.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect ctE() {
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
