package com.baidu.tieba.home;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.more.AboutActivity;
import com.baidu.tieba.more.AccountActivity;
import com.baidu.tieba.write.WriteActivity;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class HomeActivity extends com.baidu.tieba.e {
    private ListView d = null;
    private ProgressBar e = null;
    private f f = null;
    private s g = null;
    private com.baidu.tieba.b.f h = null;
    private t i = null;
    private AlertDialog j = null;
    private DialogInterface.OnClickListener k = null;
    private com.baidu.tieba.a.ac l = null;
    private r m = null;
    AlertDialog b = null;
    AlertDialog c = null;
    private Boolean n = false;
    private DialogInterface.OnClickListener o = new i(this);
    private View.OnClickListener p = new j(this);
    private View.OnClickListener q = new k(this);
    private View.OnClickListener r = new l(this);
    private View.OnLongClickListener s = new m(this);
    private View.OnKeyListener t = new n(this);

    private void i() {
        this.d = (ListView) findViewById(R.id.enter_forum_lv_forum);
        this.f = new f(this, null);
        this.f.a(this.r);
        this.f.a(this.s);
        this.f.b(this.q);
        this.f.c(this.p);
        this.d.setAdapter((ListAdapter) this.f);
        this.d.setOnKeyListener(this.t);
        this.d.setOnItemClickListener(new o(this));
        CharSequence[] charSequenceArr = {getString(R.string.enter_forum), getString(R.string.delete)};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.operation));
        builder.setItems(charSequenceArr, this.o);
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
        CharSequence[] charSequenceArr2 = {getString(R.string.enter_forum), getString(R.string.delete)};
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle(getString(R.string.operation));
        builder2.setItems(charSequenceArr2, this.o);
        this.c = builder2.create();
        this.c.setCanceledOnTouchOutside(true);
        this.e = (ProgressBar) findViewById(R.id.enter_forum_progress);
        this.e.setVisibility(8);
        ((Button) findViewById(R.id.refresh)).setOnClickListener(new p(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.l != null) {
            if (this.l.d() != 1) {
                if (this.i == null) {
                    this.i = new t(this, this.l);
                    this.i.execute(new com.baidu.tieba.a.ac[0]);
                    return;
                }
                return;
            }
            if (this.j == null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getParent());
                builder.setTitle(R.string.alerm_title);
                builder.setIcon(R.drawable.dialogue_quit);
                builder.setMessage(R.string.delete_like_info);
                this.k = new q(this);
                builder.setPositiveButton(getString(R.string.confirm), this.k);
                builder.setNegativeButton(getString(R.string.cancel), this.k);
                this.j = builder.create();
            }
            this.j.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            if (this.h != null) {
                if (this.h.d() == null || this.h.d().size() == 0) {
                    this.d.setBackgroundColor(getResources().getColor(R.color.enter_forum_bg_nodata_color));
                } else {
                    this.d.setBackgroundColor(getResources().getColor(R.color.enter_forum_bg_normal_color));
                }
                this.f.a(this.h);
                this.f.a(this.n);
                this.f.notifyDataSetChanged();
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "refresh", e.getMessage());
        }
    }

    public void a(boolean z) {
        this.n = Boolean.valueOf((TiebaApplication.u() == null || TiebaApplication.x() == null) ? false : true);
        if (!z) {
            String b = this.n.booleanValue() ? com.baidu.tieba.c.k.b() : com.baidu.tieba.c.k.f("0");
            if (b != null && b.length() > 0) {
                com.baidu.tieba.b.f fVar = new com.baidu.tieba.b.f();
                fVar.a(b);
                if (fVar.a()) {
                    com.baidu.tieba.c.ae.a("Like_Recommend_AsyncTask", "doInBackground", "cache data.size: " + String.valueOf(b.length()));
                    this.h = fVar;
                    k();
                    return;
                }
                com.baidu.tieba.c.ae.a("Like_Recommend_AsyncTask", "doInBackground", "cache data format err");
                if (this.n.booleanValue()) {
                    com.baidu.tieba.c.k.a();
                } else {
                    com.baidu.tieba.c.k.e("0");
                }
            }
        }
        if (this.g != null) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        stringBuffer.append("c/f/forum/favocommend");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("ctime", String.valueOf(System.currentTimeMillis())));
        h();
        this.g = new s(this, stringBuffer.toString(), arrayList);
        this.g.execute(stringBuffer.toString());
    }

    public void g() {
        if (this.b != null) {
            this.b.dismiss();
        }
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    public void h() {
        if (this.g != null) {
            this.g.a();
            this.g = null;
        }
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
    }

    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.home_activity);
        i();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, getString(R.string.setup)).setIcon(R.drawable.menu_setup);
        if (!TiebaApplication.f()) {
            menu.add(0, 2, 2, getString(R.string.account)).setIcon(R.drawable.menu_account);
        }
        menu.add(0, 3, 3, getString(R.string.feedback)).setIcon(R.drawable.menu_feedback);
        menu.add(0, 4, 4, getString(R.string.about)).setIcon(R.drawable.menu_about);
        menu.add(0, 5, 5, getString(R.string.quit)).setIcon(R.drawable.menu_quit);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        this.e.setVisibility(8);
        this.f.a();
        super.onDestroy();
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
                WriteActivity.a(this, com.baidu.tieba.a.h.f(), com.baidu.tieba.a.h.e(), bVar);
                break;
            case 4:
                AboutActivity.a(this);
                break;
            case 5:
                com.baidu.tieba.c.ag.a((Activity) this);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        try {
            menu.findItem(1).setVisible(true);
            if (!TiebaApplication.f()) {
                menu.findItem(2).setVisible(true);
            }
            menu.findItem(3).setVisible(true);
            menu.findItem(4).setVisible(true);
            menu.findItem(5).setVisible(true);
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b("HomeActivity", "onPrepareOptionsMenu", "exp: " + e.toString());
        }
        return super.onPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        a(false);
    }
}
