package com.baidu.tieba.ala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View hVs;
    private View hVt;
    private InterfaceC0681a hVu;
    private boolean hVv;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0681a {
        void cmB();
    }

    public a(Context context) {
        super(context, a.i.Theme_Report_Dialog);
        this.hVv = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.i.Theme_Report_Dialog);
        this.hVv = false;
        this.context = context;
        this.hVv = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.ala_person_dialog_report);
        if (this.hVv) {
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
        this.hVs = findViewById(a.f.report);
        this.hVt = findViewById(a.f.report_cancel);
        this.hVs.setOnClickListener(this);
        this.hVt.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.report && this.hVu != null) {
            this.hVu.cmB();
        }
        dismiss();
    }

    public void a(InterfaceC0681a interfaceC0681a) {
        this.hVu = interfaceC0681a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
