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
/* loaded from: classes11.dex */
public class f extends com.baidu.tieba.ala.live.guess.view.a implements View.OnClickListener {
    private RelativeLayout amz;
    private ImageView hiC;
    private TextView hiD;
    private a hiE;
    private TextView hii;
    private FrameLayout hij;

    /* loaded from: classes11.dex */
    public interface a {
        void anC();

        void bXj();
    }

    public void a(a aVar) {
        this.hiE = aVar;
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void ED() {
        this.hiD.setOnClickListener(this);
        this.hiC.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    void bXL() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_voucher_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void initView() {
        this.hij = (FrameLayout) this.mRootView.findViewById(a.f.frame_icon);
        this.hii = (TextView) this.mRootView.findViewById(a.f.tv_follow_content);
        this.amz = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hiC = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hiD = (TextView) this.mRootView.findViewById(a.f.tv_guess_voucher);
        bXR();
        this.mDialog.setOnKeyListener(new b.DialogInterface$OnKeyListenerC0647b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.f.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    private void bXR() {
        com.baidu.tieba.ala.live.guess.c.c.o(this.amz, 300, 210);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hij, 300, 118, -60, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hiD, 190, 44, 30, 30, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hii, 20);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hiC) {
            if (this.hiE != null) {
                this.hiE.anC();
                dismiss();
            }
        } else if (view == this.hiD) {
            this.hiE.bXj();
            dismiss();
        }
    }
}
