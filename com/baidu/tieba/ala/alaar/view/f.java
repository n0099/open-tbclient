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
    private int gae;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gae = 0;
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
    /* renamed from: tB */
    public T getItem(int i) {
        return (T) ((List) this.mData).get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: tC */
    public T tD(int i) {
        return (T) ((List) this.mData).get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: a */
    public f<T>.a b(int i, ViewGroup viewGroup) {
        return new a(new BeautyItemView(viewGroup.getContext()), null);
    }

    public void ty(int i) {
        this.gae = i;
    }

    /* loaded from: classes4.dex */
    public class a extends b<T> {
        private ObjectAnimator fZC;
        private BeautyItemView gaF;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.gaF = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.gaF.gam.getHierarchy();
            if (hierarchy == null) {
                this.gaF.gam.setHierarchy(new com.facebook.drawee.generic.b(this.gaF.getResources()).Oq(300).Or(a.f.filter_beauty_item_bg).eiD());
                return;
            }
            hierarchy.Oo(a.f.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void k(int i, T t) {
            String str;
            c.a bKf = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bKf();
            if (bKf == null) {
                str = null;
            } else {
                str = bKf.bKq();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.gaF.gam.setImageURI("file://" + str);
                } else {
                    this.gaF.gam.setImageURI(str);
                }
            }
            this.gaF.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).name);
            if (i == 0 && f.this.gae != 0) {
                this.gaF.setPadding(f.this.gae, 0, 0, 0);
            } else {
                this.gaF.setPadding(0, 0, 0, 0);
            }
            ll(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.gaF.fZB.setVisibility(4);
                    bLF();
                } else if (t.isLoading()) {
                    this.gaF.fZB.setVisibility(0);
                    bLE();
                } else {
                    this.gaF.fZB.setVisibility(0);
                    this.gaF.fZB.setRotation(0.0f);
                    this.gaF.fZB.setImageResource(a.f.sticker_unload);
                    bLF();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.view.b
        public boolean tz(int i) {
            boolean z = i == this.position;
            if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "setCurrentPosition vHolder=" + this.position + "==" + i + " = " + z);
            }
            return ll(z) | super.tz(i);
        }

        public boolean ll(boolean z) {
            if (z) {
                this.gaF.setSelectedBackground();
                return false;
            }
            this.gaF.setUnselectedBackground();
            return false;
        }

        public void bLE() {
            if (this.fZC == null) {
                this.fZC = ObjectAnimator.ofFloat(this.gaF.fZB, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
                this.fZC.setRepeatCount(-1);
                this.fZC.setDuration(1000L);
            }
            if (!this.fZC.isRunning()) {
                this.gaF.fZB.setImageResource(a.f.sticker_loading);
                this.fZC.start();
            }
        }

        public void bLF() {
            if (this.fZC != null && this.fZC.isRunning()) {
                this.fZC.cancel();
            }
        }
    }
}
