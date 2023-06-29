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
import com.baidu.tieba.wy2;
import com.baidu.tieba.zo3;
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
/* loaded from: classes5.dex */
public class gh4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements zo3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wy2 a;
        public final /* synthetic */ lh4 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ mh4 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(wy2 wy2Var, lh4 lh4Var, List list, Context context, mh4 mh4Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wy2Var, lh4Var, list, context, mh4Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wy2Var;
            this.b = lh4Var;
            this.c = list;
            this.d = context;
            this.e = mh4Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.baidu.tieba.zo3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (gh4.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = gh4.b();
                }
                Bitmap g = gh4.g(bitmap, this.a);
                vy2 vy2Var = this.a.b;
                LatLng latLng = new LatLng(vy2Var.a, vy2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                wy2.a aVar = this.a.k;
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
                if (lh4.h.booleanValue()) {
                    wy2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = ah4.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    wy2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(ch4.a(this.e, this.b));
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
                synchronized (eh4.a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947793910, "Lcom/baidu/tieba/gh4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947793910, "Lcom/baidu/tieba/gh4;");
                return;
            }
        }
        a = ms1.a;
    }

    public static /* synthetic */ Bitmap b() {
        return f();
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f081220);
        }
        return (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, wy2 wy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, wy2Var)) == null) {
            int i = wy2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = wy2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return bi4.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static void d(@NonNull oy2 oy2Var, @NonNull mh4 mh4Var, ih4 ih4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, oy2Var, mh4Var, ih4Var) == null) {
            List<uy2> list = oy2Var.o;
            if (list != null && list.size() > 0) {
                for (uy2 uy2Var : oy2Var.o) {
                    bh4.a(mh4Var, uy2Var, ih4Var);
                    c92.i("map", "initMapView createControl id " + uy2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<yy2> list2 = oy2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (yy2 yy2Var : oy2Var.m) {
                    if (!yy2Var.isValid()) {
                        c92.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(yy2Var.a.size());
                        Iterator<vy2> it = yy2Var.a.iterator();
                        while (it.hasNext()) {
                            vy2 next = it.next();
                            arrayList2.add(new LatLng(next.a, next.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(yy2Var.b).width((int) yy2Var.c).dottedLine(yy2Var.d));
                            c92.i("map", "initMapView createPoly");
                        } else {
                            c92.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<xy2> list3 = oy2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (xy2 xy2Var : oy2Var.q) {
                    if (!xy2Var.isValid()) {
                        c92.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(xy2Var.a.size());
                        Iterator<vy2> it2 = xy2Var.a.iterator();
                        while (it2.hasNext()) {
                            vy2 next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(xy2Var.b, xy2Var.c)).fillColor(xy2Var.d).zIndex(xy2Var.e));
                            c92.i("map", "initMapView createPolygons");
                        } else {
                            c92.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<vy2> list4 = oy2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (vy2 vy2Var : oy2Var.p) {
                    builder.include(new LatLng(vy2Var.a, vy2Var.b));
                }
                mh4Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                c92.i("map", "initMapView includePoints");
            }
            List<ty2> list5 = oy2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (ty2 ty2Var : oy2Var.n) {
                    if (ty2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        vy2 vy2Var2 = ty2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(vy2Var2.a, vy2Var2.b)).stroke(new Stroke((int) ty2Var.e, ty2Var.b)).fillColor(ty2Var.c).radius(ty2Var.d));
                        c92.i("map", "initMapView createCircle");
                    }
                }
            }
            mh4Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull oy2 oy2Var, @NonNull mh4 mh4Var) {
        List<wy2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, context, oy2Var, mh4Var) == null) && (list = oy2Var.l) != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = list.size();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator<wy2> it = list.iterator();
            while (it.hasNext()) {
                wy2 next = it.next();
                lh4 lh4Var = new lh4();
                if (next.k == null) {
                    next.k = new wy2.a();
                }
                String str = next.d;
                if (TextUtils.isEmpty(str)) {
                    str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f081220).build().getSourceUri().toString();
                }
                zo3.e(str, new a(next, lh4Var, arrayList, context, mh4Var, arrayList2, arrayList3, atomicInteger, size));
                it = it;
                arrayList = arrayList;
            }
        }
    }
}
