package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.core.data.aj;
import java.util.ArrayList;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<C0748a> giftList;
    private long jYj;
    private long jYk;
    private b jYl;
    private c jYm;
    public long jYn;
    private long sceneId;
    public aj urlTitleData;

    /* renamed from: com.baidu.tieba.gift.myGiftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0748a {
        public long aZc;
        public String aZe;
        public long aZh;
        public long createTime;
        public int ePx;
        public String giftName;
        public String jYo;
        public long jYp;
        public long jYq;
        public String jYr;
        public int jYs;
        public String nameShow;
        public String playUrl;
        public String thumbnailUrl;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public int hco;
        public int jYt;
        public int jYu;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public String aIQ;
        public String jYv;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jYj = dataRes.total_num.intValue();
            this.jYk = dataRes.money.intValue();
            this.sceneId = dataRes.scene_id.intValue();
            this.jYn = dataRes.blue_diamond.intValue();
            if (dataRes.blue_diamond_txt != null) {
                this.urlTitleData = new aj();
                if (dataRes.blue_diamond_txt.txt != null) {
                    this.urlTitleData.ePy = dataRes.blue_diamond_txt.txt;
                }
                if (dataRes.blue_diamond_txt.url != null) {
                    this.urlTitleData.ePz = dataRes.blue_diamond_txt.url;
                }
            }
            if (dataRes.page != null) {
                this.jYl = new b();
                this.jYl.hco = dataRes.page.cur_page.intValue();
                this.jYl.jYt = dataRes.page.has_more.intValue();
                this.jYl.jYu = dataRes.page.total.intValue();
            }
            if (dataRes.money_txt != null) {
                this.jYm = new c();
                this.jYm.jYv = dataRes.money_txt.txt;
                this.jYm.aIQ = dataRes.money_txt.url;
            }
            if (dataRes.gift_list != null && dataRes.gift_list.size() > 0) {
                this.giftList = new ArrayList<>();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < dataRes.gift_list.size()) {
                        PresentMyList presentMyList = dataRes.gift_list.get(i2);
                        if (presentMyList != null) {
                            C0748a c0748a = new C0748a();
                            c0748a.jYs = i2 + 1;
                            c0748a.aZc = presentMyList.pay_userid.longValue();
                            c0748a.aZe = presentMyList.pay_username;
                            c0748a.jYo = presentMyList.portrait;
                            c0748a.aZh = presentMyList.gift_id.intValue();
                            c0748a.giftName = presentMyList.gift_name;
                            c0748a.playUrl = presentMyList.play_url;
                            c0748a.thumbnailUrl = presentMyList.thumbnail_url;
                            c0748a.createTime = presentMyList.create_time.intValue();
                            c0748a.jYp = presentMyList.num.intValue();
                            c0748a.ePx = presentMyList.currency_unit.intValue();
                            c0748a.jYr = presentMyList.currency_type;
                            c0748a.jYq = presentMyList.present_scores.longValue();
                            c0748a.nameShow = presentMyList.name_show;
                            this.giftList.add(c0748a);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public long cOj() {
        return this.jYj;
    }

    public void gz(long j) {
        this.jYj = j;
    }

    public long cOk() {
        return this.jYk;
    }

    public void gA(long j) {
        this.jYk = j;
    }

    public b cOl() {
        return this.jYl;
    }

    public void a(b bVar) {
        this.jYl = bVar;
    }

    public c cOm() {
        return this.jYm;
    }

    public void a(c cVar) {
        this.jYm = cVar;
    }

    public ArrayList<C0748a> getGiftList() {
        return this.giftList;
    }

    public void aD(ArrayList<C0748a> arrayList) {
        this.giftList = arrayList;
    }
}
