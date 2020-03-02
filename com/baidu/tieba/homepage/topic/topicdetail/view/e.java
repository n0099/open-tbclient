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
    private TbImageView ddA;
    private CellTopicLinearLayout hhm;
    private TextView hhn;
    private TextView hho;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d hhp;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.hhm = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.hhn = (TextView) view.findViewById(R.id.topic_special_title);
        this.ddA = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.hho = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.ddA.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.ddA.setConrers(15);
        this.ddA.setPlaceHolder(2);
        this.hhm.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.hhn, (int) R.color.cp_cont_b);
            this.ddA.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.hho, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.cRf != null) {
            this.hhp = dVar;
            if (dVar.hgm) {
                if (StringUtils.isNull(dVar.hgn)) {
                    this.hhn.setText(R.string.topic_special_title_default);
                } else {
                    this.hhn.setText(dVar.hgn);
                }
            }
            this.hhn.setVisibility(dVar.hgm ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.cRf.aCy())) {
                Iterator<MediaData> it = dVar.cRf.aCy().iterator();
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
            if (!aq.equals(str, this.ddA.getUrl())) {
                this.ddA.reset();
            }
            this.ddA.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.cRf.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.cRf.getTitle());
            }
            this.hho.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.cRf.aCf())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hhp != null && this.hhp.cRf != null) {
            TiebaStatic.log(new an("c13354").cy("tid", this.hhp.cRf.tid).s("topic_id", this.hhp.topicId).X("obj_locate", this.hhp.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.hhp.cRf, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.hhp.cRf.aDX() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.hhp.cRf.getFid()));
                createFromThreadCfg.setForumName(this.hhp.cRf.aCt());
            } else {
                createFromThreadCfg.setForumId(this.hhp.cRf.aDX().getForumId());
                createFromThreadCfg.setForumName(this.hhp.cRf.aDX().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
