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
    private TextView gEF;
    private LinearLayout gEG;
    private LinearLayout gEH;
    private LinearLayout gEI;
    private LinearLayout gEJ;
    private TextView gEK;
    private TextView gEL;
    private TextView gEM;
    private TextView gEN;
    private View gEO;
    private View gEP;
    private View gEQ;
    private View gER;
    private View gES;
    private n gET;
    private String gEU;
    private String gEV;
    private View mRootView;

    public o(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.dyo = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.gEF = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.gEG = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.gEH = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.gEI = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.gEJ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.gEK = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.gEL = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.gEM = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.gEN = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.gEO = view.findViewById(R.id.home_top_div);
        this.gEP = view.findViewById(R.id.home_top_topic_div_one);
        this.gEQ = view.findViewById(R.id.home_top_topic_div_two);
        this.gER = view.findViewById(R.id.home_card_top_divider_line);
        this.gES = view.findViewById(R.id.home_card_bottom_divider_line);
        this.gEG.setOnClickListener(this);
        this.gEH.setOnClickListener(this);
        this.gEI.setOnClickListener(this);
        this.gEJ.setOnClickListener(this);
        this.gEF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.o.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.i(o.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(o.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", SchemeCollecter.CLASSIFY_ALL)));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.gEU = str;
        this.gEV = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.gET != null && com.baidu.tbadk.core.util.v.getItem(this.gET.gIe, i) != null) {
            TiebaStatic.log(new an(this.gEV).dh("obj_locate", String.valueOf(this.gET.locate)).dh("obj_name", this.gET.gIe.get(i).dDW));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.i(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.gET.gIe.get(i).topicId), this.gET.gIe.get(i).dDW, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.mRootView, R.color.cp_bg_line_d);
            am.setViewTextColor(this.dyo, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gEF, R.color.cp_cont_d, 1);
            am.setViewTextColor(this.gEK, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gEL, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gEM, R.color.cp_cont_b, 1);
            am.setViewTextColor(this.gEN, R.color.cp_cont_b, 1);
            am.setBackgroundResource(this.gEO, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEP, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEQ, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gER, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gES, R.color.cp_bg_line_c);
            am.setBackgroundResource(this.gEG, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gEH, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gEI, R.drawable.card_topic_click_selector);
            am.setBackgroundResource(this.gEJ, R.drawable.card_topic_click_selector);
            e(this.gEK, 0);
            e(this.gEL, 1);
            e(this.gEM, 2);
            e(this.gEN, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.gId) || com.baidu.tbadk.core.util.v.getCount(nVar.gIe) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.gET = nVar;
        this.gER.setVisibility(this.gET.gIb ? 0 : 8);
        showBottomLine(this.gET.gIc);
        this.dyo.setText(this.gET.gId.trim());
        d(this.gEK, 0);
        d(this.gEL, 1);
        d(this.gEM, 2);
        d(this.gEN, 3);
        e(this.gEK, 0);
        e(this.gEL, 1);
        e(this.gEM, 2);
        e(this.gEN, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.gET.gIe.get(i);
        if (!StringUtils.isNull(mVar.dDW)) {
            textView.setText(mVar.dDW.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.gET != null && com.baidu.tbadk.core.util.v.getCount(this.gET.gIe) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.v.getItem(this.gET.gIe, i)) != null) {
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
            this.gES.setVisibility(0);
        } else {
            this.gES.setVisibility(8);
        }
    }

    public void sq(int i) {
        ViewGroup.LayoutParams layoutParams = this.gER.getLayoutParams();
        layoutParams.height = i;
        this.gER.setLayoutParams(layoutParams);
    }
}
