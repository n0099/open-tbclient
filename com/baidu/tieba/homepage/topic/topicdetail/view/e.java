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
    private TbImageView ddz;
    private CellTopicLinearLayout hhk;
    private TextView hhl;
    private TextView hhm;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d hhn;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hhk = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.hhl = (TextView) view.findViewById(R.id.topic_special_title);
        this.ddz = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.hhm = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.ddz.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.ddz.setConrers(15);
        this.ddz.setPlaceHolder(2);
        this.hhk.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hhl, (int) R.color.cp_cont_b);
            this.ddz.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hhm, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.cRe != null) {
            this.hhn = dVar;
            if (dVar.hgk) {
                if (StringUtils.isNull(dVar.hgl)) {
                    this.hhl.setText(R.string.topic_special_title_default);
                } else {
                    this.hhl.setText(dVar.hgl);
                }
            }
            this.hhl.setVisibility(dVar.hgk ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.cRe.aCw())) {
                Iterator<MediaData> it = dVar.cRe.aCw().iterator();
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
            if (!aq.equals(str, this.ddz.getUrl())) {
                this.ddz.reset();
            }
            this.ddz.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.cRe.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.cRe.getTitle());
            }
            this.hhm.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.cRe.aCd())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhn != null && this.hhn.cRe != null) {
            TiebaStatic.log(new an("c13354").cy("tid", this.hhn.cRe.tid).s("topic_id", this.hhn.topicId).X("obj_locate", this.hhn.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.hhn.cRe, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.hhn.cRe.aDV() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.hhn.cRe.getFid()));
                createFromThreadCfg.setForumName(this.hhn.cRe.aCr());
            } else {
                createFromThreadCfg.setForumId(this.hhn.cRe.aDV().getForumId());
                createFromThreadCfg.setForumName(this.hhn.cRe.aDV().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
