package com.baidu.tieba.ala.liveroom.e;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.az;
import com.baidu.live.data.l;
import com.baidu.live.gift.p;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.im.message.c;
import com.baidu.live.im.view.ImBarrageTrackView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements j {
    private l aiW;
    private com.baidu.live.gift.c.a alR;
    private j.a ePH;
    private boolean ePI;
    private String ePJ;
    private ImBarrageTrackView ePK;
    private CustomMessageListener ePL;
    private HttpMessageListener ePM;
    private CustomMessageListener ePN;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> ePO;
    private boolean ePP = false;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public a(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        initView();
        initListener();
    }

    @Override // com.baidu.live.im.j
    public void a(j.a aVar) {
        this.ePH = aVar;
    }

    @Override // com.baidu.live.im.j
    public void a(l lVar, boolean z) {
        if (z) {
            if (!this.ePP) {
                this.ePP = true;
            } else {
                return;
            }
        }
        this.ePK.setCanAddNext();
        uU();
        a(lVar);
        bhZ();
        bif();
    }

    @Override // com.baidu.live.im.j
    public void a(l lVar) {
        boolean z = false;
        this.aiW = lVar;
        this.ePI = false;
        if (this.aiW != null && this.aiW.mLiveInfo != null) {
            this.ePJ = String.valueOf(this.aiW.Wf.userId);
            String valueOf = String.valueOf(this.aiW.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.ePI = z;
        }
    }

    @Override // com.baidu.live.im.j
    public View uT() {
        return this.ePK;
    }

    @Override // com.baidu.live.im.j
    public void uU() {
        if (this.ePK != null) {
            this.ePK.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.e.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.ePK.setVisibility(a.this.ePK.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.j
    public void us() {
        bia();
        big();
        this.aiW = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.ePK != null) {
            this.ePK.release();
            if (this.ePK.getParent() != null) {
                ((ViewGroup) this.ePK.getParent()).removeView(this.ePK);
            }
        }
        this.ePP = false;
    }

    @Override // com.baidu.live.im.j
    public void release() {
        us();
        bic();
        bie();
        k.uW().release();
    }

    @Override // com.baidu.live.im.j
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.ePK = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.ePK.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.tieba.ala.liveroom.e.a.2
            @Override // com.baidu.live.im.view.ImBarrageTrackView.a
            public void d(com.baidu.live.data.a aVar) {
                a.this.f(aVar);
            }

            @Override // com.baidu.live.im.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.bii();
            }
        });
    }

    private void initListener() {
        bib();
        bid();
    }

    private void bhZ() {
        if (this.ePO == null) {
            this.ePO = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.e.a.3
                @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                    if (customMessage != null && customMessage.getData() != null) {
                        a.this.b(customMessage.getData());
                        return null;
                    }
                    return null;
                }
            };
        }
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.ePO);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void bia() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void bib() {
        this.ePL = new CustomMessageListener(2913102) { // from class: com.baidu.tieba.ala.liveroom.e.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.B((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ePL);
    }

    private void bic() {
        if (this.ePL != null) {
            MessageManager.getInstance().unRegisterListener(this.ePL);
        }
    }

    private void bid() {
        this.ePM = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.liveroom.e.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ePM);
    }

    private void bie() {
        if (this.ePM != null) {
            MessageManager.getInstance().unRegisterListener(this.ePM);
        }
    }

    private void bif() {
        if (this.ePN == null) {
            this.ePN = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.e.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            a.this.n((com.baidu.live.im.data.a) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.ePN);
    }

    private void big() {
        if (this.ePN != null) {
            MessageManager.getInstance().unRegisterListener(this.ePN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 || imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.aqh) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    bih();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void bih() {
        if (this.ePH != null) {
            this.ePH.uV();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(List list) {
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof com.baidu.live.im.data.a) {
                    com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) obj;
                    if (p(aVar) && o(aVar)) {
                        m(aVar);
                    }
                }
            }
        }
    }

    private void m(com.baidu.live.im.data.a aVar) {
        if (aVar.vu() == 1) {
            com.baidu.live.im.data.b vw = aVar.vw();
            if (vw != null && vw.aqh) {
                a(aVar.vv(), vw);
            } else {
                e(aVar.getMsgId(), aVar.vv());
            }
        }
    }

    private void e(long j, String str) {
        String yN = q.yN();
        c cVar = new c();
        cVar.addParam("scene_from", yN);
        cVar.addParam("live_id", this.aiW.mLiveInfo.live_id);
        cVar.addParam("im_id", j);
        cVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(cVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        p pVar;
        Map<String, p> rx2 = com.baidu.live.gift.q.rw().rx();
        if (rx2 != null && rx2.containsKey(str) && (pVar = rx2.get(str)) != null) {
            if (this.alR == null) {
                this.alR = new com.baidu.live.gift.c.a();
            }
            this.alR.a(pVar.itemId, pVar.aem, bVar.aqi, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.ts();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.j.c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.baidu.live.im.data.a aVar) {
        int i;
        if (aVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean p = p(aVar);
            if (p || this.mMessages.size() < com.baidu.live.s.a.wR().asq.YU) {
                if (p && !this.mMessages.isEmpty()) {
                    int i2 = 0;
                    while (true) {
                        i = i2;
                        if (i >= this.mMessages.size()) {
                            break;
                        } else if (!p(this.mMessages.get(i))) {
                            break;
                        } else {
                            i2 = i + 1;
                        }
                    }
                }
                i = -1;
                if (i >= 0) {
                    this.mMessages.add(i, aVar);
                } else {
                    this.mMessages.add(aVar);
                }
                bii();
            }
        }
    }

    private boolean o(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean p(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bii() {
        az[] uX;
        az azVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.ePK.wf() && (uX = k.uW().uX()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = uX.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    azVar = null;
                    break;
                }
                azVar = uX[i];
                if (azVar.id.equals(remove.vv())) {
                    break;
                }
                i++;
            }
            if (azVar == null) {
                azVar = new az().qa();
            }
            this.ePK.a(azVar, remove.vq(), remove.getContent(), this.ePJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aiW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Vz, aVar.VA, aVar.VB, String.valueOf(this.aiW.mLiveInfo.group_id), String.valueOf(this.aiW.mLiveInfo.live_id), this.ePI, String.valueOf(this.aiW.Wf.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
