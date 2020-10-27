package com.baidu.tieba.ala.d;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.e;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes4.dex */
public class a {
    private long bmB;
    private long fSB;
    private com.baidu.tieba.ala.view.a gst;
    private com.baidu.live.personmanager.e gsu;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final e.a gsv = new e.a() { // from class: com.baidu.tieba.ala.d.a.1
        @Override // com.baidu.live.personmanager.e.a
        public void Ol() {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            a.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.e.a
        public void onFail(String str) {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gst.RR().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_describe_feedback_reason_text_max_limit);
            } else if (a.this.mUserId > 0) {
                a.this.gsu.aE(String.valueOf(a.this.mUserId), a.this.gst.RR());
            }
        }
    };
    private final a.InterfaceC0692a gsw = new a.InterfaceC0692a() { // from class: com.baidu.tieba.ala.d.a.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0692a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.bmB = j;
        this.fSB = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gst = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.gsw);
        this.gst.b(this.bmB, this.fSB, this.mUserId, this.mIsHost);
        this.gsu = new com.baidu.live.personmanager.e(this.mTbPageContext);
        this.gsu.a(this.gsv);
    }

    public View getView() {
        return this.gst.getView();
    }

    public void onDestroy() {
        this.gsu.onDestroy();
        this.gst.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gst != null) {
            this.gst.onKeyboardVisibilityChanged(z);
        }
    }
}
