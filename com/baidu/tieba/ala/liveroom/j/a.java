package com.baidu.tieba.ala.liveroom.j;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView hrr;
    private TextView hrs;
    private TextView hrt;
    private InterfaceC0691a hru;
    private String hrv;
    private String hrw;
    private String hrx;
    private String hry;
    private String hrz;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0691a {
        void cfh();

        void cfi();
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
        this.hrr.setIsRound(true);
        this.hrr.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hrr.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hrr = (HeadImageView) findViewById(a.f.user_icon);
        this.hrs = (TextView) findViewById(a.f.invite_txt);
        this.hrt = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        l.a(this.hrr, this.hrv, true, false);
        this.hrs.setText(this.hrw);
        this.hrt.setText(this.hrx);
    }

    private void initListener() {
        this.hrt.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hrt) {
            if (this.hru != null) {
                this.hru.cfi();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hry, this.hrz);
        } else if (view == this.mClose) {
            if (this.hru != null) {
                this.hru.cfh();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hrz);
        }
    }

    public void Ip(String str) {
        this.hrv = str;
        if (this.hrr != null) {
            l.a(this.hrr, this.hrv, true, false);
        }
    }

    public void Iq(String str) {
        this.hrw = str;
        if (this.hrs != null) {
            this.hrs.setText(this.hrw);
        }
    }

    public void Ir(String str) {
        this.hrx = str;
        if (this.hrt != null) {
            this.hrt.setText(this.hrx);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Is(String str) {
        this.hry = str;
    }

    public void It(String str) {
        this.hrz = str;
    }

    public void a(InterfaceC0691a interfaceC0691a) {
        this.hru = interfaceC0691a;
    }
}
