package com.baidu.tieba.ala.liveroom.s;

import com.baidu.live.data.PersonUserData;
import com.baidu.live.personmanager.e;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.liveroom.s.a;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class b {
    private e gJT;
    private WeakReference<a> hmb;
    private a.b hmc = new a.b() { // from class: com.baidu.tieba.ala.liveroom.s.b.1
        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void HZ(String str) {
            b.this.gJT.q(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Ia(String str) {
            b.this.gJT.r(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Ib(String str) {
            b.this.gJT.s(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Ic(String str) {
            b.this.gJT.t(str, b.this.mGroupId, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Id(String str) {
            b.this.gJT.aF(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void Ie(String str) {
            b.this.gJT.aG(str, b.this.mLiveId);
        }

        @Override // com.baidu.tieba.ala.liveroom.s.a.b
        public void cev() {
            b.this.gJT.aH(b.this.mUserId, b.this.mLiveId);
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
            this.gJT = new e(tbPageContext);
            this.mGroupId = str;
            this.mLiveId = str2;
            this.mUserId = str3;
            PersonUserData personUserData = (PersonUserData) obj;
            if (this.hmb != null && this.hmb.get() != null) {
                a aVar = this.hmb.get();
                if (aVar != null && aVar.isShowing()) {
                    aVar.dismiss();
                }
                this.hmb.clear();
            }
            a aVar2 = new a(tbPageContext);
            aVar2.a(this.hmc);
            aVar2.a(personUserData, z, str3);
            this.hmb = new WeakReference<>(aVar2);
        }
    }

    public void a(e.b bVar) {
        this.gJT.a(bVar);
    }

    public void bgm() {
        a aVar;
        if (this.hmb != null && this.hmb.get() != null && (aVar = this.hmb.get()) != null && aVar.isShowing()) {
            aVar.resize();
        }
    }

    public void onDestory() {
        if (this.hmb != null && this.hmb.get() != null) {
            a aVar = this.hmb.get();
            if (aVar != null && aVar.isShowing()) {
                aVar.dismiss();
            }
            this.hmb.clear();
        }
    }
}
