package com.baidu.tieba.ala.liveroom.o;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.n.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.o.a;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b {
    private WeakReference<a> fOv;
    private a.b fOw = new a.b() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AR(String str) {
            b.this.fpM.l(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AS(String str) {
            b.this.fpM.m(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AT(String str) {
            b.this.fpM.n(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AU(String str) {
            b.this.fpM.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AV(String str) {
            b.this.fpM.ag(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void AW(String str) {
            b.this.fpM.ah(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void bzK() {
            b.this.fpM.ai(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.o.a.b
        public void onCancel() {
        }
    };
    private com.baidu.live.n.b fpM;
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.fpM = new com.baidu.live.n.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.fOv != null && this.fOv.get() != null) {
                a aVar = this.fOv.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.fOv.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.fOw);
            aVar2.a(personUserData, z, str3);
            this.fOv = new WeakReference<>(aVar2);
        }
    }

    public void a(b.a aVar) {
        this.fpM.a(aVar);
    }

    public void aHq() {
        a aVar;
        if (this.fOv != null && this.fOv.get() != null && (aVar = this.fOv.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.fOv != null && this.fOv.get() != null) {
            a aVar = this.fOv.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.fOv.clear();
        }
    }
}
