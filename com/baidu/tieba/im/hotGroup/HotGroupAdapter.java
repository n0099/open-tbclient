package com.baidu.tieba.im.hotGroup;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.lib.g.g;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.util.i;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HotGroupAdapter extends BaseAdapter {
    private HotGroupActivity a;
    private i b;
    private List<GroupInfoData> c = new ArrayList();
    private BOTTOM_TYPE d;
    private boolean e;

    /* loaded from: classes.dex */
    public enum BOTTOM_TYPE {
        LINE,
        HAVE_MORE,
        NO_MORE
    }

    public HotGroupAdapter(HotGroupActivity hotGroupActivity) {
        this.a = hotGroupActivity;
        this.b = new i(this.a);
        this.b.d(true);
    }

    public i a() {
        return this.b;
    }

    public void a(List<GroupInfoData> list) {
        this.c.addAll(list);
        c();
    }

    public void b() {
        if (this.c != null) {
            this.c.clear();
        }
    }

    public void a(BOTTOM_TYPE bottom_type) {
        this.d = bottom_type;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.c == null) {
            return 0;
        }
        int size = this.c.size();
        if (this.e) {
            return size + 1;
        }
        return size;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    public void a(boolean z) {
        this.e = z;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.c.size()) {
            return null;
        }
        return this.c.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i == getCount() - 1 && this.e) {
            i = -2;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.a).inflate(R.layout.hot_group_item_view, viewGroup, false);
            a aVar2 = new a();
            aVar2.a = (LinearLayout) view.findViewById(R.id.list_more);
            aVar2.c = (TextView) view.findViewById(R.id.list_more_title);
            aVar2.d = (ProgressBar) view.findViewById(R.id.list_more_progress);
            aVar2.e = (ImageView) view.findViewById(R.id.list_more_line);
            aVar2.b = (LinearLayout) view.findViewById(R.id.list_more_text);
            aVar2.f = (LinearLayout) view.findViewById(R.id.click_head);
            aVar2.g = (LinearLayout) view.findViewById(R.id.list_item_content);
            aVar2.h = (HeadImageView) view.findViewById(R.id.item_head);
            aVar2.i = (TextView) view.findViewById(R.id.group_name);
            aVar2.j = (TextView) view.findViewById(R.id.item_group_num);
            aVar2.k = (TextView) view.findViewById(R.id.group_intro);
            aVar2.l = (ImageView) view.findViewById(R.id.item_grade1);
            aVar2.m = (ImageView) view.findViewById(R.id.item_grade2);
            aVar2.n = (ImageView) view.findViewById(R.id.item_grade3);
            aVar2.o = new ImageView[4];
            aVar2.o[1] = aVar2.l;
            aVar2.o[2] = aVar2.m;
            aVar2.o[3] = aVar2.n;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.h.setTag(null);
        aVar.h.setDefaultResource(R.drawable.avatar_poto_defaul140);
        aVar.h.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        aVar.h.setDrawBorder(true);
        aVar.h.setRadius(g.a((Context) this.a, 5.0f));
        if (getItemViewType(i) == 1) {
            aVar.a.setVisibility(0);
            aVar.g.setVisibility(8);
            if (this.d == BOTTOM_TYPE.LINE) {
                aVar.e.setVisibility(0);
                aVar.b.setVisibility(8);
            } else {
                aVar.e.setVisibility(8);
                aVar.b.setVisibility(0);
                if (this.d == BOTTOM_TYPE.HAVE_MORE) {
                    aVar.c.setText(R.string.frsgroup_load_more);
                    aVar.d.setVisibility(0);
                } else {
                    aVar.c.setText(R.string.frsgroup_no_more);
                    aVar.d.setVisibility(8);
                }
            }
        } else {
            GroupInfoData item = getItem(i);
            if (item != null) {
                String portrait = item.getPortrait();
                if (!TextUtils.isEmpty(portrait)) {
                    aVar.h.setTag(portrait);
                }
                aVar.i.setText(item.getName());
                aVar.j.setText(item.getMemberNum() + "/" + item.getMaxMemberNum());
                if (TextUtils.isEmpty(item.getForumShowName())) {
                    aVar.k.setText(item.getIntro());
                } else {
                    aVar.k.setText(item.getForumShowName() + item.getIntro());
                }
                a(aVar.o, item.getGrade());
            }
            this.a.a().a(TiebaApplication.h().al() == 1);
            this.a.a().a(view);
            if (item != null && item.isMemGroup()) {
                bs.a(aVar.i, R.color.im_group_vip_text, 1);
                bs.d(aVar.l, (int) R.drawable.icon_vip_grade_big_small_s);
                bs.d(aVar.m, (int) R.drawable.icon_vip_grade_big_small_s);
                bs.d(aVar.n, (int) R.drawable.icon_vip_grade_big_small_s);
            }
        }
        return view;
    }

    private void a(ImageView[] imageViewArr, int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 3) {
            i2 = 3;
        }
        for (int i3 = 1; i3 <= 3; i3++) {
            if (i3 <= i2) {
                imageViewArr[i3].setVisibility(0);
            } else {
                imageViewArr[i3].setVisibility(8);
            }
        }
    }

    private void c() {
        HashSet hashSet = new HashSet();
        Iterator<GroupInfoData> it = this.c.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(Integer.valueOf(it.next().getGroupId()))) {
                it.remove();
            }
        }
    }
}
