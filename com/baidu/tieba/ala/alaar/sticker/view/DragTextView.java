package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.alaar.sticker.model.PicStickerItem;
/* loaded from: classes3.dex */
public class DragTextView extends TextView {
    private int eMg;
    private int eMh;
    private int eMi;
    private int eMj;
    private int eMk;
    private e eMl;
    private GestureDetector eMm;
    private boolean eMn;
    private boolean eMo;
    private TbImageView eMp;
    private final int eMq;
    private GestureDetector.OnGestureListener eMr;
    private int mActivePointerId;
    private float mDownX;
    private float mDownY;
    private boolean mIsSilding;
    private float mLastMotionX;
    private float mLastMotionY;

    public DragTextView(Context context) {
        super(context);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.eMn = false;
        this.eMo = true;
        this.eMq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.eMr = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (DragTextView.this.eMl != null && DragTextView.this.eMn) {
                    DragTextView.this.eMl.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.eMn = false;
        this.eMo = true;
        this.eMq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.eMr = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (DragTextView.this.eMl != null && DragTextView.this.eMn) {
                    DragTextView.this.eMl.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        };
        init(context);
    }

    public DragTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mActivePointerId = -1;
        this.mIsSilding = false;
        this.eMn = false;
        this.eMo = true;
        this.eMq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds300);
        this.eMr = new GestureDetector.OnGestureListener() { // from class: com.baidu.tieba.ala.alaar.sticker.view.DragTextView.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (DragTextView.this.eMl != null && DragTextView.this.eMn) {
                    DragTextView.this.eMl.onClick(DragTextView.this);
                    return false;
                }
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.eMg = (int) (context.getResources().getDisplayMetrics().density * 12.0f);
        this.eMm = new GestureDetector(context, this.eMr);
    }

    public void setCanEdit(boolean z) {
        this.eMn = z;
    }

    public void setStickerCanOperate(boolean z) {
        this.eMo = z;
    }

    public void setParentBorder(int i, int i2, int i3, int i4) {
        this.eMh = i;
        this.eMi = i2;
        this.eMj = i3;
        this.eMk = i4;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i;
        int i2;
        int i3;
        if (!this.eMo) {
            return super.onTouchEvent(motionEvent);
        }
        this.eMm.onTouchEvent(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                this.mActivePointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (!isInvalidEvent(motionEvent, actionIndex, this.mActivePointerId)) {
                    this.mLastMotionX = motionEvent.getX();
                    this.mLastMotionY = motionEvent.getY();
                    this.mDownX = MotionEventCompat.getX(motionEvent, actionIndex);
                    this.mDownY = MotionEventCompat.getY(motionEvent, actionIndex);
                    return true;
                }
                break;
            case 1:
                setAlpha(1.0f);
                if (this.eMl != null) {
                    int diffX = getDiffX(motionEvent);
                    int x = x(motionEvent);
                    int left = getLeft() + diffX;
                    int top2 = getTop() + x;
                    int right = getRight() + diffX;
                    int bottom = getBottom() + x;
                    if (this.eMl != null) {
                        this.eMl.e(this, left, top2, right, bottom);
                    }
                }
                endDrag();
                break;
            case 2:
                if (!this.mIsSilding) {
                    determineDrag(motionEvent);
                }
                if (this.mIsSilding) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (!isInvalidEvent(motionEvent, getPointerIndex(motionEvent, this.mActivePointerId), this.mActivePointerId)) {
                        int diffX2 = getDiffX(motionEvent);
                        int x2 = x(motionEvent);
                        int left2 = getLeft() + diffX2;
                        int top3 = getTop() + x2;
                        int right2 = diffX2 + getRight();
                        int bottom2 = x2 + getBottom();
                        if (left2 < this.eMh) {
                            left2 = this.eMh;
                            right2 = this.eMh + getWidth();
                        }
                        if (right2 > this.eMj) {
                            right2 = this.eMj;
                            left2 = this.eMj - getWidth();
                        }
                        if (top3 < this.eMi) {
                            top3 = this.eMi;
                            bottom2 = this.eMi + getHeight();
                        }
                        if (bottom2 > this.eMk) {
                            bottom2 = this.eMk;
                            top3 = this.eMk - getHeight();
                        }
                        if (bottom2 <= this.eMk - this.eMq || right2 >= this.eMj - this.eMq) {
                            i = bottom2;
                        } else {
                            int i4 = this.eMk - this.eMq;
                            top3 = (this.eMk - this.eMq) - getHeight();
                            i = i4;
                        }
                        if (left2 >= this.eMj - this.eMq || top3 <= this.eMk - this.eMq) {
                            i2 = right2;
                            i3 = left2;
                        } else {
                            int i5 = this.eMj - this.eMq;
                            i2 = (this.eMj - this.eMq) + getWidth();
                            i3 = i5;
                        }
                        f(this, i3, top3, i2, i);
                        setAlpha(0.7f);
                        if (this.eMl != null) {
                            this.eMl.u(i3, top3, i2, i);
                            break;
                        }
                    }
                }
                break;
            case 3:
                setAlpha(1.0f);
                if (this.eMl != null) {
                    int diffX3 = getDiffX(motionEvent);
                    int x3 = x(motionEvent);
                    int right3 = getRight() + diffX3;
                    int bottom3 = getBottom() + x3;
                    this.eMl.e(this, getLeft() + diffX3, getTop() + x3, right3, bottom3);
                }
                endDrag();
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
    }

    public void setBackground(PicStickerItem picStickerItem) {
        if (this.eMp == null) {
            this.eMp = new TbImageView(getContext());
        }
        this.eMp.startLoad(picStickerItem.url, 10, false);
    }

    private void f(View view, int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9, -1);
        layoutParams.addRule(10, -1);
        layoutParams.setMargins(i, i2, 0, 0);
        view.setLayoutParams(layoutParams);
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
            if (abs > this.eMg || abs2 > this.eMg) {
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
        this.eMl = eVar;
    }
}
