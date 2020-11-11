package com.baidu.tieba.ala.alaar.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alaar.sticker.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private InterfaceC0628a gfU;
    private Context mContext;
    public List<com.baidu.live.ar.h> aDY = new ArrayList();
    private int gex = -1;
    private int gey = -1;
    private int gfV = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0628a {
        void a(int i, int[] iArr, boolean z);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0628a interfaceC0628a) {
        this.gfU = interfaceC0628a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDY == null) {
            return 0;
        }
        return this.aDY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tH */
    public com.baidu.live.ar.h getItem(int i) {
        return (com.baidu.live.ar.h) ListUtils.getItem(this.aDY, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<com.baidu.live.ar.h> list) {
        if (!ListUtils.isEmpty(list)) {
            this.aDY.clear();
            this.aDY.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.h> getDatas() {
        return this.aDY;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final g gVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.g.filter_ar_item_layout, (ViewGroup) null);
            gVar = new g(view);
            view.setTag(gVar);
        } else {
            gVar = (g) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (gVar != null && gVar.mRootView != null) {
                    gVar.mRootView.getLocationOnScreen(iArr);
                }
                a.this.a(a.this.getItem(i), i, gVar, iArr, true);
            }
        });
        if (gVar != null) {
            gVar.b(getItem(i));
            if (this.gex == i) {
                gVar.bOr();
            } else {
                gVar.bOq();
            }
        }
        if (i == 0 && this.gfV != 0) {
            view.setPadding(this.gfV, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.h hVar, int i, g gVar, int[] iArr, boolean z) {
        if (hVar != null) {
            this.gey = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.Ga(hVar.Cu())) {
                if (this.gfU != null) {
                    this.gfU.a(i, iArr, z);
                }
                this.gex = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(hVar.Cu()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cG(hVar.Cu())) {
                a(hVar, gVar, i, iArr);
            }
        }
    }

    private void a(com.baidu.live.ar.h hVar, final g gVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (hVar != null && !TextUtils.isEmpty(hVar.Cu())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(hVar.Cu(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (gVar != null) {
                        gVar.bOd();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.gey != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.gex = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.gfU != null) {
                        a.this.gfU.a(i, iArr, false);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void setSelect(int i) {
        if (this.aDY != null && this.aDY.size() > 0 && i >= 0 && i < getCount()) {
            this.gex = i;
            notifyDataSetChanged();
            if (this.gfU != null) {
                this.gfU.a(this.gex, null, false);
            }
        }
    }

    public void tI(int i) {
        this.gfV = i;
    }
}
