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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.a.d> {
    private TbImageView fcv;
    private TextView khA;
    private com.baidu.tieba.homepage.topic.topicdetail.a.d khB;
    private CellTopicLinearLayout khy;
    private TextView khz;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.khy = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.khz = (TextView) view.findViewById(R.id.topic_special_title);
        this.fcv = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.khA = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.fcv.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fcv.setConrers(15);
        this.fcv.setPlaceHolder(2);
        this.khy.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.khz, R.color.CAM_X0105);
            this.fcv.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
            ao.setViewTextColor(this.khA, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.a.d dVar) {
        if (dVar != null && dVar.eHK != null) {
            this.khB = dVar;
            if (dVar.kgy) {
                if (StringUtils.isNull(dVar.kgz)) {
                    this.khz.setText(R.string.topic_special_title_default);
                } else {
                    this.khz.setText(dVar.kgz);
                }
            }
            this.khz.setVisibility(dVar.kgy ? 0 : 8);
            String str = null;
            if (!x.isEmpty(dVar.eHK.bnG())) {
                Iterator<MediaData> it = dVar.eHK.bnG().iterator();
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
            if (!at.equals(str, this.fcv.getUrl())) {
                this.fcv.reset();
            }
            this.fcv.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.eHK.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.eHK.getTitle());
            }
            this.khA.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.eHK.bno())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.khB != null && this.khB.eHK != null) {
            TiebaStatic.log(new aq("c13354").dW("tid", this.khB.eHK.tid).w("topic_id", this.khB.topicId).an("obj_locate", this.khB.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.khB.eHK, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.khB.eHK.bpo() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.khB.eHK.getFid()));
                createFromThreadCfg.setForumName(this.khB.eHK.bnB());
            } else {
                createFromThreadCfg.setForumId(this.khB.eHK.bpo().getForumId());
                createFromThreadCfg.setForumName(this.khB.eHK.bpo().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
