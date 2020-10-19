package com.baidu.tieba.homepage.topic.topictab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TopicDetailActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int agj = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout hDk;
    private TbImageView hUT;
    private TextView jsF;
    private TextView jsG;
    private RelativeLayout jsH;
    private View jsI;
    private TopicPkView jsJ;
    private ThreadGodReplyLayout jsK;
    private View jsL;
    private TextView jsM;
    private View jsN;
    private LinearLayout.LayoutParams jsO;
    private com.baidu.tieba.homepage.topic.topictab.b.a jsP;
    private CellTopicLinearLayout jsf;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jsf = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.hDk = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.jsF = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.jsG = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.jsH = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.hUT = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.jsI = view.findViewById(R.id.cell_topic_img_placeholder);
        this.jsJ = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.jsK = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.jsL = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.jsM = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.jsN = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.hUT.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hUT.setLayoutParams(layoutParams);
        this.hUT.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.hUT.setConrers(15);
        this.hUT.setPlaceHolder(3);
        this.jsO = (LinearLayout.LayoutParams) this.hDk.getLayoutParams();
        this.jsf.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.jsJ.onChangeSkinType();
        this.jsK.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jsF, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.jsG, R.color.cp_cont_d);
            ap.setViewTextColor(this.mDescView, R.color.cp_cont_b);
            this.hUT.setIsNight(this.mSkinType == 1);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.cell_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topictab.b.a aVar) {
        if (aVar != null) {
            this.jsP = aVar;
            if (aVar.from == 0) {
                this.jsM.setVisibility(8);
                this.jsF.setVisibility(0);
                this.jsG.setVisibility(0);
                this.jsF.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.jsF, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.jsF, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.jsF, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.jsF, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ay.a(this.mDescView, aVar.eow, R.string.check_detail, R.dimen.tbds17, 2, agj, true);
                if (aVar.eov == 0) {
                    this.jsG.setText("NEW");
                } else {
                    this.jsG.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), at.numberUniformFormat(aVar.eov)));
                }
                if (aVar.jsr == null) {
                    this.jsK.setVisibility(8);
                } else {
                    this.jsK.setVisibility(0);
                    this.jsK.setData(aVar.jsr);
                }
            } else {
                this.jsM.setVisibility(0);
                this.jsF.setVisibility(8);
                this.jsG.setVisibility(8);
                this.jsK.setVisibility(8);
                this.jsO.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.eow)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.eow);
                }
                ap.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.eou;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.jqW)) {
                this.jsH.setVisibility(8);
                this.jsJ.setUserColor(R.color.cp_cont_d);
            } else {
                this.jsH.setVisibility(0);
                this.hUT.setPlaceHolder(3);
                this.hUT.startLoad(aVar.jqW, 10, false);
                this.jsJ.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.jsq == null) {
                this.jsI.setVisibility(8);
                this.jsJ.setVisibility(8);
                this.jsN.setVisibility(8);
                return;
            }
            this.jsI.setVisibility(0);
            this.jsJ.setVisibility(0);
            this.jsJ.setData(aVar.jsq);
            this.jsN.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jsP != null && this.jsP.from != 1) {
            TiebaStatic.log(new aq("c13351").u("topic_id", this.jsP.topicId).aj("obj_locate", this.jsP.index));
        }
        if (this.jsP != null && this.jsP.from == 1) {
            TiebaStatic.log(new aq("c13449").u("topic_id", this.jsP.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.jsP.topicId)));
    }

    public CellTopicLinearLayout cGA() {
        return this.jsf;
    }
}
