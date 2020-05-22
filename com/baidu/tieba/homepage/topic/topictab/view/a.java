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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class a extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int adT = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout gBJ;
    private TbImageView gTv;
    private CellTopicLinearLayout ihy;
    private TextView iia;
    private TextView iib;
    private RelativeLayout iic;
    private View iid;
    private TopicPkView iie;
    private ThreadGodReplyLayout iif;
    private View iig;
    private TextView iih;
    private View iii;
    private LinearLayout.LayoutParams iij;
    private com.baidu.tieba.homepage.topic.topictab.b.a iik;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ihy = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.gBJ = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.iia = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.iib = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.iic = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.gTv = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.iid = view.findViewById(R.id.cell_topic_img_placeholder);
        this.iie = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.iif = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.iig = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.iih = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.iii = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.gTv.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.gTv.setLayoutParams(layoutParams);
        this.gTv.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.gTv.setConrers(15);
        this.gTv.setPlaceHolder(3);
        this.iij = (LinearLayout.LayoutParams) this.gBJ.getLayoutParams();
        this.ihy.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.iie.onChangeSkinType();
        this.iif.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.iia, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.iib, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.gTv.setIsNight(this.mSkinType == 1);
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
            this.iik = aVar;
            if (aVar.from == 0) {
                this.iih.setVisibility(8);
                this.iia.setVisibility(0);
                this.iib.setVisibility(0);
                this.iia.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.iia, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.iia, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.iia, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.iia, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.dDY, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, adT, true);
                if (aVar.dDX == 0) {
                    this.iib.setText("NEW");
                } else {
                    this.iib.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.dDX)));
                }
                if (aVar.ihL == null) {
                    this.iif.setVisibility(8);
                } else {
                    this.iif.setVisibility(0);
                    this.iif.setData(aVar.ihL);
                }
            } else {
                this.iih.setVisibility(0);
                this.iia.setVisibility(8);
                this.iib.setVisibility(8);
                this.iif.setVisibility(8);
                this.iij.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.dDY)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.dDY);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.dDW;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.igp)) {
                this.iic.setVisibility(8);
                this.iie.setUserColor(R.color.cp_cont_d);
            } else {
                this.iic.setVisibility(0);
                this.gTv.setPlaceHolder(3);
                this.gTv.startLoad(aVar.igp, 10, false);
                this.iie.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.ihK == null) {
                this.iid.setVisibility(8);
                this.iie.setVisibility(8);
                this.iii.setVisibility(8);
                return;
            }
            this.iid.setVisibility(0);
            this.iie.setVisibility(0);
            this.iie.setData(aVar.ihK);
            this.iii.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iik != null && this.iik.from != 1) {
            TiebaStatic.log(new an("c13351").s("topic_id", this.iik.topicId).ag("obj_locate", this.iik.index));
        }
        if (this.iik != null && this.iik.from == 1) {
            TiebaStatic.log(new an("c13449").s("topic_id", this.iik.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.iik.topicId)));
    }

    public CellTopicLinearLayout cgU() {
        return this.ihy;
    }
}
