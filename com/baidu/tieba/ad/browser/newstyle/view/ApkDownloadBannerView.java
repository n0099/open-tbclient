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
import d.a.c.e.p.l;
import d.a.n0.q.d.g.b;
/* loaded from: classes4.dex */
public class ApkDownloadBannerView extends LinearLayout implements b {

    /* renamed from: e  reason: collision with root package name */
    public int f13485e;

    /* renamed from: f  reason: collision with root package name */
    public View f13486f;

    /* renamed from: g  reason: collision with root package name */
    public BannerDownloadProgressBar f13487g;

    /* renamed from: h  reason: collision with root package name */
    public BannerDownloadStateBar f13488h;

    /* renamed from: i  reason: collision with root package name */
    public BannerDownloadStateBar f13489i;
    public int j;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f13490a;

        static {
            int[] iArr = new int[DownloadStatus.values().length];
            f13490a = iArr;
            try {
                iArr[DownloadStatus.STATUS_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13490a[DownloadStatus.STATUS_SUCCESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13490a[DownloadStatus.STATUS_INSTALL_SUCCESS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13490a[DownloadStatus.STATUS_DOWNLOADING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f13490a[DownloadStatus.STATUS_PAUSED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public ApkDownloadBannerView(Context context) {
        this(context, null);
    }

    @Override // d.a.n0.q.d.g.b
    public void a(int i2) {
        this.f13487g.setProgress(i2);
    }

    @Override // d.a.n0.q.d.g.b
    public boolean b(View view) {
        return false;
    }

    @Override // d.a.n0.q.d.g.b
    public void c(@NonNull DownloadStatus downloadStatus) {
        getActionBar().setState(f(downloadStatus));
    }

    @Override // d.a.n0.q.d.g.b
    public void d(DownloadStatus downloadStatus, int i2) {
        int i3 = a.f13490a[downloadStatus.ordinal()];
        if (i3 == 1) {
            a(0);
            this.f13487g.setText("");
        } else if (i3 == 2 || i3 == 3) {
            a(this.f13485e);
            this.f13487g.setText("");
        } else if (i3 != 4 && i3 != 5) {
            a(0);
            this.f13487g.setText("");
        } else {
            a(i2);
        }
        c(downloadStatus);
    }

    public final void e(Context context) {
        this.f13486f = LayoutInflater.from(context).inflate(R.layout.ad_apk_download_banner_view, (ViewGroup) this, true);
        setOrientation(0);
        setGravity(16);
        int e2 = l.e(getContext(), 22.0f);
        setPadding(e2, 0, e2, 0);
        this.f13487g = (BannerDownloadProgressBar) this.f13486f.findViewById(R.id.apk_download_progress);
        this.f13488h = (BannerDownloadStateBar) this.f13486f.findViewById(R.id.apk_download_state_left);
        this.f13489i = (BannerDownloadStateBar) this.f13486f.findViewById(R.id.apk_download_state_right);
        this.f13487g.setTextColor(Color.parseColor("#999999"));
    }

    public final int f(DownloadStatus downloadStatus) {
        int i2 = a.f13490a[downloadStatus.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 4) {
                    return i2 != 5 ? 0 : 2;
                }
                return 1;
            }
            return 4;
        }
        return 3;
    }

    @Override // d.a.n0.q.d.g.b
    @NonNull
    public View getRealView() {
        return this;
    }

    public void setDownloadStateBarPosition(int i2) {
        this.j = i2;
        if (i2 == 0) {
            this.f13488h.setVisibility(0);
            this.f13489i.setVisibility(8);
        } else if (i2 != 1) {
            this.f13488h.setVisibility(0);
            this.f13489i.setVisibility(8);
        } else {
            this.f13488h.setVisibility(8);
            this.f13489i.setVisibility(0);
        }
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.q.d.g.b
    public BannerDownloadStateBar getActionBar() {
        return this.f13488h.getVisibility() == 0 ? this.f13488h : this.f13489i;
    }

    public ApkDownloadBannerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f13485e = 100;
        this.j = 1;
        e(context);
        setDownloadStateBarPosition(1);
    }
}
