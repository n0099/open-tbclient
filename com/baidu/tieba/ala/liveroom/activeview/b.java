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
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.at;
import com.baidu.live.data.i;
import com.baidu.live.data.q;
import com.baidu.live.message.GetLiveActivityDynamicHttpResponseMessage;
import com.baidu.live.message.GetLiveActivityHttpResponseMessage;
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
import com.baidu.live.u.a;
import com.baidu.live.v.d;
import com.baidu.live.view.PriorityVerticalLinearLayout;
import com.baidu.live.view.web.f;
import com.baidu.live.view.web.g;
import com.baidu.live.view.web.h;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
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
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.liveroom.b.a {
    private long aGL;
    private q aJj;
    private int avZ;
    private com.baidu.tieba.ala.liveroom.a.c fIY;
    private Map<Integer, c> fJa;
    private Map<Integer, AlaActiveRootView> fJb;
    private HttpMessageListener fJg;
    private HttpMessageListener fJh;
    private CustomMessageListener fJi;
    private CustomMessageListener fJj;
    private HandlerC0556b fJk;
    private Runnable fJl;
    private List<String> fJm;
    private boolean fJn;
    private boolean fJo;
    private boolean fJp;
    private com.baidu.live.g.a fJq;
    private TbPageContext mPageContext;
    private String otherParams;
    private String fIZ = "";
    private boolean isHost = false;
    private SimpleArrayMap<Integer, Integer> fJc = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> fJd = new SimpleArrayMap<>();
    private SimpleArrayMap<Integer, Integer> fJe = new SimpleArrayMap<>();
    private ArrayList<com.baidu.live.g.b> fJf = new ArrayList<>();
    private h bkh = new h() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.9
        @Override // com.baidu.live.view.web.h
        public void fV(String str) {
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
                    b.this.Cg(str);
                } else {
                    SchemeUtils.openScheme(str);
                }
            }
        }
    };
    private a fIv = new a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.2
        @Override // com.baidu.tieba.ala.liveroom.activeview.b.a
        public boolean qN(int i) {
            return b.this.qN(i);
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
            if (currentTimeMillis - b.this.aGL >= 400) {
                b.this.aGL = currentTimeMillis;
                if ((obj instanceof i) && b.this.aJj != null && b.this.aJj.avj != null && b.this.aJj.mLiveInfo != null) {
                    i iVar = (i) obj;
                    String str2 = iVar.jump_url;
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    StatisticItem statisticItem = new StatisticItem("c11887");
                    statisticItem.param("uid", currentAccount);
                    if (b.this.aJj != null && b.this.aJj.mLiveInfo != null) {
                        statisticItem.param("live_id", b.this.aJj.mLiveInfo.live_id);
                    }
                    TiebaInitialize.log(statisticItem);
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2);
                    if (!TextUtils.isEmpty(str2)) {
                        if (str2.contains("?")) {
                            sb.append("&_loc_user_name=");
                            sb.append(b.this.aJj.avj.userName);
                        } else {
                            sb.append("?_loc_user_name=");
                            sb.append(b.this.aJj.avj.userName);
                        }
                        sb.append("&_loc_live_id=");
                        sb.append(b.this.aJj.mLiveInfo.live_id);
                        try {
                            str = URLEncoder.encode(b.this.aJj.avj.portrait, "utf-8");
                        } catch (UnsupportedEncodingException e) {
                            str = "";
                        }
                        if (!TextUtils.isEmpty(str)) {
                            sb.append("&_loc_portrait=");
                            sb.append(str);
                        }
                    }
                    if (!qN(iVar.auV)) {
                        b.this.qM(iVar.auV);
                        if (view instanceof AlaActiveBannerView) {
                            ((AlaActiveBannerView) view).qG(i);
                        } else if ((view instanceof AlaActiveDynamicView) && iVar.auM && b.this.fIv.qN(iVar.auV)) {
                            iVar.auM = false;
                        }
                    }
                    b.this.aH(iVar.ava, sb.toString());
                    String str3 = "";
                    String str4 = "";
                    if (b.this.aJj.mLiveInfo != null) {
                        str3 = b.this.aJj.mLiveInfo.feed_id;
                        str4 = b.this.aJj.mLiveInfo.live_id + "";
                    }
                    b.this.b(iVar, str3, str4);
                    b.this.a(iVar, str3, str4);
                }
            }
        }
    };
    private CustomMessageListener foe = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (str == null) {
                    str = "";
                }
                b.this.otherParams = str;
                if (b.this.fJb != null) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 <= 2) {
                            AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.fJb.get(Integer.valueOf(i2));
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

        boolean qN(int i);
    }

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        for (int i = 1; i <= 2; i++) {
            this.fJc.put(Integer.valueOf(i), 0);
        }
        MessageManager.getInstance().registerListener(this.foe);
    }

    @Override // com.baidu.live.liveroom.b.a
    public void setHost(boolean z) {
        this.isHost = z;
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void b(q qVar, boolean z) {
        this.fJp = z;
        for (int i = 1; i <= 2; i++) {
            qL(i);
        }
        if (this.fJa != null) {
            this.fJa.clear();
        }
        h(qVar);
        if (this.aJj != null) {
            this.fIZ = com.baidu.live.c.uN().getString("ala_active_view_click_info", "");
            bxj();
            bxk();
            btb();
        }
    }

    @Override // com.baidu.live.liveroom.b.a
    public void a(int i, ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
        if (this.fJa == null) {
            this.fJa = new HashMap();
        }
        this.fJa.put(Integer.valueOf(i), new c(viewGroup, layoutParams));
        qJ(i);
    }

    private void bxj() {
        this.fJg = new HttpMessageListener(1021122) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021122 && (httpResponsedMessage instanceof GetLiveActivityHttpResponseMessage)) {
                    if (b.this.aJj == null || b.this.aJj.mLiveInfo == null || b.this.aJj.mLiveInfo.mAlaLiveSwitchData == null || !b.this.aJj.mLiveInfo.mAlaLiveSwitchData.isActivityPollingUnabled()) {
                        b.this.bxl();
                    }
                    if (httpResponsedMessage.getError() == 0) {
                        GetLiveActivityHttpResponseMessage getLiveActivityHttpResponseMessage = (GetLiveActivityHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityHttpResponseMessage.Fr() != null) {
                            b.this.avZ = getLiveActivityHttpResponseMessage.Fr().avZ;
                            b.this.bH(getLiveActivityHttpResponseMessage.Fr().aAo);
                            b.this.updateView();
                        }
                    }
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fJg);
    }

    private void bxk() {
        this.fJj = new CustomMessageListener(2913132) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                    b.this.Cg((String) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fJj);
    }

    public void onStart() {
        int i = 1;
        this.mRunning = true;
        if (this.fJb != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                AlaActiveRootView alaActiveRootView = this.fJb.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStart();
                }
            }
        }
        if (this.fJb != null) {
            while (true) {
                if (i > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView2 = this.fJb.get(Integer.valueOf(i));
                if (alaActiveRootView2 != null) {
                    View lastChild = alaActiveRootView2.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bxw()) {
                        bxq();
                        break;
                    }
                }
                i++;
            }
        }
        if (this.fIY != null) {
            this.fIY.resume();
        }
        btb();
    }

    public void onStop() {
        this.mRunning = false;
        if (this.fJb != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fJb.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.onStop();
                }
                i = i2 + 1;
            }
        }
        if (this.fIY != null) {
            this.fIY.pause();
        }
        bxm();
        bxr();
    }

    @Override // com.baidu.live.liveroom.b.a
    public void h(q qVar) {
        this.aJj = qVar;
    }

    public void setVisible(int i) {
        if (this.fJb != null) {
            for (int i2 = 1; i2 <= 2; i2++) {
                bt(i2, i);
            }
        }
    }

    public void bt(int i, int i2) {
        AlaActiveRootView alaActiveRootView;
        this.fJc.put(Integer.valueOf(i), Integer.valueOf(i2));
        int bu = bu(i, i2);
        if (this.fJb != null && (alaActiveRootView = this.fJb.get(Integer.valueOf(i))) != null) {
            alaActiveRootView.setVisibility(bu);
        }
    }

    private int bu(int i, int i2) {
        if (this.fJd == null || this.fJd.get(Integer.valueOf(i)) == null) {
            if (this.fJc != null && this.fJc.get(Integer.valueOf(i)).intValue() != 0) {
                return this.fJc.get(Integer.valueOf(i)).intValue();
            }
            if (this.fJn) {
                if (i2 != 8) {
                    if (this.fJo) {
                        if (i == 1) {
                            if (this.fJe.get(1) == null || this.fJe.get(1).intValue() != 3) {
                                return i2;
                            }
                            return 8;
                        } else if (i == 2) {
                            if (this.fJe.get(2) != null && this.fJe.get(2).intValue() == 3) {
                                return 8;
                            }
                            if (this.fJb != null && this.fJb.get(1) != null) {
                                if (this.fJb.get(1).getVisibility() != 0 || this.fJb.get(1).getChildCount() == 0) {
                                    return i2;
                                }
                                return 8;
                            }
                        }
                    } else if (i == 1) {
                        if (this.fJe.get(1) == null || this.fJe.get(1).intValue() == 3 || this.fJe.get(2) == null || this.fJe.get(2).intValue() != 3) {
                            return i2;
                        }
                        return 8;
                    } else if (i == 2 && this.fJb != null && this.fJb.get(1) != null) {
                        if (this.fJb.get(1).getVisibility() != 0 || this.fJb.get(1).getChildCount() == 0) {
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

    public void Cf(String str) {
        if (d.Gl().fC(str)) {
            btb();
        }
    }

    public void release() {
        this.aJj = null;
        if (this.fJg != null) {
            MessageManager.getInstance().unRegisterListener(this.fJg);
            this.fJg = null;
        }
        if (this.fJh != null) {
            MessageManager.getInstance().unRegisterListener(this.fJh);
            this.fJh = null;
        }
        if (this.foe != null) {
            MessageManager.getInstance().unRegisterListener(this.foe);
            this.foe = null;
        }
        if (this.fJj != null) {
            MessageManager.getInstance().unRegisterListener(this.fJj);
            this.fJj = null;
        }
        if (this.fJk != null) {
            this.fJk.removeCallbacksAndMessages(null);
        }
        d.Gl().release();
        bxr();
        if (this.fJb != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 > 2) {
                    break;
                }
                AlaActiveRootView alaActiveRootView = this.fJb.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    alaActiveRootView.release();
                    bz(alaActiveRootView);
                }
                i = i2 + 1;
            }
            this.fJb.clear();
        }
        if (this.fIY != null) {
            this.fIY.release();
            this.fIY = null;
        }
    }

    public void ki(boolean z) {
        this.fJn = z;
    }

    public void kj(boolean z) {
        this.fJo = z;
    }

    public void updateView() {
        if (this.fJb != null) {
            int i = 1;
            while (true) {
                int i2 = i;
                if (i2 <= 2) {
                    AlaActiveRootView alaActiveRootView = this.fJb.get(Integer.valueOf(i2));
                    if (alaActiveRootView != null) {
                        alaActiveRootView.setVisibility(bu(i2, this.fJc.get(Integer.valueOf(i2)).intValue()));
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
        if (this.fJb != null && viewGroup != null && (alaActiveRootView = this.fJb.get(Integer.valueOf(i))) != null) {
            bz(alaActiveRootView);
            alaActiveRootView.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(i2));
            viewGroup.addView(alaActiveRootView, layoutParams);
        }
    }

    public void cu(int i) {
        if (this.fIY != null) {
            this.fIY.cu(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btb() {
        if (this.aJj != null) {
            if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isActivityPollingUnabled()) {
                com.baidu.live.v.b.Gi().d(this.aJj.avC.userId, this.aJj.avj.userId, this.aJj.mLiveInfo.room_id, this.aJj.mLiveInfo.live_id);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxl() {
        if (this.mRunning) {
            if (this.fJk == null) {
                this.fJk = new HandlerC0556b(this);
            }
            if (this.fJl == null) {
                this.fJl = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.btb();
                    }
                };
            }
            bxm();
            if (this.avZ <= 0) {
                this.avZ = 5;
            }
            this.fJk.postDelayed(this.fJl, this.avZ * 1000);
        }
    }

    private void bxm() {
        if (this.fJk != null && this.fJl != null) {
            this.fJk.removeCallbacks(this.fJl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void bH(List<i> list) {
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
                    if (iVar.auX == 1) {
                        long j = iVar.serverTime;
                        if (j <= 0) {
                            j = System.currentTimeMillis() / 1000;
                        }
                        if (j >= iVar.showTime && j <= iVar.end_time && iVar.avc != null && iVar.avc.pos >= 0 && iVar.avc.pos <= 2) {
                            if (iVar.avc.pos == 0) {
                                iVar.avc.pos = 1;
                            }
                            switch (iVar.picType) {
                                case 0:
                                    if (TextUtils.isEmpty(iVar.pic_url)) {
                                        break;
                                    } else {
                                        if (hashMap == null) {
                                            hashMap = new HashMap();
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(iVar.avc.pos));
                                        if (list2 == null) {
                                            list2 = new ArrayList();
                                            hashMap.put(Integer.valueOf(iVar.avc.pos), list2);
                                        }
                                        list2.add(iVar);
                                        if (!z2 || iVar.avb == null) {
                                            z = z2;
                                        } else {
                                            d.Gl().b(iVar.avb);
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
                                    list2 = (List) hashMap.get(Integer.valueOf(iVar.avc.pos));
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
                                    if (!TextUtils.isEmpty(iVar.webUrl) && iVar.avc != null && iVar.avc.width > 0 && iVar.avc.height > 0) {
                                        if (hashMap == null) {
                                        }
                                        list2 = (List) hashMap.get(Integer.valueOf(iVar.avc.pos));
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
            d.Gl().b(null);
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
        if (list == null || list.isEmpty()) {
            bxn();
            qL(i);
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
        this.fJe.put(Integer.valueOf(i), Integer.valueOf(i2));
        switch (i2) {
            case 0:
                a(i, arrayList, "");
                break;
            case 1:
                a(i, iVar);
                c(iVar);
                break;
            case 2:
            default:
                qL(i);
                break;
            case 3:
                b(i, iVar);
                break;
        }
        bxo();
    }

    private void bxn() {
        if (this.fJq != null) {
            Iterator<com.baidu.live.g.b> it = this.fJf.iterator();
            while (it.hasNext()) {
                this.fJq.b(it.next());
            }
            this.fJf.clear();
            this.fJq.wB();
        }
    }

    private void bxo() {
        if (this.fJq != null) {
            for (int i = 1; i <= 2; i++) {
                AlaActiveRootView qK = qK(i);
                if (qK != null && qK.getVisibility() == 0 && qK.getChildCount() > 0 && !this.fJf.contains(qK)) {
                    this.fJf.add(qK);
                    this.fJq.a(qK);
                }
            }
            this.fJq.wB();
        }
    }

    public void a(com.baidu.live.g.a aVar) {
        this.fJq = aVar;
    }

    private ViewGroup qJ(int i) {
        c cVar;
        ViewGroup viewGroup;
        AlaActiveRootView alaActiveRootView;
        if (this.fJb == null || (alaActiveRootView = this.fJb.get(Integer.valueOf(i))) == null || alaActiveRootView.getParent() == null) {
            if (this.fJa != null && (cVar = this.fJa.get(Integer.valueOf(i))) != null && (viewGroup = cVar.fJu) != null) {
                AlaActiveRootView alaActiveRootView2 = new AlaActiveRootView(viewGroup.getContext());
                if (this.fJb == null) {
                    this.fJb = new HashMap();
                }
                this.fJb.put(Integer.valueOf(i), alaActiveRootView2);
                if (viewGroup instanceof PriorityVerticalLinearLayout) {
                    alaActiveRootView2.setTag(a.g.sdk_pvl_layout_priority_tag_key, Integer.valueOf(this.fJp ? 1 : 22));
                }
                bz(alaActiveRootView2);
                if (cVar.fJv != null) {
                    viewGroup.addView(alaActiveRootView2, cVar.fJv);
                } else {
                    viewGroup.addView(alaActiveRootView2);
                }
                return alaActiveRootView2;
            }
            return null;
        }
        return alaActiveRootView;
    }

    private void bz(View view) {
        if (view != null && view.getParent() != null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }

    public AlaActiveRootView qK(int i) {
        if (this.fJb != null) {
            return this.fJb.get(Integer.valueOf(i));
        }
        return null;
    }

    private void a(int i, ArrayList<i> arrayList, String str) {
        if (arrayList == null || arrayList.isEmpty()) {
            qL(i);
            return;
        }
        AlaActiveRootView qK = qK(i);
        if (qK != null && qK.getChildCount() == 1) {
            View lastChild = qK.getLastChild();
            if (lastChild instanceof AlaActiveBannerView) {
                ((AlaActiveBannerView) lastChild).setData(arrayList, str);
                return;
            }
        }
        this.fJd.put(Integer.valueOf(i), null);
        qL(i);
        ViewGroup qJ = qJ(i);
        if (qJ != null) {
            AlaActiveBannerView alaActiveBannerView = new AlaActiveBannerView(qJ.getContext());
            alaActiveBannerView.setOtherParams(this.otherParams);
            alaActiveBannerView.setHost(this.isHost);
            alaActiveBannerView.a(this.fIv);
            alaActiveBannerView.setData(arrayList, str);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            if (this.fJp || i == 2) {
                layoutParams.gravity = 5;
            }
            if (!this.fJp && i == 2) {
                layoutParams.rightMargin = this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds16);
            }
            qJ.addView(alaActiveBannerView, layoutParams);
        }
    }

    private void a(int i, i iVar) {
        AlaActiveRootView qK = qK(i);
        if (qK != null && qK.getChildCount() == 1) {
            View lastChild = qK.getLastChild();
            if (lastChild instanceof AlaActiveDynamicView) {
                ((AlaActiveDynamicView) lastChild).setActivityInfo(iVar);
                return;
            }
        }
        this.fJd.put(Integer.valueOf(i), null);
        qL(i);
        ViewGroup qJ = qJ(i);
        if (qJ != null) {
            final AlaActiveDynamicView alaActiveDynamicView = new AlaActiveDynamicView(qJ.getContext());
            alaActiveDynamicView.setCallback(new AlaActiveDynamicView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.6
                @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveDynamicView.a
                public void b(i iVar2) {
                    if (b.this.fIv != null) {
                        b.this.fIv.b(alaActiveDynamicView, iVar2, 0);
                    }
                }
            });
            alaActiveDynamicView.setActivityInfo(iVar);
            if (iVar.auM && this.fIv.qN(iVar.auV)) {
                iVar.auM = false;
            }
            alaActiveDynamicView.setVisibility(4);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds168), this.mPageContext.getResources().getDimensionPixelOffset(a.e.sdk_ds204));
            if (this.fJp || i == 2) {
                layoutParams.gravity = 5;
            }
            qJ.addView(alaActiveDynamicView, layoutParams);
        }
    }

    private void b(final int i, i iVar) {
        String n = n(iVar.webUrl, iVar.jump_url, iVar.ava);
        if (!TextUtils.isEmpty(n) && iVar.avc != null) {
            int applyDimension = (int) TypedValue.applyDimension(1, iVar.avc.width, this.mPageContext.getResources().getDisplayMetrics());
            int applyDimension2 = (int) TypedValue.applyDimension(1, iVar.avc.height, this.mPageContext.getResources().getDisplayMetrics());
            if (applyDimension != 0 && applyDimension2 != 0) {
                AlaActiveRootView qK = qK(i);
                if (qK != null && qK.getChildCount() == 1) {
                    View lastChild = qK.getLastChild();
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
                        if (this.fIv != null) {
                            this.fIv.a(lastChild, iVar, 0);
                            return;
                        }
                        return;
                    }
                }
                this.fJd.put(Integer.valueOf(i), null);
                qL(i);
                ViewGroup qJ = qJ(i);
                if (qJ != null) {
                    AlaActiveWebView alaActiveWebView = new AlaActiveWebView(qJ.getContext());
                    alaActiveWebView.setCallback(new AlaActiveWebView.a() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.7
                        @Override // com.baidu.tieba.ala.liveroom.activeview.AlaActiveWebView.a
                        public void kk(boolean z) {
                            if (z) {
                                b.this.bxq();
                            }
                        }
                    });
                    g gVar = new g();
                    gVar.u(this.mPageContext.getPageActivity()).a(new f() { // from class: com.baidu.tieba.ala.liveroom.activeview.b.8
                        @Override // com.baidu.live.view.web.f
                        public void dv(int i2) {
                            b.this.fJd.put(Integer.valueOf(i), 8);
                            b.this.updateView();
                        }
                    }).a(alaActiveWebView.getSchemeCallback()).b(this.bkh);
                    com.baidu.live.view.web.a[] JF = gVar.JF();
                    for (com.baidu.live.view.web.a aVar : JF) {
                        alaActiveWebView.addJavascriptInterface(aVar, aVar.getName());
                    }
                    alaActiveWebView.loadUrl(n);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(applyDimension, applyDimension2);
                    if (this.fJp || i == 2) {
                        layoutParams2.gravity = 5;
                    }
                    qJ.addView(alaActiveWebView, layoutParams2);
                    if (this.fIv != null) {
                        this.fIv.a(alaActiveWebView, iVar, 0);
                    }
                }
            }
        }
    }

    private String n(String str, String str2, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.aJj != null) {
            Map<String, Object> bxp = bxp();
            if (i == 2) {
                bxp.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
            }
            bxp.put(BigdayActivityConfig.JUMP_URL, aD(str2, i));
            return WebviewHelper.addQueryParams(str, bxp);
        }
        return str;
    }

    private Map<String, Object> bxp() {
        HashMap hashMap = new HashMap();
        if (this.aJj != null) {
            if (this.aJj.avC != null) {
                hashMap.put("user_id", Long.valueOf(this.aJj.avC.userId));
            }
            if (this.aJj.avj != null) {
                hashMap.put("charm_user_id", Long.valueOf(this.aJj.avj.userId));
            }
            if (this.aJj.mLiveInfo != null) {
                hashMap.put("room_id", Long.valueOf(this.aJj.mLiveInfo.room_id));
                hashMap.put("live_id", Long.valueOf(this.aJj.mLiveInfo.live_id));
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

    private String aD(String str, int i) {
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
    public void bxq() {
        if (Build.VERSION.SDK_INT >= 19) {
            bxt();
            if (this.fJk == null) {
                this.fJk = new HandlerC0556b(this);
            }
            if (!this.fJk.hasMessages(1000)) {
                this.fJk.sendEmptyMessageDelayed(1000, 1000L);
            }
        }
    }

    private void bxr() {
        if (this.fJm != null) {
            this.fJm.clear();
        }
        if (this.fJk != null) {
            this.fJk.removeMessages(1000);
        }
        bxu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxs() {
        String str;
        boolean z;
        int size;
        boolean z2 = false;
        if (this.fJb != null) {
            if (this.fJm == null || (size = this.fJm.size()) <= 0) {
                str = null;
            } else {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < size; i++) {
                    jSONArray.put(this.fJm.get(i));
                }
                String jSONArray2 = jSONArray.toString();
                this.fJm.clear();
                str = jSONArray2;
            }
            int i2 = 1;
            while (i2 <= 2) {
                AlaActiveRootView alaActiveRootView = this.fJb.get(Integer.valueOf(i2));
                if (alaActiveRootView != null) {
                    View lastChild = alaActiveRootView.getLastChild();
                    if ((lastChild instanceof AlaActiveWebView) && ((AlaActiveWebView) lastChild).bxw()) {
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
                this.fJk.sendEmptyMessageDelayed(1000, 1000L);
            } else {
                bxr();
            }
        }
    }

    private void bxt() {
        if (this.fJm == null) {
            this.fJm = new ArrayList();
        }
        this.fJm.clear();
        this.fJi = new CustomMessageListener(2913107) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.10
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof List)) {
                    b.this.fJm.addAll((List) customResponsedMessage.getData());
                }
            }
        };
        MessageManager.getInstance().registerListener(this.fJi);
    }

    private void bxu() {
        if (this.fJi != null) {
            MessageManager.getInstance().unRegisterListener(this.fJi);
            this.fJi = null;
        }
    }

    private void qL(int i) {
        AlaActiveRootView qK = qK(i);
        if (qK != null) {
            qK.release();
        }
    }

    private void c(i iVar) {
        bxv();
        d.Gl().a(this.aJj.mLiveInfo.user_id, this.aJj.mLiveInfo.live_id, iVar.activityId);
    }

    private void bxv() {
        if (this.fJh == null) {
            this.fJh = new HttpMessageListener(1021126) { // from class: com.baidu.tieba.ala.liveroom.activeview.b.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(HttpResponsedMessage httpResponsedMessage) {
                    if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021126 && (httpResponsedMessage instanceof GetLiveActivityDynamicHttpResponseMessage) && httpResponsedMessage.getError() == 0) {
                        GetLiveActivityDynamicHttpResponseMessage getLiveActivityDynamicHttpResponseMessage = (GetLiveActivityDynamicHttpResponseMessage) httpResponsedMessage;
                        if (getLiveActivityDynamicHttpResponseMessage.Fq() != null && b.this.fJb != null && getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() != null && (getLiveActivityDynamicHttpResponseMessage.getOrginalMessage() instanceof com.baidu.live.message.g)) {
                            int id = ((com.baidu.live.message.g) getLiveActivityDynamicHttpResponseMessage.getOrginalMessage()).getId();
                            int i = 1;
                            while (true) {
                                int i2 = i;
                                if (i2 <= 2) {
                                    AlaActiveRootView alaActiveRootView = (AlaActiveRootView) b.this.fJb.get(Integer.valueOf(i2));
                                    if (alaActiveRootView != null) {
                                        View lastChild = alaActiveRootView.getLastChild();
                                        if (lastChild instanceof AlaActiveDynamicView) {
                                            AlaActiveDynamicView alaActiveDynamicView = (AlaActiveDynamicView) lastChild;
                                            if (alaActiveDynamicView.getActivityInfo() != null && alaActiveDynamicView.getActivityInfo().activityId == id) {
                                                b.this.a(alaActiveDynamicView, getLiveActivityDynamicHttpResponseMessage.Fq());
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
            MessageManager.getInstance().registerListener(this.fJh);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaActiveDynamicView alaActiveDynamicView, at atVar) {
        boolean z;
        i activityInfo = alaActiveDynamicView.getActivityInfo();
        if (activityInfo != null) {
            alaActiveDynamicView.setData(activityInfo.pic_url, atVar);
            if (alaActiveDynamicView.getVisibility() != 0) {
                alaActiveDynamicView.setVisibility(0);
                z = true;
            } else {
                z = false;
            }
            i.a aVar = activityInfo.avb;
            long j = aVar != null ? (aVar.endTime - aVar.currentTime) * 1000 : 0L;
            if (aVar != null && j > 0) {
                alaActiveDynamicView.pX(2);
                alaActiveDynamicView.setTimer(atVar.aAu + " *" + aVar.avf);
                alaActiveDynamicView.w(j, aVar.endTime);
            } else {
                alaActiveDynamicView.pX(1);
            }
            if (z) {
                if (this.fIv != null) {
                    this.fIv.a(alaActiveDynamicView, activityInfo, 0);
                }
                d(activityInfo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(int i, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (i == 2) {
                Map<String, Object> bxp = bxp();
                bxp.put(UbcStatConstant.KEY_CONTENT_ROOM, 1);
                Cg(WebviewHelper.addQueryParams(str, bxp));
                return;
            }
            if (i == 1) {
                str = WebviewHelper.addQueryParams(str, bxp());
            }
            SchemeUtils.openScheme(str);
        }
    }

    public void Cg(String str) {
        int i = 2;
        if (this.fIY == null) {
            this.fIY = new com.baidu.tieba.ala.liveroom.a.a(this.mPageContext.getPageActivity());
        }
        this.fIY.setHost(this.isHost);
        if (this.aJj != null && this.aJj.mLiveInfo != null) {
            this.fIY.g(this.aJj.mLiveInfo.user_id, this.aJj.mLiveInfo.getNameShow());
            this.fIY.setLiveId(this.aJj.mLiveInfo.live_id);
        }
        if (!this.fJp) {
            i = 0;
        } else if (UtilHelper.getRealScreenOrientation(this.mPageContext.getPageActivity()) != 2) {
            i = 1;
        }
        this.fIY.aA(str, i);
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

    private void d(i iVar) {
        if (!this.isHost && iVar != null && this.aJj != null && this.aJj.mLiveInfo != null) {
            String str = this.aJj.mLiveInfo.feed_id;
            if (!TextUtils.isEmpty(str)) {
                if (TbadkCoreApplication.getInst().isHaokan() || TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem = new AlaStaticItem(SdkStaticKeys.DISPLAY_PENDANT);
                    alaStaticItem.addParams("feed_id", str);
                    alaStaticItem.addParams(SdkStaticKeys.KEY_PENDANT_ID, iVar.activityId + "");
                    alaStaticItem.addParams("other_params", this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(int i) {
        JSONArray jSONArray;
        try {
            if (!StringUtils.isNull(this.fIZ)) {
                jSONArray = new JSONArray(this.fIZ);
            } else {
                jSONArray = new JSONArray("[]");
            }
            jSONArray.put(i);
            this.fIZ = jSONArray.toString();
            com.baidu.live.c.uN().putString("ala_active_view_click_info", this.fIZ);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean qN(int i) {
        if (StringUtils.isNull(this.fIZ)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(this.fIZ);
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
        ViewGroup fJu;
        ViewGroup.LayoutParams fJv;

        c(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams) {
            this.fJu = viewGroup;
            this.fJv = layoutParams;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.liveroom.activeview.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class HandlerC0556b extends Handler {
        private final WeakReference<b> fJt;

        HandlerC0556b(b bVar) {
            this.fJt = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.fJt.get() != null && message.what == 1000) {
                this.fJt.get().bxs();
            }
        }
    }
}
