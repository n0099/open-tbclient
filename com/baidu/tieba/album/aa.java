package com.baidu.tieba.album;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import java.util.List;
/* loaded from: classes.dex */
public class aa extends BaseAdapter {
    private com.baidu.tbadk.img.e apK;
    private AlbumActivity apM;
    private n aqK;
    private boolean aqL;
    private boolean aqM;
    private y aqN;
    private x aqO;
    private z aqP;
    private List<ImageFileInfo> mList;
    private int mWidth;

    public aa(AlbumActivity albumActivity, n nVar) {
        this.apM = albumActivity;
        this.apK = albumActivity.BC();
        this.aqK = nVar;
        this.mWidth = (int) this.apM.getResources().getDimension(com.baidu.tieba.u.album_gridview_item_height);
    }

    public void setData(List<ImageFileInfo> list, boolean z) {
        this.mList = list;
        this.aqL = z;
        notifyDataSetChanged();
    }

    public boolean isScroll() {
        return this.aqM;
    }

    public void bo(boolean z) {
        this.aqM = z;
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
    /* renamed from: em */
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

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return (this.aqL && i == 0) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ag agVar;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            agVar = new ag(this, null);
            if (itemViewType == 0) {
                view = com.baidu.adp.lib.g.b.ei().a(this.apM.getPageContext().getPageActivity(), com.baidu.tieba.x.album_image_item_view, viewGroup, false);
                agVar.aqW = (HeadImageView) view.findViewById(com.baidu.tieba.w.pic);
                agVar.aqX = (ImageView) view.findViewById(com.baidu.tieba.w.select_icon);
                agVar.aqZ = (RelativeLayout) view.findViewById(com.baidu.tieba.w.lay_select);
                view.setTag(agVar);
            } else {
                view = com.baidu.adp.lib.g.b.ei().a(this.apM.getPageContext().getPageActivity(), com.baidu.tieba.x.album_image_item_view_camera, viewGroup, false);
                agVar.aqY = (ViewGroup) view.findViewById(com.baidu.tieba.w.item_camera);
                view.setTag(agVar);
            }
        } else {
            agVar = (ag) view.getTag();
        }
        ImageFileInfo item = getItem(i);
        if (itemViewType == 0) {
            agVar.aqW.setTag(null);
            agVar.aqW.setRadius(1);
            agVar.aqW.setDefaultResource(com.baidu.tieba.v.img_default_100);
            agVar.aqW.d(null, 12, false);
            agVar.aqW.invalidate();
            af afVar = new af(this, null);
            afVar.aqV = true;
            if (item != null) {
                item.clearPageActions();
                item.addPageAction(com.baidu.tbadk.img.effect.d.z(this.mWidth, this.mWidth));
                agVar.aqW.setTag(item.toCachedKey(false));
                if (this.apK.a(item, false) != null) {
                    agVar.aqW.invalidate();
                } else {
                    this.apK.a(item, new ab(this, viewGroup, afVar), false, this.aqM);
                }
            } else {
                afVar.aqV = false;
            }
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            if (this.aqK != null) {
                if (this.aqK.isAdded(item)) {
                    bc.i(agVar.aqX, com.baidu.tieba.v.chx_camera_pic_s);
                } else {
                    bc.i(agVar.aqX, com.baidu.tieba.v.chx_camera_pic_n);
                }
                a(agVar, afVar, i, item, skinType, this.aqK);
            }
            agVar.aqW.setOnClickListener(new ac(this, afVar, i, item));
        } else {
            agVar.aqY.setOnClickListener(new ad(this, i, item));
        }
        applyNightMode(view);
        return view;
    }

    private void applyNightMode(View view) {
        this.apM.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.apM.getLayoutMode().h(view);
    }

    public void a(y yVar) {
        this.aqN = yVar;
    }

    public void a(z zVar) {
        this.aqP = zVar;
    }

    public void a(x xVar) {
        this.aqO = xVar;
    }

    private void a(ag agVar, af afVar, int i, ImageFileInfo imageFileInfo, int i2, n nVar) {
        agVar.aqZ.setOnClickListener(new ae(this, afVar, nVar, imageFileInfo, i, agVar));
    }
}
