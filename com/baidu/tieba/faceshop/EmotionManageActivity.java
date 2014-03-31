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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionManageActivity extends com.baidu.tbadk.a {
    private List<s> a;
    private t c;
    private q d;
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
    private r o;
    private final List<String> b = new LinkedList();
    private boolean p = false;
    private final View.OnClickListener q = new n(this);
    private final AdapterView.OnItemClickListener r = new o(this);
    private final com.baidu.adp.framework.c.a s = new p(this, 0);

    public static void a(Context context) {
        context.startActivity(new Intent(context, EmotionManageActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.activity_emotion_manage);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.a.h.emotion_manage_root);
        this.f = (NavigationBar) findViewById(com.baidu.tieba.a.h.view_navigation_bar);
        this.f.a(com.baidu.tieba.a.k.title_activity_emotion_manage);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, String.valueOf(getString(com.baidu.tieba.a.k.delete)) + "(" + this.b.size() + ")", this.q);
        c();
        this.i = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.a.k.edit), this.q);
        this.j = (TextView) findViewById(com.baidu.tieba.a.h.emotion_manager_title);
        this.k = (ImageView) findViewById(com.baidu.tieba.a.h.emotion_manage_enter_line_list_up);
        this.l = (BdListView) findViewById(com.baidu.tieba.a.h.emotion_manage_list);
        this.l.setOnItemClickListener(this.r);
        this.n = LayoutInflater.from(this).inflate(com.baidu.tieba.a.i.emotion_manage_list_footer, (ViewGroup) null);
        this.l.addFooterView(this.n);
        this.m = (TextView) this.n.findViewById(com.baidu.tieba.a.h.emotion_manage_enter_record);
        this.m.setOnClickListener(this.q);
        getLayoutMode().a(TbadkApplication.j().l() == 1);
        getLayoutMode().a(this.e);
        getLayoutMode().a(this.n);
        b();
        registerListener(2001120, this.s);
        this.c = new t(this, (byte) 0);
        this.c.execute(new String[0]);
        this.o = new r(this, (byte) 0);
        this.l.setAdapter((ListAdapter) this.o);
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f.b(i);
        com.baidu.tbadk.core.util.ba.f((View) this.h, com.baidu.tieba.a.g.navi_del_text_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        boolean z2;
        if (z) {
            this.b.clear();
        } else {
            for (String str : this.b) {
                Iterator<s> it = this.a.iterator();
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
        c();
        a();
        this.o.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null) {
            if (this.a.size() == 0) {
                this.j.setText(com.baidu.tieba.a.k.emotion_manage_title_nodata);
                this.i.setEnabled(false);
                this.k.setVisibility(8);
                b();
                return;
            }
            this.j.setText(com.baidu.tieba.a.k.emotion_manage_title);
            this.i.setEnabled(true);
            this.k.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(EmotionManageActivity emotionManageActivity, String str) {
        if (emotionManageActivity.b.contains(str)) {
            return;
        }
        emotionManageActivity.b.add(str);
        emotionManageActivity.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(EmotionManageActivity emotionManageActivity, String str) {
        emotionManageActivity.b.remove(str);
        emotionManageActivity.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void g(EmotionManageActivity emotionManageActivity) {
        emotionManageActivity.g.setVisibility(8);
        emotionManageActivity.h.setVisibility(0);
        emotionManageActivity.c();
        emotionManageActivity.i.setText(emotionManageActivity.getString(com.baidu.tieba.a.k.cancel));
        emotionManageActivity.p = true;
        emotionManageActivity.n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.g.setVisibility(0);
        this.h.setVisibility(8);
        this.i.setText(getString(com.baidu.tieba.a.k.edit));
        this.p = false;
        this.n.setVisibility(0);
    }

    private void c() {
        int size = this.b.size();
        int l = TbadkApplication.j().l();
        this.h.setText(String.valueOf(getString(com.baidu.tieba.a.k.delete)) + "(" + size + ")");
        if (size == 0) {
            this.h.setEnabled(false);
            if (l == 1) {
                this.h.setTextColor(getResources().getColor(com.baidu.tieba.a.e.emotion_manage_del_disable_1));
                return;
            } else {
                this.h.setTextColor(getResources().getColor(com.baidu.tieba.a.e.emotion_manage_del_disable));
                return;
            }
        }
        this.h.setEnabled(true);
        if (l == 1) {
            this.h.setTextColor(getResources().getColor(com.baidu.tieba.a.e.emotion_manage_del_enable_1));
        } else {
            this.h.setTextColor(getResources().getColor(com.baidu.tieba.a.e.emotion_manage_del_enable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(EmotionManageActivity emotionManageActivity) {
        emotionManageActivity.d = new q(emotionManageActivity, (byte) 0);
        emotionManageActivity.d.execute(emotionManageActivity.b);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (this.p) {
            b();
            this.b.clear();
            this.p = false;
            this.o.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }
}
