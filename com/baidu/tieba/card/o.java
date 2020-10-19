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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class o extends b<com.baidu.tieba.card.data.o> {
    private TextView egP;
    private TextView hFU;
    private LinearLayout hFV;
    private LinearLayout hFW;
    private LinearLayout hFX;
    private LinearLayout hFY;
    private TextView hFZ;
    private TextView hGa;
    private TextView hGb;
    private TextView hGc;
    private View hGd;
    private View hGe;
    private View hGf;
    private View hGg;
    private View hGh;
    private com.baidu.tieba.card.data.o hGi;
    private String hGj;
    private String hGk;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.egP = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.hFU = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.hFV = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.hFW = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.hFX = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.hFY = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.hFZ = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.hGa = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.hGb = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.hGc = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.hGd = view.findViewById(R.id.home_top_div);
        this.hGe = view.findViewById(R.id.home_top_topic_div_one);
        this.hGf = view.findViewById(R.id.home_top_topic_div_two);
        this.hGg = view.findViewById(R.id.home_card_top_divider_line);
        this.hGh = view.findViewById(R.id.home_card_bottom_divider_line);
        this.hFV.setOnClickListener(this);
        this.hFW.setOnClickListener(this);
        this.hFX.setOnClickListener(this);
        this.hFY.setOnClickListener(this);
        this.hFU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.hGj = str;
        this.hGk = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.hGi != null && com.baidu.tbadk.core.util.y.getItem(this.hGi.hJC, i) != null) {
            TiebaStatic.log(new aq(this.hGk).dK("obj_locate", String.valueOf(this.hGi.locate)).dK("obj_name", this.hGi.hJC.get(i).eou));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.hGi.hJC.get(i).topicId), this.hGi.hJC.get(i).eou, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            ap.setViewTextColor(this.egP, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hFU, R.color.cp_cont_d, 1);
            ap.setViewTextColor(this.hFZ, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hGa, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hGb, R.color.cp_cont_b, 1);
            ap.setViewTextColor(this.hGc, R.color.cp_cont_b, 1);
            ap.setBackgroundResource(this.hGd, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hGe, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hGf, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hGg, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hGh, R.color.cp_bg_line_c);
            ap.setBackgroundResource(this.hFV, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hFW, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hFX, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.hFY, R.drawable.card_topic_click_selector);
            e(this.hFZ, 0);
            e(this.hGa, 1);
            e(this.hGb, 2);
            e(this.hGc, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.o oVar) {
        if (oVar == null || StringUtils.isNull(oVar.hJB) || com.baidu.tbadk.core.util.y.getCount(oVar.hJC) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.hGi = oVar;
        this.hGg.setVisibility(this.hGi.hJz ? 0 : 8);
        showBottomLine(this.hGi.hJA);
        this.egP.setText(this.hGi.hJB.trim());
        d(this.hFZ, 0);
        d(this.hGa, 1);
        d(this.hGb, 2);
        d(this.hGc, 3);
        e(this.hFZ, 0);
        e(this.hGa, 1);
        e(this.hGb, 2);
        e(this.hGc, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar = this.hGi.hJC.get(i);
        if (!StringUtils.isNull(nVar.eou)) {
            textView.setText(nVar.eou.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.n nVar;
        if (this.hGi != null && com.baidu.tbadk.core.util.y.getCount(this.hGi.hJC) >= 4 && (nVar = (com.baidu.tieba.card.data.n) com.baidu.tbadk.core.util.y.getItem(this.hGi.hJC, i)) != null) {
            switch (nVar.tag) {
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
            this.hGh.setVisibility(0);
        } else {
            this.hGh.setVisibility(8);
        }
    }

    public void wA(int i) {
        ViewGroup.LayoutParams layoutParams = this.hGg.getLayoutParams();
        layoutParams.height = i;
        this.hGg.setLayoutParams(layoutParams);
    }
}
