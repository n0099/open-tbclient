package com.baidu.tieba.ala.liveroom.d;

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
import com.baidu.live.data.ao;
import com.baidu.live.data.i;
import com.baidu.live.gift.n;
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
import com.baidu.live.utils.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class a implements j {
    private i aaB;
    private com.baidu.live.gift.c.a ady;
    private j.a dYZ;
    private boolean dZa;
    private String dZb;
    private ImBarrageTrackView dZc;
    private CustomMessageListener dZd;
    private HttpMessageListener dZe;
    private CustomMessageListener dZf;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> dZg;
    private boolean dZh = false;
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
        this.dYZ = aVar;
    }

    @Override // com.baidu.live.im.j
    public void a(i iVar, boolean z) {
        if (z) {
            if (!this.dZh) {
                this.dZh = true;
            } else {
                return;
            }
        }
        this.dZc.setCanAddNext();
        sK();
        b(iVar);
        aPL();
        aPR();
    }

    @Override // com.baidu.live.im.j
    public void b(i iVar) {
        boolean z = false;
        this.aaB = iVar;
        this.dZa = false;
        if (this.aaB != null && this.aaB.mLiveInfo != null) {
            this.dZb = String.valueOf(this.aaB.Ps.userId);
            String valueOf = String.valueOf(this.aaB.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.dZa = z;
        }
    }

    @Override // com.baidu.live.im.j
    public View sJ() {
        return this.dZc;
    }

    @Override // com.baidu.live.im.j
    public void sK() {
        if (this.dZc != null) {
            this.dZc.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dZc.setVisibility(a.this.dZc.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.j
    public void sj() {
        aPM();
        aPS();
        this.aaB = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.dZc != null) {
            this.dZc.release();
            if (this.dZc.getParent() != null) {
                ((ViewGroup) this.dZc.getParent()).removeView(this.dZc);
            }
        }
        this.dZh = false;
    }

    @Override // com.baidu.live.im.j
    public void release() {
        sj();
        aPO();
        aPQ();
        k.sM().release();
    }

    @Override // com.baidu.live.im.j
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.dZc = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.dZc.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
            @Override // com.baidu.live.im.view.ImBarrageTrackView.a
            public void d(com.baidu.live.data.a aVar) {
                a.this.f(aVar);
            }

            @Override // com.baidu.live.im.view.ImBarrageTrackView.a
            public void tT() {
                a.this.aPU();
            }
        });
    }

    private void initListener() {
        aPN();
        aPP();
    }

    private void aPL() {
        if (this.dZg == null) {
            this.dZg = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.d.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.dZg);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void aPM() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void aPN() {
        this.dZd = new CustomMessageListener(2913102) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.D((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dZd);
    }

    private void aPO() {
        if (this.dZd != null) {
            MessageManager.getInstance().unRegisterListener(this.dZd);
        }
    }

    private void aPP() {
        this.dZe = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dZe);
    }

    private void aPQ() {
        if (this.dZe != null) {
            MessageManager.getInstance().unRegisterListener(this.dZe);
        }
    }

    private void aPR() {
        if (this.dZf == null) {
            this.dZf = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            a.this.m((com.baidu.live.im.data.a) data);
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.dZf);
    }

    private void aPS() {
        if (this.dZf != null) {
            MessageManager.getInstance().unRegisterListener(this.dZf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.ahJ) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    aPT();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void aPT() {
        if (this.dYZ != null) {
            this.dYZ.sL();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(List list) {
        if (list != null && !list.isEmpty()) {
            for (Object obj : list) {
                if (obj instanceof com.baidu.live.im.data.a) {
                    com.baidu.live.im.data.a aVar = (com.baidu.live.im.data.a) obj;
                    if (o(aVar) && n(aVar)) {
                        l(aVar);
                    }
                }
            }
        }
    }

    private void l(com.baidu.live.im.data.a aVar) {
        com.baidu.live.im.data.b tj = aVar.tj();
        if (tj != null && tj.ahJ) {
            a(aVar.ti(), tj);
        } else {
            d(aVar.getMsgId(), aVar.ti());
        }
    }

    private void d(long j, String str) {
        String wt = o.wt();
        c cVar = new c();
        cVar.addParam("scene_from", wt);
        cVar.addParam("live_id", this.aaB.mLiveInfo.live_id);
        cVar.addParam("im_id", j);
        cVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(cVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        n nVar;
        Map<String, n> pJ = com.baidu.live.gift.o.pI().pJ();
        if (pJ != null && pJ.containsKey(str) && (nVar = pJ.get(str)) != null) {
            if (this.ady == null) {
                this.ady = new com.baidu.live.gift.c.a();
            }
            this.ady.a(nVar.itemId, nVar.WK, bVar.ahK, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.rm();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.e.b().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(com.baidu.live.im.data.a aVar) {
        int i;
        if (aVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            if (o(aVar) && !this.mMessages.isEmpty()) {
                int i2 = 0;
                while (true) {
                    i = i2;
                    if (i >= this.mMessages.size()) {
                        break;
                    } else if (!o(this.mMessages.get(i))) {
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
            aPU();
        }
    }

    private boolean n(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getMsgType() == 126;
    }

    private boolean o(com.baidu.live.im.data.a aVar) {
        return aVar != null && aVar.getUserId() == JavaTypesHelper.toLong(TbadkCoreApplication.getCurrentAccount(), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aPU() {
        ao[] sN;
        ao aoVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.dZc.tR() && (sN = k.sM().sN()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = sN.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    aoVar = null;
                    break;
                }
                aoVar = sN[i];
                if (aoVar.id.equals(remove.ti())) {
                    break;
                }
                i++;
            }
            if (aoVar == null) {
                aoVar = new ao().oA();
            }
            this.dZc.a(aoVar, remove.te(), remove.getContent(), this.dZb);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aaB != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.OJ, aVar.OL, aVar.OM, String.valueOf(this.aaB.mLiveInfo.group_id), String.valueOf(this.aaB.mLiveInfo.live_id), this.dZa, String.valueOf(this.aaB.Ps.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
