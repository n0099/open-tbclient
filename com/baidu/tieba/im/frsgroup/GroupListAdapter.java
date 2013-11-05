package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class GroupListAdapter extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private FrsGroupActivity f1548a;
    private BOTTOM_TYPE b;
    private boolean c;
    private com.baidu.tieba.util.a d;
    private ArrayList<GroupInfoData> e = new ArrayList<>();

    /* loaded from: classes.dex */
    public enum BOTTOM_TYPE {
        LINE,
        HAVE_MORE,
        NO_MORE
    }

    public void a(List<GroupInfoData> list) {
        this.e.addAll(list);
        c();
    }

    public void a(boolean z) {
        if (z) {
            this.e.clear();
            this.c = false;
            return;
        }
        this.c = true;
        this.b = BOTTOM_TYPE.LINE;
    }

    public GroupListAdapter(FrsGroupActivity frsGroupActivity) {
        this.f1548a = frsGroupActivity;
        this.d = new com.baidu.tieba.util.a(frsGroupActivity);
        this.d.d(true);
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void a(BOTTOM_TYPE bottom_type) {
        this.b = bottom_type;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.e != null) {
            int size = this.e.size();
            if (this.c) {
                return size + 1;
            }
            return size;
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.e.size()) {
            return null;
        }
        return this.e.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (i == getCount() - 1 && this.c) {
            i = -2;
        }
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return getItemId(i) >= 0 ? 0 : 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        n nVar;
        if (this.e == null) {
            return LayoutInflater.from(this.f1548a).inflate(R.layout.im_entergroup_list_item, viewGroup, false);
        }
        if (view == null) {
            view = LayoutInflater.from(this.f1548a).inflate(R.layout.im_entergroup_list_item, viewGroup, false);
            nVar = new n();
            nVar.b = (LinearLayout) view.findViewById(R.id.list_content);
            nVar.f1569a = (LinearLayout) view.findViewById(R.id.list_more);
            nVar.c = (HeadImageView) view.findViewById(R.id.item_head);
            nVar.d = (TextView) view.findViewById(R.id.item_name);
            nVar.e = (TextView) view.findViewById(R.id.item_num);
            nVar.f = (TextView) view.findViewById(R.id.item_introduce);
            nVar.l = (TextView) view.findViewById(R.id.list_more_title);
            nVar.m = (ProgressBar) view.findViewById(R.id.list_more_progress);
            nVar.n = (ImageView) view.findViewById(R.id.list_more_line);
            nVar.k = (LinearLayout) view.findViewById(R.id.list_more_text);
            nVar.g = (ImageView) view.findViewById(R.id.item_grade1);
            nVar.h = (ImageView) view.findViewById(R.id.item_grade2);
            nVar.i = (ImageView) view.findViewById(R.id.item_grade3);
            nVar.j = new ImageView[4];
            nVar.j[1] = nVar.g;
            nVar.j[2] = nVar.h;
            nVar.j[3] = nVar.i;
            view.setTag(nVar);
        } else {
            nVar = (n) view.getTag();
        }
        if (getItemViewType(i) == 1) {
            nVar.f1569a.setVisibility(0);
            nVar.b.setVisibility(8);
            if (this.b == BOTTOM_TYPE.LINE) {
                nVar.n.setVisibility(0);
                nVar.k.setVisibility(8);
                return view;
            }
            nVar.n.setVisibility(8);
            nVar.k.setVisibility(0);
            if (this.b == BOTTOM_TYPE.HAVE_MORE) {
                nVar.l.setText(R.string.frsgroup_load_more);
                nVar.m.setVisibility(0);
                return view;
            }
            nVar.l.setText(R.string.frsgroup_no_more);
            nVar.m.setVisibility(8);
            return view;
        }
        nVar.f1569a.setVisibility(8);
        nVar.b.setVisibility(0);
        GroupInfoData groupInfoData = (GroupInfoData) getItem(i);
        nVar.c.setTag(null);
        nVar.c.setTag(null);
        nVar.c.setDefaultId(R.drawable.avatar_poto_defaul140);
        nVar.c.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        String portrait = groupInfoData.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            nVar.c.setTag(portrait);
        }
        nVar.d.setText(groupInfoData.getName());
        nVar.e.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
        nVar.f.setText(groupInfoData.getIntro());
        a(nVar.j, groupInfoData.getGrade());
        a(view);
        return view;
    }

    private void a(View view) {
        this.f1548a.a().a(TiebaApplication.g().as() == 1);
        this.f1548a.a().a(view);
    }

    private void a(ImageView[] imageViewArr, int i) {
        int i2 = i < 0 ? 0 : i;
        int i3 = i2 > 3 ? 3 : i2;
        int i4 = 1;
        if (i3 >= 1) {
            while (i4 <= i3) {
                imageViewArr[i4].setVisibility(0);
                i4++;
            }
            while (i4 <= 3) {
                imageViewArr[i4].setVisibility(8);
                i4++;
            }
        }
    }

    private void c() {
        HashSet hashSet = new HashSet();
        Iterator<GroupInfoData> it = this.e.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(Integer.valueOf(it.next().getGroupId()))) {
                it.remove();
            }
        }
    }

    public com.baidu.tieba.util.a a() {
        return this.d;
    }

    public boolean b() {
        return this.b == BOTTOM_TYPE.HAVE_MORE;
    }
}
