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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private Context context;
    private int fRo;
    private InterfaceC0648a gPB;
    private c gPC;
    private b gPD;
    private List mList;
    private int mSkinType;
    private int type;

    /* renamed from: com.baidu.tieba.ala.person.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0648a {
        void a(com.baidu.tieba.ala.person.a.b bVar, View view);
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(AlaLiveInfoData alaLiveInfoData, View view);
    }

    /* loaded from: classes7.dex */
    public interface c {
        void b(com.baidu.tieba.ala.person.a.b bVar, View view);
    }

    public a(Context context, int i) {
        this.fRo = 2;
        this.context = context;
        this.fRo = i;
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
                if (this.fRo == 1) {
                    if (this.type == 1 || this.type == 0) {
                        view = LayoutInflater.from(this.context).inflate(a.h.ala_person_list_item_layout, (ViewGroup) null);
                        cVar = new com.baidu.tieba.ala.person.view.b(view, this.fRo);
                    } else if (this.type == 2) {
                        view = LayoutInflater.from(this.context).inflate(a.h.ala_playbacks_list_item_layout, (ViewGroup) null);
                        cVar = new e(view, this.fRo);
                    }
                } else if (this.fRo == 2) {
                    view = LayoutInflater.from(this.context).inflate(a.h.ala_person_card_list_item_layout, (ViewGroup) null);
                    cVar = new com.baidu.tieba.ala.person.view.b(view, this.fRo);
                }
                if (cVar != null) {
                    cVar.a(this.gPB);
                    cVar.a(this.gPD);
                    cVar.a(this.gPC);
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

    public void aw(String str, boolean z) {
        if (str != null && !ListUtils.isEmpty(this.mList)) {
            for (Object obj : this.mList) {
                if (this.type != 2 && (obj instanceof com.baidu.tieba.ala.person.a.b)) {
                    com.baidu.tieba.ala.person.a.b bVar = (com.baidu.tieba.ala.person.a.b) obj;
                    if (str.equals(bVar.id)) {
                        if (z) {
                            bVar.ghn = 1;
                        } else {
                            bVar.ghn = 0;
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

    public void a(InterfaceC0648a interfaceC0648a) {
        this.gPB = interfaceC0648a;
    }

    public void a(c cVar) {
        this.gPC = cVar;
    }

    public void a(b bVar) {
        this.gPD = bVar;
    }
}
