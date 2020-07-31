package com.baidu.tieba.ala.alaar.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.f;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.tieba.ala.alaar.sticker.a.e;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    private ViewGroup fqj;
    private InterfaceC0541a fqk;
    public List<f> auy = new ArrayList();
    private int foq = -1;

    /* renamed from: for  reason: not valid java name */
    private int f4for = -1;
    private int fql = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0541a {
        void b(int i, int[] iArr);
    }

    public a(ViewGroup viewGroup) {
        this.fqj = viewGroup;
    }

    public void a(InterfaceC0541a interfaceC0541a) {
        this.fqk = interfaceC0541a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auy == null) {
            return 0;
        }
        return this.auy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qk */
    public f getItem(int i) {
        return (f) ListUtils.getItem(this.auy, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<f> list) {
        if (!ListUtils.isEmpty(list)) {
            this.auy.clear();
            this.auy.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<f> getDatas() {
        return this.auy;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.fqj.getContext()).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
            eVar = new e(view);
            view.setTag(eVar);
        } else {
            eVar = (e) view.getTag();
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int[] iArr = new int[2];
                if (eVar != null && eVar.mRootView != null) {
                    eVar.mRootView.getLocationOnScreen(iArr);
                }
                a.this.a(a.this.getItem(i), i, eVar, iArr);
            }
        });
        if (eVar != null) {
            eVar.b(getItem(i));
            if (this.foq == i) {
                eVar.bwp();
            } else {
                eVar.bwo();
            }
        }
        if (i == 0 && this.fql != 0) {
            view.setPadding(this.fql, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, int i, e eVar, int[] iArr) {
        if (fVar != null) {
            this.f4for = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.BL(fVar.vr())) {
                if (this.fqk != null) {
                    this.fqk.b(i, iArr);
                }
                this.foq = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(fVar.vr()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cy(fVar.vr())) {
                a(fVar, eVar, i, iArr);
            }
        }
    }

    private void a(f fVar, final e eVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.fqj.getContext(), a.i.sdk_network_not_available);
        } else if (fVar != null && !TextUtils.isEmpty(fVar.vr())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(fVar.vr(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (eVar != null) {
                        eVar.startLoadingAnim();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.f4for != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.foq = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.fqk != null) {
                        a.this.fqk.b(i, iArr);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void BX(String str) {
        String BK;
        if (this.auy != null && this.auy.size() > 0 && !TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < this.auy.size()) {
                    if (this.fqj.getContext().getString(a.i.beauty_yuantu).equals(this.auy.get(i3).getName())) {
                        com.baidu.minivideo.arface.b.Ne();
                        BK = com.baidu.minivideo.arface.c.Nj();
                        i2 = i3;
                    } else {
                        BK = com.baidu.tieba.ala.alaar.sticker.a.e.BK(this.auy.get(i3).vr());
                    }
                    if (!str.equals(BK)) {
                        i = i3 + 1;
                    } else {
                        this.foq = i3;
                        notifyDataSetChanged();
                        if (this.fqk != null) {
                            this.fqk.b(i3, null);
                            return;
                        }
                        return;
                    }
                } else if (i2 >= 0) {
                    this.foq = i2;
                    notifyDataSetChanged();
                    if (this.fqk != null) {
                        this.fqk.b(i2, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void ql(int i) {
        this.fql = i;
    }
}
