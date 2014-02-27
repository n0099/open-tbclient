package com.baidu.tieba.album;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public final class ab extends BaseAdapter implements AbsListView.OnScrollListener {
    private List<ImageFileInfo> a;
    private AlbumActivity b;
    private com.baidu.tieba.img.e c;
    private p d;
    private z e;
    private aa f;
    private int g;
    private boolean h;

    public ab(AlbumActivity albumActivity, p pVar) {
        this.b = albumActivity;
        this.c = albumActivity.f();
        this.d = pVar;
        this.g = (int) this.b.getResources().getDimension(R.dimen.album_gridview_item_height);
    }

    public final void a(List<ImageFileInfo> list) {
        this.a = list;
        notifyDataSetChanged();
    }

    public final int a(ImageFileInfo imageFileInfo) {
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
    public final int getCount() {
        if (this.a != null) {
            return this.a.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ImageFileInfo getItem(int i) {
        if (this.a == null || i < 0 || i >= this.a.size()) {
            return null;
        }
        return this.a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.album_image_item_view, viewGroup, false);
            agVar = new ag(this, (byte) 0);
            agVar.a = (HeadImageView) view.findViewById(R.id.pic);
            agVar.b = (ImageView) view.findViewById(R.id.select_icon);
            agVar.c = (RelativeLayout) view.findViewById(R.id.lay_select);
            view.setTag(agVar);
        } else {
            agVar = (ag) view.getTag();
        }
        agVar.a.setTag(null);
        agVar.a.setRadius(1);
        agVar.a.setDefaultResource(R.drawable.pic_image_h_not);
        agVar.a.setNightDefaultResource(R.drawable.pic_image_h_not_1);
        ImageFileInfo item = getItem(i);
        af afVar = new af(this, (byte) 0);
        afVar.a = true;
        if (item != null) {
            item.clearPageActions();
            item.addPageAction(com.baidu.tieba.img.effects.d.a(this.g, this.g));
            agVar.a.setTag(item.toCachedKey(false));
            com.baidu.tieba.img.e eVar = this.c;
            if (com.baidu.tieba.img.e.a(item, false) != null) {
                agVar.a.invalidate();
            } else if (!this.h) {
                this.c.a(item, new ac(this, viewGroup, afVar), false);
            }
        } else {
            afVar.a = false;
        }
        int ae = TiebaApplication.g().ae();
        this.b.a().a(ae == 1);
        this.b.a().a(view);
        if (this.d != null) {
            if (this.d.c(item)) {
                if (ae == 1) {
                    agVar.b.setBackgroundResource(R.drawable.btn_choose_photo_s_1);
                } else {
                    agVar.b.setBackgroundResource(R.drawable.btn_choose_photo_s);
                }
            } else if (ae == 1) {
                agVar.b.setBackgroundResource(R.drawable.btn_choose_photo_n_1);
            } else {
                agVar.b.setBackgroundResource(R.drawable.btn_choose_photo_n);
            }
            agVar.c.setOnClickListener(new ae(this, afVar, this.d, item, i, ae, agVar));
        }
        agVar.a.setOnClickListener(new ad(this, afVar, i, item));
        return view;
    }

    public final void a(z zVar) {
        this.e = zVar;
    }

    public final void a(aa aaVar) {
        this.f = aaVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
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
