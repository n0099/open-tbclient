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
    private TbImageView fhd;
    private CellTopicLinearLayout kme;
    private TextView kmf;
    private TextView kmg;
    private com.baidu.tieba.homepage.topic.topicdetail.a.d kmh;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.kme = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.kmf = (TextView) view.findViewById(R.id.topic_special_title);
        this.fhd = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.kmg = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.fhd.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fhd.setConrers(15);
        this.fhd.setPlaceHolder(2);
        this.kme.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ao.setViewTextColor(this.kmf, R.color.CAM_X0105);
            this.fhd.setIsNight(this.mSkinType == 1);
            ao.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
            ao.setViewTextColor(this.kmg, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.a.d dVar) {
        if (dVar != null && dVar.eMv != null) {
            this.kmh = dVar;
            if (dVar.kle) {
                if (StringUtils.isNull(dVar.klf)) {
                    this.kmf.setText(R.string.topic_special_title_default);
                } else {
                    this.kmf.setText(dVar.klf);
                }
            }
            this.kmf.setVisibility(dVar.kle ? 0 : 8);
            String str = null;
            if (!x.isEmpty(dVar.eMv.brz())) {
                Iterator<MediaData> it = dVar.eMv.brz().iterator();
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
            if (!at.equals(str, this.fhd.getUrl())) {
                this.fhd.reset();
            }
            this.fhd.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.eMv.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.eMv.getTitle());
            }
            this.kmg.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.eMv.brh())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kmh != null && this.kmh.eMv != null) {
            TiebaStatic.log(new aq("c13354").dX("tid", this.kmh.eMv.tid).w("topic_id", this.kmh.topicId).an("obj_locate", this.kmh.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.kmh.eMv, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.kmh.eMv.bth() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.kmh.eMv.getFid()));
                createFromThreadCfg.setForumName(this.kmh.eMv.bru());
            } else {
                createFromThreadCfg.setForumId(this.kmh.eMv.bth().getForumId());
                createFromThreadCfg.setForumName(this.kmh.eMv.bth().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
