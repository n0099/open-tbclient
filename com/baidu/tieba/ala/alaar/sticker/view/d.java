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
import com.baidu.tieba.ala.alaar.sticker.a.g;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.view.c;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes7.dex */
public class d extends BaseAdapter {
    private int aAM;
    private int fyN;
    private FuFaceItem fzP;
    private c.b fzQ;
    private int fzR;
    private Context mContext;
    private LinkedList<FuFaceItem> mList = new LinkedList<>();
    private int fzN = -1;
    private int fzO = -1;

    public d(Context context, int i, c.b bVar) {
        this.mContext = context;
        this.fyN = i;
        this.fzQ = bVar;
        if (this.fyN == 1) {
            this.aAM = BdUtilHelper.dip2px(this.mContext, 110.0f);
            this.fzR = BdUtilHelper.dip2px(this.mContext, 75.0f);
        } else if (this.fyN == 2) {
            this.aAM = BdUtilHelper.dip2px(this.mContext, 170.0f);
            this.fzR = BdUtilHelper.dip2px(this.mContext, 72.0f);
        } else if (this.fyN == 3) {
            this.aAM = BdUtilHelper.dip2px(this.mContext, 60.0f);
            this.fzR = BdUtilHelper.dip2px(this.mContext, 60.0f);
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
    /* renamed from: st */
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
            if (this.fyN == 1) {
                View inflate = LayoutInflater.from(this.mContext).inflate(a.h.ala_sticker_pic_item_layout, (ViewGroup) null);
                view2 = inflate;
                gVar = new g(inflate);
            } else if (this.fyN == 2) {
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
                view2.setLayoutParams(new AbsListView.LayoutParams(this.aAM, this.fzR));
            } else {
                layoutParams.width = this.aAM;
                layoutParams.height = this.fzR;
            }
            view2.setTag(gVar);
        } else {
            gVar = (i) view.getTag();
            view2 = view;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                if (d.this.fzQ != null && !d.this.fzQ.bEO()) {
                    BdUtilHelper.showToast(d.this.mContext, a.i.txt_punish_sticker_using);
                } else if ((gVar instanceof g) || (gVar instanceof h)) {
                    if (d.this.fzQ != null) {
                        d.this.fzQ.a(d.this.getItem(i), d.this.getItem(i).getFilePath());
                    }
                    d.this.fzN = i;
                    d.this.notifyDataSetChanged();
                } else if (i != 0 || !d.this.getItem(i).isCancelItem) {
                    d.this.fzP = null;
                    if (i != d.this.fzN) {
                        d.this.a(d.this.getItem(i), i, (f) gVar);
                    }
                } else {
                    d.this.a(true, d.this.getItem(i));
                }
            }
        });
        gVar.d(getItem(i));
        if ((gVar instanceof g) || (gVar instanceof h)) {
            if (this.fzN == i) {
                gVar.fAO.setVisibility(0);
            } else {
                gVar.fAO.setVisibility(4);
            }
        } else if (i != 0 && this.fzN == i && this.fzP == null) {
            gVar.fAO.setVisibility(0);
        } else {
            gVar.fAO.setVisibility(4);
        }
        return view2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FuFaceItem fuFaceItem, int i, f fVar) {
        this.fzO = i;
        if (fuFaceItem.isResLoaded()) {
            if (this.fzQ != null) {
                this.fzQ.a(fuFaceItem, fuFaceItem.getFilePath());
            }
            this.fzN = i;
            notifyDataSetChanged();
        } else if (TextUtils.isEmpty(fuFaceItem.file) || !com.baidu.tieba.ala.alaar.sticker.download.b.bEs().isRunning(fuFaceItem.file)) {
            if (this.fzQ != null) {
                this.fzQ.bEP();
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
                /* renamed from: b */
                public void ax(FuFaceItem fuFaceItem2) {
                    Log.e("AlaSticker Adapter", "onStarted:" + fuFaceItem2.name);
                    if (fVar != null) {
                        fVar.bFb();
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tieba.ala.alaar.sticker.a.g.a
                /* renamed from: c */
                public void ay(FuFaceItem fuFaceItem2) {
                    Log.e("AlaSticker Adapter", "onCompleted:" + fuFaceItem2.name);
                    if (d.this.fzQ == null || d.this.fzQ.bEO()) {
                        if (d.this.fzO != i) {
                            d.this.notifyDataSetChanged();
                            return;
                        }
                        d.this.fzN = i;
                        d.this.notifyDataSetChanged();
                        if (d.this.fzQ != null) {
                            d.this.fzQ.a(fuFaceItem, fuFaceItem2.getFilePath());
                            return;
                        }
                        return;
                    }
                    BdUtilHelper.showToast(d.this.mContext, a.i.txt_punish_sticker_using);
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
        this.fzP = null;
        this.fzN = -1;
        this.fzO = -1;
        notifyDataSetChanged();
        if (z && this.fzQ != null) {
            this.fzQ.a(fuFaceItem, "none");
        }
    }
}
