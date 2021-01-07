package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tieba.gift.giftTab.CategoryGiftListModel;
import com.baidu.tieba.gift.giftTab.DefaultGiftListModel;
import com.baidu.tieba.gift.giftTab.FreeGiftChanceModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes9.dex */
public class f {
    private String addFreeUrl;
    private ArrayList<c> bcC;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> bcD;
    private ArrayList<e> bcE;
    public int currencyType;
    private int freeChance;
    private a jSl;
    private b jSm;
    private DefaultGiftListModel jSr;
    private CategoryGiftListModel jSs;
    private FreeGiftChanceModel jSt;
    private HashMap<Integer, ArrayList<ah>> jSu = new HashMap<>();
    private DefaultGiftListModel.a jSv = new DefaultGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.1
        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.a
        public void a(int i, String str, int i2, String str2, int i3, ai aiVar, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList, ArrayList<ah> arrayList2, ArrayList<e> arrayList3) {
            if (i == 0) {
                int i4 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i4 = arrayList.get(0).getCategoryId();
                }
                f.this.bcD = arrayList;
                f.this.jSu.put(Integer.valueOf(i4), arrayList2);
                f.this.bcE = arrayList3;
                f.this.addFreeUrl = str2;
                f.this.freeChance = i2;
                f.this.currencyType = i3;
                f.this.urlTitleData = aiVar;
                f.this.cPI();
            }
            if (f.this.jSm != null) {
                f.this.jSm.a(i, str, true, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.bcC, f.this.bcD, f.this.bcE);
            }
        }
    };
    private CategoryGiftListModel.a jSw = new CategoryGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.2
        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.a
        public void a(int i, String str, int i2, ArrayList<ah> arrayList) {
            if (i == 0) {
                f.this.jSu.put(Integer.valueOf(i2), arrayList);
                f.this.cPI();
            }
            if (f.this.jSm != null) {
                f.this.jSm.a(i, str, false, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.bcC, f.this.bcD, f.this.bcE);
            }
        }
    };
    private FreeGiftChanceModel.a jSx = new FreeGiftChanceModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.3
        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.a
        public void b(int i, String str, int i2) {
            if (i == 0) {
                f.this.freeChance = i2;
                if (f.this.jSl != null) {
                    f.this.jSl.CD(f.this.freeChance);
                }
            }
        }
    };
    private com.baidu.adp.base.f<GiftTabActivity> mContext;
    public ai urlTitleData;

    /* loaded from: classes9.dex */
    public interface a {
        void CD(int i);
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(int i, String str, boolean z, String str2, int i2, ai aiVar, ArrayList<c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<e> arrayList3);
    }

    public f(com.baidu.adp.base.f<GiftTabActivity> fVar) {
        this.mContext = fVar;
        this.jSr = new DefaultGiftListModel(this.mContext);
        this.jSr.a(this.jSv);
        this.jSs = new CategoryGiftListModel(this.mContext);
        this.jSs.a(this.jSw);
        this.jSt = new FreeGiftChanceModel(this.mContext);
        this.jSt.a(this.jSx);
    }

    public void J(String str, long j) {
        if (this.jSr == null) {
            this.jSr = new DefaultGiftListModel(this.mContext);
            this.jSr.a(this.jSv);
        }
        this.jSr.I(str, j);
    }

    public void CE(int i) {
        if (this.jSs == null) {
            this.jSs = new CategoryGiftListModel(this.mContext);
            this.jSs.a(this.jSw);
        }
        this.jSs.loadData(i);
    }

    public void LP(String str) {
        if (this.jSt == null) {
            this.jSt = new FreeGiftChanceModel(this.mContext);
            this.jSt.a(this.jSx);
        }
        this.jSt.hz(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPI() {
        if (this.jSu != null && this.jSu.size() > 0 && this.bcD != null && this.bcD.size() > 0) {
            if (this.bcC == null) {
                this.bcC = new ArrayList<>();
            }
            this.bcC.clear();
            Iterator<com.baidu.tieba.gift.giftTab.a> it = this.bcD.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.gift.giftTab.a next = it.next();
                if (next != null && !StringUtils.isNull(next.getCategoryName())) {
                    c cVar = new c();
                    cVar.setCategoryId(next.getCategoryId());
                    cVar.setCategoryName(next.getCategoryName());
                    ArrayList<ah> arrayList = this.jSu.get(Integer.valueOf(next.getCategoryId()));
                    if (arrayList != null) {
                        cVar.G(arrayList);
                    }
                    this.bcC.add(cVar);
                }
            }
        }
    }

    public void a(b bVar) {
        this.jSm = bVar;
    }

    public void a(a aVar) {
        this.jSl = aVar;
    }
}
