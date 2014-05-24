package com.baidu.tieba.im.live.mylive;

import android.text.TextUtils;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.live.mylive.MyLiveListAdapter;
import com.baidu.tieba.im.message.RequestMyLiveListMessage;
import com.baidu.tieba.im.message.ResponseMyLiveListMessage;
import com.baidu.tieba.im.model.bd;
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
        bd bdVar;
        MyLiveListAdapter myLiveListAdapter;
        bd bdVar2;
        MyLiveListAdapter myLiveListAdapter2;
        MyLiveListAdapter myLiveListAdapter3;
        bd bdVar3;
        bd bdVar4;
        bd bdVar5;
        MyLiveListAdapter myLiveListAdapter4;
        MyLiveListAdapter myLiveListAdapter5;
        bd bdVar6;
        MyLiveListAdapter myLiveListAdapter6;
        MyLiveListAdapter myLiveListAdapter7;
        MyLiveListAdapter myLiveListAdapter8;
        MyLiveListAdapter myLiveListAdapter9;
        this.a.j();
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
                        bdVar = this.a.c;
                        if (!bdVar.a()) {
                            myLiveListAdapter9 = this.a.h;
                            myLiveListAdapter9.b(true);
                        }
                        if (!hotLiveListData.a()) {
                            bdVar6 = this.a.c;
                            if (bdVar6.a()) {
                                myLiveListAdapter6 = this.a.h;
                                myLiveListAdapter6.a(MyLiveListAdapter.BOTTOM_TYPE.NO_MORE);
                            } else if (b.size() == 0) {
                                myLiveListAdapter8 = this.a.h;
                                myLiveListAdapter8.c(false);
                                this.a.l();
                                return;
                            } else {
                                myLiveListAdapter7 = this.a.h;
                                myLiveListAdapter7.a(MyLiveListAdapter.BOTTOM_TYPE.LINE);
                            }
                        } else {
                            myLiveListAdapter = this.a.h;
                            myLiveListAdapter.a(MyLiveListAdapter.BOTTOM_TYPE.HAVE_MORE);
                        }
                        bdVar2 = this.a.c;
                        bdVar2.a(true);
                        this.a.k();
                        myLiveListAdapter2 = this.a.h;
                        myLiveListAdapter2.c(true);
                        myLiveListAdapter3 = this.a.h;
                        myLiveListAdapter3.a(hotLiveListData.a());
                        bdVar3 = this.a.c;
                        bdVar3.b(b.size());
                        bdVar4 = this.a.c;
                        bdVar5 = this.a.c;
                        bdVar4.c(bdVar5.c() + 1);
                        myLiveListAdapter4 = this.a.h;
                        myLiveListAdapter4.a(b);
                        myLiveListAdapter5 = this.a.h;
                        myLiveListAdapter5.notifyDataSetChanged();
                    }
                }
            }
        }
    }
}
