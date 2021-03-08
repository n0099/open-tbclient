package com.baidu.tieba.ala.liveroom.q;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.q.a;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class b {
    private WeakReference<a> hPc;
    private a.b hPd = new a.b() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aN(String str, int i) {
            b.this.hlW.c(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aO(String str, int i) {
            b.this.hlW.d(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aP(String str, int i) {
            b.this.hlW.e(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aQ(String str, int i) {
            b.this.hlW.f(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aR(String str, int i) {
            b.this.hlW.b(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void aS(String str, int i) {
            b.this.hlW.c(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void wg(int i) {
            b.this.hlW.d(b.this.mUserId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.q.a.b
        public void onCancel() {
        }
    };
    private e hlW;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.hlW = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hPc != null && this.hPc.get() != null) {
                a aVar = this.hPc.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hPc.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hPd);
            aVar2.a(personUserData, z, str3);
            this.hPc = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.hlW.a(bVar);
    }

    public void bkr() {
        a aVar;
        if (this.hPc != null && this.hPc.get() != null && (aVar = this.hPc.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hPc != null && this.hPc.get() != null) {
            a aVar = this.hPc.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hPc.clear();
        }
    }
}
