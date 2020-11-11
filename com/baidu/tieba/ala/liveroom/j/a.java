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
    private HeadImageView hig;
    private TextView hih;
    private TextView hii;
    private InterfaceC0677a hij;
    private String hik;
    private String hil;
    private String him;
    private String hin;
    private String hio;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0677a {
        void cbU();

        void cbV();
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
        this.hig.setIsRound(true);
        this.hig.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hig.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hig = (HeadImageView) findViewById(a.f.user_icon);
        this.hih = (TextView) findViewById(a.f.invite_txt);
        this.hii = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        l.a(this.hig, this.hik, true, false);
        this.hih.setText(this.hil);
        this.hii.setText(this.him);
    }

    private void initListener() {
        this.hii.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hii) {
            if (this.hij != null) {
                this.hij.cbV();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hin, this.hio);
        } else if (view == this.mClose) {
            if (this.hij != null) {
                this.hij.cbU();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hio);
        }
    }

    public void Ia(String str) {
        this.hik = str;
        if (this.hig != null) {
            l.a(this.hig, this.hik, true, false);
        }
    }

    public void Ib(String str) {
        this.hil = str;
        if (this.hih != null) {
            this.hih.setText(this.hil);
        }
    }

    public void Ic(String str) {
        this.him = str;
        if (this.hii != null) {
            this.hii.setText(this.him);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Id(String str) {
        this.hin = str;
    }

    public void Ie(String str) {
        this.hio = str;
    }

    public void a(InterfaceC0677a interfaceC0677a) {
        this.hij = interfaceC0677a;
    }
}
