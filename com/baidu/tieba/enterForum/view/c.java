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
import com.baidu.tieba.d;
import com.baidu.tieba.enterForum.data.g;
/* loaded from: classes4.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.b, com.baidu.tbadk.mvc.d.b> {
    private View aIm;
    private View bFs;
    private ViewEventCenter eAK;
    private TextView eGF;
    private TextView eGG;
    private TextView eGH;
    private TextView eGI;
    private ImageView eGJ;
    private ImageView eGK;
    private TextView eGL;
    private BarImageView eGM;
    private TextView eGN;
    private TextView mFollowBtn;
    private TextView mName;
    private View mTopView;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eAK = viewEventCenter;
        this.aIm = view.findViewById(d.g.rootview);
        this.mName = (TextView) this.aIm.findViewById(d.g.name);
        this.eGF = (TextView) this.aIm.findViewById(d.g.live_label);
        this.eGG = (TextView) this.aIm.findViewById(d.g.pinpai_label);
        this.eGH = (TextView) this.aIm.findViewById(d.g.trial_label);
        this.eGI = (TextView) this.aIm.findViewById(d.g.edit_btn_label);
        this.eGJ = (ImageView) this.aIm.findViewById(d.g.sign);
        this.eGK = (ImageView) this.aIm.findViewById(d.g.grade);
        this.eGL = (TextView) this.aIm.findViewById(d.g.owner_flag);
        this.bFs = this.aIm.findViewById(d.g.enterforum_item_divider);
        this.mFollowBtn = (TextView) this.aIm.findViewById(d.g.tv_add_love);
        this.eGM = (BarImageView) this.aIm.findViewById(d.g.forum_avatar);
        this.mTopView = this.aIm.findViewById(d.g.forum_top_divider);
        this.eGN = (TextView) this.aIm.findViewById(d.g.forum_intro);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void ad(com.baidu.tieba.enterForum.data.b bVar) {
        super.ad(bVar);
        if (bVar != null) {
            b(bVar);
            al.l(this.bFs, d.C0277d.cp_bg_line_c);
            al.k(this.eGJ, d.f.icon_ba_sign_20_n);
            al.j(this.mName, d.C0277d.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.b bVar) {
        int i;
        int i2 = 0;
        if (bVar != null) {
            al.k(this.aIm, d.f.forum_item_bg);
            this.aIm.setVisibility(0);
            this.mName.setVisibility(0);
            if (bVar instanceof com.baidu.tieba.enterForum.data.d) {
                final com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) bVar;
                this.mName.setText(dVar.getName());
                this.eGJ.setVisibility(dVar.aWj() == 0 ? 8 : 0);
                if (dVar.getLevel() == 0) {
                    this.eGK.setVisibility(8);
                } else {
                    this.eGK.setVisibility(0);
                    al.c(this.eGK, BitmapHelper.getGradeResourceIdInEnterForum(dVar.getLevel()));
                }
                this.eGM.setShowOval(true);
                this.eGM.startLoad(dVar.getAvatar(), 10, false);
                if (dVar.aWi() > 0) {
                    al.l(this.mTopView, d.C0277d.cp_link_tip_a);
                } else {
                    al.l(this.mTopView, d.C0277d.transparent);
                }
                if (!dVar.aWh().isEmpty()) {
                    this.eGN.setText(dVar.aWh());
                }
                al.j(this.eGN, d.C0277d.cp_cont_d);
                if (getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(dVar.getName())) {
                    TiebaStatic.log(new am("c12887"));
                }
                this.eGL.setVisibility((dVar.aWk() == 1 && dVar.isPrivateForum() == 1) ? 0 : 8);
                if (dVar.aWl() == 1) {
                    this.eGG.setVisibility(0);
                    this.eGG.setText(d.j.brand_label_ba_text);
                    al.k(this.eGG, d.f.enter_forum_brand_label_bg_shape);
                    al.j(this.eGG, d.C0277d.cp_btn_a);
                    this.eGF.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.d(dVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.eGF.setVisibility(0);
                        this.eGF.setText("");
                        al.k(this.eGF, d.f.icon_ba_list_live);
                        al.j(this.eGF, d.C0277d.cp_cont_g);
                    } else {
                        this.eGF.setVisibility(8);
                    }
                    this.eGG.setVisibility(8);
                }
                if (dVar.aWo()) {
                    this.eGH.setVisibility(0);
                    i = l.h(TbadkCoreApplication.getInst(), d.e.tbds122) + 0;
                } else {
                    this.eGH.setVisibility(8);
                    i = 0;
                }
                if (dVar.aWp()) {
                    this.eGI.setVisibility(0);
                    i += l.h(TbadkCoreApplication.getInst(), d.e.tbds200);
                } else {
                    this.eGI.setVisibility(8);
                }
                this.eGI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.eAK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, dVar, null, null));
                    }
                });
                i2 = i;
            } else if (bVar instanceof g) {
                this.mName.setText(((g) bVar).getForumName());
                this.eGJ.setVisibility(8);
                this.eGK.setVisibility(8);
                if (getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(((g) bVar).getForumName())) {
                    TiebaStatic.log(new am("c12887"));
                }
            }
            al.k(this.eGL, d.f.icon_owner_bg);
            al.j(this.eGL, d.C0277d.cp_btn_a);
            al.j(this.mName, d.C0277d.cp_cont_b);
            this.mFollowBtn.setVisibility(8);
            this.aIm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.aXA());
                    bundle.putParcelable("info_forum_name_rect", c.this.aXB());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, bVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.eAK.dispatchMvcEvent(bVar2);
                }
            });
            this.aIm.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.eAK.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, bVar, null, null));
                    return true;
                }
            });
            k(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect aXA() {
        Rect rect = new Rect();
        this.eGM.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect aXB() {
        Rect rect = new Rect();
        this.mName.getGlobalVisibleRect(rect);
        return rect;
    }

    private void k(final TextView textView, final int i) {
        if (textView != null) {
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.enterForum.view.c.4
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    int aO;
                    if ((textView.getParent() instanceof ViewGroup) && (aO = l.aO(c.this.getContext())) != 0) {
                        textView.setMaxWidth(aO - (i + l.h(TbadkCoreApplication.getInst(), d.e.tbds452)));
                        textView.postInvalidate();
                        textView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }
}
