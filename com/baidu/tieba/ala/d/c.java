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
/* loaded from: classes10.dex */
public class c {
    private boolean bJI;
    private long brk;
    private com.baidu.live.personmanager.e gNT;
    private com.baidu.tieba.ala.g.d gNX;
    private com.baidu.tieba.ala.view.b gNY;
    private long gmc;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gNU = new e.a() { // from class: com.baidu.tieba.ala.d.c.1
        @Override // com.baidu.live.personmanager.e.a
        public void NE() {
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
            if (c.this.gNY.cog() != null && c.this.mUserId > 0) {
                c.this.gNT.aF(String.valueOf(c.this.mUserId), c.this.gNY.cog().Tu());
            }
        }
    };
    private final d.a gNZ = new d.a() { // from class: com.baidu.tieba.ala.d.c.3
        @Override // com.baidu.tieba.ala.g.d.a
        public void ai(List<com.baidu.tieba.ala.data.b> list) {
            if (ListUtils.isEmpty(list)) {
                list = c.this.gNX.Tz();
            }
            if (!ListUtils.isEmpty(list)) {
                c.this.gNY.setData(list);
            }
        }

        @Override // com.baidu.tieba.ala.g.d.a
        public void onFail(int i, String str) {
            List<com.baidu.tieba.ala.data.b> Tz = c.this.gNX.Tz();
            if (!ListUtils.isEmpty(Tz)) {
                c.this.gNY.setData(Tz);
            }
        }
    };

    public c(TbPageContext tbPageContext, long j, long j2, long j3, boolean z, boolean z2) {
        this.mTbPageContext = tbPageContext;
        this.brk = j;
        this.gmc = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.bJI = z2;
        this.gNX = new com.baidu.tieba.ala.g.d(this.mTbPageContext, this.gNZ);
        this.gNX.b(this.brk, this.gmc, this.mUserId, this.mIsHost, this.bJI);
        this.gNY = new com.baidu.tieba.ala.view.b(this.mTbPageContext, this.mOnClickListener);
        this.gNY.b(this.brk, this.gmc, this.mUserId, this.mIsHost, this.bJI);
        this.gNX.Ty();
        this.gNT = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gNT.a(this.gNU);
    }

    public View getView() {
        return this.gNY.getView();
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onDestroy() {
        this.gNX.onDestroy();
        this.gNT.onDestroy();
        this.gNY.onDestroy();
    }
}
