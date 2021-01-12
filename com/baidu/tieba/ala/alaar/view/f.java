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
/* loaded from: classes10.dex */
public class f<T extends com.baidu.tieba.ala.alaar.makeup.c> extends h<List<T>, T, a> {
    private int gtC;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gtC = 0;
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
    /* renamed from: tt */
    public T getItem(int i) {
        return (T) ((List) this.mData).get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: tu */
    public T tv(int i) {
        return (T) ((List) this.mData).get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: a */
    public f<T>.a b(int i, ViewGroup viewGroup) {
        return new a(new BeautyItemView(viewGroup.getContext()), null);
    }

    public void tq(int i) {
        this.gtC = i;
    }

    /* loaded from: classes10.dex */
    public class a extends b<T> {
        private ObjectAnimator gtb;
        private BeautyItemView gud;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.gud = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.gud.gtK.getHierarchy();
            if (hierarchy == null) {
                this.gud.gtK.setHierarchy(new com.facebook.drawee.generic.b(this.gud.getResources()).OS(300).OT(a.e.filter_beauty_item_bg).esy());
                return;
            }
            hierarchy.OR(a.e.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void j(int i, T t) {
            String str;
            c.a bOs = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bOs();
            if (bOs == null) {
                str = null;
            } else {
                str = bOs.bOD();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.gud.gtK.setImageURI("file://" + str);
                } else {
                    this.gud.gtK.setImageURI(str);
                }
            }
            this.gud.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).bOq());
            if (i == 0 && f.this.gtC != 0) {
                this.gud.setPadding(f.this.gtC, 0, 0, 0);
            } else {
                this.gud.setPadding(0, 0, 0, 0);
            }
            mj(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.gud.gta.setVisibility(4);
                    bPQ();
                } else if (t.isLoading()) {
                    this.gud.gta.setVisibility(0);
                    bPP();
                } else {
                    this.gud.gta.setVisibility(0);
                    this.gud.gta.setRotation(0.0f);
                    this.gud.gta.setImageResource(a.e.sticker_unload);
                    bPQ();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.view.b
        public boolean tr(int i) {
            boolean z = i == this.position;
            if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "setCurrentPosition vHolder=" + this.position + "==" + i + " = " + z);
            }
            return mj(z) | super.tr(i);
        }

        public boolean mj(boolean z) {
            if (z) {
                this.gud.setSelectedBackground();
                return false;
            }
            this.gud.setUnselectedBackground();
            return false;
        }

        public void bPP() {
            if (this.gtb == null) {
                this.gtb = ObjectAnimator.ofFloat(this.gud.gta, "rotation", 0.0f, 359.0f);
                this.gtb.setRepeatCount(-1);
                this.gtb.setDuration(1000L);
            }
            if (!this.gtb.isRunning()) {
                this.gud.gta.setImageResource(a.e.sticker_loading);
                this.gtb.start();
            }
        }

        public void bPQ() {
            if (this.gtb != null && this.gtb.isRunning()) {
                this.gtb.cancel();
            }
        }
    }
}
