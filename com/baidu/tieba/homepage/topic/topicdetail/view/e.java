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
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView eXC;
    private CellTopicLinearLayout jYT;
    private TextView jYU;
    private TextView jYV;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d jYW;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jYT = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.jYU = (TextView) view.findViewById(R.id.topic_special_title);
        this.eXC = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.jYV = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eXC.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eXC.setConrers(15);
        this.eXC.setPlaceHolder(2);
        this.jYT.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jYU, R.color.CAM_X0105);
            this.eXC.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
            ap.setViewTextColor(this.jYV, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.eCR != null) {
            this.jYW = dVar;
            if (dVar.jXS) {
                if (StringUtils.isNull(dVar.jXT)) {
                    this.jYU.setText(R.string.topic_special_title_default);
                } else {
                    this.jYU.setText(dVar.jXT);
                }
            }
            this.jYU.setVisibility(dVar.jXS ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.eCR.boY())) {
                Iterator<MediaData> it = dVar.eCR.boY().iterator();
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
            if (!au.equals(str, this.eXC.getUrl())) {
                this.eXC.reset();
            }
            this.eXC.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.eCR.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.eCR.getTitle());
            }
            this.jYV.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.eCR.boG())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jYW != null && this.jYW.eCR != null) {
            TiebaStatic.log(new ar("c13354").dY("tid", this.jYW.eCR.tid).w("topic_id", this.jYW.topicId).al("obj_locate", this.jYW.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.jYW.eCR, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.jYW.eCR.bqF() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.jYW.eCR.getFid()));
                createFromThreadCfg.setForumName(this.jYW.eCR.boT());
            } else {
                createFromThreadCfg.setForumId(this.jYW.eCR.bqF().getForumId());
                createFromThreadCfg.setForumName(this.jYW.eCR.bqF().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
