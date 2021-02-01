package com.baidu.tieba.ala.d;

import android.content.res.Configuration;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.g.d;
import java.util.List;
/* loaded from: classes11.dex */
public class c {
    private boolean bNs;
    private long buN;
    private com.baidu.tieba.ala.g.d gQD;
    private com.baidu.tieba.ala.view.b gQE;
    private com.baidu.live.personmanager.e gQz;
    private long goL;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gQA = new e.a() { // from class: com.baidu.tieba.ala.d.c.1
        @Override // com.baidu.live.personmanager.e.a
        public void Pg() {
            BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_success);
            c.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.e.a
        public void onFail(String str) {
            BdUtilHelper.showToast(c.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.c.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (c.this.gQE.cpl() != null && c.this.mUserId > 0) {
                c.this.gQz.aF(String.valueOf(c.this.mUserId), c.this.gQE.cpl().Vb());
            }
        }
    };
    private final d.a gQF = new d.a() { // from class: com.baidu.tieba.ala.d.c.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void aj(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = c.this.gQD.Vg();
            }
            if (!ListUtils.isEmpty(list)) {
                c.this.gQE.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> Vg = c.this.gQD.Vg();
            if (!ListUtils.isEmpty(Vg)) {
                c.this.gQE.setData(Vg);
            }
        }
    };

    public c(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.buN = j;
        this.goL = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bNs = z2;
        this.gQD = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gQF);
        this.gQD.b(this.buN, this.goL, this.mUserId, this.mIsHost, this.bNs);
        this.gQE = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gQE.b(this.buN, this.goL, this.mUserId, this.mIsHost, this.bNs);
        this.gQD.Vf();
        this.gQz = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gQz.a(this.gQA);
    }

    public View getView() {
        return this.gQE.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gQD.onDestroy();
        this.gQz.onDestroy();
        this.gQE.onDestroy();
    }
}
