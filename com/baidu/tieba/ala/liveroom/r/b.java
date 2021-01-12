package com.baidu.tieba.ala.liveroom.r;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.r.a;
import java.lang.ref.WeakReference;
/* loaded from: classes10.dex */
public class b {
    private WeakReference<a> hIH;
    private a.b hII = new a.b() { // from class: com.baidu.tieba.ala.liveroom.r.b.1
        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aM(String str, int i) {
            b.this.hfJ.c(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aN(String str, int i) {
            b.this.hfJ.d(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aO(String str, int i) {
            b.this.hfJ.e(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aP(String str, int i) {
            b.this.hfJ.f(str, b.this.mGroupId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aQ(String str, int i) {
            b.this.hfJ.b(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void aR(String str, int i) {
            b.this.hfJ.c(str, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void vT(int i) {
            b.this.hfJ.d(b.this.mUserId, b.this.mLiveId, i);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void onCancel() {
        }
    };
    private e hfJ;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.hfJ = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hIH != null && this.hIH.get() != null) {
                a aVar = this.hIH.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hIH.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hII);
            aVar2.a(personUserData, z, str3);
            this.hIH = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.hfJ.a(bVar);
    }

    public void bjV() {
        a aVar;
        if (this.hIH != null && this.hIH.get() != null && (aVar = this.hIH.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hIH != null && this.hIH.get() != null) {
            a aVar = this.hIH.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hIH.clear();
        }
    }
}
