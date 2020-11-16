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
import com.baidu.live.aa.f;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ac;
import com.baidu.live.data.o;
import com.baidu.live.data.w;
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
    private w aDh;
    private int aIN;
    private long aWj;
    private List<String> gRt;
    private CustomMessageListener gRu;
    private com.baidu.tieba.ala.liveroom.a.c gUI;
    private SimpleArrayMap<Integer, Set<Integer>> gUN;
    private HttpMessageListener gUP;
    private CustomMessageListener gUQ;
    private HandlerC0666b gUR;
    private Runnable gUS;
    private boolean gUT;
    private boolean gUU;
    private com.baidu.live.g.a gUV;
    private String gUW;
    private TbPageContext mPageContext;
    private String otherParams;
    private String gUJ = "";
    private boolean isHost = false;
    private Map<Integer, c> gUK = new HashMap();
    private Map<Integer, AlaActiveRootView> gUL = new HashMap();
    private SimpleArrayMap<Integer, Integer> gUM = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> gUO = new ArrayList<>();
    private a gUz = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean vQ(int i) {
            return b.this.vQ(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, o oVar, int i) {
            b.this.a(view, oVar, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void c(View view, o oVar, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aWj >= 400) {
                b.this.aWj = currentTimeMillis;
                if (b.this.aDh != null && b.this.aDh.aHk != null && b.this.aDh.mLiveInfo != null) {
                    String str = oVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aDh != null && b.this.aDh.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aDh.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aDh.aHk.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aDh.aHk.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aDh.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aDh.aHk.portrait)) {
                                str2 = URLEncoder.encode(b.this.aDh.aHk.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vQ(oVar.aGX)) {
                        b.this.vP(oVar.aGX);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).vJ(i);
                        }
                    }
                    b.this.aW(oVar.aHc, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aDh.mLiveInfo != null) {
                        str3 = b.this.aDh.mLiveInfo.feed_id;
                        str4 = b.this.aDh.mLiveInfo.live_id + "";
                    }
                    b.this.b(oVar, str3, str4);
                    b.this.a(oVar, str3, str4);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void Hi(String str) {
            b.this.Hp(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void Hj(String str) {
            b.this.Hn(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void Hk(String str) {
            SchemeUtils.openScheme(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void bK(int i, int i2) {
            AlaActiveRootView vN = b.this.vN(i);
            if (vN != null) {
                for (int i3 = 0; i3 < vN.getChildCount(); i3++) {
                    if (vN.getChildAt(i3) instanceof AlaActiveBannerView) {
                        List<o> originDatas = ((AlaActiveBannerView) vN.getChildAt(i3)).getOriginDatas();
                        if (originDatas != null) {
                            ArrayList arrayList = new ArrayList(originDatas);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((o) it.next()).activityId == i2) {
                                    it.remove();
                                }
                            }
                            if (b.this.gUN == null) {
                                b.this.gUN = new SimpleArrayMap();
                            }
                            Set set = (Set) b.this.gUN.get(Integer.valueOf(i));
                            if (set == null) {
                                set = new HashSet();
                                b.this.gUN.put(Integer.valueOf(i), set);
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
        public void mF(boolean z) {
            if (z) {
                b.this.bVg();
            }
        }
    };
    private CustomMessageListener guV = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.gUL != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView vN = b.this.vN(i2);
                            if (vN != null) {
                                View lastChild = vN.getLastChild();
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
        void Hi(String str);

        void Hj(String str);

        void Hk(String str);

        void b(View view, o oVar, int i);

        void bK(int i, int i2);

        void c(View view, o oVar, int i);

        void mF(boolean z);

        boolean vQ(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.gUM.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.guV);
    }

    public void Hm(String str) {
        this.gUW = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(w wVar, boolean z) {
        this.gUT = z;
        for (int i = 1; i <= 2; i++) {
            vO(i);
        }
        if (this.gUK != null) {
            this.gUK.clear();
        }
        i(wVar);
        if (this.aDh != null) {
            this.gUJ = com.baidu.live.d.Aq().getString("ala_active_view_click_info", "");
            bWk();
            bWl();
            bCq();
        }
    }

    public void F(com.baidu.live.im.data.a aVar) {
        JSONObject jSONObject;
        if (aVar != null && aVar.getMsgType() == 13) {
            try {
                if (aVar.getObjContent() instanceof JSONObject) {
                    jSONObject = (JSONObject) aVar.getObjContent();
                } else {
                    jSONObject = new JSONObject(aVar.getContent());
                }
                if (jSONObject != null && "fullscreen".equals(jSONObject.optString("content_type")) && G(aVar)) {
                    Hn(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.gUU) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            bWq();
            bWr();
            this.gUI.Hh(str);
        }
    }

    private boolean G(com.baidu.live.im.data.a aVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> LH = aVar.LH();
        return ListUtils.isEmpty(LH) || LH.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.gUK.put(Integer.valueOf(i), new c(pendantParentView));
            vM(i);
        }
    }

    private void bWk() {
        if (this.gUP == null) {
            this.gUP = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aDh == null || b.this.aDh.mLiveInfo == null || b.this.aDh.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aDh.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bWm();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.NA() != null) {
                                b.this.aIN = getLiveActivityHttpResponseMessage.NA().aIN;
                                b.this.cv(getLiveActivityHttpResponseMessage.NA().aNy);
                                b.this.e(getLiveActivityHttpResponseMessage.NA().aNz);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gUP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ac acVar) {
        if (acVar == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo == null ");
        } else if (acVar.DH() == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo.getUrlDataParams() == null");
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913257, acVar));
        }
    }

    private void bWl() {
        if (this.gUQ == null) {
            this.gUQ = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.Hp((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gUQ);
    }

    public void onStart() {
        this.mRunning = true;
        if (this.gUL != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vN = vN(i);
                if (vN != null) {
                    vN.onStart();
                }
            }
        }
        bVh();
        if (this.gUI != null) {
            this.gUI.resume();
        }
        bCq();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.gUL != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vN = vN(i);
                if (vN != null) {
                    vN.onStop();
                }
            }
        }
        if (this.gUI != null) {
            this.gUI.pause();
        }
        bWn();
        bVe();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void i(w wVar) {
        this.aDh = wVar;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                AlaActiveRootView vN = vN(i2);
                if (vN != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < vN.getChildCount()) {
                            if (vN.getChildAt(i4) instanceof AlaActiveBannerView) {
                                ((AlaActiveBannerView) vN.getChildAt(i4)).setLiveShowData(this.aDh);
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
        if (this.gUL != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bM(i2, i);
            }
        }
    }

    public void bM(int i, int i2) {
        AlaActiveRootView vN;
        this.gUM.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bN = bN(i, i2);
        if (this.gUL != null && (vN = vN(i)) != null) {
            vN.setVisibility(bN);
        }
    }

    private int bN(int i, int i2) {
        if (this.gUM != null && this.gUM.get(Integer.valueOf(i)).intValue() != 0) {
            return this.gUM.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void Ho(String str) {
        if (f.Px().hT(str)) {
            bCq();
        }
    }

    public void release() {
        this.aDh = null;
        this.gUW = null;
        if (this.gUP != null) {
            MessageManager.getInstance().unRegisterListener(this.gUP);
            this.gUP = null;
        }
        if (this.guV != null) {
            MessageManager.getInstance().unRegisterListener(this.guV);
            this.guV = null;
        }
        if (this.gUQ != null) {
            MessageManager.getInstance().unRegisterListener(this.gUQ);
            this.gUQ = null;
        }
        if (this.gUR != null) {
            this.gUR.removeCallbacksAndMessages(null);
        }
        f.Px().release();
        bVe();
        if (this.gUN != null) {
            this.gUN.clear();
        }
        if (this.gUL != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vN = vN(i);
                if (vN != null) {
                    vN.release();
                    cc(vN);
                }
            }
            this.gUL.clear();
        }
        if (this.gUI != null) {
            this.gUI.release();
            this.gUI = null;
        }
    }

    public void mH(boolean z) {
    }

    public void mI(boolean z) {
    }

    public void updateView() {
        if (this.gUL != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView vN = vN(i2);
                    if (vN != null) {
                        vN.setVisibility(bN(i2, this.gUM.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dE(int i) {
        if (this.gUI != null) {
            this.gUI.dE(i);
        }
    }

    public void mJ(boolean z) {
        this.gUU = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCq() {
        if (this.aDh != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.aa.d.Pu().a(this.aDh.aHG.userId, this.aDh.aHk.userId, this.aDh.mLiveInfo.room_id, this.aDh.mLiveInfo.live_id, this.aDh.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWm() {
        if (this.mRunning) {
            if (this.gUR == null) {
                this.gUR = new HandlerC0666b(this);
            }
            if (this.gUS == null) {
                this.gUS = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bCq();
                    }
                };
            }
            bWn();
            if (this.aIN <= 0) {
                this.aIN = 5;
            }
            this.gUR.postDelayed(this.gUS, this.aIN * 1000);
        }
    }

    private void bWn() {
        if (this.gUR != null && this.gUS != null) {
            this.gUR.removeCallbacks(this.gUS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(List<o> list) {
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
                    if (oVar.aHe == null) {
                        oVar.aHe = new o.b();
                    }
                    if (oVar.aHe.pos == 0) {
                        oVar.aHe.pos = 1;
                    }
                    if (hashMap == null || (list2 = (List) hashMap.get(Integer.valueOf(oVar.aHe.pos))) == null || list2.size() < 5) {
                        if (oVar.picType == 0 && (oVar.aHe.width <= 0 || oVar.aHe.height <= 0)) {
                            o.b bVar = oVar.aHe;
                            o.b bVar2 = oVar.aHe;
                            int dimensionPixelOffset = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds120);
                            bVar2.width = dimensionPixelOffset;
                            bVar.height = dimensionPixelOffset;
                        }
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        List list3 = (List) hashMap.get(Integer.valueOf(oVar.aHe.pos));
                        if (list3 == null) {
                            list3 = new ArrayList();
                            hashMap.put(Integer.valueOf(oVar.aHe.pos), list3);
                        }
                        list3.add(oVar);
                        if (z2 || oVar.aHd == null) {
                            z = z2;
                        } else {
                            f.Px().b(oVar.aHd);
                            z = true;
                        }
                        z2 = z;
                    }
                }
            }
        }
        if (!z2) {
            f.Px().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private boolean a(o oVar) {
        boolean z = true;
        if (oVar != null && oVar.aGZ == 1) {
            long j = oVar.serverTime;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j < oVar.showTime || j > oVar.end_time) {
                return false;
            }
            if (oVar.aHe == null || (oVar.aHe.pos >= 0 && oVar.aHe.pos <= 2)) {
                if (oVar.picType == 0) {
                    return !TextUtils.isEmpty(oVar.pic_url);
                } else if (oVar.picType == 3) {
                    if (TextUtils.isEmpty(oVar.webUrl) || oVar.aHe == null || oVar.aHe.width <= 0 || oVar.aHe.height <= 0) {
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
            bWo();
            vO(i);
            return;
        }
        if (this.gUN != null && (set = this.gUN.get(Integer.valueOf(i))) != null) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(Integer.valueOf(it.next().activityId))) {
                    it.remove();
                }
            }
        }
        boolean a2 = a(i, list, "");
        c cVar = this.gUK.get(Integer.valueOf(i));
        if (cVar != null && cVar.gUY != null && a2) {
            cVar.gUY.a(vN(i));
        }
        bWp();
    }

    private void bWo() {
        if (this.gUV != null) {
            Iterator<com.baidu.live.g.b> it = this.gUO.iterator();
            while (it.hasNext()) {
                this.gUV.b(it.next());
            }
            this.gUO.clear();
            this.gUV.Ew();
        }
    }

    private void bWp() {
        if (this.gUV != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vN = vN(i);
                if (vN != null && vN.getVisibility() == 0 && vN.getChildCount() > 0 && !this.gUO.contains(vN)) {
                    this.gUO.add(vN);
                    this.gUV.a(vN);
                }
            }
            this.gUV.Ew();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.gUV = aVar;
    }

    private AlaActiveRootView vM(int i) {
        c cVar;
        AlaActiveRootView vN;
        if (this.gUL == null || (vN = vN(i)) == null || vN.getParent() == null) {
            if (this.gUK != null && (cVar = this.gUK.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.gUY;
                if (pendantParentView == null || this.gUL == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView = new AlaActiveRootView(i, pendantParentView.getContext());
                this.gUL.put(Integer.valueOf(i), alaActiveRootView);
                cc(alaActiveRootView);
                pendantParentView.a(alaActiveRootView, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView;
            }
            return null;
        }
        return vN;
    }

    private void cc(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView vN(int i) {
        if (this.gUL != null) {
            return this.gUL.get(Integer.valueOf(i));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, List<o> list, String str) {
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            vO(i);
            return false;
        }
        AlaActiveRootView vN = vN(i);
        if (vN != null && vN.getChildCount() == 1) {
            View lastChild = vN.getLastChild();
            if ((lastChild instanceof AlaActiveBannerView) && ((AlaActiveBannerView) lastChild).cu(list)) {
                return false;
            }
        }
        vO(i);
        AlaActiveRootView vM = vM(i);
        if (vM != null) {
            int i3 = 0;
            for (o oVar : list) {
                i3 = Math.max(i3, oVar.aHe.width);
                i2 = Math.max(i2, oVar.aHe.height);
            }
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(vM.getContext());
            alaActiveBannerView.setActivityContext(this.mPageContext.getPageActivity());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.setLiveShowData(this.aDh);
            alaActiveBannerView.a(this.gUz);
            alaActiveBannerView.i(list, str);
            alaActiveBannerView.bL((int) TypedValue.applyDimension(1, i3, this.mPageContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, i2, this.mPageContext.getResources().getDisplayMetrics()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.gUT || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.gUT && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            }
            vM.addView(alaActiveBannerView, layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVg() {
        if (Build.VERSION.SDK_INT >= 19) {
            bVi();
            if (this.gUR == null) {
                this.gUR = new HandlerC0666b(this);
            }
            if (!this.gUR.hasMessages(1000)) {
                this.gUR.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bVe() {
        if (this.gRt != null) {
            this.gRt.clear();
        }
        if (this.gUR != null) {
            this.gUR.removeMessages(1000);
        }
        bVf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVh() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.gUL != null) {
            if (this.gRt == null || (size = this.gRt.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gRt.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.gRt.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView vN = vN(i2);
                if (vN != null) {
                    View lastChild = vN.getLastChild();
                    if (lastChild instanceof AlaActiveBannerView) {
                        z = ((AlaActiveBannerView) lastChild).Hl(str) | z2;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.gUR.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bVe();
            }
        }
    }

    private void bVi() {
        if (this.gRt == null) {
            this.gRt = new ArrayList();
        }
        this.gRt.clear();
        if (this.gRu == null) {
            this.gRu = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        b.this.gRt.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gRu);
    }

    private void bVf() {
        if (this.gRu != null) {
            MessageManager.getInstance().unRegisterListener(this.gRu);
            this.gRu = null;
        }
    }

    private void vO(int i) {
        AlaActiveRootView vN = vN(i);
        if (vN != null) {
            vN.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.aDh != null) {
                String valueOf = this.aDh.aHG != null ? String.valueOf(this.aDh.aHG.userId) : null;
                String valueOf2 = this.aDh.aHk != null ? String.valueOf(this.aDh.aHk.userId) : null;
                if (this.aDh.mLiveInfo != null) {
                    str3 = String.valueOf(this.aDh.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aDh.mLiveInfo.live_id);
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
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.gUW);
            if (i == 2) {
                Hp(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void Hp(String str) {
        int i = 2;
        bWq();
        bWr();
        if (!this.gUT) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.gUI.aF(str, i);
    }

    private void bWq() {
        if (this.gUI == null) {
            this.gUI = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void bWr() {
        this.gUI.setHost(this.isHost);
        if (this.aDh != null && this.aDh.mLiveInfo != null) {
            this.gUI.e(this.aDh.mLiveInfo.user_id, this.aDh.mLiveInfo.getNameShow(), this.aDh.aHk != null ? this.aDh.aHk.portrait : null);
            this.gUI.setLiveId(this.aDh.mLiveInfo.live_id);
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
    public void vP(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.gUJ)) {
                jSONArray = new JSONArray(this.gUJ);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.gUJ = jSONArray.toString();
            com.baidu.live.d.Aq().putString("ala_active_view_click_info", this.gUJ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vQ(int i) {
        if (StringUtils.isNull(this.gUJ)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.gUJ);
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
        PendantParentView gUY;

        c(PendantParentView pendantParentView) {
            this.gUY = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0666b extends Handler {
        private final WeakReference<b> gRD;

        HandlerC0666b(b bVar) {
            this.gRD = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gRD.get() != null && message.what == 1000) {
                this.gRD.get().bVh();
            }
        }
    }
}
