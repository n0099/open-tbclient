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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private InterfaceC0620a gyi;
    private Context mContext;
    public List<com.baidu.live.ar.i> aDD = new ArrayList();
    private int gwM = -1;
    private int gwN = -1;
    private int gyj = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0620a {
        void b(int i, int[] iArr, boolean z);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0620a interfaceC0620a) {
        this.gyi = interfaceC0620a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDD == null) {
            return 0;
        }
        return this.aDD.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tx */
    public com.baidu.live.ar.i getItem(int i) {
        return (com.baidu.live.ar.i) ListUtils.getItem(this.aDD, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<com.baidu.live.ar.i> list) {
        if (!ListUtils.isEmpty(list)) {
            this.aDD.clear();
            this.aDD.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.i> getDatas() {
        return this.aDD;
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
            if (this.gwM == i) {
                gVar.bQU();
            } else {
                gVar.bQT();
            }
        }
        if (i == 0 && this.gyj != 0) {
            view.setPadding(this.gyj, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.i iVar, int i, g gVar, int[] iArr, boolean z) {
        if (iVar != null) {
            this.gwN = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.FL(iVar.zA())) {
                if (this.gyi != null) {
                    this.gyi.b(i, iArr, z);
                }
                this.gwM = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(iVar.zA()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cI(iVar.zA())) {
                a(iVar, gVar, i, iArr);
            }
        }
    }

    private void a(com.baidu.live.ar.i iVar, final g gVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (iVar != null && !TextUtils.isEmpty(iVar.zA())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(iVar.zA(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (gVar != null) {
                        gVar.bQG();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.gwN != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.gwM = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.gyi != null) {
                        a.this.gyi.b(i, iArr, false);
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
        if (this.aDD != null && this.aDD.size() > 0 && i >= 0 && i < getCount()) {
            this.gwM = i;
            notifyDataSetChanged();
            if (this.gyi != null) {
                this.gyi.b(this.gwM, null, false);
            }
        }
    }

    public void ty(int i) {
        this.gyj = i;
    }
}
