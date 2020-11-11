package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.live.sdk.a;
/* loaded from: classes4.dex */
public class LiveFloatOperateView extends FrameLayout implements View.OnClickListener {
    private a itk;
    private ImageView itl;

    /* loaded from: classes4.dex */
    public interface a {
        void a(LiveFloatOperateView liveFloatOperateView);

        void onCloseClicked();
    }

    public LiveFloatOperateView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public LiveFloatOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public LiveFloatOperateView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(a.g.ala_live_floating_operate_layout, (ViewGroup) this, true);
        this.itl = (ImageView) findViewById(a.f.scale_btn);
        findViewById(a.f.close_btn).setOnClickListener(this);
        this.itl.setOnClickListener(this);
    }

    public void setScaleMode(boolean z) {
        if (z) {
            this.itl.setImageResource(a.e.ala_float_scale_small);
        } else {
            this.itl.setImageResource(a.e.ala_float_scale_large);
        }
    }

    public void setOnViewOperatorListener(a aVar) {
        this.itk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.close_btn) {
            if (this.itk != null) {
                this.itk.onCloseClicked();
            }
        } else if (id == a.f.scale_btn && this.itk != null) {
            this.itk.a(this);
        }
    }
}
