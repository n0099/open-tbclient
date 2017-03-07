package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ForumHeadVideoListModel bYn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ForumHeadVideoListModel forumHeadVideoListModel, int i, int i2) {
        super(i, i2);
        this.bYn = forumHeadVideoListModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String act;
        ForumHeadVideoListModel.a aVar;
        ForumHeadVideoListModel.a aVar2;
        this.bYn.isLoading = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                act = this.bYn.act();
                if (!StringUtils.isNull(errorString)) {
                    act = errorString;
                }
                aVar = this.bYn.bYl;
                if (aVar != null) {
                    aVar2 = this.bYn.bYl;
                    aVar2.fv(act);
                }
            } else if (responsedMessage instanceof ForumHeadVideoListHttpResponseMessage) {
                this.bYn.a(((ForumHeadVideoListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof ForumHeadVideoListSocketResponseMessage) {
                this.bYn.a(((ForumHeadVideoListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
