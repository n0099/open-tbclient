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
    private i aaj;
    private com.baidu.live.gift.c.a adg;
    private j.a dYi;
    private boolean dYj;
    private String dYk;
    private ImBarrageTrackView dYl;
    private CustomMessageListener dYm;
    private HttpMessageListener dYn;
    private CustomMessageListener dYo;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> dYp;
    private boolean dYq = false;
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
        this.dYi = aVar;
    }

    @Override // com.baidu.live.im.j
    public void a(i iVar, boolean z) {
        if (z) {
            if (!this.dYq) {
                this.dYq = true;
            } else {
                return;
            }
        }
        this.dYl.setCanAddNext();
        sL();
        b(iVar);
        aPJ();
        aPP();
    }

    @Override // com.baidu.live.im.j
    public void b(i iVar) {
        boolean z = false;
        this.aaj = iVar;
        this.dYj = false;
        if (this.aaj != null && this.aaj.mLiveInfo != null) {
            this.dYk = String.valueOf(this.aaj.OR.userId);
            String valueOf = String.valueOf(this.aaj.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.dYj = z;
        }
    }

    @Override // com.baidu.live.im.j
    public View sK() {
        return this.dYl;
    }

    @Override // com.baidu.live.im.j
    public void sL() {
        if (this.dYl != null) {
            this.dYl.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.dYl.setVisibility(a.this.dYl.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.j
    public void sk() {
        aPK();
        aPQ();
        this.aaj = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.dYl != null) {
            this.dYl.release();
            if (this.dYl.getParent() != null) {
                ((ViewGroup) this.dYl.getParent()).removeView(this.dYl);
            }
        }
        this.dYq = false;
    }

    @Override // com.baidu.live.im.j
    public void release() {
        sk();
        aPM();
        aPO();
        k.sN().release();
    }

    @Override // com.baidu.live.im.j
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.dYl = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.dYl.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
            @Override // com.baidu.live.im.view.ImBarrageTrackView.a
            public void d(com.baidu.live.data.a aVar) {
                a.this.f(aVar);
            }

            @Override // com.baidu.live.im.view.ImBarrageTrackView.a
            public void tU() {
                a.this.aPS();
            }
        });
    }

    private void initListener() {
        aPL();
        aPN();
    }

    private void aPJ() {
        if (this.dYp == null) {
            this.dYp = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.d.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.dYp);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void aPK() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void aPL() {
        this.dYm = new CustomMessageListener(2913102) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.E((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dYm);
    }

    private void aPM() {
        if (this.dYm != null) {
            MessageManager.getInstance().unRegisterListener(this.dYm);
        }
    }

    private void aPN() {
        this.dYn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dYn);
    }

    private void aPO() {
        if (this.dYn != null) {
            MessageManager.getInstance().unRegisterListener(this.dYn);
        }
    }

    private void aPP() {
        if (this.dYo == null) {
            this.dYo = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
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
        MessageManager.getInstance().registerListener(this.dYo);
    }

    private void aPQ() {
        if (this.dYo != null) {
            MessageManager.getInstance().unRegisterListener(this.dYo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.ahr) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    aPR();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void aPR() {
        if (this.dYi != null) {
            this.dYi.sM();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(List list) {
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
        com.baidu.live.im.data.b tk = aVar.tk();
        if (tk != null && tk.ahr) {
            a(aVar.tj(), tk);
        } else {
            d(aVar.getMsgId(), aVar.tj());
        }
    }

    private void d(long j, String str) {
        String wu = o.wu();
        c cVar = new c();
        cVar.addParam("scene_from", wu);
        cVar.addParam("live_id", this.aaj.mLiveInfo.live_id);
        cVar.addParam("im_id", j);
        cVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(cVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        n nVar;
        Map<String, n> pJ = com.baidu.live.gift.o.pI().pJ();
        if (pJ != null && pJ.containsKey(str) && (nVar = pJ.get(str)) != null) {
            if (this.adg == null) {
                this.adg = new com.baidu.live.gift.c.a();
            }
            this.adg.a(nVar.itemId, nVar.Wr, bVar.ahs, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.rn();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.e.b().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.baidu.live.im.data.a aVar) {
        int i;
        if (aVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean p = p(aVar);
            if (p || this.mMessages.size() < com.baidu.live.l.a.uB().ajF.RW) {
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
                aPS();
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
    public void aPS() {
        ao[] sO;
        ao aoVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.dYl.tS() && (sO = k.sN().sO()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = sO.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    aoVar = null;
                    break;
                }
                aoVar = sO[i];
                if (aoVar.id.equals(remove.tj())) {
                    break;
                }
                i++;
            }
            if (aoVar == null) {
                aoVar = new ao().oA();
            }
            this.dYl.a(aoVar, remove.tf(), remove.getContent(), this.dYk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aaj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Oj, aVar.Ok, aVar.Ol, String.valueOf(this.aaj.mLiveInfo.group_id), String.valueOf(this.aaj.mLiveInfo.live_id), this.dYj, String.valueOf(this.aaj.OR.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
