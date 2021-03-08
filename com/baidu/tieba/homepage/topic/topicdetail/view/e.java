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
    private TbImageView fgj;
    private CellTopicLinearLayout krW;
    private TextView krX;
    private TextView krY;
    private com.baidu.tieba.homepage.topic.topicdetail.a.d krZ;
    private int mSkinType;
    private TextView mTitleView;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.krW = (CellTopicLinearLayout) view.findViewById(R.id.topic_special_root);
        this.krX = (TextView) view.findViewById(R.id.topic_special_title);
        this.fgj = (TbImageView) view.findViewById(R.id.topic_special_thread_img);
        this.mTitleView = (TextView) view.findViewById(R.id.topic_special_thread_title);
        this.krY = (TextView) view.findViewById(R.id.topic_special_thread_discuss);
        this.fgj.setRadius(l.getDimens(this.mContext, R.dimen.tbds10));
        this.fgj.setConrers(15);
        this.fgj.setPlaceHolder(2);
        this.krW.setTopicOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            this.mSkinType = i;
            ap.setViewTextColor(this.krX, R.color.CAM_X0105);
            this.fgj.setIsNight(this.mSkinType == 1);
            ap.setViewTextColor(this.mTitleView, R.color.CAM_X0106);
            ap.setViewTextColor(this.krY, R.color.CAM_X0109);
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_topic_special_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.topic.topicdetail.a.d dVar) {
        if (dVar != null && dVar.eLr != null) {
            this.krZ = dVar;
            if (dVar.kqW) {
                if (StringUtils.isNull(dVar.kqX)) {
                    this.krX.setText(R.string.topic_special_title_default);
                } else {
                    this.krX.setText(dVar.kqX);
                }
            }
            this.krX.setVisibility(dVar.kqW ? 0 : 8);
            String str = null;
            if (!y.isEmpty(dVar.eLr.bob())) {
                Iterator<MediaData> it = dVar.eLr.bob().iterator();
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
            if (!au.equals(str, this.fgj.getUrl())) {
                this.fgj.reset();
            }
            this.fgj.startLoad(str, 10, false);
            if (StringUtils.isNull(dVar.eLr.getTitle())) {
                this.mTitleView.setVisibility(8);
            } else {
                this.mTitleView.setVisibility(0);
                this.mTitleView.setText(dVar.eLr.getTitle());
            }
            this.krY.setText(String.format(this.mContext.getString(R.string.topic_discuss_default), Integer.valueOf(dVar.eLr.bnJ())));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.krZ != null && this.krZ.eLr != null) {
            TiebaStatic.log(new ar("c13354").dR("tid", this.krZ.eLr.tid).v("topic_id", this.krZ.topicId).aq("obj_locate", this.krZ.index));
            PbActivityConfig createFromThreadCfg = new PbActivityConfig(this.mTbPageContext.getPageActivity()).createFromThreadCfg(this.krZ.eLr, null, "", RequestResponseCode.REQUEST_PERSONCENTER_TO_PB, true, false, false);
            if (this.krZ.eLr.bpI() == null) {
                createFromThreadCfg.setForumId(String.valueOf(this.krZ.eLr.getFid()));
                createFromThreadCfg.setForumName(this.krZ.eLr.bnW());
            } else {
                createFromThreadCfg.setForumId(this.krZ.eLr.bpI().getForumId());
                createFromThreadCfg.setForumName(this.krZ.eLr.bpI().getForumName());
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createFromThreadCfg));
        }
    }
}
