package com.baidu.tieba.ala.live.guess.a;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.live.guess.a.c;
/* loaded from: classes4.dex */
public class f extends b implements View.OnClickListener {
    private TextView gNQ;
    private TextView gNR;
    private a gNS;

    /* loaded from: classes4.dex */
    public interface a {
        void amE();

        void bUl();
    }

    public void a(a aVar) {
        this.gNS = aVar;
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void FS() {
        this.gNR.setOnClickListener(this);
        this.gNQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bUr() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_voucher_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.gNQ = (TextView) this.mRootView.findViewById(a.f.tv_guess_continue);
        this.gNR = (TextView) this.mRootView.findViewById(a.f.tv_guess_voucher);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.f.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gNQ) {
            if (this.gNS != null) {
                this.gNS.amE();
                dismiss();
            }
        } else if (view == this.gNR) {
            this.gNS.bUl();
            dismiss();
        }
    }
}
