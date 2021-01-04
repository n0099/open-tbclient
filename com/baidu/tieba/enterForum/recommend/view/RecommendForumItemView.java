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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private TextView iMA;
    private TBSpecificationBtn iMB;
    private a iMC;
    private com.baidu.tieba.enterForum.recommend.b.b iMD;
    private View iMu;
    private View iMv;
    private BarImageView iMw;
    private TextView iMx;
    private TextView iMy;
    private TextView iMz;

    /* loaded from: classes2.dex */
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
        this.iMu = rootView.findViewById(R.id.view_top);
        this.iMv = rootView.findViewById(R.id.view_bottom);
        this.iMw = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.iMx = (TextView) rootView.findViewById(R.id.forum_name);
        this.iMy = (TextView) rootView.findViewById(R.id.forum_attention);
        this.iMz = (TextView) rootView.findViewById(R.id.forum_thread);
        this.iMA = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.iMB = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.rs(R.color.CAM_X0302);
        this.iMB.setConfig(bVar);
        this.iMB.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.iMw.setPlaceHolder(1);
        this.iMw.setOnClickListener(this);
        this.iMB.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.iMC = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iMB) {
            if (this.iMD.eSj) {
                this.iMC.e(this.iMD);
                return;
            } else {
                this.iMC.d(this.iMD);
                return;
            }
        }
        this.iMC.e(this.iMD);
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.iMx, R.color.CAM_X0105);
        ao.setViewTextColor(this.iMy, R.color.CAM_X0109);
        ao.setViewTextColor(this.iMz, R.color.CAM_X0109);
        ao.setViewTextColor(this.iMA, R.color.CAM_X0107);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.iMD = bVar;
            this.iMw.startLoad(bVar.avatar, 15, false);
            this.iMw.setStrokeColorResId(R.color.CAM_X0201);
            this.iMw.setStrokeWith(3);
            this.iMw.setShowOval(true);
            String str = bVar.forumName;
            if (at.isEmpty(str)) {
                str = "";
            }
            this.iMx.setText(str);
            this.iMy.setText("关注 " + at.numFormatOverWan(bVar.memberCount));
            this.iMz.setText("贴子 " + at.numFormatOverWan(bVar.threadCount));
            if (!at.isEmpty(bVar.iKV)) {
                this.iMA.setText(bVar.iKV);
            } else {
                this.iMA.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            pS(bVar.eSj);
            com.baidu.tbadk.core.util.f.a.b.bwV().ag(l.getDimens(getContext(), R.dimen.tbds10)).af(l.getDimens(getContext(), R.dimen.tbds10)).qr(R.color.CAM_X0901).bz(this.iMu);
            com.baidu.tbadk.core.util.f.a.bwT().qI(R.color.CAM_X0901).qD(l.getDimens(getContext(), R.dimen.tbds10)).qE(R.color.CAM_X0804).qC(4353).qF(l.getDimens(getContext(), R.dimen.tbds10)).qG(0).qH(l.getDimens(getContext(), R.dimen.tbds5)).bz(this.iMv);
            g(bVar);
        }
    }

    public void pS(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.ru(R.color.CAM_X0109);
            this.iMB.setConfig(bVar);
            this.iMB.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.iMB.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.rs(R.color.CAM_X0302);
            this.iMB.setConfig(bVar2);
            this.iMB.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.iMB.setClickState(true);
        }
        this.iMD.eSj = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            aq aqVar = new aq("c13374");
            aqVar.dX("obj_type", String.valueOf(bVar.iKZ));
            aqVar.w("fid", bVar.forumId);
            aqVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(aqVar);
        }
    }
}
