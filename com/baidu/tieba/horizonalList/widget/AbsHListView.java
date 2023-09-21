package com.baidu.tieba.horizonalList.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Checkable;
import android.widget.ListAdapter;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.EdgeEffectCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.ab8;
import com.baidu.tieba.bb8;
import com.baidu.tieba.hb8;
import com.baidu.tieba.hma;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.za8;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
@TargetApi(11)
/* loaded from: classes6.dex */
public abstract class AbsHListView extends AdapterView<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CHECK_POSITION_SEARCH_DISTANCE = 20;
    public static final int INVALID_POINTER = -1;
    public static final int LAYOUT_FORCE_LEFT = 1;
    public static final int LAYOUT_FORCE_RIGHT = 3;
    public static final int LAYOUT_MOVE_SELECTION = 6;
    public static final int LAYOUT_NORMAL = 0;
    public static final int LAYOUT_SET_SELECTION = 2;
    public static final int LAYOUT_SPECIFIC = 4;
    public static final int LAYOUT_SYNC = 5;
    public static final int OVERSCROLL_LIMIT_DIVISOR = 3;
    public static final int[] STATESET_NOTHING;
    public static final String TAG = "AbsListView";
    public static final int TOUCH_MODE_DONE_WAITING = 2;
    public static final int TOUCH_MODE_DOWN = 0;
    public static final int TOUCH_MODE_FLING = 4;
    public static final int TOUCH_MODE_OFF = 1;
    public static final int TOUCH_MODE_ON = 0;
    public static final int TOUCH_MODE_OVERFLING = 6;
    public static final int TOUCH_MODE_OVERSCROLL = 5;
    public static final int TOUCH_MODE_REST = -1;
    public static final int TOUCH_MODE_SCROLL = 3;
    public static final int TOUCH_MODE_TAP = 1;
    public static final int TOUCH_MODE_UNKNOWN = -1;
    public static final int TRANSCRIPT_MODE_ALWAYS_SCROLL = 2;
    public static final int TRANSCRIPT_MODE_DISABLED = 0;
    public static final int TRANSCRIPT_MODE_NORMAL = 1;
    public static final Interpolator sLinearInterpolator;
    public transient /* synthetic */ FieldHolder $fh;
    public h mAccessibilityDelegate;
    public int mActivePointerId;
    public ListAdapter mAdapter;
    public boolean mAdapterHasStableIds;
    public int mCacheColorHint;
    public boolean mCachingActive;
    public boolean mCachingStarted;
    public SparseArrayCompat<Boolean> mCheckStates;
    public LongSparseArray<Integer> mCheckedIdStates;
    public int mCheckedItemCount;
    public Object mChoiceActionMode;
    public int mChoiceMode;
    public Runnable mClearScrollingCache;
    public ContextMenu.ContextMenuInfo mContextMenuInfo;
    public c mDataSetObserver;
    public int mDirection;
    public boolean mDrawSelectorOnTop;
    public EdgeEffectCompat mEdgeGlowBottom;
    public EdgeEffectCompat mEdgeGlowTop;
    public boolean mFastScrollEnabled;
    public int mFirstPositionDistanceGuess;
    public g mFlingRunnable;
    public boolean mForceTranscriptScroll;
    public int mGlowPaddingBottom;
    public int mGlowPaddingTop;
    public int mHeightMeasureSpec;
    public float mHorizontalScrollFactor;
    public boolean mIsAttached;
    public boolean mIsChildViewEnabled;
    public final boolean[] mIsScrap;
    public int mLastAccessibilityScrollEventFromIndex;
    public int mLastAccessibilityScrollEventToIndex;
    public int mLastHandledItemCount;
    public int mLastPositionDistanceGuess;
    public int mLastScrollState;
    public int mLastTouchMode;
    public int mLastX;
    public int mLayoutMode;
    public Rect mListPadding;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public int mMotionCorrection;
    public int mMotionPosition;
    public int mMotionViewNewLeft;
    public int mMotionViewOriginalLeft;
    public int mMotionX;
    public int mMotionY;
    public Object mMultiChoiceModeCallback;
    public i mOnScrollListener;
    public int mOverflingDistance;
    public int mOverscrollDistance;
    public int mOverscrollMax;
    public d mPendingCheckForKeyLongPress;
    public e mPendingCheckForLongPress;
    public Runnable mPendingCheckForTap;
    public SavedState mPendingSync;
    public j mPerformClick;
    public Runnable mPositionScrollAfterLayout;
    public k mPositionScroller;
    public final l mRecycler;
    public int mResurrectToPosition;
    public View mScrollLeft;
    public View mScrollRight;
    public boolean mScrollingCacheEnabled;
    public int mSelectedLeft;
    public int mSelectionBottomPadding;
    public int mSelectionLeftPadding;
    public int mSelectionRightPadding;
    public int mSelectionTopPadding;
    public Drawable mSelector;
    public int mSelectorPosition;
    public Rect mSelectorRect;
    public boolean mSmoothScrollbarEnabled;
    public boolean mStackFromRight;
    public Rect mTouchFrame;
    public int mTouchMode;
    public Runnable mTouchModeReset;
    public int mTouchSlop;
    public int mTranscriptMode;
    public float mVelocityScale;
    public VelocityTracker mVelocityTracker;
    public za8.a mViewHelper;

    /* loaded from: classes6.dex */
    public interface i {
        void a(AbsHListView absHListView, int i, int i2, int i3);

        void b(AbsHListView absHListView, int i);
    }

    /* loaded from: classes6.dex */
    public interface m {
        void onMovedToScrapHeap(View view2);
    }

    /* loaded from: classes6.dex */
    public interface n {
        void adjustListItemSelectionBounds(Rect rect);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
        }
    }

    public abstract void fillGap(boolean z);

    public abstract int findMotionCol(int i2);

    public int getFooterViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public int getHeaderViewsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public void layoutChildren() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, editorInfo)) == null) {
            return null;
        }
        return (InputConnection) invokeL.objValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048641, this, i2, keyEvent)) == null) {
            return false;
        }
        return invokeIL.booleanValue;
    }

    public abstract void setSelectionInt(int i2);

    public void setVisibleRangeHint(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048689, this, i2, i3) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public LongSparseArray<Integer> checkIdState;
        public SparseArrayCompat<Boolean> checkState;
        public int checkedItemCount;
        public String filter;
        public long firstId;
        public boolean inActionMode;
        public int position;
        public long selectedId;
        public int viewLeft;
        public int width;

        /* loaded from: classes6.dex */
        public class a implements Parcelable.Creator<SavedState> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                    return new SavedState(parcel, null);
                }
                return (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                    return new SavedState[i];
                }
                return (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(197768376, "Lcom/baidu/tieba/horizonalList/widget/AbsHListView$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(197768376, "Lcom/baidu/tieba/horizonalList/widget/AbsHListView$SavedState;");
                    return;
                }
            }
            CREATOR = new a();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcel) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.selectedId = parcel.readLong();
            this.firstId = parcel.readLong();
            this.viewLeft = parcel.readInt();
            this.position = parcel.readInt();
            this.width = parcel.readInt();
            this.filter = parcel.readString();
            if (parcel.readByte() != 0) {
                z = true;
            } else {
                z = false;
            }
            this.inActionMode = z;
            this.checkedItemCount = parcel.readInt();
            this.checkState = readSparseBooleanArray(parcel);
            this.checkIdState = readSparseLongArray(parcel);
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Parcelable) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }

        private SparseArrayCompat<Boolean> readSparseBooleanArray(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, parcel)) == null) {
                int readInt = parcel.readInt();
                if (readInt < 0) {
                    return null;
                }
                SparseArrayCompat<Boolean> sparseArrayCompat = new SparseArrayCompat<>(readInt);
                readSparseBooleanArrayInternal(sparseArrayCompat, parcel, readInt);
                return sparseArrayCompat;
            }
            return (SparseArrayCompat) invokeL.objValue;
        }

        private LongSparseArray<Integer> readSparseLongArray(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, parcel)) == null) {
                int readInt = parcel.readInt();
                if (readInt <= 0) {
                    return null;
                }
                LongSparseArray<Integer> longSparseArray = new LongSparseArray<>(readInt);
                readSparseLongArrayInternal(longSparseArray, parcel, readInt);
                return longSparseArray;
            }
            return (LongSparseArray) invokeL.objValue;
        }

        private void readSparseBooleanArrayInternal(SparseArrayCompat<Boolean> sparseArrayCompat, Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65541, this, sparseArrayCompat, parcel, i) == null) {
                while (i > 0) {
                    int readInt = parcel.readInt();
                    boolean z = true;
                    if (parcel.readByte() != 1) {
                        z = false;
                    }
                    sparseArrayCompat.append(readInt, Boolean.valueOf(z));
                    i--;
                }
            }
        }

        private void readSparseLongArrayInternal(LongSparseArray<Integer> longSparseArray, Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(65543, this, longSparseArray, parcel, i) == null) {
                while (i > 0) {
                    longSparseArray.put(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                    i--;
                }
            }
        }

        private void writeSparseBooleanArray(SparseArrayCompat<Boolean> sparseArrayCompat, Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65544, this, sparseArrayCompat, parcel) == null) {
                if (sparseArrayCompat == null) {
                    parcel.writeInt(-1);
                    return;
                }
                int size = sparseArrayCompat.size();
                parcel.writeInt(size);
                for (int i = 0; i < size; i++) {
                    parcel.writeInt(sparseArrayCompat.keyAt(i));
                    parcel.writeByte(sparseArrayCompat.valueAt(i).booleanValue() ? (byte) 1 : (byte) 0);
                }
            }
        }

        private void writeSparseLongArray(LongSparseArray<Integer> longSparseArray, Parcel parcel) {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(65545, this, longSparseArray, parcel) == null) {
                if (longSparseArray != null) {
                    i = longSparseArray.size();
                } else {
                    i = 0;
                }
                parcel.writeInt(i);
                for (int i2 = 0; i2 < i; i2++) {
                    parcel.writeLong(longSparseArray.keyAt(i2));
                    parcel.writeInt(longSparseArray.valueAt(i2).intValue());
                }
            }
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeLong(this.selectedId);
                parcel.writeLong(this.firstId);
                parcel.writeInt(this.viewLeft);
                parcel.writeInt(this.position);
                parcel.writeInt(this.width);
                parcel.writeString(this.filter);
                parcel.writeByte(this.inActionMode ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.checkedItemCount);
                writeSparseBooleanArray(this.checkState, parcel);
                writeSparseLongArray(this.checkIdState, parcel);
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.selectedId + " firstId=" + this.firstId + " viewLeft=" + this.viewLeft + " position=" + this.position + " width=" + this.width + " filter=" + this.filter + " checkState=" + this.checkState + "}";
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final hb8 a;
        public int b;
        public final Runnable c;
        public final /* synthetic */ AbsHListView d;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public a(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
                    return;
                }
                int i = this.a.d.mActivePointerId;
                VelocityTracker velocityTracker = this.a.d.mVelocityTracker;
                hb8 hb8Var = this.a.a;
                if (velocityTracker != null && i != -1) {
                    velocityTracker.computeCurrentVelocity(1000, this.a.d.mMaximumVelocity);
                    float f = -velocityTracker.getXVelocity(i);
                    if (Math.abs(f) >= this.a.d.mMinimumVelocity && hb8Var.h(f, 0.0f)) {
                        this.a.d.postDelayed(this, 40L);
                        return;
                    }
                    this.a.c();
                    AbsHListView absHListView = this.a.d;
                    absHListView.mTouchMode = 3;
                    absHListView.reportScrollStateChange(1);
                }
            }
        }

        public g(AbsHListView absHListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = absHListView;
            this.c = new a(this);
            this.a = new hb8(absHListView.getContext());
        }

        public void e(int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
                if (i < 0) {
                    i2 = Integer.MAX_VALUE;
                } else {
                    i2 = 0;
                }
                this.b = i2;
                this.a.k(null);
                this.a.c(i2, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                AbsHListView absHListView = this.d;
                absHListView.mTouchMode = 4;
                absHListView.mViewHelper.b(this);
            }
        }

        public void f(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                this.a.k(null);
                this.a.d(this.d.getScrollX(), 0, i, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0, this.d.getWidth(), 0);
                AbsHListView absHListView = this.d;
                absHListView.mTouchMode = 6;
                absHListView.invalidate();
                this.d.mViewHelper.b(this);
            }
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.i(this.d.getScrollX(), 0, this.d.mOverflingDistance);
                int overScrollMode = this.d.getOverScrollMode();
                if (overScrollMode != 0 && (overScrollMode != 1 || this.d.contentFits())) {
                    AbsHListView absHListView = this.d;
                    absHListView.mTouchMode = -1;
                    k kVar = absHListView.mPositionScroller;
                    if (kVar != null) {
                        kVar.f();
                    }
                } else {
                    this.d.mTouchMode = 6;
                    int e = (int) this.a.e();
                    if (i > 0) {
                        this.d.mEdgeGlowTop.onAbsorb(e);
                    } else {
                        this.d.mEdgeGlowBottom.onAbsorb(e);
                    }
                }
                this.d.invalidate();
                this.d.mViewHelper.b(this);
            }
        }

        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                AbsHListView absHListView = this.d;
                absHListView.mTouchMode = -1;
                absHListView.removeCallbacks(this);
                this.d.removeCallbacks(this.c);
                this.d.reportScrollStateChange(0);
                this.d.clearScrollingCache();
                this.a.a();
                this.d.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                if (this.a.l(this.d.getScrollX(), 0, 0, 0, 0, 0)) {
                    AbsHListView absHListView = this.d;
                    absHListView.mTouchMode = 6;
                    absHListView.invalidate();
                    this.d.mViewHelper.b(this);
                    return;
                }
                AbsHListView absHListView2 = this.d;
                absHListView2.mTouchMode = -1;
                absHListView2.reportScrollStateChange(0);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.d.postDelayed(this.c, 40L);
            }
        }

        public void g(int i, int i2, boolean z) {
            int i3;
            Interpolator interpolator;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (i < 0) {
                    i3 = Integer.MAX_VALUE;
                } else {
                    i3 = 0;
                }
                this.b = i3;
                hb8 hb8Var = this.a;
                if (z) {
                    interpolator = AbsHListView.sLinearInterpolator;
                } else {
                    interpolator = null;
                }
                hb8Var.k(interpolator);
                this.a.m(i3, 0, i, 0, i2);
                AbsHListView absHListView = this.d;
                absHListView.mTouchMode = 4;
                absHListView.mViewHelper.b(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                int i2 = this.d.mTouchMode;
                boolean z2 = false;
                if (i2 != 3) {
                    if (i2 != 4) {
                        if (i2 != 6) {
                            c();
                            return;
                        }
                        hb8 hb8Var = this.a;
                        if (hb8Var.b()) {
                            int scrollX = this.d.getScrollX();
                            int f = hb8Var.f();
                            AbsHListView absHListView = this.d;
                            if (absHListView.overScrollBy(f - scrollX, 0, scrollX, 0, 0, 0, absHListView.mOverflingDistance, 0, false)) {
                                if (scrollX <= 0 && f > 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                if (scrollX >= 0 && f < 0) {
                                    z2 = true;
                                }
                                if (!z && !z2) {
                                    h();
                                    return;
                                }
                                int e = (int) hb8Var.e();
                                if (z2) {
                                    e = -e;
                                }
                                hb8Var.a();
                                e(e);
                                return;
                            }
                            this.d.invalidate();
                            this.d.mViewHelper.b(this);
                            return;
                        }
                        c();
                        return;
                    }
                } else if (this.a.g()) {
                    return;
                }
                AbsHListView absHListView2 = this.d;
                if (absHListView2.mDataChanged) {
                    absHListView2.layoutChildren();
                }
                AbsHListView absHListView3 = this.d;
                if (absHListView3.mItemCount != 0 && absHListView3.getChildCount() != 0) {
                    hb8 hb8Var2 = this.a;
                    boolean b = hb8Var2.b();
                    int f2 = hb8Var2.f();
                    int i3 = this.b - f2;
                    if (i3 > 0) {
                        AbsHListView absHListView4 = this.d;
                        absHListView4.mMotionPosition = absHListView4.mFirstPosition;
                        View childAt = absHListView4.getChildAt(0);
                        this.d.mMotionViewOriginalLeft = childAt.getLeft();
                        max = Math.min(((this.d.getWidth() - this.d.getPaddingRight()) - this.d.getPaddingLeft()) - 1, i3);
                    } else {
                        int childCount = this.d.getChildCount() - 1;
                        AbsHListView absHListView5 = this.d;
                        absHListView5.mMotionPosition = absHListView5.mFirstPosition + childCount;
                        View childAt2 = absHListView5.getChildAt(childCount);
                        this.d.mMotionViewOriginalLeft = childAt2.getLeft();
                        max = Math.max(-(((this.d.getWidth() - this.d.getPaddingRight()) - this.d.getPaddingLeft()) - 1), i3);
                    }
                    AbsHListView absHListView6 = this.d;
                    View childAt3 = absHListView6.getChildAt(absHListView6.mMotionPosition - absHListView6.mFirstPosition);
                    if (childAt3 != null) {
                        i = childAt3.getLeft();
                    } else {
                        i = 0;
                    }
                    boolean trackMotionScroll = this.d.trackMotionScroll(max, max);
                    if (trackMotionScroll && max != 0) {
                        z2 = true;
                    }
                    if (z2) {
                        if (childAt3 != null) {
                            AbsHListView absHListView7 = this.d;
                            absHListView7.overScrollBy(-(max - (childAt3.getLeft() - i)), 0, absHListView7.getScrollX(), 0, 0, 0, this.d.mOverflingDistance, 0, false);
                        }
                        if (b) {
                            b(max);
                            return;
                        }
                        return;
                    } else if (b && !z2) {
                        if (trackMotionScroll) {
                            this.d.invalidate();
                        }
                        this.b = f2;
                        this.d.mViewHelper.b(this);
                        return;
                    } else {
                        c();
                        return;
                    }
                }
                c();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public final int f;
        public int g;
        public final /* synthetic */ AbsHListView h;

        /* loaded from: classes6.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ k c;

            public a(k kVar, int i, int i2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i), Integer.valueOf(i2)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = kVar;
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.c.c(this.a, this.b);
                }
            }
        }

        /* loaded from: classes6.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ int a;
            public final /* synthetic */ int b;
            public final /* synthetic */ int c;
            public final /* synthetic */ k d;

            public b(k kVar, int i, int i2, int i3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {kVar, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i4 = newInitContext.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.d = kVar;
                this.a = i;
                this.b = i2;
                this.c = i3;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.d.e(this.a, this.b, this.c);
                }
            }
        }

        public k(AbsHListView absHListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = absHListView;
            this.f = ViewConfiguration.get(absHListView.getContext()).getScaledFadingEdgeLength();
        }

        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                f();
                int childCount = this.h.getChildCount();
                int i2 = this.h.mFirstPosition;
                int i3 = (childCount + i2) - 1;
                if (i < i2) {
                    this.a = 2;
                } else if (i > i3) {
                    this.a = 1;
                } else {
                    a(i, -1, 200);
                    return;
                }
                this.e = 200;
                this.b = i;
                this.c = -1;
                this.d = -1;
                this.h.mViewHelper.b(this);
            }
        }

        public void a(int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
                AbsHListView absHListView = this.h;
                int i5 = absHListView.mFirstPosition;
                int childCount = (absHListView.getChildCount() + i5) - 1;
                AbsHListView absHListView2 = this.h;
                int i6 = absHListView2.mListPadding.left;
                int width = absHListView2.getWidth() - this.h.mListPadding.right;
                i2 = (i2 < i5 || i2 > childCount) ? -1 : -1;
                View childAt = this.h.getChildAt(i - i5);
                int left = childAt.getLeft();
                int right = childAt.getRight();
                if (right > width) {
                    i4 = right - width;
                } else {
                    i4 = 0;
                }
                if (left < i6) {
                    i4 = left - i6;
                }
                if (i4 == 0) {
                    return;
                }
                if (i2 >= 0) {
                    View childAt2 = this.h.getChildAt(i2 - i5);
                    int left2 = childAt2.getLeft();
                    int right2 = childAt2.getRight();
                    int abs = Math.abs(i4);
                    if (i4 < 0 && right2 + abs > width) {
                        i4 = Math.max(0, right2 - width);
                    } else if (i4 > 0 && left2 - abs < i6) {
                        i4 = Math.min(0, left2 - i6);
                    }
                }
                this.h.smoothScrollBy(i4, i3);
            }
        }

        public void e(int i, int i2, int i3) {
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIII(1048580, this, i, i2, i3) == null) {
                f();
                AbsHListView absHListView = this.h;
                if (absHListView.mDataChanged) {
                    absHListView.mPositionScrollAfterLayout = new b(this, i, i2, i3);
                    return;
                }
                int childCount = absHListView.getChildCount();
                if (childCount == 0) {
                    return;
                }
                int paddingLeft = i2 + this.h.getPaddingLeft();
                int max = Math.max(0, Math.min(this.h.getCount() - 1, i));
                this.b = max;
                this.g = paddingLeft;
                this.c = -1;
                this.d = -1;
                this.a = 5;
                AbsHListView absHListView2 = this.h;
                int i5 = absHListView2.mFirstPosition;
                int i6 = (i5 + childCount) - 1;
                if (max < i5) {
                    i4 = i5 - max;
                } else if (max > i6) {
                    i4 = max - i6;
                } else {
                    this.h.smoothScrollBy(absHListView2.getChildAt(max - i5).getLeft() - paddingLeft, i3, false);
                    return;
                }
                float f = i4 / childCount;
                if (f >= 1.0f) {
                    i3 = (int) (i3 / f);
                }
                this.e = i3;
                this.d = -1;
                this.h.mViewHelper.b(this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void c(int i, int i2) {
            int i3;
            int i4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2) == null) {
                f();
                if (i2 == -1) {
                    b(i);
                    return;
                }
                AbsHListView absHListView = this.h;
                if (absHListView.mDataChanged) {
                    absHListView.mPositionScrollAfterLayout = new a(this, i, i2);
                    return;
                }
                int childCount = absHListView.getChildCount();
                if (childCount == 0) {
                    return;
                }
                AbsHListView absHListView2 = this.h;
                int i5 = absHListView2.mFirstPosition;
                int i6 = (childCount + i5) - 1;
                int max = Math.max(0, Math.min(absHListView2.getCount() - 1, i));
                if (max < i5) {
                    int i7 = i6 - i2;
                    if (i7 < 1) {
                        return;
                    }
                    i4 = (i5 - max) + 1;
                    i3 = i7 - 1;
                    if (i3 < i4) {
                        this.a = 4;
                        i4 = i3;
                        if (i4 <= 0) {
                            this.e = 200 / i4;
                        } else {
                            this.e = 200;
                        }
                        this.b = max;
                        this.c = i2;
                        this.d = -1;
                        this.h.mViewHelper.b(this);
                    }
                    this.a = 2;
                    if (i4 <= 0) {
                    }
                    this.b = max;
                    this.c = i2;
                    this.d = -1;
                    this.h.mViewHelper.b(this);
                } else if (max > i6) {
                    int i8 = i2 - i5;
                    if (i8 < 1) {
                        return;
                    }
                    i3 = (max - i6) + 1;
                    i4 = i8 - 1;
                    if (i4 < i3) {
                        this.a = 3;
                        if (i4 <= 0) {
                        }
                        this.b = max;
                        this.c = i2;
                        this.d = -1;
                        this.h.mViewHelper.b(this);
                    }
                    this.a = 1;
                    i4 = i3;
                    if (i4 <= 0) {
                    }
                    this.b = max;
                    this.c = i2;
                    this.d = -1;
                    this.h.mViewHelper.b(this);
                } else {
                    a(max, i2, 200);
                }
            }
        }

        public void d(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                e(i, i2, 200);
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.h.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                int width = this.h.getWidth();
                AbsHListView absHListView = this.h;
                int i3 = absHListView.mFirstPosition;
                int i4 = this.a;
                if (i4 != 1) {
                    int i5 = 0;
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 == 5) {
                                    if (this.d == i3) {
                                        absHListView.mViewHelper.b(this);
                                        return;
                                    }
                                    this.d = i3;
                                    int childCount = absHListView.getChildCount();
                                    int i6 = this.b;
                                    int i7 = (i3 + childCount) - 1;
                                    if (i6 < i3) {
                                        i5 = (i3 - i6) + 1;
                                    } else if (i6 > i7) {
                                        i5 = i6 - i7;
                                    }
                                    float min = Math.min(Math.abs(i5 / childCount), 1.0f);
                                    if (i6 < i3) {
                                        int i8 = (int) (this.e * min);
                                        this.h.smoothScrollBy((int) ((-this.h.getWidth()) * min), i8, true);
                                        this.h.mViewHelper.b(this);
                                        return;
                                    } else if (i6 > i7) {
                                        int i9 = (int) (this.e * min);
                                        this.h.smoothScrollBy((int) (this.h.getWidth() * min), i9, true);
                                        this.h.mViewHelper.b(this);
                                        return;
                                    } else {
                                        int left = this.h.getChildAt(i6 - i3).getLeft() - this.g;
                                        this.h.smoothScrollBy(left, (int) (this.e * (Math.abs(left) / this.h.getWidth())), true);
                                        return;
                                    }
                                }
                                return;
                            }
                            int childCount2 = absHListView.getChildCount() - 2;
                            if (childCount2 < 0) {
                                return;
                            }
                            int i10 = i3 + childCount2;
                            if (i10 == this.d) {
                                this.h.mViewHelper.b(this);
                                return;
                            }
                            View childAt = this.h.getChildAt(childCount2);
                            int width2 = childAt.getWidth();
                            int left2 = childAt.getLeft();
                            int i11 = width - left2;
                            int max = Math.max(this.h.mListPadding.left, this.f);
                            this.d = i10;
                            if (i10 > this.c) {
                                this.h.smoothScrollBy(-(i11 - max), this.e, true);
                                this.h.mViewHelper.b(this);
                                return;
                            }
                            int i12 = width - max;
                            int i13 = left2 + width2;
                            if (i12 > i13) {
                                this.h.smoothScrollBy(-(i12 - i13), this.e, true);
                                return;
                            }
                            return;
                        }
                        int childCount3 = absHListView.getChildCount();
                        if (i3 != this.c && childCount3 > 1) {
                            int i14 = childCount3 + i3;
                            AbsHListView absHListView2 = this.h;
                            if (i14 < absHListView2.mItemCount) {
                                int i15 = i3 + 1;
                                if (i15 == this.d) {
                                    absHListView2.mViewHelper.b(this);
                                    return;
                                }
                                View childAt2 = absHListView2.getChildAt(1);
                                int width3 = childAt2.getWidth();
                                int left3 = childAt2.getLeft();
                                int max2 = Math.max(this.h.mListPadding.right, this.f);
                                if (i15 < this.c) {
                                    this.h.smoothScrollBy(Math.max(0, (width3 + left3) - max2), this.e, true);
                                    this.d = i15;
                                    this.h.mViewHelper.b(this);
                                    return;
                                } else if (left3 > max2) {
                                    this.h.smoothScrollBy(left3 - max2, this.e, true);
                                    return;
                                } else {
                                    return;
                                }
                            }
                            return;
                        }
                        return;
                    } else if (i3 == this.d) {
                        absHListView.mViewHelper.b(this);
                        return;
                    } else {
                        View childAt3 = absHListView.getChildAt(0);
                        if (childAt3 == null) {
                            return;
                        }
                        int left4 = childAt3.getLeft();
                        if (i3 > 0) {
                            i2 = Math.max(this.f, this.h.mListPadding.left);
                        } else {
                            i2 = this.h.mListPadding.left;
                        }
                        this.h.smoothScrollBy(left4 - i2, this.e, true);
                        this.d = i3;
                        if (i3 > this.b) {
                            this.h.mViewHelper.b(this);
                            return;
                        }
                        return;
                    }
                }
                int childCount4 = absHListView.getChildCount() - 1;
                if (childCount4 < 0) {
                    return;
                }
                int i16 = i3 + childCount4;
                View childAt4 = this.h.getChildAt(childCount4);
                int width4 = childAt4.getWidth();
                int left5 = width - childAt4.getLeft();
                AbsHListView absHListView3 = this.h;
                if (i16 < absHListView3.mItemCount - 1) {
                    i = Math.max(absHListView3.mListPadding.right, this.f);
                } else {
                    i = absHListView3.mListPadding.right;
                }
                this.h.smoothScrollBy((width4 - left5) + i, this.e, true);
                this.d = i16;
                if (i16 < this.b) {
                    this.h.mViewHelper.b(this);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public boolean b;
        public boolean c;
        public int d;
        public long e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.a = i3;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65539, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65539, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ j b;
        public final /* synthetic */ AbsHListView c;

        public a(AbsHListView absHListView, View view2, j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView, view2, jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absHListView;
            this.a = view2;
            this.b = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.c.mTouchMode = -1;
                this.a.setPressed(false);
                this.c.setPressed(false);
                if (!this.c.mDataChanged) {
                    this.b.run();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsHListView a;

        public b(AbsHListView absHListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absHListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AbsHListView absHListView = this.a;
                if (absHListView.mCachingStarted) {
                    absHListView.mCachingActive = false;
                    absHListView.mCachingStarted = false;
                    absHListView.setChildrenDrawnWithCacheEnabled(false);
                    if ((this.a.getPersistentDrawingCache() & 2) == 0) {
                        this.a.setChildrenDrawingCacheEnabled(false);
                    }
                    if (!this.a.isAlwaysDrawnWithCacheEnabled()) {
                        this.a.invalidate();
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends AdapterView<ListAdapter>.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsHListView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(AbsHListView absHListView) {
            super(absHListView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((AdapterView) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absHListView;
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c, android.database.DataSetObserver
        public void onChanged() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onChanged();
            }
        }

        @Override // com.baidu.tieba.horizonalList.widget.AdapterView.c, android.database.DataSetObserver
        public void onInvalidated() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onInvalidated();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsHListView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(AbsHListView absHListView) {
            super(absHListView, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbsHListView) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absHListView;
        }

        public /* synthetic */ d(AbsHListView absHListView, a aVar) {
            this(absHListView);
        }

        @Override // java.lang.Runnable
        public void run() {
            AbsHListView absHListView;
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.c.isPressed() && (i = (absHListView = this.c).mSelectedPosition) >= 0) {
                View childAt = absHListView.getChildAt(i - absHListView.mFirstPosition);
                AbsHListView absHListView2 = this.c;
                if (!absHListView2.mDataChanged) {
                    if (b()) {
                        AbsHListView absHListView3 = this.c;
                        z = absHListView3.performLongPress(childAt, absHListView3.mSelectedPosition, absHListView3.mSelectedColId);
                    } else {
                        z = false;
                    }
                    if (z) {
                        this.c.setPressed(false);
                        childAt.setPressed(false);
                        return;
                    }
                    return;
                }
                absHListView2.setPressed(false);
                if (childAt != null) {
                    childAt.setPressed(false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsHListView c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(AbsHListView absHListView) {
            super(absHListView, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbsHListView) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = absHListView;
        }

        public /* synthetic */ e(AbsHListView absHListView, a aVar) {
            this(absHListView);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AbsHListView absHListView = this.c;
                View childAt = absHListView.getChildAt(absHListView.mMotionPosition - absHListView.mFirstPosition);
                if (childAt != null) {
                    AbsHListView absHListView2 = this.c;
                    int i = absHListView2.mMotionPosition;
                    long itemId = absHListView2.mAdapter.getItemId(i);
                    if (b()) {
                        AbsHListView absHListView3 = this.c;
                        if (!absHListView3.mDataChanged) {
                            z = absHListView3.performLongPress(childAt, i, itemId);
                            if (!z) {
                                AbsHListView absHListView4 = this.c;
                                absHListView4.mTouchMode = -1;
                                absHListView4.setPressed(false);
                                childAt.setPressed(false);
                                return;
                            }
                            this.c.mTouchMode = 2;
                            return;
                        }
                    }
                    z = false;
                    if (!z) {
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public final class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsHListView a;

        public f(AbsHListView absHListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absHListView;
        }

        @Override // java.lang.Runnable
        public void run() {
            Drawable current;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AbsHListView absHListView = this.a;
                if (absHListView.mTouchMode == 0) {
                    absHListView.mTouchMode = 1;
                    View childAt = absHListView.getChildAt(absHListView.mMotionPosition - absHListView.mFirstPosition);
                    if (childAt != null && !childAt.hasFocusable()) {
                        AbsHListView absHListView2 = this.a;
                        absHListView2.mLayoutMode = 0;
                        if (!absHListView2.mDataChanged) {
                            childAt.setPressed(true);
                            this.a.setPressed(true);
                            this.a.layoutChildren();
                            AbsHListView absHListView3 = this.a;
                            absHListView3.positionSelector(absHListView3.mMotionPosition, childAt);
                            this.a.refreshDrawableState();
                            int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                            boolean isLongClickable = this.a.isLongClickable();
                            Drawable drawable = this.a.mSelector;
                            if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                if (isLongClickable) {
                                    ((TransitionDrawable) current).startTransition(longPressTimeout);
                                } else {
                                    ((TransitionDrawable) current).resetTransition();
                                }
                            }
                            if (isLongClickable) {
                                if (this.a.mPendingCheckForLongPress == null) {
                                    AbsHListView absHListView4 = this.a;
                                    absHListView4.mPendingCheckForLongPress = new e(absHListView4, null);
                                }
                                this.a.mPendingCheckForLongPress.a();
                                AbsHListView absHListView5 = this.a;
                                absHListView5.postDelayed(absHListView5.mPendingCheckForLongPress, longPressTimeout);
                                return;
                            }
                            this.a.mTouchMode = 2;
                            return;
                        }
                        absHListView2.mTouchMode = 2;
                    }
                }
            }
        }
    }

    @TargetApi(14)
    /* loaded from: classes6.dex */
    public class h extends AccessibilityDelegateCompat {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AbsHListView a;

        public h(AbsHListView absHListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = absHListView;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, accessibilityNodeInfoCompat) == null) {
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                int positionForView = this.a.getPositionForView(view2);
                ListAdapter adapter = this.a.getAdapter();
                if (positionForView != -1 && adapter != null && this.a.isEnabled() && adapter.isEnabled(positionForView)) {
                    if (positionForView == this.a.getSelectedItemPosition()) {
                        accessibilityNodeInfoCompat.setSelected(true);
                        accessibilityNodeInfoCompat.addAction(8);
                    } else {
                        accessibilityNodeInfoCompat.addAction(4);
                    }
                    if (this.a.isClickable()) {
                        accessibilityNodeInfoCompat.addAction(16);
                        accessibilityNodeInfoCompat.setClickable(true);
                    }
                    if (this.a.isLongClickable()) {
                        accessibilityNodeInfoCompat.addAction(32);
                        accessibilityNodeInfoCompat.setLongClickable(true);
                    }
                }
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view2, int i, Bundle bundle) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, i, bundle)) == null) {
                if (super.performAccessibilityAction(view2, i, bundle)) {
                    return true;
                }
                int positionForView = this.a.getPositionForView(view2);
                ListAdapter adapter = this.a.getAdapter();
                if (positionForView != -1 && adapter != null && this.a.isEnabled() && adapter.isEnabled(positionForView)) {
                    long itemIdAtPosition = this.a.getItemIdAtPosition(positionForView);
                    if (i != 4) {
                        if (i != 8) {
                            if (i != 16) {
                                if (i != 32 || !this.a.isLongClickable()) {
                                    return false;
                                }
                                return this.a.performLongPress(view2, positionForView, itemIdAtPosition);
                            } else if (!this.a.isClickable()) {
                                return false;
                            } else {
                                return this.a.performItemClick(view2, positionForView, itemIdAtPosition);
                            }
                        } else if (this.a.getSelectedItemPosition() != positionForView) {
                            return false;
                        } else {
                            this.a.setSelection(-1);
                            return true;
                        }
                    } else if (this.a.getSelectedItemPosition() != positionForView) {
                        this.a.setSelection(positionForView);
                        return true;
                    }
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes6.dex */
    public class j extends o implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int c;
        public final /* synthetic */ AbsHListView d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(AbsHListView absHListView) {
            super(absHListView, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((AbsHListView) objArr2[0], (a) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = absHListView;
        }

        public /* synthetic */ j(AbsHListView absHListView, a aVar) {
            this(absHListView);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                AbsHListView absHListView = this.d;
                if (absHListView.mDataChanged) {
                    return;
                }
                ListAdapter listAdapter = absHListView.mAdapter;
                int i = this.c;
                if (listAdapter != null && absHListView.mItemCount > 0 && i != -1 && i < listAdapter.getCount() && b()) {
                    AbsHListView absHListView2 = this.d;
                    View childAt = absHListView2.getChildAt(i - absHListView2.mFirstPosition);
                    if (childAt != null) {
                        this.d.performItemClick(childAt, i, listAdapter.getItemId(i));
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class l {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public m a;
        public int b;
        public View[] c;
        public ArrayList<View>[] d;
        public int e;
        public ArrayList<View> f;
        public ArrayList<View> g;
        public SparseArrayCompat<View> h;
        public final /* synthetic */ AbsHListView i;

        public boolean q(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) ? i >= 0 : invokeI.booleanValue;
        }

        public l(AbsHListView absHListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.i = absHListView;
            this.c = new View[0];
        }

        public View h(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
                if (this.e == 1) {
                    return AbsHListView.retrieveFromScrap(this.f, i);
                }
                int itemViewType = this.i.mAdapter.getItemViewType(i);
                if (itemViewType >= 0) {
                    ArrayList<View>[] arrayListArr = this.d;
                    if (itemViewType < arrayListArr.length) {
                        return AbsHListView.retrieveFromScrap(arrayListArr[itemViewType], i);
                    }
                    return null;
                }
                return null;
            }
            return (View) invokeI.objValue;
        }

        public void p(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
                if (i >= 1) {
                    ArrayList<View>[] arrayListArr = new ArrayList[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        arrayListArr[i2] = new ArrayList<>();
                    }
                    this.e = i;
                    this.f = arrayListArr[0];
                    this.d = arrayListArr;
                    return;
                }
                throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
            }
        }

        public View g(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                int i2 = i - this.b;
                View[] viewArr = this.c;
                if (i2 < 0 || i2 >= viewArr.length) {
                    return null;
                }
                View view2 = viewArr[i2];
                viewArr[i2] = null;
                return view2;
            }
            return (View) invokeI.objValue;
        }

        public View i(int i) {
            InterceptResult invokeI;
            int indexOfKey;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
                SparseArrayCompat<View> sparseArrayCompat = this.h;
                if (sparseArrayCompat == null || (indexOfKey = sparseArrayCompat.indexOfKey(i)) < 0) {
                    return null;
                }
                View valueAt = this.h.valueAt(indexOfKey);
                this.h.removeAt(indexOfKey);
                return valueAt;
            }
            return (View) invokeI.objValue;
        }

        public void l(List<View> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
                int i = this.e;
                if (i == 1) {
                    list.addAll(this.f);
                    return;
                }
                ArrayList<View>[] arrayListArr = this.d;
                for (int i2 = 0; i2 < i; i2++) {
                    list.addAll(arrayListArr[i2]);
                }
            }
        }

        @SuppressLint({"NewApi"})
        public void c(View view2, int i) {
            LayoutParams layoutParams;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLI(1048576, this, view2, i) != null) || (layoutParams = (LayoutParams) view2.getLayoutParams()) == null) {
                return;
            }
            layoutParams.d = i;
            int i2 = layoutParams.a;
            if (q(i2)) {
                view2.onStartTemporaryDetach();
                if (this.e == 1) {
                    this.f.add(view2);
                } else {
                    this.d[i2].add(view2);
                }
                if (Build.VERSION.SDK_INT >= 14) {
                    view2.setAccessibilityDelegate(null);
                }
                m mVar = this.a;
                if (mVar != null) {
                    mVar.onMovedToScrapHeap(view2);
                }
            } else if (i2 != -2) {
                if (this.g == null) {
                    this.g = new ArrayList<>();
                }
                this.g.add(view2);
            }
        }

        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                int i = this.e;
                if (i == 1) {
                    ArrayList<View> arrayList = this.f;
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        this.i.removeDetachedView(arrayList.remove((size - 1) - i2), false);
                    }
                } else {
                    for (int i3 = 0; i3 < i; i3++) {
                        ArrayList<View> arrayList2 = this.d[i3];
                        int size2 = arrayList2.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            this.i.removeDetachedView(arrayList2.remove((size2 - 1) - i4), false);
                        }
                    }
                }
                SparseArrayCompat<View> sparseArrayCompat = this.h;
                if (sparseArrayCompat != null) {
                    sparseArrayCompat.clear();
                }
            }
        }

        public void j() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                int i = this.e;
                if (i == 1) {
                    ArrayList<View> arrayList = this.f;
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.get(i2).forceLayout();
                    }
                } else {
                    for (int i3 = 0; i3 < i; i3++) {
                        ArrayList<View> arrayList2 = this.d[i3];
                        int size2 = arrayList2.size();
                        for (int i4 = 0; i4 < size2; i4++) {
                            arrayList2.get(i4).forceLayout();
                        }
                    }
                }
                SparseArrayCompat<View> sparseArrayCompat = this.h;
                if (sparseArrayCompat != null) {
                    int size3 = sparseArrayCompat.size();
                    for (int i5 = 0; i5 < size3; i5++) {
                        this.h.valueAt(i5).forceLayout();
                    }
                }
            }
        }

        @SuppressLint({"NewApi"})
        public final void k() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                int length = this.c.length;
                int i = this.e;
                ArrayList<View>[] arrayListArr = this.d;
                for (int i2 = 0; i2 < i; i2++) {
                    ArrayList<View> arrayList = arrayListArr[i2];
                    int size = arrayList.size();
                    int i3 = size - length;
                    int i4 = size - 1;
                    int i5 = 0;
                    while (i5 < i3) {
                        this.i.removeDetachedView(arrayList.remove(i4), false);
                        i5++;
                        i4--;
                    }
                }
                if (this.h != null) {
                    for (int i6 = 0; i6 < this.h.size(); i6++) {
                        this.h.valueAt(i6);
                    }
                }
            }
        }

        public void e() {
            SparseArrayCompat<View> sparseArrayCompat;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && (sparseArrayCompat = this.h) != null) {
                sparseArrayCompat.clear();
            }
        }

        public void m() {
            ArrayList<View> arrayList;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (arrayList = this.g) == null) {
                return;
            }
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.i.removeDetachedView(this.g.get(i), false);
            }
            this.g.clear();
        }

        public void f(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048579, this, i, i2) == null) {
                if (this.c.length < i) {
                    this.c = new View[i];
                }
                this.b = i2;
                View[] viewArr = this.c;
                for (int i3 = 0; i3 < i; i3++) {
                    View childAt = this.i.getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                    if (layoutParams != null && layoutParams.a != -2) {
                        viewArr[i3] = childAt;
                    }
                }
            }
        }

        @SuppressLint({"NewApi"})
        public void n() {
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
                View[] viewArr = this.c;
                if (this.a != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.e > 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                ArrayList<View> arrayList = this.f;
                for (int length = viewArr.length - 1; length >= 0; length--) {
                    View view2 = viewArr[length];
                    if (view2 != null) {
                        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                        int i = layoutParams.a;
                        viewArr[length] = null;
                        if (q(i)) {
                            if (z2) {
                                arrayList = this.d[i];
                            }
                            view2.onStartTemporaryDetach();
                            layoutParams.d = this.b + length;
                            arrayList.add(view2);
                            if (Build.VERSION.SDK_INT >= 14) {
                                view2.setAccessibilityDelegate(null);
                            }
                            if (z) {
                                this.a.onMovedToScrapHeap(view2);
                            }
                        } else if (i != -2) {
                            this.i.removeDetachedView(view2, false);
                        }
                    }
                }
                k();
            }
        }

        public void o(int i) {
            View[] viewArr;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
                int i2 = this.e;
                if (i2 == 1) {
                    ArrayList<View> arrayList = this.f;
                    int size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        arrayList.get(i3).setDrawingCacheBackgroundColor(i);
                    }
                } else {
                    for (int i4 = 0; i4 < i2; i4++) {
                        ArrayList<View> arrayList2 = this.d[i4];
                        int size2 = arrayList2.size();
                        for (int i5 = 0; i5 < size2; i5++) {
                            arrayList2.get(i5).setDrawingCacheBackgroundColor(i);
                        }
                    }
                }
                for (View view2 : this.c) {
                    if (view2 != null) {
                        view2.setDrawingCacheBackgroundColor(i);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class o {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;
        public final /* synthetic */ AbsHListView b;

        public o(AbsHListView absHListView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {absHListView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = absHListView;
        }

        public /* synthetic */ o(AbsHListView absHListView, a aVar) {
            this(absHListView);
        }

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a = this.b.getWindowAttachCount();
            }
        }

        public boolean b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.b.hasWindowFocus() && this.b.getWindowAttachCount() == this.a) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1240653008, "Lcom/baidu/tieba/horizonalList/widget/AbsHListView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1240653008, "Lcom/baidu/tieba/horizonalList/widget/AbsHListView;");
                return;
            }
        }
        sLinearInterpolator = new LinearInterpolator();
        STATESET_NOTHING = new int[]{0};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearScrollingCache() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65562, this) == null) && !this.mViewHelper.a()) {
            if (this.mClearScrollingCache == null) {
                this.mClearScrollingCache = new b(this);
            }
            post(this.mClearScrollingCache);
        }
    }

    private void createScrollingCache() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65564, this) == null) && this.mScrollingCacheEnabled && !this.mCachingStarted && !this.mViewHelper.a()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.mCachingActive = true;
            this.mCachingStarted = true;
        }
    }

    private void finishGlows() {
        EdgeEffectCompat edgeEffectCompat;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65566, this) == null) && (edgeEffectCompat = this.mEdgeGlowTop) != null) {
            edgeEffectCompat.finish();
            this.mEdgeGlowBottom.finish();
        }
    }

    private void initOrResetVelocityTracker() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker == null) {
                this.mVelocityTracker = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
        }
    }

    private void initVelocityTrackerIfNotExists() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65570, this) == null) && this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65573, this) == null) && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private void useDefaultSelector() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65578, this) == null) {
            setSelector(getResources().getDrawable(17301602));
        }
    }

    public void clearChoices() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            SparseArrayCompat<Boolean> sparseArrayCompat = this.mCheckStates;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.clear();
            }
            LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
            this.mCheckedItemCount = 0;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.drawableStateChanged();
            updateSelectorState();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return new LayoutParams(-2, -1, 0);
        }
        return (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.mCacheColorHint;
        }
        return invokeV.intValue;
    }

    public int getCheckedItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.mCheckedItemCount;
        }
        return invokeV.intValue;
    }

    public int getCheckedItemPosition() {
        InterceptResult invokeV;
        SparseArrayCompat<Boolean> sparseArrayCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (this.mChoiceMode == 1 && (sparseArrayCompat = this.mCheckStates) != null && sparseArrayCompat.size() == 1) {
                return this.mCheckStates.keyAt(0);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public SparseArrayCompat<Boolean> getCheckedItemPositions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (this.mChoiceMode != 0) {
                return this.mCheckStates;
            }
            return null;
        }
        return (SparseArrayCompat) invokeV.objValue;
    }

    public int getChoiceMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.mChoiceMode;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.mContextMenuInfo;
        }
        return (ContextMenu.ContextMenuInfo) invokeV.objValue;
    }

    @Override // android.view.View
    public int getHorizontalScrollbarHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return super.getHorizontalScrollbarHeight();
        }
        return invokeV.intValue;
    }

    public int getListPaddingBottom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.mListPadding.bottom;
        }
        return invokeV.intValue;
    }

    public int getListPaddingLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.mListPadding.left;
        }
        return invokeV.intValue;
    }

    public int getListPaddingRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return this.mListPadding.right;
        }
        return invokeV.intValue;
    }

    public int getListPaddingTop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.mListPadding.top;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            if (this.mItemCount > 0 && (i2 = this.mSelectedPosition) >= 0) {
                return getChildAt(i2 - this.mFirstPosition);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public Drawable getSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.mSelector;
        }
        return (Drawable) invokeV.objValue;
    }

    @Override // android.view.View
    public int getSolidColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.mCacheColorHint;
        }
        return invokeV.intValue;
    }

    public int getTranscriptMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.mTranscriptMode;
        }
        return invokeV.intValue;
    }

    public void hideSelector() {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && (i2 = this.mSelectedPosition) != -1) {
            if (this.mLayoutMode != 4) {
                this.mResurrectToPosition = i2;
            }
            int i3 = this.mNextSelectedPosition;
            if (i3 >= 0 && i3 != this.mSelectedPosition) {
                this.mResurrectToPosition = i3;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectedLeft = 0;
        }
    }

    @TargetApi(11)
    public void invalidateParentIfNeeded() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048620, this) == null) && this.mViewHelper.a() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    public void invalidateViews() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.mDataChanged = true;
            rememberSyncState();
            requestLayout();
            invalidate();
        }
    }

    public void invokeOnItemScrollListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            i iVar = this.mOnScrollListener;
            if (iVar != null) {
                iVar.a(this, this.mFirstPosition, getChildCount(), this.mItemCount);
            }
            onScrollChanged(0, 0, 0, 0);
        }
    }

    @ViewDebug.ExportedProperty
    public boolean isScrollingCacheEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.mScrollingCacheEnabled;
        }
        return invokeV.booleanValue;
    }

    @ViewDebug.ExportedProperty
    public boolean isSmoothScrollbarEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.mSmoothScrollbarEnabled;
        }
        return invokeV.booleanValue;
    }

    public boolean isStackFromRight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.mStackFromRight;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    @TargetApi(11)
    public void jumpDrawablesToCurrentState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            super.jumpDrawablesToCurrentState();
            Drawable drawable = this.mSelector;
            if (drawable != null) {
                drawable.jumpToCurrentState();
            }
        }
    }

    public int reconcileSelectedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            int i2 = this.mSelectedPosition;
            if (i2 < 0) {
                i2 = this.mResurrectToPosition;
            }
            return Math.min(Math.max(0, i2), this.mItemCount - 1);
        }
        return invokeV.intValue;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048662, this) == null) && !this.mBlockLayoutRequests && !this.mInLayout) {
            super.requestLayout();
        }
    }

    public void requestLayoutIfNecessary() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048663, this) == null) && getChildCount() > 0) {
            resetList();
            requestLayout();
            invalidate();
        }
    }

    public boolean resurrectSelectionIfNeeded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            if (this.mSelectedPosition < 0 && resurrectSelection()) {
                updateSelectorState();
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean shouldShowSelector() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            if ((hasFocus() && !isInTouchMode()) || touchModeDrawsInPressedState()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean touchModeDrawsInPressedState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            int i2 = this.mTouchMode;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void updateSelectorState() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048703, this) == null) && this.mSelector != null) {
            if (shouldShowSelector()) {
                this.mSelector.setState(getDrawableState());
            } else {
                this.mSelector.setState(STATESET_NOTHING);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsHListView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new l(this);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mHeightMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedLeft = 0;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
    }

    private boolean startScrollIfNeeded(int i2) {
        InterceptResult invokeI;
        boolean z;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65576, this, i2)) == null) {
            int i4 = i2 - this.mMotionX;
            int abs = Math.abs(i4);
            if (getScrollX() != 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z && abs <= this.mTouchSlop) {
                return false;
            }
            createScrollingCache();
            if (z) {
                this.mTouchMode = 5;
                this.mMotionCorrection = 0;
            } else {
                this.mTouchMode = 3;
                if (i4 > 0) {
                    i3 = this.mTouchSlop;
                } else {
                    i3 = -this.mTouchSlop;
                }
                this.mMotionCorrection = i3;
            }
            Handler handler = getHandler();
            if (handler != null) {
                handler.removeCallbacks(this.mPendingCheckForLongPress);
            }
            setPressed(false);
            View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
            if (childAt != null) {
                childAt.setPressed(false);
            }
            reportScrollStateChange(1);
            ViewParent parent = getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            scrollIfNeeded(i2);
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, parcelable) == null) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.mDataChanged = true;
            this.mSyncWidth = savedState.width;
            long j2 = savedState.selectedId;
            if (j2 >= 0) {
                this.mNeedSync = true;
                this.mPendingSync = savedState;
                this.mSyncColId = j2;
                this.mSyncPosition = savedState.position;
                this.mSpecificLeft = savedState.viewLeft;
                this.mSyncMode = 0;
            } else if (savedState.firstId >= 0) {
                setSelectedPositionInt(-1);
                setNextSelectedPositionInt(-1);
                this.mSelectorPosition = -1;
                this.mNeedSync = true;
                this.mPendingSync = savedState;
                this.mSyncColId = savedState.firstId;
                this.mSyncPosition = savedState.position;
                this.mSpecificLeft = savedState.viewLeft;
                this.mSyncMode = 1;
            }
            SparseArrayCompat<Boolean> sparseArrayCompat = savedState.checkState;
            if (sparseArrayCompat != null) {
                this.mCheckStates = sparseArrayCompat;
            }
            LongSparseArray<Integer> longSparseArray = savedState.checkIdState;
            if (longSparseArray != null) {
                this.mCheckedIdStates = longSparseArray;
            }
            this.mCheckedItemCount = savedState.checkedItemCount;
            if (Build.VERSION.SDK_INT >= 11 && savedState.inActionMode && this.mChoiceMode == 3 && (obj = this.mMultiChoiceModeCallback) != null) {
                this.mChoiceActionMode = startActionMode((bb8) obj);
            }
            requestLayout();
        }
    }

    public void smoothScrollByOffset(int i2) {
        int i3;
        View childAt;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048695, this, i2) == null) {
            if (i2 < 0) {
                i3 = getFirstVisiblePosition();
            } else if (i2 > 0) {
                i3 = getLastVisiblePosition();
            } else {
                i3 = -1;
            }
            if (i3 > -1 && (childAt = getChildAt(i3 - getFirstVisiblePosition())) != null) {
                if (childAt.getGlobalVisibleRect(new Rect())) {
                    float width = (rect.width() * rect.height()) / (childAt.getWidth() * childAt.getHeight());
                    if (i2 < 0 && width < 0.75f) {
                        i3++;
                    } else if (i2 > 0 && width < 0.75f) {
                        i3--;
                    }
                }
                smoothScrollToPosition(Math.max(0, Math.min(getCount(), i3 + i2)));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_absHListViewStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        int i3;
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048642, this, i2, keyEvent)) == null) {
            if (i2 == 23 || i2 == 66) {
                if (!isEnabled()) {
                    return true;
                }
                if (isClickable() && isPressed() && (i3 = this.mSelectedPosition) >= 0 && (listAdapter = this.mAdapter) != null && i3 < listAdapter.getCount()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        performItemClick(childAt, this.mSelectedPosition, this.mSelectedColId);
                        childAt.setPressed(false);
                    }
                    setPressed(false);
                    return true;
                }
            }
            return super.onKeyUp(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    public void positionSelector(int i2, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048657, this, i2, view2) == null) {
            if (i2 != -1) {
                this.mSelectorPosition = i2;
            }
            Rect rect = this.mSelectorRect;
            rect.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            if (view2 instanceof n) {
                ((n) view2).adjustListItemSelectionBounds(rect);
            }
            positionSelector(rect.left, rect.top, rect.right, rect.bottom);
            boolean z = this.mIsChildViewEnabled;
            if (view2.isEnabled() != z) {
                this.mIsChildViewEnabled = !z;
                if (getSelectedItemPosition() != -1) {
                    refreshDrawableState();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbsHListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i6 = newInitContext.flag;
            if ((i6 & 1) != 0) {
                int i7 = i6 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        boolean z3 = false;
        this.mChoiceMode = 0;
        this.mLayoutMode = 0;
        this.mDrawSelectorOnTop = false;
        this.mSelectorPosition = -1;
        this.mSelectorRect = new Rect();
        this.mRecycler = new l(this);
        this.mSelectionLeftPadding = 0;
        this.mSelectionTopPadding = 0;
        this.mSelectionRightPadding = 0;
        this.mSelectionBottomPadding = 0;
        this.mListPadding = new Rect();
        this.mHeightMeasureSpec = 0;
        this.mTouchMode = -1;
        this.mSelectedLeft = 0;
        boolean z4 = true;
        this.mSmoothScrollbarEnabled = true;
        this.mResurrectToPosition = -1;
        Drawable drawable = null;
        this.mContextMenuInfo = null;
        this.mLastTouchMode = -1;
        this.mLastScrollState = 0;
        this.mVelocityScale = 1.0f;
        this.mIsScrap = new boolean[1];
        this.mActivePointerId = -1;
        this.mDirection = 0;
        initAbsListView();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, hma.HListView, i2, 0);
        if (obtainStyledAttributes != null) {
            drawable = obtainStyledAttributes.getDrawable(0);
            boolean z5 = obtainStyledAttributes.getBoolean(1, false);
            z2 = obtainStyledAttributes.getBoolean(6, false);
            boolean z6 = obtainStyledAttributes.getBoolean(2, true);
            i4 = obtainStyledAttributes.getInt(7, 0);
            i5 = obtainStyledAttributes.getColor(3, 0);
            boolean z7 = obtainStyledAttributes.getBoolean(5, true);
            int i8 = obtainStyledAttributes.getInt(4, 0);
            obtainStyledAttributes.recycle();
            i3 = i8;
            z3 = z5;
            z = z7;
            z4 = z6;
        } else {
            i3 = 0;
            z = true;
            z2 = false;
            i4 = 0;
            i5 = 0;
        }
        if (drawable != null) {
            setSelector(drawable);
        }
        this.mDrawSelectorOnTop = z3;
        setStackFromRight(z2);
        setScrollingCacheEnabled(z4);
        setTranscriptMode(i4);
        setCacheColorHint(i5);
        setSmoothScrollbarEnabled(z);
        setChoiceMode(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean performItemClick(View view2, int i2, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048653, this, new Object[]{view2, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            int i3 = this.mChoiceMode;
            boolean z2 = false;
            boolean z3 = true;
            if (i3 != 0) {
                if (i3 != 2 && (Build.VERSION.SDK_INT < 11 || i3 != 3 || this.mChoiceActionMode == null)) {
                    if (this.mChoiceMode == 1) {
                        if (!this.mCheckStates.get(i2, Boolean.FALSE).booleanValue()) {
                            this.mCheckStates.clear();
                            this.mCheckStates.put(i2, Boolean.TRUE);
                            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                                this.mCheckedIdStates.clear();
                                this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                            }
                            this.mCheckedItemCount = 1;
                        } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0).booleanValue()) {
                            this.mCheckedItemCount = 0;
                        }
                        z = true;
                    } else {
                        z = true;
                        if (z2) {
                            updateOnScreenCheckedViews();
                        }
                        z3 = z;
                        z2 = true;
                    }
                } else {
                    boolean z4 = !this.mCheckStates.get(i2, Boolean.FALSE).booleanValue();
                    this.mCheckStates.put(i2, Boolean.valueOf(z4));
                    if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                        if (z4) {
                            this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                        } else {
                            this.mCheckedIdStates.delete(this.mAdapter.getItemId(i2));
                        }
                    }
                    if (z4) {
                        this.mCheckedItemCount++;
                    } else {
                        this.mCheckedItemCount--;
                    }
                    Object obj = this.mChoiceActionMode;
                    if (obj != null) {
                        ((bb8) this.mMultiChoiceModeCallback).a((ActionMode) obj, i2, j2, z4);
                    } else {
                        z2 = true;
                    }
                    z = z2;
                }
                z2 = true;
                if (z2) {
                }
                z3 = z;
                z2 = true;
            }
            if (z3) {
                return z2 | super.performItemClick(view2, i2, j2);
            }
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    private void drawSelector(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65565, this, canvas) == null) && !this.mSelectorRect.isEmpty()) {
            Drawable drawable = this.mSelector;
            drawable.setBounds(this.mSelectorRect);
            drawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, arrayList) == null) {
            int childCount = getChildCount();
            int i2 = this.mFirstPosition;
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter == null) {
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (listAdapter.isEnabled(i2 + i3)) {
                    arrayList.add(childAt);
                }
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) {
            return layoutParams instanceof LayoutParams;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, canvas) == null) {
            boolean z = this.mDrawSelectorOnTop;
            if (!z) {
                drawSelector(canvas);
            }
            super.dispatchDraw(canvas);
            if (z) {
                drawSelector(canvas);
            }
        }
    }

    public int findClosestMotionCol(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                return -1;
            }
            int findMotionCol = findMotionCol(i2);
            if (findMotionCol == -1) {
                return (this.mFirstPosition + childCount) - 1;
            }
            return findMotionCol;
        }
        return invokeI.intValue;
    }

    @Override // android.view.View
    public void getFocusedRect(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, rect) == null) {
            View selectedView = getSelectedView();
            if (selectedView != null && selectedView.getParent() == this) {
                selectedView.getFocusedRect(rect);
                offsetDescendantRectToMyCoords(selectedView, rect);
                return;
            }
            super.getFocusedRect(rect);
        }
    }

    public boolean isItemChecked(int i2) {
        InterceptResult invokeI;
        SparseArrayCompat<Boolean> sparseArrayCompat;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            if (this.mChoiceMode != 0 && (sparseArrayCompat = this.mCheckStates) != null) {
                return sparseArrayCompat.get(i2, Boolean.FALSE).booleanValue();
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    public void offsetChildrenLeftAndRight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).offsetLeftAndRight(i2);
            }
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(AbsHListView.class.getName());
        }
    }

    public void reportScrollStateChange(int i2) {
        i iVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048660, this, i2) == null) && i2 != this.mLastScrollState && (iVar = this.mOnScrollListener) != null) {
            this.mLastScrollState = i2;
            iVar.b(this, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048661, this, z) == null) {
            if (z) {
                recycleVelocityTracker();
            }
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEvent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048667, this, i2) == null) {
            if (i2 == 4096) {
                int firstVisiblePosition = getFirstVisiblePosition();
                int lastVisiblePosition = getLastVisiblePosition();
                if (this.mLastAccessibilityScrollEventFromIndex == firstVisiblePosition && this.mLastAccessibilityScrollEventToIndex == lastVisiblePosition) {
                    return;
                }
                this.mLastAccessibilityScrollEventFromIndex = firstVisiblePosition;
                this.mLastAccessibilityScrollEventToIndex = lastVisiblePosition;
            }
            super.sendAccessibilityEvent(i2);
        }
    }

    public void setCacheColorHint(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048670, this, i2) == null) && i2 != this.mCacheColorHint) {
            this.mCacheColorHint = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.mRecycler.o(i2);
        }
    }

    public void setDrawSelectorOnTop(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048672, this, z) == null) {
            this.mDrawSelectorOnTop = z;
        }
    }

    public void setFriction(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048673, this, f2) == null) {
            if (this.mFlingRunnable == null) {
                this.mFlingRunnable = new g(this);
            }
            this.mFlingRunnable.a.j(f2);
        }
    }

    @TargetApi(11)
    public void setMultiChoiceModeListener(ab8 ab8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048675, this, ab8Var) == null) && Build.VERSION.SDK_INT >= 11) {
            if (this.mMultiChoiceModeCallback == null) {
                this.mMultiChoiceModeCallback = new bb8(this);
            }
            ((bb8) this.mMultiChoiceModeCallback).c(ab8Var);
        }
    }

    public void setOnScrollListener(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, iVar) == null) {
            this.mOnScrollListener = iVar;
            invokeOnItemScrollListener();
        }
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048678, this, i2) == null) {
            if (i2 != 2) {
                if (this.mEdgeGlowTop == null) {
                    Context context = getContext();
                    this.mEdgeGlowTop = new EdgeEffectCompat(context);
                    this.mEdgeGlowBottom = new EdgeEffectCompat(context);
                }
            } else {
                this.mEdgeGlowTop = null;
                this.mEdgeGlowBottom = null;
            }
            super.setOverScrollMode(i2);
        }
    }

    public void setRecyclerListener(m mVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048679, this, mVar) == null) {
            this.mRecycler.a = mVar;
        }
    }

    public void setScrollingCacheEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048681, this, z) == null) {
            if (this.mScrollingCacheEnabled && !z) {
                clearScrollingCache();
            }
            this.mScrollingCacheEnabled = z;
        }
    }

    public void setSelector(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i2) == null) {
            setSelector(getResources().getDrawable(i2));
        }
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048685, this, z) == null) {
            this.mSmoothScrollbarEnabled = z;
        }
    }

    public void setStackFromRight(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048686, this, z) == null) && this.mStackFromRight != z) {
            this.mStackFromRight = z;
            requestLayoutIfNecessary();
        }
    }

    public void setTranscriptMode(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i2) == null) {
            this.mTranscriptMode = i2;
        }
    }

    public void setVelocityScale(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048688, this, f2) == null) {
            this.mVelocityScale = f2;
        }
    }

    public void smoothScrollToPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i2) == null) {
            if (this.mPositionScroller == null) {
                this.mPositionScroller = new k(this);
            }
            this.mPositionScroller.b(i2);
        }
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, drawable)) == null) {
            if (this.mSelector != drawable && !super.verifyDrawable(drawable)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public long pointToColId(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048655, this, i2, i3)) == null) {
            int pointToPosition = pointToPosition(i2, i3);
            if (pointToPosition >= 0) {
                return this.mAdapter.getItemId(pointToPosition);
            }
            return Long.MIN_VALUE;
        }
        return invokeII.longValue;
    }

    public void setOverScrollEffectPadding(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048677, this, i2, i3) == null) {
            this.mGlowPaddingTop = i2;
            this.mGlowPaddingBottom = i3;
        }
    }

    public void setScrollIndicators(View view2, View view3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048680, this, view2, view3) == null) {
            this.mScrollLeft = view2;
            this.mScrollRight = view3;
        }
    }

    public void smoothScrollBy(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048693, this, i2, i3) == null) {
            smoothScrollBy(i2, i3, false);
        }
    }

    public void smoothScrollToPosition(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048697, this, i2, i3) == null) {
            if (this.mPositionScroller == null) {
                this.mPositionScroller = new k(this);
            }
            this.mPositionScroller.c(i2, i3);
        }
    }

    public void smoothScrollToPositionFromLeft(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048698, this, i2, i3) == null) {
            if (this.mPositionScroller == null) {
                this.mPositionScroller = new k(this);
            }
            this.mPositionScroller.d(i2, i3);
        }
    }

    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view2, int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view2, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            return new AdapterView.b(view2, i2, j2);
        }
        return (ContextMenu.ContextMenuInfo) invokeCommon.objValue;
    }

    public void smoothScrollToPositionFromLeft(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048699, this, i2, i3, i4) == null) {
            if (this.mPositionScroller == null) {
                this.mPositionScroller = new k(this);
            }
            this.mPositionScroller.e(i2, i3, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean contentFits() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                return true;
            }
            if (childCount == this.mItemCount && getChildAt(0).getLeft() >= this.mListPadding.left && getChildAt(childCount - 1).getRight() <= getWidth() - this.mListPadding.right) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mSmoothScrollbarEnabled) {
                int max = Math.max(this.mItemCount * 100, 0);
                if (getScrollX() != 0) {
                    return max + Math.abs((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f));
                }
                return max;
            }
            return this.mItemCount;
        }
        return invokeV.intValue;
    }

    public long[] getCheckedItemIds() {
        InterceptResult invokeV;
        LongSparseArray<Integer> longSparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mChoiceMode != 0 && (longSparseArray = this.mCheckedIdStates) != null && this.mAdapter != null) {
                int size = longSparseArray.size();
                long[] jArr = new long[size];
                for (int i2 = 0; i2 < size; i2++) {
                    jArr[i2] = longSparseArray.keyAt(i2);
                }
                return jArr;
            }
            return new long[0];
        }
        return (long[]) invokeV.objValue;
    }

    public float getHorizontalScrollFactor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.mHorizontalScrollFactor == 0.0f) {
                TypedValue typedValue = new TypedValue();
                if (getContext().getTheme().resolveAttribute(R.attr.hlv_listPreferredItemWidth, typedValue, true)) {
                    this.mHorizontalScrollFactor = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
                }
            }
            return this.mHorizontalScrollFactor;
        }
        return invokeV.floatValue;
    }

    @Override // android.view.View
    public float getLeftFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            int childCount = getChildCount();
            float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
            if (childCount == 0) {
                return leftFadingEdgeStrength;
            }
            if (this.mFirstPosition > 0) {
                return 1.0f;
            }
            int left = getChildAt(0).getLeft();
            float horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
            if (left < getPaddingLeft()) {
                return (-(left - getPaddingLeft())) / horizontalFadingEdgeLength;
            }
            return leftFadingEdgeStrength;
        }
        return invokeV.floatValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            super.onAttachedToWindow();
            getViewTreeObserver().addOnTouchModeChangeListener(this);
            if (this.mAdapter != null && this.mDataSetObserver == null) {
                c cVar = new c(this);
                this.mDataSetObserver = cVar;
                this.mAdapter.registerDataSetObserver(cVar);
                this.mDataChanged = true;
                this.mOldItemCount = this.mItemCount;
                this.mItemCount = this.mAdapter.getCount();
            }
            this.mIsAttached = true;
        }
    }

    public void resetList() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048664, this) == null) {
            removeAllViewsInLayout();
            this.mFirstPosition = 0;
            this.mDataChanged = false;
            this.mPositionScrollAfterLayout = null;
            this.mNeedSync = false;
            this.mPendingSync = null;
            this.mOldSelectedPosition = -1;
            this.mOldSelectedColId = Long.MIN_VALUE;
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.mSelectedLeft = 0;
            this.mSelectorPosition = -1;
            this.mSelectorRect.setEmpty();
            invalidate();
        }
    }

    public static int getDistance(Rect rect, Rect rect2, int i2) {
        InterceptResult invokeLLI;
        int width;
        int height;
        int width2;
        int i3;
        int height2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65567, null, rect, rect2, i2)) == null) {
            if (i2 != 1 && i2 != 2) {
                if (i2 != 17) {
                    if (i2 != 33) {
                        if (i2 != 66) {
                            if (i2 == 130) {
                                width = rect.left + (rect.width() / 2);
                                height = rect.bottom;
                                width2 = rect2.left + (rect2.width() / 2);
                                i4 = rect2.top;
                            } else {
                                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
                            }
                        } else {
                            width = rect.right;
                            height = (rect.height() / 2) + rect.top;
                            width2 = rect2.left;
                            i3 = rect2.top;
                            height2 = rect2.height() / 2;
                        }
                    } else {
                        width = rect.left + (rect.width() / 2);
                        height = rect.top;
                        width2 = rect2.left + (rect2.width() / 2);
                        i4 = rect2.bottom;
                    }
                    int i5 = width2 - width;
                    int i6 = i4 - height;
                    return (i6 * i6) + (i5 * i5);
                }
                width = rect.left;
                height = (rect.height() / 2) + rect.top;
                width2 = rect2.right;
                i3 = rect2.top;
                height2 = rect2.height() / 2;
            } else {
                width = rect.right + (rect.width() / 2);
                height = (rect.height() / 2) + rect.top;
                width2 = rect2.left + (rect2.width() / 2);
                i3 = rect2.top;
                height2 = rect2.height() / 2;
            }
            i4 = height2 + i3;
            int i52 = width2 - width;
            int i62 = i4 - height;
            return (i62 * i62) + (i52 * i52);
        }
        return invokeLLI.intValue;
    }

    private void initAbsListView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65568, this) == null) {
            setClickable(true);
            setFocusableInTouchMode(true);
            setWillNotDraw(false);
            setAlwaysDrawnWithCacheEnabled(false);
            setScrollingCacheEnabled(true);
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
            this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
            this.mOverscrollDistance = viewConfiguration.getScaledOverscrollDistance();
            this.mOverflingDistance = viewConfiguration.getScaledOverflingDistance();
            this.mViewHelper = za8.a(this);
        }
    }

    private void updateOnScreenCheckedViews() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            int i2 = this.mFirstPosition;
            int childCount = getChildCount();
            if (Build.VERSION.SDK_INT >= 11) {
                z = true;
            } else {
                z = false;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                int i4 = i2 + i3;
                if (childAt instanceof Checkable) {
                    ((Checkable) childAt).setChecked(this.mCheckStates.get(i4, Boolean.FALSE).booleanValue());
                } else if (z) {
                    childAt.setActivated(this.mCheckStates.get(i4, Boolean.FALSE).booleanValue());
                }
            }
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int childCount = getChildCount();
            if (childCount <= 0) {
                return 0;
            }
            if (!this.mSmoothScrollbarEnabled) {
                return 1;
            }
            int i2 = childCount * 100;
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                i2 += (left * 100) / width;
            }
            View childAt2 = getChildAt(childCount - 1);
            int right = childAt2.getRight();
            int width2 = childAt2.getWidth();
            if (width2 > 0) {
                return i2 - (((right - getWidth()) * 100) / width2);
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public float getRightFadingEdgeStrength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            int childCount = getChildCount();
            float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
            if (childCount == 0) {
                return rightFadingEdgeStrength;
            }
            if ((this.mFirstPosition + childCount) - 1 < this.mItemCount - 1) {
                return 1.0f;
            }
            int right = getChildAt(childCount - 1).getRight();
            int width = getWidth();
            float horizontalFadingEdgeLength = getHorizontalFadingEdgeLength();
            if (right > width - getPaddingRight()) {
                return ((right - width) + getPaddingRight()) / horizontalFadingEdgeLength;
            }
            return rightFadingEdgeStrength;
        }
        return invokeV.floatValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            super.onDetachedFromWindow();
            this.mRecycler.d();
            getViewTreeObserver().removeOnTouchModeChangeListener(this);
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter != null && (cVar = this.mDataSetObserver) != null) {
                listAdapter.unregisterDataSetObserver(cVar);
                this.mDataSetObserver = null;
            }
            g gVar = this.mFlingRunnable;
            if (gVar != null) {
                removeCallbacks(gVar);
            }
            k kVar = this.mPositionScroller;
            if (kVar != null) {
                kVar.f();
            }
            Runnable runnable = this.mClearScrollingCache;
            if (runnable != null) {
                removeCallbacks(runnable);
            }
            j jVar = this.mPerformClick;
            if (jVar != null) {
                removeCallbacks(jVar);
            }
            Runnable runnable2 = this.mTouchModeReset;
            if (runnable2 != null) {
                removeCallbacks(runnable2);
                this.mTouchModeReset = null;
            }
            this.mIsAttached = false;
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65571, this, motionEvent) == null) {
            int action = (motionEvent.getAction() & 65280) >> 8;
            if (motionEvent.getPointerId(action) == this.mActivePointerId) {
                if (action == 0) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                this.mMotionX = (int) motionEvent.getX(i2);
                this.mMotionY = (int) motionEvent.getY(i2);
                this.mMotionCorrection = 0;
                this.mActivePointerId = motionEvent.getPointerId(i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"Override"})
    public int[] onCreateDrawableState(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
            if (this.mIsChildViewEnabled) {
                return super.onCreateDrawableState(i2);
            }
            int i3 = ViewGroup.ENABLED_STATE_SET[0];
            int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
            int length = onCreateDrawableState.length - 1;
            while (true) {
                if (length >= 0) {
                    if (onCreateDrawableState[length] == i3) {
                        break;
                    }
                    length--;
                } else {
                    length = -1;
                    break;
                }
            }
            if (length >= 0) {
                System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
            }
            return onCreateDrawableState;
        }
        return (int[]) invokeI.objValue;
    }

    @Override // android.view.View
    @TargetApi(12)
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, motionEvent)) == null) {
            if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && this.mTouchMode == -1) {
                float axisValue = motionEvent.getAxisValue(10);
                if (axisValue != 0.0f) {
                    int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                    if (!trackMotionScroll(horizontalScrollFactor, horizontalScrollFactor)) {
                        return true;
                    }
                }
            }
            return super.onGenericMotionEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @SuppressLint({"Override"})
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048639, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(AbsHListView.class.getName());
            if (isEnabled()) {
                if (getFirstVisiblePosition() > 0) {
                    accessibilityNodeInfo.addAction(8192);
                }
                if (getLastVisiblePosition() < getCount() - 1) {
                    accessibilityNodeInfo.addAction(4096);
                }
            }
        }
    }

    @TargetApi(14)
    public boolean performButtonActionOnTouchDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048652, this, motionEvent)) == null) {
            if (Build.VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && showContextMenu(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, listAdapter) == null) {
            if (listAdapter != null) {
                boolean hasStableIds = this.mAdapter.hasStableIds();
                this.mAdapterHasStableIds = hasStableIds;
                if (this.mChoiceMode != 0 && hasStableIds && this.mCheckedIdStates == null) {
                    this.mCheckedIdStates = new LongSparseArray<>();
                }
            }
            SparseArrayCompat<Boolean> sparseArrayCompat = this.mCheckStates;
            if (sparseArrayCompat != null) {
                sparseArrayCompat.clear();
            }
            LongSparseArray<Integer> longSparseArray = this.mCheckedIdStates;
            if (longSparseArray != null) {
                longSparseArray.clear();
            }
        }
    }

    public void setSelector(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, drawable) == null) {
            Drawable drawable2 = this.mSelector;
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.mSelector);
            }
            this.mSelector = drawable;
            Rect rect = new Rect();
            drawable.getPadding(rect);
            this.mSelectionLeftPadding = rect.left;
            this.mSelectionTopPadding = rect.top;
            this.mSelectionRightPadding = rect.right;
            this.mSelectionBottomPadding = rect.bottom;
            drawable.setCallback(this);
            updateSelectorState();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048692, this, view2)) == null) {
            int positionForView = getPositionForView(view2);
            boolean z = false;
            if (positionForView < 0) {
                return false;
            }
            long itemId = this.mAdapter.getItemId(positionForView);
            AdapterView.e eVar = this.mOnItemLongClickListener;
            if (eVar != null) {
                z = eVar.a(this, view2, positionForView, itemId);
            }
            if (!z) {
                this.mContextMenuInfo = createContextMenuInfo(getChildAt(positionForView - this.mFirstPosition), positionForView, itemId);
                return super.showContextMenuForChild(view2);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    private void positionSelector(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(65572, this, i2, i3, i4, i5) == null) {
            this.mSelectorRect.set(i2 - this.mSelectionLeftPadding, i3 - this.mSelectionTopPadding, i4 + this.mSelectionRightPadding, i5 + this.mSelectionBottomPadding);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIII(1048648, this, i2, i3, i4, i5) == null) && getChildCount() > 0) {
            this.mDataChanged = true;
            rememberSyncState();
        }
    }

    public static View retrieveFromScrap(ArrayList<View> arrayList, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65574, null, arrayList, i2)) == null) {
            int size = arrayList.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    View view2 = arrayList.get(i3);
                    if (((LayoutParams) view2.getLayoutParams()).d == i2) {
                        arrayList.remove(i3);
                        return view2;
                    }
                }
                return arrayList.remove(size - 1);
            }
            return null;
        }
        return (View) invokeLI.objValue;
    }

    public int pointToPosition(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048656, this, i2, i3)) == null) {
            Rect rect = this.mTouchFrame;
            if (rect == null) {
                rect = new Rect();
                this.mTouchFrame = rect;
            }
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt.getVisibility() == 0) {
                    childAt.getHitRect(rect);
                    if (rect.contains(i2, i3)) {
                        return this.mFirstPosition + childCount;
                    }
                }
            }
            return -1;
        }
        return invokeII.intValue;
    }

    private void scrollIfNeeded(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int childCount;
        int i11;
        boolean z;
        VelocityTracker velocityTracker;
        ViewParent parent;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65575, this, i2) == null) {
            int i12 = i2 - this.mMotionX;
            int i13 = i12 - this.mMotionCorrection;
            int i14 = this.mLastX;
            if (i14 != Integer.MIN_VALUE) {
                i3 = i2 - i14;
            } else {
                i3 = i13;
            }
            int i15 = this.mTouchMode;
            if (i15 == 3) {
                if (i2 != this.mLastX) {
                    if (Math.abs(i12) > this.mTouchSlop && (parent = getParent()) != null) {
                        parent.requestDisallowInterceptTouchEvent(true);
                    }
                    int i16 = this.mMotionPosition;
                    if (i16 >= 0) {
                        childCount = i16 - this.mFirstPosition;
                    } else {
                        childCount = getChildCount() / 2;
                    }
                    View childAt = getChildAt(childCount);
                    if (childAt != null) {
                        i11 = childAt.getLeft();
                    } else {
                        i11 = 0;
                    }
                    if (i3 != 0) {
                        z = trackMotionScroll(i13, i3);
                    } else {
                        z = false;
                    }
                    View childAt2 = getChildAt(childCount);
                    if (childAt2 != null) {
                        int left = childAt2.getLeft();
                        if (z) {
                            int i17 = (-i3) - (left - i11);
                            overScrollBy(i17, 0, getScrollX(), 0, 0, 0, this.mOverscrollDistance, 0, true);
                            if (Math.abs(this.mOverscrollDistance) == Math.abs(getScrollX()) && (velocityTracker = this.mVelocityTracker) != null) {
                                velocityTracker.clear();
                            }
                            int overScrollMode = getOverScrollMode();
                            if (overScrollMode == 0 || (overScrollMode == 1 && !contentFits())) {
                                this.mDirection = 0;
                                this.mTouchMode = 5;
                                if (i12 > 0) {
                                    this.mEdgeGlowTop.onPull(i17 / getWidth());
                                    if (!this.mEdgeGlowBottom.isFinished()) {
                                        this.mEdgeGlowBottom.onRelease();
                                    }
                                    invalidate();
                                } else if (i12 < 0) {
                                    this.mEdgeGlowBottom.onPull(i17 / getWidth());
                                    if (!this.mEdgeGlowTop.isFinished()) {
                                        this.mEdgeGlowTop.onRelease();
                                    }
                                    invalidate();
                                }
                            }
                        }
                        this.mMotionX = i2;
                    }
                    this.mLastX = i2;
                }
            } else if (i15 == 5 && i2 != this.mLastX) {
                int scrollX = getScrollX();
                int i18 = scrollX - i3;
                if (i2 > this.mLastX) {
                    i4 = 1;
                } else {
                    i4 = -1;
                }
                if (this.mDirection == 0) {
                    this.mDirection = i4;
                }
                int i19 = -i3;
                if ((i18 < 0 && scrollX >= 0) || (i18 > 0 && scrollX <= 0)) {
                    int i20 = -scrollX;
                    i6 = i3 + i20;
                    i5 = i20;
                } else {
                    i5 = i19;
                    i6 = 0;
                }
                if (i5 != 0) {
                    i7 = i6;
                    int i21 = i5;
                    i8 = i4;
                    overScrollBy(i5, 0, getScrollX(), 0, 0, 0, this.mOverscrollDistance, 0, true);
                    int overScrollMode2 = getOverScrollMode();
                    if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !contentFits())) {
                        if (i12 > 0) {
                            this.mEdgeGlowTop.onPull(i21 / getWidth());
                            if (!this.mEdgeGlowBottom.isFinished()) {
                                this.mEdgeGlowBottom.onRelease();
                            }
                            invalidate();
                        } else if (i12 < 0) {
                            this.mEdgeGlowBottom.onPull(i21 / getWidth());
                            if (!this.mEdgeGlowTop.isFinished()) {
                                this.mEdgeGlowTop.onRelease();
                            }
                            invalidate();
                        }
                    }
                } else {
                    i7 = i6;
                    i8 = i4;
                }
                if (i7 != 0) {
                    if (getScrollX() != 0) {
                        i9 = 0;
                        this.mViewHelper.c(0);
                        invalidateParentIfNeeded();
                    } else {
                        i9 = 0;
                    }
                    trackMotionScroll(i7, i7);
                    this.mTouchMode = 3;
                    int findClosestMotionCol = findClosestMotionCol(i2);
                    this.mMotionCorrection = i9;
                    View childAt3 = getChildAt(findClosestMotionCol - this.mFirstPosition);
                    if (childAt3 != null) {
                        i10 = childAt3.getLeft();
                    } else {
                        i10 = 0;
                    }
                    this.mMotionViewOriginalLeft = i10;
                    this.mMotionX = i2;
                    this.mMotionPosition = findClosestMotionCol;
                }
                this.mLastX = i2;
                this.mDirection = i8;
            }
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.mFirstPosition;
            int childCount = getChildCount();
            int i3 = 0;
            if (i2 >= 0 && childCount > 0) {
                if (this.mSmoothScrollbarEnabled) {
                    View childAt = getChildAt(0);
                    int left = childAt.getLeft();
                    int width = childAt.getWidth();
                    if (width > 0) {
                        return Math.max(((i2 * 100) - ((left * 100) / width)) + ((int) ((getScrollX() / getWidth()) * this.mItemCount * 100.0f)), 0);
                    }
                } else {
                    int i4 = this.mItemCount;
                    if (i2 != 0) {
                        if (i2 + childCount == i4) {
                            i3 = i4;
                        } else {
                            i3 = (childCount / 2) + i2;
                        }
                    }
                    return (int) (i2 + (childCount * (i3 / i4)));
                }
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void keyPressed() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && isEnabled() && isClickable()) {
            Drawable drawable = this.mSelector;
            Rect rect = this.mSelectorRect;
            if (drawable != null) {
                if ((isFocused() || touchModeDrawsInPressedState()) && !rect.isEmpty()) {
                    View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                    if (childAt != null) {
                        if (childAt.hasFocusable()) {
                            return;
                        }
                        childAt.setPressed(true);
                    }
                    setPressed(true);
                    boolean isLongClickable = isLongClickable();
                    Drawable current = drawable.getCurrent();
                    if (current != null && (current instanceof TransitionDrawable)) {
                        if (isLongClickable) {
                            ((TransitionDrawable) current).startTransition(ViewConfiguration.getLongPressTimeout());
                        } else {
                            ((TransitionDrawable) current).resetTransition();
                        }
                    }
                    if (isLongClickable && !this.mDataChanged) {
                        if (this.mPendingCheckForKeyLongPress == null) {
                            this.mPendingCheckForKeyLongPress = new d(this, null);
                        }
                        this.mPendingCheckForKeyLongPress.a();
                        postDelayed(this.mPendingCheckForKeyLongPress, ViewConfiguration.getLongPressTimeout());
                    }
                }
            }
        }
    }

    public void updateScrollIndicators() {
        boolean z;
        boolean z2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048702, this) == null) {
            int i3 = 4;
            boolean z3 = true;
            if (this.mScrollLeft != null) {
                if (this.mFirstPosition > 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2 && getChildCount() > 0) {
                    if (getChildAt(0).getLeft() < this.mListPadding.left) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                View view2 = this.mScrollLeft;
                if (z2) {
                    i2 = 0;
                } else {
                    i2 = 4;
                }
                view2.setVisibility(i2);
            }
            if (this.mScrollRight != null) {
                int childCount = getChildCount();
                if (this.mFirstPosition + childCount < this.mItemCount) {
                    z = true;
                } else {
                    z = false;
                }
                if (!z && childCount > 0) {
                    if (getChildAt(childCount - 1).getRight() <= getRight() - this.mListPadding.right) {
                        z3 = false;
                    }
                    z = z3;
                }
                View view3 = this.mScrollRight;
                if (z) {
                    i3 = 0;
                }
                view3.setVisibility(i3);
            }
        }
    }

    public void confirmCheckedPositionsById() {
        Object obj;
        boolean z;
        Object obj2;
        Object obj3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.mCheckStates.clear();
            int i2 = 0;
            boolean z2 = false;
            while (i2 < this.mCheckedIdStates.size()) {
                long keyAt = this.mCheckedIdStates.keyAt(i2);
                int intValue = this.mCheckedIdStates.valueAt(i2).intValue();
                if (keyAt != this.mAdapter.getItemId(intValue)) {
                    int max = Math.max(0, intValue - 20);
                    int min = Math.min(intValue + 20, this.mItemCount);
                    while (true) {
                        if (max < min) {
                            if (keyAt == this.mAdapter.getItemId(max)) {
                                this.mCheckStates.put(max, Boolean.TRUE);
                                this.mCheckedIdStates.setValueAt(i2, Integer.valueOf(max));
                                z = true;
                                break;
                            }
                            max++;
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (!z) {
                        this.mCheckedIdStates.delete(keyAt);
                        i2--;
                        this.mCheckedItemCount--;
                        if (Build.VERSION.SDK_INT > 11 && (obj2 = this.mChoiceActionMode) != null && (obj3 = this.mMultiChoiceModeCallback) != null) {
                            ((bb8) obj3).a((ActionMode) obj2, intValue, keyAt, false);
                        }
                        z2 = true;
                    }
                } else {
                    this.mCheckStates.put(intValue, Boolean.TRUE);
                }
                i2++;
            }
            if (z2 && (obj = this.mChoiceActionMode) != null && Build.VERSION.SDK_INT > 11) {
                ((ActionMode) obj).invalidate();
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, canvas) == null) {
            super.draw(canvas);
            if (this.mEdgeGlowTop != null) {
                int scrollX = getScrollX();
                if (!this.mEdgeGlowTop.isFinished()) {
                    int save = canvas.save();
                    Rect rect = this.mListPadding;
                    int i2 = rect.top + this.mGlowPaddingTop;
                    int height = (getHeight() - i2) - (rect.bottom + this.mGlowPaddingBottom);
                    int min = Math.min(0, this.mFirstPositionDistanceGuess + scrollX);
                    canvas.rotate(-90.0f);
                    canvas.translate((-getHeight()) + i2, min);
                    this.mEdgeGlowTop.setSize(height, height);
                    if (this.mEdgeGlowTop.draw(canvas)) {
                        invalidate();
                    }
                    if (save >= 1 && save <= canvas.getSaveCount()) {
                        canvas.restoreToCount(save);
                    }
                }
                if (!this.mEdgeGlowBottom.isFinished()) {
                    int save2 = canvas.save();
                    Rect rect2 = this.mListPadding;
                    int i3 = rect2.left + this.mGlowPaddingTop;
                    int height2 = (getHeight() - i3) - (rect2.right + this.mGlowPaddingBottom);
                    int max = Math.max(getWidth(), scrollX + this.mLastPositionDistanceGuess);
                    canvas.rotate(90.0f);
                    canvas.translate(-i3, -max);
                    this.mEdgeGlowBottom.setSize(height2, height2);
                    if (this.mEdgeGlowBottom.draw(canvas)) {
                        invalidate();
                    }
                    if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
                        canvas.restoreToCount(save2);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, motionEvent)) == null) {
            int action = motionEvent.getAction();
            k kVar = this.mPositionScroller;
            if (kVar != null) {
                kVar.f();
            }
            if (!this.mIsAttached) {
                return false;
            }
            int i2 = action & 255;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            if (i2 == 6) {
                                onSecondaryPointerUp(motionEvent);
                            }
                        }
                    } else if (this.mTouchMode == 0) {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex == -1) {
                            this.mActivePointerId = motionEvent.getPointerId(0);
                            findPointerIndex = 0;
                        }
                        initVelocityTrackerIfNotExists();
                        this.mVelocityTracker.addMovement(motionEvent);
                        if (startScrollIfNeeded((int) motionEvent.getX(findPointerIndex))) {
                            return true;
                        }
                    }
                }
                this.mTouchMode = -1;
                this.mActivePointerId = -1;
                recycleVelocityTracker();
                reportScrollStateChange(0);
            } else {
                int i3 = this.mTouchMode;
                if (i3 != 6 && i3 != 5) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int findMotionCol = findMotionCol(x);
                    if (i3 != 4 && findMotionCol >= 0) {
                        this.mMotionViewOriginalLeft = getChildAt(findMotionCol - this.mFirstPosition).getLeft();
                        this.mMotionX = x;
                        this.mMotionY = y;
                        this.mMotionPosition = findMotionCol;
                        this.mTouchMode = 0;
                        clearScrollingCache();
                    }
                    this.mLastX = Integer.MIN_VALUE;
                    initOrResetVelocityTracker();
                    this.mVelocityTracker.addMovement(motionEvent);
                    if (i3 == 4) {
                        return true;
                    }
                } else {
                    this.mMotionCorrection = 0;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, layoutParams)) == null) {
            return new LayoutParams(layoutParams);
        }
        return (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, attributeSet)) == null) {
            return new LayoutParams(getContext(), attributeSet);
        }
        return (LayoutParams) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void handleDataChanged() {
        int i2;
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            int i3 = this.mItemCount;
            int i4 = this.mLastHandledItemCount;
            this.mLastHandledItemCount = i3;
            if (this.mChoiceMode != 0 && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
                confirmCheckedPositionsById();
            }
            this.mRecycler.e();
            int i5 = 3;
            if (i3 > 0) {
                if (this.mNeedSync) {
                    this.mNeedSync = false;
                    this.mPendingSync = null;
                    int i6 = this.mTranscriptMode;
                    if (i6 == 2) {
                        this.mLayoutMode = 3;
                        return;
                    }
                    if (i6 == 1) {
                        if (this.mForceTranscriptScroll) {
                            this.mForceTranscriptScroll = false;
                            this.mLayoutMode = 3;
                            return;
                        }
                        int childCount = getChildCount();
                        int width = getWidth() - getPaddingRight();
                        View childAt = getChildAt(childCount - 1);
                        if (childAt != null) {
                            i2 = childAt.getBottom();
                        } else {
                            i2 = width;
                        }
                        if (this.mFirstPosition + childCount >= i4 && i2 <= width) {
                            this.mLayoutMode = 3;
                            return;
                        }
                        awakenScrollBars();
                    }
                    int i7 = this.mSyncMode;
                    if (i7 != 0) {
                        if (i7 == 1) {
                            this.mLayoutMode = 5;
                            this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i3 - 1);
                            return;
                        }
                    } else if (isInTouchMode()) {
                        this.mLayoutMode = 5;
                        this.mSyncPosition = Math.min(Math.max(0, this.mSyncPosition), i3 - 1);
                        return;
                    } else {
                        int findSyncPosition = findSyncPosition();
                        if (findSyncPosition >= 0 && lookForSelectablePosition(findSyncPosition, true) == findSyncPosition) {
                            this.mSyncPosition = findSyncPosition;
                            if (this.mSyncWidth == getWidth()) {
                                this.mLayoutMode = 5;
                            } else {
                                this.mLayoutMode = 2;
                            }
                            setNextSelectedPositionInt(findSyncPosition);
                            return;
                        }
                    }
                }
                if (!isInTouchMode()) {
                    int selectedItemPosition = getSelectedItemPosition();
                    if (selectedItemPosition >= i3) {
                        selectedItemPosition = i3 - 1;
                    }
                    if (selectedItemPosition < 0) {
                        selectedItemPosition = 0;
                    }
                    int lookForSelectablePosition = lookForSelectablePosition(selectedItemPosition, true);
                    if (lookForSelectablePosition >= 0) {
                        setNextSelectedPositionInt(lookForSelectablePosition);
                        return;
                    }
                    int lookForSelectablePosition2 = lookForSelectablePosition(selectedItemPosition, false);
                    if (lookForSelectablePosition2 >= 0) {
                        setNextSelectedPositionInt(lookForSelectablePosition2);
                        return;
                    }
                } else if (this.mResurrectToPosition >= 0) {
                    return;
                }
            }
            if (!this.mStackFromRight) {
                i5 = 1;
            }
            this.mLayoutMode = i5;
            this.mSelectedPosition = -1;
            this.mSelectedColId = Long.MIN_VALUE;
            this.mNextSelectedPosition = -1;
            this.mNextSelectedColId = Long.MIN_VALUE;
            this.mNeedSync = false;
            this.mPendingSync = null;
            this.mSelectorPosition = -1;
            checkSelectionChanged();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            SavedState savedState = new SavedState(super.onSaveInstanceState());
            SavedState savedState2 = this.mPendingSync;
            if (savedState2 != null) {
                savedState.selectedId = savedState2.selectedId;
                savedState.firstId = savedState2.firstId;
                savedState.viewLeft = savedState2.viewLeft;
                savedState.position = savedState2.position;
                savedState.width = savedState2.width;
                savedState.filter = savedState2.filter;
                savedState.inActionMode = savedState2.inActionMode;
                savedState.checkedItemCount = savedState2.checkedItemCount;
                savedState.checkState = savedState2.checkState;
                savedState.checkIdState = savedState2.checkIdState;
                return savedState;
            }
            boolean z2 = true;
            if (getChildCount() > 0 && this.mItemCount > 0) {
                z = true;
            } else {
                z = false;
            }
            long selectedItemId = getSelectedItemId();
            savedState.selectedId = selectedItemId;
            savedState.width = getWidth();
            if (selectedItemId >= 0) {
                savedState.viewLeft = this.mSelectedLeft;
                savedState.position = getSelectedItemPosition();
                savedState.firstId = -1L;
            } else if (z && this.mFirstPosition > 0) {
                savedState.viewLeft = getChildAt(0).getLeft();
                int i2 = this.mFirstPosition;
                int i3 = this.mItemCount;
                if (i2 >= i3) {
                    i2 = i3 - 1;
                }
                savedState.position = i2;
                savedState.firstId = this.mAdapter.getItemId(i2);
            } else {
                savedState.viewLeft = 0;
                savedState.firstId = -1L;
                savedState.position = 0;
            }
            savedState.filter = null;
            savedState.inActionMode = (Build.VERSION.SDK_INT < 11 || this.mChoiceMode != 3 || this.mChoiceActionMode == null) ? false : false;
            SparseArrayCompat<Boolean> sparseArrayCompat = this.mCheckStates;
            if (sparseArrayCompat != null) {
                try {
                    savedState.checkState = sparseArrayCompat.m1clone();
                } catch (NoSuchMethodError e2) {
                    e2.printStackTrace();
                    savedState.checkState = new SparseArrayCompat<>();
                }
            }
            if (this.mCheckedIdStates != null) {
                LongSparseArray<Integer> longSparseArray = new LongSparseArray<>();
                int size = this.mCheckedIdStates.size();
                for (int i4 = 0; i4 < size; i4++) {
                    longSparseArray.put(this.mCheckedIdStates.keyAt(i4), this.mCheckedIdStates.valueAt(i4));
                }
                savedState.checkIdState = longSparseArray;
            }
            savedState.checkedItemCount = this.mCheckedItemCount;
            return savedState;
        }
        return (Parcelable) invokeV.objValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d7 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean resurrectSelection() {
        InterceptResult invokeV;
        int i2;
        boolean z;
        int i3;
        k kVar;
        int lookForSelectablePosition;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            int childCount = getChildCount();
            if (childCount <= 0) {
                return false;
            }
            int i4 = this.mListPadding.left;
            int right = (getRight() - getLeft()) - this.mListPadding.right;
            int i5 = this.mFirstPosition;
            int i6 = this.mResurrectToPosition;
            if (i6 >= i5 && i6 < i5 + childCount) {
                View childAt = getChildAt(i6 - i5);
                i2 = childAt.getLeft();
                int right2 = childAt.getRight();
                if (i2 < i4) {
                    i2 = i4 + getHorizontalFadingEdgeLength();
                } else if (right2 > right) {
                    i2 = (right - childAt.getMeasuredWidth()) - getHorizontalFadingEdgeLength();
                }
            } else if (i6 < i5) {
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    if (i7 < childCount) {
                        i2 = getChildAt(i7).getLeft();
                        if (i7 == 0) {
                            if (i5 > 0 || i2 < i4) {
                                i4 += getHorizontalFadingEdgeLength();
                            }
                            i8 = i2;
                        }
                        if (i2 >= i4) {
                            i6 = i7 + i5;
                            break;
                        }
                        i7++;
                    } else {
                        i2 = i8;
                        i6 = i5;
                        break;
                    }
                }
            } else {
                int i9 = this.mItemCount;
                int i10 = i5 + childCount;
                int i11 = i10 - 1;
                int i12 = childCount - 1;
                int i13 = i12;
                int i14 = 0;
                while (true) {
                    if (i13 >= 0) {
                        View childAt2 = getChildAt(i13);
                        int left = childAt2.getLeft();
                        int right3 = childAt2.getRight();
                        if (i13 == i12) {
                            if (i10 < i9 || right3 > right) {
                                right -= getHorizontalFadingEdgeLength();
                            }
                            i14 = left;
                        }
                        if (right3 <= right) {
                            i6 = i5 + i13;
                            i2 = left;
                            break;
                        }
                        i13--;
                    } else {
                        i6 = i11;
                        i2 = i14;
                        break;
                    }
                }
                z = false;
                i3 = -1;
                this.mResurrectToPosition = -1;
                removeCallbacks(this.mFlingRunnable);
                kVar = this.mPositionScroller;
                if (kVar != null) {
                    kVar.f();
                }
                this.mTouchMode = -1;
                clearScrollingCache();
                this.mSpecificLeft = i2;
                lookForSelectablePosition = lookForSelectablePosition(i6, z);
                if (lookForSelectablePosition >= i5 && lookForSelectablePosition <= getLastVisiblePosition()) {
                    this.mLayoutMode = 4;
                    updateSelectorState();
                    setSelectionInt(lookForSelectablePosition);
                    invokeOnItemScrollListener();
                    i3 = lookForSelectablePosition;
                }
                reportScrollStateChange(0);
                if (i3 >= 0) {
                    return false;
                }
                return true;
            }
            z = true;
            i3 = -1;
            this.mResurrectToPosition = -1;
            removeCallbacks(this.mFlingRunnable);
            kVar = this.mPositionScroller;
            if (kVar != null) {
            }
            this.mTouchMode = -1;
            clearScrollingCache();
            this.mSpecificLeft = i2;
            lookForSelectablePosition = lookForSelectablePosition(i6, z);
            if (lookForSelectablePosition >= i5) {
                this.mLayoutMode = 4;
                updateSelectorState();
                setSelectionInt(lookForSelectablePosition);
                invokeOnItemScrollListener();
                i3 = lookForSelectablePosition;
            }
            reportScrollStateChange(0);
            if (i3 >= 0) {
            }
        } else {
            return invokeV.booleanValue;
        }
    }

    @SuppressLint({"NewApi"})
    public View obtainView(int i2, boolean[] zArr) {
        InterceptResult invokeIL;
        View view2;
        LayoutParams layoutParams;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048630, this, i2, zArr)) == null) {
            zArr[0] = false;
            View i3 = this.mRecycler.i(i2);
            if (i3 != null) {
                return i3;
            }
            View h2 = this.mRecycler.h(i2);
            if (h2 != null) {
                view2 = this.mAdapter.getView(i2, h2, this);
                if (view2 != h2) {
                    this.mRecycler.c(h2, i2);
                    int i4 = this.mCacheColorHint;
                    if (i4 != 0) {
                        view2.setDrawingCacheBackgroundColor(i4);
                    }
                } else {
                    zArr[0] = true;
                    view2.onFinishTemporaryDetach();
                }
            } else {
                view2 = this.mAdapter.getView(i2, null, this);
                int i5 = this.mCacheColorHint;
                if (i5 != 0) {
                    view2.setDrawingCacheBackgroundColor(i5);
                }
            }
            if (this.mAdapterHasStableIds) {
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams = (LayoutParams) generateDefaultLayoutParams();
                } else if (!checkLayoutParams(layoutParams2)) {
                    layoutParams = (LayoutParams) generateLayoutParams(layoutParams2);
                } else {
                    layoutParams = (LayoutParams) layoutParams2;
                }
                layoutParams.e = this.mAdapter.getItemId(i2);
                view2.setLayoutParams(layoutParams);
            }
            if (this.mAccessibilityManager.isEnabled() && this.mAccessibilityDelegate == null) {
                this.mAccessibilityDelegate = new h(this);
            }
            return view2;
        }
        return (View) invokeIL.objValue;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048644, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            if (this.mSelector == null) {
                useDefaultSelector();
            }
            Rect rect = this.mListPadding;
            rect.left = this.mSelectionLeftPadding + getPaddingLeft();
            rect.top = this.mSelectionTopPadding + getPaddingTop();
            rect.right = this.mSelectionRightPadding + getPaddingRight();
            rect.bottom = this.mSelectionBottomPadding + getPaddingBottom();
            boolean z = true;
            if (this.mTranscriptMode == 1) {
                int childCount = getChildCount();
                int width = getWidth() - getPaddingRight();
                View childAt = getChildAt(childCount - 1);
                if (childAt != null) {
                    i4 = childAt.getRight();
                } else {
                    i4 = width;
                }
                this.mForceTranscriptScroll = (this.mFirstPosition + childCount < this.mLastHandledItemCount || i4 > width) ? false : false;
            }
        }
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        ListAdapter listAdapter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048636, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            super.onFocusChanged(z, i2, rect);
            if (z && this.mSelectedPosition < 0 && !isInTouchMode()) {
                if (!this.mIsAttached && (listAdapter = this.mAdapter) != null) {
                    this.mDataChanged = true;
                    this.mOldItemCount = this.mItemCount;
                    this.mItemCount = listAdapter.getCount();
                }
                resurrectSelection();
            }
        }
    }

    public boolean showContextMenu(float f2, float f3, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048691, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2)})) == null) {
            int pointToPosition = pointToPosition((int) f2, (int) f3);
            if (pointToPosition != -1) {
                long itemId = this.mAdapter.getItemId(pointToPosition);
                View childAt = getChildAt(pointToPosition - this.mFirstPosition);
                if (childAt != null) {
                    this.mContextMenuInfo = createContextMenuInfo(childAt, pointToPosition, itemId);
                    return super.showContextMenuForChild(this);
                }
            }
            return showContextMenu(f2, f3, i2);
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048643, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.mInLayout = true;
            if (z) {
                int childCount = getChildCount();
                for (int i6 = 0; i6 < childCount; i6++) {
                    getChildAt(i6).forceLayout();
                }
                this.mRecycler.j();
            }
            layoutChildren();
            this.mInLayout = false;
            this.mOverscrollMax = (i4 - i2) / 3;
        }
    }

    @Override // android.view.View
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048645, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && getScrollX() != i2) {
            onScrollChanged(i2, getScrollY(), getScrollX(), getScrollY());
            this.mViewHelper.c(i2);
            invalidateParentIfNeeded();
            awakenScrollBars();
        }
    }

    @Override // android.view.View
    @SuppressLint({"Override"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        boolean z;
        Drawable current;
        Runnable runnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048649, this, motionEvent)) == null) {
            int i2 = 0;
            if (!isEnabled()) {
                if (isClickable() || isLongClickable()) {
                    return true;
                }
                return false;
            }
            k kVar = this.mPositionScroller;
            if (kVar != null) {
                kVar.f();
            }
            if (!this.mIsAttached) {
                return false;
            }
            int action = motionEvent.getAction();
            initVelocityTrackerIfNotExists();
            this.mVelocityTracker.addMovement(motionEvent);
            int i3 = action & 255;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 != 5) {
                                if (i3 == 6) {
                                    onSecondaryPointerUp(motionEvent);
                                    int i4 = this.mMotionX;
                                    int pointToPosition = pointToPosition(i4, this.mMotionY);
                                    if (pointToPosition >= 0) {
                                        this.mMotionViewOriginalLeft = getChildAt(pointToPosition - this.mFirstPosition).getLeft();
                                        this.mMotionPosition = pointToPosition;
                                    }
                                    this.mLastX = i4;
                                }
                            } else {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                int x = (int) motionEvent.getX(actionIndex);
                                int y = (int) motionEvent.getY(actionIndex);
                                this.mMotionCorrection = 0;
                                this.mActivePointerId = pointerId;
                                this.mMotionX = x;
                                this.mMotionY = y;
                                int pointToPosition2 = pointToPosition(x, y);
                                if (pointToPosition2 >= 0) {
                                    this.mMotionViewOriginalLeft = getChildAt(pointToPosition2 - this.mFirstPosition).getLeft();
                                    this.mMotionPosition = pointToPosition2;
                                }
                                this.mLastX = x;
                            }
                        } else {
                            int i5 = this.mTouchMode;
                            if (i5 != 5) {
                                if (i5 != 6) {
                                    this.mTouchMode = -1;
                                    setPressed(false);
                                    View childAt = getChildAt(this.mMotionPosition - this.mFirstPosition);
                                    if (childAt != null) {
                                        childAt.setPressed(false);
                                    }
                                    clearScrollingCache();
                                    Handler handler = getHandler();
                                    if (handler != null) {
                                        handler.removeCallbacks(this.mPendingCheckForLongPress);
                                    }
                                    recycleVelocityTracker();
                                }
                            } else {
                                if (this.mFlingRunnable == null) {
                                    this.mFlingRunnable = new g(this);
                                }
                                this.mFlingRunnable.h();
                            }
                            EdgeEffectCompat edgeEffectCompat = this.mEdgeGlowTop;
                            if (edgeEffectCompat != null) {
                                edgeEffectCompat.onRelease();
                                this.mEdgeGlowBottom.onRelease();
                            }
                            this.mActivePointerId = -1;
                        }
                    } else {
                        int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                        if (findPointerIndex == -1) {
                            this.mActivePointerId = motionEvent.getPointerId(0);
                        } else {
                            i2 = findPointerIndex;
                        }
                        int x2 = (int) motionEvent.getX(i2);
                        if (this.mDataChanged) {
                            layoutChildren();
                        }
                        int i6 = this.mTouchMode;
                        if (i6 != 0 && i6 != 1 && i6 != 2) {
                            if (i6 == 3 || i6 == 5) {
                                scrollIfNeeded(x2);
                            }
                        } else {
                            startScrollIfNeeded(x2);
                        }
                    }
                } else {
                    int i7 = this.mTouchMode;
                    if (i7 != 0 && i7 != 1 && i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                if (this.mFlingRunnable == null) {
                                    this.mFlingRunnable = new g(this);
                                }
                                VelocityTracker velocityTracker = this.mVelocityTracker;
                                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                int xVelocity = (int) velocityTracker.getXVelocity(this.mActivePointerId);
                                reportScrollStateChange(2);
                                if (Math.abs(xVelocity) > this.mMinimumVelocity) {
                                    this.mFlingRunnable.f(-xVelocity);
                                } else {
                                    this.mFlingRunnable.h();
                                }
                            }
                        } else {
                            int childCount = getChildCount();
                            if (childCount > 0) {
                                int left = getChildAt(0).getLeft();
                                int right = getChildAt(childCount - 1).getRight();
                                int i8 = this.mListPadding.left;
                                int width = getWidth() - this.mListPadding.right;
                                int i9 = this.mFirstPosition;
                                if (i9 == 0 && left >= i8 && i9 + childCount < this.mItemCount && right <= getWidth() - width) {
                                    this.mTouchMode = -1;
                                    reportScrollStateChange(0);
                                } else {
                                    VelocityTracker velocityTracker2 = this.mVelocityTracker;
                                    velocityTracker2.computeCurrentVelocity(1000, this.mMaximumVelocity);
                                    int xVelocity2 = (int) (velocityTracker2.getXVelocity(this.mActivePointerId) * this.mVelocityScale);
                                    if (Math.abs(xVelocity2) > this.mMinimumVelocity && ((this.mFirstPosition != 0 || left != i8 - this.mOverscrollDistance) && (this.mFirstPosition + childCount != this.mItemCount || right != width + this.mOverscrollDistance))) {
                                        if (this.mFlingRunnable == null) {
                                            this.mFlingRunnable = new g(this);
                                        }
                                        reportScrollStateChange(2);
                                        this.mFlingRunnable.e(-xVelocity2);
                                    } else {
                                        this.mTouchMode = -1;
                                        reportScrollStateChange(0);
                                        g gVar = this.mFlingRunnable;
                                        if (gVar != null) {
                                            gVar.c();
                                        }
                                        k kVar2 = this.mPositionScroller;
                                        if (kVar2 != null) {
                                            kVar2.f();
                                        }
                                    }
                                }
                            } else {
                                this.mTouchMode = -1;
                                reportScrollStateChange(0);
                            }
                        }
                    } else {
                        int i10 = this.mMotionPosition;
                        View childAt2 = getChildAt(i10 - this.mFirstPosition);
                        float x3 = motionEvent.getX();
                        if (x3 > this.mListPadding.left && x3 < getWidth() - this.mListPadding.right) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (childAt2 != null && !childAt2.hasFocusable() && z) {
                            if (this.mTouchMode != 0) {
                                childAt2.setPressed(false);
                            }
                            if (this.mPerformClick == null) {
                                this.mPerformClick = new j(this, null);
                            }
                            j jVar = this.mPerformClick;
                            jVar.c = i10;
                            jVar.a();
                            this.mResurrectToPosition = i10;
                            int i11 = this.mTouchMode;
                            if (i11 != 0 && i11 != 1) {
                                if (!this.mDataChanged && this.mAdapter.isEnabled(i10)) {
                                    jVar.run();
                                }
                            } else {
                                Handler handler2 = getHandler();
                                if (handler2 != null) {
                                    if (this.mTouchMode == 0) {
                                        runnable = this.mPendingCheckForTap;
                                    } else {
                                        runnable = this.mPendingCheckForLongPress;
                                    }
                                    handler2.removeCallbacks(runnable);
                                }
                                this.mLayoutMode = 0;
                                if (!this.mDataChanged && this.mAdapter.isEnabled(i10)) {
                                    this.mTouchMode = 1;
                                    setSelectedPositionInt(this.mMotionPosition);
                                    layoutChildren();
                                    childAt2.setPressed(true);
                                    positionSelector(this.mMotionPosition, childAt2);
                                    setPressed(true);
                                    Drawable drawable = this.mSelector;
                                    if (drawable != null && (current = drawable.getCurrent()) != null && (current instanceof TransitionDrawable)) {
                                        ((TransitionDrawable) current).resetTransition();
                                    }
                                    Runnable runnable2 = this.mTouchModeReset;
                                    if (runnable2 != null) {
                                        removeCallbacks(runnable2);
                                    }
                                    a aVar = new a(this, childAt2, jVar);
                                    this.mTouchModeReset = aVar;
                                    postDelayed(aVar, ViewConfiguration.getPressedStateDuration());
                                } else {
                                    this.mTouchMode = -1;
                                    updateSelectorState();
                                }
                                return true;
                            }
                        }
                        this.mTouchMode = -1;
                        updateSelectorState();
                    }
                    setPressed(false);
                    EdgeEffectCompat edgeEffectCompat2 = this.mEdgeGlowTop;
                    if (edgeEffectCompat2 != null) {
                        edgeEffectCompat2.onRelease();
                        this.mEdgeGlowBottom.onRelease();
                    }
                    invalidate();
                    Handler handler3 = getHandler();
                    if (handler3 != null) {
                        handler3.removeCallbacks(this.mPendingCheckForLongPress);
                    }
                    recycleVelocityTracker();
                    this.mActivePointerId = -1;
                }
            } else {
                if (this.mTouchMode != 6) {
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    int x4 = (int) motionEvent.getX();
                    int y2 = (int) motionEvent.getY();
                    int pointToPosition3 = pointToPosition(x4, y2);
                    if (!this.mDataChanged) {
                        if (this.mTouchMode != 4 && pointToPosition3 >= 0 && getAdapter().isEnabled(pointToPosition3)) {
                            this.mTouchMode = 0;
                            if (this.mPendingCheckForTap == null) {
                                this.mPendingCheckForTap = new f(this);
                            }
                            postDelayed(this.mPendingCheckForTap, ViewConfiguration.getTapTimeout());
                        } else if (this.mTouchMode == 4) {
                            createScrollingCache();
                            this.mTouchMode = 3;
                            this.mMotionCorrection = 0;
                            pointToPosition3 = findMotionCol(x4);
                            this.mFlingRunnable.d();
                        }
                    }
                    if (pointToPosition3 >= 0) {
                        this.mMotionViewOriginalLeft = getChildAt(pointToPosition3 - this.mFirstPosition).getLeft();
                    }
                    this.mMotionX = x4;
                    this.mMotionY = y2;
                    this.mMotionPosition = pointToPosition3;
                    this.mLastX = Integer.MIN_VALUE;
                } else {
                    this.mFlingRunnable.c();
                    k kVar3 = this.mPositionScroller;
                    if (kVar3 != null) {
                        kVar3.f();
                    }
                    this.mTouchMode = 5;
                    this.mMotionY = (int) motionEvent.getY();
                    int x5 = (int) motionEvent.getX();
                    this.mLastX = x5;
                    this.mMotionX = x5;
                    this.mMotionCorrection = 0;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    this.mDirection = 0;
                }
                if (performButtonActionOnTouchDown(motionEvent) && this.mTouchMode == 0) {
                    removeCallbacks(this.mPendingCheckForTap);
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ViewTreeObserver.OnTouchModeChangeListener
    public void onTouchModeChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048650, this, z) == null) {
            if (z) {
                hideSelector();
                if (getWidth() > 0 && getChildCount() > 0) {
                    layoutChildren();
                }
                updateSelectorState();
                return;
            }
            int i2 = this.mTouchMode;
            if (i2 == 5 || i2 == 6) {
                g gVar = this.mFlingRunnable;
                if (gVar != null) {
                    gVar.c();
                }
                k kVar = this.mPositionScroller;
                if (kVar != null) {
                    kVar.f();
                }
                if (getScrollX() != 0) {
                    this.mViewHelper.c(0);
                    finishGlows();
                    invalidate();
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048651, this, z) == null) {
            super.onWindowFocusChanged(z);
            int i2 = !isInTouchMode();
            if (!z) {
                setChildrenDrawingCacheEnabled(false);
                g gVar = this.mFlingRunnable;
                if (gVar != null) {
                    removeCallbacks(gVar);
                    this.mFlingRunnable.c();
                    k kVar = this.mPositionScroller;
                    if (kVar != null) {
                        kVar.f();
                    }
                    if (getScrollX() != 0) {
                        this.mViewHelper.c(0);
                        finishGlows();
                        invalidate();
                    }
                }
                if (i2 == 1) {
                    this.mResurrectToPosition = this.mSelectedPosition;
                }
            } else {
                int i3 = this.mLastTouchMode;
                if (i2 != i3 && i3 != -1) {
                    if (i2 == 1) {
                        resurrectSelection();
                    } else {
                        hideSelector();
                        this.mLayoutMode = 0;
                        layoutChildren();
                    }
                }
            }
            this.mLastTouchMode = i2;
        }
    }

    @SuppressLint({"NewApi"})
    public void reclaimViews(List<View> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048658, this, list) == null) {
            int childCount = getChildCount();
            m mVar = this.mRecycler.a;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && this.mRecycler.q(layoutParams.a)) {
                    list.add(childAt);
                    if (Build.VERSION.SDK_INT >= 14) {
                        childAt.setAccessibilityDelegate(null);
                    }
                    if (mVar != null) {
                        mVar.onMovedToScrapHeap(childAt);
                    }
                }
            }
            this.mRecycler.l(list);
            removeAllViewsInLayout();
        }
    }

    @TargetApi(11)
    public void setChoiceMode(int i2) {
        ListAdapter listAdapter;
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i2) == null) {
            this.mChoiceMode = i2;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 11 && (obj = this.mChoiceActionMode) != null) {
                if (i3 >= 11) {
                    ((ActionMode) obj).finish();
                }
                this.mChoiceActionMode = null;
            }
            if (this.mChoiceMode != 0) {
                if (this.mCheckStates == null) {
                    this.mCheckStates = new SparseArrayCompat<>();
                }
                if (this.mCheckedIdStates == null && (listAdapter = this.mAdapter) != null && listAdapter.hasStableIds()) {
                    this.mCheckedIdStates = new LongSparseArray<>();
                }
                if (Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3) {
                    clearChoices();
                    setLongClickable(true);
                }
            }
        }
    }

    public boolean performLongPress(View view2, int i2, long j2) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{view2, Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            if (Build.VERSION.SDK_INT >= 11 && this.mChoiceMode == 3) {
                if (this.mChoiceActionMode == null) {
                    ActionMode startActionMode = startActionMode((bb8) this.mMultiChoiceModeCallback);
                    this.mChoiceActionMode = startActionMode;
                    if (startActionMode != null) {
                        setItemChecked(i2, true);
                        performHapticFeedback(0);
                    }
                }
                return true;
            }
            AdapterView.e eVar = this.mOnItemLongClickListener;
            if (eVar != null) {
                z = eVar.a(this, view2, i2, j2);
            } else {
                z = false;
            }
            if (!z) {
                this.mContextMenuInfo = createContextMenuInfo(view2, i2, j2);
                z = super.showContextMenuForChild(this);
            }
            if (z) {
                performHapticFeedback(0);
            }
            return z;
        }
        return invokeCommon.booleanValue;
    }

    public void smoothScrollBy(int i2, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048694, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            if (this.mFlingRunnable == null) {
                this.mFlingRunnable = new g(this);
            }
            int i4 = this.mFirstPosition;
            int childCount = getChildCount();
            int i5 = i4 + childCount;
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            if (i2 != 0 && this.mItemCount != 0 && childCount != 0 && ((i4 != 0 || getChildAt(0).getLeft() != paddingLeft || i2 >= 0) && (i5 != this.mItemCount || getChildAt(childCount - 1).getRight() != width || i2 <= 0))) {
                reportScrollStateChange(2);
                this.mFlingRunnable.g(i2, i3, z);
                return;
            }
            this.mFlingRunnable.c();
            k kVar = this.mPositionScroller;
            if (kVar != null) {
                kVar.f();
            }
        }
    }

    public void setItemChecked(int i2, boolean z) {
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048674, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) != null) || (i3 = this.mChoiceMode) == 0) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 11 && z && i3 == 3 && this.mChoiceActionMode == null) {
            Object obj = this.mMultiChoiceModeCallback;
            if (obj != null && ((bb8) obj).b()) {
                this.mChoiceActionMode = startActionMode((bb8) this.mMultiChoiceModeCallback);
            } else {
                throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
            }
        }
        int i4 = this.mChoiceMode;
        if (i4 != 2 && (Build.VERSION.SDK_INT < 11 || i4 != 3)) {
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z || isItemChecked(i2)) {
                this.mCheckStates.clear();
                if (z2) {
                    this.mCheckedIdStates.clear();
                }
            }
            if (z) {
                this.mCheckStates.put(i2, Boolean.TRUE);
                if (z2) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                }
                this.mCheckedItemCount = 1;
            } else if (this.mCheckStates.size() == 0 || !this.mCheckStates.valueAt(0).booleanValue()) {
                this.mCheckedItemCount = 0;
            }
        } else {
            boolean booleanValue = this.mCheckStates.get(i2, Boolean.FALSE).booleanValue();
            this.mCheckStates.put(i2, Boolean.valueOf(z));
            if (this.mCheckedIdStates != null && this.mAdapter.hasStableIds()) {
                if (z) {
                    this.mCheckedIdStates.put(this.mAdapter.getItemId(i2), Integer.valueOf(i2));
                } else {
                    this.mCheckedIdStates.delete(this.mAdapter.getItemId(i2));
                }
            }
            if (booleanValue != z) {
                if (z) {
                    this.mCheckedItemCount++;
                } else {
                    this.mCheckedItemCount--;
                }
            }
            if (this.mChoiceActionMode != null) {
                ((bb8) this.mMultiChoiceModeCallback).a((ActionMode) this.mChoiceActionMode, i2, this.mAdapter.getItemId(i2), z);
            }
        }
        if (!this.mInLayout && !this.mBlockLayoutRequests) {
            this.mDataChanged = true;
            rememberSyncState();
            requestLayout();
        }
    }

    public boolean trackMotionScroll(int i2, int i3) {
        InterceptResult invokeII;
        int min;
        int min2;
        boolean z;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        int i6;
        int i7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048701, this, i2, i3)) == null) {
            int childCount = getChildCount();
            if (childCount == 0) {
                return true;
            }
            int left = getChildAt(0).getLeft();
            int i8 = childCount - 1;
            int right = getChildAt(i8).getRight();
            Rect rect = this.mListPadding;
            int i9 = 0 - left;
            int width = right - (getWidth() - 0);
            int width2 = (getWidth() - getPaddingRight()) - getPaddingLeft();
            if (i2 < 0) {
                min = Math.max(-(width2 - 1), i2);
            } else {
                min = Math.min(width2 - 1, i2);
            }
            if (i3 < 0) {
                min2 = Math.max(-(width2 - 1), i3);
            } else {
                min2 = Math.min(width2 - 1, i3);
            }
            int i10 = this.mFirstPosition;
            if (i10 == 0) {
                this.mFirstPositionDistanceGuess = left - rect.left;
            } else {
                this.mFirstPositionDistanceGuess += min2;
            }
            int i11 = i10 + childCount;
            if (i11 == this.mItemCount) {
                this.mLastPositionDistanceGuess = rect.right + right;
            } else {
                this.mLastPositionDistanceGuess += min2;
            }
            if (i10 == 0 && left >= rect.left && min2 >= 0) {
                z = true;
            } else {
                z = false;
            }
            if (i11 == this.mItemCount && right <= getWidth() - rect.right && min2 <= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z && !z2) {
                if (min2 < 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                boolean isInTouchMode = isInTouchMode();
                if (isInTouchMode) {
                    hideSelector();
                }
                int headerViewsCount = getHeaderViewsCount();
                int footerViewsCount = this.mItemCount - getFooterViewsCount();
                if (z3) {
                    int i12 = -min2;
                    int i13 = 0;
                    i5 = 0;
                    while (i13 < childCount) {
                        View childAt = getChildAt(i13);
                        if (childAt.getRight() >= i12) {
                            break;
                        }
                        i5++;
                        int i14 = i10 + i13;
                        if (i14 >= headerViewsCount && i14 < footerViewsCount) {
                            i7 = childCount;
                            this.mRecycler.c(childAt, i14);
                        } else {
                            i7 = childCount;
                        }
                        i13++;
                        childCount = i7;
                    }
                    i4 = 0;
                } else {
                    int width3 = getWidth() - min2;
                    i4 = 0;
                    i5 = 0;
                    while (i8 >= 0) {
                        View childAt2 = getChildAt(i8);
                        if (childAt2.getLeft() <= width3) {
                            break;
                        }
                        i5++;
                        int i15 = i10 + i8;
                        if (i15 >= headerViewsCount && i15 < footerViewsCount) {
                            this.mRecycler.c(childAt2, i15);
                        }
                        int i16 = i8;
                        i8--;
                        i4 = i16;
                    }
                }
                this.mMotionViewNewLeft = this.mMotionViewOriginalLeft + min;
                this.mBlockLayoutRequests = true;
                if (i5 > 0) {
                    detachViewsFromParent(i4, i5);
                    this.mRecycler.m();
                }
                if (!awakenScrollBars()) {
                    invalidate();
                }
                offsetChildrenLeftAndRight(min2);
                if (z3) {
                    this.mFirstPosition += i5;
                }
                int abs = Math.abs(min2);
                if (i9 < abs || width < abs) {
                    fillGap(z3);
                }
                if (!isInTouchMode && (i6 = this.mSelectedPosition) != -1) {
                    int i17 = i6 - this.mFirstPosition;
                    if (i17 >= 0 && i17 < getChildCount()) {
                        positionSelector(this.mSelectedPosition, getChildAt(i17));
                    }
                } else {
                    int i18 = this.mSelectorPosition;
                    if (i18 != -1) {
                        int i19 = i18 - this.mFirstPosition;
                        if (i19 >= 0 && i19 < getChildCount()) {
                            positionSelector(-1, getChildAt(i19));
                        }
                    } else {
                        this.mSelectorRect.setEmpty();
                    }
                }
                this.mBlockLayoutRequests = false;
                invokeOnItemScrollListener();
                return false;
            } else if (min2 != 0) {
                return true;
            } else {
                return false;
            }
        }
        return invokeII.booleanValue;
    }
}
