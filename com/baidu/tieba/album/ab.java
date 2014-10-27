package com.baidu.tieba.album;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter implements AbsListView.OnScrollListener {
    private List<ImageFileInfo> Wx;
    private boolean ahI;
    private com.baidu.tbadk.img.e ahn;
    private AlbumActivity ahq;
    private p aiq;
    private z air;
    private aa ais;
    private int mWidth;

    public ab(AlbumActivity albumActivity, p pVar) {
        this.ahq = albumActivity;
        this.ahn = albumActivity.xI();
        this.aiq = pVar;
        this.mWidth = (int) this.ahq.getResources().getDimension(com.baidu.tieba.t.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list) {
        this.Wx = list;
        notifyDataSetChanged();
    }

    public int g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.Wx == null || this.Wx.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getCount()) {
                return -1;
            }
            ImageFileInfo imageFileInfo2 = this.Wx.get(i2);
            if (imageFileInfo2 == null || imageFileInfo2.getFilePath() == null || !imageFileInfo2.getFilePath().equals(imageFileInfo.getFilePath())) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wx != null) {
            return this.Wx.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dM */
    public ImageFileInfo getItem(int i) {
        if (this.Wx == null || i < 0 || i >= this.Wx.size()) {
            return null;
        }
        return this.Wx.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.ahq, com.baidu.tieba.w.album_image_item_view, viewGroup, false);
            agVar = new ag(this, null);
            agVar.aiz = (HeadImageView) view.findViewById(com.baidu.tieba.v.pic);
            agVar.aiA = (ImageView) view.findViewById(com.baidu.tieba.v.select_icon);
            agVar.aiB = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lay_select);
            view.setTag(agVar);
        } else {
            agVar = (ag) view.getTag();
        }
        agVar.aiz.setTag(null);
        agVar.aiz.setRadius(1);
        agVar.aiz.setDefaultResource(com.baidu.tieba.u.pic_image_h_not);
        agVar.aiz.c(null, 12, false);
        agVar.aiz.invalidate();
        ImageFileInfo item = getItem(i);
        af afVar = new af(this, null);
        afVar.aiy = true;
        if (item != null) {
            item.clearPageActions();
            item.addPageAction(com.baidu.tbadk.img.effect.d.w(this.mWidth, this.mWidth));
            agVar.aiz.setTag(item.toCachedKey(false));
            if (this.ahn.a(item, false) != null) {
                agVar.aiz.invalidate();
            } else {
                this.ahn.a(item, new ac(this, viewGroup, afVar), false, this.ahq.isScroll());
            }
        } else {
            afVar.aiy = false;
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.ahq.getLayoutMode().L(skinType == 1);
        this.ahq.getLayoutMode().h(view);
        if (this.aiq != null) {
            if (this.aiq.isAdded(item)) {
                aw.h(agVar.aiA, com.baidu.tieba.u.btn_choose_photo_s);
            } else {
                aw.h(agVar.aiA, com.baidu.tieba.u.btn_choose_photo_n);
            }
            a(agVar, afVar, i, item, skinType, this.aiq);
        }
        agVar.aiz.setOnClickListener(new ad(this, afVar, i, item));
        return view;
    }

    public void a(z zVar) {
        this.air = zVar;
    }

    public void a(aa aaVar) {
        this.ais = aaVar;
    }

    private void a(ag agVar, af afVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        agVar.aiB.setOnClickListener(new ae(this, afVar, pVar, imageFileInfo, i, agVar));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.ahI = false;
            if (this.ahn != null) {
                this.ahn.so();
            }
            notifyDataSetChanged();
            return;
        }
        this.ahI = true;
    }
}
