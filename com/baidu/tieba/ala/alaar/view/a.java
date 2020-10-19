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
    private ViewGroup fRe;
    private InterfaceC0600a fRf;
    public List<f> aDn = new ArrayList();
    private int fPm = -1;
    private int fPn = -1;
    private int fRg = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0600a {
        void b(int i, int[] iArr);
    }

    public a(ViewGroup viewGroup) {
        this.fRe = viewGroup;
    }

    public void a(InterfaceC0600a interfaceC0600a) {
        this.fRf = interfaceC0600a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aDn == null) {
            return 0;
        }
        return this.aDn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tm */
    public f getItem(int i) {
        return (f) ListUtils.getItem(this.aDn, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<f> list) {
        if (!ListUtils.isEmpty(list)) {
            this.aDn.clear();
            this.aDn.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<f> getDatas() {
        return this.aDn;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.fRe.getContext()).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
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
            if (this.fPm == i) {
                eVar.bJr();
            } else {
                eVar.bJq();
            }
        }
        if (i == 0 && this.fRg != 0) {
            view.setPadding(this.fRg, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, int i, e eVar, int[] iArr) {
        if (fVar != null) {
            this.fPn = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.Fo(fVar.Cb())) {
                if (this.fRf != null) {
                    this.fRf.b(i, iArr);
                }
                this.fPm = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(fVar.Cb()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cG(fVar.Cb())) {
                a(fVar, eVar, i, iArr);
            }
        }
    }

    private void a(f fVar, final e eVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.fRe.getContext(), a.i.sdk_network_not_available);
        } else if (fVar != null && !TextUtils.isEmpty(fVar.Cb())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(fVar.Cb(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (eVar != null) {
                        eVar.bJe();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.fPn != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.fPm = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.fRf != null) {
                        a.this.fRf.b(i, iArr);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void FB(String str) {
        String Fn;
        if (this.aDn != null && this.aDn.size() > 0 && !TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < this.aDn.size()) {
                    if (this.fRe.getContext().getString(a.i.beauty_yuantu).equals(this.aDn.get(i3).getName())) {
                        com.baidu.minivideo.arface.b.VI();
                        Fn = com.baidu.minivideo.arface.c.VN();
                        i2 = i3;
                    } else {
                        Fn = com.baidu.tieba.ala.alaar.sticker.a.e.Fn(this.aDn.get(i3).Cb());
                    }
                    if (!str.equals(Fn)) {
                        i = i3 + 1;
                    } else {
                        this.fPm = i3;
                        notifyDataSetChanged();
                        if (this.fRf != null) {
                            this.fRf.b(i3, null);
                            return;
                        }
                        return;
                    }
                } else if (i2 >= 0) {
                    this.fPm = i2;
                    notifyDataSetChanged();
                    if (this.fRf != null) {
                        this.fRf.b(i2, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void tn(int i) {
        this.fRg = i;
    }
}
