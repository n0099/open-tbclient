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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView dYH;
    private CellTopicLinearLayout izq;
    private TextView izr;
    private TextView izs;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d izt;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.izq = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.izr = (TextView) view.findViewById(R.id.topic_special_title);
        this.dYH = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.izs = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.dYH.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dYH.setConrers(15);
        this.dYH.setPlaceHolder(2);
        this.izq.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            an.setViewTextColor(this.izr, (int) R.color.cp_cont_b);
            this.dYH.setIsNight(this.mSkinType == 1);
            an.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            an.setViewTextColor(this.izs, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.dLi != null) {
            this.izt = dVar;
            if (dVar.iyq) {
                if (StringUtils.isNull(dVar.iyr)) {
                    this.izr.setText(R.string.topic_special_title_default);
                } else {
                    this.izr.setText(dVar.iyr);
                }
            }
            this.izr.setVisibility(dVar.iyq ? 0 : 8);
            String str = null;
            if (!w.isEmpty(dVar.dLi.aSy())) {
                Iterator<MediaData> it = dVar.dLi.aSy().iterator();
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
            if (!ar.equals(str, this.dYH.getUrl())) {
                this.dYH.reset();
            }
            this.dYH.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.dLi.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.dLi.getTitle());
            }
            this.izs.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dLi.aSg())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.izt != null && this.izt.dLi != null) {
            TiebaStatic.log(new ao("c13354").dk("tid", this.izt.dLi.tid).s("topic_id", this.izt.topicId).ag("obj_locate", this.izt.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.izt.dLi, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.izt.dLi.aUd() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.izt.dLi.getFid()));
                createFromThreadCfg.setForumName(this.izt.dLi.aSt());
            } else {
                createFromThreadCfg.setForumId(this.izt.dLi.aUd().getForumId());
                createFromThreadCfg.setForumName(this.izt.dLi.aUd().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
