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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private InterfaceC0679a hCE;
    private boolean hCF;
    private Context mContext;
    public List<aj> hCD = new ArrayList();
    private int gwM = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0679a {
        void a(View view, int i, aj ajVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hCF = z;
    }

    public void wQ(int i) {
        this.gwM = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0679a interfaceC0679a) {
        this.hCE = interfaceC0679a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hCD == null) {
            return 0;
        }
        return this.hCD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wR */
    public aj getItem(int i) {
        return (aj) ListUtils.getItem(this.hCD, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<aj> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hCD.clear();
            this.hCD.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hCF) {
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
        final aj ajVar = this.hCD.get(i);
        if (this.gwM == i) {
            gVar.a(ajVar, true, this.hCF);
        } else {
            gVar.a(ajVar, false, this.hCF);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.gwM = i;
                a.this.notifyDataSetChanged();
                if (a.this.hCE != null) {
                    a.this.hCE.a(view2, i, ajVar);
                }
            }
        });
        return view;
    }
}
