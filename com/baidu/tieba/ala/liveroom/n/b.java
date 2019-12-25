package com.baidu.tieba.ala.liveroom.n;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.k.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.n.a;
/* loaded from: classes2.dex */
public class b {
    private com.baidu.live.k.b eFF;
    private a fcV;
    private a.b fcW = new a.b() { // from class: com.baidu.tieba.ala.liveroom.n.b.1
        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void yI(String str) {
            b.this.eFF.k(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void yJ(String str) {
            b.this.eFF.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void yK(String str) {
            b.this.eFF.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void yL(String str) {
            b.this.eFF.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void yM(String str) {
            b.this.eFF.W(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void yN(String str) {
            b.this.eFF.X(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.n.a.b
        public void bnu() {
            b.this.eFF.Y(b.this.mUserId, b.this.mLiveId);
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
            this.eFF = new com.baidu.live.k.b(this.mPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.fcV != null && this.fcV.isShowing()) {
                this.fcV.dismiss();
            }
            a aVar = new a(this.mPageContext);
            aVar.a(this.fcW);
            aVar.a(personUserData, z, str3);
            this.fcV = aVar;
        }
    }

    public void a(b.a aVar) {
        this.eFF.a(aVar);
    }

    public void awu() {
        if (this.fcV != null && this.fcV.isShowing()) {
            this.fcV.resize();
        }
    }

    public void onDestory() {
        if (this.fcV != null && this.fcV.isShowing()) {
            this.fcV.dismiss();
        }
    }
}
