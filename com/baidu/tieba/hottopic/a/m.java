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
    private HotTopicActivity boH;
    private List<RelateForumItemData> boU = new ArrayList();
    private List<com.baidu.tieba.hottopic.view.b> boV = new ArrayList();

    public m(HotTopicActivity hotTopicActivity) {
        this.boH = hotTopicActivity;
    }

    public void setDatas(List<RelateForumItemData> list) {
        if (list != null && list.size() > 0) {
            destory();
            this.boU = list;
            for (int i = 0; i < this.boU.size(); i++) {
                this.boV.add(a(this.boH));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.boU.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        if (this.boV.size() > 0 && i >= 0 && i < this.boV.size()) {
            viewGroup.removeView(this.boV.get(i));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (i >= this.boU.size()) {
            return null;
        }
        View fR = fR(i);
        if (fR != null) {
            viewGroup.addView(fR);
            return fR;
        }
        return fR;
    }

    public View fR(int i) {
        if (i >= this.boV.size()) {
            return null;
        }
        com.baidu.tieba.hottopic.view.b bVar = this.boV.get(i);
        if (bVar != null) {
            bVar.setData(this.boU.get(i));
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
        if (this.boV != null) {
            this.boV.clear();
        }
        if (this.boU != null) {
            this.boU.clear();
        }
    }

    public void Rc() {
        if (this.boV != null) {
            for (com.baidu.tieba.hottopic.view.b bVar : this.boV) {
                if (bVar != null) {
                    bVar.Rc();
                }
            }
        }
    }
}
