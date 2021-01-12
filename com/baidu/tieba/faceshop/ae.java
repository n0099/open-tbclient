package com.baidu.tieba.faceshop;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes8.dex */
public class ae extends BaseAdapter {
    private String bHT;
    private int bHU;
    private com.baidu.tbadk.img.b fwp = new com.baidu.tbadk.img.b();
    private Context mContext;
    private List<com.baidu.tbadk.album.a> mList;
    private int mWidth;

    public ae(Context context) {
        this.mContext = context;
        this.mWidth = (int) this.mContext.getResources().getDimension(R.dimen.ds120);
        this.bHU = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mContext) / 2;
    }

    public void c(List<com.baidu.tbadk.album.a> list, String str) {
        this.mList = list;
        this.bHT = str;
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
    /* renamed from: xT */
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
            aVar2.iRU = (HeadImageView) view.findViewById(R.id.item_head);
            aVar2.bHW = (TextView) view.findViewById(R.id.item_name);
            aVar2.bHX = (ImageView) view.findViewById(R.id.item_arrow);
            ao.setImageResource(aVar2.bHX, R.drawable.icon_site_ok);
            view.setTag(aVar2);
            aVar = aVar2;
        }
        aVar.iRU.setTag(null);
        aVar.iRU.setDefaultResource(R.drawable.pic_image_h_not);
        aVar.iRU.startLoad(null, 12, false);
        aVar.iRU.invalidate();
        com.baidu.tbadk.album.a item = getItem(i);
        if (item != null) {
            if (!TextUtils.isEmpty(item.getName())) {
                item.getName();
                aVar.bHW.setText(com.baidu.adp.lib.util.l.getTextOmit(aVar.bHW.getPaint(), item.getName(), this.bHU) + "(" + item.getCount() + ")");
            } else {
                aVar.bHW.setText("");
            }
            String albumId = item.getAlbumId();
            if (!TextUtils.isEmpty(albumId) && albumId.equals(this.bHT)) {
                aVar.bHX.setVisibility(0);
            } else {
                aVar.bHX.setVisibility(8);
            }
            ImageFileInfo bjw = item.bjw();
            if (bjw != null) {
                bjw.clearPageActions();
                bjw.addPageAction(com.baidu.tbadk.img.effect.d.bg(this.mWidth, this.mWidth));
                com.baidu.adp.widget.ImageView.a a2 = this.fwp.a(bjw, false);
                aVar.iRU.setTag(bjw.toCachedKey(false));
                if (a2 != null) {
                    aVar.iRU.invalidate();
                } else {
                    this.fwp.a(bjw, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.ae.1
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
            aVar.bHW.setText("");
        }
        return view;
    }

    /* loaded from: classes8.dex */
    private class a {
        TextView bHW;
        ImageView bHX;
        HeadImageView iRU;

        private a() {
        }
    }
}
