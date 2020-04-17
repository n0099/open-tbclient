package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private boolean ekA;
    private GestureDetector ekB;
    private GestureDetector ekC;
    private int ekD;
    private int ekE;
    private int ekF;
    private int ekG;
    private int ekH;
    private int ekI;
    private int ekJ;
    private float ekK;
    private int ekL;
    private int ekM;
    private int ekN;
    private boolean ekO;
    private a ekP;
    private int ekQ;
    private GestureDetector.OnGestureListener ekR;
    private int ekw;
    private boolean ekx;
    private int eky;
    private boolean ekz;
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
        this.ekw = 0;
        this.ekx = true;
        this.ekz = false;
        this.ekA = false;
        this.ekD = -1;
        this.ekE = -1;
        this.ekF = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.ekK = 500.0f;
        this.ekR = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.ekz && b.this.ekA) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.ekK) {
                        if (b.this.ekQ > (-width)) {
                            b.this.ekP.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.ekK) && b.this.ekQ < width) {
                        b.this.ekP.stopDragWithVelocity(true, f);
                    }
                    b.this.ekA = false;
                }
                return false;
            }
        };
        this.ekP = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.ekB = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.ekP.isDragEnabled() || b.this.ekP.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.ekI = (int) motionEvent.getX();
                b.this.ekJ = (int) motionEvent.getY();
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
        this.ekC = new GestureDetector(listView.getContext(), this.ekR);
        this.ekC.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.ekL = i;
        this.ekM = i4;
        this.ekN = i5;
        np(i3);
        no(i2);
    }

    public GestureDetector bbE() {
        return this.ekB;
    }

    public void no(int i) {
        this.ekw = i;
    }

    public void ig(boolean z) {
        this.ekx = z;
    }

    public void np(int i) {
        this.eky = i;
    }

    public void ih(boolean z) {
        this.ekz = z;
    }

    public boolean B(int i, int i2, int i3) {
        int i4 = 0;
        if (this.ekx && !this.ekA) {
            i4 = 12;
        }
        if (this.ekz && this.ekA) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.ekP.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ekP.isDragEnabled() && !this.ekP.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.ekz && this.mDragging && this.eky == 1) {
                this.ekC.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.ekI = (int) motionEvent.getX();
                    this.ekJ = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.ekz && this.ekA) {
                        if ((this.ekQ >= 0 ? this.ekQ : -this.ekQ) > this.mListView.getWidth() / 2) {
                            this.ekP.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.ekA = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.ekA = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.ekz && this.ekA) {
            this.ekQ = point.x;
        }
    }

    public int s(MotionEvent motionEvent) {
        return u(motionEvent);
    }

    public int t(MotionEvent motionEvent) {
        if (this.eky == 1) {
            return v(motionEvent);
        }
        return -1;
    }

    public int u(MotionEvent motionEvent) {
        return c(motionEvent, this.ekL);
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.ekN);
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
                        this.ekG = childAt.getLeft();
                        this.ekH = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.ekz && this.eky == 0) {
            this.ekF = c(motionEvent, this.ekM);
        }
        this.ekD = s(motionEvent);
        if (this.ekD != -1 && this.ekw == 0) {
            B(this.ekD, ((int) motionEvent.getX()) - this.ekG, ((int) motionEvent.getY()) - this.ekH);
        }
        this.ekA = false;
        this.ekO = true;
        this.ekQ = 0;
        this.ekE = t(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.ekG;
            int i2 = y2 - this.ekH;
            if (this.ekO && !this.mDragging && (this.ekD != -1 || this.ekE != -1)) {
                if (this.ekD != -1) {
                    if (this.ekw == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.ekx) {
                        B(this.ekD, i, i2);
                    } else if (this.ekw != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.ekz) {
                        this.ekA = true;
                        B(this.ekE, i, i2);
                    }
                } else if (this.ekE != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.ekz) {
                        this.ekA = true;
                        B(this.ekE, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.ekO = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.ekD != -1 && this.ekw == 2) {
            this.mListView.performHapticFeedback(0);
            B(this.ekD, this.ekI - this.ekG, this.ekJ - this.ekH);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.ekz && this.eky == 0 && this.ekF != -1) {
            this.ekP.removeItem(this.ekF - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
