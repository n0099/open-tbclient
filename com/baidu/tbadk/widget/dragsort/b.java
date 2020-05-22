package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int ezA;
    private GestureDetector.OnGestureListener ezB;
    private int ezg;
    private boolean ezh;
    private int ezi;
    private boolean ezj;
    private boolean ezk;
    private GestureDetector ezl;
    private GestureDetector ezm;
    private int ezn;
    private int ezo;
    private int ezp;
    private int ezq;
    private int ezr;
    private int ezs;
    private int ezt;
    private float ezu;
    private int ezv;
    private int ezw;
    private int ezx;
    private boolean ezy;
    private a ezz;
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
        this.ezg = 0;
        this.ezh = true;
        this.ezj = false;
        this.ezk = false;
        this.ezn = -1;
        this.ezo = -1;
        this.ezp = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.ezu = 500.0f;
        this.ezB = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.ezj && b.this.ezk) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.ezu) {
                        if (b.this.ezA > (-width)) {
                            b.this.ezz.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.ezu) && b.this.ezA < width) {
                        b.this.ezz.stopDragWithVelocity(true, f);
                    }
                    b.this.ezk = false;
                }
                return false;
            }
        };
        this.ezz = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.ezl = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.ezz.isDragEnabled() || b.this.ezz.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.ezs = (int) motionEvent.getX();
                b.this.ezt = (int) motionEvent.getY();
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
        this.ezm = new GestureDetector(listView.getContext(), this.ezB);
        this.ezm.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.ezv = i;
        this.ezw = i4;
        this.ezx = i5;
        nS(i3);
        nR(i2);
    }

    public GestureDetector bhN() {
        return this.ezl;
    }

    public void nR(int i) {
        this.ezg = i;
    }

    public void iD(boolean z) {
        this.ezh = z;
    }

    public void nS(int i) {
        this.ezi = i;
    }

    public void iE(boolean z) {
        this.ezj = z;
    }

    public boolean A(int i, int i2, int i3) {
        int i4 = 0;
        if (this.ezh && !this.ezk) {
            i4 = 12;
        }
        if (this.ezj && this.ezk) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.ezz.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ezz.isDragEnabled() && !this.ezz.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.ezj && this.mDragging && this.ezi == 1) {
                this.ezm.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.ezs = (int) motionEvent.getX();
                    this.ezt = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.ezj && this.ezk) {
                        if ((this.ezA >= 0 ? this.ezA : -this.ezA) > this.mListView.getWidth() / 2) {
                            this.ezz.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.ezk = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.ezk = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.ezj && this.ezk) {
            this.ezA = point.x;
        }
    }

    public int s(MotionEvent motionEvent) {
        return u(motionEvent);
    }

    public int t(MotionEvent motionEvent) {
        if (this.ezi == 1) {
            return v(motionEvent);
        }
        return -1;
    }

    public int u(MotionEvent motionEvent) {
        return c(motionEvent, this.ezv);
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.ezx);
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
                        this.ezq = childAt.getLeft();
                        this.ezr = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.ezj && this.ezi == 0) {
            this.ezp = c(motionEvent, this.ezw);
        }
        this.ezn = s(motionEvent);
        if (this.ezn != -1 && this.ezg == 0) {
            A(this.ezn, ((int) motionEvent.getX()) - this.ezq, ((int) motionEvent.getY()) - this.ezr);
        }
        this.ezk = false;
        this.ezy = true;
        this.ezA = 0;
        this.ezo = t(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.ezq;
            int i2 = y2 - this.ezr;
            if (this.ezy && !this.mDragging && (this.ezn != -1 || this.ezo != -1)) {
                if (this.ezn != -1) {
                    if (this.ezg == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.ezh) {
                        A(this.ezn, i, i2);
                    } else if (this.ezg != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.ezj) {
                        this.ezk = true;
                        A(this.ezo, i, i2);
                    }
                } else if (this.ezo != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.ezj) {
                        this.ezk = true;
                        A(this.ezo, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.ezy = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.ezn != -1 && this.ezg == 2) {
            this.mListView.performHapticFeedback(0);
            A(this.ezn, this.ezs - this.ezq, this.ezt - this.ezr);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.ezj && this.ezi == 0 && this.ezp != -1) {
            this.ezz.removeItem(this.ezp - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
