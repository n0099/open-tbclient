package com.baidu.tieba.album;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter implements AbsListView.OnScrollListener {
    private com.baidu.tbadk.img.e aoM;
    private AlbumActivity aoO;
    private int apf;
    private boolean isScrolling;
    private List<a> mList;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.aoO = albumActivity;
        this.aoM = albumActivity.Bd();
        this.mWidth = (int) this.aoO.getResources().getDimension(com.baidu.tieba.u.album_image_height);
        this.apf = com.baidu.adp.lib.util.l.M(this.aoO.getPageContext().getPageActivity()) / 2;
    }

    public void setData(List<a> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public List<a> getData() {
        return this.mList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ei */
    public a getItem(int i) {
        if (this.mList == null || i < 0 || i >= this.mList.size()) {
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
        l lVar;
        if (view != null) {
            lVar = (l) view.getTag();
        } else {
            view = com.baidu.adp.lib.g.b.ek().a(this.aoO.getPageContext().getContext(), com.baidu.tieba.x.album_list_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.apj = (HeadImageView) view.findViewById(com.baidu.tieba.w.item_head);
            lVar2.apk = (TextView) view.findViewById(com.baidu.tieba.w.album_name);
            view.setTag(lVar2);
            lVar = lVar2;
        }
        lVar.apj.setTag(null);
        lVar.apj.setDefaultResource(com.baidu.tieba.v.pic_image_h_not);
        lVar.apj.d(null, 12, false);
        lVar.apj.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                lVar.apk.setText(String.valueOf(com.baidu.adp.lib.util.l.a(lVar.apk.getPaint(), item.getName(), this.apf)) + "(" + item.Bg() + ")");
            } else {
                lVar.apk.setText("");
            }
            ImageFileInfo Bh = item.Bh();
            if (Bh != null) {
                Bh.clearPageActions();
                Bh.addPageAction(com.baidu.tbadk.img.effect.d.z(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.aoM.a(Bh, false);
                lVar.apj.setTag(Bh.toCachedKey(false));
                if (a != null) {
                    lVar.apj.invalidate();
                } else {
                    this.aoM.a(Bh, new k(this, viewGroup), false, this.aoO.isScroll());
                }
            }
        } else {
            lVar.apk.setText("");
        }
        this.aoO.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.aoO.getLayoutMode().h(view);
        return view;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.isScrolling = false;
            if (this.aoM != null) {
                this.aoM.vT();
            }
            notifyDataSetChanged();
            return;
        }
        this.isScrolling = true;
    }
}
