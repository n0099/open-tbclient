package com.baidu.tieba.flist;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.aq;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.ao;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.g b;
    private com.baidu.tieba.util.a c;
    private int d;
    private int e;
    private aq f;

    /* renamed from: a  reason: collision with root package name */
    public int f1051a = -1;
    private int g = 0;
    private ForumListModel.Forum[] h = new ForumListModel.Forum[0];

    public p(com.baidu.tieba.g gVar) {
        this.b = gVar;
        this.c = new com.baidu.tieba.util.a(gVar);
        this.c.a(BdWebErrorView.ERROR_CODE_400, BdWebErrorView.ERROR_CODE_400);
    }

    public ForumListModel.Forum[] a() {
        return this.h;
    }

    public void a(ForumListModel.Forum[] forumArr) {
        this.h = forumArr;
        if (this.h != null) {
            notifyDataSetChanged();
        }
    }

    public void a(aq aqVar) {
        this.f = aqVar;
    }

    public void a(int i, int i2) {
        this.d = i;
        this.e = i2;
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void b() {
        for (int i = 0; i < this.g; i++) {
            int d = TiebaApplication.g().d(this.h[i].forum_name);
            if (d == 1) {
                this.h[i].is_like = 1;
            } else if (d == -1) {
                this.h[i].is_like = 0;
            }
        }
    }

    public boolean c() {
        if (this.f == null) {
            return false;
        }
        return this.f.b();
    }

    public void a(int i) {
        this.g = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.h == null) {
            return 0;
        }
        return this.g;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.g) {
            return null;
        }
        return this.h[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.b, R.layout.forum_list_forum_item, null);
            s sVar = new s(this);
            sVar.f1054a = (ImageView) view.findViewById(R.id.forum_avatar);
            sVar.b = (TextView) view.findViewById(R.id.name);
            sVar.c = (TextView) view.findViewById(R.id.member_count);
            sVar.d = (TextView) view.findViewById(R.id.thread_count);
            sVar.e = (TextView) view.findViewById(R.id.slogan);
            sVar.f = (TextView) view.findViewById(R.id.like);
            view.setTag(sVar);
        }
        s sVar2 = (s) view.getTag();
        int an = TiebaApplication.g().an();
        ao.c(sVar2.b, an);
        ao.c(sVar2.c, an);
        ao.c(sVar2.d, an);
        ao.c(sVar2.e, an);
        ao.c(sVar2.f, an);
        if (an != 1) {
            sVar2.b.setTextColor(-14277082);
            sVar2.c.setTextColor(-6775644);
            sVar2.d.setTextColor(-6775644);
            sVar2.e.setTextColor(-6842215);
        }
        if (an == 1) {
            view.setBackgroundColor(this.b.getResources().getColor(R.color.flist_item_color_night));
        } else {
            view.setBackgroundColor(this.b.getResources().getColor(R.color.flist_item_color_even_day));
        }
        ForumListModel.Forum forum = this.h[i];
        com.baidu.tieba.util.aq.e("ForumListAdapter", "getView", "forum name:" + this.h[i].forum_name + "forum avatar:" + this.h[i].avatar);
        String str = this.h[i].avatar;
        this.c.e(str, new q(this, str, sVar2.f1054a));
        sVar2.f1054a.setTag(str);
        sVar2.b.setText(forum.forum_name);
        sVar2.c.setText(String.valueOf(this.b.getString(R.string.forum_list_attention_tv)) + " " + String.valueOf(forum.member_count));
        sVar2.d.setText(String.valueOf(this.b.getString(R.string.forum_list_thread_tv)) + " " + String.valueOf(forum.thread_count));
        sVar2.e.setText(forum.slogan);
        if (forum.is_like == 1) {
            sVar2.f.setBackgroundResource(this.d);
            sVar2.f.setText(R.string.attention_y);
            sVar2.f.setGravity(17);
            if (TiebaApplication.g().an() == 1) {
                sVar2.f.setTextColor(this.b.getResources().getColor(R.color.forum_list_already_attention_night));
            } else {
                sVar2.f.setTextColor(this.b.getResources().getColor(R.color.forum_list_already_attention));
            }
            sVar2.f.setPadding(0, 0, 0, UtilHelper.a((Context) this.b, 2.0f));
            sVar2.f.setOnClickListener(null);
            sVar2.f.setClickable(false);
        } else {
            sVar2.f.setBackgroundResource(this.e);
            sVar2.f.setText(R.string.attention_n);
            sVar2.f.setTextColor(this.b.getResources().getColor(R.color.forum_list_attention));
            sVar2.f.setPadding(UtilHelper.a((Context) this.b, 30.0f), 0, UtilHelper.a((Context) this.b, 10.0f), 0);
            sVar2.f.setGravity(16);
            sVar2.f.setTag(Integer.valueOf(i));
            sVar2.f.setOnClickListener(this);
        }
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.like /* 2131100055 */:
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.b, "forumlist_like", "likeclick", 1);
                }
                if (!this.f.b()) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    String E = TiebaApplication.E();
                    if (E == null || E.length() <= 0) {
                        LoginActivity.a((Activity) this.b, this.b.getString(R.string.login_to_use), true, 11002);
                        this.f1051a = intValue;
                        return;
                    }
                    this.b.findViewById(R.id.loading).setVisibility(0);
                    this.f.setLoadDataCallBack(new r(this, intValue));
                    this.f.a("from_flist");
                    this.f.a(this.h[intValue].forum_name, String.valueOf(this.h[intValue].forum_id));
                    return;
                }
                return;
            default:
                s sVar = (s) view.getTag();
                if (TiebaApplication.g().u()) {
                    StatService.onEvent(this.b, "forumlist_to_frs", "tofrsclick", 1);
                }
                FrsActivity.a(this.b, sVar.b.getText().toString(), (String) null);
                return;
        }
    }
}
