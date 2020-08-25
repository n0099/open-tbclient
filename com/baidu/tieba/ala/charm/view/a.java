package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ArrayList<ALaCharmData> efX = new ArrayList<>();
    private View.OnClickListener fRl;
    private View.OnClickListener fRm;
    private View.OnClickListener fRn;
    private int fRo;
    private TbPageContext mPageContext;
    private int mSkinType;

    public a(TbPageContext tbPageContext, int i) {
        this.fRo = 1;
        this.mPageContext = tbPageContext;
        this.fRo = i;
    }

    public void m(View.OnClickListener onClickListener) {
        this.fRl = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.fRn = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.fRm = onClickListener;
    }

    public void setData(ArrayList<ALaCharmData> arrayList) {
        if (arrayList != null) {
            this.efX.clear();
            this.efX.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void ab(ArrayList<ALaCharmData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.efX.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.efX == null) {
            return 0;
        }
        return this.efX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sZ */
    public ALaCharmData getItem(int i) {
        if (this.efX == null) {
            return null;
        }
        return this.efX.get(i);
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
            if (this.fRo == 1) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_detail_list_layout, (ViewGroup) null);
            } else if (this.fRo == 2) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_list_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_detail_list_layout, (ViewGroup) null);
            }
            d dVar2 = new d(inflate, this.fRo);
            dVar2.p(this.fRn);
            dVar2.m(this.fRl);
            dVar2.q(this.fRm);
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

    public void at(String str, boolean z) {
        if (this.efX != null && str != null) {
            Iterator<ALaCharmData> it = this.efX.iterator();
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
