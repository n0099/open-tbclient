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
    private ViewGroup eZL;
    private InterfaceC0522a eZM;
    public List<d> asJ = new ArrayList();
    private int eYl = -1;
    private int eYm = -1;
    private int eZN = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0522a {
        void b(int i, int[] iArr);
    }

    public a(ViewGroup viewGroup) {
        this.eZL = viewGroup;
    }

    public void a(InterfaceC0522a interfaceC0522a) {
        this.eZM = interfaceC0522a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.asJ == null) {
            return 0;
        }
        return this.asJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pv */
    public d getItem(int i) {
        return (d) ListUtils.getItem(this.asJ, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<d> list) {
        if (!ListUtils.isEmpty(list)) {
            this.asJ.clear();
            this.asJ.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<d> getDatas() {
        return this.asJ;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final c cVar;
        if (view == null) {
            view = LayoutInflater.from(this.eZL.getContext()).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
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
            if (this.eYl == i) {
                cVar.bqg();
            } else {
                cVar.bqf();
            }
        }
        if (i == 0 && this.eZN != 0) {
            view.setPadding(this.eZN, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, int i, c cVar, int[] iArr) {
        if (dVar != null) {
            this.eYm = i;
            if (e.AH(dVar.uX())) {
                if (this.eZM != null) {
                    this.eZM.b(i, iArr);
                }
                this.eYl = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(dVar.uX()) || !e.cz(dVar.uX())) {
                a(dVar, cVar, i, iArr);
            }
        }
    }

    private void a(d dVar, final c cVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.eZL.getContext(), a.i.sdk_network_not_available);
        } else if (dVar != null && !TextUtils.isEmpty(dVar.uX())) {
            e.a(dVar.uX(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
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
                    if (a.this.eYm != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.eYl = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.eZM != null) {
                        a.this.eZM.b(i, iArr);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void AT(String str) {
        String AG;
        if (this.asJ != null && this.asJ.size() > 0 && !TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < this.asJ.size()) {
                    if (this.eZL.getContext().getString(a.i.beauty_yuantu).equals(this.asJ.get(i3).getName())) {
                        com.baidu.minivideo.arface.b.LQ();
                        AG = com.baidu.minivideo.arface.c.LT();
                        i2 = i3;
                    } else {
                        AG = e.AG(this.asJ.get(i3).uX());
                    }
                    if (!str.equals(AG)) {
                        i = i3 + 1;
                    } else {
                        this.eYl = i3;
                        notifyDataSetChanged();
                        if (this.eZM != null) {
                            this.eZM.b(i3, null);
                            return;
                        }
                        return;
                    }
                } else if (i2 >= 0) {
                    this.eYl = i2;
                    notifyDataSetChanged();
                    if (this.eZM != null) {
                        this.eZM.b(i2, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void pw(int i) {
        this.eZN = i;
    }
}
