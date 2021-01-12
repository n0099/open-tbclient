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
/* loaded from: classes8.dex */
public class d extends BaseAdapter {
    private int akf;
    private boolean iNo;
    private b iNp;
    private a iNq;
    private List<CollectEmotionData> mDataList = new ArrayList();
    private List<CollectEmotionData> iNn = new ArrayList();
    private int dhV = com.baidu.adp.lib.util.l.getEquipmentWidth(TbadkCoreApplication.getInst()) / 4;
    private com.baidu.tbadk.img.b fwp = new com.baidu.tbadk.img.b();

    /* loaded from: classes8.dex */
    public interface a {
        void cxf();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void dc(List<CollectEmotionData> list);
    }

    public d(a aVar) {
        this.iNq = aVar;
    }

    public void db(List<CollectEmotionData> list) {
        this.mDataList.clear();
        if (list != null) {
            this.mDataList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void a(b bVar) {
        this.iNp = bVar;
    }

    public void clearSelect() {
        if (this.iNo) {
            for (CollectEmotionData collectEmotionData : this.iNn) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.iNn.clear();
            ArrayList arrayList = new ArrayList(this.mDataList);
            this.mDataList.clear();
            this.mDataList.addAll(arrayList);
            notifyDataSetChanged();
            if (this.iNp != null) {
                this.iNp.dc(this.iNn);
            }
        }
    }

    public void pV(boolean z) {
        if (this.iNo != z) {
            for (CollectEmotionData collectEmotionData : this.iNn) {
                collectEmotionData.isSelect = false;
                collectEmotionData.selectIndex = -1;
            }
            this.iNn.clear();
            this.iNo = z;
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
    /* renamed from: xJ */
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
                    layoutParams.height = this.dhV;
                    cVar3.rootView.setLayoutParams(layoutParams);
                    cVar3.iNs = (TbImageView) view.findViewById(R.id.collect_pic);
                    ((RelativeLayout.LayoutParams) cVar3.iNs.getLayoutParams()).setMargins(0, 0, 0, 0);
                    cVar3.iNs.setScaleType(ImageView.ScaleType.CENTER);
                    view.findViewById(R.id.collect_select_icon).setVisibility(8);
                    view.setTag(cVar3);
                    ao.setBackgroundColor(view, R.color.white_alpha0, this.akf);
                    cVar = cVar3;
                } else {
                    cVar = (c) view.getTag();
                }
                if (this.iNo) {
                    cVar.rootView.setEnabled(false);
                    ao.setImageResource(cVar.iNs, R.drawable.icon_emotion_unplusadd_n);
                } else {
                    cVar.rootView.setEnabled(true);
                    ao.setImageResource(cVar.iNs, R.drawable.icon_emotion_plusadd_n);
                }
                cVar.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.d.3
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        if (d.this.iNq != null) {
                            d.this.iNq.cxf();
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
                    layoutParams2.height = this.dhV;
                    cVar4.rootView.setLayoutParams(layoutParams2);
                    cVar4.iNs = (TbImageView) view.findViewById(R.id.collect_pic);
                    cVar4.bIq = (ImageView) view.findViewById(R.id.collect_select_icon);
                    view.setTag(cVar4);
                    ao.setBackgroundColor(view, R.color.CAM_X0201, this.akf);
                    cVar2 = cVar4;
                } else {
                    cVar2 = (c) view.getTag();
                }
                cVar2.iNs.setTag(null);
                cVar2.iNs.setDefaultResource(R.drawable.img_default_100);
                cVar2.iNs.startLoad(null, 12, false);
                cVar2.iNs.invalidate();
                ao.setBackgroundResource(cVar2.iNs, R.drawable.btn_choose_face_selector, this.akf);
                ImageFileInfo imageFileInfo = getItem(i).imageFileInfo;
                if (imageFileInfo != null) {
                    imageFileInfo.clearPageActions();
                    imageFileInfo.addPageAction(com.baidu.tbadk.img.effect.d.bg(this.dhV, this.dhV));
                    cVar2.iNs.setTag(imageFileInfo.toCachedKey(false));
                    if (this.fwp.a(imageFileInfo, false) != null) {
                        cVar2.iNs.invalidate();
                    } else {
                        this.fwp.a(imageFileInfo, new com.baidu.tbadk.imageManager.b() { // from class: com.baidu.tieba.faceshop.d.1
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
                if (this.iNo) {
                    cVar2.bIq.setVisibility(0);
                } else {
                    cVar2.bIq.setVisibility(8);
                }
                if (this.iNn.contains(getItem(i))) {
                    ao.setBackgroundResource(cVar2.bIq, R.drawable.ic_post_image_selected_s);
                } else {
                    ao.setBackgroundResource(cVar2.bIq, R.drawable.ic_post_image_selected_n);
                }
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.d.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CollectEmotionData item;
                        ImageView imageView;
                        if (d.this.iNo && (item = d.this.getItem(i)) != null) {
                            if (!d.this.iNn.contains(item)) {
                                item.selectIndex = d.this.iNn.size() + 1;
                                item.isSelect = true;
                                d.this.iNn.add(item);
                            } else {
                                item.selectIndex = -1;
                                item.isSelect = false;
                                d.this.iNn.remove(item);
                                for (int i2 = 0; i2 < d.this.iNn.size(); i2++) {
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
                            if (d.this.iNp != null) {
                                d.this.iNp.dc(d.this.iNn);
                            }
                        }
                    }
                };
                cVar2.iNs.setOnClickListener(onClickListener);
                cVar2.bIq.setOnClickListener(onClickListener);
                break;
        }
        return view;
    }

    public List<CollectEmotionData> cxe() {
        return this.iNn;
    }

    public void setSkinType(int i) {
        this.akf = i;
    }

    /* loaded from: classes8.dex */
    private class c {
        ImageView bIq;
        TbImageView iNs;
        View rootView;

        private c() {
        }
    }
}
