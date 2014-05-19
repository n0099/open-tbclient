package com.baidu.tieba.im.live.mylive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.LiveCardData;
import com.baidu.tbadk.coreExtra.view.LiveBroadcastCard;
import com.baidu.tbadk.coreExtra.view.ae;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class MyLiveListAdapter extends BaseAdapter {
    private MyLiveActivity a;
    private BOTTOM_TYPE b;
    private boolean c;
    private ab d;
    private boolean e;
    private ae h;
    private boolean f = false;
    private String g = "";
    private ArrayList<LiveCardData> i = new ArrayList<>();

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

    public boolean a() {
        return this.e;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(List<LiveCardData> list) {
        this.i.addAll(list);
        b();
    }

    public void a(LiveCardData liveCardData) {
        if (this.i != null) {
            this.i.remove(liveCardData);
            notifyDataSetChanged();
        }
    }

    public void a(boolean z, String str) {
        this.f = z;
        this.g = str;
        notifyDataSetChanged();
    }

    public void b(boolean z) {
        if (z) {
            this.i.clear();
            this.c = false;
            this.e = false;
            return;
        }
        this.c = true;
        this.e = false;
        this.b = BOTTOM_TYPE.LINE;
    }

    public MyLiveListAdapter(MyLiveActivity myLiveActivity, ae aeVar) {
        this.h = null;
        this.a = myLiveActivity;
        this.d = new ab(myLiveActivity);
        this.d.d(true);
        this.h = aeVar;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public void a(BOTTOM_TYPE bottom_type) {
        this.b = bottom_type;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.i != null) {
            int size = this.i.size();
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
        if (itemId < 0 || itemId >= this.i.size()) {
            return null;
        }
        return this.i.get(itemId);
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
        j jVar;
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(s.mylive_list_item, viewGroup, false);
            jVar = new j();
            jVar.a = (LinearLayout) view.findViewById(r.item_more);
            jVar.d = (TextView) view.findViewById(r.list_more_title);
            jVar.e = (ProgressBar) view.findViewById(r.list_more_progress);
            jVar.f = (ImageView) view.findViewById(r.list_more_line);
            jVar.c = (LinearLayout) view.findViewById(r.list_more_text);
            jVar.b = (LiveBroadcastCard) view.findViewById(r.item_card);
            view.setTag(jVar);
        } else {
            jVar = (j) view.getTag();
        }
        if (getItemViewType(i) == 1) {
            jVar.a.setVisibility(0);
            jVar.b.setVisibility(8);
            if (this.b == BOTTOM_TYPE.LINE) {
                jVar.f.setVisibility(0);
                jVar.c.setVisibility(8);
            } else {
                jVar.f.setVisibility(8);
                jVar.c.setVisibility(0);
                if (this.b == BOTTOM_TYPE.HAVE_MORE) {
                    jVar.d.setText(u.frsgroup_load_more);
                    jVar.e.setVisibility(0);
                } else {
                    jVar.d.setText(u.live_no_more_data);
                    jVar.e.setVisibility(8);
                }
            }
        } else {
            jVar.a.setVisibility(8);
            jVar.b.setVisibility(0);
            LiveCardData liveCardData = (LiveCardData) getItem(i);
            jVar.b.a(liveCardData, this.d);
            jVar.b.setCardClickListener(new i(this, liveCardData));
            if (this.f) {
                jVar.b.setClickable(false);
                jVar.b.a(true, this.g);
                jVar.b.setDeleteButtonClickListener(this.h);
            } else {
                jVar.b.setClickable(true);
                jVar.b.a(false, this.g);
            }
            a(view);
        }
        return view;
    }

    private void a(View view) {
        this.a.a().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.a().a(view);
    }

    private void b() {
        HashSet hashSet = new HashSet();
        Iterator<LiveCardData> it = this.i.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(Integer.valueOf(it.next().getGroupId()))) {
                it.remove();
            }
        }
    }
}
