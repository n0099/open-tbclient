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
import com.baidu.live.data.af;
import com.baidu.live.data.ag;
import com.baidu.live.data.e;
import com.baidu.live.data.k;
import com.baidu.live.message.GetLiveActivityDynamicHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.q.a;
import com.baidu.live.r.d;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.browser.BrowserHelper;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
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
    private int aam;
    private long afO;
    private k aio;
    private HttpMessageListener eKA;
    private CustomMessageListener eKB;
    private CustomMessageListener eKC;
    private HandlerC0439b eKD;
    private Runnable eKE;
    private List<String> eKF;
    private boolean eKG;
    private boolean eKH;
    private com.baidu.tieba.ala.liveroom.a.c eKv;
    private Map<Integer, c> eKx;
    private Map<Integer, AlaActiveRootView> eKy;
    private HttpMessageListener eKz;
    private TbPageContext mPageContext;
    private String otherParams;
    private String eKw = "";
    private boolean isHost = false;
    private g aBz = new g() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
        @Override // com.baidu.live.view.web.g
        public void dZ(String str) {
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
                if (!z) {
                    BrowserHelper.startInternalWebActivity(b.this.mPageContext.getPageActivity(), str);
                } else {
                    b.this.yl(str);
                }
            }
        }
    };
    private a eJR = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.10
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean pF(int i) {
            return b.this.pF(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.afO >= 400) {
                b.this.afO = currentTimeMillis;
                if ((obj instanceof e) && b.this.aio != null && b.this.aio.VP != null && b.this.aio.mLiveInfo != null) {
                    e eVar = (e) obj;
                    String str = eVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aio != null && b.this.aio.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aio.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aio.VP.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aio.VP.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aio.mLiveInfo.live_id);
                        sb.append("&_loc_portrait=");
                        sb.append(b.this.aio.VP.portrait);
                    }
                    if (!pF(eVar.VC)) {
                        b.this.pE(eVar.VC);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).py(i);
                        } else if ((view instanceof AlaActiveDynamicView) && eVar.Vt && b.this.eJR.pF(eVar.VC)) {
                            eVar.Vt = false;
                        }
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", "liveshow");
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", "liveroom");
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                    alaStaticItem.addParams("ext", eVar.VC);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    b.this.aj(eVar.VH, sb.toString());
                    String str2 = "";
                    String str3 = "";
                    if (b.this.aio.mLiveInfo != null) {
                        str2 = b.this.aio.mLiveInfo.feed_id;
                        str3 = b.this.aio.mLiveInfo.live_id + "";
                    }
                    b.this.a(eVar, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener eqn = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.eKy != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.eKy.get(Integer.valueOf(i2));
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

        boolean pF(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.eqn);
    }

    @Override // com.baidu.live.liveroom.a.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(k kVar, boolean z) {
        this.eKH = z;
        for (int i = 1; i <= 2; i++) {
            pD(i);
        }
        if (this.eKx != null) {
            this.eKx.clear();
        }
        g(kVar);
        if (this.aio != null) {
            this.eKw = com.baidu.live.c.oI().getString("ala_active_view_click_info", "");
            bfi();
            bfj();
            bfk();
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.eKx == null) {
            this.eKx = new HashMap();
        }
        this.eKx.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        pB(i);
    }

    private void bfi() {
        this.eKz = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.aio == null || b.this.aio.mLiveInfo == null || b.this.aio.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aio.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.bfl();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.wm() != null) {
                            b.this.aam = getLiveActivityHttpResponseMessage.wm().aam;
                            b.this.a(getLiveActivityHttpResponseMessage.wm());
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eKz);
    }

    private void bfj() {
        this.eKC = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    b.this.yl((String) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eKC);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.eKy != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.eKy.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.eKy != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.eKy.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bft()) {
                        bfn();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.eKv != null) {
            this.eKv.resume();
        }
        bfk();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.eKy != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.eKy.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.eKv != null) {
            this.eKv.pause();
        }
        bfm();
        bfo();
    }

    @Override // com.baidu.live.liveroom.a.a
    public void g(k kVar) {
        this.aio = kVar;
    }

    public void setVisible(int i) {
        if (this.eKG) {
            i = 8;
        }
        if (this.eKy != null) {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.eKy.get(Integer.valueOf(i3));
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

    public void bf(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        if (this.eKG) {
            i2 = 8;
        }
        if (this.eKy != null && (alaActiveRootView = this.eKy.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(i2);
        }
    }

    public void yk(String str) {
        if (d.wH().dH(str)) {
            bfk();
        }
    }

    public void release() {
        this.aio = null;
        if (this.eKz != null) {
            MessageManager.getInstance().unRegisterListener(this.eKz);
            this.eKz = null;
        }
        if (this.eKA != null) {
            MessageManager.getInstance().unRegisterListener(this.eKA);
            this.eKA = null;
        }
        if (this.eqn != null) {
            MessageManager.getInstance().unRegisterListener(this.eqn);
            this.eqn = null;
        }
        if (this.eKC != null) {
            MessageManager.getInstance().unRegisterListener(this.eKC);
            this.eKC = null;
        }
        if (this.eKD != null) {
            this.eKD.removeCallbacksAndMessages(null);
        }
        d.wH().release();
        bfo();
        if (this.eKy != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.eKy.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    if (alaActiveRootView.getParent() != null) {
                        ((ViewGroup) alaActiveRootView.getParent()).removeView(alaActiveRootView);
                    }
                }
                i = i2 + 1;
            }
            this.eKy.clear();
        }
        if (this.eKv != null) {
            this.eKv.release();
            this.eKv = null;
        }
    }

    public void iu(boolean z) {
        this.eKG = z;
    }

    public void bN(int i) {
        if (this.eKv != null) {
            this.eKv.bN(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfk() {
        if (this.aio != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.r.b.wE().d(this.aio.Wc.userId, this.aio.VP.userId, this.aio.mLiveInfo.room_id, this.aio.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(af afVar) {
        com.baidu.live.r.b.wE().arN = afVar;
        bB(afVar.aan);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfl() {
        if (this.mRunning) {
            if (this.eKD == null) {
                this.eKD = new HandlerC0439b(this);
            }
            if (this.eKE == null) {
                this.eKE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bfk();
                    }
                };
            }
            bfm();
            if (this.aam <= 0) {
                this.aam = 5;
            }
            this.eKD.postDelayed(this.eKE, this.aam * 1000);
        }
    }

    private void bfm() {
        if (this.eKD != null && this.eKE != null) {
            this.eKD.removeCallbacks(this.eKE);
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
                    if (eVar.VE == 1) {
                        long j = eVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= eVar.showTime && j <= eVar.end_time && eVar.VJ != null && eVar.VJ.pos >= 0 && eVar.VJ.pos <= 2) {
                            if (eVar.VJ.pos == 0) {
                                eVar.VJ.pos = 1;
                            }
                            switch (eVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(eVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(eVar.VJ.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(eVar.VJ.pos), list2);
                                        }
                                        list2.add(eVar);
                                        if (!z2 || eVar.VI == null) {
                                            z = z2;
                                        } else {
                                            d.wH().a(eVar.VI);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(eVar.VJ.pos));
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
                                    if (!TextUtils.isEmpty(eVar.webUrl) && eVar.VJ != null && eVar.VJ.width > 0 && eVar.VJ.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(eVar.VJ.pos));
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
            d.wH().a(null);
        }
        for (int i = 1; i <= 2; i++) {
            j(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private void j(int i, List<e> list) {
        e eVar;
        int i2;
        if (list == null || list.isEmpty()) {
            pD(i);
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
                return;
            case 1:
                a(i, eVar);
                c(eVar);
                return;
            case 2:
            default:
                pD(i);
                return;
            case 3:
                b(i, eVar);
                return;
        }
    }

    private ViewGroup pB(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.eKy == null || (alaActiveRootView = this.eKy.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.eKx != null && (cVar = this.eKx.get(Integer.valueOf(i))) != null && (viewGroup = cVar.eKL) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.eKy == null) {
                    this.eKy = new HashMap();
                }
                this.eKy.put(Integer.valueOf(i), alaActiveRootView2);
                if (cVar.eKM != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.eKM);
                } else {
                    viewGroup.addView(alaActiveRootView2);
                }
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private AlaActiveRootView pC(int i) {
        if (this.eKy != null) {
            return this.eKy.get(Integer.valueOf(i));
        }
        return null;
    }

    private void a(int i, ArrayList<e> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            pD(i);
            return;
        }
        AlaActiveRootView pC = pC(i);
        if (pC != null && pC.getChildCount() == 1) {
            View lastChild = pC.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return;
            }
        }
        pD(i);
        ViewGroup pB = pB(i);
        if (pB != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(pB.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.eJR);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.eKH || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.eKH && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            }
            pB.addView(alaActiveBannerView, layoutParams);
        }
    }

    private void a(int i, e eVar) {
        AlaActiveRootView pC = pC(i);
        if (pC != null && pC.getChildCount() == 1) {
            View lastChild = pC.getLastChild();
            if (lastChild instanceof AlaActiveDynamicView) {
                ((AlaActiveDynamicView) lastChild).setActivityInfo(eVar);
                return;
            }
        }
        pD(i);
        ViewGroup pB = pB(i);
        if (pB != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(pB.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(e eVar2) {
                    if (b.this.eJR != null) {
                        b.this.eJR.a(alaActiveDynamicView, eVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(eVar);
            if (eVar.Vt && this.eJR.pF(eVar.VC)) {
                eVar.Vt = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.eKH || i == 2) {
                layoutParams.gravity = 5;
            }
            pB.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(int i, e eVar) {
        String p = p(eVar.webUrl, eVar.jump_url, eVar.VH);
        if (!TextUtils.isEmpty(p) && eVar.VJ != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, eVar.VJ.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, eVar.VJ.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension != 0 && applyDimension2 != 0) {
                AlaActiveRootView pC = pC(i);
                if (pC != null && pC.getChildCount() == 1) {
                    View lastChild = pC.getLastChild();
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
                pD(i);
                ViewGroup pB = pB(i);
                if (pB != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(pB.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void iv(boolean z) {
                            if (z) {
                                b.this.bfn();
                            }
                        }
                    });
                    f fVar = new f();
                    fVar.x(this.mPageContext.getPageActivity()).a((com.baidu.live.view.web.e) null).a(alaActiveWebView.getSchemeCallback()).b(this.aBz);
                    com.baidu.live.view.web.a[] yO = fVar.yO();
                    for (com.baidu.live.view.web.a aVar : yO) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(p);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.eKH || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    pB.addView(alaActiveWebView, layoutParams2);
                }
            }
        }
    }

    private String p(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aio != null) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            sb.append("user_id=");
            sb.append(this.aio.Wc.userId);
            sb.append("&charm_user_id=");
            sb.append(this.aio.VP.userId);
            sb.append("&room_id=");
            sb.append(this.aio.mLiveInfo.room_id);
            sb.append("&live_id=");
            sb.append(this.aio.mLiveInfo.live_id);
            sb.append("&subapp_type=");
            sb.append(TbConfig.getSubappType());
            sb.append("&_client_type=");
            sb.append("2");
            sb.append("&jump_url=");
            sb.append(at(str2, i));
            return sb.toString();
        }
        return str;
    }

    private String at(String str, int i) {
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
    public void bfn() {
        if (Build.VERSION.SDK_INT >= 19) {
            bfq();
            if (this.eKD == null) {
                this.eKD = new HandlerC0439b(this);
            }
            if (!this.eKD.hasMessages(1000)) {
                this.eKD.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bfo() {
        if (this.eKF != null) {
            this.eKF.clear();
        }
        if (this.eKD != null) {
            this.eKD.removeMessages(1000);
        }
        bfr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfp() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.eKy != null) {
            if (this.eKF == null || (size = this.eKF.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.eKF.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.eKF.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.eKy.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bft()) {
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
                this.eKD.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bfo();
            }
        }
    }

    private void bfq() {
        if (this.eKF == null) {
            this.eKF = new ArrayList();
        }
        this.eKF.clear();
        this.eKB = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.eKF.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eKB);
    }

    private void bfr() {
        if (this.eKB != null) {
            MessageManager.getInstance().unRegisterListener(this.eKB);
            this.eKB = null;
        }
    }

    private void pD(int i) {
        AlaActiveRootView pC = pC(i);
        if (pC != null) {
            pC.release();
        }
    }

    private void c(e eVar) {
        bfs();
        d.wH().c(this.aio.mLiveInfo.user_id, this.aio.mLiveInfo.live_id, eVar.activityId);
    }

    private void bfs() {
        if (this.eKA == null) {
            this.eKA = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.wl() != null && b.this.eKy != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.g)) {
                            int id = ((com.baidu.live.message.g) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.eKy.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.wl());
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
            MessageManager.getInstance().registerListener(this.eKA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaActiveDynamicView alaActiveDynamicView, ag agVar) {
        boolean z = false;
        e activityInfo = alaActiveDynamicView.getActivityInfo();
        if (activityInfo != null) {
            alaActiveDynamicView.setData(activityInfo.pic_url, agVar);
            if (alaActiveDynamicView.getVisibility() != 0) {
                alaActiveDynamicView.setVisibility(0);
                z = true;
            }
            e.a aVar = activityInfo.VI;
            long j = aVar != null ? (aVar.endTime - aVar.VM) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.oF(2);
                alaActiveDynamicView.setTimer(agVar.aau + " *" + aVar.VL);
                alaActiveDynamicView.u(j, aVar.endTime);
            } else {
                alaActiveDynamicView.oF(1);
            }
            if (z) {
                d(activityInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aj(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(str.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
                sb.append("room");
                sb.append(ETAG.EQUAL);
                sb.append(1);
                yl(sb.toString());
                return;
            }
            BrowserHelper.startInternalWebActivity(this.mPageContext.getPageActivity(), str);
        }
    }

    public void yl(String str) {
        int i = 2;
        if (this.eKv == null) {
            this.eKv = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.eKv.setHost(this.isHost);
        if (this.aio != null && this.aio.mLiveInfo != null) {
            this.eKv.d(this.aio.mLiveInfo.user_id, this.aio.mLiveInfo.getNameShow());
        }
        if (!this.eKH) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.eKv.aq(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, String str, String str2) {
        if (!this.isHost && eVar != null) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
            alaStaticItem.addParams("feed_id", str);
            alaStaticItem.addParams("live_id", str2);
            alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, eVar.activityId + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void d(e eVar) {
        if (!this.isHost && eVar != null && this.aio != null && this.aio.mLiveInfo != null) {
            String str = this.aio.mLiveInfo.feed_id;
            if (!TextUtils.isEmpty(str)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, eVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pE(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.eKw)) {
                jSONArray = new JSONArray(this.eKw);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.eKw = jSONArray.toString();
            com.baidu.live.c.oI().putString("ala_active_view_click_info", this.eKw);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pF(int i) {
        if (StringUtils.isNull(this.eKw)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.eKw);
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
        ViewGroup eKL;
        ViewGroup.LayoutParams eKM;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.eKL = viewGroup;
            this.eKM = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0439b extends Handler {
        private final WeakReference<b> eKK;

        HandlerC0439b(b bVar) {
            this.eKK = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.eKK.get() != null && message.what == 1000) {
                this.eKK.get().bfp();
            }
        }
    }
}
