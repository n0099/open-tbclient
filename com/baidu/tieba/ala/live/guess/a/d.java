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
    private LinearLayout gIt;
    private TextView gIu;
    private a gIv;

    /* loaded from: classes4.dex */
    public interface a {
        void akM();

        void bSs();
    }

    public void a(a aVar) {
        this.gIv = aVar;
    }

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void Ga() {
        this.gIu.setOnClickListener(this);
        this.gIt.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bSz() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.h.ala_guess_follow_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.gIt = (LinearLayout) this.mRootView.findViewById(a.g.frame_exit);
        this.gIu = (TextView) this.mRootView.findViewById(a.g.tv_guess_follow);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.d.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gIt) {
            if (this.gIv != null) {
                this.gIv.akM();
                dismiss();
            }
        } else if (view == this.gIu) {
            this.gIv.bSs();
            dismiss();
        }
    }
}
