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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class o extends b<com.baidu.tieba.card.data.n> {
    private TextView eFr;
    private TextView irB;
    private LinearLayout irC;
    private LinearLayout irD;
    private LinearLayout irE;
    private LinearLayout irF;
    private TextView irG;
    private TextView irH;
    private TextView irI;
    private TextView irJ;
    private View irK;
    private View irL;
    private View irM;
    private View irN;
    private View irO;
    private com.baidu.tieba.card.data.n irP;
    private String irQ;
    private String irR;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.eFr = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.irB = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.irC = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.irD = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.irE = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.irF = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.irG = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.irH = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.irI = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.irJ = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.irK = view.findViewById(R.id.home_top_div);
        this.irL = view.findViewById(R.id.home_top_topic_div_one);
        this.irM = view.findViewById(R.id.home_top_topic_div_two);
        this.irN = view.findViewById(R.id.home_card_top_divider_line);
        this.irO = view.findViewById(R.id.home_card_bottom_divider_line);
        this.irC.setOnClickListener(this);
        this.irD.setOnClickListener(this);
        this.irE.setOnClickListener(this);
        this.irF.setOnClickListener(this);
        this.irB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.irQ = str;
        this.irR = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.irP != null && com.baidu.tbadk.core.util.x.getItem(this.irP.ivx, i) != null) {
            TiebaStatic.log(new aq(this.irR).dW("obj_locate", String.valueOf(this.irP.locate)).dW("obj_name", this.irP.ivx.get(i).eNh));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.irP.ivx.get(i).topicId), this.irP.ivx.get(i).eNh, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ao.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ao.setViewTextColor(this.eFr, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.irB, R.color.CAM_X0109, 1);
            ao.setViewTextColor(this.irG, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.irH, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.irI, R.color.CAM_X0105, 1);
            ao.setViewTextColor(this.irJ, R.color.CAM_X0105, 1);
            ao.setBackgroundResource(this.irK, R.color.CAM_X0204);
            ao.setBackgroundResource(this.irL, R.color.CAM_X0204);
            ao.setBackgroundResource(this.irM, R.color.CAM_X0204);
            ao.setBackgroundResource(this.irN, R.color.CAM_X0204);
            ao.setBackgroundResource(this.irO, R.color.CAM_X0204);
            ao.setBackgroundResource(this.irC, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.irD, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.irE, R.drawable.card_topic_click_selector);
            ao.setBackgroundResource(this.irF, R.drawable.card_topic_click_selector);
            e(this.irG, 0);
            e(this.irH, 1);
            e(this.irI, 2);
            e(this.irJ, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.ivw) || com.baidu.tbadk.core.util.x.getCount(nVar.ivx) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.irP = nVar;
        this.irN.setVisibility(this.irP.ivu ? 0 : 8);
        showBottomLine(this.irP.ivv);
        this.eFr.setText(this.irP.ivw.trim());
        d(this.irG, 0);
        d(this.irH, 1);
        d(this.irI, 2);
        d(this.irJ, 3);
        e(this.irG, 0);
        e(this.irH, 1);
        e(this.irI, 2);
        e(this.irJ, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.irP.ivx.get(i);
        if (!StringUtils.isNull(mVar.eNh)) {
            textView.setText(mVar.eNh.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.irP != null && com.baidu.tbadk.core.util.x.getCount(this.irP.ivx) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.x.getItem(this.irP.ivx, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.irO.setVisibility(0);
        } else {
            this.irO.setVisibility(8);
        }
    }

    public void wR(int i) {
        ViewGroup.LayoutParams layoutParams = this.irN.getLayoutParams();
        layoutParams.height = i;
        this.irN.setLayoutParams(layoutParams);
    }
}
