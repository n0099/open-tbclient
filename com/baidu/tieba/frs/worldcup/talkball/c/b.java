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
    private com.baidu.tieba.frs.worldcup.talkball.activity.a ebx;
    private com.baidu.tieba.frs.worldcup.talkball.model.a eby;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext, com.baidu.tieba.frs.worldcup.talkball.activity.a aVar, Bundle bundle) {
        this.mPageContext = tbPageContext;
        this.ebx = aVar;
        this.eby = new com.baidu.tieba.frs.worldcup.talkball.model.b(this.mPageContext, this, bundle);
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onRefresh() {
        if (this.eby != null) {
            this.eby.refresh();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aHw() {
        if (this.eby != null) {
            this.eby.YK();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void a(d.a aVar, ArrayList<h> arrayList, c cVar) {
        if (this.ebx != null) {
            this.ebx.YS();
            if (this.ebx.d(aVar) && cVar != null) {
                this.ebx.bU(cVar.aHr());
                this.ebx.a(cVar.aHu());
                this.ebx.a(cVar.aHt());
                this.ebx.c(cVar.aHv());
                this.ebx.W(arrayList);
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public boolean hasMore() {
        if (this.eby != null) {
            return this.eby.hasMore();
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aHx() {
        if (this.eby != null) {
            TiebaStatic.log(new am("c12402").ax(ImageViewerConfig.FORUM_ID, this.eby.getForumId()).ax("uid", TbadkCoreApplication.getCurrentAccount()).ax(ImageViewerConfig.FORUM_NAME, this.eby.getForumName()));
            if (!StringUtils.isNull(this.eby.getForumName())) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PostSearchActivityConfig(this.mPageContext.getPageActivity(), this.eby.getForumName(), this.eby.getForumId())));
            }
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void aHy() {
        if (ba.bI(this.mPageContext.getPageActivity())) {
            TiebaStatic.log(new am("c12924").x("obj_locate", 2));
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MessageCenterActivityConfig(this.mPageContext.getPageActivity())));
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public void onDestroy() {
        if (this.eby != null) {
            this.eby.onDestroy();
        }
    }

    @Override // com.baidu.tieba.frs.worldcup.talkball.c.a
    public String getForumId() {
        return this.eby != null ? this.eby.getForumId() : "";
    }
}
