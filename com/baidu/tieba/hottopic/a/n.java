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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.i, com.baidu.tieba.hottopic.b.e> {
    private HotTopicActivity bFY;
    private com.baidu.adp.widget.ListView.v bGk;
    private a bGp;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bGp = new a(this, null);
        this.bGk = new o(this);
        this.bFY = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: O */
    public com.baidu.tieba.hottopic.b.e a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.e(LayoutInflater.from(this.mContext).inflate(n.h.hot_topic_quality_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.i iVar, com.baidu.tieba.hottopic.b.e eVar) {
        if (iVar != null && eVar != null) {
            a(eVar, view);
            a(eVar, iVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.e eVar, View view) {
        if (eVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.bFY != null && eVar.ahf != this.mSkinType) {
                eVar.ahf = this.mSkinType;
                as.i(eVar.getView(), n.f.list_item_selector);
                as.b(eVar.bIx, n.d.cp_cont_c, 1);
                as.b(eVar.aOS, n.d.cp_cont_b, 1);
                as.b(eVar.bIH, n.d.cp_cont_d, 1);
                as.j(eVar.bIE, n.d.cp_bg_line_b);
                as.j(eVar.bIw, n.d.cp_bg_line_c);
                eVar.bIG.setImageDrawable(null);
                this.bFY.getLayoutMode().ac(this.mSkinType == 1);
                this.bFY.getLayoutMode().k(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.b.e eVar, com.baidu.tieba.hottopic.data.i iVar) {
        if (eVar != null && iVar != null) {
            if (iVar.VD()) {
                eVar.bIw.setVisibility(0);
                eVar.bIx.setVisibility(0);
                eVar.bIE.setVisibility(8);
                eVar.bIF.setVisibility(8);
                eVar.bIx.setText(iVar.bHa.trim());
                as.j(eVar.getView(), n.d.cp_bg_line_d);
                return;
            }
            eVar.bIw.setVisibility(8);
            eVar.bIx.setVisibility(8);
            eVar.bIE.setVisibility(0);
            eVar.bIF.setVisibility(0);
            eVar.bIG.d(iVar.bHY, 10, false);
            eVar.aOS.setText(iVar.title.trim());
            eVar.bIH.setText(iVar.summary.trim());
            eVar.bII.setText(TbadkCoreApplication.m411getInst().getString(n.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(iVar.fname, 7, false)}));
            eVar.bIJ.setText(ax.w(iVar.bHX));
            eVar.bIK.setText(ax.x(iVar.bHW));
            b(eVar, iVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.b.e eVar, com.baidu.tieba.hottopic.data.i iVar) {
        if (eVar != null && iVar != null && this.bFY != null) {
            a(this.bGk);
            this.bGp.az(TbadkCoreApplication.m411getInst().getString(n.j.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(iVar.fname, 7, false)}), String.valueOf(iVar.WH));
            eVar.bII.setOnClickListener(this.bGp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private String fid;
        private String forumName;

        private a() {
        }

        /* synthetic */ a(n nVar, a aVar) {
            this();
        }

        public void az(String str, String str2) {
            this.forumName = str;
            this.fid = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ax.aR(this.forumName)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new av("c10523").aa(ImageViewerConfig.FORUM_ID, this.fid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.hottopic.data.i iVar) {
        if (iVar != null && !iVar.VD()) {
            String valueOf = String.valueOf(iVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bFY.getActivity()).createNormalCfg(valueOf, String.valueOf(iVar.postId), HotTopicActivityConfig.ST_TYPE)));
            TiebaStatic.log(new av("c10522").aa("tid", valueOf).aa("obj_id", this.bFY.Vo()));
        }
    }
}
