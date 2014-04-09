package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.UpdateDialog;
/* loaded from: classes.dex */
public class ReLoginShareActivity extends com.baidu.tbadk.a {
    private static Activity l = null;
    private NavigationBar k;
    private Button b = null;
    private Button c = null;
    private TextView d = null;
    private ProgressBar e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private com.baidu.tbadk.coreExtra.view.p i = null;
    LinearLayout a = null;
    private boolean j = false;
    private final View.OnClickListener m = new x(this);
    private final com.baidu.tbadk.core.a.u n = new y(this);

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001002, new w());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.relogin_activity);
        Intent intent = getIntent();
        this.f = intent.getStringExtra("user_name");
        this.g = intent.getStringExtra("bduss");
        this.h = intent.getStringExtra("ptoken");
        this.k = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b = (Button) findViewById(com.baidu.tieba.a.h.relogin_retry_button);
        this.b.setOnClickListener(this.m);
        this.c = (Button) findViewById(com.baidu.tieba.a.h.relogin_cacel_button);
        this.c.setOnClickListener(this.m);
        this.e = (ProgressBar) findViewById(com.baidu.tieba.a.h.relogin_progressbar);
        this.d = (TextView) findViewById(com.baidu.tieba.a.h.relogin_textview);
        this.a = (LinearLayout) findViewById(com.baidu.tieba.a.h.container);
        a();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f = bundle.getString("user_name");
        this.g = bundle.getString("bduss");
        this.h = bundle.getString("ptoken");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("user_name", this.f);
        bundle.putString("bduss", this.g);
        bundle.putString("ptoken", this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a(0, this.f, null);
        this.k.b(i);
        ba.a((TextView) this.c, i);
        ba.a(this.a, i);
        ba.b(this.d, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, AccountData accountData) {
        String str2;
        if (str == null) {
            str = "";
        }
        switch (i) {
            case 0:
                this.b.setVisibility(8);
                this.e.setVisibility(0);
                String string = getString(com.baidu.tieba.a.k.relogin_statement);
                int indexOf = string.indexOf("?");
                String replace = string.replace("?", str);
                this.d.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.d.setText(replace);
                    return;
                }
                SpannableString spannableString = new SpannableString(replace);
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb((int) MotionEventCompat.ACTION_MASK, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.d.setText(spannableString);
                return;
            case 1:
                this.b.setVisibility(0);
                this.e.setVisibility(8);
                String string2 = getString(com.baidu.tieba.a.k.relogin_fail);
                this.d.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.d.setText(string2);
                    return;
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(str2) + str);
                int length = (String.valueOf(string2) + "\n\n").length();
                if (this.mSkinType == 1) {
                    spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(com.baidu.tieba.a.e.skin_1_common_color)), 0, length, 33);
                }
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb((int) MotionEventCompat.ACTION_MASK, 47, 47)), length, str.length() + length, 33);
                spannableString2.setSpan(new RelativeSizeSpan(0.9f), length, str.length() + length, 33);
                this.d.setText(spannableString2);
                return;
            case 2:
                if (this.i == null) {
                    this.i = new com.baidu.tbadk.coreExtra.view.p(this);
                    this.i.a(new z(this));
                    this.i.b(new aa(this));
                }
                this.i.e();
                this.i.a("");
                this.i.a(accountData);
                this.i.a();
                this.e.setVisibility(4);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(ReLoginShareActivity reLoginShareActivity) {
        if (!TextUtils.isEmpty(TbadkApplication.E())) {
            com.baidu.tbadk.core.a.o.a();
            TbadkApplication.a((AccountData) null, reLoginShareActivity.getBaseContext());
        }
        reLoginShareActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.g != null && this.h != null) {
            this.j = false;
            com.baidu.tbadk.core.a.t.b(this.f, this.g, this.h, this.n, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ReLoginShareActivity reLoginShareActivity, AccountData accountData) {
        if (!reLoginShareActivity.j) {
            com.baidu.tbadk.core.a.o.a(accountData);
            TbadkApplication.a(accountData, reLoginShareActivity.getBaseContext());
        }
        TbadkApplication.j();
        TbadkApplication.M();
        if (l != null) {
            l.finish();
        }
        if (TbadkApplication.j().T()) {
            reLoginShareActivity.sendMessage(new com.baidu.adp.framework.message.a(2015000, new com.baidu.tbadk.core.b.p(reLoginShareActivity).a("from_logo_page")));
        } else {
            int intExtra = reLoginShareActivity.getIntent().getIntExtra("locate_type", -1);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
            com.baidu.adp.framework.c.a().a(new CustomResponsedMessage(2007005, null));
            com.baidu.tbadk.core.d.b.a(reLoginShareActivity, intExtra, false);
        }
        if (com.baidu.tieba.p.c().w() && com.baidu.tieba.p.c().y() != null) {
            com.baidu.tieba.p.c();
            UpdateDialog.a(com.baidu.tieba.p.d(), com.baidu.tieba.p.c().y(), com.baidu.tieba.p.c().x());
        }
        reLoginShareActivity.finish();
    }
}
