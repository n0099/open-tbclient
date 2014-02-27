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
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class EmotionManageActivity extends com.baidu.tieba.f implements com.baidu.tieba.im.messageCenter.g {
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
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_emotion_manage);
        this.e = (LinearLayout) findViewById(R.id.emotion_manage_root);
        this.f = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f.a(R.string.title_activity_emotion_manage);
        this.g = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.h = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, String.valueOf(getString(R.string.delete)) + "(" + this.b.size() + ")", this.q);
        c();
        this.i = this.f.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(R.string.edit), this.q);
        this.j = (TextView) findViewById(R.id.emotion_manager_title);
        this.k = (ImageView) findViewById(R.id.emotion_manage_enter_line_list_up);
        this.l = (BdListView) findViewById(R.id.emotion_manage_list);
        this.l.setOnItemClickListener(this.r);
        this.n = LayoutInflater.from(this).inflate(R.layout.emotion_manage_list_footer, (ViewGroup) null);
        this.l.addFooterView(this.n);
        this.m = (TextView) this.n.findViewById(R.id.emotion_manage_enter_record);
        this.m.setOnClickListener(this.q);
        getLayoutMode().a(TiebaApplication.g().ae() == 1);
        getLayoutMode().a(this.e);
        getLayoutMode().a(this.n);
        b();
        com.baidu.tieba.im.messageCenter.d.a().a(-120, this);
        this.c = new f(this, (byte) 0);
        this.c.execute(new String[0]);
        this.o = new d(this, (byte) 0);
        this.l.setAdapter((ListAdapter) this.o);
        a(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.messageCenter.d.a().a(this);
        if (this.d != null) {
            this.d.cancel(true);
            this.d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.f.b(i);
        bq.f((View) this.h, (int) R.drawable.navi_del_text_bg);
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
        c();
        a();
        this.o.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.a != null) {
            if (this.a.size() == 0) {
                this.j.setText(R.string.emotion_manage_title_nodata);
                this.i.setEnabled(false);
                this.k.setVisibility(8);
                b();
                return;
            }
            this.j.setText(R.string.emotion_manage_title);
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
        emotionManageActivity.i.setText(emotionManageActivity.getString(R.string.cancel));
        emotionManageActivity.p = true;
        emotionManageActivity.n.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.g.setVisibility(0);
        this.h.setVisibility(8);
        this.i.setText(getString(R.string.edit));
        this.p = false;
        this.n.setVisibility(0);
    }

    private void c() {
        int size = this.b.size();
        int ae = TiebaApplication.g().ae();
        this.h.setText(String.valueOf(getString(R.string.delete)) + "(" + size + ")");
        if (size == 0) {
            this.h.setEnabled(false);
            if (ae == 1) {
                this.h.setTextColor(getResources().getColor(R.color.emotion_manage_del_disable_1));
                return;
            } else {
                this.h.setTextColor(getResources().getColor(R.color.emotion_manage_del_disable));
                return;
            }
        }
        this.h.setEnabled(true);
        if (ae == 1) {
            this.h.setTextColor(getResources().getColor(R.color.emotion_manage_del_enable_1));
        } else {
            this.h.setTextColor(getResources().getColor(R.color.emotion_manage_del_enable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(EmotionManageActivity emotionManageActivity) {
        emotionManageActivity.d = new c(emotionManageActivity, (byte) 0);
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

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        if (sVar.w() == -120) {
            this.c = new f(this, (byte) 0);
            this.c.execute(new String[0]);
        }
    }
}
