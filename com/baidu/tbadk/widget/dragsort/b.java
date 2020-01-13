package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int dFX;
    private boolean dFY;
    private int dFZ;
    private boolean dGa;
    private boolean dGb;
    private GestureDetector dGc;
    private GestureDetector dGd;
    private int dGe;
    private int dGf;
    private int dGg;
    private int dGh;
    private int dGi;
    private int dGj;
    private int dGk;
    private float dGl;
    private int dGm;
    private int dGn;
    private int dGo;
    private boolean dGp;
    private a dGq;
    private int dGr;
    private GestureDetector.OnGestureListener dGs;
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
        this.dFX = 0;
        this.dFY = true;
        this.dGa = false;
        this.dGb = false;
        this.dGe = -1;
        this.dGf = -1;
        this.dGg = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.dGl = 500.0f;
        this.dGs = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.dGa && b.this.dGb) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.dGl) {
                        if (b.this.dGr > (-width)) {
                            b.this.dGq.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.dGl) && b.this.dGr < width) {
                        b.this.dGq.stopDragWithVelocity(true, f);
                    }
                    b.this.dGb = false;
                }
                return false;
            }
        };
        this.dGq = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.dGc = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.dGq.isDragEnabled() || b.this.dGq.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.dGj = (int) motionEvent.getX();
                b.this.dGk = (int) motionEvent.getY();
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
        this.dGd = new GestureDetector(listView.getContext(), this.dGs);
        this.dGd.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.dGm = i;
        this.dGn = i4;
        this.dGo = i5;
        mK(i3);
        mJ(i2);
    }

    public GestureDetector aQW() {
        return this.dGc;
    }

    public void mJ(int i) {
        this.dFX = i;
    }

    public void ha(boolean z) {
        this.dFY = z;
    }

    public void mK(int i) {
        this.dFZ = i;
    }

    public void hb(boolean z) {
        this.dGa = z;
    }

    public boolean y(int i, int i2, int i3) {
        int i4 = 0;
        if (this.dFY && !this.dGb) {
            i4 = 12;
        }
        if (this.dGa && this.dGb) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.dGq.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.dGq.isDragEnabled() && !this.dGq.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.dGa && this.mDragging && this.dFZ == 1) {
                this.dGd.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.dGj = (int) motionEvent.getX();
                    this.dGk = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.dGa && this.dGb) {
                        if ((this.dGr >= 0 ? this.dGr : -this.dGr) > this.mListView.getWidth() / 2) {
                            this.dGq.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.dGb = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.dGb = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.dGa && this.dGb) {
            this.dGr = point.x;
        }
    }

    public int t(MotionEvent motionEvent) {
        return v(motionEvent);
    }

    public int u(MotionEvent motionEvent) {
        if (this.dFZ == 1) {
            return w(motionEvent);
        }
        return -1;
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.dGm);
    }

    public int w(MotionEvent motionEvent) {
        return c(motionEvent, this.dGo);
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
                        this.dGh = childAt.getLeft();
                        this.dGi = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.dGa && this.dFZ == 0) {
            this.dGg = c(motionEvent, this.dGn);
        }
        this.dGe = t(motionEvent);
        if (this.dGe != -1 && this.dFX == 0) {
            y(this.dGe, ((int) motionEvent.getX()) - this.dGh, ((int) motionEvent.getY()) - this.dGi);
        }
        this.dGb = false;
        this.dGp = true;
        this.dGr = 0;
        this.dGf = u(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.dGh;
            int i2 = y2 - this.dGi;
            if (this.dGp && !this.mDragging && (this.dGe != -1 || this.dGf != -1)) {
                if (this.dGe != -1) {
                    if (this.dFX == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.dFY) {
                        y(this.dGe, i, i2);
                    } else if (this.dFX != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.dGa) {
                        this.dGb = true;
                        y(this.dGf, i, i2);
                    }
                } else if (this.dGf != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.dGa) {
                        this.dGb = true;
                        y(this.dGf, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.dGp = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.dGe != -1 && this.dFX == 2) {
            this.mListView.performHapticFeedback(0);
            y(this.dGe, this.dGj - this.dGh, this.dGk - this.dGi);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.dGa && this.dFZ == 0 && this.dGg != -1) {
            this.dGq.removeItem(this.dGg - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
