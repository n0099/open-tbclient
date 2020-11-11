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
    private int gfV;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gfV = 0;
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
    /* renamed from: tL */
    public T getItem(int i) {
        return (T) ((List) this.mData).get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: tM */
    public T tN(int i) {
        return (T) ((List) this.mData).get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: a */
    public f<T>.a b(int i, ViewGroup viewGroup) {
        return new a(new BeautyItemView(viewGroup.getContext()), null);
    }

    public void tI(int i) {
        this.gfV = i;
    }

    /* loaded from: classes4.dex */
    public class a extends b<T> {
        private ObjectAnimator gfu;
        private BeautyItemView ggv;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.ggv = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.ggv.ggd.getHierarchy();
            if (hierarchy == null) {
                this.ggv.ggd.setHierarchy(new com.facebook.drawee.generic.b(this.ggv.getResources()).OL(300).OM(a.e.filter_beauty_item_bg).ems());
                return;
            }
            hierarchy.OJ(a.e.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void j(int i, T t) {
            String str;
            c.a bME = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bME();
            if (bME == null) {
                str = null;
            } else {
                str = bME.bMP();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.ggv.ggd.setImageURI("file://" + str);
                } else {
                    this.ggv.ggd.setImageURI(str);
                }
            }
            this.ggv.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).name);
            if (i == 0 && f.this.gfV != 0) {
                this.ggv.setPadding(f.this.gfV, 0, 0, 0);
            } else {
                this.ggv.setPadding(0, 0, 0, 0);
            }
            lu(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.ggv.gft.setVisibility(4);
                    bOe();
                } else if (t.isLoading()) {
                    this.ggv.gft.setVisibility(0);
                    bOd();
                } else {
                    this.ggv.gft.setVisibility(0);
                    this.ggv.gft.setRotation(0.0f);
                    this.ggv.gft.setImageResource(a.e.sticker_unload);
                    bOe();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.view.b
        public boolean tJ(int i) {
            boolean z = i == this.position;
            if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "setCurrentPosition vHolder=" + this.position + "==" + i + " = " + z);
            }
            return lu(z) | super.tJ(i);
        }

        public boolean lu(boolean z) {
            if (z) {
                this.ggv.setSelectedBackground();
                return false;
            }
            this.ggv.setUnselectedBackground();
            return false;
        }

        public void bOd() {
            if (this.gfu == null) {
                this.gfu = ObjectAnimator.ofFloat(this.ggv.gft, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
                this.gfu.setRepeatCount(-1);
                this.gfu.setDuration(1000L);
            }
            if (!this.gfu.isRunning()) {
                this.ggv.gft.setImageResource(a.e.sticker_loading);
                this.gfu.start();
            }
        }

        public void bOe() {
            if (this.gfu != null && this.gfu.isRunning()) {
                this.gfu.cancel();
            }
        }
    }
}
