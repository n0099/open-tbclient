package com.baidu.tieba.godSquare.model;

import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.godSquare.model.b;
import com.baidu.tieba.godSquare.model.res.GodSquareHttpResponsedMsg;
import com.baidu.tieba.godSquare.model.res.GodSquareSocketResponsedMsg;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ b bKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(b bVar, int i, int i2) {
        super(i, i2);
        this.bKp = bVar;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage<?> responsedMessage) {
        b.a aVar;
        b.a aVar2;
        List<u> a;
        boolean z;
        b.a aVar3;
        List<u> a2;
        boolean z2;
        aVar = this.bKp.bKk;
        if (aVar != null) {
            if (responsedMessage instanceof GodSquareHttpResponsedMsg) {
                GodSquareHttpResponsedMsg godSquareHttpResponsedMsg = (GodSquareHttpResponsedMsg) responsedMessage;
                aVar3 = this.bKp.bKk;
                a2 = this.bKp.a(godSquareHttpResponsedMsg.getResult());
                z2 = this.bKp.bKl;
                aVar3.a(a2, z2, godSquareHttpResponsedMsg.getHasMore(), godSquareHttpResponsedMsg.getErrorString());
            } else if (responsedMessage instanceof GodSquareSocketResponsedMsg) {
                GodSquareSocketResponsedMsg godSquareSocketResponsedMsg = (GodSquareSocketResponsedMsg) responsedMessage;
                aVar2 = this.bKp.bKk;
                a = this.bKp.a(godSquareSocketResponsedMsg.getResult());
                z = this.bKp.bKl;
                aVar2.a(a, z, godSquareSocketResponsedMsg.getHasMore(), godSquareSocketResponsedMsg.getErrorString());
            }
        }
    }
}
