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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ArrayList<ALaCharmData> dQf = new ArrayList<>();
    private View.OnClickListener fAK;
    private View.OnClickListener fAL;
    private View.OnClickListener fAM;
    private int fAN;
    private TbPageContext mPageContext;
    private int mSkinType;

    public a(TbPageContext tbPageContext, int i) {
        this.fAN = 1;
        this.mPageContext = tbPageContext;
        this.fAN = i;
    }

    public void m(View.OnClickListener onClickListener) {
        this.fAK = onClickListener;
    }

    public void n(View.OnClickListener onClickListener) {
        this.fAM = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.fAL = onClickListener;
    }

    public void setData(ArrayList<ALaCharmData> arrayList) {
        if (arrayList != null) {
            this.dQf.clear();
            this.dQf.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void U(ArrayList<ALaCharmData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.dQf.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.dQf == null) {
            return 0;
        }
        return this.dQf.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qy */
    public ALaCharmData getItem(int i) {
        if (this.dQf == null) {
            return null;
        }
        return this.dQf.get(i);
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
            if (this.fAN == 1) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_detail_list_layout, (ViewGroup) null);
            } else if (this.fAN == 2) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_game_live_list_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.ala_charm_detail_list_layout, (ViewGroup) null);
            }
            d dVar2 = new d(inflate, this.fAN);
            dVar2.p(this.fAM);
            dVar2.m(this.fAK);
            dVar2.q(this.fAL);
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

    public void ar(String str, boolean z) {
        if (this.dQf != null && str != null) {
            Iterator<ALaCharmData> it = this.dQf.iterator();
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
