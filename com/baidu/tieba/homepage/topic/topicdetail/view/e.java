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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.a.d> {
    private TbImageView feK;
    private CellTopicLinearLayout kpG;
    private TextView kpH;
    private TextView kpI;
    private com.baidu.tieba.homepage.topic.topicdetail.a.d kpJ;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.kpG = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.kpH = (TextView) view.findViewById(R.id.topic_special_title);
        this.feK = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.kpI = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.feK.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.feK.setConrers(15);
        this.feK.setPlaceHolder(2);
        this.kpG.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.kpH, R.color.CAM_X0105);
            this.feK.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
            ap.setViewTextColor(this.kpI, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.a.d dVar) {
        if (dVar != null && dVar.eJQ != null) {
            this.kpJ = dVar;
            if (dVar.koG) {
                if (StringUtils.isNull(dVar.koH)) {
                    this.kpH.setText(R.string.topic_special_title_default);
                } else {
                    this.kpH.setText(dVar.koH);
                }
            }
            this.kpH.setVisibility(dVar.koG ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.eJQ.bnZ())) {
                Iterator<MediaData> it = dVar.eJQ.bnZ().iterator();
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
            if (!au.equals(str, this.feK.getUrl())) {
                this.feK.reset();
            }
            this.feK.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.eJQ.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.eJQ.getTitle());
            }
            this.kpI.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.eJQ.bnH())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kpJ != null && this.kpJ.eJQ != null) {
            TiebaStatic.log(new ar("c13354").dR("tid", this.kpJ.eJQ.tid).v("topic_id", this.kpJ.topicId).ap("obj_locate", this.kpJ.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.kpJ.eJQ, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.kpJ.eJQ.bpG() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.kpJ.eJQ.getFid()));
                createFromThreadCfg.setForumName(this.kpJ.eJQ.bnU());
            } else {
                createFromThreadCfg.setForumId(this.kpJ.eJQ.bpG().getForumId());
                createFromThreadCfg.setForumName(this.kpJ.eJQ.bpG().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
