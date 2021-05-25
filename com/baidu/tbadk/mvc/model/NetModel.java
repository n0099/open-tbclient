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
    public l<T, D> f12880e;

    /* renamed from: f  reason: collision with root package name */
    public m<T, D> f12881f;

    /* renamed from: g  reason: collision with root package name */
    public T f12882g;

    /* renamed from: h  reason: collision with root package name */
    public final NetModelType f12883h;

    /* renamed from: i  reason: collision with root package name */
    public j<T, D, ActivityType> f12884i;
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
        public static final /* synthetic */ int[] f12885a;

        static {
            int[] iArr = new int[NetModelType.values().length];
            f12885a = iArr;
            try {
                iArr[NetModelType.TYPE_AUTO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12885a[NetModelType.TYPE_SOCKET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12885a[NetModelType.TYPE_HTTP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12885a[NetModelType.TYPE_NETWORK.ordinal()] = 4;
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
            int i2 = a.f12885a[NetModel.this.f12883h.ordinal()];
            if (i2 == 1) {
                NetModel.this.P(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            } else if (i2 == 2) {
                NetModel.this.Q(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            } else if (i2 == 3 || i2 == 4) {
                NetModel.this.O(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetModel.this.P(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetModel.this.O(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetModel.this.Q(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
        }
    }

    /* loaded from: classes3.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NetModel.this.O(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
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
                if (NetModel.this.f12880e != null) {
                    NetModel.this.f12880e.l((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                }
            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                if (NetModel.this.f12881f != null) {
                    NetModel.this.f12881f.h((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    if (NetModel.this.f12880e != null) {
                        NetModel.this.f12880e.l((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
                    if (NetModel.this.f12881f != null) {
                        NetModel.this.f12881f.h((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
        public NetModel<T, D, ActivityType> f12894a;

        /* renamed from: b  reason: collision with root package name */
        public HttpNetContext f12895b;

        public j(NetModel<T, D, ActivityType> netModel) {
            this.f12894a = netModel;
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
            this.f12894a.n = true;
            NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + this.f12894a.I());
            for (Map.Entry<String, Object> entry : this.f12894a.f12882g.o().entrySet()) {
                netWork.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String postNetData = netWork.postNetData();
            this.f12895b = netWork.getNetContext();
            D b2 = b(this.f12894a.getResponseDataClass());
            if (postNetData != null) {
                try {
                    b2.initByJson(new JSONObject(postNetData));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
            publishProgress(b2);
            if (this.f12894a.isNeedCache() && (httpNetContext = this.f12895b) != null && httpNetContext.getResponse() != null && this.f12895b.getResponse().isRequestSuccess() && b2 != null) {
                T t = this.f12894a.f12882g;
                if (t instanceof d.a.m0.g0.b.d) {
                    d.a.m0.g0.b.d dVar = (d.a.m0.g0.b.d) t;
                    String cacheKey = dVar.getCacheKey();
                    String r = dVar.r();
                    String currentAccount = dVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                    if (cacheKey == null || TextUtils.isEmpty(r) || b2 == null || (h2 = d.a.m0.r.r.a.f().h(r, currentAccount)) == null) {
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
            this.f12894a.n = false;
            if (this.f12894a.q != null) {
                d.a.c.e.m.e.a().removeCallbacks(this.f12894a.q);
            }
            NetModel<T, D, ActivityType> netModel = this.f12894a;
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(netModel.f12882g, netModel.F());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.f12894a.F());
            mvcJsonHttpResponsedMessage.setData(dArr[0]);
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            HttpNetContext httpNetContext = this.f12895b;
            if (httpNetContext != null && httpNetContext.getResponse() != null) {
                mvcJsonHttpResponsedMessage.setStatusCode(this.f12895b.getResponse().mNetErrorCode, this.f12895b.getResponse().mErrorString);
                mvcJsonHttpResponsedMessage.setError(this.f12895b.getResponse().mServerErrorCode);
                mvcJsonHttpResponsedMessage.setErrorString(this.f12895b.getResponse().mErrorString);
                if (this.f12895b.getResponse().mException != null) {
                    BdLog.e(this.f12895b.getResponse().mException);
                }
            }
            this.f12894a.U();
            if (this.f12894a.f12880e != null) {
                this.f12894a.f12880e.l(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface k<T extends d.a.m0.g0.b.g, D extends d.a.m0.g0.b.h> extends l<T, D>, m<T, D> {
    }

    /* loaded from: classes3.dex */
    public interface l<T extends d.a.m0.g0.b.g, D extends d.a.m0.g0.b.h> {
        void l(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes3.dex */
    public interface m<T extends d.a.m0.g0.b.g, D extends d.a.m0.g0.b.h> {
        void h(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.f12884i = null;
        this.j = false;
        this.k = false;
        this.l = false;
        this.m = false;
        this.n = false;
        this.o = -1;
        this.p = true;
        this.f12882g = t;
        this.f12883h = netModelType;
    }

    public final void B() {
        if (this.k || MessageManager.getInstance().findTask(F()) != null) {
            return;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(F(), TbConfig.SERVER_ADDRESS + I());
        tbHttpMessageTask.setResponsedClass(G());
        R(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterTask(F());
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.k = true;
    }

    public final void C() {
        if (this.k || MessageManager.getInstance().findTask(F()) != null) {
            return;
        }
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(F(), TbConfig.SERVER_ADDRESS + I() + "?cmd=" + J());
        tbHttpMessageTask.setResponsedClass(H());
        S(tbHttpMessageTask);
        MessageManager.getInstance().unRegisterTask(F());
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        this.k = true;
    }

    public final void D() {
        if (this.m) {
            return;
        }
        int i2 = a.f12885a[this.f12883h.ordinal()];
        if (i2 == 1) {
            g gVar = new g(F(), J());
            gVar.getHttpMessageListener().setSelfListener(true);
            gVar.getSocketMessageListener().setSelfListener(true);
            gVar.setTag(getUniqueId());
            registerListener(gVar);
        } else if (i2 == 2) {
            i iVar = new i(J(), true);
            iVar.setTag(getUniqueId());
            registerListener(iVar);
        } else if (i2 == 3) {
            h hVar = new h(F(), true);
            hVar.setTag(getUniqueId());
            registerListener(hVar);
        }
        this.m = true;
    }

    public final void E() {
        if (this.l || MessageManager.getInstance().findTask(J()) != null) {
            return;
        }
        d.a.m0.v0.b bVar = new d.a.m0.v0.b(J());
        bVar.setResponsedClass(K());
        T(bVar);
        MessageManager.getInstance().unRegisterTask(J());
        MessageManager.getInstance().registerTask(bVar);
        this.l = true;
    }

    public abstract int F();

    public Class<? extends MvcJsonHttpResponsedMessage> G() {
        return MvcJsonHttpResponsedMessage.class;
    }

    public Class<? extends MvcProtobufHttpResponsedMessage> H() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    public abstract String I();

    public abstract int J();

    public Class<? extends MvcSocketResponsedMessage> K() {
        return MvcSocketResponsedMessage.class;
    }

    public Runnable L() {
        if (this.q == null) {
            this.q = new b();
        }
        return this.q;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    public boolean LoadData() {
        return false;
    }

    public boolean M() {
        return this.n;
    }

    public boolean N() {
        if (this.f12881f == null && this.f12880e == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.p = d.a.c.e.p.l.D();
        if (this.o >= 10) {
            d.a.c.e.m.e.a().postDelayed(L(), this.o * 1000);
        }
        int i2 = a.f12885a[this.f12883h.ordinal()];
        if (i2 == 1) {
            if (!this.p) {
                d.a.c.e.m.e.a().post(new c());
                return false;
            }
            this.n = true;
            C();
            E();
            D();
            MvcNetMessage mvcNetMessage = new MvcNetMessage(this.f12882g, F(), J());
            mvcNetMessage.setNeedCache(isNeedCache());
            mvcNetMessage.setResponseDataClass(getResponseDataClass());
            mvcNetMessage.setTag(this.unique_id);
            HashMap<String, String> q = this.f12882g.q();
            if (q != null) {
                for (Map.Entry<String, String> entry : q.entrySet()) {
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
            E();
            D();
            MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.f12882g, J());
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
                } else if (this.f12884i == null) {
                    j<T, D, ActivityType> jVar = new j<>(this);
                    this.f12884i = jVar;
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
            B();
            D();
            MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.f12882g, F());
            mvcHttpMessage.setResponseDataClass(getResponseDataClass());
            HashMap<String, Object> o = this.f12882g.o();
            if (o != null) {
                for (Map.Entry<String, Object> entry2 : o.entrySet()) {
                    mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                }
            }
            HashMap<String, String> q2 = this.f12882g.q();
            if (q2 != null) {
                for (Map.Entry<String, String> entry3 : q2.entrySet()) {
                    mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                }
            }
            mvcHttpMessage.setNeedCache(isNeedCache());
            mvcHttpMessage.setTag(this.unique_id);
            sendMessage(mvcHttpMessage);
            return true;
        }
    }

    public final void O(int i2, String str) {
        if (this.f12880e != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.f12882g, F());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(F());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i2);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.f12880e.l(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    public final void P(int i2, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.f12882g, F(), J());
        if (this.f12881f != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(J()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                public Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i2);
            mvcSocketResponsedMessage.setErrorString(str);
            this.f12881f.h(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.f12880e != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(F()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                public Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i2);
            mvcHttpResponsedMessage.setErrorString(str);
            this.f12880e.l(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    public final void Q(int i2, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.f12882g, J());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(J()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            public Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i2);
        mvcSocketResponsedMessage.setErrorString(str);
        this.f12881f.h(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    public void R(TbHttpMessageTask tbHttpMessageTask) {
    }

    public void S(TbHttpMessageTask tbHttpMessageTask) {
    }

    public void T(d.a.m0.v0.b bVar) {
    }

    public final void U() {
        this.f12884i = null;
    }

    public void V(k<T, D> kVar) {
        this.f12880e = kVar;
        this.f12881f = kVar;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.n = false;
        MessageManager.getInstance().removeMessage(J(), this.unique_id);
        MessageManager.getInstance().removeMessage(F(), this.unique_id);
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
