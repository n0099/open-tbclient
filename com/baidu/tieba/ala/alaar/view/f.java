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
    private int gnM;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gnM = 0;
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
    /* renamed from: uN */
    public T getItem(int i) {
        return (T) ((List) this.mData).get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: uO */
    public T uP(int i) {
        return (T) ((List) this.mData).get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ala.alaar.view.h
    /* renamed from: a */
    public f<T>.a b(int i, ViewGroup viewGroup) {
        return new a(new BeautyItemView(viewGroup.getContext()), null);
    }

    public void uK(int i) {
        this.gnM = i;
    }

    /* loaded from: classes4.dex */
    public class a extends b<T> {
        private ObjectAnimator gnl;
        private BeautyItemView gon;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.gon = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.gon.gnU.getHierarchy();
            if (hierarchy == null) {
                this.gon.gnU.setHierarchy(new com.facebook.drawee.generic.b(this.gon.getResources()).Ql(300).Qm(a.e.filter_beauty_item_bg).esg());
                return;
            }
            hierarchy.Qk(a.e.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void j(int i, T t) {
            String str;
            c.a bPJ = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bPJ();
            if (bPJ == null) {
                str = null;
            } else {
                str = bPJ.bPU();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.gon.gnU.setImageURI("file://" + str);
                } else {
                    this.gon.gnU.setImageURI(str);
                }
            }
            this.gon.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).bPH());
            if (i == 0 && f.this.gnM != 0) {
                this.gon.setPadding(f.this.gnM, 0, 0, 0);
            } else {
                this.gon.setPadding(0, 0, 0, 0);
            }
            lQ(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.gon.gnk.setVisibility(4);
                    bRj();
                } else if (t.isLoading()) {
                    this.gon.gnk.setVisibility(0);
                    bRi();
                } else {
                    this.gon.gnk.setVisibility(0);
                    this.gon.gnk.setRotation(0.0f);
                    this.gon.gnk.setImageResource(a.e.sticker_unload);
                    bRj();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.view.b
        public boolean uL(int i) {
            boolean z = i == this.position;
            if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "setCurrentPosition vHolder=" + this.position + "==" + i + " = " + z);
            }
            return lQ(z) | super.uL(i);
        }

        public boolean lQ(boolean z) {
            if (z) {
                this.gon.setSelectedBackground();
                return false;
            }
            this.gon.setUnselectedBackground();
            return false;
        }

        public void bRi() {
            if (this.gnl == null) {
                this.gnl = ObjectAnimator.ofFloat(this.gon.gnk, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
                this.gnl.setRepeatCount(-1);
                this.gnl.setDuration(1000L);
            }
            if (!this.gnl.isRunning()) {
                this.gon.gnk.setImageResource(a.e.sticker_loading);
                this.gnl.start();
            }
        }

        public void bRj() {
            if (this.gnl != null && this.gnl.isRunning()) {
                this.gnl.cancel();
            }
        }
    }
}
