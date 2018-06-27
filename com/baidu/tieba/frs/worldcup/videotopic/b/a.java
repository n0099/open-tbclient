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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.ForbidParentSwipeBackLinearLayout;
import com.baidu.tieba.frs.worldcup.talkball.b.f;
/* loaded from: classes2.dex */
public class a extends com.baidu.tieba.card.a<f> {
    private TextView axt;
    private View bjZ;
    private ForbidParentSwipeBackLinearLayout dKf;
    private LinearLayout dKg;
    private TextView dKh;
    private ImageView dKi;
    private c dKj;
    private f dKk;
    private String mForumId;

    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mTbPageContext = tbPageContext;
        View view = getView();
        this.dKf = (ForbidParentSwipeBackLinearLayout) view.findViewById(d.g.video_topic_root);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(d.g.list);
        this.dKh = (TextView) view.findViewById(d.g.video_topic);
        this.dKg = (LinearLayout) view.findViewById(d.g.top_view);
        this.axt = (TextView) view.findViewById(d.g.more);
        this.bjZ = view.findViewById(d.g.divider_line);
        this.dKi = (ImageView) view.findViewById(d.g.image_go);
        this.dKj = new c(this.mTbPageContext);
        recyclerView.setAdapter(this.dKj);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.mTbPageContext.getPageActivity(), 0, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(f fVar) {
        if (fVar != null) {
            this.dKk = fVar;
            if (ap.isEmpty(fVar.getTopicName())) {
                this.dKh.setText(d.k.frs_video_topic);
            } else {
                this.dKh.setText(fVar.getTopicName());
                this.dKj.setTopicName(fVar.getTopicName());
            }
            if (fVar.aBb() != null) {
                this.dKj.setData(fVar.aBb());
                this.dKj.notifyDataSetChanged();
            }
            this.dKf.setOnClickListener(this);
            d(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.i(this.dKf, d.f.addresslist_item_bg);
            am.i(this.dKg, d.f.addresslist_item_bg);
            am.i(this.dKi, d.f.icon_arrow12_gray60_right);
            am.h(this.dKh, d.C0142d.cp_cont_f);
            am.h(this.axt, d.C0142d.cp_cont_f);
            am.j(this.bjZ, d.C0142d.cp_bg_line_e);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.i.card_insert_video_topic_layout;
    }

    public void setForumId(String str) {
        this.mForumId = str;
        this.dKj.setForumId(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dKk != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2003021, new VideoTopicActivityConfig(this.mContext).createNormalCfg(this.dKk.aBa().intValue(), this.dKk.getTopicName(), this.mForumId)));
        }
    }
}
