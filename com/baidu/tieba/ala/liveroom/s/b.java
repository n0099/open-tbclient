package com.baidu.tieba.ala.liveroom.s;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.s.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private com.baidu.live.personmanager.b gyf;
    private WeakReference<a> hal;
    private a.b ham = new a.b() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HA(String str) {
            b.this.gyf.p(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HB(String str) {
            b.this.gyf.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HC(String str) {
            b.this.gyf.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HD(String str) {
            b.this.gyf.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HE(String str) {
            b.this.gyf.aD(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HF(String str) {
            b.this.gyf.aE(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void cbr() {
            b.this.gyf.aF(b.this.mUserId, b.this.mLiveId);
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
            this.gyf = new com.baidu.live.personmanager.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hal != null && this.hal.get() != null) {
                a aVar = this.hal.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hal.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.ham);
            aVar2.a(personUserData, z, str3);
            this.hal = new WeakReference<>(aVar2);
        }
    }

    public void a(b.InterfaceC0192b interfaceC0192b) {
        this.gyf.a(interfaceC0192b);
    }

    public void bet() {
        a aVar;
        if (this.hal != null && this.hal.get() != null && (aVar = this.hal.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hal != null && this.hal.get() != null) {
            a aVar = this.hal.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hal.clear();
        }
    }
}
