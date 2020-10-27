package com.baidu.tieba.ala.liveroom.j;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.l;
/* loaded from: classes4.dex */
public class a extends Dialog implements View.OnClickListener {
    private HeadImageView hck;
    private TextView hcl;
    private TextView hcm;
    private InterfaceC0663a hcn;
    private String hco;
    private String hcp;
    private String hcq;
    private String hcr;
    private String hcs;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0663a {
        void bZs();

        void bZt();
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
        this.hck.setIsRound(true);
        this.hck.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.hck.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.hck = (HeadImageView) findViewById(a.g.user_icon);
        this.hcl = (TextView) findViewById(a.g.invite_txt);
        this.hcm = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        l.a(this.hck, this.hco, true, false);
        this.hcl.setText(this.hcp);
        this.hcm.setText(this.hcq);
    }

    private void initListener() {
        this.hcm.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hcm) {
            if (this.hcn != null) {
                this.hcn.bZt();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hcr, this.hcs);
        } else if (view == this.mClose) {
            if (this.hcn != null) {
                this.hcn.bZs();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hcs);
        }
    }

    public void HJ(String str) {
        this.hco = str;
        if (this.hck != null) {
            l.a(this.hck, this.hco, true, false);
        }
    }

    public void HK(String str) {
        this.hcp = str;
        if (this.hcl != null) {
            this.hcl.setText(this.hcp);
        }
    }

    public void HL(String str) {
        this.hcq = str;
        if (this.hcm != null) {
            this.hcm.setText(this.hcq);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void HM(String str) {
        this.hcr = str;
    }

    public void HN(String str) {
        this.hcs = str;
    }

    public void a(InterfaceC0663a interfaceC0663a) {
        this.hcn = interfaceC0663a;
    }
}
