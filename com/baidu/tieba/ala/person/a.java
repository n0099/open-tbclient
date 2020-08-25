package com.baidu.tieba.ala.person;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
/* loaded from: classes7.dex */
public class a extends Dialog implements View.OnClickListener {
    private Context context;
    private View gPn;
    private View gPo;
    private InterfaceC0647a gPp;
    private boolean gPq;

    /* renamed from: com.baidu.tieba.ala.person.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0647a {
        void bYj();
    }

    public a(Context context) {
        super(context, a.j.Theme_Report_Dialog);
        this.gPq = false;
        this.context = context;
    }

    public a(Context context, boolean z) {
        super(context, a.j.Theme_Report_Dialog);
        this.gPq = false;
        this.context = context;
        this.gPq = z;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.ala_person_dialog_report);
        if (this.gPq) {
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
        this.gPn = findViewById(a.g.report);
        this.gPo = findViewById(a.g.report_cancel);
        this.gPn.setOnClickListener(this);
        this.gPo.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.report && this.gPp != null) {
            this.gPp.bYj();
        }
        dismiss();
    }

    public void a(InterfaceC0647a interfaceC0647a) {
        this.gPp = interfaceC0647a;
    }

    public void resize() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        getWindow().setGravity(81);
        getWindow().setAttributes(attributes);
    }
}
