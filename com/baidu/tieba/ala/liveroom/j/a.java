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
    private HeadImageView gyT;
    private TextView gyU;
    private TextView gyV;
    private InterfaceC0633a gyW;
    private String gyX;
    private String gyY;
    private String gyZ;
    private String gza;
    private String gzb;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0633a {
        void bRE();

        void bRF();
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
        this.gyT.setIsRound(true);
        this.gyT.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.gyT.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.gyT = (HeadImageView) findViewById(a.g.user_icon);
        this.gyU = (TextView) findViewById(a.g.invite_txt);
        this.gyV = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.gyT, this.gyX, true, false);
        this.gyU.setText(this.gyY);
        this.gyV.setText(this.gyZ);
    }

    private void initListener() {
        this.gyV.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gyV) {
            if (this.gyW != null) {
                this.gyW.bRF();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.gza, this.gzb);
        } else if (view == this.mClose) {
            if (this.gyW != null) {
                this.gyW.bRE();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.gzb);
        }
    }

    public void Ga(String str) {
        this.gyX = str;
        if (this.gyT != null) {
            k.a(this.gyT, this.gyX, true, false);
        }
    }

    public void Gb(String str) {
        this.gyY = str;
        if (this.gyU != null) {
            this.gyU.setText(this.gyY);
        }
    }

    public void Gc(String str) {
        this.gyZ = str;
        if (this.gyV != null) {
            this.gyV.setText(this.gyZ);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Gd(String str) {
        this.gza = str;
    }

    public void Ge(String str) {
        this.gzb = str;
    }

    public void a(InterfaceC0633a interfaceC0633a) {
        this.gyW = interfaceC0633a;
    }
}
