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
    private InterfaceC0647a gQA;
    private String gQB;
    private String gQC;
    private String gQD;
    private String gQE;
    private String gQF;
    private HeadImageView gQx;
    private TextView gQy;
    private TextView gQz;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0647a {
        void bWt();

        void bWu();
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
        this.gQx.setIsRound(true);
        this.gQx.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.gQx.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.gQx = (HeadImageView) findViewById(a.g.user_icon);
        this.gQy = (TextView) findViewById(a.g.invite_txt);
        this.gQz = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        l.a(this.gQx, this.gQB, true, false);
        this.gQy.setText(this.gQC);
        this.gQz.setText(this.gQD);
    }

    private void initListener() {
        this.gQz.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gQz) {
            if (this.gQA != null) {
                this.gQA.bWu();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.gQE, this.gQF);
        } else if (view == this.mClose) {
            if (this.gQA != null) {
                this.gQA.bWt();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.gQF);
        }
    }

    public void Hk(String str) {
        this.gQB = str;
        if (this.gQx != null) {
            l.a(this.gQx, this.gQB, true, false);
        }
    }

    public void Hl(String str) {
        this.gQC = str;
        if (this.gQy != null) {
            this.gQy.setText(this.gQC);
        }
    }

    public void Hm(String str) {
        this.gQD = str;
        if (this.gQz != null) {
            this.gQz.setText(this.gQD);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Hn(String str) {
        this.gQE = str;
    }

    public void Ho(String str) {
        this.gQF = str;
    }

    public void a(InterfaceC0647a interfaceC0647a) {
        this.gQA = interfaceC0647a;
    }
}
