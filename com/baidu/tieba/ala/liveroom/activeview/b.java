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
import com.baidu.live.ae.f;
import com.baidu.live.data.ab;
import com.baidu.live.data.ad;
import com.baidu.live.data.ai;
import com.baidu.live.data.t;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    private ab aDd;
    private long aZy;
    private com.baidu.live.an.a bgE;
    private CustomMessageListener bkK;
    private List<String> hmg;
    private Runnable hpA;
    private boolean hpB;
    private boolean hpC;
    private com.baidu.live.i.a hpD;
    private String hpE;
    private SimpleArrayMap<Integer, Set<Integer>> hpv;
    private HttpMessageListener hpx;
    private CustomMessageListener hpy;
    private HandlerC0654b hpz;
    private int interval;
    private TbPageContext mPageContext;
    private String otherParams;
    private String hpr = "";
    private boolean isHost = false;
    private Map<Integer, c> hps = new HashMap();
    private Map<Integer, AlaActiveRootView> hpt = new HashMap();
    private SimpleArrayMap<Integer, Integer> hpu = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.i.b> hpw = new ArrayList<>();
    private a hph = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean vl(int i) {
            return b.this.vl(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(t tVar, int i) {
            b.this.a(tVar, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, t tVar, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aZy >= 400) {
                b.this.aZy = currentTimeMillis;
                if (b.this.aDd != null && b.this.aDd.aId != null && b.this.aDd.mLiveInfo != null) {
                    String str = tVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aDd != null && b.this.aDd.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aDd.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aDd.aId.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aDd.aId.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aDd.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aDd.aId.portrait)) {
                                str2 = URLEncoder.encode(b.this.aDd.aId.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vl(tVar.aHP)) {
                        b.this.vk(tVar.aHP);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).va(i);
                        }
                    }
                    b.this.be(tVar.aHU, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aDd.mLiveInfo != null) {
                        str3 = b.this.aDd.mLiveInfo.feed_id;
                        str4 = b.this.aDd.mLiveInfo.live_id + "";
                    }
                    b.this.b(tVar, str3, str4);
                    b.this.a(tVar, str3, str4);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void Ho(String str) {
            b.this.Hv(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void Hp(String str) {
            b.this.Ht(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void Hq(String str) {
            SchemeUtils.openScheme(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void bL(int i, int i2) {
            AlaActiveRootView vi = b.this.vi(i);
            if (vi != null) {
                for (int i3 = 0; i3 < vi.getChildCount(); i3++) {
                    if (vi.getChildAt(i3) instanceof AlaActiveBannerView) {
                        List<t> datas = ((AlaActiveBannerView) vi.getChildAt(i3)).getDatas();
                        if (datas != null) {
                            ArrayList arrayList = new ArrayList(datas);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((t) it.next()).activityId == i2) {
                                    it.remove();
                                }
                            }
                            if (b.this.hpv == null) {
                                b.this.hpv = new SimpleArrayMap();
                            }
                            Set set = (Set) b.this.hpv.get(Integer.valueOf(i));
                            if (set == null) {
                                set = new HashSet();
                                b.this.hpv.put(Integer.valueOf(i), set);
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
        public void nG(boolean z) {
            if (z) {
                b.this.bYD();
            }
        }
    };
    private CustomMessageListener gNs = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hpt != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView vi = b.this.vi(i2);
                            if (vi != null) {
                                View lastChild = vi.getLastChild();
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
        void Ho(String str);

        void Hp(String str);

        void Hq(String str);

        void a(View view, t tVar, int i);

        void b(t tVar, int i);

        void bL(int i, int i2);

        void nG(boolean z);

        boolean vl(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hpu.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gNs);
    }

    public void Hs(String str) {
        this.hpE = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void c(ab abVar, boolean z) {
        this.hpB = z;
        for (int i = 1; i <= 2; i++) {
            vj(i);
        }
        if (this.hps != null) {
            this.hps.clear();
        }
        j(abVar);
        if (this.aDd != null) {
            this.hpr = com.baidu.live.d.xc().getString("ala_active_view_click_info", "");
            bZH();
            bZI();
            bEN();
        }
    }

    public void N(com.baidu.live.im.data.b bVar) {
        JSONObject jSONObject;
        if (bVar != null && bVar.getMsgType() == 13) {
            try {
                if (bVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) bVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(bVar.getContent());
                }
                if (jSONObject != null && "fullscreen".equals(jSONObject.optString("content_type")) && O(bVar)) {
                    Ht(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ht(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.hpC) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            bZN();
            bZO();
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.url = str;
            cVar.isFullScreen = true;
            this.bgE.a(cVar);
        }
    }

    private boolean O(com.baidu.live.im.data.b bVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> Lb = bVar.Lb();
        return ListUtils.isEmpty(Lb) || Lb.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hps.put(Integer.valueOf(i), new c(pendantParentView));
            vh(i);
        }
    }

    private void bZH() {
        if (this.hpx == null) {
            this.hpx = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aDd == null || b.this.aDd.mLiveInfo == null || b.this.aDd.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aDd.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bZJ();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.Ov() != null) {
                                b.this.interval = getLiveActivityHttpResponseMessage.Ov().interval;
                                b.this.cB(getLiveActivityHttpResponseMessage.Ov().aPx);
                                b.this.e(getLiveActivityHttpResponseMessage.Ov().aPy);
                                b.this.a(getLiveActivityHttpResponseMessage.Ov().aPz);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ai aiVar) {
        if (aiVar == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo == null ");
        } else if (aiVar.Ca() == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo.getUrlDataParams() == null");
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913257, aiVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ad adVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913275, adVar));
    }

    private void bZI() {
        if (this.hpy == null) {
            this.hpy = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Hv((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hpy);
    }

    public void onStart() {
        this.mRunning = true;
        if (this.hpt != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vi = vi(i);
                if (vi != null) {
                    vi.onStart();
                }
            }
        }
        bYE();
        if (this.bgE != null) {
            this.bgE.resume();
        }
        bEN();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hpt != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vi = vi(i);
                if (vi != null) {
                    vi.onStop();
                }
            }
        }
        if (this.bgE != null) {
            this.bgE.pause();
        }
        bZK();
        bYC();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(ab abVar) {
        this.aDd = abVar;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                AlaActiveRootView vi = vi(i2);
                if (vi != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < vi.getChildCount()) {
                            if (vi.getChildAt(i4) instanceof AlaActiveBannerView) {
                                ((AlaActiveBannerView) vi.getChildAt(i4)).setLiveShowData(this.aDd);
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
        if (this.hpt != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bM(i2, i);
            }
        }
    }

    public void bM(int i, int i2) {
        AlaActiveRootView vi;
        this.hpu.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bN = bN(i, i2);
        if (this.hpt != null && (vi = vi(i)) != null) {
            vi.setVisibility(bN);
        }
    }

    private int bN(int i, int i2) {
        if (this.hpu != null && this.hpu.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hpu.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Hu(String str) {
        if (f.QB().hv(str)) {
            bEN();
        }
    }

    public void release() {
        this.aDd = null;
        this.hpE = null;
        if (this.hpx != null) {
            MessageManager.getInstance().unRegisterListener(this.hpx);
            this.hpx = null;
        }
        if (this.gNs != null) {
            MessageManager.getInstance().unRegisterListener(this.gNs);
            this.gNs = null;
        }
        if (this.hpy != null) {
            MessageManager.getInstance().unRegisterListener(this.hpy);
            this.hpy = null;
        }
        if (this.hpz != null) {
            this.hpz.removeCallbacksAndMessages(null);
        }
        f.QB().release();
        bYC();
        if (this.hpv != null) {
            this.hpv.clear();
        }
        if (this.hpt != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vi = vi(i);
                if (vi != null) {
                    vi.release();
                    co(vi);
                }
            }
            this.hpt.clear();
        }
        if (this.bgE != null) {
            this.bgE.release();
            this.bgE = null;
        }
    }

    public void aW(boolean z) {
    }

    public void nI(boolean z) {
    }

    public void updateView() {
        if (this.hpt != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView vi = vi(i2);
                    if (vi != null) {
                        vi.setVisibility(bN(i2, this.hpu.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void cr(int i) {
        if (this.bgE != null) {
            this.bgE.cr(i);
        }
    }

    public void nJ(boolean z) {
        this.hpC = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEN() {
        if (this.aDd != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.ae.d.Qy().a(this.aDd.aIz.userId, this.aDd.aId.userId, this.aDd.mLiveInfo.room_id, this.aDd.mLiveInfo.live_id, this.aDd.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZJ() {
        if (this.mRunning) {
            if (this.hpz == null) {
                this.hpz = new HandlerC0654b(this);
            }
            if (this.hpA == null) {
                this.hpA = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bEN();
                    }
                };
            }
            bZK();
            if (this.interval <= 0) {
                this.interval = 5;
            }
            this.hpz.postDelayed(this.hpA, this.interval * 1000);
        }
    }

    private void bZK() {
        if (this.hpz != null && this.hpA != null) {
            this.hpz.removeCallbacks(this.hpA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(List<t> list) {
        HashMap hashMap;
        boolean z;
        List list2;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (t tVar : list) {
                if (a(tVar)) {
                    if (tVar.aHW == null) {
                        tVar.aHW = new t.b();
                    }
                    if (tVar.aHW.pos == 0) {
                        tVar.aHW.pos = 1;
                    }
                    if (hashMap == null || (list2 = (List) hashMap.get(Integer.valueOf(tVar.aHW.pos))) == null || list2.size() < 5) {
                        if (tVar.picType == 0 && (tVar.aHW.width <= 0 || tVar.aHW.height <= 0)) {
                            t.b bVar = tVar.aHW;
                            t.b bVar2 = tVar.aHW;
                            int dimensionPixelOffset = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds120);
                            bVar2.width = dimensionPixelOffset;
                            bVar.height = dimensionPixelOffset;
                        }
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        List list3 = (List) hashMap.get(Integer.valueOf(tVar.aHW.pos));
                        if (list3 == null) {
                            list3 = new ArrayList();
                            hashMap.put(Integer.valueOf(tVar.aHW.pos), list3);
                        }
                        list3.add(tVar);
                        if (z2 || tVar.aHV == null) {
                            z = z2;
                        } else {
                            f.QB().b(tVar.aHV);
                            z = true;
                        }
                        z2 = z;
                    }
                }
            }
        }
        if (!z2) {
            f.QB().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            l(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private boolean a(t tVar) {
        boolean z = true;
        if (tVar != null && tVar.aHR == 1) {
            long j = tVar.serverTime;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j < tVar.showTime || j > tVar.end_time) {
                return false;
            }
            if (tVar.aHW == null || (tVar.aHW.pos >= 0 && tVar.aHW.pos <= 2)) {
                if (tVar.picType == 0) {
                    return !TextUtils.isEmpty(tVar.pic_url);
                } else if (tVar.picType == 3) {
                    if (TextUtils.isEmpty(tVar.webUrl) || tVar.aHW == null || tVar.aHW.width <= 0 || tVar.aHW.height <= 0) {
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

    private void l(int i, List<t> list) {
        Set<Integer> set;
        if (list == null || list.isEmpty()) {
            bZL();
            vj(i);
            return;
        }
        if (this.hpv != null && (set = this.hpv.get(Integer.valueOf(i))) != null) {
            Iterator<t> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(Integer.valueOf(it.next().activityId))) {
                    it.remove();
                }
            }
        }
        boolean a2 = a(i, list, "");
        c cVar = this.hps.get(Integer.valueOf(i));
        if (cVar != null && cVar.hpG != null && a2) {
            cVar.hpG.a(vi(i));
        }
        bZM();
    }

    private void bZL() {
        if (this.hpD != null) {
            Iterator<com.baidu.live.i.b> it = this.hpw.iterator();
            while (it.hasNext()) {
                this.hpD.b(it.next());
            }
            this.hpw.clear();
            this.hpD.CU();
        }
    }

    private void bZM() {
        if (this.hpD != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vi = vi(i);
                if (vi != null && vi.getVisibility() == 0 && vi.getChildCount() > 0 && !this.hpw.contains(vi)) {
                    this.hpw.add(vi);
                    this.hpD.a(vi);
                }
            }
            this.hpD.CU();
        }
    }

    public void a(com.baidu.live.i.a aVar) {
        this.hpD = aVar;
    }

    private AlaActiveRootView vh(int i) {
        c cVar;
        AlaActiveRootView vi;
        if (this.hpt == null || (vi = vi(i)) == null || vi.getParent() == null) {
            if (this.hps != null && (cVar = this.hps.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hpG;
                if (pendantParentView == null || this.hpt == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hpt.put(Integer.valueOf(i), alaActiveRootView);
                co(alaActiveRootView);
                pendantParentView.a(alaActiveRootView, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView;
            }
            return null;
        }
        return vi;
    }

    private void co(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView vi(int i) {
        if (this.hpt != null) {
            return this.hpt.get(Integer.valueOf(i));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, List<t> list, String str) {
        int i2;
        int i3 = 0;
        if (list == null || list.isEmpty()) {
            vj(i);
            return false;
        }
        AlaActiveRootView vi = vi(i);
        if (vi != null && vi.getChildCount() == 1) {
            View lastChild = vi.getLastChild();
            if ((lastChild instanceof AlaActiveBannerView) && ((AlaActiveBannerView) lastChild).cA(list)) {
                return false;
            }
        }
        vj(i);
        AlaActiveRootView vh = vh(i);
        if (vh != null) {
            Iterator<t> it = list.iterator();
            int i4 = 0;
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                t next = it.next();
                i3 = Math.max(i2, next.aHW.width);
                i4 = Math.max(i4, next.aHW.height);
            }
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(vh.getContext());
            alaActiveBannerView.setActivityContext(this.mPageContext.getPageActivity());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.setLiveShowData(this.aDd);
            alaActiveBannerView.a(this.hph);
            alaActiveBannerView.setData(list, str);
            alaActiveBannerView.setPagerSize((int) TypedValue.applyDimension(1, i2, this.mPageContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, i4, this.mPageContext.getResources().getDisplayMetrics()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.hpB || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.hpB && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            }
            vh.addView(alaActiveBannerView, layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYD() {
        if (Build.VERSION.SDK_INT >= 19) {
            Jv();
            if (this.hpz == null) {
                this.hpz = new HandlerC0654b(this);
            }
            if (!this.hpz.hasMessages(1000)) {
                this.hpz.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bYC() {
        if (this.hmg != null) {
            this.hmg.clear();
        }
        if (this.hpz != null) {
            this.hpz.removeMessages(1000);
        }
        Jw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYE() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hpt != null) {
            if (this.hmg == null || (size = this.hmg.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hmg.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.hmg.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView vi = vi(i2);
                if (vi != null) {
                    View lastChild = vi.getLastChild();
                    if (lastChild instanceof AlaActiveBannerView) {
                        z = ((AlaActiveBannerView) lastChild).Hr(str) | z2;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.hpz.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bYC();
            }
        }
    }

    private void Jv() {
        if (this.hmg == null) {
            this.hmg = new ArrayList();
        }
        this.hmg.clear();
        if (this.bkK == null) {
            this.bkK = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        b.this.hmg.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bkK);
    }

    private void Jw() {
        if (this.bkK != null) {
            MessageManager.getInstance().unRegisterListener(this.bkK);
            this.bkK = null;
        }
    }

    private void vj(int i) {
        AlaActiveRootView vi = vi(i);
        if (vi != null) {
            vi.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void be(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (!TextUtils.isEmpty(str)) {
            if (this.aDd != null) {
                if (this.aDd.aIz == null) {
                    str6 = null;
                } else if (i == 2) {
                    str6 = ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aDd.aIz.userId));
                } else {
                    str6 = String.valueOf(this.aDd.aIz.userId);
                }
                if (this.aDd.aId == null) {
                    str7 = null;
                } else if (i == 2) {
                    str7 = ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aDd.aId.userId));
                } else {
                    str7 = String.valueOf(this.aDd.aId.userId);
                }
                if (this.aDd.mLiveInfo != null) {
                    str3 = String.valueOf(this.aDd.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aDd.mLiveInfo.live_id);
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
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.hpE);
            if (i == 2) {
                Hv(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void Hv(String str) {
        bZN();
        bZO();
        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
        if (!this.hpB) {
            cVar.bWs = 0.7f;
        } else {
            cVar.bWt = 1;
        }
        cVar.url = str;
        this.bgE.a(cVar);
    }

    private void bZN() {
        if (this.bgE == null) {
            this.bgE = new com.baidu.live.an.a(this.mPageContext.getPageActivity());
        }
    }

    private void bZO() {
        this.bgE.isHost = this.isHost;
        if (this.aDd != null && this.aDd.mLiveInfo != null) {
            this.bgE.bWn = this.aDd.mLiveInfo.user_id;
            this.bgE.bWo = this.aDd.mLiveInfo.getNameShow();
            this.bgE.liveId = this.aDd.mLiveInfo.live_id;
            if (this.aDd.aId != null) {
                this.bgE.anchorPortrait = this.aDd.aId != null ? this.aDd.aId.portrait : null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (tVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(tVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(t tVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (tVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(tVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(t tVar, String str, String str2) {
        if (!this.isHost && tVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, tVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vk(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hpr)) {
                jSONArray = new JSONArray(this.hpr);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hpr = jSONArray.toString();
            com.baidu.live.d.xc().putString("ala_active_view_click_info", this.hpr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vl(int i) {
        if (StringUtils.isNull(this.hpr)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hpr);
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
        PendantParentView hpG;

        c(PendantParentView pendantParentView) {
            this.hpG = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static class HandlerC0654b extends Handler {
        private final WeakReference<b> hml;

        HandlerC0654b(b bVar) {
            this.hml = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hml.get() != null && message.what == 1000) {
                this.hml.get().bYE();
            }
        }
    }
}
