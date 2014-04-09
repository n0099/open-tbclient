package com.baidu.tieba.flist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r extends BaseAdapter implements View.OnClickListener {
    private com.baidu.tbadk.a b;
    private com.baidu.tieba.model.af c;
    private int e;
    public int a = -1;
    private int d = 0;
    private boolean f = true;
    private ForumDetailActivity.FromType g = ForumDetailActivity.FromType.BAR_DIR;
    private boolean i = false;
    private ForumInfoData[] h = new ForumInfoData[0];

    public r(com.baidu.tbadk.a aVar, int i) {
        this.e = 0;
        this.b = aVar;
        this.e = i;
    }

    public final ForumInfoData[] a() {
        return this.h;
    }

    public final void a(ForumDetailActivity.FromType fromType) {
        this.g = fromType;
    }

    public final void a(ForumInfoData[] forumInfoDataArr) {
        this.h = forumInfoDataArr;
        if (this.h != null) {
            notifyDataSetChanged();
        }
    }

    public final void a(com.baidu.tieba.model.af afVar) {
        this.c = afVar;
    }

    public final void a(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public final void b() {
        for (int i = 0; i < this.d; i++) {
            int d = com.baidu.tieba.p.c().d(this.h[i].forum_name);
            if (d == 1) {
                this.h[i].is_like = 1;
            } else if (d == -1) {
                this.h[i].is_like = 0;
            }
        }
    }

    public final boolean c() {
        if (this.c == null) {
            return false;
        }
        return this.c.b();
    }

    public final void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public final void a(Boolean bool) {
        this.f = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        if (this.h == null) {
            return 0;
        }
        return this.d <= this.h.length ? this.d : this.h.length;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        if (i > this.d) {
            return null;
        }
        return this.h[i];
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.b, com.baidu.tieba.a.i.forum_list_forum_item, null);
            s sVar = new s(this);
            sVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.a.h.forum_avatar);
            sVar.a.setGifIconSupport(false);
            sVar.d = (TextView) view.findViewById(com.baidu.tieba.a.h.name);
            sVar.e = (TextView) view.findViewById(com.baidu.tieba.a.h.member_count);
            sVar.f = (TextView) view.findViewById(com.baidu.tieba.a.h.thread_count);
            sVar.g = (TextView) view.findViewById(com.baidu.tieba.a.h.slogan);
            sVar.h = (TextView) view.findViewById(com.baidu.tieba.a.h.like);
            sVar.b = (TextView) view.findViewById(com.baidu.tieba.a.h.rank_badge);
            sVar.c = (TextView) view.findViewById(com.baidu.tieba.a.h.rise_no);
            view.setTag(sVar);
        }
        View findViewById = view.findViewById(com.baidu.tieba.a.h.bd_list_top_divider);
        View findViewById2 = view.findViewById(com.baidu.tieba.a.h.bd_list_bottom_divider);
        if (this.i) {
            findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.ht_title_top_sep_line_1));
            findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.ht_title_top_sep_line_1));
        } else {
            findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.ht_title_top_sep_line));
            findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.a.e.ht_title_top_sep_line));
        }
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        s sVar2 = (s) view.getTag();
        int l = TbadkApplication.j().l();
        this.b.getLayoutMode().a(l == 1);
        this.b.getLayoutMode().a(view);
        ForumInfoData forumInfoData = this.h[i];
        com.baidu.adp.lib.util.f.e("ForumListAdapter", "getView", "forum name:" + this.h[i].forum_name + "forum avatar:" + this.h[i].avatar);
        sVar2.a.setTag(this.h[i].avatar);
        sVar2.a.invalidate();
        sVar2.d.setText(forumInfoData.forum_name);
        sVar2.d.setTag(Integer.valueOf(forumInfoData.forum_id));
        sVar2.h.setTag(forumInfoData.forum_name);
        sVar2.e.setText(String.valueOf(this.b.getString(com.baidu.tieba.a.k.forum_list_attention_tv)) + " " + b(forumInfoData.member_count));
        sVar2.f.setText(String.valueOf(this.b.getString(com.baidu.tieba.a.k.forum_list_thread_tv)) + " " + b(forumInfoData.thread_count));
        sVar2.g.setText(forumInfoData.slogan);
        if (this.e == 0) {
            sVar2.c.setVisibility(8);
            if (!this.f) {
                sVar2.b.setVisibility(8);
            } else {
                sVar2.b.setVisibility(0);
                sVar2.b.setText((CharSequence) null);
                sVar2.b.setBackgroundDrawable(null);
                switch (i) {
                    case 0:
                        sVar2.b.setBackgroundResource(l != 1 ? com.baidu.tieba.a.g.icon_brief_grade_orange : com.baidu.tieba.a.g.icon_brief_grade_orange_1);
                        break;
                    case 1:
                        sVar2.b.setBackgroundResource(l != 1 ? com.baidu.tieba.a.g.icon_brief_grade_blue : com.baidu.tieba.a.g.icon_brief_grade_blue_1);
                        break;
                    case 2:
                        sVar2.b.setBackgroundResource(l != 1 ? com.baidu.tieba.a.g.icon_brief_grade_green : com.baidu.tieba.a.g.icon_brief_grade_green_1);
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
            sVar2.c.setCompoundDrawablesWithIntrinsicBounds(l != 1 ? com.baidu.tieba.a.g.icon_rise : com.baidu.tieba.a.g.icon_rise_1, 0, 0, 0);
            sVar2.c.setText(String.valueOf(this.b.getString(com.baidu.tieba.a.k.rise)) + String.valueOf(forumInfoData.mbr_inter_rank) + this.b.getString(com.baidu.tieba.a.k.number));
        }
        if (TbadkApplication.j().l() == 1) {
            sVar2.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.enterforum_name_txt_1));
        } else {
            sVar2.h.setTextColor(this.b.getResources().getColor(com.baidu.tieba.a.e.enterforum_name_txt));
        }
        sVar2.h.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.getId() == com.baidu.tieba.a.h.like) {
            TiebaStatic.a(this.b, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.b.sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.b).a((String) view.getTag(), null)));
            return;
        }
        s sVar = (s) view.getTag();
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR) == 0) {
            ForumDetailActivity.a(this.b, String.valueOf(sVar.d.getTag()), this.g);
            return;
        }
        TiebaStatic.a(this.b, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.b.sendMessage(new com.baidu.adp.framework.message.a(2003000, new com.baidu.tbadk.core.b.l(this.b).a(sVar.d.getText().toString(), null)));
    }

    private String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / 10000)) + this.b.getString(com.baidu.tieba.a.k.member_count_unit);
        }
        return String.valueOf(i);
    }

    public final void a(boolean z) {
        this.i = z;
        notifyDataSetChanged();
    }
}
