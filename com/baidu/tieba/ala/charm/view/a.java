package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class a extends BaseAdapter {
    private ArrayList<ALaCharmData> bbZ = new ArrayList<>();
    private View.OnClickListener dGj;
    private View.OnClickListener dGk;
    private View.OnClickListener dGl;
    private int dGm;
    private TbPageContext mPageContext;
    private int mSkinType;

    public a(TbPageContext tbPageContext, int i) {
        this.dGm = 1;
        this.mPageContext = tbPageContext;
        this.dGm = i;
    }

    public void m(View.OnClickListener onClickListener) {
        this.dGj = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.dGl = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.dGk = onClickListener;
    }

    public void setData(ArrayList<ALaCharmData> arrayList) {
        if (arrayList != null) {
            this.bbZ.clear();
            this.bbZ.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void L(ArrayList<ALaCharmData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.bbZ.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.bbZ == null) {
            return 0;
        }
        return this.bbZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: mx */
    public ALaCharmData getItem(int i) {
        if (this.bbZ == null) {
            return null;
        }
        return this.bbZ.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        View inflate;
        if (view == null) {
            if (this.dGm == 1) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_detail_list_layout, (ViewGroup) null);
            } else if (this.dGm == 2) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_list_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_detail_list_layout, (ViewGroup) null);
            }
            d dVar2 = new d(inflate, this.dGm);
            dVar2.p(this.dGl);
            dVar2.m(this.dGj);
            dVar2.q(this.dGk);
            inflate.setTag(dVar2);
            view = inflate;
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        if (dVar != null) {
            dVar.a(i, getItem(i), this.mSkinType);
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void T(String str, boolean z) {
        if (this.bbZ != null && str != null) {
            Iterator<ALaCharmData> it = this.bbZ.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ALaCharmData next = it.next();
                if (str.equals(next.pay_userid)) {
                    if (z) {
                        next.follow_status = 1;
                    } else {
                        next.follow_status = 0;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public void setSkinType(int i) {
        this.mSkinType = i;
    }
}
