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
    private TbImageView bNT;
    private CellTopicLinearLayout fPE;
    private TextView fPF;
    private TextView fPG;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d fPH;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fPE = (CellTopicLinearLayout) view.findViewById(d.g.topic_special_root);
        this.fPF = (TextView) view.findViewById(d.g.topic_special_title);
        this.bNT = (TbImageView) view.findViewById(d.g.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(d.g.topic_special_thread_title);
        this.fPG = (TextView) view.findViewById(d.g.topic_special_thread_discuss);
        this.bNT.setRadius(l.h(this.mContext, d.e.tbds22));
        this.bNT.setConrers(15);
        this.fPE.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            al.j(this.fPF, d.C0236d.cp_cont_b);
            this.bNT.setIsNight(this.mSkinType == 1);
            al.j(this.mTitleView, d.C0236d.cp_cont_f);
            al.j(this.fPG, d.C0236d.cp_cont_d);
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
            this.fPH = dVar;
            if (dVar.fOC) {
                if (StringUtils.isNull(dVar.fOD)) {
                    this.fPF.setText(d.j.topic_special_title_default);
                } else {
                    this.fPF.setText(dVar.fOD);
                }
            }
            this.fPF.setVisibility(dVar.fOC ? 0 : 8);
            String str = null;
            if (!v.T(dVar.threadData.Zb())) {
                Iterator<MediaData> it = dVar.threadData.Zb().iterator();
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
            if (!ap.equals(str, this.bNT.getUrl())) {
                this.bNT.reset();
            }
            this.bNT.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.threadData.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.threadData.getTitle());
            }
            this.fPG.setText(String.format(this.mContext.getString(d.j.topic_discuss_default), Integer.valueOf(dVar.threadData.YI())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fPH != null && this.fPH.threadData != null) {
            TiebaStatic.log(new am("c13354").bJ("tid", this.fPH.threadData.tid).k("topic_id", this.fPH.topicId).T("obj_locate", this.fPH.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.fPH.threadData, null, "", 18005, true, false, false);
            if (this.fPH.threadData.aaE() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.fPH.threadData.getFid()));
                createFromThreadCfg.setForumName(this.fPH.threadData.YW());
            } else {
                createFromThreadCfg.setForumId(this.fPH.threadData.aaE().getForumId());
                createFromThreadCfg.setForumName(this.fPH.threadData.aaE().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createFromThreadCfg));
        }
    }
}
