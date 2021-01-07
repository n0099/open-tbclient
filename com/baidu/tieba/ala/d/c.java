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
    private boolean bOu;
    private long bvY;
    private com.baidu.tieba.ala.g.d gSD;
    private com.baidu.tieba.ala.view.b gSE;
    private com.baidu.live.personmanager.e gSz;
    private long gqJ;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gSA = new e.a() { // from class: com.baidu.tieba.ala.d.c.1
        @Override // com.baidu.live.personmanager.e.a
        public void Rz() {
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
            if (c.this.gSE.crY() != null && c.this.mUserId > 0) {
                c.this.gSz.aG(String.valueOf(c.this.mUserId), c.this.gSE.crY().Xn());
            }
        }
    };
    private final d.a gSF = new d.a() { // from class: com.baidu.tieba.ala.d.c.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void ai(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = c.this.gSD.Xs();
            }
            if (!ListUtils.isEmpty(list)) {
                c.this.gSE.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> Xs = c.this.gSD.Xs();
            if (!ListUtils.isEmpty(Xs)) {
                c.this.gSE.setData(Xs);
            }
        }
    };

    public c(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.bvY = j;
        this.gqJ = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bOu = z2;
        this.gSD = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gSF);
        this.gSD.b(this.bvY, this.gqJ, this.mUserId, this.mIsHost, this.bOu);
        this.gSE = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gSE.b(this.bvY, this.gqJ, this.mUserId, this.mIsHost, this.bOu);
        this.gSD.Xr();
        this.gSz = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gSz.a(this.gSA);
    }

    public View getView() {
        return this.gSE.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gSD.onDestroy();
        this.gSz.onDestroy();
        this.gSE.onDestroy();
    }
}
