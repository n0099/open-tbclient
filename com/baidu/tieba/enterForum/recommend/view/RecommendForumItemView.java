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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout hHf;
    private View hHg;
    private View hHh;
    private BarImageView hHi;
    private TextView hHj;
    private TextView hHk;
    private TextView hHl;
    private TextView hHm;
    private TBSpecificationBtn hHn;
    private a hHo;
    private com.baidu.tieba.enterForum.recommend.b.b hHp;

    /* loaded from: classes21.dex */
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
        this.hHf = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.hHg = rootView.findViewById(R.id.view_top);
        this.hHh = rootView.findViewById(R.id.view_bottom);
        this.hHi = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.hHj = (TextView) rootView.findViewById(R.id.forum_name);
        this.hHk = (TextView) rootView.findViewById(R.id.forum_attention);
        this.hHl = (TextView) rootView.findViewById(R.id.forum_thread);
        this.hHm = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.hHn = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.pp(R.color.cp_link_tip_a);
        this.hHn.setConfig(bVar);
        this.hHn.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.hHi.setPlaceHolder(2);
        this.hHi.setOnClickListener(this);
        this.hHn.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.hHo = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hHn) {
            if (this.hHp.ecG) {
                this.hHo.e(this.hHp);
                return;
            } else {
                this.hHo.d(this.hHp);
                return;
            }
        }
        this.hHo.e(this.hHp);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.hHj, R.color.cp_cont_b);
        ap.setViewTextColor(this.hHk, R.color.cp_cont_d);
        ap.setViewTextColor(this.hHl, R.color.cp_cont_d);
        ap.setViewTextColor(this.hHm, R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.hHp = bVar;
            this.hHi.startLoad(bVar.avatar, 15, false);
            this.hHi.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hHi.setStrokeWith(3);
            this.hHi.setShowOval(true);
            String str = bVar.forumName;
            if (at.isEmpty(str)) {
                str = "";
            }
            this.hHj.setText(str);
            this.hHk.setText("关注 " + at.numFormatOverWan(bVar.memberCount));
            this.hHl.setText("贴子 " + at.numFormatOverWan(bVar.threadCount));
            if (!at.isEmpty(bVar.hFG)) {
                this.hHm.setText(bVar.hFG);
            } else {
                this.hHm.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            nQ(bVar.ecG);
            com.baidu.tbadk.core.util.e.a.b.bkM().X(l.getDimens(getContext(), R.dimen.tbds10)).W(l.getDimens(getContext(), R.dimen.tbds10)).or(R.color.cp_btn_a).bb(this.hHg);
            com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_btn_a).oB(l.getDimens(getContext(), R.dimen.tbds10)).oC(R.color.cp_shadow_a_alpha16).oA(4353).oD(l.getDimens(getContext(), R.dimen.tbds10)).oE(0).oF(l.getDimens(getContext(), R.dimen.tbds5)).bb(this.hHh);
            g(bVar);
        }
    }

    public void nQ(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.pr(R.color.cp_cont_d);
            this.hHn.setConfig(bVar);
            this.hHn.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.hHn.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.pp(R.color.cp_link_tip_a);
            this.hHn.setConfig(bVar2);
            this.hHn.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.hHn.setClickState(true);
        }
        this.hHp.ecG = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            aq aqVar = new aq("c13374");
            aqVar.dF("obj_type", String.valueOf(bVar.hFK));
            aqVar.u("fid", bVar.forumId);
            aqVar.u("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }
}
