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
import com.baidu.tbadk.core.data.t;
import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tieba.tbadkCore.util.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements v {
    final /* synthetic */ MyCollectFrsActivity bgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyCollectFrsActivity myCollectFrsActivity) {
        this.bgk = myCollectFrsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: com.baidu.tieba.frs.collect.MyCollectFrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null && (uVar instanceof z) && !(uVar instanceof com.baidu.tbadk.core.data.b)) {
            z zVar = (z) uVar;
            p readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.mF(zVar.getId())) {
                readThreadHistory.mE(zVar.getId());
            }
            boolean z = false;
            String sN = zVar.sN();
            if (sN != null && !sN.equals("")) {
                z = true;
                new Thread(new h(this, sN)).start();
            }
            String tid = zVar.getTid();
            if (tid == null) {
                tid = "";
            }
            if (zVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                bf vD = bf.vD();
                TbPageContext<?> pageContext = this.bgk.getPageContext();
                String[] strArr = new String[3];
                strArr[0] = tid;
                strArr[1] = "";
                vD.b(pageContext, strArr);
                return;
            }
            if (zVar.getThreadType() == 33 || (zVar instanceof t)) {
                this.bgk.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bgk.getPageContext().getPageActivity(), zVar.getTid()).cn("from_frs").bv(18003).rw()));
            } else {
                if (tid.startsWith("pb:")) {
                    zVar.setId(tid.substring(3));
                }
                MyCollectFrsActivity myCollectFrsActivity = this.bgk;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bgk.getPageContext().getPageActivity());
                str = this.bgk.mForumName;
                myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str, null, 18003, true, false, z)));
            }
            TiebaStatic.log("c10419");
        }
    }
}
