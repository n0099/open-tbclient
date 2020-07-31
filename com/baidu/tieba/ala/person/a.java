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
    private View gCO;
    private View gCP;
    private InterfaceC0597a gCQ;
    private boolean gCR;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0597a {
        void bOj();
    }

    public a(Context context) {
        super(context, a.j.Theme_Report_Dialog);
        this.gCR = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.j.Theme_Report_Dialog);
        this.gCR = false;
        this.context = context;
        this.gCR = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_report);
        if (this.gCR) {
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
        this.gCO = findViewById(a.g.report);
        this.gCP = findViewById(a.g.report_cancel);
        this.gCO.setOnClickListener(this);
        this.gCP.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.report && this.gCQ != null) {
            this.gCQ.bOj();
        }
        dismiss();
    }

    public void a(InterfaceC0597a interfaceC0597a) {
        this.gCQ = interfaceC0597a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
