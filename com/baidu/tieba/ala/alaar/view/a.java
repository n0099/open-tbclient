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
    private ViewGroup fEV;
    private InterfaceC0583a fEW;
    public List<f> aAi = new ArrayList();
    private int fDd = -1;
    private int fDe = -1;
    private int fEX = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC0583a {
        void b(int i, int[] iArr);
    }

    public a(ViewGroup viewGroup) {
        this.fEV = viewGroup;
    }

    public void a(InterfaceC0583a interfaceC0583a) {
        this.fEW = interfaceC0583a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aAi == null) {
            return 0;
        }
        return this.aAi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sO */
    public f getItem(int i) {
        return (f) ListUtils.getItem(this.aAi, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<f> list) {
        if (!ListUtils.isEmpty(list)) {
            this.aAi.clear();
            this.aAi.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<f> getDatas() {
        return this.aAi;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.fEV.getContext()).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
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
            if (this.fDd == i) {
                eVar.bGF();
            } else {
                eVar.bGE();
            }
        }
        if (i == 0 && this.fEX != 0) {
            view.setPadding(this.fEX, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, int i, e eVar, int[] iArr) {
        if (fVar != null) {
            this.fDe = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.ED(fVar.Be())) {
                if (this.fEW != null) {
                    this.fEW.b(i, iArr);
                }
                this.fDd = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(fVar.Be()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cG(fVar.Be())) {
                a(fVar, eVar, i, iArr);
            }
        }
    }

    private void a(f fVar, final e eVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.fEV.getContext(), a.i.sdk_network_not_available);
        } else if (fVar != null && !TextUtils.isEmpty(fVar.Be())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(fVar.Be(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (eVar != null) {
                        eVar.bGs();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.fDe != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.fDd = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.fEW != null) {
                        a.this.fEW.b(i, iArr);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void EQ(String str) {
        String EC;
        if (this.aAi != null && this.aAi.size() > 0 && !TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < this.aAi.size()) {
                    if (this.fEV.getContext().getString(a.i.beauty_yuantu).equals(this.aAi.get(i3).getName())) {
                        com.baidu.minivideo.arface.b.TP();
                        EC = com.baidu.minivideo.arface.c.TU();
                        i2 = i3;
                    } else {
                        EC = com.baidu.tieba.ala.alaar.sticker.a.e.EC(this.aAi.get(i3).Be());
                    }
                    if (!str.equals(EC)) {
                        i = i3 + 1;
                    } else {
                        this.fDd = i3;
                        notifyDataSetChanged();
                        if (this.fEW != null) {
                            this.fEW.b(i3, null);
                            return;
                        }
                        return;
                    }
                } else if (i2 >= 0) {
                    this.fDd = i2;
                    notifyDataSetChanged();
                    if (this.fEW != null) {
                        this.fEW.b(i2, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void sP(int i) {
        this.fEX = i;
    }
}
