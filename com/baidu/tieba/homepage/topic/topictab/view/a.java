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
public class a extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topictab.b.a> {
    private static final int Ky = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout fHv;
    private TbImageView fXv;
    private CellTopicLinearLayout hhy;
    private TextView hia;
    private TextView hib;
    private RelativeLayout hic;
    private View hie;
    private TopicPkView hif;
    private ThreadGodReplyLayout hig;
    private View hih;
    private TextView hii;
    private View hij;
    private LinearLayout.LayoutParams hik;
    private com.baidu.tieba.homepage.topic.topictab.b.a hil;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hhy = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.fHv = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.hia = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.hib = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.hic = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.fXv = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.hie = view.findViewById(R.id.cell_topic_img_placeholder);
        this.hif = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.hig = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.hih = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.hii = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.hij = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.fXv.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.fXv.setLayoutParams(layoutParams);
        this.fXv.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fXv.setConrers(15);
        this.fXv.setPlaceHolder(3);
        this.hik = (LinearLayout.LayoutParams) this.fHv.getLayoutParams();
        this.hhy.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.hif.onChangeSkinType();
        this.hig.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hia, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hib, (int) R.color.cp_cont_d);
            am.setViewTextColor(this.mDescView, (int) R.color.cp_cont_b);
            this.fXv.setIsNight(this.mSkinType == 1);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.cell_topic_card_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topictab.b.a aVar) {
        if (aVar != null) {
            this.hil = aVar;
            if (aVar.from == 0) {
                this.hii.setVisibility(8);
                this.hia.setVisibility(0);
                this.hib.setVisibility(0);
                this.hia.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    am.setBackgroundResource(this.hia, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    am.setBackgroundResource(this.hia, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    am.setBackgroundResource(this.hia, R.drawable.topic_rank_three_bg);
                } else {
                    am.setBackgroundResource(this.hia, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                au.a(this.mDescView, aVar.cQE, (int) R.string.check_detail, (int) R.dimen.tbds17, 2, Ky, true);
                if (aVar.cQD == 0) {
                    this.hib.setText("NEW");
                } else {
                    this.hib.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), aq.numberUniformFormat(aVar.cQD)));
                }
                if (aVar.hhL == null) {
                    this.hig.setVisibility(8);
                } else {
                    this.hig.setVisibility(0);
                    this.hig.setData(aVar.hhL);
                }
            } else {
                this.hii.setVisibility(0);
                this.hia.setVisibility(8);
                this.hib.setVisibility(8);
                this.hig.setVisibility(8);
                this.hik.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.cQE)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.cQE);
                }
                am.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.cQC;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.hgp)) {
                this.hic.setVisibility(8);
                this.hif.setUserColor(R.color.cp_cont_d);
            } else {
                this.hic.setVisibility(0);
                this.fXv.setPlaceHolder(3);
                this.fXv.startLoad(aVar.hgp, 10, false);
                this.hif.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.hhK == null) {
                this.hie.setVisibility(8);
                this.hif.setVisibility(8);
                this.hij.setVisibility(8);
                return;
            }
            this.hie.setVisibility(0);
            this.hif.setVisibility(0);
            this.hif.setData(aVar.hhK);
            this.hij.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hil != null && this.hil.from != 1) {
            TiebaStatic.log(new an("c13351").s("topic_id", this.hil.topicId).X("obj_locate", this.hil.index));
        }
        if (this.hil != null && this.hil.from == 1) {
            TiebaStatic.log(new an("c13449").s("topic_id", this.hil.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.hil.topicId)));
    }

    public CellTopicLinearLayout bPE() {
        return this.hhy;
    }
}
