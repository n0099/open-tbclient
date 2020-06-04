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
    private HeadImageView fUh;
    private TextView fUi;
    private TextView fUj;
    private InterfaceC0563a fUk;
    private String fUl;
    private String fUm;
    private String fUn;
    private String fUo;
    private String fUp;
    private View mClose;
    private long roomId;

    /* renamed from: com.baidu.tieba.ala.liveroom.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0563a {
        void bBn();

        void bBo();
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
        this.fUh.setIsRound(true);
        this.fUh.setBorderWidth(getContext().getResources().getDimensionPixelSize(a.e.sdk_ds2));
        this.fUh.setBorderColor(getContext().getResources().getColor(a.d.sdk_white_alpha100));
    }

    private void initView() {
        this.fUh = (HeadImageView) findViewById(a.g.user_icon);
        this.fUi = (TextView) findViewById(a.g.invite_txt);
        this.fUj = (TextView) findViewById(a.g.go_to_client);
        this.mClose = findViewById(a.g.close);
        k.a(this.fUh, this.fUl, true, false);
        this.fUi.setText(this.fUm);
        this.fUj.setText(this.fUn);
    }

    private void initListener() {
        this.fUj.setOnClickListener(this);
        this.mClose.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fUj) {
            if (this.fUk != null) {
                this.fUk.bBo();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doClickGuideFloatDialogLog(this.roomId + "", this.fUo, this.fUp);
        } else if (view == this.mClose) {
            if (this.fUk != null) {
                this.fUk.bBn();
            }
            dismiss();
            LogManager.getFeedDiversionLogger().doCloseGuideFloatDialogLog(this.roomId + "", this.fUp);
        }
    }

    public void Cq(String str) {
        this.fUl = str;
        if (this.fUh != null) {
            k.a(this.fUh, this.fUl, true, false);
        }
    }

    public void Cr(String str) {
        this.fUm = str;
        if (this.fUi != null) {
            this.fUi.setText(this.fUm);
        }
    }

    public void Cs(String str) {
        this.fUn = str;
        if (this.fUj != null) {
            this.fUj.setText(this.fUn);
        }
    }

    public void setRoomId(long j) {
        this.roomId = j;
    }

    public void Ct(String str) {
        this.fUo = str;
    }

    public void Cu(String str) {
        this.fUp = str;
    }

    public void a(InterfaceC0563a interfaceC0563a) {
        this.fUk = interfaceC0563a;
    }
}
