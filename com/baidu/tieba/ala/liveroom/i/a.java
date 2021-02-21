package com.baidu.tieba.ala.liveroom.i;

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
    private HeadImageView hDg;
    private TextView hDh;
    private TextView hDi;
    private InterfaceC0667a hDj;
    private String hDk;
    private String hDl;
    private String hDm;
    private String hDn;
    private String hDo;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0667a {
        void cfi();

        void cfj();
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
        this.hDg.setIsRound(true);
        this.hDg.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.d.sdk_ds2));
        this.hDg.setBorderColor(getContext().getResources().getColor(a.c.sdk_white_alpha100));
    }

    private void initView() {
        this.hDg = (HeadImageView) findViewById(a.f.user_icon);
        this.hDh = (TextView) findViewById(a.f.invite_txt);
        this.hDi = (TextView) findViewById(a.f.go_to_client);
        this.mClose = findViewById(a.f.close);
        m.a(this.hDg, this.hDk, true, false);
        this.hDh.setText(this.hDl);
        this.hDi.setText(this.hDm);
    }

    private void initListener() {
        this.hDi.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hDi) {
            if (this.hDj != null) {
                this.hDj.cfj();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.hDn, this.hDo);
        } else if (view == this.mClose) {
            if (this.hDj != null) {
                this.hDj.cfi();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.hDo);
        }
    }

    public void HK(String str) {
        this.hDk = str;
        if (this.hDg != null) {
            m.a(this.hDg, this.hDk, true, false);
        }
    }

    public void HL(String str) {
        this.hDl = str;
        if (this.hDh != null) {
            this.hDh.setText(this.hDl);
        }
    }

    public void HM(String str) {
        this.hDm = str;
        if (this.hDi != null) {
            this.hDi.setText(this.hDm);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void HN(String str) {
        this.hDn = str;
    }

    public void HO(String str) {
        this.hDo = str;
    }

    public void a(InterfaceC0667a interfaceC0667a) {
        this.hDj = interfaceC0667a;
    }
}
