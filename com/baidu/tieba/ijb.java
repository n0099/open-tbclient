package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class ijb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String a;
    public final List<jjb> b;

    public ijb(SpriteEntity spriteEntity) {
        List<jjb> emptyList;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {spriteEntity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = spriteEntity.imageKey;
        List<FrameEntity> list = spriteEntity.frames;
        if (list != null) {
            emptyList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
            jjb jjbVar = null;
            for (FrameEntity it : list) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                jjb jjbVar2 = new jjb(it);
                if ((!jjbVar2.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.first((List<? extends Object>) jjbVar2.d())).e() && jjbVar != null) {
                    jjbVar2.f(jjbVar.d());
                }
                emptyList.add(jjbVar2);
                jjbVar = jjbVar2;
            }
        } else {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        this.b = emptyList;
    }

    public ijb(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONObject};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = jSONObject.optString("imageKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    jjb jjbVar = new jjb(optJSONObject);
                    if ((!jjbVar.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.first((List<? extends Object>) jjbVar.d())).e() && arrayList.size() > 0) {
                        jjbVar.f(((jjb) CollectionsKt___CollectionsKt.last((List<? extends Object>) arrayList)).d());
                    }
                    arrayList.add(jjbVar);
                }
            }
        }
        this.b = CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public final List<jjb> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }
}
