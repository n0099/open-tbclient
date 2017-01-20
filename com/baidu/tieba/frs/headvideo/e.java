package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.frs.headvideo.ForumHeadVideoListModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ForumHeadVideoListModel bRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ForumHeadVideoListModel forumHeadVideoListModel, int i, int i2) {
        super(i, i2);
        this.bRf = forumHeadVideoListModel;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        String abw;
        ForumHeadVideoListModel.a aVar;
        ForumHeadVideoListModel.a aVar2;
        this.bRf.isLoading = false;
        if (responsedMessage != null) {
            if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                String errorString = responsedMessage.getErrorString();
                abw = this.bRf.abw();
                if (!StringUtils.isNull(errorString)) {
                    abw = errorString;
                }
                aVar = this.bRf.bRd;
                if (aVar != null) {
                    aVar2 = this.bRf.bRd;
                    aVar2.fG(abw);
                }
            } else if (responsedMessage instanceof ForumHeadVideoListHttpResponseMessage) {
                this.bRf.a(((ForumHeadVideoListHttpResponseMessage) responsedMessage).getData());
            } else if (responsedMessage instanceof ForumHeadVideoListSocketResponseMessage) {
                this.bRf.a(((ForumHeadVideoListSocketResponseMessage) responsedMessage).getData());
            }
        }
    }
}
