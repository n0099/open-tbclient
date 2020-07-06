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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int aey = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout gOK;
    private TbImageView hgp;
    private com.baidu.tieba.homepage.topic.topictab.b.a iAa;
    private TextView izQ;
    private TextView izR;
    private RelativeLayout izS;
    private View izT;
    private TopicPkView izU;
    private ThreadGodReplyLayout izV;
    private View izW;
    private TextView izX;
    private View izY;
    private LinearLayout.LayoutParams izZ;
    private CellTopicLinearLayout izq;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.izq = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.gOK = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.izQ = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.izR = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.izS = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.hgp = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.izT = view.findViewById(R.id.cell_topic_img_placeholder);
        this.izU = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.izV = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.izW = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.izX = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.izY = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.hgp.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.hgp.setLayoutParams(layoutParams);
        this.hgp.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.hgp.setConrers(15);
        this.hgp.setPlaceHolder(3);
        this.izZ = (LinearLayout.LayoutParams) this.gOK.getLayoutParams();
        this.izq.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.izU.onChangeSkinType();
        this.izV.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            an.setViewTextColor(this.izQ, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.izR, (int) R.color.cp_cont_d);
            an.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.hgp.setIsNight(this.mSkinType == 1);
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
            this.iAa = aVar;
            if (aVar.from == 0) {
                this.izX.setVisibility(8);
                this.izQ.setVisibility(0);
                this.izR.setVisibility(0);
                this.izQ.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    an.setBackgroundResource(this.izQ, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    an.setBackgroundResource(this.izQ, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    an.setBackgroundResource(this.izQ, R.drawable.topic_rank_three_bg);
                } else {
                    an.setBackgroundResource(this.izQ, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                aw.a(this.mDescView, aVar.dKy, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, aey, true);
                if (aVar.dKx == 0) {
                    this.izR.setText("NEW");
                } else {
                    this.izR.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), ar.numberUniformFormat(aVar.dKx)));
                }
                if (aVar.izC == null) {
                    this.izV.setVisibility(8);
                } else {
                    this.izV.setVisibility(0);
                    this.izV.setData(aVar.izC);
                }
            } else {
                this.izX.setVisibility(0);
                this.izQ.setVisibility(8);
                this.izR.setVisibility(8);
                this.izV.setVisibility(8);
                this.izZ.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.dKy)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.dKy);
                }
                an.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.dKw;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.iyh)) {
                this.izS.setVisibility(8);
                this.izU.setUserColor(R.color.cp_cont_d);
            } else {
                this.izS.setVisibility(0);
                this.hgp.setPlaceHolder(3);
                this.hgp.startLoad(aVar.iyh, 10, false);
                this.izU.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.izB == null) {
                this.izT.setVisibility(8);
                this.izU.setVisibility(8);
                this.izY.setVisibility(8);
                return;
            }
            this.izT.setVisibility(0);
            this.izU.setVisibility(0);
            this.izU.setData(aVar.izB);
            this.izY.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iAa != null && this.iAa.from != 1) {
            TiebaStatic.log(new ao("c13351").s("topic_id", this.iAa.topicId).ag("obj_locate", this.iAa.index));
        }
        if (this.iAa != null && this.iAa.from == 1) {
            TiebaStatic.log(new ao("c13449").s("topic_id", this.iAa.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.iAa.topicId)));
    }

    public CellTopicLinearLayout ckQ() {
        return this.izq;
    }
}
