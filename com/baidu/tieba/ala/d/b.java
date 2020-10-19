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
    private long blh;
    private boolean eaR;
    private long fKh;
    private com.baidu.live.personmanager.b gis;
    private com.baidu.tieba.ala.g.d giw;
    private com.baidu.tieba.ala.view.b gix;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a git = new b.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.b.a
        public void NN() {
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
            if (b.this.gix.cfT() != null && b.this.mUserId > 0) {
                b.this.gis.aC(String.valueOf(b.this.mUserId), b.this.gix.cfT().bMD());
            }
        }
    };
    private final d.a giy = new d.a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void bk(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = b.this.giw.cdg();
            }
            if (!ListUtils.isEmpty(list)) {
                b.this.gix.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> cdg = b.this.giw.cdg();
            if (!ListUtils.isEmpty(cdg)) {
                b.this.gix.setData(cdg);
            }
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.blh = j;
        this.fKh = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.eaR = z2;
        this.giw = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.giy);
        this.giw.b(this.blh, this.fKh, this.mUserId, this.mIsHost, this.eaR);
        this.gix = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gix.b(this.blh, this.fKh, this.mUserId, this.mIsHost, this.eaR);
        this.giw.cdf();
        this.gis = new com.baidu.live.personmanager.b(this.mTbPageContext);
        this.gis.a(this.git);
    }

    public View getView() {
        return this.gix.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.giw.onDestroy();
        this.gis.onDestroy();
        this.gix.onDestroy();
    }
}
