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
    private HeadImageView gCe;
    private TextView gCf;
    private TextView gCg;
    private InterfaceC0629a gCh;
    private String gCi;
    private String gCj;
    private String gCk;
    private String gCl;
    private String gCm;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0629a {
        void bTa();

        void bTb();
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
        this.gCe.setIsRound(true);
        this.gCe.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.gCe.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.gCe = (HeadImageView) findViewById(a.g.user_icon);
        this.gCf = (TextView) findViewById(a.g.invite_txt);
        this.gCg = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        l.a(this.gCe, this.gCi, true, false);
        this.gCf.setText(this.gCj);
        this.gCg.setText(this.gCk);
    }

    private void initListener() {
        this.gCg.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gCg) {
            if (this.gCh != null) {
                this.gCh.bTb();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.gCl, this.gCm);
        } else if (view == this.mClose) {
            if (this.gCh != null) {
                this.gCh.bTa();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.gCm);
        }
    }

    public void Gy(String str) {
        this.gCi = str;
        if (this.gCe != null) {
            l.a(this.gCe, this.gCi, true, false);
        }
    }

    public void Gz(String str) {
        this.gCj = str;
        if (this.gCf != null) {
            this.gCf.setText(this.gCj);
        }
    }

    public void GA(String str) {
        this.gCk = str;
        if (this.gCg != null) {
            this.gCg.setText(this.gCk);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void GB(String str) {
        this.gCl = str;
    }

    public void GC(String str) {
        this.gCm = str;
    }

    public void a(InterfaceC0629a interfaceC0629a) {
        this.gCh = interfaceC0629a;
    }
}
