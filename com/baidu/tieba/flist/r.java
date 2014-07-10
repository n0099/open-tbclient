package com.baidu.tieba.flist;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.ai;
import com.baidu.tieba.data.ForumInfoData;
import com.baidu.tieba.forumdetail.ForumDetailActivity;
import com.baidu.tieba.switchs.features.BarDetailForDirSwitchStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends BaseAdapter implements View.OnClickListener {
    private BaseActivity b;
    private com.baidu.tieba.model.ae c;
    private int e;
    public int a = -1;
    private int d = 0;
    private boolean f = true;
    private ForumDetailActivity.FromType g = ForumDetailActivity.FromType.BAR_DIR;
    private boolean i = false;
    private ForumInfoData[] h = new ForumInfoData[0];

    public r(BaseActivity baseActivity, int i) {
        this.e = 0;
        this.b = baseActivity;
        this.e = i;
    }

    public ForumInfoData[] a() {
        return this.h;
    }

    public void a(ForumDetailActivity.FromType fromType) {
        this.g = fromType;
    }

    public void a(ForumInfoData[] forumInfoDataArr) {
        this.h = forumInfoDataArr;
        if (this.h != null) {
            notifyDataSetChanged();
        }
    }

    public void a(com.baidu.tieba.model.ae aeVar) {
        this.c = aeVar;
    }

    public void a(int i, int i2) {
        if (i != 0 && i2 != 0) {
            notifyDataSetChanged();
        }
    }

    public void b() {
        for (int i = 0; i < this.d; i++) {
            int d = ai.c().d(this.h[i].forum_name);
            if (d == 1) {
                this.h[i].is_like = 1;
            } else if (d == -1) {
                this.h[i].is_like = 0;
            }
        }
    }

    public boolean c() {
        if (this.c == null) {
            return false;
        }
        return this.c.b();
    }

    public void a(int i) {
        this.d = i;
        notifyDataSetChanged();
    }

    public void a(Boolean bool) {
        this.f = bool.booleanValue();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.h == null) {
            return 0;
        }
        return this.d <= this.h.length ? this.d : this.h.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (i > this.d) {
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
            view = View.inflate(this.b, com.baidu.tieba.w.forum_list_forum_item, null);
            s sVar = new s(this);
            sVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.v.forum_avatar);
            sVar.a.setGifIconSupport(false);
            sVar.d = (TextView) view.findViewById(com.baidu.tieba.v.name);
            sVar.e = (TextView) view.findViewById(com.baidu.tieba.v.member_count);
            sVar.f = (TextView) view.findViewById(com.baidu.tieba.v.thread_count);
            sVar.g = (TextView) view.findViewById(com.baidu.tieba.v.slogan);
            sVar.h = (TextView) view.findViewById(com.baidu.tieba.v.like);
            sVar.b = (TextView) view.findViewById(com.baidu.tieba.v.rank_badge);
            sVar.c = (TextView) view.findViewById(com.baidu.tieba.v.rise_no);
            view.setTag(sVar);
        }
        View findViewById = view.findViewById(com.baidu.tieba.v.bd_list_top_divider);
        View findViewById2 = view.findViewById(com.baidu.tieba.v.bd_list_bottom_divider);
        if (this.i) {
            findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.ht_title_top_sep_line_1));
            findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.ht_title_top_sep_line_1));
        } else {
            findViewById.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.ht_title_top_sep_line));
            findViewById2.setBackgroundColor(this.b.getResources().getColor(com.baidu.tieba.s.ht_title_top_sep_line));
        }
        if (i == 0) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        s sVar2 = (s) view.getTag();
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.b.getLayoutMode().a(skinType == 1);
        this.b.getLayoutMode().a(view);
        ForumInfoData forumInfoData = this.h[i];
        sVar2.a.setTag(this.h[i].avatar);
        sVar2.a.invalidate();
        sVar2.d.setText(forumInfoData.forum_name);
        sVar2.d.setTag(Integer.valueOf(forumInfoData.forum_id));
        sVar2.h.setTag(forumInfoData.forum_name);
        sVar2.e.setText(String.valueOf(this.b.getString(com.baidu.tieba.y.forum_list_attention_tv)) + " " + b(forumInfoData.member_count));
        sVar2.f.setText(String.valueOf(this.b.getString(com.baidu.tieba.y.forum_list_thread_tv)) + " " + b(forumInfoData.thread_count));
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
                        sVar2.b.setBackgroundResource(skinType != 1 ? com.baidu.tieba.u.icon_brief_grade_orange : com.baidu.tieba.u.icon_brief_grade_orange_1);
                        break;
                    case 1:
                        sVar2.b.setBackgroundResource(skinType != 1 ? com.baidu.tieba.u.icon_brief_grade_blue : com.baidu.tieba.u.icon_brief_grade_blue_1);
                        break;
                    case 2:
                        sVar2.b.setBackgroundResource(skinType != 1 ? com.baidu.tieba.u.icon_brief_grade_green : com.baidu.tieba.u.icon_brief_grade_green_1);
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
            sVar2.c.setCompoundDrawablesWithIntrinsicBounds(skinType != 1 ? com.baidu.tieba.u.icon_rise : com.baidu.tieba.u.icon_rise_1, 0, 0, 0);
            sVar2.c.setText(String.valueOf(this.b.getString(com.baidu.tieba.y.rise)) + String.valueOf(forumInfoData.mbr_inter_rank) + this.b.getString(com.baidu.tieba.y.number));
        }
        sVar2.h.setOnClickListener(this);
        view.setOnClickListener(this);
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == com.baidu.tieba.v.like) {
            TiebaStatic.eventStat(this.b, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
            this.b.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(this.b).a((String) view.getTag(), null)));
            return;
        }
        s sVar = (s) view.getTag();
        if (com.baidu.adp.lib.a.f.a().b(BarDetailForDirSwitchStatic.BAR_DETAIL_DIR) == 0) {
            ForumDetailActivity.a(this.b, String.valueOf(sVar.d.getTag()), this.g);
            return;
        }
        TiebaStatic.eventStat(this.b, "forumlist_to_frs", "tofrsclick", 1, new Object[0]);
        this.b.sendMessage(new CustomMessage(2003000, new com.baidu.tbadk.core.atomData.r(this.b).a(sVar.d.getText().toString(), null)));
    }

    public String b(int i) {
        if (i >= 100000) {
            return String.valueOf(String.valueOf(i / TbConfig.BIG_IMAGE_MIN_CAPACITY)) + this.b.getString(com.baidu.tieba.y.member_count_unit);
        }
        return String.valueOf(i);
    }

    public void a(boolean z) {
        this.i = z;
        notifyDataSetChanged();
    }
}
