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
/* loaded from: classes22.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private View ioA;
    private View ioB;
    private BarImageView ioC;
    private TextView ioD;
    private TextView ioE;
    private TextView ioF;
    private TextView ioG;
    private TBSpecificationBtn ioH;
    private a ioI;
    private com.baidu.tieba.enterForum.recommend.b.b ioJ;
    private LinearLayout ioz;

    /* loaded from: classes22.dex */
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
        this.ioz = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.ioA = rootView.findViewById(R.id.view_top);
        this.ioB = rootView.findViewById(R.id.view_bottom);
        this.ioC = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.ioD = (TextView) rootView.findViewById(R.id.forum_name);
        this.ioE = (TextView) rootView.findViewById(R.id.forum_attention);
        this.ioF = (TextView) rootView.findViewById(R.id.forum_thread);
        this.ioG = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.ioH = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.qi(R.color.cp_link_tip_a);
        this.ioH.setConfig(bVar);
        this.ioH.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.ioC.setPlaceHolder(2);
        this.ioC.setOnClickListener(this);
        this.ioH.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.ioI = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ioH) {
            if (this.ioJ.eDa) {
                this.ioI.e(this.ioJ);
                return;
            } else {
                this.ioI.d(this.ioJ);
                return;
            }
        }
        this.ioI.e(this.ioJ);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ioD, R.color.cp_cont_b);
        ap.setViewTextColor(this.ioE, R.color.cp_cont_d);
        ap.setViewTextColor(this.ioF, R.color.cp_cont_d);
        ap.setViewTextColor(this.ioG, R.color.cp_cont_j);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.ioJ = bVar;
            this.ioC.startLoad(bVar.avatar, 15, false);
            this.ioC.setStrokeColorResId(R.color.cp_bg_line_d);
            this.ioC.setStrokeWith(3);
            this.ioC.setShowOval(true);
            String str = bVar.forumName;
            if (at.isEmpty(str)) {
                str = "";
            }
            this.ioD.setText(str);
            this.ioE.setText("关注 " + at.numFormatOverWan(bVar.memberCount));
            this.ioF.setText("贴子 " + at.numFormatOverWan(bVar.threadCount));
            if (!at.isEmpty(bVar.imZ)) {
                this.ioG.setText(bVar.imZ);
            } else {
                this.ioG.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            oW(bVar.eDa);
            com.baidu.tbadk.core.util.e.a.b.brP().ad(l.getDimens(getContext(), R.dimen.tbds10)).ac(l.getDimens(getContext(), R.dimen.tbds10)).pk(R.color.cp_btn_a).bk(this.ioA);
            com.baidu.tbadk.core.util.e.a.brN().pA(R.color.cp_btn_a).pv(l.getDimens(getContext(), R.dimen.tbds10)).pw(R.color.cp_shadow_a_alpha16).pu(4353).px(l.getDimens(getContext(), R.dimen.tbds10)).py(0).pz(l.getDimens(getContext(), R.dimen.tbds5)).bk(this.ioB);
            g(bVar);
        }
    }

    public void oW(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qk(R.color.cp_cont_d);
            this.ioH.setConfig(bVar);
            this.ioH.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.ioH.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qi(R.color.cp_link_tip_a);
            this.ioH.setConfig(bVar2);
            this.ioH.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.ioH.setClickState(true);
        }
        this.ioJ.eDa = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            aq aqVar = new aq("c13374");
            aqVar.dR("obj_type", String.valueOf(bVar.ind));
            aqVar.w("fid", bVar.forumId);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }
}
