package com.baidu.tieba.hottopicselect;

import android.content.Intent;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class HotTopicSelectModel extends BdBaseModel<HotTopicSelectActivity> {
    public static final int FAIL_LOAD = 3;
    public static final int NORMAL_LOAD = 2;
    public static final int NO_LOADED_DATA = 1;
    public static final String TOPIC_SELECT_KEY = "topic_select_user";
    private CustomMessageListener gaW;
    private String iYq;
    private final a krg;
    private boolean krh;
    private boolean kri;
    private com.baidu.adp.framework.listener.a krj;
    private String mFirstDir;
    private long mForumId;
    private int mFrom;
    private TbPageContext<HotTopicSelectActivity> mPageContext;
    private String mSecondDir;

    /* loaded from: classes7.dex */
    public interface a {
        void Ly(String str);

        void Lz(String str);

        void a(c cVar);

        void a(c cVar, c cVar2);
    }

    public HotTopicSelectModel(TbPageContext tbPageContext, a aVar) {
        super(tbPageContext);
        this.krh = false;
        this.kri = false;
        this.mForumId = 0L;
        this.mFirstDir = "";
        this.mSecondDir = "";
        checkNotNull(aVar, "HotSelectCallBack is NullPointerException");
        checkNotNull(tbPageContext, "HotTopicSelectActivity is  NullPointerException");
        this.mPageContext = tbPageContext;
        this.krg = aVar;
    }

    private void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public void W(Intent intent) {
        if (intent != null) {
            this.mFrom = intent.getIntExtra("from", HotSelectActivityConfig.FROM_PB);
            this.mForumId = intent.getLongExtra("forum_id", 0L);
            this.mFirstDir = intent.getStringExtra("forum_first_dir");
            this.mSecondDir = intent.getStringExtra("forum_second_dir");
        }
    }

    public void getCacheData() {
        sendMessage(new HotSelectCacheReqMessage());
    }

    public void LA(String str) {
        this.iYq = str;
        this.krh = true;
        if (!j.isNetWorkAvailable()) {
            this.krg.Lz("");
        } else if (!this.kri) {
            this.kri = true;
            HotTopicSelectNetMessage cSb = cSb();
            cSb.setPrefix(str);
            sendMessage(cSb);
        }
    }

    public void cSa() {
        this.iYq = "";
        this.krh = false;
        if (!j.isNetWorkAvailable()) {
            getCacheData();
        } else if (!this.kri) {
            this.kri = true;
            sendMessage(cSb());
        }
    }

    private HotTopicSelectNetMessage cSb() {
        HotTopicSelectNetMessage hotTopicSelectNetMessage = new HotTopicSelectNetMessage();
        hotTopicSelectNetMessage.setFid(this.mForumId);
        hotTopicSelectNetMessage.setFirstDir(this.mFirstDir);
        hotTopicSelectNetMessage.setSecondDir(this.mSecondDir);
        return hotTopicSelectNetMessage;
    }

    public void LB(String str) {
        this.iYq = str;
    }

    public String czV() {
        return this.iYq;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, ResponsedMessage<?> responsedMessage) {
        if (responsedMessage == null || TextUtils.isEmpty(responsedMessage.getErrorString())) {
            if (z) {
                this.krg.Lz("");
            } else {
                this.krg.Ly(this.mPageContext.getString(R.string.neterror));
            }
        } else if (z) {
            this.krg.Lz("");
        } else {
            this.krg.Ly(responsedMessage.getErrorString());
        }
    }

    private void cSc() {
        this.gaW = new CustomMessageListener(CmdConfigCustom.CMD_HOT_TOPIC_SELECT_CACHE) { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null || !(customResponsedMessage instanceof HotSelectCacheResponseMessage)) {
                    HotTopicSelectModel.this.b(HotTopicSelectModel.this.krh, customResponsedMessage);
                    return;
                }
                HotSelectCacheResponseMessage hotSelectCacheResponseMessage = (HotSelectCacheResponseMessage) customResponsedMessage;
                switch (hotSelectCacheResponseMessage.getResultStatus()) {
                    case 1:
                        HotTopicSelectModel.this.b(HotTopicSelectModel.this.krh, customResponsedMessage);
                        return;
                    case 2:
                        HotTopicSelectModel.this.krg.a(hotSelectCacheResponseMessage.mUserData, hotSelectCacheResponseMessage.mBangData);
                        return;
                    case 3:
                        HotTopicSelectModel.this.b(HotTopicSelectModel.this.krh, customResponsedMessage);
                        return;
                    default:
                        return;
                }
            }
        };
        com.baidu.tieba.tbadkCore.a.a.e(CmdConfigCustom.CMD_HOT_TOPIC_SELECT_CACHE, com.baidu.tieba.hottopicselect.a.class);
        registerListener(this.gaW);
    }

    private void cSd() {
        this.krj = new com.baidu.adp.framework.listener.a(1003186, CmdConfigSocket.CMD_GET_HOTTOPIC_SELECT) { // from class: com.baidu.tieba.hottopicselect.HotTopicSelectModel.2
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                HotTopicSelectModel.this.kri = false;
                if (!(responsedMessage instanceof HotSelectSocketResponseMessage) && !(responsedMessage instanceof HotSelectHttpResponseMessage)) {
                    HotTopicSelectModel.this.b(HotTopicSelectModel.this.krh, responsedMessage);
                } else if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof HotTopicSelectNetMessage)) {
                    HotTopicSelectModel.this.b(HotTopicSelectModel.this.krh, responsedMessage);
                } else if (responsedMessage.hasError() || responsedMessage.getError() != 0) {
                    HotTopicSelectModel.this.b(HotTopicSelectModel.this.krh, responsedMessage);
                } else if (responsedMessage instanceof HotSelectHttpResponseMessage) {
                    HotSelectHttpResponseMessage hotSelectHttpResponseMessage = (HotSelectHttpResponseMessage) responsedMessage;
                    if (HotTopicSelectModel.this.krh) {
                        HotTopicSelectModel.this.krg.a(hotSelectHttpResponseMessage.getSugTopic());
                    } else {
                        HotTopicSelectModel.this.krg.a(hotSelectHttpResponseMessage.getUserHisTopic(), hotSelectHttpResponseMessage.getBangTopic());
                    }
                } else if (responsedMessage instanceof HotSelectSocketResponseMessage) {
                    HotSelectSocketResponseMessage hotSelectSocketResponseMessage = (HotSelectSocketResponseMessage) responsedMessage;
                    if (HotTopicSelectModel.this.krh) {
                        HotTopicSelectModel.this.krg.a(hotSelectSocketResponseMessage.getSugTopic());
                    } else {
                        HotTopicSelectModel.this.krg.a(hotSelectSocketResponseMessage.getUserHisTopic(), hotSelectSocketResponseMessage.getBangTopic());
                    }
                }
            }
        };
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_HOTTOPIC_SELECT, HotSelectSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_HOTTOPIC_SELECT, 1003186, TbConfig.SET_HOTSELECT, HotSelectHttpResponseMessage.class, true, true, true, true);
        registerListener(this.krj);
    }

    public void cSe() {
        cSd();
        cSc();
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.krj);
        MessageManager.getInstance().unRegisterListener(this.gaW);
        MessageManager.getInstance().unRegisterTask(CmdConfigSocket.CMD_GET_HOTTOPIC_SELECT);
        MessageManager.getInstance().unRegisterTask(1003186);
        MessageManager.getInstance().unRegisterTask(CmdConfigCustom.CMD_HOT_TOPIC_SELECT_CACHE);
    }
}
