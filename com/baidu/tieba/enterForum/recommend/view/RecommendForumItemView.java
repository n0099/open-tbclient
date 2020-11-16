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
/* loaded from: classes21.dex */
public class RecommendForumItemView extends LinearLayout implements View.OnClickListener {
    private LinearLayout ipn;
    private View ipo;
    private View ipp;
    private BarImageView ipq;
    private TextView ipr;
    private TextView ips;
    private TextView ipt;
    private TextView ipu;
    private TBSpecificationBtn ipv;
    private a ipw;
    private com.baidu.tieba.enterForum.recommend.b.b ipx;

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
        this.ipn = (LinearLayout) rootView.findViewById(R.id.forum_item_container);
        this.ipo = rootView.findViewById(R.id.view_top);
        this.ipp = rootView.findViewById(R.id.view_bottom);
        this.ipq = (BarImageView) rootView.findViewById(R.id.forum_image);
        this.ipr = (TextView) rootView.findViewById(R.id.forum_name);
        this.ips = (TextView) rootView.findViewById(R.id.forum_attention);
        this.ipt = (TextView) rootView.findViewById(R.id.forum_thread);
        this.ipu = (TextView) rootView.findViewById(R.id.forum_introduce);
        this.ipv = (TBSpecificationBtn) rootView.findViewById(R.id.forum_like_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        bVar.qG(R.color.CAM_X0302);
        this.ipv.setConfig(bVar);
        this.ipv.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
        this.ipq.setPlaceHolder(1);
        this.ipq.setOnClickListener(this);
        this.ipv.setOnClickListener(this);
        rootView.setOnClickListener(this);
    }

    public void setForumItemClickListener(a aVar) {
        if (aVar != null) {
            this.ipw = aVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ipv) {
            if (this.ipx.eBr) {
                this.ipw.e(this.ipx);
                return;
            } else {
                this.ipw.d(this.ipx);
                return;
            }
        }
        this.ipw.e(this.ipx);
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ipr, R.color.CAM_X0105);
        ap.setViewTextColor(this.ips, R.color.CAM_X0109);
        ap.setViewTextColor(this.ipt, R.color.CAM_X0109);
        ap.setViewTextColor(this.ipu, R.color.CAM_X0107);
    }

    public void f(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            this.ipx = bVar;
            this.ipq.startLoad(bVar.avatar, 15, false);
            this.ipq.setStrokeColorResId(R.color.CAM_X0201);
            this.ipq.setStrokeWith(3);
            this.ipq.setShowOval(true);
            String str = bVar.forumName;
            if (au.isEmpty(str)) {
                str = "";
            }
            this.ipr.setText(str);
            this.ips.setText("关注 " + au.numFormatOverWan(bVar.memberCount));
            this.ipt.setText("贴子 " + au.numFormatOverWan(bVar.threadCount));
            if (!au.isEmpty(bVar.inO)) {
                this.ipu.setText(bVar.inO);
            } else {
                this.ipu.setText(TbadkCoreApplication.getInst().getString(R.string.recommend_forum_default_introduce));
            }
            oZ(bVar.eBr);
            com.baidu.tbadk.core.util.e.a.b.brd().ae(l.getDimens(getContext(), R.dimen.tbds10)).ad(l.getDimens(getContext(), R.dimen.tbds10)).pG(R.color.CAM_X0901).bn(this.ipo);
            com.baidu.tbadk.core.util.e.a.brb().pX(R.color.CAM_X0901).pS(l.getDimens(getContext(), R.dimen.tbds10)).pT(R.color.CAM_X0804).pR(4353).pU(l.getDimens(getContext(), R.dimen.tbds10)).pV(0).pW(l.getDimens(getContext(), R.dimen.tbds5)).bn(this.ipp);
            g(bVar);
        }
    }

    public void oZ(boolean z) {
        if (z) {
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.qI(R.color.CAM_X0109);
            this.ipv.setConfig(bVar);
            this.ipv.setText(TbadkCoreApplication.getInst().getString(R.string.relate_forum_is_followed));
            this.ipv.setClickState(false);
        } else {
            com.baidu.tbadk.core.view.commonBtn.b bVar2 = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar2.qG(R.color.CAM_X0302);
            this.ipv.setConfig(bVar2);
            this.ipv.setText(TbadkCoreApplication.getInst().getString(R.string.attention));
            this.ipv.setClickState(true);
        }
        this.ipx.eBr = z;
    }

    private void g(com.baidu.tieba.enterForum.recommend.b.b bVar) {
        if (bVar != null) {
            ar arVar = new ar("c13374");
            arVar.dR("obj_type", String.valueOf(bVar.inS));
            arVar.w("fid", bVar.forumId);
            arVar.w("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(arVar);
        }
    }
}
