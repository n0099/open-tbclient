package com.baidu.tieba.ala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View fnB;
    private View fnC;
    private InterfaceC0464a fnD;
    private boolean fnE;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0464a {
        void bqm();
    }

    public a(Context context) {
        super(context, a.j.Theme_Report_Dialog);
        this.fnE = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.j.Theme_Report_Dialog);
        this.fnE = false;
        this.context = context;
        this.fnE = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_report);
        if (this.fnE) {
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
        this.fnB = findViewById(a.g.report);
        this.fnC = findViewById(a.g.report_cancel);
        this.fnB.setOnClickListener(this);
        this.fnC.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.report && this.fnD != null) {
            this.fnD.bqm();
        }
        dismiss();
    }

    public void a(InterfaceC0464a interfaceC0464a) {
        this.fnD = interfaceC0464a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
