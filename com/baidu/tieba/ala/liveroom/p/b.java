package com.baidu.tieba.ala.liveroom.p;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.o.b;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.p.a;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class b {
    private com.baidu.live.o.b fPf;
    private WeakReference<a> gpK;
    private a.b gpL = new a.b() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
        @Override // com.baidu.tieba.ala.liveroom.p.a.b
        public void Dd(String str) {
            b.this.fPf.o(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.p.a.b
        public void De(String str) {
            b.this.fPf.p(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.p.a.b
        public void Df(String str) {
            b.this.fPf.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.p.a.b
        public void Dg(String str) {
            b.this.fPf.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.p.a.b
        public void Dh(String str) {
            b.this.fPf.aw(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.p.a.b
        public void Di(String str) {
            b.this.fPf.ax(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.p.a.b
        public void bIZ() {
            b.this.fPf.ay(b.this.mUserId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.p.a.b
        public void onCancel() {
        }
    };
    private String mGroupId;
    private String mLiveId;
    private String mUserId;

    public void a(TbPageContext tbPageContext, String str, String str2, String str3, boolean z, Object obj) {
        if (obj instanceof PersonUserData) {
            this.fPf = new com.baidu.live.o.b(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.gpK != null && this.gpK.get() != null) {
                a aVar = this.gpK.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.gpK.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.gpL);
            aVar2.a(personUserData, z, str3);
            this.gpK = new WeakReference<>(aVar2);
        }
    }

    public void a(b.a aVar) {
        this.fPf.a(aVar);
    }

    public void aOF() {
        a aVar;
        if (this.gpK != null && this.gpK.get() != null && (aVar = this.gpK.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.gpK != null && this.gpK.get() != null) {
            a aVar = this.gpK.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.gpK.clear();
        }
    }
}
