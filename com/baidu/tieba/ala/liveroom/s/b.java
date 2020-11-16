package com.baidu.tieba.ala.liveroom.s;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.s.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private e gPm;
    private WeakReference<a> hrG;
    private a.b hrH = new a.b() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HR(String str) {
            b.this.gPm.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HS(String str) {
            b.this.gPm.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HT(String str) {
            b.this.gPm.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HU(String str) {
            b.this.gPm.t(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HV(String str) {
            b.this.gPm.aF(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HW(String str) {
            b.this.gPm.aG(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void cgr() {
            b.this.gPm.aH(b.this.mUserId, b.this.mLiveId);
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
            this.gPm = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hrG != null && this.hrG.get() != null) {
                a aVar = this.hrG.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hrG.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hrH);
            aVar2.a(personUserData, z, str3);
            this.hrG = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.gPm.a(bVar);
    }

    public void big() {
        a aVar;
        if (this.hrG != null && this.hrG.get() != null && (aVar = this.hrG.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hrG != null && this.hrG.get() != null) {
            a aVar = this.hrG.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hrG.clear();
        }
    }
}
