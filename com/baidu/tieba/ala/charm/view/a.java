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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private ArrayList<ALaCharmData> eTF = new ArrayList<>();
    private View.OnClickListener gMj;
    private View.OnClickListener gMk;
    private View.OnClickListener gMl;
    private int gMm;
    private TbPageContext mPageContext;
    private int mSkinType;

    public a(TbPageContext tbPageContext, int i) {
        this.gMm = 1;
        this.mPageContext = tbPageContext;
        this.gMm = i;
    }

    public void o(View.OnClickListener onClickListener) {
        this.gMj = onClickListener;
    }

    public void p(View.OnClickListener onClickListener) {
        this.gMl = onClickListener;
    }

    public void q(View.OnClickListener onClickListener) {
        this.gMk = onClickListener;
    }

    public void setData(ArrayList<ALaCharmData> arrayList) {
        if (arrayList != null) {
            this.eTF.clear();
            this.eTF.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    public void X(ArrayList<ALaCharmData> arrayList) {
        if (!ListUtils.isEmpty(arrayList)) {
            this.eTF.addAll(arrayList);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ud */
    public ALaCharmData getItem(int i) {
        if (this.eTF == null) {
            return null;
        }
        return this.eTF.get(i);
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
            if (this.gMm == 1) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_detail_list_layout, (ViewGroup) null);
            } else if (this.gMm == 2) {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_game_live_list_layout, (ViewGroup) null);
            } else {
                inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.ala_charm_detail_list_layout, (ViewGroup) null);
            }
            dVar = new d(inflate, this.gMm);
            dVar.r(this.gMl);
            dVar.o(this.gMj);
            dVar.s(this.gMk);
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

    public void aB(String str, boolean z) {
        if (this.eTF != null && str != null) {
            Iterator<ALaCharmData> it = this.eTF.iterator();
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
