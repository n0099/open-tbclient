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
/* loaded from: classes3.dex */
public class DragTextView extends TextView {
    private float bjK;
    private float cAs;
    private int fjA;
    private int fjB;
    private int fjC;
    private int fjD;
    private int fjE;
    private int fjF;
    private int fjG;
    private e fjH;
    private GestureDetector fjI;
    private boolean fjJ;
    private boolean fjK;
    private TbImageView fjL;
    private final int fjM;
    private int fjN;
    private int fjO;
    private boolean fjP;
    private float fjQ;
    private float fjR;
    private CharSequence fjS;
    int fjT;
    int fjU;
    int fjV;
    private GestureDetector.OnGestureListener fjW;
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
        this.fjJ = false;
        this.fjK = true;
        this.fjM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fjN = this.fjM;
        this.fjO = this.fjM;
        this.fjP = false;
        this.type = 2;
        this.fjW = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fjP = true;
                if (DragTextView.this.fjH != null && DragTextView.this.fjJ) {
                    DragTextView.this.fjH.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fjP = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
                if (DragTextView.this.fjH != null) {
                    DragTextView.this.fjH.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fjP = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.fjJ = false;
        this.fjK = true;
        this.fjM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fjN = this.fjM;
        this.fjO = this.fjM;
        this.fjP = false;
        this.type = 2;
        this.fjW = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fjP = true;
                if (DragTextView.this.fjH != null && DragTextView.this.fjJ) {
                    DragTextView.this.fjH.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fjP = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
                if (DragTextView.this.fjH != null) {
                    DragTextView.this.fjH.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fjP = false;
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.fjJ = false;
        this.fjK = true;
        this.fjM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.fjN = this.fjM;
        this.fjO = this.fjM;
        this.fjP = false;
        this.type = 2;
        this.fjW = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                DragTextView.this.fjP = true;
                if (DragTextView.this.fjH != null && DragTextView.this.fjJ) {
                    DragTextView.this.fjH.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fjP = false;
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                DragTextView.this.fjP = false;
                if (DragTextView.this.fjH != null) {
                    DragTextView.this.fjH.onLongPress();
                }
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                DragTextView.this.fjP = false;
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.fjA = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.fjI = new GestureDetector(context, this.fjW);
        this.fjT = BdUtilHelper.dip2px(context, 98.0f) / 2;
        this.fjU = BdUtilHelper.dip2px(context, 162.0f) / 2;
        this.fjV = BdUtilHelper.dip2px(context, 64.0f) / 2;
    }

    public void setCanEdit(boolean z) {
        this.fjJ = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.fjK = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        if (this.type == 2) {
            this.fjF = this.fjU;
        } else {
            this.fjF = this.fjT;
        }
        this.fjG = this.fjV;
        this.fjB = i;
        this.fjD = i3;
        this.fjC = i2;
        this.fjE = i4;
    }

    public void setImRightViewSize(int i, int i2) {
        this.fjN = i;
        this.fjO = i2;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        if (!this.fjK) {
            return super.onTouchEvent(motionEvent);
        }
        this.fjI.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.fjP = false;
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mDownY = MotionEventCompat.getY(motionEvent, actionIndex);
                    this.cAs = getX();
                    this.bjK = getY();
                    if (this.fjH != null && this.fjH.bsO()) {
                        this.fjQ = getTranslationX();
                        this.fjR = getTranslationY();
                        this.fjS = getText();
                    }
                    if (this.fjH != null) {
                        this.fjH.bsN();
                        return true;
                    }
                    return true;
                }
                break;
            case 1:
            case 3:
                setAlpha(1.0f);
                if (this.fjH != null && !this.fjP) {
                    this.fjH.e(this, (int) this.cAs, (int) this.bjK, getWidth() + ((int) this.cAs), getHeight() + ((int) this.bjK));
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId) && (this.fjH == null || this.fjH.bsO())) {
                        int diffX = getDiffX(motionEvent);
                        int x = x(motionEvent);
                        int x2 = ((int) getX()) + diffX;
                        int y = ((int) getY()) + x;
                        int width = x2 + getWidth();
                        int height = y + getHeight();
                        int i3 = this.fjC;
                        int i4 = this.fjB - this.fjF;
                        int i5 = this.fjF + this.fjD;
                        int i6 = this.fjD - this.fjN;
                        int i7 = (this.fjE - this.fjO) + this.fjG;
                        int i8 = this.fjG + this.fjE;
                        int i9 = i6 - this.fjF;
                        if (y < i3) {
                            height = getHeight() + i3;
                        } else {
                            i3 = y;
                        }
                        if (x2 < i4) {
                            width = getWidth() + i4;
                        } else {
                            i4 = x2;
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
                        this.cAs = i9;
                        this.bjK = i2;
                        setTranslationX(i9);
                        setTranslationY(i2);
                        setAlpha(0.7f);
                        if (this.fjH != null) {
                            this.fjH.v((int) this.cAs, (int) this.bjK, ((int) this.cAs) + getWidth(), ((int) this.bjK) + getHeight());
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
        if (this.fjL == null) {
            this.fjL = new TbImageView(getContext());
        }
        this.fjL.startLoad(picStickerItem.url, 10, false);
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
            if (abs > this.fjA || abs2 > this.fjA) {
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

    private int x(MotionEvent motionEvent) {
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
        this.fjH = eVar;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void bsT() {
        setTranslationX(this.fjQ);
        setTranslationY(this.fjR);
        if (this.type == 2) {
            setText(this.fjS);
        }
        if (getParent() != null && ((View) getParent()).getVisibility() == 0) {
            setVisibility(0);
        }
    }
}
