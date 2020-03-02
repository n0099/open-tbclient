package com.baidu.tieba.ala.liveroom.activeview;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.SimpleArrayMap;
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
import com.baidu.live.data.ak;
import com.baidu.live.data.al;
import com.baidu.live.data.f;
import com.baidu.live.data.m;
import com.baidu.live.message.GetLiveActivityDynamicHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.u.a;
import com.baidu.live.v.d;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.live.view.web.e;
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
/* loaded from: classes3.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private int acx;
    private long aiH;
    private m ald;
    private com.baidu.tieba.ala.liveroom.a.c ePH;
    private Map<Integer, c> ePJ;
    private Map<Integer, AlaActiveRootView> ePK;
    private HttpMessageListener ePO;
    private HttpMessageListener ePP;
    private CustomMessageListener ePQ;
    private CustomMessageListener ePR;
    private HandlerC0453b ePS;
    private Runnable ePT;
    private List<String> ePU;
    private boolean ePV;
    private boolean ePW;
    private boolean ePX;
    private com.baidu.live.g.a ePY;
    private TbPageContext mPageContext;
    private String otherParams;
    private String ePI = "";
    private boolean isHost = false;
    private SimpleArrayMap<Integer, Integer> ePL = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> ePM = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> ePN = new ArrayList<>();
    private g aGz = new g() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
        @Override // com.baidu.live.view.web.g
        public void eq(String str) {
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
                    b.this.yL(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a ePd = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean pO(int i) {
            return b.this.pO(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aiH >= 400) {
                b.this.aiH = currentTimeMillis;
                if ((obj instanceof f) && b.this.ald != null && b.this.ald.XQ != null && b.this.ald.mLiveInfo != null) {
                    f fVar = (f) obj;
                    String str2 = fVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.ald != null && b.this.ald.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.ald.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.ald.XQ.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.ald.XQ.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.ald.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.ald.XQ.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!pO(fVar.XC)) {
                        b.this.pN(fVar.XC);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).pH(i);
                        } else if ((view instanceof AlaActiveDynamicView) && fVar.Xt && b.this.ePd.pO(fVar.XC)) {
                            fVar.Xt = false;
                        }
                    }
                    b.this.an(fVar.XH, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.ald.mLiveInfo != null) {
                        str3 = b.this.ald.mLiveInfo.feed_id;
                        str4 = b.this.ald.mLiveInfo.live_id + "";
                    }
                    b.this.a(fVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener evL = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.ePK != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.ePK.get(Integer.valueOf(i2));
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

    /* loaded from: classes3.dex */
    public interface a {
        void a(View view, Object obj, int i);

        boolean pO(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.evL);
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(m mVar, boolean z) {
        this.ePX = z;
        for (int i = 1; i <= 2; i++) {
            pM(i);
        }
        if (this.ePJ != null) {
            this.ePJ.clear();
        }
        h(mVar);
        if (this.ald != null) {
            this.ePI = com.baidu.live.c.pr().getString("ala_active_view_click_info", "");
            bhR();
            bhS();
            bhT();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.ePJ == null) {
            this.ePJ = new HashMap();
        }
        this.ePJ.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        pK(i);
    }

    private void bhR() {
        this.ePO = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.ald == null || b.this.ald.mLiveInfo == null || b.this.ald.mLiveInfo.mAlaLiveSwitchData == null || !b.this.ald.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.bhU();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.yV() != null) {
                            b.this.acx = getLiveActivityHttpResponseMessage.yV().acx;
                            b.this.a(getLiveActivityHttpResponseMessage.yV());
                            b.this.updateView();
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ePO);
    }

    private void bhS() {
        this.ePR = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    b.this.yL((String) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ePR);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.ePK != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.ePK.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.ePK != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.ePK.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bie()) {
                        bhY();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.ePH != null) {
            this.ePH.resume();
        }
        bhT();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.ePK != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.ePK.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.ePH != null) {
            this.ePH.pause();
        }
        bhV();
        bhZ();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void h(m mVar) {
        this.ald = mVar;
    }

    public void setVisible(int i) {
        if (this.ePK != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                i = bk(i2, i);
                bj(i2, i);
            }
        }
    }

    public void bj(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        int bk = bk(i, i2);
        if (this.ePK != null && (alaActiveRootView = this.ePK.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bk);
        }
    }

    private int bk(int i, int i2) {
        if (this.ePL == null || this.ePL.get(Integer.valueOf(i)) == null) {
            if (this.ePV) {
                if (i2 != 8) {
                    if (this.ePW) {
                        if (i == 1) {
                            if (this.ePM.get(1) == null || this.ePM.get(1).intValue() != 3) {
                                return i2;
                            }
                            return 8;
                        } else if (i == 2) {
                            if (this.ePM.get(2) != null && this.ePM.get(2).intValue() == 3) {
                                return 8;
                            }
                            if (this.ePK != null && this.ePK.get(1) != null) {
                                if (this.ePK.get(1).getVisibility() != 0 || this.ePK.get(1).getChildCount() == 0) {
                                    return i2;
                                }
                                return 8;
                            }
                        }
                    } else if (i == 1) {
                        if (this.ePM.get(1) == null || this.ePM.get(1).intValue() == 3 || this.ePM.get(2) == null || this.ePM.get(2).intValue() != 3) {
                            return i2;
                        }
                        return 8;
                    } else if (i == 2 && this.ePK != null && this.ePK.get(1) != null) {
                        if (this.ePK.get(1).getVisibility() != 0 || this.ePK.get(1).getChildCount() == 0) {
                            return i2;
                        }
                        return 8;
                    }
                }
                return 8;
            }
            return i2;
        }
        return 8;
    }

    public void yK(String str) {
        if (d.zs().dY(str)) {
            bhT();
        }
    }

    public void release() {
        this.ald = null;
        if (this.ePO != null) {
            MessageManager.getInstance().unRegisterListener(this.ePO);
            this.ePO = null;
        }
        if (this.ePP != null) {
            MessageManager.getInstance().unRegisterListener(this.ePP);
            this.ePP = null;
        }
        if (this.evL != null) {
            MessageManager.getInstance().unRegisterListener(this.evL);
            this.evL = null;
        }
        if (this.ePR != null) {
            MessageManager.getInstance().unRegisterListener(this.ePR);
            this.ePR = null;
        }
        if (this.ePS != null) {
            this.ePS.removeCallbacksAndMessages(null);
        }
        d.zs().release();
        bhZ();
        if (this.ePK != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.ePK.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    removeFromParent(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.ePK.clear();
        }
        if (this.ePH != null) {
            this.ePH.release();
            this.ePH = null;
        }
    }

    public void iM(boolean z) {
        this.ePV = z;
    }

    public void iN(boolean z) {
        this.ePW = z;
    }

    public void updateView() {
        if (this.ePK != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    if (this.ePK.get(Integer.valueOf(i2)) != null) {
                        bj(i2, 0);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, int i2) {
        AlaActiveRootView alaActiveRootView;
        if (this.ePK != null && viewGroup != null && (alaActiveRootView = this.ePK.get(Integer.valueOf(i))) != null) {
            removeFromParent(alaActiveRootView);
            alaActiveRootView.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(i2));
            viewGroup.addView(alaActiveRootView, layoutParams);
        }
    }

    public void bW(int i) {
        if (this.ePH != null) {
            this.ePH.bW(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhT() {
        if (this.ald != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.v.b.zp().d(this.ald.Ye.userId, this.ald.XQ.userId, this.ald.mLiveInfo.room_id, this.ald.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ak akVar) {
        com.baidu.live.v.b.zp().awK = akVar;
        bB(akVar.acy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhU() {
        if (this.mRunning) {
            if (this.ePS == null) {
                this.ePS = new HandlerC0453b(this);
            }
            if (this.ePT == null) {
                this.ePT = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bhT();
                    }
                };
            }
            bhV();
            if (this.acx <= 0) {
                this.acx = 5;
            }
            this.ePS.postDelayed(this.ePT, this.acx * 1000);
        }
    }

    private void bhV() {
        if (this.ePS != null && this.ePT != null) {
            this.ePS.removeCallbacks(this.ePT);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bB(List<f> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (f fVar : list) {
                if (fVar != null) {
                    if (fVar.XE == 1) {
                        long j = fVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= fVar.showTime && j <= fVar.end_time && fVar.XJ != null && fVar.XJ.pos >= 0 && fVar.XJ.pos <= 2) {
                            if (fVar.XJ.pos == 0) {
                                fVar.XJ.pos = 1;
                            }
                            switch (fVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(fVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(fVar.XJ.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(fVar.XJ.pos), list2);
                                        }
                                        list2.add(fVar);
                                        if (!z2 || fVar.XI == null) {
                                            z = z2;
                                        } else {
                                            d.zs().b(fVar.XI);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(fVar.XJ.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(fVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(fVar.webUrl) && fVar.XJ != null && fVar.XJ.width > 0 && fVar.XJ.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(fVar.XJ.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(fVar);
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
            d.zs().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            j(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r0.picType;
        r2 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void j(int i, List<f> list) {
        int i2;
        f fVar = null;
        if (list == null || list.isEmpty()) {
            bhW();
            pM(i);
            return;
        }
        Iterator<f> it = list.iterator();
        ArrayList<f> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            f next = it.next();
            if (next.picType != 1 && next.picType != 3) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(next);
                if (arrayList.size() >= 5) {
                    i2 = 0;
                    break;
                }
            } else {
                break;
            }
        }
        this.ePM.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                a(i, arrayList, "");
                break;
            case 1:
                a(i, fVar);
                c(fVar);
                break;
            case 2:
            default:
                pM(i);
                break;
            case 3:
                b(i, fVar);
                break;
        }
        bhX();
    }

    private void bhW() {
        if (this.ePY != null) {
            Iterator<com.baidu.live.g.b> it = this.ePN.iterator();
            while (it.hasNext()) {
                this.ePY.b(it.next());
            }
            this.ePN.clear();
            this.ePY.qQ();
        }
    }

    private void bhX() {
        if (this.ePY != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView pL = pL(i);
                if (pL != null && pL.getVisibility() == 0 && pL.getChildCount() > 0 && !this.ePN.contains(pL)) {
                    this.ePN.add(pL);
                    this.ePY.a(pL);
                }
            }
            this.ePY.qQ();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.ePY = aVar;
    }

    private ViewGroup pK(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.ePK == null || (alaActiveRootView = this.ePK.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.ePJ != null && (cVar = this.ePJ.get(Integer.valueOf(i))) != null && (viewGroup = cVar.eQc) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.ePK == null) {
                    this.ePK = new HashMap();
                }
                this.ePK.put(Integer.valueOf(i), alaActiveRootView2);
                if (viewGroup instanceof PriorityVerticalLinearLayout) {
                    alaActiveRootView2.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(this.ePX ? 1 : 22));
                }
                removeFromParent(alaActiveRootView2);
                if (cVar.eQd != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.eQd);
                } else {
                    viewGroup.addView(alaActiveRootView2);
                }
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void removeFromParent(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView pL(int i) {
        if (this.ePK != null) {
            return this.ePK.get(Integer.valueOf(i));
        }
        return null;
    }

    private void a(int i, ArrayList<f> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            pM(i);
            return;
        }
        AlaActiveRootView pL = pL(i);
        if (pL != null && pL.getChildCount() == 1) {
            View lastChild = pL.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return;
            }
        }
        this.ePL.put(Integer.valueOf(i), null);
        pM(i);
        ViewGroup pK = pK(i);
        if (pK != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(pK.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.ePd);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.ePX || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.ePX && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            }
            pK.addView(alaActiveBannerView, layoutParams);
        }
    }

    private void a(int i, f fVar) {
        AlaActiveRootView pL = pL(i);
        if (pL != null && pL.getChildCount() == 1) {
            View lastChild = pL.getLastChild();
            if (lastChild instanceof AlaActiveDynamicView) {
                ((AlaActiveDynamicView) lastChild).setActivityInfo(fVar);
                return;
            }
        }
        this.ePL.put(Integer.valueOf(i), null);
        pM(i);
        ViewGroup pK = pK(i);
        if (pK != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(pK.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(f fVar2) {
                    if (b.this.ePd != null) {
                        b.this.ePd.a(alaActiveDynamicView, fVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(fVar);
            if (fVar.Xt && this.ePd.pO(fVar.XC)) {
                fVar.Xt = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.ePX || i == 2) {
                layoutParams.gravity = 5;
            }
            pK.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(final int i, f fVar) {
        String o = o(fVar.webUrl, fVar.jump_url, fVar.XH);
        if (!TextUtils.isEmpty(o) && fVar.XJ != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, fVar.XJ.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, fVar.XJ.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension != 0 && applyDimension2 != 0) {
                AlaActiveRootView pL = pL(i);
                if (pL != null && pL.getChildCount() == 1) {
                    View lastChild = pL.getLastChild();
                    if (lastChild instanceof AlaActiveWebView) {
                        if (TextUtils.isEmpty(((AlaActiveWebView) lastChild).getOriginalUrl()) || !((AlaActiveWebView) lastChild).getOriginalUrl().equals(o)) {
                            ((AlaActiveWebView) lastChild).loadUrl("file:///android_asset/web/blank.html");
                            ((AlaActiveWebView) lastChild).loadUrl(o);
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
                this.ePL.put(Integer.valueOf(i), null);
                pM(i);
                ViewGroup pK = pK(i);
                if (pK != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(pK.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void iO(boolean z) {
                            if (z) {
                                b.this.bhY();
                            }
                        }
                    });
                    com.baidu.live.view.web.f fVar2 = new com.baidu.live.view.web.f();
                    fVar2.y(this.mPageContext.getPageActivity()).a(new e() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
                        @Override // com.baidu.live.view.web.e
                        public void cY(int i2) {
                            b.this.ePL.put(Integer.valueOf(i), 8);
                            b.this.updateView();
                        }
                    }).a(alaActiveWebView.getSchemeCallback()).b(this.aGz);
                    com.baidu.live.view.web.a[] BC = fVar2.BC();
                    for (com.baidu.live.view.web.a aVar : BC) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(o);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.ePX || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    pK.addView(alaActiveWebView, layoutParams2);
                }
            }
        }
    }

    private String o(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.ald != null) {
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("?")) {
                sb.append(ETAG.ITEM_SEPARATOR);
            } else {
                sb.append("?");
            }
            a(sb);
            sb.append("&jump_url=");
            sb.append(as(str2, i));
            return sb.toString();
        }
        return str;
    }

    private void a(StringBuilder sb) {
        sb.append("user_id=");
        sb.append(this.ald.Ye.userId);
        sb.append("&charm_user_id=");
        sb.append(this.ald.XQ.userId);
        sb.append("&room_id=");
        sb.append(this.ald.mLiveInfo.room_id);
        sb.append("&live_id=");
        sb.append(this.ald.mLiveInfo.live_id);
        sb.append("&subapp_type=");
        sb.append(TbConfig.getSubappType());
        sb.append("&_client_type=");
        sb.append("2");
        sb.append("&_sdk_version=");
        sb.append(TbConfig.SDK_VERSION);
        if (this.isHost) {
            sb.append("&is_host=1");
        }
    }

    private String as(String str, int i) {
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
    public void bhY() {
        if (Build.VERSION.SDK_INT >= 19) {
            bib();
            if (this.ePS == null) {
                this.ePS = new HandlerC0453b(this);
            }
            if (!this.ePS.hasMessages(1000)) {
                this.ePS.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bhZ() {
        if (this.ePU != null) {
            this.ePU.clear();
        }
        if (this.ePS != null) {
            this.ePS.removeMessages(1000);
        }
        bic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bia() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.ePK != null) {
            if (this.ePU == null || (size = this.ePU.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.ePU.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.ePU.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.ePK.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bie()) {
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
                this.ePS.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bhZ();
            }
        }
    }

    private void bib() {
        if (this.ePU == null) {
            this.ePU = new ArrayList();
        }
        this.ePU.clear();
        this.ePQ = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.ePU.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.ePQ);
    }

    private void bic() {
        if (this.ePQ != null) {
            MessageManager.getInstance().unRegisterListener(this.ePQ);
            this.ePQ = null;
        }
    }

    private void pM(int i) {
        AlaActiveRootView pL = pL(i);
        if (pL != null) {
            pL.release();
        }
    }

    private void c(f fVar) {
        bid();
        d.zs().c(this.ald.mLiveInfo.user_id, this.ald.mLiveInfo.live_id, fVar.activityId);
    }

    private void bid() {
        if (this.ePP == null) {
            this.ePP = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.yU() != null && b.this.ePK != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.g)) {
                            int id = ((com.baidu.live.message.g) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.ePK.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.yU());
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
            MessageManager.getInstance().registerListener(this.ePP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaActiveDynamicView alaActiveDynamicView, al alVar) {
        boolean z = false;
        f activityInfo = alaActiveDynamicView.getActivityInfo();
        if (activityInfo != null) {
            alaActiveDynamicView.setData(activityInfo.pic_url, alVar);
            if (alaActiveDynamicView.getVisibility() != 0) {
                alaActiveDynamicView.setVisibility(0);
                z = true;
            }
            f.a aVar = activityInfo.XI;
            long j = aVar != null ? (aVar.endTime - aVar.currentTime) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.oX(2);
                alaActiveDynamicView.setTimer(alVar.acE + " *" + aVar.XM);
                alaActiveDynamicView.u(j, aVar.endTime);
            } else {
                alaActiveDynamicView.oX(1);
            }
            if (z) {
                d(activityInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                StringBuilder sb = new StringBuilder(str);
                sb.append(str.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
                sb.append("room");
                sb.append(ETAG.EQUAL);
                sb.append(1);
                sb.append(ETAG.ITEM_SEPARATOR);
                a(sb);
                yL(sb.toString());
                return;
            }
            if (i == 1) {
                StringBuilder sb2 = new StringBuilder(str);
                sb2.append(str.contains("?") ? ETAG.ITEM_SEPARATOR : "?");
                a(sb2);
                str = sb2.toString();
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void yL(String str) {
        int i = 2;
        if (this.ePH == null) {
            this.ePH = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.ePH.setHost(this.isHost);
        if (this.ald != null && this.ald.mLiveInfo != null) {
            this.ePH.e(this.ald.mLiveInfo.user_id, this.ald.mLiveInfo.getNameShow());
        }
        if (!this.ePX) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.ePH.ap(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, String str, String str2) {
        if (!this.isHost && fVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, fVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    private void d(f fVar) {
        if (!this.isHost && fVar != null && this.ald != null && this.ald.mLiveInfo != null) {
            String str = this.ald.mLiveInfo.feed_id;
            if (!TextUtils.isEmpty(str)) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                    alaStaticItem.addParams("feed_id", str);
                    alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, fVar.activityId + "");
                    alaStaticItem.addParams("other_params", this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pN(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.ePI)) {
                jSONArray = new JSONArray(this.ePI);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.ePI = jSONArray.toString();
            com.baidu.live.c.pr().putString("ala_active_view_click_info", this.ePI);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pO(int i) {
        if (StringUtils.isNull(this.ePI)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.ePI);
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
    /* loaded from: classes3.dex */
    public class c {
        ViewGroup eQc;
        ViewGroup.LayoutParams eQd;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.eQc = viewGroup;
            this.eQd = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0453b extends Handler {
        private final WeakReference<b> eQb;

        HandlerC0453b(b bVar) {
            this.eQb = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.eQb.get() != null && message.what == 1000) {
                this.eQb.get().bia();
            }
        }
    }
}
