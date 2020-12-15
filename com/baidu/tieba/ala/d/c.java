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
public class c {
    private boolean bJG;
    private long brr;
    private com.baidu.live.personmanager.e gGN;
    private com.baidu.tieba.ala.g.d gGR;
    private com.baidu.tieba.ala.view.b gGS;
    private long ggl;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gGO = new e.a() { // from class: com.baidu.tieba.ala.d.c.1
        @Override // com.baidu.live.personmanager.e.a
        public void Qv() {
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
            if (c.this.gGS.cpe() != null && c.this.mUserId > 0) {
                c.this.gGN.aI(String.valueOf(c.this.mUserId), c.this.gGS.cpe().Wk());
            }
        }
    };
    private final d.a gGT = new d.a() { // from class: com.baidu.tieba.ala.d.c.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void ah(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = c.this.gGR.Wp();
            }
            if (!ListUtils.isEmpty(list)) {
                c.this.gGS.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> Wp = c.this.gGR.Wp();
            if (!ListUtils.isEmpty(Wp)) {
                c.this.gGS.setData(Wp);
            }
        }
    };

    public c(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.brr = j;
        this.ggl = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bJG = z2;
        this.gGR = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gGT);
        this.gGR.b(this.brr, this.ggl, this.mUserId, this.mIsHost, this.bJG);
        this.gGS = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gGS.b(this.brr, this.ggl, this.mUserId, this.mIsHost, this.bJG);
        this.gGR.Wo();
        this.gGN = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gGN.a(this.gGO);
    }

    public View getView() {
        return this.gGS.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gGR.onDestroy();
        this.gGN.onDestroy();
        this.gGS.onDestroy();
    }
}
