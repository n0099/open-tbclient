package com.baidu.tieba.ala.liveroom.q;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.l.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.q.a;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.live.l.b eGP;
    private a fgb;
    private a.b fgc = new a.b() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void yR(String str) {
            b.this.eGP.k(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void yS(String str) {
            b.this.eGP.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void yT(String str) {
            b.this.eGP.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void yU(String str) {
            b.this.eGP.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void yV(String str) {
            b.this.eGP.V(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void yW(String str) {
            b.this.eGP.W(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void bou() {
            b.this.eGP.X(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
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
            this.eGP = new com.baidu.live.l.b(this.mPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.fgb != null && this.fgb.isShowing()) {
                this.fgb.dismiss();
            }
            a aVar = new a(this.mPageContext);
            aVar.a(this.fgc);
            aVar.a(personUserData, z, str3);
            this.fgb = aVar;
        }
    }

    public void a(b.a aVar) {
        this.eGP.a(aVar);
    }

    public void awN() {
        if (this.fgb != null && this.fgb.isShowing()) {
            this.fgb.resize();
        }
    }

    public void onDestory() {
        if (this.fgb != null && this.fgb.isShowing()) {
            this.fgb.dismiss();
        }
    }
}
