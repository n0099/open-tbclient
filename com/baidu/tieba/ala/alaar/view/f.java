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
    private int gyj;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gyj = 0;
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
        this.gyj = i;
    }

    /* loaded from: classes10.dex */
    public class a extends b<T> {
        private ObjectAnimator gxI;
        private BeautyItemView gyK;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.gyK = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.gyK.gyr.getHierarchy();
            if (hierarchy == null) {
                this.gyK.gyr.setHierarchy(new com.facebook.drawee.generic.b(this.gyK.getResources()).Ps(300).Pt(a.e.filter_beauty_item_bg).evh());
                return;
            }
            hierarchy.Pr(a.e.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void j(int i, T t) {
            String str;
            c.a bPj = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bPj();
            if (bPj == null) {
                str = null;
            } else {
                str = bPj.bPu();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.gyK.gyr.setImageURI("file://" + str);
                } else {
                    this.gyK.gyr.setImageURI(str);
                }
            }
            this.gyK.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).bPh());
            if (i == 0 && f.this.gyj != 0) {
                this.gyK.setPadding(f.this.gyj, 0, 0, 0);
            } else {
                this.gyK.setPadding(0, 0, 0, 0);
            }
            mn(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.gyK.gxH.setVisibility(4);
                    bQH();
                } else if (t.isLoading()) {
                    this.gyK.gxH.setVisibility(0);
                    bQG();
                } else {
                    this.gyK.gxH.setVisibility(0);
                    this.gyK.gxH.setRotation(0.0f);
                    this.gyK.gxH.setImageResource(a.e.sticker_unload);
                    bQH();
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.view.b
        public boolean tz(int i) {
            boolean z = i == this.position;
            if (com.baidu.tieba.ala.alaar.makeup.h.isDebug()) {
                com.baidu.tieba.ala.alaar.makeup.h.d("MK_VIEW", "setCurrentPosition vHolder=" + this.position + "==" + i + " = " + z);
            }
            return mn(z) | super.tz(i);
        }

        public boolean mn(boolean z) {
            if (z) {
                this.gyK.setSelectedBackground();
                return false;
            }
            this.gyK.setUnselectedBackground();
            return false;
        }

        public void bQG() {
            if (this.gxI == null) {
                this.gxI = ObjectAnimator.ofFloat(this.gyK.gxH, "rotation", 0.0f, 359.0f);
                this.gxI.setRepeatCount(-1);
                this.gxI.setDuration(1000L);
            }
            if (!this.gxI.isRunning()) {
                this.gyK.gxH.setImageResource(a.e.sticker_loading);
                this.gxI.start();
            }
        }

        public void bQH() {
            if (this.gxI != null && this.gxI.isRunning()) {
                this.gxI.cancel();
            }
        }
    }
}
