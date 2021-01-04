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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c extends com.baidu.tbadk.mvc.f.a<v, com.baidu.tieba.enterForum.data.c> {
    private BarImageView akt;
    private TextView bmU;
    private View dAT;
    private View eXI;
    private ViewEventCenter iFJ;
    private TextView iPD;
    private TextView iPE;
    private TextView iPF;
    private TextView iPG;
    private ImageView iPH;
    private TextView iPI;
    private TextView iPJ;
    private View iPK;
    private ImageView irS;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iFJ = viewEventCenter;
        this.dAT = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.dAT.findViewById(R.id.name);
        this.iPD = (TextView) this.dAT.findViewById(R.id.live_label);
        this.iPE = (TextView) this.dAT.findViewById(R.id.pinpai_label);
        this.iPF = (TextView) this.dAT.findViewById(R.id.trial_label);
        this.iPG = (TextView) this.dAT.findViewById(R.id.edit_btn_label);
        this.iPH = (ImageView) this.dAT.findViewById(R.id.sign);
        this.irS = (ImageView) this.dAT.findViewById(R.id.grade);
        this.iPI = (TextView) this.dAT.findViewById(R.id.owner_flag);
        this.eXI = this.dAT.findViewById(R.id.enterforum_item_divider);
        this.bmU = (TextView) this.dAT.findViewById(R.id.tv_add_love);
        this.akt = (BarImageView) this.dAT.findViewById(R.id.forum_avatar);
        this.iPK = this.dAT.findViewById(R.id.forum_top_divider);
        this.iPJ = (TextView) this.dAT.findViewById(R.id.forum_intro);
        this.akt.setPlaceHolder(1);
        this.akt.setStrokeColorResId(R.color.CAM_X0201);
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
        stateListDrawable.addState(new int[]{16842910, 16842919}, ao.getDrawable(R.color.CAM_X0204));
        stateListDrawable.addState(new int[0], ao.getDrawable(R.color.CAM_X0205).mutate());
        this.dAT.setBackgroundDrawable(stateListDrawable);
        this.akt.setPlaceHolder(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(v vVar) {
        super.aw(vVar);
        if (vVar != null) {
            b(vVar);
            ao.setBackgroundColor(this.eXI, R.color.CAM_X0205);
            SvgManager.bwq().a(this.iPH, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        }
    }

    private void b(final v vVar) {
        int i;
        int i2 = 0;
        if (vVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bGP();
            this.dAT.setBackgroundDrawable(ao.qe(R.color.CAM_X0205));
            this.dAT.setVisibility(0);
            this.mName.setVisibility(0);
            if (vVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
                this.mName.setText(fVar.getName());
                this.iPH.setVisibility(fVar.cxO() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.irS.setVisibility(8);
                } else {
                    this.irS.setVisibility(0);
                    ao.setImageResource(this.irS, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.akt.setShowOval(true);
                this.akt.startLoad(fVar.getAvatar(), 10, false);
                this.akt.setShowOuterBorder(false);
                this.akt.setShowInnerBorder(true);
                this.akt.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.akt.setStrokeColorResId(R.color.CAM_X0401);
                if (fVar.cxN() > 0) {
                    ao.setBackgroundColor(this.iPK, R.color.CAM_X0302);
                } else {
                    ao.setBackgroundColor(this.iPK, R.color.transparent);
                }
                if (!fVar.cxM().isEmpty()) {
                    this.iPJ.setText(fVar.cxM());
                }
                ao.setViewTextColor(this.iPJ, R.color.CAM_X0109);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
                this.iPI.setVisibility((fVar.cxP() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.cxQ() == 1) {
                    this.iPE.setVisibility(0);
                    this.iPE.setText(R.string.brand_label_ba_text);
                    ao.setBackgroundResource(this.iPE, R.drawable.enter_forum_brand_label_bg_shape);
                    ao.setViewTextColor(this.iPE, R.color.CAM_X0101);
                    this.iPD.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.iPD.setVisibility(0);
                        this.iPD.setText("");
                        ao.setBackgroundResource(this.iPD, R.drawable.icon_ba_list_live);
                        ao.setViewTextColor(this.iPD, R.color.CAM_X0111);
                    } else {
                        this.iPD.setVisibility(8);
                    }
                    this.iPE.setVisibility(8);
                }
                if (fVar.cxT()) {
                    this.iPF.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.iPF.setVisibility(8);
                    i = 0;
                }
                if (fVar.cxU()) {
                    this.iPG.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.iPG.setVisibility(8);
                }
                this.iPG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.iFJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (vVar instanceof bl) {
                this.mName.setText(((bl) vVar).getForumName());
                this.iPH.setVisibility(8);
                this.irS.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bl) vVar).getForumName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
            }
            ao.setBackgroundResource(this.iPI, R.drawable.icon_owner_bg);
            ao.setViewTextColor(this.iPI, R.color.CAM_X0101);
            ao.setViewTextColor(this.mName, R.color.CAM_X0105);
            this.bmU.setVisibility(8);
            this.dAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.cAp());
                    bundle.putParcelable("info_forum_name_rect", c.this.cAq());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, vVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.iFJ.dispatchMvcEvent(bVar);
                }
            });
            this.dAT.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.iFJ.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, vVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cAp() {
        Rect rect = new Rect();
        this.akt.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cAq() {
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
