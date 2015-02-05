package com.baidu.tieba.album;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class j extends BaseAdapter {
    private com.baidu.tbadk.img.e apH;
    private AlbumActivity apJ;
    private String aqb;
    private int aqc;
    private List<a> mList;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.apJ = albumActivity;
        this.apH = albumActivity.Bw();
        this.mWidth = (int) this.apJ.getResources().getDimension(com.baidu.tieba.u.album_image_height);
        this.aqc = com.baidu.adp.lib.util.l.M(this.apJ.getPageContext().getPageActivity()) / 2;
    }

    public void a(List<a> list, String str) {
        this.mList = list;
        this.aqb = str;
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
    /* renamed from: eo */
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
            view = com.baidu.adp.lib.g.b.ei().a(this.apJ.getPageContext().getPageActivity(), com.baidu.tieba.x.album_list_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.aqf = (HeadImageView) view.findViewById(com.baidu.tieba.w.item_head);
            lVar2.aqg = (TextView) view.findViewById(com.baidu.tieba.w.item_name);
            lVar2.aqh = (ImageView) view.findViewById(com.baidu.tieba.w.item_arrow);
            view.setTag(lVar2);
            lVar = lVar2;
        }
        lVar.aqf.setTag(null);
        lVar.aqf.setDefaultBgResource(0);
        lVar.aqf.setDefaultResource(com.baidu.tieba.v.img_default_100);
        lVar.aqf.d(null, 12, false);
        lVar.aqf.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                lVar.aqg.setText(String.valueOf(com.baidu.adp.lib.util.l.a(lVar.aqg.getPaint(), item.getName(), this.aqc)) + "(" + item.Bz() + ")");
            } else {
                lVar.aqg.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.aqb)) {
                lVar.aqh.setVisibility(0);
            } else {
                lVar.aqh.setVisibility(8);
            }
            ImageFileInfo BA = item.BA();
            if (BA != null) {
                BA.clearPageActions();
                BA.addPageAction(com.baidu.tbadk.img.effect.d.z(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.apH.a(BA, false);
                lVar.aqf.setTag(BA.toCachedKey(false));
                if (a != null) {
                    lVar.aqf.invalidate();
                } else {
                    this.apH.a(BA, new k(this, viewGroup), false, this.apJ.isScroll());
                }
            }
        } else {
            lVar.aqg.setText("");
        }
        this.apJ.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.apJ.getLayoutMode().h(view);
        return view;
    }
}
