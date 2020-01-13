package com.baidu.tbadk.mvc.model;

import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.mvc.b.h;
import com.baidu.tbadk.mvc.b.j;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcJsonHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import protobuf.Error;
/* loaded from: classes.dex */
public abstract class NetModel<T extends h, D extends j, ActivityType> extends BdBaseModel<ActivityType> {
    private c<T, D> dya;
    private d<T, D> dyb;
    protected T dyc;
    private final NetModelType dyd;
    private a<T, D, ActivityType> dye;
    private boolean dyf;
    private boolean dyg;
    private boolean dyh;
    private boolean dyi;
    private Runnable dyj;
    private boolean isLoading;
    private boolean isNeedCache;
    private TbPageContext<ActivityType> mPageContext;
    private int timeout;

    /* loaded from: classes.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK
    }

    /* loaded from: classes.dex */
    public interface b<T extends h, D extends j> extends c<T, D>, d<T, D> {
    }

    /* loaded from: classes.dex */
    public interface c<T extends h, D extends j> {
        void a(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes.dex */
    public interface d<T extends h, D extends j> {
        void a(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    protected abstract int aOh();

    protected abstract int aOi();

    protected abstract String aOj();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.dye = null;
        this.isNeedCache = false;
        this.dyf = false;
        this.dyg = false;
        this.dyh = false;
        this.isLoading = false;
        this.timeout = -1;
        this.dyi = true;
        this.mPageContext = tbPageContext;
        this.dyc = t;
        this.dyd = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable aOk() {
        if (this.dyj == null) {
            this.dyj = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.dyk[NetModel.this.dyd.ordinal()]) {
                        case 1:
                            NetModel.this.T(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        case 2:
                            NetModel.this.V(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.U(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.dyj;
    }

    public boolean loadData() {
        if (this.dyb == null && this.dya == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.dyi = l.isNetOk();
        if (this.timeout >= 10) {
            e.gx().postDelayed(aOk(), this.timeout * 1000);
        }
        switch (this.dyd) {
            case TYPE_AUTO:
                if (!this.dyi) {
                    e.gx().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.T(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aOn();
                aOp();
                aOl();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.dyc, aOh(), aOi());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> aNP = this.dyc.aNP();
                if (aNP != null) {
                    for (Map.Entry<String, String> entry : aNP.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.dyi) {
                    e.gx().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.V(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aOp();
                aOl();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.dyc, aOi());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.dyi) {
                    e.gx().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.U(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                aOo();
                aOl();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.dyc, aOh());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> aNO = this.dyc.aNO();
                if (aNO != null) {
                    for (Map.Entry<String, Object> entry2 : aNO.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> aNP2 = this.dyc.aNP();
                if (aNP2 != null) {
                    for (Map.Entry<String, String> entry3 : aNP2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.dyi) {
                    e.gx().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.U(-1, NetModel.this.mPageContext.getString(R.string.neterror));
                        }
                    });
                    return false;
                } else if (this.dye == null) {
                    this.dye = new a<>(this);
                    this.dye.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void aOl() {
        if (!this.dyh) {
            switch (this.dyd) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(aOh(), aOi()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.dyj != null) {
                                e.gx().removeCallbacks(NetModel.this.dyj);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.dya != null) {
                                    NetModel.this.dya.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.dyb != null) {
                                    NetModel.this.dyb.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel NetListener responsedMessage error");
                            }
                        }
                    };
                    aVar.getHttpMessageListener().setSelfListener(true);
                    aVar.getSocketMessageListener().setSelfListener(true);
                    aVar.setTag(getUniqueId());
                    registerListener(aVar);
                    break;
                case TYPE_SOCKET:
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(aOi(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.dyj != null) {
                                e.gx().removeCallbacks(NetModel.this.dyj);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.dyb != null) {
                                        NetModel.this.dyb.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage originaMessage error");
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel SocketListener socketResponsedMessage error");
                            }
                        }
                    };
                    cVar.setTag(getUniqueId());
                    registerListener(cVar);
                    break;
                case TYPE_HTTP:
                    HttpMessageListener httpMessageListener = new HttpMessageListener(aOh(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.dyj != null) {
                                e.gx().removeCallbacks(NetModel.this.dyj);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.dya != null) {
                                        NetModel.this.dya.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
                                    }
                                } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                    throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage originaMessage error");
                                }
                            } else if (TbadkCoreApplication.getInst().isDebugMode()) {
                                throw new RuntimeException("mvc netmodel HttpListener jsonHttpResponsedMessage error");
                            }
                        }
                    };
                    httpMessageListener.setTag(getUniqueId());
                    registerListener(httpMessageListener);
                    break;
            }
            this.dyh = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> aOf() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> aOm() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> aOg() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    private void aOn() {
        if (!this.dyf && MessageManager.getInstance().findTask(aOh()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aOh(), TbConfig.SERVER_ADDRESS + aOj() + "?cmd=" + aOi());
            tbHttpMessageTask.setResponsedClass(aOf());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aOh());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.dyf = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aOo() {
        if (!this.dyf && MessageManager.getInstance().findTask(aOh()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(aOh(), TbConfig.SERVER_ADDRESS + aOj());
            tbHttpMessageTask.setResponsedClass(aOm());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(aOh());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.dyf = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void aOp() {
        if (!this.dyg && MessageManager.getInstance().findTask(aOi()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(aOi());
            bVar.setResponsedClass(aOg());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(aOi());
            MessageManager.getInstance().registerTask(bVar);
            this.dyg = true;
        }
    }

    protected void a(com.baidu.tbadk.task.b bVar) {
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        this.isLoading = false;
        MessageManager.getInstance().removeMessage(aOi(), this.unique_id);
        MessageManager.getInstance().removeMessage(aOh(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.dyc, aOh(), aOi());
        if (this.dyb != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aOi()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.dyb.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.dya != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(aOh()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.dya.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
        if (this.dya != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.dyc, aOh());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(aOh());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.dya.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.dyc, aOi());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(aOi()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.dyb.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOq() {
        this.dye = null;
    }

    public void a(b<T, D> bVar) {
        this.dya = bVar;
        this.dyb = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private NetModel<T, D, ActivityType> dyl;
        private com.baidu.tbadk.core.util.a.a dym;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.dyl = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: n */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.dyl).isLoading = true;
            x xVar = new x(TbConfig.SERVER_ADDRESS + this.dyl.aOj());
            for (Map.Entry<String, Object> entry : this.dyl.dyc.aNO().entrySet()) {
                xVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String postNetData = xVar.postNetData();
            this.dym = xVar.aDU();
            D u = u(this.dyl.getResponseDataClass());
            if (postNetData != null) {
                try {
                    u.initByJson(new JSONObject(postNetData));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(u);
            if (this.dyl.isNeedCache() && this.dym != null && this.dym.aEv() != null && this.dym.aEv().isRequestSuccess() && u != null && (this.dyl.dyc instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.dyl.dyc;
                String cacheKey = eVar.getCacheKey();
                String aNL = eVar.aNL();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(aNL) || u == null) {
                    return u;
                }
                com.baidu.adp.lib.cache.l<String> ci = com.baidu.tbadk.core.c.a.aCo().ci(aNL, currentAccount);
                if (ci == null) {
                    return u;
                }
                ci.setForever(cacheKey, postNetData);
            }
            return u;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.dyl).isLoading = false;
                if (((NetModel) this.dyl).dyj != null) {
                    e.gx().removeCallbacks(((NetModel) this.dyl).dyj);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.dyl.dyc, this.dyl.aOh());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.dyl.aOh());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.dym != null && this.dym.aEv() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.dym.aEv().mNetErrorCode, this.dym.aEv().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.dym.aEv().mServerErrorCode);
                    mvcJsonHttpResponsedMessage.setErrorString(this.dym.aEv().mErrorString);
                    if (this.dym.aEv().mException != null) {
                        BdLog.e(this.dym.aEv().mException);
                    }
                }
                this.dyl.aOq();
                if (((NetModel) this.dyl).dya != null) {
                    ((NetModel) this.dyl).dya.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D u(Class<D> cls) {
            try {
                return cls.newInstance();
            } catch (ExceptionInInitializerError e) {
                e.printStackTrace();
                return null;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return null;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return null;
            }
        }
    }
}
