package com.baidu.tieba.flist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.model.ar;
import com.baidu.tieba.switchs.SwitchKey;
import com.baidu.tieba.util.cb;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tieba.f b;
    private int c;
    private int d;
    private ar e;
    private int g;
    public int a = -1;
    private int f = 0;
    private boolean h = true;
    private ForumDetailActivity.FromType i = ForumDetailActivity.FromType.BAR_DIR;
    private boolean k = false;
    private ForumInfoData[] j = new ForumInfoData[0];

    public r(com.baidu.tieba.f fVar, int i) {
        this.g = 0;
        this.b = fVar;
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

    public void a(ar arVar) {
        this.e = arVar;
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
            int d = TiebaApplication.g().d(this.j[i].forum_name);
            if (d == 1) {
                this.j[i].is_like = 1;
            } else if (d == -1) {
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
            s sVar = new s(this);
            sVar.a = (HeadImageView) view.findViewById(R.id.forum_avatar);
            sVar.a.setGifIconSupport(false);
            sVar.d = (TextView) view.findViewById(R.id.name);
            sVar.e = (TextView) view.findViewById(R.id.member_count);
            sVar.f = (TextView) view.findViewById(R.id.thread_count);
            sVar.g = (TextView) view.findViewById(R.id.slogan);
            sVar.h = (TextView) view.findViewById(R.id.like);
            sVar.b = (TextView) view.findViewById(R.id.rank_badge);
            sVar.c = (TextView) view.findViewById(R.id.rise_no);
            view.setTag(sVar);
        }
        View findViewById = view.findViewById(R.id.bd_list_top_divider);
        View findViewById2 = view.findViewById(R.id.bd_list_bottom_divider);
        if (this.k) {
            findViewById.setBackgroundColor(this.b.getResources().getColor(R.color.ht_title_top_sep_line_1));
            findViewById2.setBackgroundColor(this.b.getResources().getColor(R.color.ht_title_top_sep_line_1));
        } else {
            findViewById.setBackgroundColor(this.b.getResources().getColor(R.color.ht_title_top_sep_line));
            findViewById2.setBackgroundColor(this.b.getResources().getColor(R.color.ht_title_top_sep_line));
        }
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        s sVar2 = (s) view.getTag();
        int al = TiebaApplication.g().al();
        this.b.getLayoutMode().a(al == 1);
        this.b.getLayoutMode().a(view);
        ForumInfoData forumInfoData = this.j[i];
        com.baidu.adp.lib.util.f.e("ForumListAdapter", "getView", "forum name:" + this.j[i].forum_name + "forum avatar:" + this.j[i].avatar);
        String str = this.j[i].avatar;
        HeadImageView headImageView = sVar2.a;
        sVar2.a.setTag(str);
        sVar2.a.invalidate();
        sVar2.d.setText(forumInfoData.forum_name);
        sVar2.d.setTag(Integer.valueOf(forumInfoData.forum_id));
        sVar2.h.setTag(forumInfoData.forum_name);
        sVar2.e.setText(String.valueOf(this.b.getString(R.string.forum_list_attention_tv)) + " " + b(forumInfoData.member_count));
        sVar2.f.setText(String.valueOf(this.b.getString(R.string.forum_list_thread_tv)) + " " + b(forumInfoData.thread_count));
        sVar2.g.setText(forumInfoData.slogan);
        if (this.g == 0) {
            sVar2.c.setVisibility(8);
            if (!this.h) {
                sVar2.b.setVisibility(8);
            } else {
                sVar2.b.setVisibility(0);
                sVar2.b.setText((CharSequence) null);
                sVar2.b.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        sVar2.b.setBackgroundResource(al != 1 ? R.drawable.icon_brief_grade_orange : R.drawable.icon_brief_grade_orange_1);
                        break;
                    case 1:
                        sVar2.b.setBackgroundResource(al != 1 ? R.drawable.icon_brief_grade_blue : R.drawable.icon_brief_grade_blue_1);
                        break;
                    case 2:
                        sVar2.b.setBackgroundResource(al != 1 ? R.drawable.icon_brief_grade_green : R.drawable.icon_brief_grade_green_1);
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
            sVar2.c.setCompoundDrawablesWithIntrinsicBounds(al != 1 ? R.drawable.icon_rise : R.drawable.icon_rise_1, 0, 0, 0);
            sVar2.c.setText(String.valueOf(this.b.getString(R.string.rise)) + String.valueOf(forumInfoData.mbr_inter_rank) + this.b.getString(R.string.number));
        }
        if (TiebaApplication.g().al() == 1) {
            sVar2.h.setTextColor(this.b.getResources().getColor(R.color.enterforum_name_txt_1));
        } else {
            sVar2.h.setTextColor(this.b.getResources().getColor(R.color.enterforum_name_txt));
        }
        sVar2.h.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.like /* 2131100383 */:
                cb.a(this.b, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
                FrsActivity.a(this.b, (String) view.getTag(), null);
                return;
            default:
                s sVar = (s) view.getTag();
                if (com.baidu.adp.lib.a.d.a().b(SwitchKey.BAR_DETAIL_DIR) == 0) {
                    ForumDetailActivity.a(this.b, String.valueOf(sVar.d.getTag()), this.i);
                    return;
                }
                cb.a(this.b, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
                FrsActivity.a(this.b, sVar.d.getText().toString(), null);
                return;
        }
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.b.getString(R.string.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(boolean z) {
        this.k = z;
        notifyDataSetChanged();
    }
}
