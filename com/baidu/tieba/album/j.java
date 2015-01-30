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
    private com.baidu.tbadk.img.e apK;
    private AlbumActivity apM;
    private String aqe;
    private int aqf;
    private List<a> mList;
    private int mWidth;

    public j(AlbumActivity albumActivity) {
        this.apM = albumActivity;
        this.apK = albumActivity.BC();
        this.mWidth = (int) this.apM.getResources().getDimension(com.baidu.tieba.u.album_image_height);
        this.aqf = com.baidu.adp.lib.util.l.M(this.apM.getPageContext().getPageActivity()) / 2;
    }

    public void a(List<a> list, String str) {
        this.mList = list;
        this.aqe = str;
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
            view = com.baidu.adp.lib.g.b.ei().a(this.apM.getPageContext().getPageActivity(), com.baidu.tieba.x.album_list_item, viewGroup, false);
            l lVar2 = new l(this, null);
            lVar2.aqi = (HeadImageView) view.findViewById(com.baidu.tieba.w.item_head);
            lVar2.aqj = (TextView) view.findViewById(com.baidu.tieba.w.item_name);
            lVar2.aqk = (ImageView) view.findViewById(com.baidu.tieba.w.item_arrow);
            view.setTag(lVar2);
            lVar = lVar2;
        }
        lVar.aqi.setTag(null);
        lVar.aqi.setDefaultBgResource(0);
        lVar.aqi.setDefaultResource(com.baidu.tieba.v.img_default_100);
        lVar.aqi.d(null, 12, false);
        lVar.aqi.invalidate();
        a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                lVar.aqj.setText(String.valueOf(com.baidu.adp.lib.util.l.a(lVar.aqj.getPaint(), item.getName(), this.aqf)) + "(" + item.BF() + ")");
            } else {
                lVar.aqj.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.aqe)) {
                lVar.aqk.setVisibility(0);
            } else {
                lVar.aqk.setVisibility(8);
            }
            ImageFileInfo BG = item.BG();
            if (BG != null) {
                BG.clearPageActions();
                BG.addPageAction(com.baidu.tbadk.img.effect.d.z(this.mWidth, this.mWidth));
                com.baidu.adp.widget.a.a a = this.apK.a(BG, false);
                lVar.aqi.setTag(BG.toCachedKey(false));
                if (a != null) {
                    lVar.aqi.invalidate();
                } else {
                    this.apK.a(BG, new k(this, viewGroup), false, this.apM.isScroll());
                }
            }
        } else {
            lVar.aqj.setText("");
        }
        this.apM.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.apM.getLayoutMode().h(view);
        return view;
    }
}
