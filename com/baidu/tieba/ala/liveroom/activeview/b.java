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
    private w aES;
    private int aKy;
    private long aXU;
    private List<String> gRM;
    private CustomMessageListener gRN;
    private com.baidu.tieba.ala.liveroom.a.c gVb;
    private SimpleArrayMap<Integer, Set<Integer>> gVg;
    private HttpMessageListener gVi;
    private CustomMessageListener gVj;
    private HandlerC0666b gVk;
    private Runnable gVl;
    private boolean gVm;
    private boolean gVn;
    private com.baidu.live.g.a gVo;
    private String gVp;
    private TbPageContext mPageContext;
    private String otherParams;
    private String gVc = "";
    private boolean isHost = false;
    private Map<Integer, c> gVd = new HashMap();
    private Map<Integer, AlaActiveRootView> gVe = new HashMap();
    private SimpleArrayMap<Integer, Integer> gVf = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> gVh = new ArrayList<>();
    private a gUS = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean vs(int i) {
            return b.this.vs(i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void b(View view, o oVar, int i) {
            b.this.a(view, oVar, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void c(View view, o oVar, int i) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - b.this.aXU >= 400) {
                b.this.aXU = currentTimeMillis;
                if (b.this.aES != null && b.this.aES.aIV != null && b.this.aES.mLiveInfo != null) {
                    String str = oVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aES != null && b.this.aES.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aES.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    if (!TextUtils.isEmpty(str)) {
                        if (str.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aES.aIV.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aES.aIV.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aES.mLiveInfo.live_id);
                        String str2 = "";
                        try {
                            if (!TextUtils.isEmpty(b.this.aES.aIV.portrait)) {
                                str2 = URLEncoder.encode(b.this.aES.aIV.portrait, "utf-8");
                            }
                        } catch (Exception e) {
                            str2 = "";
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str2);
                        }
                    }
                    if (!vs(oVar.aII)) {
                        b.this.vr(oVar.aII);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).vl(i);
                        }
                    }
                    b.this.aY(oVar.aIN, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aES.mLiveInfo != null) {
                        str3 = b.this.aES.mLiveInfo.feed_id;
                        str4 = b.this.aES.mLiveInfo.live_id + "";
                    }
                    b.this.b(oVar, str3, str4);
                    b.this.a(oVar, str3, str4);
                }
            }
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void HH(String str) {
            b.this.HO(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void HI(String str) {
            b.this.HM(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void HJ(String str) {
            SchemeUtils.openScheme(str);
        }

        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public void bK(int i, int i2) {
            AlaActiveRootView vp = b.this.vp(i);
            if (vp != null) {
                for (int i3 = 0; i3 < vp.getChildCount(); i3++) {
                    if (vp.getChildAt(i3) instanceof AlaActiveBannerView) {
                        List<o> originDatas = ((AlaActiveBannerView) vp.getChildAt(i3)).getOriginDatas();
                        if (originDatas != null) {
                            ArrayList arrayList = new ArrayList(originDatas);
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (((o) it.next()).activityId == i2) {
                                    it.remove();
                                }
                            }
                            if (b.this.gVg == null) {
                                b.this.gVg = new SimpleArrayMap();
                            }
                            Set set = (Set) b.this.gVg.get(Integer.valueOf(i));
                            if (set == null) {
                                set = new HashSet();
                                b.this.gVg.put(Integer.valueOf(i), set);
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
        public void mE(boolean z) {
            if (z) {
                b.this.bVN();
            }
        }
    };
    private CustomMessageListener gvo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.gVe != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView vp = b.this.vp(i2);
                            if (vp != null) {
                                View lastChild = vp.getLastChild();
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
        void HH(String str);

        void HI(String str);

        void HJ(String str);

        void b(View view, o oVar, int i);

        void bK(int i, int i2);

        void c(View view, o oVar, int i);

        void mE(boolean z);

        boolean vs(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.gVf.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.gvo);
    }

    public void HL(String str) {
        this.gVp = str;
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(w wVar, boolean z) {
        this.gVm = z;
        for (int i = 1; i <= 2; i++) {
            vq(i);
        }
        if (this.gVd != null) {
            this.gVd.clear();
        }
        i(wVar);
        if (this.aES != null) {
            this.gVc = com.baidu.live.d.AZ().getString("ala_active_view_click_info", "");
            bWR();
            bWS();
            bCX();
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
                    HM(jSONObject.optString("url"));
                }
            } catch (JSONException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HM(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (this.gVn) {
                BdLog.d("清屏状态不显示全屏弹框");
                return;
            }
            bWX();
            bWY();
            this.gVb.HG(str);
        }
    }

    private boolean G(com.baidu.live.im.data.a aVar) {
        long currentAccountId = TbadkCoreApplication.getCurrentAccountId();
        if (currentAccountId <= 0) {
            return false;
        }
        List<Long> Mq = aVar.Mq();
        return ListUtils.isEmpty(Mq) || Mq.contains(Long.valueOf(currentAccountId));
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, PendantParentView pendantParentView) {
        if (pendantParentView != null) {
            this.gVd.put(Integer.valueOf(i), new c(pendantParentView));
            vo(i);
        }
    }

    private void bWR() {
        if (this.gVi == null) {
            this.gVi = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                        if (b.this.aES == null || b.this.aES.mLiveInfo == null || b.this.aES.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aES.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                            b.this.bWT();
                        }
                        if (httpResponsedMessage.getError() == 0) {
                            GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                            if (getLiveActivityHttpResponseMessage.Oj() != null) {
                                b.this.aKy = getLiveActivityHttpResponseMessage.Oj().aKy;
                                b.this.cv(getLiveActivityHttpResponseMessage.Oj().aPj);
                                b.this.e(getLiveActivityHttpResponseMessage.Oj().aPk);
                                b.this.updateView();
                            }
                        }
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gVi);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ac acVar) {
        if (acVar == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo == null ");
        } else if (acVar.Eq() == null) {
            BdLog.e("AlaPkPanel: dealPkPanelData  error alaPkPanelInfo.getUrlDataParams() == null");
        } else {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913257, acVar));
        }
    }

    private void bWS() {
        if (this.gVj == null) {
            this.gVj = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                        b.this.HO((String) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gVj);
    }

    public void onStart() {
        this.mRunning = true;
        if (this.gVe != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vp = vp(i);
                if (vp != null) {
                    vp.onStart();
                }
            }
        }
        bVO();
        if (this.gVb != null) {
            this.gVb.resume();
        }
        bCX();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.gVe != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vp = vp(i);
                if (vp != null) {
                    vp.onStop();
                }
            }
        }
        if (this.gVb != null) {
            this.gVb.pause();
        }
        bWU();
        bVL();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void i(w wVar) {
        this.aES = wVar;
        int i = 1;
        while (true) {
            int i2 = i;
            if (i2 <= 2) {
                AlaActiveRootView vp = vp(i2);
                if (vp != null) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 < vp.getChildCount()) {
                            if (vp.getChildAt(i4) instanceof AlaActiveBannerView) {
                                ((AlaActiveBannerView) vp.getChildAt(i4)).setLiveShowData(this.aES);
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
        if (this.gVe != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bM(i2, i);
            }
        }
    }

    public void bM(int i, int i2) {
        AlaActiveRootView vp;
        this.gVf.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bN = bN(i, i2);
        if (this.gVe != null && (vp = vp(i)) != null) {
            vp.setVisibility(bN);
        }
    }

    private int bN(int i, int i2) {
        if (this.gVf != null && this.gVf.get(Integer.valueOf(i)).intValue() != 0) {
            return this.gVf.get(Integer.valueOf(i)).intValue();
        }
        return i2;
    }

    public void HN(String str) {
        if (f.Qg().hZ(str)) {
            bCX();
        }
    }

    public void release() {
        this.aES = null;
        this.gVp = null;
        if (this.gVi != null) {
            MessageManager.getInstance().unRegisterListener(this.gVi);
            this.gVi = null;
        }
        if (this.gvo != null) {
            MessageManager.getInstance().unRegisterListener(this.gvo);
            this.gvo = null;
        }
        if (this.gVj != null) {
            MessageManager.getInstance().unRegisterListener(this.gVj);
            this.gVj = null;
        }
        if (this.gVk != null) {
            this.gVk.removeCallbacksAndMessages(null);
        }
        f.Qg().release();
        bVL();
        if (this.gVg != null) {
            this.gVg.clear();
        }
        if (this.gVe != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vp = vp(i);
                if (vp != null) {
                    vp.release();
                    bZ(vp);
                }
            }
            this.gVe.clear();
        }
        if (this.gVb != null) {
            this.gVb.release();
            this.gVb = null;
        }
    }

    public void mG(boolean z) {
    }

    public void mH(boolean z) {
    }

    public void updateView() {
        if (this.gVe != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView vp = vp(i2);
                    if (vp != null) {
                        vp.setVisibility(bN(i2, this.gVf.get(Integer.valueOf(i2)).intValue()));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void dI(int i) {
        if (this.gVb != null) {
            this.gVb.dI(i);
        }
    }

    public void mI(boolean z) {
        this.gVn = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bCX() {
        if (this.aES != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.aa.d.Qd().a(this.aES.aJr.userId, this.aES.aIV.userId, this.aES.mLiveInfo.room_id, this.aES.mLiveInfo.live_id, this.aES.mLiveInfo.pubShowId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWT() {
        if (this.mRunning) {
            if (this.gVk == null) {
                this.gVk = new HandlerC0666b(this);
            }
            if (this.gVl == null) {
                this.gVl = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.bCX();
                    }
                };
            }
            bWU();
            if (this.aKy <= 0) {
                this.aKy = 5;
            }
            this.gVk.postDelayed(this.gVl, this.aKy * 1000);
        }
    }

    private void bWU() {
        if (this.gVk != null && this.gVl != null) {
            this.gVk.removeCallbacks(this.gVl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cv(List<o> list) {
        HashMap hashMap;
        boolean z;
        boolean z2 = false;
        if (list == null || list.isEmpty()) {
            hashMap = null;
        } else {
            hashMap = null;
            for (o oVar : list) {
                if (a(oVar)) {
                    if (oVar.aIP == null) {
                        oVar.aIP = new o.b();
                    }
                    if (oVar.aIP.pos == 0) {
                        oVar.aIP.pos = 1;
                    }
                    if (oVar.picType == 0 && (oVar.aIP.width <= 0 || oVar.aIP.height <= 0)) {
                        o.b bVar = oVar.aIP;
                        o.b bVar2 = oVar.aIP;
                        int dimensionPixelOffset = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds120);
                        bVar2.width = dimensionPixelOffset;
                        bVar.height = dimensionPixelOffset;
                    }
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    List list2 = (List) hashMap.get(Integer.valueOf(oVar.aIP.pos));
                    if (list2 == null) {
                        list2 = new ArrayList();
                        hashMap.put(Integer.valueOf(oVar.aIP.pos), list2);
                    }
                    list2.add(oVar);
                    if (list2.size() >= 5) {
                        break;
                    }
                    if (z2 || oVar.aIO == null) {
                        z = z2;
                    } else {
                        f.Qg().b(oVar.aIO);
                        z = true;
                    }
                    z2 = z;
                }
            }
        }
        if (!z2) {
            f.Qg().b(null);
        }
        for (int i = 1; i <= 2; i++) {
            k(i, hashMap != null ? (List) hashMap.get(Integer.valueOf(i)) : null);
        }
    }

    private boolean a(o oVar) {
        boolean z = true;
        if (oVar != null && oVar.aIK == 1) {
            long j = oVar.serverTime;
            if (j <= 0) {
                j = System.currentTimeMillis() / 1000;
            }
            if (j < oVar.showTime || j > oVar.end_time) {
                return false;
            }
            if (oVar.aIP == null || (oVar.aIP.pos >= 0 && oVar.aIP.pos <= 2)) {
                if (oVar.picType == 0) {
                    return !TextUtils.isEmpty(oVar.pic_url);
                } else if (oVar.picType == 3) {
                    if (TextUtils.isEmpty(oVar.webUrl) || oVar.aIP == null || oVar.aIP.width <= 0 || oVar.aIP.height <= 0) {
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
            bWV();
            vq(i);
            return;
        }
        if (this.gVg != null && (set = this.gVg.get(Integer.valueOf(i))) != null) {
            Iterator<o> it = list.iterator();
            while (it.hasNext()) {
                if (set.contains(Integer.valueOf(it.next().activityId))) {
                    it.remove();
                }
            }
        }
        boolean a2 = a(i, list, "");
        c cVar = this.gVd.get(Integer.valueOf(i));
        if (cVar != null && cVar.gVr != null && a2) {
            cVar.gVr.a(vp(i));
        }
        bWW();
    }

    private void bWV() {
        if (this.gVo != null) {
            Iterator<com.baidu.live.g.b> it = this.gVh.iterator();
            while (it.hasNext()) {
                this.gVo.b(it.next());
            }
            this.gVh.clear();
            this.gVo.Ff();
        }
    }

    private void bWW() {
        if (this.gVo != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView vp = vp(i);
                if (vp != null && vp.getVisibility() == 0 && vp.getChildCount() > 0 && !this.gVh.contains(vp)) {
                    this.gVh.add(vp);
                    this.gVo.a(vp);
                }
            }
            this.gVo.Ff();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.gVo = aVar;
    }

    private AlaActiveRootView vo(int i) {
        c cVar;
        AlaActiveRootView vp;
        if (this.gVe == null || (vp = vp(i)) == null || vp.getParent() == null) {
            if (this.gVd != null && (cVar = this.gVd.get(Integer.valueOf(i))) != null) {
                PendantParentView pendantParentView = cVar.gVr;
                if (pendantParentView == null || this.gVe == null) {
                    return null;
                }
                AlaActiveRootView alaActiveRootView = new AlaActiveRootView(i, pendantParentView.getContext());
                this.gVe.put(Integer.valueOf(i), alaActiveRootView);
                bZ(alaActiveRootView);
                pendantParentView.a(alaActiveRootView, new LinearLayout.LayoutParams(-2, -2));
                return alaActiveRootView;
            }
            return null;
        }
        return vp;
    }

    private void bZ(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView vp(int i) {
        if (this.gVe != null) {
            return this.gVe.get(Integer.valueOf(i));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, List<o> list, String str) {
        int i2 = 0;
        if (list == null || list.isEmpty()) {
            vq(i);
            return false;
        }
        AlaActiveRootView vp = vp(i);
        if (vp != null && vp.getChildCount() == 1) {
            View lastChild = vp.getLastChild();
            if ((lastChild instanceof AlaActiveBannerView) && ((AlaActiveBannerView) lastChild).cu(list)) {
                return false;
            }
        }
        vq(i);
        AlaActiveRootView vo = vo(i);
        if (vo != null) {
            int i3 = 0;
            for (o oVar : list) {
                i3 = Math.max(i3, oVar.aIP.width);
                i2 = Math.max(i2, oVar.aIP.height);
            }
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(vo.getContext());
            alaActiveBannerView.setActivityContext(this.mPageContext.getPageActivity());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.setLiveShowData(this.aES);
            alaActiveBannerView.a(this.gUS);
            alaActiveBannerView.j(list, str);
            alaActiveBannerView.bL((int) TypedValue.applyDimension(1, i3, this.mPageContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, i2, this.mPageContext.getResources().getDisplayMetrics()));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.gVm || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.gVm && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.d.sdk_ds16);
            }
            vo.addView(alaActiveBannerView, layoutParams);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVN() {
        if (Build.VERSION.SDK_INT >= 19) {
            bVP();
            if (this.gVk == null) {
                this.gVk = new HandlerC0666b(this);
            }
            if (!this.gVk.hasMessages(1000)) {
                this.gVk.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bVL() {
        if (this.gRM != null) {
            this.gRM.clear();
        }
        if (this.gVk != null) {
            this.gVk.removeMessages(1000);
        }
        bVM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVO() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.gVe != null) {
            if (this.gRM == null || (size = this.gRM.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.gRM.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.gRM.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView vp = vp(i2);
                if (vp != null) {
                    View lastChild = vp.getLastChild();
                    if (lastChild instanceof AlaActiveBannerView) {
                        z = ((AlaActiveBannerView) lastChild).HK(str) | z2;
                        i2++;
                        z2 = z;
                    }
                }
                z = z2;
                i2++;
                z2 = z;
            }
            if (z2) {
                this.gVk.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bVL();
            }
        }
    }

    private void bVP() {
        if (this.gRM == null) {
            this.gRM = new ArrayList();
        }
        this.gRM.clear();
        if (this.gRN == null) {
            this.gRN = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                        b.this.gRM.addAll((List) customResponsedMessage.getData());
                    }
                }
            };
        }
        MessageManager.getInstance().registerListener(this.gRN);
    }

    private void bVM() {
        if (this.gRN != null) {
            MessageManager.getInstance().unRegisterListener(this.gRN);
            this.gRN = null;
        }
    }

    private void vq(int i) {
        AlaActiveRootView vp = vp(i);
        if (vp != null) {
            vp.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aY(int i, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        if (!TextUtils.isEmpty(str)) {
            if (this.aES != null) {
                String valueOf = this.aES.aJr != null ? String.valueOf(this.aES.aJr.userId) : null;
                String valueOf2 = this.aES.aIV != null ? String.valueOf(this.aES.aIV.userId) : null;
                if (this.aES.mLiveInfo != null) {
                    str3 = String.valueOf(this.aES.mLiveInfo.room_id);
                    str2 = String.valueOf(this.aES.mLiveInfo.live_id);
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
            String a2 = com.baidu.live.utils.b.a(i, str, this.isHost, str5, str4, str3, str2, this.gVp);
            if (i == 2) {
                HO(a2);
            } else {
                SchemeUtils.openScheme(a2);
            }
        }
    }

    public void HO(String str) {
        int i = 2;
        bWX();
        bWY();
        if (!this.gVm) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.gVb.aG(str, i);
    }

    private void bWX() {
        if (this.gVb == null) {
            this.gVb = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
    }

    private void bWY() {
        this.gVb.setHost(this.isHost);
        if (this.aES != null && this.aES.mLiveInfo != null) {
            this.gVb.e(this.aES.mLiveInfo.user_id, this.aES.mLiveInfo.getNameShow(), this.aES.aIV != null ? this.aES.aIV.portrait : null);
            this.gVb.setLiveId(this.aES.mLiveInfo.live_id);
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
    public void vr(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.gVc)) {
                jSONArray = new JSONArray(this.gVc);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.gVc = jSONArray.toString();
            com.baidu.live.d.AZ().putString("ala_active_view_click_info", this.gVc);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean vs(int i) {
        if (StringUtils.isNull(this.gVc)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.gVc);
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
        PendantParentView gVr;

        c(PendantParentView pendantParentView) {
            this.gVr = pendantParentView;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class HandlerC0666b extends Handler {
        private final WeakReference<b> gRW;

        HandlerC0666b(b bVar) {
            this.gRW = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.gRW.get() != null && message.what == 1000) {
                this.gRW.get().bVO();
            }
        }
    }
}
