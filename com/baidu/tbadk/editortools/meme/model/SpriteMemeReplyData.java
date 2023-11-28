package com.baidu.tbadk.editortools.meme.model;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.wordscommand.util.CommandUBCHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001:\u0002+,BG\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0006HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003JI\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020)HÖ\u0001J\t\u0010*\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000e\"\u0004\b\u001e\u0010\u0010¨\u0006-"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData;", "", "titleStr", "", "btnStr", "scene", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$SPRITE_SCENE;", "playAnimation", "", "clickCallback", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$Callback;", "needUpdateTitle", "(Ljava/lang/String;Ljava/lang/String;Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$SPRITE_SCENE;ZLcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$Callback;Z)V", "getBtnStr", "()Ljava/lang/String;", "setBtnStr", "(Ljava/lang/String;)V", "getClickCallback", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$Callback;", "getNeedUpdateTitle", "()Z", "setNeedUpdateTitle", "(Z)V", "getPlayAnimation", "setPlayAnimation", "getScene", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$SPRITE_SCENE;", "setScene", "(Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$SPRITE_SCENE;)V", "getTitleStr", "setTitleStr", "component1", "component2", "component3", "component4", "component5", "component6", CommandUBCHelper.COMMAND_UBC_TYPE_COPY, "equals", "other", "hashCode", "", "toString", "Callback", "SPRITE_SCENE", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteMemeReplyData {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public SPRITE_SCENE c;
    public boolean d;
    public final a e;
    public boolean f;

    /* loaded from: classes5.dex */
    public interface a {

        /* renamed from: com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0219a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public static void a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(65536, null, aVar) == null) {
                }
            }

            public static void b(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(65537, null, aVar) == null) {
                }
            }
        }

        void a();

        void b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SpriteMemeReplyData() {
        this(null, null, null, false, null, false, 63, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr = newInitContext.callArgs;
                this((String) objArr[0], (String) objArr[1], (SPRITE_SCENE) objArr[2], ((Boolean) objArr[3]).booleanValue(), (a) objArr[4], ((Boolean) objArr[5]).booleanValue(), ((Integer) objArr[6]).intValue(), (DefaultConstructorMarker) objArr[7]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SpriteMemeReplyData) {
                SpriteMemeReplyData spriteMemeReplyData = (SpriteMemeReplyData) obj;
                return Intrinsics.areEqual(this.a, spriteMemeReplyData.a) && Intrinsics.areEqual(this.b, spriteMemeReplyData.b) && this.c == spriteMemeReplyData.c && this.d == spriteMemeReplyData.d && Intrinsics.areEqual(this.e, spriteMemeReplyData.e) && this.f == spriteMemeReplyData.f;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v6, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int hashCode = this.a.hashCode() * 31;
            String str = this.b;
            int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.c.hashCode()) * 31;
            boolean z = this.d;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (hashCode2 + i) * 31;
            a aVar = this.e;
            int hashCode3 = (i2 + (aVar != null ? aVar.hashCode() : 0)) * 31;
            boolean z2 = this.f;
            return hashCode3 + (z2 ? 1 : z2 ? 1 : 0);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return "SpriteMemeReplyData(titleStr=" + this.a + ", btnStr=" + this.b + ", scene=" + this.c + ", playAnimation=" + this.d + ", clickCallback=" + this.e + ", needUpdateTitle=" + this.f + ')';
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$SPRITE_SCENE;", "", "(Ljava/lang/String;I)V", "SCENE_PB", "SCENE_REPLY_DEFAULT", "SCENE_REPLY_REFRESH", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class SPRITE_SCENE {
        public static final /* synthetic */ SPRITE_SCENE[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SPRITE_SCENE SCENE_PB;
        public static final SPRITE_SCENE SCENE_REPLY_DEFAULT;
        public static final SPRITE_SCENE SCENE_REPLY_REFRESH;
        public transient /* synthetic */ FieldHolder $fh;

        public static final /* synthetic */ SPRITE_SCENE[] $values() {
            return new SPRITE_SCENE[]{SCENE_PB, SCENE_REPLY_DEFAULT, SCENE_REPLY_REFRESH};
        }

        public static SPRITE_SCENE valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (SPRITE_SCENE) Enum.valueOf(SPRITE_SCENE.class, str) : (SPRITE_SCENE) invokeL.objValue;
        }

        public static SPRITE_SCENE[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (SPRITE_SCENE[]) $VALUES.clone() : (SPRITE_SCENE[]) invokeV.objValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2122470461, "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$SPRITE_SCENE;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2122470461, "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeReplyData$SPRITE_SCENE;");
                    return;
                }
            }
            SCENE_PB = new SPRITE_SCENE("SCENE_PB", 0);
            SCENE_REPLY_DEFAULT = new SPRITE_SCENE("SCENE_REPLY_DEFAULT", 1);
            SCENE_REPLY_REFRESH = new SPRITE_SCENE("SCENE_REPLY_REFRESH", 2);
            $VALUES = $values();
        }

        public SPRITE_SCENE(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                }
            }
        }
    }

    @JvmOverloads
    public SpriteMemeReplyData(String titleStr, String str, SPRITE_SCENE scene, boolean z, a aVar, boolean z2) {
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {titleStr, str, scene, Boolean.valueOf(z), aVar, Boolean.valueOf(z2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(titleStr, "titleStr");
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.a = titleStr;
        this.b = str;
        this.c = scene;
        this.d = z;
        this.e = aVar;
        this.f = z2;
        if (str != null && str.length() != 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            this.c = SPRITE_SCENE.SCENE_REPLY_DEFAULT;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ SpriteMemeReplyData(String str, String str2, SPRITE_SCENE sprite_scene, boolean z, a aVar, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, r12, r1, r2, r0, r3);
        String str3;
        boolean z3;
        boolean z4;
        str = (i & 1) != 0 ? "" : str;
        if ((i & 2) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        SPRITE_SCENE sprite_scene2 = (i & 4) != 0 ? SPRITE_SCENE.SCENE_REPLY_DEFAULT : sprite_scene;
        if ((i & 8) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        a aVar2 = (i & 16) == 0 ? aVar : null;
        if ((i & 32) != 0) {
            z4 = true;
        } else {
            z4 = z2;
        }
    }

    public final String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (a) invokeV.objValue;
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return invokeV.booleanValue;
    }

    public final boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public final SPRITE_SCENE e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (SPRITE_SCENE) invokeV.objValue;
    }

    public final String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.a;
        }
        return (String) invokeV.objValue;
    }

    public final void g(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f = z;
        }
    }
}
