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
    private BarImageView ajr;
    private TextView blz;
    private View dyo;
    private View eVm;
    private ViewEventCenter iGM;
    private TextView iQE;
    private TextView iQF;
    private TextView iQG;
    private TextView iQH;
    private ImageView iQI;
    private TextView iQJ;
    private TextView iQK;
    private View iQL;
    private ImageView isP;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iGM = viewEventCenter;
        this.dyo = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.dyo.findViewById(R.id.name);
        this.iQE = (TextView) this.dyo.findViewById(R.id.live_label);
        this.iQF = (TextView) this.dyo.findViewById(R.id.pinpai_label);
        this.iQG = (TextView) this.dyo.findViewById(R.id.trial_label);
        this.iQH = (TextView) this.dyo.findViewById(R.id.edit_btn_label);
        this.iQI = (ImageView) this.dyo.findViewById(R.id.sign);
        this.isP = (ImageView) this.dyo.findViewById(R.id.grade);
        this.iQJ = (TextView) this.dyo.findViewById(R.id.owner_flag);
        this.eVm = this.dyo.findViewById(R.id.enterforum_item_divider);
        this.blz = (TextView) this.dyo.findViewById(R.id.tv_add_love);
        this.ajr = (BarImageView) this.dyo.findViewById(R.id.forum_avatar);
        this.iQL = this.dyo.findViewById(R.id.forum_top_divider);
        this.iQK = (TextView) this.dyo.findViewById(R.id.forum_intro);
        this.ajr.setPlaceHolder(1);
        this.ajr.setStrokeColorResId(R.color.CAM_X0201);
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
        this.dyo.setBackgroundDrawable(stateListDrawable);
        this.ajr.setPlaceHolder(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(w wVar) {
        super.aw(wVar);
        if (wVar != null) {
            b(wVar);
            ap.setBackgroundColor(this.eVm, R.color.CAM_X0205);
            SvgManager.bsR().a(this.iQI, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        }
    }

    private void b(final w wVar) {
        int i;
        int i2 = 0;
        if (wVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bDp();
            this.dyo.setBackgroundDrawable(ap.oC(R.color.CAM_X0205));
            this.dyo.setVisibility(0);
            this.mName.setVisibility(0);
            if (wVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) wVar;
                this.mName.setText(fVar.getName());
                this.iQI.setVisibility(fVar.cvj() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.isP.setVisibility(8);
                } else {
                    this.isP.setVisibility(0);
                    ap.setImageResource(this.isP, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.ajr.setShowOval(true);
                this.ajr.startLoad(fVar.getAvatar(), 10, false);
                this.ajr.setShowOuterBorder(false);
                this.ajr.setShowInnerBorder(true);
                this.ajr.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ajr.setStrokeColorResId(R.color.CAM_X0401);
                if (fVar.cvi() > 0) {
                    ap.setBackgroundColor(this.iQL, R.color.CAM_X0302);
                } else {
                    ap.setBackgroundColor(this.iQL, R.color.transparent);
                }
                if (!fVar.cvh().isEmpty()) {
                    this.iQK.setText(fVar.cvh());
                }
                ap.setViewTextColor(this.iQK, R.color.CAM_X0109);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new ar("c12887"));
                }
                this.iQJ.setVisibility((fVar.cvk() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.cvl() == 1) {
                    this.iQF.setVisibility(0);
                    this.iQF.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.iQF, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.iQF, R.color.CAM_X0101);
                    this.iQE.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.iQE.setVisibility(0);
                        this.iQE.setText("");
                        ap.setBackgroundResource(this.iQE, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.iQE, R.color.CAM_X0111);
                    } else {
                        this.iQE.setVisibility(8);
                    }
                    this.iQF.setVisibility(8);
                }
                if (fVar.cvo()) {
                    this.iQG.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.iQG.setVisibility(8);
                    i = 0;
                }
                if (fVar.cvp()) {
                    this.iQH.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.iQH.setVisibility(8);
                }
                this.iQH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.iGM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (wVar instanceof bn) {
                this.mName.setText(((bn) wVar).getForumName());
                this.iQI.setVisibility(8);
                this.isP.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bn) wVar).getForumName())) {
                    TiebaStatic.log(new ar("c12887"));
                }
            }
            ap.setBackgroundResource(this.iQJ, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.iQJ, R.color.CAM_X0101);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
            this.blz.setVisibility(8);
            this.dyo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.cxK());
                    bundle.putParcelable("info_forum_name_rect", c.this.cxL());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, wVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.iGM.dispatchMvcEvent(bVar);
                }
            });
            this.dyo.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.iGM.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, wVar, null, null));
                    return true;
                }
            });
            g(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cxK() {
        Rect rect = new Rect();
        this.ajr.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cxL() {
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
