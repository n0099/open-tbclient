package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout gUC;
    private View gUD;
    private View gUE;
    private BarImageView gUF;
    private TextView gUG;
    private TextView gUH;
    private TextView gUI;
    private TextView gUJ;
    private TBSpecificationBtn gUK;
    private a gUL;
    private com.baidu.tieba.enterForum.recommend.b.b gUM;

    /* loaded from: classes9.dex */
    public interface a {
        void d(com.baidu.tieba.enterForum.recommend.b.b bVar);

        void e(com.baidu.tieba.enterForum.recommend.b.b bVar);
    }

    public RecommendForumItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI(context);
    }

    public RecommendForumItemView(Context context) {
        super(context);
        initUI(context);
    }

    private void initUI(Context context) {
        LayoutInflater.from(context).inflate(R.layout.recommend_forum_item_layout, this);
        View rootView = getRootView();
        this.gUC = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.gUD = rootView.findViewById(R.id.view_top);
        this.gUE = rootView.findViewById(R.id.view_bottom);
        this.gUF = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.gUG = (TextView) rootView.findViewById(R.id.forum_name);
        this.gUH = (TextView) rootView.findViewById(R.id.forum_attention);
        this.gUI = (TextView) rootView.findViewById(R.id.forum_thread);
        this.gUJ = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.gUK = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mi(R.color.cp_link_tip_a);
        this.gUK.setConfig(cVar);
        this.gUK.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.gUF.setPlaceHolder(2);
        this.gUF.setOnClickListener(this);
        this.gUK.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.gUL = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gUK) {
            if (this.gUM.dEi) {
                this.gUL.e(this.gUM);
                return;
            } else {
                this.gUL.d(this.gUM);
                return;
            }
        }
        this.gUL.e(this.gUM);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gUG, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gUH, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gUI, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gUJ, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.gUM = bVar;
            this.gUF.startLoad(bVar.avatar, 15, false);
            this.gUF.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gUF.setStrokeWith(3);
            this.gUF.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.gUG.setText(str);
            this.gUH.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.gUI.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.gTd)) {
                this.gUJ.setText(bVar.gTd);
            } else {
                this.gUJ.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            mo(bVar.dEi);
            com.baidu.tbadk.core.util.e.a.c.aVz().Q(l.getDimens(getContext(), R.dimen.tbds10)).P(l.getDimens(getContext(), R.dimen.tbds10)).lo(R.color.cp_btn_a).aR(this.gUD);
            com.baidu.tbadk.core.util.e.a.aVu().lD(R.color.cp_btn_a).ly(l.getDimens(getContext(), R.dimen.tbds10)).lz(R.color.cp_shadow_a_alpha16).lx(4353).lA(l.getDimens(getContext(), R.dimen.tbds10)).lB(0).lC(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.gUE);
            g(bVar);
        }
    }

    public void mo(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mk(R.color.cp_cont_d);
            this.gUK.setConfig(cVar);
            this.gUK.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.gUK.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mi(R.color.cp_link_tip_a);
            this.gUK.setConfig(cVar2);
            this.gUK.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.gUK.setClickState(true);
        }
        this.gUM.dEi = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.dh("obj_type", String.valueOf(bVar.gTh));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
