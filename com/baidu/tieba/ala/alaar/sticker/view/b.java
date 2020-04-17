package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.n;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import com.baidu.live.w.a;
import com.baidu.tieba.ala.alaar.sticker.model.FuFaceItem;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
import com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView;
import com.baidu.tieba.ala.alaar.sticker.view.c;
/* loaded from: classes3.dex */
public class b implements com.baidu.live.w.a {
    private n aDE;
    private AlaStickerDragContentView eLd;
    private AlaStickerDragDeletePanelView eLe;
    private c eLf;
    private a.InterfaceC0132a eLg;
    private AlaTextStickerEditView eLh;
    private DragTextView eLi;
    private com.baidu.live.g.a eLj;
    private ViewGroup eLk;
    private ViewGroup eLl;
    private ViewGroup eLm;
    private com.baidu.live.w.b eLo;
    private Context mContext;
    private int eLn = 0;
    private int euQ = 0;
    private boolean dYb = true;
    private Handler mHandler = new Handler();
    private boolean eLp = false;
    private c.a eLq = new c.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void a(FuFaceItem fuFaceItem, String str) {
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.eLp) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.eLd != null && b.this.eLd.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                    return;
                }
                int i = a.d.sdk_cp_cont_q;
                b.this.bkD();
                b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i);
                b.this.bkC();
            } else if (b.this.eLg != null) {
                b.this.eLg.D(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void bkF() {
        }
    };
    private Runnable dUu = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.dYb = true;
        }
    };
    private e eLr = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.dYb) {
                b.this.dYb = false;
                b.this.mHandler.postDelayed(b.this.dUu, 600L);
                if (view instanceof DragTextView) {
                    b.this.eLi = (DragTextView) view;
                    if (b.this.eLg != null) {
                        b.this.eLg.Ez();
                    }
                    b.this.zh(b.this.eLi.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.eLe != null) {
                b.this.eLe.setVisibility(8);
                b.this.eLe.iN(false);
                if (((i4 - i2) / 5) + i2 < b.this.eLe.getTopDeletePanelBottom()) {
                    b.this.bu(view);
                    b.this.bkE();
                    if (b.this.eLj != null) {
                        b.this.eLj.L(view);
                    }
                } else if (b.this.eLj != null && b.this.eLj.K(view)) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_shelter);
                }
                b.this.bkC();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void u(int i, int i2, int i3, int i4) {
            if (b.this.eLe != null) {
                b.this.eLe.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.eLe.getTopDeletePanelBottom()) {
                    b.this.eLe.iN(true);
                } else {
                    b.this.eLe.iN(false);
                }
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.w.a
    public void i(ViewGroup viewGroup) {
        this.eLk = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void j(ViewGroup viewGroup) {
        this.eLm = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void cw(int i) {
        this.eLn = i;
    }

    @Override // com.baidu.live.w.a
    public void cx(int i) {
        this.euQ = i;
    }

    @Override // com.baidu.live.w.a
    public void setStickerCanOperate(boolean z) {
        if (this.eLd != null) {
            this.eLd.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.w.a
    public void k(ViewGroup viewGroup) {
        this.eLl = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.g.a aVar) {
        this.eLj = aVar;
    }

    @Override // com.baidu.live.w.a
    public void showDialog() {
        if (this.eLf == null) {
            this.eLf = new c(this.mContext, this.eLq);
        }
        this.eLf.show();
    }

    @Override // com.baidu.live.w.a
    public void bN(boolean z) {
        this.eLp = z;
    }

    @Override // com.baidu.live.w.a
    public void setLiveShowInfo(n nVar) {
        this.aDE = nVar;
    }

    @Override // com.baidu.live.w.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.eLh != null) {
                this.eLh.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLh.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eLh.setLayoutParams(layoutParams);
                    this.eLh.setBottom(0);
                }
            }
        } else if (this.eLh != null && this.eLl != null) {
            if (this.eLl.indexOfChild(this.eLh) >= 0) {
                this.eLl.removeView(this.eLh);
            }
            this.eLh.setVisibility(8);
            this.eLi = null;
            if (this.eLg != null) {
                this.eLg.EA();
            }
        }
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.w.a
    public void a(a.InterfaceC0132a interfaceC0132a) {
        this.eLg = interfaceC0132a;
    }

    @Override // com.baidu.live.w.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dUu);
        }
        if (this.eLh != null) {
            this.eLh.unRegisterListener();
            this.eLh = null;
        }
        if (this.eLf != null) {
            this.eLf.unRegisterListener();
            this.eLf = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zh(String str) {
        if (this.eLh == null) {
            this.eLh = new AlaTextStickerEditView(this.mContext);
            this.eLh.setLiveShowInfo(this.aDE);
            this.eLh.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void zi(String str2) {
                    if (!StringUtils.isNull(str2) && b.this.eLi != null) {
                        b.this.eLi.setText(str2);
                    }
                }
            });
        }
        if (this.eLl != null) {
            if (this.eLl.indexOfChild(this.eLh) >= 0) {
                this.eLl.removeView(this.eLh);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds98));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.eLl.addView(this.eLh, layoutParams);
            this.eLh.show(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkC() {
        if (this.eLd != null) {
            if (this.eLo == null) {
                this.eLo = new com.baidu.live.w.b();
            }
            this.eLd.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.eLd.getChildCount() <= 0 || b.this.eLd.getVisibility() != 0) {
                        b.this.eLo.aRL = false;
                        b.this.eLo.bitmap = b.this.eLd.getVisibleBitmap();
                    } else {
                        b.this.eLo.aRL = true;
                        b.this.eLo.bitmap = b.this.eLd.getVisibleBitmap();
                    }
                    if (b.this.eLg != null) {
                        b.this.eLg.a(b.this.eLo);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkD() {
        if (this.eLd == null) {
            this.eLd = new AlaStickerDragContentView(this.mContext);
        }
        if (this.eLe == null) {
            this.eLe = new AlaStickerDragDeletePanelView(this.mContext);
            this.eLe.setVisibility(8);
        }
        if (this.eLd.getParent() == null) {
            this.eLd.bi(this.eLk.getWidth(), this.eLk.getHeight() - this.euQ);
            this.eLk.addView(this.eLd, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.eLe.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.eLe.setDeleteBottomHeight(this.euQ);
            this.eLe.setTopDeletePanelHeight(this.eLn);
            this.eLm.addView(this.eLe, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkE() {
        if (this.eLd.getChildCount() == 0) {
            if (this.eLd != null) {
                ((ViewGroup) this.eLd.getParent()).removeView(this.eLd);
            }
            if (this.eLe != null) {
                ((ViewGroup) this.eLe.getParent()).removeView(this.eLe);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap, int i2) {
        if (this.eLd != null) {
            this.eLd.a(i, bitmap, i2, this.eLr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(View view) {
        if (this.eLd != null) {
            this.eLd.bv(view);
        }
    }
}
