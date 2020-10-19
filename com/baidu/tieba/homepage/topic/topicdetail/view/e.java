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
    private TbImageView eDb;
    private CellTopicLinearLayout jsf;
    private TextView jsg;
    private TextView jsh;
    private com.baidu.tieba.homepage.topic.topicdetail.b.d jsi;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.jsf = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.jsg = (TextView) view.findViewById(R.id.topic_special_title);
        this.eDb = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.jsh = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.eDb.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.eDb.setConrers(15);
        this.eDb.setPlaceHolder(2);
        this.jsf.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jsg, R.color.cp_cont_b);
            this.eDb.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.cp_cont_f);
            ap.setViewTextColor(this.jsh, R.color.cp_cont_d);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.b.d dVar) {
        if (dVar != null && dVar.eji != null) {
            this.jsi = dVar;
            if (dVar.jrf) {
                if (StringUtils.isNull(dVar.jrg)) {
                    this.jsg.setText(R.string.topic_special_title_default);
                } else {
                    this.jsg.setText(dVar.jrg);
                }
            }
            this.jsg.setVisibility(dVar.jrf ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.eji.biq())) {
                Iterator<MediaData> it = dVar.eji.biq().iterator();
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
            if (!at.equals(str, this.eDb.getUrl())) {
                this.eDb.reset();
            }
            this.eDb.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.eji.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.eji.getTitle());
            }
            this.jsh.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.eji.bhY())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jsi != null && this.jsi.eji != null) {
            TiebaStatic.log(new aq("c13354").dK("tid", this.jsi.eji.tid).u("topic_id", this.jsi.topicId).aj("obj_locate", this.jsi.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.jsi.eji, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.jsi.eji.bjV() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.jsi.eji.getFid()));
                createFromThreadCfg.setForumName(this.jsi.eji.bil());
            } else {
                createFromThreadCfg.setForumId(this.jsi.eji.bjV().getForumId());
                createFromThreadCfg.setForumName(this.jsi.eji.bjV().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
