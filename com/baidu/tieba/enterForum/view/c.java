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
import com.baidu.tbadk.core.data.bn;
import com.baidu.tbadk.core.data.w;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<w, com.baidu.tieba.enterForum.data.c> {
    private BarImageView akJ;
    private TextView bna;
    private View dzP;
    private View eWL;
    private ViewEventCenter iIJ;
    private TextView iSB;
    private TextView iSC;
    private TextView iSD;
    private TextView iSE;
    private ImageView iSF;
    private TextView iSG;
    private TextView iSH;
    private View iSI;
    private ImageView iuM;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iIJ = viewEventCenter;
        this.dzP = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.dzP.findViewById(R.id.name);
        this.iSB = (TextView) this.dzP.findViewById(R.id.live_label);
        this.iSC = (TextView) this.dzP.findViewById(R.id.pinpai_label);
        this.iSD = (TextView) this.dzP.findViewById(R.id.trial_label);
        this.iSE = (TextView) this.dzP.findViewById(R.id.edit_btn_label);
        this.iSF = (ImageView) this.dzP.findViewById(R.id.sign);
        this.iuM = (ImageView) this.dzP.findViewById(R.id.grade);
        this.iSG = (TextView) this.dzP.findViewById(R.id.owner_flag);
        this.eWL = this.dzP.findViewById(R.id.enterforum_item_divider);
        this.bna = (TextView) this.dzP.findViewById(R.id.tv_add_love);
        this.akJ = (BarImageView) this.dzP.findViewById(R.id.forum_avatar);
        this.iSI = this.dzP.findViewById(R.id.forum_top_divider);
        this.iSH = (TextView) this.dzP.findViewById(R.id.forum_intro);
        this.akJ.setPlaceHolder(1);
        this.akJ.setStrokeColorResId(R.color.CAM_X0201);
    }

    @Override // com.baidu.tieba.tbadkCore.t
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
        stateListDrawable.addState(new int[]{16842910, 16842919}, ap.getDrawable(R.color.CAM_X0204));
        stateListDrawable.addState(new int[0], ap.getDrawable(R.color.CAM_X0205).mutate());
        this.dzP.setBackgroundDrawable(stateListDrawable);
        this.akJ.setPlaceHolder(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ay(w wVar) {
        super.ay(wVar);
        if (wVar != null) {
            b(wVar);
            ap.setBackgroundColor(this.eWL, R.color.CAM_X0205);
            SvgManager.bsU().a(this.iSF, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        }
    }

    private void b(final w wVar) {
        int i;
        int i2 = 0;
        if (wVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bDs();
            this.dzP.setBackgroundDrawable(ap.oD(R.color.CAM_X0205));
            this.dzP.setVisibility(0);
            this.mName.setVisibility(0);
            if (wVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) wVar;
                this.mName.setText(fVar.getName());
                this.iSF.setVisibility(fVar.cvw() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.iuM.setVisibility(8);
                } else {
                    this.iuM.setVisibility(0);
                    ap.setImageResource(this.iuM, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.akJ.setShowOval(true);
                this.akJ.startLoad(fVar.getAvatar(), 10, false);
                this.akJ.setShowOuterBorder(false);
                this.akJ.setShowInnerBorder(true);
                this.akJ.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.akJ.setStrokeColorResId(R.color.CAM_X0401);
                if (fVar.cvv() > 0) {
                    ap.setBackgroundColor(this.iSI, R.color.CAM_X0302);
                } else {
                    ap.setBackgroundColor(this.iSI, R.color.transparent);
                }
                if (!fVar.cvu().isEmpty()) {
                    this.iSH.setText(fVar.cvu());
                }
                ap.setViewTextColor(this.iSH, R.color.CAM_X0109);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new ar("c12887"));
                }
                this.iSG.setVisibility((fVar.cvx() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.cvy() == 1) {
                    this.iSC.setVisibility(0);
                    this.iSC.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.iSC, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.iSC, R.color.CAM_X0101);
                    this.iSB.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.iSB.setVisibility(0);
                        this.iSB.setText("");
                        ap.setBackgroundResource(this.iSB, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.iSB, R.color.CAM_X0111);
                    } else {
                        this.iSB.setVisibility(8);
                    }
                    this.iSC.setVisibility(8);
                }
                if (fVar.cvB()) {
                    this.iSD.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.iSD.setVisibility(8);
                    i = 0;
                }
                if (fVar.cvC()) {
                    this.iSE.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.iSE.setVisibility(8);
                }
                this.iSE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.iIJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (wVar instanceof bn) {
                this.mName.setText(((bn) wVar).getForumName());
                this.iSF.setVisibility(8);
                this.iuM.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bn) wVar).getForumName())) {
                    TiebaStatic.log(new ar("c12887"));
                }
            }
            ap.setBackgroundResource(this.iSG, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.iSG, R.color.CAM_X0101);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
            this.bna.setVisibility(8);
            this.dzP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.cxX());
                    bundle.putParcelable("info_forum_name_rect", c.this.cxY());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, wVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.iIJ.dispatchMvcEvent(bVar);
                }
            });
            this.dzP.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.iIJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, wVar, null, null));
                    return true;
                }
            });
            g(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cxX() {
        Rect rect = new Rect();
        this.akJ.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cxY() {
        Rect rect = new Rect();
        this.mName.getGlobalVisibleRect(rect);
        return rect;
    }

    private void g(final TextView textView, final int i) {
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
