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
    private TbImageView dea;
    private CellTopicLinearLayout hiZ;
    private TextView hja;
    private TextView hjb;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d hjc;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hiZ = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.hja = (TextView) view.findViewById(R.id.topic_special_title);
        this.dea = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.hjb = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.dea.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dea.setConrers(15);
        this.dea.setPlaceHolder(2);
        this.hiZ.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hja, (int) R.color.cp_cont_b);
            this.dea.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hjb, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.cRt != null) {
            this.hjc = dVar;
            if (dVar.hhY) {
                if (StringUtils.isNull(dVar.hhZ)) {
                    this.hja.setText(R.string.topic_special_title_default);
                } else {
                    this.hja.setText(dVar.hhZ);
                }
            }
            this.hja.setVisibility(dVar.hhY ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.cRt.aCB())) {
                Iterator<MediaData> it = dVar.cRt.aCB().iterator();
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
            if (!aq.equals(str, this.dea.getUrl())) {
                this.dea.reset();
            }
            this.dea.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.cRt.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.cRt.getTitle());
            }
            this.hjb.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.cRt.aCi())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hjc != null && this.hjc.cRt != null) {
            TiebaStatic.log(new an("c13354").cx("tid", this.hjc.cRt.tid).s("topic_id", this.hjc.topicId).X("obj_locate", this.hjc.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.hjc.cRt, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.hjc.cRt.aEb() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.hjc.cRt.getFid()));
                createFromThreadCfg.setForumName(this.hjc.cRt.aCw());
            } else {
                createFromThreadCfg.setForumId(this.hjc.cRt.aEb().getForumId());
                createFromThreadCfg.setForumName(this.hjc.cRt.aEb().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
