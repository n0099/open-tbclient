package com.baidu.tieba.ala.person.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.person.view.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private Context context;
    private int fAN;
    private InterfaceC0589a gxB;
    private c gxC;
    private b gxD;
    private List mList;
    private int mSkinType;
    private int type;

    /* renamed from: com.baidu.tieba.ala.person.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0589a {
        void a(com.baidu.tieba.ala.person.a.b bVar, View view);
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(AlaLiveInfoData alaLiveInfoData, View view);
    }

    /* loaded from: classes3.dex */
    public interface c {
        void b(com.baidu.tieba.ala.person.a.b bVar, View view);
    }

    public a(Context context, int i) {
        this.fAN = 2;
        this.context = context;
        this.fAN = i;
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
        com.baidu.tieba.ala.person.view.c cVar = null;
        if (view == null) {
            if (this.mList.get(i) != null) {
                if (this.fAN == 1) {
                    if (this.type == 1 || this.type == 0) {
                        view = LayoutInflater.from(this.context).inflate(a.h.ala_person_list_item_layout, (ViewGroup) null);
                        cVar = new com.baidu.tieba.ala.person.view.b(view, this.fAN);
                    } else if (this.type == 2) {
                        view = LayoutInflater.from(this.context).inflate(a.h.ala_playbacks_list_item_layout, (ViewGroup) null);
                        cVar = new e(view, this.fAN);
                    }
                } else if (this.fAN == 2) {
                    view = LayoutInflater.from(this.context).inflate(a.h.ala_person_card_list_item_layout, (ViewGroup) null);
                    cVar = new com.baidu.tieba.ala.person.view.b(view, this.fAN);
                }
                if (cVar != null) {
                    cVar.a(this.gxB);
                    cVar.a(this.gxD);
                    cVar.a(this.gxC);
                }
                if (view != null) {
                    view.setTag(cVar);
                }
            }
        } else {
            cVar = (com.baidu.tieba.ala.person.view.c) view.getTag();
        }
        Object obj = this.mList.get(i);
        if (cVar != null && obj != null) {
            cVar.b(obj, this.mSkinType);
        }
        return view;
    }

    public void au(String str, boolean z) {
        if (str != null && !ListUtils.isEmpty(this.mList)) {
            for (Object obj : this.mList) {
                if (this.type != 2 && (obj instanceof com.baidu.tieba.ala.person.a.b)) {
                    com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
                    if (str.equals(bVar.id)) {
                        if (z) {
                            bVar.fPV = 1;
                        } else {
                            bVar.fPV = 0;
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

    public void a(InterfaceC0589a interfaceC0589a) {
        this.gxB = interfaceC0589a;
    }

    public void a(c cVar) {
        this.gxC = cVar;
    }

    public void a(b bVar) {
        this.gxD = bVar;
    }
}
