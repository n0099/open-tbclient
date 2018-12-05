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
    private com.baidu.tieba.frs.worldcup.talkball.activity.a ejv;
    private com.baidu.tieba.frs.worldcup.talkball.model.a ejw;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.talkball.activity.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ejv = aVar;
        this.ejw = new com.baidu.tieba.frs.worldcup.talkball.model.b(this.mPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onRefresh() {
        if (this.ejw != null) {
            this.ejw.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aIG() {
        if (this.ejw != null) {
            this.ejw.aab();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.ejv != null) {
            this.ejv.aaj();
            if (this.ejv.d(aVar) && cVar != null) {
                this.ejv.bU(cVar.aIB());
                this.ejv.a(cVar.aIE());
                this.ejv.a(cVar.aID());
                this.ejv.c(cVar.aIF());
                this.ejv.V(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public boolean hasMore() {
        if (this.ejw != null) {
            return this.ejw.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aIH() {
        if (this.ejw != null) {
            TiebaStatic.log(new am("c12402").aA(ImageViewerConfig.FORUM_ID, this.ejw.getForumId()).aA("uid", TbadkCoreApplication.getCurrentAccount()).aA(ImageViewerConfig.FORUM_NAME, this.ejw.getForumName()));
            if (!StringUtils.isNull(this.ejw.getForumName())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.mPageContext.getPageActivity(), this.ejw.getForumName(), this.ejw.getForumId())));
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aII() {
        if (ba.bJ(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new am("c12924").x("obj_locate", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onDestroy() {
        if (this.ejw != null) {
            this.ejw.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public String getForumId() {
        return this.ejw != null ? this.ejw.getForumId() : "";
    }
}
