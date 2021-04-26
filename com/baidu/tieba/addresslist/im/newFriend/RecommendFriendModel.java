package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.i0.z0.n;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendFriendModel extends BdBaseModel<NewFriendsActivity> {

    /* renamed from: g  reason: collision with root package name */
    public static final String f14364g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f14365h;

    /* renamed from: e  reason: collision with root package name */
    public b f14366e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f14367f;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {

        /* renamed from: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0179a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f14369a;

            public C0179a(a aVar, List list) {
                this.f14369a = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                List list = this.f14369a;
                if (list == null || list.size() <= 0) {
                    return null;
                }
                d.a.j0.q.e.a.b.f().m(this.f14369a);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f14370a;

            public b(String str) {
                this.f14370a = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.i0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r2) {
                RecommendFriendModel.this.f14366e.a(this.f14370a);
            }
        }

        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1001900) {
                return;
            }
            if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof RecommendFriendResponseMessage)) {
                if (RecommendFriendModel.this.f14366e != null) {
                    RecommendFriendModel.this.f14366e.onLoadFailed(null);
                    return;
                }
                return;
            }
            RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
            String errMsg = recommendFriendResponseMessage.getErrMsg();
            if (recommendFriendResponseMessage.getError() != 0) {
                if (RecommendFriendModel.this.f14366e != null) {
                    RecommendFriendModel.this.f14366e.onLoadFailed(errMsg);
                    return;
                }
                return;
            }
            h0.c(new C0179a(this, recommendFriendResponseMessage.getDatas()), new b(errMsg));
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str);

        void onLoadFailed(String str);
    }

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/r/friend/getRecommendList";
        f14364g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, str);
        f14365h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(f14365h);
    }

    public RecommendFriendModel(NewFriendsActivity newFriendsActivity, b bVar) {
        super(newFriendsActivity.getPageContext());
        this.f14366e = null;
        this.f14367f = new a(CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.f14366e = bVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void registerListener() {
        registerListener(this.f14367f);
    }

    public void t() {
        sendMessage(new HttpMessage(CmdConfigHttp.RECOMMOEND_FRIEND_CMD));
    }
}
