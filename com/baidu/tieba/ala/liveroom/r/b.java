package com.baidu.tieba.ala.liveroom.r;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.r.a;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class b {
    private WeakReference<a> hNn;
    private a.b hNo = new a.b() { // from class: com.baidu.tieba.ala.liveroom.r.b.1
        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aM(String str, int i) {
            b.this.hkq.c(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aN(String str, int i) {
            b.this.hkq.d(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aO(String str, int i) {
            b.this.hkq.e(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aP(String str, int i) {
            b.this.hkq.f(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aQ(String str, int i) {
            b.this.hkq.b(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aR(String str, int i) {
            b.this.hkq.c(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void xz(int i) {
            b.this.hkq.d(b.this.mUserId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void onCancel() {
        }
    };
    private e hkq;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.hkq = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hNn != null && this.hNn.get() != null) {
                a aVar = this.hNn.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hNn.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hNo);
            aVar2.a(personUserData, z, str3);
            this.hNn = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.hkq.a(bVar);
    }

    public void bnO() {
        a aVar;
        if (this.hNn != null && this.hNn.get() != null && (aVar = this.hNn.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hNn != null && this.hNn.get() != null) {
            a aVar = this.hNn.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hNn.clear();
        }
    }
}
