package com.baidu.tieba.ala.liveroom.o;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.o.a;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.live.n.b fDL;
    private WeakReference<a> gcF;
    private a.b gcG = new a.b() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CC(String str) {
            b.this.fDL.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CD(String str) {
            b.this.fDL.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CE(String str) {
            b.this.fDL.p(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CF(String str) {
            b.this.fDL.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CG(String str) {
            b.this.fDL.av(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void CH(String str) {
            b.this.fDL.aw(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void bFR() {
            b.this.fDL.ax(b.this.mUserId, b.this.mLiveId);
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
            this.fDL = new com.baidu.live.n.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.gcF != null && this.gcF.get() != null) {
                a aVar = this.gcF.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.gcF.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.gcG);
            aVar2.a(personUserData, z, str3);
            this.gcF = new WeakReference<>(aVar2);
        }
    }

    public void a(b.a aVar) {
        this.fDL.a(aVar);
    }

    public void aNc() {
        a aVar;
        if (this.gcF != null && this.gcF.get() != null && (aVar = this.gcF.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.gcF != null && this.gcF.get() != null) {
            a aVar = this.gcF.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.gcF.clear();
        }
    }
}
