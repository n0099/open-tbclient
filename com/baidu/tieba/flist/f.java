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
import com.baidu.tieba.model.aj;
import com.baidu.tieba.util.x;
import com.baidu.tieba.view.ImageViewDrawer;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f extends BaseAdapter implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f817a;
    private int b;
    private ForumListModel.Forum[] c = new ForumListModel.Forum[0];

    public f(ForumListActivity forumListActivity, int i) {
        this.f817a = forumListActivity;
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
            i iVar = new i(this);
            iVar.f820a = (ImageViewDrawer) view.findViewById(R.id.forum_avatar);
            iVar.b = (TextView) view.findViewById(R.id.name);
            iVar.c = (TextView) view.findViewById(R.id.member_count);
            iVar.d = (TextView) view.findViewById(R.id.thread_count);
            iVar.e = (TextView) view.findViewById(R.id.slogan);
            iVar.f = (ImageView) view.findViewById(R.id.like);
            view.setTag(iVar);
        }
        i iVar2 = (i) view.getTag();
        int at = TiebaApplication.f().at();
        x.c(iVar2.b, at);
        x.c(iVar2.c, at);
        x.c(iVar2.d, at);
        x.c(iVar2.e, at);
        if (at == 1) {
            view.setBackgroundColor(this.f817a.getResources().getColor(R.color.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.f817a.getResources().getColor(R.color.flist_item_color_even_day));
        }
        ForumListModel.Forum forum = this.c[i];
        String str = this.c[i].avatar;
        ImageViewDrawer imageViewDrawer = iVar2.f820a;
        aVar = this.f817a.n;
        aVar.e(str, new g(this, str, imageViewDrawer));
        iVar2.f820a.setTag(str);
        iVar2.b.setText(forum.forum_name);
        iVar2.c.setText(String.valueOf(forum.member_count));
        iVar2.d.setText(String.valueOf(forum.thread_count));
        iVar2.e.setText(forum.slogan);
        if (forum.is_like == 1) {
            ImageView imageView = iVar2.f;
            i3 = this.f817a.g;
            imageView.setImageResource(i3);
            iVar2.f.setOnClickListener(null);
            iVar2.f.setClickable(false);
        } else {
            ImageView imageView2 = iVar2.f;
            i2 = this.f817a.j;
            imageView2.setImageResource(i2);
            iVar2.f.setTag(Integer.valueOf(i));
            iVar2.f.setOnClickListener(this);
        }
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aj ajVar;
        aj ajVar2;
        aj ajVar3;
        switch (view.getId()) {
            case R.id.like /* 2131099994 */:
                ajVar = this.f817a.m;
                if (!ajVar.b()) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    String E = TiebaApplication.E();
                    if (E == null || E.length() <= 0) {
                        LoginActivity.a((Activity) this.f817a, this.f817a.getString(R.string.login_to_use), true, 1100002);
                        this.f817a.l = this.b;
                        this.f817a.k = intValue;
                        return;
                    }
                    this.f817a.findViewById(R.id.loading).setVisibility(0);
                    this.f817a.m = new aj();
                    ajVar2 = this.f817a.m;
                    ajVar2.setLoadDataCallBack(new h(this, intValue));
                    ajVar3 = this.f817a.m;
                    ajVar3.a(this.c[intValue].forum_name, String.valueOf(this.c[intValue].forum_id));
                    return;
                }
                return;
            default:
                FrsActivity.a(this.f817a, ((i) view.getTag()).b.getText().toString(), (String) null);
                return;
        }
    }
}
