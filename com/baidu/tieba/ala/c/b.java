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
/* loaded from: classes4.dex */
public class b {
    private long aZc;
    private boolean dDA;
    private com.baidu.live.o.b fHu;
    private com.baidu.tieba.ala.f.c fHy;
    private com.baidu.tieba.ala.view.b fHz;
    private long fjn;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a fHv = new b.a() { // from class: com.baidu.tieba.ala.c.b.1
        @Override // com.baidu.live.o.b.a
        public void Gr() {
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
            if (b.this.fHz.bQb() != null && b.this.mUserId > 0) {
                b.this.fHu.av(String.valueOf(b.this.mUserId), b.this.fHz.bQb().bzG());
            }
        }
    };
    private final c.a fHA = new c.a() { // from class: com.baidu.tieba.ala.c.b.3
        @Override // com.baidu.tieba.ala.f.c.a
        public void bd(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.fHy.bNU();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.fHz.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.f.c.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> bNU = b.this.fHy.bNU();
            if (!ListUtils.isEmpty(bNU)) {
                b.this.fHz.setData(bNU);
            }
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.aZc = j;
        this.fjn = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.dDA = z2;
        this.fHy = new com.baidu.tieba.ala.f.c(this.mTbPageContext, this.fHA);
        this.fHy.b(this.aZc, this.fjn, this.mUserId, this.mIsHost, this.dDA);
        this.fHz = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.fHz.b(this.aZc, this.fjn, this.mUserId, this.mIsHost, this.dDA);
        this.fHy.bNT();
        this.fHu = new com.baidu.live.o.b(this.mTbPageContext);
        this.fHu.a(this.fHv);
    }

    public View getView() {
        return this.fHz.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.fHy.onDestroy();
        this.fHu.onDestroy();
        this.fHz.onDestroy();
    }
}
