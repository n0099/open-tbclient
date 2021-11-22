package com.baidu.tieba.frs.voiceroom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import b.a.q0.s.u.c;
import b.a.r0.x0.c1;
import b.a.r0.x0.d1;
import b.a.r0.x0.d3.b;
import b.a.r0.x0.f1;
import b.a.r0.x0.g1;
import b.a.r0.x0.h1;
import b.a.r0.x0.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.frs.voiceroom.VoiceRoomStat;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tbclient.User;
import tbclient.VoiceRoom.VoiceRoom;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u001d\u0012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$ViewHolder;", "holder", "", "position", "", "onBindViewHolder", "(Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$ViewHolder;I)V", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$ViewHolder;", "Landroid/os/Bundle;", "arguments", "Landroid/os/Bundle;", "Lcom/baidu/tbadk/TbPageContext;", "tbPageContext", "Lcom/baidu/tbadk/TbPageContext;", "getTbPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "<init>", "(Lcom/baidu/tbadk/TbPageContext;Landroid/os/Bundle;)V", "Binding", "ViewHolder", "frs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class VoiceRoomListAdapter extends ListAdapter<VoiceRoomWrapper, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final TbPageContext<?> f50062a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f50063b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u000b\u001a\u00020\n2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$ViewHolder;", "androidx/recyclerview/widget/RecyclerView$ViewHolder", "Lcom/baidu/tbadk/TbPageContext;", "tbPageContext", "", "position", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "voiceRoomWrapper", "Landroid/os/Bundle;", "arguments", "", "bind", "(Lcom/baidu/tbadk/TbPageContext;ILcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;Landroid/os/Bundle;)V", WriteMulitImageActivityConfig.SKIN_TYPE, "changeSkin", "(I)V", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$Binding;", "binding", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$Binding;", "<init>", "(Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$Binding;)V", "frs_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final a f50064a;

        /* loaded from: classes9.dex */
        public static final class a implements View.OnClickListener {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ VoiceRoom f50065e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ Bundle f50066f;

            /* renamed from: g  reason: collision with root package name */
            public final /* synthetic */ int f50067g;

            /* renamed from: h  reason: collision with root package name */
            public final /* synthetic */ TbPageContext f50068h;

            public a(VoiceRoom voiceRoom, String str, Bundle bundle, int i2, TbPageContext tbPageContext) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {voiceRoom, str, bundle, Integer.valueOf(i2), tbPageContext};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i3 = newInitContext.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50065e = voiceRoom;
                this.f50066f = bundle;
                this.f50067g = i2;
                this.f50068h = tbPageContext;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Frs$From f2;
                long d2;
                String e2;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                    Bundle bundle = this.f50066f;
                    if (bundle != null) {
                        VoiceRoomStat voiceRoomStat = VoiceRoomStat.f50093a;
                        VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.ITEM_CLICK;
                        f2 = b.a.r0.x0.d3.a.f(bundle);
                        Integer valueOf = Integer.valueOf(this.f50067g);
                        Long l = this.f50065e.room_id;
                        d2 = b.a.r0.x0.d3.a.d(bundle);
                        Long valueOf2 = Long.valueOf(d2);
                        e2 = b.a.r0.x0.d3.a.e(bundle);
                        voiceRoomStat.c(statType, f2, valueOf, l, valueOf2, e2);
                    }
                    TbPageContext<?> tbPageContext = this.f50068h;
                    Long l2 = this.f50065e.room_id;
                    Intrinsics.checkExpressionValueIsNotNull(l2, "voiceRoom.room_id");
                    ((b.a.q0.i0.c.a) ServiceManager.getService(b.a.q0.i0.c.a.f13386a.a())).a(tbPageContext, l2.longValue());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(a aVar) {
            super(aVar.d());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50064a = aVar;
        }

        public static /* synthetic */ void bind$default(ViewHolder viewHolder, TbPageContext tbPageContext, int i2, VoiceRoomWrapper voiceRoomWrapper, Bundle bundle, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                bundle = null;
            }
            viewHolder.bind(tbPageContext, i2, voiceRoomWrapper, bundle);
        }

        public final void bind(TbPageContext<?> tbPageContext, int i2, VoiceRoomWrapper voiceRoomWrapper, Bundle bundle) {
            Frs$From f2;
            long d2;
            String e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, tbPageContext, i2, voiceRoomWrapper, bundle) == null) {
                VoiceRoom voiceRoom = voiceRoomWrapper.getVoiceRoom();
                String forumName = voiceRoomWrapper.getForumName();
                a aVar = this.f50064a;
                aVar.e().setText(voiceRoom.room_name);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = aVar.d().getResources().getString(i1.frs_voice_desc);
                Intrinsics.checkExpressionValueIsNotNull(string, "root.resources.getString(R.string.frs_voice_desc)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(voiceRoom.talker.size()), voiceRoom.joined_num}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                if (forumName.length() > 0) {
                    format = format + ' ' + forumName + (char) 21543;
                }
                aVar.b().setText(format);
                int i3 = 0;
                for (Object obj : aVar.c()) {
                    int i4 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    HeadImageView headImageView = (HeadImageView) obj;
                    List<User> list = voiceRoom.talker;
                    Intrinsics.checkExpressionValueIsNotNull(list, "voiceRoom.talker");
                    User user = (User) CollectionsKt___CollectionsKt.getOrNull(list, i3);
                    if (user != null) {
                        headImageView.startLoad(user.portrait, 12, false);
                        headImageView.setVisibility(0);
                    } else {
                        headImageView.setVisibility(8);
                    }
                    i3 = i4;
                }
                a aVar2 = new a(voiceRoom, forumName, bundle, i2, tbPageContext);
                aVar.d().setOnClickListener(aVar2);
                aVar.a().setOnClickListener(aVar2);
                if (bundle != null) {
                    VoiceRoomStat voiceRoomStat = VoiceRoomStat.f50093a;
                    VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.ITEM_EXPOSE;
                    f2 = b.a.r0.x0.d3.a.f(bundle);
                    Integer valueOf = Integer.valueOf(i2);
                    Long l = voiceRoom.room_id;
                    d2 = b.a.r0.x0.d3.a.d(bundle);
                    Long valueOf2 = Long.valueOf(d2);
                    e2 = b.a.r0.x0.d3.a.e(bundle);
                    voiceRoomStat.c(statType, f2, valueOf, l, valueOf2, e2);
                }
            }
        }

        public final void changeSkin(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                a aVar = this.f50064a;
                c d2 = c.d(aVar.d());
                d2.n(i1.J_X05);
                d2.f(c1.CAM_X0205);
                c d3 = c.d(aVar.g());
                d3.n(i1.J_X01);
                d3.v(c1.CAM_X0115);
                d3.f(c1.CAM_X0919);
                c.d(aVar.e()).v(c1.CAM_X0105);
                c.d(aVar.b()).v(c1.CAM_X0108);
                c d4 = c.d(aVar.a());
                d4.n(i1.J_X01);
                d4.v(c1.CAM_X0115);
                d4.h(c1.CAM_X0919);
                SkinManager.setLottieAnimation(aVar.f(), h1.lottie_voice_room_voicing_icon);
                aVar.f().setRepeatCount(-1);
                aVar.f().playAnimation();
            }
        }
    }

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: i  reason: collision with root package name */
        public static final C1762a f50069i;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final List<HeadImageView> f50070a;

        /* renamed from: b  reason: collision with root package name */
        public final View f50071b;

        /* renamed from: c  reason: collision with root package name */
        public final TBLottieAnimationView f50072c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f50073d;

        /* renamed from: e  reason: collision with root package name */
        public final TextView f50074e;

        /* renamed from: f  reason: collision with root package name */
        public final FrameLayout f50075f;

        /* renamed from: g  reason: collision with root package name */
        public final TextView f50076g;

        /* renamed from: h  reason: collision with root package name */
        public final TextView f50077h;

        /* renamed from: com.baidu.tieba.frs.voiceroom.VoiceRoomListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public static final class C1762a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1762a() {
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

            public final a a(View view) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) {
                    View findViewById = view.findViewById(f1.voicing_icon);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById, "root.findViewById(R.id.voicing_icon)");
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById;
                    View findViewById2 = view.findViewById(f1.voicing_text);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById2, "root.findViewById(R.id.voicing_text)");
                    TextView textView = (TextView) findViewById2;
                    View findViewById3 = view.findViewById(f1.title);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById3, "root.findViewById(R.id.title)");
                    TextView textView2 = (TextView) findViewById3;
                    View findViewById4 = view.findViewById(f1.headers);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById4, "root.findViewById(R.id.headers)");
                    FrameLayout frameLayout = (FrameLayout) findViewById4;
                    View findViewById5 = view.findViewById(f1.desc);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById5, "root.findViewById(R.id.desc)");
                    TextView textView3 = (TextView) findViewById5;
                    View findViewById6 = view.findViewById(f1.action_join);
                    Intrinsics.checkExpressionValueIsNotNull(findViewById6, "root.findViewById(R.id.action_join)");
                    return new a(view, tBLottieAnimationView, textView, textView2, frameLayout, textView3, (TextView) findViewById6);
                }
                return (a) invokeL.objValue;
            }

            public /* synthetic */ C1762a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-860753886, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-860753886, "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$a;");
                    return;
                }
            }
            f50069i = new C1762a(null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.List<com.baidu.tbadk.core.view.HeadImageView> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.util.List<com.baidu.tbadk.core.view.HeadImageView> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(View view, TBLottieAnimationView tBLottieAnimationView, TextView textView, TextView textView2, FrameLayout frameLayout, TextView textView3, TextView textView4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view, tBLottieAnimationView, textView, textView2, frameLayout, textView3, textView4};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f50071b = view;
            this.f50072c = tBLottieAnimationView;
            this.f50073d = textView;
            this.f50074e = textView2;
            this.f50075f = frameLayout;
            this.f50076g = textView3;
            this.f50077h = textView4;
            ArrayList arrayList = new ArrayList();
            this.f50070a = arrayList;
            View findViewById = this.f50075f.findViewById(f1.header0);
            Intrinsics.checkExpressionValueIsNotNull(findViewById, "headers.findViewById(R.id.header0)");
            arrayList.add(findViewById);
            List<HeadImageView> list = this.f50070a;
            View findViewById2 = this.f50075f.findViewById(f1.header1);
            Intrinsics.checkExpressionValueIsNotNull(findViewById2, "headers.findViewById(R.id.header1)");
            list.add(findViewById2);
            List<HeadImageView> list2 = this.f50070a;
            View findViewById3 = this.f50075f.findViewById(f1.header2);
            Intrinsics.checkExpressionValueIsNotNull(findViewById3, "headers.findViewById(R.id.header2)");
            list2.add(findViewById3);
            for (HeadImageView headImageView : this.f50070a) {
                headImageView.setDefaultResource(17170445);
                headImageView.setPlaceHolder(2);
                headImageView.setIsRound(true);
                headImageView.setBorderWidth((int) this.f50071b.getResources().getDimension(d1.L_X02));
                headImageView.setBorderColor(SkinManager.getColor(c1.CAM_X0402));
                headImageView.setDrawBorder(true);
            }
        }

        public final TextView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50077h : (TextView) invokeV.objValue;
        }

        public final TextView b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f50076g : (TextView) invokeV.objValue;
        }

        public final List<HeadImageView> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f50070a : (List) invokeV.objValue;
        }

        public final View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f50071b : (View) invokeV.objValue;
        }

        public final TextView e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f50074e : (TextView) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this != obj) {
                    if (obj instanceof a) {
                        a aVar = (a) obj;
                        return Intrinsics.areEqual(this.f50071b, aVar.f50071b) && Intrinsics.areEqual(this.f50072c, aVar.f50072c) && Intrinsics.areEqual(this.f50073d, aVar.f50073d) && Intrinsics.areEqual(this.f50074e, aVar.f50074e) && Intrinsics.areEqual(this.f50075f, aVar.f50075f) && Intrinsics.areEqual(this.f50076g, aVar.f50076g) && Intrinsics.areEqual(this.f50077h, aVar.f50077h);
                    }
                    return false;
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        public final TBLottieAnimationView f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f50072c : (TBLottieAnimationView) invokeV.objValue;
        }

        public final TextView g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f50073d : (TextView) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                View view = this.f50071b;
                int hashCode = (view != null ? view.hashCode() : 0) * 31;
                TBLottieAnimationView tBLottieAnimationView = this.f50072c;
                int hashCode2 = (hashCode + (tBLottieAnimationView != null ? tBLottieAnimationView.hashCode() : 0)) * 31;
                TextView textView = this.f50073d;
                int hashCode3 = (hashCode2 + (textView != null ? textView.hashCode() : 0)) * 31;
                TextView textView2 = this.f50074e;
                int hashCode4 = (hashCode3 + (textView2 != null ? textView2.hashCode() : 0)) * 31;
                FrameLayout frameLayout = this.f50075f;
                int hashCode5 = (hashCode4 + (frameLayout != null ? frameLayout.hashCode() : 0)) * 31;
                TextView textView3 = this.f50076g;
                int hashCode6 = (hashCode5 + (textView3 != null ? textView3.hashCode() : 0)) * 31;
                TextView textView4 = this.f50077h;
                return hashCode6 + (textView4 != null ? textView4.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "Binding(root=" + this.f50071b + ", voicingIcon=" + this.f50072c + ", voicingText=" + this.f50073d + ", title=" + this.f50074e + ", headers=" + this.f50075f + ", desc=" + this.f50076g + ", actionJoin=" + this.f50077h + SmallTailInfo.EMOTION_SUFFIX;
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceRoomListAdapter(TbPageContext<?> tbPageContext, Bundle bundle) {
        super(new b());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((DiffUtil.ItemCallback) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f50062a = tbPageContext;
        this.f50063b = bundle;
    }

    public final TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f50062a : (TbPageContext) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder viewHolder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewHolder, i2) == null) {
            TbPageContext<?> tbPageContext = this.f50062a;
            VoiceRoomWrapper item = getItem(i2);
            Intrinsics.checkExpressionValueIsNotNull(item, "getItem(position)");
            viewHolder.bind(tbPageContext, i2, item, this.f50063b);
            TbadkCoreApplication inst = TbadkCoreApplication.getInst();
            Intrinsics.checkExpressionValueIsNotNull(inst, "TbadkCoreApplication.getInst()");
            viewHolder.changeSkin(inst.getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i2)) == null) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(g1.fragment_voice_room_list_item, viewGroup, false);
            a.C1762a c1762a = a.f50069i;
            Intrinsics.checkExpressionValueIsNotNull(view, "view");
            return new ViewHolder(c1762a.a(view));
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
