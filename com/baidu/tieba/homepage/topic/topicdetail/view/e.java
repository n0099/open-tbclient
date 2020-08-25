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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView eov;
    private CellTopicLinearLayout iUu;
    private TextView iUv;
    private TextView iUw;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d iUx;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iUu = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.iUv = (TextView) view.findViewById(R.id.topic_special_title);
        this.eov = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.iUw = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eov.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eov.setConrers(15);
        this.eov.setPlaceHolder(2);
        this.iUu.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iUv, R.color.cp_cont_b);
            this.eov.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
            ap.setViewTextColor(this.iUw, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.dUS != null) {
            this.iUx = dVar;
            if (dVar.iTu) {
                if (StringUtils.isNull(dVar.iTv)) {
                    this.iUv.setText(R.string.topic_special_title_default);
                } else {
                    this.iUv.setText(dVar.iTv);
                }
            }
            this.iUv.setVisibility(dVar.iTu ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.dUS.beN())) {
                Iterator<MediaData> it = dVar.dUS.beN().iterator();
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
            if (!at.equals(str, this.eov.getUrl())) {
                this.eov.reset();
            }
            this.eov.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.dUS.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.dUS.getTitle());
            }
            this.iUw.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dUS.bev())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iUx != null && this.iUx.dUS != null) {
            TiebaStatic.log(new aq("c13354").dD("tid", this.iUx.dUS.tid).u("topic_id", this.iUx.topicId).ai("obj_locate", this.iUx.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.iUx.dUS, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.iUx.dUS.bgs() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.iUx.dUS.getFid()));
                createFromThreadCfg.setForumName(this.iUx.dUS.beI());
            } else {
                createFromThreadCfg.setForumId(this.iUx.dUS.bgs().getForumId());
                createFromThreadCfg.setForumName(this.iUx.dUS.bgs().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
