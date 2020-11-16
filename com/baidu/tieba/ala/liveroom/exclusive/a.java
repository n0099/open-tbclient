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
    private InterfaceC0673a hhd;
    private boolean hhe;
    private Context mContext;
    public List<af> hhc = new ArrayList();
    private int ged = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0673a {
        void a(View view, int i, af afVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hhe = z;
    }

    public void wa(int i) {
        this.ged = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0673a interfaceC0673a) {
        this.hhd = interfaceC0673a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hhc == null) {
            return 0;
        }
        return this.hhc.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wb */
    public af getItem(int i) {
        return (af) ListUtils.getItem(this.hhc, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<af> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hhc.clear();
            this.hhc.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hhe) {
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
        final af afVar = this.hhc.get(i);
        if (this.ged == i) {
            gVar.a(afVar, true, this.hhe);
        } else {
            gVar.a(afVar, false, this.hhe);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ged = i;
                a.this.notifyDataSetChanged();
                if (a.this.hhd != null) {
                    a.this.hhd.a(view2, i, afVar);
                }
            }
        });
        return view;
    }
}
