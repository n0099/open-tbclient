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
    private com.baidu.tbadk.img.e apK;
    private AlbumActivity apM;
    private Map<Integer, Boolean> aqb = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int rc;

    public h(AlbumActivity albumActivity, com.baidu.tbadk.img.e eVar) {
        this.apM = albumActivity;
        this.apK = eVar;
        this.rc = com.baidu.adp.lib.util.l.M(this.apM.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.l.N(this.apM.getPageContext().getContext()) - ((int) this.apM.getResources().getDimension(com.baidu.tieba.u.album_bottom_height));
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        if (this.mList != null) {
            return this.mList.size();
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

    public ImageFileInfo em(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean en(int i) {
        if (this.aqb.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.aqb.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.apM.getPageContext().getContext(), com.baidu.tieba.x.album_big_image_item, null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.w.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo em = em(i);
        this.aqb.put(Integer.valueOf(i), false);
        if (em != null) {
            em.clearPageActions();
            em.addPageAction(com.baidu.tbadk.img.effect.d.z(this.rc, this.mMaxHeight));
            tbImageView.setTag(em.toCachedKey(false));
            if (this.apK.a(em, false) != null) {
                tbImageView.invalidate();
                this.aqb.put(Integer.valueOf(i), true);
            } else {
                this.apK.a(em, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
