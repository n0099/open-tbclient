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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private ViewGroup flb;
    private InterfaceC0530a flc;
    public List<f> auC = new ArrayList();
    private int fjj = -1;
    private int fjk = -1;
    private int fld = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0530a {
        void b(int i, int[] iArr);
    }

    public a(ViewGroup viewGroup) {
        this.flb = viewGroup;
    }

    public void a(InterfaceC0530a interfaceC0530a) {
        this.flc = interfaceC0530a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auC == null) {
            return 0;
        }
        return this.auC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pV */
    public f getItem(int i) {
        return (f) ListUtils.getItem(this.auC, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<f> list) {
        if (!ListUtils.isEmpty(list)) {
            this.auC.clear();
            this.auC.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<f> getDatas() {
        return this.auC;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.flb.getContext()).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
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
            if (this.fjj == i) {
                eVar.btg();
            } else {
                eVar.btf();
            }
        }
        if (i == 0 && this.fld != 0) {
            view.setPadding(this.fld, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, int i, e eVar, int[] iArr) {
        if (fVar != null) {
            this.fjk = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.Ba(fVar.vr())) {
                if (this.flc != null) {
                    this.flc.b(i, iArr);
                }
                this.fjj = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(fVar.vr()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cA(fVar.vr())) {
                a(fVar, eVar, i, iArr);
            }
        }
    }

    private void a(f fVar, final e eVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.flb.getContext(), a.i.sdk_network_not_available);
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
                    if (a.this.fjk != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.fjj = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.flc != null) {
                        a.this.flc.b(i, iArr);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void Bm(String str) {
        String AZ;
        if (this.auC != null && this.auC.size() > 0 && !TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < this.auC.size()) {
                    if (this.flb.getContext().getString(a.i.beauty_yuantu).equals(this.auC.get(i3).getName())) {
                        com.baidu.minivideo.arface.b.MZ();
                        AZ = com.baidu.minivideo.arface.c.Ne();
                        i2 = i3;
                    } else {
                        AZ = com.baidu.tieba.ala.alaar.sticker.a.e.AZ(this.auC.get(i3).vr());
                    }
                    if (!str.equals(AZ)) {
                        i = i3 + 1;
                    } else {
                        this.fjj = i3;
                        notifyDataSetChanged();
                        if (this.flc != null) {
                            this.flc.b(i3, null);
                            return;
                        }
                        return;
                    }
                } else if (i2 >= 0) {
                    this.fjj = i2;
                    notifyDataSetChanged();
                    if (this.flc != null) {
                        this.flc.b(i2, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void pW(int i) {
        this.fld = i;
    }
}
