package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
/* loaded from: classes7.dex */
public class DragTextView extends TextView {
    private float bpJ;
    private float cLu;
    private GestureDetector.OnGestureListener fAA;
    private int fAe;
    private int fAf;
    private int fAg;
    private int fAh;
    private int fAi;
    private int fAj;
    private int fAk;
    private e fAl;
    private GestureDetector fAm;
    private boolean fAn;
    private boolean fAo;
    private TbImageView fAp;
    private final int fAq;
    private int fAr;
    private int fAs;
    private boolean fAt;
    private float fAu;
    private float fAv;
    private CharSequence fAw;
    int fAx;
    int fAy;
    int fAz;
    private int mActivePointerId;
    private float mDownX;
    private float mDownY;
    private boolean mIsSilding;
    private float mLastMotionX;
    private float mLastMotionY;
    private int type;

    public DragTextView(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.fAn = false;
        this.fAo = true;
        this.fAq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fAr = this.fAq;
        this.fAs = this.fAq;
        this.fAt = false;
        this.type = 2;
        this.fAA = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fAt = true;
                if (DragTextView.this.fAl != null && DragTextView.this.fAn) {
                    DragTextView.this.fAl.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fAt = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
                if (DragTextView.this.fAl != null) {
                    DragTextView.this.fAl.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fAt = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.fAn = false;
        this.fAo = true;
        this.fAq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fAr = this.fAq;
        this.fAs = this.fAq;
        this.fAt = false;
        this.type = 2;
        this.fAA = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fAt = true;
                if (DragTextView.this.fAl != null && DragTextView.this.fAn) {
                    DragTextView.this.fAl.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fAt = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
                if (DragTextView.this.fAl != null) {
                    DragTextView.this.fAl.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fAt = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.fAn = false;
        this.fAo = true;
        this.fAq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fAr = this.fAq;
        this.fAs = this.fAq;
        this.fAt = false;
        this.type = 2;
        this.fAA = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fAt = true;
                if (DragTextView.this.fAl != null && DragTextView.this.fAn) {
                    DragTextView.this.fAl.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fAt = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fAt = false;
                if (DragTextView.this.fAl != null) {
                    DragTextView.this.fAl.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fAt = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fAe = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.fAm = new GestureDetector(context, this.fAA);
        this.fAx = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.fAy = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.fAz = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.fAn = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.fAo = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.fAj = this.fAy;
        } else {
            this.fAj = this.fAx;
        }
        this.fAk = this.fAz;
        this.fAf = i;
        this.fAh = i3;
        this.fAg = i2;
        this.fAi = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.fAr = i;
        this.fAs = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (!this.fAo) {
            return super.onTouchEvent(motionEvent);
        }
        this.fAm.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.fAt = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mDownY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.cLu = getX();
                    this.bpJ = getY();
                    if (this.fAl != null && this.fAl.bES()) {
                        this.fAu = getTranslationX();
                        this.fAv = getTranslationY();
                        this.fAw = getText();
                    }
                    if (this.fAl != null) {
                        this.fAl.bER();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.fAl != null && !this.fAt) {
                    this.fAl.e(this, (int) this.cLu, (int) this.bpJ, getWidth() + ((int) this.cLu), getHeight() + ((int) this.bpJ));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.fAl == null || this.fAl.bES())) {
                        int diffX = getDiffX(motionEvent);
                        int M = M(motionEvent);
                        int x = ((int) getX()) + diffX;
                        int y = ((int) getY()) + M;
                        int width = x + getWidth();
                        int height = y + getHeight();
                        int i3 = this.fAg;
                        int i4 = this.fAf - this.fAj;
                        int i5 = this.fAj + this.fAh;
                        int i6 = this.fAh - this.fAr;
                        int i7 = (this.fAi - this.fAs) + this.fAk;
                        int i8 = this.fAk + this.fAi;
                        int i9 = i6 - this.fAj;
                        if (y < i3) {
                            height = getHeight() + i3;
                        } else {
                            i3 = y;
                        }
                        if (x < i4) {
                            width = getWidth() + i4;
                        } else {
                            i4 = x;
                        }
                        if (width > i5) {
                            i = i5 - getWidth();
                            width = i5;
                        } else {
                            i = i4;
                        }
                        if (height > i8) {
                            i2 = i8 - getHeight();
                        } else {
                            i8 = height;
                            i2 = i3;
                        }
                        if (width < i6 && i8 > i7) {
                            i2 = i7 - getHeight();
                            i8 = i7;
                        }
                        if (i >= i9 || i8 <= i7) {
                            i9 = i;
                        } else {
                            int width2 = getWidth() + i9;
                        }
                        this.cLu = i9;
                        this.bpJ = i2;
                        setTranslationX(i9);
                        setTranslationY(i2);
                        setAlpha(0.7f);
                        if (this.fAl != null) {
                            this.fAl.w((int) this.cLu, (int) this.bpJ, ((int) this.cLu) + getWidth(), ((int) this.bpJ) + getHeight());
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
        if (this.fAp == null) {
            this.fAp = new TbImageView(getContext());
        }
        this.fAp.startLoad(picStickerItem.url, 10, false);
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
            if (abs > this.fAe || abs2 > this.fAe) {
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
        return (int) (MotionEventCompat.getY(motionEvent, pointerIndex) - this.mDownY);
    }

    private boolean isInvalidEvent(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public void setOnDragViewEventListener(e eVar) {
        this.fAl = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bFa() {
        setTranslationX(this.fAu);
        setTranslationY(this.fAv);
        if (this.type == 2) {
            setText(this.fAw);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
