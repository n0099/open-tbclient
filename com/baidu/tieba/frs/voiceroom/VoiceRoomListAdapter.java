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
import c.a.t0.d1.c1;
import c.a.t0.d1.d1;
import c.a.t0.d1.d3.c;
import c.a.t0.d1.d3.d;
import c.a.t0.d1.f1;
import c.a.t0.d1.g1;
import c.a.t0.d1.h1;
import c.a.t0.d1.i1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.frs.voiceroom.VoiceRoomListAdapter;
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
import tbclient.VoiceRoom;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$ViewHolder;", "tbPageContext", "Lcom/baidu/tbadk/TbPageContext;", "arguments", "Landroid/os/Bundle;", "(Lcom/baidu/tbadk/TbPageContext;Landroid/os/Bundle;)V", "getTbPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Binding", "ViewHolder", "frs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class VoiceRoomListAdapter extends ListAdapter<VoiceRoomWrapper, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f45565b;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$Binding;", "(Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$Binding;)V", "bind", "", "tbPageContext", "Lcom/baidu/tbadk/TbPageContext;", "position", "", "voiceRoomWrapper", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "arguments", "Landroid/os/Bundle;", "changeSkin", WriteMulitImageActivityConfig.SKIN_TYPE, "frs_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final a a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(a binding) {
            super(binding.d());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {binding};
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
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.a = binding;
        }

        public static final void a(Bundle bundle, TbPageContext tbPageContext, VoiceRoom voiceRoom, int i2, View view) {
            Frs$From f2;
            long d2;
            String e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{bundle, tbPageContext, voiceRoom, Integer.valueOf(i2), view}) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "$tbPageContext");
                Intrinsics.checkNotNullParameter(voiceRoom, "$voiceRoom");
                if (bundle != null) {
                    VoiceRoomStat voiceRoomStat = VoiceRoomStat.a;
                    VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.ITEM_CLICK;
                    f2 = c.f(bundle);
                    Integer valueOf = Integer.valueOf(i2);
                    Long l = voiceRoom.room_id;
                    d2 = c.d(bundle);
                    Long valueOf2 = Long.valueOf(d2);
                    e2 = c.e(bundle);
                    voiceRoomStat.c(statType, f2, valueOf, l, valueOf2, e2);
                }
                Long l2 = voiceRoom.room_id;
                Intrinsics.checkNotNullExpressionValue(l2, "voiceRoom.room_id");
                ((c.a.s0.j0.c.a) ServiceManager.getService(c.a.s0.j0.c.a.a.a())).a(tbPageContext, l2.longValue());
            }
        }

        public static /* synthetic */ void bind$default(ViewHolder viewHolder, TbPageContext tbPageContext, int i2, VoiceRoomWrapper voiceRoomWrapper, Bundle bundle, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                bundle = null;
            }
            viewHolder.bind(tbPageContext, i2, voiceRoomWrapper, bundle);
        }

        public final void bind(final TbPageContext<?> tbPageContext, final int i2, VoiceRoomWrapper voiceRoomWrapper, final Bundle bundle) {
            Frs$From f2;
            long d2;
            String e2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, tbPageContext, i2, voiceRoomWrapper, bundle) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                Intrinsics.checkNotNullParameter(voiceRoomWrapper, "voiceRoomWrapper");
                final VoiceRoom voiceRoom = voiceRoomWrapper.getVoiceRoom();
                String forumName = voiceRoomWrapper.getForumName();
                a aVar = this.a;
                aVar.e().setText(voiceRoom.room_name);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = aVar.d().getResources().getString(i1.frs_voice_desc);
                Intrinsics.checkNotNullExpressionValue(string, "root.resources.getString(R.string.frs_voice_desc)");
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
                    Intrinsics.checkNotNullExpressionValue(list, "voiceRoom.talker");
                    User user = (User) CollectionsKt___CollectionsKt.getOrNull(list, i3);
                    if (user != null) {
                        headImageView.startLoad(user.portrait, 12, false);
                        headImageView.setVisibility(0);
                    } else {
                        headImageView.setVisibility(8);
                    }
                    i3 = i4;
                }
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: c.a.t0.d1.d3.b
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view) == null) {
                            VoiceRoomListAdapter.ViewHolder.a(bundle, tbPageContext, voiceRoom, i2, view);
                        }
                    }
                };
                aVar.d().setOnClickListener(onClickListener);
                aVar.a().setOnClickListener(onClickListener);
                if (bundle == null) {
                    return;
                }
                VoiceRoomStat voiceRoomStat = VoiceRoomStat.a;
                VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.ITEM_EXPOSE;
                f2 = c.f(bundle);
                Integer valueOf = Integer.valueOf(i2);
                Long l = voiceRoom.room_id;
                d2 = c.d(bundle);
                Long valueOf2 = Long.valueOf(d2);
                e2 = c.e(bundle);
                voiceRoomStat.c(statType, f2, valueOf, l, valueOf2, e2);
            }
        }

        public final void changeSkin(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                a aVar = this.a;
                c.a.s0.s.u.c d2 = c.a.s0.s.u.c.d(aVar.d());
                d2.n(i1.J_X05);
                d2.f(c1.CAM_X0205);
                c.a.s0.s.u.c d3 = c.a.s0.s.u.c.d(aVar.g());
                d3.n(i1.J_X01);
                d3.v(c1.CAM_X0115);
                d3.f(c1.CAM_X0919);
                c.a.s0.s.u.c.d(aVar.e()).v(c1.CAM_X0105);
                c.a.s0.s.u.c.d(aVar.b()).v(c1.CAM_X0108);
                c.a.s0.s.u.c d4 = c.a.s0.s.u.c.d(aVar.a());
                d4.n(i1.J_X01);
                d4.v(c1.CAM_X0115);
                d4.h(c1.CAM_X0919);
                SkinManager.setLottieAnimation(aVar.f(), h1.lottie_voice_room_voicing_icon);
                aVar.f().setRepeatCount(-1);
                aVar.f().playAnimation();
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: i  reason: collision with root package name */
        public static final C1899a f45566i;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;

        /* renamed from: b  reason: collision with root package name */
        public final TBLottieAnimationView f45567b;

        /* renamed from: c  reason: collision with root package name */
        public final TextView f45568c;

        /* renamed from: d  reason: collision with root package name */
        public final TextView f45569d;

        /* renamed from: e  reason: collision with root package name */
        public final FrameLayout f45570e;

        /* renamed from: f  reason: collision with root package name */
        public final TextView f45571f;

        /* renamed from: g  reason: collision with root package name */
        public final TextView f45572g;

        /* renamed from: h  reason: collision with root package name */
        public final List<HeadImageView> f45573h;

        /* renamed from: com.baidu.tieba.frs.voiceroom.VoiceRoomListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes12.dex */
        public static final class C1899a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public C1899a() {
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

            public /* synthetic */ C1899a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(View root) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, root)) == null) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    View findViewById = root.findViewById(f1.voicing_icon);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.voicing_icon)");
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById;
                    View findViewById2 = root.findViewById(f1.voicing_text);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.voicing_text)");
                    TextView textView = (TextView) findViewById2;
                    View findViewById3 = root.findViewById(f1.title);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.title)");
                    TextView textView2 = (TextView) findViewById3;
                    View findViewById4 = root.findViewById(f1.headers);
                    Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.headers)");
                    FrameLayout frameLayout = (FrameLayout) findViewById4;
                    View findViewById5 = root.findViewById(f1.desc);
                    Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.desc)");
                    TextView textView3 = (TextView) findViewById5;
                    View findViewById6 = root.findViewById(f1.action_join);
                    Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.action_join)");
                    return new a(root, tBLottieAnimationView, textView, textView2, frameLayout, textView3, (TextView) findViewById6);
                }
                return (a) invokeL.objValue;
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
            f45566i = new C1899a(null);
        }

        /* JADX DEBUG: Multi-variable search result rejected for r6v2, resolved type: java.util.List<com.baidu.tbadk.core.view.HeadImageView> */
        /* JADX DEBUG: Multi-variable search result rejected for r6v3, resolved type: java.util.List<com.baidu.tbadk.core.view.HeadImageView> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(View root, TBLottieAnimationView voicingIcon, TextView voicingText, TextView title, FrameLayout headers, TextView desc, TextView actionJoin) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {root, voicingIcon, voicingText, title, headers, desc, actionJoin};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(root, "root");
            Intrinsics.checkNotNullParameter(voicingIcon, "voicingIcon");
            Intrinsics.checkNotNullParameter(voicingText, "voicingText");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(desc, "desc");
            Intrinsics.checkNotNullParameter(actionJoin, "actionJoin");
            this.a = root;
            this.f45567b = voicingIcon;
            this.f45568c = voicingText;
            this.f45569d = title;
            this.f45570e = headers;
            this.f45571f = desc;
            this.f45572g = actionJoin;
            ArrayList arrayList = new ArrayList();
            this.f45573h = arrayList;
            View findViewById = this.f45570e.findViewById(f1.header0);
            Intrinsics.checkNotNullExpressionValue(findViewById, "headers.findViewById(R.id.header0)");
            arrayList.add(findViewById);
            List<HeadImageView> list = this.f45573h;
            View findViewById2 = this.f45570e.findViewById(f1.header1);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "headers.findViewById(R.id.header1)");
            list.add(findViewById2);
            List<HeadImageView> list2 = this.f45573h;
            View findViewById3 = this.f45570e.findViewById(f1.header2);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "headers.findViewById(R.id.header2)");
            list2.add(findViewById3);
            for (HeadImageView headImageView : this.f45573h) {
                headImageView.setDefaultResource(17170445);
                headImageView.setPlaceHolder(2);
                headImageView.setIsRound(true);
                headImageView.setBorderWidth((int) d().getResources().getDimension(d1.L_X02));
                headImageView.setBorderColor(SkinManager.getColor(c1.CAM_X0402));
                headImageView.setDrawBorder(true);
            }
        }

        public final TextView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f45572g : (TextView) invokeV.objValue;
        }

        public final TextView b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45571f : (TextView) invokeV.objValue;
        }

        public final List<HeadImageView> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45573h : (List) invokeV.objValue;
        }

        public final View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.a : (View) invokeV.objValue;
        }

        public final TextView e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f45569d : (TextView) invokeV.objValue;
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.f45567b, aVar.f45567b) && Intrinsics.areEqual(this.f45568c, aVar.f45568c) && Intrinsics.areEqual(this.f45569d, aVar.f45569d) && Intrinsics.areEqual(this.f45570e, aVar.f45570e) && Intrinsics.areEqual(this.f45571f, aVar.f45571f) && Intrinsics.areEqual(this.f45572g, aVar.f45572g);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public final TBLottieAnimationView f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f45567b : (TBLottieAnimationView) invokeV.objValue;
        }

        public final TextView g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f45568c : (TextView) invokeV.objValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (((((((((((this.a.hashCode() * 31) + this.f45567b.hashCode()) * 31) + this.f45568c.hashCode()) * 31) + this.f45569d.hashCode()) * 31) + this.f45570e.hashCode()) * 31) + this.f45571f.hashCode()) * 31) + this.f45572g.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "Binding(root=" + this.a + ", voicingIcon=" + this.f45567b + ", voicingText=" + this.f45568c + ", title=" + this.f45569d + ", headers=" + this.f45570e + ", desc=" + this.f45571f + ", actionJoin=" + this.f45572g + ')';
            }
            return (String) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceRoomListAdapter(TbPageContext<?> tbPageContext, Bundle bundle) {
        super(new d());
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
        Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
        this.a = tbPageContext;
        this.f45565b = bundle;
    }

    public final TbPageContext<?> getTbPageContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (TbPageContext) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ViewHolder holder, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, holder, i2) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            TbPageContext<?> tbPageContext = this.a;
            VoiceRoomWrapper item = getItem(i2);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            holder.bind(tbPageContext, i2, item, this.f45565b);
            holder.changeSkin(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, parent, i2)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view = LayoutInflater.from(parent.getContext()).inflate(g1.fragment_voice_room_list_item, parent, false);
            a.C1899a c1899a = a.f45566i;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            return new ViewHolder(c1899a.a(view));
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
