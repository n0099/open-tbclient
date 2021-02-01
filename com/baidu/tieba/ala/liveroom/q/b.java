package com.baidu.tieba.ala.liveroom.q;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.q.a;
import java.lang.ref.WeakReference;
/* loaded from: classes11.dex */
public class b {
    private WeakReference<a> hNf;
    private a.b hNg = new a.b() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aM(String str, int i) {
            b.this.hjZ.c(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aN(String str, int i) {
            b.this.hjZ.d(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aO(String str, int i) {
            b.this.hjZ.e(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aP(String str, int i) {
            b.this.hjZ.f(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aQ(String str, int i) {
            b.this.hjZ.b(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aR(String str, int i) {
            b.this.hjZ.c(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void we(int i) {
            b.this.hjZ.d(b.this.mUserId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void onCancel() {
        }
    };
    private e hjZ;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.hjZ = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hNf != null && this.hNf.get() != null) {
                a aVar = this.hNf.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hNf.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hNg);
            aVar2.a(personUserData, z, str3);
            this.hNf = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.hjZ.a(bVar);
    }

    public void bkp() {
        a aVar;
        if (this.hNf != null && this.hNf.get() != null && (aVar = this.hNf.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hNf != null && this.hNf.get() != null) {
            a aVar = this.hNf.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hNf.clear();
        }
    }
}
