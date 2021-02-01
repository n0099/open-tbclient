package com.baidu.tieba.card;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class o extends b<com.baidu.tieba.card.data.n> {
    private TextView eHx;
    private TextView ixf;
    private LinearLayout ixg;
    private LinearLayout ixh;
    private LinearLayout ixi;
    private LinearLayout ixj;
    private TextView ixk;
    private TextView ixl;
    private TextView ixm;
    private TextView ixn;
    private View ixo;
    private View ixp;
    private View ixq;
    private View ixr;
    private View ixs;
    private com.baidu.tieba.card.data.n ixt;
    private String ixu;
    private String ixv;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.eHx = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.ixf = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.ixg = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.ixh = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.ixi = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.ixj = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.ixk = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.ixl = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.ixm = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.ixn = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.ixo = view.findViewById(R.id.home_top_div);
        this.ixp = view.findViewById(R.id.home_top_topic_div_one);
        this.ixq = view.findViewById(R.id.home_top_topic_div_two);
        this.ixr = view.findViewById(R.id.home_card_top_divider_line);
        this.ixs = view.findViewById(R.id.home_card_bottom_divider_line);
        this.ixg.setOnClickListener(this);
        this.ixh.setOnClickListener(this);
        this.ixi.setOnClickListener(this);
        this.ixj.setOnClickListener(this);
        this.ixf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.ixu = str;
        this.ixv = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.ixt != null && com.baidu.tbadk.core.util.y.getItem(this.ixt.iBh, i) != null) {
            TiebaStatic.log(new ar(this.ixv).dR("obj_locate", String.valueOf(this.ixt.locate)).dR("obj_name", this.ixt.iBh.get(i).ePt));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.ixt.iBh.get(i).topicId), this.ixt.iBh.get(i).ePt, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ixf, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ixk, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ixl, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ixm, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ixn, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.ixo, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixp, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixq, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixr, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixs, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixg, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ixh, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ixi, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ixj, R.drawable.card_topic_click_selector);
            f(this.ixk, 0);
            f(this.ixl, 1);
            f(this.ixm, 2);
            f(this.ixn, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.iBg) || com.baidu.tbadk.core.util.y.getCount(nVar.iBh) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.ixt = nVar;
        this.ixr.setVisibility(this.ixt.iBe ? 0 : 8);
        showBottomLine(this.ixt.iBf);
        this.eHx.setText(this.ixt.iBg.trim());
        e(this.ixk, 0);
        e(this.ixl, 1);
        e(this.ixm, 2);
        e(this.ixn, 3);
        f(this.ixk, 0);
        f(this.ixl, 1);
        f(this.ixm, 2);
        f(this.ixn, 3);
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.ixt.iBh.get(i);
        if (!StringUtils.isNull(mVar.ePt)) {
            textView.setText(mVar.ePt.trim());
        }
    }

    private void f(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.ixt != null && com.baidu.tbadk.core.util.y.getCount(this.ixt.iBh) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.y.getItem(this.ixt.iBh, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.ixs.setVisibility(0);
        } else {
            this.ixs.setVisibility(8);
        }
    }

    public void xb(int i) {
        ViewGroup.LayoutParams layoutParams = this.ixr.getLayoutParams();
        layoutParams.height = i;
        this.ixr.setLayoutParams(layoutParams);
    }
}
