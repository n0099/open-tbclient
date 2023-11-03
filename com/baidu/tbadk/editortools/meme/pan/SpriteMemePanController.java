package com.baidu.tbadk.editortools.meme.pan;

import android.content.Context;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.face.platform.utils.FileUtils;
import com.baidu.sapi2.SapiAccount;
import com.baidu.tbadk.core.GlobalBuildConfig;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.meme.list.GeneratedErrorData;
import com.baidu.tbadk.editortools.meme.list.MemeData;
import com.baidu.tbadk.editortools.meme.model.QuerySpriteMemeModel;
import com.baidu.tbadk.editortools.meme.model.SpriteMemeLoopModel;
import com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData;
import com.baidu.tbadk.editortools.meme.pan.SpriteMemePan;
import com.baidu.tbadk.editortools.meme.pan.SpriteMemePanController;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.tieba.cg5;
import com.baidu.tieba.of5;
import com.baidu.tieba.pf5;
import com.baidu.tieba.qf5;
import com.baidu.tieba.wf5;
import com.baidu.tieba.xf5;
import com.baidu.tieba.yf5;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0007Jd\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\b\b\u0002\u0010\u001e\u001a\u00020\u00162\b\b\u0002\u0010\u001f\u001a\u00020\u0018H\u0007J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J4\u0010$\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u00162\b\u0010&\u001a\u0004\u0018\u00010\u0016H\u0007J6\u0010'\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010\u00162\b\u0010&\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u001a\u0010(\u001a\u00020\u001a2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,J@\u0010-\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0016H\u0007JD\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u0002002\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010%\u001a\u00020\u00162\b\b\u0002\u0010&\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J(\u00101\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020!2\u0006\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0016H\u0002J(\u00104\u001a\u00020\u00112\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u00102\u001a\u00020!H\u0007J\b\u00105\u001a\u00020\u0011H\u0007J^\u00106\u001a\u00020\u00112\u0006\u00107\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u001d\u001a\u00020\u001a2\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020:092\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanController;", "", "()V", "generateLoopModel", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel;", "getGenerateLoopModel", "()Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeLoopModel;", "generateLoopModel$delegate", "Lkotlin/Lazy;", "model", "Lcom/baidu/tbadk/editortools/meme/model/QuerySpriteMemeModel;", "getModel", "()Lcom/baidu/tbadk/editortools/meme/model/QuerySpriteMemeModel;", "model$delegate", "querySpriteMemeRunnable", "Ljava/lang/Runnable;", "cancelModelRequest", "", "firstRequest", "spriteMemePan", "Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePan;", "scene", "", "forumId", "", "hasContent", "", "forumNameNullable", "tidNullable", "needPlayAnimation", "query", "memeId", "getObjSourceByStateType", "", "type", "Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanStateType;", "hideSpriteMeme", ForumBroadcastHelper.KEY_PARMARS_FORUM_NAME, "tid", "initSpriteMeme", "isSpriteMeme", "context", "Landroid/content/Context;", SapiAccount.SAPI_ACCOUNT_FROMTYPE, "Lcom/baidu/tbadk/editortools/pb/PbNewEditorTool$InputShowType;", "requestQuery", "startLoop", "spriteMemeQueryData", "Lcom/baidu/tbadk/editortools/meme/model/SpriteMemeQueryData;", "statClick", "objSource", "fname", "statSpriteShow", "unRegisterCallbacks", "updateSpriteMemePanState", "stateType", "memeList", "", "Lcom/baidu/tbadk/editortools/meme/list/MemeData;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpriteMemePanController {
    public static /* synthetic */ Interceptable $ic;
    public static final SpriteMemePanController a;
    public static final Lazy b;
    public static final Lazy c;
    public static Runnable d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1749731783, "Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanController$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1749731783, "Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanController$a;");
                    return;
                }
            }
            int[] iArr = new int[SpriteMemePanStateType.values().length];
            iArr[SpriteMemePanStateType.UNINPUT_SHOW.ordinal()] = 1;
            iArr[SpriteMemePanStateType.UNINPUT_HIDE.ordinal()] = 2;
            iArr[SpriteMemePanStateType.INPUT_SHOW.ordinal()] = 3;
            iArr[SpriteMemePanStateType.INPUT_HIDE.ordinal()] = 4;
            iArr[SpriteMemePanStateType.INIT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    @JvmOverloads
    public static final void e(SpriteMemePan spriteMemePan, String scene, long j, boolean z, String str, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65542, null, new Object[]{spriteMemePan, scene, Long.valueOf(j), Boolean.valueOf(z), str, str2, Boolean.valueOf(z2)}) == null) {
            Intrinsics.checkNotNullParameter(spriteMemePan, "spriteMemePan");
            Intrinsics.checkNotNullParameter(scene, "scene");
            g(spriteMemePan, scene, j, z, str, str2, z2, null, 0L, 384, null);
        }
    }

    /* loaded from: classes5.dex */
    public static final class b implements QuerySpriteMemeModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ SpriteMemePan c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;

        public b(String str, boolean z, SpriteMemePan spriteMemePan, long j, String str2, String str3, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Boolean.valueOf(z), spriteMemePan, Long.valueOf(j), str2, str3, Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = z;
            this.c = spriteMemePan;
            this.d = j;
            this.e = str2;
            this.f = str3;
            this.g = z2;
        }

        @Override // com.baidu.tbadk.editortools.meme.model.QuerySpriteMemeModel.a
        public void a(xf5 spriteMemeQueryData, String requestQuery) {
            SpriteMemePanStateType spriteMemePanStateType;
            SpriteMemePanStateType spriteMemePanStateType2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, spriteMemeQueryData, requestQuery) == null) {
                Intrinsics.checkNotNullParameter(spriteMemeQueryData, "spriteMemeQueryData");
                Intrinsics.checkNotNullParameter(requestQuery, "requestQuery");
                if (!Intrinsics.areEqual(this.a, requestQuery)) {
                    return;
                }
                if (spriteMemeQueryData.c()) {
                    if (this.b) {
                        spriteMemePanStateType2 = SpriteMemePanStateType.INPUT_HIDE;
                    } else {
                        spriteMemePanStateType2 = SpriteMemePanStateType.UNINPUT_HIDE;
                    }
                    SpriteMemePanController.u(spriteMemePanStateType2, this.c, this.d, this.e, this.f, this.g, null, false, 192, null);
                    return;
                }
                if (this.b) {
                    spriteMemePanStateType = SpriteMemePanStateType.INPUT_SHOW;
                } else {
                    spriteMemePanStateType = SpriteMemePanStateType.UNINPUT_SHOW;
                }
                SpriteMemePanController.a.p(spriteMemeQueryData, spriteMemePanStateType, this.c, this.d, this.e, this.f, this.g);
                List<MemeData> a = spriteMemeQueryData.a();
                for (MemeData memeData : a) {
                    memeData.setRequestQuery(requestQuery);
                }
                SpriteMemePanController.u(spriteMemePanStateType, this.c, this.d, this.e, this.f, this.g, a, false, 128, null);
            }
        }

        @Override // com.baidu.tbadk.editortools.meme.model.QuerySpriteMemeModel.a
        public void onError() {
            SpriteMemePanStateType spriteMemePanStateType;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.b) {
                    spriteMemePanStateType = SpriteMemePanStateType.INPUT_HIDE;
                } else {
                    spriteMemePanStateType = SpriteMemePanStateType.UNINPUT_HIDE;
                }
                SpriteMemePanController.u(spriteMemePanStateType, this.c, this.d, this.e, this.f, this.g, null, false, 192, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class c implements SpriteMemeLoopModel.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ List<MemeData> a;
        public final /* synthetic */ SpriteMemePanStateType b;
        public final /* synthetic */ SpriteMemePan c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ boolean g;

        public c(List<MemeData> list, SpriteMemePanStateType spriteMemePanStateType, SpriteMemePan spriteMemePan, long j, String str, String str2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {list, spriteMemePanStateType, spriteMemePan, Long.valueOf(j), str, str2, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = list;
            this.b = spriteMemePanStateType;
            this.c = spriteMemePan;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = z;
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeLoopModel.a
        public void a(wf5 spriteMemeLoopData) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, spriteMemeLoopData) == null) {
                Intrinsics.checkNotNullParameter(spriteMemeLoopData, "spriteMemeLoopData");
                List<MemeData> list = this.a;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((MemeData) obj).getType() != 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        arrayList.add(obj);
                    }
                }
                List<MemeData> plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) spriteMemeLoopData.a());
                for (MemeData memeData : plus) {
                    memeData.setRequestQuery(SpriteMemePanController.a.i().c());
                }
                SpriteMemePanController.u(this.b, this.c, this.d, this.e, this.f, this.g, plus, false, 128, null);
            }
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeLoopModel.a
        public void onError() {
            int i;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                List<MemeData> list = this.a;
                ArrayList arrayList = new ArrayList();
                Iterator<T> it = list.iterator();
                while (true) {
                    boolean z2 = true;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (((MemeData) next).getType() != 2) {
                        z2 = false;
                    }
                    if (z2) {
                        arrayList.add(next);
                    }
                }
                int size = arrayList.size();
                List<MemeData> list2 = this.a;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : list2) {
                    if (((MemeData) obj).getType() != 2) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(size);
                for (i = 0; i < size; i++) {
                    arrayList3.add(new GeneratedErrorData());
                }
                List<MemeData> plus = CollectionsKt___CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3);
                for (MemeData memeData : plus) {
                    memeData.setRequestQuery(SpriteMemePanController.a.i().c());
                }
                SpriteMemePanController.u(this.b, this.c, this.d, this.e, this.f, this.g, plus, false, 128, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class d implements SpriteMemeReplyData.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public d(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SpriteMemeReplyData.a.C0219a.a(this);
            }
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SpriteMemePanController.a.i().f();
                SpriteMemePanController.a.q(3, 3, this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class e implements SpriteMemeReplyData.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpriteMemePan a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public e(SpriteMemePan spriteMemePan, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteMemePan, Long.valueOf(j), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spriteMemePan;
            this.b = j;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SpriteMemePanController.g(this.a, "click_recom", this.b, false, this.c, this.d, false, null, 0L, FileUtils.S_IRWXU, null);
                SpriteMemePanController.a.q(2, 1, this.c, this.d);
            }
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SpriteMemeReplyData.a.C0219a.b(this);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class f implements SpriteMemeReplyData.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public f(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
            this.b = str2;
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SpriteMemeReplyData.a.C0219a.a(this);
            }
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SpriteMemePanController.a.i().f();
                SpriteMemePanController.a.q(3, 4, this.a, this.b);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class g implements SpriteMemeReplyData.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SpriteMemePan a;
        public final /* synthetic */ long b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public g(SpriteMemePan spriteMemePan, long j, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {spriteMemePan, Long.valueOf(j), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = spriteMemePan;
            this.b = j;
            this.c = str;
            this.d = str2;
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                SpriteMemePanController.g(this.a, "click_recom", this.b, true, this.c, this.d, false, null, 0L, FileUtils.S_IRWXU, null);
                SpriteMemePanController.a.q(2, 2, this.c, this.d);
            }
        }

        @Override // com.baidu.tbadk.editortools.meme.model.SpriteMemeReplyData.a
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                SpriteMemeReplyData.a.C0219a.b(this);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(596233508, "Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanController;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(596233508, "Lcom/baidu/tbadk/editortools/meme/pan/SpriteMemePanController;");
                return;
            }
        }
        a = new SpriteMemePanController();
        b = LazyKt__LazyJVMKt.lazy(SpriteMemePanController$model$2.INSTANCE);
        c = LazyKt__LazyJVMKt.lazy(SpriteMemePanController$generateLoopModel$2.INSTANCE);
    }

    public SpriteMemePanController() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @JvmStatic
    public static final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, null) == null) {
            a.i().a();
            SpriteMemeLoopModel.m(a.h(), false, 1, null);
        }
    }

    @JvmStatic
    public static final void s() {
        Runnable runnable;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65551, null) == null) && (runnable = d) != null) {
            SafeHandler.getInst().removeCallbacks(runnable);
            d = null;
        }
    }

    public final SpriteMemeLoopModel h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return (SpriteMemeLoopModel) c.getValue();
        }
        return (SpriteMemeLoopModel) invokeV.objValue;
    }

    public final QuerySpriteMemeModel i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (QuerySpriteMemeModel) b.getValue();
        }
        return (QuerySpriteMemeModel) invokeV.objValue;
    }

    @JvmStatic
    @JvmOverloads
    public static final void f(SpriteMemePan spriteMemePan, String scene, long j, boolean z, String str, String str2, boolean z2, String query, long j2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{spriteMemePan, scene, Long.valueOf(j), Boolean.valueOf(z), str, str2, Boolean.valueOf(z2), query, Long.valueOf(j2)}) == null) {
            Intrinsics.checkNotNullParameter(spriteMemePan, "spriteMemePan");
            Intrinsics.checkNotNullParameter(scene, "scene");
            Intrinsics.checkNotNullParameter(query, "query");
            if (str == null) {
                str3 = "";
            } else {
                str3 = str;
            }
            if (str2 == null) {
                str4 = "0";
            } else {
                str4 = str2;
            }
            a.i().m(query);
            a.i().j(j);
            a.i().o(scene);
            a.i().l(j2);
            a.i().k(str3);
            a.i().p(str4);
            a.i().n(new b(query, z, spriteMemePan, j, str3, str4, z2));
            a.i().b();
        }
    }

    public static /* synthetic */ void g(SpriteMemePan spriteMemePan, String str, long j, boolean z, String str2, String str3, boolean z2, String str4, long j2, int i, Object obj) {
        String str5;
        long j3;
        boolean z3;
        String str6;
        String str7;
        String str8 = "";
        if ((i & 2) != 0) {
            str5 = "";
        } else {
            str5 = str;
        }
        long j4 = 0;
        if ((i & 4) != 0) {
            j3 = 0;
        } else {
            j3 = j;
        }
        boolean z4 = false;
        if ((i & 8) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 16) != 0) {
            str6 = "";
        } else {
            str6 = str2;
        }
        if ((i & 32) != 0) {
            str7 = "";
        } else {
            str7 = str3;
        }
        if ((i & 64) == 0) {
            z4 = z2;
        }
        if ((i & 128) == 0) {
            str8 = str4;
        }
        if ((i & 256) == 0) {
            j4 = j2;
        }
        f(spriteMemePan, str5, j3, z3, str6, str7, z4, str8, j4);
    }

    @JvmStatic
    public static final int j(SpriteMemePanStateType type, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65545, null, type, z)) == null) {
            Intrinsics.checkNotNullParameter(type, "type");
            int i = a.$EnumSwitchMapping$0[type.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return 4;
                    }
                    if (i == 4 || !z) {
                        return 2;
                    }
                }
                return 1;
            }
            return 3;
        }
        return invokeLZ.intValue;
    }

    public final boolean m(Context context, PbNewEditorTool.InputShowType inputShowType) {
        InterceptResult invokeLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, inputShowType)) == null) {
            if (yf5.a.a() && (inputShowType == PbNewEditorTool.InputShowType.REPLY || inputShowType == PbNewEditorTool.InputShowType.REPLY_BIG_IMAGE || inputShowType == PbNewEditorTool.InputShowType.REPLY_VIDEO)) {
                z = true;
            } else {
                z = false;
            }
            if (context == null) {
                return z;
            }
            if (z && !UtilHelper.isFoldScreen() && !UtilHelper.isLargeScreen(context)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    @JvmStatic
    public static final SpriteMemePanStateType k(SpriteMemePan spriteMemePan, boolean z, long j, String str, String str2) {
        InterceptResult invokeCommon;
        SpriteMemePanStateType spriteMemePanStateType;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{spriteMemePan, Boolean.valueOf(z), Long.valueOf(j), str, str2})) == null) {
            Intrinsics.checkNotNullParameter(spriteMemePan, "spriteMemePan");
            if (z) {
                spriteMemePanStateType = SpriteMemePanStateType.INPUT_HIDE;
            } else {
                spriteMemePanStateType = SpriteMemePanStateType.UNINPUT_HIDE;
            }
            u(spriteMemePanStateType, spriteMemePan, j, str, str2, true, null, false, 192, null);
            return spriteMemePanStateType;
        }
        return (SpriteMemePanStateType) invokeCommon.objValue;
    }

    @JvmStatic
    public static final void l(SpriteMemePan spriteMemePan, long j, String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65547, null, new Object[]{spriteMemePan, Long.valueOf(j), str, str2, Boolean.valueOf(z)}) != null) || spriteMemePan == null) {
            return;
        }
        u(SpriteMemePanStateType.INIT, spriteMemePan, j, str, str2, false, null, z, 96, null);
    }

    @JvmStatic
    public static final void n(final SpriteMemePan spriteMemePan, final String query, final long j, final boolean z, final String str, final String str2) {
        SpriteMemePanStateType spriteMemePanStateType;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{spriteMemePan, query, Long.valueOf(j), Boolean.valueOf(z), str, str2}) == null) {
            Intrinsics.checkNotNullParameter(spriteMemePan, "spriteMemePan");
            Intrinsics.checkNotNullParameter(query, "query");
            s();
            if (StringsKt__StringsJVMKt.isBlank(query)) {
                if (z) {
                    spriteMemePanStateType = SpriteMemePanStateType.INPUT_HIDE;
                } else {
                    spriteMemePanStateType = SpriteMemePanStateType.UNINPUT_HIDE;
                }
                u(spriteMemePanStateType, spriteMemePan, j, str, str2, false, null, false, 224, null);
                return;
            }
            d = new Runnable() { // from class: com.baidu.tieba.ag5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        SpriteMemePanController.o(SpriteMemePan.this, j, z, str, str2, query);
                    }
                }
            };
            SafeHandler.getInst().postDelayed(d, of5.a.a().f());
        }
    }

    public static final void o(SpriteMemePan spriteMemePan, long j, boolean z, String str, String str2, String query) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{spriteMemePan, Long.valueOf(j), Boolean.valueOf(z), str, str2, query}) == null) {
            Intrinsics.checkNotNullParameter(spriteMemePan, "$spriteMemePan");
            Intrinsics.checkNotNullParameter(query, "$query");
            g(spriteMemePan, "input_query", j, z, str, str2, false, query, 0L, 256, null);
        }
    }

    @JvmStatic
    public static final void r(String str, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65550, null, str, str2, i) == null) {
            if (str == null) {
                str = "";
            }
            if (str2 == null) {
                str2 = "0";
            }
            qf5 qf5Var = new qf5();
            qf5Var.l(1);
            qf5Var.j(i);
            qf5Var.g(str);
            qf5Var.k(str2);
            pf5.a.c(qf5Var);
        }
    }

    @JvmStatic
    public static final void t(SpriteMemePanStateType spriteMemePanStateType, SpriteMemePan spriteMemePan, long j, String str, String str2, boolean z, List<? extends MemeData> list, boolean z2) {
        String str3;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65552, null, new Object[]{spriteMemePanStateType, spriteMemePan, Long.valueOf(j), str, str2, Boolean.valueOf(z), list, Boolean.valueOf(z2)}) == null) {
            if (str == null) {
                str3 = "";
            } else {
                str3 = str;
            }
            if (str2 == null) {
                str4 = "0";
            } else {
                str4 = str2;
            }
            spriteMemePan.setFname(str3);
            spriteMemePan.setTid(str4);
            r(str3, str4, j(spriteMemePanStateType, z2));
            int i = a.$EnumSwitchMapping$0[spriteMemePanStateType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (GlobalBuildConfig.isDebug()) {
                                    throw new RuntimeException("SpriteMemePanController has unknown stateType");
                                }
                                return;
                            }
                            spriteMemePan.d(new cg5(spriteMemePanStateType, new SpriteMemeReplyData(null, null, null, z, null, false, 55, null), list));
                            return;
                        }
                        spriteMemePan.d(new cg5(spriteMemePanStateType, new SpriteMemeReplyData(of5.a.a().i(of5.a.a().e()), null, null, z, new g(spriteMemePan, j, str3, str4), false, 38, null), list));
                        d();
                        return;
                    }
                    spriteMemePan.d(new cg5(spriteMemePanStateType, new SpriteMemeReplyData(of5.a.a().i(of5.a.a().g()), of5.a.a().h(), SpriteMemeReplyData.SPRITE_SCENE.SCENE_REPLY_REFRESH, z, new f(str3, str4), false, 32, null), list));
                    return;
                }
                spriteMemePan.d(new cg5(spriteMemePanStateType, new SpriteMemeReplyData(of5.a.a().i(of5.a.a().j()), null, null, z, new e(spriteMemePan, j, str3, str4), false, 38, null), list));
                d();
                return;
            }
            spriteMemePan.d(new cg5(spriteMemePanStateType, new SpriteMemeReplyData(of5.a.a().i(of5.a.a().k()), of5.a.a().h(), SpriteMemeReplyData.SPRITE_SCENE.SCENE_REPLY_REFRESH, z, new d(str3, str4), false, 32, null), list));
        }
    }

    public static /* synthetic */ void u(SpriteMemePanStateType spriteMemePanStateType, SpriteMemePan spriteMemePan, long j, String str, String str2, boolean z, List list, boolean z2, int i, Object obj) {
        long j2;
        String str3;
        boolean z3;
        List list2;
        if ((i & 4) != 0) {
            j2 = 0;
        } else {
            j2 = j;
        }
        String str4 = "";
        if ((i & 8) != 0) {
            str3 = "";
        } else {
            str3 = str;
        }
        if ((i & 16) == 0) {
            str4 = str2;
        }
        boolean z4 = false;
        if ((i & 32) != 0) {
            z3 = false;
        } else {
            z3 = z;
        }
        if ((i & 64) != 0) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = list;
        }
        if ((i & 128) == 0) {
            z4 = z2;
        }
        t(spriteMemePanStateType, spriteMemePan, j2, str3, str4, z3, list2, z4);
    }

    public final void p(xf5 xf5Var, SpriteMemePanStateType spriteMemePanStateType, SpriteMemePan spriteMemePan, long j, String str, String str2, boolean z) {
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{xf5Var, spriteMemePanStateType, spriteMemePan, Long.valueOf(j), str, str2, Boolean.valueOf(z)}) == null) {
            String b2 = xf5Var.b();
            if (b2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                h().j(null);
                SpriteMemeLoopModel.m(h(), false, 1, null);
                return;
            }
            h().j(new c(xf5Var.a(), spriteMemePanStateType, spriteMemePan, j, str, str2, z));
            h().k(b2);
        }
    }

    public final void q(int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            qf5 qf5Var = new qf5();
            qf5Var.l(i);
            qf5Var.j(i2);
            qf5Var.g(str);
            qf5Var.k(str2);
            pf5.a.c(qf5Var);
        }
    }
}
