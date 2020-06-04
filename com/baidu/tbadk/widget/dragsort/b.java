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
    private int ezB;
    private int ezC;
    private int ezD;
    private int ezE;
    private float ezF;
    private int ezG;
    private int ezH;
    private int ezI;
    private boolean ezJ;
    private a ezK;
    private int ezL;
    private GestureDetector.OnGestureListener ezM;
    private int ezr;
    private boolean ezs;
    private int ezt;
    private boolean ezu;
    private boolean ezv;
    private GestureDetector ezw;
    private GestureDetector ezx;
    private int ezy;
    private int ezz;
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
        this.ezr = 0;
        this.ezs = true;
        this.ezu = false;
        this.ezv = false;
        this.ezy = -1;
        this.ezz = -1;
        this.ezA = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.ezF = 500.0f;
        this.ezM = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.ezu && b.this.ezv) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.ezF) {
                        if (b.this.ezL > (-width)) {
                            b.this.ezK.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.ezF) && b.this.ezL < width) {
                        b.this.ezK.stopDragWithVelocity(true, f);
                    }
                    b.this.ezv = false;
                }
                return false;
            }
        };
        this.ezK = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.ezw = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.ezK.isDragEnabled() || b.this.ezK.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.ezD = (int) motionEvent.getX();
                b.this.ezE = (int) motionEvent.getY();
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
        this.ezx = new GestureDetector(listView.getContext(), this.ezM);
        this.ezx.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.ezG = i;
        this.ezH = i4;
        this.ezI = i5;
        nU(i3);
        nT(i2);
    }

    public GestureDetector bhP() {
        return this.ezw;
    }

    public void nT(int i) {
        this.ezr = i;
    }

    public void iD(boolean z) {
        this.ezs = z;
    }

    public void nU(int i) {
        this.ezt = i;
    }

    public void iE(boolean z) {
        this.ezu = z;
    }

    public boolean A(int i, int i2, int i3) {
        int i4 = 0;
        if (this.ezs && !this.ezv) {
            i4 = 12;
        }
        if (this.ezu && this.ezv) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.ezK.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ezK.isDragEnabled() && !this.ezK.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.ezu && this.mDragging && this.ezt == 1) {
                this.ezx.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.ezD = (int) motionEvent.getX();
                    this.ezE = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.ezu && this.ezv) {
                        if ((this.ezL >= 0 ? this.ezL : -this.ezL) > this.mListView.getWidth() / 2) {
                            this.ezK.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.ezv = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.ezv = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.ezu && this.ezv) {
            this.ezL = point.x;
        }
    }

    public int s(MotionEvent motionEvent) {
        return u(motionEvent);
    }

    public int t(MotionEvent motionEvent) {
        if (this.ezt == 1) {
            return v(motionEvent);
        }
        return -1;
    }

    public int u(MotionEvent motionEvent) {
        return c(motionEvent, this.ezG);
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.ezI);
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
                        this.ezB = childAt.getLeft();
                        this.ezC = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.ezu && this.ezt == 0) {
            this.ezA = c(motionEvent, this.ezH);
        }
        this.ezy = s(motionEvent);
        if (this.ezy != -1 && this.ezr == 0) {
            A(this.ezy, ((int) motionEvent.getX()) - this.ezB, ((int) motionEvent.getY()) - this.ezC);
        }
        this.ezv = false;
        this.ezJ = true;
        this.ezL = 0;
        this.ezz = t(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.ezB;
            int i2 = y2 - this.ezC;
            if (this.ezJ && !this.mDragging && (this.ezy != -1 || this.ezz != -1)) {
                if (this.ezy != -1) {
                    if (this.ezr == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.ezs) {
                        A(this.ezy, i, i2);
                    } else if (this.ezr != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.ezu) {
                        this.ezv = true;
                        A(this.ezz, i, i2);
                    }
                } else if (this.ezz != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.ezu) {
                        this.ezv = true;
                        A(this.ezz, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.ezJ = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.ezy != -1 && this.ezr == 2) {
            this.mListView.performHapticFeedback(0);
            A(this.ezy, this.ezD - this.ezB, this.ezE - this.ezC);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.ezu && this.ezt == 0 && this.ezA != -1) {
            this.ezK.removeItem(this.ezA - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
