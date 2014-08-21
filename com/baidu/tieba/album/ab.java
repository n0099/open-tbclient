package com.baidu.tieba.album;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter implements AbsListView.OnScrollListener {
    private List<ImageFileInfo> a;
    private AlbumActivity b;
    private com.baidu.tbadk.img.e c;
    private p d;
    private z e;
    private aa f;
    private int g;
    private boolean h;

    public ab(AlbumActivity albumActivity, p pVar) {
        this.b = albumActivity;
        this.c = albumActivity.i();
        this.d = pVar;
        this.g = (int) this.b.getResources().getDimension(com.baidu.tieba.s.album_gridview_item_height);
    }

    public void a(List<ImageFileInfo> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    public int a(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.a == null || this.a.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getCount()) {
                return -1;
            }
            ImageFileInfo imageFileInfo2 = this.a.get(i2);
            if (imageFileInfo2 == null || imageFileInfo2.getFilePath() == null || !imageFileInfo2.getFilePath().equals(imageFileInfo.getFilePath())) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImageFileInfo getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        if (view == null) {
            view = com.baidu.adp.lib.e.b.a().a(this.b, com.baidu.tieba.v.album_image_item_view, viewGroup, false);
            agVar = new ag(this, null);
            agVar.a = (HeadImageView) view.findViewById(com.baidu.tieba.u.pic);
            agVar.b = (ImageView) view.findViewById(com.baidu.tieba.u.select_icon);
            agVar.c = (RelativeLayout) view.findViewById(com.baidu.tieba.u.lay_select);
            view.setTag(agVar);
        } else {
            agVar = (ag) view.getTag();
        }
        agVar.a.setTag(null);
        agVar.a.setRadius(1);
        agVar.a.setDefaultResource(com.baidu.tieba.t.pic_image_h_not);
        agVar.a.setNightDefaultResource(com.baidu.tieba.t.pic_image_h_not_1);
        ImageFileInfo item = getItem(i);
        af afVar = new af(this, null);
        afVar.a = true;
        if (item != null) {
            item.clearPageActions();
            item.addPageAction(com.baidu.tbadk.img.effect.d.a(this.g, this.g));
            agVar.a.setTag(item.toCachedKey(false));
            if (this.c.a(item, false) != null) {
                agVar.a.invalidate();
            } else if (!this.h) {
                this.c.a(item, new ac(this, viewGroup, afVar), false);
            }
        } else {
            afVar.a = false;
        }
        int skinType = TbadkApplication.m252getInst().getSkinType();
        this.b.c().a(skinType == 1);
        this.b.c().a(view);
        if (this.d != null) {
            if (this.d.c(item)) {
                if (skinType == 1) {
                    agVar.b.setBackgroundResource(com.baidu.tieba.t.btn_choose_photo_s_1);
                } else {
                    agVar.b.setBackgroundResource(com.baidu.tieba.t.btn_choose_photo_s);
                }
            } else if (skinType == 1) {
                agVar.b.setBackgroundResource(com.baidu.tieba.t.btn_choose_photo_n_1);
            } else {
                agVar.b.setBackgroundResource(com.baidu.tieba.t.btn_choose_photo_n);
            }
            a(agVar, afVar, i, item, skinType, this.d);
        }
        agVar.a.setOnClickListener(new ad(this, afVar, i, item));
        return view;
    }

    public void a(z zVar) {
        this.e = zVar;
    }

    public void a(aa aaVar) {
        this.f = aaVar;
    }

    private void a(ag agVar, af afVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        agVar.c.setOnClickListener(new ae(this, afVar, pVar, imageFileInfo, i, i2, agVar));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.h = false;
            if (this.c != null) {
                this.c.b();
            }
            notifyDataSetChanged();
            return;
        }
        this.h = true;
    }
}
