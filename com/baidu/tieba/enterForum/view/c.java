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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.i;
/* loaded from: classes4.dex */
public class c extends com.baidu.tbadk.mvc.f.a<com.baidu.tieba.enterForum.data.d, com.baidu.tieba.enterForum.data.b> {
    private View aKO;
    private View bNX;
    private ViewEventCenter eVv;
    private ImageView eyH;
    private TextView fcp;
    private TextView fcq;
    private TextView fcr;
    private TextView fcs;
    private ImageView fct;
    private TextView fcu;
    private BarImageView fcv;
    private TextView fcw;
    private TextView mFollowBtn;
    private TextView mName;
    private View mTopView;

    public c(TbPageContext<?> tbPageContext, View view, ViewEventCenter viewEventCenter) {
        super(tbPageContext, view, viewEventCenter);
        this.eVv = viewEventCenter;
        this.aKO = view.findViewById(R.id.rootview);
        this.mName = (TextView) this.aKO.findViewById(R.id.name);
        this.fcp = (TextView) this.aKO.findViewById(R.id.live_label);
        this.fcq = (TextView) this.aKO.findViewById(R.id.pinpai_label);
        this.fcr = (TextView) this.aKO.findViewById(R.id.trial_label);
        this.fcs = (TextView) this.aKO.findViewById(R.id.edit_btn_label);
        this.fct = (ImageView) this.aKO.findViewById(R.id.sign);
        this.eyH = (ImageView) this.aKO.findViewById(R.id.grade);
        this.fcu = (TextView) this.aKO.findViewById(R.id.owner_flag);
        this.bNX = this.aKO.findViewById(R.id.enterforum_item_divider);
        this.mFollowBtn = (TextView) this.aKO.findViewById(R.id.tv_add_love);
        this.fcv = (BarImageView) this.aKO.findViewById(R.id.forum_avatar);
        this.mTopView = this.aKO.findViewById(R.id.forum_top_divider);
        this.fcw = (TextView) this.aKO.findViewById(R.id.forum_intro);
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
        am.k(this.aKO, R.drawable.forum_item_bg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.mvc.f.e
    /* renamed from: a */
    public void af(com.baidu.tieba.enterForum.data.d dVar) {
        super.af(dVar);
        if (dVar != null) {
            b(dVar);
            am.l(this.bNX, R.color.cp_bg_line_c);
            am.k(this.fct, R.drawable.icon_ba_sign_20_n);
            am.j(this.mName, R.color.cp_cont_b);
        }
    }

    private void b(final com.baidu.tieba.enterForum.data.d dVar) {
        int i;
        int i2 = 0;
        if (dVar != null) {
            com.baidu.tieba.enterForum.data.b bVar = (com.baidu.tieba.enterForum.data.b) aun();
            am.k(this.aKO, R.drawable.forum_item_bg);
            this.aKO.setVisibility(0);
            this.mName.setVisibility(0);
            if (dVar instanceof com.baidu.tieba.enterForum.data.f) {
                final com.baidu.tieba.enterForum.data.f fVar = (com.baidu.tieba.enterForum.data.f) dVar;
                this.mName.setText(fVar.getName());
                this.fct.setVisibility(fVar.bfs() == 0 ? 8 : 0);
                if (fVar.getLevel() == 0) {
                    this.eyH.setVisibility(8);
                } else {
                    this.eyH.setVisibility(0);
                    am.c(this.eyH, BitmapHelper.getGradeResourceIdInEnterForum(fVar.getLevel()));
                }
                this.fcv.setShowOval(true);
                this.fcv.startLoad(fVar.getAvatar(), 10, false);
                if (fVar.bfr() > 0) {
                    am.l(this.mTopView, R.color.cp_link_tip_a);
                } else {
                    am.l(this.mTopView, R.color.transparent);
                }
                if (!fVar.bfq().isEmpty()) {
                    this.fcw.setText(fVar.bfq());
                }
                am.j(this.fcw, R.color.cp_cont_d);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(fVar.getName())) {
                    TiebaStatic.log(new an("c12887"));
                }
                this.fcu.setVisibility((fVar.bft() == 1 && fVar.isPrivateForum() == 1) ? 0 : 8);
                if (fVar.bfu() == 1) {
                    this.fcq.setVisibility(0);
                    this.fcq.setText(R.string.brand_label_ba_text);
                    am.k(this.fcq, R.drawable.enter_forum_brand_label_bg_shape);
                    am.j(this.fcq, R.color.cp_btn_a);
                    this.fcp.setVisibility(8);
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911007, Boolean.class, Long.valueOf(com.baidu.adp.lib.g.b.c(fVar.getId(), 0L)));
                    if (runTask != null && ((Boolean) runTask.getData()).booleanValue()) {
                        this.fcp.setVisibility(0);
                        this.fcp.setText("");
                        am.k(this.fcp, R.drawable.icon_ba_list_live);
                        am.j(this.fcp, R.color.cp_cont_g);
                    } else {
                        this.fcp.setVisibility(8);
                    }
                    this.fcq.setVisibility(8);
                }
                if (fVar.bfx()) {
                    this.fcr.setVisibility(0);
                    i = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds122) + 0;
                } else {
                    this.fcr.setVisibility(8);
                    i = 0;
                }
                if (fVar.bfy()) {
                    this.fcs.setVisibility(0);
                    i += l.g(TbadkCoreApplication.getInst(), R.dimen.tbds200);
                } else {
                    this.fcs.setVisibility(8);
                }
                this.fcs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TiebaStatic.log("c13386");
                        c.this.eVv.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(15, fVar, null, null));
                    }
                });
                i2 = i;
            } else if (dVar instanceof i) {
                this.mName.setText(((i) dVar).getForumName());
                this.fct.setVisibility(8);
                this.eyH.setVisibility(8);
                if (getResources().getString(R.string.ala_follow_live_enter_live_square_txt).equals(((i) dVar).getForumName())) {
                    TiebaStatic.log(new an("c12887"));
                }
            }
            am.k(this.fcu, R.drawable.icon_owner_bg);
            am.j(this.fcu, R.color.cp_btn_a);
            am.j(this.mName, R.color.cp_cont_b);
            this.mFollowBtn.setVisibility(8);
            this.aKO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.view.c.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("info_forum_image_rect", c.this.bhe());
                    bundle.putParcelable("info_forum_name_rect", c.this.bhf());
                    com.baidu.tbadk.mvc.c.b bVar2 = new com.baidu.tbadk.mvc.c.b(1, dVar, null, null);
                    bVar2.setExtra(bundle);
                    c.this.eVv.dispatchMvcEvent(bVar2);
                }
            });
            this.aKO.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.baidu.tieba.enterForum.view.c.3
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    c.this.eVv.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(12, dVar, null, null));
                    return true;
                }
            });
            k(this.mName, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bhe() {
        Rect rect = new Rect();
        this.fcv.getGlobalVisibleRect(rect);
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect bhf() {
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
