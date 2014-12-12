package com.baidu.tieba.album;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class ab extends BaseAdapter implements AbsListView.OnScrollListener {
    private com.baidu.tbadk.img.e aoM;
    private AlbumActivity aoO;
    private p apM;
    private z apN;
    private aa apO;
    private boolean isScrolling;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public ab(AlbumActivity albumActivity, p pVar) {
        this.aoO = albumActivity;
        this.aoM = albumActivity.Bd();
        this.apM = pVar;
        this.mWidth = (int) this.aoO.getResources().getDimension(com.baidu.tieba.u.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public int g(ImageFileInfo imageFileInfo) {
        if (imageFileInfo == null || imageFileInfo.getFilePath() == null) {
            return -1;
        }
        if (this.mList == null || this.mList.size() == 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getCount()) {
                return -1;
            }
            ImageFileInfo imageFileInfo2 = this.mList.get(i2);
            if (imageFileInfo2 == null || imageFileInfo2.getFilePath() == null || !imageFileInfo2.getFilePath().equals(imageFileInfo.getFilePath())) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
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
    /* renamed from: eg */
    public ImageFileInfo getItem(int i) {
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
        ag agVar;
        if (view == null) {
            view = com.baidu.adp.lib.g.b.ek().a(this.aoO.getPageContext().getContext(), com.baidu.tieba.x.album_image_item_view, viewGroup, false);
            agVar = new ag(this, null);
            agVar.apV = (HeadImageView) view.findViewById(com.baidu.tieba.w.pic);
            agVar.apW = (ImageView) view.findViewById(com.baidu.tieba.w.select_icon);
            agVar.apX = (RelativeLayout) view.findViewById(com.baidu.tieba.w.lay_select);
            view.setTag(agVar);
        } else {
            agVar = (ag) view.getTag();
        }
        agVar.apV.setTag(null);
        agVar.apV.setRadius(1);
        agVar.apV.setDefaultResource(com.baidu.tieba.v.pic_image_h_not);
        agVar.apV.d(null, 12, false);
        agVar.apV.invalidate();
        ImageFileInfo item = getItem(i);
        af afVar = new af(this, null);
        afVar.apU = true;
        if (item != null) {
            item.clearPageActions();
            item.addPageAction(com.baidu.tbadk.img.effect.d.z(this.mWidth, this.mWidth));
            agVar.apV.setTag(item.toCachedKey(false));
            if (this.aoM.a(item, false) != null) {
                agVar.apV.invalidate();
            } else {
                this.aoM.a(item, new ac(this, viewGroup, afVar), false, this.aoO.isScroll());
            }
        } else {
            afVar.apU = false;
        }
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        this.aoO.getLayoutMode().ab(skinType == 1);
        this.aoO.getLayoutMode().h(view);
        if (this.apM != null) {
            if (this.apM.isAdded(item)) {
                ax.i(agVar.apW, com.baidu.tieba.v.btn_choose_photo_s);
            } else {
                ax.i(agVar.apW, com.baidu.tieba.v.btn_choose_photo_n);
            }
            a(agVar, afVar, i, item, skinType, this.apM);
        }
        agVar.apV.setOnClickListener(new ad(this, afVar, i, item));
        return view;
    }

    public void a(z zVar) {
        this.apN = zVar;
    }

    public void a(aa aaVar) {
        this.apO = aaVar;
    }

    private void a(ag agVar, af afVar, int i, ImageFileInfo imageFileInfo, int i2, p pVar) {
        agVar.apX.setOnClickListener(new ae(this, afVar, pVar, imageFileInfo, i, agVar));
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0) {
            this.isScrolling = false;
            if (this.aoM != null) {
                this.aoM.vT();
            }
            notifyDataSetChanged();
            return;
        }
        this.isScrolling = true;
    }
}
