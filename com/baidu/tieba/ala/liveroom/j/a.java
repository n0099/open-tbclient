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
    private HeadImageView hhM;
    private TextView hhN;
    private TextView hhO;
    private InterfaceC0677a hhP;
    private String hhQ;
    private String hhR;
    private String hhS;
    private String hhT;
    private String hhU;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0677a {
        void cbn();

        void cbo();
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
        this.hhM.setIsRound(true);
        this.hhM.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hhM.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hhM = (HeadImageView) findViewById(a.f.user_icon);
        this.hhN = (TextView) findViewById(a.f.invite_txt);
        this.hhO = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        l.a(this.hhM, this.hhQ, true, false);
        this.hhN.setText(this.hhR);
        this.hhO.setText(this.hhS);
    }

    private void initListener() {
        this.hhO.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hhO) {
            if (this.hhP != null) {
                this.hhP.cbo();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hhT, this.hhU);
        } else if (view == this.mClose) {
            if (this.hhP != null) {
                this.hhP.cbn();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hhU);
        }
    }

    public void HB(String str) {
        this.hhQ = str;
        if (this.hhM != null) {
            l.a(this.hhM, this.hhQ, true, false);
        }
    }

    public void HC(String str) {
        this.hhR = str;
        if (this.hhN != null) {
            this.hhN.setText(this.hhR);
        }
    }

    public void HD(String str) {
        this.hhS = str;
        if (this.hhO != null) {
            this.hhO.setText(this.hhS);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void HE(String str) {
        this.hhT = str;
    }

    public void HF(String str) {
        this.hhU = str;
    }

    public void a(InterfaceC0677a interfaceC0677a) {
        this.hhP = interfaceC0677a;
    }
}
