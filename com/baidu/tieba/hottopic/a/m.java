package com.baidu.tieba.hottopic.a;

import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class m extends PagerAdapter {
    private HotTopicActivity bod;
    private List<RelateForumItemData> boq = new ArrayList();
    private List<com.baidu.tieba.hottopic.view.b> bor = new ArrayList();

    public m(HotTopicActivity hotTopicActivity) {
        this.bod = hotTopicActivity;
    }

    public void setDatas(List<RelateForumItemData> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.boq = list;
            for (int i = 0; i < this.boq.size(); i++) {
                this.bor.add(a(this.bod));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.boq.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.bor.size() > 0 && i >= 0 && i < this.bor.size()) {
            viewGroup.removeView(this.bor.get(i));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.boq.size()) {
            return null;
        }
        View fJ = fJ(i);
        if (fJ != null) {
            viewGroup.addView(fJ);
            return fJ;
        }
        return fJ;
    }

    public View fJ(int i) {
        if (i >= this.bor.size()) {
            return null;
        }
        com.baidu.tieba.hottopic.view.b bVar = this.bor.get(i);
        if (bVar != null) {
            bVar.setData(this.boq.get(i));
            return bVar;
        }
        return bVar;
    }

    private com.baidu.tieba.hottopic.view.b a(HotTopicActivity hotTopicActivity) {
        return new com.baidu.tieba.hottopic.view.b(hotTopicActivity);
    }

    @Override // android.support.v4.view.PagerAdapter
    public Parcelable saveState() {
        return super.saveState();
    }

    public void destory() {
        if (this.bor != null) {
            this.bor.clear();
        }
        if (this.boq != null) {
            this.boq.clear();
        }
    }

    public void QK() {
        if (this.bor != null) {
            for (com.baidu.tieba.hottopic.view.b bVar : this.bor) {
                if (bVar != null) {
                    bVar.QK();
                }
            }
        }
    }
}
