package com.baidu.tieba.ala.c;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.o.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes7.dex */
public class a {
    private long bew;
    private com.baidu.tieba.ala.view.a fSK;
    private com.baidu.live.o.b fSL;
    private long fuJ;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a fSM = new b.a() { // from class: com.baidu.tieba.ala.c.a.1
        @Override // com.baidu.live.o.b.a
        public void Mf() {
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
            if (a.this.fSK.cal().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_describe_feedback_reason_text_max_limit);
            } else if (a.this.mUserId > 0) {
                a.this.fSL.az(String.valueOf(a.this.mUserId), a.this.fSK.cal());
            }
        }
    };
    private final a.InterfaceC0661a fSN = new a.InterfaceC0661a() { // from class: com.baidu.tieba.ala.c.a.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0661a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.bew = j;
        this.fuJ = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.fSK = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.fSN);
        this.fSK.b(this.bew, this.fuJ, this.mUserId, this.mIsHost);
        this.fSL = new com.baidu.live.o.b(this.mTbPageContext);
        this.fSL.a(this.fSM);
    }

    public View getView() {
        return this.fSK.getView();
    }

    public void onDestroy() {
        this.fSL.onDestroy();
        this.fSK.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.fSK != null) {
            this.fSK.onKeyboardVisibilityChanged(z);
        }
    }
}
