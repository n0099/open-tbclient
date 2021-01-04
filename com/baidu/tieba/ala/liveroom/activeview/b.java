package com.baidu.tieba.ala.liveroom.activeview;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.collection.SimpleArrayMap;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.af.f;
import com.baidu.live.data.ae;
import com.baidu.live.data.p;
import com.baidu.live.data.x;
import com.baidu.live.data.z;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private x aGe;
    private int aMk;
    private long bbg;
    private List<String> hmy;
    private CustomMessageListener hmz;
    private com.baidu.tieba.ala.liveroom.a.c hpJ;
    private SimpleArrayMap<Integer, Set<Integer>> hpO;
    private HttpMessageListener hpQ;
    private CustomMessageListener hpR;
    private HandlerC0671b hpS;
    private Runnable hpT;
    private boolean hpU;
    private boolean hpV;
    private com.baidu.live.j.a hpW;
    private String hpX;
    private TbPageContext mPageContext;
    private String otherParams;
    private String hpK = "";
    private boolean isHost = false;
    private Map<Integer, c> hpL = new HashMap();
    private Map<Integer, AlaActiveRootView> hpM = new HashMap();
    private SimpleArrayMap<Integer, Integer> hpN = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.j.b> hpP = new ArrayList<>();
    private a hpB = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean wG(int i) {
            return b.this.wG(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, p pVar, int i) {
            b.this.a(view, pVar, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void c(View view, p pVar, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.bbg >= 400) {
                b.this.bbg = currentTimeMillis;
                if (b.this.aGe != null && b.this.aGe.aKu != null && b.this.aGe.mLiveInfo != null) {
                    String str = pVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aGe != null && b.this.aGe.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aGe.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aGe.aKu.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aGe.aKu.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aGe.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aGe.aKu.portrait)) {
                                str2 = URLEncoder.encode(b.this.aGe.aKu.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!wG(pVar.aKg)) {
                        b.this.wF(pVar.aKg);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).wz(i);
                        }
                    }
                    b.this.aY(pVar.aKl, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aGe.mLiveInfo != null) {
                        str3 = b.this.aGe.mLiveInfo.feed_id;
                        str4 = b.this.aGe.mLiveInfo.live_id + "";
                    }
                    b.this.b(pVar, str3, str4);
                    b.this.a(pVar, str3, str4);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void HW(String str) {
            b.this.Id(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void HX(String str) {
            b.this.Ib(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void HY(String str) {
            SchemeUtils.openScheme(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void bN(int i, int i2) {
            AlaActiveRootView wD = b.this.wD(i);
            if (wD != null) {
                for (int i3 = 0; i3 < wD.getChildCount(); i3++) {
                    if (wD.getChildAt(i3) instanceof AlaActiveBannerView) {
                        List<p> originDatas = ((AlaActiveBannerView) wD.getChildAt(i3)).getOriginDatas();
                        if (originDatas != null) {
                            ArrayList arrayList = new ArrayList(originDatas);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((p) it.next()).activityId == i2) {
                                    it.remove();
                                }
                            }
                            if (b.this.hpO == null) {
                                b.this.hpO = new SimpleArrayMap();
                            }
                            Set set = (Set) b.this.hpO.get(Integer.valueOf(i));
                            if (set == null) {
                                set = new HashSet();
                                b.this.hpO.put(Integer.valueOf(i), set);
                            }
                            set.add(Integer.valueOf(i2));
                            b.this.a(i, arrayList, "");
                            return;
                        }
                        return;
                    }
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void nz(boolean z) {
            if (z) {
                b.this.cbv();
            }
        }
    };
    private CustomMessageListener gPs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hpM != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView wD = b.this.wD(i2);
                            if (wD != null) {
                                View lastChild = wD.getLastChild();
                                if (lastChild instanceof AlaActiveBannerView) {
                                    ((AlaActiveBannerView) lastChild).setOtherParams(b.this.otherParams);
                                }
                            }
                            i = i2 + 1;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    };
    private boolean mRunning = true;

    /* loaded from: classes11.dex */
    public interface a {
        void HW(String str);

        void HX(String str);

        void HY(String str);

        void b(View view, p pVar, int i);

        void bN(int i, int i2);

        void c(View view, p pVar, int i);

        void nz(boolean z);

        boolean wG(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hpN.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gPs);
    }

    public void Ia(String str) {
        this.hpX = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void c(x xVar, boolean z) {
        this.hpU = z;
        for (int i = 1; i <= 2; i++) {
            wE(i);
        }
        if (this.hpL != null) {
            this.hpL.clear();
        }
        j(xVar);
        if (this.aGe != null) {
            this.hpK = com.baidu.live.d.Ba().getString("ala_active_view_click_info", "");
            ccC();
            ccD();
            bIm();
        }
    }

    public void I(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "fullscreen".equals(jSONObject.optString("content_type")) && J(bVar)) {
                    Ib(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.hpV) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            ccI();
            ccJ();
            this.hpJ.HV(str);
        }
    }

    private boolean J(com.baidu.live.im.data.b bVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> Ny = bVar.Ny();
        return ListUtils.isEmpty(Ny) || Ny.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hpL.put(Integer.valueOf(i), new c(pendantParentView));
            wC(i);
        }
    }

    private void ccC() {
        if (this.hpQ == null) {
            this.hpQ = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aGe == null || b.this.aGe.mLiveInfo == null || b.this.aGe.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aGe.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.ccE();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.QS() != null) {
                                b.this.aMk = getLiveActivityHttpResponseMessage.QS().aMk;
                                b.this.cG(getLiveActivityHttpResponseMessage.QS().aRm);
                                b.this.e(getLiveActivityHttpResponseMessage.QS().aRn);
                                b.this.a(getLiveActivityHttpResponseMessage.QS().aRo);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ae aeVar) {
        if (aeVar == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo == null ");
        } else if (aeVar.EI() == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo.getUrlDataParams() == null");
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913257, aeVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(z zVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913275, zVar));
    }

    private void ccD() {
        if (this.hpR == null) {
            this.hpR = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Id((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpR);
    }

    public void onStart() {
        this.mRunning = true;
        if (this.hpM != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView wD = wD(i);
                if (wD != null) {
                    wD.onStart();
                }
            }
        }
        cbw();
        if (this.hpJ != null) {
            this.hpJ.resume();
        }
        bIm();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hpM != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView wD = wD(i);
                if (wD != null) {
                    wD.onStop();
                }
            }
        }
        if (this.hpJ != null) {
            this.hpJ.pause();
        }
        ccF();
        cbt();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(x xVar) {
        this.aGe = xVar;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                AlaActiveRootView wD = wD(i2);
                if (wD != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < wD.getChildCount()) {
                            if (wD.getChildAt(i4) instanceof AlaActiveBannerView) {
                                ((AlaActiveBannerView) wD.getChildAt(i4)).setLiveShowData(this.aGe);
                            }
                            i3 = i4 + 1;
                        }
                    }
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void setVisible(int i) {
        if (this.hpM != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bP(i2, i);
            }
        }
    }

    public void bP(int i, int i2) {
        AlaActiveRootView wD;
        this.hpN.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bQ = bQ(i, i2);
        if (this.hpM != null && (wD = wD(i)) != null) {
            wD.setVisibility(bQ);
        }
    }

    private int bQ(int i, int i2) {
        if (this.hpN != null && this.hpN.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hpN.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Ic(String str) {
        if (f.SV().ik(str)) {
            bIm();
        }
    }

    public void release() {
        this.aGe = null;
        this.hpX = null;
        if (this.hpQ != null) {
            MessageManager.getInstance().unRegisterListener(this.hpQ);
            this.hpQ = null;
        }
        if (this.gPs != null) {
            MessageManager.getInstance().unRegisterListener(this.gPs);
            this.gPs = null;
        }
        if (this.hpR != null) {
            MessageManager.getInstance().unRegisterListener(this.hpR);
            this.hpR = null;
        }
        if (this.hpS != null) {
            this.hpS.removeCallbacksAndMessages(null);
        }
        f.SV().release();
        cbt();
        if (this.hpO != null) {
            this.hpO.clear();
        }
        if (this.hpM != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView wD = wD(i);
                if (wD != null) {
                    wD.release();
                    cs(wD);
                }
            }
            this.hpM.clear();
        }
        if (this.hpJ != null) {
            this.hpJ.release();
            this.hpJ = null;
        }
    }

    public void ba(boolean z) {
    }

    public void nB(boolean z) {
    }

    public void updateView() {
        if (this.hpM != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView wD = wD(i2);
                    if (wD != null) {
                        wD.setVisibility(bQ(i2, this.hpN.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dU(int i) {
        if (this.hpJ != null) {
            this.hpJ.dU(i);
        }
    }

    public void nC(boolean z) {
        this.hpV = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIm() {
        if (this.aGe != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.af.d.SS().a(this.aGe.aKQ.userId, this.aGe.aKu.userId, this.aGe.mLiveInfo.room_id, this.aGe.mLiveInfo.live_id, this.aGe.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccE() {
        if (this.mRunning) {
            if (this.hpS == null) {
                this.hpS = new HandlerC0671b(this);
            }
            if (this.hpT == null) {
                this.hpT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bIm();
                    }
                };
            }
            ccF();
            if (this.aMk <= 0) {
                this.aMk = 5;
            }
            this.hpS.postDelayed(this.hpT, this.aMk * 1000);
        }
    }

    private void ccF() {
        if (this.hpS != null && this.hpT != null) {
            this.hpS.removeCallbacks(this.hpT);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cG(List<p> list) {
        HashMap hashMap;
        boolean z;
        List list2;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (p pVar : list) {
                if (a(pVar)) {
                    if (pVar.aKn == null) {
                        pVar.aKn = new p.b();
                    }
                    if (pVar.aKn.pos == 0) {
                        pVar.aKn.pos = 1;
                    }
                    if (hashMap == null || (list2 = (List) hashMap.get(Integer.valueOf(pVar.aKn.pos))) == null || list2.size() < 5) {
                        if (pVar.picType == 0 && (pVar.aKn.width <= 0 || pVar.aKn.height <= 0)) {
                            p.b bVar = pVar.aKn;
                            p.b bVar2 = pVar.aKn;
                            int dimensionPixelOffset = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds120);
                            bVar2.width = dimensionPixelOffset;
                            bVar.height = dimensionPixelOffset;
                        }
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        List list3 = (List) hashMap.get(Integer.valueOf(pVar.aKn.pos));
                        if (list3 == null) {
                            list3 = new ArrayList();
                            hashMap.put(Integer.valueOf(pVar.aKn.pos), list3);
                        }
                        list3.add(pVar);
                        if (z2 || pVar.aKm == null) {
                            z = z2;
                        } else {
                            f.SV().b(pVar.aKm);
                            z = true;
                        }
                        z2 = z;
                    }
                }
            }
        }
        if (!z2) {
            f.SV().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private boolean a(p pVar) {
        boolean z = true;
        if (pVar != null && pVar.aKi == 1) {
            long j = pVar.serverTime;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j < pVar.showTime || j > pVar.end_time) {
                return false;
            }
            if (pVar.aKn == null || (pVar.aKn.pos >= 0 && pVar.aKn.pos <= 2)) {
                if (pVar.picType == 0) {
                    return !TextUtils.isEmpty(pVar.pic_url);
                } else if (pVar.picType == 3) {
                    if (TextUtils.isEmpty(pVar.webUrl) || pVar.aKn == null || pVar.aKn.width <= 0 || pVar.aKn.height <= 0) {
                        z = false;
                    }
                    return z;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }

    private void k(int i, List<p> list) {
        Set<Integer> set;
        if (list == null || list.isEmpty()) {
            ccG();
            wE(i);
            return;
        }
        if (this.hpO != null && (set = this.hpO.get(Integer.valueOf(i))) != null) {
            Iterator<p> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(Integer.valueOf(it.next().activityId))) {
                    it.remove();
                }
            }
        }
        boolean a2 = a(i, list, "");
        c cVar = this.hpL.get(Integer.valueOf(i));
        if (cVar != null && cVar.hpZ != null && a2) {
            cVar.hpZ.a(wD(i));
        }
        ccH();
    }

    private void ccG() {
        if (this.hpW != null) {
            Iterator<com.baidu.live.j.b> it = this.hpP.iterator();
            while (it.hasNext()) {
                this.hpW.b(it.next());
            }
            this.hpP.clear();
            this.hpW.FA();
        }
    }

    private void ccH() {
        if (this.hpW != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView wD = wD(i);
                if (wD != null && wD.getVisibility() == 0 && wD.getChildCount() > 0 && !this.hpP.contains(wD)) {
                    this.hpP.add(wD);
                    this.hpW.a(wD);
                }
            }
            this.hpW.FA();
        }
    }

    public void a(com.baidu.live.j.a aVar) {
        this.hpW = aVar;
    }

    private AlaActiveRootView wC(int i) {
        c cVar;
        AlaActiveRootView wD;
        if (this.hpM == null || (wD = wD(i)) == null || wD.getParent() == null) {
            if (this.hpL != null && (cVar = this.hpL.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hpZ;
                if (pendantParentView == null || this.hpM == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hpM.put(Integer.valueOf(i), alaActiveRootView);
                cs(alaActiveRootView);
                pendantParentView.a(alaActiveRootView, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView;
            }
            return null;
        }
        return wD;
    }

    private void cs(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView wD(int i) {
        if (this.hpM != null) {
            return this.hpM.get(Integer.valueOf(i));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, List<p> list, String str) {
        int i2;
        int i3 = 0;
        if (list == null || list.isEmpty()) {
            wE(i);
            return false;
        }
        AlaActiveRootView wD = wD(i);
        if (wD != null && wD.getChildCount() == 1) {
            View lastChild = wD.getLastChild();
            if ((lastChild instanceof AlaActiveBannerView) && ((AlaActiveBannerView) lastChild).cF(list)) {
                return false;
            }
        }
        wE(i);
        AlaActiveRootView wC = wC(i);
        if (wC != null) {
            Iterator<p> it = list.iterator();
            int i4 = 0;
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                i3 = Math.max(i2, next.aKn.width);
                i4 = Math.max(i4, next.aKn.height);
            }
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(wC.getContext());
            alaActiveBannerView.setActivityContext(this.mPageContext.getPageActivity());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.setLiveShowData(this.aGe);
            alaActiveBannerView.a(this.hpB);
            alaActiveBannerView.j(list, str);
            alaActiveBannerView.bO((int) TypedValue.applyDimension(1, i2, this.mPageContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, i4, this.mPageContext.getResources().getDisplayMetrics()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.hpU || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.hpU && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            }
            wC.addView(alaActiveBannerView, layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbv() {
        if (Build.VERSION.SDK_INT >= 19) {
            cbx();
            if (this.hpS == null) {
                this.hpS = new HandlerC0671b(this);
            }
            if (!this.hpS.hasMessages(1000)) {
                this.hpS.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void cbt() {
        if (this.hmy != null) {
            this.hmy.clear();
        }
        if (this.hpS != null) {
            this.hpS.removeMessages(1000);
        }
        cbu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbw() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hpM != null) {
            if (this.hmy == null || (size = this.hmy.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hmy.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.hmy.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView wD = wD(i2);
                if (wD != null) {
                    View lastChild = wD.getLastChild();
                    if (lastChild instanceof AlaActiveBannerView) {
                        z = ((AlaActiveBannerView) lastChild).HZ(str) | z2;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.hpS.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                cbt();
            }
        }
    }

    private void cbx() {
        if (this.hmy == null) {
            this.hmy = new ArrayList();
        }
        this.hmy.clear();
        if (this.hmz == null) {
            this.hmz = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        b.this.hmy.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hmz);
    }

    private void cbu() {
        if (this.hmz != null) {
            MessageManager.getInstance().unRegisterListener(this.hmz);
            this.hmz = null;
        }
    }

    private void wE(int i) {
        AlaActiveRootView wD = wD(i);
        if (wD != null) {
            wD.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (!TextUtils.isEmpty(str)) {
            if (this.aGe != null) {
                if (this.aGe.aKQ == null) {
                    str6 = null;
                } else if (i == 2) {
                    str6 = ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aGe.aKQ.userId));
                } else {
                    str6 = String.valueOf(this.aGe.aKQ.userId);
                }
                if (this.aGe.aKu == null) {
                    str7 = null;
                } else if (i == 2) {
                    str7 = ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aGe.aKu.userId));
                } else {
                    str7 = String.valueOf(this.aGe.aKu.userId);
                }
                if (this.aGe.mLiveInfo != null) {
                    str3 = String.valueOf(this.aGe.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aGe.mLiveInfo.live_id);
                    str4 = str7;
                    str5 = str6;
                } else {
                    str2 = null;
                    str3 = null;
                    str4 = str7;
                    str5 = str6;
                }
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.hpX);
            if (i == 2) {
                Id(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void Id(String str) {
        int i = 2;
        ccI();
        ccJ();
        if (!this.hpU) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.hpJ.aI(str, i);
    }

    private void ccI() {
        if (this.hpJ == null) {
            this.hpJ = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void ccJ() {
        this.hpJ.setHost(this.isHost);
        if (this.aGe != null && this.aGe.mLiveInfo != null) {
            this.hpJ.g(this.aGe.mLiveInfo.user_id, this.aGe.mLiveInfo.getNameShow(), this.aGe.aKu != null ? this.aGe.aKu.portrait : null);
            this.hpJ.setLiveId(this.aGe.mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, p pVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (pVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(pVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(p pVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (pVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(pVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(p pVar, String str, String str2) {
        if (!this.isHost && pVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, pVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wF(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hpK)) {
                jSONArray = new JSONArray(this.hpK);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hpK = jSONArray.toString();
            com.baidu.live.d.Ba().putString("ala_active_view_click_info", this.hpK);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wG(int i) {
        if (StringUtils.isNull(this.hpK)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hpK);
            if (jSONArray == null || jSONArray.length() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                if (jSONArray.optInt(i2, -1) == i) {
                    return true;
                }
            }
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public static class c {
        PendantParentView hpZ;

        c(PendantParentView pendantParentView) {
            this.hpZ = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0671b extends Handler {
        private final WeakReference<b> hmE;

        HandlerC0671b(b bVar) {
            this.hmE = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hmE.get() != null && message.what == 1000) {
                this.hmE.get().cbw();
            }
        }
    }
}
