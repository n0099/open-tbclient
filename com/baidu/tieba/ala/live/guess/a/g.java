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
/* loaded from: classes4.dex */
public class g extends b implements View.OnClickListener {
    private TextView gIB;
    private LinearLayout gIC;

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void Ga() {
        this.gIB.setOnClickListener(this);
        this.gIC.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bSz() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.ala_guess_not_choice, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.mDialog.setContentView(this.mRootView);
        this.gIB = (TextView) this.mRootView.findViewById(a.g.tv_guess_ok);
        this.gIC = (LinearLayout) this.mRootView.findViewById(a.g.frame_exit);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.g.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gIB) {
            dismiss();
        } else if (view == this.gIC) {
            dismiss();
        }
    }
}
