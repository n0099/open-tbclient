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
    private TbImageView bVI;
    private CellTopicLinearLayout ggA;
    private TextView ggB;
    private TextView ggC;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d ggD;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ggA = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.ggB = (TextView) view.findViewById(R.id.topic_special_title);
        this.bVI = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.ggC = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.bVI.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.bVI.setConrers(15);
        this.ggA.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.ggB, R.color.cp_cont_b);
            this.bVI.setIsNight(this.mSkinType == 1);
            al.j(this.mTitleView, R.color.cp_cont_f);
            al.j(this.ggC, R.color.cp_cont_d);
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
            this.ggD = dVar;
            if (dVar.gfy) {
                if (StringUtils.isNull(dVar.gfz)) {
                    this.ggB.setText(R.string.topic_special_title_default);
                } else {
                    this.ggB.setText(dVar.gfz);
                }
            }
            this.ggB.setVisibility(dVar.gfy ? 0 : 8);
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
            if (!ap.equals(str, this.bVI.getUrl())) {
                this.bVI.reset();
            }
            this.bVI.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.threadData.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.threadData.getTitle());
            }
            this.ggC.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.threadData.adm())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ggD != null && this.ggD.threadData != null) {
            TiebaStatic.log(new am("c13354").bT("tid", this.ggD.threadData.tid).l("topic_id", this.ggD.topicId).P("obj_locate", this.ggD.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.ggD.threadData, null, "", 18005, true, false, false);
            if (this.ggD.threadData.afi() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.ggD.threadData.getFid()));
                createFromThreadCfg.setForumName(this.ggD.threadData.adA());
            } else {
                createFromThreadCfg.setForumId(this.ggD.threadData.afi().getForumId());
                createFromThreadCfg.setForumName(this.ggD.threadData.afi().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
