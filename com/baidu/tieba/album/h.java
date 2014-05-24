package com.baidu.tieba.album;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class h extends PagerAdapter {
    private AlbumActivity a;
    private com.baidu.tbadk.img.e b;
    private List<ImageFileInfo> c;
    private int d;
    private int e;
    private Map<Integer, Boolean> f = new HashMap();

    public h(AlbumActivity albumActivity, com.baidu.tbadk.img.e eVar) {
        this.a = albumActivity;
        this.b = eVar;
        this.d = com.baidu.adp.lib.util.k.b(this.a);
        this.e = com.baidu.adp.lib.util.k.c(this.a) - ((int) this.a.getResources().getDimension(com.baidu.tieba.t.album_bottom_height));
    }

    public void a(List<ImageFileInfo> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.c != null) {
            return this.c.size();
        }
        return 0;
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        return view == obj;
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        ((ViewPager) viewGroup).removeView((View) obj);
    }

    public ImageFileInfo a(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.c.get(i);
    }

    public boolean b(int i) {
        if (this.f.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.f.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.album_big_image_item, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.v.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setNightDefaultResource(0);
        ImageFileInfo a = a(i);
        this.f.put(Integer.valueOf(i), false);
        if (a != null) {
            a.clearPageActions();
            a.addPageAction(com.baidu.tbadk.img.effect.d.a(this.d, this.e));
            tbImageView.setTag(a.toCachedKey(false));
            if (this.b.a(a, false) != null) {
                tbImageView.invalidate();
                this.f.put(Integer.valueOf(i), true);
            } else {
                this.b.a(a, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
