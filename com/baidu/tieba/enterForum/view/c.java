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
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes4.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.d, com.baidu.tieba.enterForum.data.b> {
    private View aLm;
    private View bOw;
    private ImageView eAq;
    private ViewEventCenter eXb;
    private TextView fec;
    private TextView fed;
    private TextView fee;
    private TextView fef;
    private ImageView feg;
    private TextView feh;
    private BarImageView fei;
    private TextView fej;
    private TextView mFollowBtn;
    private TextView mName;
    private View mTopView;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eXb = viewEventCenter;
        this.aLm = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.aLm.findViewById(R.id.name);
        this.fec = (TextView) this.aLm.findViewById(R.id.live_label);
        this.fed = (TextView) this.aLm.findViewById(R.id.pinpai_label);
        this.fee = (TextView) this.aLm.findViewById(R.id.trial_label);
        this.fef = (TextView) this.aLm.findViewById(R.id.edit_btn_label);
        this.feg = (ImageView) this.aLm.findViewById(R.id.sign);
        this.eAq = (ImageView) this.aLm.findViewById(R.id.grade);
        this.feh = (TextView) this.aLm.findViewById(R.id.owner_flag);
        this.bOw = this.aLm.findViewById(R.id.enterforum_item_divider);
        this.mFollowBtn = (TextView) this.aLm.findViewById(R.id.tv_add_love);
        this.fei = (BarImageView) this.aLm.findViewById(R.id.forum_avatar);
        this.mTopView = this.aLm.findViewById(R.id.forum_top_divider);
        this.fej = (TextView) this.aLm.findViewById(R.id.forum_intro);
    }

    @Override // com.baidu.tieba.tbadkCore.q
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void b(com.baidu.tieba.enterForum.data.b bVar) {
        super.b((c) bVar);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842910, 16842919}, am.getDrawable(R.color.cp_bg_line_c));
        stateListDrawable.addState(new int[0], am.getDrawable(R.color.cp_bg_line_e).mutate());
        this.aLm.setBackgroundDrawable(stateListDrawable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(com.baidu.tieba.enterForum.data.d dVar) {
        super.af(dVar);
        if (dVar != null) {
            b(dVar);
            am.l(this.bOw, R.color.cp_bg_line_e);
            SvgManager.ajv().a(this.feg, R.drawable.icon_pure_ba_checkedin_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
            am.j(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) auz();
            this.aLm.setBackgroundDrawable(am.io(R.color.cp_bg_line_e));
            this.aLm.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.feg.setVisibility(fVar.bfW() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.eAq.setVisibility(8);
                } else {
                    this.eAq.setVisibility(0);
                    am.c(this.eAq, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.fei.setShowOval(true);
                this.fei.startLoad(fVar.getAvatar(), 10, false);
                if (fVar.bfV() > 0) {
                    am.l(this.mTopView, R.color.cp_link_tip_a);
                } else {
                    am.l(this.mTopView, R.color.transparent);
                }
                if (!fVar.bfU().isEmpty()) {
                    this.fej.setText(fVar.bfU());
                }
                am.j(this.fej, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.feh.setVisibility((fVar.bfX() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bfY() == 1) {
                    this.fed.setVisibility(0);
                    this.fed.setText(R.string.brand_label_ba_text);
                    am.k(this.fed, R.drawable.enter_forum_brand_label_bg_shape);
                    am.j(this.fed, R.color.cp_cont_a);
                    this.fec.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.e(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.fec.setVisibility(0);
                        this.fec.setText("");
                        am.k(this.fec, R.drawable.icon_ba_list_live);
                        am.j(this.fec, R.color.cp_cont_g);
                    } else {
                        this.fec.setVisibility(8);
                    }
                    this.fed.setVisibility(8);
                }
                if (fVar.bgb()) {
                    this.fee.setVisibility(0);
                    i = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.fee.setVisibility(8);
                    i = 0;
                }
                if (fVar.bgc()) {
                    this.fef.setVisibility(0);
                    i += l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.fef.setVisibility(8);
                }
                this.fef.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.eXb.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.feg.setVisibility(8);
                this.eAq.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.k(this.feh, R.drawable.icon_owner_bg);
            am.j(this.feh, R.color.cp_cont_a);
            am.j(this.mName, R.color.cp_cont_b);
            this.mFollowBtn.setVisibility(8);
            this.aLm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bhP());
                    bundle.putParcelable("info_forum_name_rect", c.this.bhQ());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.eXb.dispatchMvcEvent(bVar2);
                }
            });
            this.aLm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.eXb.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            k(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bhP() {
        Rect rect = new Rect();
        this.fei.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bhQ() {
        Rect rect = new Rect();
        this.mName.getGlobalVisibleRect(rect);
        return rect;
    }

    private void k(final TextView textView, final int i) {
        if (textView != null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.enterForum.view.c.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    int af;
                    if ((textView.getParent() instanceof ViewGroup) && (af = l.af(c.this.getContext())) != 0) {
                        textView.setMaxWidth(af - (i + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds452)));
                        textView.postInvalidate();
                        textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }
}
