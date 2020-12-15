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
    private TextView ijN;
    private LinearLayout ijO;
    private LinearLayout ijP;
    private LinearLayout ijQ;
    private LinearLayout ijR;
    private TextView ijS;
    private TextView ijT;
    private TextView ijU;
    private TextView ijV;
    private View ijW;
    private View ijX;
    private View ijY;
    private View ijZ;
    private View ika;
    private com.baidu.tieba.card.data.n ikb;
    private String ikc;
    private String ikd;
    private View mRootView;

    public p(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        init(getView());
    }

    private void init(View view) {
        this.mRootView = view.findViewById(R.id.home_card_hot_topic_root_view);
        this.eAz = (TextView) view.findViewById(R.id.home_card_topic_title);
        this.ijN = (TextView) view.findViewById(R.id.home_card_topic_more);
        this.ijO = (LinearLayout) view.findViewById(R.id.home_card_topic_group_one);
        this.ijP = (LinearLayout) view.findViewById(R.id.home_card_topic_group_two);
        this.ijQ = (LinearLayout) view.findViewById(R.id.home_card_topic_group_three);
        this.ijR = (LinearLayout) view.findViewById(R.id.home_card_topic_group_four);
        this.ijS = (TextView) view.findViewById(R.id.home_card_topic_one);
        this.ijT = (TextView) view.findViewById(R.id.home_card_topic_two);
        this.ijU = (TextView) view.findViewById(R.id.home_card_topic_three);
        this.ijV = (TextView) view.findViewById(R.id.home_card_topic_four);
        this.ijW = view.findViewById(R.id.home_top_div);
        this.ijX = view.findViewById(R.id.home_top_topic_div_one);
        this.ijY = view.findViewById(R.id.home_top_topic_div_two);
        this.ijZ = view.findViewById(R.id.home_card_top_divider_line);
        this.ika = view.findViewById(R.id.home_card_bottom_divider_line);
        this.ijO.setOnClickListener(this);
        this.ijP.setOnClickListener(this);
        this.ijQ.setOnClickListener(this);
        this.ijR.setOnClickListener(this);
        this.ijN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.card.p.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (!com.baidu.tbadk.plugins.b.k(p.this.getTbPageContext())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotRanklistActivityConfig(p.this.getTbPageContext().getPageActivity()).createNormalConfig("homepage", "all")));
                }
            }
        });
    }

    public void setStatKey(String str, String str2) {
        this.ikc = str;
        this.ikd = str2;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.home_card_hot_topic_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i = com.baidu.adp.lib.f.b.toInt((String) view.getTag(), -1);
        if (this.ikb != null && com.baidu.tbadk.core.util.y.getItem(this.ikb.inK, i) != null) {
            TiebaStatic.log(new ar(this.ikd).dY("obj_locate", String.valueOf(this.ikb.locate)).dY("obj_name", this.ikb.inK.get(i).eIa));
            if (i >= 0 && !com.baidu.tbadk.plugins.b.k(getTbPageContext())) {
                getTbPageContext().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new HotTopicActivityConfig(getTbPageContext().getPageActivity()).createNormalConfig(String.valueOf(this.ikb.inK.get(i).topicId), this.ikb.inK.get(i).eIa, "")));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.mRootView, R.color.CAM_X0201);
            ap.setViewTextColor(this.eAz, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ijN, R.color.CAM_X0109, 1);
            ap.setViewTextColor(this.ijS, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ijT, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ijU, R.color.CAM_X0105, 1);
            ap.setViewTextColor(this.ijV, R.color.CAM_X0105, 1);
            ap.setBackgroundResource(this.ijW, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijX, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijY, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijZ, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ika, R.color.CAM_X0204);
            ap.setBackgroundResource(this.ijO, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ijP, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ijQ, R.drawable.card_topic_click_selector);
            ap.setBackgroundResource(this.ijR, R.drawable.card_topic_click_selector);
            e(this.ijS, 0);
            e(this.ijT, 1);
            e(this.ijU, 2);
            e(this.ijV, 3);
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.data.n nVar) {
        if (nVar == null || StringUtils.isNull(nVar.inJ) || com.baidu.tbadk.core.util.y.getCount(nVar.inK) < 4) {
            this.mRootView.setVisibility(8);
            return;
        }
        if (this.mRootView.getVisibility() != 0) {
            this.mRootView.setVisibility(0);
        }
        this.ikb = nVar;
        this.ijZ.setVisibility(this.ikb.inH ? 0 : 8);
        showBottomLine(this.ikb.inI);
        this.eAz.setText(this.ikb.inJ.trim());
        d(this.ijS, 0);
        d(this.ijT, 1);
        d(this.ijU, 2);
        d(this.ijV, 3);
        e(this.ijS, 0);
        e(this.ijT, 1);
        e(this.ijU, 2);
        e(this.ijV, 3);
    }

    private void d(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar = this.ikb.inK.get(i);
        if (!StringUtils.isNull(mVar.eIa)) {
            textView.setText(mVar.eIa.trim());
        }
    }

    private void e(TextView textView, int i) {
        com.baidu.tieba.card.data.m mVar;
        if (this.ikb != null && com.baidu.tbadk.core.util.y.getCount(this.ikb.inK) >= 4 && (mVar = (com.baidu.tieba.card.data.m) com.baidu.tbadk.core.util.y.getItem(this.ikb.inK, i)) != null) {
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
            this.ika.setVisibility(0);
        } else {
            this.ika.setVisibility(8);
        }
    }

    public void yk(int i) {
        ViewGroup.LayoutParams layoutParams = this.ijZ.getLayoutParams();
        layoutParams.height = i;
        this.ijZ.setLayoutParams(layoutParams);
    }
}
