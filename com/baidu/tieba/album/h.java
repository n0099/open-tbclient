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
    private List<ImageFileInfo> WB;
    private Map<Integer, Boolean> ahN = new HashMap();
    private com.baidu.tbadk.img.e ahw;
    private AlbumActivity ahz;
    private int mMaxHeight;
    private int rd;

    public h(AlbumActivity albumActivity, com.baidu.tbadk.img.e eVar) {
        this.ahz = albumActivity;
        this.ahw = eVar;
        this.rd = com.baidu.adp.lib.util.m.n(this.ahz);
        this.mMaxHeight = com.baidu.adp.lib.util.m.o(this.ahz) - ((int) this.ahz.getResources().getDimension(com.baidu.tieba.t.album_bottom_height));
    }

    public void setData(List<ImageFileInfo> list) {
        this.WB = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.WB != null) {
            return this.WB.size();
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

    public ImageFileInfo dM(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.WB.get(i);
    }

    public boolean dN(int i) {
        if (this.ahN.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.ahN.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.ahz, com.baidu.tieba.w.album_big_image_item, null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.v.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo dM = dM(i);
        this.ahN.put(Integer.valueOf(i), false);
        if (dM != null) {
            dM.clearPageActions();
            dM.addPageAction(com.baidu.tbadk.img.effect.d.w(this.rd, this.mMaxHeight));
            tbImageView.setTag(dM.toCachedKey(false));
            if (this.ahw.a(dM, false) != null) {
                tbImageView.invalidate();
                this.ahN.put(Integer.valueOf(i), true);
            } else {
                this.ahw.a(dM, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
