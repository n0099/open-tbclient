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
import com.baidu.tbadk.core.util.aa;
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
/* loaded from: classes2.dex */
public abstract class NetModel<T extends h, D extends j, ActivityType> extends BdBaseModel<ActivityType> {
    private boolean bDQ;
    private Runnable bDR;
    protected T bEd;
    private boolean bEi;
    private boolean bEj;
    private boolean bEk;
    private c<T, D> eQu;
    private d<T, D> eQv;
    private final NetModelType eQw;
    private a<T, D, ActivityType> eQx;
    private boolean isLoading;
    private boolean isNeedCache;
    private int timeout;

    /* loaded from: classes2.dex */
    public enum NetModelType {
        TYPE_HTTP,
        TYPE_SOCKET,
        TYPE_AUTO,
        TYPE_NETWORK
    }

    /* loaded from: classes2.dex */
    public interface b<T extends h, D extends j> extends c<T, D>, d<T, D> {
    }

    /* loaded from: classes2.dex */
    public interface c<T extends h, D extends j> {
        void a(MvcHttpResponsedMessage<D> mvcHttpResponsedMessage, MvcHttpMessage<T, D> mvcHttpMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    /* loaded from: classes2.dex */
    public interface d<T extends h, D extends j> {
        void a(MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage, MvcSocketMessage<T, D> mvcSocketMessage, MvcNetMessage<T, D> mvcNetMessage);
    }

    protected abstract int TA();

    protected abstract int TB();

    protected abstract String Tu();

    protected abstract Class<D> getResponseDataClass();

    public NetModel(TbPageContext<ActivityType> tbPageContext, T t, NetModelType netModelType) {
        super(tbPageContext);
        this.eQx = null;
        this.isNeedCache = false;
        this.bEi = false;
        this.bEj = false;
        this.bEk = false;
        this.isLoading = false;
        this.timeout = -1;
        this.bDQ = true;
        this.bEd = t;
        this.eQw = netModelType;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isNeedCache() {
        return this.isNeedCache;
    }

    public void setNeedCache(boolean z) {
        this.isNeedCache = z;
    }

    public Runnable Tz() {
        if (this.bDR == null) {
            this.bDR = new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.1
                @Override // java.lang.Runnable
                public void run() {
                    switch (AnonymousClass2.eQy[NetModel.this.eQw.ordinal()]) {
                        case 1:
                            NetModel.this.I(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 2:
                            NetModel.this.J(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        case 3:
                        case 4:
                            NetModel.this.H(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                            return;
                        default:
                            return;
                    }
                }
            };
        }
        return this.bDR;
    }

    public boolean loadData() {
        if (this.eQv == null && this.eQu == null && TbadkCoreApplication.getInst().isDebugMode()) {
            throw new RuntimeException("NetModel must have callback");
        }
        this.bDQ = l.isNetOk();
        if (this.timeout >= 10) {
            e.mS().postDelayed(Tz(), this.timeout * 1000);
        }
        switch (this.eQw) {
            case TYPE_AUTO:
                if (!this.bDQ) {
                    e.mS().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.3
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.I(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                TH();
                TJ();
                TD();
                MvcNetMessage mvcNetMessage = new MvcNetMessage(this.bEd, TB(), TA());
                mvcNetMessage.setNeedCache(isNeedCache());
                mvcNetMessage.setResponseDataClass(getResponseDataClass());
                mvcNetMessage.setTag(this.unique_id);
                HashMap<String, String> bts = this.bEd.bts();
                if (bts != null) {
                    for (Map.Entry<String, String> entry : bts.entrySet()) {
                        mvcNetMessage.getHttpMessage().addHeader(entry.getKey(), entry.getValue());
                    }
                }
                sendMessage(mvcNetMessage);
                return true;
            case TYPE_SOCKET:
                if (!this.bDQ) {
                    e.mS().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.5
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.J(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                TJ();
                TD();
                MvcSocketMessage mvcSocketMessage = new MvcSocketMessage(this.bEd, TA());
                mvcSocketMessage.setResponseDataClass(getResponseDataClass());
                mvcSocketMessage.setNeedCache(isNeedCache());
                mvcSocketMessage.setTag(this.unique_id);
                sendMessage(mvcSocketMessage);
                return true;
            case TYPE_HTTP:
                if (!this.bDQ) {
                    e.mS().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.4
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.H(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                }
                this.isLoading = true;
                TI();
                TD();
                MvcHttpMessage mvcHttpMessage = new MvcHttpMessage(this.bEd, TB());
                mvcHttpMessage.setResponseDataClass(getResponseDataClass());
                HashMap<String, Object> btr = this.bEd.btr();
                if (btr != null) {
                    for (Map.Entry<String, Object> entry2 : btr.entrySet()) {
                        mvcHttpMessage.addParam(entry2.getKey(), entry2.getValue());
                    }
                }
                HashMap<String, String> bts2 = this.bEd.bts();
                if (bts2 != null) {
                    for (Map.Entry<String, String> entry3 : bts2.entrySet()) {
                        mvcHttpMessage.addHeader(entry3.getKey(), entry3.getValue());
                    }
                }
                mvcHttpMessage.setNeedCache(isNeedCache());
                mvcHttpMessage.setTag(this.unique_id);
                sendMessage(mvcHttpMessage);
                return true;
            case TYPE_NETWORK:
                if (!this.bDQ) {
                    e.mS().post(new Runnable() { // from class: com.baidu.tbadk.mvc.model.NetModel.6
                        @Override // java.lang.Runnable
                        public void run() {
                            NetModel.this.H(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    });
                    return false;
                } else if (this.eQx == null) {
                    this.eQx = new a<>(this);
                    this.eQx.execute(new Object[0]);
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private void TD() {
        if (!this.bEk) {
            switch (this.eQw) {
                case TYPE_AUTO:
                    com.baidu.adp.framework.listener.a aVar = new com.baidu.adp.framework.listener.a(TB(), TA()) { // from class: com.baidu.tbadk.mvc.model.NetModel.7
                        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.baidu.tbadk.mvc.model.NetModel$d */
                        /* JADX DEBUG: Multi-variable search result rejected for r2v8, resolved type: com.baidu.tbadk.mvc.model.NetModel$c */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.adp.framework.listener.a
                        public void onMessage(ResponsedMessage<?> responsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.bDR != null) {
                                e.mS().removeCallbacks(NetModel.this.bDR);
                            }
                            if (responsedMessage instanceof MvcProtobufHttpResponsedMessage) {
                                MvcNetMessage mvcNetMessage = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.eQu != null) {
                                    NetModel.this.eQu.a((MvcProtobufHttpResponsedMessage) responsedMessage, null, mvcNetMessage);
                                }
                            } else if (responsedMessage instanceof MvcSocketResponsedMessage) {
                                MvcNetMessage mvcNetMessage2 = responsedMessage.getOrginalMessage().getExtra() instanceof MvcNetMessage ? (MvcNetMessage) responsedMessage.getOrginalMessage().getExtra() : null;
                                if (NetModel.this.eQv != null) {
                                    NetModel.this.eQv.a((MvcSocketResponsedMessage) responsedMessage, null, mvcNetMessage2);
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
                    com.baidu.adp.framework.listener.c cVar = new com.baidu.adp.framework.listener.c(TA(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.12
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.bDR != null) {
                                e.mS().removeCallbacks(NetModel.this.bDR);
                            }
                            if (socketResponsedMessage instanceof MvcSocketResponsedMessage) {
                                if (socketResponsedMessage.getOrginalMessage() instanceof MvcSocketMessage) {
                                    if (NetModel.this.eQv != null) {
                                        NetModel.this.eQv.a((MvcSocketResponsedMessage) socketResponsedMessage, (MvcSocketMessage) socketResponsedMessage.getOrginalMessage(), null);
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
                    HttpMessageListener httpMessageListener = new HttpMessageListener(TB(), true) { // from class: com.baidu.tbadk.mvc.model.NetModel.8
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.adp.framework.listener.MessageListener
                        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                            NetModel.this.isLoading = false;
                            if (NetModel.this.bDR != null) {
                                e.mS().removeCallbacks(NetModel.this.bDR);
                            }
                            if (httpResponsedMessage instanceof MvcJsonHttpResponsedMessage) {
                                if (httpResponsedMessage.getOrginalMessage() instanceof MvcHttpMessage) {
                                    if (NetModel.this.eQu != null) {
                                        NetModel.this.eQu.a((MvcJsonHttpResponsedMessage) httpResponsedMessage, (MvcHttpMessage) httpResponsedMessage.getOrginalMessage(), null);
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
            this.bEk = true;
        }
    }

    protected Class<? extends MvcProtobufHttpResponsedMessage> TE() {
        return MvcProtobufHttpResponsedMessage.class;
    }

    protected Class<? extends MvcJsonHttpResponsedMessage> TF() {
        return MvcJsonHttpResponsedMessage.class;
    }

    protected Class<? extends MvcSocketResponsedMessage> TG() {
        return MvcSocketResponsedMessage.class;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    private void TH() {
        if (!this.bEi && MessageManager.getInstance().findTask(TB()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(TB(), TbConfig.SERVER_ADDRESS + Tu() + "?cmd=" + TA());
            tbHttpMessageTask.setResponsedClass(TE());
            a(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(TB());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bEi = true;
        }
    }

    protected void a(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void TI() {
        if (!this.bEi && MessageManager.getInstance().findTask(TB()) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(TB(), TbConfig.SERVER_ADDRESS + Tu());
            tbHttpMessageTask.setResponsedClass(TF());
            b(tbHttpMessageTask);
            MessageManager.getInstance().unRegisterTask(TB());
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            this.bEi = true;
        }
    }

    protected void b(TbHttpMessageTask tbHttpMessageTask) {
    }

    private void TJ() {
        if (!this.bEj && MessageManager.getInstance().findTask(TA()) == null) {
            com.baidu.tbadk.task.b bVar = new com.baidu.tbadk.task.b(TA());
            bVar.setResponsedClass(TG());
            a(bVar);
            MessageManager.getInstance().unRegisterTask(TA());
            MessageManager.getInstance().registerTask(bVar);
            this.bEj = true;
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
        MessageManager.getInstance().removeMessage(TA(), this.unique_id);
        MessageManager.getInstance().removeMessage(TB(), this.unique_id);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(int i, String str) {
        MvcNetMessage<T, D> mvcNetMessage = new MvcNetMessage<>(this.bEd, TB(), TA());
        if (this.eQv != null) {
            MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(TA()) { // from class: com.baidu.tbadk.mvc.model.NetModel.9
                @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
                protected Class getProtobufResponseIdlClass() {
                    return null;
                }
            };
            mvcSocketResponsedMessage.setOrginalMessage(mvcNetMessage.getSocketMessage());
            mvcSocketResponsedMessage.setError(i);
            mvcSocketResponsedMessage.setErrorString(str);
            this.eQv.a(mvcSocketResponsedMessage, null, mvcNetMessage);
        } else if (this.eQu != null) {
            MvcHttpResponsedMessage<D> mvcHttpResponsedMessage = new MvcProtobufHttpResponsedMessage<D, Error>(TB()) { // from class: com.baidu.tbadk.mvc.model.NetModel.10
                @Override // com.baidu.tbadk.mvc.message.MvcProtobufHttpResponsedMessage
                protected Class<Error> getProtobufResponseIdlClass() {
                    return Error.class;
                }
            };
            mvcHttpResponsedMessage.setOrginalMessage(mvcNetMessage.getHttpMessage());
            mvcHttpResponsedMessage.setError(i);
            mvcHttpResponsedMessage.setErrorString(str);
            this.eQu.a(mvcHttpResponsedMessage, null, mvcNetMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(int i, String str) {
        if (this.eQu != null) {
            MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.bEd, TB());
            MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(TB());
            mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
            mvcJsonHttpResponsedMessage.setError(i);
            mvcJsonHttpResponsedMessage.setErrorString(str);
            this.eQu.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(int i, String str) {
        MvcSocketMessage<T, D> mvcSocketMessage = new MvcSocketMessage<>(this.bEd, TA());
        MvcSocketResponsedMessage<D, ?> mvcSocketResponsedMessage = new MvcSocketResponsedMessage(TA()) { // from class: com.baidu.tbadk.mvc.model.NetModel.11
            @Override // com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage
            protected Class getProtobufResponseIdlClass() {
                return null;
            }
        };
        mvcSocketResponsedMessage.setOrginalMessage(mvcSocketMessage);
        mvcSocketResponsedMessage.setError(i);
        mvcSocketResponsedMessage.setErrorString(str);
        this.eQv.a(mvcSocketResponsedMessage, mvcSocketMessage, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Tw() {
        this.eQx = null;
    }

    public void a(b<T, D> bVar) {
        this.eQu = bVar;
        this.eQv = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a<T extends h, D extends j, ActivityType> extends BdAsyncTask<Object, D, D> {
        private com.baidu.tbadk.core.util.a.a bDX;
        private NetModel<T, D, ActivityType> eQz;

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.baidu.tbadk.mvc.model.NetModel$a<T extends com.baidu.tbadk.mvc.b.h, D extends com.baidu.tbadk.mvc.b.j, ActivityType> */
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public /* synthetic */ void onPostExecute(Object obj) {
            a((a<T, D, ActivityType>) ((j) obj));
        }

        public a(NetModel<T, D, ActivityType> netModel) {
            this.eQz = netModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: p */
        public D doInBackground(Object... objArr) {
            ((NetModel) this.eQz).isLoading = true;
            aa aaVar = new aa(TbConfig.SERVER_ADDRESS + this.eQz.Tu());
            for (Map.Entry<String, Object> entry : this.eQz.bEd.btr().entrySet()) {
                aaVar.addPostData(entry.getKey(), String.valueOf(entry.getValue()));
            }
            String postNetData = aaVar.postNetData();
            this.bDX = aaVar.biQ();
            D v = v(this.eQz.getResponseDataClass());
            if (postNetData != null) {
                try {
                    v.initByJson(new JSONObject(postNetData));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(v);
            if (this.eQz.isNeedCache() && this.bDX != null && this.bDX.bjw() != null && this.bDX.bjw().isRequestSuccess() && v != null && (this.eQz.bEd instanceof com.baidu.tbadk.mvc.b.e)) {
                com.baidu.tbadk.mvc.b.e eVar = (com.baidu.tbadk.mvc.b.e) this.eQz.bEd;
                String cacheKey = eVar.getCacheKey();
                String bto = eVar.bto();
                String currentAccount = eVar.isNeedUid() ? TbadkCoreApplication.getCurrentAccount() : null;
                if (cacheKey == null || TextUtils.isEmpty(bto) || v == null) {
                    return v;
                }
                com.baidu.adp.lib.cache.l<String> dw = com.baidu.tbadk.core.c.a.bhb().dw(bto, currentAccount);
                if (dw == null) {
                    return v;
                }
                dw.setForever(cacheKey, postNetData);
            }
            return v;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: a */
        public void onProgressUpdate(D... dArr) {
            super.onProgressUpdate(dArr);
            if (dArr != null && dArr.length > 0) {
                ((NetModel) this.eQz).isLoading = false;
                if (((NetModel) this.eQz).bDR != null) {
                    e.mS().removeCallbacks(((NetModel) this.eQz).bDR);
                }
                MvcHttpMessage<T, D> mvcHttpMessage = new MvcHttpMessage<>(this.eQz.bEd, this.eQz.TB());
                MvcJsonHttpResponsedMessage mvcJsonHttpResponsedMessage = new MvcJsonHttpResponsedMessage(this.eQz.TB());
                mvcJsonHttpResponsedMessage.setData(dArr[0]);
                mvcJsonHttpResponsedMessage.setOrginalMessage(mvcHttpMessage);
                if (this.bDX != null && this.bDX.bjw() != null) {
                    mvcJsonHttpResponsedMessage.setStatusCode(this.bDX.bjw().mNetErrorCode, this.bDX.bjw().mErrorString);
                    mvcJsonHttpResponsedMessage.setError(this.bDX.bjw().mServerErrorCode);
                    mvcJsonHttpResponsedMessage.setErrorString(this.bDX.bjw().mErrorString);
                    if (this.bDX.bjw().mException != null) {
                        BdLog.e(this.bDX.bjw().mException);
                    }
                }
                this.eQz.Tw();
                if (((NetModel) this.eQz).eQu != null) {
                    ((NetModel) this.eQz).eQu.a(mvcJsonHttpResponsedMessage, mvcHttpMessage, null);
                }
            }
        }

        protected void a(D d) {
            super.onPostExecute(d);
        }

        protected D v(Class<D> cls) {
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
