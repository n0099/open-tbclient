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
    private int gnK;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gnK = 0;
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
        this.gnK = i;
    }

    /* loaded from: classes4.dex */
    public class a extends b<T> {
        private ObjectAnimator gnj;
        private BeautyItemView gol;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.gol = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.gol.gnS.getHierarchy();
            if (hierarchy == null) {
                this.gol.gnS.setHierarchy(new com.facebook.drawee.generic.b(this.gol.getResources()).Ql(300).Qm(a.e.filter_beauty_item_bg).esf());
                return;
            }
            hierarchy.Qk(a.e.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void j(int i, T t) {
            String str;
            c.a bPI = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bPI();
            if (bPI == null) {
                str = null;
            } else {
                str = bPI.bPT();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.gol.gnS.setImageURI("file://" + str);
                } else {
                    this.gol.gnS.setImageURI(str);
                }
            }
            this.gol.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).bPG());
            if (i == 0 && f.this.gnK != 0) {
                this.gol.setPadding(f.this.gnK, 0, 0, 0);
            } else {
                this.gol.setPadding(0, 0, 0, 0);
            }
            lQ(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.gol.gni.setVisibility(4);
                    bRi();
                } else if (t.isLoading()) {
                    this.gol.gni.setVisibility(0);
                    bRh();
                } else {
                    this.gol.gni.setVisibility(0);
                    this.gol.gni.setRotation(0.0f);
                    this.gol.gni.setImageResource(a.e.sticker_unload);
                    bRi();
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
                this.gol.setSelectedBackground();
                return false;
            }
            this.gol.setUnselectedBackground();
            return false;
        }

        public void bRh() {
            if (this.gnj == null) {
                this.gnj = ObjectAnimator.ofFloat(this.gol.gni, MapBundleKey.MapObjKey.OBJ_SS_ARROW_ROTATION, 0.0f, 359.0f);
                this.gnj.setRepeatCount(-1);
                this.gnj.setDuration(1000L);
            }
            if (!this.gnj.isRunning()) {
                this.gol.gni.setImageResource(a.e.sticker_loading);
                this.gnj.start();
            }
        }

        public void bRi() {
            if (this.gnj != null && this.gnj.isRunning()) {
                this.gnj.cancel();
            }
        }
    }
}
