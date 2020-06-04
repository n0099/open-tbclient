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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.view.CellTopicLinearLayout;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.topic.topicdetail.b.d> {
    private TbImageView dRP;
    private CellTopicLinearLayout iil;
    private TextView iim;
    private TextView iin;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d iio;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.iil = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.iim = (TextView) view.findViewById(R.id.topic_special_title);
        this.dRP = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.iin = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.dRP.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.dRP.setConrers(15);
        this.dRP.setPlaceHolder(2);
        this.iil.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            am.setViewTextColor(this.iim, (int) R.color.cp_cont_b);
            this.dRP.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.mTitleView, (int) R.color.cp_cont_f);
            am.setViewTextColor(this.iin, (int) R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.dEA != null) {
            this.iio = dVar;
            if (dVar.ihl) {
                if (StringUtils.isNull(dVar.ihm)) {
                    this.iim.setText(R.string.topic_special_title_default);
                } else {
                    this.iim.setText(dVar.ihm);
                }
            }
            this.iim.setVisibility(dVar.ihl ? 0 : 8);
            String str = null;
            if (!v.isEmpty(dVar.dEA.aQH())) {
                Iterator<MediaData> it = dVar.dEA.aQH().iterator();
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
            if (!aq.equals(str, this.dRP.getUrl())) {
                this.dRP.reset();
            }
            this.dRP.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.dEA.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.dEA.getTitle());
            }
            this.iin.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.dEA.aQo())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iio != null && this.iio.dEA != null) {
            TiebaStatic.log(new an("c13354").dh("tid", this.iio.dEA.tid).s("topic_id", this.iio.topicId).ag("obj_locate", this.iio.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.iio.dEA, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.iio.dEA.aSm() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.iio.dEA.getFid()));
                createFromThreadCfg.setForumName(this.iio.dEA.aQC());
            } else {
                createFromThreadCfg.setForumId(this.iio.dEA.aSm().getForumId());
                createFromThreadCfg.setForumName(this.iio.dEA.aSm().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
