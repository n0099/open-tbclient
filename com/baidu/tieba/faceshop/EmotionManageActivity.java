package com.baidu.tieba.faceshop;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionManageActivity extends com.baidu.tieba.j implements com.baidu.tieba.im.messageCenter.g {
    private List<e> a;
    private f c;
    private c d;
    private LinearLayout e;
    private NavigationBar f;
    private ImageView g;
    private TextView h;
    private TextView i;
    private TextView j;
    private ImageView k;
    private BdListView l;
    private TextView m;
    private View n;
    private d o;
    private List<String> b = new LinkedList();
    private boolean p = false;
    private View.OnClickListener q = new a(this);
    private AdapterView.OnItemClickListener r = new b(this);

    public static void a(Context context) {
        context.startActivity(new Intent(context, EmotionManageActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_emotion_manage);
        a();
        b();
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.e.a().a(this);
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f.c(i);
        bs.f((View) this.h, (int) R.drawable.navi_del_text_bg);
    }

    private void a() {
        this.e = (LinearLayout) findViewById(R.id.emotion_manage_root);
        this.f = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f.a(R.string.title_activity_emotion_manage);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, getString(R.string.delete) + "(" + this.b.size() + ")", this.q);
        f();
        this.i = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.q);
        this.j = (TextView) findViewById(R.id.emotion_manager_title);
        this.k = (ImageView) findViewById(R.id.emotion_manage_enter_line_list_up);
        this.l = (BdListView) findViewById(R.id.emotion_manage_list);
        this.l.setOnItemClickListener(this.r);
        this.n = LayoutInflater.from(this).inflate(R.layout.emotion_manage_list_footer, (ViewGroup) null);
        this.l.addFooterView(this.n);
        this.m = (TextView) this.n.findViewById(R.id.emotion_manage_enter_record);
        this.m.setOnClickListener(this.q);
        getLayoutMode().a(TiebaApplication.h().al() == 1);
        getLayoutMode().a((View) this.e);
        getLayoutMode().a(this.n);
        e();
    }

    private void b() {
        com.baidu.tieba.im.messageCenter.e.a().a(-120, this);
        this.c = new f(this, null);
        this.c.execute(new String[0]);
        this.o = new d(this, null);
        this.l.setAdapter((ListAdapter) this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        if (z) {
            this.b.clear();
        } else {
            for (String str : this.b) {
                Iterator<e> it = this.a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z2 = false;
                        break;
                    } else if (str.equals(it.next().a)) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    this.b.remove(str);
                }
            }
        }
        f();
        c();
        this.o.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.a != null) {
            if (this.a.size() == 0) {
                this.j.setText(R.string.emotion_manage_title_nodata);
                this.i.setEnabled(false);
                this.k.setVisibility(8);
                e();
                return;
            }
            this.j.setText(R.string.emotion_manage_title);
            this.i.setEnabled(true);
            this.k.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (!this.b.contains(str)) {
            this.b.add(str);
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        this.b.remove(str);
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        this.g.setVisibility(8);
        this.h.setVisibility(0);
        f();
        this.i.setText(getString(R.string.cancel));
        this.p = true;
        this.n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.g.setVisibility(0);
        this.h.setVisibility(8);
        this.i.setText(getString(R.string.edit));
        this.p = false;
        this.n.setVisibility(0);
    }

    private void f() {
        int size = this.b.size();
        int al = TiebaApplication.h().al();
        this.h.setText(getString(R.string.delete) + "(" + size + ")");
        if (size == 0) {
            this.h.setEnabled(false);
            if (al == 1) {
                this.h.setTextColor(getResources().getColor(R.color.emotion_manage_del_disable_1));
                return;
            } else {
                this.h.setTextColor(getResources().getColor(R.color.emotion_manage_del_disable));
                return;
            }
        }
        this.h.setEnabled(true);
        if (al == 1) {
            this.h.setTextColor(getResources().getColor(R.color.emotion_manage_del_enable_1));
        } else {
            this.h.setTextColor(getResources().getColor(R.color.emotion_manage_del_enable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.d = new c(this, null);
        this.d.execute(this.b);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.p) {
            e();
            this.b.clear();
            this.p = false;
            this.o.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        if (qVar.w() == -120) {
            this.c = new f(this, null);
            this.c.execute(new String[0]);
        }
    }
}
