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
    private TbImageView bXK;
    private TextView gpA;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d gpB;
    private CellTopicLinearLayout gpy;
    private TextView gpz;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gpy = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.gpz = (TextView) view.findViewById(R.id.topic_special_title);
        this.bXK = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.gpA = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.bXK.setRadius(l.g(this.mContext, R.dimen.tbds22));
        this.bXK.setConrers(15);
        this.gpy.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.j(this.gpz, R.color.cp_cont_b);
            this.bXK.setIsNight(this.mSkinType == 1);
            am.j(this.mTitleView, R.color.cp_cont_f);
            am.j(this.gpA, R.color.cp_cont_d);
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
            this.gpB = dVar;
            if (dVar.gox) {
                if (StringUtils.isNull(dVar.goy)) {
                    this.gpz.setText(R.string.topic_special_title_default);
                } else {
                    this.gpz.setText(dVar.goy);
                }
            }
            this.gpz.setVisibility(dVar.gox ? 0 : 8);
            String str = null;
            if (!v.aa(dVar.threadData.aeM())) {
                Iterator<MediaData> it = dVar.threadData.aeM().iterator();
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
            if (!aq.bV(str, this.bXK.getUrl())) {
                this.bXK.reset();
            }
            this.bXK.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.threadData.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.threadData.getTitle());
            }
            this.gpA.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.threadData.aet())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gpB != null && this.gpB.threadData != null) {
            TiebaStatic.log(new an("c13354").bT("tid", this.gpB.threadData.tid).n("topic_id", this.gpB.topicId).P("obj_locate", this.gpB.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.gpB.threadData, null, "", 18005, true, false, false);
            if (this.gpB.threadData.agp() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.gpB.threadData.getFid()));
                createFromThreadCfg.setForumName(this.gpB.threadData.aeH());
            } else {
                createFromThreadCfg.setForumId(this.gpB.threadData.agp().getForumId());
                createFromThreadCfg.setForumName(this.gpB.threadData.agp().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
