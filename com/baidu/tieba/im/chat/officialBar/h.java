package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.RequiresApi;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes20.dex */
public class h extends BaseAdapter {
    private d.c iSo;
    private boolean iSp;
    private BdTypeListView iUk;
    private TbPageContext<BaseActivity> pageContext;
    private List<com.baidu.tieba.im.message.chat.b> mList = null;
    private LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> iUj = null;

    public h(TbPageContext<BaseActivity> tbPageContext, BdTypeListView bdTypeListView, d.c cVar) {
        this.pageContext = tbPageContext;
        this.iSo = cVar;
        this.iUk = bdTypeListView;
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.im.message.chat.b bVar, e.a<b> aVar) {
        b cra = aVar.cra();
        a.C0667a cwt = bVar.cwt();
        cwt.createTime = bVar.getCreateTime();
        cra.a(this.pageContext.getPageActivity().getBaseContext(), cwt, bVar.cwu(), this.iUj == null ? null : this.iUj.get(cwt.jhm), bVar.cwv(), bVar.cws(), i);
        ap apVar = new ap(this.iSp ? "c13865" : "c13863");
        if (com.baidu.tbadk.getUserInfo.b.bkd().bkf() != null) {
            apVar.dn("uid", com.baidu.tbadk.getUserInfo.b.bkd().bkf().getUserId());
        }
        apVar.dn("tid", cwt.tid == null ? "" : cwt.tid);
        apVar.dn("fid", cwt.fid);
        TiebaStatic.log(apVar);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList == null) {
            return 0;
        }
        return this.mList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yu */
    public com.baidu.tieba.im.message.chat.b getItem(int i) {
        if (this.mList == null || this.mList.size() == 0 || i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2;
        a aVar = null;
        if (view != null) {
            aVar = (a) view.getTag();
        }
        if (aVar == null) {
            b bVar = new b(this.pageContext, this.iSp);
            bVar.a(this.iSo);
            view2 = bVar.getConvertView();
            aVar = new a(bVar.getConvertView(), bVar);
            view2.setTag(aVar);
        } else {
            view2 = view;
        }
        return a(i, view2, viewGroup, getItem(i), aVar);
    }

    public void setData(List<com.baidu.tieba.im.message.chat.b> list) {
        if (this.mList == null) {
            this.mList = new LinkedList();
        }
        this.mList.clear();
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    @RequiresApi(api = 16)
    public void b(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray) {
        if (this.iUj == null) {
            this.iUj = new LongSparseArray<>();
        }
        this.iUj.clear();
        for (int i = 0; i < longSparseArray.size(); i++) {
            this.iUj.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes20.dex */
    private class a extends e.a<b> {
        public a(View view, b bVar) {
            super(view, bVar);
        }
    }

    public void pH(boolean z) {
        this.iSp = z;
    }
}
