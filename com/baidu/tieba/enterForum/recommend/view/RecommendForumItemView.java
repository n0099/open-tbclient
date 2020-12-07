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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout iAf;
    private View iAg;
    private View iAh;
    private BarImageView iAi;
    private TextView iAj;
    private TextView iAk;
    private TextView iAl;
    private TextView iAm;
    private TBSpecificationBtn iAn;
    private a iAo;
    private com.baidu.tieba.enterForum.recommend.b.b iAp;

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
        this.iAf = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.iAg = rootView.findViewById(R.id.view_top);
        this.iAh = rootView.findViewById(R.id.view_bottom);
        this.iAi = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.iAj = (TextView) rootView.findViewById(R.id.forum_name);
        this.iAk = (TextView) rootView.findViewById(R.id.forum_attention);
        this.iAl = (TextView) rootView.findViewById(R.id.forum_thread);
        this.iAm = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.iAn = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.rh(R.color.CAM_X0302);
        this.iAn.setConfig(bVar);
        this.iAn.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.iAi.setPlaceHolder(1);
        this.iAi.setOnClickListener(this);
        this.iAn.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.iAo = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iAn) {
            if (this.iAp.eIr) {
                this.iAo.e(this.iAp);
                return;
            } else {
                this.iAo.d(this.iAp);
                return;
            }
        }
        this.iAo.e(this.iAp);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iAj, R.color.CAM_X0105);
        ap.setViewTextColor(this.iAk, R.color.CAM_X0109);
        ap.setViewTextColor(this.iAl, R.color.CAM_X0109);
        ap.setViewTextColor(this.iAm, R.color.CAM_X0107);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.iAp = bVar;
            this.iAi.startLoad(bVar.avatar, 15, false);
            this.iAi.setStrokeColorResId(R.color.CAM_X0201);
            this.iAi.setStrokeWith(3);
            this.iAi.setShowOval(true);
            String str = bVar.forumName;
            if (au.isEmpty(str)) {
                str = "";
            }
            this.iAj.setText(str);
            this.iAk.setText("关注 " + au.numFormatOverWan(bVar.memberCount));
            this.iAl.setText("贴子 " + au.numFormatOverWan(bVar.threadCount));
            if (!au.isEmpty(bVar.iyG)) {
                this.iAm.setText(bVar.iyG);
            } else {
                this.iAm.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            pv(bVar.eIr);
            com.baidu.tbadk.core.util.e.a.b.buA().ae(l.getDimens(getContext(), R.dimen.tbds10)).ad(l.getDimens(getContext(), R.dimen.tbds10)).qg(R.color.CAM_X0901).bq(this.iAg);
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0901).qs(l.getDimens(getContext(), R.dimen.tbds10)).qt(R.color.CAM_X0804).qr(4353).qu(l.getDimens(getContext(), R.dimen.tbds10)).qv(0).qw(l.getDimens(getContext(), R.dimen.tbds5)).bq(this.iAh);
            g(bVar);
        }
    }

    public void pv(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.rj(R.color.CAM_X0109);
            this.iAn.setConfig(bVar);
            this.iAn.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.iAn.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.rh(R.color.CAM_X0302);
            this.iAn.setConfig(bVar2);
            this.iAn.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.iAn.setClickState(true);
        }
        this.iAp.eIr = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            ar arVar = new ar("c13374");
            arVar.dY("obj_type", String.valueOf(bVar.iyK));
            arVar.w("fid", bVar.forumId);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }
}
