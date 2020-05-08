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
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.a.g;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.view.c;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class d extends BaseAdapter {
    private int aPg;
    private FuFaceItem eLQ;
    private c.a eLR;
    private int eLS;
    private int eLe;
    private Context mContext;
    private LinkedList<FuFaceItem> mList = new LinkedList<>();
    private int eLO = -1;
    private int eLP = -1;

    public d(Context context, int i, c.a aVar) {
        this.mContext = context;
        this.eLe = i;
        this.eLR = aVar;
        if (this.eLe == 2) {
            this.aPg = BdUtilHelper.dip2px(this.mContext, 110.0f);
            this.eLS = BdUtilHelper.dip2px(this.mContext, 75.0f);
        } else if (this.eLe == 1) {
            this.aPg = BdUtilHelper.dip2px(this.mContext, 170.0f);
            this.eLS = BdUtilHelper.dip2px(this.mContext, 72.0f);
        } else if (this.eLe == 3) {
            this.aPg = BdUtilHelper.dip2px(this.mContext, 60.0f);
            this.eLS = BdUtilHelper.dip2px(this.mContext, 60.0f);
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
    /* renamed from: oR */
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
            if (this.eLe == 2) {
                View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_sticker_pic_item_layout, (ViewGroup) null);
                view2 = inflate;
                gVar = new g(inflate);
            } else if (this.eLe == 1) {
                View inflate2 = LayoutInflater.from(this.mContext).inflate(a.h.ala_sticker_txt_item_layout, (ViewGroup) null);
                view2 = inflate2;
                gVar = new h(inflate2);
            } else {
                View inflate3 = LayoutInflater.from(this.mContext).inflate(a.h.ala_sticker_ar_item_layout, (ViewGroup) null);
                view2 = inflate3;
                gVar = new f(inflate3);
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
            if (layoutParams == null) {
                view2.setLayoutParams(new AbsListView.LayoutParams(this.aPg, this.eLS));
            } else {
                layoutParams.width = this.aPg;
                layoutParams.height = this.eLS;
            }
            view2.setTag(gVar);
        } else {
            gVar = (i) view.getTag();
            view2 = view;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if ((gVar instanceof g) || (gVar instanceof h)) {
                    if (d.this.eLR != null) {
                        d.this.eLR.a(d.this.getItem(i), d.this.getItem(i).getFilePath());
                    }
                    d.this.eLO = i;
                    d.this.notifyDataSetChanged();
                } else if (i != 0 || !d.this.getItem(i).isCancelItem) {
                    d.this.eLQ = null;
                    if (i != d.this.eLO) {
                        d.this.a(d.this.getItem(i), i, (f) gVar);
                    }
                } else {
                    d.this.a(true, d.this.getItem(i));
                }
            }
        });
        gVar.c(getItem(i));
        if ((gVar instanceof g) || (gVar instanceof h)) {
            if (this.eLO == i) {
                gVar.eMF.setVisibility(0);
            } else {
                gVar.eMF.setVisibility(4);
            }
        } else if (i != 0 && this.eLO == i && this.eLQ == null) {
            gVar.eMF.setVisibility(0);
        } else {
            gVar.eMF.setVisibility(4);
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FuFaceItem fuFaceItem, int i, f fVar) {
        this.eLP = i;
        if (fuFaceItem.isResLoaded()) {
            if (this.eLR != null) {
                this.eLR.a(fuFaceItem, fuFaceItem.getFilePath());
            }
            this.eLO = i;
            notifyDataSetChanged();
        } else if (TextUtils.isEmpty(fuFaceItem.file) || !com.baidu.tieba.ala.alaar.sticker.download.b.bki().isRunning(fuFaceItem.file)) {
            if (this.eLR != null) {
                this.eLR.bkD();
            }
            a(fuFaceItem, fVar, i);
        }
    }

    private void a(final FuFaceItem fuFaceItem, final f fVar, final int i) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (fuFaceItem != null && !TextUtils.isEmpty(fuFaceItem.file)) {
            com.baidu.tieba.ala.alaar.sticker.a.g.a(fuFaceItem, new g.a<FuFaceItem>() { // from class: com.baidu.tieba.ala.alaar.sticker.view.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                /* renamed from: a */
                public void aq(FuFaceItem fuFaceItem2) {
                    Log.e("AlaSticker Adapter", "onStarted:" + fuFaceItem2.name);
                    if (fVar != null) {
                        fVar.startLoadingAnim();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                /* renamed from: b */
                public void ar(FuFaceItem fuFaceItem2) {
                    Log.e("AlaSticker Adapter", "onCompleted:" + fuFaceItem2.name);
                    if (d.this.eLP != i) {
                        d.this.notifyDataSetChanged();
                        return;
                    }
                    d.this.eLO = i;
                    d.this.notifyDataSetChanged();
                    if (d.this.eLR != null) {
                        d.this.eLR.a(fuFaceItem, fuFaceItem2.getFilePath());
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                public void a(FuFaceItem fuFaceItem2, int i2, int i3, String str) {
                    Log.e("AlaSticker Adapter", "onFailed:" + fuFaceItem2.name + ", what:" + i2 + ", ext:" + i3 + ", msg:" + str);
                    d.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void a(boolean z, FuFaceItem fuFaceItem) {
        this.eLQ = null;
        this.eLO = -1;
        this.eLP = -1;
        notifyDataSetChanged();
        if (z && this.eLR != null) {
            this.eLR.a(fuFaceItem, "none");
        }
    }
}
