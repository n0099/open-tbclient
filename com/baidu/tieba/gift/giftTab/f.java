package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class f {
    private String addFreeUrl;
    private ArrayList<c> baV;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> baW;
    private ArrayList<e> baX;
    public int currencyType;
    private int freeChance;
    private a jVi;
    private b jVj;
    private DefaultGiftListModel jVo;
    private CategoryGiftListModel jVp;
    private FreeGiftChanceModel jVq;
    private HashMap<Integer, ArrayList<ai>> jVr = new HashMap<>();
    private DefaultGiftListModel.a jVs = new DefaultGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.1
        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.a
        public void a(int i, String str, int i2, String str2, int i3, aj ajVar, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList, ArrayList<ai> arrayList2, ArrayList<e> arrayList3) {
            if (i == 0) {
                int i4 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i4 = arrayList.get(0).getCategoryId();
                }
                f.this.baW = arrayList;
                f.this.jVr.put(Integer.valueOf(i4), arrayList2);
                f.this.baX = arrayList3;
                f.this.addFreeUrl = str2;
                f.this.freeChance = i2;
                f.this.currencyType = i3;
                f.this.urlTitleData = ajVar;
                f.this.cNN();
            }
            if (f.this.jVj != null) {
                f.this.jVj.a(i, str, true, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.baV, f.this.baW, f.this.baX);
            }
        }
    };
    private CategoryGiftListModel.a jVt = new CategoryGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.2
        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.a
        public void a(int i, String str, int i2, ArrayList<ai> arrayList) {
            if (i == 0) {
                f.this.jVr.put(Integer.valueOf(i2), arrayList);
                f.this.cNN();
            }
            if (f.this.jVj != null) {
                f.this.jVj.a(i, str, false, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.baV, f.this.baW, f.this.baX);
            }
        }
    };
    private FreeGiftChanceModel.a jVu = new FreeGiftChanceModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.3
        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.a
        public void c(int i, String str, int i2) {
            if (i == 0) {
                f.this.freeChance = i2;
                if (f.this.jVi != null) {
                    f.this.jVi.Bm(f.this.freeChance);
                }
            }
        }
    };
    private com.baidu.adp.base.f<GiftTabActivity> mContext;
    public aj urlTitleData;

    /* loaded from: classes9.dex */
    public interface a {
        void Bm(int i);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i, String str, boolean z, String str2, int i2, aj ajVar, ArrayList<c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<e> arrayList3);
    }

    public f(com.baidu.adp.base.f<GiftTabActivity> fVar) {
        this.mContext = fVar;
        this.jVo = new DefaultGiftListModel(this.mContext);
        this.jVo.a(this.jVs);
        this.jVp = new CategoryGiftListModel(this.mContext);
        this.jVp.a(this.jVt);
        this.jVq = new FreeGiftChanceModel(this.mContext);
        this.jVq.a(this.jVu);
    }

    public void I(String str, long j) {
        if (this.jVo == null) {
            this.jVo = new DefaultGiftListModel(this.mContext);
            this.jVo.a(this.jVs);
        }
        this.jVo.H(str, j);
    }

    public void Bn(int i) {
        if (this.jVp == null) {
            this.jVp = new CategoryGiftListModel(this.mContext);
            this.jVp.a(this.jVt);
        }
        this.jVp.loadData(i);
    }

    public void Lv(String str) {
        if (this.jVq == null) {
            this.jVq = new FreeGiftChanceModel(this.mContext);
            this.jVq.a(this.jVu);
        }
        this.jVq.gL(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNN() {
        if (this.jVr != null && this.jVr.size() > 0 && this.baW != null && this.baW.size() > 0) {
            if (this.baV == null) {
                this.baV = new ArrayList<>();
            }
            this.baV.clear();
            Iterator<com.baidu.tieba.gift.giftTab.a> it = this.baW.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.gift.giftTab.a next = it.next();
                if (next != null && !StringUtils.isNull(next.getCategoryName())) {
                    c cVar = new c();
                    cVar.setCategoryId(next.getCategoryId());
                    cVar.setCategoryName(next.getCategoryName());
                    ArrayList<ai> arrayList = this.jVr.get(Integer.valueOf(next.getCategoryId()));
                    if (arrayList != null) {
                        cVar.G(arrayList);
                    }
                    this.baV.add(cVar);
                }
            }
        }
    }

    public void a(b bVar) {
        this.jVj = bVar;
    }

    public void a(a aVar) {
        this.jVi = aVar;
    }
}
