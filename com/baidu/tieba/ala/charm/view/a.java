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
    private ArrayList<ALaCharmData> eOt = new ArrayList<>();
    private View.OnClickListener gFc;
    private View.OnClickListener gFd;
    private View.OnClickListener gFe;
    private int gFf;
    private TbPageContext mPageContext;
    private int mSkinType;

    public a(TbPageContext tbPageContext, int i) {
        this.gFf = 1;
        this.mPageContext = tbPageContext;
        this.gFf = i;
    }

    public void n(View.OnClickListener onClickListener) {
        this.gFc = onClickListener;
    }

    public void o(View.OnClickListener onClickListener) {
        this.gFe = onClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.gFd = onClickListener;
    }

    public void setData(ArrayList<ALaCharmData> arrayList) {
        if (arrayList != null) {
            this.eOt.clear();
            this.eOt.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void ac(ArrayList<ALaCharmData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.eOt.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vy */
    public ALaCharmData getItem(int i) {
        if (this.eOt == null) {
            return null;
        }
        return this.eOt.get(i);
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
            if (this.gFf == 1) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_detail_list_layout, (ViewGroup) null);
            } else if (this.gFf == 2) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_list_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_detail_list_layout, (ViewGroup) null);
            }
            d dVar2 = new d(inflate, this.gFf);
            dVar2.q(this.gFe);
            dVar2.n(this.gFc);
            dVar2.r(this.gFd);
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

    public void aA(String str, boolean z) {
        if (this.eOt != null && str != null) {
            Iterator<ALaCharmData> it = this.eOt.iterator();
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
