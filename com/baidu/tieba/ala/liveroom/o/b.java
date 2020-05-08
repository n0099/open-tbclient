package com.baidu.tieba.ala.liveroom.o;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.o.a;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b {
    private WeakReference<a> fOA;
    private a.b fOB = new a.b() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AU(String str) {
            b.this.fpR.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AV(String str) {
            b.this.fpR.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AW(String str) {
            b.this.fpR.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AX(String str) {
            b.this.fpR.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AY(String str) {
            b.this.fpR.ag(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AZ(String str) {
            b.this.fpR.ah(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void bzI() {
            b.this.fpR.ai(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void onCancel() {
        }
    };
    private com.baidu.live.n.b fpR;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.fpR = new com.baidu.live.n.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.fOA != null && this.fOA.get() != null) {
                a aVar = this.fOA.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.fOA.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.fOB);
            aVar2.a(personUserData, z, str3);
            this.fOA = new WeakReference<>(aVar2);
        }
    }

    public void a(b.a aVar) {
        this.fpR.a(aVar);
    }

    public void aHo() {
        a aVar;
        if (this.fOA != null && this.fOA.get() != null && (aVar = this.fOA.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.fOA != null && this.fOA.get() != null) {
            a aVar = this.fOA.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.fOA.clear();
        }
    }
}
