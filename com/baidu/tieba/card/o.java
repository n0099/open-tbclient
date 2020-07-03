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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class o extends b<com.baidu.tieba.card.data.n> {
    private TextView dDu;
    private TextView gRA;
    private TextView gRB;
    private TextView gRC;
    private TextView gRD;
    private View gRE;
    private View gRF;
    private View gRG;
    private View gRH;
    private View gRI;
    private com.baidu.tieba.card.data.n gRJ;
    private String gRK;
    private String gRL;
    private TextView gRv;
    private LinearLayout gRw;
    private LinearLayout gRx;
    private LinearLayout gRy;
    private LinearLayout gRz;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dDu = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.gRv = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.gRw = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.gRx = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.gRy = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.gRz = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.gRA = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.gRB = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.gRC = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.gRD = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.gRE = view.findViewById(R.id.home_top_div);
        this.gRF = view.findViewById(R.id.home_top_topic_div_one);
        this.gRG = view.findViewById(R.id.home_top_topic_div_two);
        this.gRH = view.findViewById(R.id.home_card_top_divider_line);
        this.gRI = view.findViewById(R.id.home_card_bottom_divider_line);
        this.gRw.setOnClickListener(this);
        this.gRx.setOnClickListener(this);
        this.gRy.setOnClickListener(this);
        this.gRz.setOnClickListener(this);
        this.gRv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.l(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.gRK = str;
        this.gRL = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.gRJ != null && com.baidu.tbadk.core.util.w.getItem(this.gRJ.gVe, i) != null) {
            TiebaStatic.log(new ao(this.gRL).dk("obj_locate", String.valueOf(this.gRJ.locate)).dk("obj_name", this.gRJ.gVe.get(i).dKw));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.l(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.gRJ.gVe.get(i).topicId), this.gRJ.gVe.get(i).dKw, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            an.setViewTextColor(this.dDu, R.color.cp_cont_d, 1);
            an.setViewTextColor(this.gRv, R.color.cp_cont_d, 1);
            an.setViewTextColor(this.gRA, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.gRB, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.gRC, R.color.cp_cont_b, 1);
            an.setViewTextColor(this.gRD, R.color.cp_cont_b, 1);
            an.setBackgroundResource(this.gRE, R.color.cp_bg_line_c);
            an.setBackgroundResource(this.gRF, R.color.cp_bg_line_c);
            an.setBackgroundResource(this.gRG, R.color.cp_bg_line_c);
            an.setBackgroundResource(this.gRH, R.color.cp_bg_line_c);
            an.setBackgroundResource(this.gRI, R.color.cp_bg_line_c);
            an.setBackgroundResource(this.gRw, R.drawable.card_topic_click_selector);
            an.setBackgroundResource(this.gRx, R.drawable.card_topic_click_selector);
            an.setBackgroundResource(this.gRy, R.drawable.card_topic_click_selector);
            an.setBackgroundResource(this.gRz, R.drawable.card_topic_click_selector);
            e(this.gRA, 0);
            e(this.gRB, 1);
            e(this.gRC, 2);
            e(this.gRD, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.gVd) || com.baidu.tbadk.core.util.w.getCount(nVar.gVe) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.gRJ = nVar;
        this.gRH.setVisibility(this.gRJ.gVb ? 0 : 8);
        showBottomLine(this.gRJ.gVc);
        this.dDu.setText(this.gRJ.gVd.trim());
        d(this.gRA, 0);
        d(this.gRB, 1);
        d(this.gRC, 2);
        d(this.gRD, 3);
        e(this.gRA, 0);
        e(this.gRB, 1);
        e(this.gRC, 2);
        e(this.gRD, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.gRJ.gVe.get(i);
        if (!StringUtils.isNull(mVar.dKw)) {
            textView.setText(mVar.dKw.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.gRJ != null && com.baidu.tbadk.core.util.w.getCount(this.gRJ.gVe) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.w.getItem(this.gRJ.gVe, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, an.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.gRI.setVisibility(0);
        } else {
            this.gRI.setVisibility(8);
        }
    }

    public void sO(int i) {
        ViewGroup.LayoutParams layoutParams = this.gRH.getLayoutParams();
        layoutParams.height = i;
        this.gRH.setLayoutParams(layoutParams);
    }
}
