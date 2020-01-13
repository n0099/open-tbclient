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
/* loaded from: classes7.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView cZu;
    private CellTopicLinearLayout hfk;
    private TextView hfl;
    private TextView hfm;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d hfn;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hfk = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.hfl = (TextView) view.findViewById(R.id.topic_special_title);
        this.cZu = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.hfm = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.cZu.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.cZu.setConrers(15);
        this.cZu.setPlaceHolder(2);
        this.hfk.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hfl, (int) R.color.cp_cont_b);
            this.cZu.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hfm, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.cNb != null) {
            this.hfn = dVar;
            if (dVar.hej) {
                if (StringUtils.isNull(dVar.hek)) {
                    this.hfl.setText(R.string.topic_special_title_default);
                } else {
                    this.hfl.setText(dVar.hek);
                }
            }
            this.hfl.setVisibility(dVar.hej ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.cNb.aAh())) {
                Iterator<MediaData> it = dVar.cNb.aAh().iterator();
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
            if (!aq.equals(str, this.cZu.getUrl())) {
                this.cZu.reset();
            }
            this.cZu.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.cNb.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.cNb.getTitle());
            }
            this.hfm.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.cNb.azO())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hfn != null && this.hfn.cNb != null) {
            TiebaStatic.log(new an("c13354").cp("tid", this.hfn.cNb.tid).s("topic_id", this.hfn.topicId).Z("obj_locate", this.hfn.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.hfn.cNb, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.hfn.cNb.aBJ() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.hfn.cNb.getFid()));
                createFromThreadCfg.setForumName(this.hfn.cNb.aAc());
            } else {
                createFromThreadCfg.setForumId(this.hfn.cNb.aBJ().getForumId());
                createFromThreadCfg.setForumName(this.hfn.cNb.aBJ().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
