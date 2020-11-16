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
    private InterfaceC0628a gfB;
    private Context mContext;
    public List<com.baidu.live.ar.h> aCn = new ArrayList();
    private int ged = -1;
    private int gee = -1;
    private int gfC = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0628a {
        void a(int i, int[] iArr, boolean z);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0628a interfaceC0628a) {
        this.gfB = interfaceC0628a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aCn == null) {
            return 0;
        }
        return this.aCn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uf */
    public com.baidu.live.ar.h getItem(int i) {
        return (com.baidu.live.ar.h) ListUtils.getItem(this.aCn, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<com.baidu.live.ar.h> list) {
        if (!ListUtils.isEmpty(list)) {
            this.aCn.clear();
            this.aCn.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.h> getDatas() {
        return this.aCn;
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
            if (this.ged == i) {
                gVar.bNK();
            } else {
                gVar.bNJ();
            }
        }
        if (i == 0 && this.gfC != 0) {
            view.setPadding(this.gfC, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.h hVar, int i, g gVar, int[] iArr, boolean z) {
        if (hVar != null) {
            this.gee = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.FB(hVar.BL())) {
                if (this.gfB != null) {
                    this.gfB.a(i, iArr, z);
                }
                this.ged = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(hVar.BL()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cI(hVar.BL())) {
                a(hVar, gVar, i, iArr);
            }
        }
    }

    private void a(com.baidu.live.ar.h hVar, final g gVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (hVar != null && !TextUtils.isEmpty(hVar.BL())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(hVar.BL(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (gVar != null) {
                        gVar.bNw();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.gee != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.ged = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.gfB != null) {
                        a.this.gfB.a(i, iArr, false);
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
        if (this.aCn != null && this.aCn.size() > 0 && i >= 0 && i < getCount()) {
            this.ged = i;
            notifyDataSetChanged();
            if (this.gfB != null) {
                this.gfB.a(this.ged, null, false);
            }
        }
    }

    public void ug(int i) {
        this.gfC = i;
    }
}
