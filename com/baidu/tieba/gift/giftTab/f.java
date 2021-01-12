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
/* loaded from: classes8.dex */
public class f {
    private ArrayList<c> aXO;
    private ArrayList<com.baidu.tieba.gift.giftTab.a> aXP;
    private ArrayList<e> aXQ;
    private String addFreeUrl;
    public int currencyType;
    private int freeChance;
    private a jNG;
    private b jNH;
    private DefaultGiftListModel jNM;
    private CategoryGiftListModel jNN;
    private FreeGiftChanceModel jNO;
    private HashMap<Integer, ArrayList<ah>> jNP = new HashMap<>();
    private DefaultGiftListModel.a jNQ = new DefaultGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.1
        @Override // com.baidu.tieba.gift.giftTab.DefaultGiftListModel.a
        public void a(int i, String str, int i2, String str2, int i3, ai aiVar, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList, ArrayList<ah> arrayList2, ArrayList<e> arrayList3) {
            if (i == 0) {
                int i4 = 0;
                if (arrayList != null && arrayList.size() >= 1 && arrayList.get(0) != null) {
                    i4 = arrayList.get(0).getCategoryId();
                }
                f.this.aXP = arrayList;
                f.this.jNP.put(Integer.valueOf(i4), arrayList2);
                f.this.aXQ = arrayList3;
                f.this.addFreeUrl = str2;
                f.this.freeChance = i2;
                f.this.currencyType = i3;
                f.this.urlTitleData = aiVar;
                f.this.cLQ();
            }
            if (f.this.jNH != null) {
                f.this.jNH.a(i, str, true, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.aXO, f.this.aXP, f.this.aXQ);
            }
        }
    };
    private CategoryGiftListModel.a jNR = new CategoryGiftListModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.2
        @Override // com.baidu.tieba.gift.giftTab.CategoryGiftListModel.a
        public void a(int i, String str, int i2, ArrayList<ah> arrayList) {
            if (i == 0) {
                f.this.jNP.put(Integer.valueOf(i2), arrayList);
                f.this.cLQ();
            }
            if (f.this.jNH != null) {
                f.this.jNH.a(i, str, false, f.this.addFreeUrl, f.this.currencyType, f.this.urlTitleData, f.this.aXO, f.this.aXP, f.this.aXQ);
            }
        }
    };
    private FreeGiftChanceModel.a jNS = new FreeGiftChanceModel.a() { // from class: com.baidu.tieba.gift.giftTab.f.3
        @Override // com.baidu.tieba.gift.giftTab.FreeGiftChanceModel.a
        public void c(int i, String str, int i2) {
            if (i == 0) {
                f.this.freeChance = i2;
                if (f.this.jNG != null) {
                    f.this.jNG.AX(f.this.freeChance);
                }
            }
        }
    };
    private com.baidu.adp.base.f<GiftTabActivity> mContext;
    public ai urlTitleData;

    /* loaded from: classes8.dex */
    public interface a {
        void AX(int i);
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i, String str, boolean z, String str2, int i2, ai aiVar, ArrayList<c> arrayList, ArrayList<com.baidu.tieba.gift.giftTab.a> arrayList2, ArrayList<e> arrayList3);
    }

    public f(com.baidu.adp.base.f<GiftTabActivity> fVar) {
        this.mContext = fVar;
        this.jNM = new DefaultGiftListModel(this.mContext);
        this.jNM.a(this.jNQ);
        this.jNN = new CategoryGiftListModel(this.mContext);
        this.jNN.a(this.jNR);
        this.jNO = new FreeGiftChanceModel(this.mContext);
        this.jNO.a(this.jNS);
    }

    public void J(String str, long j) {
        if (this.jNM == null) {
            this.jNM = new DefaultGiftListModel(this.mContext);
            this.jNM.a(this.jNQ);
        }
        this.jNM.I(str, j);
    }

    public void AY(int i) {
        if (this.jNN == null) {
            this.jNN = new CategoryGiftListModel(this.mContext);
            this.jNN.a(this.jNR);
        }
        this.jNN.loadData(i);
    }

    public void KH(String str) {
        if (this.jNO == null) {
            this.jNO = new FreeGiftChanceModel(this.mContext);
            this.jNO.a(this.jNS);
        }
        this.jNO.gn(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLQ() {
        if (this.jNP != null && this.jNP.size() > 0 && this.aXP != null && this.aXP.size() > 0) {
            if (this.aXO == null) {
                this.aXO = new ArrayList<>();
            }
            this.aXO.clear();
            Iterator<com.baidu.tieba.gift.giftTab.a> it = this.aXP.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.gift.giftTab.a next = it.next();
                if (next != null && !StringUtils.isNull(next.getCategoryName())) {
                    c cVar = new c();
                    cVar.setCategoryId(next.getCategoryId());
                    cVar.setCategoryName(next.getCategoryName());
                    ArrayList<ah> arrayList = this.jNP.get(Integer.valueOf(next.getCategoryId()));
                    if (arrayList != null) {
                        cVar.G(arrayList);
                    }
                    this.aXO.add(cVar);
                }
            }
        }
    }

    public void a(b bVar) {
        this.jNH = bVar;
    }

    public void a(a aVar) {
        this.jNG = aVar;
    }
}
