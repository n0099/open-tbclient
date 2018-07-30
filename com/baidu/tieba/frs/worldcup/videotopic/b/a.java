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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.f;
/* loaded from: classes3.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private TextView awZ;
    private View bkE;
    private ForbidParentSwipeBackLinearLayout dMV;
    private LinearLayout dMW;
    private TextView dMX;
    private ImageView dMY;
    private c dMZ;
    private f dNa;
    private String mForumId;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dMV = (ForbidParentSwipeBackLinearLayout) view.findViewById(d.g.video_topic_root);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(d.g.list);
        this.dMX = (TextView) view.findViewById(d.g.video_topic);
        this.dMW = (LinearLayout) view.findViewById(d.g.top_view);
        this.awZ = (TextView) view.findViewById(d.g.more);
        this.bkE = view.findViewById(d.g.divider_line);
        this.dMY = (ImageView) view.findViewById(d.g.image_go);
        this.dMZ = new c(this.mTbPageContext);
        recyclerView.setAdapter(this.dMZ);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null) {
            this.dNa = fVar;
            if (ap.isEmpty(fVar.getTopicName())) {
                this.dMX.setText(d.j.frs_video_topic);
            } else {
                this.dMX.setText(fVar.getTopicName());
                this.dMZ.setTopicName(fVar.getTopicName());
            }
            if (fVar.aBK() != null) {
                this.dMZ.setData(fVar.aBK());
                this.dMZ.notifyDataSetChanged();
            }
            this.dMV.setOnClickListener(this);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.dMV, d.f.addresslist_item_bg);
            am.i(this.dMW, d.f.addresslist_item_bg);
            am.i(this.dMY, d.f.icon_arrow12_gray60_right);
            am.h(this.dMX, d.C0140d.cp_cont_f);
            am.h(this.awZ, d.C0140d.cp_cont_f);
            am.j(this.bkE, d.C0140d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_insert_video_topic_layout;
    }

    public void setForumId(String str) {
        this.mForumId = str;
        this.dMZ.setForumId(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dNa != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003021, new VideoTopicActivityConfig(this.mContext).createNormalCfg(this.dNa.aBJ().intValue(), this.dNa.getTopicName(), this.mForumId)));
        }
    }
}
