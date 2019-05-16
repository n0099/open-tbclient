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
    private TextView ggA;
    private TextView ggB;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d ggC;
    private CellTopicLinearLayout ggz;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ggz = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.ggA = (TextView) view.findViewById(R.id.topic_special_title);
        this.bVI = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.ggB = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.bVI.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.bVI.setConrers(15);
        this.ggz.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.ggA, R.color.cp_cont_b);
            this.bVI.setIsNight(this.mSkinType == 1);
            al.j(this.mTitleView, R.color.cp_cont_f);
            al.j(this.ggB, R.color.cp_cont_d);
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
            this.ggC = dVar;
            if (dVar.gfx) {
                if (StringUtils.isNull(dVar.gfy)) {
                    this.ggA.setText(R.string.topic_special_title_default);
                } else {
                    this.ggA.setText(dVar.gfy);
                }
            }
            this.ggA.setVisibility(dVar.gfx ? 0 : 8);
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
            this.ggB.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.threadData.adm())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ggC != null && this.ggC.threadData != null) {
            TiebaStatic.log(new am("c13354").bT("tid", this.ggC.threadData.tid).l("topic_id", this.ggC.topicId).P("obj_locate", this.ggC.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.ggC.threadData, null, "", 18005, true, false, false);
            if (this.ggC.threadData.afi() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.ggC.threadData.getFid()));
                createFromThreadCfg.setForumName(this.ggC.threadData.adA());
            } else {
                createFromThreadCfg.setForumId(this.ggC.threadData.afi().getForumId());
                createFromThreadCfg.setForumName(this.ggC.threadData.afi().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
