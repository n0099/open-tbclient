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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ArrayList<ALaCharmData> eHj = new ArrayList<>();
    private View.OnClickListener gwr;
    private View.OnClickListener gws;
    private View.OnClickListener gwt;
    private int gwu;
    private TbPageContext mPageContext;
    private int mSkinType;

    public a(TbPageContext tbPageContext, int i) {
        this.gwu = 1;
        this.mPageContext = tbPageContext;
        this.gwu = i;
    }

    public void n(View.OnClickListener onClickListener) {
        this.gwr = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.gwt = onClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.gws = onClickListener;
    }

    public void setData(ArrayList<ALaCharmData> arrayList) {
        if (arrayList != null) {
            this.eHj.clear();
            this.eHj.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void ab(ArrayList<ALaCharmData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.eHj.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eHj == null) {
            return 0;
        }
        return this.eHj.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uR */
    public ALaCharmData getItem(int i) {
        if (this.eHj == null) {
            return null;
        }
        return this.eHj.get(i);
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
            if (this.gwu == 1) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_detail_list_layout, (ViewGroup) null);
            } else if (this.gwu == 2) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_list_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_detail_list_layout, (ViewGroup) null);
            }
            d dVar2 = new d(inflate, this.gwu);
            dVar2.q(this.gwt);
            dVar2.n(this.gwr);
            dVar2.r(this.gws);
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

    public void az(String str, boolean z) {
        if (this.eHj != null && str != null) {
            Iterator<ALaCharmData> it = this.eHj.iterator();
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
