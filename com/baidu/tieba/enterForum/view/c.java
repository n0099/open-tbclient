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
    private BarImageView ajC;
    private TextView bih;
    private View dwh;
    private View eSX;
    private ViewEventCenter iBc;
    private TextView iKW;
    private TextView iKX;
    private TextView iKY;
    private TextView iKZ;
    private ImageView iLa;
    private TextView iLb;
    private TextView iLc;
    private View iLd;
    private ImageView ink;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iBc = viewEventCenter;
        this.dwh = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.dwh.findViewById(R.id.name);
        this.iKW = (TextView) this.dwh.findViewById(R.id.live_label);
        this.iKX = (TextView) this.dwh.findViewById(R.id.pinpai_label);
        this.iKY = (TextView) this.dwh.findViewById(R.id.trial_label);
        this.iKZ = (TextView) this.dwh.findViewById(R.id.edit_btn_label);
        this.iLa = (ImageView) this.dwh.findViewById(R.id.sign);
        this.ink = (ImageView) this.dwh.findViewById(R.id.grade);
        this.iLb = (TextView) this.dwh.findViewById(R.id.owner_flag);
        this.eSX = this.dwh.findViewById(R.id.enterforum_item_divider);
        this.bih = (TextView) this.dwh.findViewById(R.id.tv_add_love);
        this.ajC = (BarImageView) this.dwh.findViewById(R.id.forum_avatar);
        this.iLd = this.dwh.findViewById(R.id.forum_top_divider);
        this.iLc = (TextView) this.dwh.findViewById(R.id.forum_intro);
        this.ajC.setPlaceHolder(1);
        this.ajC.setStrokeColorResId(R.color.CAM_X0201);
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
        this.dwh.setBackgroundDrawable(stateListDrawable);
        this.ajC.setPlaceHolder(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void aw(v vVar) {
        super.aw(vVar);
        if (vVar != null) {
            b(vVar);
            ao.setBackgroundColor(this.eSX, R.color.CAM_X0205);
            SvgManager.bsx().a(this.iLa, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.mName, R.color.CAM_X0105);
        }
    }

    private void b(final v vVar) {
        int i;
        int i2 = 0;
        if (vVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bCX();
            this.dwh.setBackgroundDrawable(ao.ox(R.color.CAM_X0205));
            this.dwh.setVisibility(0);
            this.mName.setVisibility(0);
            if (vVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
                this.mName.setText(fVar.getName());
                this.iLa.setVisibility(fVar.ctX() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.ink.setVisibility(8);
                } else {
                    this.ink.setVisibility(0);
                    ao.setImageResource(this.ink, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.ajC.setShowOval(true);
                this.ajC.startLoad(fVar.getAvatar(), 10, false);
                this.ajC.setShowOuterBorder(false);
                this.ajC.setShowInnerBorder(true);
                this.ajC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.ajC.setStrokeColorResId(R.color.CAM_X0401);
                if (fVar.ctW() > 0) {
                    ao.setBackgroundColor(this.iLd, R.color.CAM_X0302);
                } else {
                    ao.setBackgroundColor(this.iLd, R.color.transparent);
                }
                if (!fVar.ctV().isEmpty()) {
                    this.iLc.setText(fVar.ctV());
                }
                ao.setViewTextColor(this.iLc, R.color.CAM_X0109);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
                this.iLb.setVisibility((fVar.ctY() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.ctZ() == 1) {
                    this.iKX.setVisibility(0);
                    this.iKX.setText(R.string.brand_label_ba_text);
                    ao.setBackgroundResource(this.iKX, R.drawable.enter_forum_brand_label_bg_shape);
                    ao.setViewTextColor(this.iKX, R.color.CAM_X0101);
                    this.iKW.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.iKW.setVisibility(0);
                        this.iKW.setText("");
                        ao.setBackgroundResource(this.iKW, R.drawable.icon_ba_list_live);
                        ao.setViewTextColor(this.iKW, R.color.CAM_X0111);
                    } else {
                        this.iKW.setVisibility(8);
                    }
                    this.iKX.setVisibility(8);
                }
                if (fVar.cuc()) {
                    this.iKY.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.iKY.setVisibility(8);
                    i = 0;
                }
                if (fVar.cud()) {
                    this.iKZ.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.iKZ.setVisibility(8);
                }
                this.iKZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.iBc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (vVar instanceof bl) {
                this.mName.setText(((bl) vVar).getForumName());
                this.iLa.setVisibility(8);
                this.ink.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bl) vVar).getForumName())) {
                    TiebaStatic.log(new aq("c12887"));
                }
            }
            ao.setBackgroundResource(this.iLb, R.drawable.icon_owner_bg);
            ao.setViewTextColor(this.iLb, R.color.CAM_X0101);
            ao.setViewTextColor(this.mName, R.color.CAM_X0105);
            this.bih.setVisibility(8);
            this.dwh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.cwy());
                    bundle.putParcelable("info_forum_name_rect", c.this.cwz());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, vVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.iBc.dispatchMvcEvent(bVar);
                }
            });
            this.dwh.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.iBc.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, vVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cwy() {
        Rect rect = new Rect();
        this.ajC.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cwz() {
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
