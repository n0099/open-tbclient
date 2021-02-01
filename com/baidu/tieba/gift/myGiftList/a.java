package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.core.data.aj;
import java.util.ArrayList;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
/* loaded from: classes9.dex */
public class a {
    private ArrayList<C0741a> giftList;
    private long jVT;
    private long jVU;
    private b jVV;
    private c jVW;
    public long jVX;
    private long sceneId;
    public aj urlTitleData;

    /* renamed from: com.baidu.tieba.gift.myGiftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0741a {
        public long aXC;
        public String aXE;
        public long aXH;
        public long createTime;
        public int eNW;
        public String giftName;
        public String jVY;
        public long jVZ;
        public long jWa;
        public String jWb;
        public int jWc;
        public String nameShow;
        public String playUrl;
        public String thumbnailUrl;
    }

    /* loaded from: classes9.dex */
    public static class b {
        public int har;
        public int jWd;
        public int jWe;
    }

    /* loaded from: classes9.dex */
    public static class c {
        public String aHq;
        public String jWf;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jVT = dataRes.total_num.intValue();
            this.jVU = dataRes.money.intValue();
            this.sceneId = dataRes.scene_id.intValue();
            this.jVX = dataRes.blue_diamond.intValue();
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
                this.jVV = new b();
                this.jVV.har = dataRes.page.cur_page.intValue();
                this.jVV.jWd = dataRes.page.has_more.intValue();
                this.jVV.jWe = dataRes.page.total.intValue();
            }
            if (dataRes.money_txt != null) {
                this.jVW = new c();
                this.jVW.jWf = dataRes.money_txt.txt;
                this.jVW.aHq = dataRes.money_txt.url;
            }
            if (dataRes.gift_list != null && dataRes.gift_list.size() > 0) {
                this.giftList = new ArrayList<>();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < dataRes.gift_list.size()) {
                        PresentMyList presentMyList = dataRes.gift_list.get(i2);
                        if (presentMyList != null) {
                            C0741a c0741a = new C0741a();
                            c0741a.jWc = i2 + 1;
                            c0741a.aXC = presentMyList.pay_userid.longValue();
                            c0741a.aXE = presentMyList.pay_username;
                            c0741a.jVY = presentMyList.portrait;
                            c0741a.aXH = presentMyList.gift_id.intValue();
                            c0741a.giftName = presentMyList.gift_name;
                            c0741a.playUrl = presentMyList.play_url;
                            c0741a.thumbnailUrl = presentMyList.thumbnail_url;
                            c0741a.createTime = presentMyList.create_time.intValue();
                            c0741a.jVZ = presentMyList.num.intValue();
                            c0741a.eNW = presentMyList.currency_unit.intValue();
                            c0741a.jWb = presentMyList.currency_type;
                            c0741a.jWa = presentMyList.present_scores.longValue();
                            c0741a.nameShow = presentMyList.name_show;
                            this.giftList.add(c0741a);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public long cNV() {
        return this.jVT;
    }

    public void gz(long j) {
        this.jVT = j;
    }

    public long cNW() {
        return this.jVU;
    }

    public void gA(long j) {
        this.jVU = j;
    }

    public b cNX() {
        return this.jVV;
    }

    public void a(b bVar) {
        this.jVV = bVar;
    }

    public c cNY() {
        return this.jVW;
    }

    public void a(c cVar) {
        this.jVW = cVar;
    }

    public ArrayList<C0741a> getGiftList() {
        return this.giftList;
    }

    public void aD(ArrayList<C0741a> arrayList) {
        this.giftList = arrayList;
    }
}
