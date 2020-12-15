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
    private TextView gXj;
    private LinearLayout gXk;

    public g(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void HH() {
        this.gXj.setOnClickListener(this);
        this.gXk.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bYb() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_not_choice, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.mDialog.setContentView(this.mRootView);
        this.gXj = (TextView) this.mRootView.findViewById(a.f.tv_guess_ok);
        this.gXk = (LinearLayout) this.mRootView.findViewById(a.f.frame_exit);
        this.mDialog.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.g.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gXj) {
            dismiss();
        } else if (view == this.gXk) {
            dismiss();
        }
    }
}
