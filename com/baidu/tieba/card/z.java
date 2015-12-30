package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements View.OnClickListener {
    final /* synthetic */ y aOv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.aOv = yVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.card.a.n nVar;
        com.baidu.tieba.card.a.n nVar2;
        com.baidu.tieba.card.a.n nVar3;
        com.baidu.tieba.card.a.n nVar4;
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        com.baidu.tieba.card.a.n nVar5;
        com.baidu.tieba.card.a.n nVar6;
        com.baidu.tieba.card.a.n nVar7;
        TextView textView;
        com.baidu.tieba.card.a.n nVar8;
        TextView textView2;
        nVar = this.aOv.aOj;
        if (nVar != null) {
            nVar2 = this.aOv.aOj;
            if (nVar2.aQo != null) {
                nVar3 = this.aOv.aOj;
                TiebaStatic.log(nVar3.IB());
                nVar4 = this.aOv.aOj;
                x.gH(nVar4.aQo.getId());
                tbPageContext = this.aOv.mPageContext;
                tbPageContext2 = this.aOv.mPageContext;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(tbPageContext2.getPageActivity());
                nVar5 = this.aOv.aOj;
                PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(nVar5.aQo.getId(), null, x.In());
                nVar6 = this.aOv.aOj;
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, createNormalCfg.addLocateParam(nVar6.It())));
                y yVar = this.aOv;
                nVar7 = this.aOv.aOj;
                boolean gI = x.gI(nVar7.aQo.getId());
                textView = this.aOv.aOn;
                yVar.a(gI, textView, n.d.cp_cont_b, n.d.cp_cont_d);
                y yVar2 = this.aOv;
                nVar8 = this.aOv.aOj;
                boolean gI2 = x.gI(nVar8.aQo.getId());
                textView2 = this.aOv.aOp;
                yVar2.a(gI2, textView2, n.d.cp_cont_j, n.d.cp_cont_d);
            }
        }
    }
}
