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
    private int acH;
    private long aiR;
    private m alp;
    private HttpMessageListener eQA;
    private CustomMessageListener eQB;
    private CustomMessageListener eQC;
    private HandlerC0453b eQD;
    private Runnable eQE;
    private List<String> eQF;
    private boolean eQG;
    private boolean eQH;
    private boolean eQI;
    private com.baidu.live.g.a eQJ;
    private com.baidu.tieba.ala.liveroom.a.c eQs;
    private Map<Integer, c> eQu;
    private Map<Integer, AlaActiveRootView> eQv;
    private HttpMessageListener eQz;
    private TbPageContext mPageContext;
    private String otherParams;
    private String eQt = "";
    private boolean isHost = false;
    private SimpleArrayMap<Integer, Integer> eQw = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> eQx = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> eQy = new ArrayList<>();
    private g aGO = new g() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
        @Override // com.baidu.live.view.web.g
        public void ep(String str) {
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
                    b.this.yN(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a ePO = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean pQ(int i) {
            return b.this.pQ(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aiR >= 400) {
                b.this.aiR = currentTimeMillis;
                if ((obj instanceof f) && b.this.alp != null && b.this.alp.Ya != null && b.this.alp.mLiveInfo != null) {
                    f fVar = (f) obj;
                    String str2 = fVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.alp != null && b.this.alp.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.alp.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.alp.Ya.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.alp.Ya.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.alp.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.alp.Ya.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!pQ(fVar.XM)) {
                        b.this.pP(fVar.XM);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).pJ(i);
                        } else if ((view instanceof AlaActiveDynamicView) && fVar.XD && b.this.ePO.pQ(fVar.XM)) {
                            fVar.XD = false;
                        }
                    }
                    b.this.an(fVar.XR, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.alp.mLiveInfo != null) {
                        str3 = b.this.alp.mLiveInfo.feed_id;
                        str4 = b.this.alp.mLiveInfo.live_id + "";
                    }
                    b.this.a(fVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener ewu = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.eQv != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.eQv.get(Integer.valueOf(i2));
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

        boolean pQ(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        MessageManager.getInstance().registerListener(this.ewu);
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(m mVar, boolean z) {
        this.eQI = z;
        for (int i = 1; i <= 2; i++) {
            pO(i);
        }
        if (this.eQu != null) {
            this.eQu.clear();
        }
        h(mVar);
        if (this.alp != null) {
            this.eQt = com.baidu.live.c.pw().getString("ala_active_view_click_info", "");
            bhX();
            bhY();
            bhZ();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.eQu == null) {
            this.eQu = new HashMap();
        }
        this.eQu.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        pM(i);
    }

    private void bhX() {
        this.eQz = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.alp == null || b.this.alp.mLiveInfo == null || b.this.alp.mLiveInfo.mAlaLiveSwitchData == null || !b.this.alp.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.bia();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.za() != null) {
                            b.this.acH = getLiveActivityHttpResponseMessage.za().acH;
                            b.this.a(getLiveActivityHttpResponseMessage.za());
                            b.this.updateView();
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eQz);
    }

    private void bhY() {
        this.eQC = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    b.this.yN((String) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eQC);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.eQv != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.eQv.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.eQv != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.eQv.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bik()) {
                        bie();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.eQs != null) {
            this.eQs.resume();
        }
        bhZ();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.eQv != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.eQv.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.eQs != null) {
            this.eQs.pause();
        }
        bib();
        bif();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void h(m mVar) {
        this.alp = mVar;
    }

    public void setVisible(int i) {
        if (this.eQv != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                i = bl(i2, i);
                bk(i2, i);
            }
        }
    }

    public void bk(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        int bl = bl(i, i2);
        if (this.eQv != null && (alaActiveRootView = this.eQv.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bl);
        }
    }

    private int bl(int i, int i2) {
        if (this.eQw == null || this.eQw.get(Integer.valueOf(i)) == null) {
            if (this.eQG) {
                if (i2 != 8) {
                    if (this.eQH) {
                        if (i == 1) {
                            if (this.eQx.get(1) == null || this.eQx.get(1).intValue() != 3) {
                                return i2;
                            }
                            return 8;
                        } else if (i == 2) {
                            if (this.eQx.get(2) != null && this.eQx.get(2).intValue() == 3) {
                                return 8;
                            }
                            if (this.eQv != null && this.eQv.get(1) != null) {
                                if (this.eQv.get(1).getVisibility() != 0 || this.eQv.get(1).getChildCount() == 0) {
                                    return i2;
                                }
                                return 8;
                            }
                        }
                    } else if (i == 1) {
                        if (this.eQx.get(1) == null || this.eQx.get(1).intValue() == 3 || this.eQx.get(2) == null || this.eQx.get(2).intValue() != 3) {
                            return i2;
                        }
                        return 8;
                    } else if (i == 2 && this.eQv != null && this.eQv.get(1) != null) {
                        if (this.eQv.get(1).getVisibility() != 0 || this.eQv.get(1).getChildCount() == 0) {
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

    public void yM(String str) {
        if (d.zz().dX(str)) {
            bhZ();
        }
    }

    public void release() {
        this.alp = null;
        if (this.eQz != null) {
            MessageManager.getInstance().unRegisterListener(this.eQz);
            this.eQz = null;
        }
        if (this.eQA != null) {
            MessageManager.getInstance().unRegisterListener(this.eQA);
            this.eQA = null;
        }
        if (this.ewu != null) {
            MessageManager.getInstance().unRegisterListener(this.ewu);
            this.ewu = null;
        }
        if (this.eQC != null) {
            MessageManager.getInstance().unRegisterListener(this.eQC);
            this.eQC = null;
        }
        if (this.eQD != null) {
            this.eQD.removeCallbacksAndMessages(null);
        }
        d.zz().release();
        bif();
        if (this.eQv != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.eQv.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    removeFromParent(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.eQv.clear();
        }
        if (this.eQs != null) {
            this.eQs.release();
            this.eQs = null;
        }
    }

    public void iO(boolean z) {
        this.eQG = z;
    }

    public void iP(boolean z) {
        this.eQH = z;
    }

    public void updateView() {
        if (this.eQv != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    if (this.eQv.get(Integer.valueOf(i2)) != null) {
                        bk(i2, 0);
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
        if (this.eQv != null && viewGroup != null && (alaActiveRootView = this.eQv.get(Integer.valueOf(i))) != null) {
            removeFromParent(alaActiveRootView);
            alaActiveRootView.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(i2));
            viewGroup.addView(alaActiveRootView, layoutParams);
        }
    }

    public void bW(int i) {
        if (this.eQs != null) {
            this.eQs.bW(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhZ() {
        if (this.alp != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.v.b.zw().d(this.alp.Yo.userId, this.alp.Ya.userId, this.alp.mLiveInfo.room_id, this.alp.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ak akVar) {
        com.baidu.live.v.b.zw().awV = akVar;
        bB(akVar.acI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bia() {
        if (this.mRunning) {
            if (this.eQD == null) {
                this.eQD = new HandlerC0453b(this);
            }
            if (this.eQE == null) {
                this.eQE = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bhZ();
                    }
                };
            }
            bib();
            if (this.acH <= 0) {
                this.acH = 5;
            }
            this.eQD.postDelayed(this.eQE, this.acH * 1000);
        }
    }

    private void bib() {
        if (this.eQD != null && this.eQE != null) {
            this.eQD.removeCallbacks(this.eQE);
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
                    if (fVar.XO == 1) {
                        long j = fVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= fVar.showTime && j <= fVar.end_time && fVar.XT != null && fVar.XT.pos >= 0 && fVar.XT.pos <= 2) {
                            if (fVar.XT.pos == 0) {
                                fVar.XT.pos = 1;
                            }
                            switch (fVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(fVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(fVar.XT.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(fVar.XT.pos), list2);
                                        }
                                        list2.add(fVar);
                                        if (!z2 || fVar.XS == null) {
                                            z = z2;
                                        } else {
                                            d.zz().b(fVar.XS);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(fVar.XT.pos));
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
                                    if (!TextUtils.isEmpty(fVar.webUrl) && fVar.XT != null && fVar.XT.width > 0 && fVar.XT.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(fVar.XT.pos));
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
            d.zz().b(null);
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
            bic();
            pO(i);
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
        this.eQx.put(Integer.valueOf(i), Integer.valueOf(i2));
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
                pO(i);
                break;
            case 3:
                b(i, fVar);
                break;
        }
        bid();
    }

    private void bic() {
        if (this.eQJ != null) {
            Iterator<com.baidu.live.g.b> it = this.eQy.iterator();
            while (it.hasNext()) {
                this.eQJ.b(it.next());
            }
            this.eQy.clear();
            this.eQJ.qV();
        }
    }

    private void bid() {
        if (this.eQJ != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView pN = pN(i);
                if (pN != null && pN.getVisibility() == 0 && pN.getChildCount() > 0 && !this.eQy.contains(pN)) {
                    this.eQy.add(pN);
                    this.eQJ.a(pN);
                }
            }
            this.eQJ.qV();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.eQJ = aVar;
    }

    private ViewGroup pM(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.eQv == null || (alaActiveRootView = this.eQv.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.eQu != null && (cVar = this.eQu.get(Integer.valueOf(i))) != null && (viewGroup = cVar.eQN) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.eQv == null) {
                    this.eQv = new HashMap();
                }
                this.eQv.put(Integer.valueOf(i), alaActiveRootView2);
                if (viewGroup instanceof PriorityVerticalLinearLayout) {
                    alaActiveRootView2.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(this.eQI ? 1 : 22));
                }
                removeFromParent(alaActiveRootView2);
                if (cVar.eQO != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.eQO);
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

    public AlaActiveRootView pN(int i) {
        if (this.eQv != null) {
            return this.eQv.get(Integer.valueOf(i));
        }
        return null;
    }

    private void a(int i, ArrayList<f> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            pO(i);
            return;
        }
        AlaActiveRootView pN = pN(i);
        if (pN != null && pN.getChildCount() == 1) {
            View lastChild = pN.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return;
            }
        }
        this.eQw.put(Integer.valueOf(i), null);
        pO(i);
        ViewGroup pM = pM(i);
        if (pM != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(pM.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.ePO);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.eQI || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.eQI && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            }
            pM.addView(alaActiveBannerView, layoutParams);
        }
    }

    private void a(int i, f fVar) {
        AlaActiveRootView pN = pN(i);
        if (pN != null && pN.getChildCount() == 1) {
            View lastChild = pN.getLastChild();
            if (lastChild instanceof AlaActiveDynamicView) {
                ((AlaActiveDynamicView) lastChild).setActivityInfo(fVar);
                return;
            }
        }
        this.eQw.put(Integer.valueOf(i), null);
        pO(i);
        ViewGroup pM = pM(i);
        if (pM != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(pM.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(f fVar2) {
                    if (b.this.ePO != null) {
                        b.this.ePO.a(alaActiveDynamicView, fVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(fVar);
            if (fVar.XD && this.ePO.pQ(fVar.XM)) {
                fVar.XD = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.eQI || i == 2) {
                layoutParams.gravity = 5;
            }
            pM.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(final int i, f fVar) {
        String o = o(fVar.webUrl, fVar.jump_url, fVar.XR);
        if (!TextUtils.isEmpty(o) && fVar.XT != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, fVar.XT.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, fVar.XT.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension != 0 && applyDimension2 != 0) {
                AlaActiveRootView pN = pN(i);
                if (pN != null && pN.getChildCount() == 1) {
                    View lastChild = pN.getLastChild();
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
                this.eQw.put(Integer.valueOf(i), null);
                pO(i);
                ViewGroup pM = pM(i);
                if (pM != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(pM.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void iQ(boolean z) {
                            if (z) {
                                b.this.bie();
                            }
                        }
                    });
                    com.baidu.live.view.web.f fVar2 = new com.baidu.live.view.web.f();
                    fVar2.y(this.mPageContext.getPageActivity()).a(new e() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
                        @Override // com.baidu.live.view.web.e
                        public void cY(int i2) {
                            b.this.eQw.put(Integer.valueOf(i), 8);
                            b.this.updateView();
                        }
                    }).a(alaActiveWebView.getSchemeCallback()).b(this.aGO);
                    com.baidu.live.view.web.a[] BJ = fVar2.BJ();
                    for (com.baidu.live.view.web.a aVar : BJ) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(o);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.eQI || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    pM.addView(alaActiveWebView, layoutParams2);
                }
            }
        }
    }

    private String o(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.alp != null) {
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
        sb.append(this.alp.Yo.userId);
        sb.append("&charm_user_id=");
        sb.append(this.alp.Ya.userId);
        sb.append("&room_id=");
        sb.append(this.alp.mLiveInfo.room_id);
        sb.append("&live_id=");
        sb.append(this.alp.mLiveInfo.live_id);
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
    public void bie() {
        if (Build.VERSION.SDK_INT >= 19) {
            bih();
            if (this.eQD == null) {
                this.eQD = new HandlerC0453b(this);
            }
            if (!this.eQD.hasMessages(1000)) {
                this.eQD.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bif() {
        if (this.eQF != null) {
            this.eQF.clear();
        }
        if (this.eQD != null) {
            this.eQD.removeMessages(1000);
        }
        bii();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void big() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.eQv != null) {
            if (this.eQF == null || (size = this.eQF.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.eQF.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.eQF.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.eQv.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bik()) {
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
                this.eQD.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bif();
            }
        }
    }

    private void bih() {
        if (this.eQF == null) {
            this.eQF = new ArrayList();
        }
        this.eQF.clear();
        this.eQB = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.eQF.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.eQB);
    }

    private void bii() {
        if (this.eQB != null) {
            MessageManager.getInstance().unRegisterListener(this.eQB);
            this.eQB = null;
        }
    }

    private void pO(int i) {
        AlaActiveRootView pN = pN(i);
        if (pN != null) {
            pN.release();
        }
    }

    private void c(f fVar) {
        bij();
        d.zz().c(this.alp.mLiveInfo.user_id, this.alp.mLiveInfo.live_id, fVar.activityId);
    }

    private void bij() {
        if (this.eQA == null) {
            this.eQA = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.yZ() != null && b.this.eQv != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.g)) {
                            int id = ((com.baidu.live.message.g) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.eQv.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.yZ());
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
            MessageManager.getInstance().registerListener(this.eQA);
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
            f.a aVar = activityInfo.XS;
            long j = aVar != null ? (aVar.endTime - aVar.currentTime) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.oZ(2);
                alaActiveDynamicView.setTimer(alVar.acO + " *" + aVar.XW);
                alaActiveDynamicView.u(j, aVar.endTime);
            } else {
                alaActiveDynamicView.oZ(1);
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
                yN(sb.toString());
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

    public void yN(String str) {
        int i = 2;
        if (this.eQs == null) {
            this.eQs = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.eQs.setHost(this.isHost);
        if (this.alp != null && this.alp.mLiveInfo != null) {
            this.eQs.e(this.alp.mLiveInfo.user_id, this.alp.mLiveInfo.getNameShow());
        }
        if (!this.eQI) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.eQs.ap(str, i);
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
        if (!this.isHost && fVar != null && this.alp != null && this.alp.mLiveInfo != null) {
            String str = this.alp.mLiveInfo.feed_id;
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
    public void pP(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.eQt)) {
                jSONArray = new JSONArray(this.eQt);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.eQt = jSONArray.toString();
            com.baidu.live.c.pw().putString("ala_active_view_click_info", this.eQt);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean pQ(int i) {
        if (StringUtils.isNull(this.eQt)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.eQt);
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
        ViewGroup eQN;
        ViewGroup.LayoutParams eQO;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.eQN = viewGroup;
            this.eQO = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0453b extends Handler {
        private final WeakReference<b> eQM;

        HandlerC0453b(b bVar) {
            this.eQM = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.eQM.get() != null && message.what == 1000) {
                this.eQM.get().big();
            }
        }
    }
}
