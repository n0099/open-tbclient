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
    private InterfaceC0662a hCi;
    private boolean hCj;
    private Context mContext;
    public List<an> hCh = new ArrayList();
    private int guP = -1;

    /* renamed from: com.baidu.tieba.ala.liveroom.exclusive.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0662a {
        void a(View view, int i, an anVar);
    }

    public a(Context context, boolean z) {
        this.mContext = context;
        this.hCj = z;
    }

    public void vv(int i) {
        this.guP = i;
        notifyDataSetChanged();
    }

    public void a(InterfaceC0662a interfaceC0662a) {
        this.hCi = interfaceC0662a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.hCh == null) {
            return 0;
        }
        return this.hCh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vw */
    public an getItem(int i) {
        return (an) ListUtils.getItem(this.hCh, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<an> list) {
        if (!ListUtils.isEmpty(list)) {
            this.hCh.clear();
            this.hCh.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        g gVar;
        View inflate;
        if (view == null) {
            if (this.hCj) {
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
        final an anVar = this.hCh.get(i);
        if (this.guP == i) {
            gVar.a(anVar, true, this.hCj);
        } else {
            gVar.a(anVar, false, this.hCj);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.exclusive.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.guP = i;
                a.this.notifyDataSetChanged();
                if (a.this.hCi != null) {
                    a.this.hCi.a(view2, i, anVar);
                }
            }
        });
        return view;
    }
}
