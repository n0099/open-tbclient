package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView dDz;
    private CellTopicLinearLayout hSI;
    private TextView hSJ;
    private TextView hSK;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d hSL;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hSI = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.hSJ = (TextView) view.findViewById(R.id.topic_special_title);
        this.dDz = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.hSK = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.dDz.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dDz.setConrers(15);
        this.dDz.setPlaceHolder(2);
        this.hSI.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hSJ, (int) R.color.cp_cont_b);
            this.dDz.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hSK, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.dqA != null) {
            this.hSL = dVar;
            if (dVar.hRI) {
                if (StringUtils.isNull(dVar.hRJ)) {
                    this.hSJ.setText(R.string.topic_special_title_default);
                } else {
                    this.hSJ.setText(dVar.hRJ);
                }
            }
            this.hSJ.setVisibility(dVar.hRI ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.dqA.aKO())) {
                Iterator<MediaData> it = dVar.dqA.aKO().iterator();
                while (it.hasNext()) {
                    MediaData next = it.next();
                    if (next != null && next.getType() == 3) {
                        str = next.getPicUrl();
                        if (StringUtils.isNull(str)) {
                            str = next.getSmallUrl();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getThumbnails_url();
                        }
                        if (StringUtils.isNull(str)) {
                            str = next.getSrc_pic();
                        }
                        if (!StringUtils.isNull(str)) {
                            break;
                        }
                    }
                }
            }
            if (!aq.equals(str, this.dDz.getUrl())) {
                this.dDz.reset();
            }
            this.dDz.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.dqA.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.dqA.getTitle());
            }
            this.hSK.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dqA.aKv())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hSL != null && this.hSL.dqA != null) {
            TiebaStatic.log(new an("c13354").cI("tid", this.hSL.dqA.tid).t("topic_id", this.hSL.topicId).af("obj_locate", this.hSL.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.hSL.dqA, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.hSL.dqA.aMp() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.hSL.dqA.getFid()));
                createFromThreadCfg.setForumName(this.hSL.dqA.aKJ());
            } else {
                createFromThreadCfg.setForumId(this.hSL.dqA.aMp().getForumId());
                createFromThreadCfg.setForumName(this.hSL.dqA.aMp().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
