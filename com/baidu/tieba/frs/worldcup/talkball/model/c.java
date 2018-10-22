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
    private int cSW;
    private long ebr;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> ebu;
    private AdidasAdvert ebv;
    private e ebw;
    private m ebx;
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
                    if (!bVar.aHd() || bVar.aHc() == null || bVar.aHc().aHm() == null || !bVar.aHc().aHm().isEmpty()) {
                        this.mThreadList.add(bVar);
                    }
                }
            }
            this.ebu = new ArrayList();
            List<BannerImage> list2 = dataRes.banner_images;
            if (list2 != null) {
                for (BannerImage bannerImage : list2) {
                    if (bannerImage != null && !TextUtils.isEmpty(bannerImage.img_url)) {
                        com.baidu.tieba.frs.worldcup.talkball.b.a aVar = new com.baidu.tieba.frs.worldcup.talkball.b.a();
                        aVar.a(bannerImage);
                        this.ebu.add(aVar);
                    }
                }
            }
            this.ebv = dataRes.adidas_advert;
            this.cSW = dataRes.has_more.intValue();
            this.ebr = dataRes.last_thread_id.longValue();
            this.ebw = new e();
            this.ebw.a(dataRes.guessing_competition);
            this.ebx = new m();
            this.ebx.a(dataRes.redpacketrain);
        }
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.b> getThreadList() {
        return this.mThreadList;
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.a> aHr() {
        return this.ebu;
    }

    public int auL() {
        return this.cSW;
    }

    public long aHs() {
        return this.ebr;
    }

    public e aHt() {
        return this.ebw;
    }

    public AdidasAdvert aHu() {
        return this.ebv;
    }

    public m aHv() {
        return this.ebx;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MK() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void H(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean G(byte[] bArr) {
        return false;
    }
}
