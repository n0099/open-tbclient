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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView eoz;
    private CellTopicLinearLayout iUA;
    private TextView iUB;
    private TextView iUC;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d iUD;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iUA = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.iUB = (TextView) view.findViewById(R.id.topic_special_title);
        this.eoz = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.iUC = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eoz.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eoz.setConrers(15);
        this.eoz.setPlaceHolder(2);
        this.iUA.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iUB, R.color.cp_cont_b);
            this.eoz.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
            ap.setViewTextColor(this.iUC, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.dUW != null) {
            this.iUD = dVar;
            if (dVar.iTA) {
                if (StringUtils.isNull(dVar.iTB)) {
                    this.iUB.setText(R.string.topic_special_title_default);
                } else {
                    this.iUB.setText(dVar.iTB);
                }
            }
            this.iUB.setVisibility(dVar.iTA ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.dUW.beN())) {
                Iterator<MediaData> it = dVar.dUW.beN().iterator();
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
            if (!at.equals(str, this.eoz.getUrl())) {
                this.eoz.reset();
            }
            this.eoz.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.dUW.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.dUW.getTitle());
            }
            this.iUC.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dUW.bev())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iUD != null && this.iUD.dUW != null) {
            TiebaStatic.log(new aq("c13354").dD("tid", this.iUD.dUW.tid).u("topic_id", this.iUD.topicId).ai("obj_locate", this.iUD.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.iUD.dUW, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.iUD.dUW.bgs() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.iUD.dUW.getFid()));
                createFromThreadCfg.setForumName(this.iUD.dUW.beI());
            } else {
                createFromThreadCfg.setForumId(this.iUD.dUW.bgs().getForumId());
                createFromThreadCfg.setForumName(this.iUD.dUW.bgs().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
