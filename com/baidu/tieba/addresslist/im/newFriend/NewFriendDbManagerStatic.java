package com.baidu.tieba.addresslist.im.newFriend;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.newFriends.RequestNewFriendActionLocalMessage;
import com.baidu.tbadk.newFriends.RequestPassFriendMessage;
import com.baidu.tbadk.newFriends.ResponseAddFriendMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendDataMessage;
import com.baidu.tbadk.newFriends.ResponseNewFriendUpdateUiMsg;
import com.baidu.tbadk.newFriends.ResponseUnreadPointNum;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.message.PushMessage;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NewFriendDbManagerStatic {

    /* renamed from: a  reason: collision with root package name */
    public static NewFriendDbManagerStatic f14571a = new NewFriendDbManagerStatic();

    /* loaded from: classes4.dex */
    public class a extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.g.a f14572a;

        public a(NewFriendDbManagerStatic newFriendDbManagerStatic, d.b.i0.d1.g.a aVar) {
            this.f14572a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.b.i0.q.e.a.b.f().l(this.f14572a);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(d.b.i0.q.e.a.b.f().h(), true));
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.b.h0.z0.n<Void> {
        public b(NewFriendDbManagerStatic newFriendDbManagerStatic) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", ""));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.g.a f14573a;

        public c(NewFriendDbManagerStatic newFriendDbManagerStatic, d.b.i0.d1.g.a aVar) {
            this.f14573a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.b.i0.q.e.a.b.f().l(this.f14573a);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(d.b.i0.q.e.a.b.f().h(), true));
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.b.h0.z0.n<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.g.a f14574a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f14575b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f14576c;

        public d(NewFriendDbManagerStatic newFriendDbManagerStatic, d.b.i0.d1.g.a aVar, String str, String str2) {
            this.f14574a = aVar;
            this.f14575b = str;
            this.f14576c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f14574a.b(), this.f14574a.e(), this.f14574a.d(), this.f14575b, this.f14576c));
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f14577a;

        public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            this.f14577a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.b.i0.q.e.a.b.f().b(this.f14577a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.b.h0.z0.n<Void> {
        public f(NewFriendDbManagerStatic newFriendDbManagerStatic) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r1) {
        }
    }

    /* loaded from: classes4.dex */
    public class g extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.g.a f14578a;

        public g(NewFriendDbManagerStatic newFriendDbManagerStatic, d.b.i0.d1.g.a aVar) {
            this.f14578a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.b.i0.q.e.a.b.f().l(this.f14578a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.b.h0.z0.n<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f14579a;

        public h(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            this.f14579a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f14579a, "", "", "", ""));
        }
    }

    /* loaded from: classes4.dex */
    public class i extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.g.a f14580a;

        public i(NewFriendDbManagerStatic newFriendDbManagerStatic, d.b.i0.d1.g.a aVar) {
            this.f14580a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.b.i0.q.e.a.b.f().l(this.f14580a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements d.b.h0.z0.n<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f14581a;

        public j(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            this.f14581a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f14581a, "", "", "", ""));
        }
    }

    /* loaded from: classes4.dex */
    public static class k extends CustomMessageListener {
        public k(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof RequestApplyLocalMessage) {
                RequestApplyLocalMessage requestApplyLocalMessage = (RequestApplyLocalMessage) customResponsedMessage;
                long uid = requestApplyLocalMessage.getUid();
                long friendId = requestApplyLocalMessage.getFriendId();
                String message = requestApplyLocalMessage.getMessage();
                RequestApplyMessage requestApplyMessage = new RequestApplyMessage();
                requestApplyMessage.setFriendId(friendId);
                requestApplyMessage.setMessage(message);
                requestApplyMessage.setUid(uid);
                MessageManager.getInstance().sendMessage(requestApplyMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class l extends CustomMessageListener {

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14582a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.b.i0.d1.g.a f14583b;

            public a(l lVar, long j, d.b.i0.d1.g.a aVar) {
                this.f14582a = j;
                this.f14583b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (d.b.i0.q.e.a.b.f().n(this.f14582a)) {
                    return null;
                }
                d.b.i0.q.e.a.b.f().l(this.f14583b);
                return null;
            }
        }

        public l(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001169) {
                return;
            }
            RequestNewFriendActionLocalMessage requestNewFriendActionLocalMessage = (RequestNewFriendActionLocalMessage) customResponsedMessage;
            long id = requestNewFriendActionLocalMessage.getId();
            String name = requestNewFriendActionLocalMessage.getName();
            String portrait = requestNewFriendActionLocalMessage.getPortrait();
            String content = requestNewFriendActionLocalMessage.getContent();
            String st_type = requestNewFriendActionLocalMessage.getSt_type();
            RequestAddFriendMessage requestAddFriendMessage = new RequestAddFriendMessage();
            requestAddFriendMessage.setFriendId(id);
            requestAddFriendMessage.setMessage(content);
            requestAddFriendMessage.setSt_type(st_type);
            MessageManager.getInstance().sendMessage(requestAddFriendMessage);
            d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
            aVar.h(id);
            aVar.j(name);
            aVar.l(0);
            aVar.k(portrait);
            aVar.g(content);
            aVar.i(0);
            h0.c(new a(this, id, aVar), null);
        }
    }

    /* loaded from: classes4.dex */
    public class m extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.d1.g.a f14584a;

        public m(NewFriendDbManagerStatic newFriendDbManagerStatic, d.b.i0.d1.g.a aVar) {
            this.f14584a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.b.i0.q.e.a.b.f().l(this.f14584a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements d.b.h0.z0.n<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f14585a;

        public n(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            this.f14585a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f14585a, "", "", "", ""));
        }
    }

    /* loaded from: classes4.dex */
    public static class o extends d.b.b.c.g.c {

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14586a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.b.i0.d1.g.a f14587b;

            public a(o oVar, long j, d.b.i0.d1.g.a aVar) {
                this.f14586a = j;
                this.f14587b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                d.b.i0.d1.g.a e2 = d.b.i0.q.e.a.b.f().e(this.f14586a);
                if (e2 == null) {
                    return null;
                }
                this.f14587b.j(e2.d());
                this.f14587b.k(e2.e());
                d.b.i0.q.e.a.b.f().l(this.f14587b);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.b.h0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14588a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RequestAddFriendMessage f14589b;

            public b(o oVar, long j, RequestAddFriendMessage requestAddFriendMessage) {
                this.f14588a = j;
                this.f14589b = requestAddFriendMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.f14588a, "", "", "", "");
                responseNewFriendUpdateUiMsg.setContent(this.f14589b.getMessage());
                MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
            }
        }

        /* loaded from: classes4.dex */
        public class c extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14590a;

            public c(o oVar, long j) {
                this.f14590a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (0 != this.f14590a && d.b.i0.q.e.a.b.f().n(this.f14590a)) {
                    d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
                    aVar.h(this.f14590a);
                    aVar.l(3);
                    aVar.i(0);
                    d.b.i0.q.e.a.b.f().q(aVar);
                }
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.b.h0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14591a;

            public d(o oVar, long j) {
                this.f14591a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f14591a, "", "", "", ""));
            }
        }

        public o(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                RequestAddFriendMessage requestAddFriendMessage = (RequestAddFriendMessage) responseAddFriendMessage.getOrginalMessage();
                int error = responseAddFriendMessage.getError();
                long friendId = responseAddFriendMessage.getFriendId();
                d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
                aVar.h(friendId);
                aVar.i(0);
                aVar.g(requestAddFriendMessage.getMessage());
                if (error == 0) {
                    aVar.l(3);
                    h0.c(new a(this, friendId, aVar), new b(this, friendId, requestAddFriendMessage));
                } else if (error == 3100097) {
                    Message<?> orginalMessage = responseAddFriendMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestAddFriendMessage) {
                        long friendId2 = ((RequestAddFriendMessage) orginalMessage).getFriendId();
                        h0.c(new c(this, friendId2), new d(this, friendId2));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class p extends d.b.b.c.g.c {

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14592a;

            public a(p pVar, long j) {
                this.f14592a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (0 == this.f14592a) {
                    return null;
                }
                d.b.i0.q.e.a.b.f().b(this.f14592a);
                d.b.i0.d1.h.m.t().o(String.valueOf(this.f14592a));
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.b.h0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14593a;

            public b(p pVar, long j) {
                this.f14593a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, this.f14593a, "", "", "", ""));
            }
        }

        public p(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
                ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
                int error = responseDeleteFriendMessage.getError();
                long friendId = responseDeleteFriendMessage.getFriendId();
                if (error == 0) {
                    h0.c(new a(this, friendId), new b(this, friendId));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class q extends d.b.b.c.g.c {

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14594a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.b.i0.d1.g.a f14595b;

            public a(q qVar, long j, d.b.i0.d1.g.a aVar) {
                this.f14594a = j;
                this.f14595b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                d.b.i0.d1.g.a e2;
                if (0 == this.f14594a || (e2 = d.b.i0.q.e.a.b.f().e(this.f14594a)) == null) {
                    return null;
                }
                this.f14595b.g(e2.a());
                this.f14595b.j(e2.d());
                this.f14595b.k(e2.e());
                d.b.i0.q.e.a.b.f().l(this.f14595b);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.b.h0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14596a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f14597b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f14598c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f14599d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f14600e;

            public b(q qVar, long j, String str, String str2, String str3, String str4) {
                this.f14596a = j;
                this.f14597b = str;
                this.f14598c = str2;
                this.f14599d = str3;
                this.f14600e = str4;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f14596a, this.f14597b, this.f14598c, this.f14599d, this.f14600e));
            }
        }

        /* loaded from: classes4.dex */
        public class c extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14601a;

            public c(q qVar, long j) {
                this.f14601a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (0 != this.f14601a && d.b.i0.q.e.a.b.f().n(this.f14601a)) {
                    d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
                    aVar.h(this.f14601a);
                    aVar.l(2);
                    aVar.i(0);
                    d.b.i0.q.e.a.b.f().q(aVar);
                }
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.b.h0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f14602a;

            public d(q qVar, long j) {
                this.f14602a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f14602a, "", "", "", ""));
            }
        }

        public q(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponsePassFriendMessage)) {
                ResponsePassFriendMessage responsePassFriendMessage = (ResponsePassFriendMessage) socketResponsedMessage;
                int error = responsePassFriendMessage.getError();
                long friendId = responsePassFriendMessage.getFriendId();
                String name = responsePassFriendMessage.getName();
                String portrait = responsePassFriendMessage.getPortrait();
                String key = responsePassFriendMessage.getKey();
                String quanpin = responsePassFriendMessage.getQuanpin();
                d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
                aVar.h(friendId);
                aVar.l(2);
                aVar.i(0);
                if (error == 0) {
                    h0.c(new a(this, friendId, aVar), new b(this, friendId, portrait, name, key, quanpin));
                } else if (error == 3100098) {
                    Message<?> orginalMessage = responsePassFriendMessage.getOrginalMessage();
                    if (orginalMessage instanceof RequestPassFriendMessage) {
                        long friendId2 = ((RequestPassFriendMessage) orginalMessage).getFriendId();
                        h0.c(new c(this, friendId2), new d(this, friendId2));
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class r extends CustomMessageListener {

        /* renamed from: a  reason: collision with root package name */
        public int f14603a;

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                r.this.f14603a = d.b.i0.q.e.a.b.f().h();
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.b.h0.z0.n<Void> {
            public b() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.b.h0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r3) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(r.this.f14603a, false));
            }
        }

        public r(int i) {
            super(i);
            this.f14603a = 0;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001175) {
                return;
            }
            h0.c(new a(), new b());
        }
    }

    /* loaded from: classes4.dex */
    public static class s extends CustomMessageListener {
        public s(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            d.b.h0.r.d0.b i = d.b.h0.r.d0.b.i();
            i.B("get_addresslist_switch" + ((String) customResponsedMessage.getData()));
        }
    }

    /* loaded from: classes4.dex */
    public static class t extends CustomMessageListener {
        public t(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GroupNewsPojo p;
            if (customResponsedMessage == null || !(customResponsedMessage instanceof PushMessage) || (p = ((PushMessage) customResponsedMessage).getP()) == null) {
                return;
            }
            String cmd = p.getCmd();
            if (TextUtils.isEmpty(cmd)) {
                return;
            }
            String content = p.getContent();
            if (TextUtils.isEmpty(content)) {
                return;
            }
            if (cmd.equals("apply_new_friend")) {
                NewFriendDbManagerStatic.d().b(content);
            } else if (cmd.equals("passed_new_friend")) {
                NewFriendDbManagerStatic.d().f(content);
            } else if (cmd.equals("delete_new_friend")) {
                NewFriendDbManagerStatic.d().c(content);
            } else if (cmd.equals("apply_reply_message")) {
                NewFriendDbManagerStatic.d().g(content);
            } else if (cmd.equals("apply_add_friend")) {
                NewFriendDbManagerStatic.d().a(content);
            } else if (cmd.equals("apply_pass_friend")) {
                NewFriendDbManagerStatic.d().e(content);
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class u implements CustomMessageTask.CustomRunnable<Long> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.b.i0.d1.g.a> run(CustomMessage<Long> customMessage) {
            if (customMessage == null) {
                return null;
            }
            return new ResponseNewFriendDataMessage(d.b.i0.q.e.a.b.f().e(customMessage.getData().longValue()));
        }
    }

    static {
        MessageManager.getInstance().registerListener(new k(2001216));
        MessageManager.getInstance().registerListener(new l(2001169));
        MessageManager.getInstance().registerListener(new o(304100));
        MessageManager.getInstance().registerListener(new p(304102));
        MessageManager.getInstance().registerListener(new q(304101));
        MessageManager.getInstance().registerListener(new r(2001175));
        MessageManager.getInstance().registerListener(new s(2001189));
        t tVar = new t(0);
        MessageManager.getInstance().registerListener(2001209, tVar);
        MessageManager.getInstance().registerListener(2001172, tVar);
        MessageManager.getInstance().registerListener(2001173, tVar);
        MessageManager.getInstance().registerListener(2001219, tVar);
        MessageManager.getInstance().registerListener(2001220, tVar);
        MessageManager.getInstance().registerListener(2001221, tVar);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001305, new u());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static NewFriendDbManagerStatic d() {
        return f14571a;
    }

    public void a(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject == null) {
                return;
            }
            d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
            long optLong = optJSONObject.optLong("user_id");
            String optString = optJSONObject.optString("user_name");
            String optString2 = optJSONObject.optString("portrait");
            String optString3 = optJSONObject.optString("message");
            aVar.l(3);
            aVar.g(optString3);
            aVar.h(optLong);
            aVar.i(1);
            aVar.j(optString);
            aVar.k(optString2);
            h0.c(new i(this, aVar), new j(this, optLong));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void b(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject == null) {
                return;
            }
            d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
            aVar.h(optJSONObject.optLong("user_id"));
            aVar.j(optJSONObject.optString("user_name"));
            aVar.k(optJSONObject.optString("portrait"));
            aVar.g(optJSONObject.optString("message"));
            aVar.i(0);
            aVar.l(1);
            h0.c(new a(this, aVar), new b(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject == null) {
                return;
            }
            h0.c(new e(this, optJSONObject.optLong("user_id")), new f(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void e(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject == null) {
                return;
            }
            d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
            long optLong = optJSONObject.optLong("user_id");
            String optString = optJSONObject.optString("user_name");
            String optString2 = optJSONObject.optString("portrait");
            String optString3 = optJSONObject.optString("message");
            aVar.l(2);
            aVar.g(optString3);
            aVar.h(optLong);
            aVar.i(1);
            aVar.j(optString);
            aVar.k(optString2);
            h0.c(new m(this, aVar), new n(this, optLong));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject == null) {
                return;
            }
            d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
            aVar.h(optJSONObject.optLong("user_id"));
            aVar.j(optJSONObject.optString("user_name"));
            aVar.k(optJSONObject.optString("portrait"));
            aVar.g(optJSONObject.optString("message"));
            String optString = optJSONObject.optString("key");
            String optString2 = optJSONObject.optString("pinyin");
            aVar.i(0);
            aVar.l(4);
            h0.c(new c(this, aVar), new d(this, aVar, optString, optString2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject == null) {
                return;
            }
            d.b.i0.d1.g.a aVar = new d.b.i0.d1.g.a();
            long optLong = optJSONObject.optLong("user_id");
            String optString = optJSONObject.optString("user_name");
            String optString2 = optJSONObject.optString("portrait");
            String optString3 = optJSONObject.optString("message");
            int optInt = optJSONObject.optInt("type");
            if (optInt == 1) {
                aVar.l(3);
            } else if (optInt == 2) {
                aVar.l(1);
            }
            aVar.g(optString3);
            aVar.h(optLong);
            aVar.i(1);
            aVar.j(optString);
            aVar.k(optString2);
            h0.c(new g(this, aVar), new h(this, optLong));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
