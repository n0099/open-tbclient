package com.baidu.tieba.ala.liveroom.activeview;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
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
import com.baidu.live.data.ac;
import com.baidu.live.data.ad;
import com.baidu.live.data.c;
import com.baidu.live.data.i;
import com.baidu.live.k.a;
import com.baidu.live.l.d;
import com.baidu.live.message.GetLiveActivityDynamicHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
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
import com.baidu.live.view.web.e;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView;
import com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView;
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
/* loaded from: classes6.dex */
public class b implements com.baidu.live.liveroom.a.a {
    private int Tv;
    private i aaj;
    private com.baidu.tieba.ala.liveroom.a.c dUV;
    private Map<Integer, c> dUX;
    private Map<Integer, AlaActiveRootView> dUY;
    private HttpMessageListener dUZ;
    private HttpMessageListener dVa;
    private CustomMessageListener dVb;
    private HandlerC0351b dVc;
    private Runnable dVd;
    private List<String> dVe;
    private boolean dVf;
    private boolean dVg;
    private long dbU;
    private TbPageContext mPageContext;
    private String otherParams;
    private String dUW = "";
    private boolean isHost = false;
    private g atD = new g() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
        @Override // com.baidu.live.view.web.g
        public void df(String str) {
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
                    return;
                }
                Log.e("Da88", "openDetail--3---url = " + str);
                b.this.tw(str);
            }
        }
    };
    private a dUr = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean np(int i) {
            return b.this.np(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.dbU >= 400) {
                b.this.dbU = currentTimeMillis;
                if ((obj instanceof com.baidu.live.data.c) && b.this.aaj != null && b.this.aaj.OR != null && b.this.aaj.mLiveInfo != null) {
                    com.baidu.live.data.c cVar = (com.baidu.live.data.c) obj;
                    String str = cVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aaj != null && b.this.aaj.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aaj.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aaj.OR.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aaj.OR.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aaj.mLiveInfo.live_id);
                        sb.append("&_loc_portrait=");
                        sb.append(b.this.aaj.OR.portrait);
                    }
                    if (!np(cVar.OC)) {
                        b.this.no(cVar.OC);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).nh(i);
                        } else if ((view instanceof AlaActiveDynamicView) && cVar.Ot && b.this.dUr.np(cVar.OC)) {
                            cVar.Ot = false;
                        }
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", AlaStaticKeys.ALA_STATIC_VALUE_FROM);
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", "liveroom");
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                    alaStaticItem.addParams("ext", cVar.OC);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    b.this.U(cVar.OH, sb.toString());
                    String str2 = "";
                    String str3 = "";
                    if (b.this.aaj.mLiveInfo != null) {
                        str2 = b.this.aaj.mLiveInfo.feed_id;
                        str3 = b.this.aaj.mLiveInfo.live_id + "";
                    }
                    b.this.a(cVar, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener dEz = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.dUY != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.dUY.get(Integer.valueOf(i2));
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

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view, Object obj, int i);

        boolean np(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.dEz);
    }

    @Override // com.baidu.live.liveroom.a.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(i iVar, boolean z) {
        this.dVg = z;
        for (int i = 1; i <= 2; i++) {
            nn(i);
        }
        if (this.dUX != null) {
            this.dUX.clear();
        }
        g(iVar);
        if (this.aaj != null) {
            this.dUW = com.baidu.live.c.np().getString("ala_active_view_click_info", "");
            aNN();
            aNO();
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.dUX == null) {
            this.dUX = new HashMap();
        }
        this.dUX.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        nl(i);
    }

    private void aNN() {
        this.dUZ = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.aaj == null || b.this.aaj.mLiveInfo == null || b.this.aaj.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aaj.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.aNP();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.ur() != null) {
                            b.this.Tv = getLiveActivityHttpResponseMessage.ur().Tv;
                            b.this.a(getLiveActivityHttpResponseMessage.ur());
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dUZ);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.dUY != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.dUY.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.dUY != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.dUY.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).aNX()) {
                        aNR();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.dUV != null) {
            this.dUV.resume();
        }
        aNO();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.dUY != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.dUY.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.dUV != null) {
            this.dUV.pause();
        }
        aNQ();
        aNS();
    }

    @Override // com.baidu.live.liveroom.a.a
    public void g(i iVar) {
        this.aaj = iVar;
    }

    public void setVisible(int i) {
        if (this.dVf) {
            i = 8;
        }
        if (this.dUY != null) {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.dUY.get(Integer.valueOf(i3));
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

    public void aP(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        if (this.dVf) {
            i2 = 8;
        }
        if (this.dUY != null && (alaActiveRootView = this.dUY.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(i2);
        }
    }

    public void tv(String str) {
        if (d.uJ().cO(str)) {
            aNO();
        }
    }

    public void release() {
        this.aaj = null;
        if (this.dUZ != null) {
            MessageManager.getInstance().unRegisterListener(this.dUZ);
            this.dUZ = null;
        }
        if (this.dVa != null) {
            MessageManager.getInstance().unRegisterListener(this.dVa);
            this.dVa = null;
        }
        if (this.dEz != null) {
            MessageManager.getInstance().unRegisterListener(this.dEz);
            this.dEz = null;
        }
        if (this.dVc != null) {
            this.dVc.removeCallbacksAndMessages(null);
        }
        d.uJ().release();
        aNS();
        if (this.dUY != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.dUY.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    if (alaActiveRootView.getParent() != null) {
                        ((ViewGroup) alaActiveRootView.getParent()).removeView(alaActiveRootView);
                    }
                }
                i = i2 + 1;
            }
            this.dUY.clear();
        }
        if (this.dUV != null) {
            this.dUV.release();
            this.dUV = null;
        }
    }

    public void hk(boolean z) {
        this.dVf = z;
    }

    public void bw(int i) {
        if (this.dUV != null) {
            this.dUV.bw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNO() {
        if (this.aaj != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.l.b.uG().d(this.aaj.Pj.userId, this.aaj.OR.userId, this.aaj.mLiveInfo.room_id, this.aaj.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ac acVar) {
        com.baidu.live.l.b.uG().ajP = acVar;
        bC(acVar.Tw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNP() {
        if (this.mRunning) {
            if (this.dVc == null) {
                this.dVc = new HandlerC0351b(this);
            }
            if (this.dVd == null) {
                this.dVd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.aNO();
                    }
                };
            }
            aNQ();
            if (this.Tv <= 0) {
                this.Tv = 5;
            }
            this.dVc.postDelayed(this.dVd, this.Tv * 1000);
        }
    }

    private void aNQ() {
        if (this.dVc != null && this.dVd != null) {
            this.dVc.removeCallbacks(this.dVd);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bC(List<com.baidu.live.data.c> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (com.baidu.live.data.c cVar : list) {
                if (cVar != null) {
                    if (cVar.OE == 1) {
                        long j = cVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= cVar.showTime && j <= cVar.end_time && cVar.OJ != null && cVar.OJ.pos >= 0 && cVar.OJ.pos <= 2) {
                            if (cVar.OJ.pos == 0) {
                                cVar.OJ.pos = 1;
                            }
                            switch (cVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(cVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(cVar.OJ.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(cVar.OJ.pos), list2);
                                        }
                                        list2.add(cVar);
                                        if (!z2 || cVar.OI == null) {
                                            z = z2;
                                        } else {
                                            d.uJ().a(cVar.OI);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(cVar.OJ.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(cVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(cVar.webUrl) && cVar.OJ != null && cVar.OJ.width > 0 && cVar.OJ.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(cVar.OJ.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(cVar);
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
            d.uJ().a(null);
        }
        for (int i = 1; i <= 2; i++) {
            g(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private void g(int i, List<com.baidu.live.data.c> list) {
        com.baidu.live.data.c cVar;
        int i2;
        if (list == null || list.isEmpty()) {
            nn(i);
            return;
        }
        Iterator<com.baidu.live.data.c> it = list.iterator();
        ArrayList<com.baidu.live.data.c> arrayList = null;
        while (it.hasNext()) {
            cVar = it.next();
            if (cVar.picType == 1 || cVar.picType == 3) {
                i2 = cVar.picType;
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(cVar);
        }
        cVar = null;
        i2 = 0;
        switch (i2) {
            case 0:
                a(i, arrayList, "");
                return;
            case 1:
                a(i, cVar);
                c(cVar);
                return;
            case 2:
            default:
                nn(i);
                return;
            case 3:
                b(i, cVar);
                return;
        }
    }

    private ViewGroup nl(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.dUY == null || (alaActiveRootView = this.dUY.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.dUX != null && (cVar = this.dUX.get(Integer.valueOf(i))) != null && (viewGroup = cVar.dVk) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.dUY == null) {
                    this.dUY = new HashMap();
                }
                this.dUY.put(Integer.valueOf(i), alaActiveRootView2);
                if (cVar.dVl != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.dVl);
                } else {
                    viewGroup.addView(alaActiveRootView2);
                }
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private AlaActiveRootView nm(int i) {
        if (this.dUY != null) {
            return this.dUY.get(Integer.valueOf(i));
        }
        return null;
    }

    private void a(int i, ArrayList<com.baidu.live.data.c> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            nn(i);
            return;
        }
        AlaActiveRootView nm = nm(i);
        if (nm != null && nm.getChildCount() == 1) {
            View lastChild = nm.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return;
            }
        }
        nn(i);
        ViewGroup nl = nl(i);
        if (nl != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(nl.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.dUr);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.dVg || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.dVg && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            }
            nl.addView(alaActiveBannerView, layoutParams);
        }
    }

    private void a(int i, com.baidu.live.data.c cVar) {
        AlaActiveRootView nm = nm(i);
        if (nm != null && nm.getChildCount() == 1) {
            View lastChild = nm.getLastChild();
            if (lastChild instanceof AlaActiveDynamicView) {
                ((AlaActiveDynamicView) lastChild).setActivityInfo(cVar);
                return;
            }
        }
        nn(i);
        ViewGroup nl = nl(i);
        if (nl != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(nl.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(com.baidu.live.data.c cVar2) {
                    if (b.this.dUr != null) {
                        b.this.dUr.a(alaActiveDynamicView, cVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(cVar);
            if (cVar.Ot && this.dUr.np(cVar.OC)) {
                cVar.Ot = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.dVg || i == 2) {
                layoutParams.gravity = 5;
            }
            nl.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(int i, com.baidu.live.data.c cVar) {
        String l = l(cVar.webUrl, cVar.jump_url, cVar.OH);
        if (!TextUtils.isEmpty(l) && cVar.OJ != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, cVar.OJ.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, cVar.OJ.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension != 0 && applyDimension2 != 0) {
                AlaActiveRootView nm = nm(i);
                if (nm != null && nm.getChildCount() == 1) {
                    View lastChild = nm.getLastChild();
                    if (lastChild instanceof AlaActiveWebView) {
                        if (TextUtils.isEmpty(((AlaActiveWebView) lastChild).getOriginalUrl()) || !((AlaActiveWebView) lastChild).getOriginalUrl().equals(l)) {
                            ((AlaActiveWebView) lastChild).loadUrl("file:///android_asset/web/blank.html");
                            ((AlaActiveWebView) lastChild).loadUrl(l);
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
                nn(i);
                ViewGroup nl = nl(i);
                if (nl != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(nl.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void hl(boolean z) {
                            if (z) {
                                b.this.aNR();
                            }
                        }
                    });
                    f fVar = new f();
                    fVar.az(this.mPageContext.getPageActivity()).a((e) null).a(alaActiveWebView.getSchemeCallback()).b(this.atD);
                    com.baidu.live.view.web.a[] wP = fVar.wP();
                    for (com.baidu.live.view.web.a aVar : wP) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(l);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.dVg || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    nl.addView(alaActiveWebView, layoutParams2);
                }
            }
        }
    }

    private String l(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aaj != null) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("user_id=");
            sb.append(this.aaj.Pj.userId);
            sb.append("&charm_user_id=");
            sb.append(this.aaj.OR.userId);
            sb.append("&room_id=");
            sb.append(this.aaj.mLiveInfo.room_id);
            sb.append("&live_id=");
            sb.append(this.aaj.mLiveInfo.live_id);
            sb.append("&subapp_type=");
            sb.append(TbConfig.getSubappType());
            sb.append("&_client_type=");
            sb.append("2");
            sb.append("&jump_url=");
            sb.append(ak(str2, i));
            return sb.toString();
        }
        return str;
    }

    private String ak(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(str);
        if (i == 2) {
            if (str.contains("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("room");
            sb.append("=");
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
    public void aNR() {
        if (Build.VERSION.SDK_INT >= 19) {
            aNU();
            if (this.dVc == null) {
                this.dVc = new HandlerC0351b(this);
            }
            if (!this.dVc.hasMessages(1000)) {
                this.dVc.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void aNS() {
        if (this.dVe != null) {
            this.dVe.clear();
        }
        if (this.dVc != null) {
            this.dVc.removeMessages(1000);
        }
        aNV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNT() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.dUY != null) {
            if (this.dVe == null || (size = this.dVe.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.dVe.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.dVe.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.dUY.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).aNX()) {
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
                this.dVc.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                aNS();
            }
        }
    }

    private void aNU() {
        if (this.dVe == null) {
            this.dVe = new ArrayList();
        }
        this.dVe.clear();
        this.dVb = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.dVe.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dVb);
    }

    private void aNV() {
        if (this.dVb != null) {
            MessageManager.getInstance().unRegisterListener(this.dVb);
            this.dVb = null;
        }
    }

    private void nn(int i) {
        AlaActiveRootView nm = nm(i);
        if (nm != null) {
            nm.release();
        }
    }

    private void c(com.baidu.live.data.c cVar) {
        aNW();
        d.uJ().c(this.aaj.mLiveInfo.user_id, this.aaj.mLiveInfo.live_id, cVar.activityId);
    }

    private void aNW() {
        if (this.dVa == null) {
            this.dVa = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.uq() != null && b.this.dUY != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.e)) {
                            int id = ((com.baidu.live.message.e) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.dUY.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.uq());
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
            MessageManager.getInstance().registerListener(this.dVa);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaActiveDynamicView alaActiveDynamicView, ad adVar) {
        boolean z = false;
        com.baidu.live.data.c activityInfo = alaActiveDynamicView.getActivityInfo();
        if (activityInfo != null) {
            alaActiveDynamicView.setData(activityInfo.pic_url, adVar);
            if (alaActiveDynamicView.getVisibility() != 0) {
                alaActiveDynamicView.setVisibility(0);
                z = true;
            }
            c.a aVar = activityInfo.OI;
            long j = aVar != null ? (aVar.endTime - aVar.OO) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.nk(2);
                alaActiveDynamicView.setTimer(adVar.TD + " *" + aVar.OM);
                alaActiveDynamicView.p(j, aVar.endTime);
            } else {
                alaActiveDynamicView.nk(1);
            }
            if (z) {
                d(activityInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(str.contains("?") ? "&" : "?");
                sb.append("room");
                sb.append("=");
                sb.append(1);
                Log.e("Da88", "openDetail--2---url = " + sb.toString());
                tw(sb.toString());
                return;
            }
            BrowserHelper.startInternalWebActivity(this.mPageContext.getPageActivity(), str);
        }
    }

    public void tw(String str) {
        int i = 2;
        if (this.dUV == null) {
            this.dUV = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.dUV.setHost(this.isHost);
        if (this.aaj != null && this.aaj.mLiveInfo != null) {
            this.dUV.c(this.aaj.mLiveInfo.user_id, this.aaj.mLiveInfo.getNameShow());
        }
        if (!this.dVg) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.dUV.ah(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.data.c cVar, String str, String str2) {
        if (!this.isHost && cVar != null) {
            AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
            alaStaticItem.addParams("feed_id", str);
            alaStaticItem.addParams("live_id", str2);
            alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, cVar.activityId + "");
            alaStaticItem.addParams("other_params", this.otherParams);
            AlaStaticsManager.getInst().onStatic(alaStaticItem);
        }
    }

    private void d(com.baidu.live.data.c cVar) {
        if (!this.isHost && cVar != null && this.aaj != null && this.aaj.mLiveInfo != null) {
            String str = this.aaj.mLiveInfo.feed_id;
            if (!TextUtils.isEmpty(str)) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, cVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void no(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.dUW)) {
                jSONArray = new JSONArray(this.dUW);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.dUW = jSONArray.toString();
            com.baidu.live.c.np().putString("ala_active_view_click_info", this.dUW);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean np(int i) {
        if (StringUtils.isNull(this.dUW)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.dUW);
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
    /* loaded from: classes6.dex */
    public class c {
        ViewGroup dVk;
        ViewGroup.LayoutParams dVl;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.dVk = viewGroup;
            this.dVl = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0351b extends Handler {
        private final WeakReference<b> dVj;

        HandlerC0351b(b bVar) {
            this.dVj = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.dVj.get() != null && message.what == 1000) {
                this.dVj.get().aNT();
            }
        }
    }
}
