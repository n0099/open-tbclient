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
import com.baidu.tieba.sx2;
import com.baidu.tieba.vn3;
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
public class cg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements vn3.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sx2 a;
        public final /* synthetic */ hg4 b;
        public final /* synthetic */ List c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ ig4 e;
        public final /* synthetic */ List f;
        public final /* synthetic */ List g;
        public final /* synthetic */ AtomicInteger h;
        public final /* synthetic */ int i;

        public a(sx2 sx2Var, hg4 hg4Var, List list, Context context, ig4 ig4Var, List list2, List list3, AtomicInteger atomicInteger, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sx2Var, hg4Var, list, context, ig4Var, list2, list3, atomicInteger, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sx2Var;
            this.b = hg4Var;
            this.c = list;
            this.d = context;
            this.e = ig4Var;
            this.f = list2;
            this.g = list3;
            this.h = atomicInteger;
            this.i = i;
        }

        @Override // com.baidu.tieba.vn3.b
        public void a(String str, Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, str, bitmap) == null) {
                if (cg4.a) {
                    Log.d("MarkerViewCreateHelper", "url=" + str);
                }
                if (bitmap == null) {
                    bitmap = cg4.b();
                }
                Bitmap g = cg4.g(bitmap, this.a);
                rx2 rx2Var = this.a.b;
                LatLng latLng = new LatLng(rx2Var.a, rx2Var.b);
                MarkerOptions zIndex = new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.fromBitmap(g)).alpha((float) this.a.f).title(this.a.c).rotate((float) this.a.e).zIndex(88);
                sx2.a aVar = this.a.k;
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
                if (hg4.h.booleanValue()) {
                    sx2.b bVar = this.a.i;
                    if (bVar != null && bVar.isValid() && TextUtils.equals(this.a.i.g, "ALWAYS")) {
                        View a = wf4.a(this.e, this.a);
                        linearLayout.addView(a, 0);
                        this.b.d = a;
                    }
                    sx2.c cVar = this.a.j;
                    if (cVar != null && cVar.isValid()) {
                        this.f.add(yf4.a(this.e, this.b));
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
                synchronized (ag4.a) {
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947673785, "Lcom/baidu/tieba/cg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947673785, "Lcom/baidu/tieba/cg4;");
                return;
            }
        }
        a = ir1.a;
    }

    public static /* synthetic */ Bitmap b() {
        return f();
    }

    public static Bitmap f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return BitmapFactory.decodeResource(AppRuntime.getAppContext().getResources(), R.drawable.obfuscated_res_0x7f08123e);
        }
        return (Bitmap) invokeV.objValue;
    }

    @Nullable
    public static Bitmap g(Bitmap bitmap, sx2 sx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bitmap, sx2Var)) == null) {
            int i = sx2Var.g;
            if (i == -1) {
                i = bitmap.getWidth();
            }
            int i2 = sx2Var.h;
            if (i2 == -1) {
                i2 = bitmap.getHeight();
            }
            return xg4.a(bitmap, i, i2);
        }
        return (Bitmap) invokeLL.objValue;
    }

    public static void d(@NonNull kx2 kx2Var, @NonNull ig4 ig4Var, eg4 eg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, kx2Var, ig4Var, eg4Var) == null) {
            List<qx2> list = kx2Var.o;
            if (list != null && list.size() > 0) {
                for (qx2 qx2Var : kx2Var.o) {
                    xf4.a(ig4Var, qx2Var, eg4Var);
                    y72.i("map", "initMapView createControl id " + qx2Var.a);
                }
            }
            ArrayList arrayList = new ArrayList();
            List<ux2> list2 = kx2Var.m;
            if (list2 != null && list2.size() > 0) {
                for (ux2 ux2Var : kx2Var.m) {
                    if (!ux2Var.isValid()) {
                        y72.c("map", "polyline is invalid");
                    } else {
                        ArrayList arrayList2 = new ArrayList(ux2Var.a.size());
                        Iterator<rx2> it = ux2Var.a.iterator();
                        while (it.hasNext()) {
                            rx2 next = it.next();
                            arrayList2.add(new LatLng(next.a, next.b));
                        }
                        if (arrayList2.size() >= 2 && !arrayList2.contains(null)) {
                            arrayList.add(new PolylineOptions().points(arrayList2).color(ux2Var.b).width((int) ux2Var.c).dottedLine(ux2Var.d));
                            y72.i("map", "initMapView createPoly");
                        } else {
                            y72.c("map", "polyline count can't less than 2 or your polyline points contains null");
                        }
                    }
                }
            }
            List<tx2> list3 = kx2Var.q;
            if (list3 != null && !list3.isEmpty()) {
                for (tx2 tx2Var : kx2Var.q) {
                    if (!tx2Var.isValid()) {
                        y72.c("map", "polygon is invalid");
                    } else {
                        ArrayList arrayList3 = new ArrayList(tx2Var.a.size());
                        Iterator<rx2> it2 = tx2Var.a.iterator();
                        while (it2.hasNext()) {
                            rx2 next2 = it2.next();
                            arrayList3.add(new LatLng(next2.a, next2.b));
                        }
                        if (arrayList3.size() >= 3 && !arrayList3.contains(null)) {
                            arrayList.add(new PolygonOptions().points(arrayList3).stroke(new Stroke(tx2Var.b, tx2Var.c)).fillColor(tx2Var.d).zIndex(tx2Var.e));
                            y72.i("map", "initMapView createPolygons");
                        } else {
                            y72.c("map", "polygons count can't less than 3 or your polygons points contains null");
                        }
                    }
                }
            }
            List<rx2> list4 = kx2Var.p;
            if (list4 != null && list4.size() > 0) {
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for (rx2 rx2Var : kx2Var.p) {
                    builder.include(new LatLng(rx2Var.a, rx2Var.b));
                }
                ig4Var.l.getMap().setMapStatus(MapStatusUpdateFactory.newLatLngBounds(builder.build()));
                y72.i("map", "initMapView includePoints");
            }
            List<px2> list5 = kx2Var.n;
            if (list5 != null && list5.size() > 0) {
                for (px2 px2Var : kx2Var.n) {
                    if (px2Var.isValid()) {
                        CircleOptions circleOptions = new CircleOptions();
                        rx2 rx2Var2 = px2Var.a;
                        arrayList.add(circleOptions.center(new LatLng(rx2Var2.a, rx2Var2.b)).stroke(new Stroke((int) px2Var.e, px2Var.b)).fillColor(px2Var.c).radius(px2Var.d));
                        y72.i("map", "initMapView createCircle");
                    }
                }
            }
            ig4Var.l.getMap().addOverlays(arrayList);
        }
    }

    public static void e(Context context, @NonNull kx2 kx2Var, @NonNull ig4 ig4Var) {
        List<sx2> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(65541, null, context, kx2Var, ig4Var) == null) && (list = kx2Var.l) != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int size = list.size();
            AtomicInteger atomicInteger = new AtomicInteger(0);
            Iterator<sx2> it = list.iterator();
            while (it.hasNext()) {
                sx2 next = it.next();
                hg4 hg4Var = new hg4();
                if (next.k == null) {
                    next.k = new sx2.a();
                }
                String str = next.d;
                if (TextUtils.isEmpty(str)) {
                    str = ImageRequestBuilder.newBuilderWithResourceId(R.drawable.obfuscated_res_0x7f08123e).build().getSourceUri().toString();
                }
                vn3.e(str, new a(next, hg4Var, arrayList, context, ig4Var, arrayList2, arrayList3, atomicInteger, size));
                it = it;
                arrayList = arrayList;
            }
        }
    }
}
