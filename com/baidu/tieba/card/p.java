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
/* loaded from: classes22.dex */
public class p extends b<com.baidu.tieba.card.data.n> {
    private TextView eAz;
    private TextView ijL;
    private LinearLayout ijM;
    private LinearLayout ijN;
    private LinearLayout ijO;
    private LinearLayout ijP;
    private TextView ijQ;
    private TextView ijR;
    private TextView ijS;
    private TextView ijT;
    private View ijU;
    private View ijV;
    private View ijW;
    private View ijX;
    private View ijY;
    private com.baidu.tieba.card.data.n ijZ;
    private String ika;
    private String ikb;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.eAz = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.ijL = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.ijM = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.ijN = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.ijO = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.ijP = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.ijQ = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.ijR = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.ijS = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.ijT = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.ijU = view.findViewById(R.id.home_top_div);
        this.ijV = view.findViewById(R.id.home_top_topic_div_one);
        this.ijW = view.findViewById(R.id.home_top_topic_div_two);
        this.ijX = view.findViewById(R.id.home_card_top_divider_line);
        this.ijY = view.findViewById(R.id.home_card_bottom_divider_line);
        this.ijM.setOnClickListener(this);
        this.ijN.setOnClickListener(this);
        this.ijO.setOnClickListener(this);
        this.ijP.setOnClickListener(this);
        this.ijL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.ika = str;
        this.ikb = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.ijZ != null && com.baidu.tbadk.core.util.y.getItem(this.ijZ.inI, i) != null) {
            TiebaStatic.log(new ar(this.ikb).dY("obj_locate", String.valueOf(this.ijZ.locate)).dY("obj_name", this.ijZ.inI.get(i).eIa));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.ijZ.inI.get(i).topicId), this.ijZ.inI.get(i).eIa, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ijL, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ijQ, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ijR, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ijS, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ijT, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.ijU, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijV, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijW, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijX, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijY, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijM, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ijN, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ijO, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ijP, R.drawable.card_topic_click_selector);
            e(this.ijQ, 0);
            e(this.ijR, 1);
            e(this.ijS, 2);
            e(this.ijT, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.inH) || com.baidu.tbadk.core.util.y.getCount(nVar.inI) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.ijZ = nVar;
        this.ijX.setVisibility(this.ijZ.inF ? 0 : 8);
        showBottomLine(this.ijZ.inG);
        this.eAz.setText(this.ijZ.inH.trim());
        d(this.ijQ, 0);
        d(this.ijR, 1);
        d(this.ijS, 2);
        d(this.ijT, 3);
        e(this.ijQ, 0);
        e(this.ijR, 1);
        e(this.ijS, 2);
        e(this.ijT, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.ijZ.inI.get(i);
        if (!StringUtils.isNull(mVar.eIa)) {
            textView.setText(mVar.eIa.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.ijZ != null && com.baidu.tbadk.core.util.y.getCount(this.ijZ.inI) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.y.getItem(this.ijZ.inI, i)) != null) {
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
            this.ijY.setVisibility(0);
        } else {
            this.ijY.setVisibility(8);
        }
    }

    public void yk(int i) {
        ViewGroup.LayoutParams layoutParams = this.ijX.getLayoutParams();
        layoutParams.height = i;
        this.ijX.setLayoutParams(layoutParams);
    }
}
