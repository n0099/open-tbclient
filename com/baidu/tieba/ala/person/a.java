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
    private View etM;
    private View etN;
    private InterfaceC0376a etO;
    private boolean etP;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0376a {
        void aXp();
    }

    public a(Context context) {
        super(context, a.j.Theme_Report_Dialog);
        this.etP = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.j.Theme_Report_Dialog);
        this.etP = false;
        this.context = context;
        this.etP = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_report);
        if (this.etP) {
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
        this.etM = findViewById(a.g.report);
        this.etN = findViewById(a.g.report_cancel);
        this.etM.setOnClickListener(this);
        this.etN.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.report && this.etO != null) {
            this.etO.aXp();
        }
        dismiss();
    }

    public void a(InterfaceC0376a interfaceC0376a) {
        this.etO = interfaceC0376a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
