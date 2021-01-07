package com.baidu.tieba.faceshop;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseAdapter {
    private int akW;
    private boolean iRV;
    private b iRW;
    private a iRX;
    private List<CollectEmotionData> mDataList = new ArrayList();
    private List<CollectEmotionData> iRU = new ArrayList();
    private int dmK = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) / 4;
    private com.baidu.tbadk.img.b fAX = new com.baidu.tbadk.img.b();

    /* loaded from: classes9.dex */
    public interface a {
        void cAX();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void dc(List<CollectEmotionData> list);
    }

    public d(a aVar) {
        this.iRX = aVar;
    }

    public void db(List<CollectEmotionData> list) {
        this.mDataList.clear();
        if (list != null) {
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void a(b bVar) {
        this.iRW = bVar;
    }

    public void clearSelect() {
        if (this.iRV) {
            for (CollectEmotionData collectEmotionData : this.iRU) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.iRU.clear();
            ArrayList arrayList = new ArrayList(this.mDataList);
            this.mDataList.clear();
            this.mDataList.addAll(arrayList);
            notifyDataSetChanged();
            if (this.iRW != null) {
                this.iRW.dc(this.iRU);
            }
        }
    }

    public void pZ(boolean z) {
        if (this.iRV != z) {
            for (CollectEmotionData collectEmotionData : this.iRU) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.iRU.clear();
            this.iRV = z;
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
    /* renamed from: zp */
    public CollectEmotionData getItem(int i) {
        if (i == 0) {
            return null;
        }
        return (CollectEmotionData) com.baidu.tbadk.core.util.x.getItem(this.mDataList, i - 1);
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
                    layoutParams.height = this.dmK;
                    cVar3.rootView.setLayoutParams(layoutParams);
                    cVar3.iRZ = (TbImageView) view.findViewById(R.id.collect_pic);
                    ((RelativeLayout.LayoutParams) cVar3.iRZ.getLayoutParams()).setMargins(0, 0, 0, 0);
                    cVar3.iRZ.setScaleType(ImageView.ScaleType.CENTER);
                    view.findViewById(R.id.collect_select_icon).setVisibility(8);
                    view.setTag(cVar3);
                    ao.setBackgroundColor(view, R.color.white_alpha0, this.akW);
                    cVar = cVar3;
                } else {
                    cVar = (c) view.getTag();
                }
                if (this.iRV) {
                    cVar.rootView.setEnabled(false);
                    ao.setImageResource(cVar.iRZ, R.drawable.icon_emotion_unplusadd_n);
                } else {
                    cVar.rootView.setEnabled(true);
                    ao.setImageResource(cVar.iRZ, R.drawable.icon_emotion_plusadd_n);
                }
                cVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.d.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.iRX != null) {
                            d.this.iRX.cAX();
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
                    layoutParams2.height = this.dmK;
                    cVar4.rootView.setLayoutParams(layoutParams2);
                    cVar4.iRZ = (TbImageView) view.findViewById(R.id.collect_pic);
                    cVar4.bNc = (ImageView) view.findViewById(R.id.collect_select_icon);
                    view.setTag(cVar4);
                    ao.setBackgroundColor(view, R.color.CAM_X0201, this.akW);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (c) view.getTag();
                }
                cVar2.iRZ.setTag(null);
                cVar2.iRZ.setDefaultResource(R.drawable.img_default_100);
                cVar2.iRZ.startLoad(null, 12, false);
                cVar2.iRZ.invalidate();
                ao.setBackgroundResource(cVar2.iRZ, R.drawable.btn_choose_face_selector, this.akW);
                ImageFileInfo imageFileInfo = getItem(i).imageFileInfo;
                if (imageFileInfo != null) {
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(this.dmK, this.dmK));
                    cVar2.iRZ.setTag(imageFileInfo.toCachedKey(false));
                    if (this.fAX.a(imageFileInfo, false) != null) {
                        cVar2.iRZ.invalidate();
                    } else {
                        this.fAX.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.d.1
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
                if (this.iRV) {
                    cVar2.bNc.setVisibility(0);
                } else {
                    cVar2.bNc.setVisibility(8);
                }
                if (this.iRU.contains(getItem(i))) {
                    ao.setBackgroundResource(cVar2.bNc, R.drawable.ic_post_image_selected_s);
                } else {
                    ao.setBackgroundResource(cVar2.bNc, R.drawable.ic_post_image_selected_n);
                }
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CollectEmotionData item;
                        ImageView imageView;
                        if (d.this.iRV && (item = d.this.getItem(i)) != null) {
                            if (!d.this.iRU.contains(item)) {
                                item.selectIndex = d.this.iRU.size() + 1;
                                item.isSelect = true;
                                d.this.iRU.add(item);
                            } else {
                                item.selectIndex = -1;
                                item.isSelect = false;
                                d.this.iRU.remove(item);
                                for (int i2 = 0; i2 < d.this.iRU.size(); i2++) {
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
                                    ao.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_s);
                                } else {
                                    ao.setBackgroundResource(imageView, R.drawable.ic_post_image_selected_n);
                                }
                            }
                            if (d.this.iRW != null) {
                                d.this.iRW.dc(d.this.iRU);
                            }
                        }
                    }
                };
                cVar2.iRZ.setOnClickListener(onClickListener);
                cVar2.bNc.setOnClickListener(onClickListener);
                break;
        }
        return view;
    }

    public List<CollectEmotionData> cAW() {
        return this.iRU;
    }

    public void setSkinType(int i) {
        this.akW = i;
    }

    /* loaded from: classes9.dex */
    private class c {
        ImageView bNc;
        TbImageView iRZ;
        View rootView;

        private c() {
        }
    }
}
