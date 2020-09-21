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
    private InterfaceC0625a gBu;
    private boolean gBv;
    private Context mContext;
    public List<ac> gBt = new ArrayList();
    private int fDd = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0625a {
        void a(View view, int i, ac acVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.gBv = z;
    }

    public void uq(int i) {
        this.fDd = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0625a interfaceC0625a) {
        this.gBu = interfaceC0625a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.gBt == null) {
            return 0;
        }
        return this.gBt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ur */
    public ac getItem(int i) {
        return (ac) ListUtils.getItem(this.gBt, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<ac> list) {
        if (!ListUtils.isEmpty(list)) {
            this.gBt.clear();
            this.gBt.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.gBv) {
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
        final ac acVar = this.gBt.get(i);
        if (this.fDd == i) {
            gVar.a(acVar, true, this.gBv);
        } else {
            gVar.a(acVar, false, this.gBv);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.fDd = i;
                a.this.notifyDataSetChanged();
                if (a.this.gBu != null) {
                    a.this.gBu.a(view2, i, acVar);
                }
            }
        });
        return view;
    }
}
