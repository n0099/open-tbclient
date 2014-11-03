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
    private List<a> WB;
    private int ahQ;
    private boolean ahR;
    private com.baidu.tbadk.img.e ahw;
    private AlbumActivity ahz;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.ahz = albumActivity;
        this.ahw = albumActivity.xK();
        this.mWidth = (int) this.ahz.getResources().getDimension(com.baidu.tieba.t.album_image_height);
        this.ahQ = com.baidu.adp.lib.util.m.n(this.ahz) / 2;
    }

    public void setData(List<a> list) {
        this.WB = list;
        notifyDataSetChanged();
    }

    public List<a> getData() {
        return this.WB;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WB != null) {
            return this.WB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dO */
    public a getItem(int i) {
        if (this.WB == null || i < 0 || i >= this.WB.size()) {
            return null;
        }
        return this.WB.get(i);
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
            view = com.baidu.adp.lib.g.b.ek().a(this.ahz, com.baidu.tieba.w.album_list_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.ahU = (HeadImageView) view.findViewById(com.baidu.tieba.v.item_head);
            lVar2.ahV = (TextView) view.findViewById(com.baidu.tieba.v.album_name);
            view.setTag(lVar2);
            lVar = lVar2;
        }
        lVar.ahU.setTag(null);
        lVar.ahU.setDefaultResource(com.baidu.tieba.u.pic_image_h_not);
        lVar.ahU.c(null, 12, false);
        lVar.ahU.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                lVar.ahV.setText(String.valueOf(com.baidu.adp.lib.util.m.a(lVar.ahV.getPaint(), item.getName(), this.ahQ)) + "(" + item.xN() + ")");
            } else {
                lVar.ahV.setText("");
            }
            ImageFileInfo xO = item.xO();
            if (xO != null) {
                xO.clearPageActions();
                xO.addPageAction(com.baidu.tbadk.img.effect.d.w(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.ahw.a(xO, false);
                lVar.ahU.setTag(xO.toCachedKey(false));
                if (a != null) {
                    lVar.ahU.invalidate();
                } else {
                    this.ahw.a(xO, new k(this, viewGroup), false, this.ahz.isScroll());
                }
            }
        } else {
            lVar.ahV.setText("");
        }
        this.ahz.getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        this.ahz.getLayoutMode().h(view);
        return view;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.ahR = false;
            if (this.ahw != null) {
                this.ahw.sq();
            }
            notifyDataSetChanged();
            return;
        }
        this.ahR = true;
    }
}
