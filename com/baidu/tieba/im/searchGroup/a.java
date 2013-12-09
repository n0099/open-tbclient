package com.baidu.tieba.im.searchGroup;

import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import java.util.List;
/* loaded from: classes.dex */
class a implements com.baidu.tieba.im.messageCenter.g {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AddGroupActivity f1873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AddGroupActivity addGroupActivity) {
        this.f1873a = addGroupActivity;
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(Message message) {
        b bVar;
        bVar = this.f1873a.f1871a;
        bVar.a(false);
        if (message == null || message.getCmd() != 103007) {
            this.f1873a.a();
        } else if (!(message instanceof ResponseSearchGroupMessage)) {
            this.f1873a.a();
        } else {
            ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) message;
            if (responseSearchGroupMessage.hasError()) {
                this.f1873a.a(responseSearchGroupMessage.getErrMsg(), responseSearchGroupMessage.getErrNo());
                return;
            }
            List<BaseGroupData> searchResult = responseSearchGroupMessage.getSearchResult();
            if (searchResult == null || searchResult.size() <= 0) {
                this.f1873a.a();
            } else {
                this.f1873a.a(searchResult.get(0));
            }
        }
    }
}
