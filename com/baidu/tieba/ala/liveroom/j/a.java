package com.baidu.tieba.ala.liveroom.j;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.m;
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView hyH;
    private TextView hyI;
    private TextView hyJ;
    private InterfaceC0666a hyK;
    private String hyL;
    private String hyM;
    private String hyN;
    private String hyO;
    private String hyP;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0666a {
        void ceg();

        void ceh();
    }

    public a(Context context) {
        super(context, a.i.ala_tips_dialog_style);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.g.dialog_anchor_letter);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        this.hyH.setIsRound(true);
        this.hyH.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hyH.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hyH = (HeadImageView) findViewById(a.f.user_icon);
        this.hyI = (TextView) findViewById(a.f.invite_txt);
        this.hyJ = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        m.a(this.hyH, this.hyL, true, false);
        this.hyI.setText(this.hyM);
        this.hyJ.setText(this.hyN);
    }

    private void initListener() {
        this.hyJ.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hyJ) {
            if (this.hyK != null) {
                this.hyK.ceh();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hyO, this.hyP);
        } else if (view == this.mClose) {
            if (this.hyK != null) {
                this.hyK.ceg();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hyP);
        }
    }

    public void Hf(String str) {
        this.hyL = str;
        if (this.hyH != null) {
            m.a(this.hyH, this.hyL, true, false);
        }
    }

    public void Hg(String str) {
        this.hyM = str;
        if (this.hyI != null) {
            this.hyI.setText(this.hyM);
        }
    }

    public void Hh(String str) {
        this.hyN = str;
        if (this.hyJ != null) {
            this.hyJ.setText(this.hyN);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Hi(String str) {
        this.hyO = str;
    }

    public void Hj(String str) {
        this.hyP = str;
    }

    public void a(InterfaceC0666a interfaceC0666a) {
        this.hyK = interfaceC0666a;
    }
}
