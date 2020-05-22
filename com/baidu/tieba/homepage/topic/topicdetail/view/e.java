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
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView dRP;
    private TextView ihA;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d ihB;
    private CellTopicLinearLayout ihy;
    private TextView ihz;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ihy = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.ihz = (TextView) view.findViewById(R.id.topic_special_title);
        this.dRP = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.ihA = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.dRP.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dRP.setConrers(15);
        this.dRP.setPlaceHolder(2);
        this.ihy.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.ihz, (int) R.color.cp_cont_b);
            this.dRP.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.ihA, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.dEA != null) {
            this.ihB = dVar;
            if (dVar.igy) {
                if (StringUtils.isNull(dVar.igz)) {
                    this.ihz.setText(R.string.topic_special_title_default);
                } else {
                    this.ihz.setText(dVar.igz);
                }
            }
            this.ihz.setVisibility(dVar.igy ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.dEA.aQH())) {
                Iterator<MediaData> it = dVar.dEA.aQH().iterator();
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
            if (!aq.equals(str, this.dRP.getUrl())) {
                this.dRP.reset();
            }
            this.dRP.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.dEA.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.dEA.getTitle());
            }
            this.ihA.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dEA.aQo())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ihB != null && this.ihB.dEA != null) {
            TiebaStatic.log(new an("c13354").dh("tid", this.ihB.dEA.tid).s("topic_id", this.ihB.topicId).ag("obj_locate", this.ihB.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.ihB.dEA, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.ihB.dEA.aSm() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.ihB.dEA.getFid()));
                createFromThreadCfg.setForumName(this.ihB.dEA.aQC());
            } else {
                createFromThreadCfg.setForumId(this.ihB.dEA.aSm().getForumId());
                createFromThreadCfg.setForumName(this.ihB.dEA.aSm().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
