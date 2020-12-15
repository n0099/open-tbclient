package com.baidu.tieba.ala.d;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes4.dex */
public class b {
    private long brr;
    private com.baidu.tieba.ala.view.a gGM;
    private com.baidu.live.personmanager.e gGN;
    private long ggl;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gGO = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void Qv() {
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
            if (b.this.gGM.Wq().length() > 20) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (b.this.mUserId > 0) {
                b.this.gGN.aI(String.valueOf(b.this.mUserId), b.this.gGM.Wq());
            }
        }
    };
    private final a.InterfaceC0720a gGP = new a.InterfaceC0720a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0720a
        public void afterTextChanged(Editable editable) {
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.brr = j;
        this.ggl = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gGM = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gGP);
        this.gGM.b(this.brr, this.ggl, this.mUserId, this.mIsHost);
        this.gGN = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gGN.a(this.gGO);
    }

    public View getView() {
        return this.gGM.getView();
    }

    public void onDestroy() {
        this.gGN.onDestroy();
        this.gGM.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gGM != null) {
            this.gGM.onKeyboardVisibilityChanged(z);
        }
    }
}
