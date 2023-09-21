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
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.statistics.UbcRemoteStat;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.module.frs.Frs$From;
import com.baidu.tbadk.module.frs.FrsService;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ay7;
import com.baidu.tieba.frs.voiceroom.VoiceRoomListAdapter;
import com.baidu.tieba.frs.voiceroom.VoiceRoomStat;
import com.baidu.tieba.frs.voiceroom.data.VoiceRoomWrapper;
import com.baidu.tieba.zx7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0014\u0015B\u001b\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$ViewHolder;", "tbPageContext", "Lcom/baidu/tbadk/TbPageContext;", "arguments", "Landroid/os/Bundle;", "(Lcom/baidu/tbadk/TbPageContext;Landroid/os/Bundle;)V", "getTbPageContext", "()Lcom/baidu/tbadk/TbPageContext;", "onBindViewHolder", "", "holder", CriusAttrConstants.POSITION, "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Binding", "ViewHolder", "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoiceRoomListAdapter extends ListAdapter<VoiceRoomWrapper, ViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final TbPageContext<?> a;
    public final Bundle b;

    /* loaded from: classes6.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public static final C0309a i;
        public transient /* synthetic */ FieldHolder $fh;
        public final View a;
        public final TBLottieAnimationView b;
        public final TextView c;
        public final TextView d;
        public final FrameLayout e;
        public final TextView f;
        public final TextView g;
        public final List<HeadImageView> h;

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
            i = new C0309a(null);
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
                    return Intrinsics.areEqual(this.a, aVar.a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e) && Intrinsics.areEqual(this.f, aVar.f) && Intrinsics.areEqual(this.g, aVar.g);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (((((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode() : invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return "Binding(root=" + this.a + ", voicingIcon=" + this.b + ", voicingText=" + this.c + ", title=" + this.d + ", headers=" + this.e + ", desc=" + this.f + ", actionJoin=" + this.g + ')';
            }
            return (String) invokeV.objValue;
        }

        /* renamed from: com.baidu.tieba.frs.voiceroom.VoiceRoomListAdapter$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0309a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public /* synthetic */ C0309a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public C0309a() {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            public final a a(View root) {
                InterceptResult invokeL;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, root)) == null) {
                    Intrinsics.checkNotNullParameter(root, "root");
                    View findViewById = root.findViewById(R.id.obfuscated_res_0x7f0929d9);
                    Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.voicing_icon)");
                    TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) findViewById;
                    View findViewById2 = root.findViewById(R.id.obfuscated_res_0x7f0929da);
                    Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.voicing_text)");
                    TextView textView = (TextView) findViewById2;
                    View findViewById3 = root.findViewById(R.id.obfuscated_res_0x7f09259d);
                    Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.title)");
                    TextView textView2 = (TextView) findViewById3;
                    View findViewById4 = root.findViewById(R.id.obfuscated_res_0x7f090f27);
                    Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.headers)");
                    FrameLayout frameLayout = (FrameLayout) findViewById4;
                    View findViewById5 = root.findViewById(R.id.obfuscated_res_0x7f090874);
                    Intrinsics.checkNotNullExpressionValue(findViewById5, "root.findViewById(R.id.desc)");
                    TextView textView3 = (TextView) findViewById5;
                    View findViewById6 = root.findViewById(R.id.obfuscated_res_0x7f090079);
                    Intrinsics.checkNotNullExpressionValue(findViewById6, "root.findViewById(R.id.action_join)");
                    return new a(root, tBLottieAnimationView, textView, textView2, frameLayout, textView3, (TextView) findViewById6);
                }
                return (a) invokeL.objValue;
            }
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
            this.b = voicingIcon;
            this.c = voicingText;
            this.d = title;
            this.e = headers;
            this.f = desc;
            this.g = actionJoin;
            ArrayList arrayList = new ArrayList();
            this.h = arrayList;
            View findViewById = this.e.findViewById(R.id.obfuscated_res_0x7f090f0a);
            Intrinsics.checkNotNullExpressionValue(findViewById, "headers.findViewById(R.id.header0)");
            arrayList.add(findViewById);
            List<HeadImageView> list = this.h;
            View findViewById2 = this.e.findViewById(R.id.obfuscated_res_0x7f090f0b);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "headers.findViewById(R.id.header1)");
            list.add(findViewById2);
            List<HeadImageView> list2 = this.h;
            View findViewById3 = this.e.findViewById(R.id.obfuscated_res_0x7f090f0c);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "headers.findViewById(R.id.header2)");
            list2.add(findViewById3);
            for (HeadImageView headImageView : this.h) {
                headImageView.setDefaultResource(17170445);
                headImageView.setPlaceHolder(2);
                headImageView.setIsRound(true);
                headImageView.setBorderWidth((int) this.a.getResources().getDimension(R.dimen.L_X02));
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0402));
                headImageView.setDrawBorder(true);
            }
        }

        public final TextView a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.g;
            }
            return (TextView) invokeV.objValue;
        }

        public final TextView b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.f;
            }
            return (TextView) invokeV.objValue;
        }

        public final List<HeadImageView> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.h;
            }
            return (List) invokeV.objValue;
        }

        public final View d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a;
            }
            return (View) invokeV.objValue;
        }

        public final TextView e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.d;
            }
            return (TextView) invokeV.objValue;
        }

        public final TBLottieAnimationView f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.b;
            }
            return (TBLottieAnimationView) invokeV.objValue;
        }

        public final TextView g() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.c;
            }
            return (TextView) invokeV.objValue;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$Binding;", "(Lcom/baidu/tieba/frs/voiceroom/VoiceRoomListAdapter$Binding;)V", UbcRemoteStat.BIND_SERVICE, "", "tbPageContext", "Lcom/baidu/tbadk/TbPageContext;", CriusAttrConstants.POSITION, "", "voiceRoomWrapper", "Lcom/baidu/tieba/frs/voiceroom/data/VoiceRoomWrapper;", "arguments", "Landroid/os/Bundle;", "changeSkin", WriteMulitImageActivityConfig.SKIN_TYPE, "frs_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter(binding, "binding");
            this.a = binding;
        }

        public static final void b(Bundle bundle, TbPageContext tbPageContext, VoiceRoom voiceRoom, int i, View view2) {
            Frs$From f;
            long d;
            String e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{bundle, tbPageContext, voiceRoom, Integer.valueOf(i), view2}) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "$tbPageContext");
                Intrinsics.checkNotNullParameter(voiceRoom, "$voiceRoom");
                if (bundle != null) {
                    VoiceRoomStat voiceRoomStat = VoiceRoomStat.a;
                    VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.ITEM_CLICK;
                    f = zx7.f(bundle);
                    Integer valueOf = Integer.valueOf(i);
                    Long l = voiceRoom.room_id;
                    d = zx7.d(bundle);
                    Long valueOf2 = Long.valueOf(d);
                    e = zx7.e(bundle);
                    voiceRoomStat.c(statType, f, valueOf, l, valueOf2, e);
                }
                Long l2 = voiceRoom.room_id;
                Intrinsics.checkNotNullExpressionValue(l2, "voiceRoom.room_id");
                ((FrsService) ServiceManager.getService(FrsService.Companion.getServiceReference())).navToVoiceRoom(tbPageContext, l2.longValue());
            }
        }

        public final void a(final TbPageContext<?> tbPageContext, final int i, VoiceRoomWrapper voiceRoomWrapper, final Bundle bundle) {
            Frs$From f;
            long d;
            String e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLILL(1048576, this, tbPageContext, i, voiceRoomWrapper, bundle) == null) {
                Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
                Intrinsics.checkNotNullParameter(voiceRoomWrapper, "voiceRoomWrapper");
                final VoiceRoom voiceRoom = voiceRoomWrapper.getVoiceRoom();
                String forumName = voiceRoomWrapper.getForumName();
                a aVar = this.a;
                aVar.e().setText(voiceRoom.room_name);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = aVar.d().getResources().getString(R.string.obfuscated_res_0x7f0f0891);
                Intrinsics.checkNotNullExpressionValue(string, "root.resources.getString(R.string.frs_voice_desc)");
                boolean z = true;
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(voiceRoom.talker.size()), voiceRoom.joined_num}, 2));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                if (forumName.length() <= 0) {
                    z = false;
                }
                if (z) {
                    format = format + WebvttCueParser.CHAR_SPACE + forumName + (char) 21543;
                }
                aVar.b().setText(format);
                int i2 = 0;
                for (Object obj : aVar.c()) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    HeadImageView headImageView = (HeadImageView) obj;
                    List<User> list = voiceRoom.talker;
                    Intrinsics.checkNotNullExpressionValue(list, "voiceRoom.talker");
                    User user = (User) CollectionsKt___CollectionsKt.getOrNull(list, i2);
                    if (user != null) {
                        headImageView.startLoad(user.portrait, 12, false);
                        headImageView.setVisibility(0);
                    } else {
                        headImageView.setVisibility(8);
                    }
                    i2 = i3;
                }
                View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.yx7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            VoiceRoomListAdapter.ViewHolder.b(bundle, tbPageContext, voiceRoom, i, view2);
                        }
                    }
                };
                aVar.d().setOnClickListener(onClickListener);
                aVar.a().setOnClickListener(onClickListener);
                if (bundle != null) {
                    VoiceRoomStat voiceRoomStat = VoiceRoomStat.a;
                    VoiceRoomStat.StatType statType = VoiceRoomStat.StatType.ITEM_EXPOSE;
                    f = zx7.f(bundle);
                    Integer valueOf = Integer.valueOf(i);
                    Long l = voiceRoom.room_id;
                    d = zx7.d(bundle);
                    Long valueOf2 = Long.valueOf(d);
                    e = zx7.e(bundle);
                    voiceRoomStat.c(statType, f, valueOf, l, valueOf2, e);
                }
            }
        }

        public final void c(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                a aVar = this.a;
                EMManager.from(aVar.d()).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0205);
                EMManager.from(aVar.g()).setCorner(R.string.J_X01).setTextColor(R.color.CAM_X0115).setBackGroundColor(R.color.CAM_X0919);
                EMManager.from(aVar.e()).setTextColor(R.color.CAM_X0105);
                EMManager.from(aVar.b()).setTextColor(R.color.CAM_X0108);
                EMManager.from(aVar.a()).setCorner(R.string.J_X01).setTextColor(R.color.CAM_X0115).setBackGroundSelectorColor(R.color.CAM_X0919);
                SkinManager.setLottieAnimation(aVar.f(), R.raw.lottie_voice_room_voicing_icon);
                aVar.f().setRepeatCount(-1);
                aVar.f().playAnimation();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceRoomListAdapter(TbPageContext<?> tbPageContext, Bundle bundle) {
        super(new ay7());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((DiffUtil.ItemCallback) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(tbPageContext, "tbPageContext");
        this.a = tbPageContext;
        this.b = bundle;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onBindViewHolder(ViewHolder holder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, holder, i) == null) {
            Intrinsics.checkNotNullParameter(holder, "holder");
            TbPageContext<?> tbPageContext = this.a;
            VoiceRoomWrapper item = getItem(i);
            Intrinsics.checkNotNullExpressionValue(item, "getItem(position)");
            holder.a(tbPageContext, i, item, this.b);
            holder.c(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, parent, i)) == null) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0344, parent, false);
            a.C0309a c0309a = a.i;
            Intrinsics.checkNotNullExpressionValue(view2, "view");
            return new ViewHolder(c0309a.a(view2));
        }
        return (ViewHolder) invokeLI.objValue;
    }
}
