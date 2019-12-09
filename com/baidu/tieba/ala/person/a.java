package com.baidu.tieba.ala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View esU;
    private View esV;
    private InterfaceC0371a esW;
    private boolean esX;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0371a {
        void aXn();
    }

    public a(Context context) {
        super(context, a.j.Theme_Report_Dialog);
        this.esX = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.j.Theme_Report_Dialog);
        this.esX = false;
        this.context = context;
        this.esX = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_report);
        if (this.esX) {
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
        this.esU = findViewById(a.g.report);
        this.esV = findViewById(a.g.report_cancel);
        this.esU.setOnClickListener(this);
        this.esV.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.report && this.esW != null) {
            this.esW.aXn();
        }
        dismiss();
    }

    public void a(InterfaceC0371a interfaceC0371a) {
        this.esW = interfaceC0371a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
