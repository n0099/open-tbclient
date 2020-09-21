package com.baidu.tieba.ala.d;

import android.content.res.Configuration;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.g.d;
import java.util.List;
/* loaded from: classes4.dex */
public class b {
    private long bhr;
    private boolean dOQ;
    private com.baidu.live.personmanager.b fVZ;
    private com.baidu.tieba.ala.g.d fWd;
    private com.baidu.tieba.ala.view.b fWe;
    private long fxY;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a fWa = new b.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.b.a
        public void MI() {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            b.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.b.a
        public void onFail(String str) {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.fWe.ccx() != null && b.this.mUserId > 0) {
                b.this.fVZ.az(String.valueOf(b.this.mUserId), b.this.fWe.ccx().bJT());
            }
        }
    };
    private final d.a fWf = new d.a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void bh(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.fWd.bZI();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.fWe.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> bZI = b.this.fWd.bZI();
            if (!ListUtils.isEmpty(bZI)) {
                b.this.fWe.setData(bZI);
            }
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.bhr = j;
        this.fxY = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.dOQ = z2;
        this.fWd = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.fWf);
        this.fWd.b(this.bhr, this.fxY, this.mUserId, this.mIsHost, this.dOQ);
        this.fWe = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.fWe.b(this.bhr, this.fxY, this.mUserId, this.mIsHost, this.dOQ);
        this.fWd.bZH();
        this.fVZ = new com.baidu.live.personmanager.b(this.mTbPageContext);
        this.fVZ.a(this.fWa);
    }

    public View getView() {
        return this.fWe.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.fWd.onDestroy();
        this.fVZ.onDestroy();
        this.fWe.onDestroy();
    }
}
