package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.af;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private InterfaceC0673a hhw;
    private boolean hhx;
    private Context mContext;
    public List<af> hhv = new ArrayList();
    private int gex = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0673a {
        void a(View view, int i, af afVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hhx = z;
    }

    public void vC(int i) {
        this.gex = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0673a interfaceC0673a) {
        this.hhw = interfaceC0673a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hhv == null) {
            return 0;
        }
        return this.hhv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vD */
    public af getItem(int i) {
        return (af) ListUtils.getItem(this.hhv, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<af> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hhv.clear();
            this.hhv.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hhx) {
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
        final af afVar = this.hhv.get(i);
        if (this.gex == i) {
            gVar.a(afVar, true, this.hhx);
        } else {
            gVar.a(afVar, false, this.hhx);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.gex = i;
                a.this.notifyDataSetChanged();
                if (a.this.hhw != null) {
                    a.this.hhw.a(view2, i, afVar);
                }
            }
        });
        return view;
    }
}
