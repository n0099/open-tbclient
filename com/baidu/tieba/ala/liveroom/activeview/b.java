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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private ab aED;
    private long baZ;
    private com.baidu.live.an.a bif;
    private CustomMessageListener bmk;
    private List<String> hod;
    private com.baidu.live.i.a hrA;
    private String hrB;
    private SimpleArrayMap<Integer, Set<Integer>> hrs;
    private HttpMessageListener hru;
    private CustomMessageListener hrv;
    private HandlerC0661b hrw;
    private Runnable hrx;
    private boolean hry;
    private boolean hrz;
    private int interval;
    private TbPageContext mPageContext;
    private String otherParams;
    private String hro = "";
    private boolean isHost = false;
    private Map<Integer, c> hrp = new HashMap();
    private Map<Integer, AlaActiveRootView> hrq = new HashMap();
    private SimpleArrayMap<Integer, Integer> hrr = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.i.b> hrt = new ArrayList<>();
    private a hre = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean vn(int i) {
            return b.this.vn(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(t tVar, int i) {
            b.this.a(tVar, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, t tVar, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.baZ >= 400) {
                b.this.baZ = currentTimeMillis;
                if (b.this.aED != null && b.this.aED.aJD != null && b.this.aED.mLiveInfo != null) {
                    String str = tVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aED != null && b.this.aED.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aED.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aED.aJD.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aED.aJD.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aED.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aED.aJD.portrait)) {
                                str2 = URLEncoder.encode(b.this.aED.aJD.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vn(tVar.aJp)) {
                        b.this.vm(tVar.aJp);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).vc(i);
                        }
                    }
                    b.this.be(tVar.aJu, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aED.mLiveInfo != null) {
                        str3 = b.this.aED.mLiveInfo.feed_id;
                        str4 = b.this.aED.mLiveInfo.live_id + "";
                    }
                    b.this.b(tVar, str3, str4);
                    b.this.a(tVar, str3, str4);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void Hy(String str) {
            b.this.HF(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void Hz(String str) {
            b.this.HD(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void HA(String str) {
            SchemeUtils.openScheme(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void bM(int i, int i2) {
            AlaActiveRootView vk = b.this.vk(i);
            if (vk != null) {
                for (int i3 = 0; i3 < vk.getChildCount(); i3++) {
                    if (vk.getChildAt(i3) instanceof AlaActiveBannerView) {
                        List<t> datas = ((AlaActiveBannerView) vk.getChildAt(i3)).getDatas();
                        if (datas != null) {
                            ArrayList arrayList = new ArrayList(datas);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((t) it.next()).activityId == i2) {
                                    it.remove();
                                }
                            }
                            if (b.this.hrs == null) {
                                b.this.hrs = new SimpleArrayMap();
                            }
                            Set set = (Set) b.this.hrs.get(Integer.valueOf(i));
                            if (set == null) {
                                set = new HashSet();
                                b.this.hrs.put(Integer.valueOf(i), set);
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
                b.this.bYQ();
            }
        }
    };
    private CustomMessageListener gPp = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hrq != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView vk = b.this.vk(i2);
                            if (vk != null) {
                                View lastChild = vk.getLastChild();
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

    /* loaded from: classes10.dex */
    public interface a {
        void HA(String str);

        void Hy(String str);

        void Hz(String str);

        void a(View view, t tVar, int i);

        void b(t tVar, int i);

        void bM(int i, int i2);

        void nG(boolean z);

        boolean vn(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hrr.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gPp);
    }

    public void HC(String str) {
        this.hrB = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void c(ab abVar, boolean z) {
        this.hry = z;
        for (int i = 1; i <= 2; i++) {
            vl(i);
        }
        if (this.hrp != null) {
            this.hrp.clear();
        }
        j(abVar);
        if (this.aED != null) {
            this.hro = com.baidu.live.d.xf().getString("ala_active_view_click_info", "");
            bZU();
            bZV();
            bER();
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
                    HD(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HD(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.hrz) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            caa();
            cab();
            com.baidu.live.an.c cVar = new com.baidu.live.an.c();
            cVar.url = str;
            cVar.isFullScreen = true;
            this.bif.a(cVar);
        }
    }

    private boolean O(com.baidu.live.im.data.b bVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> Le = bVar.Le();
        return ListUtils.isEmpty(Le) || Le.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hrp.put(Integer.valueOf(i), new c(pendantParentView));
            vj(i);
        }
    }

    private void bZU() {
        if (this.hru == null) {
            this.hru = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aED == null || b.this.aED.mLiveInfo == null || b.this.aED.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aED.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bZW();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.Oy() != null) {
                                b.this.interval = getLiveActivityHttpResponseMessage.Oy().interval;
                                b.this.cB(getLiveActivityHttpResponseMessage.Oy().aQX);
                                b.this.e(getLiveActivityHttpResponseMessage.Oy().aQY);
                                b.this.a(getLiveActivityHttpResponseMessage.Oy().aQZ);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hru);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ai aiVar) {
        if (aiVar == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo == null ");
        } else if (aiVar.Cd() == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo.getUrlDataParams() == null");
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913257, aiVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ad adVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913275, adVar));
    }

    private void bZV() {
        if (this.hrv == null) {
            this.hrv = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.HF((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hrv);
    }

    public void onStart() {
        this.mRunning = true;
        if (this.hrq != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vk = vk(i);
                if (vk != null) {
                    vk.onStart();
                }
            }
        }
        bYR();
        if (this.bif != null) {
            this.bif.resume();
        }
        bER();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hrq != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vk = vk(i);
                if (vk != null) {
                    vk.onStop();
                }
            }
        }
        if (this.bif != null) {
            this.bif.pause();
        }
        bZX();
        bYP();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(ab abVar) {
        this.aED = abVar;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                AlaActiveRootView vk = vk(i2);
                if (vk != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < vk.getChildCount()) {
                            if (vk.getChildAt(i4) instanceof AlaActiveBannerView) {
                                ((AlaActiveBannerView) vk.getChildAt(i4)).setLiveShowData(this.aED);
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
        if (this.hrq != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bN(i2, i);
            }
        }
    }

    public void bN(int i, int i2) {
        AlaActiveRootView vk;
        this.hrr.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bO = bO(i, i2);
        if (this.hrq != null && (vk = vk(i)) != null) {
            vk.setVisibility(bO);
        }
    }

    private int bO(int i, int i2) {
        if (this.hrr != null && this.hrr.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hrr.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void HE(String str) {
        if (f.QE().hB(str)) {
            bER();
        }
    }

    public void release() {
        this.aED = null;
        this.hrB = null;
        if (this.hru != null) {
            MessageManager.getInstance().unRegisterListener(this.hru);
            this.hru = null;
        }
        if (this.gPp != null) {
            MessageManager.getInstance().unRegisterListener(this.gPp);
            this.gPp = null;
        }
        if (this.hrv != null) {
            MessageManager.getInstance().unRegisterListener(this.hrv);
            this.hrv = null;
        }
        if (this.hrw != null) {
            this.hrw.removeCallbacksAndMessages(null);
        }
        f.QE().release();
        bYP();
        if (this.hrs != null) {
            this.hrs.clear();
        }
        if (this.hrq != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vk = vk(i);
                if (vk != null) {
                    vk.release();
                    co(vk);
                }
            }
            this.hrq.clear();
        }
        if (this.bif != null) {
            this.bif.release();
            this.bif = null;
        }
    }

    public void aW(boolean z) {
    }

    public void nI(boolean z) {
    }

    public void updateView() {
        if (this.hrq != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView vk = vk(i2);
                    if (vk != null) {
                        vk.setVisibility(bO(i2, this.hrr.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void cs(int i) {
        if (this.bif != null) {
            this.bif.cs(i);
        }
    }

    public void nJ(boolean z) {
        this.hrz = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bER() {
        if (this.aED != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.ae.d.QB().a(this.aED.aJZ.userId, this.aED.aJD.userId, this.aED.mLiveInfo.room_id, this.aED.mLiveInfo.live_id, this.aED.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZW() {
        if (this.mRunning) {
            if (this.hrw == null) {
                this.hrw = new HandlerC0661b(this);
            }
            if (this.hrx == null) {
                this.hrx = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bER();
                    }
                };
            }
            bZX();
            if (this.interval <= 0) {
                this.interval = 5;
            }
            this.hrw.postDelayed(this.hrx, this.interval * 1000);
        }
    }

    private void bZX() {
        if (this.hrw != null && this.hrx != null) {
            this.hrw.removeCallbacks(this.hrx);
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
                    if (tVar.aJw == null) {
                        tVar.aJw = new t.b();
                    }
                    if (tVar.aJw.pos == 0) {
                        tVar.aJw.pos = 1;
                    }
                    if (hashMap == null || (list2 = (List) hashMap.get(Integer.valueOf(tVar.aJw.pos))) == null || list2.size() < 5) {
                        if (tVar.picType == 0 && (tVar.aJw.width <= 0 || tVar.aJw.height <= 0)) {
                            t.b bVar = tVar.aJw;
                            t.b bVar2 = tVar.aJw;
                            int dimensionPixelOffset = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds120);
                            bVar2.width = dimensionPixelOffset;
                            bVar.height = dimensionPixelOffset;
                        }
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        List list3 = (List) hashMap.get(Integer.valueOf(tVar.aJw.pos));
                        if (list3 == null) {
                            list3 = new ArrayList();
                            hashMap.put(Integer.valueOf(tVar.aJw.pos), list3);
                        }
                        list3.add(tVar);
                        if (z2 || tVar.aJv == null) {
                            z = z2;
                        } else {
                            f.QE().b(tVar.aJv);
                            z = true;
                        }
                        z2 = z;
                    }
                }
            }
        }
        if (!z2) {
            f.QE().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            l(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private boolean a(t tVar) {
        boolean z = true;
        if (tVar != null && tVar.aJr == 1) {
            long j = tVar.serverTime;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j < tVar.showTime || j > tVar.end_time) {
                return false;
            }
            if (tVar.aJw == null || (tVar.aJw.pos >= 0 && tVar.aJw.pos <= 2)) {
                if (tVar.picType == 0) {
                    return !TextUtils.isEmpty(tVar.pic_url);
                } else if (tVar.picType == 3) {
                    if (TextUtils.isEmpty(tVar.webUrl) || tVar.aJw == null || tVar.aJw.width <= 0 || tVar.aJw.height <= 0) {
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
            bZY();
            vl(i);
            return;
        }
        if (this.hrs != null && (set = this.hrs.get(Integer.valueOf(i))) != null) {
            Iterator<t> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(Integer.valueOf(it.next().activityId))) {
                    it.remove();
                }
            }
        }
        boolean a2 = a(i, list, "");
        c cVar = this.hrp.get(Integer.valueOf(i));
        if (cVar != null && cVar.hrD != null && a2) {
            cVar.hrD.a(vk(i));
        }
        bZZ();
    }

    private void bZY() {
        if (this.hrA != null) {
            Iterator<com.baidu.live.i.b> it = this.hrt.iterator();
            while (it.hasNext()) {
                this.hrA.b(it.next());
            }
            this.hrt.clear();
            this.hrA.CX();
        }
    }

    private void bZZ() {
        if (this.hrA != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vk = vk(i);
                if (vk != null && vk.getVisibility() == 0 && vk.getChildCount() > 0 && !this.hrt.contains(vk)) {
                    this.hrt.add(vk);
                    this.hrA.a(vk);
                }
            }
            this.hrA.CX();
        }
    }

    public void a(com.baidu.live.i.a aVar) {
        this.hrA = aVar;
    }

    private AlaActiveRootView vj(int i) {
        c cVar;
        AlaActiveRootView vk;
        if (this.hrq == null || (vk = vk(i)) == null || vk.getParent() == null) {
            if (this.hrp != null && (cVar = this.hrp.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hrD;
                if (pendantParentView == null || this.hrq == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hrq.put(Integer.valueOf(i), alaActiveRootView);
                co(alaActiveRootView);
                pendantParentView.a(alaActiveRootView, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView;
            }
            return null;
        }
        return vk;
    }

    private void co(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView vk(int i) {
        if (this.hrq != null) {
            return this.hrq.get(Integer.valueOf(i));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, List<t> list, String str) {
        int i2;
        int i3 = 0;
        if (list == null || list.isEmpty()) {
            vl(i);
            return false;
        }
        AlaActiveRootView vk = vk(i);
        if (vk != null && vk.getChildCount() == 1) {
            View lastChild = vk.getLastChild();
            if ((lastChild instanceof AlaActiveBannerView) && ((AlaActiveBannerView) lastChild).cA(list)) {
                return false;
            }
        }
        vl(i);
        AlaActiveRootView vj = vj(i);
        if (vj != null) {
            Iterator<t> it = list.iterator();
            int i4 = 0;
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                t next = it.next();
                i3 = Math.max(i2, next.aJw.width);
                i4 = Math.max(i4, next.aJw.height);
            }
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(vj.getContext());
            alaActiveBannerView.setActivityContext(this.mPageContext.getPageActivity());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.setLiveShowData(this.aED);
            alaActiveBannerView.a(this.hre);
            alaActiveBannerView.setData(list, str);
            alaActiveBannerView.setPagerSize((int) TypedValue.applyDimension(1, i2, this.mPageContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, i4, this.mPageContext.getResources().getDisplayMetrics()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.hry || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.hry && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            }
            vj.addView(alaActiveBannerView, layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYQ() {
        if (Build.VERSION.SDK_INT >= 19) {
            Jy();
            if (this.hrw == null) {
                this.hrw = new HandlerC0661b(this);
            }
            if (!this.hrw.hasMessages(1000)) {
                this.hrw.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bYP() {
        if (this.hod != null) {
            this.hod.clear();
        }
        if (this.hrw != null) {
            this.hrw.removeMessages(1000);
        }
        Jz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYR() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hrq != null) {
            if (this.hod == null || (size = this.hod.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hod.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.hod.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView vk = vk(i2);
                if (vk != null) {
                    View lastChild = vk.getLastChild();
                    if (lastChild instanceof AlaActiveBannerView) {
                        z = ((AlaActiveBannerView) lastChild).HB(str) | z2;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.hrw.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bYP();
            }
        }
    }

    private void Jy() {
        if (this.hod == null) {
            this.hod = new ArrayList();
        }
        this.hod.clear();
        if (this.bmk == null) {
            this.bmk = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        b.this.hod.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.bmk);
    }

    private void Jz() {
        if (this.bmk != null) {
            MessageManager.getInstance().unRegisterListener(this.bmk);
            this.bmk = null;
        }
    }

    private void vl(int i) {
        AlaActiveRootView vk = vk(i);
        if (vk != null) {
            vk.release();
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
            if (this.aED != null) {
                if (this.aED.aJZ == null) {
                    str6 = null;
                } else if (i == 2) {
                    str6 = ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aED.aJZ.userId));
                } else {
                    str6 = String.valueOf(this.aED.aJZ.userId);
                }
                if (this.aED.aJD == null) {
                    str7 = null;
                } else if (i == 2) {
                    str7 = ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aED.aJD.userId));
                } else {
                    str7 = String.valueOf(this.aED.aJD.userId);
                }
                if (this.aED.mLiveInfo != null) {
                    str3 = String.valueOf(this.aED.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aED.mLiveInfo.live_id);
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
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.hrB);
            if (i == 2) {
                HF(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void HF(String str) {
        caa();
        cab();
        com.baidu.live.an.c cVar = new com.baidu.live.an.c();
        if (!this.hry) {
            cVar.bXS = 0.7f;
        } else {
            cVar.bXT = 1;
        }
        cVar.url = str;
        this.bif.a(cVar);
    }

    private void caa() {
        if (this.bif == null) {
            this.bif = new com.baidu.live.an.a(this.mPageContext.getPageActivity());
        }
    }

    private void cab() {
        this.bif.isHost = this.isHost;
        if (this.aED != null && this.aED.mLiveInfo != null) {
            this.bif.bXN = this.aED.mLiveInfo.user_id;
            this.bif.bXO = this.aED.mLiveInfo.getNameShow();
            this.bif.liveId = this.aED.mLiveInfo.live_id;
            if (this.aED.aJD != null) {
                this.bif.anchorPortrait = this.aED.aJD != null ? this.aED.aJD.portrait : null;
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
    public void vm(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hro)) {
                jSONArray = new JSONArray(this.hro);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hro = jSONArray.toString();
            com.baidu.live.d.xf().putString("ala_active_view_click_info", this.hro);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vn(int i) {
        if (StringUtils.isNull(this.hro)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hro);
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
    /* loaded from: classes10.dex */
    public static class c {
        PendantParentView hrD;

        c(PendantParentView pendantParentView) {
            this.hrD = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0661b extends Handler {
        private final WeakReference<b> hoi;

        HandlerC0661b(b bVar) {
            this.hoi = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hoi.get() != null && message.what == 1000) {
                this.hoi.get().bYR();
            }
        }
    }
}
