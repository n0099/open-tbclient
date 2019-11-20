package com.baidu.tieba.ala.liveroom.n;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.g.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.n.a;
/* loaded from: classes6.dex */
public class b {
    private com.baidu.live.g.b dQd;
    private a emD;
    private a.b emE = new a.b() { // from class: com.baidu.tieba.ala.liveroom.n.b.1
        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tU(String str) {
            b.this.dQd.j(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tV(String str) {
            b.this.dQd.k(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tW(String str) {
            b.this.dQd.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tX(String str) {
            b.this.dQd.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tY(String str) {
            b.this.dQd.O(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void tZ(String str) {
            b.this.dQd.P(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void aVC() {
            b.this.dQd.Q(b.this.mUserId, b.this.mLiveId);
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
            this.dQd = new com.baidu.live.g.b(this.mPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.emD != null && this.emD.isShowing()) {
                this.emD.dismiss();
            }
            a aVar = new a(this.mPageContext);
            aVar.a(this.emE);
            aVar.a(personUserData, z, str3);
            this.emD = aVar;
        }
    }

    public void a(b.a aVar) {
        this.dQd.a(aVar);
    }

    public void afC() {
        if (this.emD != null && this.emD.isShowing()) {
            this.emD.resize();
        }
    }

    public void onDestory() {
        if (this.emD != null && this.emD.isShowing()) {
            this.emD.dismiss();
        }
    }
}
