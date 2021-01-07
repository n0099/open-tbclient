package com.baidu.tieba.ala.liveroom.j;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.m;
/* loaded from: classes11.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView hDn;
    private TextView hDo;
    private TextView hDp;
    private InterfaceC0683a hDq;
    private String hDr;
    private String hDs;
    private String hDt;
    private String hDu;
    private String hDv;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0683a {
        void chY();

        void chZ();
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
        this.hDn.setIsRound(true);
        this.hDn.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hDn.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hDn = (HeadImageView) findViewById(a.f.user_icon);
        this.hDo = (TextView) findViewById(a.f.invite_txt);
        this.hDp = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        m.a(this.hDn, this.hDr, true, false);
        this.hDo.setText(this.hDs);
        this.hDp.setText(this.hDt);
    }

    private void initListener() {
        this.hDp.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hDp) {
            if (this.hDq != null) {
                this.hDq.chZ();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hDu, this.hDv);
        } else if (view == this.mClose) {
            if (this.hDq != null) {
                this.hDq.chY();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hDv);
        }
    }

    public void Iq(String str) {
        this.hDr = str;
        if (this.hDn != null) {
            m.a(this.hDn, this.hDr, true, false);
        }
    }

    public void Ir(String str) {
        this.hDs = str;
        if (this.hDo != null) {
            this.hDo.setText(this.hDs);
        }
    }

    public void Is(String str) {
        this.hDt = str;
        if (this.hDp != null) {
            this.hDp.setText(this.hDt);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void It(String str) {
        this.hDu = str;
    }

    public void Iu(String str) {
        this.hDv = str;
    }

    public void a(InterfaceC0683a interfaceC0683a) {
        this.hDq = interfaceC0683a;
    }
}
