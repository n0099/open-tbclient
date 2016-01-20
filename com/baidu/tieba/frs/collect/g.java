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
import com.baidu.tieba.tbadkCore.util.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements v {
    final /* synthetic */ MyCollectFrsActivity bkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(MyCollectFrsActivity myCollectFrsActivity) {
        this.bkc = myCollectFrsActivity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v17, resolved type: com.baidu.tieba.frs.collect.MyCollectFrsActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.adp.widget.ListView.v
    public void a(View view, u uVar, BdUniqueId bdUniqueId, AdapterView<?> adapterView, int i, long j) {
        String str;
        if (bdUniqueId != null && (uVar instanceof z) && !(uVar instanceof com.baidu.tbadk.core.data.b)) {
            z zVar = (z) uVar;
            q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
            if (readThreadHistory != null && !readThreadHistory.mD(zVar.getId())) {
                readThreadHistory.mC(zVar.getId());
            }
            boolean z = false;
            String sx = zVar.sx();
            if (sx != null && !sx.equals("")) {
                z = true;
                new Thread(new h(this, sx)).start();
            }
            String tid = zVar.getTid();
            if (tid == null) {
                tid = "";
            }
            if (zVar.getIs_top() == 2 && !tid.startsWith("pb:")) {
                bf vn = bf.vn();
                TbPageContext<?> pageContext = this.bkc.getPageContext();
                String[] strArr = new String[3];
                strArr[0] = tid;
                strArr[1] = "";
                vn.b(pageContext, strArr);
                return;
            }
            if (zVar.getThreadType() == 33 || (zVar instanceof t)) {
                this.bkc.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.bkc.getPageContext().getPageActivity(), zVar.getTid()).cp("from_frs").bo(18003).rf()));
            } else {
                if (tid.startsWith("pb:")) {
                    zVar.setId(tid.substring(3));
                }
                MyCollectFrsActivity myCollectFrsActivity = this.bkc;
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.bkc.getPageContext().getPageActivity());
                str = this.bkc.mForumName;
                myCollectFrsActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig.createFromThreadCfg(zVar, str, null, 18003, true, false, z)));
            }
            TiebaStatic.log("c10419");
        }
    }
}
