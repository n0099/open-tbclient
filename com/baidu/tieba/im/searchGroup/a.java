package com.baidu.tieba.im.searchGroup;

import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
class a extends e {
    final /* synthetic */ AddGroupActivity bhJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddGroupActivity addGroupActivity, int i) {
        super(i);
        this.bhJ = addGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        b bVar;
        bVar = this.bhJ.bhG;
        bVar.da(false);
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103007) {
            if (socketResponsedMessage instanceof ResponseSearchGroupMessage) {
                ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage;
                if (responseSearchGroupMessage.getError() == 0) {
                    List<BaseGroupData> searchResult = responseSearchGroupMessage.getSearchResult();
                    if (searchResult == null || searchResult.size() <= 0) {
                        this.bhJ.Rt();
                        return;
                    } else {
                        this.bhJ.a(searchResult.get(0));
                        return;
                    }
                }
                this.bhJ.t(responseSearchGroupMessage.getErrorString(), responseSearchGroupMessage.getError());
                return;
            }
            this.bhJ.Rt();
            return;
        }
        this.bhJ.Rt();
    }
}
