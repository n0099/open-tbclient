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
    private DefaultGiftListModel jVC;
    private CategoryGiftListModel jVD;
    private FreeGiftChanceModel jVE;
    private HashMap<Integer, ArrayList<ai>> jVF = new HashMap<>();
    private DefaultGiftListModel.a jVG = new DefaultGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.1
        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.a
        public void a(int i, String str, int i2, String str2, int i3, aj ajVar, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList, ArrayList<ai> arrayList2, ArrayList<e> arrayList3) {
            if (i == 0) {
                int i4 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i4 = arrayList.get(0).getCategoryId();
                }
                f.this.baW = arrayList;
                f.this.jVF.put(Integer.valueOf(i4), arrayList2);
                f.this.baX = arrayList3;
                f.this.addFreeUrl = str2;
                f.this.freeChance = i2;
                f.this.currencyType = i3;
                f.this.urlTitleData = ajVar;
                f.this.cNU();
            }
            if (f.this.jVx != null) {
                f.this.jVx.a(i, str, true, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.baV, f.this.baW, f.this.baX);
            }
        }
    };
    private CategoryGiftListModel.a jVH = new CategoryGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.2
        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.a
        public void a(int i, String str, int i2, ArrayList<ai> arrayList) {
            if (i == 0) {
                f.this.jVF.put(Integer.valueOf(i2), arrayList);
                f.this.cNU();
            }
            if (f.this.jVx != null) {
                f.this.jVx.a(i, str, false, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.baV, f.this.baW, f.this.baX);
            }
        }
    };
    private FreeGiftChanceModel.a jVI = new FreeGiftChanceModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.3
        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.a
        public void c(int i, String str, int i2) {
            if (i == 0) {
                f.this.freeChance = i2;
                if (f.this.jVw != null) {
                    f.this.jVw.Bm(f.this.freeChance);
                }
            }
        }
    };
    private a jVw;
    private b jVx;
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
        this.jVC = new DefaultGiftListModel(this.mContext);
        this.jVC.a(this.jVG);
        this.jVD = new CategoryGiftListModel(this.mContext);
        this.jVD.a(this.jVH);
        this.jVE = new FreeGiftChanceModel(this.mContext);
        this.jVE.a(this.jVI);
    }

    public void I(String str, long j) {
        if (this.jVC == null) {
            this.jVC = new DefaultGiftListModel(this.mContext);
            this.jVC.a(this.jVG);
        }
        this.jVC.H(str, j);
    }

    public void Bn(int i) {
        if (this.jVD == null) {
            this.jVD = new CategoryGiftListModel(this.mContext);
            this.jVD.a(this.jVH);
        }
        this.jVD.loadData(i);
    }

    public void Lw(String str) {
        if (this.jVE == null) {
            this.jVE = new FreeGiftChanceModel(this.mContext);
            this.jVE.a(this.jVI);
        }
        this.jVE.gL(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNU() {
        if (this.jVF != null && this.jVF.size() > 0 && this.baW != null && this.baW.size() > 0) {
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
                    ArrayList<ai> arrayList = this.jVF.get(Integer.valueOf(next.getCategoryId()));
                    if (arrayList != null) {
                        cVar.G(arrayList);
                    }
                    this.baV.add(cVar);
                }
            }
        }
    }

    public void a(b bVar) {
        this.jVx = bVar;
    }

    public void a(a aVar) {
        this.jVw = aVar;
    }
}
