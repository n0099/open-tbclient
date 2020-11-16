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
    private LinearLayout gNM;
    private TextView gNN;
    private a gNO;

    /* loaded from: classes4.dex */
    public interface a {
        void amE();

        void bUk();
    }

    public void a(a aVar) {
        this.gNO = aVar;
    }

    public d(Context context) {
        super(context);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void FS() {
        this.gNN.setOnClickListener(this);
        this.gNM.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    void bUr() {
        this.mRootView = LayoutInflater.from(this.mDialog.getContext()).inflate(a.g.ala_guess_follow_dialog, (ViewGroup) null);
    }

    @Override // com.baidu.tieba.ala.live.guess.a.b
    public void initView() {
        this.gNM = (LinearLayout) this.mRootView.findViewById(a.f.frame_exit);
        this.gNN = (TextView) this.mRootView.findViewById(a.f.tv_guess_follow);
        this.mDialog.setOnKeyListener(new c.b(new DialogInterface.OnKeyListener() { // from class: com.baidu.tieba.ala.live.guess.a.d.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                return false;
            }
        }));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gNM) {
            if (this.gNO != null) {
                this.gNO.amE();
                dismiss();
            }
        } else if (view == this.gNN) {
            this.gNO.bUk();
            dismiss();
        }
    }
}
