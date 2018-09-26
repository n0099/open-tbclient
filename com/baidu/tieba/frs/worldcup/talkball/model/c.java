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
    private int cKD;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> dTA;
    private AdidasAdvert dTB;
    private e dTC;
    private m dTD;
    private long dTx;
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
                    if (!bVar.aDL() || bVar.aDK() == null || bVar.aDK().aDU() == null || !bVar.aDK().aDU().isEmpty()) {
                        this.mThreadList.add(bVar);
                    }
                }
            }
            this.dTA = new ArrayList();
            List<BannerImage> list2 = dataRes.banner_images;
            if (list2 != null) {
                for (BannerImage bannerImage : list2) {
                    if (bannerImage != null && !TextUtils.isEmpty(bannerImage.img_url)) {
                        com.baidu.tieba.frs.worldcup.talkball.b.a aVar = new com.baidu.tieba.frs.worldcup.talkball.b.a();
                        aVar.a(bannerImage);
                        this.dTA.add(aVar);
                    }
                }
            }
            this.dTB = dataRes.adidas_advert;
            this.cKD = dataRes.has_more.intValue();
            this.dTx = dataRes.last_thread_id.longValue();
            this.dTC = new e();
            this.dTC.a(dataRes.guessing_competition);
            this.dTD = new m();
            this.dTD.a(dataRes.redpacketrain);
        }
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.b> getThreadList() {
        return this.mThreadList;
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.a> aDZ() {
        return this.dTA;
    }

    public int aro() {
        return this.cKD;
    }

    public long aEa() {
        return this.dTx;
    }

    public e aEb() {
        return this.dTC;
    }

    public AdidasAdvert aEc() {
        return this.dTB;
    }

    public m aEd() {
        return this.dTD;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] KM() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void E(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean G(byte[] bArr) {
        return false;
    }
}
