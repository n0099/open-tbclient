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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class e extends com.baidu.tieba.card.a<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView bNW;
    private CellTopicLinearLayout fPs;
    private TextView fPt;
    private TextView fPu;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d fPv;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fPs = (CellTopicLinearLayout) view.findViewById(d.g.topic_special_root);
        this.fPt = (TextView) view.findViewById(d.g.topic_special_title);
        this.bNW = (TbImageView) view.findViewById(d.g.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(d.g.topic_special_thread_title);
        this.fPu = (TextView) view.findViewById(d.g.topic_special_thread_discuss);
        this.bNW.setRadius(l.h(this.mContext, d.e.tbds22));
        this.bNW.setConrers(15);
        this.fPs.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.fPt, d.C0277d.cp_cont_b);
            this.bNW.setIsNight(this.mSkinType == 1);
            al.j(this.mTitleView, d.C0277d.cp_cont_f);
            al.j(this.fPu, d.C0277d.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.threadData != null) {
            this.fPv = dVar;
            if (dVar.fOp) {
                if (StringUtils.isNull(dVar.fOq)) {
                    this.fPt.setText(d.j.topic_special_title_default);
                } else {
                    this.fPt.setText(dVar.fOq);
                }
            }
            this.fPt.setVisibility(dVar.fOp ? 0 : 8);
            String str = null;
            if (!v.T(dVar.threadData.YY())) {
                Iterator<MediaData> it = dVar.threadData.YY().iterator();
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
            if (!ap.equals(str, this.bNW.getUrl())) {
                this.bNW.reset();
            }
            this.bNW.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.threadData.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.threadData.getTitle());
            }
            this.fPu.setText(String.format(this.mContext.getString(d.j.topic_discuss_default), Integer.valueOf(dVar.threadData.YF())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fPv != null && this.fPv.threadData != null) {
            TiebaStatic.log(new am("c13354").bJ("tid", this.fPv.threadData.tid).k("topic_id", this.fPv.topicId).T("obj_locate", this.fPv.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.fPv.threadData, null, "", 18005, true, false, false);
            if (this.fPv.threadData.aaB() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.fPv.threadData.getFid()));
                createFromThreadCfg.setForumName(this.fPv.threadData.YT());
            } else {
                createFromThreadCfg.setForumId(this.fPv.threadData.aaB().getForumId());
                createFromThreadCfg.setForumName(this.fPv.threadData.aaB().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
