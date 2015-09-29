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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.e, com.baidu.tieba.hottopic.b.c> {
    private HotTopicActivity bnS;
    private v boa;
    public int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public i(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.boa = new j(this);
        this.bnS = hotTopicActivity;
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
            am.i(cVar.getView(), i.e.list_item_selector);
            am.b(cVar.bpw, i.c.cp_cont_c, 1);
            am.b(cVar.bpz, i.c.cp_cont_f, 1);
            am.b(cVar.bpA, i.c.cp_cont_d, 1);
            am.b(cVar.bpB, i.c.cp_cont_e, 1);
            am.b(cVar.bpC, i.c.cp_cont_b, 1);
            am.j(cVar.bpD, i.c.cp_bg_line_b);
            am.j(cVar.bpv, i.c.cp_bg_line_c);
            cVar.bpy.setImageDrawable(null);
            c(cVar.apR, view);
        }
    }

    private void c(int i, View view) {
        this.mSkinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bnS != null && i != this.mSkinType) {
            this.bnS.getLayoutMode().ad(this.mSkinType == 1);
            this.bnS.getLayoutMode().k(view);
        }
    }

    private void a(com.baidu.tieba.hottopic.b.c cVar, com.baidu.tieba.hottopic.data.e eVar) {
        if (cVar != null && eVar != null) {
            if (eVar.QX()) {
                cVar.bpv.setVisibility(0);
                cVar.bpw.setVisibility(0);
                cVar.bpD.setVisibility(8);
                cVar.bpx.setVisibility(8);
                cVar.bpB.setVisibility(8);
                cVar.bpC.setVisibility(8);
                eVar.boS = eVar.boS.trim();
                StringBuilder sb = new StringBuilder();
                if (eVar.boS.length() > 23) {
                    String substring = eVar.boS.substring(1, 19);
                    sb.append(eVar.boS.charAt(0));
                    sb.append(substring);
                    sb.append("...");
                    sb.append(eVar.boS.charAt(eVar.boS.length() - 1));
                    cVar.bpw.setText(sb);
                } else {
                    cVar.bpw.setText(eVar.boS);
                }
                am.j(cVar.getView(), i.c.cp_bg_line_d);
                return;
            }
            cVar.bpv.setVisibility(8);
            cVar.bpw.setVisibility(8);
            cVar.bpx.setVisibility(0);
            cVar.bpB.setVisibility(0);
            cVar.bpC.setVisibility(0);
            cVar.bpD.setVisibility(0);
            cVar.bpz.setText(ar.d(eVar.boU.trim(), 14, "..."));
            cVar.bpA.setText(ar.o(eVar.boW * 1000));
            cVar.bpB.setText(TbadkCoreApplication.m411getInst().getString(i.h.magic_post_comment));
            cVar.bpC.setMaxLines(2);
            cVar.bpC.setEllipsize(TextUtils.TruncateAt.END);
            cVar.bpC.setText(eVar.boX);
            cVar.bpy.setUserId(String.valueOf(eVar.boV));
            cVar.bpy.d(eVar.boT, 12, false);
            b(cVar, eVar);
        }
    }

    private void b(com.baidu.tieba.hottopic.b.c cVar, com.baidu.tieba.hottopic.data.e eVar) {
        if (cVar != null && eVar != null && this.bnS != null) {
            String valueOf = String.valueOf(eVar.boV);
            String str = eVar.boU;
            String valueOf2 = String.valueOf(eVar.postId);
            a(this.boa);
            cVar.bpx.setOnClickListener(new k(this, valueOf, str, valueOf2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tieba.hottopic.data.e eVar) {
        if (eVar == null || eVar.QX()) {
            return false;
        }
        String valueOf = String.valueOf(eVar.threadId);
        String valueOf2 = String.valueOf(eVar.postId);
        TiebaStatic.log(new ap("c10366").ae("post_id", valueOf2).ae("obj_type", "2").ae("obj_id", this.bnS.QP()));
        if (!eVar.boZ) {
            return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bnS.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, true, true)));
        }
        String valueOf3 = String.valueOf(eVar.bpa);
        return MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SubPbActivityConfig(this.bnS.getActivity()).createSubPbActivityConfig(valueOf, valueOf2, HotTopicActivityConfig.ST_TYPE, false, eVar.boU, true, valueOf3, 0)));
    }
}
