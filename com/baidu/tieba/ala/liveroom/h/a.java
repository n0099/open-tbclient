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
    private HeadImageView fbc;
    private TextView fbd;
    private TextView fbe;
    private InterfaceC0460a fbf;
    private String fbg;
    private String fbh;
    private String fbi;
    private String fbj;
    private String fbk;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0460a {
        void blS();

        void blT();
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
        this.fbc.setIsRound(true);
        this.fbc.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.fbc.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.fbc = (HeadImageView) findViewById(a.g.user_icon);
        this.fbd = (TextView) findViewById(a.g.invite_txt);
        this.fbe = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.fbc, this.fbg, true, false);
        this.fbd.setText(this.fbh);
        this.fbe.setText(this.fbi);
    }

    private void initListener() {
        this.fbe.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fbe) {
            if (this.fbf != null) {
                this.fbf.blT();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.fbj, this.fbk);
        } else if (view == this.mClose) {
            if (this.fbf != null) {
                this.fbf.blS();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.fbk);
        }
    }

    public void yW(String str) {
        this.fbg = str;
        if (this.fbc != null) {
            k.a(this.fbc, this.fbg, true, false);
        }
    }

    public void yX(String str) {
        this.fbh = str;
        if (this.fbd != null) {
            this.fbd.setText(this.fbh);
        }
    }

    public void yY(String str) {
        this.fbi = str;
        if (this.fbe != null) {
            this.fbe.setText(this.fbi);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void yZ(String str) {
        this.fbj = str;
    }

    public void za(String str) {
        this.fbk = str;
    }

    public void a(InterfaceC0460a interfaceC0460a) {
        this.fbf = interfaceC0460a;
    }
}
