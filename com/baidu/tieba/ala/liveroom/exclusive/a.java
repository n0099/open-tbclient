package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.aj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private InterfaceC0662a hxY;
    private boolean hxZ;
    private Context mContext;
    public List<aj> hxX = new ArrayList();
    private int gsf = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0662a {
        void a(View view, int i, aj ajVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hxZ = z;
    }

    public void vk(int i) {
        this.gsf = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0662a interfaceC0662a) {
        this.hxY = interfaceC0662a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hxX == null) {
            return 0;
        }
        return this.hxX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vl */
    public aj getItem(int i) {
        return (aj) ListUtils.getItem(this.hxX, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<aj> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hxX.clear();
            this.hxX.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hxZ) {
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
        final aj ajVar = this.hxX.get(i);
        if (this.gsf == i) {
            gVar.a(ajVar, true, this.hxZ);
        } else {
            gVar.a(ajVar, false, this.hxZ);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.gsf = i;
                a.this.notifyDataSetChanged();
                if (a.this.hxY != null) {
                    a.this.hxY.a(view2, i, ajVar);
                }
            }
        });
        return view;
    }
}
