package com.baidu.tieba.frs.collect;

import android.view.View;
import android.widget.AdapterView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.x;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.tbadkCore.util.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements v {
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyCollectFrsActivity myCollectFrsActivity) {
        this.bmY = myCollectFrsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: com.baidu.tieba.frs.collect.MyCollectFrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null && (uVar instanceof ah) && !(uVar instanceof com.baidu.tbadk.core.data.c)) {
            ah ahVar = (ah) uVar;
            r readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.mU(ahVar.getId())) {
                readThreadHistory.mT(ahVar.getId());
            }
            boolean z = false;
            String tq = ahVar.tq();
            if (tq != null && !tq.equals("")) {
                z = true;
                new Thread(new h(this, tq)).start();
            }
            String tid = ahVar.getTid();
            if (tid == null) {
                tid = "";
            }
            if (ahVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                be wt = be.wt();
                TbPageContext<?> pageContext = this.bmY.getPageContext();
                String[] strArr = new String[3];
                strArr[0] = tid;
                strArr[1] = "";
                wt.c(pageContext, strArr);
                return;
            }
            if (ahVar.getThreadType() == 33 || (ahVar instanceof x)) {
                this.bmY.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bmY.getPageContext().getPageActivity(), ahVar.getTid()).co("from_frs").bD(18003).rC()));
            } else {
                if (tid.startsWith("pb:")) {
                    ahVar.setId(tid.substring(3));
                }
                MyCollectFrsActivity myCollectFrsActivity = this.bmY;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bmY.getPageContext().getPageActivity());
                str = this.bmY.mForumName;
                myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(ahVar, str, null, 18003, true, false, z)));
            }
            TiebaStatic.log("c10419");
        }
    }
}
