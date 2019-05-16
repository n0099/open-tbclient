package com.baidu.tieba.enterForum.view;

import android.graphics.Rect;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes4.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.d, com.baidu.tieba.enterForum.data.b> {
    private View aKg;
    private View bMQ;
    private ViewEventCenter eQn;
    private TextView eWO;
    private TextView eWP;
    private TextView eWQ;
    private TextView eWR;
    private ImageView eWS;
    private TextView eWT;
    private BarImageView eWU;
    private TextView eWV;
    private ImageView etA;
    private TextView mFollowBtn;
    private TextView mName;
    private View mTopView;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eQn = viewEventCenter;
        this.aKg = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.aKg.findViewById(R.id.name);
        this.eWO = (TextView) this.aKg.findViewById(R.id.live_label);
        this.eWP = (TextView) this.aKg.findViewById(R.id.pinpai_label);
        this.eWQ = (TextView) this.aKg.findViewById(R.id.trial_label);
        this.eWR = (TextView) this.aKg.findViewById(R.id.edit_btn_label);
        this.eWS = (ImageView) this.aKg.findViewById(R.id.sign);
        this.etA = (ImageView) this.aKg.findViewById(R.id.grade);
        this.eWT = (TextView) this.aKg.findViewById(R.id.owner_flag);
        this.bMQ = this.aKg.findViewById(R.id.enterforum_item_divider);
        this.mFollowBtn = (TextView) this.aKg.findViewById(R.id.tv_add_love);
        this.eWU = (BarImageView) this.aKg.findViewById(R.id.forum_avatar);
        this.mTopView = this.aKg.findViewById(R.id.forum_top_divider);
        this.eWV = (TextView) this.aKg.findViewById(R.id.forum_intro);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.s.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void b(com.baidu.tieba.enterForum.data.b bVar) {
        super.b((c) bVar);
        al.k(this.aKg, R.drawable.forum_item_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(com.baidu.tieba.enterForum.data.d dVar) {
        super.af(dVar);
        if (dVar != null) {
            b(dVar);
            al.l(this.bMQ, R.color.cp_bg_line_c);
            al.k(this.eWS, R.drawable.icon_ba_sign_20_n);
            al.j(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) atd();
            al.k(this.aKg, R.drawable.forum_item_bg);
            this.aKg.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.eWS.setVisibility(fVar.bdl() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.etA.setVisibility(8);
                } else {
                    this.etA.setVisibility(0);
                    al.c(this.etA, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.eWU.setShowOval(true);
                this.eWU.startLoad(fVar.getAvatar(), 10, false);
                if (fVar.bdk() > 0) {
                    al.l(this.mTopView, R.color.cp_link_tip_a);
                } else {
                    al.l(this.mTopView, R.color.transparent);
                }
                if (!fVar.bdj().isEmpty()) {
                    this.eWV.setText(fVar.bdj());
                }
                al.j(this.eWV, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new am("c12887"));
                }
                this.eWT.setVisibility((fVar.bdm() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bdn() == 1) {
                    this.eWP.setVisibility(0);
                    this.eWP.setText(R.string.brand_label_ba_text);
                    al.k(this.eWP, R.drawable.enter_forum_brand_label_bg_shape);
                    al.j(this.eWP, R.color.cp_btn_a);
                    this.eWO.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.c(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.eWO.setVisibility(0);
                        this.eWO.setText("");
                        al.k(this.eWO, R.drawable.icon_ba_list_live);
                        al.j(this.eWO, R.color.cp_cont_g);
                    } else {
                        this.eWO.setVisibility(8);
                    }
                    this.eWP.setVisibility(8);
                }
                if (fVar.bdq()) {
                    this.eWQ.setVisibility(0);
                    i = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.eWQ.setVisibility(8);
                    i = 0;
                }
                if (fVar.bdr()) {
                    this.eWR.setVisibility(0);
                    i += l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.eWR.setVisibility(8);
                }
                this.eWR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.eQn.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.eWS.setVisibility(8);
                this.etA.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new am("c12887"));
                }
            }
            al.k(this.eWT, R.drawable.icon_owner_bg);
            al.j(this.eWT, R.color.cp_btn_a);
            al.j(this.mName, R.color.cp_cont_b);
            this.mFollowBtn.setVisibility(8);
            this.aKg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.beR());
                    bundle.putParcelable("info_forum_name_rect", c.this.beS());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.eQn.dispatchMvcEvent(bVar2);
                }
            });
            this.aKg.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.eQn.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            k(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect beR() {
        Rect rect = new Rect();
        this.eWU.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect beS() {
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
