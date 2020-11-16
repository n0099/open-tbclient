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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes21.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView eQn;
    private CellTopicLinearLayout jLo;
    private TextView jLp;
    private TextView jLq;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d jLr;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jLo = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.jLp = (TextView) view.findViewById(R.id.topic_special_title);
        this.eQn = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.jLq = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eQn.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eQn.setConrers(15);
        this.eQn.setPlaceHolder(2);
        this.jLo.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jLp, R.color.CAM_X0105);
            this.eQn.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
            ap.setViewTextColor(this.jLq, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.evQ != null) {
            this.jLr = dVar;
            if (dVar.jKn) {
                if (StringUtils.isNull(dVar.jKo)) {
                    this.jLp.setText(R.string.topic_special_title_default);
                } else {
                    this.jLp.setText(dVar.jKo);
                }
            }
            this.jLp.setVisibility(dVar.jKn ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.evQ.blL())) {
                Iterator<MediaData> it = dVar.evQ.blL().iterator();
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
            if (!au.equals(str, this.eQn.getUrl())) {
                this.eQn.reset();
            }
            this.eQn.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.evQ.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.evQ.getTitle());
            }
            this.jLq.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.evQ.blt())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jLr != null && this.jLr.evQ != null) {
            TiebaStatic.log(new ar("c13354").dR("tid", this.jLr.evQ.tid).w("topic_id", this.jLr.topicId).ak("obj_locate", this.jLr.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.jLr.evQ, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.jLr.evQ.bns() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.jLr.evQ.getFid()));
                createFromThreadCfg.setForumName(this.jLr.evQ.blG());
            } else {
                createFromThreadCfg.setForumId(this.jLr.evQ.bns().getForumId());
                createFromThreadCfg.setForumName(this.jLr.evQ.bns().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
