package com.baidu.tieba.ala.liveroom.views;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.ala.recorder.video.AlaLiveVideoConfig;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.f;
import com.baidu.live.ar.k;
import com.baidu.live.ar.l;
import com.baidu.live.ar.m;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.h.c;
/* loaded from: classes10.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext bnf;
    private boolean gtr;
    private m gtt;
    private HListView hMd;
    private com.baidu.tieba.ala.liveroom.h.c hMe;
    private LinearLayout hMf;
    private LinearLayout hMg;
    private Button hMh;
    private Button hMi;
    private Button hMj;
    private Button hMk;
    private View hMl;
    private GridView hMm;
    private f hMn;
    private SeekBar hMo;
    private SeekBar hMp;
    private SeekBar hMq;
    private SeekBar hMr;
    private SeekBar hMs;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.gtr = true;
        this.hMn = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gtr = true;
        this.hMn = new f();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.gtr = true;
        this.hMn = new f();
        initViews();
    }

    private void initViews() {
        if (getContext() instanceof Activity) {
            if (((Activity) getContext()).getApplication().getResources().getConfiguration().orientation == 1) {
                View.inflate(getContext(), a.g.ala_live_beauty_new_hor_layout, this);
            } else {
                View.inflate(getContext(), a.g.ala_live_beauty_new_ver_layout, this);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            View.inflate(getContext(), a.g.ala_live_beauty_new_hor_layout, this);
        } else {
            View.inflate(getContext(), a.g.ala_live_beauty_new_ver_layout, this);
        }
        this.hMd = (HListView) findViewById(a.f.filter_list_view);
        if (this.hMd != null) {
            this.hMe = new com.baidu.tieba.ala.liveroom.h.c(this.hMd);
            this.hMe.tq(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hMd.setDividerWidth(getResources().getDimensionPixelSize(a.d.sdk_ds34));
            this.hMd.setAdapter((ListAdapter) this.hMe);
            this.hMd.setSelector(getResources().getDrawable(a.e.sdk_transparent_bg));
        }
        this.hMm = (GridView) findViewById(a.f.filter_grid_view);
        if (this.hMm != null) {
            this.hMe = new com.baidu.tieba.ala.liveroom.h.c(this.hMm);
            this.hMm.setAdapter((ListAdapter) this.hMe);
        }
        this.hMe.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void sB(int i) {
                AlaLiveMultiBeautyView.this.hMn.mFilterName = AlaLiveMultiBeautyView.this.hMe.hwW[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.gtt != null) {
                    AlaLiveMultiBeautyView.this.gtt.onFilterSelected(AlaLiveMultiBeautyView.this.hMe.hwW[i].gtV, AlaLiveMultiBeautyView.this.hMe.hwW[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.f.beauty_title_text);
        this.hMj = (Button) findViewById(a.f.btn_choose_beauty_level);
        this.hMj.setOnClickListener(this);
        this.hMk.setOnClickListener(this);
        this.hMh = (Button) findViewById(a.f.btn_choose_filter);
        this.hMh.setOnClickListener(this);
        this.hMi = (Button) findViewById(a.f.btn_choose_face_shape);
        this.hMi.setOnClickListener(this);
        this.hMf = (LinearLayout) findViewById(a.f.live_face_shape);
        this.hMg = (LinearLayout) findViewById(a.f.face_beauty_level_select_layout);
        this.hMo = (SeekBar) findViewById(a.f.face_level_white_seekbar);
        this.hMo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hMn.aBb = i;
                if (AlaLiveMultiBeautyView.this.gtt != null) {
                    AlaLiveMultiBeautyView.this.gtt.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hMp = (SeekBar) findViewById(a.f.face_level_red_seekbar);
        this.hMp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hMn.aBc = i;
                if (AlaLiveMultiBeautyView.this.gtt != null) {
                    AlaLiveMultiBeautyView.this.gtt.w(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hMq = (SeekBar) findViewById(a.f.face_level_skin_seekbar);
        this.hMq.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hMn.aBd = i;
                if (AlaLiveMultiBeautyView.this.gtt != null) {
                    AlaLiveMultiBeautyView.this.gtt.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hMr = (SeekBar) findViewById(a.f.face_shape_thin_level_seekbar);
        this.hMr.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hMn.aBf = i;
                if (AlaLiveMultiBeautyView.this.gtt != null) {
                    AlaLiveMultiBeautyView.this.gtt.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hMs = (SeekBar) findViewById(a.f.face_shape_eye_level_seekbar);
        this.hMs.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.hMn.aBe = i;
                if (AlaLiveMultiBeautyView.this.gtt != null) {
                    AlaLiveMultiBeautyView.this.gtt.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hMl = findViewById(a.f.ala_live_new_beauty_nav_view);
        findViewById(a.f.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.yW();
                if (AlaLiveMultiBeautyView.this.gtt != null) {
                    AlaLiveMultiBeautyView.this.gtt.onClosed();
                    return true;
                }
                return true;
            }
        });
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void yV() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void yW() {
        if (this.hMn != null) {
            com.baidu.live.d.xf().putString("ala_beauty_5.4_config_str", this.hMn.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(k kVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bnf = bdPageContext;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setAlaLiveShowData(x xVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void b(short s) {
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.gtr && this.hMh.getWidth() != 0) {
            i(this.hMh, false);
            this.gtr = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hMh) {
            i(this.hMh, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hMh);
            if (this.hMd != null) {
                setEffectFilterBeautyChooseBlock(this.hMd);
            } else if (this.hMm != null) {
                setEffectFilterBeautyChooseBlock(this.hMm);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_filter));
            }
        } else if (view == this.hMi) {
            i(this.hMi, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hMi);
            setEffectFilterBeautyChooseBlock(this.hMf);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.hMj) {
            i(this.hMj, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hMj);
            setEffectFilterBeautyChooseBlock(this.hMg);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        } else if (view == this.hMk) {
            i(this.hMk, true);
            setEffectFilterBeautyChooseBtnTextColor(this.hMk);
            setEffectFilterBeautyChooseBlock(this.hMg);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.h.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.hMd != null) {
            this.hMd.setVisibility(4);
        }
        if (this.hMm != null) {
            this.hMm.setVisibility(4);
        }
        this.hMf.setVisibility(4);
        this.hMg.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.hMh.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hMi.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        this.hMj.setTextColor(getResources().getColor(a.c.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.c.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(m mVar) {
        this.gtt = mVar;
    }

    private void i(View view, boolean z) {
        this.hMl.clearAnimation();
        int width = (this.hMl.getWidth() / 2) + this.hMl.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hMl.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.hMl.getWidth() / 2);
        this.hMl.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.hMl.startAnimation(translateAnimation);
        }
    }

    public void setViewData(l lVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (lVar != null && alaLiveVideoConfig != null) {
            f fVar = (f) lVar;
            this.hMo.setProgress(fVar.aBb);
            this.hMp.setProgress(fVar.aBc);
            this.hMq.setProgress(fVar.aBd);
            this.hMr.setProgress(fVar.aBf);
            this.hMs.setProgress(fVar.aBe);
            this.hMe.Hc(fVar.mFilterName);
            this.hMe.notifyDataSetChanged();
            this.hMn = fVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.hMi.setVisibility(0);
            } else {
                this.hMi.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
