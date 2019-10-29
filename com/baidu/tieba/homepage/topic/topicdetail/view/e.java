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
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView cmP;
    private CellTopicLinearLayout goX;
    private TextView goY;
    private TextView goZ;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d gpa;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.goX = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.goY = (TextView) view.findViewById(R.id.topic_special_title);
        this.cmP = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.goZ = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.cmP.setRadius(l.getDimens(this.mContext, R.dimen.tbds22));
        this.cmP.setConrers(15);
        this.goX.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.goY, (int) R.color.cp_cont_b);
            this.cmP.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.goZ, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.cbq != null) {
            this.gpa = dVar;
            if (dVar.gnW) {
                if (StringUtils.isNull(dVar.gnX)) {
                    this.goY.setText(R.string.topic_special_title_default);
                } else {
                    this.goY.setText(dVar.gnX);
                }
            }
            this.goY.setVisibility(dVar.gnW ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.cbq.aiQ())) {
                Iterator<MediaData> it = dVar.cbq.aiQ().iterator();
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
            if (!aq.equals(str, this.cmP.getUrl())) {
                this.cmP.reset();
            }
            this.cmP.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.cbq.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.cbq.getTitle());
            }
            this.goZ.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.cbq.aix())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gpa != null && this.gpa.cbq != null) {
            TiebaStatic.log(new an("c13354").bS("tid", this.gpa.cbq.tid).p("topic_id", this.gpa.topicId).O("obj_locate", this.gpa.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.gpa.cbq, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.gpa.cbq.aks() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.gpa.cbq.getFid()));
                createFromThreadCfg.setForumName(this.gpa.cbq.aiL());
            } else {
                createFromThreadCfg.setForumId(this.gpa.cbq.aks().getForumId());
                createFromThreadCfg.setForumName(this.gpa.cbq.aks().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
