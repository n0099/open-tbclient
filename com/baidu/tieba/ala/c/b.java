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
    private long bey;
    private boolean dMN;
    private com.baidu.live.o.b fSP;
    private com.baidu.tieba.ala.f.c fST;
    private com.baidu.tieba.ala.view.b fSU;
    private long fuN;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a fSQ = new b.a() { // from class: com.baidu.tieba.ala.c.b.1
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
            if (b.this.fSU.can() != null && b.this.mUserId > 0) {
                b.this.fSP.az(String.valueOf(b.this.mUserId), b.this.fSU.can().bIK());
            }
        }
    };
    private final c.a fSV = new c.a() { // from class: com.baidu.tieba.ala.c.b.3
        @Override // com.baidu.tieba.ala.f.c.a
        public void bd(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.fST.bXV();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.fSU.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.f.c.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> bXV = b.this.fST.bXV();
            if (!ListUtils.isEmpty(bXV)) {
                b.this.fSU.setData(bXV);
            }
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.bey = j;
        this.fuN = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.dMN = z2;
        this.fST = new com.baidu.tieba.ala.f.c(this.mTbPageContext, this.fSV);
        this.fST.b(this.bey, this.fuN, this.mUserId, this.mIsHost, this.dMN);
        this.fSU = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.fSU.b(this.bey, this.fuN, this.mUserId, this.mIsHost, this.dMN);
        this.fST.bXU();
        this.fSP = new com.baidu.live.o.b(this.mTbPageContext);
        this.fSP.a(this.fSQ);
    }

    public View getView() {
        return this.fSU.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.fST.onDestroy();
        this.fSP.onDestroy();
        this.fSU.onDestroy();
    }
}
