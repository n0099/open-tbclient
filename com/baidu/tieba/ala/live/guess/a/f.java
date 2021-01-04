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
/* loaded from: classes11.dex */
public class f extends b implements View.OnClickListener {
    private TextView hiT;
    private TextView hiU;
    private a hiV;

    /* loaded from: classes11.dex */
    public interface a {
        void aqY();

        void caA();
    }

    public void a(a aVar) {
        this.hiV = aVar;
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void Hi() {
        this.hiU.setOnClickListener(this);
        this.hiT.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void caG() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_voucher_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.hiT = (TextView) this.mRootView.findViewById(a.f.tv_guess_continue);
        this.hiU = (TextView) this.mRootView.findViewById(a.f.tv_guess_voucher);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.f.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hiT) {
            if (this.hiV != null) {
                this.hiV.aqY();
                dismiss();
            }
        } else if (view == this.hiU) {
            this.hiV.caA();
            dismiss();
        }
    }
}
