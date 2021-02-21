package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
import com.baidu.tieba.ala.alaar.makeup.c;
import com.baidu.tieba.ala.alaar.view.b;
import java.io.File;
import java.util.List;
/* loaded from: classes11.dex */
public class f<T extends com.baidu.tieba.ala.alaar.makeup.c> extends h<List<T>, T, a> {
    private int gwA;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gwA = 0;
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == 0) {
            return 0;
        }
        return ((List) this.mData).size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: tz */
    public T getItem(int i) {
        return (T) ((List) this.mData).get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: tA */
    public T tB(int i) {
        return (T) ((List) this.mData).get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: a */
    public f<T>.a b(int i, ViewGroup viewGroup) {
        return new a(new BeautyItemView(viewGroup.getContext()), null);
    }

    public void tw(int i) {
        this.gwA = i;
    }

    /* loaded from: classes11.dex */
    public class a extends b<T> {
        private ObjectAnimator gvZ;
        private BeautyItemView gxb;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.gxb = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.gxb.gwI.getHierarchy();
            if (hierarchy == null) {
                this.gxb.gwI.setHierarchy(new com.facebook.drawee.generic.b(this.gxb.getResources()).Po(300).Pp(a.e.filter_beauty_item_bg).euY());
                return;
            }
            hierarchy.Pn(a.e.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void j(int i, T t) {
            String str;
            c.a bPd = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bPd();
            if (bPd == null) {
                str = null;
            } else {
                str = bPd.bPo();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.gxb.gwI.setImageURI("file://" + str);
                } else {
                    this.gxb.gwI.setImageURI(str);
                }
            }
            this.gxb.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).bPb());
            if (i == 0 && f.this.gwA != 0) {
                this.gxb.setPadding(f.this.gwA, 0, 0, 0);
            } else {
                this.gxb.setPadding(0, 0, 0, 0);
            }
            mn(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.gxb.gvY.setVisibility(4);
                    bQB();
                } else if (t.isLoading()) {
                    this.gxb.gvY.setVisibility(0);
                    bQA();
                } else {
                    this.gxb.gvY.setVisibility(0);
                    this.gxb.gvY.setRotation(0.0f);
                    this.gxb.gvY.setImageResource(a.e.sticker_unload);
                    bQB();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.view.b
        public boolean tx(int i) {
            boolean z = i == this.position;
            if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "setCurrentPosition vHolder=" + this.position + "==" + i + " = " + z);
            }
            return mn(z) | super.tx(i);
        }

        public boolean mn(boolean z) {
            if (z) {
                this.gxb.setSelectedBackground();
                return false;
            }
            this.gxb.setUnselectedBackground();
            return false;
        }

        public void bQA() {
            if (this.gvZ == null) {
                this.gvZ = ObjectAnimator.ofFloat(this.gxb.gvY, "rotation", 0.0f, 359.0f);
                this.gvZ.setRepeatCount(-1);
                this.gvZ.setDuration(1000L);
            }
            if (!this.gvZ.isRunning()) {
                this.gxb.gvY.setImageResource(a.e.sticker_loading);
                this.gvZ.start();
            }
        }

        public void bQB() {
            if (this.gvZ != null && this.gvZ.isRunning()) {
                this.gvZ.cancel();
            }
        }
    }
}
