package com.baidu.tieba.ala.liveroom.activeview;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.aj;
import com.baidu.live.data.ak;
import com.baidu.live.data.e;
import com.baidu.live.data.l;
import com.baidu.live.message.GetLiveActivityDynamicHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.r.a;
import com.baidu.live.s.d;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView;
import com.baidu.webkit.internal.ETAG;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes2.dex */
public class b implements com.baidu.live.liveroom.a.a {
    private int aaz;
    private long agy;
    private l aiW;
    private com.baidu.tieba.ala.liveroom.a.c eLG;
    private Map<Integer, c> eLI;
    private Map<Integer, AlaActiveRootView> eLJ;
    private HttpMessageListener eLL;
    private HttpMessageListener eLM;
    private CustomMessageListener eLN;
    private CustomMessageListener eLO;
    private HandlerC0442b eLP;
    private Runnable eLQ;
    private List<String> eLR;
    private boolean eLS;
    private boolean eLT;
    private com.baidu.live.g.a eLU;
    private TbPageContext mPageContext;
    private String otherParams;
    private String eLH = "";
    private boolean isHost = false;
    private ArrayList<com.baidu.live.g.b> eLK = new ArrayList<>();
    private g aCr = new g() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
        @Override // com.baidu.live.view.web.g
        public void eb(String str) {
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                String queryParameter = Uri.parse(str).getQueryParameter("room");
                if (TextUtils.isEmpty(queryParameter)) {
                    int indexOf = str.indexOf("room=");
                    int length = "room".length() + 1;
                    if (indexOf >= 0 && indexOf + length + 1 <= str.length()) {
                        queryParameter = str.substring(indexOf + length, indexOf + length + 1);
                    }
                }
                if (!TextUtils.isEmpty(queryParameter)) {
                    try {
                        z = Integer.parseInt(queryParameter) == 1;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (z) {
                    b.this.yq(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a eLc = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.10
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean pG(int i) {
            return b.this.pG(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.agy >= 400) {
                b.this.agy = currentTimeMillis;
                if ((obj instanceof e) && b.this.aiW != null && b.this.aiW.Wf != null && b.this.aiW.mLiveInfo != null) {
                    e eVar = (e) obj;
                    String str = eVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aiW != null && b.this.aiW.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aiW.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aiW.Wf.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aiW.Wf.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aiW.mLiveInfo.live_id);
                        sb.append("&_loc_portrait=");
                        sb.append(b.this.aiW.Wf.portrait);
                    }
                    if (!pG(eVar.VS)) {
                        b.this.pF(eVar.VS);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).pz(i);
                        } else if ((view instanceof AlaActiveDynamicView) && eVar.VJ && b.this.eLc.pG(eVar.VS)) {
                            eVar.VJ = false;
                        }
                    }
                    b.this.al(eVar.VX, sb.toString());
                    String str2 = "";
                    String str3 = "";
                    if (b.this.aiW.mLiveInfo != null) {
                        str2 = b.this.aiW.mLiveInfo.feed_id;
                        str3 = b.this.aiW.mLiveInfo.live_id + "";
                    }
                    b.this.a(eVar, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener erA = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.eLJ != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.eLJ.get(Integer.valueOf(i2));
                            if (alaActiveRootView != null) {
                                View lastChild = alaActiveRootView.getLastChild();
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

    /* loaded from: classes2.dex */
    public interface a {
        void a(View view, Object obj, int i);

        boolean pG(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.erA);
    }

    @Override // com.baidu.live.liveroom.a.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(l lVar, boolean z) {
        this.eLT = z;
        for (int i = 1; i <= 2; i++) {
            pE(i);
        }
        if (this.eLI != null) {
            this.eLI.clear();
        }
        g(lVar);
        if (this.aiW != null) {
            this.eLH = com.baidu.live.c.oJ().getString("ala_active_view_click_info", "");
            bfG();
            bfH();
            bfI();
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.eLI == null) {
            this.eLI = new HashMap();
        }
        this.eLI.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        pC(i);
    }

    private void bfG() {
        this.eLL = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.aiW == null || b.this.aiW.mLiveInfo == null || b.this.aiW.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aiW.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.bfJ();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.wD() != null) {
                            b.this.aaz = getLiveActivityHttpResponseMessage.wD().aaz;
                            b.this.a(getLiveActivityHttpResponseMessage.wD());
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eLL);
    }

    private void bfH() {
        this.eLO = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    b.this.yq((String) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eLO);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.eLJ != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.eLJ.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.eLJ != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.eLJ.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bfT()) {
                        bfN();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.eLG != null) {
            this.eLG.resume();
        }
        bfI();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.eLJ != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.eLJ.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.eLG != null) {
            this.eLG.pause();
        }
        bfK();
        bfO();
    }

    @Override // com.baidu.live.liveroom.a.a
    public void g(l lVar) {
        this.aiW = lVar;
    }

    public void setVisible(int i) {
        if (this.eLS) {
            i = 8;
        }
        if (this.eLJ != null) {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.eLJ.get(Integer.valueOf(i3));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(i);
                    }
                    i2 = i3 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void bj(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        if (this.eLS) {
            i2 = 8;
        }
        if (this.eLJ != null && (alaActiveRootView = this.eLJ.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(i2);
        }
    }

    public void yp(String str) {
        if (d.wY().dJ(str)) {
            bfI();
        }
    }

    public void release() {
        this.aiW = null;
        if (this.eLL != null) {
            MessageManager.getInstance().unRegisterListener(this.eLL);
            this.eLL = null;
        }
        if (this.eLM != null) {
            MessageManager.getInstance().unRegisterListener(this.eLM);
            this.eLM = null;
        }
        if (this.erA != null) {
            MessageManager.getInstance().unRegisterListener(this.erA);
            this.erA = null;
        }
        if (this.eLO != null) {
            MessageManager.getInstance().unRegisterListener(this.eLO);
            this.eLO = null;
        }
        if (this.eLP != null) {
            this.eLP.removeCallbacksAndMessages(null);
        }
        d.wY().release();
        bfO();
        if (this.eLJ != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.eLJ.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    if (alaActiveRootView.getParent() != null) {
                        ((ViewGroup) alaActiveRootView.getParent()).removeView(alaActiveRootView);
                    }
                }
                i = i2 + 1;
            }
            this.eLJ.clear();
        }
        if (this.eLG != null) {
            this.eLG.release();
            this.eLG = null;
        }
    }

    public void iE(boolean z) {
        this.eLS = z;
    }

    public void bN(int i) {
        if (this.eLG != null) {
            this.eLG.bN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfI() {
        if (this.aiW != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.s.b.wV().d(this.aiW.Wt.userId, this.aiW.Wf.userId, this.aiW.mLiveInfo.room_id, this.aiW.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(aj ajVar) {
        com.baidu.live.s.b.wV().asz = ajVar;
        bB(ajVar.aaA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfJ() {
        if (this.mRunning) {
            if (this.eLP == null) {
                this.eLP = new HandlerC0442b(this);
            }
            if (this.eLQ == null) {
                this.eLQ = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bfI();
                    }
                };
            }
            bfK();
            if (this.aaz <= 0) {
                this.aaz = 5;
            }
            this.eLP.postDelayed(this.eLQ, this.aaz * 1000);
        }
    }

    private void bfK() {
        if (this.eLP != null && this.eLQ != null) {
            this.eLP.removeCallbacks(this.eLQ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bB(List<e> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (e eVar : list) {
                if (eVar != null) {
                    if (eVar.VU == 1) {
                        long j = eVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= eVar.showTime && j <= eVar.end_time && eVar.VZ != null && eVar.VZ.pos >= 0 && eVar.VZ.pos <= 2) {
                            if (eVar.VZ.pos == 0) {
                                eVar.VZ.pos = 1;
                            }
                            switch (eVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(eVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(eVar.VZ.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(eVar.VZ.pos), list2);
                                        }
                                        list2.add(eVar);
                                        if (!z2 || eVar.VY == null) {
                                            z = z2;
                                        } else {
                                            d.wY().a(eVar.VY);
                                            z = true;
                                        }
                                        z2 = z;
                                        break;
                                    }
                                    break;
                                case 1:
                                case 2:
                                default:
                                    if (hashMap == null) {
                                    }
                                    list2 = (List) hashMap.get(Integer.valueOf(eVar.VZ.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(eVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(eVar.webUrl) && eVar.VZ != null && eVar.VZ.width > 0 && eVar.VZ.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(eVar.VZ.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(eVar);
                                        if (z2) {
                                        }
                                        z = z2;
                                        z2 = z;
                                        break;
                                    }
                                    break;
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        }
        if (!z2) {
            d.wY().a(null);
        }
        for (int i = 1; i <= 2; i++) {
            j(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private void j(int i, List<e> list) {
        e eVar;
        int i2;
        if (list == null || list.isEmpty()) {
            bfL();
            pE(i);
            return;
        }
        Iterator<e> it = list.iterator();
        ArrayList<e> arrayList = null;
        while (it.hasNext()) {
            eVar = it.next();
            if (eVar.picType == 1 || eVar.picType == 3) {
                i2 = eVar.picType;
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(eVar);
        }
        eVar = null;
        i2 = 0;
        switch (i2) {
            case 0:
                a(i, arrayList, "");
                break;
            case 1:
                a(i, eVar);
                c(eVar);
                break;
            case 2:
            default:
                pE(i);
                break;
            case 3:
                b(i, eVar);
                break;
        }
        bfM();
    }

    private void bfL() {
        if (this.eLU != null) {
            Iterator<com.baidu.live.g.b> it = this.eLK.iterator();
            while (it.hasNext()) {
                this.eLU.b(it.next());
            }
            this.eLK.clear();
            this.eLU.qf();
        }
    }

    private void bfM() {
        if (this.eLU != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView pD = pD(i);
                if (pD != null && pD.getVisibility() == 0 && pD.getChildCount() > 0 && !this.eLK.contains(pD)) {
                    this.eLK.add(pD);
                    this.eLU.a(pD);
                }
            }
            this.eLU.qf();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.eLU = aVar;
    }

    private ViewGroup pC(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.eLJ == null || (alaActiveRootView = this.eLJ.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.eLI != null && (cVar = this.eLI.get(Integer.valueOf(i))) != null && (viewGroup = cVar.eLY) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.eLJ == null) {
                    this.eLJ = new HashMap();
                }
                this.eLJ.put(Integer.valueOf(i), alaActiveRootView2);
                if (viewGroup instanceof PriorityVerticalLinearLayout) {
                    alaActiveRootView2.setTag(a.g.sdk_pvl_layout_priority_tag_key, 1);
                }
                if (cVar.eLZ != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.eLZ);
                } else {
                    viewGroup.addView(alaActiveRootView2);
                }
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    public AlaActiveRootView pD(int i) {
        if (this.eLJ != null) {
            return this.eLJ.get(Integer.valueOf(i));
        }
        return null;
    }

    private void a(int i, ArrayList<e> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            pE(i);
            return;
        }
        AlaActiveRootView pD = pD(i);
        if (pD != null && pD.getChildCount() == 1) {
            View lastChild = pD.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return;
            }
        }
        pE(i);
        ViewGroup pC = pC(i);
        if (pC != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(pC.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.eLc);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.eLT || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.eLT && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            }
            pC.addView(alaActiveBannerView, layoutParams);
        }
    }

    private void a(int i, e eVar) {
        AlaActiveRootView pD = pD(i);
        if (pD != null && pD.getChildCount() == 1) {
            View lastChild = pD.getLastChild();
            if (lastChild instanceof AlaActiveDynamicView) {
                ((AlaActiveDynamicView) lastChild).setActivityInfo(eVar);
                return;
            }
        }
        pE(i);
        ViewGroup pC = pC(i);
        if (pC != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(pC.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(e eVar2) {
                    if (b.this.eLc != null) {
                        b.this.eLc.a(alaActiveDynamicView, eVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(eVar);
            if (eVar.VJ && this.eLc.pG(eVar.VS)) {
                eVar.VJ = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.eLT || i == 2) {
                layoutParams.gravity = 5;
            }
            pC.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(int i, e eVar) {
        String p = p(eVar.webUrl, eVar.jump_url, eVar.VX);
        if (!TextUtils.isEmpty(p) && eVar.VZ != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, eVar.VZ.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, eVar.VZ.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension != 0 && applyDimension2 != 0) {
                AlaActiveRootView pD = pD(i);
                if (pD != null && pD.getChildCount() == 1) {
                    View lastChild = pD.getLastChild();
                    if (lastChild instanceof AlaActiveWebView) {
                        if (TextUtils.isEmpty(((AlaActiveWebView) lastChild).getOriginalUrl()) || !((AlaActiveWebView) lastChild).getOriginalUrl().equals(p)) {
                            ((AlaActiveWebView) lastChild).loadUrl("file:///android_asset/web/blank.html");
                            ((AlaActiveWebView) lastChild).loadUrl(p);
                        }
                        ViewGroup.LayoutParams layoutParams = lastChild.getLayoutParams();
                        if (layoutParams.width != applyDimension || layoutParams.height != applyDimension2) {
                            layoutParams.width = applyDimension;
                            layoutParams.height = applyDimension2;
                            lastChild.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                }
                pE(i);
                ViewGroup pC = pC(i);
                if (pC != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(pC.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void iF(boolean z) {
                            if (z) {
                                b.this.bfN();
                            }
                        }
                    });
                    f fVar = new f();
                    fVar.x(this.mPageContext.getPageActivity()).a((com.baidu.live.view.web.e) null).a(alaActiveWebView.getSchemeCallback()).b(this.aCr);
                    com.baidu.live.view.web.a[] zk = fVar.zk();
                    for (com.baidu.live.view.web.a aVar : zk) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(p);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.eLT || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    pC.addView(alaActiveWebView, layoutParams2);
                }
            }
        }
    }

    private String p(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aiW != null) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            sb.append("user_id=");
            sb.append(this.aiW.Wt.userId);
            sb.append("&charm_user_id=");
            sb.append(this.aiW.Wf.userId);
            sb.append("&room_id=");
            sb.append(this.aiW.mLiveInfo.room_id);
            sb.append("&live_id=");
            sb.append(this.aiW.mLiveInfo.live_id);
            sb.append("&subapp_type=");
            sb.append(TbConfig.getSubappType());
            sb.append("&_client_type=");
            sb.append("2");
            if (this.isHost) {
                sb.append("&is_host=1");
            }
            sb.append("&jump_url=");
            sb.append(au(str2, i));
            return sb.toString();
        }
        return str;
    }

    private String au(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        if (i == 2) {
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            sb.append("room");
            sb.append(ETAG.EQUAL);
            sb.append(1);
        }
        try {
            return URLEncoder.encode(sb.toString(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfN() {
        if (Build.VERSION.SDK_INT >= 19) {
            bfQ();
            if (this.eLP == null) {
                this.eLP = new HandlerC0442b(this);
            }
            if (!this.eLP.hasMessages(1000)) {
                this.eLP.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bfO() {
        if (this.eLR != null) {
            this.eLR.clear();
        }
        if (this.eLP != null) {
            this.eLP.removeMessages(1000);
        }
        bfR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfP() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.eLJ != null) {
            if (this.eLR == null || (size = this.eLR.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.eLR.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.eLR.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.eLJ.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bfT()) {
                        if (!TextUtils.isEmpty(str)) {
                            if (Build.VERSION.SDK_INT >= 19) {
                                ((AlaActiveWebView) lastChild).evaluateJavascript("javascript:getClientInfo(" + str + ")", null);
                                z = true;
                                i2++;
                                z2 = z;
                            } else {
                                ((AlaActiveWebView) lastChild).loadUrl("javascript:getClientInfo(" + str + ")");
                            }
                        }
                        z = true;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.eLP.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bfO();
            }
        }
    }

    private void bfQ() {
        if (this.eLR == null) {
            this.eLR = new ArrayList();
        }
        this.eLR.clear();
        this.eLN = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.eLR.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eLN);
    }

    private void bfR() {
        if (this.eLN != null) {
            MessageManager.getInstance().unRegisterListener(this.eLN);
            this.eLN = null;
        }
    }

    private void pE(int i) {
        AlaActiveRootView pD = pD(i);
        if (pD != null) {
            pD.release();
        }
    }

    private void c(e eVar) {
        bfS();
        d.wY().c(this.aiW.mLiveInfo.user_id, this.aiW.mLiveInfo.live_id, eVar.activityId);
    }

    private void bfS() {
        if (this.eLM == null) {
            this.eLM = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.wC() != null && b.this.eLJ != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.g)) {
                            int id = ((com.baidu.live.message.g) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.eLJ.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.wC());
                                                return;
                                            }
                                        } else {
                                            continue;
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
            MessageManager.getInstance().registerListener(this.eLM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaActiveDynamicView alaActiveDynamicView, ak akVar) {
        boolean z = false;
        e activityInfo = alaActiveDynamicView.getActivityInfo();
        if (activityInfo != null) {
            alaActiveDynamicView.setData(activityInfo.pic_url, akVar);
            if (alaActiveDynamicView.getVisibility() != 0) {
                alaActiveDynamicView.setVisibility(0);
                z = true;
            }
            e.a aVar = activityInfo.VY;
            long j = aVar != null ? (aVar.endTime - aVar.currentTime) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.oG(2);
                alaActiveDynamicView.setTimer(akVar.aaG + " *" + aVar.Wb);
                alaActiveDynamicView.u(j, aVar.endTime);
            } else {
                alaActiveDynamicView.oG(1);
            }
            if (z) {
                d(activityInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void al(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(str.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
                sb.append("room");
                sb.append(ETAG.EQUAL);
                sb.append(1);
                yq(sb.toString());
                return;
            }
            BrowserHelper.startInternalWebActivity(this.mPageContext.getPageActivity(), str);
        }
    }

    public void yq(String str) {
        int i = 2;
        if (this.eLG == null) {
            this.eLG = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.eLG.setHost(this.isHost);
        if (this.aiW != null && this.aiW.mLiveInfo != null) {
            this.eLG.d(this.aiW.mLiveInfo.user_id, this.aiW.mLiveInfo.getNameShow());
        }
        if (!this.eLT) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.eLG.ar(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, String str, String str2) {
        if (!this.isHost && eVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, eVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void d(e eVar) {
        if (!this.isHost && eVar != null && this.aiW != null && this.aiW.mLiveInfo != null) {
            String str = this.aiW.mLiveInfo.feed_id;
            if (!TextUtils.isEmpty(str)) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                    alaStaticItem.addParams("feed_id", str);
                    alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, eVar.activityId + "");
                    alaStaticItem.addParams("other_params", this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pF(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.eLH)) {
                jSONArray = new JSONArray(this.eLH);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.eLH = jSONArray.toString();
            com.baidu.live.c.oJ().putString("ala_active_view_click_info", this.eLH);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pG(int i) {
        if (StringUtils.isNull(this.eLH)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.eLH);
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
    /* loaded from: classes2.dex */
    public class c {
        ViewGroup eLY;
        ViewGroup.LayoutParams eLZ;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.eLY = viewGroup;
            this.eLZ = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0442b extends Handler {
        private final WeakReference<b> eLX;

        HandlerC0442b(b bVar) {
            this.eLX = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.eLX.get() != null && message.what == 1000) {
                this.eLX.get().bfP();
            }
        }
    }
}
