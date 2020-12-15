package com.baidu.tieba.ala.liveroom.r;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.r.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private e gYB;
    private WeakReference<a> hBm;
    private a.b hBn = new a.b() { // from class: com.baidu.tieba.ala.liveroom.r.b.1
        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void IG(String str) {
            b.this.gYB.t(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void IH(String str) {
            b.this.gYB.u(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void II(String str) {
            b.this.gYB.x(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void IJ(String str) {
            b.this.gYB.y(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void IK(String str) {
            b.this.gYB.aJ(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void IL(String str) {
            b.this.gYB.aK(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void ckm() {
            b.this.gYB.aL(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void onCancel() {
        }
    };
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.gYB = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hBm != null && this.hBm.get() != null) {
                a aVar = this.hBm.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hBm.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hBn);
            aVar2.a(personUserData, z, str3);
            this.hBm = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.gYB.a(bVar);
    }

    public void blq() {
        a aVar;
        if (this.hBm != null && this.hBm.get() != null && (aVar = this.hBm.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hBm != null && this.hBm.get() != null) {
            a aVar = this.hBm.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hBm.clear();
        }
    }
}
