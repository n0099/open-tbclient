package com.baidu.tieba.ala.liveroom.o;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.o.a;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.live.n.b fDW;
    private WeakReference<a> gcQ;
    private a.b gcR = new a.b() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CC(String str) {
            b.this.fDW.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CD(String str) {
            b.this.fDW.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CE(String str) {
            b.this.fDW.p(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CF(String str) {
            b.this.fDW.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CG(String str) {
            b.this.fDW.av(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CH(String str) {
            b.this.fDW.aw(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void bFT() {
            b.this.fDW.ax(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void onCancel() {
        }
    };
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.fDW = new com.baidu.live.n.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.gcQ != null && this.gcQ.get() != null) {
                a aVar = this.gcQ.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.gcQ.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.gcR);
            aVar2.a(personUserData, z, str3);
            this.gcQ = new WeakReference<>(aVar2);
        }
    }

    public void a(b.a aVar) {
        this.fDW.a(aVar);
    }

    public void aNc() {
        a aVar;
        if (this.gcQ != null && this.gcQ.get() != null && (aVar = this.gcQ.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.gcQ != null && this.gcQ.get() != null) {
            a aVar = this.gcQ.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.gcQ.clear();
        }
    }
}
