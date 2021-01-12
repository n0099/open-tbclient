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
/* loaded from: classes10.dex */
public class d extends b implements View.OnClickListener {
    private LinearLayout hei;
    private TextView hej;
    private a hek;

    /* loaded from: classes10.dex */
    public interface a {
        void ane();

        void bWI();
    }

    public void a(a aVar) {
        this.hek = aVar;
    }

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void Dn() {
        this.hej.setOnClickListener(this);
        this.hei.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bWP() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_follow_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.hei = (LinearLayout) this.mRootView.findViewById(a.f.frame_exit);
        this.hej = (TextView) this.mRootView.findViewById(a.f.tv_guess_follow);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.d.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hei) {
            if (this.hek != null) {
                this.hek.ane();
                dismiss();
            }
        } else if (view == this.hej) {
            this.hek.bWI();
            dismiss();
        }
    }
}
