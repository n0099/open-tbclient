package com.baidu.tieba.hottopic.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.l, com.baidu.tieba.hottopic.b.g> {
    private HotTopicActivity bJD;
    private a bJK;
    private com.baidu.adp.widget.ListView.v bJL;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public s(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bJK = new a(this, null);
        this.bJL = new t(this);
        this.bJD = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: V */
    public com.baidu.tieba.hottopic.b.g b(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.g(LayoutInflater.from(this.mContext).inflate(t.h.hot_topic_quality_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.l lVar, com.baidu.tieba.hottopic.b.g gVar) {
        if (lVar != null && gVar != null) {
            a(gVar, view);
            a(gVar, lVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.g gVar, View view) {
        if (gVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.bJD != null && gVar.ahU != this.mSkinType) {
                gVar.ahU = this.mSkinType;
                ar.k(gVar.getView(), t.f.list_item_selector);
                ar.b(gVar.bMj, t.d.cp_cont_c, 1);
                ar.b(gVar.aQR, t.d.cp_cont_b, 1);
                ar.b(gVar.bMs, t.d.cp_cont_d, 1);
                ar.l(gVar.bMq, t.d.cp_bg_line_b);
                ar.l(gVar.bMi, t.d.cp_bg_line_c);
                gVar.bMr.setImageDrawable(null);
                this.bJD.getLayoutMode().ac(this.mSkinType == 1);
                this.bJD.getLayoutMode().x(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.b.g gVar, com.baidu.tieba.hottopic.data.l lVar) {
        if (gVar != null && lVar != null) {
            if (lVar.XX()) {
                gVar.bMi.setVisibility(0);
                gVar.bMj.setVisibility(0);
                gVar.bMq.setVisibility(8);
                gVar.bMp.setVisibility(8);
                gVar.bMj.setText(lVar.bKA.trim());
                ar.l(gVar.getView(), t.d.cp_bg_line_d);
                return;
            }
            gVar.bMi.setVisibility(8);
            gVar.bMj.setVisibility(8);
            gVar.bMq.setVisibility(0);
            gVar.bMp.setVisibility(0);
            gVar.bMr.d(lVar.bLC, 10, false);
            gVar.aQR.setText(lVar.title.trim());
            gVar.bMs.setText(lVar.summary.trim());
            gVar.bMt.setText(TbadkCoreApplication.m411getInst().getString(t.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(lVar.fname, 7, false)}));
            gVar.bMu.setText(aw.x(lVar.bLB));
            gVar.bMv.setText(aw.y(lVar.bLA));
            b(gVar, lVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.b.g gVar, com.baidu.tieba.hottopic.data.l lVar) {
        if (gVar != null && lVar != null && this.bJD != null) {
            a(this.bJL);
            this.bJK.aC(TbadkCoreApplication.m411getInst().getString(t.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(lVar.fname, 7, false)}), String.valueOf(lVar.fid));
            gVar.bMt.setOnClickListener(this.bJK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private String fid;
        private String forumName;

        private a() {
        }

        /* synthetic */ a(s sVar, a aVar) {
            this();
        }

        public void aC(String str, String str2) {
            this.forumName = str;
            this.fid = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (aw.aQ(this.forumName)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(s.this.mContext).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new au("c10523").aa(ImageViewerConfig.FORUM_ID, this.fid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.hottopic.data.l lVar) {
        if (lVar != null && !lVar.XX()) {
            String valueOf = String.valueOf(lVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bJD.getActivity()).createNormalCfg(valueOf, String.valueOf(lVar.postId), HotTopicActivityConfig.ST_TYPE)));
            TiebaStatic.log(new au("c10522").aa("tid", valueOf).aa("obj_id", this.bJD.XB()));
        }
    }
}
