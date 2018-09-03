package com.baidu.tieba.frs.worldcup.videotopic.b;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.worldcup.talkball.b.g;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends RecyclerView.Adapter<b> {
    private List<g> mData;
    private String mForumId;
    private TbPageContext<?> mPageContext;
    private String mTopicName;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mTopicName = this.mPageContext.getString(f.j.frs_video_topic);
    }

    public void setData(List<g> list) {
        this.mData = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: p */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(new com.baidu.tieba.frs.worldcup.videotopic.b.b(this.mPageContext));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: a */
    public void onBindViewHolder(b bVar, int i) {
        g gVar;
        if (bVar != null && bVar.aBW() != null && this.mData != null && (gVar = this.mData.get(i)) != null) {
            int i2 = i + 1;
            bVar.aBW().a(gVar);
            bVar.aBW().getRootView().setOnClickListener(new a(gVar, i2));
            TiebaStatic.log(new an("c13087").r("obj_locate", i2).ae("obj_name", this.mTopicName).ae(ImageViewerConfig.FORUM_ID, this.mForumId).ae("obj_param1", gVar.aBK()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        private int cBI;
        private g dMZ;

        public a(g gVar, int i) {
            this.dMZ = gVar;
            this.cBI = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dMZ != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(c.this.mPageContext.getPageActivity());
                pbActivityConfig.createNormalCfg(this.dMZ.getThreadId(), this.dMZ.aBK(), "frs_page");
                c.this.mPageContext.sendMessage(new CustomMessage(2004001, pbActivityConfig));
                TiebaStatic.log(new an("c13088").r("obj_locate", this.cBI).ae("obj_name", c.this.mTopicName).ae(ImageViewerConfig.FORUM_ID, c.this.mForumId).ae("obj_param1", this.dMZ.aBK()));
            }
        }
    }

    public void setTopicName(String str) {
        if (!ap.isEmpty(str)) {
            this.mTopicName = str;
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* loaded from: classes3.dex */
    public static class b extends RecyclerView.ViewHolder {
        private com.baidu.tieba.frs.worldcup.videotopic.b.b dNb;

        public b(com.baidu.tieba.frs.worldcup.videotopic.b.b bVar) {
            super(bVar.getView());
            this.dNb = bVar;
        }

        public com.baidu.tieba.frs.worldcup.videotopic.b.b aBW() {
            return this.dNb;
        }
    }
}
