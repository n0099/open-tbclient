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
    private LinearLayout iAh;
    private View iAi;
    private View iAj;
    private BarImageView iAk;
    private TextView iAl;
    private TextView iAm;
    private TextView iAn;
    private TextView iAo;
    private TBSpecificationBtn iAp;
    private a iAq;
    private com.baidu.tieba.enterForum.recommend.b.b iAr;

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
        this.iAh = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.iAi = rootView.findViewById(R.id.view_top);
        this.iAj = rootView.findViewById(R.id.view_bottom);
        this.iAk = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.iAl = (TextView) rootView.findViewById(R.id.forum_name);
        this.iAm = (TextView) rootView.findViewById(R.id.forum_attention);
        this.iAn = (TextView) rootView.findViewById(R.id.forum_thread);
        this.iAo = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.iAp = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.rh(R.color.CAM_X0302);
        this.iAp.setConfig(bVar);
        this.iAp.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.iAk.setPlaceHolder(1);
        this.iAk.setOnClickListener(this);
        this.iAp.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.iAq = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iAp) {
            if (this.iAr.eIr) {
                this.iAq.e(this.iAr);
                return;
            } else {
                this.iAq.d(this.iAr);
                return;
            }
        }
        this.iAq.e(this.iAr);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iAl, R.color.CAM_X0105);
        ap.setViewTextColor(this.iAm, R.color.CAM_X0109);
        ap.setViewTextColor(this.iAn, R.color.CAM_X0109);
        ap.setViewTextColor(this.iAo, R.color.CAM_X0107);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.iAr = bVar;
            this.iAk.startLoad(bVar.avatar, 15, false);
            this.iAk.setStrokeColorResId(R.color.CAM_X0201);
            this.iAk.setStrokeWith(3);
            this.iAk.setShowOval(true);
            String str = bVar.forumName;
            if (au.isEmpty(str)) {
                str = "";
            }
            this.iAl.setText(str);
            this.iAm.setText("关注 " + au.numFormatOverWan(bVar.memberCount));
            this.iAn.setText("贴子 " + au.numFormatOverWan(bVar.threadCount));
            if (!au.isEmpty(bVar.iyI)) {
                this.iAo.setText(bVar.iyI);
            } else {
                this.iAo.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            pv(bVar.eIr);
            com.baidu.tbadk.core.util.e.a.b.buA().ae(l.getDimens(getContext(), R.dimen.tbds10)).ad(l.getDimens(getContext(), R.dimen.tbds10)).qg(R.color.CAM_X0901).bq(this.iAi);
            com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0901).qs(l.getDimens(getContext(), R.dimen.tbds10)).qt(R.color.CAM_X0804).qr(4353).qu(l.getDimens(getContext(), R.dimen.tbds10)).qv(0).qw(l.getDimens(getContext(), R.dimen.tbds5)).bq(this.iAj);
            g(bVar);
        }
    }

    public void pv(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.rj(R.color.CAM_X0109);
            this.iAp.setConfig(bVar);
            this.iAp.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.iAp.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.rh(R.color.CAM_X0302);
            this.iAp.setConfig(bVar2);
            this.iAp.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.iAp.setClickState(true);
        }
        this.iAr.eIr = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            ar arVar = new ar("c13374");
            arVar.dY("obj_type", String.valueOf(bVar.iyM));
            arVar.w("fid", bVar.forumId);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }
}
