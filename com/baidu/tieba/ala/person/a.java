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
    private View gSZ;
    private View gTa;
    private InterfaceC0644a gTb;
    private boolean gTc;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0644a {
        void cag();
    }

    public a(Context context) {
        super(context, a.j.Theme_Report_Dialog);
        this.gTc = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.j.Theme_Report_Dialog);
        this.gTc = false;
        this.context = context;
        this.gTc = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_report);
        if (this.gTc) {
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
        this.gSZ = findViewById(a.g.report);
        this.gTa = findViewById(a.g.report_cancel);
        this.gSZ.setOnClickListener(this);
        this.gTa.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.report && this.gTb != null) {
            this.gTb.cag();
        }
        dismiss();
    }

    public void a(InterfaceC0644a interfaceC0644a) {
        this.gTb = interfaceC0644a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
