package com.baidu.tieba.forumfeed;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.widget.ListView.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ i f1240a;
    private Context b;
    private TextView c = null;
    private ProgressBar d = null;
    private ImageView e = null;
    private View.OnClickListener f = null;
    private View g = null;
    private View h;

    public m(i iVar, Context context) {
        this.f1240a = iVar;
        this.b = null;
        this.b = context;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a() {
        ForumFeedActivity forumFeedActivity;
        ForumFeedActivity forumFeedActivity2;
        ForumFeedActivity forumFeedActivity3;
        ForumFeedActivity forumFeedActivity4;
        this.g = LayoutInflater.from(this.b).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.c = (TextView) this.g.findViewById(R.id.pb_more_text);
        this.e = (ImageView) this.g.findViewById(R.id.image);
        this.h = this.g.findViewById(R.id.pb_more_view);
        this.h.setVisibility(8);
        this.d = (ProgressBar) this.g.findViewById(R.id.progress);
        View view = this.g;
        forumFeedActivity = this.f1240a.d;
        int a2 = UtilHelper.a((Context) forumFeedActivity, 6.0f);
        forumFeedActivity2 = this.f1240a.d;
        int a3 = UtilHelper.a((Context) forumFeedActivity2, 10.0f);
        forumFeedActivity3 = this.f1240a.d;
        int a4 = UtilHelper.a((Context) forumFeedActivity3, 6.0f);
        forumFeedActivity4 = this.f1240a.d;
        view.setPadding(a2, a3, a4, UtilHelper.a((Context) forumFeedActivity4, 10.0f));
        a(TiebaApplication.g().as());
        this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, UtilHelper.a(this.b, 45.0f)));
        return this.g;
    }

    public void a(int i) {
        ForumFeedActivity forumFeedActivity;
        n nVar;
        forumFeedActivity = this.f1240a.d;
        forumFeedActivity.m().a(this.h);
        bb.e(this.h, i == 1 ? R.drawable.bg_list_all_1 : R.drawable.bg_list_all);
        nVar = this.f1240a.m;
        nVar.a(i);
    }

    public void a(View.OnClickListener onClickListener) {
        this.f = onClickListener;
    }

    public void c() {
        this.g.setVisibility(8);
    }

    public void d() {
        this.g.setVisibility(0);
    }

    public void e() {
        this.d.setVisibility(0);
        this.e.setVisibility(8);
        this.c.setText(this.b.getText(R.string.loading));
        this.h.setVisibility(0);
    }

    public void f() {
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.c.setText(R.string.no_more_to_load);
    }

    public void g() {
        this.d.setVisibility(8);
        this.e.setVisibility(0);
        this.c.setText(R.string.load_more);
    }

    public void h() {
        this.h.setVisibility(0);
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.f != null) {
            this.f.onClick(this.g);
        }
    }
}
