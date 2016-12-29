package com.baidu.tieba.acrossForum;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.acrossForum.message.AcrossForumHttpResMsg;
import com.baidu.tieba.acrossForum.message.AcrossForumSocketResMsg;
import tbclient.Acrossforum.AcrossForum;
import tbclient.Acrossforum.DataRes;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ a aVa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.aVa = aVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        DataRes dataRes;
        boolean z;
        TbPageContext tbPageContext;
        boolean z2;
        TbPageContext tbPageContext2;
        if (responsedMessage instanceof AcrossForumHttpResMsg) {
            dataRes = ((AcrossForumHttpResMsg) responsedMessage).result;
        } else {
            dataRes = responsedMessage instanceof AcrossForumSocketResMsg ? ((AcrossForumSocketResMsg) responsedMessage).result : null;
        }
        if (dataRes == null || x.c(dataRes.across_forum, 0) == null) {
            z = this.aVa.aUY;
            if (!z) {
                a aVar = this.aVa;
                tbPageContext = this.aVa.Gf;
                aVar.aw(tbPageContext.getPageActivity());
            }
            this.aVa.Gf = null;
            return;
        }
        AcrossForum acrossForum = dataRes.across_forum.get(0);
        this.aVa.aUW = new AcrossForumViewData();
        this.aVa.aUW.userPortrait = dataRes.user_portrait;
        this.aVa.aUW.forumName = acrossForum.forum_name;
        this.aVa.aUW.describe = acrossForum.desc;
        this.aVa.aUW.rulesURL = dataRes.jump_url;
        this.aVa.aUW.shareTitle = dataRes.share_title;
        this.aVa.aUW.shareAbstract = dataRes.share_abstract;
        this.aVa.aUW.sharePicURL = dataRes.share_pic;
        z2 = this.aVa.aUY;
        if (!z2) {
            a aVar2 = this.aVa;
            tbPageContext2 = this.aVa.Gf;
            aVar2.aw(tbPageContext2.getPageActivity());
            this.aVa.Gf = null;
        }
    }
}
