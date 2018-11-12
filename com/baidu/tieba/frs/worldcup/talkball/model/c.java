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
    private int cUc;
    private long ecL;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> ecO;
    private AdidasAdvert ecP;
    private e ecQ;
    private m ecR;
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
                    if (!bVar.aGB() || bVar.aGA() == null || bVar.aGA().aGK() == null || !bVar.aGA().aGK().isEmpty()) {
                        this.mThreadList.add(bVar);
                    }
                }
            }
            this.ecO = new ArrayList();
            List<BannerImage> list2 = dataRes.banner_images;
            if (list2 != null) {
                for (BannerImage bannerImage : list2) {
                    if (bannerImage != null && !TextUtils.isEmpty(bannerImage.img_url)) {
                        com.baidu.tieba.frs.worldcup.talkball.b.a aVar = new com.baidu.tieba.frs.worldcup.talkball.b.a();
                        aVar.a(bannerImage);
                        this.ecO.add(aVar);
                    }
                }
            }
            this.ecP = dataRes.adidas_advert;
            this.cUc = dataRes.has_more.intValue();
            this.ecL = dataRes.last_thread_id.longValue();
            this.ecQ = new e();
            this.ecQ.a(dataRes.guessing_competition);
            this.ecR = new m();
            this.ecR.a(dataRes.redpacketrain);
        }
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.b> getThreadList() {
        return this.mThreadList;
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.a> aGP() {
        return this.ecO;
    }

    public int auj() {
        return this.cUc;
    }

    public long aGQ() {
        return this.ecL;
    }

    public e aGR() {
        return this.ecQ;
    }

    public AdidasAdvert aGS() {
        return this.ecP;
    }

    public m aGT() {
        return this.ecR;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] MT() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void H(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean F(byte[] bArr) {
        return false;
    }
}
