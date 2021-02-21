package com.baidu.tieba.faceshop;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes9.dex */
public class ae extends BaseAdapter {
    private String bLD;
    private int bLE;
    private com.baidu.tbadk.img.b fyF = new com.baidu.tbadk.img.b();
    private Context mContext;
    private List<com.baidu.tbadk.album.a> mList;
    private int mWidth;

    public ae(Context context) {
        this.mContext = context;
        this.mWidth = (int) this.mContext.getResources().getDimension(R.dimen.ds120);
        this.bLE = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) / 2;
    }

    public void setData(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bLD = str;
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
    /* renamed from: yd */
    public com.baidu.tbadk.album.a getItem(int i) {
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
    public View getView(int i, View view, final ViewGroup viewGroup) {
        a aVar;
        if (view != null) {
            aVar = (a) view.getTag();
        } else {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.collect_album_list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.iXP = (HeadImageView) view.findViewById(R.id.item_head);
            aVar2.bLG = (TextView) view.findViewById(R.id.item_name);
            aVar2.bLH = (ImageView) view.findViewById(R.id.item_arrow);
            ap.setImageResource(aVar2.bLH, R.drawable.icon_site_ok);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.iXP.setTag(null);
        aVar.iXP.setDefaultResource(R.drawable.pic_image_h_not);
        aVar.iXP.startLoad(null, 12, false);
        aVar.iXP.invalidate();
        com.baidu.tbadk.album.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.bLG.setText(com.baidu.adp.lib.util.l.getTextOmit(aVar.bLG.getPaint(), item.getName(), this.bLE) + "(" + item.getCount() + ")");
            } else {
                aVar.bLG.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bLD)) {
                aVar.bLH.setVisibility(0);
            } else {
                aVar.bLH.setVisibility(8);
            }
            ImageFileInfo bjR = item.bjR();
            if (bjR != null) {
                bjR.clearPageActions();
                bjR.addPageAction(com.baidu.tbadk.img.effect.d.bd(this.mWidth, this.mWidth));
                com.baidu.adp.widget.ImageView.a a2 = this.fyF.a(bjR, false);
                aVar.iXP.setTag(bjR.toCachedKey(false));
                if (a2 != null) {
                    aVar.iXP.invalidate();
                } else {
                    this.fyF.a(bjR, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.ae.1
                        @Override // com.baidu.tbadk.imageManager.b
                        public void a(com.baidu.adp.widget.ImageView.a aVar3, String str, boolean z) {
                            HeadImageView headImageView = (HeadImageView) viewGroup.findViewWithTag(str);
                            if (headImageView != null && aVar3 != null) {
                                headImageView.invalidate();
                            }
                        }
                    }, false, false);
                }
            }
        } else {
            aVar.bLG.setText("");
        }
        return view;
    }

    /* loaded from: classes9.dex */
    private class a {
        TextView bLG;
        ImageView bLH;
        HeadImageView iXP;

        private a() {
        }
    }
}
