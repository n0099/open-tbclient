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
    private InterfaceC0629a gyj;
    private boolean gyk;
    private Context mContext;
    public List<x> gyi = new ArrayList();
    private int fzR = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0629a {
        void a(View view, int i, x xVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.gyk = z;
    }

    public void tX(int i) {
        this.fzR = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0629a interfaceC0629a) {
        this.gyj = interfaceC0629a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gyi == null) {
            return 0;
        }
        return this.gyi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tY */
    public x getItem(int i) {
        return (x) ListUtils.getItem(this.gyi, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<x> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gyi.clear();
            this.gyi.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.gyk) {
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
        final x xVar = this.gyi.get(i);
        if (this.fzR == i) {
            gVar.a(xVar, true, this.gyk);
        } else {
            gVar.a(xVar, false, this.gyk);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.fzR = i;
                a.this.notifyDataSetChanged();
                if (a.this.gyj != null) {
                    a.this.gyj.a(view2, i, xVar);
                }
            }
        });
        return view;
    }
}
