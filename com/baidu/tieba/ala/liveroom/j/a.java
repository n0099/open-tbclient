package com.baidu.tieba.ala.liveroom.j;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.k;
/* loaded from: classes7.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView gyP;
    private TextView gyQ;
    private TextView gyR;
    private InterfaceC0633a gyS;
    private String gyT;
    private String gyU;
    private String gyV;
    private String gyW;
    private String gyX;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0633a {
        void bRD();

        void bRE();
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
        this.gyP.setIsRound(true);
        this.gyP.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.gyP.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.gyP = (HeadImageView) findViewById(a.g.user_icon);
        this.gyQ = (TextView) findViewById(a.g.invite_txt);
        this.gyR = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.gyP, this.gyT, true, false);
        this.gyQ.setText(this.gyU);
        this.gyR.setText(this.gyV);
    }

    private void initListener() {
        this.gyR.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gyR) {
            if (this.gyS != null) {
                this.gyS.bRE();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.gyW, this.gyX);
        } else if (view == this.mClose) {
            if (this.gyS != null) {
                this.gyS.bRD();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.gyX);
        }
    }

    public void FZ(String str) {
        this.gyT = str;
        if (this.gyP != null) {
            k.a(this.gyP, this.gyT, true, false);
        }
    }

    public void Ga(String str) {
        this.gyU = str;
        if (this.gyQ != null) {
            this.gyQ.setText(this.gyU);
        }
    }

    public void Gb(String str) {
        this.gyV = str;
        if (this.gyR != null) {
            this.gyR.setText(this.gyV);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Gc(String str) {
        this.gyW = str;
    }

    public void Gd(String str) {
        this.gyX = str;
    }

    public void a(InterfaceC0633a interfaceC0633a) {
        this.gyS = interfaceC0633a;
    }
}
