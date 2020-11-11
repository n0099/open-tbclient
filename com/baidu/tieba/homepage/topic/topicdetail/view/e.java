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
    private TbImageView eRm;
    private CellTopicLinearLayout jKD;
    private TextView jKE;
    private TextView jKF;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d jKG;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jKD = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.jKE = (TextView) view.findViewById(R.id.topic_special_title);
        this.eRm = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.jKF = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eRm.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eRm.setConrers(15);
        this.eRm.setPlaceHolder(2);
        this.jKD.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jKE, R.color.cp_cont_b);
            this.eRm.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
            ap.setViewTextColor(this.jKF, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.exA != null) {
            this.jKG = dVar;
            if (dVar.jJC) {
                if (StringUtils.isNull(dVar.jJD)) {
                    this.jKE.setText(R.string.topic_special_title_default);
                } else {
                    this.jKE.setText(dVar.jJD);
                }
            }
            this.jKE.setVisibility(dVar.jJC ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.exA.bmJ())) {
                Iterator<MediaData> it = dVar.exA.bmJ().iterator();
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
            if (!at.equals(str, this.eRm.getUrl())) {
                this.eRm.reset();
            }
            this.eRm.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.exA.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.exA.getTitle());
            }
            this.jKF.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.exA.bmr())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jKG != null && this.jKG.exA != null) {
            TiebaStatic.log(new aq("c13354").dR("tid", this.jKG.exA.tid).w("topic_id", this.jKG.topicId).al("obj_locate", this.jKG.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.jKG.exA, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.jKG.exA.boo() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.jKG.exA.getFid()));
                createFromThreadCfg.setForumName(this.jKG.exA.bmE());
            } else {
                createFromThreadCfg.setForumId(this.jKG.exA.boo().getForumId());
                createFromThreadCfg.setForumName(this.jKG.exA.boo().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
