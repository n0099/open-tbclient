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
    private com.baidu.tieba.ala.view.a gGK;
    private com.baidu.live.personmanager.e gGL;
    private long ggj;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gGM = new e.a() { // from class: com.baidu.tieba.ala.d.b.1
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
            if (b.this.gGK.Wq().length() > 20) {
                BdUtilHelper.showToast(b.this.mTbPageContext.getPageActivity(), a.h.txt_describe_feedback_reason_text_max_limit);
            } else if (b.this.mUserId > 0) {
                b.this.gGL.aI(String.valueOf(b.this.mUserId), b.this.gGK.Wq());
            }
        }
    };
    private final a.InterfaceC0720a gGN = new a.InterfaceC0720a() { // from class: com.baidu.tieba.ala.d.b.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0720a
        public void afterTextChanged(Editable editable) {
        }
    };

    public b(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.brr = j;
        this.ggj = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gGK = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gGN);
        this.gGK.b(this.brr, this.ggj, this.mUserId, this.mIsHost);
        this.gGL = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gGL.a(this.gGM);
    }

    public View getView() {
        return this.gGK.getView();
    }

    public void onDestroy() {
        this.gGL.onDestroy();
        this.gGK.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gGK != null) {
            this.gGK.onKeyboardVisibilityChanged(z);
        }
    }
}
