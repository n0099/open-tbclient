package com.baidu.tieba.ala.liveroom.i;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.k;
/* loaded from: classes3.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView gha;
    private TextView ghb;
    private TextView ghc;
    private InterfaceC0572a ghd;
    private String ghe;
    private String ghf;
    private String ghg;
    private String ghh;
    private String ghi;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0572a {
        void bEt();

        void bEu();
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
        this.gha.setIsRound(true);
        this.gha.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.gha.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.gha = (HeadImageView) findViewById(a.g.user_icon);
        this.ghb = (TextView) findViewById(a.g.invite_txt);
        this.ghc = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.gha, this.ghe, true, false);
        this.ghb.setText(this.ghf);
        this.ghc.setText(this.ghg);
    }

    private void initListener() {
        this.ghc.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ghc) {
            if (this.ghd != null) {
                this.ghd.bEu();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.ghh, this.ghi);
        } else if (view == this.mClose) {
            if (this.ghd != null) {
                this.ghd.bEt();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.ghi);
        }
    }

    public void CP(String str) {
        this.ghe = str;
        if (this.gha != null) {
            k.a(this.gha, this.ghe, true, false);
        }
    }

    public void CQ(String str) {
        this.ghf = str;
        if (this.ghb != null) {
            this.ghb.setText(this.ghf);
        }
    }

    public void CR(String str) {
        this.ghg = str;
        if (this.ghc != null) {
            this.ghc.setText(this.ghg);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void CS(String str) {
        this.ghh = str;
    }

    public void CT(String str) {
        this.ghi = str;
    }

    public void a(InterfaceC0572a interfaceC0572a) {
        this.ghd = interfaceC0572a;
    }
}
