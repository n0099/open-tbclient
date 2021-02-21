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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private ArrayList<ALaCharmData> eVV = new ArrayList<>();
    private View.OnClickListener gPd;
    private View.OnClickListener gPe;
    private View.OnClickListener gPf;
    private int gPg;
    private TbPageContext mPageContext;
    private int mSkinType;

    public a(TbPageContext tbPageContext, int i) {
        this.gPg = 1;
        this.mPageContext = tbPageContext;
        this.gPg = i;
    }

    public void o(View.OnClickListener onClickListener) {
        this.gPd = onClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.gPf = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.gPe = onClickListener;
    }

    public void setData(ArrayList<ALaCharmData> arrayList) {
        if (arrayList != null) {
            this.eVV.clear();
            this.eVV.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void W(ArrayList<ALaCharmData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.eVV.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eVV == null) {
            return 0;
        }
        return this.eVV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uj */
    public ALaCharmData getItem(int i) {
        if (this.eVV == null) {
            return null;
        }
        return this.eVV.get(i);
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
            if (this.gPg == 1) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_detail_list_layout, (ViewGroup) null);
            } else if (this.gPg == 2) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_list_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_detail_list_layout, (ViewGroup) null);
            }
            dVar = new d(inflate, this.gPg);
            dVar.r(this.gPf);
            dVar.o(this.gPd);
            dVar.s(this.gPe);
            inflate.setTag(dVar);
            view = inflate;
        } else {
            dVar = (d) view.getTag();
        }
        if (dVar != null) {
            dVar.a(i, getItem(i), this.mSkinType);
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    public void aA(String str, boolean z) {
        if (this.eVV != null && str != null) {
            Iterator<ALaCharmData> it = this.eVV.iterator();
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
