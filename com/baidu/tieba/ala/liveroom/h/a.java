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
    private HeadImageView fbN;
    private TextView fbO;
    private TextView fbP;
    private InterfaceC0460a fbQ;
    private String fbR;
    private String fbS;
    private String fbT;
    private String fbU;
    private String fbV;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0460a {
        void blY();

        void blZ();
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
        this.fbN.setIsRound(true);
        this.fbN.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.fbN.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.fbN = (HeadImageView) findViewById(a.g.user_icon);
        this.fbO = (TextView) findViewById(a.g.invite_txt);
        this.fbP = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.fbN, this.fbR, true, false);
        this.fbO.setText(this.fbS);
        this.fbP.setText(this.fbT);
    }

    private void initListener() {
        this.fbP.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fbP) {
            if (this.fbQ != null) {
                this.fbQ.blZ();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.fbU, this.fbV);
        } else if (view == this.mClose) {
            if (this.fbQ != null) {
                this.fbQ.blY();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.fbV);
        }
    }

    public void yX(String str) {
        this.fbR = str;
        if (this.fbN != null) {
            k.a(this.fbN, this.fbR, true, false);
        }
    }

    public void yY(String str) {
        this.fbS = str;
        if (this.fbO != null) {
            this.fbO.setText(this.fbS);
        }
    }

    public void yZ(String str) {
        this.fbT = str;
        if (this.fbP != null) {
            this.fbP.setText(this.fbT);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void za(String str) {
        this.fbU = str;
    }

    public void zb(String str) {
        this.fbV = str;
    }

    public void a(InterfaceC0460a interfaceC0460a) {
        this.fbQ = interfaceC0460a;
    }
}
