package com.baidu.tieba.im.live.mylive;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.live.mylive.MyLiveListAdapter;
import com.baidu.tieba.im.message.RequestMyLiveListMessage;
import com.baidu.tieba.im.message.ResponseMyLiveListMessage;
import com.baidu.tieba.im.model.bc;
import com.baidu.tieba.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.b {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(a aVar, int i) {
        super(i);
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        int i;
        bc bcVar;
        MyLiveListAdapter myLiveListAdapter;
        bc bcVar2;
        MyLiveListAdapter myLiveListAdapter2;
        MyLiveListAdapter myLiveListAdapter3;
        bc bcVar3;
        bc bcVar4;
        bc bcVar5;
        MyLiveListAdapter myLiveListAdapter4;
        MyLiveListAdapter myLiveListAdapter5;
        bc bcVar6;
        MyLiveListAdapter myLiveListAdapter6;
        MyLiveListAdapter myLiveListAdapter7;
        MyLiveListAdapter myLiveListAdapter8;
        MyLiveListAdapter myLiveListAdapter9;
        this.a.k();
        if (socketResponsedMessage == null) {
            this.a.a(y.neterror);
        } else if (!(socketResponsedMessage instanceof ResponseMyLiveListMessage)) {
            this.a.a(y.neterror);
        } else {
            ResponseMyLiveListMessage responseMyLiveListMessage = (ResponseMyLiveListMessage) socketResponsedMessage;
            Message<?> orginalMessage = responseMyLiveListMessage.getOrginalMessage();
            if (orginalMessage != null && (orginalMessage instanceof RequestMyLiveListMessage)) {
                int type = ((RequestMyLiveListMessage) orginalMessage).getType();
                i = this.a.i;
                if (type == i) {
                    if (responseMyLiveListMessage.getError() != 0) {
                        if (responseMyLiveListMessage.getError() > 0) {
                            if (!TextUtils.isEmpty(responseMyLiveListMessage.getErrorString())) {
                                this.a.b(responseMyLiveListMessage.getErrorString());
                                return;
                            }
                            return;
                        }
                        this.a.a(y.neterror);
                        return;
                    }
                    com.baidu.tieba.im.data.d hotLiveListData = responseMyLiveListMessage.getHotLiveListData();
                    if (hotLiveListData != null && hotLiveListData.b() != null) {
                        List<LiveCardData> b = hotLiveListData.b();
                        bcVar = this.a.c;
                        if (!bcVar.a()) {
                            myLiveListAdapter9 = this.a.h;
                            myLiveListAdapter9.b(true);
                        }
                        if (!hotLiveListData.a()) {
                            bcVar6 = this.a.c;
                            if (bcVar6.a()) {
                                myLiveListAdapter6 = this.a.h;
                                myLiveListAdapter6.a(MyLiveListAdapter.BOTTOM_TYPE.NO_MORE);
                            } else if (b.size() == 0) {
                                myLiveListAdapter8 = this.a.h;
                                myLiveListAdapter8.c(false);
                                this.a.m();
                                return;
                            } else {
                                myLiveListAdapter7 = this.a.h;
                                myLiveListAdapter7.a(MyLiveListAdapter.BOTTOM_TYPE.LINE);
                            }
                        } else {
                            myLiveListAdapter = this.a.h;
                            myLiveListAdapter.a(MyLiveListAdapter.BOTTOM_TYPE.HAVE_MORE);
                        }
                        bcVar2 = this.a.c;
                        bcVar2.a(true);
                        this.a.l();
                        myLiveListAdapter2 = this.a.h;
                        myLiveListAdapter2.c(true);
                        myLiveListAdapter3 = this.a.h;
                        myLiveListAdapter3.a(hotLiveListData.a());
                        bcVar3 = this.a.c;
                        bcVar3.b(b.size());
                        bcVar4 = this.a.c;
                        bcVar5 = this.a.c;
                        bcVar4.c(bcVar5.c() + 1);
                        myLiveListAdapter4 = this.a.h;
                        myLiveListAdapter4.a(b);
                        myLiveListAdapter5 = this.a.h;
                        myLiveListAdapter5.notifyDataSetChanged();
                        return;
                    }
                    this.a.m();
                }
            }
        }
    }
}
