package com.baidu.tieba.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.write.WriteActivity;
import com.baidu.zeus.Headers;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class HomeActivity extends com.baidu.tieba.e {
    private ListView j = null;
    private ProgressBar k = null;
    private f l = null;
    private x m = null;
    private com.baidu.tieba.b.f n = null;
    private z o = null;
    private AlertDialog p = null;
    private DialogInterface.OnClickListener q = null;
    private com.baidu.tieba.a.y r = null;
    private w s = null;
    AlertDialog c = null;
    AlertDialog d = null;
    private Boolean t = false;
    RelativeLayout e = null;
    RelativeLayout f = null;
    Button g = null;
    TextView h = null;
    FrameLayout i = null;
    private y u = null;
    private DialogInterface.OnClickListener v = new n(this);
    private View.OnClickListener w = new o(this);
    private View.OnClickListener x = new p(this);
    private View.OnClickListener y = new q(this);
    private View.OnLongClickListener z = new r(this);
    private View.OnKeyListener A = new s(this);

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_activity);
        k();
        l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onStop() {
        View findViewById = this.j.findViewById(R.id.lottery_image);
        if (findViewById != null && (findViewById instanceof ImageView)) {
            ((ImageView) findViewById).setImageResource(0);
        }
        super.onStop();
    }

    private void k() {
        this.u = new y(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.lottery");
        registerReceiver(this.u, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        View findViewById = this.j.findViewById(R.id.lottery_image);
        if (findViewById != null && (findViewById instanceof ImageView) && findViewById.getVisibility() == 0) {
            ((ImageView) findViewById).setImageResource(R.drawable.banner_image);
        }
        a(false);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.g()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.g()) {
            menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        }
        menu.add(0, 3, 3, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback);
        menu.add(0, 4, 4, getString(R.string.about)).setIcon(R.drawable.menu_about);
        menu.add(0, 5, 5, getString(R.string.quit)).setIcon(R.drawable.menu_quit);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 1:
                MainTabActivity.a(this, "goto_more");
                break;
            case 2:
                AccountActivity.a(this);
                break;
            case 3:
                com.baidu.tieba.a.b bVar = new com.baidu.tieba.a.b();
                bVar.a(1);
                WriteActivity.a(this, com.baidu.tieba.a.i.f(), com.baidu.tieba.a.i.e(), bVar);
                break;
            case 4:
                AboutActivity.a(this);
                break;
            case 5:
                com.baidu.tieba.c.ai.a((Activity) this);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        this.k.setVisibility(8);
        this.l.a();
        if (this.u != null) {
            unregisterReceiver(this.u);
        }
        super.onDestroy();
    }

    public void i() {
        if (this.c != null) {
            this.c.dismiss();
        }
        if (this.d != null) {
            this.d.dismiss();
        }
    }

    private void l() {
        this.e = (RelativeLayout) findViewById(R.id.container);
        this.f = (RelativeLayout) findViewById(R.id.title);
        this.g = (Button) findViewById(R.id.refresh);
        this.h = (TextView) findViewById(R.id.titel_text);
        this.i = (FrameLayout) findViewById(R.id.lv_container);
        this.j = (ListView) findViewById(R.id.enter_forum_lv_forum);
        this.l = new f(this, null);
        this.l.a(this.y);
        this.l.a(this.z);
        this.l.b(this.x);
        this.l.c(this.w);
        this.j.setAdapter((ListAdapter) this.l);
        this.j.setOnKeyListener(this.A);
        this.j.setOnItemClickListener(new t(this));
        CharSequence[] charSequenceArr = {getString(R.string.enter_forum), getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(charSequenceArr, this.v);
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {getString(R.string.enter_forum), getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle(getString(R.string.operation));
        builder2.setItems(charSequenceArr2, this.v);
        this.d = builder2.create();
        this.d.setCanceledOnTouchOutside(true);
        this.k = (ProgressBar) findViewById(R.id.enter_forum_progress);
        this.k.setVisibility(8);
        ((Button) findViewById(R.id.refresh)).setOnClickListener(new u(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ae.c(this.h, i);
        com.baidu.tieba.c.ae.a(this.e, i);
        com.baidu.tieba.c.ae.c(this.f, i);
        com.baidu.tieba.c.ae.e((View) this.g, i);
        com.baidu.tieba.c.ae.a((View) this.j, i);
        com.baidu.tieba.c.ae.a(this.j, i);
        if (i == 1) {
            this.i.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
        } else {
            this.i.setBackgroundColor(15856113);
        }
    }

    public void j() {
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
        if (this.o != null) {
            this.o.a();
            this.o = null;
        }
        if (this.s != null) {
            this.s.a();
            this.s = null;
        }
    }

    public void a(boolean z) {
        String f;
        this.t = Boolean.valueOf((TiebaApplication.x() == null || TiebaApplication.B() == null) ? false : true);
        if (!z) {
            if (this.t.booleanValue()) {
                f = com.baidu.tieba.c.k.b();
            } else {
                f = com.baidu.tieba.c.k.f("0");
            }
            if (f != null && f.length() > 0) {
                com.baidu.tieba.b.f fVar = new com.baidu.tieba.b.f();
                fVar.a(f);
                if (!fVar.a()) {
                    com.baidu.tieba.c.ag.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                    if (this.t.booleanValue()) {
                        com.baidu.tieba.c.k.a();
                    } else {
                        com.baidu.tieba.c.k.e("0");
                    }
                } else {
                    com.baidu.tieba.c.ag.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(f.length()));
                    this.n = fVar;
                    n();
                    return;
                }
            }
        }
        if (this.m == null) {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/f/forum/favocommend");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis())));
            j();
            this.m = new x(this, stringBuffer.toString(), arrayList);
            this.m.execute(stringBuffer.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.r != null) {
            if (this.r.d() == 1) {
                if (this.p == null) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
                    builder.setTitle(R.string.alerm_title);
                    builder.setIcon(R.drawable.dialogue_quit);
                    builder.setMessage(R.string.delete_like_info);
                    this.q = new v(this);
                    builder.setPositiveButton(getString(R.string.confirm), this.q);
                    builder.setNegativeButton(getString(R.string.cancel), this.q);
                    this.p = builder.create();
                }
                this.p.show();
            } else if (this.o == null) {
                this.o = new z(this, this.r);
                this.o.execute(new com.baidu.tieba.a.y[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            if (this.n != null) {
                if (this.n.d() == null || this.n.d().size() == 0) {
                    if (this.b == 1) {
                        this.j.setBackgroundColor(-14145496);
                    } else {
                        this.j.setBackgroundColor(getResources().getColor(R.color.enter_forum_bg_nodata_color));
                    }
                } else if (this.b == 1) {
                    this.j.setBackgroundColor(getResources().getColor(R.color.skin_1_common_bg));
                } else {
                    this.j.setBackgroundColor(getResources().getColor(R.color.enter_forum_bg_normal_color));
                }
                this.l.a(this.n);
                this.l.a(this.t);
                this.l.notifyDataSetChanged();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), Headers.REFRESH, e.getMessage());
        }
    }
}
