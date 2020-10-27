package com.baidu.tieba.ala.liveroom.exclusive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.data.ae;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private InterfaceC0659a hbB;
    private boolean hbC;
    private Context mContext;
    public List<ae> hbA = new ArrayList();
    private int fYF = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0659a {
        void a(View view, int i, ae aeVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hbC = z;
    }

    public void vp(int i) {
        this.fYF = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0659a interfaceC0659a) {
        this.hbB = interfaceC0659a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hbA == null) {
            return 0;
        }
        return this.hbA.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vq */
    public ae getItem(int i) {
        return (ae) ListUtils.getItem(this.hbA, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<ae> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hbA.clear();
            this.hbA.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hbC) {
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
        final ae aeVar = this.hbA.get(i);
        if (this.fYF == i) {
            gVar.a(aeVar, true, this.hbC);
        } else {
            gVar.a(aeVar, false, this.hbC);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.fYF = i;
                a.this.notifyDataSetChanged();
                if (a.this.hbB != null) {
                    a.this.hbB.a(view2, i, aeVar);
                }
            }
        });
        return view;
    }
}
