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
    private static final int agk = l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2);
    private RelativeLayout hPG;
    private TbImageView iht;
    private CellTopicLinearLayout jEF;
    private TextView jFf;
    private TextView jFg;
    private RelativeLayout jFh;
    private View jFi;
    private TopicPkView jFj;
    private ThreadGodReplyLayout jFk;
    private View jFl;
    private TextView jFm;
    private View jFn;
    private LinearLayout.LayoutParams jFo;
    private com.baidu.tieba.homepage.topic.topictab.b.a jFp;
    private TextView mDescView;
    private int mSkinType;
    private TextView mTitleView;

    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jEF = (CellTopicLinearLayout) view.findViewById(R.id.cell_topic_root);
        this.hPG = (RelativeLayout) view.findViewById(R.id.cell_topic_top_layout);
        this.jFf = (TextView) view.findViewById(R.id.cell_topic_index);
        this.mTitleView = (TextView) view.findViewById(R.id.cell_topic_title);
        this.jFg = (TextView) view.findViewById(R.id.cell_topic_partake);
        this.mDescView = (TextView) view.findViewById(R.id.cell_topic_des);
        this.jFh = (RelativeLayout) view.findViewById(R.id.cell_topic_img_layout);
        this.iht = (TbImageView) view.findViewById(R.id.cell_topic_img);
        this.jFi = view.findViewById(R.id.cell_topic_img_placeholder);
        this.jFj = (TopicPkView) view.findViewById(R.id.cell_topic_pk);
        this.jFk = (ThreadGodReplyLayout) view.findViewById(R.id.cell_topic_god_reply);
        this.jFl = view.findViewById(R.id.cell_topic_bottom_placeholder);
        this.jFm = (TextView) view.findViewById(R.id.cell_topic_icon);
        this.jFn = view.findViewById(R.id.cell_topic_img_mask);
        ViewGroup.LayoutParams layoutParams = this.iht.getLayoutParams();
        layoutParams.height = ((l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88)) * 9) / 16;
        this.iht.setLayoutParams(layoutParams);
        this.iht.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.iht.setConrers(15);
        this.iht.setPlaceHolder(3);
        this.jFo = (LinearLayout.LayoutParams) this.hPG.getLayoutParams();
        this.jEF.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.jFj.onChangeSkinType();
        this.jFk.onChangeSkinType();
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jFf, R.color.cp_cont_a);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_b);
            ap.setViewTextColor(this.jFg, R.color.cp_cont_d);
            ap.setViewTextColor(this.mDescView, R.color.cp_cont_b);
            this.iht.setIsNight(this.mSkinType == 1);
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
            this.jFp = aVar;
            if (aVar.from == 0) {
                this.jFm.setVisibility(8);
                this.jFf.setVisibility(0);
                this.jFg.setVisibility(0);
                this.jFf.setText(String.valueOf(aVar.index));
                if (aVar.index == 1) {
                    ap.setBackgroundResource(this.jFf, R.drawable.topic_rank_one_bg);
                } else if (aVar.index == 2) {
                    ap.setBackgroundResource(this.jFf, R.drawable.topic_rank_two_bg);
                } else if (aVar.index == 3) {
                    ap.setBackgroundResource(this.jFf, R.drawable.topic_rank_three_bg);
                } else {
                    ap.setBackgroundResource(this.jFf, R.drawable.topic_rank_other_bg);
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams.addRule(1, R.id.cell_topic_index);
                layoutParams.setMargins(dimens, 0, dimens, 0);
                ay.a(this.mDescView, aVar.ewT, R.string.check_detail, R.dimen.tbds17, 2, agk, true);
                if (aVar.ewS == 0) {
                    this.jFg.setText("NEW");
                } else {
                    this.jFg.setText(String.format(this.mTbPageContext.getString(R.string.topic_partake_default), at.numberUniformFormat(aVar.ewS)));
                }
                if (aVar.jER == null) {
                    this.jFk.setVisibility(8);
                } else {
                    this.jFk.setVisibility(0);
                    this.jFk.setData(aVar.jER);
                }
            } else {
                this.jFm.setVisibility(0);
                this.jFf.setVisibility(8);
                this.jFg.setVisibility(8);
                this.jFk.setVisibility(8);
                this.jFo.setMargins(0, l.getDimens(getContext(), R.dimen.tbds44), 0, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
                int dimens2 = l.getDimens(getContext(), R.dimen.tbds30);
                int dimens3 = l.getDimens(getContext(), R.dimen.tbds16);
                layoutParams2.addRule(1, R.id.cell_topic_icon);
                layoutParams2.setMargins(dimens2, 0, dimens3, 0);
                this.mTitleView.setTextSize(0, l.getDimens(this.mContext, R.dimen.tbds40));
                if (StringUtils.isNull(aVar.ewT)) {
                    this.mDescView.setVisibility(8);
                } else {
                    this.mDescView.setVisibility(0);
                    this.mDescView.setText(aVar.ewT);
                }
                ap.setViewTextColor(this.mDescView, R.color.cp_cont_b, 1);
            }
            String str = aVar.ewR;
            if (str.length() > 14) {
                str = str.substring(0, 13) + StringHelper.STRING_MORE;
            }
            this.mTitleView.setText(String.format(this.mTbPageContext.getString(R.string.daily_topic_name), str));
            if (StringUtils.isNull(aVar.jDw)) {
                this.jFh.setVisibility(8);
                this.jFj.setUserColor(R.color.cp_cont_d);
            } else {
                this.jFh.setVisibility(0);
                this.iht.setPlaceHolder(3);
                this.iht.startLoad(aVar.jDw, 10, false);
                this.jFj.setUserColor(R.color.cp_cont_a);
            }
            if (aVar.jEQ == null) {
                this.jFi.setVisibility(8);
                this.jFj.setVisibility(8);
                this.jFn.setVisibility(8);
                return;
            }
            this.jFi.setVisibility(0);
            this.jFj.setVisibility(0);
            this.jFj.setData(aVar.jEQ);
            this.jFn.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jFp != null && this.jFp.from != 1) {
            TiebaStatic.log(new aq("c13351").w("topic_id", this.jFp.topicId).aj("obj_locate", this.jFp.index));
        }
        if (this.jFp != null && this.jFp.from == 1) {
            TiebaStatic.log(new aq("c13449").w("topic_id", this.jFp.topicId));
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TopicDetailActivityConfig(getContext(), this.jFp.topicId)));
    }

    public CellTopicLinearLayout cJH() {
        return this.jEF;
    }
}
