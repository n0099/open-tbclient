package com.baidu.tieba.frs.worldcup.talkball.model;

import android.text.TextUtils;
import com.baidu.tieba.frs.worldcup.talkball.b.e;
import com.baidu.tieba.tbadkCore.data.m;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import tbclient.BannerImage;
import tbclient.TalkBall.AdidasAdvert;
import tbclient.TalkBall.CardInfo;
import tbclient.TalkBall.DataRes;
import tbclient.TalkBall.TalkBallResIdl;
/* loaded from: classes3.dex */
public class c implements com.baidu.tbadk.mvc.b.c {
    private int cEP;
    private long dMj;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> dMm;
    private AdidasAdvert dMn;
    private e dMo;
    private m dMp;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.b> mThreadList;

    @Override // com.baidu.tbadk.mvc.b.j
    public void a(Message message) {
        if (message != null && (message instanceof TalkBallResIdl)) {
            a(((TalkBallResIdl) message).data);
        }
    }

    private void a(DataRes dataRes) {
        if (dataRes != null) {
            this.mThreadList = new ArrayList();
            List<CardInfo> list = dataRes.thread_list;
            if (list != null) {
                for (CardInfo cardInfo : list) {
                    com.baidu.tieba.frs.worldcup.talkball.b.b bVar = new com.baidu.tieba.frs.worldcup.talkball.b.b();
                    bVar.a(cardInfo);
                    if (!bVar.aBB() || bVar.aBA() == null || bVar.aBA().aBK() == null || !bVar.aBA().aBK().isEmpty()) {
                        this.mThreadList.add(bVar);
                    }
                }
            }
            this.dMm = new ArrayList();
            List<BannerImage> list2 = dataRes.banner_images;
            if (list2 != null) {
                for (BannerImage bannerImage : list2) {
                    if (bannerImage != null && !TextUtils.isEmpty(bannerImage.img_url)) {
                        com.baidu.tieba.frs.worldcup.talkball.b.a aVar = new com.baidu.tieba.frs.worldcup.talkball.b.a();
                        aVar.a(bannerImage);
                        this.dMm.add(aVar);
                    }
                }
            }
            this.dMn = dataRes.adidas_advert;
            this.cEP = dataRes.has_more.intValue();
            this.dMj = dataRes.last_thread_id.longValue();
            this.dMo = new e();
            this.dMo.a(dataRes.guessing_competition);
            this.dMp = new m();
            this.dMp.a(dataRes.redpacketrain);
        }
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.b> getThreadList() {
        return this.mThreadList;
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.a> aBP() {
        return this.dMm;
    }

    public int apA() {
        return this.cEP;
    }

    public long aBQ() {
        return this.dMj;
    }

    public e aBR() {
        return this.dMo;
    }

    public AdidasAdvert aBS() {
        return this.dMn;
    }

    public m aBT() {
        return this.dMp;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Js() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void u(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean y(byte[] bArr) {
        return false;
    }
}
