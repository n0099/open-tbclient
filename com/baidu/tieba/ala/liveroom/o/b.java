package com.baidu.tieba.ala.liveroom.o;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.o.a;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.live.n.b eKK;
    private a fjr;
    private a.b fjs = new a.b() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zj(String str) {
            b.this.eKK.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zk(String str) {
            b.this.eKK.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zl(String str) {
            b.this.eKK.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zm(String str) {
            b.this.eKK.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zn(String str) {
            b.this.eKK.ad(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zo(String str) {
            b.this.eKK.af(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void bqj() {
            b.this.eKK.ag(b.this.mUserId, b.this.mLiveId);
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
            this.eKK = new com.baidu.live.n.b(this.mPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.fjr != null && this.fjr.isShowing()) {
                this.fjr.dismiss();
            }
            a aVar = new a(this.mPageContext);
            aVar.a(this.fjs);
            aVar.a(personUserData, z, str3);
            this.fjr = aVar;
        }
    }

    public void a(b.a aVar) {
        this.eKK.a(aVar);
    }

    public void azc() {
        if (this.fjr != null && this.fjr.isShowing()) {
            this.fjr.resize();
        }
    }

    public void onDestory() {
        if (this.fjr != null && this.fjr.isShowing()) {
            this.fjr.dismiss();
        }
    }
}
