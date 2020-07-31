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
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView gma;
    private TextView gmb;
    private TextView gmc;
    private InterfaceC0582a gmd;
    private String gme;
    private String gmf;
    private String gmg;
    private String gmh;
    private String gmi;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0582a {
        void bHE();

        void bHF();
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
        this.gma.setIsRound(true);
        this.gma.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.gma.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.gma = (HeadImageView) findViewById(a.g.user_icon);
        this.gmb = (TextView) findViewById(a.g.invite_txt);
        this.gmc = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.gma, this.gme, true, false);
        this.gmb.setText(this.gmf);
        this.gmc.setText(this.gmg);
    }

    private void initListener() {
        this.gmc.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmc) {
            if (this.gmd != null) {
                this.gmd.bHF();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.gmh, this.gmi);
        } else if (view == this.mClose) {
            if (this.gmd != null) {
                this.gmd.bHE();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.gmi);
        }
    }

    public void DB(String str) {
        this.gme = str;
        if (this.gma != null) {
            k.a(this.gma, this.gme, true, false);
        }
    }

    public void DC(String str) {
        this.gmf = str;
        if (this.gmb != null) {
            this.gmb.setText(this.gmf);
        }
    }

    public void DD(String str) {
        this.gmg = str;
        if (this.gmc != null) {
            this.gmc.setText(this.gmg);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void DE(String str) {
        this.gmh = str;
    }

    public void DF(String str) {
        this.gmi = str;
    }

    public void a(InterfaceC0582a interfaceC0582a) {
        this.gmd = interfaceC0582a;
    }
}
