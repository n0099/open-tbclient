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
    private int daL;
    private long ejo;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> ejr;
    private AdidasAdvert ejs;
    private e ejt;
    private m eju;
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
                    if (!bVar.aIn() || bVar.aIm() == null || bVar.aIm().aIw() == null || !bVar.aIm().aIw().isEmpty()) {
                        this.mThreadList.add(bVar);
                    }
                }
            }
            this.ejr = new ArrayList();
            List<BannerImage> list2 = dataRes.banner_images;
            if (list2 != null) {
                for (BannerImage bannerImage : list2) {
                    if (bannerImage != null && !TextUtils.isEmpty(bannerImage.img_url)) {
                        com.baidu.tieba.frs.worldcup.talkball.b.a aVar = new com.baidu.tieba.frs.worldcup.talkball.b.a();
                        aVar.a(bannerImage);
                        this.ejr.add(aVar);
                    }
                }
            }
            this.ejs = dataRes.adidas_advert;
            this.daL = dataRes.has_more.intValue();
            this.ejo = dataRes.last_thread_id.longValue();
            this.ejt = new e();
            this.ejt.a(dataRes.guessing_competition);
            this.eju = new m();
            this.eju.a(dataRes.redpacketrain);
        }
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.b> getThreadList() {
        return this.mThreadList;
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.a> aIB() {
        return this.ejr;
    }

    public int avU() {
        return this.daL;
    }

    public long aIC() {
        return this.ejo;
    }

    public e aID() {
        return this.ejt;
    }

    public AdidasAdvert aIE() {
        return this.ejs;
    }

    public m aIF() {
        return this.eju;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] NX() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void I(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean F(byte[] bArr) {
        return false;
    }
}
