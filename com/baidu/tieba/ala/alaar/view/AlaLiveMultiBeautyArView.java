package com.baidu.tieba.ala.alaar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.SeekBar;
import android.widget.TextView;
import com.baidu.live.adp.base.BdPageContext;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.ar.AlaFilterAndBeautyData;
import com.baidu.live.ar.ILiveMultiBeautyView;
import com.baidu.live.ar.d;
import com.baidu.live.ar.f;
import com.baidu.live.ar.h;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tieba.horizonallist.widget.AbsHListView;
import com.baidu.live.tieba.horizonallist.widget.HListView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.a.e;
import com.baidu.tieba.ala.alaar.view.a;
import com.baidu.tieba.ala.alaar.view.b;
/* loaded from: classes3.dex */
public class AlaLiveMultiBeautyArView extends ILiveMultiBeautyView implements View.OnClickListener {
    private BdPageContext aUs;
    private int ds120;
    private int ds20;
    private int ds28;
    private int ds3;
    private View eZA;
    private int eZB;
    private FrameLayout eZC;
    private TopTipSeekBar eZD;
    private TextView eZE;
    private TextView eZF;
    private BdAlertDialog eZG;
    private f eZH;
    private LinearLayout eZI;
    private Button eZJ;
    private Button eZK;
    private Button eZL;
    private View eZM;
    private boolean eZN;
    private com.baidu.live.ar.c eZO;
    private h eZP;
    private int eZQ;
    private TextView eZR;
    private HListView eZo;
    private a eZp;
    private int eZq;
    private int eZr;
    private HListView eZs;
    private b eZt;
    private int eZu;
    private int eZv;
    private FrameLayout eZw;
    private TopTipSeekBar eZx;
    private TextView eZy;
    private TextView eZz;
    private TextView mTitle;

    public AlaLiveMultiBeautyArView(Context context) {
        super(context);
        this.eZq = -1;
        this.eZr = -1;
        this.eZu = -1;
        this.eZv = -1;
        this.eZB = 0;
        this.eZN = true;
        this.eZO = com.baidu.live.ar.c.atc;
        this.eZQ = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eZq = -1;
        this.eZr = -1;
        this.eZu = -1;
        this.eZv = -1;
        this.eZB = 0;
        this.eZN = true;
        this.eZO = com.baidu.live.ar.c.atc;
        this.eZQ = 1;
        initViews();
    }

