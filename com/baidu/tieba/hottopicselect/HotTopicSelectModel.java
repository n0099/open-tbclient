package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
/* loaded from: classes4.dex */
public class HotTopicSelectModel extends BdBaseModel<HotTopicSelectActivity> {
    public static final int FAIL_LOAD = 3;
    public static final int NORMAL_LOAD = 2;
    public static final int NO_LOADED_DATA = 1;
    public static final String TOPIC_SELECT_KEY = "topic_select_user";

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<HotTopicSelectActivity> f17029e;

    /* renamed from: f  reason: collision with root package name */
    public final c f17030f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17031g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17032h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f17033i;
    public CustomMessageListener j;
    public String k;
    public long l;
    public String m;
    public String n;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof HotSelectCacheResponseMessage)) {
                HotSelectCacheResponseMessage hotSelectCacheResponseMessage = (HotSelectCacheResponseMessage) customResponsedMessage;
                int resultStatus = hotSelectCacheResponseMessage.getResultStatus();
                if (resultStatus == 1) {
                    HotTopicSelectModel hotTopicSelectModel = HotTopicSelectModel.this;
                    hotTopicSelectModel.A(hotTopicSelectModel.f17031g, customResponsedMessage);
                    return;
                } else if (resultStatus == 2) {
                    HotTopicSelectModel.this.f17030f.onHotSelectDataNoSearchSuccess(hotSelectCacheResponseMessage.mUserData, hotSelectCacheResponseMessage.mBangData);
                    return;
                } else if (resultStatus != 3) {
                    return;
                } else {
                    HotTopicSelectModel hotTopicSelectModel2 = HotTopicSelectModel.this;
                    hotTopicSelectModel2.A(hotTopicSelectModel2.f17031g, customResponsedMessage);
                    return;
                }
            }
            HotTopicSelectModel hotTopicSelectModel3 = HotTopicSelectModel.this;
            hotTopicSelectModel3.A(hotTopicSelectModel3.f17031g, customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HotTopicSelectModel.this.f17032h = false;
            boolean z = responsedMessage instanceof HotSelectSocketResponseMessage;
            if (!z && !(responsedMessage instanceof HotSelectHttpResponseMessage)) {
                HotTopicSelectModel hotTopicSelectModel = HotTopicSelectModel.this;
                hotTopicSelectModel.A(hotTopicSelectModel.f17031g, responsedMessage);
            } else if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof HotTopicSelectNetMessage)) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof HotSelectHttpResponseMessage) {
                        HotSelectHttpResponseMessage hotSelectHttpResponseMessage = (HotSelectHttpResponseMessage) responsedMessage;
                        if (HotTopicSelectModel.this.f17031g) {
                            HotTopicSelectModel.this.f17030f.onHotSelectDataSearchSuccess(hotSelectHttpResponseMessage.getSugTopic());
                            return;
                        } else {
                            HotTopicSelectModel.this.f17030f.onHotSelectDataNoSearchSuccess(hotSelectHttpResponseMessage.getUserHisTopic(), hotSelectHttpResponseMessage.getBangTopic());
                            return;
                        }
                    } else if (z) {
                        HotSelectSocketResponseMessage hotSelectSocketResponseMessage = (HotSelectSocketResponseMessage) responsedMessage;
                        if (HotTopicSelectModel.this.f17031g) {
                            HotTopicSelectModel.this.f17030f.onHotSelectDataSearchSuccess(hotSelectSocketResponseMessage.getSugTopic());
                            return;
                        } else {
                            HotTopicSelectModel.this.f17030f.onHotSelectDataNoSearchSuccess(hotSelectSocketResponseMessage.getUserHisTopic(), hotSelectSocketResponseMessage.getBangTopic());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                HotTopicSelectModel hotTopicSelectModel2 = HotTopicSelectModel.this;
                hotTopicSelectModel2.A(hotTopicSelectModel2.f17031g, responsedMessage);
            } else {
                HotTopicSelectModel hotTopicSelectModel3 = HotTopicSelectModel.this;
                hotTopicSelectModel3.A(hotTopicSelectModel3.f17031g, responsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onHotSelectDataNoSearchFailed(String str);

        void onHotSelectDataNoSearchSuccess(d.a.k0.d1.c cVar, d.a.k0.d1.c cVar2);

        void onHotSelectDataSearchFailed(String str);

        void onHotSelectDataSearchSuccess(d.a.k0.d1.c cVar);
    }

    public HotTopicSelectModel(TbPageContext tbPageContext, c cVar) {
        super(tbPageContext);
        this.f17031g = false;
        this.f17032h = false;
        this.l = 0L;
        this.m = "";
        this.n = "";
        w(cVar, "HotSelectCallBack is NullPointerException");
        w(tbPageContext, "HotTopicSelectActivity is  NullPointerException");
        this.f17029e = tbPageContext;
        this.f17030f = cVar;
    }

    public final void A(boolean z, ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null || TextUtils.isEmpty(responsedMessage.getErrorString())) {
            if (z) {
                this.f17030f.onHotSelectDataSearchFailed("");
            } else {
                this.f17030f.onHotSelectDataNoSearchFailed(this.f17029e.getString(R.string.neterror));
            }
        } else if (z) {
            this.f17030f.onHotSelectDataSearchFailed("");
        } else {
            this.f17030f.onHotSelectDataNoSearchFailed(responsedMessage.getErrorString());
        }
    }

    public void B(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.getIntExtra("from", HotSelectActivityConfig.FROM_PB);
        this.l = intent.getLongExtra("forum_id", 0L);
        this.m = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
        this.n = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
    }

    public final void C() {
        this.j = new a(2016491);
        d.a.k0.d3.d0.a.b(2016491, d.a.k0.d1.a.class);
        registerListener(this.j);
    }

    public final void D() {
        this.f17033i = new b(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, 309416);
        d.a.k0.d3.d0.a.h(309416, HotSelectSocketResponseMessage.class, false, false);
        d.a.k0.d3.d0.a.c(309416, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, TbConfig.SET_HOTSELECT, HotSelectHttpResponseMessage.class, true, true, true, true);
        registerListener(this.f17033i);
    }

    public void E() {
        D();
        C();
    }

    public void F() {
        this.k = "";
        this.f17031g = false;
        if (!j.z()) {
            x();
        } else if (this.f17032h) {
        } else {
            this.f17032h = true;
            sendMessage(z());
        }
    }

    public void G(String str) {
        this.k = str;
        this.f17031g = true;
        if (!j.z()) {
            this.f17030f.onHotSelectDataSearchFailed("");
        } else if (this.f17032h) {
        } else {
            this.f17032h = true;
            HotTopicSelectNetMessage z = z();
            z.setPrefix(str);
            sendMessage(z);
        }
    }

    public void H(String str) {
        this.k = str;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.f17033i);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterTask(309416);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT);
        MessageManager.getInstance().unRegisterTask(2016491);
    }

    public final void w(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public void x() {
        sendMessage(new HotSelectCacheReqMessage());
    }

    public String y() {
        return this.k;
    }

    public final HotTopicSelectNetMessage z() {
        HotTopicSelectNetMessage hotTopicSelectNetMessage = new HotTopicSelectNetMessage();
        hotTopicSelectNetMessage.setFid(this.l);
        hotTopicSelectNetMessage.setFirstDir(this.m);
        hotTopicSelectNetMessage.setSecondDir(this.n);
        return hotTopicSelectNetMessage;
    }
}
