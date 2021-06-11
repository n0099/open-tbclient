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
    public TbPageContext<HotTopicSelectActivity> f17015e;

    /* renamed from: f  reason: collision with root package name */
    public final c f17016f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f17017g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f17018h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.c.c.g.a f17019i;
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
                    hotTopicSelectModel.E(hotTopicSelectModel.f17017g, customResponsedMessage);
                    return;
                } else if (resultStatus == 2) {
                    HotTopicSelectModel.this.f17016f.onHotSelectDataNoSearchSuccess(hotSelectCacheResponseMessage.mUserData, hotSelectCacheResponseMessage.mBangData);
                    return;
                } else if (resultStatus != 3) {
                    return;
                } else {
                    HotTopicSelectModel hotTopicSelectModel2 = HotTopicSelectModel.this;
                    hotTopicSelectModel2.E(hotTopicSelectModel2.f17017g, customResponsedMessage);
                    return;
                }
            }
            HotTopicSelectModel hotTopicSelectModel3 = HotTopicSelectModel.this;
            hotTopicSelectModel3.E(hotTopicSelectModel3.f17017g, customResponsedMessage);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            HotTopicSelectModel.this.f17018h = false;
            boolean z = responsedMessage instanceof HotSelectSocketResponseMessage;
            if (!z && !(responsedMessage instanceof HotSelectHttpResponseMessage)) {
                HotTopicSelectModel hotTopicSelectModel = HotTopicSelectModel.this;
                hotTopicSelectModel.E(hotTopicSelectModel.f17017g, responsedMessage);
            } else if (responsedMessage.getOrginalMessage() != null && (responsedMessage.getOrginalMessage().getExtra() instanceof HotTopicSelectNetMessage)) {
                if (!responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    if (responsedMessage instanceof HotSelectHttpResponseMessage) {
                        HotSelectHttpResponseMessage hotSelectHttpResponseMessage = (HotSelectHttpResponseMessage) responsedMessage;
                        if (HotTopicSelectModel.this.f17017g) {
                            HotTopicSelectModel.this.f17016f.onHotSelectDataSearchSuccess(hotSelectHttpResponseMessage.getSugTopic());
                            return;
                        } else {
                            HotTopicSelectModel.this.f17016f.onHotSelectDataNoSearchSuccess(hotSelectHttpResponseMessage.getUserHisTopic(), hotSelectHttpResponseMessage.getBangTopic());
                            return;
                        }
                    } else if (z) {
                        HotSelectSocketResponseMessage hotSelectSocketResponseMessage = (HotSelectSocketResponseMessage) responsedMessage;
                        if (HotTopicSelectModel.this.f17017g) {
                            HotTopicSelectModel.this.f17016f.onHotSelectDataSearchSuccess(hotSelectSocketResponseMessage.getSugTopic());
                            return;
                        } else {
                            HotTopicSelectModel.this.f17016f.onHotSelectDataNoSearchSuccess(hotSelectSocketResponseMessage.getUserHisTopic(), hotSelectSocketResponseMessage.getBangTopic());
                            return;
                        }
                    } else {
                        return;
                    }
                }
                HotTopicSelectModel hotTopicSelectModel2 = HotTopicSelectModel.this;
                hotTopicSelectModel2.E(hotTopicSelectModel2.f17017g, responsedMessage);
            } else {
                HotTopicSelectModel hotTopicSelectModel3 = HotTopicSelectModel.this;
                hotTopicSelectModel3.E(hotTopicSelectModel3.f17017g, responsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void onHotSelectDataNoSearchFailed(String str);

        void onHotSelectDataNoSearchSuccess(d.a.n0.e1.c cVar, d.a.n0.e1.c cVar2);

        void onHotSelectDataSearchFailed(String str);

        void onHotSelectDataSearchSuccess(d.a.n0.e1.c cVar);
    }

    public HotTopicSelectModel(TbPageContext tbPageContext, c cVar) {
        super(tbPageContext);
        this.f17017g = false;
        this.f17018h = false;
        this.l = 0L;
        this.m = "";
        this.n = "";
        A(cVar, "HotSelectCallBack is NullPointerException");
        A(tbPageContext, "HotTopicSelectActivity is  NullPointerException");
        this.f17015e = tbPageContext;
        this.f17016f = cVar;
    }

    public final void A(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public void B() {
        sendMessage(new HotSelectCacheReqMessage());
    }

    public String C() {
        return this.k;
    }

    public final HotTopicSelectNetMessage D() {
        HotTopicSelectNetMessage hotTopicSelectNetMessage = new HotTopicSelectNetMessage();
        hotTopicSelectNetMessage.setFid(this.l);
        hotTopicSelectNetMessage.setFirstDir(this.m);
        hotTopicSelectNetMessage.setSecondDir(this.n);
        return hotTopicSelectNetMessage;
    }

    public final void E(boolean z, ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null || TextUtils.isEmpty(responsedMessage.getErrorString())) {
            if (z) {
                this.f17016f.onHotSelectDataSearchFailed("");
            } else {
                this.f17016f.onHotSelectDataNoSearchFailed(this.f17015e.getString(R.string.neterror));
            }
        } else if (z) {
            this.f17016f.onHotSelectDataSearchFailed("");
        } else {
            this.f17016f.onHotSelectDataNoSearchFailed(responsedMessage.getErrorString());
        }
    }

    public void F(Intent intent) {
        if (intent == null) {
            return;
        }
        intent.getIntExtra("from", HotSelectActivityConfig.FROM_PB);
        this.l = intent.getLongExtra("forum_id", 0L);
        this.m = intent.getStringExtra(IntentConfig.FORUM_FIRST_DIR);
        this.n = intent.getStringExtra(IntentConfig.FORUM_SECOND_DIR);
    }

    public final void G() {
        this.j = new a(2016491);
        d.a.n0.e3.d0.a.b(2016491, d.a.n0.e1.a.class);
        registerListener(this.j);
    }

    public final void H() {
        this.f17019i = new b(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, 309416);
        d.a.n0.e3.d0.a.h(309416, HotSelectSocketResponseMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309416, CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT, TbConfig.SET_HOTSELECT, HotSelectHttpResponseMessage.class, true, true, true, true);
        registerListener(this.f17019i);
    }

    public void I() {
        H();
        G();
    }

    public void J() {
        this.k = "";
        this.f17017g = false;
        if (!j.z()) {
            B();
        } else if (this.f17018h) {
        } else {
            this.f17018h = true;
            sendMessage(D());
        }
    }

    public void K(String str) {
        this.k = str;
        this.f17017g = true;
        if (!j.z()) {
            this.f17016f.onHotSelectDataSearchFailed("");
        } else if (this.f17018h) {
        } else {
            this.f17018h = true;
            HotTopicSelectNetMessage D = D();
            D.setPrefix(str);
            sendMessage(D);
        }
    }

    public void L(String str) {
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
        MessageManager.getInstance().unRegisterListener(this.f17019i);
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterTask(309416);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_HTTP_GET_HOTTOPIC_SELECT);
        MessageManager.getInstance().unRegisterTask(2016491);
    }
}
