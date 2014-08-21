package com.baidu.tieba.im.frsgroup;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.GroupImageView;
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
    private ArrayList<GroupInfoData> d = new ArrayList<>();

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
        this.d.addAll(list);
        c();
    }

    public void a(boolean z) {
        if (z) {
            this.d.clear();
            this.c = false;
            return;
        }
        this.c = true;
        this.b = BOTTOM_TYPE.LINE;
    }

    public ArrayList<GroupInfoData> a() {
        return this.d;
    }

    public GroupListAdapter(FrsGroupActivity frsGroupActivity) {
        this.a = frsGroupActivity;
    }

    public void b(boolean z) {
        this.c = z;
    }

    public void a(BOTTOM_TYPE bottom_type) {
        this.b = bottom_type;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.d != null) {
            int size = this.d.size();
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
        if (itemId < 0 || itemId >= this.d.size()) {
            return null;
        }
        return this.d.get(itemId);
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
        o oVar;
        if (this.d == null) {
            return com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.im_frsgroup_list_item, viewGroup, false);
        }
        if (view == null) {
            view = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.im_frsgroup_list_item, viewGroup, false);
            oVar = new o();
            oVar.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.list_item_content);
            oVar.a = (LinearLayout) view.findViewById(com.baidu.tieba.u.list_more);
            oVar.c = (GroupImageView) view.findViewById(com.baidu.tieba.u.item_head);
            oVar.d = (TextView) view.findViewById(com.baidu.tieba.u.item_group_name);
            oVar.e = (TextView) view.findViewById(com.baidu.tieba.u.item_group_meizi);
            oVar.f = (TextView) view.findViewById(com.baidu.tieba.u.item_group_num);
            oVar.g = (TextView) view.findViewById(com.baidu.tieba.u.item_introduce);
            oVar.m = (TextView) view.findViewById(com.baidu.tieba.u.list_more_title);
            oVar.n = (ProgressBar) view.findViewById(com.baidu.tieba.u.list_more_progress);
            oVar.o = (ImageView) view.findViewById(com.baidu.tieba.u.list_more_line);
            oVar.l = (LinearLayout) view.findViewById(com.baidu.tieba.u.list_more_text);
            oVar.h = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade1);
            oVar.i = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade2);
            oVar.j = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade3);
            oVar.k = new ImageView[4];
            oVar.k[1] = oVar.h;
            oVar.k[2] = oVar.i;
            oVar.k[3] = oVar.j;
            view.setTag(oVar);
        } else {
            oVar = (o) view.getTag();
        }
        if (getItemViewType(i) == 1) {
            oVar.a.setVisibility(0);
            oVar.b.setVisibility(8);
            if (this.b == BOTTOM_TYPE.LINE) {
                oVar.o.setVisibility(0);
                oVar.l.setVisibility(8);
                return view;
            }
            oVar.o.setVisibility(8);
            oVar.l.setVisibility(0);
            if (this.b == BOTTOM_TYPE.HAVE_MORE) {
                oVar.m.setText(com.baidu.tieba.x.frsgroup_load_more);
                oVar.n.setVisibility(0);
                return view;
            }
            oVar.m.setText(com.baidu.tieba.x.frsgroup_no_more);
            oVar.n.setVisibility(8);
            return view;
        }
        oVar.a.setVisibility(8);
        oVar.b.setVisibility(0);
        GroupInfoData groupInfoData = (GroupInfoData) getItem(i);
        oVar.c.setTag(null);
        oVar.c.setDrawBorder(true);
        oVar.c.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        String portrait = groupInfoData.getPortrait();
        if (!TextUtils.isEmpty(portrait)) {
            oVar.c.setTag(portrait);
            oVar.c.a(portrait, 10, false);
        }
        oVar.d.setText(groupInfoData.getName());
        oVar.e.setVisibility(groupInfoData.autorIsMeizhi() ? 0 : 8);
        oVar.f.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
        oVar.g.setText(groupInfoData.getIntro().trim());
        a(oVar.k, groupInfoData.getGrade());
        a(view);
        if (groupInfoData.isMemGroup()) {
            ay.a(oVar.d, com.baidu.tieba.r.im_group_vip_text, 1);
            ay.c(oVar.h, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            ay.c(oVar.i, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            ay.c(oVar.j, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            return view;
        }
        return view;
    }

    private void a(View view) {
        this.a.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.c().a(view);
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
        Iterator<GroupInfoData> it = this.d.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(Integer.valueOf(it.next().getGroupId()))) {
                it.remove();
            }
        }
    }

    public boolean b() {
        return this.b == BOTTOM_TYPE.HAVE_MORE;
    }
}
