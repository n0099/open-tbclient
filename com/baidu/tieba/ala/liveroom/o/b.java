package com.baidu.tieba.ala.liveroom.o;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.o.a;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.live.n.b eKJ;
    private a fjq;
    private a.b fjr = new a.b() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zj(String str) {
            b.this.eKJ.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zk(String str) {
            b.this.eKJ.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zl(String str) {
            b.this.eKJ.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zm(String str) {
            b.this.eKJ.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zn(String str) {
            b.this.eKJ.ad(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zo(String str) {
            b.this.eKJ.af(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void bqh() {
            b.this.eKJ.ag(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void onCancel() {
        }
    };
    private String mGroupId;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String mUserId;

    public b(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
    }

    public void a(String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.eKJ = new com.baidu.live.n.b(this.mPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.fjq != null && this.fjq.isShowing()) {
                this.fjq.dismiss();
            }
            a aVar = new a(this.mPageContext);
            aVar.a(this.fjr);
            aVar.a(personUserData, z, str3);
            this.fjq = aVar;
        }
    }

    public void a(b.a aVar) {
        this.eKJ.a(aVar);
    }

    public void aza() {
        if (this.fjq != null && this.fjq.isShowing()) {
            this.fjq.resize();
        }
    }

    public void onDestory() {
        if (this.fjq != null && this.fjq.isShowing()) {
            this.fjq.dismiss();
        }
    }
}
