package com.baidu.tieba.ala.alaar.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.sdk.a;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.baidu.tieba.ala.alaar.makeup.c;
import com.baidu.tieba.ala.alaar.view.b;
import java.io.File;
import java.util.List;
/* loaded from: classes4.dex */
public class f<T extends com.baidu.tieba.ala.alaar.makeup.c> extends h<List<T>, T, a> {
    private int gfC;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gfC = 0;
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
    /* renamed from: uj */
    public T getItem(int i) {
        return (T) ((List) this.mData).get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: uk */
    public T ul(int i) {
        return (T) ((List) this.mData).get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: a */
    public f<T>.a b(int i, ViewGroup viewGroup) {
        return new a(new BeautyItemView(viewGroup.getContext()), null);
    }

    public void ug(int i) {
        this.gfC = i;
    }

    /* loaded from: classes4.dex */
    public class a extends b<T> {
        private ObjectAnimator gfb;
        private BeautyItemView ggc;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.ggc = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.ggc.gfK.getHierarchy();
            if (hierarchy == null) {
                this.ggc.gfK.setHierarchy(new com.facebook.drawee.generic.b(this.ggc.getResources()).Po(300).Pp(a.e.filter_beauty_item_bg).emq());
                return;
            }
            hierarchy.Pm(a.e.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void j(int i, T t) {
            String str;
            c.a bLX = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bLX();
            if (bLX == null) {
                str = null;
            } else {
                str = bLX.bMi();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.ggc.gfK.setImageURI("file://" + str);
                } else {
                    this.ggc.gfK.setImageURI(str);
                }
            }
            this.ggc.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).name);
            if (i == 0 && f.this.gfC != 0) {
                this.ggc.setPadding(f.this.gfC, 0, 0, 0);
            } else {
                this.ggc.setPadding(0, 0, 0, 0);
            }
            lv(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.ggc.gfa.setVisibility(4);
                    bNx();
                } else if (t.isLoading()) {
                    this.ggc.gfa.setVisibility(0);
                    bNw();
                } else {
                    this.ggc.gfa.setVisibility(0);
                    this.ggc.gfa.setRotation(0.0f);
                    this.ggc.gfa.setImageResource(a.e.sticker_unload);
                    bNx();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.view.b
        public boolean uh(int i) {
            boolean z = i == this.position;
            if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "setCurrentPosition vHolder=" + this.position + "==" + i + " = " + z);
            }
            return lv(z) | super.uh(i);
        }

        public boolean lv(boolean z) {
            if (z) {
                this.ggc.setSelectedBackground();
                return false;
            }
            this.ggc.setUnselectedBackground();
            return false;
        }

        public void bNw() {
            if (this.gfb == null) {
                this.gfb = ObjectAnimator.ofFloat(this.ggc.gfa, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
                this.gfb.setRepeatCount(-1);
                this.gfb.setDuration(1000L);
            }
            if (!this.gfb.isRunning()) {
                this.ggc.gfa.setImageResource(a.e.sticker_loading);
                this.gfb.start();
            }
        }

        public void bNx() {
            if (this.gfb != null && this.gfb.isRunning()) {
                this.gfb.cancel();
            }
        }
    }
}
