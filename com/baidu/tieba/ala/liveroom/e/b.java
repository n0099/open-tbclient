package com.baidu.tieba.ala.liveroom.e;

import android.graphics.Color;
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
import com.baidu.live.data.ai;
import com.baidu.live.data.az;
import com.baidu.live.data.l;
import com.baidu.live.data.y;
import com.baidu.live.gift.p;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.im.message.c;
import com.baidu.live.im.view.ImBarrageTrackListView;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.r.a;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements j {
    private l aiW;
    private com.baidu.live.gift.c.a alR;
    private j.a ePH;
    private boolean ePI;
    private String ePJ;
    private CustomMessageListener ePL;
    private HttpMessageListener ePM;
    private CustomMessageListener ePN;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> ePO;
    private boolean ePP = false;
    private ImBarrageTrackListView ePR;
    private List<com.baidu.live.im.data.a> mMessages;
    private String mOtherParams;
    private TbPageContext mPageContext;

    public b(TbPageContext tbPageContext) {
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
        this.ePR.setCanAddNext();
        this.ePR.we();
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
        return this.ePR;
    }

    @Override // com.baidu.live.im.j
    public void uU() {
        if (this.ePR != null) {
            this.ePR.uU();
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
        if (this.ePR != null) {
            this.ePR.release();
            if (this.ePR.getParent() != null) {
                ((ViewGroup) this.ePR.getParent()).removeView(this.ePR);
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
        this.ePR = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.tieba.ala.liveroom.e.b.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void d(com.baidu.live.data.a aVar) {
                b.this.f(aVar);
            }

            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.ePR.a(landscapeImBarrageTrackView);
                b.this.bii();
            }
        });
    }

    private void initListener() {
        bib();
        bid();
    }

    private void bhZ() {
        if (this.ePO == null) {
            this.ePO = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.e.b.2
                @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
                public CustomResponsedMessage<?> run(CustomMessage<ImSendMsgData> customMessage) {
                    if (customMessage != null && customMessage.getData() != null) {
                        b.this.b(customMessage.getData());
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
        this.ePL = new CustomMessageListener(2913102) { // from class: com.baidu.tieba.ala.liveroom.e.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.B((List) customResponsedMessage.getData());
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
        this.ePM = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.liveroom.e.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
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
        big();
        if (this.ePN == null) {
            this.ePN = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.e.b.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2) {
                        Object data = customResponsedMessage.getData();
                        if (data instanceof com.baidu.live.im.data.a) {
                            b.this.n((com.baidu.live.im.data.a) data);
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
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                bih();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
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
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
        if ("zan_rmb".equals(r0) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(com.baidu.live.im.data.a aVar) {
        boolean z;
        boolean z2 = true;
        int i = 0;
        boolean s = s(aVar);
        if (!s) {
            String content = aVar.getContent();
            if (!TextUtils.isEmpty(content)) {
                try {
                    String optString = new JSONObject(content).optString("content_type");
                    if (!"follow_anchor".equals(optString) && !"guard_club_join".equals(optString)) {
                    }
                    z = true;
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (!z && !s) {
                    z2 = false;
                }
                if (aVar.vt() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean p = p(aVar);
                    if (p || this.mMessages.size() <= com.baidu.live.s.a.wR().asq.YT) {
                        if (p && !this.mMessages.isEmpty()) {
                            while (i < this.mMessages.size()) {
                                if (!p(this.mMessages.get(i))) {
                                    break;
                                }
                                i++;
                            }
                        }
                        i = -1;
                        if (i >= 0) {
                            this.mMessages.add(i, aVar);
                        } else {
                            this.mMessages.add(aVar);
                        }
                        bii();
                        return;
                    }
                    return;
                }
            }
        }
        z = false;
        if (!z) {
            z2 = false;
        }
        if (aVar.vt()) {
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
        az azVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.ePR.wf()) {
            az[] uX = k.uW().uX();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.vq() == null) {
                bii();
                return;
            }
            if (remove.getMsgType() != 126) {
                azVar = null;
            } else if (uX != null) {
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
            } else {
                return;
            }
            if (this.ePR.a(azVar, azVar == null ? C(remove.vx()) : null, remove.vq(), q(remove), this.ePJ, r(remove))) {
                bii();
            }
        }
    }

    private String q(com.baidu.live.im.data.a aVar) {
        String str = "";
        if (aVar == null) {
            return "";
        }
        if (s(aVar)) {
            return aVar.getContent();
        }
        if (!TextUtils.isEmpty(aVar.getContent())) {
            try {
                String optString = new JSONObject(aVar.getContent()).optString("content_type");
                if ("follow_anchor".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.i.ala_follow_live);
                } else if ("guard_club_join".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.i.ala_guard_club_join);
                } else if ("zan_rmb".equals(optString)) {
                    str = this.mPageContext.getPageActivity().getString(a.i.ala_zan_rmb);
                }
                return str;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    private int r(com.baidu.live.im.data.a aVar) {
        String content;
        if (aVar == null || s(aVar) || (content = aVar.getContent()) == null) {
            return 0;
        }
        try {
            String optString = new JSONObject(content).optString("content_type");
            if ("follow_anchor".equals(optString)) {
                return 2;
            }
            if ("guard_club_join".equals(optString)) {
                return 3;
            }
            if (!"zan_rmb".equals(optString)) {
                return 0;
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private boolean s(com.baidu.live.im.data.a aVar) {
        if (aVar == null) {
            return false;
        }
        int msgType = aVar.getMsgType();
        return msgType == 126 || msgType == 1;
    }

    private y C(String[] strArr) {
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        int i = 255;
        boolean z = false;
        if (strArr == null || strArr.length <= 1 || com.baidu.live.s.a.wR().atk == null) {
            return null;
        }
        y yVar = new y();
        ai aiVar = com.baidu.live.s.a.wR().atk.aaW;
        if (aiVar != null && aiVar.aax != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = aiVar.aax.optJSONObject(strArr[0])) != null) {
            int optInt = optJSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                yVar.Zx = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                yVar.Zx = 255;
            }
            yVar.Zy = optJSONObject2.optString("tail_icon");
            String optString2 = optJSONObject2.optString("start_color");
            String optString3 = optJSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    yVar.Zt = Color.parseColor(optString2);
                    yVar.Zu = Color.parseColor(optString3);
                    z = true;
                } else {
                    String optString4 = optJSONObject2.optString("bg_color");
                    if (!TextUtils.isEmpty(optString4)) {
                        yVar.Zt = Color.parseColor(optString4);
                        yVar.Zu = yVar.Zt;
                        z = true;
                    }
                }
                if (z) {
                    String optString5 = optJSONObject2.optString("frame_start_color");
                    String optString6 = optJSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                        yVar.Zv = Color.parseColor(optString5);
                        yVar.Zw = Color.parseColor(optString6);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (aiVar != null && aiVar.aay != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = aiVar.aay.optJSONObject(strArr[1])) != null) {
            String optString7 = optJSONObject.optString("bg_color");
            if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                try {
                    i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                } catch (Exception e2) {
                }
            }
            if (!TextUtils.isEmpty(optString7)) {
                yVar.Zz = Color.parseColor(optString7);
                yVar.ZA = i;
            }
        }
        return yVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aiW != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Vz, aVar.VA, aVar.VB, String.valueOf(this.aiW.mLiveInfo.group_id), String.valueOf(this.aiW.mLiveInfo.live_id), this.ePI, String.valueOf(this.aiW.Wf.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
