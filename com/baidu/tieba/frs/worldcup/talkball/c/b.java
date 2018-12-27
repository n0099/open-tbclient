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
    private com.baidu.tieba.frs.worldcup.talkball.activity.a eml;
    private com.baidu.tieba.frs.worldcup.talkball.model.a emm;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.talkball.activity.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.eml = aVar;
        this.emm = new com.baidu.tieba.frs.worldcup.talkball.model.b(this.mPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onRefresh() {
        if (this.emm != null) {
            this.emm.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aJv() {
        if (this.emm != null) {
            this.emm.aad();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.eml != null) {
            this.eml.aal();
            if (this.eml.d(aVar) && cVar != null) {
                this.eml.bV(cVar.aJq());
                this.eml.a(cVar.aJt());
                this.eml.a(cVar.aJs());
                this.eml.c(cVar.aJu());
                this.eml.V(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public boolean hasMore() {
        if (this.emm != null) {
            return this.emm.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aJw() {
        if (this.emm != null) {
            TiebaStatic.log(new am("c12402").aA(ImageViewerConfig.FORUM_ID, this.emm.getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_NAME, this.emm.getForumName()));
            if (!StringUtils.isNull(this.emm.getForumName())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.mPageContext.getPageActivity(), this.emm.getForumName(), this.emm.getForumId())));
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aJx() {
        if (ba.bJ(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new am("c12924").x("obj_locate", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onDestroy() {
        if (this.emm != null) {
            this.emm.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public String getForumId() {
        return this.emm != null ? this.emm.getForumId() : "";
    }
}
