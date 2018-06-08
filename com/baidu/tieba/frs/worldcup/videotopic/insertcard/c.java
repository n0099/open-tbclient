package com.baidu.tieba.frs.worldcup.videotopic.insertcard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.worldcup.talkball.b.g;
import java.util.List;
/* loaded from: classes2.dex */
public class c extends RecyclerView.Adapter<b> {
    private List<g> mData;
    private String mForumId;
    private TbPageContext<?> mPageContext;
    private String mTopicName;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mTopicName = this.mPageContext.getString(d.k.frs_video_topic);
    }

    public void setData(List<g> list) {
        this.mData = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: l */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(new com.baidu.tieba.frs.worldcup.videotopic.insertcard.b(this.mPageContext));
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
        if (bVar != null && bVar.aAK() != null && this.mData != null && (gVar = this.mData.get(i)) != null) {
            int i2 = i + 1;
            bVar.aAK().a(gVar);
            bVar.aAK().aAJ().setOnClickListener(new a(gVar, i2));
            TiebaStatic.log(new am("c13087").r("obj_locate", i2).ah("obj_name", this.mTopicName).ah(ImageViewerConfig.FORUM_ID, this.mForumId).ah("obj_param1", gVar.aAx()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        private int cBm;
        private g dGU;

        public a(g gVar, int i) {
            this.dGU = gVar;
            this.cBm = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.dGU != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(c.this.mPageContext.getPageActivity());
                pbActivityConfig.createNormalCfg(this.dGU.getThreadId(), this.dGU.aAx(), "frs_page");
                c.this.mPageContext.sendMessage(new CustomMessage(2004001, pbActivityConfig));
                TiebaStatic.log(new am("c13088").r("obj_locate", this.cBm).ah("obj_name", c.this.mTopicName).ah(ImageViewerConfig.FORUM_ID, c.this.mForumId).ah("obj_param1", this.dGU.aAx()));
            }
        }
    }

    public void setTopicName(String str) {
        if (!ao.isEmpty(str)) {
            this.mTopicName = str;
        }
    }

    public void setForumId(String str) {
        this.mForumId = str;
    }

    /* loaded from: classes2.dex */
    public class b extends RecyclerView.ViewHolder {
        private com.baidu.tieba.frs.worldcup.videotopic.insertcard.b dGW;

        public b(com.baidu.tieba.frs.worldcup.videotopic.insertcard.b bVar) {
            super(bVar.getView());
            this.dGW = bVar;
        }

        public com.baidu.tieba.frs.worldcup.videotopic.insertcard.b aAK() {
            return this.dGW;
        }
    }
}
