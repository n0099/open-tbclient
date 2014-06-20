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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class GroupListAdapter extends BaseAdapter {
    private FrsGroupActivity a;
    private BOTTOM_TYPE b;
    private boolean c;
    private com.baidu.tbadk.editortool.ab d;
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
        this.d = new com.baidu.tbadk.editortool.ab(frsGroupActivity);
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
        p pVar;
        if (this.e == null) {
            return LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.im_frsgroup_list_item, viewGroup, false);
        }
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.im_frsgroup_list_item, viewGroup, false);
            pVar = new p();
            pVar.b = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_item_content);
            pVar.a = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_more);
            pVar.c = (HeadImageView) view.findViewById(com.baidu.tieba.v.item_head);
            pVar.d = (TextView) view.findViewById(com.baidu.tieba.v.item_group_name);
            pVar.e = (TextView) view.findViewById(com.baidu.tieba.v.item_group_meizi);
            pVar.f = (TextView) view.findViewById(com.baidu.tieba.v.item_group_num);
            pVar.g = (TextView) view.findViewById(com.baidu.tieba.v.item_introduce);
            pVar.m = (TextView) view.findViewById(com.baidu.tieba.v.list_more_title);
            pVar.n = (ProgressBar) view.findViewById(com.baidu.tieba.v.list_more_progress);
            pVar.o = (ImageView) view.findViewById(com.baidu.tieba.v.list_more_line);
            pVar.l = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_more_text);
            pVar.h = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade1);
            pVar.i = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade2);
            pVar.j = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade3);
            pVar.k = new ImageView[4];
            pVar.k[1] = pVar.h;
            pVar.k[2] = pVar.i;
            pVar.k[3] = pVar.j;
            view.setTag(pVar);
        } else {
            pVar = (p) view.getTag();
        }
        if (getItemViewType(i) == 1) {
            pVar.a.setVisibility(0);
            pVar.b.setVisibility(8);
            if (this.b == BOTTOM_TYPE.LINE) {
                pVar.o.setVisibility(0);
                pVar.l.setVisibility(8);
                return view;
            }
            pVar.o.setVisibility(8);
            pVar.l.setVisibility(0);
            if (this.b == BOTTOM_TYPE.HAVE_MORE) {
                pVar.m.setText(com.baidu.tieba.y.frsgroup_load_more);
                pVar.n.setVisibility(0);
                return view;
            }
            pVar.m.setText(com.baidu.tieba.y.frsgroup_no_more);
            pVar.n.setVisibility(8);
            return view;
        }
        pVar.a.setVisibility(8);
        pVar.b.setVisibility(0);
        GroupInfoData groupInfoData = (GroupInfoData) getItem(i);
        pVar.c.setTag(null);
        pVar.c.setDrawBorder(true);
        pVar.c.setDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
        pVar.c.setNightDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
        pVar.c.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        String portrait = groupInfoData.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            pVar.c.setTag(portrait);
        }
        pVar.d.setText(groupInfoData.getName());
        pVar.e.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
        pVar.f.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
        pVar.g.setText(groupInfoData.getIntro().trim());
        a(pVar.k, groupInfoData.getGrade());
        a(view);
        if (groupInfoData.isMemGroup()) {
            be.a(pVar.d, com.baidu.tieba.s.im_group_vip_text, 1);
            be.c(pVar.h, com.baidu.tieba.u.icon_vip_grade_big_small_s);
            be.c(pVar.i, com.baidu.tieba.u.icon_vip_grade_big_small_s);
            be.c(pVar.j, com.baidu.tieba.u.icon_vip_grade_big_small_s);
            return view;
        }
        return view;
    }

    private void a(View view) {
        this.a.a().a(TbadkApplication.m252getInst().getSkinType() == 1);
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

    public com.baidu.tbadk.editortool.ab b() {
        return this.d;
    }

    public boolean c() {
        return this.b == BOTTOM_TYPE.HAVE_MORE;
    }
}
