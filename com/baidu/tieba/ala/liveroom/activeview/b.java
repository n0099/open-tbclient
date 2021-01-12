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
/* loaded from: classes10.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private x aBr;
    private int aHx;
    private long aWs;
    private List<String> hhR;
    private CustomMessageListener hhS;
    private com.baidu.tieba.ala.liveroom.a.c hlc;
    private SimpleArrayMap<Integer, Set<Integer>> hlh;
    private HttpMessageListener hlj;
    private CustomMessageListener hlk;
    private HandlerC0654b hll;
    private Runnable hlm;
    private boolean hln;
    private boolean hlo;
    private com.baidu.live.j.a hlp;
    private String hlq;
    private TbPageContext mPageContext;
    private String otherParams;
    private String hld = "";
    private boolean isHost = false;
    private Map<Integer, c> hle = new HashMap();
    private Map<Integer, AlaActiveRootView> hlf = new HashMap();
    private SimpleArrayMap<Integer, Integer> hlg = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.j.b> hli = new ArrayList<>();
    private a hkU = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean va(int i) {
            return b.this.va(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, p pVar, int i) {
            b.this.a(view, pVar, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void c(View view, p pVar, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aWs >= 400) {
                b.this.aWs = currentTimeMillis;
                if (b.this.aBr != null && b.this.aBr.aFH != null && b.this.aBr.mLiveInfo != null) {
                    String str = pVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aBr != null && b.this.aBr.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aBr.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aBr.aFH.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aBr.aFH.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aBr.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aBr.aFH.portrait)) {
                                str2 = URLEncoder.encode(b.this.aBr.aFH.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!va(pVar.aFt)) {
                        b.this.uZ(pVar.aFt);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).uT(i);
                        }
                    }
                    b.this.aZ(pVar.aFy, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aBr.mLiveInfo != null) {
                        str3 = b.this.aBr.mLiveInfo.feed_id;
                        str4 = b.this.aBr.mLiveInfo.live_id + "";
                    }
                    b.this.b(pVar, str3, str4);
                    b.this.a(pVar, str3, str4);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void GK(String str) {
            b.this.GR(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void GL(String str) {
            b.this.GP(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void GM(String str) {
            SchemeUtils.openScheme(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void bN(int i, int i2) {
            AlaActiveRootView uX = b.this.uX(i);
            if (uX != null) {
                for (int i3 = 0; i3 < uX.getChildCount(); i3++) {
                    if (uX.getChildAt(i3) instanceof AlaActiveBannerView) {
                        List<p> originDatas = ((AlaActiveBannerView) uX.getChildAt(i3)).getOriginDatas();
                        if (originDatas != null) {
                            ArrayList arrayList = new ArrayList(originDatas);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((p) it.next()).activityId == i2) {
                                    it.remove();
                                }
                            }
                            if (b.this.hlh == null) {
                                b.this.hlh = new SimpleArrayMap();
                            }
                            Set set = (Set) b.this.hlh.get(Integer.valueOf(i));
                            if (set == null) {
                                set = new HashSet();
                                b.this.hlh.put(Integer.valueOf(i), set);
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
        public void nv(boolean z) {
            if (z) {
                b.this.bXE();
            }
        }
    };
    private CustomMessageListener gKM = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.hlf != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView uX = b.this.uX(i2);
                            if (uX != null) {
                                View lastChild = uX.getLastChild();
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
        void GK(String str);

        void GL(String str);

        void GM(String str);

        void b(View view, p pVar, int i);

        void bN(int i, int i2);

        void c(View view, p pVar, int i);

        void nv(boolean z);

        boolean va(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.hlg.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gKM);
    }

    public void GO(String str) {
        this.hlq = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void c(x xVar, boolean z) {
        this.hln = z;
        for (int i = 1; i <= 2; i++) {
            uY(i);
        }
        if (this.hle != null) {
            this.hle.clear();
        }
        j(xVar);
        if (this.aBr != null) {
            this.hld = com.baidu.live.d.xf().getString("ala_active_view_click_info", "");
            bYL();
            bYM();
            bEv();
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
                    GP(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.hlo) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            bYR();
            bYS();
            this.hlc.GJ(str);
        }
    }

    private boolean J(com.baidu.live.im.data.b bVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> JD = bVar.JD();
        return ListUtils.isEmpty(JD) || JD.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.hle.put(Integer.valueOf(i), new c(pendantParentView));
            uW(i);
        }
    }

    private void bYL() {
        if (this.hlj == null) {
            this.hlj = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aBr == null || b.this.aBr.mLiveInfo == null || b.this.aBr.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aBr.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bYN();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.MX() != null) {
                                b.this.aHx = getLiveActivityHttpResponseMessage.MX().aHx;
                                b.this.cG(getLiveActivityHttpResponseMessage.MX().aMz);
                                b.this.e(getLiveActivityHttpResponseMessage.MX().aMA);
                                b.this.a(getLiveActivityHttpResponseMessage.MX().aMB);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hlj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ae aeVar) {
        if (aeVar == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo == null ");
        } else if (aeVar.AN() == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo.getUrlDataParams() == null");
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913257, aeVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(z zVar) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913275, zVar));
    }

    private void bYM() {
        if (this.hlk == null) {
            this.hlk = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.GR((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hlk);
    }

    public void onStart() {
        this.mRunning = true;
        if (this.hlf != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView uX = uX(i);
                if (uX != null) {
                    uX.onStart();
                }
            }
        }
        bXF();
        if (this.hlc != null) {
            this.hlc.resume();
        }
        bEv();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.hlf != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView uX = uX(i);
                if (uX != null) {
                    uX.onStop();
                }
            }
        }
        if (this.hlc != null) {
            this.hlc.pause();
        }
        bYO();
        bXC();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(x xVar) {
        this.aBr = xVar;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                AlaActiveRootView uX = uX(i2);
                if (uX != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < uX.getChildCount()) {
                            if (uX.getChildAt(i4) instanceof AlaActiveBannerView) {
                                ((AlaActiveBannerView) uX.getChildAt(i4)).setLiveShowData(this.aBr);
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
        if (this.hlf != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bP(i2, i);
            }
        }
    }

    public void bP(int i, int i2) {
        AlaActiveRootView uX;
        this.hlg.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bQ = bQ(i, i2);
        if (this.hlf != null && (uX = uX(i)) != null) {
            uX.setVisibility(bQ);
        }
    }

    private int bQ(int i, int i2) {
        if (this.hlg != null && this.hlg.get(Integer.valueOf(i)).intValue() != 0) {
            return this.hlg.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void GQ(String str) {
        if (f.Pa().gZ(str)) {
            bEv();
        }
    }

    public void release() {
        this.aBr = null;
        this.hlq = null;
        if (this.hlj != null) {
            MessageManager.getInstance().unRegisterListener(this.hlj);
            this.hlj = null;
        }
        if (this.gKM != null) {
            MessageManager.getInstance().unRegisterListener(this.gKM);
            this.gKM = null;
        }
        if (this.hlk != null) {
            MessageManager.getInstance().unRegisterListener(this.hlk);
            this.hlk = null;
        }
        if (this.hll != null) {
            this.hll.removeCallbacksAndMessages(null);
        }
        f.Pa().release();
        bXC();
        if (this.hlh != null) {
            this.hlh.clear();
        }
        if (this.hlf != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView uX = uX(i);
                if (uX != null) {
                    uX.release();
                    cs(uX);
                }
            }
            this.hlf.clear();
        }
        if (this.hlc != null) {
            this.hlc.release();
            this.hlc = null;
        }
    }

    public void aW(boolean z) {
    }

    public void nx(boolean z) {
    }

    public void updateView() {
        if (this.hlf != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView uX = uX(i2);
                    if (uX != null) {
                        uX.setVisibility(bQ(i2, this.hlg.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void co(int i) {
        if (this.hlc != null) {
            this.hlc.co(i);
        }
    }

    public void ny(boolean z) {
        this.hlo = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEv() {
        if (this.aBr != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.af.d.OX().a(this.aBr.aGd.userId, this.aBr.aFH.userId, this.aBr.mLiveInfo.room_id, this.aBr.mLiveInfo.live_id, this.aBr.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYN() {
        if (this.mRunning) {
            if (this.hll == null) {
                this.hll = new HandlerC0654b(this);
            }
            if (this.hlm == null) {
                this.hlm = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bEv();
                    }
                };
            }
            bYO();
            if (this.aHx <= 0) {
                this.aHx = 5;
            }
            this.hll.postDelayed(this.hlm, this.aHx * 1000);
        }
    }

    private void bYO() {
        if (this.hll != null && this.hlm != null) {
            this.hll.removeCallbacks(this.hlm);
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
                    if (pVar.aFA == null) {
                        pVar.aFA = new p.b();
                    }
                    if (pVar.aFA.pos == 0) {
                        pVar.aFA.pos = 1;
                    }
                    if (hashMap == null || (list2 = (List) hashMap.get(Integer.valueOf(pVar.aFA.pos))) == null || list2.size() < 5) {
                        if (pVar.picType == 0 && (pVar.aFA.width <= 0 || pVar.aFA.height <= 0)) {
                            p.b bVar = pVar.aFA;
                            p.b bVar2 = pVar.aFA;
                            int dimensionPixelOffset = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds120);
                            bVar2.width = dimensionPixelOffset;
                            bVar.height = dimensionPixelOffset;
                        }
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        List list3 = (List) hashMap.get(Integer.valueOf(pVar.aFA.pos));
                        if (list3 == null) {
                            list3 = new ArrayList();
                            hashMap.put(Integer.valueOf(pVar.aFA.pos), list3);
                        }
                        list3.add(pVar);
                        if (z2 || pVar.aFz == null) {
                            z = z2;
                        } else {
                            f.Pa().b(pVar.aFz);
                            z = true;
                        }
                        z2 = z;
                    }
                }
            }
        }
        if (!z2) {
            f.Pa().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private boolean a(p pVar) {
        boolean z = true;
        if (pVar != null && pVar.aFv == 1) {
            long j = pVar.serverTime;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j < pVar.showTime || j > pVar.end_time) {
                return false;
            }
            if (pVar.aFA == null || (pVar.aFA.pos >= 0 && pVar.aFA.pos <= 2)) {
                if (pVar.picType == 0) {
                    return !TextUtils.isEmpty(pVar.pic_url);
                } else if (pVar.picType == 3) {
                    if (TextUtils.isEmpty(pVar.webUrl) || pVar.aFA == null || pVar.aFA.width <= 0 || pVar.aFA.height <= 0) {
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
            bYP();
            uY(i);
            return;
        }
        if (this.hlh != null && (set = this.hlh.get(Integer.valueOf(i))) != null) {
            Iterator<p> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(Integer.valueOf(it.next().activityId))) {
                    it.remove();
                }
            }
        }
        boolean a2 = a(i, list, "");
        c cVar = this.hle.get(Integer.valueOf(i));
        if (cVar != null && cVar.hls != null && a2) {
            cVar.hls.a(uX(i));
        }
        bYQ();
    }

    private void bYP() {
        if (this.hlp != null) {
            Iterator<com.baidu.live.j.b> it = this.hli.iterator();
            while (it.hasNext()) {
                this.hlp.b(it.next());
            }
            this.hli.clear();
            this.hlp.BF();
        }
    }

    private void bYQ() {
        if (this.hlp != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView uX = uX(i);
                if (uX != null && uX.getVisibility() == 0 && uX.getChildCount() > 0 && !this.hli.contains(uX)) {
                    this.hli.add(uX);
                    this.hlp.a(uX);
                }
            }
            this.hlp.BF();
        }
    }

    public void a(com.baidu.live.j.a aVar) {
        this.hlp = aVar;
    }

    private AlaActiveRootView uW(int i) {
        c cVar;
        AlaActiveRootView uX;
        if (this.hlf == null || (uX = uX(i)) == null || uX.getParent() == null) {
            if (this.hle != null && (cVar = this.hle.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.hls;
                if (pendantParentView == null || this.hlf == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView = new AlaActiveRootView(i, pendantParentView.getContext());
                this.hlf.put(Integer.valueOf(i), alaActiveRootView);
                cs(alaActiveRootView);
                pendantParentView.a(alaActiveRootView, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView;
            }
            return null;
        }
        return uX;
    }

    private void cs(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView uX(int i) {
        if (this.hlf != null) {
            return this.hlf.get(Integer.valueOf(i));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, List<p> list, String str) {
        int i2;
        int i3 = 0;
        if (list == null || list.isEmpty()) {
            uY(i);
            return false;
        }
        AlaActiveRootView uX = uX(i);
        if (uX != null && uX.getChildCount() == 1) {
            View lastChild = uX.getLastChild();
            if ((lastChild instanceof AlaActiveBannerView) && ((AlaActiveBannerView) lastChild).cF(list)) {
                return false;
            }
        }
        uY(i);
        AlaActiveRootView uW = uW(i);
        if (uW != null) {
            Iterator<p> it = list.iterator();
            int i4 = 0;
            while (true) {
                i2 = i3;
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                i3 = Math.max(i2, next.aFA.width);
                i4 = Math.max(i4, next.aFA.height);
            }
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(uW.getContext());
            alaActiveBannerView.setActivityContext(this.mPageContext.getPageActivity());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.setLiveShowData(this.aBr);
            alaActiveBannerView.a(this.hkU);
            alaActiveBannerView.j(list, str);
            alaActiveBannerView.bO((int) TypedValue.applyDimension(1, i2, this.mPageContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, i4, this.mPageContext.getResources().getDisplayMetrics()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.hln || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.hln && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            }
            uW.addView(alaActiveBannerView, layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXE() {
        if (Build.VERSION.SDK_INT >= 19) {
            bXG();
            if (this.hll == null) {
                this.hll = new HandlerC0654b(this);
            }
            if (!this.hll.hasMessages(1000)) {
                this.hll.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bXC() {
        if (this.hhR != null) {
            this.hhR.clear();
        }
        if (this.hll != null) {
            this.hll.removeMessages(1000);
        }
        bXD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXF() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.hlf != null) {
            if (this.hhR == null || (size = this.hhR.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.hhR.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.hhR.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView uX = uX(i2);
                if (uX != null) {
                    View lastChild = uX.getLastChild();
                    if (lastChild instanceof AlaActiveBannerView) {
                        z = ((AlaActiveBannerView) lastChild).GN(str) | z2;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.hll.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bXC();
            }
        }
    }

    private void bXG() {
        if (this.hhR == null) {
            this.hhR = new ArrayList();
        }
        this.hhR.clear();
        if (this.hhS == null) {
            this.hhS = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        b.this.hhR.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.hhS);
    }

    private void bXD() {
        if (this.hhS != null) {
            MessageManager.getInstance().unRegisterListener(this.hhS);
            this.hhS = null;
        }
    }

    private void uY(int i) {
        AlaActiveRootView uX = uX(i);
        if (uX != null) {
            uX.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        if (!TextUtils.isEmpty(str)) {
            if (this.aBr != null) {
                if (this.aBr.aGd == null) {
                    str6 = null;
                } else if (i == 2) {
                    str6 = ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aBr.aGd.userId));
                } else {
                    str6 = String.valueOf(this.aBr.aGd.userId);
                }
                if (this.aBr.aFH == null) {
                    str7 = null;
                } else if (i == 2) {
                    str7 = ExtraParamsManager.getEncryptionUserId(String.valueOf(this.aBr.aFH.userId));
                } else {
                    str7 = String.valueOf(this.aBr.aFH.userId);
                }
                if (this.aBr.mLiveInfo != null) {
                    str3 = String.valueOf(this.aBr.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aBr.mLiveInfo.live_id);
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
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.hlq);
            if (i == 2) {
                GR(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void GR(String str) {
        int i = 2;
        bYR();
        bYS();
        if (!this.hln) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.hlc.aI(str, i);
    }

    private void bYR() {
        if (this.hlc == null) {
            this.hlc = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void bYS() {
        this.hlc.setHost(this.isHost);
        if (this.aBr != null && this.aBr.mLiveInfo != null) {
            this.hlc.g(this.aBr.mLiveInfo.user_id, this.aBr.mLiveInfo.getNameShow(), this.aBr.aFH != null ? this.aBr.aFH.portrait : null);
            this.hlc.setLiveId(this.aBr.mLiveInfo.live_id);
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
    public void uZ(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.hld)) {
                jSONArray = new JSONArray(this.hld);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.hld = jSONArray.toString();
            com.baidu.live.d.xf().putString("ala_active_view_click_info", this.hld);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean va(int i) {
        if (StringUtils.isNull(this.hld)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.hld);
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
        PendantParentView hls;

        c(PendantParentView pendantParentView) {
            this.hls = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class HandlerC0654b extends Handler {
        private final WeakReference<b> hhX;

        HandlerC0654b(b bVar) {
            this.hhX = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.hhX.get() != null && message.what == 1000) {
                this.hhX.get().bXF();
            }
        }
    }
}
