package com.baidu.tieba.ala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View gko;
    private View gkp;
    private InterfaceC0579a gkq;
    private boolean gkr;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0579a {
        void bHU();
    }

    public a(Context context) {
        super(context, a.j.Theme_Report_Dialog);
        this.gkr = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.j.Theme_Report_Dialog);
        this.gkr = false;
        this.context = context;
        this.gkr = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_report);
        if (this.gkr) {
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
        this.gko = findViewById(a.g.report);
        this.gkp = findViewById(a.g.report_cancel);
        this.gko.setOnClickListener(this);
        this.gkp.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.report && this.gkq != null) {
            this.gkq.bHU();
        }
        dismiss();
    }

    public void a(InterfaceC0579a interfaceC0579a) {
        this.gkq = interfaceC0579a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
