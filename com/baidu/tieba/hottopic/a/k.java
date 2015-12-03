package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class k extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.g, com.baidu.tieba.hottopic.b.d> {
    private com.baidu.adp.widget.ListView.v bCG;
    private HotTopicActivity bCu;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bCG = new l(this);
        this.bCu = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: S */
    public com.baidu.tieba.hottopic.b.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.d(LayoutInflater.from(this.mContext).inflate(n.g.hot_topic_magicpost_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.g gVar, com.baidu.tieba.hottopic.b.d dVar) {
        if (gVar != null && dVar != null) {
            a(dVar, view);
            a(dVar, gVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar, View view) {
        if (dVar != null) {
            this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (this.bCu != null && dVar.afY != this.mSkinType) {
                dVar.afY = this.mSkinType;
                as.i(dVar.getView(), n.e.list_item_selector);
                as.b(dVar.bET, n.c.cp_cont_c, 1);
                as.b(dVar.bEW, n.c.cp_cont_f, 1);
                as.b(dVar.bEX, n.c.cp_cont_d, 1);
                as.b(dVar.bAN, n.c.cp_cont_e, 1);
                as.b(dVar.bBB, n.c.cp_cont_b, 1);
                as.j(dVar.bEY, n.c.cp_bg_line_b);
                as.j(dVar.bES, n.c.cp_bg_line_c);
                dVar.bEV.setImageDrawable(null);
                this.bCu.getLayoutMode().af(this.mSkinType == 1);
                this.bCu.getLayoutMode().k(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (dVar != null && gVar != null) {
            if (gVar.UA()) {
                dVar.bES.setVisibility(0);
                dVar.bET.setVisibility(0);
                dVar.bEY.setVisibility(8);
                dVar.bEU.setVisibility(8);
                dVar.bAN.setVisibility(8);
                dVar.bBB.setVisibility(8);
                gVar.bEg = gVar.bEg.trim();
                StringBuilder sb = new StringBuilder();
                if (gVar.bEg.length() > 23) {
                    String substring = gVar.bEg.substring(1, 19);
                    sb.append(gVar.bEg.charAt(0));
                    sb.append(substring);
                    sb.append("...");
                    sb.append(gVar.bEg.charAt(gVar.bEg.length() - 1));
                    dVar.bET.setText(sb);
                } else {
                    dVar.bET.setText(gVar.bEg);
                }
                as.j(dVar.getView(), n.c.cp_bg_line_d);
                return;
            }
            dVar.bES.setVisibility(8);
            dVar.bET.setVisibility(8);
            dVar.bEU.setVisibility(0);
            dVar.bAN.setVisibility(0);
            dVar.bBB.setVisibility(0);
            dVar.bEY.setVisibility(0);
            dVar.bEW.setText(ax.d(gVar.bEi.trim(), 14, "..."));
            dVar.bEX.setText(ax.s(gVar.bEk * 1000));
            dVar.bAN.setText(TbadkCoreApplication.m411getInst().getString(n.i.magic_post_comment));
            dVar.bBB.setMaxLines(2);
            dVar.bBB.setEllipsize(TextUtils.TruncateAt.END);
            dVar.bBB.setText(gVar.bEl);
            dVar.bEV.setUserId(String.valueOf(gVar.bEj));
            dVar.bEV.d(gVar.bEh, 12, false);
            b(dVar, gVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.b.d dVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (dVar != null && gVar != null && this.bCu != null) {
            String valueOf = String.valueOf(gVar.bEj);
            String str = gVar.bEi;
            String valueOf2 = String.valueOf(gVar.postId);
            a(this.bCG);
            dVar.bEU.setOnClickListener(new m(this, valueOf, str, valueOf2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.hottopic.data.g gVar) {
        if (gVar == null || gVar.UA()) {
            return false;
        }
        String valueOf = String.valueOf(gVar.threadId);
        String valueOf2 = String.valueOf(gVar.postId);
        TiebaStatic.log(new av("c10366").ab("post_id", valueOf2).ab("obj_type", "2").ab("obj_id", this.bCu.Ul()));
        if (!gVar.bEn) {
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bCu.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, true, true)));
        }
        String valueOf3 = String.valueOf(gVar.bEo);
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bCu.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, false, gVar.bEi, true, valueOf3, 0)));
    }
}
