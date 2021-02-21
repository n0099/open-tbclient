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
    private TextView ixA;
    private TextView ixB;
    private View ixC;
    private View ixD;
    private View ixE;
    private View ixF;
    private View ixG;
    private com.baidu.tieba.card.data.n ixH;
    private String ixI;
    private String ixJ;
    private TextView ixt;
    private LinearLayout ixu;
    private LinearLayout ixv;
    private LinearLayout ixw;
    private LinearLayout ixx;
    private TextView ixy;
    private TextView ixz;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.eHx = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.ixt = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.ixu = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.ixv = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.ixw = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.ixx = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.ixy = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.ixz = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.ixA = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.ixB = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.ixC = view.findViewById(R.id.home_top_div);
        this.ixD = view.findViewById(R.id.home_top_topic_div_one);
        this.ixE = view.findViewById(R.id.home_top_topic_div_two);
        this.ixF = view.findViewById(R.id.home_card_top_divider_line);
        this.ixG = view.findViewById(R.id.home_card_bottom_divider_line);
        this.ixu.setOnClickListener(this);
        this.ixv.setOnClickListener(this);
        this.ixw.setOnClickListener(this);
        this.ixx.setOnClickListener(this);
        this.ixt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.ixI = str;
        this.ixJ = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.ixH != null && com.baidu.tbadk.core.util.y.getItem(this.ixH.iBv, i) != null) {
            TiebaStatic.log(new ar(this.ixJ).dR("obj_locate", String.valueOf(this.ixH.locate)).dR("obj_name", this.ixH.iBv.get(i).ePt));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.ixH.iBv.get(i).topicId), this.ixH.iBv.get(i).ePt, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.eHx, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ixt, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ixy, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ixz, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ixA, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ixB, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.ixC, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixD, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixE, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixF, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixG, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ixu, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ixv, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ixw, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ixx, R.drawable.card_topic_click_selector);
            f(this.ixy, 0);
            f(this.ixz, 1);
            f(this.ixA, 2);
            f(this.ixB, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.iBu) || com.baidu.tbadk.core.util.y.getCount(nVar.iBv) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.ixH = nVar;
        this.ixF.setVisibility(this.ixH.iBs ? 0 : 8);
        showBottomLine(this.ixH.iBt);
        this.eHx.setText(this.ixH.iBu.trim());
        e(this.ixy, 0);
        e(this.ixz, 1);
        e(this.ixA, 2);
        e(this.ixB, 3);
        f(this.ixy, 0);
        f(this.ixz, 1);
        f(this.ixA, 2);
        f(this.ixB, 3);
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.ixH.iBv.get(i);
        if (!StringUtils.isNull(mVar.ePt)) {
            textView.setText(mVar.ePt.trim());
        }
    }

    private void f(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.ixH != null && com.baidu.tbadk.core.util.y.getCount(this.ixH.iBv) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.y.getItem(this.ixH.iBv, i)) != null) {
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
            this.ixG.setVisibility(0);
        } else {
            this.ixG.setVisibility(8);
        }
    }

    public void xb(int i) {
        ViewGroup.LayoutParams layoutParams = this.ixF.getLayoutParams();
        layoutParams.height = i;
        this.ixF.setLayoutParams(layoutParams);
    }
}
