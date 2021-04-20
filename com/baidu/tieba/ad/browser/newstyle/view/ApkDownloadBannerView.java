package com.baidu.tieba.ad.browser.newstyle.view;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.R;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import d.b.c.e.p.l;
import d.b.i0.o.d.f.b;
/* loaded from: classes4.dex */
public class ApkDownloadBannerView extends LinearLayout implements b {

    /* renamed from: e  reason: collision with root package name */
    public int f14186e;

    /* renamed from: f  reason: collision with root package name */
    public View f14187f;

    /* renamed from: g  reason: collision with root package name */
    public BannerDownloadProgressBar f14188g;

    /* renamed from: h  reason: collision with root package name */
    public BannerDownloadStateBar f14189h;
    public BannerDownloadStateBar i;
    public int j;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14190a;

        static {
            int[] iArr = new int[DownloadStatus.values().length];
            f14190a = iArr;
            try {
                iArr[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14190a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14190a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14190a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14190a[DownloadStatus.STATUS_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ApkDownloadBannerView(Context context) {
        this(context, null);
    }

    @Override // d.b.i0.o.d.f.b
    public void a(int i) {
        this.f14188g.setProgress(i);
    }

    @Override // d.b.i0.o.d.f.b
    public boolean b(View view) {
        return false;
    }

    @Override // d.b.i0.o.d.f.b
    public void c(@NonNull DownloadStatus downloadStatus) {
        getActionBar().setState(f(downloadStatus));
    }

    @Override // d.b.i0.o.d.f.b
    public void d(DownloadStatus downloadStatus, int i) {
        int i2 = a.f14190a[downloadStatus.ordinal()];
        if (i2 == 1) {
            a(0);
            this.f14188g.setText("");
        } else if (i2 == 2 || i2 == 3) {
            a(this.f14186e);
            this.f14188g.setText("");
        } else if (i2 != 4 && i2 != 5) {
            a(0);
            this.f14188g.setText("");
        } else {
            a(i);
        }
        c(downloadStatus);
    }

    public final void e(Context context) {
        this.f14187f = LayoutInflater.from(context).inflate(R.layout.ad_apk_download_banner_view, (ViewGroup) this, true);
        setOrientation(0);
        setGravity(16);
        int e2 = l.e(getContext(), 22.0f);
        setPadding(e2, 0, e2, 0);
        this.f14188g = (BannerDownloadProgressBar) this.f14187f.findViewById(R.id.apk_download_progress);
        this.f14189h = (BannerDownloadStateBar) this.f14187f.findViewById(R.id.apk_download_state_left);
        this.i = (BannerDownloadStateBar) this.f14187f.findViewById(R.id.apk_download_state_right);
        this.f14188g.setTextColor(Color.parseColor("#999999"));
    }

    public final int f(DownloadStatus downloadStatus) {
        int i = a.f14190a[downloadStatus.ordinal()];
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    return i != 5 ? 0 : 2;
                }
                return 1;
            }
            return 4;
        }
        return 3;
    }

    @Override // d.b.i0.o.d.f.b
    @NonNull
    public View getRealView() {
        return this;
    }

    public void setDownloadStateBarPosition(int i) {
        this.j = i;
        if (i == 0) {
            this.f14189h.setVisibility(0);
            this.i.setVisibility(8);
        } else if (i != 1) {
            this.f14189h.setVisibility(0);
            this.i.setVisibility(8);
        } else {
            this.f14189h.setVisibility(8);
            this.i.setVisibility(0);
        }
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.o.d.f.b
    public BannerDownloadStateBar getActionBar() {
        return this.f14189h.getVisibility() == 0 ? this.f14189h : this.i;
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14186e = 100;
        this.j = 1;
        e(context);
        setDownloadStateBarPosition(1);
    }
}
