package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapViewLayoutParams;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.Overlay;
import com.baidu.mapapi.map.PolygonOptions;
import com.baidu.mapapi.map.PolylineOptions;
import com.baidu.mapapi.map.Stroke;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.tieba.ao3;
import com.baidu.tieba.xx2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class hg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a implements ao3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ xx2 a;
        public final /* synthetic */ mg4 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ ng4 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(xx2 xx2Var, mg4 mg4Var, List list, Context context, ng4 ng4Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {xx2Var, mg4Var, list, context, ng4Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = xx2Var;
            this.b = mg4Var;
            this.c = list;
            this.d = context;
            this.e = ng4Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.baidu.tieba.ao3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (hg4.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = hg4.b();
                }
                Bitmap g = hg4.g(bitmap, this.a);
                wx2 wx2Var = this.a.b;
                LatLng latLng = new LatLng(wx2Var.a, wx2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                xx2.a aVar = this.a.k;
                MarkerOptions anchor = zIndex.anchor((float) aVar.a, (float) aVar.b);
                this.b.a = this.a;
                this.c.add(anchor);
                LinearLayout linearLayout = new LinearLayout(this.d);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                linearLayout.setGravity(17);
                View view2 = new View(this.d);
                view2.setLayoutParams(new ViewGroup.LayoutParams(g.getWidth(), g.getHeight()));
                view2.setVisibility(4);
                linearLayout.addView(view2);
                this.b.e = linearLayout;
                if (mg4.h.booleanValue()) {
                    xx2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = bg4.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    xx2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(dg4.a(this.e, this.b));
                    }
                }
                linearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                MapViewLayoutParams.Builder builder = new MapViewLayoutParams.Builder();
                builder.layoutMode(MapViewLayoutParams.ELayoutMode.mapMode);
                builder.position(latLng);
                builder.yOffset((int) ((g.getHeight() * (1.0d - this.a.k.b)) + 0.0d));
                this.e.l.addView(linearLayout, builder.build());
                linearLayout.setAlpha(0.0f);
                BitmapDescriptor fromView = BitmapDescriptorFactory.fromView(linearLayout);
                if (fromView == null) {
                    return;
                }
                Bitmap bitmap2 = fromView.getBitmap();
                this.g.add(new MarkerOptions().position(latLng).icon(fromView).anchor(((float) (((bitmap2.getWidth() - g.getWidth()) / 2.0f) + (this.a.k.a * g.getWidth()))) / bitmap2.getWidth(), ((float) (((float) ((bitmap2.getHeight() - 0.0d) - g.getHeight())) + (this.a.k.b * g.getHeight()))) / bitmap2.getHeight()).zIndex(66));
                synchronized (fg4.a) {
                    this.h.getAndIncrement();
                    this.e.n.add(this.b);
                    int size = this.e.n.size();
                    if (this.i == this.h.get()) {
                        List<Overlay> addOverlays = this.e.l.getMap().addOverlays(this.f);
                        int size2 = addOverlays.size();
                        for (int i = 0; i < size2 && i < size; i++) {
                            this.e.n.get(i).c = (Marker) addOverlays.get(i);
                        }
                        List<Overlay> addOverlays2 = this.e.l.getMap().addOverlays(this.c);
                        int size3 = addOverlays2.size();
                        for (int i2 = 0; i2 < size3 && i2 < size; i2++) {
                            this.e.n.get(i2).b = (Marker) addOverlays2.get(i2);
                        }
                        List<Overlay> addOverlays3 = this.e.l.getMap().addOverlays(this.g);
                        int size4 = addOverlays3.size();
                        for (int i3 = 0; i3 < size4 && i3 < size; i3++) {
                            this.e.n.get(i3).f = (Marker) addOverlays3.get(i3);
                        }
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947822740, "Lcom/baidu/tieba/hg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947822740, "Lcom/baidu/tieba/hg4;");
                return;
            }
        }
        a = nr1.a;
    }

    public static /* synthetic */ Bitmap b() {
        return f();
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f081253);
        }
        return (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, xx2 xx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, xx2Var)) == null) {
            int i = xx2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = xx2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return ch4.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static void d(@NonNull px2 px2Var, @NonNull ng4 ng4Var, jg4 jg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, px2Var, ng4Var, jg4Var) == null) {
            List<vx2> list = px2Var.o;
            if (list != null && list.size() > 0) {
                for (vx2 vx2Var : px2Var.o) {
                    cg4.a(ng4Var, vx2Var, jg4Var);
                    d82.i("map", "initMapView createControl id " + vx2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<zx2> list2 = px2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (zx2 zx2Var : px2Var.m) {
                    if (!zx2Var.isValid()) {
                        d82.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(zx2Var.a.size());
                        Iterator<wx2> it = zx2Var.a.iterator();
                        while (it.hasNext()) {
                            wx2 next = it.next();
                            arrayList2.add(new LatLng(next.a, next.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(zx2Var.b).width((int) zx2Var.c).dottedLine(zx2Var.d));
                            d82.i("map", "initMapView createPoly");
                        } else {
                            d82.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<yx2> list3 = px2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (yx2 yx2Var : px2Var.q) {
                    if (!yx2Var.isValid()) {
                        d82.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(yx2Var.a.size());
                        Iterator<wx2> it2 = yx2Var.a.iterator();
                        while (it2.hasNext()) {
                            wx2 next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(yx2Var.b, yx2Var.c)).fillColor(yx2Var.d).zIndex(yx2Var.e));
                            d82.i("map", "initMapView createPolygons");
                        } else {
                            d82.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<wx2> list4 = px2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (wx2 wx2Var : px2Var.p) {
                    builder.include(new LatLng(wx2Var.a, wx2Var.b));
                }
                ng4Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                d82.i("map", "initMapView includePoints");
            }
            List<ux2> list5 = px2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (ux2 ux2Var : px2Var.n) {
                    if (ux2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        wx2 wx2Var2 = ux2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(wx2Var2.a, wx2Var2.b)).stroke(new Stroke((int) ux2Var.e, ux2Var.b)).fillColor(ux2Var.c).radius(ux2Var.d));
                        d82.i("map", "initMapView createCircle");
                    }
                }
            }
            ng4Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull px2 px2Var, @NonNull ng4 ng4Var) {
        List<xx2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, context, px2Var, ng4Var) == null) && (list = px2Var.l) != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = list.size();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator<xx2> it = list.iterator();
            while (it.hasNext()) {
                xx2 next = it.next();
                mg4 mg4Var = new mg4();
                if (next.k == null) {
                    next.k = new xx2.a();
                }
                String str = next.d;
                if (TextUtils.isEmpty(str)) {
                    str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f081253).build().getSourceUri().toString();
                }
                ao3.e(str, new a(next, mg4Var, arrayList, context, ng4Var, arrayList2, arrayList3, atomicInteger, size));
                it = it;
                arrayList = arrayList;
            }
        }
    }
}
