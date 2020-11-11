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
    private TextView gOj;
    private TextView gOk;
    private a gOl;

    /* loaded from: classes4.dex */
    public interface a {
        void anm();

        void bUS();
    }

    public void a(a aVar) {
        this.gOl = aVar;
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void GB() {
        this.gOk.setOnClickListener(this);
        this.gOj.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bUY() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_voucher_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.gOj = (TextView) this.mRootView.findViewById(a.f.tv_guess_continue);
        this.gOk = (TextView) this.mRootView.findViewById(a.f.tv_guess_voucher);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.f.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gOj) {
            if (this.gOl != null) {
                this.gOl.anm();
                dismiss();
            }
        } else if (view == this.gOk) {
            this.gOl.bUS();
            dismiss();
        }
    }
}
