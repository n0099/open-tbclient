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
import com.baidu.live.data.av;
import com.baidu.live.data.k;
import com.baidu.live.gift.q;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.im.message.c;
import com.baidu.live.im.view.ImBarrageTrackView;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.atomdata.BuyTBeanActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.utils.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class a implements j {
    private k aio;
    private com.baidu.live.gift.c.a ald;
    private j.a eOf;
    private boolean eOg;
    private String eOh;
    private ImBarrageTrackView eOi;
    private CustomMessageListener eOj;
    private HttpMessageListener eOk;
    private CustomMessageListener eOl;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> eOm;
    private boolean eOn = false;
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
        this.eOf = aVar;
    }

    @Override // com.baidu.live.im.j
    public void a(k kVar, boolean z) {
        if (z) {
            if (!this.eOn) {
                this.eOn = true;
            } else {
                return;
            }
        }
        this.eOi.setCanAddNext();
        uD();
        a(kVar);
        bhm();
        bhs();
    }

    @Override // com.baidu.live.im.j
    public void a(k kVar) {
        boolean z = false;
        this.aio = kVar;
        this.eOg = false;
        if (this.aio != null && this.aio.mLiveInfo != null) {
            this.eOh = String.valueOf(this.aio.VP.userId);
            String valueOf = String.valueOf(this.aio.mLiveInfo.user_id);
            if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(valueOf)) {
                z = true;
            }
            this.eOg = z;
        }
    }

    @Override // com.baidu.live.im.j
    public View uC() {
        return this.eOi;
    }

    @Override // com.baidu.live.im.j
    public void uD() {
        if (this.eOi != null) {
            this.eOi.post(new Runnable() { // from class: com.baidu.tieba.ala.liveroom.d.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.eOi.setVisibility(a.this.eOi.getTop() > 0 ? 0 : 4);
                }
            });
        }
    }

    @Override // com.baidu.live.im.j
    public void ub() {
        bhn();
        bht();
        this.aio = null;
        if (this.mMessages != null) {
            this.mMessages.clear();
        }
        if (this.eOi != null) {
            this.eOi.release();
            if (this.eOi.getParent() != null) {
                ((ViewGroup) this.eOi.getParent()).removeView(this.eOi);
            }
        }
        this.eOn = false;
    }

    @Override // com.baidu.live.im.j
    public void release() {
        ub();
        bhp();
        bhr();
        com.baidu.live.im.k.uF().release();
    }

    @Override // com.baidu.live.im.j
    public void setOtherParams(String str) {
        this.mOtherParams = str;
    }

    private void initView() {
        this.eOi = new ImBarrageTrackView(this.mPageContext.getPageActivity());
        this.eOi.setCallback(new ImBarrageTrackView.a() { // from class: com.baidu.tieba.ala.liveroom.d.a.2
            @Override // com.baidu.live.im.view.ImBarrageTrackView.a
            public void d(com.baidu.live.data.a aVar) {
                a.this.f(aVar);
            }

            @Override // com.baidu.live.im.view.ImBarrageTrackView.a
            public void onNext() {
                a.this.bhv();
            }
        });
    }

    private void initListener() {
        bho();
        bhq();
    }

    private void bhm() {
        if (this.eOm == null) {
            this.eOm = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.d.a.3
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.eOm);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void bhn() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void bho() {
        this.eOj = new CustomMessageListener(2913102) { // from class: com.baidu.tieba.ala.liveroom.d.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(a.this.mPageContext.getPageActivity()) != 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    a.this.C((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eOj);
    }

    private void bhp() {
        if (this.eOj != null) {
            MessageManager.getInstance().unRegisterListener(this.eOj);
        }
    }

    private void bhq() {
        this.eOk = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.liveroom.d.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    a.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eOk);
    }

    private void bhr() {
        if (this.eOk != null) {
            MessageManager.getInstance().unRegisterListener(this.eOk);
        }
    }

    private void bhs() {
        if (this.eOl == null) {
            this.eOl = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.a.6
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
        MessageManager.getInstance().registerListener(this.eOl);
    }

    private void bht() {
        if (this.eOl != null) {
            MessageManager.getInstance().unRegisterListener(this.eOl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ImSendMsgData imSendMsgData) {
        if (imSendMsgData.msgType == 126) {
            if (imSendMsgData.barrageType == 1 || imSendMsgData.barrageCardInfo == null || !imSendMsgData.barrageCardInfo.apv) {
                long j = imSendMsgData.price;
                if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                    bhu();
                    return;
                } else {
                    TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
                }
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2913043, imSendMsgData));
        }
    }

    private void bhu() {
        if (this.eOf != null) {
            this.eOf.uE();
        }
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new BuyTBeanActivityConfig(this.mPageContext.getPageActivity(), 0L, this.mOtherParams, true, "", true)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(List list) {
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
        if (aVar.vd() == 1) {
            com.baidu.live.im.data.b vf = aVar.vf();
            if (vf != null && vf.apv) {
                a(aVar.ve(), vf);
            } else {
                e(aVar.getMsgId(), aVar.ve());
            }
        }
    }

    private void e(long j, String str) {
        String yu = p.yu();
        c cVar = new c();
        cVar.addParam("scene_from", yu);
        cVar.addParam("live_id", this.aio.mLiveInfo.live_id);
        cVar.addParam("im_id", j);
        cVar.addParam("barrage_id", str);
        MessageManager.getInstance().sendMessage(cVar);
    }

    private void a(String str, com.baidu.live.im.data.b bVar) {
        com.baidu.live.gift.p pVar;
        Map<String, com.baidu.live.gift.p> rl = q.rk().rl();
        if (rl != null && rl.containsKey(str) && (pVar = rl.get(str)) != null) {
            if (this.ald == null) {
                this.ald = new com.baidu.live.gift.c.a();
            }
            this.ald.a(pVar.itemId, pVar.adX, bVar.apw, bVar.liveId, 1, 0, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ImBarragePayResponseMessage imBarragePayResponseMessage) {
        if (imBarragePayResponseMessage.getError() == 0) {
            TbadkCoreApplication.getInst().currentAccountTdouNum = imBarragePayResponseMessage.tb();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(AlaCmdConfigCustom.CMD_ALA_UPDATE_GIFT_PANEL_SCORE_DATA));
            return;
        }
        if (!TextUtils.isEmpty(imBarragePayResponseMessage.getErrorString())) {
            BdUtilHelper.showToast(TbadkCoreApplication.getInst().getContext(), imBarragePayResponseMessage.getErrorString());
        }
        new com.baidu.live.i.c().refreshCurUserScores();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(com.baidu.live.im.data.a aVar) {
        int i;
        if (aVar.getMsgType() == 126) {
            if (this.mMessages == null) {
                this.mMessages = new ArrayList();
            }
            boolean p = p(aVar);
            if (p || this.mMessages.size() < com.baidu.live.r.a.wA().arE.YI) {
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
                bhv();
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
    public void bhv() {
        av[] uG;
        av avVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.eOi.vO() && (uG = com.baidu.live.im.k.uF().uG()) != null) {
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            int length = uG.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    avVar = null;
                    break;
                }
                avVar = uG[i];
                if (avVar.id.equals(remove.ve())) {
                    break;
                }
                i++;
            }
            if (avVar == null) {
                avVar = new av().pU();
            }
            this.eOi.a(avVar, remove.uZ(), remove.getContent(), this.eOh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aio != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Vj, aVar.Vk, aVar.Vl, String.valueOf(this.aio.mLiveInfo.group_id), String.valueOf(this.aio.mLiveInfo.live_id), this.eOg, String.valueOf(this.aio.VP.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
