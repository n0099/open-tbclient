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
/* loaded from: classes11.dex */
public class c extends com.baidu.tieba.ala.live.guess.view.a implements View.OnClickListener {
    private RelativeLayout amz;
    private LinearLayout hif;
    private TextView hig;
    private a hih;
    private TextView hii;
    private FrameLayout hij;

    /* loaded from: classes11.dex */
    public interface a {
        void anC();

        void bXi();
    }

    public void a(a aVar) {
        this.hih = aVar;
    }

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void ED() {
        this.hig.setOnClickListener(this);
        this.hif.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    void bXL() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_follow_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void initView() {
        this.hii = (TextView) this.mRootView.findViewById(a.f.tv_follow_content);
        this.amz = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hif = (LinearLayout) this.mRootView.findViewById(a.f.frame_exit);
        this.hig = (TextView) this.mRootView.findViewById(a.f.tv_guess_follow);
        this.hij = (FrameLayout) this.mRootView.findViewById(a.f.frame_icon);
        bXR();
        this.mDialog.setOnKeyListener(new b.DialogInterface$OnKeyListenerC0647b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.c.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    private void bXR() {
        com.baidu.tieba.ala.live.guess.c.c.o(this.amz, 300, 240);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hij, 300, 118, -60, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hig, 190, 44, 25, 25, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hii, 20);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hif) {
            if (this.hih != null) {
                this.hih.anC();
                dismiss();
            }
        } else if (view == this.hig) {
            this.hih.bXi();
            dismiss();
        }
    }
}
