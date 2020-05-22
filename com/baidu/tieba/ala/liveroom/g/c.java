package com.baidu.tieba.ala.liveroom.g;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyFilterItemView;
import java.util.ArrayList;
import java.util.Arrays;
/* loaded from: classes3.dex */
public class c extends BaseAdapter {
    private ViewGroup eZL;
    private b fSP;
    public final a[] fSO = {new a(a.f.img_live_filter_ziran, "delta", "自然"), new a(a.f.img_live_filter_fennen, "slowlived", "粉嫩"), new a(a.f.img_live_filter_rouguang, "pink", "柔光"), new a(a.f.img_live_filter_fsqq, "sakura", "粉红气球"), new a(a.f.img_live_filter_mgzc, "hongkong", "暮光之城")};
    private int eZZ = -1;
    private int eZN = 0;
    private ArrayList<Boolean> eZY = new ArrayList<>();

    /* loaded from: classes3.dex */
    public interface b {
        void onItemSelected(int i);
    }

    public c(ViewGroup viewGroup) {
        this.eZL = viewGroup;
        bqe();
    }

    private void bqe() {
        if (this.eZY != null) {
            this.eZY.clear();
            this.eZY.addAll(Arrays.asList(new Boolean[this.fSO.length]));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qS(int i) {
        if (i >= 0) {
            this.eZY.set(i, true);
            this.eZZ = i;
            if (this.fSP != null) {
                this.fSP.onItemSelected(i);
            }
        }
    }

    public void AT(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < this.fSO.length; i++) {
                if (str.equals(this.fSO[i].mFilterName)) {
                    qS(i);
                    return;
                }
            }
        }
    }

    public void a(b bVar) {
        this.fSP = bVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.fSO.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        C0561c c0561c;
        if (view == null) {
            C0561c c0561c2 = new C0561c();
            c0561c2.fSR = new AlaLiveMultiBeautyFilterItemView(this.eZL.getContext());
            c0561c2.fSR.setTag(c0561c2);
            c0561c = c0561c2;
        } else {
            c0561c = (C0561c) view.getTag();
        }
        if (this.eZY.get(i) == null || !this.eZY.get(i).booleanValue()) {
            c0561c.fSR.setUnselectedBackground();
        } else {
            c0561c.fSR.setSelectedBackground();
        }
        c0561c.fSR.setItemIcon(this.fSO[i % this.fSO.length].mDrawableId);
        c0561c.fSR.setItemText(this.fSO[i % this.fSO.length].mShowName);
        c0561c.fSR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.g.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (c.this.eZZ != i) {
                    View childAt = c.this.eZL.getChildAt(c.this.eZZ);
                    if (childAt != null && (childAt instanceof AlaLiveMultiBeautyFilterItemView)) {
                        ((AlaLiveMultiBeautyFilterItemView) childAt).setUnselectedBackground();
                    }
                    if (c.this.eZZ >= 0) {
                        c.this.eZY.set(c.this.eZZ, false);
                    }
                }
                if (view2.getTag() != null) {
                    ((C0561c) view2.getTag()).fSR.setSelectedBackground();
                }
                c.this.qS(i);
                c.this.notifyDataSetChanged();
            }
        });
        if (i == 0 && this.eZN != 0) {
            c0561c.fSR.setPadding(this.eZN, 0, 0, 0);
        } else {
            c0561c.fSR.setPadding(0, 0, 0, 0);
        }
        return c0561c.fSR;
    }

    public void pw(int i) {
        this.eZN = i;
    }

    /* renamed from: com.baidu.tieba.ala.liveroom.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class C0561c {
        AlaLiveMultiBeautyFilterItemView fSR;

        C0561c() {
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        public int mDrawableId;
        public String mFilterName;
        public String mShowName;

        public a(int i, String str, String str2) {
            this.mDrawableId = i;
            this.mFilterName = str;
            this.mShowName = str2;
        }
    }
}
