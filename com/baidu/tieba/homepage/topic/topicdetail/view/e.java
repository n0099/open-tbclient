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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView eeU;
    private CellTopicLinearLayout iFu;
    private TextView iFv;
    private TextView iFw;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d iFx;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iFu = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.iFv = (TextView) view.findViewById(R.id.topic_special_title);
        this.eeU = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.iFw = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eeU.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eeU.setConrers(15);
        this.eeU.setPlaceHolder(2);
        this.iFu.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.iFv, R.color.cp_cont_b);
            this.eeU.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
            ao.setViewTextColor(this.iFw, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.dLK != null) {
            this.iFx = dVar;
            if (dVar.iEu) {
                if (StringUtils.isNull(dVar.iEv)) {
                    this.iFv.setText(R.string.topic_special_title_default);
                } else {
                    this.iFv.setText(dVar.iEv);
                }
            }
            this.iFv.setVisibility(dVar.iEu ? 0 : 8);
            String str = null;
            if (!x.isEmpty(dVar.dLK.aWu())) {
                Iterator<MediaData> it = dVar.dLK.aWu().iterator();
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
            if (!as.equals(str, this.eeU.getUrl())) {
                this.eeU.reset();
            }
            this.eeU.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.dLK.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.dLK.getTitle());
            }
            this.iFw.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dLK.aWc())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iFx != null && this.iFx.dLK != null) {
            TiebaStatic.log(new ap("c13354").dn("tid", this.iFx.dLK.tid).t("topic_id", this.iFx.topicId).ah("obj_locate", this.iFx.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.iFx.dLK, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.iFx.dLK.aXZ() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.iFx.dLK.getFid()));
                createFromThreadCfg.setForumName(this.iFx.dLK.aWp());
            } else {
                createFromThreadCfg.setForumId(this.iFx.dLK.aXZ().getForumId());
                createFromThreadCfg.setForumName(this.iFx.dLK.aXZ().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
