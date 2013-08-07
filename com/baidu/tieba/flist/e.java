package com.baidu.tieba.flist;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.util.ah;
import com.baidu.tieba.view.ImageViewDrawer;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1039a;
    private int b;
    private ForumListModel.Forum[] c = new ForumListModel.Forum[0];

    public e(ForumListActivity forumListActivity, int i) {
        this.f1039a = forumListActivity;
        this.b = i;
    }

    public ForumListModel.Forum[] a() {
        return this.c;
    }

    public void a(ForumListModel.Forum[] forumArr) {
        this.c = forumArr;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        return this.c.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.c[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        com.baidu.tieba.util.a aVar;
        int i2;
        int i3;
        Context context = viewGroup.getContext();
        if (view == null) {
            view = View.inflate(context, R.layout.forum_list_forum_item, null);
            h hVar = new h(this);
            hVar.f1042a = (ImageViewDrawer) view.findViewById(R.id.forum_avatar);
            hVar.b = (TextView) view.findViewById(R.id.name);
            hVar.c = (TextView) view.findViewById(R.id.member_count);
            hVar.d = (TextView) view.findViewById(R.id.thread_count);
            hVar.e = (TextView) view.findViewById(R.id.slogan);
            hVar.f = (ImageView) view.findViewById(R.id.like);
            view.setTag(hVar);
        }
        h hVar2 = (h) view.getTag();
        int au = TiebaApplication.f().au();
        ah.c(hVar2.b, au);
        ah.c(hVar2.c, au);
        ah.c(hVar2.d, au);
        ah.c(hVar2.e, au);
        if (au == 1) {
            view.setBackgroundColor(this.f1039a.getResources().getColor(R.color.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.f1039a.getResources().getColor(R.color.flist_item_color_even_day));
        }
        ForumListModel.Forum forum = this.c[i];
        String str = this.c[i].avatar;
        ImageViewDrawer imageViewDrawer = hVar2.f1042a;
        aVar = this.f1039a.n;
        aVar.e(str, new f(this, str, imageViewDrawer));
        hVar2.f1042a.setTag(str);
        hVar2.b.setText(forum.forum_name);
        hVar2.c.setText(String.valueOf(forum.member_count));
        hVar2.d.setText(String.valueOf(forum.thread_count));
        hVar2.e.setText(forum.slogan);
        if (forum.is_like == 1) {
            ImageView imageView = hVar2.f;
            i3 = this.f1039a.g;
            imageView.setImageResource(i3);
            hVar2.f.setOnClickListener(null);
            hVar2.f.setClickable(false);
        } else {
            ImageView imageView2 = hVar2.f;
            i2 = this.f1039a.j;
            imageView2.setImageResource(i2);
            hVar2.f.setTag(Integer.valueOf(i));
            hVar2.f.setOnClickListener(this);
        }
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar arVar;
        ar arVar2;
        ar arVar3;
        switch (view.getId()) {
            case R.id.like /* 2131100015 */:
                arVar = this.f1039a.m;
                if (!arVar.b()) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    String E = TiebaApplication.E();
                    if (E == null || E.length() <= 0) {
                        LoginActivity.a((Activity) this.f1039a, this.f1039a.getString(R.string.login_to_use), true, 11002);
                        this.f1039a.l = this.b;
                        this.f1039a.k = intValue;
                        return;
                    }
                    this.f1039a.findViewById(R.id.loading).setVisibility(0);
                    this.f1039a.m = new ar();
                    arVar2 = this.f1039a.m;
                    arVar2.setLoadDataCallBack(new g(this, intValue));
                    arVar3 = this.f1039a.m;
                    arVar3.a(this.c[intValue].forum_name, String.valueOf(this.c[intValue].forum_id));
                    return;
                }
                return;
            default:
                FrsActivity.a(this.f1039a, ((h) view.getTag()).b.getText().toString(), (String) null);
                return;
        }
    }
}
