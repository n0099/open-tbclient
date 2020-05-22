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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.n;
/* loaded from: classes9.dex */
public class o extends b<n> {
    private TextView dyo;
    private TextView gEA;
    private TextView gEB;
    private TextView gEC;
    private View gED;
    private View gEE;
    private View gEF;
    private View gEG;
    private View gEH;
    private n gEI;
    private String gEJ;
    private String gEK;
    private TextView gEu;
    private LinearLayout gEv;
    private LinearLayout gEw;
    private LinearLayout gEx;
    private LinearLayout gEy;
    private TextView gEz;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dyo = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.gEu = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.gEv = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.gEw = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.gEx = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.gEy = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.gEz = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.gEA = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.gEB = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.gEC = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.gED = view.findViewById(R.id.home_top_div);
        this.gEE = view.findViewById(R.id.home_top_topic_div_one);
        this.gEF = view.findViewById(R.id.home_top_topic_div_two);
        this.gEG = view.findViewById(R.id.home_card_top_divider_line);
        this.gEH = view.findViewById(R.id.home_card_bottom_divider_line);
        this.gEv.setOnClickListener(this);
        this.gEw.setOnClickListener(this);
        this.gEx.setOnClickListener(this);
        this.gEy.setOnClickListener(this);
        this.gEu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.i(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.gEJ = str;
        this.gEK = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.gEI != null && com.baidu.tbadk.core.util.v.getItem(this.gEI.gHT, i) != null) {
            TiebaStatic.log(new an(this.gEK).dh("obj_locate", String.valueOf(this.gEI.locate)).dh("obj_name", this.gEI.gHT.get(i).dDW));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.i(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.gEI.gHT.get(i).topicId), this.gEI.gHT.get(i).dDW, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dyo, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gEu, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gEz, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gEA, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gEB, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gEC, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.gED, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEE, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEF, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEG, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEH, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEv, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gEw, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gEx, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gEy, R.drawable.card_topic_click_selector);
            e(this.gEz, 0);
            e(this.gEA, 1);
            e(this.gEB, 2);
            e(this.gEC, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.gHS) || com.baidu.tbadk.core.util.v.getCount(nVar.gHT) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.gEI = nVar;
        this.gEG.setVisibility(this.gEI.gHQ ? 0 : 8);
        showBottomLine(this.gEI.gHR);
        this.dyo.setText(this.gEI.gHS.trim());
        d(this.gEz, 0);
        d(this.gEA, 1);
        d(this.gEB, 2);
        d(this.gEC, 3);
        e(this.gEz, 0);
        e(this.gEA, 1);
        e(this.gEB, 2);
        e(this.gEC, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.gEI.gHT.get(i);
        if (!StringUtils.isNull(mVar.dDW)) {
            textView.setText(mVar.dDW.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.gEI != null && com.baidu.tbadk.core.util.v.getCount(this.gEI.gHT) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.getItem(this.gEI.gHT, i)) != null) {
            switch (mVar.tag) {
                case 1:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_hottopic_new), (Drawable) null);
                    return;
                case 2:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_hottopic_hot), (Drawable) null);
                    return;
                case 3:
                    textView.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(R.drawable.icon_hottopic_tuijian), (Drawable) null);
                    return;
                default:
                    return;
            }
        }
    }

    public void showBottomLine(boolean z) {
        if (z) {
            this.gEH.setVisibility(0);
        } else {
            this.gEH.setVisibility(8);
        }
    }

    public void so(int i) {
        ViewGroup.LayoutParams layoutParams = this.gEG.getLayoutParams();
        layoutParams.height = i;
        this.gEG.setLayoutParams(layoutParams);
    }
}
