package com.baidu.tieba.ala.c;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.o.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes4.dex */
public class a {
    private long aZc;
    private com.baidu.tieba.ala.view.a fHt;
    private com.baidu.live.o.b fHu;
    private long fjn;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a fHv = new b.a() { // from class: com.baidu.tieba.ala.c.a.1
        @Override // com.baidu.live.o.b.a
        public void Gr() {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            a.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.o.b.a
        public void onFail(String str) {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.c.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.fHt.bQa().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_describe_feedback_reason_text_max_limit);
            } else if (a.this.mUserId > 0) {
                a.this.fHu.av(String.valueOf(a.this.mUserId), a.this.fHt.bQa());
            }
        }
    };
    private final a.InterfaceC0611a fHw = new a.InterfaceC0611a() { // from class: com.baidu.tieba.ala.c.a.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0611a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.aZc = j;
        this.fjn = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.fHt = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.fHw);
        this.fHt.b(this.aZc, this.fjn, this.mUserId, this.mIsHost);
        this.fHu = new com.baidu.live.o.b(this.mTbPageContext);
        this.fHu.a(this.fHv);
    }

    public View getView() {
        return this.fHt.getView();
    }

    public void onDestroy() {
        this.fHu.onDestroy();
        this.fHt.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fHt != null) {
            this.fHt.onKeyboardVisibilityChanged(z);
        }
    }
}
