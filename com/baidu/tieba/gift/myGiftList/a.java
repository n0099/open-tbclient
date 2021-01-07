package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.core.data.ai;
import java.util.ArrayList;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
/* loaded from: classes9.dex */
public class a {
    private ArrayList<C0757a> giftList;
    private long jSW;
    private long jSX;
    private b jSY;
    private c jSZ;
    public long jTa;
    private long sceneId;
    public ai urlTitleData;

    /* renamed from: com.baidu.tieba.gift.myGiftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0757a {
        public long aZk;
        public String aZm;
        public long aZp;
        public long createTime;
        public int eQv;
        public String giftName;
        public String jTb;
        public long jTc;
        public long jTd;
        public String jTe;
        public int jTf;
        public String nameShow;
        public String playUrl;
        public String thumbnailUrl;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public int hcn;
        public int jTg;
        public int jTh;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public String aJH;
        public String jTi;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jSW = dataRes.total_num.intValue();
            this.jSX = dataRes.money.intValue();
            this.sceneId = dataRes.scene_id.intValue();
            this.jTa = dataRes.blue_diamond.intValue();
            if (dataRes.blue_diamond_txt != null) {
                this.urlTitleData = new ai();
                if (dataRes.blue_diamond_txt.txt != null) {
                    this.urlTitleData.eQw = dataRes.blue_diamond_txt.txt;
                }
                if (dataRes.blue_diamond_txt.url != null) {
                    this.urlTitleData.eQx = dataRes.blue_diamond_txt.url;
                }
            }
            if (dataRes.page != null) {
                this.jSY = new b();
                this.jSY.hcn = dataRes.page.cur_page.intValue();
                this.jSY.jTg = dataRes.page.has_more.intValue();
                this.jSY.jTh = dataRes.page.total.intValue();
            }
            if (dataRes.money_txt != null) {
                this.jSZ = new c();
                this.jSZ.jTi = dataRes.money_txt.txt;
                this.jSZ.aJH = dataRes.money_txt.url;
            }
            if (dataRes.gift_list != null && dataRes.gift_list.size() > 0) {
                this.giftList = new ArrayList<>();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < dataRes.gift_list.size()) {
                        PresentMyList presentMyList = dataRes.gift_list.get(i2);
                        if (presentMyList != null) {
                            C0757a c0757a = new C0757a();
                            c0757a.jTf = i2 + 1;
                            c0757a.aZk = presentMyList.pay_userid.longValue();
                            c0757a.aZm = presentMyList.pay_username;
                            c0757a.jTb = presentMyList.portrait;
                            c0757a.aZp = presentMyList.gift_id.intValue();
                            c0757a.giftName = presentMyList.gift_name;
                            c0757a.playUrl = presentMyList.play_url;
                            c0757a.thumbnailUrl = presentMyList.thumbnail_url;
                            c0757a.createTime = presentMyList.create_time.intValue();
                            c0757a.jTc = presentMyList.num.intValue();
                            c0757a.eQv = presentMyList.currency_unit.intValue();
                            c0757a.jTe = presentMyList.currency_type;
                            c0757a.jTd = presentMyList.present_scores.longValue();
                            c0757a.nameShow = presentMyList.name_show;
                            this.giftList.add(c0757a);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public long cPQ() {
        return this.jSW;
    }

    public void gu(long j) {
        this.jSW = j;
    }

    public long cPR() {
        return this.jSX;
    }

    public void gv(long j) {
        this.jSX = j;
    }

    public b cPS() {
        return this.jSY;
    }

    public void a(b bVar) {
        this.jSY = bVar;
    }

    public c cPT() {
        return this.jSZ;
    }

    public void a(c cVar) {
        this.jSZ = cVar;
    }

    public ArrayList<C0757a> getGiftList() {
        return this.giftList;
    }

    public void aJ(ArrayList<C0757a> arrayList) {
        this.giftList = arrayList;
    }
}
