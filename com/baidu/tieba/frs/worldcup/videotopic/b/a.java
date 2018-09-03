package com.baidu.tieba.frs.worldcup.videotopic.b;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoTopicActivityConfig;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.worldcup.talkball.b.f;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private TextView awW;
    private View bkJ;
    private ForbidParentSwipeBackLinearLayout dMR;
    private LinearLayout dMS;
    private TextView dMT;
    private ImageView dMU;
    private c dMV;
    private f dMW;
    private String mForumId;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dMR = (ForbidParentSwipeBackLinearLayout) view.findViewById(f.g.video_topic_root);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(f.g.list);
        this.dMT = (TextView) view.findViewById(f.g.video_topic);
        this.dMS = (LinearLayout) view.findViewById(f.g.top_view);
        this.awW = (TextView) view.findViewById(f.g.more);
        this.bkJ = view.findViewById(f.g.divider_line);
        this.dMU = (ImageView) view.findViewById(f.g.image_go);
        this.dMV = new c(this.mTbPageContext);
        recyclerView.setAdapter(this.dMV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.frs.worldcup.talkball.b.f fVar) {
        if (fVar != null) {
            this.dMW = fVar;
            if (ap.isEmpty(fVar.getTopicName())) {
                this.dMT.setText(f.j.frs_video_topic);
            } else {
                this.dMT.setText(fVar.getTopicName());
                this.dMV.setTopicName(fVar.getTopicName());
            }
            if (fVar.aBH() != null) {
                this.dMV.setData(fVar.aBH());
                this.dMV.notifyDataSetChanged();
            }
            this.dMR.setOnClickListener(this);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.dMR, f.C0146f.addresslist_item_bg);
            am.i(this.dMS, f.C0146f.addresslist_item_bg);
            am.i(this.dMU, f.C0146f.icon_arrow12_gray60_right);
            am.h(this.dMT, f.d.cp_cont_f);
            am.h(this.awW, f.d.cp_cont_f);
            am.j(this.bkJ, f.d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.card_insert_video_topic_layout;
    }

    public void setForumId(String str) {
        this.mForumId = str;
        this.dMV.setForumId(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dMW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003021, new VideoTopicActivityConfig(this.mContext).createNormalCfg(this.dMW.aBG().intValue(), this.dMW.getTopicName(), this.mForumId)));
        }
    }
}
