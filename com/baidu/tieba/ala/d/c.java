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
    private com.baidu.live.personmanager.e gQN;
    private com.baidu.tieba.ala.g.d gQR;
    private com.baidu.tieba.ala.view.b gQS;
    private long goZ;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gQO = new e.a() { // from class: com.baidu.tieba.ala.d.c.1
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
            if (c.this.gQS.cps() != null && c.this.mUserId > 0) {
                c.this.gQN.aF(String.valueOf(c.this.mUserId), c.this.gQS.cps().Vb());
            }
        }
    };
    private final d.a gQT = new d.a() { // from class: com.baidu.tieba.ala.d.c.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void aj(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = c.this.gQR.Vg();
            }
            if (!ListUtils.isEmpty(list)) {
                c.this.gQS.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> Vg = c.this.gQR.Vg();
            if (!ListUtils.isEmpty(Vg)) {
                c.this.gQS.setData(Vg);
            }
        }
    };

    public c(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.buN = j;
        this.goZ = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bNs = z2;
        this.gQR = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gQT);
        this.gQR.b(this.buN, this.goZ, this.mUserId, this.mIsHost, this.bNs);
        this.gQS = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gQS.b(this.buN, this.goZ, this.mUserId, this.mIsHost, this.bNs);
        this.gQR.Vf();
        this.gQN = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gQN.a(this.gQO);
    }

    public View getView() {
        return this.gQS.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gQR.onDestroy();
        this.gQN.onDestroy();
        this.gQS.onDestroy();
    }
}
