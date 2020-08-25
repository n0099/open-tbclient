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
    private BdPageContext bdo;
    private LinearLayout fBn;
    private Button fBr;
    private Button fBs;
    private Button fBt;
    private View fBu;
    private boolean fBv;
    private j fBx;
    private SeekBar gLA;
    private SeekBar gLB;
    private HListView gLs;
    private com.baidu.tieba.ala.liveroom.h.c gLt;
    private LinearLayout gLu;
    private GridView gLv;
    private com.baidu.tieba.ala.liveroom.data.d gLw;
    private SeekBar gLx;
    private SeekBar gLy;
    private SeekBar gLz;
    private TextView mTitle;

    public AlaLiveMultiBeautyView(Context context) {
        super(context);
        this.fBv = true;
        this.gLw = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fBv = true;
        this.gLw = new com.baidu.tieba.ala.liveroom.data.d();
        initViews();
    }

    public AlaLiveMultiBeautyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.fBv = true;
        this.gLw = new com.baidu.tieba.ala.liveroom.data.d();
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
        this.gLs = (HListView) findViewById(a.g.filter_list_view);
        if (this.gLs != null) {
            this.gLt = new com.baidu.tieba.ala.liveroom.h.c(this.gLs);
            this.gLt.sx(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gLs.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds34));
            this.gLs.setAdapter((ListAdapter) this.gLt);
            this.gLs.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.gLv = (GridView) findViewById(a.g.filter_grid_view);
        if (this.gLv != null) {
            this.gLt = new com.baidu.tieba.ala.liveroom.h.c(this.gLv);
            this.gLv.setAdapter((ListAdapter) this.gLt);
        }
        this.gLt.a(new c.b() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.1
            @Override // com.baidu.tieba.ala.liveroom.h.c.b
            public void onItemSelected(int i) {
                AlaLiveMultiBeautyView.this.gLw.mFilterName = AlaLiveMultiBeautyView.this.gLt.gwR[i].mFilterName;
                if (AlaLiveMultiBeautyView.this.fBx != null) {
                    AlaLiveMultiBeautyView.this.fBx.onFilterSelected(AlaLiveMultiBeautyView.this.gLt.gwR[i].mShowName, AlaLiveMultiBeautyView.this.gLt.gwR[i].mFilterName, 0.0f);
                }
            }
        });
        this.mTitle = (TextView) findViewById(a.g.beauty_title_text);
        this.fBt = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.fBt.setOnClickListener(this);
        this.fBr = (Button) findViewById(a.g.btn_choose_filter);
        this.fBr.setOnClickListener(this);
        this.fBs = (Button) findViewById(a.g.btn_choose_face_shape);
        this.fBs.setOnClickListener(this);
        this.gLu = (LinearLayout) findViewById(a.g.live_face_shape);
        this.fBn = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.gLx = (SeekBar) findViewById(a.g.face_level_white_seekbar);
        this.gLx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLw.gxp = i;
                if (AlaLiveMultiBeautyView.this.fBx != null) {
                    AlaLiveMultiBeautyView.this.fBx.s(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gLy = (SeekBar) findViewById(a.g.face_level_red_seekbar);
        this.gLy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLw.gxq = i;
                if (AlaLiveMultiBeautyView.this.fBx != null) {
                    AlaLiveMultiBeautyView.this.fBx.v(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gLz = (SeekBar) findViewById(a.g.face_level_skin_seekbar);
        this.gLz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLw.gxr = i;
                if (AlaLiveMultiBeautyView.this.fBx != null) {
                    AlaLiveMultiBeautyView.this.fBx.onBlurLevelSelected(i);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gLA = (SeekBar) findViewById(a.g.face_shape_thin_level_seekbar);
        this.gLA.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLw.gxt = i;
                if (AlaLiveMultiBeautyView.this.fBx != null) {
                    AlaLiveMultiBeautyView.this.fBx.t(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.gLB = (SeekBar) findViewById(a.g.face_shape_eye_level_seekbar);
        this.gLB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyView.this.gLw.gxs = i;
                if (AlaLiveMultiBeautyView.this.fBx != null) {
                    AlaLiveMultiBeautyView.this.fBx.u(i, 100);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.fBu = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.liveroom.views.AlaLiveMultiBeautyView.7
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ViewParent parent = AlaLiveMultiBeautyView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyView.this);
                }
                AlaLiveMultiBeautyView.this.AV();
                if (AlaLiveMultiBeautyView.this.fBx != null) {
                    AlaLiveMultiBeautyView.this.fBx.AW();
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
        if (this.gLw != null) {
            com.baidu.live.c.AD().putString("ala_beauty_5.4_config_str", this.gLw.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(h hVar) {
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.bdo = bdPageContext;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.fBv && this.fBr.getWidth() != 0) {
            g(this.fBr, false);
            this.fBv = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fBr) {
            g(this.fBr, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBr);
            if (this.gLs != null) {
                setEffectFilterBeautyChooseBlock(this.gLs);
            } else if (this.gLv != null) {
                setEffectFilterBeautyChooseBlock(this.gLv);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
        } else if (view == this.fBs) {
            g(this.fBs, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBs);
            setEffectFilterBeautyChooseBlock(this.gLu);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.fBt) {
            g(this.fBt, true);
            setEffectFilterBeautyChooseBtnTextColor(this.fBt);
            setEffectFilterBeautyChooseBlock(this.fBn);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.gLs != null) {
            this.gLs.setVisibility(4);
        }
        if (this.gLv != null) {
            this.gLv.setVisibility(4);
        }
        this.gLu.setVisibility(4);
        this.fBn.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.fBr.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fBs.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.fBt.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(j jVar) {
        this.fBx = jVar;
    }

    private void g(View view, boolean z) {
        this.fBu.clearAnimation();
        int width = (this.fBu.getWidth() / 2) + this.fBu.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fBu.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.fBu.getWidth() / 2);
        this.fBu.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.fBu.startAnimation(translateAnimation);
        }
    }

    public void setViewData(i iVar, AlaLiveVideoConfig alaLiveVideoConfig) {
        if (iVar != null && alaLiveVideoConfig != null) {
            com.baidu.tieba.ala.liveroom.data.d dVar = (com.baidu.tieba.ala.liveroom.data.d) iVar;
            this.gLx.setProgress(dVar.gxp);
            this.gLy.setProgress(dVar.gxq);
            this.gLz.setProgress(dVar.gxr);
            this.gLA.setProgress(dVar.gxt);
            this.gLB.setProgress(dVar.gxs);
            this.gLt.Er(dVar.mFilterName);
            this.gLt.notifyDataSetChanged();
            this.gLw = dVar;
            if (alaLiveVideoConfig.isSupportFaceStyle()) {
                this.fBs.setVisibility(0);
            } else {
                this.fBs.setVisibility(8);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
