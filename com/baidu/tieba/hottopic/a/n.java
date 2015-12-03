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
    private com.baidu.adp.widget.ListView.v bCG;
    private a bCL;
    private HotTopicActivity bCu;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public n(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bCL = new a(this, null);
        this.bCG = new o(this);
        this.bCu = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: T */
    public com.baidu.tieba.hottopic.b.e a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.e(LayoutInflater.from(this.mContext).inflate(n.g.hot_topic_quality_item, viewGroup, false));
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
            if (this.bCu != null && eVar.afY != this.mSkinType) {
                eVar.afY = this.mSkinType;
                as.i(eVar.getView(), n.e.list_item_selector);
                as.b(eVar.bET, n.c.cp_cont_c, 1);
                as.b(eVar.aNy, n.c.cp_cont_b, 1);
                as.b(eVar.bFb, n.c.cp_cont_d, 1);
                as.j(eVar.bEY, n.c.cp_bg_line_b);
                as.j(eVar.bES, n.c.cp_bg_line_c);
                eVar.bFa.setImageDrawable(null);
                this.bCu.getLayoutMode().af(this.mSkinType == 1);
                this.bCu.getLayoutMode().k(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.b.e eVar, com.baidu.tieba.hottopic.data.i iVar) {
        if (eVar != null && iVar != null) {
            if (iVar.UA()) {
                eVar.bES.setVisibility(0);
                eVar.bET.setVisibility(0);
                eVar.bEY.setVisibility(8);
                eVar.bEZ.setVisibility(8);
                eVar.bET.setText(iVar.bDw.trim());
                as.j(eVar.getView(), n.c.cp_bg_line_d);
                return;
            }
            eVar.bES.setVisibility(8);
            eVar.bET.setVisibility(8);
            eVar.bEY.setVisibility(0);
            eVar.bEZ.setVisibility(0);
            eVar.bFa.d(iVar.bEu, 10, false);
            eVar.aNy.setText(iVar.title.trim());
            eVar.bFb.setText(iVar.summary.trim());
            eVar.bFc.setText(TbadkCoreApplication.m411getInst().getString(n.i.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(iVar.fname, 7, false)}));
            eVar.bFd.setText(ax.v(iVar.bAH));
            eVar.bFe.setText(ax.w(iVar.bEt));
            b(eVar, iVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.b.e eVar, com.baidu.tieba.hottopic.data.i iVar) {
        if (eVar != null && iVar != null && this.bCu != null) {
            a(this.bCG);
            this.bCL.aF(TbadkCoreApplication.m411getInst().getString(n.i.chosen_pb_original_bar, new Object[]{UtilHelper.getFixedText(iVar.fname, 7, false)}), String.valueOf(iVar.Wg));
            eVar.bFc.setOnClickListener(this.bCL);
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

        public void aF(String str, String str2) {
            this.forumName = str;
            this.fid = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ax.aR(this.forumName)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(n.this.mContext).createNormalCfg(this.forumName, FrsActivityConfig.FRS_FROM_RECOMMEND)));
                TiebaStatic.log(new av("c10523").ab(ImageViewerConfig.FORUM_ID, this.fid));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.hottopic.data.i iVar) {
        if (iVar != null && !iVar.UA()) {
            String valueOf = String.valueOf(iVar.tid);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.bCu.getActivity()).createNormalCfg(valueOf, String.valueOf(iVar.postId), HotTopicActivityConfig.ST_TYPE)));
            TiebaStatic.log(new av("c10522").ab("tid", valueOf).ab("obj_id", this.bCu.Ul()));
        }
    }
}
