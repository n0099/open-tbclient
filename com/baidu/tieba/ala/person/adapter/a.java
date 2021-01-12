package com.baidu.tieba.ala.person.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bh;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.person.view.d;
import com.baidu.tieba.ala.person.view.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private Context context;
    private int gMm;
    private InterfaceC0681a hQX;
    private c hQY;
    private b hQZ;
    private List mList;
    private int mSkinType;
    private int type;

    /* renamed from: com.baidu.tieba.ala.person.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0681a {
        void a(bh bhVar, View view);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(AlaLiveInfoData alaLiveInfoData, View view);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void b(bh bhVar, View view);
    }

    public a(Context context, int i) {
        this.gMm = 2;
        this.context = context;
        this.gMm = i;
    }

    public void a(boolean z, List list, int i) {
        if (this.mList == null) {
            this.mList = new ArrayList();
        }
        if (z) {
            this.mList.clear();
        }
        if (list != null) {
            this.mList.addAll(list);
        }
        this.type = i;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        d dVar = null;
        if (view == null) {
            if (this.mList.get(i) != null) {
                if (this.gMm == 1) {
                    if (this.type == 1 || this.type == 0) {
                        view = LayoutInflater.from(this.context).inflate(a.g.ala_person_list_item_layout, (ViewGroup) null);
                        dVar = new com.baidu.tieba.ala.person.view.b(view, this.gMm);
                    } else if (this.type == 2) {
                        view = LayoutInflater.from(this.context).inflate(a.g.ala_playbacks_list_item_layout, (ViewGroup) null);
                        dVar = new f(view, this.gMm);
                    }
                } else if (this.gMm == 2) {
                    view = LayoutInflater.from(this.context).inflate(a.g.ala_person_card_list_item_layout, (ViewGroup) null);
                    dVar = new com.baidu.tieba.ala.person.view.b(view, this.gMm);
                }
                if (dVar != null) {
                    dVar.a(this.hQX);
                    dVar.a(this.hQZ);
                    dVar.a(this.hQY);
                }
                if (view != null) {
                    view.setTag(dVar);
                }
            }
        } else {
            dVar = (d) view.getTag();
        }
        Object obj = this.mList.get(i);
        if (dVar != null && obj != null) {
            dVar.c(obj, this.mSkinType);
        }
        return view;
    }

    public void aE(String str, boolean z) {
        if (str != null && !ListUtils.isEmpty(this.mList)) {
            for (Object obj : this.mList) {
                if (this.type != 2 && (obj instanceof bh)) {
                    bh bhVar = (bh) obj;
                    if (str.equals(bhVar.id)) {
                        if (z) {
                            bhVar.aMc = 1;
                        } else {
                            bhVar.aMc = 0;
                        }
                        notifyDataSetChanged();
                        return;
                    }
                }
            }
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }

    public void a(InterfaceC0681a interfaceC0681a) {
        this.hQX = interfaceC0681a;
    }

    public void a(c cVar) {
        this.hQY = cVar;
    }

    public void a(b bVar) {
        this.hQZ = bVar;
    }
}
