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
    private TbImageView clX;
    private CellTopicLinearLayout gog;
    private TextView goh;
    private TextView goi;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d goj;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gog = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.goh = (TextView) view.findViewById(R.id.topic_special_title);
        this.clX = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.goi = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.clX.setRadius(l.getDimens(this.mContext, R.dimen.tbds22));
        this.clX.setConrers(15);
        this.gog.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.goh, (int) R.color.cp_cont_b);
            this.clX.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.goi, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.caz != null) {
            this.goj = dVar;
            if (dVar.gnf) {
                if (StringUtils.isNull(dVar.gng)) {
                    this.goh.setText(R.string.topic_special_title_default);
                } else {
                    this.goh.setText(dVar.gng);
                }
            }
            this.goh.setVisibility(dVar.gnf ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.caz.aiO())) {
                Iterator<MediaData> it = dVar.caz.aiO().iterator();
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
            if (!aq.equals(str, this.clX.getUrl())) {
                this.clX.reset();
            }
            this.clX.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.caz.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.caz.getTitle());
            }
            this.goi.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.caz.aiv())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.goj != null && this.goj.caz != null) {
            TiebaStatic.log(new an("c13354").bS("tid", this.goj.caz.tid).p("topic_id", this.goj.topicId).O("obj_locate", this.goj.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.goj.caz, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.goj.caz.akq() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.goj.caz.getFid()));
                createFromThreadCfg.setForumName(this.goj.caz.aiJ());
            } else {
                createFromThreadCfg.setForumId(this.goj.caz.akq().getForumId());
                createFromThreadCfg.setForumName(this.goj.caz.akq().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
