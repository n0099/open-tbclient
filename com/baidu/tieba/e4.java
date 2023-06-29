package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.graphics.g3d.model.data.ModelMaterial;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.badlogic.gdx.utils.JsonValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.bddownload.core.breakpoint.sqlite.BreakpointSQLiteKey;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.crius.constants.NativeConstants;
import com.baidu.tieba.m1;
import com.baidu.tieba.t6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import org.chromium.base.PathUtils;
/* loaded from: classes5.dex */
public class e4 extends m1<m1.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final v6 d;
    public final Quaternion e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e4(v6 v6Var, k1 k1Var) {
        super(k1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {v6Var, k1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((k1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = new Quaternion();
        this.d = v6Var;
    }

    public t6<r4> p(o4 o4Var, JsonValue jsonValue) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, o4Var, jsonValue)) == null) {
            JsonValue l = jsonValue.l("nodes");
            if (l != null) {
                o4Var.d.e(l.j);
                for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                    o4Var.d.a(q(jsonValue2));
                }
            }
            return o4Var.d;
        }
        return (t6) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.m1
    public o4 h(c3 c3Var, m1.a aVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, c3Var, aVar)) == null) {
            return o(c3Var);
        }
        return (o4) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r10v2, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r15v7, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r8v8, types: [T, com.badlogic.gdx.math.Quaternion] */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v15, types: [com.badlogic.gdx.math.Vector3, T] */
    /* JADX WARN: Type inference failed for: r9v17, types: [T, com.badlogic.gdx.math.Quaternion] */
    public void j(o4 o4Var, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, o4Var, jsonValue) == null) {
            o4 o4Var2 = o4Var;
            JsonValue l = jsonValue.l("animations");
            if (l == null) {
                return;
            }
            o4Var2.e.e(l.j);
            JsonValue jsonValue2 = l.f;
            while (jsonValue2 != null) {
                JsonValue l2 = jsonValue2.l("bones");
                if (l2 != null) {
                    n4 n4Var = new n4();
                    o4Var2.e.a(n4Var);
                    n4Var.b.e(l2.j);
                    n4Var.a = jsonValue2.q("id");
                    for (JsonValue jsonValue3 = l2.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                        s4 s4Var = new s4();
                        n4Var.b.a(s4Var);
                        s4Var.a = jsonValue3.q("boneId");
                        JsonValue l3 = jsonValue3.l("keyframes");
                        float f = 1000.0f;
                        float f2 = 0.0f;
                        int i = 2;
                        int i2 = 1;
                        int i3 = 0;
                        int i4 = 3;
                        if (l3 != null && l3.u()) {
                            JsonValue jsonValue4 = l3.f;
                            while (jsonValue4 != null) {
                                float o = jsonValue4.o("keytime", f2) / f;
                                JsonValue l4 = jsonValue4.l("translation");
                                if (l4 != null && l4.j == i4) {
                                    if (s4Var.b == null) {
                                        s4Var.b = new t6<>();
                                    }
                                    t4<Vector3> t4Var = new t4<>();
                                    t4Var.a = o;
                                    t4Var.b = new Vector3(l4.n(i3), l4.n(i2), l4.n(i));
                                    s4Var.b.a(t4Var);
                                }
                                JsonValue l5 = jsonValue4.l("rotation");
                                if (l5 != null && l5.j == 4) {
                                    if (s4Var.c == null) {
                                        s4Var.c = new t6<>();
                                    }
                                    t4<Quaternion> t4Var2 = new t4<>();
                                    t4Var2.a = o;
                                    t4Var2.b = new Quaternion(l5.n(0), l5.n(i2), l5.n(i), l5.n(3));
                                    s4Var.c.a(t4Var2);
                                }
                                JsonValue l6 = jsonValue4.l("scale");
                                if (l6 != null && l6.j == 3) {
                                    if (s4Var.d == null) {
                                        s4Var.d = new t6<>();
                                    }
                                    t4<Vector3> t4Var3 = new t4<>();
                                    t4Var3.a = o;
                                    t4Var3.b = new Vector3(l6.n(0), l6.n(1), l6.n(2));
                                    s4Var.d.a(t4Var3);
                                }
                                jsonValue4 = jsonValue4.h;
                                f = 1000.0f;
                                f2 = 0.0f;
                                i = 2;
                                i2 = 1;
                                i3 = 0;
                                i4 = 3;
                            }
                        } else {
                            JsonValue l7 = jsonValue3.l("translation");
                            if (l7 != null && l7.u()) {
                                t6<t4<Vector3>> t6Var = new t6<>();
                                s4Var.b = t6Var;
                                t6Var.e(l7.j);
                                for (JsonValue jsonValue5 = l7.f; jsonValue5 != null; jsonValue5 = jsonValue5.h) {
                                    t4<Vector3> t4Var4 = new t4<>();
                                    s4Var.b.a(t4Var4);
                                    t4Var4.a = jsonValue5.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l8 = jsonValue5.l("value");
                                    if (l8 != null && l8.j >= 3) {
                                        t4Var4.b = new Vector3(l8.n(0), l8.n(1), l8.n(2));
                                    }
                                }
                            }
                            JsonValue l9 = jsonValue3.l("rotation");
                            if (l9 != null && l9.u()) {
                                t6<t4<Quaternion>> t6Var2 = new t6<>();
                                s4Var.c = t6Var2;
                                t6Var2.e(l9.j);
                                for (JsonValue jsonValue6 = l9.f; jsonValue6 != null; jsonValue6 = jsonValue6.h) {
                                    t4<Quaternion> t4Var5 = new t4<>();
                                    s4Var.c.a(t4Var5);
                                    t4Var5.a = jsonValue6.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l10 = jsonValue6.l("value");
                                    if (l10 != null && l10.j >= 4) {
                                        t4Var5.b = new Quaternion(l10.n(0), l10.n(1), l10.n(2), l10.n(3));
                                    }
                                }
                            }
                            JsonValue l11 = jsonValue3.l("scaling");
                            if (l11 != null && l11.u()) {
                                t6<t4<Vector3>> t6Var3 = new t6<>();
                                s4Var.d = t6Var3;
                                t6Var3.e(l11.j);
                                for (JsonValue jsonValue7 = l11.f; jsonValue7 != null; jsonValue7 = jsonValue7.h) {
                                    t4<Vector3> t4Var6 = new t4<>();
                                    s4Var.d.a(t4Var6);
                                    t4Var6.a = jsonValue7.o("keytime", 0.0f) / 1000.0f;
                                    JsonValue l12 = jsonValue7.l("value");
                                    if (l12 != null && l12.j >= 3) {
                                        t4Var6.b = new Vector3(l12.n(0), l12.n(1), l12.n(2));
                                    }
                                }
                            }
                        }
                    }
                }
                jsonValue2 = jsonValue2.h;
                o4Var2 = o4Var;
            }
        }
    }

    public l3[] k(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jsonValue)) == null) {
            t6 t6Var = new t6();
            int i = 0;
            int i2 = 0;
            for (JsonValue jsonValue2 = jsonValue.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                String j = jsonValue2.j();
                if (j.equals("POSITION")) {
                    t6Var.a(l3.f());
                } else if (j.equals("NORMAL")) {
                    t6Var.a(l3.e());
                } else if (j.equals("COLOR")) {
                    t6Var.a(l3.d());
                } else if (j.equals("COLORPACKED")) {
                    t6Var.a(l3.c());
                } else if (j.equals("TANGENT")) {
                    t6Var.a(l3.g());
                } else if (j.equals("BINORMAL")) {
                    t6Var.a(l3.a());
                } else if (j.startsWith("TEXCOORD")) {
                    t6Var.a(l3.h(i));
                    i++;
                } else if (j.startsWith("BLENDWEIGHT")) {
                    t6Var.a(l3.b(i2));
                    i2++;
                } else {
                    throw new GdxRuntimeException("Unknown vertex attribute '" + j + "', should be one of position, normal, uv, tangent or binormal");
                }
            }
            return (l3[]) t6Var.m(l3.class);
        }
        return (l3[]) invokeL.objValue;
    }

    public d3 l(JsonValue jsonValue) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jsonValue)) == null) {
            if (jsonValue.j >= 3) {
                return new d3(jsonValue.n(0), jsonValue.n(1), jsonValue.n(2), 1.0f);
            }
            throw new GdxRuntimeException("Expected Color values <> than three.");
        }
        return (d3) invokeL.objValue;
    }

    public void m(o4 o4Var, JsonValue jsonValue, String str) {
        JsonValue l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048580, this, o4Var, jsonValue, str) == null) && (l = jsonValue.l("materials")) != null) {
            o4Var.c.e(l.j);
            for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                ModelMaterial modelMaterial = new ModelMaterial();
                String r = jsonValue2.r("id", null);
                if (r != null) {
                    modelMaterial.a = r;
                    JsonValue l2 = jsonValue2.l("diffuse");
                    if (l2 != null) {
                        modelMaterial.c = l(l2);
                    }
                    JsonValue l3 = jsonValue2.l("ambient");
                    if (l3 != null) {
                        modelMaterial.b = l(l3);
                    }
                    JsonValue l4 = jsonValue2.l("emissive");
                    if (l4 != null) {
                        modelMaterial.e = l(l4);
                    }
                    JsonValue l5 = jsonValue2.l("specular");
                    if (l5 != null) {
                        modelMaterial.d = l(l5);
                    }
                    JsonValue l6 = jsonValue2.l("reflection");
                    if (l6 != null) {
                        modelMaterial.f = l(l6);
                    }
                    modelMaterial.g = jsonValue2.o("shininess", 0.0f);
                    modelMaterial.h = jsonValue2.o(NativeConstants.OPACITY, 1.0f);
                    JsonValue l7 = jsonValue2.l(PathUtils.THUMBNAIL_DIRECTORY_NAME);
                    if (l7 != null) {
                        for (JsonValue jsonValue3 = l7.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                            v4 v4Var = new v4();
                            if (jsonValue3.r("id", null) != null) {
                                String r2 = jsonValue3.r(BreakpointSQLiteKey.FILENAME, null);
                                if (r2 != null) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append(str);
                                    String str2 = "/";
                                    sb.append((str.length() == 0 || str.endsWith("/")) ? "" : "");
                                    sb.append(r2);
                                    v4Var.a = sb.toString();
                                    v4Var.b = t(jsonValue3.l("uvTranslation"), 0.0f, 0.0f);
                                    v4Var.c = t(jsonValue3.l("uvScaling"), 1.0f, 1.0f);
                                    String r3 = jsonValue3.r("type", null);
                                    if (r3 != null) {
                                        v4Var.d = r(r3);
                                        if (modelMaterial.i == null) {
                                            modelMaterial.i = new t6<>();
                                        }
                                        modelMaterial.i.a(v4Var);
                                    } else {
                                        throw new GdxRuntimeException("Texture needs type.");
                                    }
                                } else {
                                    throw new GdxRuntimeException("Texture needs filename.");
                                }
                            } else {
                                throw new GdxRuntimeException("Texture has no id.");
                            }
                        }
                        continue;
                    }
                    o4Var.c.a(modelMaterial);
                } else {
                    throw new GdxRuntimeException("Material needs an id.");
                }
            }
        }
    }

    public void n(o4 o4Var, JsonValue jsonValue) {
        JsonValue l;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, o4Var, jsonValue) == null) && (l = jsonValue.l("meshes")) != null) {
            o4Var.b.e(l.j);
            for (JsonValue jsonValue2 = l.f; jsonValue2 != null; jsonValue2 = jsonValue2.h) {
                p4 p4Var = new p4();
                jsonValue2.r("id", "");
                p4Var.a = k(jsonValue2.K("attributes"));
                p4Var.b = jsonValue2.K("vertices").e();
                JsonValue K = jsonValue2.K("parts");
                t6 t6Var = new t6();
                for (JsonValue jsonValue3 = K.f; jsonValue3 != null; jsonValue3 = jsonValue3.h) {
                    q4 q4Var = new q4();
                    String r = jsonValue3.r("id", null);
                    if (r != null) {
                        t6.b it = t6Var.iterator();
                        while (it.hasNext()) {
                            if (((q4) it.next()).a.equals(r)) {
                                throw new GdxRuntimeException("Mesh part with id '" + r + "' already in defined");
                            }
                        }
                        q4Var.a = r;
                        String r2 = jsonValue3.r("type", null);
                        if (r2 != null) {
                            q4Var.c = s(r2);
                            q4Var.b = jsonValue3.K("indices").i();
                            t6Var.a(q4Var);
                        } else {
                            throw new GdxRuntimeException("No primitive type given for mesh part '" + r + "'");
                        }
                    } else {
                        throw new GdxRuntimeException("Not id given for mesh part");
                    }
                }
                p4Var.c = (q4[]) t6Var.m(q4.class);
                o4Var.b.a(p4Var);
            }
        }
    }

    public o4 o(c3 c3Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, c3Var)) == null) {
            JsonValue a = this.d.a(c3Var);
            o4 o4Var = new o4();
            JsonValue K = a.K("version");
            o4Var.a[0] = K.p(0);
            o4Var.a[1] = K.p(1);
            short[] sArr = o4Var.a;
            if (sArr[0] == 0 && sArr[1] == 1) {
                a.r("id", "");
                n(o4Var, a);
                m(o4Var, a, c3Var.i().j());
                p(o4Var, a);
                j(o4Var, a);
                return o4Var;
            }
            throw new GdxRuntimeException("Model version not supported");
        }
        return (o4) invokeL.objValue;
    }

    public int r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str.equalsIgnoreCase("AMBIENT")) {
                return 4;
            }
            if (str.equalsIgnoreCase("BUMP")) {
                return 8;
            }
            if (str.equalsIgnoreCase("DIFFUSE")) {
                return 2;
            }
            if (str.equalsIgnoreCase("EMISSIVE")) {
                return 3;
            }
            if (str.equalsIgnoreCase(HlsPlaylistParser.METHOD_NONE)) {
                return 1;
            }
            if (str.equalsIgnoreCase("NORMAL")) {
                return 7;
            }
            if (str.equalsIgnoreCase("REFLECTION")) {
                return 10;
            }
            if (str.equalsIgnoreCase("SHININESS")) {
                return 6;
            }
            if (str.equalsIgnoreCase("SPECULAR")) {
                return 5;
            }
            if (str.equalsIgnoreCase("TRANSPARENCY")) {
                return 9;
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public r4 q(JsonValue jsonValue) {
        InterceptResult invokeL;
        Vector3 vector3;
        Quaternion quaternion;
        Vector3 vector32;
        String str;
        String str2;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, jsonValue)) == null) {
            e4 e4Var = this;
            r4 r4Var = new r4();
            String str3 = null;
            String r = jsonValue.r("id", null);
            if (r != null) {
                r4Var.a = r;
                String str4 = "translation";
                JsonValue l = jsonValue.l("translation");
                if (l != null && l.j != 3) {
                    throw new GdxRuntimeException("Node translation incomplete");
                }
                boolean z = true;
                if (l == null) {
                    vector3 = null;
                } else {
                    vector3 = new Vector3(l.n(0), l.n(1), l.n(2));
                }
                r4Var.b = vector3;
                String str5 = "rotation";
                JsonValue l2 = jsonValue.l("rotation");
                if (l2 != null && l2.j != 4) {
                    throw new GdxRuntimeException("Node rotation incomplete");
                }
                if (l2 == null) {
                    quaternion = null;
                } else {
                    quaternion = new Quaternion(l2.n(0), l2.n(1), l2.n(2), l2.n(3));
                }
                r4Var.c = quaternion;
                JsonValue l3 = jsonValue.l("scale");
                if (l3 != null && l3.j != 3) {
                    throw new GdxRuntimeException("Node scale incomplete");
                }
                if (l3 == null) {
                    vector32 = null;
                } else {
                    vector32 = new Vector3(l3.n(0), l3.n(1), l3.n(2));
                }
                r4Var.d = vector32;
                jsonValue.r("mesh", null);
                JsonValue l4 = jsonValue.l("parts");
                if (l4 != null) {
                    r4Var.e = new u4[l4.j];
                    JsonValue jsonValue2 = l4.f;
                    int i2 = 0;
                    while (jsonValue2 != null) {
                        u4 u4Var = new u4();
                        String r2 = jsonValue2.r("meshpartid", str3);
                        String r3 = jsonValue2.r("materialid", str3);
                        if (r2 != null && r3 != null) {
                            u4Var.a = r3;
                            u4Var.b = r2;
                            JsonValue l5 = jsonValue2.l("bones");
                            if (l5 != null) {
                                u4Var.c = new u6<>(z, l5.j, String.class, Matrix4.class);
                                JsonValue jsonValue3 = l5.f;
                                while (jsonValue3 != null) {
                                    String r4 = jsonValue3.r("node", null);
                                    if (r4 != null) {
                                        Matrix4 matrix4 = new Matrix4();
                                        JsonValue l6 = jsonValue3.l(str4);
                                        if (l6 != null && l6.j >= 3) {
                                            str = str4;
                                            matrix4.translate(l6.n(0), l6.n(1), l6.n(2));
                                        } else {
                                            str = str4;
                                        }
                                        JsonValue l7 = jsonValue3.l(str5);
                                        if (l7 != null && l7.j >= 4) {
                                            str2 = str5;
                                            i = 3;
                                            matrix4.rotate(e4Var.e.set(l7.n(0), l7.n(1), l7.n(2), l7.n(3)));
                                        } else {
                                            str2 = str5;
                                            i = 3;
                                        }
                                        JsonValue l8 = jsonValue3.l("scale");
                                        if (l8 != null && l8.j >= i) {
                                            matrix4.scale(l8.n(0), l8.n(1), l8.n(2));
                                        }
                                        u4Var.c.e(r4, matrix4);
                                        jsonValue3 = jsonValue3.h;
                                        e4Var = this;
                                        str4 = str;
                                        str5 = str2;
                                    } else {
                                        throw new GdxRuntimeException("Bone node ID missing");
                                    }
                                }
                                continue;
                            }
                            r4Var.e[i2] = u4Var;
                            jsonValue2 = jsonValue2.h;
                            i2++;
                            str3 = null;
                            e4Var = this;
                            str4 = str4;
                            str5 = str5;
                            z = true;
                        } else {
                            throw new GdxRuntimeException("Node " + r + " part is missing meshPartId or materialId");
                        }
                    }
                }
                JsonValue l9 = jsonValue.l(CriusAttrConstants.CHILDREN);
                if (l9 != null) {
                    r4Var.f = new r4[l9.j];
                    JsonValue jsonValue4 = l9.f;
                    int i3 = 0;
                    while (jsonValue4 != null) {
                        r4Var.f[i3] = q(jsonValue4);
                        jsonValue4 = jsonValue4.h;
                        i3++;
                    }
                }
                return r4Var;
            }
            throw new GdxRuntimeException("Node id missing.");
        }
        return (r4) invokeL.objValue;
    }

    public int s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            if (str.equals("TRIANGLES")) {
                return 4;
            }
            if (str.equals("LINES")) {
                return 1;
            }
            if (str.equals("POINTS")) {
                return 0;
            }
            if (str.equals("TRIANGLE_STRIP")) {
                return 5;
            }
            if (str.equals("LINE_STRIP")) {
                return 3;
            }
            throw new GdxRuntimeException("Unknown primitive type '" + str + "', should be one of triangle, trianglestrip, line, linestrip, lineloop or point");
        }
        return invokeL.intValue;
    }

    public Vector2 t(JsonValue jsonValue, float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{jsonValue, Float.valueOf(f), Float.valueOf(f2)})) == null) {
            if (jsonValue == null) {
                return new Vector2(f, f2);
            }
            if (jsonValue.j == 2) {
                return new Vector2(jsonValue.n(0), jsonValue.n(1));
            }
            throw new GdxRuntimeException("Expected Vector2 values <> than two.");
        }
        return (Vector2) invokeCommon.objValue;
    }
}
