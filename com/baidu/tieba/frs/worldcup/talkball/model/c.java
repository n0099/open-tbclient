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
/* loaded from: classes2.dex */
public class c implements com.baidu.tbadk.mvc.b.c {
    private int cEr;
    private long dGa;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> dGd;
    private AdidasAdvert dGe;
    private e dGf;
    private m dGg;
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
                    if (!bVar.aAl() || bVar.aAk() == null || bVar.aAk().aAu() == null || !bVar.aAk().aAu().isEmpty()) {
                        this.mThreadList.add(bVar);
                    }
                }
            }
            this.dGd = new ArrayList();
            List<BannerImage> list2 = dataRes.banner_images;
            if (list2 != null) {
                for (BannerImage bannerImage : list2) {
                    if (bannerImage != null && !TextUtils.isEmpty(bannerImage.img_url)) {
                        com.baidu.tieba.frs.worldcup.talkball.b.a aVar = new com.baidu.tieba.frs.worldcup.talkball.b.a();
                        aVar.a(bannerImage);
                        this.dGd.add(aVar);
                    }
                }
            }
            this.dGe = dataRes.adidas_advert;
            this.cEr = dataRes.has_more.intValue();
            this.dGa = dataRes.last_thread_id.longValue();
            this.dGf = new e();
            this.dGf.a(dataRes.guessing_competition);
            this.dGg = new m();
            this.dGg.a(dataRes.redpacketrain);
        }
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.b> getThreadList() {
        return this.mThreadList;
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.a> aAz() {
        return this.dGd;
    }

    public int apF() {
        return this.cEr;
    }

    public long aAA() {
        return this.dGa;
    }

    public e aAB() {
        return this.dGf;
    }

    public AdidasAdvert aAC() {
        return this.dGe;
    }

    public m aAD() {
        return this.dGg;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Jf() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void v(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean z(byte[] bArr) {
        return false;
    }
}
