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
    private HeadImageView fFW;
    private TextView fFX;
    private TextView fFY;
    private InterfaceC0495a fFZ;
    private String fGa;
    private String fGb;
    private String fGc;
    private String fGd;
    private String fGe;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0495a {
        void bvo();

        void bvp();
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
        this.fFW.setIsRound(true);
        this.fFW.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.fFW.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.fFW = (HeadImageView) findViewById(a.g.user_icon);
        this.fFX = (TextView) findViewById(a.g.invite_txt);
        this.fFY = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.fFW, this.fGa, true, false);
        this.fFX.setText(this.fGb);
        this.fFY.setText(this.fGc);
    }

    private void initListener() {
        this.fFY.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fFY) {
            if (this.fFZ != null) {
                this.fFZ.bvp();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.fGd, this.fGe);
        } else if (view == this.mClose) {
            if (this.fFZ != null) {
                this.fFZ.bvo();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.fGe);
        }
    }

    public void AF(String str) {
        this.fGa = str;
        if (this.fFW != null) {
            k.a(this.fFW, this.fGa, true, false);
        }
    }

    public void AG(String str) {
        this.fGb = str;
        if (this.fFX != null) {
            this.fFX.setText(this.fGb);
        }
    }

    public void AH(String str) {
        this.fGc = str;
        if (this.fFY != null) {
            this.fFY.setText(this.fGc);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void AI(String str) {
        this.fGd = str;
    }

    public void AJ(String str) {
        this.fGe = str;
    }

    public void a(InterfaceC0495a interfaceC0495a) {
        this.fFZ = interfaceC0495a;
    }
}
