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
    private LinearLayout hit;
    private TextView hiu;
    private a hiv;
    private TextView hiw;
    private FrameLayout hix;

    /* loaded from: classes11.dex */
    public interface a {
        void anC();

        void bXp();
    }

    public void a(a aVar) {
        this.hiv = aVar;
    }

    public c(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void ED() {
        this.hiu.setOnClickListener(this);
        this.hit.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    void bXS() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_follow_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.view.a
    public void initView() {
        this.hiw = (TextView) this.mRootView.findViewById(a.f.tv_follow_content);
        this.amz = (RelativeLayout) this.mRootView.findViewById(a.f.layout_panel);
        this.hit = (LinearLayout) this.mRootView.findViewById(a.f.frame_exit);
        this.hiu = (TextView) this.mRootView.findViewById(a.f.tv_guess_follow);
        this.hix = (FrameLayout) this.mRootView.findViewById(a.f.frame_icon);
        bXY();
        this.mDialog.setOnKeyListener(new b.DialogInterface$OnKeyListenerC0648b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.view.c.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    private void bXY() {
        com.baidu.tieba.ala.live.guess.c.c.o(this.amz, 300, 240);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hix, 300, 118, -60, 0, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hiu, 190, 44, 25, 25, 0, 0);
        com.baidu.tieba.ala.live.guess.c.c.c(this.hiw, 20);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hit) {
            if (this.hiv != null) {
                this.hiv.anC();
                dismiss();
            }
        } else if (view == this.hiu) {
            this.hiv.bXp();
            dismiss();
        }
    }
}
