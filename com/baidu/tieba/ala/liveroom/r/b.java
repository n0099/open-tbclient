package com.baidu.tieba.ala.liveroom.r;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.o.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.r.a;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class b {
    private WeakReference<a> gHJ;
    private a.b gHK = new a.b() { // from class: com.baidu.tieba.ala.liveroom.r.b.1
        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void Go(String str) {
            b.this.ggx.p(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void Gp(String str) {
            b.this.ggx.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void Gq(String str) {
            b.this.ggx.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void Gr(String str) {
            b.this.ggx.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void Gs(String str) {
            b.this.ggx.aA(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void Gt(String str) {
            b.this.ggx.aB(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void bWg() {
            b.this.ggx.aC(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.r.a.b
        public void onCancel() {
        }
    };
    private com.baidu.live.o.b ggx;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.ggx = new com.baidu.live.o.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.gHJ != null && this.gHJ.get() != null) {
                a aVar = this.gHJ.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.gHJ.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.gHK);
            aVar2.a(personUserData, z, str3);
            this.gHJ = new WeakReference<>(aVar2);
        }
    }

    public void a(b.InterfaceC0183b interfaceC0183b) {
        this.ggx.a(interfaceC0183b);
    }

    public void baR() {
        a aVar;
        if (this.gHJ != null && this.gHJ.get() != null && (aVar = this.gHJ.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.gHJ != null && this.gHJ.get() != null) {
            a aVar = this.gHJ.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.gHJ.clear();
        }
    }
}
