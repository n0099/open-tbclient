package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.an;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private InterfaceC0669a hEf;
    private boolean hEg;
    private Context mContext;
    public List<an> hEe = new ArrayList();
    private int gwM = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0669a {
        void a(View view, int i, an anVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hEg = z;
    }

    public void vx(int i) {
        this.gwM = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0669a interfaceC0669a) {
        this.hEf = interfaceC0669a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hEe == null) {
            return 0;
        }
        return this.hEe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vy */
    public an getItem(int i) {
        return (an) ListUtils.getItem(this.hEe, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<an> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hEe.clear();
            this.hEe.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hEg) {
                inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_exclusive_scene_item, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_exclusive_scene_land_item, (ViewGroup) null);
            }
            gVar = new g(inflate);
            inflate.setTag(gVar);
            view = inflate;
        } else {
            gVar = (g) view.getTag();
        }
        final an anVar = this.hEe.get(i);
        if (this.gwM == i) {
            gVar.a(anVar, true, this.hEg);
        } else {
            gVar.a(anVar, false, this.hEg);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.gwM = i;
                a.this.notifyDataSetChanged();
                if (a.this.hEf != null) {
                    a.this.hEf.a(view2, i, anVar);
                }
            }
        });
        return view;
    }
}
