package com.baidu.tieba.flist;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.browser.explorer.BdWebErrorView;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.account.LoginActivity;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.ForumListModel;
import com.baidu.tieba.model.as;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.av;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.j b;
    private com.baidu.tieba.util.a c;
    private int d;
    private int e;
    private as f;
    private int h;

    /* renamed from: a  reason: collision with root package name */
    public int f1068a = -1;
    private int g = 0;
    private boolean i = true;
    private ForumListModel.Forum[] j = new ForumListModel.Forum[0];

    public p(com.baidu.tieba.j jVar, int i) {
        this.h = 0;
        this.b = jVar;
        this.h = i;
        this.c = new com.baidu.tieba.util.a(jVar);
        this.c.a(BdWebErrorView.ERROR_CODE_400, BdWebErrorView.ERROR_CODE_400);
    }

    public ForumListModel.Forum[] a() {
        return this.j;
    }

    public void a(ForumListModel.Forum[] forumArr) {
        this.j = forumArr;
        if (this.j != null) {
            notifyDataSetChanged();
        }
    }

    public void a(as asVar) {
        this.f = asVar;
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
            int d = TiebaApplication.g().d(this.j[i].forum_name);
            if (d == 1) {
                this.j[i].is_like = 1;
            } else if (d == -1) {
                this.j[i].is_like = 0;
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

    public void a(Boolean bool) {
        this.i = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.j == null) {
            return 0;
        }
        return this.g <= this.j.length ? this.g : this.j.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.g) {
            return null;
        }
        return this.j[i];
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
            sVar.f1071a = (ImageView) view.findViewById(R.id.forum_avatar);
            sVar.d = (TextView) view.findViewById(R.id.name);
            sVar.e = (TextView) view.findViewById(R.id.member_count);
            sVar.f = (TextView) view.findViewById(R.id.thread_count);
            sVar.g = (TextView) view.findViewById(R.id.slogan);
            sVar.h = (TextView) view.findViewById(R.id.like);
            sVar.b = (TextView) view.findViewById(R.id.rank_badge);
            sVar.c = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(sVar);
        }
        s sVar2 = (s) view.getTag();
        int ap = TiebaApplication.g().ap();
        this.b.l().a(ap == 1);
        this.b.l().a(view);
        ForumListModel.Forum forum = this.j[i];
        av.e("ForumListAdapter", "getView", "forum name:" + this.j[i].forum_name + "forum avatar:" + this.j[i].avatar);
        String str = this.j[i].avatar;
        this.c.e(str, new q(this, str, sVar2.f1071a));
        sVar2.f1071a.setTag(str);
        sVar2.f1071a.invalidate();
        sVar2.d.setText(forum.forum_name);
        sVar2.d.setTag(Integer.valueOf(forum.forum_id));
        sVar2.e.setText(String.valueOf(this.b.getString(R.string.forum_list_attention_tv)) + " " + b(forum.member_count));
        sVar2.f.setText(String.valueOf(this.b.getString(R.string.forum_list_thread_tv)) + " " + b(forum.thread_count));
        sVar2.g.setText(forum.slogan);
        if (this.h == 0) {
            sVar2.c.setVisibility(8);
            if (!this.i) {
                sVar2.b.setVisibility(8);
            } else {
                sVar2.b.setVisibility(0);
                sVar2.b.setText((CharSequence) null);
                sVar2.b.setBackgroundResource(0);
                switch (i) {
                    case 0:
                        sVar2.b.setBackgroundResource(ap != 1 ? R.drawable.icon_brief_grade_orange : R.drawable.icon_brief_grade_orange_1);
                        break;
                    case 1:
                        sVar2.b.setBackgroundResource(ap != 1 ? R.drawable.icon_brief_grade_blue : R.drawable.icon_brief_grade_blue_1);
                        break;
                    case 2:
                        sVar2.b.setBackgroundResource(ap != 1 ? R.drawable.icon_brief_grade_green : R.drawable.icon_brief_grade_green_1);
                        break;
                    default:
                        sVar2.b.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            sVar2.b.setVisibility(8);
            sVar2.c.setVisibility(0);
            sVar2.c.setText((CharSequence) null);
            sVar2.c.setCompoundDrawablesWithIntrinsicBounds(ap != 1 ? R.drawable.icon_rise : R.drawable.icon_rise_1, 0, 0, 0);
            sVar2.c.setText(String.valueOf(this.b.getString(R.string.rise)) + String.valueOf(forum.mbr_inter_rank) + this.b.getString(R.string.number));
        }
        if (forum.is_like == 1) {
            sVar2.h.setBackgroundResource(this.d);
            sVar2.h.setText(R.string.attention_y);
            sVar2.h.setGravity(17);
            if (TiebaApplication.g().ap() == 1) {
                sVar2.h.setTextColor(this.b.getResources().getColor(R.color.forum_list_already_attention_night));
            } else {
                sVar2.h.setTextColor(this.b.getResources().getColor(R.color.forum_list_already_attention));
            }
            sVar2.h.setPadding(0, 0, 0, UtilHelper.a((Context) this.b, 2.0f));
            sVar2.h.setOnClickListener(null);
            sVar2.h.setClickable(false);
        } else {
            sVar2.h.setBackgroundResource(this.e);
            sVar2.h.setText(R.string.attention_n);
            sVar2.h.setTextColor(this.b.getResources().getColor(R.color.forum_list_attention));
            sVar2.h.setPadding(UtilHelper.a((Context) this.b, 30.0f), 0, UtilHelper.a((Context) this.b, 10.0f), 0);
            sVar2.h.setGravity(16);
            sVar2.h.setTag(Integer.valueOf(i));
            sVar2.h.setOnClickListener(this);
        }
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.like /* 2131100096 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.b, "forumlist_like", "likeclick", 1);
                }
                if (!this.f.b()) {
                    int intValue = ((Integer) view.getTag()).intValue();
                    String C = TiebaApplication.C();
                    if (C == null || C.length() <= 0) {
                        LoginActivity.a((Activity) this.b, this.b.getString(R.string.login_to_use), true, 11002);
                        this.f1068a = intValue;
                        return;
                    }
                    this.b.findViewById(R.id.loading).setVisibility(0);
                    this.f.setLoadDataCallBack(new r(this, intValue));
                    this.f.a("from_flist");
                    this.f.a(this.j[intValue].forum_name, String.valueOf(this.j[intValue].forum_id));
                    return;
                }
                return;
            default:
                s sVar = (s) view.getTag();
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.b, "forumlist_to_frs", "tofrsclick", 1);
                }
                if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_DIR) == 0) {
                    ForumDetailActivity.a(this.b, String.valueOf(sVar.d.getTag()), ForumDetailActivity.FromType.BAR_DIR);
                    return;
                } else {
                    FrsActivity.a(this.b, sVar.d.getText().toString(), (String) null);
                    return;
                }
        }
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / VersionUtils.CUR_DEVELOPMENT)) + this.b.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
