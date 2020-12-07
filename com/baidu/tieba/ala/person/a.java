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
    private View hJc;
    private View hJd;
    private InterfaceC0705a hJe;
    private boolean hJf;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0705a {
        void cmv();
    }

    public a(Context context) {
        super(context, a.i.Theme_Report_Dialog);
        this.hJf = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.i.Theme_Report_Dialog);
        this.hJf = false;
        this.context = context;
        this.hJf = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_report);
        if (this.hJf) {
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
        this.hJc = findViewById(a.f.report);
        this.hJd = findViewById(a.f.report_cancel);
        this.hJc.setOnClickListener(this);
        this.hJd.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.report && this.hJe != null) {
            this.hJe.cmv();
        }
        dismiss();
    }

    public void a(InterfaceC0705a interfaceC0705a) {
        this.hJe = interfaceC0705a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
