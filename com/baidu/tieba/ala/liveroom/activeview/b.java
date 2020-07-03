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
import android.widget.LinearLayout;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.i;
import com.baidu.live.data.q;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
import com.baidu.live.pendantview.PendantParentView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StatisticItem;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.util.httpnet.HttpRequest;
import com.baidu.live.tbadk.scheme.SchemeUtils;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.util.WebviewHelper;
import com.baidu.live.v.d;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
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
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private long aJj;
    private q aLQ;
    private int ayh;
    private List<String> bdi;
    private CustomMessageListener bdk;
    private com.baidu.tieba.ala.liveroom.a.c fUf;
    private HttpMessageListener fUn;
    private HttpMessageListener fUo;
    private CustomMessageListener fUp;
    private HandlerC0564b fUq;
    private Runnable fUr;
    private boolean fUs;
    private com.baidu.live.g.a fUt;
    private String fUu;
    private TbPageContext mPageContext;
    private String otherParams;
    private String fUg = "";
    private boolean isHost = false;
    private Map<Integer, c> fUh = new HashMap();
    private Map<Integer, AlaActiveRootView> fUi = new HashMap();
    private SimpleArrayMap<Integer, Integer> fUj = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> fUk = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> fUl = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> fUm = new ArrayList<>();
    private h bpi = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
        @Override // com.baidu.live.view.web.h
        public void gd(String str) {
            boolean z = false;
            if (!TextUtils.isEmpty(str)) {
                String queryParameter = Uri.parse(str).getQueryParameter(UbcStatConstant.KEY_CONTENT_ROOM);
                if (TextUtils.isEmpty(queryParameter)) {
                    int indexOf = str.indexOf("room=");
                    int length = UbcStatConstant.KEY_CONTENT_ROOM.length() + 1;
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
                    b.this.CF(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a fTD = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean rm(int i) {
            return b.this.rm(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void a(View view, Object obj, int i) {
            if (obj instanceof i) {
                b.this.a(view, (i) obj, i);
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, Object obj, int i) {
            String str;
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aJj >= 400) {
                b.this.aJj = currentTimeMillis;
                if ((obj instanceof i) && b.this.aLQ != null && b.this.aLQ.axp != null && b.this.aLQ.mLiveInfo != null) {
                    i iVar = (i) obj;
                    String str2 = iVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aLQ != null && b.this.aLQ.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aLQ.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aLQ.axp.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aLQ.axp.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aLQ.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.aLQ.axp.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!rm(iVar.axb)) {
                        b.this.rl(iVar.axb);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).rf(i);
                        } else if ((view instanceof AlaActiveDynamicView) && iVar.awS && b.this.fTD.rm(iVar.axb)) {
                            iVar.awS = false;
                        }
                    }
                    b.this.aJ(iVar.axg, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aLQ.mLiveInfo != null) {
                        str3 = b.this.aLQ.mLiveInfo.feed_id;
                        str4 = b.this.aLQ.mLiveInfo.live_id + "";
                    }
                    b.this.b(iVar, str3, str4);
                    b.this.a(iVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener fzr = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.fUi != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.fUi.get(Integer.valueOf(i2));
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

        void b(View view, Object obj, int i);

        boolean rm(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.fUj.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.fzr);
    }

    public void CD(String str) {
        this.fUu = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(q qVar, boolean z) {
        this.fUs = z;
        for (int i = 1; i <= 2; i++) {
            rk(i);
        }
        if (this.fUh != null) {
            this.fUh.clear();
        }
        j(qVar);
        if (this.aLQ != null) {
            this.fUg = com.baidu.live.c.vf().getString("ala_active_view_click_info", "");
            bAd();
            bAe();
            bis();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.fUh.put(Integer.valueOf(i), new c(pendantParentView));
            ri(i);
        }
    }

    private void bAd() {
        if (this.fUn == null) {
            this.fUn = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aLQ == null || b.this.aLQ.mLiveInfo == null || b.this.aLQ.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aLQ.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bAf();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.Gb() != null) {
                                b.this.ayh = getLiveActivityHttpResponseMessage.Gb().ayh;
                                b.this.bQ(getLiveActivityHttpResponseMessage.Gb().aCz);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.fUn);
    }

    private void bAe() {
        if (this.fUp == null) {
            this.fUp = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.CF((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.fUp);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.fUi != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.fUi.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.fUi != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.fUi.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bAk()) {
                        GX();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.fUf != null) {
            this.fUf.resume();
        }
        bis();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.fUi != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fUi.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.fUf != null) {
            this.fUf.pause();
        }
        bAg();
        Hb();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void j(q qVar) {
        this.aLQ = qVar;
    }

    public void setVisible(int i) {
        if (this.fUi != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bx(i2, i);
            }
        }
    }

    public void bx(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.fUj.put(Integer.valueOf(i), Integer.valueOf(i2));
        int by = by(i, i2);
        if (this.fUi != null && (alaActiveRootView = this.fUi.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(by);
        }
    }

    private int by(int i, int i2) {
        if (this.fUk != null && this.fUk.get(Integer.valueOf(i)) != null) {
            return 8;
        }
        if (this.fUj != null && this.fUj.get(Integer.valueOf(i)).intValue() != 0) {
            return this.fUj.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void CE(String str) {
        if (d.Ht().fK(str)) {
            bis();
        }
    }

    public void release() {
        this.aLQ = null;
        this.fUu = null;
        if (this.fUn != null) {
            MessageManager.getInstance().unRegisterListener(this.fUn);
            this.fUn = null;
        }
        if (this.fUo != null) {
            MessageManager.getInstance().unRegisterListener(this.fUo);
            this.fUo = null;
        }
        if (this.fzr != null) {
            MessageManager.getInstance().unRegisterListener(this.fzr);
            this.fzr = null;
        }
        if (this.fUp != null) {
            MessageManager.getInstance().unRegisterListener(this.fUp);
            this.fUp = null;
        }
        if (this.fUq != null) {
            this.fUq.removeCallbacksAndMessages(null);
        }
        d.Ht().release();
        Hb();
        if (this.fUi != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fUi.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bC(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.fUi.clear();
        }
        if (this.fUf != null) {
            this.fUf.release();
            this.fUf = null;
        }
    }

    public void kw(boolean z) {
    }

    public void kx(boolean z) {
    }

    public void updateView() {
        if (this.fUi != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.fUi.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(by(i2, this.fUj.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void cA(int i) {
        if (this.fUf != null) {
            this.fUf.cA(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bis() {
        if (this.aLQ != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.v.b.Hq().d(this.aLQ.axI.userId, this.aLQ.axp.userId, this.aLQ.mLiveInfo.room_id, this.aLQ.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAf() {
        if (this.mRunning) {
            if (this.fUq == null) {
                this.fUq = new HandlerC0564b(this);
            }
            if (this.fUr == null) {
                this.fUr = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bis();
                    }
                };
            }
            bAg();
            if (this.ayh <= 0) {
                this.ayh = 5;
            }
            this.fUq.postDelayed(this.fUr, this.ayh * 1000);
        }
    }

    private void bAg() {
        if (this.fUq != null && this.fUr != null) {
            this.fUq.removeCallbacks(this.fUr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bQ(List<i> list) {
        HashMap hashMap;
        List list2;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (i iVar : list) {
                if (iVar != null) {
                    if (iVar.axd == 1) {
                        long j = iVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= iVar.showTime && j <= iVar.end_time && iVar.axi != null && iVar.axi.pos >= 0 && iVar.axi.pos <= 2) {
                            if (iVar.axi.pos == 0) {
                                iVar.axi.pos = 1;
                            }
                            switch (iVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(iVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(iVar.axi.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(iVar.axi.pos), list2);
                                        }
                                        list2.add(iVar);
                                        if (!z2 || iVar.axh == null) {
                                            z = z2;
                                        } else {
                                            d.Ht().b(iVar.axh);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(iVar.axi.pos));
                                    if (list2 == null) {
                                    }
                                    list2.add(iVar);
                                    if (z2) {
                                        break;
                                    }
                                    z = z2;
                                    z2 = z;
                                    break;
                                case 3:
                                    if (!TextUtils.isEmpty(iVar.webUrl) && iVar.axi != null && iVar.axi.width > 0 && iVar.axi.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(iVar.axi.pos));
                                        if (list2 == null) {
                                        }
                                        list2.add(iVar);
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
            d.Ht().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
        r0 = r0.picType;
        r2 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k(int i, List<i> list) {
        int i2;
        i iVar = null;
        boolean z = false;
        if (list == null || list.isEmpty()) {
            bAh();
            rk(i);
            return;
        }
        Iterator<i> it = list.iterator();
        ArrayList<i> arrayList = null;
        while (true) {
            if (!it.hasNext()) {
                i2 = 0;
                break;
            }
            i next = it.next();
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
        this.fUl.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                z = a(i, arrayList, "");
                break;
            case 1:
            case 2:
            default:
                rk(i);
                break;
            case 3:
                z = a(i, iVar);
                break;
        }
        c cVar = this.fUh.get(Integer.valueOf(i));
        if (cVar != null && cVar.fUw != null && z) {
            cVar.fUw.a(this.fUi.get(Integer.valueOf(i)));
        }
        bAi();
    }

    private void bAh() {
        if (this.fUt != null) {
            Iterator<com.baidu.live.g.b> it = this.fUm.iterator();
            while (it.hasNext()) {
                this.fUt.b(it.next());
            }
            this.fUm.clear();
            this.fUt.wZ();
        }
    }

    private void bAi() {
        if (this.fUt != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView rj = rj(i);
                if (rj != null && rj.getVisibility() == 0 && rj.getChildCount() > 0 && !this.fUm.contains(rj)) {
                    this.fUm.add(rj);
                    this.fUt.a(rj);
                }
            }
            this.fUt.wZ();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.fUt = aVar;
    }

    private AlaActiveRootView ri(int i) {
        c cVar;
        AlaActiveRootView alaActiveRootView;
        if (this.fUi == null || (alaActiveRootView = this.fUi.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.fUh != null && (cVar = this.fUh.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.fUw;
                if (pendantParentView == null || this.fUi == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(i, pendantParentView.getContext());
                this.fUi.put(Integer.valueOf(i), alaActiveRootView2);
                bC(alaActiveRootView2);
                pendantParentView.a(alaActiveRootView2, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bC(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView rj(int i) {
        if (this.fUi != null) {
            return this.fUi.get(Integer.valueOf(i));
        }
        return null;
    }

    private boolean a(int i, ArrayList<i> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            rk(i);
            return false;
        }
        AlaActiveRootView rj = rj(i);
        if (rj != null && rj.getChildCount() == 1) {
            View lastChild = rj.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return false;
            }
        }
        this.fUk.put(Integer.valueOf(i), null);
        rk(i);
        AlaActiveRootView ri = ri(i);
        if (ri == null) {
            return false;
        }
        AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(ri.getContext());
        alaActiveBannerView.setOtherParams(this.otherParams);
        alaActiveBannerView.setHost(this.isHost);
        alaActiveBannerView.a(this.fTD);
        alaActiveBannerView.setData(arrayList, str);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        if (this.fUs || i == 2) {
            layoutParams.gravity = 5;
        }
        if (!this.fUs && i == 2) {
            layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
        }
        ri.addView(alaActiveBannerView, layoutParams);
        return true;
    }

    private boolean a(final int i, i iVar) {
        String n = n(iVar.webUrl, iVar.jump_url, iVar.axg);
        if (!TextUtils.isEmpty(n) && iVar.axi != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, iVar.axi.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, iVar.axi.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension == 0 || applyDimension2 == 0) {
                return false;
            }
            AlaActiveRootView rj = rj(i);
            if (rj != null && rj.getChildCount() == 1) {
                View lastChild = rj.getLastChild();
                if (lastChild instanceof AlaActiveWebView) {
                    if (TextUtils.isEmpty(((AlaActiveWebView) lastChild).getOriginalUrl()) || !((AlaActiveWebView) lastChild).getOriginalUrl().equals(n)) {
                        ((AlaActiveWebView) lastChild).loadUrl("file:///android_asset/web/blank.html");
                        ((AlaActiveWebView) lastChild).loadUrl(n);
                    }
                    ViewGroup.LayoutParams layoutParams = lastChild.getLayoutParams();
                    if (layoutParams.width != applyDimension || layoutParams.height != applyDimension2) {
                        layoutParams.width = applyDimension;
                        layoutParams.height = applyDimension2;
                        lastChild.setLayoutParams(layoutParams);
                    }
                    if (this.fTD != null) {
                        this.fTD.a(lastChild, iVar, 0);
                    }
                    return false;
                }
            }
            this.fUk.put(Integer.valueOf(i), null);
            rk(i);
            AlaActiveRootView ri = ri(i);
            if (ri == null) {
                return false;
            }
            AlaActiveWebView alaActiveWebView = new AlaActiveWebView(ri.getContext());
            alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                public void bZ(boolean z) {
                    if (z) {
                        b.this.GX();
                    }
                }
            });
            g gVar = new g();
            gVar.u(this.mPageContext.getPageActivity()).b(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                @Override // com.baidu.live.view.web.f
                public void cM(int i2) {
                    b.this.fUk.put(Integer.valueOf(i), 8);
                    b.this.updateView();
                }
            }).a(alaActiveWebView.getSchemeCallback()).b(this.bpi);
            com.baidu.live.view.web.a[] KO = gVar.KO();
            for (com.baidu.live.view.web.a aVar : KO) {
                alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
            }
            alaActiveWebView.loadUrl(n);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
            if (this.fUs || i == 2) {
                layoutParams2.gravity = 5;
            }
            ri.addView(alaActiveWebView, layoutParams2);
            if (this.fTD != null) {
                this.fTD.a(alaActiveWebView, iVar, 0);
                return true;
            }
            return true;
        }
        return false;
    }

    private String n(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aLQ != null) {
            Map<String, Object> bAj = bAj();
            if (i == 2) {
                bAj.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            bAj.put(BigdayActivityConfig.JUMP_URL, aC(str2, i));
            return WebviewHelper.addQueryParams(str, bAj);
        }
        return str;
    }

    private Map<String, Object> bAj() {
        HashMap hashMap = new HashMap();
        if (this.aLQ != null) {
            if (this.aLQ.axI != null) {
                hashMap.put("user_id", Long.valueOf(this.aLQ.axI.userId));
            }
            if (this.aLQ.axp != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aLQ.axp.userId));
            }
            if (this.aLQ.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aLQ.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aLQ.mLiveInfo.live_id));
            }
        }
        hashMap.put("subapp_type", TbConfig.getSubappType());
        hashMap.put("_client_type", "2");
        hashMap.put(HttpRequest.SDK_VERSION, TbConfig.SDK_VERSION);
        if (this.isHost) {
            hashMap.put("is_host", 1);
        }
        return hashMap;
    }

    private String aC(String str, int i) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (i == 2) {
            HashMap hashMap = new HashMap();
            hashMap.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            str2 = WebviewHelper.addQueryParams(str, hashMap);
        } else {
            str2 = str;
        }
        try {
            return URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GX() {
        if (Build.VERSION.SDK_INT >= 19) {
            GZ();
            if (this.fUq == null) {
                this.fUq = new HandlerC0564b(this);
            }
            if (!this.fUq.hasMessages(1000)) {
                this.fUq.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void Hb() {
        if (this.bdi != null) {
            this.bdi.clear();
        }
        if (this.fUq != null) {
            this.fUq.removeMessages(1000);
        }
        Hc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.fUi != null) {
            if (this.bdi == null || (size = this.bdi.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.bdi.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.bdi.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.fUi.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bAk()) {
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
                this.fUq.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                Hb();
            }
        }
    }

    private void GZ() {
        if (this.bdi == null) {
            this.bdi = new ArrayList();
        }
        this.bdi.clear();
        this.bdk = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.bdi.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.bdk);
    }

    private void Hc() {
        if (this.bdk != null) {
            MessageManager.getInstance().unRegisterListener(this.bdk);
            this.bdk = null;
        }
    }

    private void rk(int i) {
        AlaActiveRootView rj = rj(i);
        if (rj != null) {
            rj.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> bAj = bAj();
                bAj.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                String addQueryParams = WebviewHelper.addQueryParams(str, bAj);
                if (!TextUtils.isEmpty(this.fUu)) {
                    addQueryParams = addQueryParams + ETAG.ITEM_SEPARATOR + this.fUu;
                }
                CF(addQueryParams);
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, bAj());
            }
            if (!TextUtils.isEmpty(this.fUu)) {
                str = str + ETAG.ITEM_SEPARATOR + this.fUu;
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void CF(String str) {
        int i;
        if (this.fUf == null) {
            this.fUf = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.fUf.setHost(this.isHost);
        if (this.aLQ != null && this.aLQ.mLiveInfo != null) {
            this.fUf.e(this.aLQ.mLiveInfo.user_id, this.aLQ.mLiveInfo.getNameShow(), this.aLQ.axp != null ? this.aLQ.axp.portrait : null);
            this.fUf.setLiveId(this.aLQ.mLiveInfo.live_id);
        }
        if (!this.fUs) {
            i = 0;
        } else {
            i = UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) == 2 ? 2 : 1;
        }
        this.fUf.aA(str, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, i iVar, int i) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (iVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(iVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "pendant_show").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar, String str, String str2) {
        Object valueOf;
        JSONObject jSONObject = new JSONObject();
        if (iVar == null) {
            valueOf = "0";
        } else {
            try {
                valueOf = Integer.valueOf(iVar.activityId);
            } catch (JSONException e) {
                BdLog.e(e);
            }
        }
        jSONObject.put(SdkStaticKeys.KEY_PENDANT_ID, valueOf);
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "pendant_clk").setContentExt(jSONObject));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(i iVar, String str, String str2) {
        if (!this.isHost && iVar != null) {
            if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.CLICK_PENDANT);
                alaStaticItem.addParams("feed_id", str);
                alaStaticItem.addParams("live_id", str2);
                alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, iVar.activityId + "");
                alaStaticItem.addParams("other_params", this.otherParams);
                AlaStaticsManager.getInst().onStatic(alaStaticItem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rl(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.fUg)) {
                jSONArray = new JSONArray(this.fUg);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.fUg = jSONArray.toString();
            com.baidu.live.c.vf().putString("ala_active_view_click_info", this.fUg);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean rm(int i) {
        if (StringUtils.isNull(this.fUg)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.fUg);
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
    public static class c {
        PendantParentView fUw;

        c(PendantParentView pendantParentView) {
            this.fUw = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0564b extends Handler {
        private final WeakReference<b> bdn;

        HandlerC0564b(b bVar) {
            this.bdn = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.bdn.get() != null && message.what == 1000) {
                this.bdn.get().Ha();
            }
        }
    }
}
