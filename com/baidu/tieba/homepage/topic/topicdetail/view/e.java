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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView bVJ;
    private CellTopicLinearLayout ggC;
    private TextView ggD;
    private TextView ggE;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d ggF;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ggC = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.ggD = (TextView) view.findViewById(R.id.topic_special_title);
        this.bVJ = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.ggE = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.bVJ.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.bVJ.setConrers(15);
        this.ggC.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.ggD, R.color.cp_cont_b);
            this.bVJ.setIsNight(this.mSkinType == 1);
            al.j(this.mTitleView, R.color.cp_cont_f);
            al.j(this.ggE, R.color.cp_cont_d);
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
            this.ggF = dVar;
            if (dVar.gfA) {
                if (StringUtils.isNull(dVar.gfB)) {
                    this.ggD.setText(R.string.topic_special_title_default);
                } else {
                    this.ggD.setText(dVar.gfB);
                }
            }
            this.ggD.setVisibility(dVar.gfA ? 0 : 8);
            String str = null;
            if (!v.aa(dVar.threadData.adF())) {
                Iterator<MediaData> it = dVar.threadData.adF().iterator();
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
            if (!ap.equals(str, this.bVJ.getUrl())) {
                this.bVJ.reset();
            }
            this.bVJ.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.threadData.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.threadData.getTitle());
            }
            this.ggE.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.threadData.adm())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ggF != null && this.ggF.threadData != null) {
            TiebaStatic.log(new am("c13354").bT("tid", this.ggF.threadData.tid).l("topic_id", this.ggF.topicId).P("obj_locate", this.ggF.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.ggF.threadData, null, "", 18005, true, false, false);
            if (this.ggF.threadData.afi() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.ggF.threadData.getFid()));
                createFromThreadCfg.setForumName(this.ggF.threadData.adA());
            } else {
                createFromThreadCfg.setForumId(this.ggF.threadData.afi().getForumId());
                createFromThreadCfg.setForumName(this.ggF.threadData.afi().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
