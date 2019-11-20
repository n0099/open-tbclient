package com.baidu.tieba.ala.liveroom.d;

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
import com.baidu.live.data.ab;
import com.baidu.live.data.ao;
import com.baidu.live.data.i;
import com.baidu.live.data.u;
import com.baidu.live.gift.n;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.k;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.im.message.c;
import com.baidu.live.im.view.ImBarrageTrackListView;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.k.a;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b implements j {
    private i aaj;
    private com.baidu.live.gift.c.a adg;
    private j.a dYi;
    private boolean dYj;
    private String dYk;
    private CustomMessageListener dYm;
    private HttpMessageListener dYn;
    private CustomMessageListener dYo;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> dYp;
    private boolean dYq = false;
    private ImBarrageTrackListView dYs;
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
        this.dYs.setCanAddNext();
        this.dYs.tR();
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
        return this.dYs;
    }

    @Override // com.baidu.live.im.j
    public void sL() {
        if (this.dYs != null) {
            this.dYs.sL();
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
        if (this.dYs != null) {
            this.dYs.release();
            if (this.dYs.getParent() != null) {
                ((ViewGroup) this.dYs.getParent()).removeView(this.dYs);
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
        this.dYs = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void d(com.baidu.live.data.a aVar) {
                b.this.f(aVar);
            }

            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.dYs.a(landscapeImBarrageTrackView);
                b.this.aPS();
            }
        });
    }

    private void initListener() {
        aPL();
        aPN();
    }

    private void aPJ() {
        if (this.dYp == null) {
            this.dYp = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.d.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.dYp);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void aPK() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void aPL() {
        this.dYm = new CustomMessageListener(2913102) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.E((List) customResponsedMessage.getData());
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
        this.dYn = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
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
        aPQ();
        if (this.dYo == null) {
            this.dYo = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.5
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
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                aPR();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
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
                if (aVar.ti() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean p = p(aVar);
                    if (p || this.mMessages.size() <= com.baidu.live.l.a.uB().ajF.RV) {
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
                        aPS();
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
        if (aVar.ti()) {
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
        ao aoVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.dYs.tS()) {
            ao[] sO = k.sN().sO();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.tf() == null) {
                aPS();
                return;
            }
            if (remove.getMsgType() != 126) {
                aoVar = null;
            } else if (sO != null) {
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
            } else {
                return;
            }
            if (this.dYs.a(aoVar, aoVar == null ? t(remove.tl()) : null, remove.tf(), q(remove), this.dYk, r(remove))) {
                aPS();
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

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private u t(String[] strArr) {
        int i;
        int i2;
        JSONObject optJSONObject;
        String optString;
        String optString2;
        JSONObject optJSONObject2;
        String optString3;
        int i3;
        int i4 = 255;
        int i5 = -1;
        if (strArr == null || strArr.length <= 1 || com.baidu.live.l.a.uB().aku == null) {
            return null;
        }
        ab abVar = com.baidu.live.l.a.uB().aku.TM;
        if (abVar != null && abVar.Tt != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = abVar.Tt.optJSONObject(strArr[0])) != null) {
            String optString4 = optJSONObject2.optString("bg_color");
            if (TextUtils.isEmpty(optJSONObject2.optString("transparency"))) {
                i3 = 255;
            } else {
                try {
                    i3 = (int) (((Integer.parseInt(optString3) * 1.0f) / 100.0f) * 255.0f);
                } catch (Exception e) {
                    i3 = 255;
                }
            }
            if (!TextUtils.isEmpty(optString4)) {
                i2 = Color.parseColor(optString4);
                i = i3;
                if (abVar != null && abVar.Tu != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = abVar.Tu.optJSONObject(strArr[1])) != null) {
                    optString = optJSONObject.optString("bg_color");
                    if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                        try {
                            i4 = (int) (((Integer.parseInt(optString2) * 1.0f) / 100.0f) * 255.0f);
                        } catch (Exception e2) {
                        }
                    }
                    if (!TextUtils.isEmpty(optString)) {
                        i5 = Color.parseColor(optString);
                        return new u(i2, i5, i, i4);
                    }
                }
                i4 = -1;
                return new u(i2, i5, i, i4);
            }
        }
        i = -1;
        i2 = -1;
        if (abVar != null) {
            optString = optJSONObject.optString("bg_color");
            if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
            }
            if (!TextUtils.isEmpty(optString)) {
            }
        }
        i4 = -1;
        return new u(i2, i5, i, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aaj != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Oj, aVar.Ok, aVar.Ol, String.valueOf(this.aaj.mLiveInfo.group_id), String.valueOf(this.aaj.mLiveInfo.live_id), this.dYj, String.valueOf(this.aaj.OR.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
