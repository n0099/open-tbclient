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
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import com.baidu.tieba.horizonalList.widget.AdapterView;
import com.baidu.tieba.horizonalList.widget.ExpandableHListConnector;
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
    public static final int[] B;
    public static final int[] C;
    public static final int[][] D;
    public static final int[] E;
    public static final int[] z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ExpandableHListConnector f17092e;

    /* renamed from: f  reason: collision with root package name */
    public ExpandableListAdapter f17093f;

    /* renamed from: g  reason: collision with root package name */
    public int f17094g;

    /* renamed from: h  reason: collision with root package name */
    public int f17095h;

    /* renamed from: i  reason: collision with root package name */
    public int f17096i;
    public int j;
    public int k;
    public int l;
    public Drawable m;
    public Drawable n;
    public Drawable o;
    public final Rect p;
    public final Rect q;
    public int r;
    public int s;
    public int t;
    public int u;
    public e v;
    public f w;
    public d x;
    public c y;

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
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
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
            public SavedState[] newArray(int i2) {
                InterceptResult invokeI;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new SavedState[i2] : (SavedState[]) invokeI.objValue;
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
        public void writeToParcel(Parcel parcel, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, parcel, i2) == null) {
                super.writeToParcel(parcel, i2);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        /* renamed from: a  reason: collision with root package name */
        public View f17097a;

        public b(View view, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f17097a = view;
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i2, int i3, long j);
    }

    /* loaded from: classes4.dex */
    public interface d {
        boolean a(ExpandableHListView expandableHListView, View view, int i2, long j);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(int i2);
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
        z = iArr;
        int[] iArr2 = {16842920};
        A = iArr2;
        int[] iArr3 = {16842921};
        B = iArr3;
        int[] iArr4 = {16842920, 16842921};
        C = iArr4;
        D = new int[][]{iArr, iArr2, iArr3, iArr4};
        E = new int[]{16842918};
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.AD_TEXT_ID, null, j)) == null) {
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
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, null, j)) == null) {
            if (j == 4294967295L) {
                return 2;
            }
            return (j & Long.MIN_VALUE) == Long.MIN_VALUE ? 1 : 0;
        }
        return invokeJ.intValue;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? i2 + getHeaderViewsCount() : invokeI.intValue;
    }

    public final long b(d.a.q0.f1.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar.f56735d == 1) {
                return this.f17093f.getChildId(aVar.f56732a, aVar.f56733b);
            }
            return this.f17093f.getGroupId(aVar.f56732a);
        }
        return invokeL.longValue;
    }

    public long c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            if (j(i2)) {
                return 4294967295L;
            }
            ExpandableHListConnector.b i3 = this.f17092e.i(d(i2));
            long a2 = i3.f17089a.a();
            i3.d();
            return a2;
        }
        return invokeI.longValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (j(i2)) {
                return new AdapterView.b(view, i2, j);
            }
            ExpandableHListConnector.b i3 = this.f17092e.i(d(i2));
            d.a.q0.f1.b.a aVar = i3.f17089a;
            long b2 = b(aVar);
            long a2 = aVar.a();
            i3.d();
            return new b(view, a2, b2);
        }
        return (ContextMenu.ContextMenuInfo) invokeCommon.objValue;
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) ? i2 - getHeaderViewsCount() : invokeI.intValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.n == null && this.m == null) {
                return;
            }
            int headerViewsCount = getHeaderViewsCount();
            int footerViewsCount = ((this.mItemCount - getFooterViewsCount()) - headerViewsCount) - 1;
            int right = getRight();
            int i2 = -4;
            Rect rect = this.p;
            int childCount = getChildCount();
            int i3 = 0;
            int i4 = this.mFirstPosition - headerViewsCount;
            while (i3 < childCount) {
                if (i4 >= 0) {
                    if (i4 > footerViewsCount) {
                        return;
                    }
                    View childAt = getChildAt(i3);
                    int left = childAt.getLeft();
                    int right2 = childAt.getRight();
                    if (right2 >= 0 && left <= right) {
                        ExpandableHListConnector.b i5 = this.f17092e.i(i4);
                        int i6 = i5.f17089a.f56735d;
                        if (i6 != i2) {
                            if (i6 == 1) {
                                rect.top = childAt.getTop() + this.k;
                                rect.bottom = childAt.getBottom() + this.k;
                            } else {
                                rect.top = childAt.getTop() + this.f17094g;
                                rect.bottom = childAt.getBottom() + this.f17094g;
                            }
                            i2 = i5.f17089a.f56735d;
                        }
                        if (rect.top != rect.bottom) {
                            if (i5.f17089a.f56735d == 1) {
                                int i7 = this.l;
                                rect.left = left + i7;
                                rect.right = right2 + i7;
                            } else {
                                int i8 = this.f17095h;
                                rect.left = left + i8;
                                rect.right = right2 + i8;
                            }
                            Drawable e2 = e(i5);
                            if (e2 != null) {
                                if (i5.f17089a.f56735d == 1) {
                                    Gravity.apply(this.j, this.t, this.u, rect, this.q);
                                } else {
                                    Gravity.apply(this.f17096i, this.r, this.s, rect, this.q);
                                }
                                e2.setBounds(this.q);
                                e2.draw(canvas);
                            }
                        }
                        i5.d();
                    }
                }
                i3++;
                i4++;
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
    public void drawDivider(Canvas canvas, Rect rect, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048582, this, canvas, rect, i2) == null) {
            int i3 = i2 + this.mFirstPosition;
            if (i3 >= 0) {
                ExpandableHListConnector.b i4 = this.f17092e.i(d(i3));
                if (i4.f17089a.f56735d != 1) {
                    if (i4.b()) {
                        ExpandableHListConnector.GroupMetadata groupMetadata = i4.f17090b;
                    }
                    i4.d();
                }
                Drawable drawable = this.o;
                drawable.setBounds(rect);
                drawable.draw(canvas);
                i4.d();
                return;
            }
            super.drawDivider(canvas, rect, i3);
        }
    }

    public final Drawable e(ExpandableHListConnector.b bVar) {
        InterceptResult invokeL;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bVar)) == null) {
            if (bVar.f17089a.f56735d == 2) {
                drawable = this.m;
                if (drawable != null && drawable.isStateful()) {
                    ExpandableHListConnector.GroupMetadata groupMetadata = bVar.f17090b;
                    drawable.setState(D[bVar.b() | (groupMetadata == null || groupMetadata.lastChildFlPos == groupMetadata.flPos ? (char) 2 : (char) 0)]);
                }
            } else {
                drawable = this.n;
                if (drawable != null && drawable.isStateful()) {
                    drawable.setState(bVar.f17089a.f56734c == bVar.f17090b.lastChildFlPos ? E : z);
                }
            }
            return drawable;
        }
        return (Drawable) invokeL.objValue;
    }

    public ExpandableListAdapter getExpandableListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f17093f : (ExpandableListAdapter) invokeV.objValue;
    }

    public long getSelectedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            long selectedPosition = getSelectedPosition();
            if (selectedPosition == 4294967295L) {
                return -1L;
            }
            int g2 = g(selectedPosition);
            if (h(selectedPosition) == 0) {
                return this.f17093f.getGroupId(g2);
            }
            return this.f17093f.getChildId(g2, f(selectedPosition));
        }
        return invokeV.longValue;
    }

    public long getSelectedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? c(getSelectedItemPosition()) : invokeV.longValue;
    }

    public boolean i(View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            ExpandableHListConnector.b i3 = this.f17092e.i(i2);
            long b2 = b(i3.f17089a);
            d.a.q0.f1.b.a aVar = i3.f17089a;
            boolean z2 = true;
            if (aVar.f56735d == 2) {
                d dVar = this.x;
                if (dVar != null && dVar.a(this, view, aVar.f56732a, b2)) {
                    i3.d();
                    return true;
                } else if (i3.b()) {
                    this.f17092e.c(i3);
                    playSoundEffect(0);
                    e eVar = this.v;
                    if (eVar != null) {
                        eVar.a(i3.f17089a.f56732a);
                    }
                } else {
                    this.f17092e.d(i3);
                    playSoundEffect(0);
                    f fVar = this.w;
                    if (fVar != null) {
                        fVar.a(i3.f17089a.f56732a);
                    }
                    d.a.q0.f1.b.a aVar2 = i3.f17089a;
                    int i4 = aVar2.f56732a;
                    int headerViewsCount = aVar2.f56734c + getHeaderViewsCount();
                    smoothScrollToPosition(this.f17093f.getChildrenCount(i4) + headerViewsCount, headerViewsCount);
                }
            } else if (this.y != null) {
                playSoundEffect(0);
                c cVar = this.y;
                d.a.q0.f1.b.a aVar3 = i3.f17089a;
                return cVar.a(this, view, aVar3.f56732a, aVar3.f56733b, b2);
            } else {
                z2 = false;
            }
            i3.d();
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean j(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            return i2 < getHeaderViewsCount() || i2 >= this.mItemCount - getFooterViewsCount();
        }
        return invokeI.booleanValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            Drawable drawable = this.n;
            if (drawable != null) {
                this.t = drawable.getIntrinsicWidth();
                this.u = this.n.getIntrinsicHeight();
                return;
            }
            this.t = 0;
            this.u = 0;
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Drawable drawable = this.m;
            if (drawable != null) {
                this.r = drawable.getIntrinsicWidth();
                this.s = this.m.getIntrinsicHeight();
                return;
            }
            this.r = 0;
            this.s = 0;
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
            ExpandableHListConnector expandableHListConnector = this.f17092e;
            if (expandableHListConnector == null || (arrayList = savedState.expandedGroupMetadataList) == null) {
                return;
            }
            expandableHListConnector.l(arrayList);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
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
            ExpandableHListConnector expandableHListConnector = this.f17092e;
            return new SavedState(onSaveInstanceState, expandableHListConnector != null ? expandableHListConnector.g() : null);
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048598, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (j(i2)) {
                return super.performItemClick(view, i2, j);
            }
            return i(view, d(i2), j);
        }
        return invokeCommon.booleanValue;
    }

    public void setChildDivider(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, drawable) == null) {
            this.o = drawable;
        }
    }

    public void setChildIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, drawable) == null) {
            this.n = drawable;
            k();
        }
    }

    public void setGroupIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, drawable) == null) {
            this.m = drawable;
            l();
        }
    }

    public void setOnChildClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cVar) == null) {
            this.y = cVar;
        }
    }

    public void setOnGroupClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, dVar) == null) {
            this.x = dVar;
        }
    }

    public void setOnGroupCollapseListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, eVar) == null) {
            this.v = eVar;
        }
    }

    public void setOnGroupExpandListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, fVar) == null) {
            this.w = fVar;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setOnItemClickListener(AdapterView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dVar) == null) {
            super.setOnItemClickListener(dVar);
        }
    }

    public void setSelectedGroup(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            d.a.q0.f1.b.a d2 = d.a.q0.f1.b.a.d(i2);
            ExpandableHListConnector.b h2 = this.f17092e.h(d2);
            d2.e();
            super.setSelection(a(h2.f17089a.f56734c));
            h2.d();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExpandableHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.hlv_expandableListViewStyle);
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
    public ExpandableHListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.p = new Rect();
        this.q = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandableHListView, i2, 0);
        setGroupIndicator(obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_groupIndicator));
        setChildIndicator(obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_childIndicator));
        this.f17095h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.f17094g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.f17096i = obtainStyledAttributes.getInt(R$styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.j = obtainStyledAttributes.getInt(R$styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.o = obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, expandableListAdapter) == null) {
            this.f17093f = expandableListAdapter;
            if (expandableListAdapter != null) {
                this.f17092e = new ExpandableHListConnector(expandableListAdapter);
            } else {
                this.f17092e = null;
            }
            super.setAdapter((ListAdapter) this.f17092e);
        }
    }
}
