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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private ViewGroup fBJ;
    private InterfaceC0587a fBK;
    public List<f> azC = new ArrayList();
    private int fzR = -1;
    private int fzS = -1;
    private int fBL = 0;

    /* renamed from: com.baidu.tieba.ala.alaar.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0587a {
        void b(int i, int[] iArr);
    }

    public a(ViewGroup viewGroup) {
        this.fBJ = viewGroup;
    }

    public void a(InterfaceC0587a interfaceC0587a) {
        this.fBK = interfaceC0587a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.azC == null) {
            return 0;
        }
        return this.azC.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: sw */
    public f getItem(int i) {
        return (f) ListUtils.getItem(this.azC, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void setDatas(List<f> list) {
        if (!ListUtils.isEmpty(list)) {
            this.azC.clear();
            this.azC.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<f> getDatas() {
        return this.azC;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final e eVar;
        if (view == null) {
            view = LayoutInflater.from(this.fBJ.getContext()).inflate(a.h.filter_ar_item_layout, (ViewGroup) null);
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
            if (this.fzR == i) {
                eVar.bFp();
            } else {
                eVar.bFo();
            }
        }
        if (i == 0 && this.fBL != 0) {
            view.setPadding(this.fBL, 0, 0, 0);
        } else {
            view.setPadding(0, 0, 0, 0);
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, int i, e eVar, int[] iArr) {
        if (fVar != null) {
            this.fzS = i;
            if (com.baidu.tieba.ala.alaar.sticker.a.e.Eg(fVar.AP())) {
                if (this.fBK != null) {
                    this.fBK.b(i, iArr);
                }
                this.fzR = i;
                notifyDataSetChanged();
            } else if (TextUtils.isEmpty(fVar.AP()) || !com.baidu.tieba.ala.alaar.sticker.a.e.cE(fVar.AP())) {
                a(fVar, eVar, i, iArr);
            }
        }
    }

    private void a(f fVar, final e eVar, final int i, final int[] iArr) {
        if (!BdNetTypeUtil.isNetWorkAvailable()) {
            BdUtilHelper.showToast(this.fBJ.getContext(), a.i.sdk_network_not_available);
        } else if (fVar != null && !TextUtils.isEmpty(fVar.AP())) {
            com.baidu.tieba.ala.alaar.sticker.a.e.a(fVar.AP(), new e.a() { // from class: com.baidu.tieba.ala.alaar.view.a.2
                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onStarted() {
                    if (eVar != null) {
                        eVar.bFc();
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onProgress(long j, long j2, int i2) {
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onCompleted(String str) {
                    if (a.this.fzS != i) {
                        a.this.notifyDataSetChanged();
                        return;
                    }
                    a.this.fzR = i;
                    a.this.notifyDataSetChanged();
                    if (a.this.fBK != null) {
                        a.this.fBK.b(i, iArr);
                    }
                }

                @Override // com.baidu.tieba.ala.alaar.sticker.a.e.a
                public void onFailed(int i2, int i3, String str) {
                    a.this.notifyDataSetChanged();
                }
            });
        }
    }

    public void Es(String str) {
        String Ef;
        if (this.azC != null && this.azC.size() > 0 && !TextUtils.isEmpty(str)) {
            int i = 0;
            int i2 = -1;
            while (true) {
                int i3 = i;
                if (i3 < this.azC.size()) {
                    if (this.fBJ.getContext().getString(a.i.beauty_yuantu).equals(this.azC.get(i3).getName())) {
                        com.baidu.minivideo.arface.b.SY();
                        Ef = com.baidu.minivideo.arface.c.Td();
                        i2 = i3;
                    } else {
                        Ef = com.baidu.tieba.ala.alaar.sticker.a.e.Ef(this.azC.get(i3).AP());
                    }
                    if (!str.equals(Ef)) {
                        i = i3 + 1;
                    } else {
                        this.fzR = i3;
                        notifyDataSetChanged();
                        if (this.fBK != null) {
                            this.fBK.b(i3, null);
                            return;
                        }
                        return;
                    }
                } else if (i2 >= 0) {
                    this.fzR = i2;
                    notifyDataSetChanged();
                    if (this.fBK != null) {
                        this.fBK.b(i2, null);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
    }

    public void sx(int i) {
        this.fBL = i;
    }
}
