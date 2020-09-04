package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int eUf;
    private int eZD;
    private boolean eZE;
    private int eZF;
    private boolean eZG;
    private boolean eZH;
    private GestureDetector eZI;
    private GestureDetector eZJ;
    private int eZK;
    private int eZL;
    private int eZM;
    private int eZN;
    private int eZO;
    private int eZP;
    private float eZQ;
    private int eZR;
    private int eZS;
    private int eZT;
    private boolean eZU;
    private a eZV;
    private int eZW;
    private GestureDetector.OnGestureListener eZX;
    private GestureDetector mDetector;
    private boolean mDragging;
    private ListView mListView;
    private int[] mTempLoc;
    private int mTouchSlop;

    public b(a aVar, ListView listView, int i, int i2, int i3) {
        this(aVar, listView, i, i2, i3, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4) {
        this(aVar, listView, i, i2, i3, i4, 0);
    }

    public b(a aVar, ListView listView, int i, int i2, int i3, int i4, int i5) {
        super(listView);
        this.eZD = 0;
        this.eZE = true;
        this.eZG = false;
        this.eZH = false;
        this.eZK = -1;
        this.eZL = -1;
        this.eZM = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.eZQ = 500.0f;
        this.eZX = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.eZG && b.this.eZH) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.eZQ) {
                        if (b.this.eZW > (-width)) {
                            b.this.eZV.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.eZQ) && b.this.eZW < width) {
                        b.this.eZV.stopDragWithVelocity(true, f);
                    }
                    b.this.eZH = false;
                }
                return false;
            }
        };
        this.eZV = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.eZI = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.eZV.isDragEnabled() || b.this.eZV.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.eZP = (int) motionEvent.getX();
                b.this.eUf = (int) motionEvent.getY();
                return true;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                b.this.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                return false;
            }
        });
        this.eZJ = new GestureDetector(listView.getContext(), this.eZX);
        this.eZJ.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.eZR = i;
        this.eZS = i4;
        this.eZT = i5;
        qV(i3);
        qU(i2);
    }

    public GestureDetector bwK() {
        return this.eZI;
    }

    public void qU(int i) {
        this.eZD = i;
    }

    public void jT(boolean z) {
        this.eZE = z;
    }

    public void qV(int i) {
        this.eZF = i;
    }

    public void jU(boolean z) {
        this.eZG = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.eZE && !this.eZH) {
            i4 = 12;
        }
        if (this.eZG && this.eZH) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.eZV.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.eZV.isDragEnabled() && !this.eZV.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.eZG && this.mDragging && this.eZF == 1) {
                this.eZJ.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.eZP = (int) motionEvent.getX();
                    this.eUf = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.eZG && this.eZH) {
                        if ((this.eZW >= 0 ? this.eZW : -this.eZW) > this.mListView.getWidth() / 2) {
                            this.eZV.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.eZH = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.eZH = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.eZG && this.eZH) {
            this.eZW = point.x;
        }
    }

    public int H(MotionEvent motionEvent) {
        return J(motionEvent);
    }

    public int I(MotionEvent motionEvent) {
        if (this.eZF == 1) {
            return K(motionEvent);
        }
        return -1;
    }

    public int J(MotionEvent motionEvent) {
        return c(motionEvent, this.eZR);
    }

    public int K(MotionEvent motionEvent) {
        return c(motionEvent, this.eZT);
    }

    public int c(MotionEvent motionEvent, int i) {
        int pointToPosition = this.mListView.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        int headerViewsCount = this.mListView.getHeaderViewsCount();
        int footerViewsCount = this.mListView.getFooterViewsCount();
        int count = this.mListView.getCount();
        if (pointToPosition != -1 && pointToPosition >= headerViewsCount && pointToPosition < count - footerViewsCount) {
            View childAt = this.mListView.getChildAt(pointToPosition - this.mListView.getFirstVisiblePosition());
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            View findViewById = i == 0 ? childAt : childAt.findViewById(i);
            if (findViewById != null) {
                findViewById.getLocationOnScreen(this.mTempLoc);
                if (rawX > this.mTempLoc[0] && rawY > this.mTempLoc[1] && rawX < this.mTempLoc[0] + findViewById.getWidth()) {
                    if (rawY < findViewById.getHeight() + this.mTempLoc[1]) {
                        this.eZN = childAt.getLeft();
                        this.eZO = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.eZG && this.eZF == 0) {
            this.eZM = c(motionEvent, this.eZS);
        }
        this.eZK = H(motionEvent);
        if (this.eZK != -1 && this.eZD == 0) {
            z(this.eZK, ((int) motionEvent.getX()) - this.eZN, ((int) motionEvent.getY()) - this.eZO);
        }
        this.eZH = false;
        this.eZU = true;
        this.eZW = 0;
        this.eZL = I(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.eZN;
            int i2 = y2 - this.eZO;
            if (this.eZU && !this.mDragging && (this.eZK != -1 || this.eZL != -1)) {
                if (this.eZK != -1) {
                    if (this.eZD == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.eZE) {
                        z(this.eZK, i, i2);
                    } else if (this.eZD != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.eZG) {
                        this.eZH = true;
                        z(this.eZL, i, i2);
                    }
                } else if (this.eZL != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.eZG) {
                        this.eZH = true;
                        z(this.eZL, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.eZU = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.eZK != -1 && this.eZD == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.eZK, this.eZP - this.eZN, this.eUf - this.eZO);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.eZG && this.eZF == 0 && this.eZM != -1) {
            this.eZV.removeItem(this.eZM - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
