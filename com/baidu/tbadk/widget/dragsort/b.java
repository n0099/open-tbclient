package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int eJv;
    private int eOT;
    private boolean eOU;
    private int eOV;
    private boolean eOW;
    private boolean eOX;
    private GestureDetector eOY;
    private GestureDetector eOZ;
    private int ePa;
    private int ePb;
    private int ePc;
    private int ePd;
    private int ePe;
    private int ePf;
    private float ePg;
    private int ePh;
    private int ePi;
    private int ePj;
    private boolean ePk;
    private a ePl;
    private int ePm;
    private GestureDetector.OnGestureListener ePn;
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
        this.eOT = 0;
        this.eOU = true;
        this.eOW = false;
        this.eOX = false;
        this.ePa = -1;
        this.ePb = -1;
        this.ePc = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.ePg = 500.0f;
        this.ePn = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.eOW && b.this.eOX) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.ePg) {
                        if (b.this.ePm > (-width)) {
                            b.this.ePl.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.ePg) && b.this.ePm < width) {
                        b.this.ePl.stopDragWithVelocity(true, f);
                    }
                    b.this.eOX = false;
                }
                return false;
            }
        };
        this.ePl = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.eOY = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.ePl.isDragEnabled() || b.this.ePl.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.ePf = (int) motionEvent.getX();
                b.this.eJv = (int) motionEvent.getY();
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
        this.eOZ = new GestureDetector(listView.getContext(), this.ePn);
        this.eOZ.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.ePh = i;
        this.ePi = i4;
        this.ePj = i5;
        oJ(i3);
        oI(i2);
    }

    public GestureDetector bnV() {
        return this.eOY;
    }

    public void oI(int i) {
        this.eOT = i;
    }

    public void jt(boolean z) {
        this.eOU = z;
    }

    public void oJ(int i) {
        this.eOV = i;
    }

    public void ju(boolean z) {
        this.eOW = z;
    }

    public boolean z(int i, int i2, int i3) {
        int i4 = 0;
        if (this.eOU && !this.eOX) {
            i4 = 12;
        }
        if (this.eOW && this.eOX) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.ePl.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ePl.isDragEnabled() && !this.ePl.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.eOW && this.mDragging && this.eOV == 1) {
                this.eOZ.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.ePf = (int) motionEvent.getX();
                    this.eJv = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.eOW && this.eOX) {
                        if ((this.ePm >= 0 ? this.ePm : -this.ePm) > this.mListView.getWidth() / 2) {
                            this.ePl.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.eOX = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.eOX = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.eOW && this.eOX) {
            this.ePm = point.x;
        }
    }

    public int s(MotionEvent motionEvent) {
        return u(motionEvent);
    }

    public int t(MotionEvent motionEvent) {
        if (this.eOV == 1) {
            return v(motionEvent);
        }
        return -1;
    }

    public int u(MotionEvent motionEvent) {
        return c(motionEvent, this.ePh);
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.ePj);
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
                        this.ePd = childAt.getLeft();
                        this.ePe = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.eOW && this.eOV == 0) {
            this.ePc = c(motionEvent, this.ePi);
        }
        this.ePa = s(motionEvent);
        if (this.ePa != -1 && this.eOT == 0) {
            z(this.ePa, ((int) motionEvent.getX()) - this.ePd, ((int) motionEvent.getY()) - this.ePe);
        }
        this.eOX = false;
        this.ePk = true;
        this.ePm = 0;
        this.ePb = t(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.ePd;
            int i2 = y2 - this.ePe;
            if (this.ePk && !this.mDragging && (this.ePa != -1 || this.ePb != -1)) {
                if (this.ePa != -1) {
                    if (this.eOT == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.eOU) {
                        z(this.ePa, i, i2);
                    } else if (this.eOT != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.eOW) {
                        this.eOX = true;
                        z(this.ePb, i, i2);
                    }
                } else if (this.ePb != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.eOW) {
                        this.eOX = true;
                        z(this.ePb, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.ePk = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.ePa != -1 && this.eOT == 2) {
            this.mListView.performHapticFeedback(0);
            z(this.ePa, this.ePf - this.ePd, this.eJv - this.ePe);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.eOW && this.eOV == 0 && this.ePc != -1) {
            this.ePl.removeItem(this.ePc - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
