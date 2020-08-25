package com.baidu.tieba.ala.c;

import android.content.res.Configuration;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.o.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.f.c;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    private long bew;
    private boolean dMJ;
    private com.baidu.live.o.b fSL;
    private com.baidu.tieba.ala.f.c fSP;
    private com.baidu.tieba.ala.view.b fSQ;
    private long fuJ;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a fSM = new b.a() { // from class: com.baidu.tieba.ala.c.b.1
        @Override // com.baidu.live.o.b.a
        public void Mf() {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            b.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.o.b.a
        public void onFail(String str) {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fSQ.cam() != null && b.this.mUserId > 0) {
                b.this.fSL.az(String.valueOf(b.this.mUserId), b.this.fSQ.cam().bIJ());
            }
        }
    };
    private final c.a fSR = new c.a() { // from class: com.baidu.tieba.ala.c.b.3
        @Override // com.baidu.tieba.ala.f.c.a
        public void bd(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.fSP.bXU();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.fSQ.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.f.c.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> bXU = b.this.fSP.bXU();
            if (!ListUtils.isEmpty(bXU)) {
                b.this.fSQ.setData(bXU);
            }
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.bew = j;
        this.fuJ = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.dMJ = z2;
        this.fSP = new com.baidu.tieba.ala.f.c(this.mTbPageContext, this.fSR);
        this.fSP.b(this.bew, this.fuJ, this.mUserId, this.mIsHost, this.dMJ);
        this.fSQ = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.fSQ.b(this.bew, this.fuJ, this.mUserId, this.mIsHost, this.dMJ);
        this.fSP.bXT();
        this.fSL = new com.baidu.live.o.b(this.mTbPageContext);
        this.fSL.a(this.fSM);
    }

    public View getView() {
        return this.fSQ.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.fSP.onDestroy();
        this.fSL.onDestroy();
        this.fSQ.onDestroy();
    }
}
