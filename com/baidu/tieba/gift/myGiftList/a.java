package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.core.data.ai;
import java.util.ArrayList;
import tbclient.GetMyGift.DataRes;
import tbclient.GetMyGift.PresentMyList;
/* loaded from: classes8.dex */
public class a {
    private ArrayList<C0740a> giftList;
    private long jOr;
    private long jOs;
    private b jOt;
    private c jOu;
    public long jOv;
    private long sceneId;
    public ai urlTitleData;

    /* renamed from: com.baidu.tieba.gift.myGiftList.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0740a {
        public long aUC;
        public long aUx;
        public String aUz;
        public long createTime;
        public int eLK;
        public String giftName;
        public int jOA;
        public String jOw;
        public long jOx;
        public long jOy;
        public String jOz;
        public String nameShow;
        public String playUrl;
        public String thumbnailUrl;
    }

    /* loaded from: classes8.dex */
    public static class b {
        public int gXH;
        public int jOB;
        public int jOC;
    }

    /* loaded from: classes8.dex */
    public static class c {
        public String aEU;
        public String jOD;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null) {
            this.jOr = dataRes.total_num.intValue();
            this.jOs = dataRes.money.intValue();
            this.sceneId = dataRes.scene_id.intValue();
            this.jOv = dataRes.blue_diamond.intValue();
            if (dataRes.blue_diamond_txt != null) {
                this.urlTitleData = new ai();
                if (dataRes.blue_diamond_txt.txt != null) {
                    this.urlTitleData.eLL = dataRes.blue_diamond_txt.txt;
                }
                if (dataRes.blue_diamond_txt.url != null) {
                    this.urlTitleData.eLM = dataRes.blue_diamond_txt.url;
                }
            }
            if (dataRes.page != null) {
                this.jOt = new b();
                this.jOt.gXH = dataRes.page.cur_page.intValue();
                this.jOt.jOB = dataRes.page.has_more.intValue();
                this.jOt.jOC = dataRes.page.total.intValue();
            }
            if (dataRes.money_txt != null) {
                this.jOu = new c();
                this.jOu.jOD = dataRes.money_txt.txt;
                this.jOu.aEU = dataRes.money_txt.url;
            }
            if (dataRes.gift_list != null && dataRes.gift_list.size() > 0) {
                this.giftList = new ArrayList<>();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < dataRes.gift_list.size()) {
                        PresentMyList presentMyList = dataRes.gift_list.get(i2);
                        if (presentMyList != null) {
                            C0740a c0740a = new C0740a();
                            c0740a.jOA = i2 + 1;
                            c0740a.aUx = presentMyList.pay_userid.longValue();
                            c0740a.aUz = presentMyList.pay_username;
                            c0740a.jOw = presentMyList.portrait;
                            c0740a.aUC = presentMyList.gift_id.intValue();
                            c0740a.giftName = presentMyList.gift_name;
                            c0740a.playUrl = presentMyList.play_url;
                            c0740a.thumbnailUrl = presentMyList.thumbnail_url;
                            c0740a.createTime = presentMyList.create_time.intValue();
                            c0740a.jOx = presentMyList.num.intValue();
                            c0740a.eLK = presentMyList.currency_unit.intValue();
                            c0740a.jOz = presentMyList.currency_type;
                            c0740a.jOy = presentMyList.present_scores.longValue();
                            c0740a.nameShow = presentMyList.name_show;
                            this.giftList.add(c0740a);
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public long cLY() {
        return this.jOr;
    }

    public void gu(long j) {
        this.jOr = j;
    }

    public long cLZ() {
        return this.jOs;
    }

    public void gv(long j) {
        this.jOs = j;
    }

    public b cMa() {
        return this.jOt;
    }

    public void a(b bVar) {
        this.jOt = bVar;
    }

    public c cMb() {
        return this.jOu;
    }

    public void a(c cVar) {
        this.jOu = cVar;
    }

    public ArrayList<C0740a> getGiftList() {
        return this.giftList;
    }

    public void aE(ArrayList<C0740a> arrayList) {
        this.giftList = arrayList;
    }
}
