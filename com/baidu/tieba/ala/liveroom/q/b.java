package com.baidu.tieba.ala.liveroom.q;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.o.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.q.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private com.baidu.live.o.b fUy;
    private WeakReference<a> guL;
    private a.b guM = new a.b() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void DP(String str) {
            b.this.fUy.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void DQ(String str) {
            b.this.fUy.p(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void DR(String str) {
            b.this.fUy.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void DS(String str) {
            b.this.fUy.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void DT(String str) {
            b.this.fUy.aw(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void DU(String str) {
            b.this.fUy.ax(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void bMe() {
            b.this.fUy.ay(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void onCancel() {
        }
    };
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.fUy = new com.baidu.live.o.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.guL != null && this.guL.get() != null) {
                a aVar = this.guL.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.guL.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.guM);
            aVar2.a(personUserData, z, str3);
            this.guL = new WeakReference<>(aVar2);
        }
    }

    public void a(b.InterfaceC0175b interfaceC0175b) {
        this.fUy.a(interfaceC0175b);
    }

    public void aSA() {
        a aVar;
        if (this.guL != null && this.guL.get() != null && (aVar = this.guL.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.guL != null && this.guL.get() != null) {
            a aVar = this.guL.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.guL.clear();
        }
    }
}
