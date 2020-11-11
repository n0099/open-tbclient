package com.baidu.tieba.ala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View hzQ;
    private View hzR;
    private InterfaceC0692a hzS;
    private boolean hzT;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0692a {
        void cji();
    }

    public a(Context context) {
        super(context, a.i.Theme_Report_Dialog);
        this.hzT = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.i.Theme_Report_Dialog);
        this.hzT = false;
        this.context = context;
        this.hzT = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_report);
        if (this.hzT) {
            resize();
        } else {
            int[] screenDimensions = BdUtilHelper.getScreenDimensions(this.context);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = Math.min(screenDimensions[0], screenDimensions[1]);
            getWindow().setGravity(81);
            getWindow().setAttributes(attributes);
        }
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        this.hzQ = findViewById(a.f.report);
        this.hzR = findViewById(a.f.report_cancel);
        this.hzQ.setOnClickListener(this);
        this.hzR.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.report && this.hzS != null) {
            this.hzS.cji();
        }
        dismiss();
    }

    public void a(InterfaceC0692a interfaceC0692a) {
        this.hzS = interfaceC0692a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
