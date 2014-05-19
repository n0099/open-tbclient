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
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionManageActivity extends BaseActivity {
    private List<v> a;
    private w c;
    private t d;
    private LinearLayout e;
    private NavigationBar f;
    private View g;
    private TextView h;
    private TextView i;
    private TextView j;
    private ImageView k;
    private BdListView l;
    private TextView m;
    private View n;
    private u o;
    private final List<String> b = new LinkedList();
    private boolean p = false;
    private final View.OnClickListener q = new q(this);
    private final AdapterView.OnItemClickListener r = new r(this);
    private final CustomMessageListener s = new s(this, 0);

    public static void a(Context context) {
        context.startActivity(new Intent(context, EmotionManageActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.s.activity_emotion_manage);
        a();
        b();
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f.c(i);
        com.baidu.tbadk.core.util.bc.f((View) this.h, com.baidu.tieba.q.navi_del_text_bg);
    }

    private void a() {
        this.e = (LinearLayout) findViewById(com.baidu.tieba.r.emotion_manage_root);
        this.f = (NavigationBar) findViewById(com.baidu.tieba.r.view_navigation_bar);
        this.f.a(com.baidu.tieba.u.title_activity_emotion_manage);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, String.valueOf(getString(com.baidu.tieba.u.delete)) + "(" + this.b.size() + ")", this.q);
        f();
        this.i = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.u.edit), this.q);
        this.j = (TextView) findViewById(com.baidu.tieba.r.emotion_manager_title);
        this.k = (ImageView) findViewById(com.baidu.tieba.r.emotion_manage_enter_line_list_up);
        this.l = (BdListView) findViewById(com.baidu.tieba.r.emotion_manage_list);
        this.l.setOnItemClickListener(this.r);
        this.n = LayoutInflater.from(this).inflate(com.baidu.tieba.s.emotion_manage_list_footer, (ViewGroup) null);
        this.l.addFooterView(this.n);
        this.m = (TextView) this.n.findViewById(com.baidu.tieba.r.emotion_manage_enter_record);
        this.m.setOnClickListener(this.q);
        getLayoutMode().a(TbadkApplication.m252getInst().getSkinType() == 1);
        getLayoutMode().a((View) this.e);
        getLayoutMode().a(this.n);
        e();
    }

    private void b() {
        registerListener(MessageTypes.CMD_EMOTIONS_GROUP_CHANGED, this.s);
        this.c = new w(this, null);
        this.c.execute(new String[0]);
        this.o = new u(this, null);
        this.l.setAdapter((ListAdapter) this.o);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        if (z) {
            this.b.clear();
        } else {
            for (String str : this.b) {
                Iterator<v> it = this.a.iterator();
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
                this.j.setText(com.baidu.tieba.u.emotion_manage_title_nodata);
                this.i.setEnabled(false);
                this.k.setVisibility(8);
                e();
                return;
            }
            this.j.setText(com.baidu.tieba.u.emotion_manage_title);
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
        this.i.setText(getString(com.baidu.tieba.u.cancel));
        this.p = true;
        this.n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.g.setVisibility(0);
        this.h.setVisibility(8);
        this.i.setText(getString(com.baidu.tieba.u.edit));
        this.p = false;
        this.n.setVisibility(0);
    }

    private void f() {
        int size = this.b.size();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.h.setText(String.valueOf(getString(com.baidu.tieba.u.delete)) + "(" + size + ")");
        if (size == 0) {
            this.h.setEnabled(false);
            if (skinType == 1) {
                this.h.setTextColor(getResources().getColor(com.baidu.tieba.o.emotion_manage_del_disable_1));
                return;
            } else {
                this.h.setTextColor(getResources().getColor(com.baidu.tieba.o.emotion_manage_del_disable));
                return;
            }
        }
        this.h.setEnabled(true);
        if (skinType == 1) {
            this.h.setTextColor(getResources().getColor(com.baidu.tieba.o.emotion_manage_del_enable_1));
        } else {
            this.h.setTextColor(getResources().getColor(com.baidu.tieba.o.emotion_manage_del_enable));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        this.d = new t(this, null);
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
}
