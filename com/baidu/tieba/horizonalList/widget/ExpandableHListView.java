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
/* loaded from: classes9.dex */
public class ExpandableHListView extends HListView {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] A;
    public static final int[] B;
    public static final int[] C;
    public static final int CHILD_INDICATOR_INHERIT = -1;
    public static final int[][] D;
    public static final int[] E;
    public static final int PACKED_POSITION_TYPE_CHILD = 1;
    public static final int PACKED_POSITION_TYPE_GROUP = 0;
    public static final int PACKED_POSITION_TYPE_NULL = 2;
    public static final long PACKED_POSITION_VALUE_NULL = 4294967295L;
    public static final int[] z;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ExpandableHListConnector f50879e;

    /* renamed from: f  reason: collision with root package name */
    public ExpandableListAdapter f50880f;

    /* renamed from: g  reason: collision with root package name */
    public int f50881g;

    /* renamed from: h  reason: collision with root package name */
    public int f50882h;

    /* renamed from: i  reason: collision with root package name */
    public int f50883i;
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

    /* loaded from: classes9.dex */
    public static class SavedState extends View.BaseSavedState {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator<SavedState> CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public ArrayList<ExpandableHListConnector.GroupMetadata> expandedGroupMetadataList;

        /* loaded from: classes9.dex */
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

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes9.dex */
    public static class b implements ContextMenu.ContextMenuInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f50884a;

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
            this.f50884a = view;
        }
    }

    /* loaded from: classes9.dex */
    public interface c {
        boolean a(ExpandableHListView expandableHListView, View view, int i2, int i3, long j);
    }

    /* loaded from: classes9.dex */
    public interface d {
        boolean a(ExpandableHListView expandableHListView, View view, int i2, long j);
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a(int i2);
    }

    /* loaded from: classes9.dex */
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

    public static int getPackedPositionChild(long j) {
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

    public static long getPackedPositionForChild(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(AdIconUtil.AD_TEXT_ID, null, i2, i3)) == null) ? (i3 & (-1)) | ((i2 & 2147483647L) << 32) | Long.MIN_VALUE : invokeII.longValue;
    }

    public static long getPackedPositionForGroup(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? (i2 & 2147483647L) << 32 : invokeI.longValue;
    }

    public static int getPackedPositionGroup(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65543, null, j)) == null) {
            if (j == 4294967295L) {
                return -1;
            }
            return (int) ((j & 9223372032559808512L) >> 32);
        }
        return invokeJ.intValue;
    }

    public static int getPackedPositionType(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(65544, null, j)) == null) {
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

    public final long b(b.a.r0.i1.b.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) {
            if (aVar.f19347d == 1) {
                return this.f50880f.getChildId(aVar.f19344a, aVar.f19345b);
            }
            return this.f50880f.getGroupId(aVar.f19344a);
        }
        return invokeL.longValue;
    }

    public final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 - getHeaderViewsCount() : invokeI.intValue;
    }

    public boolean collapseGroup(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            boolean b2 = this.f50879e.b(i2);
            e eVar = this.v;
            if (eVar != null) {
                eVar.a(i2);
            }
            return b2;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView
    public ContextMenu.ContextMenuInfo createContextMenuInfo(View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (f(i2)) {
                return new AdapterView.b(view, i2, j);
            }
            ExpandableHListConnector.b i3 = this.f50879e.i(c(i2));
            b.a.r0.i1.b.a aVar = i3.f50876a;
            long b2 = b(aVar);
            long a2 = aVar.a();
            i3.d();
            return new b(view, a2, b2);
        }
        return (ContextMenu.ContextMenuInfo) invokeCommon.objValue;
    }

    public final Drawable d(ExpandableHListConnector.b bVar) {
        InterceptResult invokeL;
        Drawable drawable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            if (bVar.f50876a.f19347d == 2) {
                drawable = this.m;
                if (drawable != null && drawable.isStateful()) {
                    ExpandableHListConnector.GroupMetadata groupMetadata = bVar.f50877b;
                    drawable.setState(D[bVar.b() | (groupMetadata == null || groupMetadata.lastChildFlPos == groupMetadata.flPos ? (char) 2 : (char) 0)]);
                }
            } else {
                drawable = this.n;
                if (drawable != null && drawable.isStateful()) {
                    drawable.setState(bVar.f50876a.f19346c == bVar.f50877b.lastChildFlPos ? E : z);
                }
            }
            return drawable;
        }
        return (Drawable) invokeL.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) {
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
                        ExpandableHListConnector.b i5 = this.f50879e.i(i4);
                        int i6 = i5.f50876a.f19347d;
                        if (i6 != i2) {
                            if (i6 == 1) {
                                rect.top = childAt.getTop() + this.k;
                                rect.bottom = childAt.getBottom() + this.k;
                            } else {
                                rect.top = childAt.getTop() + this.f50881g;
                                rect.bottom = childAt.getBottom() + this.f50881g;
                            }
                            i2 = i5.f50876a.f19347d;
                        }
                        if (rect.top != rect.bottom) {
                            if (i5.f50876a.f19347d == 1) {
                                int i7 = this.l;
                                rect.left = left + i7;
                                rect.right = right2 + i7;
                            } else {
                                int i8 = this.f50882h;
                                rect.left = left + i8;
                                rect.right = right2 + i8;
                            }
                            Drawable d2 = d(i5);
                            if (d2 != null) {
                                if (i5.f50876a.f19347d == 1) {
                                    Gravity.apply(this.j, this.t, this.u, rect, this.q);
                                } else {
                                    Gravity.apply(this.f50883i, this.r, this.s, rect, this.q);
                                }
                                d2.setBounds(this.q);
                                d2.draw(canvas);
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
        if (interceptable == null || interceptable.invokeLLI(1048583, this, canvas, rect, i2) == null) {
            int i3 = i2 + this.mFirstPosition;
            if (i3 >= 0) {
                ExpandableHListConnector.b i4 = this.f50879e.i(c(i3));
                if (i4.f50876a.f19347d != 1) {
                    if (i4.b()) {
                        ExpandableHListConnector.GroupMetadata groupMetadata = i4.f50877b;
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

    public boolean e(View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            ExpandableHListConnector.b i3 = this.f50879e.i(i2);
            long b2 = b(i3.f50876a);
            b.a.r0.i1.b.a aVar = i3.f50876a;
            boolean z2 = true;
            if (aVar.f19347d == 2) {
                d dVar = this.x;
                if (dVar != null && dVar.a(this, view, aVar.f19344a, b2)) {
                    i3.d();
                    return true;
                } else if (i3.b()) {
                    this.f50879e.c(i3);
                    playSoundEffect(0);
                    e eVar = this.v;
                    if (eVar != null) {
                        eVar.a(i3.f50876a.f19344a);
                    }
                } else {
                    this.f50879e.d(i3);
                    playSoundEffect(0);
                    f fVar = this.w;
                    if (fVar != null) {
                        fVar.a(i3.f50876a.f19344a);
                    }
                    b.a.r0.i1.b.a aVar2 = i3.f50876a;
                    int i4 = aVar2.f19344a;
                    int headerViewsCount = aVar2.f19346c + getHeaderViewsCount();
                    smoothScrollToPosition(this.f50880f.getChildrenCount(i4) + headerViewsCount, headerViewsCount);
                }
            } else if (this.y != null) {
                playSoundEffect(0);
                c cVar = this.y;
                b.a.r0.i1.b.a aVar3 = i3.f50876a;
                return cVar.a(this, view, aVar3.f19344a, aVar3.f19345b, b2);
            } else {
                z2 = false;
            }
            i3.d();
            return z2;
        }
        return invokeCommon.booleanValue;
    }

    public boolean expandGroup(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) ? expandGroup(i2, false) : invokeI.booleanValue;
    }

    public final boolean f(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            return i2 < getHeaderViewsCount() || i2 >= this.mItemCount - getFooterViewsCount();
        }
        return invokeI.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
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

    public ExpandableListAdapter getExpandableListAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.f50880f : (ExpandableListAdapter) invokeV.objValue;
    }

    public long getExpandableListPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            if (f(i2)) {
                return 4294967295L;
            }
            ExpandableHListConnector.b i3 = this.f50879e.i(c(i2));
            long a2 = i3.f50876a.a();
            i3.d();
            return a2;
        }
        return invokeI.longValue;
    }

    public int getFlatListPosition(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048593, this, j)) == null) {
            b.a.r0.i1.b.a f2 = b.a.r0.i1.b.a.f(j);
            ExpandableHListConnector.b h2 = this.f50879e.h(f2);
            f2.g();
            int i2 = h2.f50876a.f19346c;
            h2.d();
            return a(i2);
        }
        return invokeJ.intValue;
    }

    public long getSelectedId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            long selectedPosition = getSelectedPosition();
            if (selectedPosition == 4294967295L) {
                return -1L;
            }
            int packedPositionGroup = getPackedPositionGroup(selectedPosition);
            if (getPackedPositionType(selectedPosition) == 0) {
                return this.f50880f.getGroupId(packedPositionGroup);
            }
            return this.f50880f.getChildId(packedPositionGroup, getPackedPositionChild(selectedPosition));
        }
        return invokeV.longValue;
    }

    public long getSelectedPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? getExpandableListPosition(getSelectedItemPosition()) : invokeV.longValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
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

    public boolean isGroupExpanded(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? this.f50879e.j(i2) : invokeI.booleanValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, accessibilityEvent) == null) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ExpandableHListView.class.getName());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView, android.view.View
    @TargetApi(14)
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, accessibilityNodeInfo) == null) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ExpandableHListView.class.getName());
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ArrayList<ExpandableHListConnector.GroupMetadata> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, parcelable) == null) {
            if (!(parcelable instanceof SavedState)) {
                super.onRestoreInstanceState(parcelable);
                return;
            }
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            ExpandableHListConnector expandableHListConnector = this.f50879e;
            if (expandableHListConnector == null || (arrayList = savedState.expandedGroupMetadataList) == null) {
                return;
            }
            expandableHListConnector.m(arrayList);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            h();
            g();
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, android.view.View
    public Parcelable onSaveInstanceState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            Parcelable onSaveInstanceState = super.onSaveInstanceState();
            ExpandableHListConnector expandableHListConnector = this.f50879e;
            return new SavedState(onSaveInstanceState, expandableHListConnector != null ? expandableHListConnector.g() : null);
        }
        return (Parcelable) invokeV.objValue;
    }

    @Override // com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public boolean performItemClick(View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            if (f(i2)) {
                return super.performItemClick(view, i2, j);
            }
            return e(view, c(i2), j);
        }
        return invokeCommon.booleanValue;
    }

    public void setChildDivider(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, drawable) == null) {
            this.o = drawable;
        }
    }

    public void setChildIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, drawable) == null) {
            this.n = drawable;
            g();
        }
    }

    public void setGroupIndicator(Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, drawable) == null) {
            this.m = drawable;
            h();
        }
    }

    public void setOnChildClickListener(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, cVar) == null) {
            this.y = cVar;
        }
    }

    public void setOnGroupClickListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, dVar) == null) {
            this.x = dVar;
        }
    }

    public void setOnGroupCollapseListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, eVar) == null) {
            this.v = eVar;
        }
    }

    public void setOnGroupExpandListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, fVar) == null) {
            this.w = fVar;
        }
    }

    @Override // com.baidu.tieba.horizonalList.widget.AdapterView
    public void setOnItemClickListener(AdapterView.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, dVar) == null) {
            super.setOnItemClickListener(dVar);
        }
    }

    public boolean setSelectedChild(int i2, int i3, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z2)})) == null) {
            b.a.r0.i1.b.a d2 = b.a.r0.i1.b.a.d(i2, i3);
            ExpandableHListConnector.b h2 = this.f50879e.h(d2);
            if (h2 == null) {
                if (!z2) {
                    return false;
                }
                expandGroup(i2);
                h2 = this.f50879e.h(d2);
                if (h2 == null) {
                    throw new IllegalStateException("Could not find child");
                }
            }
            super.setSelection(a(h2.f50876a.f19346c));
            d2.g();
            h2.d();
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void setSelectedGroup(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            b.a.r0.i1.b.a e2 = b.a.r0.i1.b.a.e(i2);
            ExpandableHListConnector.b h2 = this.f50879e.h(e2);
            e2.g();
            super.setSelection(a(h2.f50876a.f19346c));
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

    public boolean expandGroup(int i2, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z2)})) == null) {
            b.a.r0.i1.b.a c2 = b.a.r0.i1.b.a.c(2, i2, -1, -1);
            ExpandableHListConnector.b h2 = this.f50879e.h(c2);
            c2.g();
            boolean d2 = this.f50879e.d(h2);
            f fVar = this.w;
            if (fVar != null) {
                fVar.a(i2);
            }
            if (z2) {
                int headerViewsCount = h2.f50876a.f19346c + getHeaderViewsCount();
                smoothScrollToPosition(this.f50880f.getChildrenCount(i2) + headerViewsCount, headerViewsCount);
            }
            h2.d();
            return d2;
        }
        return invokeCommon.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public ListAdapter getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? super.getAdapter() : (ListAdapter) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.horizonalList.widget.HListView, com.baidu.tieba.horizonalList.widget.AbsHListView, com.baidu.tieba.horizonalList.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, listAdapter) == null) {
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
        this.f50882h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_indicatorPaddingLeft, 0);
        this.f50881g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_indicatorPaddingTop, 0);
        this.f50883i = obtainStyledAttributes.getInt(R$styleable.ExpandableHListView_hlv_indicatorGravity, 0);
        this.j = obtainStyledAttributes.getInt(R$styleable.ExpandableHListView_hlv_childIndicatorGravity, 0);
        this.l = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_childIndicatorPaddingLeft, 0);
        this.k = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ExpandableHListView_hlv_childIndicatorPaddingTop, 0);
        this.o = obtainStyledAttributes.getDrawable(R$styleable.ExpandableHListView_hlv_childDivider);
        obtainStyledAttributes.recycle();
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, expandableListAdapter) == null) {
            this.f50880f = expandableListAdapter;
            if (expandableListAdapter != null) {
                this.f50879e = new ExpandableHListConnector(expandableListAdapter);
            } else {
                this.f50879e = null;
            }
            super.setAdapter((ListAdapter) this.f50879e);
        }
    }
}
