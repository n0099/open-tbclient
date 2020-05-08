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
    private TbImageView dDD;
    private CellTopicLinearLayout hSO;
    private TextView hSP;
    private TextView hSQ;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d hSR;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hSO = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.hSP = (TextView) view.findViewById(R.id.topic_special_title);
        this.dDD = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.hSQ = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.dDD.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dDD.setConrers(15);
        this.dDD.setPlaceHolder(2);
        this.hSO.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hSP, (int) R.color.cp_cont_b);
            this.dDD.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hSQ, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.dqE != null) {
            this.hSR = dVar;
            if (dVar.hRO) {
                if (StringUtils.isNull(dVar.hRP)) {
                    this.hSP.setText(R.string.topic_special_title_default);
                } else {
                    this.hSP.setText(dVar.hRP);
                }
            }
            this.hSP.setVisibility(dVar.hRO ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.dqE.aKM())) {
                Iterator<MediaData> it = dVar.dqE.aKM().iterator();
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
            if (!aq.equals(str, this.dDD.getUrl())) {
                this.dDD.reset();
            }
            this.dDD.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.dqE.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.dqE.getTitle());
            }
            this.hSQ.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dqE.aKt())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hSR != null && this.hSR.dqE != null) {
            TiebaStatic.log(new an("c13354").cI("tid", this.hSR.dqE.tid).t("topic_id", this.hSR.topicId).af("obj_locate", this.hSR.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.hSR.dqE, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.hSR.dqE.aMn() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.hSR.dqE.getFid()));
                createFromThreadCfg.setForumName(this.hSR.dqE.aKH());
            } else {
                createFromThreadCfg.setForumId(this.hSR.dqE.aMn().getForumId());
                createFromThreadCfg.setForumName(this.hSR.dqE.aMn().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
