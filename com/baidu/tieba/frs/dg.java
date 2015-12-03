package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class dg extends bm<com.baidu.tbadk.core.data.s, dl> implements View.OnClickListener {
    private ArrayList<ex> bdO;

    /* JADX INFO: Access modifiers changed from: protected */
    public dg(BaseActivity baseActivity, BdUniqueId bdUniqueId) {
        super(baseActivity, bdUniqueId);
        this.bdO = new ArrayList<>();
        this.bdO.add(new ex(this.mContext));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: s */
    public dl a(ViewGroup viewGroup) {
        return new dl(LayoutInflater.from(this.mContext).inflate(n.g.frs_photo_live_view_pager_div, viewGroup, false), Ob());
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.s sVar, dl dlVar) {
        super.a(i, view, viewGroup, (ViewGroup) sVar, (com.baidu.tbadk.core.data.s) dlVar);
        dlVar.bec.a(sVar);
        dlVar.beb.setTag(sVar);
        dlVar.beb.setOnClickListener(this);
        if (dlVar.afY != this.mSkinType) {
            com.baidu.tbadk.i.a.a(this.aXA.getPageContext(), view);
            dlVar.afY = this.mSkinType;
        }
        return view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id;
        if ((view.getTag() instanceof com.baidu.tbadk.core.data.s) && (id = view.getId()) == n.f.all_live_list) {
            this.bbF.a(id, 0, view, null, (com.baidu.tbadk.core.data.s) view.getTag());
        }
    }

    public int Oa() {
        return n.f.all_live_list;
    }

    private ex Ob() {
        if (this.bdO.size() > 0) {
            return this.bdO.remove(this.bdO.size() - 1);
        }
        return null;
    }
}
