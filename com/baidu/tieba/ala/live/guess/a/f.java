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
    private TextView gwJ;
    private TextView gwK;
    private a gwL;

    /* loaded from: classes4.dex */
    public interface a {
        void aiS();

        void bPw();
    }

    public void a(a aVar) {
        this.gwL = aVar;
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void FL() {
        this.gwK.setOnClickListener(this);
        this.gwJ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bPC() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.ala_guess_voucher_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.gwJ = (TextView) this.mRootView.findViewById(a.g.tv_guess_continue);
        this.gwK = (TextView) this.mRootView.findViewById(a.g.tv_guess_voucher);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.f.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gwJ) {
            if (this.gwL != null) {
                this.gwL.aiS();
                dismiss();
            }
        } else if (view == this.gwK) {
            this.gwL.bPw();
            dismiss();
        }
    }
}
