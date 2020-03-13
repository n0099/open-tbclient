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
    private TbImageView ddN;
    private TextView hhA;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d hhB;
    private CellTopicLinearLayout hhy;
    private TextView hhz;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hhy = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.hhz = (TextView) view.findViewById(R.id.topic_special_title);
        this.ddN = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.hhA = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.ddN.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.ddN.setConrers(15);
        this.ddN.setPlaceHolder(2);
        this.hhy.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hhz, (int) R.color.cp_cont_b);
            this.ddN.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hhA, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.cRg != null) {
            this.hhB = dVar;
            if (dVar.hgy) {
                if (StringUtils.isNull(dVar.hgz)) {
                    this.hhz.setText(R.string.topic_special_title_default);
                } else {
                    this.hhz.setText(dVar.hgz);
                }
            }
            this.hhz.setVisibility(dVar.hgy ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.cRg.aCy())) {
                Iterator<MediaData> it = dVar.cRg.aCy().iterator();
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
            if (!aq.equals(str, this.ddN.getUrl())) {
                this.ddN.reset();
            }
            this.ddN.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.cRg.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.cRg.getTitle());
            }
            this.hhA.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.cRg.aCf())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhB != null && this.hhB.cRg != null) {
            TiebaStatic.log(new an("c13354").cy("tid", this.hhB.cRg.tid).s("topic_id", this.hhB.topicId).X("obj_locate", this.hhB.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.hhB.cRg, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.hhB.cRg.aDX() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.hhB.cRg.getFid()));
                createFromThreadCfg.setForumName(this.hhB.cRg.aCt());
            } else {
                createFromThreadCfg.setForumId(this.hhB.cRg.aDX().getForumId());
                createFromThreadCfg.setForumName(this.hhB.cRg.aDX().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
