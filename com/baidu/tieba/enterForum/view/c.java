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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c extends com.baidu.tbadk.mvc.f.a<v, com.baidu.tieba.enterForum.data.c> {
    private BarImageView ajR;
    private TextView blo;
    private View duK;
    private View eNL;
    private TextView iDp;
    private TextView iDq;
    private TextView iDr;
    private TextView iDs;
    private ImageView iDt;
    private TextView iDu;
    private TextView iDv;
    private View iDw;
    private ImageView ifv;
    private ViewEventCenter itu;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.itu = viewEventCenter;
        this.duK = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.duK.findViewById(R.id.name);
        this.iDp = (TextView) this.duK.findViewById(R.id.live_label);
        this.iDq = (TextView) this.duK.findViewById(R.id.pinpai_label);
        this.iDr = (TextView) this.duK.findViewById(R.id.trial_label);
        this.iDs = (TextView) this.duK.findViewById(R.id.edit_btn_label);
        this.iDt = (ImageView) this.duK.findViewById(R.id.sign);
        this.ifv = (ImageView) this.duK.findViewById(R.id.grade);
        this.iDu = (TextView) this.duK.findViewById(R.id.owner_flag);
        this.eNL = this.duK.findViewById(R.id.enterforum_item_divider);
        this.blo = (TextView) this.duK.findViewById(R.id.tv_add_love);
        this.ajR = (BarImageView) this.duK.findViewById(R.id.forum_avatar);
        this.iDw = this.duK.findViewById(R.id.forum_top_divider);
        this.iDv = (TextView) this.duK.findViewById(R.id.forum_intro);
        this.ajR.setPlaceHolder(1);
        this.ajR.setStrokeColorResId(R.color.CAM_X0201);
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
        this.duK.setBackgroundDrawable(stateListDrawable);
        this.ajR.setPlaceHolder(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(v vVar) {
        super.au(vVar);
        if (vVar != null) {
            b(vVar);
            ap.setBackgroundColor(this.eNL, R.color.CAM_X0205);
            SvgManager.btW().a(this.iDt, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        }
    }

    private void b(final v vVar) {
        int i;
        int i2 = 0;
        if (vVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bEv();
            this.duK.setBackgroundDrawable(ap.pT(R.color.CAM_X0205));
            this.duK.setVisibility(0);
            this.mName.setVisibility(0);
            if (vVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
                this.mName.setText(fVar.getName());
                this.iDt.setVisibility(fVar.cuU() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.ifv.setVisibility(8);
                } else {
                    this.ifv.setVisibility(0);
                    ap.setImageResource(this.ifv, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.ajR.setShowOval(true);
                this.ajR.startLoad(fVar.getAvatar(), 10, false);
                this.ajR.setShowOuterBorder(false);
                this.ajR.setShowInnerBorder(true);
                this.ajR.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ajR.setStrokeColorResId(R.color.CAM_X0401);
                if (fVar.cuT() > 0) {
                    ap.setBackgroundColor(this.iDw, R.color.CAM_X0302);
                } else {
                    ap.setBackgroundColor(this.iDw, R.color.transparent);
                }
                if (!fVar.cuS().isEmpty()) {
                    this.iDv.setText(fVar.cuS());
                }
                ap.setViewTextColor(this.iDv, R.color.CAM_X0109);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new ar("c12887"));
                }
                this.iDu.setVisibility((fVar.cuV() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.cuW() == 1) {
                    this.iDq.setVisibility(0);
                    this.iDq.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.iDq, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.iDq, R.color.CAM_X0101);
                    this.iDp.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.iDp.setVisibility(0);
                        this.iDp.setText("");
                        ap.setBackgroundResource(this.iDp, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.iDp, R.color.CAM_X0111);
                    } else {
                        this.iDp.setVisibility(8);
                    }
                    this.iDq.setVisibility(8);
                }
                if (fVar.cuZ()) {
                    this.iDr.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.iDr.setVisibility(8);
                    i = 0;
                }
                if (fVar.cva()) {
                    this.iDs.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.iDs.setVisibility(8);
                }
                this.iDs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.itu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (vVar instanceof bk) {
                this.mName.setText(((bk) vVar).getForumName());
                this.iDt.setVisibility(8);
                this.ifv.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bk) vVar).getForumName())) {
                    TiebaStatic.log(new ar("c12887"));
                }
            }
            ap.setBackgroundResource(this.iDu, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.iDu, R.color.CAM_X0101);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
            this.blo.setVisibility(8);
            this.duK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.cxv());
                    bundle.putParcelable("info_forum_name_rect", c.this.cxw());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, vVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.itu.dispatchMvcEvent(bVar);
                }
            });
            this.duK.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.itu.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, vVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cxv() {
        Rect rect = new Rect();
        this.ajR.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cxw() {
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
