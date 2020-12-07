package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.ah;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private InterfaceC0687a hqG;
    private boolean hqH;
    private Context mContext;
    public List<ah> hqF = new ArrayList();
    private int gmm = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0687a {
        void a(View view, int i, ah ahVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hqH = z;
    }

    public void wF(int i) {
        this.gmm = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0687a interfaceC0687a) {
        this.hqG = interfaceC0687a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hqF == null) {
            return 0;
        }
        return this.hqF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wG */
    public ah getItem(int i) {
        return (ah) ListUtils.getItem(this.hqF, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<ah> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hqF.clear();
            this.hqF.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hqH) {
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
        final ah ahVar = this.hqF.get(i);
        if (this.gmm == i) {
            gVar.a(ahVar, true, this.hqH);
        } else {
            gVar.a(ahVar, false, this.hqH);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.gmm = i;
                a.this.notifyDataSetChanged();
                if (a.this.hqG != null) {
                    a.this.hqG.a(view2, i, ahVar);
                }
            }
        });
        return view;
    }
}
