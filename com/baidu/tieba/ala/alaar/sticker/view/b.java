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
    private n aDK;
    private AlaStickerDragContentView eLi;
    private AlaStickerDragDeletePanelView eLj;
    private c eLk;
    private a.InterfaceC0153a eLl;
    private AlaTextStickerEditView eLm;
    private DragTextView eLn;
    private com.baidu.live.g.a eLo;
    private ViewGroup eLp;
    private ViewGroup eLq;
    private ViewGroup eLr;
    private com.baidu.live.w.b eLt;
    private Context mContext;
    private int eLs = 0;
    private int euV = 0;
    private boolean dYg = true;
    private Handler mHandler = new Handler();
    private boolean eLu = false;
    private c.a eLv = new c.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.1
        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void a(FuFaceItem fuFaceItem, String str) {
            if (fuFaceItem instanceof PicStickerItem) {
                if (b.this.eLu) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_master_live_unable_sticker);
                    return;
                }
                PicStickerItem picStickerItem = (PicStickerItem) fuFaceItem;
                if (b.this.eLi != null && b.this.eLi.getChildCount() >= 3) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_max_striker);
                    return;
                }
                int i = a.d.sdk_cp_cont_q;
                b.this.bkB();
                b.this.a(picStickerItem.sticker_type, picStickerItem.bitmap, i);
                b.this.bkA();
            } else if (b.this.eLl != null) {
                b.this.eLl.E(fuFaceItem.getSticker());
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.c.a
        public void bkD() {
        }
    };
    private Runnable dUz = new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.3
        @Override // java.lang.Runnable
        public void run() {
            b.this.dYg = true;
        }
    };
    private e eLw = new e() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.4
        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void onClick(View view) {
            if (b.this.dYg) {
                b.this.dYg = false;
                b.this.mHandler.postDelayed(b.this.dUz, 600L);
                if (view instanceof DragTextView) {
                    b.this.eLn = (DragTextView) view;
                    if (b.this.eLl != null) {
                        b.this.eLl.Ey();
                    }
                    b.this.zk(b.this.eLn.getText().toString());
                }
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void e(View view, int i, int i2, int i3, int i4) {
            if (b.this.eLj != null) {
                b.this.eLj.setVisibility(8);
                b.this.eLj.iN(false);
                if (((i4 - i2) / 5) + i2 < b.this.eLj.getTopDeletePanelBottom()) {
                    b.this.bu(view);
                    b.this.bkC();
                    if (b.this.eLo != null) {
                        b.this.eLo.L(view);
                    }
                } else if (b.this.eLo != null && b.this.eLo.K(view)) {
                    BdUtilHelper.showToast(b.this.mContext, a.i.ala_live_sticker_shelter);
                }
                b.this.bkA();
            }
        }

        @Override // com.baidu.tieba.ala.alaar.sticker.view.e
        public void u(int i, int i2, int i3, int i4) {
            if (b.this.eLj != null) {
                b.this.eLj.setVisibility(0);
                if (((i4 - i2) / 5) + i2 < b.this.eLj.getTopDeletePanelBottom()) {
                    b.this.eLj.iN(true);
                } else {
                    b.this.eLj.iN(false);
                }
            }
        }
    };

    public b(Context context) {
        this.mContext = context;
    }

    @Override // com.baidu.live.w.a
    public void i(ViewGroup viewGroup) {
        this.eLp = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void j(ViewGroup viewGroup) {
        this.eLr = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void cw(int i) {
        this.eLs = i;
    }

    @Override // com.baidu.live.w.a
    public void cx(int i) {
        this.euV = i;
    }

    @Override // com.baidu.live.w.a
    public void setStickerCanOperate(boolean z) {
        if (this.eLi != null) {
            this.eLi.setStickerCanOperate(z);
        }
    }

    @Override // com.baidu.live.w.a
    public void k(ViewGroup viewGroup) {
        this.eLq = viewGroup;
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.g.a aVar) {
        this.eLo = aVar;
    }

    @Override // com.baidu.live.w.a
    public void showDialog() {
        if (this.eLk == null) {
            this.eLk = new c(this.mContext, this.eLv);
        }
        this.eLk.show();
    }

    @Override // com.baidu.live.w.a
    public void bN(boolean z) {
        this.eLu = z;
    }

    @Override // com.baidu.live.w.a
    public void setLiveShowInfo(n nVar) {
        this.aDK = nVar;
    }

    @Override // com.baidu.live.w.a
    public void onKeyboardVisibilityChanged(boolean z) {
        if (z) {
            if (this.eLm != null) {
                this.eLm.setVisibility(0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.eLm.getLayoutParams();
                if (layoutParams != null && layoutParams.bottomMargin != TbadkCoreApplication.getInst().getKeyboardHeight()) {
                    layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
                    this.eLm.setLayoutParams(layoutParams);
                    this.eLm.setBottom(0);
                }
            }
        } else if (this.eLm != null && this.eLq != null) {
            if (this.eLq.indexOfChild(this.eLm) >= 0) {
                this.eLq.removeView(this.eLm);
            }
            this.eLm.setVisibility(8);
            this.eLn = null;
            if (this.eLl != null) {
                this.eLl.Ez();
            }
        }
    }

    @Override // com.baidu.live.w.a
    public void a(com.baidu.live.liveroom.b.a aVar) {
    }

    @Override // com.baidu.live.w.a
    public void a(a.InterfaceC0153a interfaceC0153a) {
        this.eLl = interfaceC0153a;
    }

    @Override // com.baidu.live.w.a
    public void onDestroy() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacks(this.dUz);
        }
        if (this.eLm != null) {
            this.eLm.unRegisterListener();
            this.eLm = null;
        }
        if (this.eLk != null) {
            this.eLk.unRegisterListener();
            this.eLk = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(String str) {
        if (this.eLm == null) {
            this.eLm = new AlaTextStickerEditView(this.mContext);
            this.eLm.setLiveShowInfo(this.aDK);
            this.eLm.setTextEditCompleteListener(new AlaTextStickerEditView.a() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.2
                @Override // com.baidu.tieba.ala.alaar.sticker.view.AlaTextStickerEditView.a
                public void zl(String str2) {
                    if (!StringUtils.isNull(str2) && b.this.eLn != null) {
                        b.this.eLn.setText(str2);
                    }
                }
            });
        }
        if (this.eLq != null) {
            if (this.eLq.indexOfChild(this.eLm) >= 0) {
                this.eLq.removeView(this.eLm);
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds98));
            layoutParams.addRule(12);
            layoutParams.bottomMargin = TbadkCoreApplication.getInst().getKeyboardHeight();
            this.eLq.addView(this.eLm, layoutParams);
            this.eLm.show(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkA() {
        if (this.eLi != null) {
            if (this.eLt == null) {
                this.eLt = new com.baidu.live.w.b();
            }
            this.eLi.post(new Runnable() { // from class: com.baidu.tieba.ala.alaar.sticker.view.b.5
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.eLi.getChildCount() <= 0 || b.this.eLi.getVisibility() != 0) {
                        b.this.eLt.aRQ = false;
                        b.this.eLt.bitmap = b.this.eLi.getVisibleBitmap();
                    } else {
                        b.this.eLt.aRQ = true;
                        b.this.eLt.bitmap = b.this.eLi.getVisibleBitmap();
                    }
                    if (b.this.eLl != null) {
                        b.this.eLl.a(b.this.eLt);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkB() {
        if (this.eLi == null) {
            this.eLi = new AlaStickerDragContentView(this.mContext);
        }
        if (this.eLj == null) {
            this.eLj = new AlaStickerDragDeletePanelView(this.mContext);
            this.eLj.setVisibility(8);
        }
        if (this.eLi.getParent() == null) {
            this.eLi.bi(this.eLp.getWidth(), this.eLp.getHeight() - this.euV);
            this.eLp.addView(this.eLi, new RelativeLayout.LayoutParams(-1, -1));
        }
        if (this.eLj.getParent() == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            this.eLj.setDeleteBottomHeight(this.euV);
            this.eLj.setTopDeletePanelHeight(this.eLs);
            this.eLr.addView(this.eLj, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkC() {
        if (this.eLi.getChildCount() == 0) {
            if (this.eLi != null) {
                ((ViewGroup) this.eLi.getParent()).removeView(this.eLi);
            }
            if (this.eLj != null) {
                ((ViewGroup) this.eLj.getParent()).removeView(this.eLj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, Bitmap bitmap, int i2) {
        if (this.eLi != null) {
            this.eLi.a(i, bitmap, i2, this.eLw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bu(View view) {
        if (this.eLi != null) {
            this.eLi.bv(view);
        }
    }
}
