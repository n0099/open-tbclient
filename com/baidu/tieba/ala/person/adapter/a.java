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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private Context context;
    private int gQS;
    private InterfaceC0698a hVE;
    private c hVF;
    private b hVG;
    private List mList;
    private int mSkinType;
    private int type;

    /* renamed from: com.baidu.tieba.ala.person.adapter.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0698a {
        void a(bh bhVar, View view);
    }

    /* loaded from: classes11.dex */
    public interface b {
        void a(AlaLiveInfoData alaLiveInfoData, View view);
    }

    /* loaded from: classes11.dex */
    public interface c {
        void b(bh bhVar, View view);
    }

    public a(Context context, int i) {
        this.gQS = 2;
        this.context = context;
        this.gQS = i;
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
                if (this.gQS == 1) {
                    if (this.type == 1 || this.type == 0) {
                        view = LayoutInflater.from(this.context).inflate(a.g.ala_person_list_item_layout, (ViewGroup) null);
                        dVar = new com.baidu.tieba.ala.person.view.b(view, this.gQS);
                    } else if (this.type == 2) {
                        view = LayoutInflater.from(this.context).inflate(a.g.ala_playbacks_list_item_layout, (ViewGroup) null);
                        dVar = new f(view, this.gQS);
                    }
                } else if (this.gQS == 2) {
                    view = LayoutInflater.from(this.context).inflate(a.g.ala_person_card_list_item_layout, (ViewGroup) null);
                    dVar = new com.baidu.tieba.ala.person.view.b(view, this.gQS);
                }
                if (dVar != null) {
                    dVar.a(this.hVE);
                    dVar.a(this.hVG);
                    dVar.a(this.hVF);
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
                            bhVar.aQP = 1;
                        } else {
                            bhVar.aQP = 0;
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

    public void a(InterfaceC0698a interfaceC0698a) {
        this.hVE = interfaceC0698a;
    }

    public void a(c cVar) {
        this.hVF = cVar;
    }

    public void a(b bVar) {
        this.hVG = bVar;
    }
}
