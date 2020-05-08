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
    private ViewGroup eNo;
    private InterfaceC0475a eNp;
    public List<d> anP = new ArrayList();
    private int eLO = -1;
    private int eLP = -1;
    private int eNq = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0475a {
        void b(int i, int[] iArr);
    }

    public a(ViewGroup viewGroup) {
        this.eNo = viewGroup;
    }

    public void a(InterfaceC0475a interfaceC0475a) {
        this.eNp = interfaceC0475a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.anP == null) {
            return 0;
        }
        return this.anP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oU */
    public d getItem(int i) {
        return (d) ListUtils.getItem(this.anP, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.anP.clear();
            this.anP.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<d> getDatas() {
        return this.anP;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.eNo.getContext()).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
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
            if (this.eLO == i) {
                cVar.bkM();
            } else {
                cVar.bkL();
            }
        }
        if (i == 0 && this.eNq != 0) {
            view.setPadding(this.eNq, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, int i, c cVar, int[] iArr) {
        if (dVar != null) {
            this.eLP = i;
            if (e.zb(dVar.tQ())) {
                if (this.eNp != null) {
                    this.eNp.b(i, iArr);
                }
                this.eLO = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(dVar.tQ()) || !e.cy(dVar.tQ())) {
                a(dVar, cVar, i, iArr);
            }
        }
    }

    private void a(d dVar, final c cVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.eNo.getContext(), a.i.sdk_network_not_available);
        } else if (dVar != null && !TextUtils.isEmpty(dVar.tQ())) {
            e.a(dVar.tQ(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
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
                    if (a.this.eLP != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.eLO = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.eNp != null) {
                        a.this.eNp.b(i, iArr);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void zn(String str) {
        String za;
        if (this.anP != null && this.anP.size() > 0 && !TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < this.anP.size()) {
                    if (this.eNo.getContext().getString(a.i.beauty_yuantu).equals(this.anP.get(i3).getName())) {
                        com.baidu.minivideo.arface.b.JX();
                        za = com.baidu.minivideo.arface.c.Ka();
                        i2 = i3;
                    } else {
                        za = e.za(this.anP.get(i3).tQ());
                    }
                    if (!str.equals(za)) {
                        i = i3 + 1;
                    } else {
                        this.eLO = i3;
                        notifyDataSetChanged();
                        if (this.eNp != null) {
                            this.eNp.b(i3, null);
                            return;
                        }
                        return;
                    }
                } else if (i2 >= 0) {
                    this.eLO = i2;
                    notifyDataSetChanged();
                    if (this.eNp != null) {
                        this.eNp.b(i2, null);
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
        this.eNq = i;
    }
}
