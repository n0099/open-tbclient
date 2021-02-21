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
    private ImageView hiQ;
    private TextView hiR;
    private a hiS;
    private TextView hiw;
    private FrameLayout hix;

    /* loaded from: classes11.dex */
    public interface a {
        void anC();

        void bXq();
    }

    public void a(a aVar) {
        this.hiS = aVar;
    }

    public f(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void ED() {
        this.hiR.setOnClickListener(this);
        this.hiQ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    void bXS() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_voucher_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void initView() {
        this.hix = (FrameLayout) this.mRootView.findViewById(a.f.frame_icon);
        this.hiw = (TextView) this.mRootView.findViewById(a.f.tv_follow_content);
        this.amz = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hiQ = (ImageView) this.mRootView.findViewById(a.f.img_exit);
        this.hiR = (TextView) this.mRootView.findViewById(a.f.tv_guess_voucher);
        bXY();
        this.mDialog.setOnKeyListener(new b.DialogInterface$OnKeyListenerC0648b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.f.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    private void bXY() {
        com.baidu.tieba.ala.live.guess.c.c.o(this.amz, 300, 210);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hix, 300, 118, -60, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hiR, 190, 44, 30, 30, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hiw, 20);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hiQ) {
            if (this.hiS != null) {
                this.hiS.anC();
                dismiss();
            }
        } else if (view == this.hiR) {
            this.hiS.bXq();
            dismiss();
        }
    }
}
