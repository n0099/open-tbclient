package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.core.data.aj;
import java.util.ArrayList;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
/* loaded from: classes9.dex */
public class a {
    private ArrayList<C0742a> giftList;
    private long jWh;
    private long jWi;
    private b jWj;
    private c jWk;
    public long jWl;
    private long sceneId;
    public aj urlTitleData;

    /* renamed from: com.baidu.tieba.gift.myGiftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0742a {
        public long aXC;
        public String aXE;
        public long aXH;
        public long createTime;
        public int eNW;
        public String giftName;
        public String jWm;
        public long jWn;
        public long jWo;
        public String jWp;
        public int jWq;
        public String nameShow;
        public String playUrl;
        public String thumbnailUrl;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public int haF;
        public int jWr;
        public int jWs;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public String aHq;
        public String jWt;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jWh = dataRes.total_num.intValue();
            this.jWi = dataRes.money.intValue();
            this.sceneId = dataRes.scene_id.intValue();
            this.jWl = dataRes.blue_diamond.intValue();
            if (dataRes.blue_diamond_txt != null) {
                this.urlTitleData = new aj();
                if (dataRes.blue_diamond_txt.txt != null) {
                    this.urlTitleData.eNX = dataRes.blue_diamond_txt.txt;
                }
                if (dataRes.blue_diamond_txt.url != null) {
                    this.urlTitleData.eNY = dataRes.blue_diamond_txt.url;
                }
            }
            if (dataRes.page != null) {
                this.jWj = new b();
                this.jWj.haF = dataRes.page.cur_page.intValue();
                this.jWj.jWr = dataRes.page.has_more.intValue();
                this.jWj.jWs = dataRes.page.total.intValue();
            }
            if (dataRes.money_txt != null) {
                this.jWk = new c();
                this.jWk.jWt = dataRes.money_txt.txt;
                this.jWk.aHq = dataRes.money_txt.url;
            }
            if (dataRes.gift_list != null && dataRes.gift_list.size() > 0) {
                this.giftList = new ArrayList<>();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < dataRes.gift_list.size()) {
                        PresentMyList presentMyList = dataRes.gift_list.get(i2);
                        if (presentMyList != null) {
                            C0742a c0742a = new C0742a();
                            c0742a.jWq = i2 + 1;
                            c0742a.aXC = presentMyList.pay_userid.longValue();
                            c0742a.aXE = presentMyList.pay_username;
                            c0742a.jWm = presentMyList.portrait;
                            c0742a.aXH = presentMyList.gift_id.intValue();
                            c0742a.giftName = presentMyList.gift_name;
                            c0742a.playUrl = presentMyList.play_url;
                            c0742a.thumbnailUrl = presentMyList.thumbnail_url;
                            c0742a.createTime = presentMyList.create_time.intValue();
                            c0742a.jWn = presentMyList.num.intValue();
                            c0742a.eNW = presentMyList.currency_unit.intValue();
                            c0742a.jWp = presentMyList.currency_type;
                            c0742a.jWo = presentMyList.present_scores.longValue();
                            c0742a.nameShow = presentMyList.name_show;
                            this.giftList.add(c0742a);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public long cOc() {
        return this.jWh;
    }

    public void gz(long j) {
        this.jWh = j;
    }

    public long cOd() {
        return this.jWi;
    }

    public void gA(long j) {
        this.jWi = j;
    }

    public b cOe() {
        return this.jWj;
    }

    public void a(b bVar) {
        this.jWj = bVar;
    }

    public c cOf() {
        return this.jWk;
    }

    public void a(c cVar) {
        this.jWk = cVar;
    }

    public ArrayList<C0742a> getGiftList() {
        return this.giftList;
    }

    public void aD(ArrayList<C0742a> arrayList) {
        this.giftList = arrayList;
    }
}
