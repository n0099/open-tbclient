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
    private int cCk;
    private long dJt;
    private List<com.baidu.tieba.frs.worldcup.talkball.b.a> dJw;
    private AdidasAdvert dJx;
    private e dJy;
    private m dJz;
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
                    if (!bVar.aAS() || bVar.aAR() == null || bVar.aAR().aBb() == null || !bVar.aAR().aBb().isEmpty()) {
                        this.mThreadList.add(bVar);
                    }
                }
            }
            this.dJw = new ArrayList();
            List<BannerImage> list2 = dataRes.banner_images;
            if (list2 != null) {
                for (BannerImage bannerImage : list2) {
                    if (bannerImage != null && !TextUtils.isEmpty(bannerImage.img_url)) {
                        com.baidu.tieba.frs.worldcup.talkball.b.a aVar = new com.baidu.tieba.frs.worldcup.talkball.b.a();
                        aVar.a(bannerImage);
                        this.dJw.add(aVar);
                    }
                }
            }
            this.dJx = dataRes.adidas_advert;
            this.cCk = dataRes.has_more.intValue();
            this.dJt = dataRes.last_thread_id.longValue();
            this.dJy = new e();
            this.dJy.a(dataRes.guessing_competition);
            this.dJz = new m();
            this.dJz.a(dataRes.redpacketrain);
        }
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.b> getThreadList() {
        return this.mThreadList;
    }

    public List<com.baidu.tieba.frs.worldcup.talkball.b.a> aBg() {
        return this.dJw;
    }

    public int aoZ() {
        return this.cCk;
    }

    public long aBh() {
        return this.dJt;
    }

    public e aBi() {
        return this.dJy;
    }

    public AdidasAdvert aBj() {
        return this.dJx;
    }

    public m aBk() {
        return this.dJz;
    }

    @Override // com.baidu.tbadk.mvc.b.d
    public String getCacheKey() {
        return null;
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public byte[] Jx() {
        return new byte[0];
    }

    @Override // com.baidu.tbadk.mvc.b.j
    public void v(JSONObject jSONObject) {
    }

    @Override // com.baidu.tbadk.mvc.b.b
    public boolean A(byte[] bArr) {
        return false;
    }
}
