package com.baidu.tieba.ala.live.guess.a;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.live.guess.a.c;
/* loaded from: classes11.dex */
public class d extends b implements View.OnClickListener {
    private LinearLayout hiP;
    private TextView hiQ;
    private a hiR;

    /* loaded from: classes11.dex */
    public interface a {
        void aqZ();

        void caA();
    }

    public void a(a aVar) {
        this.hiR = aVar;
    }

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void Hi() {
        this.hiQ.setOnClickListener(this);
        this.hiP.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void caH() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_follow_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.hiP = (LinearLayout) this.mRootView.findViewById(a.f.frame_exit);
        this.hiQ = (TextView) this.mRootView.findViewById(a.f.tv_guess_follow);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.d.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hiP) {
            if (this.hiR != null) {
                this.hiR.aqZ();
                dismiss();
            }
        } else if (view == this.hiQ) {
            this.hiR.caA();
            dismiss();
        }
    }
}
