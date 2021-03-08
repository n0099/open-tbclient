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
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private int aln;
    private boolean iUS;
    private b iUT;
    private a iUU;
    private List<CollectEmotionData> mDataList = new ArrayList();
    private List<CollectEmotionData> iUR = new ArrayList();
    private int dlK = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) / 4;
    private com.baidu.tbadk.img.b fAe = new com.baidu.tbadk.img.b();

    /* loaded from: classes8.dex */
    public interface a {
        void cyD();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void cX(List<CollectEmotionData> list);
    }

    public d(a aVar) {
        this.iUU = aVar;
    }

    public void cW(List<CollectEmotionData> list) {
        this.mDataList.clear();
        if (list != null) {
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void a(b bVar) {
        this.iUT = bVar;
    }

    public void clearSelect() {
        if (this.iUS) {
            for (CollectEmotionData collectEmotionData : this.iUR) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.iUR.clear();
            ArrayList arrayList = new ArrayList(this.mDataList);
            this.mDataList.clear();
            this.mDataList.addAll(arrayList);
            notifyDataSetChanged();
            if (this.iUT != null) {
                this.iUT.cX(this.iUR);
            }
        }
    }

    public void qf(boolean z) {
        if (this.iUS != z) {
            for (CollectEmotionData collectEmotionData : this.iUR) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.iUR.clear();
            this.iUS = z;
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
    /* renamed from: xU */
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
                    layoutParams.height = this.dlK;
                    cVar3.rootView.setLayoutParams(layoutParams);
                    cVar3.iUW = (TbImageView) view.findViewById(R.id.collect_pic);
                    ((RelativeLayout.LayoutParams) cVar3.iUW.getLayoutParams()).setMargins(0, 0, 0, 0);
                    cVar3.iUW.setScaleType(ImageView.ScaleType.CENTER);
                    view.findViewById(R.id.collect_select_icon).setVisibility(8);
                    view.setTag(cVar3);
                    ap.setBackgroundColor(view, R.color.white_alpha0, this.aln);
                    cVar = cVar3;
                } else {
                    cVar = (c) view.getTag();
                }
                if (this.iUS) {
                    cVar.rootView.setEnabled(false);
                    ap.setImageResource(cVar.iUW, R.drawable.icon_emotion_unplusadd_n);
                } else {
                    cVar.rootView.setEnabled(true);
                    ap.setImageResource(cVar.iUW, R.drawable.icon_emotion_plusadd_n);
                }
                cVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.d.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.iUU != null) {
                            d.this.iUU.cyD();
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
                    layoutParams2.height = this.dlK;
                    cVar4.rootView.setLayoutParams(layoutParams2);
                    cVar4.iUW = (TbImageView) view.findViewById(R.id.collect_pic);
                    cVar4.bNA = (ImageView) view.findViewById(R.id.collect_select_icon);
                    view.setTag(cVar4);
                    ap.setBackgroundColor(view, R.color.CAM_X0201, this.aln);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (c) view.getTag();
                }
                cVar2.iUW.setTag(null);
                cVar2.iUW.setDefaultResource(R.drawable.img_default_100);
                cVar2.iUW.startLoad(null, 12, false);
                cVar2.iUW.invalidate();
                ap.setBackgroundResource(cVar2.iUW, R.drawable.btn_choose_face_selector, this.aln);
                ImageFileInfo imageFileInfo = getItem(i).imageFileInfo;
                if (imageFileInfo != null) {
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bd(this.dlK, this.dlK));
                    cVar2.iUW.setTag(imageFileInfo.toCachedKey(false));
                    if (this.fAe.a(imageFileInfo, false) != null) {
                        cVar2.iUW.invalidate();
                    } else {
                        this.fAe.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.d.1
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
                if (this.iUS) {
                    cVar2.bNA.setVisibility(0);
                } else {
                    cVar2.bNA.setVisibility(8);
                }
                if (this.iUR.contains(getItem(i))) {
                    ap.setBackgroundResource(cVar2.bNA, R.drawable.ic_post_image_selected_s);
                } else {
                    ap.setBackgroundResource(cVar2.bNA, R.drawable.ic_post_image_selected_n);
                }
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CollectEmotionData item;
                        ImageView imageView;
                        if (d.this.iUS && (item = d.this.getItem(i)) != null) {
                            if (!d.this.iUR.contains(item)) {
                                item.selectIndex = d.this.iUR.size() + 1;
                                item.isSelect = true;
                                d.this.iUR.add(item);
                            } else {
                                item.selectIndex = -1;
                                item.isSelect = false;
                                d.this.iUR.remove(item);
                                for (int i2 = 0; i2 < d.this.iUR.size(); i2++) {
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
                            if (d.this.iUT != null) {
                                d.this.iUT.cX(d.this.iUR);
                            }
                        }
                    }
                };
                cVar2.iUW.setOnClickListener(onClickListener);
                cVar2.bNA.setOnClickListener(onClickListener);
                break;
        }
        return view;
    }

    public List<CollectEmotionData> cyC() {
        return this.iUR;
    }

    public void setSkinType(int i) {
        this.aln = i;
    }

    /* loaded from: classes8.dex */
    private class c {
        ImageView bNA;
        TbImageView iUW;
        View rootView;

        private c() {
        }
    }
}
