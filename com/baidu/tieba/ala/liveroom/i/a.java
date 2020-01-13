package com.baidu.tieba.ala.liveroom.i;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.k;
/* loaded from: classes2.dex */
public class a extends Dialog implements View.OnClickListener {
    private String eXA;
    private HeadImageView eXs;
    private TextView eXt;
    private TextView eXu;
    private InterfaceC0449a eXv;
    private String eXw;
    private String eXx;
    private String eXy;
    private String eXz;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0449a {
        void bkc();

        void bkd();
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
        this.eXs.setIsRound(true);
        this.eXs.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.eXs.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.eXs = (HeadImageView) findViewById(a.g.user_icon);
        this.eXt = (TextView) findViewById(a.g.invite_txt);
        this.eXu = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.eXs, this.eXw, true, false);
        this.eXt.setText(this.eXx);
        this.eXu.setText(this.eXy);
    }

    private void initListener() {
        this.eXu.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eXu) {
            if (this.eXv != null) {
                this.eXv.bkd();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.eXz, this.eXA);
        } else if (view == this.mClose) {
            if (this.eXv != null) {
                this.eXv.bkc();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.eXA);
        }
    }

    public void yC(String str) {
        this.eXw = str;
        if (this.eXs != null) {
            k.a(this.eXs, this.eXw, true, false);
        }
    }

    public void yD(String str) {
        this.eXx = str;
        if (this.eXt != null) {
            this.eXt.setText(this.eXx);
        }
    }

    public void yE(String str) {
        this.eXy = str;
        if (this.eXu != null) {
            this.eXu.setText(this.eXy);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void yF(String str) {
        this.eXz = str;
    }

    public void yG(String str) {
        this.eXA = str;
    }

    public void a(InterfaceC0449a interfaceC0449a) {
        this.eXv = interfaceC0449a;
    }
}
