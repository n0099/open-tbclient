package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.d;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ViewGroup eNj;
    private InterfaceC0454a eNk;
    public List<d> anJ = new ArrayList();
    private int eLJ = -1;
    private int eLK = -1;
    private int eNl = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0454a {
        void b(int i, int[] iArr);
    }

    public a(ViewGroup viewGroup) {
        this.eNj = viewGroup;
    }

    public void a(InterfaceC0454a interfaceC0454a) {
        this.eNk = interfaceC0454a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anJ == null) {
            return 0;
        }
        return this.anJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oU */
    public d getItem(int i) {
        return (d) ListUtils.getItem(this.anJ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.anJ.clear();
            this.anJ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<d> getDatas() {
        return this.anJ;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.eNj.getContext()).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
            cVar = new c(view);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (cVar != null && cVar.mRootView != null) {
                    cVar.mRootView.getLocationOnScreen(iArr);
                }
                a.this.a(a.this.getItem(i), i, cVar, iArr);
            }
        });
        if (cVar != null) {
            cVar.b(getItem(i));
            if (this.eLJ == i) {
                cVar.bkO();
            } else {
                cVar.bkN();
            }
        }
        if (i == 0 && this.eNl != 0) {
            view.setPadding(this.eNl, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, int i, c cVar, int[] iArr) {
        if (dVar != null) {
            this.eLK = i;
            if (e.yY(dVar.tR())) {
                if (this.eNk != null) {
                    this.eNk.b(i, iArr);
                }
                this.eLJ = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(dVar.tR()) || !e.cy(dVar.tR())) {
                a(dVar, cVar, i, iArr);
            }
        }
    }

    private void a(d dVar, final c cVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.eNj.getContext(), a.i.sdk_network_not_available);
        } else if (dVar != null && !TextUtils.isEmpty(dVar.tR())) {
            e.a(dVar.tR(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (cVar != null) {
                        cVar.startLoadingAnim();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.eLK != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.eLJ = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.eNk != null) {
                        a.this.eNk.b(i, iArr);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void zk(String str) {
        String yX;
        if (this.anJ != null && this.anJ.size() > 0 && !TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < this.anJ.size()) {
                    if (this.eNj.getContext().getString(a.i.beauty_yuantu).equals(this.anJ.get(i3).getName())) {
                        com.baidu.minivideo.arface.b.JY();
                        yX = com.baidu.minivideo.arface.c.Kb();
                        i2 = i3;
                    } else {
                        yX = e.yX(this.anJ.get(i3).tR());
                    }
                    if (!str.equals(yX)) {
                        i = i3 + 1;
                    } else {
                        this.eLJ = i3;
                        notifyDataSetChanged();
                        if (this.eNk != null) {
                            this.eNk.b(i3, null);
                            return;
                        }
                        return;
                    }
                } else if (i2 >= 0) {
                    this.eLJ = i2;
                    notifyDataSetChanged();
                    if (this.eNk != null) {
                        this.eNk.b(i2, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void oV(int i) {
        this.eNl = i;
    }
}
