package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.RequiresApi;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.im.chat.e;
import com.baidu.tieba.im.chat.officialBar.d;
import com.baidu.tieba.im.message.chat.a;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class h extends BaseAdapter {
    private d.c klJ;
    private boolean klK;
    private BdTypeListView knD;
    private TbPageContext<OfficialBarFeedActivity> pageContext;
    private List<com.baidu.tieba.im.message.chat.b> mList = null;
    private LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> knC = null;

    public h(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, d.c cVar) {
        this.pageContext = tbPageContext;
        this.klJ = cVar;
        this.knD = bdTypeListView;
    }

    private View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.im.message.chat.b bVar, e.a<b> aVar) {
        b cTM = aVar.cTM();
        a.C0782a cZb = bVar.cZb();
        cZb.createTime = bVar.getCreateTime();
        cTM.a(this.pageContext.getPageActivity().getBaseContext(), cZb, bVar.cZc(), this.knC == null ? null : this.knC.get(cZb.kAy), bVar.cZd(), bVar.cZa(), i);
        ar arVar = new ar(this.klK ? "c13865" : "c13863");
        arVar.dY("uid", TbadkCoreApplication.getCurrentAccount());
        arVar.dY("tid", cZb.tid == null ? "" : cZb.tid);
        arVar.dY("fid", cZb.fid);
        TiebaStatic.log(arVar);
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
    /* renamed from: DO */
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
            b bVar = new b(this.pageContext, this.klK);
            bVar.a(this.klJ);
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
        if (this.knC == null) {
            this.knC = new LongSparseArray<>();
        }
        this.knC.clear();
        for (int i = 0; i < longSparseArray.size(); i++) {
            this.knC.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
        }
        notifyDataSetChanged();
    }

    /* loaded from: classes26.dex */
    private class a extends e.a<b> {
        public a(View view, b bVar) {
            super(view, bVar);
        }
    }

    public void sj(boolean z) {
        this.klK = z;
    }
}
