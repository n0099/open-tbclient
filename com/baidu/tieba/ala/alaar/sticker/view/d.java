package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alaar.sticker.a.h;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.view.c;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class d extends BaseAdapter {
    private int aGs;
    private int gll;
    private FuFaceItem gmq;
    private c.b gmr;
    private int gms;
    private Context mContext;
    private LinkedList<FuFaceItem> mList = new LinkedList<>();
    private int gmo = -1;
    private int gmp = -1;

    public d(Context context, int i, c.b bVar) {
        this.mContext = context;
        this.gll = i;
        this.gmr = bVar;
        if (this.gll == 1) {
            this.aGs = BdUtilHelper.dip2px(this.mContext, 110.0f);
            this.gms = BdUtilHelper.dip2px(this.mContext, 75.0f);
        } else if (this.gll == 2) {
            this.aGs = BdUtilHelper.dip2px(this.mContext, 170.0f);
            this.gms = BdUtilHelper.dip2px(this.mContext, 72.0f);
        } else if (this.gll == 3) {
            this.aGs = BdUtilHelper.dip2px(this.mContext, 60.0f);
            this.gms = BdUtilHelper.dip2px(this.mContext, 60.0f);
        }
    }

    public void setDatas(List<FuFaceItem> list) {
        if (!ListUtils.isEmpty(list)) {
            this.mList.clear();
            this.mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return ListUtils.getCount(this.mList);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uH */
    public FuFaceItem getItem(int i) {
        return (FuFaceItem) ListUtils.getItem(this.mList, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final g gVar;
        View view2;
        if (view == null) {
            if (this.gll == 1) {
                View inflate = LayoutInflater.from(this.mContext).inflate(a.g.ala_sticker_pic_item_layout, (ViewGroup) null);
                view2 = inflate;
                gVar = new g(inflate);
            } else if (this.gll == 2) {
                View inflate2 = LayoutInflater.from(this.mContext).inflate(a.g.ala_sticker_txt_item_layout, (ViewGroup) null);
                view2 = inflate2;
                gVar = new h(inflate2);
            } else {
                View inflate3 = LayoutInflater.from(this.mContext).inflate(a.g.ala_sticker_ar_item_layout, (ViewGroup) null);
                view2 = inflate3;
                gVar = new f(inflate3);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                view2.setLayoutParams(new AbsListView.LayoutParams(this.aGs, this.gms));
            } else {
                layoutParams.width = this.aGs;
                layoutParams.height = this.gms;
            }
            view2.setTag(gVar);
        } else {
            gVar = (i) view.getTag();
            view2 = view;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (d.this.gmr != null && !d.this.gmr.bQV()) {
                    BdUtilHelper.showToast(d.this.mContext, a.h.txt_punish_sticker_using);
                } else if ((gVar instanceof g) || (gVar instanceof h)) {
                    if (d.this.gmr != null) {
                        d.this.gmr.a(d.this.getItem(i), d.this.getItem(i).getFilePath());
                    }
                    d.this.gmo = i;
                    d.this.notifyDataSetChanged();
                } else if (i != 0 || !d.this.getItem(i).isCancelItem) {
                    d.this.gmq = null;
                    if (i != d.this.gmo) {
                        d.this.a(d.this.getItem(i), i, (f) gVar);
                    }
                } else {
                    d.this.a(true, d.this.getItem(i));
                }
            }
        });
        gVar.d(getItem(i));
        if ((gVar instanceof g) || (gVar instanceof h)) {
            if (this.gmo == i) {
                gVar.gnp.setVisibility(0);
            } else {
                gVar.gnp.setVisibility(4);
            }
        } else if (i != 0 && this.gmo == i && this.gmq == null) {
            gVar.gnp.setVisibility(0);
        } else {
            gVar.gnp.setVisibility(4);
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FuFaceItem fuFaceItem, int i, f fVar) {
        this.gmp = i;
        if (fuFaceItem.isResLoaded()) {
            if (this.gmr != null) {
                this.gmr.a(fuFaceItem, fuFaceItem.getFilePath());
            }
            this.gmo = i;
            notifyDataSetChanged();
        } else if (TextUtils.isEmpty(fuFaceItem.file) || !com.baidu.tieba.ala.alaar.sticker.download.b.bQx().isRunning(fuFaceItem.file)) {
            if (this.gmr != null) {
                this.gmr.bQW();
            }
            a(fuFaceItem, fVar, i);
        }
    }

    private void a(final FuFaceItem fuFaceItem, final f fVar, final int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (fuFaceItem != null && !TextUtils.isEmpty(fuFaceItem.file)) {
            com.baidu.tieba.ala.alaar.sticker.a.h.a(fuFaceItem, new h.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                /* renamed from: b */
                public void aD(FuFaceItem fuFaceItem2) {
                    Log.e("AlaSticker Adapter", "onStarted:" + fuFaceItem2.name);
                    if (fVar != null) {
                        fVar.bRi();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                /* renamed from: c */
                public void aE(FuFaceItem fuFaceItem2) {
                    Log.e("AlaSticker Adapter", "onCompleted:" + fuFaceItem2.name);
                    if (d.this.gmr == null || d.this.gmr.bQV()) {
                        if (d.this.gmp != i) {
                            d.this.notifyDataSetChanged();
                            return;
                        }
                        d.this.gmo = i;
                        d.this.notifyDataSetChanged();
                        if (d.this.gmr != null) {
                            d.this.gmr.a(fuFaceItem, fuFaceItem2.getFilePath());
                            return;
                        }
                        return;
                    }
                    BdUtilHelper.showToast(d.this.mContext, a.h.txt_punish_sticker_using);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.sticker.a.h.a
                public void a(FuFaceItem fuFaceItem2, int i2, int i3, String str) {
                    Log.e("AlaSticker Adapter", "onFailed:" + fuFaceItem2.name + ", what:" + i2 + ", ext:" + i3 + ", msg:" + str);
                    d.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void a(boolean z, FuFaceItem fuFaceItem) {
        this.gmq = null;
        this.gmo = -1;
        this.gmp = -1;
        notifyDataSetChanged();
        if (z && this.gmr != null) {
            this.gmr.a(fuFaceItem, "none");
        }
    }
}
