package com.baidu.tieba.faceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    private int ajU;
    private boolean iSV;
    private b iSW;
    private a iSX;
    private List<CollectEmotionData> mDataList = new ArrayList();
    private List<CollectEmotionData> iSU = new ArrayList();
    private int dkj = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) / 4;
    private com.baidu.tbadk.img.b fyF = new com.baidu.tbadk.img.b();

    /* loaded from: classes9.dex */
    public interface a {
        void cyq();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void cX(List<CollectEmotionData> list);
    }

    public d(a aVar) {
        this.iSX = aVar;
    }

    public void cW(List<CollectEmotionData> list) {
        this.mDataList.clear();
        if (list != null) {
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void a(b bVar) {
        this.iSW = bVar;
    }

    public void clearSelect() {
        if (this.iSV) {
            for (CollectEmotionData collectEmotionData : this.iSU) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.iSU.clear();
            ArrayList arrayList = new ArrayList(this.mDataList);
            this.mDataList.clear();
            this.mDataList.addAll(arrayList);
            notifyDataSetChanged();
            if (this.iSW != null) {
                this.iSW.cX(this.iSU);
            }
        }
    }

    public void qf(boolean z) {
        if (this.iSV != z) {
            for (CollectEmotionData collectEmotionData : this.iSU) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.iSU.clear();
            this.iSV = z;
            ArrayList arrayList = new ArrayList(this.mDataList);
            this.mDataList.clear();
            this.mDataList.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mDataList.size() + 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xT */
    public CollectEmotionData getItem(int i) {
        if (i == 0) {
            return null;
        }
        return (CollectEmotionData) com.baidu.tbadk.core.util.y.getItem(this.mDataList, i - 1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        c cVar;
        c cVar2;
        switch (getItemViewType(i)) {
            case 0:
                if (view == null) {
                    c cVar3 = new c();
                    view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                    cVar3.rootView = view;
                    ViewGroup.LayoutParams layoutParams = cVar3.rootView.getLayoutParams();
                    layoutParams.height = this.dkj;
                    cVar3.rootView.setLayoutParams(layoutParams);
                    cVar3.iSZ = (TbImageView) view.findViewById(R.id.collect_pic);
                    ((RelativeLayout.LayoutParams) cVar3.iSZ.getLayoutParams()).setMargins(0, 0, 0, 0);
                    cVar3.iSZ.setScaleType(ImageView.ScaleType.CENTER);
                    view.findViewById(R.id.collect_select_icon).setVisibility(8);
                    view.setTag(cVar3);
                    ap.setBackgroundColor(view, R.color.white_alpha0, this.ajU);
                    cVar = cVar3;
                } else {
                    cVar = (c) view.getTag();
                }
                if (this.iSV) {
                    cVar.rootView.setEnabled(false);
                    ap.setImageResource(cVar.iSZ, R.drawable.icon_emotion_unplusadd_n);
                } else {
                    cVar.rootView.setEnabled(true);
                    ap.setImageResource(cVar.iSZ, R.drawable.icon_emotion_plusadd_n);
                }
                cVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.d.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.iSX != null) {
                            d.this.iSX.cyq();
                        }
                    }
                });
                break;
            case 1:
                if (view == null) {
                    c cVar4 = new c();
                    view = LayoutInflater.from(TbadkCoreApplication.getInst()).inflate(R.layout.collect_image_item_view, viewGroup, false);
                    cVar4.rootView = view;
                    ViewGroup.LayoutParams layoutParams2 = cVar4.rootView.getLayoutParams();
                    layoutParams2.height = this.dkj;
                    cVar4.rootView.setLayoutParams(layoutParams2);
                    cVar4.iSZ = (TbImageView) view.findViewById(R.id.collect_pic);
                    cVar4.bMa = (ImageView) view.findViewById(R.id.collect_select_icon);
                    view.setTag(cVar4);
                    ap.setBackgroundColor(view, R.color.CAM_X0201, this.ajU);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (c) view.getTag();
                }
                cVar2.iSZ.setTag(null);
                cVar2.iSZ.setDefaultResource(R.drawable.img_default_100);
                cVar2.iSZ.startLoad(null, 12, false);
                cVar2.iSZ.invalidate();
                ap.setBackgroundResource(cVar2.iSZ, R.drawable.btn_choose_face_selector, this.ajU);
                ImageFileInfo imageFileInfo = getItem(i).imageFileInfo;
                if (imageFileInfo != null) {
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bd(this.dkj, this.dkj));
                    cVar2.iSZ.setTag(imageFileInfo.toCachedKey(false));
                    if (this.fyF.a(imageFileInfo, false) != null) {
                        cVar2.iSZ.invalidate();
                    } else {
                        this.fyF.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.d.1
                            @Override // com.baidu.tbadk.imageManager.b
                            public void a(com.baidu.adp.widget.ImageView.a aVar, String str, boolean z) {
                                TbImageView tbImageView = (TbImageView) viewGroup.findViewWithTag(str);
                                if (tbImageView != null && aVar != null) {
                                    tbImageView.invalidate();
                                }
                            }
                        }, false, false);
                    }
                }
                if (this.iSV) {
                    cVar2.bMa.setVisibility(0);
                } else {
                    cVar2.bMa.setVisibility(8);
                }
                if (this.iSU.contains(getItem(i))) {
                    ap.setBackgroundResource(cVar2.bMa, R.drawable.ic_post_image_selected_s);
                } else {
                    ap.setBackgroundResource(cVar2.bMa, R.drawable.ic_post_image_selected_n);
                }
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CollectEmotionData item;
                        ImageView imageView;
                        if (d.this.iSV && (item = d.this.getItem(i)) != null) {
                            if (!d.this.iSU.contains(item)) {
                                item.selectIndex = d.this.iSU.size() + 1;
                                item.isSelect = true;
                                d.this.iSU.add(item);
                            } else {
                                item.selectIndex = -1;
                                item.isSelect = false;
                                d.this.iSU.remove(item);
                                for (int i2 = 0; i2 < d.this.iSU.size(); i2++) {
                                    d.this.getItem(i).selectIndex = i2 + 1;
                                }
                            }
                            if (view2.getId() == R.id.collect_select_icon) {
                                imageView = (ImageView) view2;
                            } else {
                                imageView = (ImageView) ((RelativeLayout) view2.getParent()).findViewById(R.id.collect_select_icon);
                            }
                            if (imageView != null) {
                                if (item.isSelect) {
                                    ap.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_s);
                                } else {
                                    ap.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_n);
                                }
                            }
                            if (d.this.iSW != null) {
                                d.this.iSW.cX(d.this.iSU);
                            }
                        }
                    }
                };
                cVar2.iSZ.setOnClickListener(onClickListener);
                cVar2.bMa.setOnClickListener(onClickListener);
                break;
        }
        return view;
    }

    public List<CollectEmotionData> cyp() {
        return this.iSU;
    }

    public void setSkinType(int i) {
        this.ajU = i;
    }

    /* loaded from: classes9.dex */
    private class c {
        ImageView bMa;
        TbImageView iSZ;
        View rootView;

        private c() {
        }
    }
}
