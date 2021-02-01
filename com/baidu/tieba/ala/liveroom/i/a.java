package com.baidu.tieba.ala.liveroom.i;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.m;
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView hCS;
    private TextView hCT;
    private TextView hCU;
    private InterfaceC0666a hCV;
    private String hCW;
    private String hCX;
    private String hCY;
    private String hCZ;
    private String hDa;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0666a {
        void cfb();

        void cfc();
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
        this.hCS.setIsRound(true);
        this.hCS.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hCS.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hCS = (HeadImageView) findViewById(a.f.user_icon);
        this.hCT = (TextView) findViewById(a.f.invite_txt);
        this.hCU = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        m.a(this.hCS, this.hCW, true, false);
        this.hCT.setText(this.hCX);
        this.hCU.setText(this.hCY);
    }

    private void initListener() {
        this.hCU.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCU) {
            if (this.hCV != null) {
                this.hCV.cfc();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hCZ, this.hDa);
        } else if (view == this.mClose) {
            if (this.hCV != null) {
                this.hCV.cfb();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hDa);
        }
    }

    public void HJ(String str) {
        this.hCW = str;
        if (this.hCS != null) {
            m.a(this.hCS, this.hCW, true, false);
        }
    }

    public void HK(String str) {
        this.hCX = str;
        if (this.hCT != null) {
            this.hCT.setText(this.hCX);
        }
    }

    public void HL(String str) {
        this.hCY = str;
        if (this.hCU != null) {
            this.hCU.setText(this.hCY);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void HM(String str) {
        this.hCZ = str;
    }

    public void HN(String str) {
        this.hDa = str;
    }

    public void a(InterfaceC0666a interfaceC0666a) {
        this.hCV = interfaceC0666a;
    }
}
