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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private InterfaceC0663a hCw;
    private boolean hCx;
    private Context mContext;
    public List<an> hCv = new ArrayList();
    private int gvd = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0663a {
        void a(View view, int i, an anVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hCx = z;
    }

    public void vv(int i) {
        this.gvd = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0663a interfaceC0663a) {
        this.hCw = interfaceC0663a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hCv == null) {
            return 0;
        }
        return this.hCv.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vw */
    public an getItem(int i) {
        return (an) ListUtils.getItem(this.hCv, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<an> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hCv.clear();
            this.hCv.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hCx) {
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
        final an anVar = this.hCv.get(i);
        if (this.gvd == i) {
            gVar.a(anVar, true, this.hCx);
        } else {
            gVar.a(anVar, false, this.hCx);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.gvd = i;
                a.this.notifyDataSetChanged();
                if (a.this.hCw != null) {
                    a.this.hCw.a(view2, i, anVar);
                }
            }
        });
        return view;
    }
}
