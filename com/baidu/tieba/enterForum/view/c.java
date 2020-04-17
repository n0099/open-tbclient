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
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.h;
import com.baidu.tieba.enterForum.data.k;
/* loaded from: classes9.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.f, com.baidu.tieba.enterForum.data.d> {
    private TextView aKJ;
    private View cDX;
    private View ckF;
    private View duT;
    private TextView gIN;
    private TextView gIO;
    private TextView gIP;
    private TextView gIQ;
    private ImageView gIR;
    private TextView gIS;
    private TextView gIT;
    private ImageView glo;
    private ViewEventCenter gyO;
    private BarImageView gzf;
    private TextView mName;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.gyO = viewEventCenter;
        this.ckF = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.ckF.findViewById(R.id.name);
        this.gIN = (TextView) this.ckF.findViewById(R.id.live_label);
        this.gIO = (TextView) this.ckF.findViewById(R.id.pinpai_label);
        this.gIP = (TextView) this.ckF.findViewById(R.id.trial_label);
        this.gIQ = (TextView) this.ckF.findViewById(R.id.edit_btn_label);
        this.gIR = (ImageView) this.ckF.findViewById(R.id.sign);
        this.glo = (ImageView) this.ckF.findViewById(R.id.grade);
        this.gIS = (TextView) this.ckF.findViewById(R.id.owner_flag);
        this.duT = this.ckF.findViewById(R.id.enterforum_item_divider);
        this.aKJ = (TextView) this.ckF.findViewById(R.id.tv_add_love);
        this.gzf = (BarImageView) this.ckF.findViewById(R.id.forum_avatar);
        this.cDX = this.ckF.findViewById(R.id.forum_top_divider);
        this.gIT = (TextView) this.ckF.findViewById(R.id.forum_intro);
        this.gzf.setPlaceHolder(2);
        this.gzf.setStrokeColorResId(R.color.cp_bg_line_d);
    }

    @Override // com.baidu.tieba.tbadkCore.r
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.q.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void b(com.baidu.tieba.enterForum.data.d dVar) {
        super.b((c) dVar);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, am.getDrawable(R.color.cp_bg_line_c));
        stateListDrawable.addState(new int[0], am.getDrawable(R.color.cp_bg_line_e).mutate());
        this.ckF.setBackgroundDrawable(stateListDrawable);
        this.gzf.setPlaceHolder(2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ai(com.baidu.tieba.enterForum.data.f fVar) {
        super.ai(fVar);
        if (fVar != null) {
            b(fVar);
            am.setBackgroundColor(this.duT, R.color.cp_bg_line_e);
            SvgManager.aOU().a(this.gIR, R.drawable.icon_pure_ba_checkedin16_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.f fVar) {
        int i;
        int i2 = 0;
        if (fVar != null) {
            com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) aYL();
            this.ckF.setBackgroundDrawable(am.kC(R.color.cp_bg_line_e));
            this.ckF.setVisibility(0);
            this.mName.setVisibility(0);
            if (fVar instanceof h) {
                final h hVar = (h) fVar;
                this.mName.setText(hVar.getName());
                this.gIR.setVisibility(hVar.bHL() == 0 ? 8 : 0);
                if (hVar.getLevel() == 0) {
                    this.glo.setVisibility(8);
                } else {
                    this.glo.setVisibility(0);
                    am.setImageResource(this.glo, BitmapHelper.getGradeResourceIdInEnterForum(hVar.getLevel()));
                }
                this.gzf.setShowOval(true);
                this.gzf.startLoad(hVar.getAvatar(), 10, false);
                this.gzf.setShowOuterBorder(false);
                this.gzf.setShowInnerBorder(true);
                this.gzf.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds1));
                this.gzf.setStrokeColorResId(R.color.cp_border_a);
                if (hVar.bHK() > 0) {
                    am.setBackgroundColor(this.cDX, R.color.cp_link_tip_a);
                } else {
                    am.setBackgroundColor(this.cDX, R.color.transparent);
                }
                if (!hVar.bHJ().isEmpty()) {
                    this.gIT.setText(hVar.bHJ());
                }
                am.setViewTextColor(this.gIT, (int) R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(hVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.gIS.setVisibility((hVar.bHM() == 1 && hVar.isPrivateForum() == 1) ? 0 : 8);
                if (hVar.bHN() == 1) {
                    this.gIO.setVisibility(0);
                    this.gIO.setText(R.string.brand_label_ba_text);
                    am.setBackgroundResource(this.gIO, R.drawable.enter_forum_brand_label_bg_shape);
                    am.setViewTextColor(this.gIO, (int) R.color.cp_cont_a);
                    this.gIN.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(CmdConfigCustom.CMD_ALA_CHECK_LIVE_FORUM_BY_FID, Boolean.class, Long.valueOf(com.baidu.adp.lib.f.b.toLong(hVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.gIN.setVisibility(0);
                        this.gIN.setText("");
                        am.setBackgroundResource(this.gIN, R.drawable.icon_ba_list_live);
                        am.setViewTextColor(this.gIN, (int) R.color.cp_cont_g);
                    } else {
                        this.gIN.setVisibility(8);
                    }
                    this.gIO.setVisibility(8);
                }
                if (hVar.bHQ()) {
                    this.gIP.setVisibility(0);
                    i = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.gIP.setVisibility(8);
                    i = 0;
                }
                if (hVar.bHR()) {
                    this.gIQ.setVisibility(0);
                    i += l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.gIQ.setVisibility(8);
                }
                this.gIQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.gyO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, hVar, null, null));
                    }
                });
                i2 = i;
            } else if (fVar instanceof k) {
                this.mName.setText(((k) fVar).getForumName());
                this.gIR.setVisibility(8);
                this.glo.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((k) fVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.setBackgroundResource(this.gIS, R.drawable.icon_owner_bg);
            am.setViewTextColor(this.gIS, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mName, (int) R.color.cp_cont_b);
            this.aKJ.setVisibility(8);
            this.ckF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bKd());
                    bundle.putParcelable("info_forum_name_rect", c.this.bKe());
                    com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, fVar, null, null);
                    bVar.setExtra(bundle);
                    c.this.gyO.dispatchMvcEvent(bVar);
                }
            });
            this.ckF.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.gyO.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, fVar, null, null));
                    return true;
                }
            });
            e(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bKd() {
        Rect rect = new Rect();
        this.gzf.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bKe() {
        Rect rect = new Rect();
        this.mName.getGlobalVisibleRect(rect);
        return rect;
    }

    private void e(final TextView textView, final int i) {
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
