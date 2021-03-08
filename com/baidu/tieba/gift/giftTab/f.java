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
/* loaded from: classes8.dex */
public class f {
    private String addFreeUrl;
    private ArrayList<c> bcv;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> bcw;
    private ArrayList<e> bcx;
    public int currencyType;
    private int freeChance;
    private DefaultGiftListModel jXE;
    private CategoryGiftListModel jXF;
    private FreeGiftChanceModel jXG;
    private HashMap<Integer, ArrayList<ai>> jXH = new HashMap<>();
    private DefaultGiftListModel.a jXI = new DefaultGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.1
        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.a
        public void a(int i, String str, int i2, String str2, int i3, aj ajVar, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList, ArrayList<ai> arrayList2, ArrayList<e> arrayList3) {
            if (i == 0) {
                int i4 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i4 = arrayList.get(0).getCategoryId();
                }
                f.this.bcw = arrayList;
                f.this.jXH.put(Integer.valueOf(i4), arrayList2);
                f.this.bcx = arrayList3;
                f.this.addFreeUrl = str2;
                f.this.freeChance = i2;
                f.this.currencyType = i3;
                f.this.urlTitleData = ajVar;
                f.this.cOb();
            }
            if (f.this.jXz != null) {
                f.this.jXz.a(i, str, true, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.bcv, f.this.bcw, f.this.bcx);
            }
        }
    };
    private CategoryGiftListModel.a jXJ = new CategoryGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.2
        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.a
        public void a(int i, String str, int i2, ArrayList<ai> arrayList) {
            if (i == 0) {
                f.this.jXH.put(Integer.valueOf(i2), arrayList);
                f.this.cOb();
            }
            if (f.this.jXz != null) {
                f.this.jXz.a(i, str, false, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.bcv, f.this.bcw, f.this.bcx);
            }
        }
    };
    private FreeGiftChanceModel.a jXK = new FreeGiftChanceModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.3
        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.a
        public void c(int i, String str, int i2) {
            if (i == 0) {
                f.this.freeChance = i2;
                if (f.this.jXy != null) {
                    f.this.jXy.Bp(f.this.freeChance);
                }
            }
        }
    };
    private a jXy;
    private b jXz;
    private com.baidu.adp.base.f<GiftTabActivity> mContext;
    public aj urlTitleData;

    /* loaded from: classes8.dex */
    public interface a {
        void Bp(int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, String str, boolean z, String str2, int i2, aj ajVar, ArrayList<c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<e> arrayList3);
    }

    public f(com.baidu.adp.base.f<GiftTabActivity> fVar) {
        this.mContext = fVar;
        this.jXE = new DefaultGiftListModel(this.mContext);
        this.jXE.a(this.jXI);
        this.jXF = new CategoryGiftListModel(this.mContext);
        this.jXF.a(this.jXJ);
        this.jXG = new FreeGiftChanceModel(this.mContext);
        this.jXG.a(this.jXK);
    }

    public void I(String str, long j) {
        if (this.jXE == null) {
            this.jXE = new DefaultGiftListModel(this.mContext);
            this.jXE.a(this.jXI);
        }
        this.jXE.H(str, j);
    }

    public void Bq(int i) {
        if (this.jXF == null) {
            this.jXF = new CategoryGiftListModel(this.mContext);
            this.jXF.a(this.jXJ);
        }
        this.jXF.loadData(i);
    }

    public void LC(String str) {
        if (this.jXG == null) {
            this.jXG = new FreeGiftChanceModel(this.mContext);
            this.jXG.a(this.jXK);
        }
        this.jXG.gR(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOb() {
        if (this.jXH != null && this.jXH.size() > 0 && this.bcw != null && this.bcw.size() > 0) {
            if (this.bcv == null) {
                this.bcv = new ArrayList<>();
            }
            this.bcv.clear();
            Iterator<com.baidu.tieba.gift.giftTab.a> it = this.bcw.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.gift.giftTab.a next = it.next();
                if (next != null && !StringUtils.isNull(next.getCategoryName())) {
                    c cVar = new c();
                    cVar.setCategoryId(next.getCategoryId());
                    cVar.setCategoryName(next.getCategoryName());
                    ArrayList<ai> arrayList = this.jXH.get(Integer.valueOf(next.getCategoryId()));
                    if (arrayList != null) {
                        cVar.G(arrayList);
                    }
                    this.bcv.add(cVar);
                }
            }
        }
    }

    public void a(b bVar) {
        this.jXz = bVar;
    }

    public void a(a aVar) {
        this.jXy = aVar;
    }
}
