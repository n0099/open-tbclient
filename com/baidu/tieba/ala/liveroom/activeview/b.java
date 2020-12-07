package com.baidu.tieba.ala.liveroom.activeview;

import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.ae.f;
import com.baidu.live.data.ad;
import com.baidu.live.data.o;
import com.baidu.live.data.w;
import com.baidu.live.data.y;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
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
/* loaded from: classes4.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private w aFN;
    private int aLG;
    private long aZz;
    private List<String> haG;
    private CustomMessageListener haH;
    private com.baidu.tieba.ala.liveroom.a.c hdU;
    private SimpleArrayMap<Integer, Set<Integer>> hdZ;
    private HttpMessageListener heb;
    private CustomMessageListener hec;
    private HandlerC0679b hed;
    private Runnable hee;
    private boolean hef;
    private boolean heg;
    private com.baidu.live.i.a heh;
    private String hei;
    private TbPageContext mPageContext;
    private String otherParams;
    private String hdV = "";
    private boolean isHost = false;
    private Map<Integer, c> hdW = new HashMap();
    private Map<Integer, AlaActiveRootView> hdX = new HashMap();
    private SimpleArrayMap<Integer, Integer> hdY = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.i.b> hea = new ArrayList<>();
    private a hdM = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean wv(int i) {
            return b.this.wv(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, o oVar, int i) {
            b.this.a(view, oVar, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void c(View view, o oVar, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aZz >= 400) {
                b.this.aZz = currentTimeMillis;
                if (b.this.aFN != null && b.this.aFN.aJV != null && b.this.aFN.mLiveInfo != null) {
                    String str = oVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aFN != null && b.this.aFN.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aFN.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aFN.aJV.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aFN.aJV.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aFN.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aFN.aJV.portrait)) {
                                str2 = URLEncoder.encode(b.this.aFN.aJV.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!wv(oVar.aJH)) {
                        b.this.wu(oVar.aJH);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).wo(i);
                        }
                    }
                    b.this.aW(oVar.aJM, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aFN.mLiveInfo != null) {
                        str3 = b.this.aFN.mLiveInfo.feed_id;
                        str4 = b.this.aFN.mLiveInfo.live_id + "";
                    }
                    b.this.b(oVar, str3, str4);
                    b.this.a(oVar, str3, str4);
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
        public void bO(int i, int i2) {
            AlaActiveRootView ws = b.this.ws(i);
            if (ws != null) {
                for (int i3 = 0; i3 < ws.getChildCount(); i3++) {
                    if (ws.getChildAt(i3) instanceof AlaActiveBannerView) {
                        List<o> originDatas = ((AlaActiveBannerView) ws.getChildAt(i3)).getOriginDatas();
                        if (originDatas != null) {
                            ArrayList arrayList = new ArrayList(originDatas);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((o) it.next()).activityId == i2) {
                                    it.remove();
                                }
                            }
                            if (b.this.hdZ == null) {
                                b.this.hdZ = new SimpleArrayMap();
                            }
                            Set set = (Set) b.this.hdZ.get(Integer.valueOf(i));
                            if (set == null) {
                                set = new HashSet();
                                b.this.hdZ.put(Integer.valueOf(i), set);
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
        public void na(boolean z) {
            if (z) {
                b.this.bYP();
            }
        }
    };
    private CustomMessageListener gDE = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hdX != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView ws = b.this.ws(i2);
                            if (ws != null) {
                                View lastChild = ws.getLastChild();
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

    /* loaded from: classes4.dex */
    public interface a {
        void HW(String str);

        void HX(String str);

        void HY(String str);

        void b(View view, o oVar, int i);

        void bO(int i, int i2);

        void c(View view, o oVar, int i);

        void na(boolean z);

        boolean wv(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hdY.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gDE);
    }

    public void Ia(String str) {
        this.hei = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(w wVar, boolean z) {
        this.hef = z;
        for (int i = 1; i <= 2; i++) {
            wt(i);
        }
        if (this.hdW != null) {
            this.hdW.clear();
        }
        i(wVar);
        if (this.aFN != null) {
            this.hdV = com.baidu.live.d.BM().getString("ala_active_view_click_info", "");
            bZU();
            bZV();
            bFR();
        }
    }

    public void G(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "fullscreen".equals(jSONObject.optString("content_type")) && H(bVar)) {
                    Ib(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ib(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.heg) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            caa();
            cab();
            this.hdU.HV(str);
        }
    }

    private boolean H(com.baidu.live.im.data.b bVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> NW = bVar.NW();
        return ListUtils.isEmpty(NW) || NW.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hdW.put(Integer.valueOf(i), new c(pendantParentView));
            wr(i);
        }
    }

    private void bZU() {
        if (this.heb == null) {
            this.heb = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aFN == null || b.this.aFN.mLiveInfo == null || b.this.aFN.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aFN.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bZW();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.PT() != null) {
                                b.this.aLG = getLiveActivityHttpResponseMessage.PT().aLG;
                                b.this.cz(getLiveActivityHttpResponseMessage.PT().aQx);
                                b.this.e(getLiveActivityHttpResponseMessage.PT().aQy);
                                b.this.a(getLiveActivityHttpResponseMessage.PT().aQz);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.heb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ad adVar) {
        if (adVar == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo == null ");
        } else if (adVar.Fs() == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo.getUrlDataParams() == null");
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913257, adVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(y yVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913275, yVar));
    }

    private void bZV() {
        if (this.hec == null) {
            this.hec = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Id((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hec);
    }

    public void onStart() {
        this.mRunning = true;
        if (this.hdX != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView ws = ws(i);
                if (ws != null) {
                    ws.onStart();
                }
            }
        }
        bYQ();
        if (this.hdU != null) {
            this.hdU.resume();
        }
        bFR();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hdX != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView ws = ws(i);
                if (ws != null) {
                    ws.onStop();
                }
            }
        }
        if (this.hdU != null) {
            this.hdU.pause();
        }
        bZX();
        bYN();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void i(w wVar) {
        this.aFN = wVar;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                AlaActiveRootView ws = ws(i2);
                if (ws != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < ws.getChildCount()) {
                            if (ws.getChildAt(i4) instanceof AlaActiveBannerView) {
                                ((AlaActiveBannerView) ws.getChildAt(i4)).setLiveShowData(this.aFN);
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
        if (this.hdX != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bQ(i2, i);
            }
        }
    }

    public void bQ(int i, int i2) {
        AlaActiveRootView ws;
        this.hdY.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bR = bR(i, i2);
        if (this.hdX != null && (ws = ws(i)) != null) {
            ws.setVisibility(bR);
        }
    }

    private int bR(int i, int i2) {
        if (this.hdY != null && this.hdY.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hdY.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Ic(String str) {
        if (f.RR().ix(str)) {
            bFR();
        }
    }

    public void release() {
        this.aFN = null;
        this.hei = null;
        if (this.heb != null) {
            MessageManager.getInstance().unRegisterListener(this.heb);
            this.heb = null;
        }
        if (this.gDE != null) {
            MessageManager.getInstance().unRegisterListener(this.gDE);
            this.gDE = null;
        }
        if (this.hec != null) {
            MessageManager.getInstance().unRegisterListener(this.hec);
            this.hec = null;
        }
        if (this.hed != null) {
            this.hed.removeCallbacksAndMessages(null);
        }
        f.RR().release();
        bYN();
        if (this.hdZ != null) {
            this.hdZ.clear();
        }
        if (this.hdX != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView ws = ws(i);
                if (ws != null) {
                    ws.release();
                    cj(ws);
                }
            }
            this.hdX.clear();
        }
        if (this.hdU != null) {
            this.hdU.release();
            this.hdU = null;
        }
    }

    public void bd(boolean z) {
    }

    public void nc(boolean z) {
    }

    public void updateView() {
        if (this.hdX != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView ws = ws(i2);
                    if (ws != null) {
                        ws.setVisibility(bR(i2, this.hdY.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dX(int i) {
        if (this.hdU != null) {
            this.hdU.dX(i);
        }
    }

    public void nd(boolean z) {
        this.heg = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFR() {
        if (this.aFN != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.ae.d.RO().a(this.aFN.aKr.userId, this.aFN.aJV.userId, this.aFN.mLiveInfo.room_id, this.aFN.mLiveInfo.live_id, this.aFN.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZW() {
        if (this.mRunning) {
            if (this.hed == null) {
                this.hed = new HandlerC0679b(this);
            }
            if (this.hee == null) {
                this.hee = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bFR();
                    }
                };
            }
            bZX();
            if (this.aLG <= 0) {
                this.aLG = 5;
            }
            this.hed.postDelayed(this.hee, this.aLG * 1000);
        }
    }

    private void bZX() {
        if (this.hed != null && this.hee != null) {
            this.hed.removeCallbacks(this.hee);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(List<o> list) {
        HashMap hashMap;
        boolean z;
        List list2;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (o oVar : list) {
                if (a(oVar)) {
                    if (oVar.aJO == null) {
                        oVar.aJO = new o.b();
                    }
                    if (oVar.aJO.pos == 0) {
                        oVar.aJO.pos = 1;
                    }
                    if (hashMap == null || (list2 = (List) hashMap.get(Integer.valueOf(oVar.aJO.pos))) == null || list2.size() < 5) {
                        if (oVar.picType == 0 && (oVar.aJO.width <= 0 || oVar.aJO.height <= 0)) {
                            o.b bVar = oVar.aJO;
                            o.b bVar2 = oVar.aJO;
                            int dimensionPixelOffset = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds120);
                            bVar2.width = dimensionPixelOffset;
                            bVar.height = dimensionPixelOffset;
                        }
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        List list3 = (List) hashMap.get(Integer.valueOf(oVar.aJO.pos));
                        if (list3 == null) {
                            list3 = new ArrayList();
                            hashMap.put(Integer.valueOf(oVar.aJO.pos), list3);
                        }
                        list3.add(oVar);
                        if (z2 || oVar.aJN == null) {
                            z = z2;
                        } else {
                            f.RR().b(oVar.aJN);
                            z = true;
                        }
                        z2 = z;
                    }
                }
            }
        }
        if (!z2) {
            f.RR().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private boolean a(o oVar) {
        boolean z = true;
        if (oVar != null && oVar.aJJ == 1) {
            long j = oVar.serverTime;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j < oVar.showTime || j > oVar.end_time) {
                return false;
            }
            if (oVar.aJO == null || (oVar.aJO.pos >= 0 && oVar.aJO.pos <= 2)) {
                if (oVar.picType == 0) {
                    return !TextUtils.isEmpty(oVar.pic_url);
                } else if (oVar.picType == 3) {
                    if (TextUtils.isEmpty(oVar.webUrl) || oVar.aJO == null || oVar.aJO.width <= 0 || oVar.aJO.height <= 0) {
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

    private void k(int i, List<o> list) {
        Set<Integer> set;
        if (list == null || list.isEmpty()) {
            bZY();
            wt(i);
            return;
        }
        if (this.hdZ != null && (set = this.hdZ.get(Integer.valueOf(i))) != null) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(Integer.valueOf(it.next().activityId))) {
                    it.remove();
                }
            }
        }
        boolean a2 = a(i, list, "");
        c cVar = this.hdW.get(Integer.valueOf(i));
        if (cVar != null && cVar.hek != null && a2) {
            cVar.hek.a(ws(i));
        }
        bZZ();
    }

    private void bZY() {
        if (this.heh != null) {
            Iterator<com.baidu.live.i.b> it = this.hea.iterator();
            while (it.hasNext()) {
                this.heh.b(it.next());
            }
            this.hea.clear();
            this.heh.Gh();
        }
    }

    private void bZZ() {
        if (this.heh != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView ws = ws(i);
                if (ws != null && ws.getVisibility() == 0 && ws.getChildCount() > 0 && !this.hea.contains(ws)) {
                    this.hea.add(ws);
                    this.heh.a(ws);
                }
            }
            this.heh.Gh();
        }
    }

    public void a(com.baidu.live.i.a aVar) {
        this.heh = aVar;
    }

    private AlaActiveRootView wr(int i) {
        c cVar;
        AlaActiveRootView ws;
        if (this.hdX == null || (ws = ws(i)) == null || ws.getParent() == null) {
            if (this.hdW != null && (cVar = this.hdW.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hek;
                if (pendantParentView == null || this.hdX == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hdX.put(Integer.valueOf(i), alaActiveRootView);
                cj(alaActiveRootView);
                pendantParentView.a(alaActiveRootView, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView;
            }
            return null;
        }
        return ws;
    }

    private void cj(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView ws(int i) {
        if (this.hdX != null) {
            return this.hdX.get(Integer.valueOf(i));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, List<o> list, String str) {
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            wt(i);
            return false;
        }
        AlaActiveRootView ws = ws(i);
        if (ws != null && ws.getChildCount() == 1) {
            View lastChild = ws.getLastChild();
            if ((lastChild instanceof AlaActiveBannerView) && ((AlaActiveBannerView) lastChild).cy(list)) {
                return false;
            }
        }
        wt(i);
        AlaActiveRootView wr = wr(i);
        if (wr != null) {
            int i3 = 0;
            for (o oVar : list) {
                i3 = Math.max(i3, oVar.aJO.width);
                i2 = Math.max(i2, oVar.aJO.height);
            }
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(wr.getContext());
            alaActiveBannerView.setActivityContext(this.mPageContext.getPageActivity());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.setLiveShowData(this.aFN);
            alaActiveBannerView.a(this.hdM);
            alaActiveBannerView.j(list, str);
            alaActiveBannerView.bP((int) TypedValue.applyDimension(1, i3, this.mPageContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, i2, this.mPageContext.getResources().getDisplayMetrics()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.hef || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.hef && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            }
            wr.addView(alaActiveBannerView, layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYP() {
        if (Build.VERSION.SDK_INT >= 19) {
            bYR();
            if (this.hed == null) {
                this.hed = new HandlerC0679b(this);
            }
            if (!this.hed.hasMessages(1000)) {
                this.hed.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bYN() {
        if (this.haG != null) {
            this.haG.clear();
        }
        if (this.hed != null) {
            this.hed.removeMessages(1000);
        }
        bYO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYQ() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hdX != null) {
            if (this.haG == null || (size = this.haG.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.haG.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.haG.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView ws = ws(i2);
                if (ws != null) {
                    View lastChild = ws.getLastChild();
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
                this.hed.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bYN();
            }
        }
    }

    private void bYR() {
        if (this.haG == null) {
            this.haG = new ArrayList();
        }
        this.haG.clear();
        if (this.haH == null) {
            this.haH = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        b.this.haG.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.haH);
    }

    private void bYO() {
        if (this.haH != null) {
            MessageManager.getInstance().unRegisterListener(this.haH);
            this.haH = null;
        }
    }

    private void wt(int i) {
        AlaActiveRootView ws = ws(i);
        if (ws != null) {
            ws.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.aFN != null) {
                String valueOf = this.aFN.aKr != null ? String.valueOf(this.aFN.aKr.userId) : null;
                String valueOf2 = this.aFN.aJV != null ? String.valueOf(this.aFN.aJV.userId) : null;
                if (this.aFN.mLiveInfo != null) {
                    str3 = String.valueOf(this.aFN.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aFN.mLiveInfo.live_id);
                    str4 = valueOf2;
                    str5 = valueOf;
                } else {
                    str2 = null;
                    str3 = null;
                    str4 = valueOf2;
                    str5 = valueOf;
                }
            } else {
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
            }
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.hei);
            if (i == 2) {
                Id(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void Id(String str) {
        int i = 2;
        caa();
        cab();
        if (!this.hef) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.hdU.aG(str, i);
    }

    private void caa() {
        if (this.hdU == null) {
            this.hdU = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void cab() {
        this.hdU.setHost(this.isHost);
        if (this.aFN != null && this.aFN.mLiveInfo != null) {
            this.hdU.f(this.aFN.mLiveInfo.user_id, this.aFN.mLiveInfo.getNameShow(), this.aFN.aJV != null ? this.aFN.aJV.portrait : null);
            this.hdU.setLiveId(this.aFN.mLiveInfo.live_id);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, o oVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (oVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(oVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(o oVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (oVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(oVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(o oVar, String str, String str2) {
        if (!this.isHost && oVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, oVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wu(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hdV)) {
                jSONArray = new JSONArray(this.hdV);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hdV = jSONArray.toString();
            com.baidu.live.d.BM().putString("ala_active_view_click_info", this.hdV);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wv(int i) {
        if (StringUtils.isNull(this.hdV)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hdV);
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
    /* loaded from: classes4.dex */
    public static class c {
        PendantParentView hek;

        c(PendantParentView pendantParentView) {
            this.hek = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0679b extends Handler {
        private final WeakReference<b> haQ;

        HandlerC0679b(b bVar) {
            this.haQ = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.haQ.get() != null && message.what == 1000) {
                this.haQ.get().bYQ();
            }
        }
    }
}
