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
    private View aIi;
    private View bFo;
    private ViewEventCenter eBd;
    private TextView eGX;
    private TextView eGY;
    private TextView eGZ;
    private TextView eHa;
    private ImageView eHb;
    private ImageView eHc;
    private TextView eHd;
    private BarImageView eHe;
    private TextView eHf;
    private TextView mFollowBtn;
    private TextView mName;
    private View mTopView;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eBd = viewEventCenter;
        this.aIi = view.findViewById(d.g.rootview);
        this.mName = (TextView) this.aIi.findViewById(d.g.name);
        this.eGX = (TextView) this.aIi.findViewById(d.g.live_label);
        this.eGY = (TextView) this.aIi.findViewById(d.g.pinpai_label);
        this.eGZ = (TextView) this.aIi.findViewById(d.g.trial_label);
        this.eHa = (TextView) this.aIi.findViewById(d.g.edit_btn_label);
        this.eHb = (ImageView) this.aIi.findViewById(d.g.sign);
        this.eHc = (ImageView) this.aIi.findViewById(d.g.grade);
        this.eHd = (TextView) this.aIi.findViewById(d.g.owner_flag);
        this.bFo = this.aIi.findViewById(d.g.enterforum_item_divider);
        this.mFollowBtn = (TextView) this.aIi.findViewById(d.g.tv_add_love);
        this.eHe = (BarImageView) this.aIi.findViewById(d.g.forum_avatar);
        this.mTopView = this.aIi.findViewById(d.g.forum_top_divider);
        this.eHf = (TextView) this.aIi.findViewById(d.g.forum_intro);
    }

    @Override // com.baidu.tieba.tbadkCore.o
    public boolean b(TbPageContext<?> tbPageContext, int i) {
        com.baidu.tbadk.r.a.a(tbPageContext, getRootView());
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(com.baidu.tieba.enterForum.data.b bVar) {
        super.af(bVar);
        if (bVar != null) {
            b(bVar);
            al.l(this.bFo, d.C0236d.cp_bg_line_c);
            al.k(this.eHb, d.f.icon_ba_sign_20_n);
            al.j(this.mName, d.C0236d.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.b bVar) {
        int i;
        int i2 = 0;
        if (bVar != null) {
            al.k(this.aIi, d.f.forum_item_bg);
            this.aIi.setVisibility(0);
            this.mName.setVisibility(0);
            if (bVar instanceof com.baidu.tieba.enterForum.data.d) {
                final com.baidu.tieba.enterForum.data.d dVar = (com.baidu.tieba.enterForum.data.d) bVar;
                this.mName.setText(dVar.getName());
                this.eHb.setVisibility(dVar.aWl() == 0 ? 8 : 0);
                if (dVar.getLevel() == 0) {
                    this.eHc.setVisibility(8);
                } else {
                    this.eHc.setVisibility(0);
                    al.c(this.eHc, BitmapHelper.getGradeResourceIdInEnterForum(dVar.getLevel()));
                }
                this.eHe.setShowOval(true);
                this.eHe.startLoad(dVar.getAvatar(), 10, false);
                if (dVar.aWk() > 0) {
                    al.l(this.mTopView, d.C0236d.cp_link_tip_a);
                } else {
                    al.l(this.mTopView, d.C0236d.transparent);
                }
                if (!dVar.aWj().isEmpty()) {
                    this.eHf.setText(dVar.aWj());
                }
                al.j(this.eHf, d.C0236d.cp_cont_d);
                if (getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(dVar.getName())) {
                    TiebaStatic.log(new am("c12887"));
                }
                this.eHd.setVisibility((dVar.aWm() == 1 && dVar.isPrivateForum() == 1) ? 0 : 8);
                if (dVar.aWn() == 1) {
                    this.eGY.setVisibility(0);
                    this.eGY.setText(d.j.brand_label_ba_text);
                    al.k(this.eGY, d.f.enter_forum_brand_label_bg_shape);
                    al.j(this.eGY, d.C0236d.cp_btn_a);
                    this.eGX.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.d(dVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.eGX.setVisibility(0);
                        this.eGX.setText("");
                        al.k(this.eGX, d.f.icon_ba_list_live);
                        al.j(this.eGX, d.C0236d.cp_cont_g);
                    } else {
                        this.eGX.setVisibility(8);
                    }
                    this.eGY.setVisibility(8);
                }
                if (dVar.aWq()) {
                    this.eGZ.setVisibility(0);
                    i = l.h(TbadkCoreApplication.getInst(), d.e.tbds122) + 0;
                } else {
                    this.eGZ.setVisibility(8);
                    i = 0;
                }
                if (dVar.aWr()) {
                    this.eHa.setVisibility(0);
                    i += l.h(TbadkCoreApplication.getInst(), d.e.tbds200);
                } else {
                    this.eHa.setVisibility(8);
                }
                this.eHa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.eBd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, dVar, null, null));
                    }
                });
                i2 = i;
            } else if (bVar instanceof g) {
                this.mName.setText(((g) bVar).getForumName());
                this.eHb.setVisibility(8);
                this.eHc.setVisibility(8);
                if (getResources().getString(d.j.ala_follow_live_enter_live_square_txt).equals(((g) bVar).getForumName())) {
                    TiebaStatic.log(new am("c12887"));
                }
            }
            al.k(this.eHd, d.f.icon_owner_bg);
            al.j(this.eHd, d.C0236d.cp_btn_a);
            al.j(this.mName, d.C0236d.cp_cont_b);
            this.mFollowBtn.setVisibility(8);
            this.aIi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.aXD());
                    bundle.putParcelable("info_forum_name_rect", c.this.aXE());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, bVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.eBd.dispatchMvcEvent(bVar2);
                }
            });
            this.aIi.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.eBd.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, bVar, null, null));
                    return true;
                }
            });
            k(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect aXD() {
        Rect rect = new Rect();
        this.eHe.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect aXE() {
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
