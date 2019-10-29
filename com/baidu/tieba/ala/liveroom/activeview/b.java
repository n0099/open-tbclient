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
    private int TQ;
    private i aaB;
    private com.baidu.tieba.ala.liveroom.a.c dVM;
    private Map<Integer, c> dVO;
    private Map<Integer, AlaActiveRootView> dVP;
    private HttpMessageListener dVQ;
    private HttpMessageListener dVR;
    private CustomMessageListener dVS;
    private HandlerC0356b dVT;
    private Runnable dVU;
    private List<String> dVV;
    private boolean dVW;
    private boolean dVX;
    private long dcM;
    private TbPageContext mPageContext;
    private String otherParams;
    private String dVN = "";
    private boolean isHost = false;
    private g atV = new g() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
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
                } else {
                    b.this.tw(str);
                }
            }
        }
    };
    private a dVi = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean nq(int i) {
            return b.this.nq(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.dcM >= 400) {
                b.this.dcM = currentTimeMillis;
                if ((obj instanceof com.baidu.live.data.c) && b.this.aaB != null && b.this.aaB.Ps != null && b.this.aaB.mLiveInfo != null) {
                    com.baidu.live.data.c cVar = (com.baidu.live.data.c) obj;
                    String str = cVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aaB != null && b.this.aaB.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aaB.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aaB.Ps.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aaB.Ps.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aaB.mLiveInfo.live_id);
                        sb.append("&_loc_portrait=");
                        sb.append(b.this.aaB.Ps.portrait);
                    }
                    if (!nq(cVar.Pf)) {
                        b.this.np(cVar.Pf);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).ni(i);
                        } else if ((view instanceof AlaActiveDynamicView) && cVar.OW && b.this.dVi.nq(cVar.Pf)) {
                            cVar.OW = false;
                        }
                    }
                    AlaStaticItem alaStaticItem = new AlaStaticItem(AlaStaticKeys.ALA_STATIC_KEY);
                    alaStaticItem.addParams("from", AlaStaticKeys.ALA_STATIC_VALUE_FROM);
                    alaStaticItem.addParams("type", "click");
                    alaStaticItem.addParams("page", "liveroom");
                    alaStaticItem.addParams("value", AlaStaticKeys.ALA_STATIC_VALUE_ICON);
                    alaStaticItem.addParams("ext", cVar.Pf);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    b.this.V(cVar.Pk, sb.toString());
                    String str2 = "";
                    String str3 = "";
                    if (b.this.aaB.mLiveInfo != null) {
                        str2 = b.this.aaB.mLiveInfo.feed_id;
                        str3 = b.this.aaB.mLiveInfo.live_id + "";
                    }
                    b.this.a(cVar, str2, str3);
                }
            }
        }
    };
    private CustomMessageListener dFq = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.dVP != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.dVP.get(Integer.valueOf(i2));
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

        boolean nq(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.dFq);
    }

    @Override // com.baidu.live.liveroom.a.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(i iVar, boolean z) {
        this.dVX = z;
        for (int i = 1; i <= 2; i++) {
            no(i);
        }
        if (this.dVO != null) {
            this.dVO.clear();
        }
        g(iVar);
        if (this.aaB != null) {
            this.dVN = com.baidu.live.c.np().getString("ala_active_view_click_info", "");
            aNP();
            aNQ();
        }
    }

    @Override // com.baidu.live.liveroom.a.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.dVO == null) {
            this.dVO = new HashMap();
        }
        this.dVO.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        nm(i);
    }

    private void aNP() {
        this.dVQ = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.aaB == null || b.this.aaB.mLiveInfo == null || b.this.aaB.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aaB.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.aNR();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.uq() != null) {
                            b.this.TQ = getLiveActivityHttpResponseMessage.uq().TQ;
                            b.this.a(getLiveActivityHttpResponseMessage.uq());
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dVQ);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.dVP != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.dVP.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.dVP != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.dVP.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).aNZ()) {
                        aNT();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.dVM != null) {
            this.dVM.resume();
        }
        aNQ();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.dVP != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.dVP.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.dVM != null) {
            this.dVM.pause();
        }
        aNS();
        aNU();
    }

    @Override // com.baidu.live.liveroom.a.a
    public void g(i iVar) {
        this.aaB = iVar;
    }

    public void setVisible(int i) {
        if (this.dVW) {
            i = 8;
        }
        if (this.dVP != null) {
            int i2 = 1;
            while (true) {
                int i3 = i2;
                if (i3 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.dVP.get(Integer.valueOf(i3));
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

    public void aR(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        if (this.dVW) {
            i2 = 8;
        }
        if (this.dVP != null && (alaActiveRootView = this.dVP.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(i2);
        }
    }

    public void tv(String str) {
        if (d.uI().cO(str)) {
            aNQ();
        }
    }

    public void release() {
        this.aaB = null;
        if (this.dVQ != null) {
            MessageManager.getInstance().unRegisterListener(this.dVQ);
            this.dVQ = null;
        }
        if (this.dVR != null) {
            MessageManager.getInstance().unRegisterListener(this.dVR);
            this.dVR = null;
        }
        if (this.dFq != null) {
            MessageManager.getInstance().unRegisterListener(this.dFq);
            this.dFq = null;
        }
        if (this.dVT != null) {
            this.dVT.removeCallbacksAndMessages(null);
        }
        d.uI().release();
        aNU();
        if (this.dVP != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.dVP.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    if (alaActiveRootView.getParent() != null) {
                        ((ViewGroup) alaActiveRootView.getParent()).removeView(alaActiveRootView);
                    }
                }
                i = i2 + 1;
            }
            this.dVP.clear();
        }
        if (this.dVM != null) {
            this.dVM.release();
            this.dVM = null;
        }
    }

    public void hk(boolean z) {
        this.dVW = z;
    }

    public void bw(int i) {
        if (this.dVM != null) {
            this.dVM.bw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNQ() {
        if (this.aaB != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.l.b.uF().d(this.aaB.PN.userId, this.aaB.Ps.userId, this.aaB.mLiveInfo.room_id, this.aaB.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ac acVar) {
        com.baidu.live.l.b.uF().akh = acVar;
        bC(acVar.TR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNR() {
        if (this.mRunning) {
            if (this.dVT == null) {
                this.dVT = new HandlerC0356b(this);
            }
            if (this.dVU == null) {
                this.dVU = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.aNQ();
                    }
                };
            }
            aNS();
            if (this.TQ <= 0) {
                this.TQ = 5;
            }
            this.dVT.postDelayed(this.dVU, this.TQ * 1000);
        }
    }

    private void aNS() {
        if (this.dVT != null && this.dVU != null) {
            this.dVT.removeCallbacks(this.dVU);
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
                    if (cVar.Ph == 1) {
                        long j = cVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= cVar.showTime && j <= cVar.end_time && cVar.Pm != null && cVar.Pm.pos >= 0 && cVar.Pm.pos <= 2) {
                            if (cVar.Pm.pos == 0) {
                                cVar.Pm.pos = 1;
                            }
                            switch (cVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(cVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(cVar.Pm.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(cVar.Pm.pos), list2);
                                        }
                                        list2.add(cVar);
                                        if (!z2 || cVar.Pl == null) {
                                            z = z2;
                                        } else {
                                            d.uI().a(cVar.Pl);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(cVar.Pm.pos));
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
                                    if (!TextUtils.isEmpty(cVar.webUrl) && cVar.Pm != null && cVar.Pm.width > 0 && cVar.Pm.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(cVar.Pm.pos));
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
            d.uI().a(null);
        }
        for (int i = 1; i <= 2; i++) {
            g(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private void g(int i, List<com.baidu.live.data.c> list) {
        com.baidu.live.data.c cVar;
        int i2;
        if (list == null || list.isEmpty()) {
            no(i);
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
                no(i);
                return;
            case 3:
                b(i, cVar);
                return;
        }
    }

    private ViewGroup nm(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.dVP == null || (alaActiveRootView = this.dVP.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.dVO != null && (cVar = this.dVO.get(Integer.valueOf(i))) != null && (viewGroup = cVar.dWb) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.dVP == null) {
                    this.dVP = new HashMap();
                }
                this.dVP.put(Integer.valueOf(i), alaActiveRootView2);
                if (cVar.dWc != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.dWc);
                } else {
                    viewGroup.addView(alaActiveRootView2);
                }
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private AlaActiveRootView nn(int i) {
        if (this.dVP != null) {
            return this.dVP.get(Integer.valueOf(i));
        }
        return null;
    }

    private void a(int i, ArrayList<com.baidu.live.data.c> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            no(i);
            return;
        }
        AlaActiveRootView nn = nn(i);
        if (nn != null && nn.getChildCount() == 1) {
            View lastChild = nn.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return;
            }
        }
        no(i);
        ViewGroup nm = nm(i);
        if (nm != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(nm.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.dVi);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.dVX || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.dVX && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
                layoutParams.bottomMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            }
            nm.addView(alaActiveBannerView, layoutParams);
        }
    }

    private void a(int i, com.baidu.live.data.c cVar) {
        AlaActiveRootView nn = nn(i);
        if (nn != null && nn.getChildCount() == 1) {
            View lastChild = nn.getLastChild();
            if (lastChild instanceof AlaActiveDynamicView) {
                ((AlaActiveDynamicView) lastChild).setActivityInfo(cVar);
                return;
            }
        }
        no(i);
        ViewGroup nm = nm(i);
        if (nm != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(nm.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(com.baidu.live.data.c cVar2) {
                    if (b.this.dVi != null) {
                        b.this.dVi.a(alaActiveDynamicView, cVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(cVar);
            if (cVar.OW && this.dVi.nq(cVar.Pf)) {
                cVar.OW = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.dVX || i == 2) {
                layoutParams.gravity = 5;
            }
            nm.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(int i, com.baidu.live.data.c cVar) {
        String l = l(cVar.webUrl, cVar.jump_url, cVar.Pk);
        if (!TextUtils.isEmpty(l) && cVar.Pm != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, cVar.Pm.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, cVar.Pm.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension != 0 && applyDimension2 != 0) {
                AlaActiveRootView nn = nn(i);
                if (nn != null && nn.getChildCount() == 1) {
                    View lastChild = nn.getLastChild();
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
                no(i);
                ViewGroup nm = nm(i);
                if (nm != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(nm.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void hl(boolean z) {
                            if (z) {
                                b.this.aNT();
                            }
                        }
                    });
                    f fVar = new f();
                    fVar.az(this.mPageContext.getPageActivity()).a((e) null).a(alaActiveWebView.getSchemeCallback()).b(this.atV);
                    com.baidu.live.view.web.a[] wO = fVar.wO();
                    for (com.baidu.live.view.web.a aVar : wO) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(l);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.dVX || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    nm.addView(alaActiveWebView, layoutParams2);
                }
            }
        }
    }

    private String l(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aaB != null) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("user_id=");
            sb.append(this.aaB.PN.userId);
            sb.append("&charm_user_id=");
            sb.append(this.aaB.Ps.userId);
            sb.append("&room_id=");
            sb.append(this.aaB.mLiveInfo.room_id);
            sb.append("&live_id=");
            sb.append(this.aaB.mLiveInfo.live_id);
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
    public void aNT() {
        if (Build.VERSION.SDK_INT >= 19) {
            aNW();
            if (this.dVT == null) {
                this.dVT = new HandlerC0356b(this);
            }
            if (!this.dVT.hasMessages(1000)) {
                this.dVT.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void aNU() {
        if (this.dVV != null) {
            this.dVV.clear();
        }
        if (this.dVT != null) {
            this.dVT.removeMessages(1000);
        }
        aNX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNV() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.dVP != null) {
            if (this.dVV == null || (size = this.dVV.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.dVV.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.dVV.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.dVP.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).aNZ()) {
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
                this.dVT.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                aNU();
            }
        }
    }

    private void aNW() {
        if (this.dVV == null) {
            this.dVV = new ArrayList();
        }
        this.dVV.clear();
        this.dVS = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.dVV.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.dVS);
    }

    private void aNX() {
        if (this.dVS != null) {
            MessageManager.getInstance().unRegisterListener(this.dVS);
            this.dVS = null;
        }
    }

    private void no(int i) {
        AlaActiveRootView nn = nn(i);
        if (nn != null) {
            nn.release();
        }
    }

    private void c(com.baidu.live.data.c cVar) {
        aNY();
        d.uI().c(this.aaB.mLiveInfo.user_id, this.aaB.mLiveInfo.live_id, cVar.activityId);
    }

    private void aNY() {
        if (this.dVR == null) {
            this.dVR = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.up() != null && b.this.dVP != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.e)) {
                            int id = ((com.baidu.live.message.e) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.dVP.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.up());
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
            MessageManager.getInstance().registerListener(this.dVR);
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
            c.a aVar = activityInfo.Pl;
            long j = aVar != null ? (aVar.endTime - aVar.Pp) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.nl(2);
                alaActiveDynamicView.setTimer(adVar.TY + " *" + aVar.Po);
                alaActiveDynamicView.p(j, aVar.endTime);
            } else {
                alaActiveDynamicView.nl(1);
            }
            if (z) {
                d(activityInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(str.contains("?") ? "&" : "?");
                sb.append("room");
                sb.append("=");
                sb.append(1);
                tw(sb.toString());
                return;
            }
            BrowserHelper.startInternalWebActivity(this.mPageContext.getPageActivity(), str);
        }
    }

    public void tw(String str) {
        int i = 2;
        if (this.dVM == null) {
            this.dVM = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.dVM.setHost(this.isHost);
        if (this.aaB != null && this.aaB.mLiveInfo != null) {
            this.dVM.c(this.aaB.mLiveInfo.user_id, this.aaB.mLiveInfo.getNameShow());
        }
        if (!this.dVX) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.dVM.ah(str, i);
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
        if (!this.isHost && cVar != null && this.aaB != null && this.aaB.mLiveInfo != null) {
            String str = this.aaB.mLiveInfo.feed_id;
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
    public void np(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.dVN)) {
                jSONArray = new JSONArray(this.dVN);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.dVN = jSONArray.toString();
            com.baidu.live.c.np().putString("ala_active_view_click_info", this.dVN);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nq(int i) {
        if (StringUtils.isNull(this.dVN)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.dVN);
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
        ViewGroup dWb;
        ViewGroup.LayoutParams dWc;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.dWb = viewGroup;
            this.dWc = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class HandlerC0356b extends Handler {
        private final WeakReference<b> dWa;

        HandlerC0356b(b bVar) {
            this.dWa = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.dWa.get() != null && message.what == 1000) {
                this.dWa.get().aNV();
            }
        }
    }
}
