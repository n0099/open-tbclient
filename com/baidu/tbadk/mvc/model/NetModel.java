package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpNetContext;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import d.a.m0.g0.b.g;
import d.a.m0.g0.b.h;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes3.dex */
public abstract class NetModel<T extends d.a.m0.g0.b.g, D extends d.a.m0.g0.b.h, ActivityType> extends BdBaseModel<ActivityType> {

    /* renamed from: e  reason: collision with root package name */
    public l<T, D> f12945e;

    /* renamed from: f  reason: collision with root package name */
    public m<T, D> f12946f;

    /* renamed from: g  reason: collision with root package name */
    public T f12947g;

    /* renamed from: h  reason: collision with root package name */
    public final NetModelType f12948h;

    /* renamed from: i  reason: collision with root package name */
    public j<T, D, ActivityType> f12949i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public boolean p;
    public Runnable q;

    /* loaded from: classes3.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12950a;

        static {
            int[] iArr = new int[NetModelType.values().length];
            f12950a = iArr;
            try {
                iArr[NetModelType.TYPE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12950a[NetModelType.TYPE_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12950a[NetModelType.TYPE_HTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12950a[NetModelType.TYPE_NETWORK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = a.f12950a[NetModel.this.f12948h.ordinal()];
            if (i2 == 1) {
                NetModel.this.T(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            } else if (i2 == 2) {
                NetModel.this.U(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            } else if (i2 == 3 || i2 == 4) {
                NetModel.this.S(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetModel.this.T(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetModel.this.S(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetModel.this.U(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetModel.this.S(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes3.dex */
    public class g extends d.a.c.c.g.a {
        public g(int i2, int i3) {
            super(i2, i3);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: com.baidu.tbadk.mvc.model.NetModel$m */
        /* JADX DEBUG: Multi-variable search result rejected for r2v7, resolved type: com.baidu.tbadk.mvc.model.NetModel$l */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            NetModel.this.n = false;
            if (NetModel.this.q != null) {
                d.a.c.e.m.e.a().removeCallbacks(NetModel.this.q);
            }
            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                if (NetModel.this.f12945e != null) {
                    NetModel.this.f12945e.p((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                }
            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                if (NetModel.this.f12946f != null) {
                    NetModel.this.f12946f.k((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                }
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h extends HttpMessageListener {
        public h(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            NetModel.this.n = false;
            if (NetModel.this.q != null) {
                d.a.c.e.m.e.a().removeCallbacks(NetModel.this.q);
            }
            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                    if (NetModel.this.f12945e != null) {
                        NetModel.this.f12945e.p((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
                }
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i extends d.a.c.c.g.c {
        public i(int i2, boolean z) {
            super(i2, z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            NetModel.this.n = false;
            if (NetModel.this.q != null) {
                d.a.c.e.m.e.a().removeCallbacks(NetModel.this.q);
            }
            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                    if (NetModel.this.f12946f != null) {
                        NetModel.this.f12946f.k((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                    }
                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                }
            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage error");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class j<T extends d.a.m0.g0.b.g, D extends d.a.m0.g0.b.h, ActivityType> extends BdAsyncTask<Object, D, D> {

        /* renamed from: a  reason: collision with root package name */
        public NetModel<T, D, ActivityType> f12959a;

        /* renamed from: b  reason: collision with root package name */
        public HttpNetContext f12960b;

        public j(NetModel<T, D, ActivityType> netModel) {
            this.f12959a = netModel;
        }

        public D b(Class<D> cls) {
            try {
                return cls.newInstance();
            } catch (ExceptionInInitializerError e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            } catch (InstantiationException e4) {
                e4.printStackTrace();
                return null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public D doInBackground(Object... objArr) {
            HttpNetContext httpNetContext;
            d.a.c.e.d.l<String> h2;
            this.f12959a.n = true;
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f12959a.M());
            for (Map.Entry<String, Object> entry : this.f12959a.f12947g.s().entrySet()) {
                netWork.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String postNetData = netWork.postNetData();
            this.f12960b = netWork.getNetContext();
            D b2 = b(this.f12959a.getResponseDataClass());
            if (postNetData != null) {
                try {
                    b2.initByJson(new JSONObject(postNetData));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            publishProgress(b2);
            if (this.f12959a.isNeedCache() && (httpNetContext = this.f12960b) != null && httpNetContext.getResponse() != null && this.f12960b.getResponse().isRequestSuccess() && b2 != null) {
                T t = this.f12959a.f12947g;
                if (t instanceof d.a.m0.g0.b.d) {
                    d.a.m0.g0.b.d dVar = (d.a.m0.g0.b.d) t;
                    String cacheKey = dVar.getCacheKey();
                    String v = dVar.v();
                    String currentAccount = dVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                    if (cacheKey == null || TextUtils.isEmpty(v) || b2 == null || (h2 = d.a.m0.r.r.a.f().h(v, currentAccount)) == null) {
                        return b2;
                    }
                    h2.g(cacheKey, postNetData);
                }
            }
            return b2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(D d2) {
            super.onPostExecute(d2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: e */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr == null || dArr.length <= 0) {
                return;
            }
            this.f12959a.n = false;
            if (this.f12959a.q != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.f12959a.q);
            }
            NetModel<T, D, ActivityType> netModel = this.f12959a;
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(netModel.f12947g, netModel.J());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.f12959a.J());
            mvcJsonHttpResponsedMessage.setData(dArr[0]);
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            HttpNetContext httpNetContext = this.f12960b;
            if (httpNetContext != null && httpNetContext.getResponse() != null) {
                mvcJsonHttpResponsedMessage.setStatusCode(this.f12960b.getResponse().mNetErrorCode, this.f12960b.getResponse().mErrorString);
                mvcJsonHttpResponsedMessage.setError(this.f12960b.getResponse().mServerErrorCode);
                mvcJsonHttpResponsedMessage.setErrorString(this.f12960b.getResponse().mErrorString);
                if (this.f12960b.getResponse().mException != null) {
                    BdLog.e(this.f12960b.getResponse().mException);
                }
            }
            this.f12959a.Y();
            if (this.f12959a.f12945e != null) {
                this.f12959a.f12945e.p(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface k<T extends d.a.m0.g0.b.g, D extends d.a.m0.g0.b.h> extends l<T, D>, m<T, D> {
    }

    /* loaded from: classes3.dex */
    public interface l<T extends d.a.m0.g0.b.g, D extends d.a.m0.g0.b.h> {
        void p(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes3.dex */
    public interface m<T extends d.a.m0.g0.b.g, D extends d.a.m0.g0.b.h> {
        void k(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.f12949i = null;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = true;
        this.f12947g = t;
        this.f12948h = netModelType;
    }

    public final void F() {
        if (this.k || MessageManager.getInstance().findTask(J()) != null) {
            return;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(J(), TbConfig.SERVER_ADDRESS + M());
        tbHttpMessageTask.setResponsedClass(K());
        V(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterTask(J());
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.k = true;
    }

    public final void G() {
        if (this.k || MessageManager.getInstance().findTask(J()) != null) {
            return;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(J(), TbConfig.SERVER_ADDRESS + M() + "?cmd=" + N());
        tbHttpMessageTask.setResponsedClass(L());
        W(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterTask(J());
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.k = true;
    }

    public final void H() {
        if (this.m) {
            return;
        }
        int i2 = a.f12950a[this.f12948h.ordinal()];
        if (i2 == 1) {
            g gVar = new g(J(), N());
            gVar.getHttpMessageListener().setSelfListener(true);
            gVar.getSocketMessageListener().setSelfListener(true);
            gVar.setTag(getUniqueId());
            registerListener(gVar);
        } else if (i2 == 2) {
            i iVar = new i(N(), true);
            iVar.setTag(getUniqueId());
            registerListener(iVar);
        } else if (i2 == 3) {
            h hVar = new h(J(), true);
            hVar.setTag(getUniqueId());
            registerListener(hVar);
        }
        this.m = true;
    }

    public final void I() {
        if (this.l || MessageManager.getInstance().findTask(N()) != null) {
            return;
        }
        d.a.m0.v0.b bVar = new d.a.m0.v0.b(N());
        bVar.setResponsedClass(O());
        X(bVar);
        MessageManager.getInstance().unRegisterTask(N());
        MessageManager.getInstance().registerTask(bVar);
        this.l = true;
    }

    public abstract int J();

    public Class<? extends MvcJsonHttpResponsedMessage> K() {
        return MvcJsonHttpResponsedMessage.class;
    }

    public Class<? extends MvcProtobufHttpResponsedMessage> L() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    public boolean LoadData() {
        return false;
    }

    public abstract String M();

    public abstract int N();

    public Class<? extends MvcSocketResponsedMessage> O() {
        return MvcSocketResponsedMessage.class;
    }

    public Runnable P() {
        if (this.q == null) {
            this.q = new b();
        }
        return this.q;
    }

    public boolean Q() {
        return this.n;
    }

    public boolean R() {
        if (this.f12946f == null && this.f12945e == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.p = d.a.c.e.p.l.D();
        if (this.o >= 10) {
            d.a.c.e.m.e.a().postDelayed(P(), this.o * 1000);
        }
        int i2 = a.f12950a[this.f12948h.ordinal()];
        if (i2 == 1) {
            if (!this.p) {
                d.a.c.e.m.e.a().post(new c());
                return false;
            }
            this.n = true;
            G();
            I();
            H();
            MvcNetMessage mvcNetMessage = new MvcNetMessage(this.f12947g, J(), N());
            mvcNetMessage.setNeedCache(isNeedCache());
            mvcNetMessage.setResponseDataClass(getResponseDataClass());
            mvcNetMessage.setTag(this.unique_id);
            HashMap<String, String> u = this.f12947g.u();
            if (u != null) {
                for (Map.Entry<String, String> entry : u.entrySet()) {
                    mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                }
            }
            sendMessage(mvcNetMessage);
            return true;
        } else if (i2 == 2) {
            if (!this.p) {
                d.a.c.e.m.e.a().post(new e());
                return false;
            }
            this.n = true;
            I();
            H();
            MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.f12947g, N());
            mvcSocketMessage.setResponseDataClass(getResponseDataClass());
            mvcSocketMessage.setNeedCache(isNeedCache());
            mvcSocketMessage.setTag(this.unique_id);
            sendMessage(mvcSocketMessage);
            return true;
        } else if (i2 != 3) {
            if (i2 == 4) {
                if (!this.p) {
                    d.a.c.e.m.e.a().post(new f());
                    return false;
                } else if (this.f12949i == null) {
                    j<T, D, ActivityType> jVar = new j<>(this);
                    this.f12949i = jVar;
                    jVar.execute(new Object[0]);
                    return true;
                }
            }
            return false;
        } else if (!this.p) {
            d.a.c.e.m.e.a().post(new d());
            return false;
        } else {
            this.n = true;
            F();
            H();
            MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.f12947g, J());
            mvcHttpMessage.setResponseDataClass(getResponseDataClass());
            HashMap<String, Object> s = this.f12947g.s();
            if (s != null) {
                for (Map.Entry<String, Object> entry2 : s.entrySet()) {
                    mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                }
            }
            HashMap<String, String> u2 = this.f12947g.u();
            if (u2 != null) {
                for (Map.Entry<String, String> entry3 : u2.entrySet()) {
                    mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                }
            }
            mvcHttpMessage.setNeedCache(isNeedCache());
            mvcHttpMessage.setTag(this.unique_id);
            sendMessage(mvcHttpMessage);
            return true;
        }
    }

    public final void S(int i2, String str) {
        if (this.f12945e != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.f12947g, J());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(J());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i2);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.f12945e.p(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    public final void T(int i2, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.f12947g, J(), N());
        if (this.f12946f != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(N()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                public Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i2);
            mvcSocketResponsedMessage.setErrorString(str);
            this.f12946f.k(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.f12945e != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(J()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                public Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i2);
            mvcHttpResponsedMessage.setErrorString(str);
            this.f12945e.p(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    public final void U(int i2, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.f12947g, N());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(N()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            public Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i2);
        mvcSocketResponsedMessage.setErrorString(str);
        this.f12946f.k(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    public void V(TbHttpMessageTask tbHttpMessageTask) {
    }

    public void W(TbHttpMessageTask tbHttpMessageTask) {
    }

    public void X(d.a.m0.v0.b bVar) {
    }

    public final void Y() {
        this.f12949i = null;
    }

    public void Z(k<T, D> kVar) {
        this.f12945e = kVar;
        this.f12946f = kVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.n = false;
        MessageManager.getInstance().removeMessage(N(), this.unique_id);
        MessageManager.getInstance().removeMessage(J(), this.unique_id);
        return true;
    }

    public abstract Class<D> getResponseDataClass();

    public boolean isNeedCache() {
        return this.j;
    }

    public void setNeedCache(boolean z) {
        this.j = z;
    }
}
