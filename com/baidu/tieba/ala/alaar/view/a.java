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
    private InterfaceC0614a gtB;
    private Context mContext;
    public List<com.baidu.live.ar.i> aAy = new ArrayList();
    private int gsf = -1;
    private int gsg = -1;
    private int gtC = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0614a {
        void a(int i, int[] iArr, boolean z);
    }

    public a(Context context) {
        this.mContext = context;
    }

    public void a(InterfaceC0614a interfaceC0614a) {
        this.gtB = interfaceC0614a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAy == null) {
            return 0;
        }
        return this.aAy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tp */
    public com.baidu.live.ar.i getItem(int i) {
        return (com.baidu.live.ar.i) ListUtils.getItem(this.aAy, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<com.baidu.live.ar.i> list) {
        if (!ListUtils.isEmpty(list)) {
            this.aAy.clear();
            this.aAy.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<com.baidu.live.ar.i> getDatas() {
        return this.aAy;
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
            if (this.gsf == i) {
                gVar.bQd();
            } else {
                gVar.bQc();
            }
        }
        if (i == 0 && this.gtC != 0) {
            view.setPadding(this.gtC, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.live.ar.i iVar, int i, g gVar, int[] iArr, boolean z) {
        if (iVar != null) {
            this.gsg = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.Fd(iVar.yQ())) {
                if (this.gtB != null) {
                    this.gtB.a(i, iArr, z);
                }
                this.gsf = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(iVar.yQ()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cE(iVar.yQ())) {
                a(iVar, gVar, i, iArr);
            }
        }
    }

    private void a(com.baidu.live.ar.i iVar, final g gVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.mContext, a.h.sdk_network_not_available);
        } else if (iVar != null && !TextUtils.isEmpty(iVar.yQ())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(iVar.yQ(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (gVar != null) {
                        gVar.bPP();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.gsg != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.gsf = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.gtB != null) {
                        a.this.gtB.a(i, iArr, false);
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
        if (this.aAy != null && this.aAy.size() > 0 && i >= 0 && i < getCount()) {
            this.gsf = i;
            notifyDataSetChanged();
            if (this.gtB != null) {
                this.gtB.a(this.gsf, null, false);
            }
        }
    }

    public void tq(int i) {
        this.gtC = i;
    }
}
