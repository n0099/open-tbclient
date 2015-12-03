package com.baidu.tieba.gift.myGiftList;

import java.util.ArrayList;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
/* loaded from: classes.dex */
public class a {
    private long bwe;
    private long bwf;
    private b bwg;
    private c bwh;
    private ArrayList<C0063a> giftList;
    private long sceneId;

    /* renamed from: com.baidu.tieba.gift.myGiftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0063a {
        public String VG;
        public long bwi;
        public String bwj;
        public String bwk;
        public long bwl;
        public long bwm;
        public long createTime;
        public String playUrl;
        public String thumbnailUrl;
    }

    /* loaded from: classes.dex */
    public static class b {
        public int bwn;
        public int bwo;
        public int hasMore;
    }

    /* loaded from: classes.dex */
    public static class c {
        public String bwp;
        public String bwq;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.bwe = dataRes.total_num.intValue();
            this.bwf = dataRes.money.intValue();
            this.sceneId = dataRes.scene_id.intValue();
            if (dataRes.page != null) {
                this.bwg = new b();
                this.bwg.bwn = dataRes.page.cur_page.intValue();
                this.bwg.hasMore = dataRes.page.has_more.intValue();
                this.bwg.bwo = dataRes.page.total.intValue();
            }
            if (dataRes.money_txt != null) {
                this.bwh = new c();
                this.bwh.bwp = dataRes.money_txt.txt;
                this.bwh.bwq = dataRes.money_txt.url;
            }
            if (dataRes.gift_list != null && dataRes.gift_list.size() > 0) {
                this.giftList = new ArrayList<>();
                for (PresentMyList presentMyList : dataRes.gift_list) {
                    if (presentMyList != null) {
                        C0063a c0063a = new C0063a();
                        c0063a.bwi = presentMyList.pay_userid.longValue();
                        c0063a.bwj = presentMyList.pay_username;
                        c0063a.bwk = presentMyList.portrait;
                        c0063a.bwl = presentMyList.gift_id.intValue();
                        c0063a.VG = presentMyList.gift_name;
                        c0063a.playUrl = presentMyList.play_url;
                        c0063a.thumbnailUrl = presentMyList.thumbnail_url;
                        c0063a.createTime = presentMyList.create_time.intValue();
                        c0063a.bwm = presentMyList.num.intValue();
                        this.giftList.add(c0063a);
                    }
                }
            }
        }
    }

    public long Tp() {
        return this.bwe;
    }

    public void aH(long j) {
        this.bwe = j;
    }

    public long Tq() {
        return this.bwf;
    }

    public void aI(long j) {
        this.bwf = j;
    }

    public b Tr() {
        return this.bwg;
    }

    public void a(b bVar) {
        this.bwg = bVar;
    }

    public c Ts() {
        return this.bwh;
    }

    public void a(c cVar) {
        this.bwh = cVar;
    }

    public ArrayList<C0063a> getGiftList() {
        return this.giftList;
    }

    public void I(ArrayList<C0063a> arrayList) {
        this.giftList = arrayList;
    }
}
