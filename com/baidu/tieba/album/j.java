package com.baidu.tieba.album;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter implements AbsListView.OnScrollListener {
    private List<a> Wx;
    private int ahH;
    private boolean ahI;
    private com.baidu.tbadk.img.e ahn;
    private AlbumActivity ahq;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.ahq = albumActivity;
        this.ahn = albumActivity.xI();
        this.mWidth = (int) this.ahq.getResources().getDimension(com.baidu.tieba.t.album_image_height);
        this.ahH = com.baidu.adp.lib.util.m.n(this.ahq) / 2;
    }

    public void setData(List<a> list) {
        this.Wx = list;
        notifyDataSetChanged();
    }

    public List<a> getData() {
        return this.Wx;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wx != null) {
            return this.Wx.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dO */
    public a getItem(int i) {
        if (this.Wx == null || i < 0 || i >= this.Wx.size()) {
            return null;
        }
        return this.Wx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        if (view != null) {
            lVar = (l) view.getTag();
        } else {
            view = com.baidu.adp.lib.g.b.ek().a(this.ahq, com.baidu.tieba.w.album_list_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.ahL = (HeadImageView) view.findViewById(com.baidu.tieba.v.item_head);
            lVar2.ahM = (TextView) view.findViewById(com.baidu.tieba.v.album_name);
            view.setTag(lVar2);
            lVar = lVar2;
        }
        lVar.ahL.setTag(null);
        lVar.ahL.setDefaultResource(com.baidu.tieba.u.pic_image_h_not);
        lVar.ahL.c(null, 12, false);
        lVar.ahL.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                lVar.ahM.setText(String.valueOf(com.baidu.adp.lib.util.m.a(lVar.ahM.getPaint(), item.getName(), this.ahH)) + "(" + item.xL() + ")");
            } else {
                lVar.ahM.setText("");
            }
            ImageFileInfo xM = item.xM();
            if (xM != null) {
                xM.clearPageActions();
                xM.addPageAction(com.baidu.tbadk.img.effect.d.w(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.ahn.a(xM, false);
                lVar.ahL.setTag(xM.toCachedKey(false));
                if (a != null) {
                    lVar.ahL.invalidate();
                } else {
                    this.ahn.a(xM, new k(this, viewGroup), false, this.ahq.isScroll());
                }
            }
        } else {
            lVar.ahM.setText("");
        }
        this.ahq.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.ahq.getLayoutMode().h(view);
        return view;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.ahI = false;
            if (this.ahn != null) {
                this.ahn.so();
            }
            notifyDataSetChanged();
            return;
        }
        this.ahI = true;
    }
}
