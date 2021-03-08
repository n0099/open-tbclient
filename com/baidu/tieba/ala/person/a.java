package com.baidu.tieba.ala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View hXb;
    private View hXc;
    private InterfaceC0687a hXd;
    private boolean hXe;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0687a {
        void cmH();
    }

    public a(Context context) {
        super(context, a.i.Theme_Report_Dialog);
        this.hXe = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.i.Theme_Report_Dialog);
        this.hXe = false;
        this.context = context;
        this.hXe = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_report);
        if (this.hXe) {
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
        this.hXb = findViewById(a.f.report);
        this.hXc = findViewById(a.f.report_cancel);
        this.hXb.setOnClickListener(this);
        this.hXc.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.report && this.hXd != null) {
            this.hXd.cmH();
        }
        dismiss();
    }

    public void a(InterfaceC0687a interfaceC0687a) {
        this.hXd = interfaceC0687a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
