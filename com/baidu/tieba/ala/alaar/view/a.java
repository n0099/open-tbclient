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
    private InterfaceC0616a gad;
    private Context mContext;
    public List<com.baidu.live.ar.g> aDr = new ArrayList();
    private int fYF = -1;
    private int fYG = -1;
    private int gae = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0616a {
        void a(int i, int[] iArr, boolean z);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0616a interfaceC0616a) {
        this.gad = interfaceC0616a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDr == null) {
            return 0;
        }
        return this.aDr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tx */
    public com.baidu.live.ar.g getItem(int i) {
        return (com.baidu.live.ar.g) ListUtils.getItem(this.aDr, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<com.baidu.live.ar.g> list) {
        if (!ListUtils.isEmpty(list)) {
            this.aDr.clear();
            this.aDr.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.g> getDatas() {
        return this.aDr;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final g gVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
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
            if (this.fYF == i) {
                gVar.bLR();
            } else {
                gVar.bLQ();
            }
        }
        if (i == 0 && this.gae != 0) {
            view.setPadding(this.gae, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.g gVar, int i, g gVar2, int[] iArr, boolean z) {
        if (gVar != null) {
            this.fYG = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.FM(gVar.Cc())) {
                if (this.gad != null) {
                    this.gad.a(i, iArr, z);
                }
                this.fYF = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(gVar.Cc()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cG(gVar.Cc())) {
                a(gVar, gVar2, i, iArr);
            }
        }
    }

    private void a(com.baidu.live.ar.g gVar, final g gVar2, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.i.sdk_network_not_available);
        } else if (gVar != null && !TextUtils.isEmpty(gVar.Cc())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(gVar.Cc(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (gVar2 != null) {
                        gVar2.bLE();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.fYG != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.fYF = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.gad != null) {
                        a.this.gad.a(i, iArr, false);
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
        if (this.aDr != null && this.aDr.size() > 0 && i >= 0 && i < getCount()) {
            this.fYF = i;
            notifyDataSetChanged();
            if (this.gad != null) {
                this.gad.a(this.fYF, null, false);
            }
        }
    }

    public void ty(int i) {
        this.gae = i;
    }
}
