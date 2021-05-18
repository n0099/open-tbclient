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
import d.a.j0.z0.f0;
import d.a.j0.z0.h0;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class NewFriendDbManagerStatic {

    /* renamed from: a  reason: collision with root package name */
    public static NewFriendDbManagerStatic f13648a = new NewFriendDbManagerStatic();

    /* loaded from: classes4.dex */
    public class a extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.g.a f13649a;

        public a(NewFriendDbManagerStatic newFriendDbManagerStatic, d.a.k0.e1.g.a aVar) {
            this.f13649a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.a.k0.q.e.a.b.f().l(this.f13649a);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(d.a.k0.q.e.a.b.f().h(), true));
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d.a.j0.z0.n<Void> {
        public b(NewFriendDbManagerStatic newFriendDbManagerStatic) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, 0L, "", "", "", ""));
        }
    }

    /* loaded from: classes4.dex */
    public class c extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.g.a f13650a;

        public c(NewFriendDbManagerStatic newFriendDbManagerStatic, d.a.k0.e1.g.a aVar) {
            this.f13650a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.a.k0.q.e.a.b.f().l(this.f13650a);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(d.a.k0.q.e.a.b.f().h(), true));
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d implements d.a.j0.z0.n<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.g.a f13651a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13652b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f13653c;

        public d(NewFriendDbManagerStatic newFriendDbManagerStatic, d.a.k0.e1.g.a aVar, String str, String str2) {
            this.f13651a = aVar;
            this.f13652b = str;
            this.f13653c = str2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f13651a.b(), this.f13651a.e(), this.f13651a.d(), this.f13652b, this.f13653c));
        }
    }

    /* loaded from: classes4.dex */
    public class e extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f13654a;

        public e(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            this.f13654a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.a.k0.q.e.a.b.f().b(this.f13654a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class f implements d.a.j0.z0.n<Void> {
        public f(NewFriendDbManagerStatic newFriendDbManagerStatic) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r1) {
        }
    }

    /* loaded from: classes4.dex */
    public class g extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.g.a f13655a;

        public g(NewFriendDbManagerStatic newFriendDbManagerStatic, d.a.k0.e1.g.a aVar) {
            this.f13655a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.a.k0.q.e.a.b.f().l(this.f13655a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class h implements d.a.j0.z0.n<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f13656a;

        public h(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            this.f13656a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f13656a, "", "", "", ""));
        }
    }

    /* loaded from: classes4.dex */
    public class i extends f0<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.k0.e1.g.a f13657a;

        public i(NewFriendDbManagerStatic newFriendDbManagerStatic, d.a.k0.e1.g.a aVar) {
            this.f13657a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.a.k0.q.e.a.b.f().l(this.f13657a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements d.a.j0.z0.n<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f13658a;

        public j(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            this.f13658a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f13658a, "", "", "", ""));
        }
    }

    /* loaded from: classes4.dex */
    public static class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
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
            public final /* synthetic */ long f13659a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.a.k0.e1.g.a f13660b;

            public a(l lVar, long j, d.a.k0.e1.g.a aVar) {
                this.f13659a = j;
                this.f13660b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (d.a.k0.q.e.a.b.f().n(this.f13659a)) {
                    return null;
                }
                d.a.k0.q.e.a.b.f().l(this.f13660b);
                return null;
            }
        }

        public l(int i2) {
            super(i2);
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
            d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
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
        public final /* synthetic */ d.a.k0.e1.g.a f13661a;

        public m(NewFriendDbManagerStatic newFriendDbManagerStatic, d.a.k0.e1.g.a aVar) {
            this.f13661a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.f0
        /* renamed from: a */
        public Void doInBackground() {
            d.a.k0.q.e.a.b.f().l(this.f13661a);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class n implements d.a.j0.z0.n<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f13662a;

        public n(NewFriendDbManagerStatic newFriendDbManagerStatic, long j) {
            this.f13662a = j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.z0.n
        /* renamed from: a */
        public void onReturnDataInUI(Void r9) {
            MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f13662a, "", "", "", ""));
        }
    }

    /* loaded from: classes4.dex */
    public static class o extends d.a.c.c.g.c {

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13663a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.a.k0.e1.g.a f13664b;

            public a(o oVar, long j, d.a.k0.e1.g.a aVar) {
                this.f13663a = j;
                this.f13664b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                d.a.k0.e1.g.a e2 = d.a.k0.q.e.a.b.f().e(this.f13663a);
                if (e2 == null) {
                    return null;
                }
                this.f13664b.j(e2.d());
                this.f13664b.k(e2.e());
                d.a.k0.q.e.a.b.f().l(this.f13664b);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.a.j0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13665a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ RequestAddFriendMessage f13666b;

            public b(o oVar, long j, RequestAddFriendMessage requestAddFriendMessage) {
                this.f13665a = j;
                this.f13666b = requestAddFriendMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                ResponseNewFriendUpdateUiMsg responseNewFriendUpdateUiMsg = new ResponseNewFriendUpdateUiMsg(-1, this.f13665a, "", "", "", "");
                responseNewFriendUpdateUiMsg.setContent(this.f13666b.getMessage());
                MessageManager.getInstance().dispatchResponsedMessageToUI(responseNewFriendUpdateUiMsg);
            }
        }

        /* loaded from: classes4.dex */
        public class c extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13667a;

            public c(o oVar, long j) {
                this.f13667a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (0 != this.f13667a && d.a.k0.q.e.a.b.f().n(this.f13667a)) {
                    d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
                    aVar.h(this.f13667a);
                    aVar.l(3);
                    aVar.i(0);
                    d.a.k0.q.e.a.b.f().q(aVar);
                }
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.a.j0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13668a;

            public d(o oVar, long j) {
                this.f13668a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(-1, this.f13668a, "", "", "", ""));
            }
        }

        public o(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseAddFriendMessage)) {
                ResponseAddFriendMessage responseAddFriendMessage = (ResponseAddFriendMessage) socketResponsedMessage;
                RequestAddFriendMessage requestAddFriendMessage = (RequestAddFriendMessage) responseAddFriendMessage.getOrginalMessage();
                int error = responseAddFriendMessage.getError();
                long friendId = responseAddFriendMessage.getFriendId();
                d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
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
    public static class p extends d.a.c.c.g.c {

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13669a;

            public a(p pVar, long j) {
                this.f13669a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (0 == this.f13669a) {
                    return null;
                }
                d.a.k0.q.e.a.b.f().b(this.f13669a);
                d.a.k0.e1.h.m.t().o(String.valueOf(this.f13669a));
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.a.j0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13670a;

            public b(p pVar, long j) {
                this.f13670a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(1, this.f13670a, "", "", "", ""));
            }
        }

        public p(int i2) {
            super(i2);
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
    public static class q extends d.a.c.c.g.c {

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13671a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ d.a.k0.e1.g.a f13672b;

            public a(q qVar, long j, d.a.k0.e1.g.a aVar) {
                this.f13671a = j;
                this.f13672b = aVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                d.a.k0.e1.g.a e2;
                if (0 == this.f13671a || (e2 = d.a.k0.q.e.a.b.f().e(this.f13671a)) == null) {
                    return null;
                }
                this.f13672b.g(e2.a());
                this.f13672b.j(e2.d());
                this.f13672b.k(e2.e());
                d.a.k0.q.e.a.b.f().l(this.f13672b);
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.a.j0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13673a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f13674b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f13675c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ String f13676d;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f13677e;

            public b(q qVar, long j, String str, String str2, String str3, String str4) {
                this.f13673a = j;
                this.f13674b = str;
                this.f13675c = str2;
                this.f13676d = str3;
                this.f13677e = str4;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f13673a, this.f13674b, this.f13675c, this.f13676d, this.f13677e));
            }
        }

        /* loaded from: classes4.dex */
        public class c extends f0<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13678a;

            public c(q qVar, long j) {
                this.f13678a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                if (0 != this.f13678a && d.a.k0.q.e.a.b.f().n(this.f13678a)) {
                    d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
                    aVar.h(this.f13678a);
                    aVar.l(2);
                    aVar.i(0);
                    d.a.k0.q.e.a.b.f().q(aVar);
                }
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class d implements d.a.j0.z0.n<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ long f13679a;

            public d(q qVar, long j) {
                this.f13679a = j;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r9) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseNewFriendUpdateUiMsg(0, this.f13679a, "", "", "", ""));
            }
        }

        public q(int i2) {
            super(i2);
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
                d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
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
        public int f13680a;

        /* loaded from: classes4.dex */
        public class a extends f0<Void> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.f0
            /* renamed from: a */
            public Void doInBackground() {
                r.this.f13680a = d.a.k0.q.e.a.b.f().h();
                return null;
            }
        }

        /* loaded from: classes4.dex */
        public class b implements d.a.j0.z0.n<Void> {
            public b() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // d.a.j0.z0.n
            /* renamed from: a */
            public void onReturnDataInUI(Void r3) {
                MessageManager.getInstance().dispatchResponsedMessageToUI(new ResponseUnreadPointNum(r.this.f13680a, false));
            }
        }

        public r(int i2) {
            super(i2);
            this.f13680a = 0;
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
        public s(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            d.a.j0.r.d0.b j = d.a.j0.r.d0.b.j();
            j.C("get_addresslist_switch" + ((String) customResponsedMessage.getData()));
        }
    }

    /* loaded from: classes4.dex */
    public static class t extends CustomMessageListener {
        public t(int i2) {
            super(i2);
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
        public CustomResponsedMessage<d.a.k0.e1.g.a> run(CustomMessage<Long> customMessage) {
            if (customMessage == null) {
                return null;
            }
            return new ResponseNewFriendDataMessage(d.a.k0.q.e.a.b.f().e(customMessage.getData().longValue()));
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
        return f13648a;
    }

    public void a(String str) {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject(TbEnum.SystemMessage.KEY_EVENT_PARAM);
            if (optJSONObject == null) {
                return;
            }
            d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
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
            d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
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
            d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
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
            d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
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
            d.a.k0.e1.g.a aVar = new d.a.k0.e1.g.a();
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
