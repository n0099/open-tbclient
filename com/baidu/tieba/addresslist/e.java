package com.baidu.tieba.addresslist;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.coreExtra.relationship.ResponseGetAddressListMessage;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ d a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d dVar) {
        super(304001);
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        BdListView bdListView;
        com.baidu.tieba.addresslist.c.a aVar;
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 304001) {
            bdListView = this.a.l;
            bdListView.d();
            if (socketResponsedMessage.hasError() || !(socketResponsedMessage instanceof ResponseGetAddressListMessage)) {
                String errorString = socketResponsedMessage.getErrorString();
                if (!TextUtils.isEmpty(errorString)) {
                    this.a.a(errorString, false);
                    return;
                }
                return;
            }
            com.baidu.tbadk.coreExtra.relationship.a addressListData = ((ResponseGetAddressListMessage) socketResponsedMessage).getAddressListData();
            ArrayList arrayList = new ArrayList();
            if (addressListData != null) {
                for (com.baidu.tbadk.coreExtra.relationship.g gVar : addressListData.a()) {
                    List<com.baidu.tbadk.coreExtra.relationship.b> b = gVar.b();
                    if (b.size() > 0) {
                        com.baidu.tbadk.coreExtra.relationship.b bVar = new com.baidu.tbadk.coreExtra.relationship.b();
                        bVar.d(gVar.a());
                        arrayList.add(bVar);
                    }
                    for (com.baidu.tbadk.coreExtra.relationship.b bVar2 : b) {
                        arrayList.add(bVar2);
                    }
                }
            }
            aVar = this.a.b;
            aVar.a(arrayList);
        }
    }
}
