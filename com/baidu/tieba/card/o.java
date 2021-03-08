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
    private TextView eIY;
    private TextView izc;
    private LinearLayout izd;
    private LinearLayout ize;
    private LinearLayout izf;
    private LinearLayout izg;
    private TextView izh;
    private TextView izi;
    private TextView izj;
    private TextView izk;
    private View izl;
    private View izm;
    private View izn;
    private View izo;
    private View izp;
    private com.baidu.tieba.card.data.n izq;
    private String izr;
    private String izs;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.eIY = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.izc = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.izd = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.ize = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.izf = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.izg = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.izh = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.izi = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.izj = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.izk = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.izl = view.findViewById(R.id.home_top_div);
        this.izm = view.findViewById(R.id.home_top_topic_div_one);
        this.izn = view.findViewById(R.id.home_top_topic_div_two);
        this.izo = view.findViewById(R.id.home_card_top_divider_line);
        this.izp = view.findViewById(R.id.home_card_bottom_divider_line);
        this.izd.setOnClickListener(this);
        this.ize.setOnClickListener(this);
        this.izf.setOnClickListener(this);
        this.izg.setOnClickListener(this);
        this.izc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.izr = str;
        this.izs = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.izq != null && com.baidu.tbadk.core.util.y.getItem(this.izq.iDe, i) != null) {
            TiebaStatic.log(new ar(this.izs).dR("obj_locate", String.valueOf(this.izq.locate)).dR("obj_name", this.izq.iDe.get(i).eQU));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.izq.iDe.get(i).topicId), this.izq.iDe.get(i).eQU, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.eIY, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.izc, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.izh, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.izi, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.izj, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.izk, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.izl, R.color.CAM_X0204);
            ap.setBackgroundResource(this.izm, R.color.CAM_X0204);
            ap.setBackgroundResource(this.izn, R.color.CAM_X0204);
            ap.setBackgroundResource(this.izo, R.color.CAM_X0204);
            ap.setBackgroundResource(this.izp, R.color.CAM_X0204);
            ap.setBackgroundResource(this.izd, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ize, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.izf, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.izg, R.drawable.card_topic_click_selector);
            f(this.izh, 0);
            f(this.izi, 1);
            f(this.izj, 2);
            f(this.izk, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.iDd) || com.baidu.tbadk.core.util.y.getCount(nVar.iDe) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.izq = nVar;
        this.izo.setVisibility(this.izq.iDb ? 0 : 8);
        showBottomLine(this.izq.iDc);
        this.eIY.setText(this.izq.iDd.trim());
        e(this.izh, 0);
        e(this.izi, 1);
        e(this.izj, 2);
        e(this.izk, 3);
        f(this.izh, 0);
        f(this.izi, 1);
        f(this.izj, 2);
        f(this.izk, 3);
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.izq.iDe.get(i);
        if (!StringUtils.isNull(mVar.eQU)) {
            textView.setText(mVar.eQU.trim());
        }
    }

    private void f(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.izq != null && com.baidu.tbadk.core.util.y.getCount(this.izq.iDe) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.y.getItem(this.izq.iDe, i)) != null) {
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
            this.izp.setVisibility(0);
        } else {
            this.izp.setVisibility(8);
        }
    }

    public void xc(int i) {
        ViewGroup.LayoutParams layoutParams = this.izo.getLayoutParams();
        layoutParams.height = i;
        this.izo.setLayoutParams(layoutParams);
    }
}
