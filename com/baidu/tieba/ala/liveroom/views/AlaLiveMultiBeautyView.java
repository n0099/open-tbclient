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
import com.baidu.live.ar.h;
import com.baidu.live.ar.i;
import com.baidu.live.ar.j;
import com.baidu.live.sdk.a;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.tieba.ala.liveroom.h.c;
/* loaded from: classes7.dex */
public class AlaLiveMultiBeautyView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext bdq;
    private j fBB;
    private LinearLayout fBr;
    private Button fBv;
    private Button fBw;
    private Button fBx;
    private View fBy;
    private boolean fBz;
    private com.baidu.tieba.ala.liveroom.data.d gLA;
    private SeekBar gLB;
    private SeekBar gLC;
    private SeekBar gLD;
    private SeekBar gLE;
    private SeekBar gLF;
    private HListView gLw;
    private com.baidu.tieba.ala.liveroom.h.c gLx;
    private LinearLayout gLy;
    private GridView gLz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fBz = true;
        this.gLA = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBz = true;
        this.gLA = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBz = true;
        this.gLA = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    private void initViews() {
        if (getContext() instanceof Activity) {
            if (((Activity) getContext()).getApplication().getResources().getConfiguration().orientation == 1) {
                View.inflate(getContext(), a.h.ala_live_beauty_new_hor_layout, this);
            } else {
                View.inflate(getContext(), a.h.ala_live_beauty_new_ver_layout, this);
            }
        } else if (getResources().getConfiguration().orientation == 1) {
            View.inflate(getContext(), a.h.ala_live_beauty_new_hor_layout, this);
        } else {
            View.inflate(getContext(), a.h.ala_live_beauty_new_ver_layout, this);
        }
        this.gLw = (HListView) findViewById(a.g.filter_list_view);
        if (this.gLw != null) {
            this.gLx = new com.baidu.tieba.ala.liveroom.h.c(this.gLw);
            this.gLx.sx(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gLw.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gLw.setAdapter((ListAdapter) this.gLx);
            this.gLw.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.gLz = (GridView) findViewById(a.g.filter_grid_view);
        if (this.gLz != null) {
            this.gLx = new com.baidu.tieba.ala.liveroom.h.c(this.gLz);
            this.gLz.setAdapter((ListAdapter) this.gLx);
        }
        this.gLx.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.gLA.mFilterName = AlaLiveMultiBeautyView.this.gLx.gwV[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fBB != null) {
                    AlaLiveMultiBeautyView.this.fBB.onFilterSelected(AlaLiveMultiBeautyView.this.gLx.gwV[i].mShowName, AlaLiveMultiBeautyView.this.gLx.gwV[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fBx = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fBx.setOnClickListener(this);
        this.fBv = (Button) findViewById(a.g.btn_choose_filter);
        this.fBv.setOnClickListener(this);
        this.fBw = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fBw.setOnClickListener(this);
        this.gLy = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fBr = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.gLB = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.gLB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLA.gxt = i;
                if (AlaLiveMultiBeautyView.this.fBB != null) {
                    AlaLiveMultiBeautyView.this.fBB.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gLC = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.gLC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLA.gxu = i;
                if (AlaLiveMultiBeautyView.this.fBB != null) {
                    AlaLiveMultiBeautyView.this.fBB.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gLD = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.gLD.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLA.gxv = i;
                if (AlaLiveMultiBeautyView.this.fBB != null) {
                    AlaLiveMultiBeautyView.this.fBB.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gLE = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.gLE.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLA.gxx = i;
                if (AlaLiveMultiBeautyView.this.fBB != null) {
                    AlaLiveMultiBeautyView.this.fBB.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gLF = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.gLF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLA.gxw = i;
                if (AlaLiveMultiBeautyView.this.fBB != null) {
                    AlaLiveMultiBeautyView.this.fBB.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fBy = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.AV();
                if (AlaLiveMultiBeautyView.this.fBB != null) {
                    AlaLiveMultiBeautyView.this.fBB.AW();
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
    public void AU() {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void AV() {
        if (this.gLA != null) {
            com.baidu.live.c.AD().putString("ala_beauty_5.4_config_str", this.gLA.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bdq = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fBz && this.fBv.getWidth() != 0) {
            g(this.fBv, false);
            this.fBz = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fBv) {
            g(this.fBv, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBv);
            if (this.gLw != null) {
                setEffectFilterBeautyChooseBlock(this.gLw);
            } else if (this.gLz != null) {
                setEffectFilterBeautyChooseBlock(this.gLz);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fBw) {
            g(this.fBw, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBw);
            setEffectFilterBeautyChooseBlock(this.gLy);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fBx) {
            g(this.fBx, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBx);
            setEffectFilterBeautyChooseBlock(this.fBr);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.gLw != null) {
            this.gLw.setVisibility(4);
        }
        if (this.gLz != null) {
            this.gLz.setVisibility(4);
        }
        this.gLy.setVisibility(4);
        this.fBr.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fBv.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fBw.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fBx.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fBB = jVar;
    }

    private void g(View view, boolean z) {
        this.fBy.clearAnimation();
        int width = (this.fBy.getWidth() / 2) + this.fBy.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBy.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fBy.getWidth() / 2);
        this.fBy.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fBy.startAnimation(translateAnimation);
        }
    }

    public void setViewData(i iVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (iVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) iVar;
            this.gLB.setProgress(dVar.gxt);
            this.gLC.setProgress(dVar.gxu);
            this.gLD.setProgress(dVar.gxv);
            this.gLE.setProgress(dVar.gxx);
            this.gLF.setProgress(dVar.gxw);
            this.gLx.Es(dVar.mFilterName);
            this.gLx.notifyDataSetChanged();
            this.gLA = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fBw.setVisibility(0);
            } else {
                this.fBw.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
