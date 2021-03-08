package com.baidu.tieba.ala.live.guess.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.live.guess.view.b;
/* loaded from: classes10.dex */
public class c extends com.baidu.tieba.ala.live.guess.view.a implements View.OnClickListener {
    private RelativeLayout anR;
    private LinearLayout hkc;
    private TextView hkd;
    private a hke;
    private TextView hkf;
    private FrameLayout hkg;

    /* loaded from: classes10.dex */
    public interface a {
        void anF();

        void bXv();
    }

    public void a(a aVar) {
        this.hke = aVar;
    }

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void EG() {
        this.hkd.setOnClickListener(this);
        this.hkc.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    void bXY() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_follow_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void initView() {
        this.hkf = (TextView) this.mRootView.findViewById(a.f.tv_follow_content);
        this.anR = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hkc = (LinearLayout) this.mRootView.findViewById(a.f.frame_exit);
        this.hkd = (TextView) this.mRootView.findViewById(a.f.tv_guess_follow);
        this.hkg = (FrameLayout) this.mRootView.findViewById(a.f.frame_icon);
        bYe();
        this.mDialog.setOnKeyListener(new b.DialogInterface$OnKeyListenerC0654b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.c.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    private void bYe() {
        com.baidu.tieba.ala.live.guess.c.c.o(this.anR, 300, 240);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hkg, 300, 118, -60, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hkd, 190, 44, 25, 25, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hkf, 20);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hkc) {
            if (this.hke != null) {
                this.hke.anF();
                dismiss();
            }
        } else if (view == this.hkd) {
            this.hke.bXv();
            dismiss();
        }
    }
}
