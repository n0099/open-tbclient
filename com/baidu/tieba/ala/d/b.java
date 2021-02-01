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
    private long buN;
    private com.baidu.tieba.ala.view.a gQy;
    private com.baidu.live.personmanager.e gQz;
    private long goL;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gQA = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
        @Override // com.baidu.live.personmanager.e.a
        public void Pg() {
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
            if (b.this.gQy.Vh().length() > 20) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (b.this.mUserId > 0) {
                b.this.gQz.aF(String.valueOf(b.this.mUserId), b.this.gQy.Vh());
            }
        }
    };
    private final a.InterfaceC0695a gQB = new a.InterfaceC0695a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0695a
        public void afterTextChanged(Editable editable) {
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.buN = j;
        this.goL = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gQy = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gQB);
        this.gQy.b(this.buN, this.goL, this.mUserId, this.mIsHost);
        this.gQz = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gQz.a(this.gQA);
    }

    public View getView() {
        return this.gQy.getView();
    }

    public void onDestroy() {
        this.gQz.onDestroy();
        this.gQy.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gQy != null) {
            this.gQy.onKeyboardVisibilityChanged(z);
        }
    }
}
