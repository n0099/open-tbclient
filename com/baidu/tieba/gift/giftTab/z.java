package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.gift.giftTab.a;
import com.baidu.tieba.gift.giftTab.d;
import com.baidu.tieba.gift.giftTab.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes.dex */
public class z {
    private String addFreeUrl;
    private ArrayList<k> bvA;
    private HashMap<Integer, ArrayList<com.baidu.tbadk.core.data.l>> bvB = new HashMap<>();
    private d.a bvC = new aa(this);
    private a.InterfaceC0062a bvD = new ab(this);
    private f.a bvE = new ac(this);
    private a bvp;
    private b bvq;
    private d bvv;
    private com.baidu.tieba.gift.giftTab.a bvw;
    private f bvx;
    private ArrayList<i> bvy;
    private ArrayList<c> bvz;
    private int freeChance;
    private com.baidu.adp.base.h<GiftTabActivity> mContext;

    /* loaded from: classes.dex */
    public interface a {
        void hw(int i);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i, String str, boolean z, String str2, ArrayList<i> arrayList, ArrayList<c> arrayList2, ArrayList<k> arrayList3);
    }

    public z(com.baidu.adp.base.h<GiftTabActivity> hVar) {
        this.mContext = hVar;
        this.bvv = new d(this.mContext);
        this.bvv.a(this.bvC);
        this.bvw = new com.baidu.tieba.gift.giftTab.a(this.mContext);
        this.bvw.a(this.bvD);
        this.bvx = new f(this.mContext);
        this.bvx.a(this.bvE);
    }

    public void j(String str, long j) {
        if (this.bvv == null) {
            this.bvv = new d(this.mContext);
            this.bvv.a(this.bvC);
        }
        this.bvv.i(str, j);
    }

    public void hx(int i) {
        if (this.bvw == null) {
            this.bvw = new com.baidu.tieba.gift.giftTab.a(this.mContext);
            this.bvw.a(this.bvD);
        }
        this.bvw.fL(i);
    }

    public void hJ(String str) {
        if (this.bvx == null) {
            this.bvx = new f(this.mContext);
            this.bvx.a(this.bvE);
        }
        this.bvx.hI(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Th() {
        if (this.bvB != null && this.bvB.size() > 0 && this.bvz != null && this.bvz.size() > 0) {
            if (this.bvy == null) {
                this.bvy = new ArrayList<>();
            }
            this.bvy.clear();
            Iterator<c> it = this.bvz.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next != null && !StringUtils.isNull(next.getCategoryName())) {
                    i iVar = new i();
                    iVar.setCategoryId(next.getCategoryId());
                    iVar.setCategoryName(next.getCategoryName());
                    ArrayList<com.baidu.tbadk.core.data.l> arrayList = this.bvB.get(Integer.valueOf(next.getCategoryId()));
                    if (arrayList != null) {
                        iVar.aL(arrayList);
                    }
                    this.bvy.add(iVar);
                }
            }
        }
    }

    public void a(b bVar) {
        this.bvq = bVar;
    }

    public void a(a aVar) {
        this.bvp = aVar;
    }
}
