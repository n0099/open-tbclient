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
    private HeadImageView fbp;
    private TextView fbq;
    private TextView fbr;
    private InterfaceC0460a fbs;
    private String fbt;
    private String fbu;
    private String fbv;
    private String fbw;
    private String fbx;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0460a {
        void blT();

        void blU();
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
        this.fbp.setIsRound(true);
        this.fbp.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.fbp.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.fbp = (HeadImageView) findViewById(a.g.user_icon);
        this.fbq = (TextView) findViewById(a.g.invite_txt);
        this.fbr = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.fbp, this.fbt, true, false);
        this.fbq.setText(this.fbu);
        this.fbr.setText(this.fbv);
    }

    private void initListener() {
        this.fbr.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fbr) {
            if (this.fbs != null) {
                this.fbs.blU();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.fbw, this.fbx);
        } else if (view == this.mClose) {
            if (this.fbs != null) {
                this.fbs.blT();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.fbx);
        }
    }

    public void yX(String str) {
        this.fbt = str;
        if (this.fbp != null) {
            k.a(this.fbp, this.fbt, true, false);
        }
    }

    public void yY(String str) {
        this.fbu = str;
        if (this.fbq != null) {
            this.fbq.setText(this.fbu);
        }
    }

    public void yZ(String str) {
        this.fbv = str;
        if (this.fbr != null) {
            this.fbr.setText(this.fbv);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void za(String str) {
        this.fbw = str;
    }

    public void zb(String str) {
        this.fbx = str;
    }

    public void a(InterfaceC0460a interfaceC0460a) {
        this.fbs = interfaceC0460a;
    }
}
