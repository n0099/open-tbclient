package com.baidu.tieba.ala.liveroom.o;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.o.a;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.live.n.b eLt;
    private a fkd;
    private a.b fke = new a.b() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zk(String str) {
            b.this.eLt.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zl(String str) {
            b.this.eLt.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zm(String str) {
            b.this.eLt.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zn(String str) {
            b.this.eLt.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zo(String str) {
            b.this.eLt.ac(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void zp(String str) {
            b.this.eLt.ad(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void bqp() {
            b.this.eLt.af(b.this.mUserId, b.this.mLiveId);
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
            this.eLt = new com.baidu.live.n.b(this.mPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.fkd != null && this.fkd.isShowing()) {
                this.fkd.dismiss();
            }
            a aVar = new a(this.mPageContext);
            aVar.a(this.fke);
            aVar.a(personUserData, z, str3);
            this.fkd = aVar;
        }
    }

    public void a(b.a aVar) {
        this.eLt.a(aVar);
    }

    public void azf() {
        if (this.fkd != null && this.fkd.isShowing()) {
            this.fkd.resize();
        }
    }

    public void onDestory() {
        if (this.fkd != null && this.fkd.isShowing()) {
            this.fkd.dismiss();
        }
    }
}
