package com.baidu.tieba.ala.person.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.bl;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.person.view.d;
import com.baidu.tieba.ala.person.view.f;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private Context context;
    private int gQP;
    private InterfaceC0688a hXp;
    private c hXq;
    private b hXr;
    private List mList;
    private int mSkinType;
    private int type;

    /* renamed from: com.baidu.tieba.ala.person.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0688a {
        void a(bl blVar, View view);
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(AlaLiveInfoData alaLiveInfoData, View view);
    }

    /* loaded from: classes10.dex */
    public interface c {
        void b(bl blVar, View view);
    }

    public a(Context context, int i) {
        this.gQP = 2;
        this.context = context;
        this.gQP = i;
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
                if (this.gQP == 1) {
                    if (this.type == 1 || this.type == 0) {
                        view = LayoutInflater.from(this.context).inflate(a.g.ala_person_list_item_layout, (ViewGroup) null);
                        dVar = new com.baidu.tieba.ala.person.view.b(view, this.gQP);
                    } else if (this.type == 2) {
                        view = LayoutInflater.from(this.context).inflate(a.g.ala_playbacks_list_item_layout, (ViewGroup) null);
                        dVar = new f(view, this.gQP);
                    }
                } else if (this.gQP == 2) {
                    view = LayoutInflater.from(this.context).inflate(a.g.ala_person_card_list_item_layout, (ViewGroup) null);
                    dVar = new com.baidu.tieba.ala.person.view.b(view, this.gQP);
                }
                if (dVar != null) {
                    dVar.a(this.hXp);
                    dVar.a(this.hXr);
                    dVar.a(this.hXq);
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
            dVar.b(obj, this.mSkinType);
        }
        return view;
    }

    public void aD(String str, boolean z) {
        if (str != null && !ListUtils.isEmpty(this.mList)) {
            for (Object obj : this.mList) {
                if (this.type != 2 && (obj instanceof bl)) {
                    bl blVar = (bl) obj;
                    if (str.equals(blVar.id)) {
                        if (z) {
                            blVar.aQz = 1;
                        } else {
                            blVar.aQz = 0;
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

    public void a(InterfaceC0688a interfaceC0688a) {
        this.hXp = interfaceC0688a;
    }

    public void a(c cVar) {
        this.hXq = cVar;
    }

    public void a(b bVar) {
        this.hXr = bVar;
    }
}
