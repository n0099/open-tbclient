package com.baidu.tieba.im.live.mylive;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tieba.im.live.mylive.MyLiveListAdapter;
import com.baidu.tieba.im.message.RequestMyLiveListLocalMessage;
import com.baidu.tieba.im.message.ResponseMyLiveListLocalMessage;
import com.baidu.tieba.y;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends CustomMessageListener {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(a aVar, int i) {
        super(i);
        this.a = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        int i;
        MyLiveListAdapter myLiveListAdapter;
        MyLiveListAdapter myLiveListAdapter2;
        MyLiveListAdapter myLiveListAdapter3;
        MyLiveListAdapter myLiveListAdapter4;
        if (customResponsedMessage == null) {
            this.a.a(y.neterror);
            this.a.j();
        } else if (!(customResponsedMessage instanceof ResponseMyLiveListLocalMessage)) {
            this.a.a(y.neterror);
            this.a.j();
        } else {
            ResponseMyLiveListLocalMessage responseMyLiveListLocalMessage = (ResponseMyLiveListLocalMessage) customResponsedMessage;
            Message<?> orginalMessage = responseMyLiveListLocalMessage.getOrginalMessage();
            if (orginalMessage == null) {
                this.a.j();
            } else if (!(orginalMessage instanceof RequestMyLiveListLocalMessage)) {
                this.a.j();
            } else {
                int type = ((RequestMyLiveListLocalMessage) orginalMessage).getType();
                i = this.a.i;
                if (type == i) {
                    this.a.a(true);
                    List<LiveCardData> list = null;
                    if (responseMyLiveListLocalMessage != null && responseMyLiveListLocalMessage.getHotLiveListData() != null) {
                        list = responseMyLiveListLocalMessage.getHotLiveListData().b();
                    }
                    if (list != null && !list.isEmpty()) {
                        myLiveListAdapter = this.a.h;
                        myLiveListAdapter.c(true);
                        myLiveListAdapter2 = this.a.h;
                        myLiveListAdapter2.a(MyLiveListAdapter.BOTTOM_TYPE.LINE);
                        myLiveListAdapter3 = this.a.h;
                        myLiveListAdapter3.a(list);
                        myLiveListAdapter4 = this.a.h;
                        myLiveListAdapter4.notifyDataSetChanged();
                        return;
                    }
                    return;
                }
                this.a.j();
            }
        }
    }
}
