package com.baidu.tieba.ala.charm.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.charm.data.ALaCharmData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    private ArrayList<ALaCharmData> cRO = new ArrayList<>();
    private View.OnClickListener esH;
    private View.OnClickListener esI;
    private View.OnClickListener esJ;
    private int mFromType;
    private TbPageContext mPageContext;
    private int mSkinType;

    public a(TbPageContext tbPageContext, int i) {
        this.mFromType = 1;
        this.mPageContext = tbPageContext;
        this.mFromType = i;
    }

    public void m(View.OnClickListener onClickListener) {
        this.esH = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.esJ = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.esI = onClickListener;
    }

    public void setData(ArrayList<ALaCharmData> arrayList) {
        if (arrayList != null) {
            this.cRO.clear();
            this.cRO.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void R(ArrayList<ALaCharmData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.cRO.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.cRO == null) {
            return 0;
        }
        return this.cRO.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oI */
    public ALaCharmData getItem(int i) {
        if (this.cRO == null) {
            return null;
        }
        return this.cRO.get(i);
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
            if (this.mFromType == 1) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_detail_list_layout, (ViewGroup) null);
            } else if (this.mFromType == 2) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_list_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_detail_list_layout, (ViewGroup) null);
            }
            d dVar2 = new d(inflate, this.mFromType);
            dVar2.p(this.esJ);
            dVar2.m(this.esH);
            dVar2.q(this.esI);
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

    public void X(String str, boolean z) {
        if (this.cRO != null && str != null) {
            Iterator<ALaCharmData> it = this.cRO.iterator();
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
