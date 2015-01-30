package com.baidu.tieba.im.searchGroup;

import com.baidu.adp.framework.listener.e;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
class a extends e {
    final /* synthetic */ AddGroupActivity bnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(AddGroupActivity addGroupActivity, int i) {
        super(i);
        this.bnI = addGroupActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        b bVar;
        bVar = this.bnI.bnF;
        bVar.cW(false);
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103007) {
            if (socketResponsedMessage instanceof ResponseSearchGroupMessage) {
                ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage;
                if (responseSearchGroupMessage.getError() == 0) {
                    List<BaseGroupData> searchResult = responseSearchGroupMessage.getSearchResult();
                    if (searchResult == null || searchResult.size() <= 0) {
                        this.bnI.Tc();
                        return;
                    } else {
                        this.bnI.a(searchResult.get(0));
                        return;
                    }
                }
                this.bnI.v(responseSearchGroupMessage.getErrorString(), responseSearchGroupMessage.getError());
                return;
            }
            this.bnI.Tc();
            return;
        }
        this.bnI.Tc();
    }
}
