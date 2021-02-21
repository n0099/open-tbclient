package com.baidu.tieba.ext.bdplayer.floating;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
/* loaded from: classes11.dex */
public class LiveFloatOperateView extends FrameLayout implements View.OnClickListener {
    private a iSs;
    private ImageView iSt;

    /* loaded from: classes11.dex */
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
        this.iSt = (ImageView) findViewById(a.f.scale_btn);
        findViewById(a.f.close_btn).setOnClickListener(this);
        this.iSt.setOnClickListener(this);
    }

    public void setScaleMode(boolean z) {
        if (z) {
            this.iSt.setImageResource(a.e.ala_float_scale_small);
        } else {
            this.iSt.setImageResource(a.e.ala_float_scale_large);
        }
    }

    public void setOnViewOperatorListener(a aVar) {
        this.iSs = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.close_btn) {
            if (this.iSs != null) {
                this.iSs.onCloseClicked();
            }
        } else if (id == a.f.scale_btn && this.iSs != null) {
            this.iSs.a(this);
        }
    }
}
