package com.baidu.tbadk.coreExtra.view;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public final class ah extends RelativeLayout {
    protected ProgressBar a;
    protected com.baidu.tbadk.widget.a b;
    protected Context c;
    private aj d;
    private ai e;
    private boolean f;

    public final void setHeadImage(boolean z) {
        if (this.b != null) {
            this.b.setIsHeadImage(z);
        }
    }

    public final void setCallback(ai aiVar) {
        this.e = aiVar;
    }

    public ah(Context context) {
        super(context);
        this.a = null;
        this.b = null;
        this.d = null;
        this.c = null;
        this.e = null;
        this.f = false;
        this.c = context;
        this.b = new com.baidu.tbadk.widget.a(this.c);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.b);
        this.a = new ProgressBar(this.c, null, 16843399);
        this.a.setIndeterminateDrawable(this.c.getResources().getDrawable(com.baidu.tbadk.i.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.a.setLayoutParams(layoutParams);
        this.a.setIndeterminate(true);
        addView(this.a);
    }

    public final com.baidu.tbadk.widget.a getImageView() {
        return this.b;
    }

    public final void setGifSetListener(com.baidu.tbadk.widget.e eVar) {
        this.b.setGifSetListener(eVar);
    }

    public final void setImageOnClickListener(View.OnClickListener onClickListener) {
        this.b.setImageOnClickListener(onClickListener);
    }

    public final void setImageOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.b.setImageOnLongClickListener(onLongClickListener);
    }

    public final void setOnSizeChangedListener(com.baidu.tbadk.widget.f fVar) {
        this.b.setOnSizeChangedListener(fVar);
    }

    public final void a(String str, boolean z) {
        this.b.setTag(str);
        UtilHelper.NetworkStateInfo d = UtilHelper.d(getContext());
        if (d == UtilHelper.NetworkStateInfo.WIFI || d == UtilHelper.NetworkStateInfo.ThreeG) {
            if (this.d != null) {
                this.d.cancel();
            }
            if (str != null) {
                this.d = new aj(this, str, z);
                this.d.execute(new String[0]);
            }
        }
    }

    public final void setGifMaxUseableMem(int i) {
        this.b.setGifMaxUseableMem(i);
    }

    private void d() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }

    public final void a() {
        d();
        if (this.b != null) {
            this.b.i();
        }
        this.a.setVisibility(8);
    }

    public final void b() {
        d();
        if (this.b != null) {
            this.b.j();
        }
        this.a.setVisibility(8);
    }

    public final void c() {
        if (this.b != null && this.b.getImageType() == 1) {
            this.b.f();
        }
    }

    public final void a(boolean z) {
        String str;
        if (this.b != null && (str = (String) this.b.getTag()) != null && this.b != null && this.d == null) {
            if (this.b.getImageType() == 1) {
                if (this.b.getGifCache() == null) {
                    this.d = new aj(this, str, z);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageType() == 2) {
                if (UtilHelper.d(getContext()) != UtilHelper.NetworkStateInfo.UNAVAIL) {
                    this.d = new aj(this, str, z);
                    this.d.execute(new String[0]);
                }
            } else if (this.b.getImageBitmap() == null) {
                this.d = new aj(this, str, z);
                this.d.execute(new String[0]);
            }
        }
    }

    public final int getImageType() {
        if (this.b != null) {
            return this.b.getImageType();
        }
        return 0;
    }

    public final void setIsCdn(boolean z) {
        this.f = z;
    }
}
