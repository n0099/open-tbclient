package com.baidu.tieba.ala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.q.a;
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View fkr;
    private View fks;
    private InterfaceC0460a fkt;
    private boolean fku;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0460a {
        void bpl();
    }

    public a(Context context) {
        super(context, a.j.Theme_Report_Dialog);
        this.fku = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.j.Theme_Report_Dialog);
        this.fku = false;
        this.context = context;
        this.fku = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_report);
        if (this.fku) {
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
        this.fkr = findViewById(a.g.report);
        this.fks = findViewById(a.g.report_cancel);
        this.fkr.setOnClickListener(this);
        this.fks.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.report && this.fkt != null) {
            this.fkt.bpl();
        }
        dismiss();
    }

    public void a(InterfaceC0460a interfaceC0460a) {
        this.fkt = interfaceC0460a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
