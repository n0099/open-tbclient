package com.baidu.tieba.ala.liveroom.s;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.s.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private WeakReference<a> gLo;
    private a.b gLp = new a.b() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void GM(String str) {
            b.this.gjM.p(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void GN(String str) {
            b.this.gjM.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void GO(String str) {
            b.this.gjM.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void GP(String str) {
            b.this.gjM.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void GQ(String str) {
            b.this.gjM.aA(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void GR(String str) {
            b.this.gjM.aB(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void bXR() {
            b.this.gjM.aC(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void onCancel() {
        }
    };
    private com.baidu.live.personmanager.b gjM;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.gjM = new com.baidu.live.personmanager.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.gLo != null && this.gLo.get() != null) {
                a aVar = this.gLo.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.gLo.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.gLp);
            aVar2.a(personUserData, z, str3);
            this.gLo = new WeakReference<>(aVar2);
        }
    }

    public void a(b.InterfaceC0184b interfaceC0184b) {
        this.gjM.a(interfaceC0184b);
    }

    public void bbL() {
        a aVar;
        if (this.gLo != null && this.gLo.get() != null && (aVar = this.gLo.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.gLo != null && this.gLo.get() != null) {
            a aVar = this.gLo.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.gLo.clear();
        }
    }
}
