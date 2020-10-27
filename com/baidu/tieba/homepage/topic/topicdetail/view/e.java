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
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView eLx;
    private CellTopicLinearLayout jEF;
    private TextView jEG;
    private TextView jEH;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d jEI;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jEF = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.jEG = (TextView) view.findViewById(R.id.topic_special_title);
        this.eLx = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.jEH = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eLx.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eLx.setConrers(15);
        this.eLx.setPlaceHolder(2);
        this.jEF.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jEG, R.color.cp_cont_b);
            this.eLx.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
            ap.setViewTextColor(this.jEH, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.erH != null) {
            this.jEI = dVar;
            if (dVar.jDF) {
                if (StringUtils.isNull(dVar.jDG)) {
                    this.jEG.setText(R.string.topic_special_title_default);
                } else {
                    this.jEG.setText(dVar.jDG);
                }
            }
            this.jEG.setVisibility(dVar.jDF ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.erH.bkj())) {
                Iterator<MediaData> it = dVar.erH.bkj().iterator();
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
            if (!at.equals(str, this.eLx.getUrl())) {
                this.eLx.reset();
            }
            this.eLx.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.erH.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.erH.getTitle());
            }
            this.jEH.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.erH.bjR())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jEI != null && this.jEI.erH != null) {
            TiebaStatic.log(new aq("c13354").dR("tid", this.jEI.erH.tid).w("topic_id", this.jEI.topicId).aj("obj_locate", this.jEI.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.jEI.erH, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.jEI.erH.blO() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.jEI.erH.getFid()));
                createFromThreadCfg.setForumName(this.jEI.erH.bke());
            } else {
                createFromThreadCfg.setForumId(this.jEI.erH.blO().getForumId());
                createFromThreadCfg.setForumName(this.jEI.erH.blO().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
