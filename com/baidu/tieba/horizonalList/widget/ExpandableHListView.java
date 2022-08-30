package com.baidu.tieba.horizonalList.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ExpandableListAdapter;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
import com.baidu.tieba.s47;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ExpandableHListView extends HListView {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] A;
    public static final int[] v;
    public static final int[] w;
    public static final int[] x;
    public static final int[] y;
    public static final int[][] z;
    public transient /* synthetic */ FieldHolder $fh;
    public ExpandableHListConnector a;
    public ExpandableListAdapter b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public Drawable i;
    public Drawable j;
    public Drawable k;
    public final Rect l;
    public final Rect m;
    public int n;
    public int o;
    public int p;
    public int q;
    public e r;
    public f s;
    public d t;
    public c u;

    /* loaded from: classes4.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<ExpandableHListConnector.GroupMetadata> expandedGroupMetadataList;

        /* loaded from: classes4.dex */
        public static class a implements Parcelable.Creator<SavedState> {
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
                return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new SavedState(parcel, (a) null) : (SavedState) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? new SavedState[i] : (SavedState[]) invokeI.objValue;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-863763246, "Lcom/baidu/tieba/horizonalList/widget/ExpandableHListView$SavedState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-863763246, "Lcom/baidu/tieba/horizonalList/widget/ExpandableHListView$SavedState;");
                    return;
                }
            }
            CREATOR = new a();
        }

        public /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i) == null) {
                super.writeToParcel(parcel, i);
                parcel.writeList(this.expandedGroupMetadataList);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcelable parcelable, ArrayList<ExpandableHListConnector.GroupMetadata> arrayList) {
            super(parcelable);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcelable, arrayList};
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
            this.expandedGroupMetadataList = arrayList;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel parcel) {
            super(parcel);
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
            ArrayList<ExpandableHListConnector.GroupMetadata> arrayList = new ArrayList<>();
            this.expandedGroupMetadataList = arrayList;
            parcel.readList(arrayList, ExpandableHListConnector.class.getClassLoader());
        }
    }

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public static class b implements ContextMenu.ContextMenuInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        public b(View view2, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view2, int i, int i2, long j);
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a(ExpandableHListView expandableHListView, View view2, int i, long j);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1363777782, "Lcom/baidu/tieba/horizonalList/widget/ExpandableHListView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1363777782, "Lcom/baidu/tieba/horizonalList/widget/ExpandableHListView;");
                return;
            }
        }
        int[] iArr = new int[0];
        v = iArr;
        int[] iArr2 = {16842920};
        w = iArr2;
        int[] iArr3 = {16842921};
        x = iArr3;
        int[] iArr4 = {16842920, 16842921};
        y = iArr4;
        z = new int[][]{iArr, iArr2, iArr3, iArr4};
        A = new int[]{16842918};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandableHListView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static int f(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j)) == null) {
            if (j != 4294967295L && (j & Long.MIN_VALUE) == Long.MIN_VALUE) {
                return (int) (j & 4294967295L);
            }
            return -1;
        }
        return invokeJ.intValue;
    }

    public static int g(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65541, null, j)) == null) {
            if (j == 4294967295L) {
                return -1;
            }
            return (int) ((j & 9223372032559808512L) >> 32);
        }
        return invokeJ.intValue;
    }

    public static int h(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65542, null, j)) == null) {
            if (j == 4294967295L) {
                return 2;
            }
            return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
        }
        return invokeJ.intValue;
    }

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? i + getHeaderViewsCount() : invokeI.intValue;
    }

    public final long b(s47 s47Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, s47Var)) == null) {
            if (s47Var.d == 1) {
                return this.b.getChildId(s47Var.a, s47Var.b);
            }
            return this.b.getGroupId(s47Var.a);
        }
        return invokeL.longValue;
    }

    public long c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (j(i)) {
                return 4294967295L;
            }
            ExpandableHListConnector.b i2 = this.a.i(d(i));
            long a2 = i2.a.a();
            i2.d();
            return a2;
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (j(i)) {
                return new AdapterView.b(view2, i, j);
            }
            ExpandableHListConnector.b i2 = this.a.i(d(i));
            s47 s47Var = i2.a;
            long b2 = b(s47Var);
            long a2 = s47Var.a();
            i2.d();
            return new b(view2, a2, b2);
        }
        return (ContextMenu.ContextMenuInfo) invokeCommon.objValue;
    }

    public final int d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? i - getHeaderViewsCount() : invokeI.intValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.j == null && this.i == null) {
                return;
            }
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            int i = -4;
            Rect rect = this.l;
            int childCount = getChildCount();
            int i2 = 0;
            int i3 = this.mFirstPosition - headerViewsCount;
            while (i2 < childCount) {
                if (i3 >= 0) {
                    if (i3 > footerViewsCount) {
                        return;
                    }
                    View childAt = getChildAt(i2);
                    int left = childAt.getLeft();
                    int right2 = childAt.getRight();
                    if (right2 >= 0 && left <= right) {
                        ExpandableHListConnector.b i4 = this.a.i(i3);
                        int i5 = i4.a.d;
                        if (i5 != i) {
                            if (i5 == 1) {
                                rect.top = childAt.getTop() + this.g;
                                rect.bottom = childAt.getBottom() + this.g;
                            } else {
                                rect.top = childAt.getTop() + this.c;
                                rect.bottom = childAt.getBottom() + this.c;
                            }
                            i = i4.a.d;
                        }
                        if (rect.top != rect.bottom) {
                            if (i4.a.d == 1) {
                                int i6 = this.h;
                                rect.left = left + i6;
                                rect.right = right2 + i6;
                            } else {
                                int i7 = this.d;
                                rect.left = left + i7;
                                rect.right = right2 + i7;
                            }
                            Drawable e2 = e(i4);
                            if (e2 != null) {
                                if (i4.a.d == 1) {
                                    Gravity.apply(this.f, this.p, this.q, rect, this.m);
                                } else {
                                    Gravity.apply(this.e, this.n, this.o, rect, this.m);
                                }
                                e2.setBounds(this.m);
                                e2.draw(canvas);
                            }
                        }
                        i4.d();
                    }
                }
                i2++;
                i3++;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0026, code lost:
        if (r1.lastChildFlPos != r1.flPos) goto L12;
     */
    @Override // com.baidu.tieba.horizonalList.widget.HListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void drawDivider(Canvas canvas, Rect rect, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, canvas, rect, i) == null) {
            int i2 = i + this.mFirstPosition;
            if (i2 >= 0) {
                ExpandableHListConnector.b i3 = this.a.i(d(i2));
                if (i3.a.d != 1) {
                    if (i3.b()) {
                        ExpandableHListConnector.GroupMetadata groupMetadata = i3.b;
                    }
                    i3.d();
                }
                Drawable drawable = this.k;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                i3.d();
                return;
            }
            super.drawDivider(canvas, rect, i2);
        }
    }

    public final Drawable e(ExpandableHListConnector.b bVar) {
        InterceptResult invokeL;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar.a.d == 2) {
                drawable = this.i;
                if (drawable != null && drawable.isStateful()) {
                    ExpandableHListConnector.GroupMetadata groupMetadata = bVar.b;
                    drawable.setState(z[bVar.b() | (groupMetadata == null || groupMetadata.lastChildFlPos == groupMetadata.flPos ? (char) 2 : (char) 0)]);
                }
            } else {
                drawable = this.j;
                if (drawable != null && drawable.isStateful()) {
                    drawable.setState(bVar.a.c == bVar.b.lastChildFlPos ? A : v);
                }
            }
            return drawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.b : (ExpandableListAdapter) invokeV.objValue;
    }

    public long getSelectedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            long selectedPosition = getSelectedPosition();
            if (selectedPosition == 4294967295L) {
                return -1L;
            }
            int g = g(selectedPosition);
            if (h(selectedPosition) == 0) {
                return this.b.getGroupId(g);
            }
            return this.b.getChildId(g, f(selectedPosition));
        }
        return invokeV.longValue;
    }

    public long getSelectedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c(getSelectedItemPosition()) : invokeV.longValue;
    }

    public boolean i(View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            ExpandableHListConnector.b i2 = this.a.i(i);
            long b2 = b(i2.a);
            s47 s47Var = i2.a;
            boolean z2 = true;
            if (s47Var.d == 2) {
                d dVar = this.t;
                if (dVar != null && dVar.a(this, view2, s47Var.a, b2)) {
                    i2.d();
                    return true;
                } else if (i2.b()) {
                    this.a.c(i2);
                    playSoundEffect(0);
                    e eVar = this.r;
                    if (eVar != null) {
                        eVar.a(i2.a.a);
                    }
                } else {
                    this.a.d(i2);
                    playSoundEffect(0);
                    f fVar = this.s;
                    if (fVar != null) {
                        fVar.a(i2.a.a);
                    }
                    s47 s47Var2 = i2.a;
                    int i3 = s47Var2.a;
                    int headerViewsCount = s47Var2.c + getHeaderViewsCount();
                    smoothScrollToPosition(this.b.getChildrenCount(i3) + headerViewsCount, headerViewsCount);
                }
            } else if (this.u != null) {
                playSoundEffect(0);
                c cVar = this.u;
                s47 s47Var3 = i2.a;
                return cVar.a(this, view2, s47Var3.a, s47Var3.b, b2);
            } else {
                z2 = false;
            }
            i2.d();
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean j(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            return i < getHeaderViewsCount() || i >= this.mItemCount - getFooterViewsCount();
        }
        return invokeI.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Drawable drawable = this.j;
            if (drawable != null) {
                this.p = drawable.getIntrinsicWidth();
                this.q = this.j.getIntrinsicHeight();
                return;
            }
            this.p = 0;
            this.q = 0;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Drawable drawable = this.i;
            if (drawable != null) {
                this.n = drawable.getIntrinsicWidth();
                this.o = this.i.getIntrinsicHeight();
                return;
            }
            this.n = 0;
            this.o = 0;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ExpandableHListView.class.getName());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ArrayList<ExpandableHListConnector.GroupMetadata> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            ExpandableHListConnector expandableHListConnector = this.a;
            if (expandableHListConnector == null || (arrayList = savedState.expandedGroupMetadataList) == null) {
                return;
            }
            expandableHListConnector.l(arrayList);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            l();
            k();
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState();
            ExpandableHListConnector expandableHListConnector = this.a;
            return new SavedState(onSaveInstanceState, expandableHListConnector != null ? expandableHListConnector.g() : null);
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view2, int i, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{view2, Integer.valueOf(i), Long.valueOf(j)})) == null) {
            if (j(i)) {
                return super.performItemClick(view2, i, j);
            }
            return i(view2, d(i), j);
        }
        return invokeCommon.booleanValue;
    }

    public void setChildDivider(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, drawable) == null) {
            this.k = drawable;
        }
    }

    public void setChildIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, drawable) == null) {
            this.j = drawable;
            k();
        }
    }

    public void setGroupIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, drawable) == null) {
            this.i = drawable;
            l();
        }
    }

    public void setOnChildClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) {
            this.u = cVar;
        }
    }

    public void setOnGroupClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, dVar) == null) {
            this.t = dVar;
        }
    }

    public void setOnGroupCollapseListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void setOnGroupExpandListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, fVar) == null) {
            this.s = fVar;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setOnItemClickListener(AdapterView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dVar) == null) {
            super.setOnItemClickListener(dVar);
        }
    }

    public void setSelectedGroup(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            s47 d2 = s47.d(i);
            ExpandableHListConnector.b h = this.a.h(d2);
            d2.e();
            super.setSelection(a(h.a.c));
            h.d();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040314);
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
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? super.getAdapter() : (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, listAdapter) == null) {
            throw new RuntimeException("For ExpandableListView, use setAdapter(ExpandableListAdapter) instead of setAdapter(ListAdapter)");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExpandableHListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.l = new Rect();
        this.m = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04030e, R.attr.obfuscated_res_0x7f04030f, R.attr.obfuscated_res_0x7f040310, R.attr.obfuscated_res_0x7f040311, R.attr.obfuscated_res_0x7f040312, R.attr.obfuscated_res_0x7f040316, R.attr.obfuscated_res_0x7f040318, R.attr.obfuscated_res_0x7f040319, R.attr.obfuscated_res_0x7f04031a}, i, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(5));
        setChildIndicator(obtainStyledAttributes.getDrawable(1));
        this.d = obtainStyledAttributes.getDimensionPixelSize(7, 0);
        this.c = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        this.e = obtainStyledAttributes.getInt(6, 0);
        this.f = obtainStyledAttributes.getInt(2, 0);
        this.h = obtainStyledAttributes.getDimensionPixelSize(3, 0);
        this.g = obtainStyledAttributes.getDimensionPixelSize(4, 0);
        this.k = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, expandableListAdapter) == null) {
            this.b = expandableListAdapter;
            if (expandableListAdapter != null) {
                this.a = new ExpandableHListConnector(expandableListAdapter);
            } else {
                this.a = null;
            }
            super.setAdapter((ListAdapter) this.a);
        }
    }
}
