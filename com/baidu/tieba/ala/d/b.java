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
/* loaded from: classes4.dex */
public class b {
    private boolean bGj;
    private long bnV;
    private long fYr;
    private com.baidu.live.personmanager.e gyi;
    private com.baidu.tieba.ala.g.d gym;
    private com.baidu.tieba.ala.view.b gyn;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gyj = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void OL() {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_success);
            b.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.e.a
        public void onFail(String str) {
            BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.b.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.gyn.clv() != null && b.this.mUserId > 0) {
                b.this.gyi.aF(String.valueOf(b.this.mUserId), b.this.gyn.clv().Ut());
            }
        }
    };
    private final d.a gyo = new d.a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void af(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.gym.Uy();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.gyn.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> Uy = b.this.gym.Uy();
            if (!ListUtils.isEmpty(Uy)) {
                b.this.gyn.setData(Uy);
            }
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.bnV = j;
        this.fYr = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bGj = z2;
        this.gym = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gyo);
        this.gym.b(this.bnV, this.fYr, this.mUserId, this.mIsHost, this.bGj);
        this.gyn = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gyn.b(this.bnV, this.fYr, this.mUserId, this.mIsHost, this.bGj);
        this.gym.Ux();
        this.gyi = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gyi.a(this.gyj);
    }

    public View getView() {
        return this.gyn.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gym.onDestroy();
        this.gyi.onDestroy();
        this.gyn.onDestroy();
    }
}
