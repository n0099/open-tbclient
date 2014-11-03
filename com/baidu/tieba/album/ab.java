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
    private List<ImageFileInfo> WB;
    private boolean ahR;
    private com.baidu.tbadk.img.e ahw;
    private AlbumActivity ahz;
    private z aiA;
    private aa aiB;
    private p aiz;
    private int mWidth;

    public ab(AlbumActivity albumActivity, p pVar) {
        this.ahz = albumActivity;
        this.ahw = albumActivity.xK();
        this.aiz = pVar;
        this.mWidth = (int) this.ahz.getResources().getDimension(com.baidu.tieba.t.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list) {
        this.WB = list;
        notifyDataSetChanged();
    }

    public int g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.WB == null || this.WB.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getCount()) {
                return -1;
            }
            ImageFileInfo imageFileInfo2 = this.WB.get(i2);
            if (imageFileInfo2 == null || imageFileInfo2.getFilePath() == null || !imageFileInfo2.getFilePath().equals(imageFileInfo.getFilePath())) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WB != null) {
            return this.WB.size();
        }
        return 0;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: dM */
    public ImageFileInfo getItem(int i) {
        if (this.WB == null || i < 0 || i >= this.WB.size()) {
            return null;
        }
        return this.WB.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.ahz, com.baidu.tieba.w.album_image_item_view, viewGroup, false);
            agVar = new ag(this, null);
            agVar.aiI = (HeadImageView) view.findViewById(com.baidu.tieba.v.pic);
            agVar.aiJ = (ImageView) view.findViewById(com.baidu.tieba.v.select_icon);
            agVar.aiK = (RelativeLayout) view.findViewById(com.baidu.tieba.v.lay_select);
            view.setTag(agVar);
        } else {
            agVar = (ag) view.getTag();
        }
        agVar.aiI.setTag(null);
        agVar.aiI.setRadius(1);
        agVar.aiI.setDefaultResource(com.baidu.tieba.u.pic_image_h_not);
        agVar.aiI.c(null, 12, false);
        agVar.aiI.invalidate();
        ImageFileInfo item = getItem(i);
        af afVar = new af(this, null);
        afVar.aiH = true;
        if (item != null) {
            item.clearPageActions();
            item.addPageAction(com.baidu.tbadk.img.effect.d.w(this.mWidth, this.mWidth));
            agVar.aiI.setTag(item.toCachedKey(false));
            if (this.ahw.a(item, false) != null) {
                agVar.aiI.invalidate();
            } else {
                this.ahw.a(item, new ac(this, viewGroup, afVar), false, this.ahz.isScroll());
            }
        } else {
            afVar.aiH = false;
        }
        int skinType = TbadkApplication.m251getInst().getSkinType();
        this.ahz.getLayoutMode().L(skinType == 1);
        this.ahz.getLayoutMode().h(view);
        if (this.aiz != null) {
            if (this.aiz.isAdded(item)) {
                aw.h(agVar.aiJ, com.baidu.tieba.u.btn_choose_photo_s);
            } else {
                aw.h(agVar.aiJ, com.baidu.tieba.u.btn_choose_photo_n);
            }
            a(agVar, afVar, i, item, skinType, this.aiz);
        }
        agVar.aiI.setOnClickListener(new ad(this, afVar, i, item));
        return view;
    }

    public void a(z zVar) {
        this.aiA = zVar;
    }

    public void a(aa aaVar) {
        this.aiB = aaVar;
    }

    private void a(ag agVar, af afVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        agVar.aiK.setOnClickListener(new ae(this, afVar, pVar, imageFileInfo, i, agVar));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.ahR = false;
            if (this.ahw != null) {
                this.ahw.sq();
            }
            notifyDataSetChanged();
            return;
        }
        this.ahR = true;
    }
}
