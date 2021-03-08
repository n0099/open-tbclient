package com.baidu.tieba.ala.live.guess.view;

import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.live.guess.view.b;
/* loaded from: classes10.dex */
public class f extends com.baidu.tieba.ala.live.guess.view.a implements View.OnClickListener {
    private RelativeLayout anR;
    private TextView hkA;
    private a hkB;
    private TextView hkf;
    private FrameLayout hkg;
    private ImageView hkz;

    /* loaded from: classes10.dex */
    public interface a {
        void anF();

        void bXw();
    }

    public void a(a aVar) {
        this.hkB = aVar;
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void EG() {
        this.hkA.setOnClickListener(this);
        this.hkz.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    void bXY() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_voucher_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void initView() {
        this.hkg = (FrameLayout) this.mRootView.findViewById(a.f.frame_icon);
        this.hkf = (TextView) this.mRootView.findViewById(a.f.tv_follow_content);
        this.anR = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hkz = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hkA = (TextView) this.mRootView.findViewById(a.f.tv_guess_voucher);
        bYe();
        this.mDialog.setOnKeyListener(new b.DialogInterface$OnKeyListenerC0654b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.f.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    private void bYe() {
        com.baidu.tieba.ala.live.guess.c.c.o(this.anR, 300, 210);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hkg, 300, 118, -60, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hkA, 190, 44, 30, 30, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hkf, 20);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hkz) {
            if (this.hkB != null) {
                this.hkB.anF();
                dismiss();
            }
        } else if (view == this.hkA) {
            this.hkB.bXw();
            dismiss();
        }
    }
}
