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
    private HotTopicActivity boH;
    private v boP;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.boP = new j(this);
        this.boH = hotTopicActivity;
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
            an.b(cVar.bql, i.c.cp_cont_c, 1);
            an.b(cVar.bqo, i.c.cp_cont_f, 1);
            an.b(cVar.bqp, i.c.cp_cont_d, 1);
            an.b(cVar.bqq, i.c.cp_cont_e, 1);
            an.b(cVar.bqr, i.c.cp_cont_b, 1);
            an.j(cVar.bqs, i.c.cp_bg_line_b);
            an.j(cVar.bqk, i.c.cp_bg_line_c);
            cVar.bqn.setImageDrawable(null);
            c(cVar.arf, view);
        }
    }

    private void c(int i, View view) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.boH != null && i != this.mSkinType) {
            this.boH.getLayoutMode().ad(this.mSkinType == 1);
            this.boH.getLayoutMode().k(view);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.c cVar, com.baidu.tieba.hottopic.data.e eVar) {
        if (cVar != null && eVar != null) {
            if (eVar.Rp()) {
                cVar.bqk.setVisibility(0);
                cVar.bql.setVisibility(0);
                cVar.bqs.setVisibility(8);
                cVar.bqm.setVisibility(8);
                cVar.bqq.setVisibility(8);
                cVar.bqr.setVisibility(8);
                eVar.bpH = eVar.bpH.trim();
                StringBuilder sb = new StringBuilder();
                if (eVar.bpH.length() > 23) {
                    String substring = eVar.bpH.substring(1, 19);
                    sb.append(eVar.bpH.charAt(0));
                    sb.append(substring);
                    sb.append("...");
                    sb.append(eVar.bpH.charAt(eVar.bpH.length() - 1));
                    cVar.bql.setText(sb);
                } else {
                    cVar.bql.setText(eVar.bpH);
                }
                an.j(cVar.getView(), i.c.cp_bg_line_d);
                return;
            }
            cVar.bqk.setVisibility(8);
            cVar.bql.setVisibility(8);
            cVar.bqm.setVisibility(0);
            cVar.bqq.setVisibility(0);
            cVar.bqr.setVisibility(0);
            cVar.bqs.setVisibility(0);
            cVar.bqo.setText(as.d(eVar.bpJ.trim(), 14, "..."));
            cVar.bqp.setText(as.m(eVar.bpL * 1000));
            cVar.bqq.setText(TbadkCoreApplication.m411getInst().getString(i.h.magic_post_comment));
            cVar.bqr.setMaxLines(2);
            cVar.bqr.setEllipsize(TextUtils.TruncateAt.END);
            cVar.bqr.setText(eVar.bpM);
            cVar.bqn.setUserId(String.valueOf(eVar.bpK));
            cVar.bqn.d(eVar.bpI, 12, false);
            b(cVar, eVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.b.c cVar, com.baidu.tieba.hottopic.data.e eVar) {
        if (cVar != null && eVar != null && this.boH != null) {
            String valueOf = String.valueOf(eVar.bpK);
            String str = eVar.bpJ;
            String valueOf2 = String.valueOf(eVar.postId);
            a(this.boP);
            cVar.bqm.setOnClickListener(new k(this, valueOf, str, valueOf2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar == null || eVar.Rp()) {
            return false;
        }
        String valueOf = String.valueOf(eVar.threadId);
        String valueOf2 = String.valueOf(eVar.postId);
        TiebaStatic.log(new aq("c10366").ae("post_id", valueOf2).ae("obj_type", "2").ae("obj_id", this.boH.Rh()));
        if (!eVar.bpO) {
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.boH.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, true, true)));
        }
        String valueOf3 = String.valueOf(eVar.bpP);
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.boH.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, false, eVar.bpJ, true, valueOf3, 0)));
    }
}
