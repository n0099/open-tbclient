package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import d.a.m0.z0.n;
import java.util.List;
/* loaded from: classes4.dex */
public class RecommendFriendModel extends BdBaseModel<NewFriendsActivity> {

    /* renamed from: g  reason: collision with root package name */
    public static final String f13668g;

    /* renamed from: h  reason: collision with root package name */
    public static TbHttpMessageTask f13669h;

    /* renamed from: e  reason: collision with root package name */
    public b f13670e;

    /* renamed from: f  reason: collision with root package name */
    public final HttpMessageListener f13671f;

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {

        /* renamed from: com.baidu.tieba.addresslist.im.newFriend.RecommendFriendModel$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0167a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ List f13673a;

            public C0167a(a aVar, List list) {
                this.f13673a = list;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                List list = this.f13673a;
                if (list == null || list.size() <= 0) {
                    return null;
                }
                d.a.n0.s.e.a.b.f().m(this.f13673a);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ String f13674a;

            public b(String str) {
                this.f13674a = str;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.m0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r2) {
                RecommendFriendModel.this.f13670e.a(this.f13674a);
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
                if (RecommendFriendModel.this.f13670e != null) {
                    RecommendFriendModel.this.f13670e.onLoadFailed(null);
                    return;
                }
                return;
            }
            RecommendFriendResponseMessage recommendFriendResponseMessage = (RecommendFriendResponseMessage) httpResponsedMessage;
            String errMsg = recommendFriendResponseMessage.getErrMsg();
            if (recommendFriendResponseMessage.getError() != 0) {
                if (RecommendFriendModel.this.f13670e != null) {
                    RecommendFriendModel.this.f13670e.onLoadFailed(errMsg);
                    return;
                }
                return;
            }
            h0.c(new C0167a(this, recommendFriendResponseMessage.getDatas()), new b(errMsg));
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(String str);

        void onLoadFailed(String str);
    }

    static {
        String str = TbConfig.SERVER_ADDRESS + "c/r/friend/getRecommendList";
        f13668g = str;
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.RECOMMOEND_FRIEND_CMD, str);
        f13669h = tbHttpMessageTask;
        tbHttpMessageTask.setResponsedClass(RecommendFriendResponseMessage.class);
        MessageManager.getInstance().registerTask(f13669h);
    }

    public RecommendFriendModel(NewFriendsActivity newFriendsActivity, b bVar) {
        super(newFriendsActivity.getPageContext());
        this.f13670e = null;
        this.f13671f = new a(CmdConfigHttp.RECOMMOEND_FRIEND_CMD);
        this.f13670e = bVar;
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
        registerListener(this.f13671f);
    }

    public void x() {
        sendMessage(new HttpMessage(CmdConfigHttp.RECOMMOEND_FRIEND_CMD));
    }
}
