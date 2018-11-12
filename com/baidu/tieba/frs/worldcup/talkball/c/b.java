package com.baidu.tieba.frs.worldcup.talkball.c;

import android.os.Bundle;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.frs.worldcup.talkball.model.c;
import com.baidu.tieba.tbadkCore.d;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.talkball.activity.a ecS;
    private com.baidu.tieba.frs.worldcup.talkball.model.a ecT;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.talkball.activity.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ecS = aVar;
        this.ecT = new com.baidu.tieba.frs.worldcup.talkball.model.b(this.mPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onRefresh() {
        if (this.ecT != null) {
            this.ecT.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aGU() {
        if (this.ecT != null) {
            this.ecT.YV();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.ecS != null) {
            this.ecS.Zd();
            if (this.ecS.d(aVar) && cVar != null) {
                this.ecS.bS(cVar.aGP());
                this.ecS.a(cVar.aGS());
                this.ecS.a(cVar.aGR());
                this.ecS.c(cVar.aGT());
                this.ecS.V(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public boolean hasMore() {
        if (this.ecT != null) {
            return this.ecT.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aGV() {
        if (this.ecT != null) {
            TiebaStatic.log(new am("c12402").ax(ImageViewerConfig.FORUM_ID, this.ecT.getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_NAME, this.ecT.getForumName()));
            if (!StringUtils.isNull(this.ecT.getForumName())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.mPageContext.getPageActivity(), this.ecT.getForumName(), this.ecT.getForumId())));
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aGW() {
        if (ba.bG(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new am("c12924").x("obj_locate", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onDestroy() {
        if (this.ecT != null) {
            this.ecT.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public String getForumId() {
        return this.ecT != null ? this.ecT.getForumId() : "";
    }
}
