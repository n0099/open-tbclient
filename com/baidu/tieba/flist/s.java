package com.baidu.tieba.flist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.ax;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.bo;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.j b;
    private int c;
    private int d;
    private ax e;
    private int g;
    public int a = -1;
    private int f = 0;
    private boolean h = true;
    private ForumDetailActivity.FromType i = ForumDetailActivity.FromType.BAR_DIR;
    private ForumInfoData[] j = new ForumInfoData[0];

    public s(com.baidu.tieba.j jVar, int i) {
        this.g = 0;
        this.b = jVar;
        this.g = i;
    }

    public ForumInfoData[] a() {
        return this.j;
    }

    public void a(ForumDetailActivity.FromType fromType) {
        this.i = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.j = forumInfoDataArr;
        if (this.j != null) {
            notifyDataSetChanged();
        }
    }

    public void a(ax axVar) {
        this.e = axVar;
    }

    public void a(int i, int i2) {
        this.c = i;
        this.d = i2;
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void b() {
        for (int i = 0; i < this.f; i++) {
            int e = TiebaApplication.g().e(this.j[i].forum_name);
            if (e == 1) {
                this.j[i].is_like = 1;
            } else if (e == -1) {
                this.j[i].is_like = 0;
            }
        }
    }

    public boolean c() {
        if (this.e == null) {
            return false;
        }
        return this.e.b();
    }

    public void a(int i) {
        this.f = i;
        notifyDataSetChanged();
    }

    public void a(Boolean bool) {
        this.h = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.j == null) {
            return 0;
        }
        return this.f <= this.j.length ? this.f : this.j.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.f) {
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
            t tVar = new t(this);
            tVar.a = (HeadImageView) view.findViewById(R.id.forum_avatar);
            tVar.a.setGifIconSupport(false);
            tVar.d = (TextView) view.findViewById(R.id.name);
            tVar.e = (TextView) view.findViewById(R.id.member_count);
            tVar.f = (TextView) view.findViewById(R.id.thread_count);
            tVar.g = (TextView) view.findViewById(R.id.slogan);
            tVar.h = (TextView) view.findViewById(R.id.like);
            tVar.b = (TextView) view.findViewById(R.id.rank_badge);
            tVar.c = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(tVar);
        }
        t tVar2 = (t) view.getTag();
        int an = TiebaApplication.g().an();
        this.b.getLayoutMode().a(an == 1);
        this.b.getLayoutMode().a(view);
        ForumInfoData forumInfoData = this.j[i];
        bo.e("ForumListAdapter", "getView", "forum name:" + this.j[i].forum_name + "forum avatar:" + this.j[i].avatar);
        String str = this.j[i].avatar;
        HeadImageView headImageView = tVar2.a;
        tVar2.a.setTag(str);
        tVar2.a.invalidate();
        tVar2.d.setText(forumInfoData.forum_name);
        tVar2.d.setTag(Integer.valueOf(forumInfoData.forum_id));
        tVar2.h.setTag(forumInfoData.forum_name);
        tVar2.e.setText(this.b.getString(R.string.forum_list_attention_tv) + " " + b(forumInfoData.member_count));
        tVar2.f.setText(this.b.getString(R.string.forum_list_thread_tv) + " " + b(forumInfoData.thread_count));
        tVar2.g.setText(forumInfoData.slogan);
        if (this.g == 0) {
            tVar2.c.setVisibility(8);
            if (!this.h) {
                tVar2.b.setVisibility(8);
            } else {
                tVar2.b.setVisibility(0);
                tVar2.b.setText((CharSequence) null);
                tVar2.b.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        tVar2.b.setBackgroundResource(an != 1 ? R.drawable.icon_brief_grade_orange : R.drawable.icon_brief_grade_orange_1);
                        break;
                    case 1:
                        tVar2.b.setBackgroundResource(an != 1 ? R.drawable.icon_brief_grade_blue : R.drawable.icon_brief_grade_blue_1);
                        break;
                    case 2:
                        tVar2.b.setBackgroundResource(an != 1 ? R.drawable.icon_brief_grade_green : R.drawable.icon_brief_grade_green_1);
                        break;
                    default:
                        tVar2.b.setText(String.format("%02d", Integer.valueOf(i + 1)));
                        break;
                }
            }
        } else {
            tVar2.b.setVisibility(8);
            tVar2.c.setVisibility(0);
            tVar2.c.setText((CharSequence) null);
            tVar2.c.setCompoundDrawablesWithIntrinsicBounds(an != 1 ? R.drawable.icon_rise : R.drawable.icon_rise_1, 0, 0, 0);
            tVar2.c.setText(this.b.getString(R.string.rise) + String.valueOf(forumInfoData.mbr_inter_rank) + this.b.getString(R.string.number));
        }
        if (TiebaApplication.g().an() == 1) {
            tVar2.h.setTextColor(this.b.getResources().getColor(R.color.enterforum_name_txt_1));
        } else {
            tVar2.h.setTextColor(this.b.getResources().getColor(R.color.enterforum_name_txt));
        }
        tVar2.h.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.like /* 2131100242 */:
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.b, "forumlist_to_frs", "tofrsclick", 1);
                }
                FrsActivity.a(this.b, (String) view.getTag(), (String) null);
                return;
            default:
                t tVar = (t) view.getTag();
                if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_DIR) == 0) {
                    ForumDetailActivity.a(this.b, String.valueOf(tVar.d.getTag()), this.i);
                    return;
                }
                if (TiebaApplication.g().s()) {
                    StatService.onEvent(this.b, "forumlist_to_frs", "tofrsclick", 1);
                }
                FrsActivity.a(this.b, tVar.d.getText().toString(), (String) null);
                return;
        }
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(i / 10000) + this.b.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }
}
