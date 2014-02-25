package com.baidu.tieba.im.frsgroup;

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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.util.bq;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class GroupListAdapter extends BaseAdapter {
    private FrsGroupActivity a;
    private BOTTOM_TYPE b;
    private boolean c;
    private com.baidu.tieba.util.i d;
    private ArrayList<GroupInfoData> e = new ArrayList<>();

    /* loaded from: classes.dex */
    public enum BOTTOM_TYPE {
        LINE,
        HAVE_MORE,
        NO_MORE;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static BOTTOM_TYPE[] valuesCustom() {
            BOTTOM_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            BOTTOM_TYPE[] bottom_typeArr = new BOTTOM_TYPE[length];
            System.arraycopy(valuesCustom, 0, bottom_typeArr, 0, length);
            return bottom_typeArr;
        }
    }

    public void a(List<GroupInfoData> list) {
        this.e.addAll(list);
        d();
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

    public ArrayList<GroupInfoData> a() {
        return this.e;
    }

    public GroupListAdapter(FrsGroupActivity frsGroupActivity) {
        this.a = frsGroupActivity;
        this.d = new com.baidu.tieba.util.i(frsGroupActivity);
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
            return LayoutInflater.from(this.a).inflate(R.layout.im_frsgroup_list_item, viewGroup, false);
        }
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(R.layout.im_frsgroup_list_item, viewGroup, false);
            nVar = new n();
            nVar.b = (LinearLayout) view.findViewById(R.id.list_item_content);
            nVar.a = (LinearLayout) view.findViewById(R.id.list_more);
            nVar.c = (HeadImageView) view.findViewById(R.id.item_head);
            nVar.d = (TextView) view.findViewById(R.id.item_group_name);
            nVar.e = (TextView) view.findViewById(R.id.item_group_meizi);
            nVar.f = (TextView) view.findViewById(R.id.item_group_num);
            nVar.g = (TextView) view.findViewById(R.id.item_introduce);
            nVar.m = (TextView) view.findViewById(R.id.list_more_title);
            nVar.n = (ProgressBar) view.findViewById(R.id.list_more_progress);
            nVar.o = (ImageView) view.findViewById(R.id.list_more_line);
            nVar.l = (LinearLayout) view.findViewById(R.id.list_more_text);
            nVar.h = (ImageView) view.findViewById(R.id.item_grade1);
            nVar.i = (ImageView) view.findViewById(R.id.item_grade2);
            nVar.j = (ImageView) view.findViewById(R.id.item_grade3);
            nVar.k = new ImageView[4];
            nVar.k[1] = nVar.h;
            nVar.k[2] = nVar.i;
            nVar.k[3] = nVar.j;
            view.setTag(nVar);
        } else {
            nVar = (n) view.getTag();
        }
        if (getItemViewType(i) == 1) {
            nVar.a.setVisibility(0);
            nVar.b.setVisibility(8);
            if (this.b == BOTTOM_TYPE.LINE) {
                nVar.o.setVisibility(0);
                nVar.l.setVisibility(8);
                return view;
            }
            nVar.o.setVisibility(8);
            nVar.l.setVisibility(0);
            if (this.b == BOTTOM_TYPE.HAVE_MORE) {
                nVar.m.setText(R.string.frsgroup_load_more);
                nVar.n.setVisibility(0);
                return view;
            }
            nVar.m.setText(R.string.frsgroup_no_more);
            nVar.n.setVisibility(8);
            return view;
        }
        nVar.a.setVisibility(8);
        nVar.b.setVisibility(0);
        GroupInfoData groupInfoData = (GroupInfoData) getItem(i);
        nVar.c.setTag(null);
        nVar.c.setDrawBorder(true);
        nVar.c.setRadius(BdUtilHelper.a((Context) this.a, 5.0f));
        nVar.c.setDefaultResource(R.drawable.avatar_poto_defaul140);
        nVar.c.setNightDefaultResource(R.drawable.avatar_poto_defaul140);
        nVar.c.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        String portrait = groupInfoData.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            nVar.c.setTag(portrait);
        }
        nVar.d.setText(groupInfoData.getName());
        nVar.e.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
        nVar.f.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
        nVar.g.setText(groupInfoData.getIntro().trim());
        a(nVar.k, groupInfoData.getGrade());
        a(view);
        if (groupInfoData.isMemGroup()) {
            bq.a(nVar.d, R.color.im_group_vip_text, 1);
            bq.d(nVar.h, (int) R.drawable.icon_vip_grade_big_small_s);
            bq.d(nVar.i, (int) R.drawable.icon_vip_grade_big_small_s);
            bq.d(nVar.j, (int) R.drawable.icon_vip_grade_big_small_s);
            return view;
        }
        return view;
    }

    private void a(View view) {
        this.a.a().a(TiebaApplication.g().al() == 1);
        this.a.a().a(view);
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

    private void d() {
        HashSet hashSet = new HashSet();
        Iterator<GroupInfoData> it = this.e.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(Integer.valueOf(it.next().getGroupId()))) {
                it.remove();
            }
        }
    }

    public com.baidu.tieba.util.i b() {
        return this.d;
    }

    public boolean c() {
        return this.b == BOTTOM_TYPE.HAVE_MORE;
    }
}
