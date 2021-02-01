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
    private int gwm;
    private Context mContext;

    public f(Context context) {
        super(context, null);
        this.gwm = 0;
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
        this.gwm = i;
    }

    /* loaded from: classes11.dex */
    public class a extends b<T> {
        private ObjectAnimator gvL;
        private BeautyItemView gwN;

        public a(View view, b.a aVar) {
            super(view, aVar);
            this.gwN = (BeautyItemView) view;
            com.facebook.drawee.generic.a hierarchy = this.gwN.gwu.getHierarchy();
            if (hierarchy == null) {
                this.gwN.gwu.setHierarchy(new com.facebook.drawee.generic.b(this.gwN.getResources()).Pn(300).Po(a.e.filter_beauty_item_bg).euQ());
                return;
            }
            hierarchy.Pm(a.e.filter_beauty_item_bg);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.ala.alaar.view.b
        /* renamed from: a */
        public void j(int i, T t) {
            String str;
            c.a bOW = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).bOW();
            if (bOW == null) {
                str = null;
            } else {
                str = bOW.bPh();
            }
            if (TextUtils.isEmpty(str)) {
                str = ((com.baidu.tieba.ala.alaar.makeup.c) this.item).getIcon();
            }
            if (!TextUtils.isEmpty(str) && !"null".equals(str)) {
                if (str.charAt(0) == File.separatorChar) {
                    this.gwN.gwu.setImageURI("file://" + str);
                } else {
                    this.gwN.gwu.setImageURI(str);
                }
            }
            this.gwN.setItemText(((com.baidu.tieba.ala.alaar.makeup.c) this.item).bOU());
            if (i == 0 && f.this.gwm != 0) {
                this.gwN.setPadding(f.this.gwm, 0, 0, 0);
            } else {
                this.gwN.setPadding(0, 0, 0, 0);
            }
            mn(false);
            b(t);
        }

        private void b(T t) {
            if (t == this.item) {
                if (t.isLoaded()) {
                    this.gwN.gvK.setVisibility(4);
                    bQu();
                } else if (t.isLoading()) {
                    this.gwN.gvK.setVisibility(0);
                    bQt();
                } else {
                    this.gwN.gvK.setVisibility(0);
                    this.gwN.gvK.setRotation(0.0f);
                    this.gwN.gvK.setImageResource(a.e.sticker_unload);
                    bQu();
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
                this.gwN.setSelectedBackground();
                return false;
            }
            this.gwN.setUnselectedBackground();
            return false;
        }

        public void bQt() {
            if (this.gvL == null) {
                this.gvL = ObjectAnimator.ofFloat(this.gwN.gvK, "rotation", 0.0f, 359.0f);
                this.gvL.setRepeatCount(-1);
                this.gvL.setDuration(1000L);
            }
            if (!this.gvL.isRunning()) {
                this.gwN.gvK.setImageResource(a.e.sticker_loading);
                this.gvL.start();
            }
        }

        public void bQu() {
            if (this.gvL != null && this.gvL.isRunning()) {
                this.gvL.cancel();
            }
        }
    }
}
