package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
/* loaded from: classes10.dex */
public class DragTextView extends TextView {
    private float bNR;
    private float cFL;
    private float dxQ;
    private int gxc;
    private int gxd;
    private int gxe;
    private int gxf;
    private int gxg;
    private int gxh;
    private int gxi;
    private e gxj;
    private GestureDetector gxk;
    private boolean gxl;
    private boolean gxm;
    private TbImageView gxn;
    private final int gxo;
    private int gxp;
    private int gxq;
    private boolean gxr;
    private float gxs;
    private float gxt;
    private CharSequence gxu;
    int gxv;
    int gxw;
    int gxx;
    private GestureDetector.OnGestureListener gxy;
    private int mActivePointerId;
    private float mDownX;
    private boolean mIsSilding;
    private float mLastMotionX;
    private float mLastMotionY;
    private int type;

    public DragTextView(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gxl = false;
        this.gxm = true;
        this.gxo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gxp = this.gxo;
        this.gxq = this.gxo;
        this.gxr = false;
        this.type = 2;
        this.gxy = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gxr = true;
                if (DragTextView.this.gxj != null && DragTextView.this.gxl) {
                    DragTextView.this.gxj.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gxr = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
                if (DragTextView.this.gxj != null) {
                    DragTextView.this.gxj.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gxr = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gxl = false;
        this.gxm = true;
        this.gxo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gxp = this.gxo;
        this.gxq = this.gxo;
        this.gxr = false;
        this.type = 2;
        this.gxy = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gxr = true;
                if (DragTextView.this.gxj != null && DragTextView.this.gxl) {
                    DragTextView.this.gxj.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gxr = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
                if (DragTextView.this.gxj != null) {
                    DragTextView.this.gxj.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gxr = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.gxl = false;
        this.gxm = true;
        this.gxo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.d.sdk_ds300);
        this.gxp = this.gxo;
        this.gxq = this.gxo;
        this.gxr = false;
        this.type = 2;
        this.gxy = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.gxr = true;
                if (DragTextView.this.gxj != null && DragTextView.this.gxl) {
                    DragTextView.this.gxj.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gxr = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.gxr = false;
                if (DragTextView.this.gxj != null) {
                    DragTextView.this.gxj.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.gxr = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.gxc = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.gxk = new GestureDetector(context, this.gxy);
        this.gxv = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.gxw = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.gxx = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.gxl = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.gxm = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.gxh = this.gxw;
        } else {
            this.gxh = this.gxv;
        }
        this.gxi = this.gxx;
        this.gxd = i;
        this.gxf = i3;
        this.gxe = i2;
        this.gxg = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.gxp = i;
        this.gxq = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.gxm) {
            return super.onTouchEvent(motionEvent);
        }
        this.gxk.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.gxr = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.cFL = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.dxQ = getX();
                    this.bNR = getY();
                    if (this.gxj != null && this.gxj.bQx()) {
                        this.gxs = getTranslationX();
                        this.gxt = getTranslationY();
                        this.gxu = getText();
                    }
                    if (this.gxj != null) {
                        this.gxj.bQw();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.gxj != null && !this.gxr) {
                    this.gxj.g(this, (int) this.dxQ, (int) this.bNR, getWidth() + ((int) this.dxQ), getHeight() + ((int) this.bNR));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.gxj == null || this.gxj.bQx())) {
                        int diffX = getDiffX(motionEvent);
                        int M = M(motionEvent);
                        int x = ((int) getX()) + diffX;
                        int y = ((int) getY()) + M;
                        int width = x + getWidth();
                        int height = y + getHeight();
                        int i = this.gxe;
                        int i2 = this.gxd - this.gxh;
                        int i3 = this.gxf + this.gxh;
                        int i4 = this.gxf - this.gxp;
                        int i5 = (this.gxg - this.gxq) + this.gxi;
                        int i6 = this.gxi + this.gxg;
                        int i7 = i4 - this.gxh;
                        if (y < i) {
                            height = getHeight() + i;
                        } else {
                            i = y;
                        }
                        if (x < i2) {
                            width = getWidth() + i2;
                        } else {
                            i2 = x;
                        }
                        if (width > i3) {
                            i2 = i3 - getWidth();
                        } else {
                            i3 = width;
                        }
                        if (height > i6) {
                            i = i6 - getHeight();
                        } else {
                            i6 = height;
                        }
                        if (i3 < i4 && i6 > i5) {
                            i = i5 - getHeight();
                            i6 = i5;
                        }
                        if (i2 >= i7 || i6 <= i5) {
                            i7 = i2;
                        } else {
                            int width2 = getWidth() + i7;
                        }
                        this.dxQ = i7;
                        this.bNR = i;
                        setTranslationX(i7);
                        setTranslationY(i);
                        setAlpha(0.7f);
                        if (this.gxj != null) {
                            this.gxj.C((int) this.dxQ, (int) this.bNR, ((int) this.dxQ) + getWidth(), ((int) this.bNR) + getHeight());
                            break;
                        }
                    }
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
    }

    public void setBackground(PicStickerItem picStickerItem) {
        if (this.gxn == null) {
            this.gxn = new TbImageView(getContext());
        }
        this.gxn.startLoad(picStickerItem.url, 10, false);
    }

    private void endDrag() {
        this.mIsSilding = false;
        this.mActivePointerId = -1;
    }

    private void determineDrag(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (!isInvalidEvent(motionEvent, pointerIndex, i)) {
            float x = MotionEventCompat.getX(motionEvent, pointerIndex);
            float abs = Math.abs(x - this.mLastMotionX);
            float y = MotionEventCompat.getY(motionEvent, pointerIndex);
            float abs2 = Math.abs(y - this.mLastMotionY);
            if (abs > this.gxc || abs2 > this.gxc) {
                this.mIsSilding = true;
                this.mLastMotionX = x;
                this.mLastMotionY = y;
            }
        }
    }

    private int getPointerIndex(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.mActivePointerId = -1;
        }
        return findPointerIndex;
    }

    private int getDiffX(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getX(motionEvent, pointerIndex) - this.mDownX);
    }

    private int M(MotionEvent motionEvent) {
        int i = this.mActivePointerId;
        int pointerIndex = getPointerIndex(motionEvent, i);
        if (isInvalidEvent(motionEvent, pointerIndex, i)) {
            return 0;
        }
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.cFL);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public void setOnDragViewEventListener(e eVar) {
        this.gxj = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bQF() {
        setTranslationX(this.gxs);
        setTranslationY(this.gxt);
        if (this.type == 2) {
            setText(this.gxu);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
