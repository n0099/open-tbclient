package com.baidu.tieba.homepage.topic.topicdetail.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
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
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView bWR;
    private CellTopicLinearLayout gnH;
    private TextView gnI;
    private TextView gnJ;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d gnK;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gnH = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.gnI = (TextView) view.findViewById(R.id.topic_special_title);
        this.bWR = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.gnJ = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.bWR.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.bWR.setConrers(15);
        this.gnH.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.j(this.gnI, R.color.cp_cont_b);
            this.bWR.setIsNight(this.mSkinType == 1);
            am.j(this.mTitleView, R.color.cp_cont_f);
            am.j(this.gnJ, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.threadData != null) {
            this.gnK = dVar;
            if (dVar.gmG) {
                if (StringUtils.isNull(dVar.gmH)) {
                    this.gnI.setText(R.string.topic_special_title_default);
                } else {
                    this.gnI.setText(dVar.gmH);
                }
            }
            this.gnI.setVisibility(dVar.gmG ? 0 : 8);
            String str = null;
            if (!v.aa(dVar.threadData.aeI())) {
                Iterator<MediaData> it = dVar.threadData.aeI().iterator();
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
            if (!aq.bV(str, this.bWR.getUrl())) {
                this.bWR.reset();
            }
            this.bWR.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.threadData.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.threadData.getTitle());
            }
            this.gnJ.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.threadData.aep())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gnK != null && this.gnK.threadData != null) {
            TiebaStatic.log(new an("c13354").bT("tid", this.gnK.threadData.tid).l("topic_id", this.gnK.topicId).P("obj_locate", this.gnK.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.gnK.threadData, null, "", 18005, true, false, false);
            if (this.gnK.threadData.agl() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.gnK.threadData.getFid()));
                createFromThreadCfg.setForumName(this.gnK.threadData.aeD());
            } else {
                createFromThreadCfg.setForumId(this.gnK.threadData.agl().getForumId());
                createFromThreadCfg.setForumName(this.gnK.threadData.agl().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
