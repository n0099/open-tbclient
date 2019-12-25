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
import com.baidu.live.data.ae;
import com.baidu.live.data.av;
import com.baidu.live.data.k;
import com.baidu.live.data.w;
import com.baidu.live.gift.q;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.im.j;
import com.baidu.live.im.message.ImBarragePayResponseMessage;
import com.baidu.live.im.message.c;
import com.baidu.live.im.view.ImBarrageTrackListView;
import com.baidu.live.im.view.LandscapeImBarrageTrackView;
import com.baidu.live.q.a;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b implements j {
    private k aio;
    private com.baidu.live.gift.c.a ald;
    private j.a eOf;
    private boolean eOg;
    private String eOh;
    private CustomMessageListener eOj;
    private HttpMessageListener eOk;
    private CustomMessageListener eOl;
    private CustomMessageTask.CustomRunnable<ImSendMsgData> eOm;
    private boolean eOn = false;
    private ImBarrageTrackListView eOp;
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
        this.eOp.setCanAddNext();
        this.eOp.vN();
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
        return this.eOp;
    }

    @Override // com.baidu.live.im.j
    public void uD() {
        if (this.eOp != null) {
            this.eOp.uD();
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
        if (this.eOp != null) {
            this.eOp.release();
            if (this.eOp.getParent() != null) {
                ((ViewGroup) this.eOp.getParent()).removeView(this.eOp);
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
        this.eOp = new ImBarrageTrackListView(this.mPageContext.getPageActivity(), 3, new LandscapeImBarrageTrackView.a() { // from class: com.baidu.tieba.ala.liveroom.d.b.1
            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void d(com.baidu.live.data.a aVar) {
                b.this.f(aVar);
            }

            @Override // com.baidu.live.im.view.LandscapeImBarrageTrackView.a
            public void c(LandscapeImBarrageTrackView landscapeImBarrageTrackView) {
                b.this.eOp.a(landscapeImBarrageTrackView);
                b.this.bhv();
            }
        });
    }

    private void initListener() {
        bho();
        bhq();
    }

    private void bhm() {
        if (this.eOm == null) {
            this.eOm = new CustomMessageTask.CustomRunnable<ImSendMsgData>() { // from class: com.baidu.tieba.ala.liveroom.d.b.2
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
        CustomMessageTask customMessageTask = new CustomMessageTask(2913101, this.eOm);
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private void bhn() {
        MessageManager.getInstance().unRegisterTask(2913101);
    }

    private void bho() {
        this.eOj = new CustomMessageListener(2913102) { // from class: com.baidu.tieba.ala.liveroom.d.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (UtilHelper.getRealScreenOrientation(b.this.mPageContext.getPageActivity()) == 2 && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.C((List) customResponsedMessage.getData());
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
        this.eOk = new HttpMessageListener(AlaCmdConfigHttp.CMD_ALA_GET_ENTER_EFFECT) { // from class: com.baidu.tieba.ala.liveroom.d.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021133 && (httpResponsedMessage instanceof ImBarragePayResponseMessage)) {
                    b.this.a((ImBarragePayResponseMessage) httpResponsedMessage);
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
        bht();
        if (this.eOl == null) {
            this.eOl = new CustomMessageListener(2913037) { // from class: com.baidu.tieba.ala.liveroom.d.b.5
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
            long j = imSendMsgData.price;
            if (TbadkCoreApplication.getInst().currentAccountTdouNum < j) {
                bhu();
                return;
            }
            TbadkCoreApplication.getInst().currentAccountTdouNum -= j;
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
                if (aVar.vc() && z2) {
                    if (this.mMessages == null) {
                        this.mMessages = new ArrayList();
                    }
                    boolean p = p(aVar);
                    if (p || this.mMessages.size() <= com.baidu.live.r.a.wA().arE.YH) {
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
                        bhv();
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
        if (aVar.vc()) {
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
        av avVar;
        if (this.mMessages != null && !this.mMessages.isEmpty() && this.eOp.vO()) {
            av[] uG = com.baidu.live.im.k.uF().uG();
            com.baidu.live.im.data.a remove = this.mMessages.remove(0);
            if (remove == null || TextUtils.isEmpty(remove.getContent()) || remove.uZ() == null) {
                bhv();
                return;
            }
            if (remove.getMsgType() != 126) {
                avVar = null;
            } else if (uG != null) {
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
            } else {
                return;
            }
            if (this.eOp.a(avVar, avVar == null ? C(remove.vg()) : null, remove.uZ(), q(remove), this.eOh, r(remove))) {
                bhv();
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

    private w C(String[] strArr) {
        JSONObject optJSONObject;
        String optString;
        JSONObject optJSONObject2;
        int i = 255;
        boolean z = false;
        if (strArr == null || strArr.length <= 1 || com.baidu.live.r.a.wA().asy == null) {
            return null;
        }
        w wVar = new w();
        ae aeVar = com.baidu.live.r.a.wA().asy.aaJ;
        if (aeVar != null && aeVar.aak != null && !TextUtils.isEmpty(strArr[0]) && (optJSONObject2 = aeVar.aak.optJSONObject(strArr[0])) != null) {
            int optInt = optJSONObject2.optInt("transparency");
            if (optInt >= 0 && optInt <= 100) {
                wVar.Zj = (int) (((optInt * 1.0f) / 100.0f) * 255.0f);
            } else {
                wVar.Zj = 255;
            }
            wVar.Zk = optJSONObject2.optString("tail_icon");
            String optString2 = optJSONObject2.optString("start_color");
            String optString3 = optJSONObject2.optString("end_color");
            try {
                if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString3)) {
                    wVar.Zf = Color.parseColor(optString2);
                    wVar.Zg = Color.parseColor(optString3);
                    z = true;
                } else {
                    String optString4 = optJSONObject2.optString("bg_color");
                    if (!TextUtils.isEmpty(optString4)) {
                        wVar.Zf = Color.parseColor(optString4);
                        wVar.Zg = wVar.Zf;
                        z = true;
                    }
                }
                if (z) {
                    String optString5 = optJSONObject2.optString("frame_start_color");
                    String optString6 = optJSONObject2.optString("frame_end_color");
                    if (!TextUtils.isEmpty(optString5) && !TextUtils.isEmpty(optString6)) {
                        wVar.Zh = Color.parseColor(optString5);
                        wVar.Zi = Color.parseColor(optString6);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (aeVar != null && aeVar.aal != null && !TextUtils.isEmpty(strArr[1]) && (optJSONObject = aeVar.aal.optJSONObject(strArr[1])) != null) {
            String optString7 = optJSONObject.optString("bg_color");
            if (!TextUtils.isEmpty(optJSONObject.optString("transparency"))) {
                try {
                    i = (int) (((Integer.parseInt(optString) * 1.0f) / 100.0f) * 255.0f);
                } catch (Exception e2) {
                }
            }
            if (!TextUtils.isEmpty(optString7)) {
                wVar.Zl = Color.parseColor(optString7);
                wVar.Zm = i;
            }
        }
        return wVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(com.baidu.live.data.a aVar) {
        if (aVar != null && this.aio != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaPersonCardActivityConfig(this.mPageContext.getPageActivity(), aVar.userId, aVar.userName, aVar.portrait, aVar.sex, aVar.level_id, null, null, 0L, aVar.Vj, aVar.Vk, aVar.Vl, String.valueOf(this.aio.mLiveInfo.group_id), String.valueOf(this.aio.mLiveInfo.live_id), this.eOg, String.valueOf(this.aio.VP.userId), aVar.appId, aVar.getNameShow(), "")));
        }
    }
}
