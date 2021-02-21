package com.baidu.tieba.ala.liveroom.q;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.q.a;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class b {
    private WeakReference<a> hNt;
    private a.b hNu = new a.b() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aM(String str, int i) {
            b.this.hkn.c(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aN(String str, int i) {
            b.this.hkn.d(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aO(String str, int i) {
            b.this.hkn.e(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aP(String str, int i) {
            b.this.hkn.f(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aQ(String str, int i) {
            b.this.hkn.b(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aR(String str, int i) {
            b.this.hkn.c(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void we(int i) {
            b.this.hkn.d(b.this.mUserId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void onCancel() {
        }
    };
    private e hkn;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.hkn = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hNt != null && this.hNt.get() != null) {
                a aVar = this.hNt.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hNt.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hNu);
            aVar2.a(personUserData, z, str3);
            this.hNt = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.hkn.a(bVar);
    }

    public void bkp() {
        a aVar;
        if (this.hNt != null && this.hNt.get() != null && (aVar = this.hNt.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hNt != null && this.hNt.get() != null) {
            a aVar = this.hNt.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hNt.clear();
        }
    }
}
