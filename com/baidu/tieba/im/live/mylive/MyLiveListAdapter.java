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
import com.baidu.tbadk.coreExtra.view.ag;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class MyLiveListAdapter extends BaseAdapter {
    private MyLiveActivity a;
    private BOTTOM_TYPE b;
    private boolean c;
    private boolean d;
    private ag g;
    private boolean e = false;
    private String f = "";
    private ArrayList<LiveCardData> h = new ArrayList<>();

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
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public void a(List<LiveCardData> list) {
        this.h.addAll(list);
        c();
    }

    public void a(LiveCardData liveCardData) {
        if (this.h != null) {
            this.h.remove(liveCardData);
            notifyDataSetChanged();
        }
    }

    public void a(boolean z, String str) {
        this.e = z;
        this.f = str;
        notifyDataSetChanged();
    }

    public void b(boolean z) {
        if (z) {
            this.h.clear();
            this.c = false;
            this.d = false;
            return;
        }
        this.c = true;
        this.d = false;
        this.b = BOTTOM_TYPE.LINE;
    }

    public MyLiveListAdapter(MyLiveActivity myLiveActivity, ag agVar) {
        this.g = null;
        this.a = myLiveActivity;
        this.g = agVar;
    }

    public boolean b() {
        return this.c;
    }

    public void c(boolean z) {
        this.c = z;
    }

    public void a(BOTTOM_TYPE bottom_type) {
        this.b = bottom_type;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.h != null) {
            int size = this.h.size();
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
        if (itemId < 0 || itemId >= this.h.size()) {
            return null;
        }
        return this.h.get(itemId);
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
            view = LayoutInflater.from(this.a).inflate(v.mylive_list_item, viewGroup, false);
            jVar = new j();
            jVar.a = (LinearLayout) view.findViewById(u.item_more);
            jVar.d = (TextView) view.findViewById(u.list_more_title);
            jVar.e = (ProgressBar) view.findViewById(u.list_more_progress);
            jVar.f = (ImageView) view.findViewById(u.list_more_line);
            jVar.c = (LinearLayout) view.findViewById(u.list_more_text);
            jVar.b = (LiveBroadcastCard) view.findViewById(u.item_card);
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
                    jVar.d.setText(x.live_load_more);
                    jVar.e.setVisibility(0);
                } else {
                    jVar.d.setText(x.live_no_more_data);
                    jVar.e.setVisibility(8);
                }
            }
        } else {
            jVar.a.setVisibility(8);
            jVar.b.setVisibility(0);
            LiveCardData liveCardData = (LiveCardData) getItem(i);
            jVar.b.setData(liveCardData);
            jVar.b.setCardClickListener(new i(this, liveCardData));
            if (this.e) {
                jVar.b.setClickable(false);
                jVar.b.a(true, this.f);
                jVar.b.setDeleteButtonClickListener(this.g);
            } else {
                jVar.b.setClickable(true);
                jVar.b.a(false, this.f);
            }
            a(view);
        }
        return view;
    }

    private void a(View view) {
        this.a.c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.c().a(view);
    }

    private void c() {
        HashSet hashSet = new HashSet();
        Iterator<LiveCardData> it = this.h.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(Integer.valueOf(it.next().getGroupId()))) {
                it.remove();
            }
        }
    }
}
