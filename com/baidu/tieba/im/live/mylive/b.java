package com.baidu.tieba.im.live.mylive;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.live.mylive.MyLiveListAdapter;
import com.baidu.tieba.im.message.RequestMyLiveListMessage;
import com.baidu.tieba.im.message.ResponseMyLiveListMessage;
import com.baidu.tieba.im.model.am;
import com.baidu.tieba.x;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b extends com.baidu.adp.framework.listener.d {
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
        am amVar;
        MyLiveListAdapter myLiveListAdapter;
        am amVar2;
        MyLiveListAdapter myLiveListAdapter2;
        MyLiveListAdapter myLiveListAdapter3;
        am amVar3;
        am amVar4;
        am amVar5;
        MyLiveListAdapter myLiveListAdapter4;
        MyLiveListAdapter myLiveListAdapter5;
        am amVar6;
        MyLiveListAdapter myLiveListAdapter6;
        MyLiveListAdapter myLiveListAdapter7;
        MyLiveListAdapter myLiveListAdapter8;
        MyLiveListAdapter myLiveListAdapter9;
        this.a.l();
        if (socketResponsedMessage == null) {
            this.a.a(x.neterror);
        } else if (!(socketResponsedMessage instanceof ResponseMyLiveListMessage)) {
            this.a.a(x.neterror);
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
                        this.a.a(x.neterror);
                        return;
                    }
                    com.baidu.tieba.im.data.d hotLiveListData = responseMyLiveListMessage.getHotLiveListData();
                    if (hotLiveListData != null && hotLiveListData.b() != null) {
                        List<LiveCardData> b = hotLiveListData.b();
                        amVar = this.a.c;
                        if (!amVar.b()) {
                            myLiveListAdapter9 = this.a.h;
                            myLiveListAdapter9.b(true);
                        }
                        if (!hotLiveListData.a()) {
                            amVar6 = this.a.c;
                            if (amVar6.b()) {
                                myLiveListAdapter6 = this.a.h;
                                myLiveListAdapter6.a(MyLiveListAdapter.BOTTOM_TYPE.NO_MORE);
                            } else if (b.size() == 0) {
                                myLiveListAdapter8 = this.a.h;
                                myLiveListAdapter8.c(false);
                                this.a.n();
                                return;
                            } else {
                                myLiveListAdapter7 = this.a.h;
                                myLiveListAdapter7.a(MyLiveListAdapter.BOTTOM_TYPE.LINE);
                            }
                        } else {
                            myLiveListAdapter = this.a.h;
                            myLiveListAdapter.a(MyLiveListAdapter.BOTTOM_TYPE.HAVE_MORE);
                        }
                        amVar2 = this.a.c;
                        amVar2.b(true);
                        this.a.m();
                        myLiveListAdapter2 = this.a.h;
                        myLiveListAdapter2.c(true);
                        myLiveListAdapter3 = this.a.h;
                        myLiveListAdapter3.a(hotLiveListData.a());
                        amVar3 = this.a.c;
                        amVar3.b(b.size());
                        amVar4 = this.a.c;
                        amVar5 = this.a.c;
                        amVar4.c(amVar5.d() + 1);
                        myLiveListAdapter4 = this.a.h;
                        myLiveListAdapter4.a(b);
                        myLiveListAdapter5 = this.a.h;
                        myLiveListAdapter5.notifyDataSetChanged();
                        return;
                    }
                    this.a.n();
                }
            }
        }
    }
}
