package com.baidu.tieba.b.d;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class d extends LinearLayout {
    private boolean btR;
    private List<Runnable> btS;
    private ArrayList<h> btT;
    private a btU;
    private Handler handler;
    private Context mContext;

    public d(Context context) {
        super(context);
        this.btR = false;
        this.handler = new Handler();
        this.btS = new ArrayList();
        this.btT = new ArrayList<>();
        this.mContext = null;
        this.mContext = context;
    }

    public void setShadeViewContainer(a aVar) {
        this.btU = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(h hVar, boolean z) {
        if (hVar != null) {
            if (z) {
                hVar.setVisibility(0);
            } else {
                hVar.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i == 8 && !ha(1)) {
            SM();
        }
        super.setVisibility(i);
    }

    public void setWriteViewList(ArrayList<h> arrayList) {
        boolean z;
        if (!x.r(arrayList)) {
            if (arrayList.get(0) != x.c(this.btT, 0) || getChildCount() <= 1) {
                z = true;
            } else {
                removeViews(0, getChildCount() - 1);
                z = false;
            }
            this.btT = arrayList;
            int size = this.btT.size();
            if (this.btU != null) {
                this.btU.setShadeCount(size);
            }
            for (int i = 0; i < size; i++) {
                h hVar = this.btT.get(i);
                if (hVar != null) {
                    if (i != 0) {
                        hVar.setRotateRadius((-1.5f) - i);
                        hVar.setWriteEndCallBack(new e(this, hVar, i));
                        a(hVar, false);
                        hVar.setClickable(false);
                    } else {
                        hVar.setRotateRadius(0.0f);
                        a(hVar, true);
                        if (this.btU != null) {
                            this.btU.k(0, true);
                        }
                    }
                    if (i != 0 || z) {
                        addView(hVar, 0);
                    }
                }
            }
        }
    }

    public void SI() {
        for (Runnable runnable : this.btS) {
            if (runnable != null) {
                this.handler.removeCallbacks(runnable);
            }
        }
    }

    public void onPause() {
        if (this.btT != null) {
            Iterator<h> it = this.btT.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onPause();
                }
            }
        }
    }

    public void onResume() {
        if (this.btT != null) {
            Iterator<h> it = this.btT.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.onResume();
                }
            }
        }
    }

    public void SJ() {
        this.btR = false;
        SI();
        int size = this.btT.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.btT.get(i);
            if (hVar != null) {
                f fVar = new f(this, i, hVar);
                this.handler.postDelayed(fVar, i * 110);
                this.btS.add(fVar);
            }
        }
    }

    public void SK() {
        if (ha(3)) {
            this.btR = false;
            SI();
            int size = this.btT.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.btT.get(i);
                if (hVar != null) {
                    g gVar = new g(this, i, hVar);
                    this.handler.postDelayed(gVar, ((size - i) - 1) * 110);
                    this.btS.add(gVar);
                }
            }
        }
    }

    public boolean ha(int i) {
        Iterator<h> it = this.btT.iterator();
        boolean z = true;
        while (it.hasNext()) {
            h next = it.next();
            if (next != null) {
                boolean z2 = next.ha(i) && z;
                if (!z2) {
                    return z2;
                }
                z = z2;
            }
        }
        return z;
    }

    public void setItemOnclickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null && this.btT != null) {
            Iterator<h> it = this.btT.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.setOnClickListener(onClickListener);
                }
            }
        }
    }

    public void SL() {
        if (this.btT != null) {
            Iterator<h> it = this.btT.iterator();
            while (it.hasNext()) {
                h next = it.next();
                if (next != null) {
                    next.SL();
                }
            }
        }
    }

    public void SM() {
        if (this.btT != null) {
            SI();
            int size = this.btT.size();
            for (int i = 0; i < size; i++) {
                h hVar = this.btT.get(i);
                if (hVar != null) {
                    if (this.btU != null) {
                        if (i == 0) {
                            this.btU.k(i, true);
                        } else {
                            this.btU.k(i, false);
                            hVar.setClickable(false);
                        }
                    }
                    hVar.vK();
                }
            }
            this.btR = false;
        }
    }

    public void setIsNeedIgnoreParentTouch(boolean z) {
        this.btR = z;
    }

    public boolean SN() {
        return this.btR;
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout {
        ArrayList<TbImageView> btY;
        private int mSkinType;

        public a(Context context) {
            super(context);
            this.btY = new ArrayList<>();
            this.mSkinType = 3;
            SO();
        }

        public void SO() {
            setOrientation(1);
        }

        public void setShadeCount(int i) {
            if (i <= 0) {
                this.btY.clear();
                removeAllViews();
                return;
            }
            int size = i - this.btY.size();
            if (size > 0) {
                while (true) {
                    int i2 = size - 1;
                    if (size > 0) {
                        TbImageView bh = bh(getContext());
                        bh.setVisibility(8);
                        addView(bh, 0);
                        this.btY.add(bh);
                        size = i2;
                    } else {
                        return;
                    }
                }
            } else {
                while (true) {
                    int i3 = size + 1;
                    if (size < 0) {
                        if (this.btY.size() > 0) {
                            removeView(this.btY.get(0));
                            this.btY.remove(0);
                        }
                        size = i3;
                    } else {
                        return;
                    }
                }
            }
        }

        private TbImageView bh(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            int g = k.g(context, w.f.ds124);
            tbImageView.setLayoutParams(new LinearLayout.LayoutParams(g, g));
            tbImageView.setImageResource(w.g.write_shade);
            return tbImageView;
        }

        public void onChangeSkinType(int i) {
        }

        public void k(int i, boolean z) {
            ImageView imageView = (ImageView) x.c(this.btY, i);
            if (imageView != null) {
                if (z) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
            }
        }
    }
}
