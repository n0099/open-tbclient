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
    final /* synthetic */ a aVJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i, int i2) {
        super(i, i2);
        this.aVJ = aVar;
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
            z = this.aVJ.aVH;
            if (!z) {
                a aVar = this.aVJ;
                tbPageContext = this.aVJ.Gf;
                aVar.ay(tbPageContext.getPageActivity());
            }
            this.aVJ.Gf = null;
            return;
        }
        AcrossForum acrossForum = dataRes.across_forum.get(0);
        this.aVJ.aVF = new AcrossForumViewData();
        this.aVJ.aVF.userPortrait = dataRes.user_portrait;
        this.aVJ.aVF.forumName = acrossForum.forum_name;
        this.aVJ.aVF.describe = acrossForum.desc;
        this.aVJ.aVF.rulesURL = dataRes.jump_url;
        this.aVJ.aVF.shareTitle = dataRes.share_title;
        this.aVJ.aVF.shareAbstract = dataRes.share_abstract;
        this.aVJ.aVF.sharePicURL = dataRes.share_pic;
        z2 = this.aVJ.aVH;
        if (!z2) {
            a aVar2 = this.aVJ;
            tbPageContext2 = this.aVJ.Gf;
            aVar2.ay(tbPageContext2.getPageActivity());
            this.aVJ.Gf = null;
        }
    }
}
