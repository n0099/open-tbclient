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
    private HotTopicActivity bFY;
    private com.baidu.adp.widget.ListView.v bGk;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public k(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bGk = new l(this);
        this.bFY = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: N */
    public com.baidu.tieba.hottopic.b.d a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.d(LayoutInflater.from(this.mContext).inflate(n.h.hot_topic_magicpost_item, viewGroup, false));
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
            if (this.bFY != null && dVar.ahf != this.mSkinType) {
                dVar.ahf = this.mSkinType;
                as.i(dVar.getView(), n.f.list_item_selector);
                as.b(dVar.bIx, n.d.cp_cont_c, 1);
                as.b(dVar.bIA, n.d.cp_cont_f, 1);
                as.b(dVar.bIB, n.d.cp_cont_d, 1);
                as.b(dVar.bIC, n.d.cp_cont_e, 1);
                as.b(dVar.bID, n.d.cp_cont_b, 1);
                as.j(dVar.bIE, n.d.cp_bg_line_b);
                as.j(dVar.bIw, n.d.cp_bg_line_c);
                dVar.bIz.setImageDrawable(null);
                this.bFY.getLayoutMode().ac(this.mSkinType == 1);
                this.bFY.getLayoutMode().k(view);
            }
        }
    }

    private void a(com.baidu.tieba.hottopic.b.d dVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (dVar != null && gVar != null) {
            if (gVar.VD()) {
                dVar.bIw.setVisibility(0);
                dVar.bIx.setVisibility(0);
                dVar.bIE.setVisibility(8);
                dVar.bIy.setVisibility(8);
                dVar.bIC.setVisibility(8);
                dVar.bID.setVisibility(8);
                gVar.bHJ = gVar.bHJ.trim();
                StringBuilder sb = new StringBuilder();
                if (gVar.bHJ.length() > 23) {
                    String substring = gVar.bHJ.substring(1, 19);
                    sb.append(gVar.bHJ.charAt(0));
                    sb.append(substring);
                    sb.append("...");
                    sb.append(gVar.bHJ.charAt(gVar.bHJ.length() - 1));
                    dVar.bIx.setText(sb);
                } else {
                    dVar.bIx.setText(gVar.bHJ);
                }
                as.j(dVar.getView(), n.d.cp_bg_line_d);
                return;
            }
            dVar.bIw.setVisibility(8);
            dVar.bIx.setVisibility(8);
            dVar.bIy.setVisibility(0);
            dVar.bIC.setVisibility(0);
            dVar.bID.setVisibility(0);
            dVar.bIE.setVisibility(0);
            dVar.bIA.setText(ax.d(gVar.bHL.trim(), 14, "..."));
            dVar.bIB.setText(ax.s(gVar.bHN * 1000));
            dVar.bIC.setText(TbadkCoreApplication.m411getInst().getString(n.j.magic_post_comment));
            dVar.bID.setMaxLines(2);
            dVar.bID.setEllipsize(TextUtils.TruncateAt.END);
            dVar.bID.setText(gVar.bHO);
            dVar.bIz.setUserId(String.valueOf(gVar.bHM));
            dVar.bIz.d(gVar.bHK, 12, false);
            b(dVar, gVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.b.d dVar, com.baidu.tieba.hottopic.data.g gVar) {
        if (dVar != null && gVar != null && this.bFY != null) {
            String valueOf = String.valueOf(gVar.bHM);
            String str = gVar.bHL;
            String valueOf2 = String.valueOf(gVar.postId);
            a(this.bGk);
            dVar.bIy.setOnClickListener(new m(this, valueOf, str, valueOf2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.hottopic.data.g gVar) {
        if (gVar == null || gVar.VD()) {
            return false;
        }
        String valueOf = String.valueOf(gVar.threadId);
        String valueOf2 = String.valueOf(gVar.postId);
        TiebaStatic.log(new av("c10366").aa("post_id", valueOf2).aa("obj_type", "2").aa("obj_id", this.bFY.Vo()));
        if (!gVar.bHQ) {
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bFY.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, true, true)));
        }
        String valueOf3 = String.valueOf(gVar.bHR);
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bFY.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, false, gVar.bHL, true, valueOf3, 0)));
    }
}
