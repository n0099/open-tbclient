package com.baidu.tbadk.widget.dragsort;

import android.graphics.Point;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ListView;
/* loaded from: classes.dex */
public class b extends e implements GestureDetector.OnGestureListener, View.OnTouchListener {
    private int ekB;
    private boolean ekC;
    private int ekD;
    private boolean ekE;
    private boolean ekF;
    private GestureDetector ekG;
    private GestureDetector ekH;
    private int ekI;
    private int ekJ;
    private int ekK;
    private int ekL;
    private int ekM;
    private int ekN;
    private int ekO;
    private float ekP;
    private int ekQ;
    private int ekR;
    private int ekS;
    private boolean ekT;
    private a ekU;
    private int ekV;
    private GestureDetector.OnGestureListener ekW;
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
        this.ekB = 0;
        this.ekC = true;
        this.ekE = false;
        this.ekF = false;
        this.ekI = -1;
        this.ekJ = -1;
        this.ekK = -1;
        this.mTempLoc = new int[2];
        this.mDragging = false;
        this.ekP = 500.0f;
        this.ekW = new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (b.this.ekE && b.this.ekF) {
                    int width = b.this.mListView.getWidth() / 5;
                    if (f > b.this.ekP) {
                        if (b.this.ekV > (-width)) {
                            b.this.ekU.stopDragWithVelocity(true, f);
                        }
                    } else if (f < (-b.this.ekP) && b.this.ekV < width) {
                        b.this.ekU.stopDragWithVelocity(true, f);
                    }
                    b.this.ekF = false;
                }
                return false;
            }
        };
        this.ekU = aVar;
        this.mListView = listView;
        this.mDetector = new GestureDetector(listView.getContext(), this);
        this.ekG = new GestureDetector(listView.getContext(), new GestureDetector.OnGestureListener() { // from class: com.baidu.tbadk.widget.dragsort.b.1
            @Override // android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (!b.this.ekU.isDragEnabled() || b.this.ekU.listViewIntercepted()) {
                    return false;
                }
                b.this.onDown(motionEvent);
                b.this.ekN = (int) motionEvent.getX();
                b.this.ekO = (int) motionEvent.getY();
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
        this.ekH = new GestureDetector(listView.getContext(), this.ekW);
        this.ekH.setIsLongpressEnabled(false);
        this.mTouchSlop = ViewConfiguration.get(listView.getContext()).getScaledTouchSlop();
        this.ekQ = i;
        this.ekR = i4;
        this.ekS = i5;
        np(i3);
        no(i2);
    }

    public GestureDetector bbC() {
        return this.ekG;
    }

    public void no(int i) {
        this.ekB = i;
    }

    public void ig(boolean z) {
        this.ekC = z;
    }

    public void np(int i) {
        this.ekD = i;
    }

    public void ih(boolean z) {
        this.ekE = z;
    }

    public boolean B(int i, int i2, int i3) {
        int i4 = 0;
        if (this.ekC && !this.ekF) {
            i4 = 12;
        }
        if (this.ekE && this.ekF) {
            i4 = i4 | 1 | 2;
        }
        this.mDragging = this.ekU.startDrag(i - this.mListView.getHeaderViewsCount(), i4, i2, i3);
        return this.mDragging;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.ekU.isDragEnabled() && !this.ekU.listViewIntercepted()) {
            this.mDetector.onTouchEvent(motionEvent);
            if (this.ekE && this.mDragging && this.ekD == 1) {
                this.ekH.onTouchEvent(motionEvent);
            }
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.ekN = (int) motionEvent.getX();
                    this.ekO = (int) motionEvent.getY();
                    break;
                case 1:
                    if (this.ekE && this.ekF) {
                        if ((this.ekV >= 0 ? this.ekV : -this.ekV) > this.mListView.getWidth() / 2) {
                            this.ekU.stopDragWithVelocity(true, 0.0f);
                        }
                    }
                    this.ekF = false;
                    this.mDragging = false;
                    break;
                case 3:
                    this.ekF = false;
                    this.mDragging = false;
                    break;
            }
        }
        return false;
    }

    @Override // com.baidu.tbadk.widget.dragsort.e, com.baidu.tbadk.widget.dragsort.a.h
    public void b(View view, Point point, Point point2) {
        if (this.ekE && this.ekF) {
            this.ekV = point.x;
        }
    }

    public int s(MotionEvent motionEvent) {
        return u(motionEvent);
    }

    public int t(MotionEvent motionEvent) {
        if (this.ekD == 1) {
            return v(motionEvent);
        }
        return -1;
    }

    public int u(MotionEvent motionEvent) {
        return c(motionEvent, this.ekQ);
    }

    public int v(MotionEvent motionEvent) {
        return c(motionEvent, this.ekS);
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
                        this.ekL = childAt.getLeft();
                        this.ekM = childAt.getTop();
                        return pointToPosition;
                    }
                }
            }
        }
        return -1;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        if (this.ekE && this.ekD == 0) {
            this.ekK = c(motionEvent, this.ekR);
        }
        this.ekI = s(motionEvent);
        if (this.ekI != -1 && this.ekB == 0) {
            B(this.ekI, ((int) motionEvent.getX()) - this.ekL, ((int) motionEvent.getY()) - this.ekM);
        }
        this.ekF = false;
        this.ekT = true;
        this.ekV = 0;
        this.ekJ = t(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null && motionEvent2 != null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int x2 = (int) motionEvent2.getX();
            int y2 = (int) motionEvent2.getY();
            int i = x2 - this.ekL;
            int i2 = y2 - this.ekM;
            if (this.ekT && !this.mDragging && (this.ekI != -1 || this.ekJ != -1)) {
                if (this.ekI != -1) {
                    if (this.ekB == 1 && Math.abs(y2 - y) > this.mTouchSlop && this.ekC) {
                        B(this.ekI, i, i2);
                    } else if (this.ekB != 0 && Math.abs(x2 - x) > this.mTouchSlop && this.ekE) {
                        this.ekF = true;
                        B(this.ekJ, i, i2);
                    }
                } else if (this.ekJ != -1) {
                    if (Math.abs(x2 - x) > this.mTouchSlop && this.ekE) {
                        this.ekF = true;
                        B(this.ekJ, i, i2);
                    } else if (Math.abs(y2 - y) > this.mTouchSlop) {
                        this.ekT = false;
                    }
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.ekI != -1 && this.ekB == 2) {
            this.mListView.performHapticFeedback(0);
            B(this.ekI, this.ekN - this.ekL, this.ekO - this.ekM);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.ekE && this.ekD == 0 && this.ekK != -1) {
            this.ekU.removeItem(this.ekK - this.mListView.getHeaderViewsCount());
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }
}
