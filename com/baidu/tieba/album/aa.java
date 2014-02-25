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
public class aa extends BaseAdapter implements AbsListView.OnScrollListener {
    private List<ImageFileInfo> a;
    private AlbumActivity b;
    private com.baidu.tieba.img.e c;
    private p d;
    private y e;
    private z f;
    private int g;
    private boolean h;

    public aa(AlbumActivity albumActivity, p pVar) {
        this.b = albumActivity;
        this.c = albumActivity.g();
        this.d = pVar;
        this.g = (int) this.b.getResources().getDimension(R.dimen.album_gridview_item_height);
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
        af afVar;
        if (view == null) {
            view = LayoutInflater.from(this.b).inflate(R.layout.album_image_item_view, viewGroup, false);
            afVar = new af(this, null);
            afVar.a = (HeadImageView) view.findViewById(R.id.pic);
            afVar.b = (ImageView) view.findViewById(R.id.select_icon);
            afVar.c = (RelativeLayout) view.findViewById(R.id.lay_select);
            view.setTag(afVar);
        } else {
            afVar = (af) view.getTag();
        }
        afVar.a.setTag(null);
        afVar.a.setRadius(1);
        ImageFileInfo item = getItem(i);
        ae aeVar = new ae(this, null);
        aeVar.a = true;
        if (item != null) {
            item.clearPageActions();
            item.addPageAction(com.baidu.tieba.img.effects.d.a(this.g, this.g));
            afVar.a.setTag(item.toCachedKey(false));
            if (this.c.a(item, false) != null) {
                afVar.a.invalidate();
            } else if (!this.h) {
                this.c.a(item, new ab(this, viewGroup, aeVar), false);
            }
        } else {
            aeVar.a = false;
        }
        int al = TiebaApplication.g().al();
        this.b.a().a(al == 1);
        this.b.a().a(view);
        if (this.d != null) {
            if (this.d.c(item)) {
                if (al == 1) {
                    afVar.b.setBackgroundResource(R.drawable.btn_choose_photo_s_1);
                } else {
                    afVar.b.setBackgroundResource(R.drawable.btn_choose_photo_s);
                }
            } else if (al == 1) {
                afVar.b.setBackgroundResource(R.drawable.btn_choose_photo_n_1);
            } else {
                afVar.b.setBackgroundResource(R.drawable.btn_choose_photo_n);
            }
            a(afVar, aeVar, i, item, al, this.d);
        }
        afVar.a.setOnClickListener(new ac(this, aeVar, i, item));
        return view;
    }

    public void a(y yVar) {
        this.e = yVar;
    }

    public void a(z zVar) {
        this.f = zVar;
    }

    private void a(af afVar, ae aeVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        afVar.c.setOnClickListener(new ad(this, aeVar, pVar, imageFileInfo, i, i2, afVar));
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
