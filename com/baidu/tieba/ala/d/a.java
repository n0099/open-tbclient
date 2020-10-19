package com.baidu.tieba.ala.d;

import android.text.Editable;
import android.view.View;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.personmanager.b;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.tieba.ala.view.a;
/* loaded from: classes4.dex */
public class a {
    private long blh;
    private long fKh;
    private com.baidu.tieba.ala.view.a gir;
    private com.baidu.live.personmanager.b gis;
    private boolean mIsHost;
    private TbPageContext mTbPageContext;
    private long mUserId;
    private final b.a git = new b.a() { // from class: com.baidu.tieba.ala.d.a.1
        @Override // com.baidu.live.personmanager.b.a
        public void NN() {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_success);
            a.this.mTbPageContext.getPageActivity().finish();
        }

        @Override // com.baidu.live.personmanager.b.a
        public void onFail(String str) {
            BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_person_report_fail);
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.d.a.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.gir.cfS().length() > 20) {
                BdUtilHelper.showToast(a.this.mTbPageContext.getPageActivity(), a.i.txt_describe_feedback_reason_text_max_limit);
            } else if (a.this.mUserId > 0) {
                a.this.gis.aC(String.valueOf(a.this.mUserId), a.this.gir.cfS());
            }
        }
    };
    private final a.InterfaceC0676a giu = new a.InterfaceC0676a() { // from class: com.baidu.tieba.ala.d.a.3
        @Override // com.baidu.tieba.ala.view.a.InterfaceC0676a
        public void afterTextChanged(Editable editable) {
        }
    };

    public a(TbPageContext tbPageContext, long j, long j2, long j3, boolean z) {
        this.mTbPageContext = tbPageContext;
        this.blh = j;
        this.fKh = j2;
        this.mUserId = j3;
        this.mIsHost = z;
        this.gir = new com.baidu.tieba.ala.view.a(this.mTbPageContext, this.mOnClickListener, this.giu);
        this.gir.b(this.blh, this.fKh, this.mUserId, this.mIsHost);
        this.gis = new com.baidu.live.personmanager.b(this.mTbPageContext);
        this.gis.a(this.git);
    }

    public View getView() {
        return this.gir.getView();
    }

    public void onDestroy() {
        this.gis.onDestroy();
        this.gir.onDestroy();
    }

    public void onKeyboardVisibilityChanged(boolean z) {
        if (this.gir != null) {
            this.gir.onKeyboardVisibilityChanged(z);
        }
    }
}
