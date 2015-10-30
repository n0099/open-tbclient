package com.baidu.tieba.hottopic.a;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.e, com.baidu.tieba.hottopic.b.c> {
    private HotTopicActivity bod;
    private v bol;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.bol = new j(this);
        this.bod = hotTopicActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: A */
    public com.baidu.tieba.hottopic.b.c a(ViewGroup viewGroup) {
        return new com.baidu.tieba.hottopic.b.c(LayoutInflater.from(this.mContext).inflate(i.g.hot_topic_magicpost_item, viewGroup, false));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.e eVar, com.baidu.tieba.hottopic.b.c cVar) {
        if (eVar != null && cVar != null) {
            a(cVar, view);
            a(cVar, eVar);
        }
        return view;
    }

    private void a(com.baidu.tieba.hottopic.b.c cVar, View view) {
        if (cVar != null) {
            an.i(cVar.getView(), i.e.list_item_selector);
            an.b(cVar.bpH, i.c.cp_cont_c, 1);
            an.b(cVar.bpK, i.c.cp_cont_f, 1);
            an.b(cVar.bpL, i.c.cp_cont_d, 1);
            an.b(cVar.bpM, i.c.cp_cont_e, 1);
            an.b(cVar.bpN, i.c.cp_cont_b, 1);
            an.j(cVar.bpO, i.c.cp_bg_line_b);
            an.j(cVar.bpG, i.c.cp_bg_line_c);
            cVar.bpJ.setImageDrawable(null);
            c(cVar.apS, view);
        }
    }

    private void c(int i, View view) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bod != null && i != this.mSkinType) {
            this.bod.getLayoutMode().ad(this.mSkinType == 1);
            this.bod.getLayoutMode().k(view);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.c cVar, com.baidu.tieba.hottopic.data.e eVar) {
        if (cVar != null && eVar != null) {
            if (eVar.QT()) {
                cVar.bpG.setVisibility(0);
                cVar.bpH.setVisibility(0);
                cVar.bpO.setVisibility(8);
                cVar.bpI.setVisibility(8);
                cVar.bpM.setVisibility(8);
                cVar.bpN.setVisibility(8);
                eVar.bpd = eVar.bpd.trim();
                StringBuilder sb = new StringBuilder();
                if (eVar.bpd.length() > 23) {
                    String substring = eVar.bpd.substring(1, 19);
                    sb.append(eVar.bpd.charAt(0));
                    sb.append(substring);
                    sb.append("...");
                    sb.append(eVar.bpd.charAt(eVar.bpd.length() - 1));
                    cVar.bpH.setText(sb);
                } else {
                    cVar.bpH.setText(eVar.bpd);
                }
                an.j(cVar.getView(), i.c.cp_bg_line_d);
                return;
            }
            cVar.bpG.setVisibility(8);
            cVar.bpH.setVisibility(8);
            cVar.bpI.setVisibility(0);
            cVar.bpM.setVisibility(0);
            cVar.bpN.setVisibility(0);
            cVar.bpO.setVisibility(0);
            cVar.bpK.setText(as.d(eVar.bpf.trim(), 14, "..."));
            cVar.bpL.setText(as.m(eVar.bph * 1000));
            cVar.bpM.setText(TbadkCoreApplication.m411getInst().getString(i.h.magic_post_comment));
            cVar.bpN.setMaxLines(2);
            cVar.bpN.setEllipsize(TextUtils.TruncateAt.END);
            cVar.bpN.setText(eVar.bpi);
            cVar.bpJ.setUserId(String.valueOf(eVar.bpg));
            cVar.bpJ.d(eVar.bpe, 12, false);
            b(cVar, eVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.b.c cVar, com.baidu.tieba.hottopic.data.e eVar) {
        if (cVar != null && eVar != null && this.bod != null) {
            String valueOf = String.valueOf(eVar.bpg);
            String str = eVar.bpf;
            String valueOf2 = String.valueOf(eVar.postId);
            a(this.bol);
            cVar.bpI.setOnClickListener(new k(this, valueOf, str, valueOf2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar == null || eVar.QT()) {
            return false;
        }
        String valueOf = String.valueOf(eVar.threadId);
        String valueOf2 = String.valueOf(eVar.postId);
        TiebaStatic.log(new aq("c10366").ae("post_id", valueOf2).ae("obj_type", "2").ae("obj_id", this.bod.QL()));
        if (!eVar.bpk) {
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bod.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, true, true)));
        }
        String valueOf3 = String.valueOf(eVar.bpl);
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bod.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, false, eVar.bpf, true, valueOf3, 0)));
    }
}
