package com.baidu.tieba.album;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
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
        this.d = com.baidu.adp.lib.util.j.b(this.a);
        this.e = com.baidu.adp.lib.util.j.c(this.a) - ((int) this.a.getResources().getDimension(com.baidu.tieba.s.album_bottom_height));
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
        View a = com.baidu.adp.lib.e.b.a().a(this.a, com.baidu.tieba.v.album_big_image_item, null);
        TbImageView tbImageView = (TbImageView) a.findViewById(com.baidu.tieba.u.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setNightDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        tbImageView.setNightDefaultBgResource(0);
        ImageFileInfo a2 = a(i);
        this.f.put(Integer.valueOf(i), false);
        if (a2 != null) {
            a2.clearPageActions();
            a2.addPageAction(com.baidu.tbadk.img.effect.d.a(this.d, this.e));
            tbImageView.setTag(a2.toCachedKey(false));
            if (this.b.a(a2, false) != null) {
                tbImageView.invalidate();
                this.f.put(Integer.valueOf(i), true);
            } else {
                this.b.a(a2, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(a, 0);
        return a;
    }
}
