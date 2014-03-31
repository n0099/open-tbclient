package com.baidu.tieba.im.chat.officialBar;

import android.os.Handler;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends com.baidu.adp.framework.c.g {
    final /* synthetic */ OfficialBarHistoryActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        bc bcVar;
        List list;
        ai aiVar;
        List<bf> list2;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        this.a.hideProgressBar();
        this.a.f = false;
        if (socketResponsedMessage2 == null) {
            this.a.showToast(com.baidu.tieba.im.j.neterror);
        } else if (socketResponsedMessage2.e() != 0) {
            this.a.showToast(socketResponsedMessage2.f());
        } else if (socketResponsedMessage2.g() != 208002 || !(socketResponsedMessage2 instanceof ResponseHistoryMessage)) {
            this.a.showToast(com.baidu.tieba.im.j.neterror);
        } else {
            ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage2;
            if (responseHistoryMessage.d().isEmpty() || (bcVar = (bc) responseHistoryMessage.h()) == null) {
                return;
            }
            if (bcVar.j() == 0) {
                this.a.e = responseHistoryMessage.d();
            } else {
                list = this.a.e;
                list.addAll(responseHistoryMessage.d());
            }
            aiVar = this.a.b;
            list2 = this.a.e;
            aiVar.a(list2);
            if (responseHistoryMessage.d().size() != 0) {
                new Handler().post(new ac(this));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab(OfficialBarHistoryActivity officialBarHistoryActivity) {
        super(208002);
        this.a = officialBarHistoryActivity;
    }
}