    public AlaLiveMultiBeautyArView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eZq = -1;
        this.eZr = -1;
        this.eZu = -1;
        this.eZv = -1;
        this.eZB = 0;
        this.eZN = true;
        this.eZO = com.baidu.live.ar.c.atc;
        this.eZQ = 1;
        initViews();
    }

    private void initViews() {
        View.inflate(getContext(), a.h.ala_live_beauty_ar_hor_layout, this);
        bqd();
        this.eZo = (HListView) findViewById(a.g.filter_list_view);
        if (this.eZo != null) {
            this.eZp = new a(this.eZo);
            this.eZp.py(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eZo.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eZo.setAdapter((ListAdapter) this.eZp);
            this.eZo.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eZo.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.1
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.eZq = i;
                AlaLiveMultiBeautyArView.this.eZr = i2;
            }
        });
        this.eZp.a(new a.InterfaceC0522a() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4
            @Override // com.baidu.tieba.ala.alaar.view.a.InterfaceC0522a
            public void b(final int i, final int[] iArr) {
                new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (AlaLiveMultiBeautyArView.this.eZr > 0) {
                            AlaLiveMultiBeautyArView.this.eZo.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.eZq, AlaLiveMultiBeautyArView.this.eZr, iArr, AlaLiveMultiBeautyArView.this.eZp.getCount(), false), 300);
                        }
                    }
                }, iArr == null ? 300 : 0);
                d dVar = AlaLiveMultiBeautyArView.this.eZp.getDatas().get(i);
                if (!AlaLiveMultiBeautyArView.this.eZO.asU.equals(e.AG(dVar.uX()))) {
                    AlaLiveMultiBeautyArView.this.AS(dVar.getName());
                }
                if (AlaLiveMultiBeautyArView.this.getContext().getString(a.i.beauty_yuantu).equals(dVar.getName())) {
                    com.baidu.live.ar.c cVar = AlaLiveMultiBeautyArView.this.eZO;
                    com.baidu.minivideo.arface.b.LQ();
                    cVar.asU = com.baidu.minivideo.arface.c.LT();
                } else {
                    AlaLiveMultiBeautyArView.this.eZO.asU = e.AG(dVar.uX());
                }
                AlaLiveMultiBeautyArView.this.eZO.asV = dVar;
                if (AlaLiveMultiBeautyArView.this.eZP != null && AlaLiveMultiBeautyArView.this.eZH.va() != null) {
                    int a = AlaLiveMultiBeautyArView.this.eZO.a(dVar, AlaLiveMultiBeautyArView.this.eZH.va().asJ);
                    int ei = AlaLiveMultiBeautyArView.this.eZO.ei(AlaLiveMultiBeautyArView.this.eZO.asU);
                    float f = (((ei * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onItemSelected threshold:" + a + ", level:" + ei + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.eZP.onFilterSelected(AlaLiveMultiBeautyArView.this.eZO.asV.getName(), AlaLiveMultiBeautyArView.this.eZO.asU, f);
                }
                AlaLiveMultiBeautyArView.this.pw(AlaLiveMultiBeautyArView.this.eZO.ei(AlaLiveMultiBeautyArView.this.eZO.asU));
            }
        });
        this.eZC = (FrameLayout) findViewById(a.g.filter_rl_progress);
        this.eZE = (TextView) findViewById(a.g.filter_progress_tv);
        this.eZD = (TopTipSeekBar) findViewById(a.g.filter_value_seekbar);
        this.eZD.setMax(100);
        this.eZD.setTipView(this.eZE);
        this.eZF = (TextView) findViewById(a.g.filter_def_thumb_tv);
        this.eZD.setDefThumb(this.eZF);
        this.eZD.setDefThumbPos(100);
        this.eZD.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.5
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.eZO.x(AlaLiveMultiBeautyArView.this.eZO.asU, i);
                if (AlaLiveMultiBeautyArView.this.eZP != null) {
                    int a = AlaLiveMultiBeautyArView.this.eZO.a(AlaLiveMultiBeautyArView.this.eZO.asV, AlaLiveMultiBeautyArView.this.eZH.va().asJ);
                    float f = (((i * 1.0f) / 100.0f) * (a * 1.0f)) / 100.0f;
                    Log.d("ArUpdate", "@.@ onProgressChanged threshold:" + a + ", progress:" + i + ", value:" + f);
                    AlaLiveMultiBeautyArView.this.eZP.onFilterSelected(AlaLiveMultiBeautyArView.this.eZO.asV.getName(), AlaLiveMultiBeautyArView.this.eZO.asU, f);
                }
                if (z) {
                    com.baidu.live.c.uN().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eZw = (FrameLayout) findViewById(a.g.rl_beauty_progress);
        this.eZy = (TextView) findViewById(a.g.progress_tv);
        this.eZz = (TextView) findViewById(a.g.def_thumb_tv);
        this.eZx = (TopTipSeekBar) findViewById(a.g.value_seekbar);
        this.eZA = findViewById(a.g.effect_diff_btn);
        this.eZs = (HListView) findViewById(a.g.beauty_list_view);
        this.eZx.setMax(100);
        this.eZx.setTipView(this.eZy);
        this.eZx.setDefThumb(this.eZz);
        if (this.eZs != null) {
            this.eZt = new b(this.eZs);
            this.eZt.py(getResources().getDimensionPixelSize(a.e.sdk_ds28));
            this.eZs.setDividerWidth(getResources().getDimensionPixelSize(a.e.sdk_ds20));
            this.eZs.setAdapter((ListAdapter) this.eZt);
            this.eZs.setSelector(getResources().getDrawable(a.f.sdk_transparent_bg));
        }
        this.eZs.setOnScrollListener(new AbsHListView.g() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.6
            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i) {
            }

            @Override // com.baidu.live.tieba.horizonallist.widget.AbsHListView.g
            public void a(AbsHListView absHListView, int i, int i2, int i3) {
                AlaLiveMultiBeautyArView.this.eZu = i;
                AlaLiveMultiBeautyArView.this.eZv = i2;
            }
        });
        this.eZt.a(new b.InterfaceC0523b() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.7
            @Override // com.baidu.tieba.ala.alaar.view.b.InterfaceC0523b
            public void b(int i, int[] iArr) {
                if (i == 0) {
                    AlaLiveMultiBeautyArView.this.bqe();
                    return;
                }
                AlaLiveMultiBeautyArView.this.eZs.smoothScrollBy(AlaLiveMultiBeautyArView.this.a(i, AlaLiveMultiBeautyArView.this.eZu, AlaLiveMultiBeautyArView.this.eZv, iArr, AlaLiveMultiBeautyArView.this.eZt.getCount(), true), 300);
                AlaLiveMultiBeautyArView.this.eZO.asW = AlaLiveMultiBeautyArView.this.eZt.fai[i].fan;
                AlaLiveMultiBeautyArView.this.eZB = AlaLiveMultiBeautyArView.this.eZt.fai[i].fao;
                AlaLiveMultiBeautyArView.this.pv(AlaLiveMultiBeautyArView.this.eZO.ej(AlaLiveMultiBeautyArView.this.eZO.asW) + AlaLiveMultiBeautyArView.this.eZB);
                AlaLiveMultiBeautyArView.this.eZx.setProcessDiff(AlaLiveMultiBeautyArView.this.eZt.fai[i].fao);
            }
        });
        this.eZx.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.8
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                AlaLiveMultiBeautyArView.this.eZO.y(AlaLiveMultiBeautyArView.this.eZO.asW, i - AlaLiveMultiBeautyArView.this.eZB);
                if (AlaLiveMultiBeautyArView.this.eZP != null) {
                    AlaLiveMultiBeautyArView.this.eZP.a((1.0f * i) / 100.0f, AlaFilterAndBeautyData.eg(AlaLiveMultiBeautyArView.this.eZO.asW));
                }
                if (z) {
                    com.baidu.live.c.uN().putBoolean("ala_beauty_changed_by_user", true);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.eZA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.9
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction() & 255) {
                    case 0:
                        if (AlaLiveMultiBeautyArView.this.eZP != null) {
                            AlaLiveMultiBeautyArView.this.eZP.vf();
                            return true;
                        }
                        return true;
                    case 1:
                    case 3:
                    case 4:
                        AlaLiveMultiBeautyArView.this.bqf();
                        return true;
                    case 2:
                    default:
                        return true;
                }
            }
        });
        this.eZL = (Button) findViewById(a.g.btn_choose_beauty_level);
        this.eZL.setOnClickListener(this);
        this.eZJ = (Button) findViewById(a.g.btn_choose_filter);
        this.eZJ.setOnClickListener(this);
        this.eZK = (Button) findViewById(a.g.btn_choose_face_shape);
        this.eZK.setOnClickListener(this);
        this.eZI = (LinearLayout) findViewById(a.g.face_beauty_level_select_layout);
        this.eZM = findViewById(a.g.ala_live_new_beauty_nav_view);
        findViewById(a.g.beauty_viewStub).setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewParent parent = AlaLiveMultiBeautyArView.this.getParent();
                if (parent != null && (parent instanceof ViewGroup)) {
                    ((ViewGroup) parent).removeView(AlaLiveMultiBeautyArView.this);
                }
                AlaLiveMultiBeautyArView.this.vc();
                if (AlaLiveMultiBeautyArView.this.eZP != null) {
                    AlaLiveMultiBeautyArView.this.eZP.vd();
                }
            }
        });
        this.eZR = (TextView) findViewById(a.g.filter_select_anim);
    }

    private void bqd() {
        this.ds120 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds120);
        this.ds28 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds28);
        this.ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);
        this.ds3 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds3);
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vc() {
        if (this.eZO != null) {
            com.baidu.live.c.uN().putString("ala_beauty_config_ar", this.eZO.toJsonString());
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setArModel(f fVar) {
        this.eZH = fVar;
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setBdPageContext(BdPageContext bdPageContext) {
        this.aUs = bdPageContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pv(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.eZx.setProgress(i, true);
        } else {
            this.eZx.setProgress(i);
        }
        this.eZx.setDefThumbPos(com.baidu.live.ar.c.atb.ej(this.eZO.asW) + this.eZB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pw(int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.eZD.setProgress(i, true);
        } else {
            this.eZD.setProgress(i);
        }
        Log.d("ArUpdate", "View -- updateFilterSeekbar--value:" + i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i, int i2, int i3, int[] iArr, int i4, boolean z) {
        int i5;
        int i6 = (i3 / 2) + i2;
        if (i >= i2 + i3) {
            i5 = (((i - i6) + 1) * this.ds120) + this.ds28;
        } else {
            i5 = ((i - i6) * this.ds120) + this.ds28 + (this.ds120 / 2);
        }
        int i7 = BdUtilHelper.getScreenSize(this.aUs.getPageActivity()).widthPixels;
        if (iArr != null) {
            int i8 = iArr[0] - ((i7 - this.ds120) / 2);
            int i9 = z ? ((i - 1) * (this.ds120 + this.ds20)) + this.ds28 + this.ds3 + this.ds20 : ((this.ds120 + this.ds20) * i) + this.ds28;
            int i10 = ((i4 - i) - 1) * (this.ds120 + this.ds20);
            if ((i7 - this.ds120) / 2 > i9) {
                return (((i7 - this.ds120) / 2) - i9) + i8;
            }
            return (i7 - this.ds120) / 2 > i10 ? i8 - (((i7 - this.ds120) / 2) - i10) : i8;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqe() {
        if (this.eZG != null) {
            this.eZG.dismiss();
            this.eZG = null;
        }
        String string = getContext().getString(a.i.ar_beauty_is_reset);
        this.eZG = new BdAlertDialog((Activity) getContext());
        this.eZG.setAutoNight(false);
        this.eZG.setMessage(string);
        this.eZG.setPositiveButton(getContext().getString(a.i.sdk_dialog_ok), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.11
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                if (AlaLiveMultiBeautyArView.this.eZP != null) {
                    AlaLiveMultiBeautyArView.this.eZP.ve();
                }
                String str = com.baidu.live.ar.c.atc.asW;
                com.baidu.live.ar.c.atc.eh(com.baidu.live.ar.c.atb.toJsonString());
                com.baidu.live.ar.c.atc.asW = str;
                AlaLiveMultiBeautyArView.this.eZO = com.baidu.live.ar.c.atc;
                AlaLiveMultiBeautyArView.this.pv(AlaLiveMultiBeautyArView.this.eZO.ej(AlaLiveMultiBeautyArView.this.eZO.asW) + AlaLiveMultiBeautyArView.this.eZB);
                AlaLiveMultiBeautyArView.this.yy();
            }
        });
        this.eZG.setNegativeButton(getContext().getString(a.i.sdk_dialog_cancel), new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog) {
                AlaLiveMultiBeautyArView.this.yy();
            }
        });
        this.eZG.setCancelable(false);
        this.eZG.setCanceledOnTouchOutside(false);
        this.eZG.setTitleShowCenter(true);
        this.eZG.setMessageShowCenter(true);
        this.eZG.isShowTitleAndMessage();
        this.eZG.create(this.aUs);
        this.eZG.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yy() {
        if (this.eZG != null) {
            this.eZG.dismiss();
            this.eZG = null;
        }
        this.eZG = null;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.eZN && this.eZJ.getWidth() != 0) {
            h(this.eZJ, false);
            this.eZN = false;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eZJ) {
            h(this.eZJ, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZJ);
            if (this.eZo != null) {
                setEffectFilterBeautyChooseBlock(this.eZo);
            }
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_filter));
            }
            this.eZQ = 0;
            this.eZw.setVisibility(8);
            this.eZC.setVisibility(0);
        } else if (view == this.eZK) {
            h(this.eZK, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZK);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_face_shape));
            }
        } else if (view == this.eZL) {
            h(this.eZL, true);
            setEffectFilterBeautyChooseBtnTextColor(this.eZL);
            setEffectFilterBeautyChooseBlock(this.eZs);
            this.eZw.setVisibility(0);
            if (this.mTitle != null) {
                this.mTitle.setText(getResources().getString(a.i.ala_live_new_beauty_beauty));
            }
            this.eZQ = 1;
            this.eZw.setVisibility(0);
            this.eZC.setVisibility(8);
        }
    }

    private void setEffectFilterBeautyChooseBlock(View view) {
        if (this.eZo != null) {
            this.eZo.setVisibility(4);
        }
        if (this.eZs != null) {
            this.eZs.setVisibility(4);
        }
        this.eZI.setVisibility(4);
        view.setVisibility(0);
    }

    private void setEffectFilterBeautyChooseBtnTextColor(Button button) {
        this.eZJ.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eZK.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        this.eZL.setTextColor(getResources().getColor(a.d.sdk_cp_cont_g));
        button.setTextColor(getResources().getColor(a.d.sdk_cp_other_b));
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setOnEffectSelectedListener(h hVar) {
        this.eZP = hVar;
    }

    private void h(View view, boolean z) {
        this.eZM.clearAnimation();
        int width = (this.eZM.getWidth() / 2) + this.eZM.getLeft();
        int width2 = (view.getWidth() / 2) + view.getLeft();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eZM.getLayoutParams();
        layoutParams.leftMargin = width2 - (this.eZM.getWidth() / 2);
        this.eZM.setLayoutParams(layoutParams);
        if (z) {
            TranslateAnimation translateAnimation = new TranslateAnimation(width - width2, 0.0f, 0.0f, 0.0f);
            translateAnimation.setDuration(200L);
            translateAnimation.setFillAfter(true);
            this.eZM.startAnimation(translateAnimation);
        }
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void setViewData() {
        com.baidu.live.ar.c.atc.eh(com.baidu.live.c.uN().getString("ala_beauty_config_ar", ""));
        if (TextUtils.isEmpty(com.baidu.live.ar.c.atc.asU) && com.baidu.minivideo.arface.b.LQ() != null) {
            com.baidu.live.ar.c cVar = com.baidu.live.ar.c.atc;
            com.baidu.minivideo.arface.b.LQ();
            cVar.asU = com.baidu.minivideo.arface.c.LT();
        }
        if (TextUtils.isEmpty(com.baidu.live.ar.e.atf)) {
            com.baidu.minivideo.arface.b.LQ();
            com.baidu.live.ar.e.ek(com.baidu.minivideo.arface.c.LT());
        }
        this.eZO = com.baidu.live.ar.c.atc;
        bqf();
        pv(this.eZO.ej(this.eZO.asW) + this.eZB);
        this.eZt.AU(this.eZO.asW);
        this.eZt.notifyDataSetChanged();
        if (this.eZH != null && this.eZH.va() != null && this.eZH.va().asJ != null) {
            this.eZp.setDatas(this.eZH.va().asJ);
        }
        if (!TextUtils.isEmpty(this.eZO.asU)) {
            this.eZp.AT(this.eZO.asU);
        }
        this.eZp.notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqf() {
        AlaFilterAndBeautyData.BeautyAdjustKey[] values;
        int i;
        if (this.eZP != null) {
            for (AlaFilterAndBeautyData.BeautyAdjustKey beautyAdjustKey : AlaFilterAndBeautyData.BeautyAdjustKey.values()) {
                if (this.eZt != null) {
                    i = 0;
                    for (int i2 = 0; i2 < this.eZt.fai.length; i2++) {
                        if (beautyAdjustKey.getJsonKey().equals(this.eZt.fai[i2].fan)) {
                            i = this.eZt.fai[i2].fao;
                        }
                    }
                } else {
                    i = 0;
                }
                this.eZP.a(((this.eZO.ej(beautyAdjustKey.getJsonKey()) + i) * 1.0f) / 100.0f, beautyAdjustKey);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void AS(String str) {
        this.eZR.setText(str);
        this.eZR.setVisibility(0);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.eZR, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.eZR, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.eZR, "alpha", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
        animatorSet.setDuration(280L);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.alaar.view.AlaLiveMultiBeautyArView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(AlaLiveMultiBeautyArView.this.eZR, "alpha", 1.0f, 0.0f);
                ofFloat4.setStartDelay(100L);
                ofFloat4.setDuration(320L);
                ofFloat4.start();
            }
        });
        animatorSet.start();
    }

    @Override // com.baidu.live.ar.ILiveMultiBeautyView
    public void vb() {
        if (this.eZt != null) {
            this.eZt.notifyDataSetChanged();
        }
        if (this.eZp != null) {
            this.eZp.notifyDataSetChanged();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
