package com.baidu.tieba.album;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.img.ImageFileInfo;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter implements AbsListView.OnScrollListener {
    private List<a> a;
    private AlbumActivity b;
    private com.baidu.tieba.img.e c;
    private int d;
    private int e;
    private boolean f;

    public j(AlbumActivity albumActivity) {
        this.b = albumActivity;
        this.c = albumActivity.g();
        this.e = (int) this.b.getResources().getDimension(R.dimen.album_image_height);
        this.d = BdUtilHelper.b(this.b) / 2;
    }

    public void a(List<a> list) {
        this.a = list;
        notifyDataSetChanged();
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
    public a getItem(int i) {
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
        l lVar;
        if (view != null) {
            lVar = (l) view.getTag();
        } else {
            view = LayoutInflater.from(this.b).inflate(R.layout.album_list_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.a = (HeadImageView) view.findViewById(R.id.item_head);
            lVar2.b = (TextView) view.findViewById(R.id.album_name);
            view.setTag(lVar2);
            lVar = lVar2;
        }
        lVar.a.setTag(null);
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.b())) {
                item.b();
                lVar.b.setText(String.valueOf(BdUtilHelper.a(lVar.b.getPaint(), item.b(), this.d)) + "(" + item.c() + ")");
            } else {
                lVar.b.setText("");
            }
            ImageFileInfo d = item.d();
            if (d != null) {
                d.clearPageActions();
                d.addPageAction(com.baidu.tieba.img.effects.d.a(this.e, this.e));
                com.baidu.adp.widget.ImageView.b a = this.c.a(d, false);
                lVar.a.setTag(d.toCachedKey(false));
                if (a != null) {
                    lVar.a.invalidate();
                } else if (!this.f) {
                    this.c.a(d, new k(this, viewGroup), false);
                }
            }
        } else {
            lVar.b.setText("");
        }
        this.b.a().a(TiebaApplication.g().al() == 1);
        this.b.a().a(view);
        return view;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.f = false;
            if (this.c != null) {
                this.c.b();
            }
            notifyDataSetChanged();
            return;
        }
        this.f = true;
    }
}
