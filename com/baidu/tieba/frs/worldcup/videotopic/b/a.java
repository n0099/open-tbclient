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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.layout.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.worldcup.talkball.b.f;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private TextView aJI;
    private View bzG;
    private ImageView enA;
    private c enB;
    private f enC;
    private ForbidParentSwipeBackLinearLayout enx;
    private LinearLayout eny;
    private TextView enz;
    private String mForumId;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.enx = (ForbidParentSwipeBackLinearLayout) view.findViewById(e.g.video_topic_root);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(e.g.list);
        this.enz = (TextView) view.findViewById(e.g.video_topic);
        this.eny = (LinearLayout) view.findViewById(e.g.top_view);
        this.aJI = (TextView) view.findViewById(e.g.more);
        this.bzG = view.findViewById(e.g.divider_line);
        this.enA = (ImageView) view.findViewById(e.g.image_go);
        this.enB = new c(this.mTbPageContext);
        recyclerView.setAdapter(this.enB);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null) {
            this.enC = fVar;
            if (ao.isEmpty(fVar.getTopicName())) {
                this.enz.setText(e.j.frs_video_topic);
            } else {
                this.enz.setText(fVar.getTopicName());
                this.enB.setTopicName(fVar.getTopicName());
            }
            if (fVar.aJJ() != null) {
                this.enB.setData(fVar.aJJ());
                this.enB.notifyDataSetChanged();
            }
            this.enx.setOnClickListener(this);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            al.i(this.enx, e.f.addresslist_item_bg);
            al.i(this.eny, e.f.addresslist_item_bg);
            al.i(this.enA, e.f.icon_arrow12_gray60_right);
            al.h(this.enz, e.d.cp_cont_f);
            al.h(this.aJI, e.d.cp_cont_f);
            al.j(this.bzG, e.d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.card_insert_video_topic_layout;
    }

    public void setForumId(String str) {
        this.mForumId = str;
        this.enB.setForumId(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.enC != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003021, new VideoTopicActivityConfig(this.mContext).createNormalCfg(this.enC.aJI().intValue(), this.enC.getTopicName(), this.mForumId)));
        }
    }
}
