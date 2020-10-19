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
/* loaded from: classes4.dex */
public class d extends b implements View.OnClickListener {
    private LinearLayout gwF;
    private TextView gwG;
    private a gwH;

    /* loaded from: classes4.dex */
    public interface a {
        void aiS();

        void bPv();
    }

    public void a(a aVar) {
        this.gwH = aVar;
    }

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void FL() {
        this.gwG.setOnClickListener(this);
        this.gwF.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bPC() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.ala_guess_follow_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.gwF = (LinearLayout) this.mRootView.findViewById(a.g.frame_exit);
        this.gwG = (TextView) this.mRootView.findViewById(a.g.tv_guess_follow);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.d.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gwF) {
            if (this.gwH != null) {
                this.gwH.aiS();
                dismiss();
            }
        } else if (view == this.gwG) {
            this.gwH.bPv();
            dismiss();
        }
    }
}
