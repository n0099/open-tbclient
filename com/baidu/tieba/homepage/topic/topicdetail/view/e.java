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
    private CellTopicLinearLayout iFw;
    private TextView iFx;
    private TextView iFy;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d iFz;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iFw = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.iFx = (TextView) view.findViewById(R.id.topic_special_title);
        this.eeU = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.iFy = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eeU.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eeU.setConrers(15);
        this.eeU.setPlaceHolder(2);
        this.iFw.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.iFx, R.color.cp_cont_b);
            this.eeU.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
            ao.setViewTextColor(this.iFy, R.color.cp_cont_d);
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
            this.iFz = dVar;
            if (dVar.iEw) {
                if (StringUtils.isNull(dVar.iEx)) {
                    this.iFx.setText(R.string.topic_special_title_default);
                } else {
                    this.iFx.setText(dVar.iEx);
                }
            }
            this.iFx.setVisibility(dVar.iEw ? 0 : 8);
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
            this.iFy.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dLK.aWc())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iFz != null && this.iFz.dLK != null) {
            TiebaStatic.log(new ap("c13354").dn("tid", this.iFz.dLK.tid).t("topic_id", this.iFz.topicId).ah("obj_locate", this.iFz.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.iFz.dLK, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.iFz.dLK.aXZ() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.iFz.dLK.getFid()));
                createFromThreadCfg.setForumName(this.iFz.dLK.aWp());
            } else {
                createFromThreadCfg.setForumId(this.iFz.dLK.aXZ().getForumId());
                createFromThreadCfg.setForumName(this.iFz.dLK.aXZ().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
