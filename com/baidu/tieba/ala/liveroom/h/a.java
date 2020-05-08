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
    private HeadImageView fGb;
    private TextView fGc;
    private TextView fGd;
    private InterfaceC0516a fGe;
    private String fGf;
    private String fGg;
    private String fGh;
    private String fGi;
    private String fGj;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0516a {
        void bvm();

        void bvn();
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
        this.fGb.setIsRound(true);
        this.fGb.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.fGb.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.fGb = (HeadImageView) findViewById(a.g.user_icon);
        this.fGc = (TextView) findViewById(a.g.invite_txt);
        this.fGd = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.fGb, this.fGf, true, false);
        this.fGc.setText(this.fGg);
        this.fGd.setText(this.fGh);
    }

    private void initListener() {
        this.fGd.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fGd) {
            if (this.fGe != null) {
                this.fGe.bvn();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.fGi, this.fGj);
        } else if (view == this.mClose) {
            if (this.fGe != null) {
                this.fGe.bvm();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.fGj);
        }
    }

    public void AI(String str) {
        this.fGf = str;
        if (this.fGb != null) {
            k.a(this.fGb, this.fGf, true, false);
        }
    }

    public void AJ(String str) {
        this.fGg = str;
        if (this.fGc != null) {
            this.fGc.setText(this.fGg);
        }
    }

    public void AK(String str) {
        this.fGh = str;
        if (this.fGd != null) {
            this.fGd.setText(this.fGh);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void AL(String str) {
        this.fGi = str;
    }

    public void AM(String str) {
        this.fGj = str;
    }

    public void a(InterfaceC0516a interfaceC0516a) {
        this.fGe = interfaceC0516a;
    }
}
