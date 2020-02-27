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
    private HeadImageView fbb;
    private TextView fbc;
    private TextView fbd;
    private InterfaceC0460a fbe;
    private String fbf;
    private String fbg;
    private String fbh;
    private String fbi;
    private String fbj;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0460a {
        void blQ();

        void blR();
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
        this.fbb.setIsRound(true);
        this.fbb.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.fbb.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.fbb = (HeadImageView) findViewById(a.g.user_icon);
        this.fbc = (TextView) findViewById(a.g.invite_txt);
        this.fbd = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.fbb, this.fbf, true, false);
        this.fbc.setText(this.fbg);
        this.fbd.setText(this.fbh);
    }

    private void initListener() {
        this.fbd.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fbd) {
            if (this.fbe != null) {
                this.fbe.blR();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.fbi, this.fbj);
        } else if (view == this.mClose) {
            if (this.fbe != null) {
                this.fbe.blQ();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.fbj);
        }
    }

    public void yW(String str) {
        this.fbf = str;
        if (this.fbb != null) {
            k.a(this.fbb, this.fbf, true, false);
        }
    }

    public void yX(String str) {
        this.fbg = str;
        if (this.fbc != null) {
            this.fbc.setText(this.fbg);
        }
    }

    public void yY(String str) {
        this.fbh = str;
        if (this.fbd != null) {
            this.fbd.setText(this.fbh);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void yZ(String str) {
        this.fbi = str;
    }

    public void za(String str) {
        this.fbj = str;
    }

    public void a(InterfaceC0460a interfaceC0460a) {
        this.fbe = interfaceC0460a;
    }
}
