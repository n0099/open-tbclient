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
    private HotTopicActivity bnS;
    private List<RelateForumItemData> bof = new ArrayList();
    private List<com.baidu.tieba.hottopic.view.b> bog = new ArrayList();

    public m(HotTopicActivity hotTopicActivity) {
        this.bnS = hotTopicActivity;
    }

    public void setDatas(List<RelateForumItemData> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.bof = list;
            for (int i = 0; i < this.bof.size(); i++) {
                this.bog.add(a(this.bnS));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.bof.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.bog.size() > 0 && i >= 0 && i < this.bog.size()) {
            viewGroup.removeView(this.bog.get(i));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.bof.size()) {
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
        if (i >= this.bog.size()) {
            return null;
        }
        com.baidu.tieba.hottopic.view.b bVar = this.bog.get(i);
        if (bVar != null) {
            bVar.setData(this.bof.get(i));
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
        if (this.bog != null) {
            this.bog.clear();
        }
        if (this.bof != null) {
            this.bof.clear();
        }
    }

    public void QK() {
        if (this.bog != null) {
            for (com.baidu.tieba.hottopic.view.b bVar : this.bog) {
                if (bVar != null) {
                    bVar.QK();
                }
            }
        }
    }
}
