package com.baidu.tieba.ala.liveroom.s;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.s.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private e gPF;
    private WeakReference<a> hrZ;
    private a.b hsa = new a.b() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Iq(String str) {
            b.this.gPF.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Ir(String str) {
            b.this.gPF.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Is(String str) {
            b.this.gPF.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void It(String str) {
            b.this.gPF.t(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Iu(String str) {
            b.this.gPF.aG(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Iv(String str) {
            b.this.gPF.aH(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void cgY() {
            b.this.gPF.aI(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void onCancel() {
        }
    };
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.gPF = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hrZ != null && this.hrZ.get() != null) {
                a aVar = this.hrZ.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hrZ.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hsa);
            aVar2.a(personUserData, z, str3);
            this.hrZ = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.gPF.a(bVar);
    }

    public void biM() {
        a aVar;
        if (this.hrZ != null && this.hrZ.get() != null && (aVar = this.hrZ.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hrZ != null && this.hrZ.get() != null) {
            a aVar = this.hrZ.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hrZ.clear();
        }
    }
}
