package com.baidu.tieba.ala.d;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes11.dex */
public class b {
    private long bvY;
    private com.baidu.tieba.ala.view.a gSy;
    private com.baidu.live.personmanager.e gSz;
    private long gqJ;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gSA = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void Rz() {
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
            if (b.this.gSy.Xt().length() > 20) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (b.this.mUserId > 0) {
                b.this.gSz.aG(String.valueOf(b.this.mUserId), b.this.gSy.Xt());
            }
        }
    };
    private final a.InterfaceC0712a gSB = new a.InterfaceC0712a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0712a
        public void afterTextChanged(Editable editable) {
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.bvY = j;
        this.gqJ = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gSy = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gSB);
        this.gSy.b(this.bvY, this.gqJ, this.mUserId, this.mIsHost);
        this.gSz = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gSz.a(this.gSA);
    }

    public View getView() {
        return this.gSy.getView();
    }

    public void onDestroy() {
        this.gSz.onDestroy();
        this.gSy.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gSy != null) {
            this.gSy.onKeyboardVisibilityChanged(z);
        }
    }
}
