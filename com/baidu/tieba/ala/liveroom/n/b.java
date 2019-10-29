package com.baidu.tieba.ala.liveroom.n;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.g.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.n.a;
/* loaded from: classes6.dex */
public class b {
    private com.baidu.live.g.b dQU;
    private a enw;
    private a.b enx = new a.b() { // from class: com.baidu.tieba.ala.liveroom.n.b.1
        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tU(String str) {
            b.this.dQU.j(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tV(String str) {
            b.this.dQU.k(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tW(String str) {
            b.this.dQU.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tX(String str) {
            b.this.dQU.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tY(String str) {
            b.this.dQU.O(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tZ(String str) {
            b.this.dQU.P(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void aVE() {
            b.this.dQU.Q(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
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
            this.dQU = new com.baidu.live.g.b(this.mPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.enw != null && this.enw.isShowing()) {
                this.enw.dismiss();
            }
            a aVar = new a(this.mPageContext);
            aVar.a(this.enx);
            aVar.a(personUserData, z, str3);
            this.enw = aVar;
        }
    }

    public void a(b.a aVar) {
        this.dQU.a(aVar);
    }

    public void afE() {
        if (this.enw != null && this.enw.isShowing()) {
            this.enw.resize();
        }
    }

    public void onDestory() {
        if (this.enw != null && this.enw.isShowing()) {
            this.enw.dismiss();
        }
    }
}
