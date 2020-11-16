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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.data.v;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c extends com.baidu.tbadk.mvc.f.a<v, com.baidu.tieba.enterForum.data.c> {
    private BarImageView aiS;
    private TextView bgZ;
    private View dnH;
    private View eGI;
    private ImageView hUy;
    private ViewEventCenter iiB;
    private TextView isA;
    private ImageView isB;
    private TextView isC;
    private TextView isD;
    private View isE;
    private TextView isx;
    private TextView isy;
    private TextView isz;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.iiB = viewEventCenter;
        this.dnH = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.dnH.findViewById(R.id.name);
        this.isx = (TextView) this.dnH.findViewById(R.id.live_label);
        this.isy = (TextView) this.dnH.findViewById(R.id.pinpai_label);
        this.isz = (TextView) this.dnH.findViewById(R.id.trial_label);
        this.isA = (TextView) this.dnH.findViewById(R.id.edit_btn_label);
        this.isB = (ImageView) this.dnH.findViewById(R.id.sign);
        this.hUy = (ImageView) this.dnH.findViewById(R.id.grade);
        this.isC = (TextView) this.dnH.findViewById(R.id.owner_flag);
        this.eGI = this.dnH.findViewById(R.id.enterforum_item_divider);
        this.bgZ = (TextView) this.dnH.findViewById(R.id.tv_add_love);
        this.aiS = (BarImageView) this.dnH.findViewById(R.id.forum_avatar);
        this.isE = this.dnH.findViewById(R.id.forum_top_divider);
        this.isD = (TextView) this.dnH.findViewById(R.id.forum_intro);
        this.aiS.setPlaceHolder(1);
        this.aiS.setStrokeColorResId(R.color.CAM_X0201);
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
        stateListDrawable.addState(new int[]{16842910, 16842919}, ap.getDrawable(R.color.CAM_X0204));
        stateListDrawable.addState(new int[0], ap.getDrawable(R.color.CAM_X0205).mutate());
        this.dnH.setBackgroundDrawable(stateListDrawable);
        this.aiS.setPlaceHolder(1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void au(v vVar) {
        super.au(vVar);
        if (vVar != null) {
            b(vVar);
            ap.setBackgroundColor(this.eGI, R.color.CAM_X0205);
            SvgManager.bqB().a(this.isB, R.drawable.icon_pure_ba_checkedin16_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
        }
    }

    private void b(final v vVar) {
        int i;
        int i2 = 0;
        if (vVar != null) {
            com.baidu.tieba.enterForum.data.c cVar = (com.baidu.tieba.enterForum.data.c) bAT();
            this.dnH.setBackgroundDrawable(ap.pt(R.color.CAM_X0205));
            this.dnH.setVisibility(0);
            this.mName.setVisibility(0);
            if (vVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) vVar;
                this.mName.setText(fVar.getName());
                this.isB.setVisibility(fVar.cqG() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.hUy.setVisibility(8);
                } else {
                    this.hUy.setVisibility(0);
                    ap.setImageResource(this.hUy, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.aiS.setShowOval(true);
                this.aiS.startLoad(fVar.getAvatar(), 10, false);
                this.aiS.setShowOuterBorder(false);
                this.aiS.setShowInnerBorder(true);
                this.aiS.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.aiS.setStrokeColorResId(R.color.CAM_X0401);
                if (fVar.cqF() > 0) {
                    ap.setBackgroundColor(this.isE, R.color.CAM_X0302);
                } else {
                    ap.setBackgroundColor(this.isE, R.color.transparent);
                }
                if (!fVar.cqE().isEmpty()) {
                    this.isD.setText(fVar.cqE());
                }
                ap.setViewTextColor(this.isD, R.color.CAM_X0109);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new ar("c12887"));
                }
                this.isC.setVisibility((fVar.cqH() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.cqI() == 1) {
                    this.isy.setVisibility(0);
                    this.isy.setText(R.string.brand_label_ba_text);
                    ap.setBackgroundResource(this.isy, R.drawable.enter_forum_brand_label_bg_shape);
                    ap.setViewTextColor(this.isy, R.color.CAM_X0101);
                    this.isx.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.isx.setVisibility(0);
                        this.isx.setText("");
                        ap.setBackgroundResource(this.isx, R.drawable.icon_ba_list_live);
                        ap.setViewTextColor(this.isx, R.color.CAM_X0111);
                    } else {
                        this.isx.setVisibility(8);
                    }
                    this.isy.setVisibility(8);
                }
                if (fVar.cqL()) {
                    this.isz.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.isz.setVisibility(8);
                    i = 0;
                }
                if (fVar.cqM()) {
                    this.isA.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.isA.setVisibility(8);
                }
                this.isA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.iiB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (vVar instanceof bj) {
                this.mName.setText(((bj) vVar).getForumName());
                this.isB.setVisibility(8);
                this.hUy.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((bj) vVar).getForumName())) {
                    TiebaStatic.log(new ar("c12887"));
                }
            }
            ap.setBackgroundResource(this.isC, R.drawable.icon_owner_bg);
            ap.setViewTextColor(this.isC, R.color.CAM_X0101);
            ap.setViewTextColor(this.mName, R.color.CAM_X0105);
            this.bgZ.setVisibility(8);
            this.dnH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.ctg());
                    bundle.putParcelable("info_forum_name_rect", c.this.cth());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, vVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.iiB.dispatchMvcEvent(bVar);
                }
            });
            this.dnH.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.iiB.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, vVar, null, null));
                    return true;
                }
            });
            f(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect ctg() {
        Rect rect = new Rect();
        this.aiS.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect cth() {
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
