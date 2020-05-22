package com.baidu.tieba.ala.liveroom.h;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView fTW;
    private TextView fTX;
    private TextView fTY;
    private InterfaceC0563a fTZ;
    private String fUa;
    private String fUb;
    private String fUc;
    private String fUd;
    private String fUe;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0563a {
        void bBl();

        void bBm();
    }

    public a(Context context) {
        super(context, a.j.ala_tips_dialog_style);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(a.h.dialog_anchor_letter);
        initView();
        initListener();
        initData();
    }

    private void initData() {
        this.fTW.setIsRound(true);
        this.fTW.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.fTW.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.fTW = (HeadImageView) findViewById(a.g.user_icon);
        this.fTX = (TextView) findViewById(a.g.invite_txt);
        this.fTY = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.fTW, this.fUa, true, false);
        this.fTX.setText(this.fUb);
        this.fTY.setText(this.fUc);
    }

    private void initListener() {
        this.fTY.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fTY) {
            if (this.fTZ != null) {
                this.fTZ.bBm();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.fUd, this.fUe);
        } else if (view == this.mClose) {
            if (this.fTZ != null) {
                this.fTZ.bBl();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.fUe);
        }
    }

    public void Cq(String str) {
        this.fUa = str;
        if (this.fTW != null) {
            k.a(this.fTW, this.fUa, true, false);
        }
    }

    public void Cr(String str) {
        this.fUb = str;
        if (this.fTX != null) {
            this.fTX.setText(this.fUb);
        }
    }

    public void Cs(String str) {
        this.fUc = str;
        if (this.fTY != null) {
            this.fTY.setText(this.fUc);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Ct(String str) {
        this.fUd = str;
    }

    public void Cu(String str) {
        this.fUe = str;
    }

    public void a(InterfaceC0563a interfaceC0563a) {
        this.fTZ = interfaceC0563a;
    }
}
