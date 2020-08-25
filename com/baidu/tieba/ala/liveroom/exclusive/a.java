package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private InterfaceC0629a gyf;
    private boolean gyg;
    private Context mContext;
    public List<x> gye = new ArrayList();
    private int fzN = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0629a {
        void a(View view, int i, x xVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.gyg = z;
    }

    public void tX(int i) {
        this.fzN = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0629a interfaceC0629a) {
        this.gyf = interfaceC0629a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gye == null) {
            return 0;
        }
        return this.gye.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tY */
    public x getItem(int i) {
        return (x) ListUtils.getItem(this.gye, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<x> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gye.clear();
            this.gye.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.gyg) {
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
        final x xVar = this.gye.get(i);
        if (this.fzN == i) {
            gVar.a(xVar, true, this.gyg);
        } else {
            gVar.a(xVar, false, this.gyg);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.fzN = i;
                a.this.notifyDataSetChanged();
                if (a.this.gyf != null) {
                    a.this.gyf.a(view2, i, xVar);
                }
            }
        });
        return view;
    }
}
