package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.ac;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private InterfaceC0643a gPN;
    private boolean gPO;
    private Context mContext;
    public List<ac> gPM = new ArrayList();
    private int fPm = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0643a {
        void a(View view, int i, ac acVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.gPO = z;
    }

    public void uV(int i) {
        this.fPm = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0643a interfaceC0643a) {
        this.gPN = interfaceC0643a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gPM == null) {
            return 0;
        }
        return this.gPM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uW */
    public ac getItem(int i) {
        return (ac) ListUtils.getItem(this.gPM, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<ac> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gPM.clear();
            this.gPM.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.gPO) {
                inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_exclusive_scene_item, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_exclusive_scene_land_item, (ViewGroup) null);
            }
            gVar = new g(inflate);
            inflate.setTag(gVar);
            view = inflate;
        } else {
            gVar = (g) view.getTag();
        }
        final ac acVar = this.gPM.get(i);
        if (this.fPm == i) {
            gVar.a(acVar, true, this.gPO);
        } else {
            gVar.a(acVar, false, this.gPO);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.fPm = i;
                a.this.notifyDataSetChanged();
                if (a.this.gPN != null) {
                    a.this.gPN.a(view2, i, acVar);
                }
            }
        });
        return view;
    }
}
