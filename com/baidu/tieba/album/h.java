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
    private com.baidu.tbadk.img.e aoM;
    private AlbumActivity aoO;
    private Map<Integer, Boolean> apc = new HashMap();
    private List<ImageFileInfo> mList;
    private int mMaxHeight;
    private int qX;

    public h(AlbumActivity albumActivity, com.baidu.tbadk.img.e eVar) {
        this.aoO = albumActivity;
        this.aoM = eVar;
        this.qX = com.baidu.adp.lib.util.l.M(this.aoO.getPageContext().getContext());
        this.mMaxHeight = com.baidu.adp.lib.util.l.N(this.aoO.getPageContext().getContext()) - ((int) this.aoO.getResources().getDimension(com.baidu.tieba.u.album_bottom_height));
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

    public ImageFileInfo eg(int i) {
        if (i < 0 || i >= getCount()) {
            return null;
        }
        return this.mList.get(i);
    }

    public boolean eh(int i) {
        if (this.apc.get(Integer.valueOf(i)) == null) {
            return false;
        }
        return this.apc.get(Integer.valueOf(i)).booleanValue();
    }

    @Override // android.support.v4.view.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.aoO.getPageContext().getContext(), com.baidu.tieba.x.album_big_image_item, null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(com.baidu.tieba.w.big_image);
        tbImageView.setTag(null);
        tbImageView.setDefaultResource(0);
        tbImageView.setDefaultBgResource(0);
        ImageFileInfo eg = eg(i);
        this.apc.put(Integer.valueOf(i), false);
        if (eg != null) {
            eg.clearPageActions();
            eg.addPageAction(com.baidu.tbadk.img.effect.d.z(this.qX, this.mMaxHeight));
            tbImageView.setTag(eg.toCachedKey(false));
            if (this.aoM.a(eg, false) != null) {
                tbImageView.invalidate();
                this.apc.put(Integer.valueOf(i), true);
            } else {
                this.aoM.a(eg, new i(this, viewGroup, i), false);
            }
        }
        ((ViewPager) viewGroup).addView(inflate, 0);
        return inflate;
    }
}
