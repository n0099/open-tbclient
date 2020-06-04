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
    private LinearLayout gUN;
    private View gUO;
    private View gUP;
    private BarImageView gUQ;
    private TextView gUR;
    private TextView gUS;
    private TextView gUT;
    private TextView gUU;
    private TBSpecificationBtn gUV;
    private a gUW;
    private com.baidu.tieba.enterForum.recommend.b.b gUX;

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
        this.gUN = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.gUO = rootView.findViewById(R.id.view_top);
        this.gUP = rootView.findViewById(R.id.view_bottom);
        this.gUQ = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.gUR = (TextView) rootView.findViewById(R.id.forum_name);
        this.gUS = (TextView) rootView.findViewById(R.id.forum_attention);
        this.gUT = (TextView) rootView.findViewById(R.id.forum_thread);
        this.gUU = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.gUV = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.mk(R.color.cp_link_tip_a);
        this.gUV.setConfig(cVar);
        this.gUV.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.gUQ.setPlaceHolder(2);
        this.gUQ.setOnClickListener(this);
        this.gUV.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.gUW = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gUV) {
            if (this.gUX.dEi) {
                this.gUW.e(this.gUX);
                return;
            } else {
                this.gUW.d(this.gUX);
                return;
            }
        }
        this.gUW.e(this.gUX);
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gUR, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gUS, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gUT, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gUU, (int) R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.gUX = bVar;
            this.gUQ.startLoad(bVar.avatar, 15, false);
            this.gUQ.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gUQ.setStrokeWith(3);
            this.gUQ.setShowOval(true);
            String str = bVar.forumName;
            if (aq.isEmpty(str)) {
                str = "";
            }
            this.gUR.setText(str);
            this.gUS.setText("关注 " + aq.numFormatOverWan(bVar.memberCount));
            this.gUT.setText("贴子 " + aq.numFormatOverWan(bVar.threadCount));
            if (!aq.isEmpty(bVar.gTo)) {
                this.gUU.setText(bVar.gTo);
            } else {
                this.gUU.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            mo(bVar.dEi);
            com.baidu.tbadk.core.util.e.a.c.aVA().Q(l.getDimens(getContext(), R.dimen.tbds10)).P(l.getDimens(getContext(), R.dimen.tbds10)).lq(R.color.cp_btn_a).aR(this.gUO);
            com.baidu.tbadk.core.util.e.a.aVv().lF(R.color.cp_btn_a).lA(l.getDimens(getContext(), R.dimen.tbds10)).lB(R.color.cp_shadow_a_alpha16).lz(4353).lC(l.getDimens(getContext(), R.dimen.tbds10)).lD(0).lE(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.gUP);
            g(bVar);
        }
    }

    public void mo(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar.mm(R.color.cp_cont_d);
            this.gUV.setConfig(cVar);
            this.gUV.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.gUV.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.c cVar2 = new com.baidu.tbadk.core.view.commonBtn.c();
            cVar2.mk(R.color.cp_link_tip_a);
            this.gUV.setConfig(cVar2);
            this.gUV.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.gUV.setClickState(true);
        }
        this.gUX.dEi = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            an anVar = new an("c13374");
            anVar.dh("obj_type", String.valueOf(bVar.gTs));
            anVar.s("fid", bVar.forumId);
            anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }
}
