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
    private HeadImageView hrp;
    private TextView hrq;
    private TextView hrr;
    private InterfaceC0691a hrs;
    private String hrt;
    private String hru;
    private String hrv;
    private String hrw;
    private String hrx;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0691a {
        void cfg();

        void cfh();
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
        this.hrp.setIsRound(true);
        this.hrp.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hrp.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hrp = (HeadImageView) findViewById(a.f.user_icon);
        this.hrq = (TextView) findViewById(a.f.invite_txt);
        this.hrr = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        l.a(this.hrp, this.hrt, true, false);
        this.hrq.setText(this.hru);
        this.hrr.setText(this.hrv);
    }

    private void initListener() {
        this.hrr.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hrr) {
            if (this.hrs != null) {
                this.hrs.cfh();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hrw, this.hrx);
        } else if (view == this.mClose) {
            if (this.hrs != null) {
                this.hrs.cfg();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hrx);
        }
    }

    public void Ip(String str) {
        this.hrt = str;
        if (this.hrp != null) {
            l.a(this.hrp, this.hrt, true, false);
        }
    }

    public void Iq(String str) {
        this.hru = str;
        if (this.hrq != null) {
            this.hrq.setText(this.hru);
        }
    }

    public void Ir(String str) {
        this.hrv = str;
        if (this.hrr != null) {
            this.hrr.setText(this.hrv);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Is(String str) {
        this.hrw = str;
    }

    public void It(String str) {
        this.hrx = str;
    }

    public void a(InterfaceC0691a interfaceC0691a) {
        this.hrs = interfaceC0691a;
    }
}
