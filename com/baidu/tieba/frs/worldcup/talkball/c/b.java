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
/* loaded from: classes2.dex */
public class b implements a {
    private com.baidu.tieba.frs.worldcup.talkball.activity.a dGh;
    private com.baidu.tieba.frs.worldcup.talkball.model.a dGi;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.talkball.activity.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.dGh = aVar;
        this.dGi = new com.baidu.tieba.frs.worldcup.talkball.model.b(this.mPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onRefresh() {
        if (this.dGi != null) {
            this.dGi.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aAE() {
        if (this.dGi != null) {
            this.dGi.SJ();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.dGh != null) {
            this.dGh.SR();
            if (this.dGh.d(aVar) && cVar != null) {
                this.dGh.bA(cVar.aAz());
                this.dGh.a(cVar.aAC());
                this.dGh.a(cVar.aAB());
                this.dGh.c(cVar.aAD());
                this.dGh.Q(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public boolean hasMore() {
        if (this.dGi != null) {
            return this.dGi.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aAF() {
        if (this.dGi != null) {
            TiebaStatic.log(new am("c12402").ah(ImageViewerConfig.FORUM_ID, this.dGi.getForumId()).ah("uid", TbadkCoreApplication.getCurrentAccount()).ah(ImageViewerConfig.FORUM_NAME, this.dGi.getForumName()));
            if (!StringUtils.isNull(this.dGi.getForumName())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.mPageContext.getPageActivity(), this.dGi.getForumName(), this.dGi.getForumId())));
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aAG() {
        if (ba.aU(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new am("c12924").r("obj_locate", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onDestroy() {
        if (this.dGi != null) {
            this.dGi.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public String getForumId() {
        return this.dGi != null ? this.dGi.getForumId() : "";
    }
}
