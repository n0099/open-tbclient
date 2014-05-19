package com.baidu.tieba.im.live.livelist;

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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class HotLiveListAdapter extends BaseAdapter {
    private HotLiveListActivity a;
    private BOTTOM_TYPE b;
    private boolean c;
    private com.baidu.tbadk.editortool.ab d;
    private boolean e;
    private ArrayList<LiveCardData> f = new ArrayList<>();

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
        this.f.addAll(list);
        b();
    }

    public void b(boolean z) {
        if (z) {
            this.f.clear();
            this.c = false;
            this.e = false;
            return;
        }
        this.c = true;
        this.e = false;
        this.b = BOTTOM_TYPE.LINE;
    }

    public HotLiveListAdapter(HotLiveListActivity hotLiveListActivity) {
        this.a = hotLiveListActivity;
        this.d = new com.baidu.tbadk.editortool.ab(hotLiveListActivity);
        this.d.d(true);
    }

    public void c(boolean z) {
        this.c = z;
    }

    public void a(BOTTOM_TYPE bottom_type) {
        this.b = bottom_type;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f != null) {
            int size = this.f.size();
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
        if (itemId < 0 || itemId >= this.f.size()) {
            return null;
        }
        return this.f.get(itemId);
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
        y yVar;
        if (this.f == null) {
            return LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.live_hot_list_item, viewGroup, false);
        }
        if (view == null) {
            view = LayoutInflater.from(this.a).inflate(com.baidu.tieba.s.live_hot_list_item, viewGroup, false);
            yVar = new y();
            yVar.a = (LinearLayout) view.findViewById(com.baidu.tieba.r.item_more);
            yVar.d = (TextView) view.findViewById(com.baidu.tieba.r.list_more_title);
            yVar.e = (ProgressBar) view.findViewById(com.baidu.tieba.r.list_more_progress);
            yVar.f = (ImageView) view.findViewById(com.baidu.tieba.r.list_more_line);
            yVar.c = (LinearLayout) view.findViewById(com.baidu.tieba.r.list_more_text);
            yVar.b = (LiveBroadcastCard) view.findViewById(com.baidu.tieba.r.item_card);
            view.setTag(yVar);
        } else {
            yVar = (y) view.getTag();
        }
        if (getItemViewType(i) == 1) {
            yVar.a.setVisibility(0);
            yVar.b.setVisibility(8);
            if (this.b == BOTTOM_TYPE.LINE) {
                yVar.f.setVisibility(0);
                yVar.c.setVisibility(8);
                return view;
            }
            yVar.f.setVisibility(8);
            yVar.c.setVisibility(0);
            if (this.b == BOTTOM_TYPE.HAVE_MORE) {
                yVar.d.setText(com.baidu.tieba.u.frsgroup_load_more);
                yVar.e.setVisibility(0);
                return view;
            }
            yVar.d.setText(com.baidu.tieba.u.frsgroup_no_more);
            yVar.e.setVisibility(8);
            return view;
        }
        yVar.a.setVisibility(8);
        yVar.b.setVisibility(0);
        LiveCardData liveCardData = (LiveCardData) getItem(i);
        yVar.b.a(liveCardData, this.d);
        a(yVar.b, liveCardData);
        a(view);
        return view;
    }

    private void a(LiveBroadcastCard liveBroadcastCard, LiveCardData liveCardData) {
        liveBroadcastCard.setTag(liveCardData);
        liveBroadcastCard.setCardClickListener(new x(this));
    }

    private void a(View view) {
        this.a.a().a(TbadkApplication.m252getInst().getSkinType() == 1);
        this.a.a().a(view);
    }

    private void b() {
        HashSet hashSet = new HashSet();
        Iterator<LiveCardData> it = this.f.iterator();
        while (it.hasNext()) {
            if (!hashSet.add(Integer.valueOf(it.next().getGroupId()))) {
                it.remove();
            }
        }
    }
}
