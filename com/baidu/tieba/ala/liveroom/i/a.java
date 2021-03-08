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
/* loaded from: classes10.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView hEP;
    private TextView hEQ;
    private TextView hER;
    private InterfaceC0673a hES;
    private String hET;
    private String hEU;
    private String hEV;
    private String hEW;
    private String hEX;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0673a {
        void cfo();

        void cfp();
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
        this.hEP.setIsRound(true);
        this.hEP.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hEP.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hEP = (HeadImageView) findViewById(a.f.user_icon);
        this.hEQ = (TextView) findViewById(a.f.invite_txt);
        this.hER = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        m.a(this.hEP, this.hET, true, false);
        this.hEQ.setText(this.hEU);
        this.hER.setText(this.hEV);
    }

    private void initListener() {
        this.hER.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hER) {
            if (this.hES != null) {
                this.hES.cfp();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hEW, this.hEX);
        } else if (view == this.mClose) {
            if (this.hES != null) {
                this.hES.cfo();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hEX);
        }
    }

    public void HT(String str) {
        this.hET = str;
        if (this.hEP != null) {
            m.a(this.hEP, this.hET, true, false);
        }
    }

    public void HU(String str) {
        this.hEU = str;
        if (this.hEQ != null) {
            this.hEQ.setText(this.hEU);
        }
    }

    public void HV(String str) {
        this.hEV = str;
        if (this.hER != null) {
            this.hER.setText(this.hEV);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void HW(String str) {
        this.hEW = str;
    }

    public void HX(String str) {
        this.hEX = str;
    }

    public void a(InterfaceC0673a interfaceC0673a) {
        this.hES = interfaceC0673a;
    }
}
