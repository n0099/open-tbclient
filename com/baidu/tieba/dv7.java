package com.baidu.tieba;

import android.app.Activity;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import com.baidu.tieba.pb.chosen.PbChosenActivity;
import com.baidu.tieba.pb.chosen.view.ShareThreadView;
import com.baidu.tieba.pu4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.text.MessageFormat;
/* loaded from: classes3.dex */
public class dv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbChosenActivity a;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dv7 a;

        public a(dv7 dv7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dv7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.sendMessage(new CustomMessage(2001277));
                TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "pb_new_share", "loc", 0, new Object[0]);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ShareItem a;
        public final /* synthetic */ dv7 b;

        public b(dv7 dv7Var, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dv7Var, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dv7Var;
            this.a = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ShareItem shareItem = this.a;
                shareItem.x = k35.u(shareItem.x, shareItem.O, UtilHelper.isVideoThread(shareItem.Q));
                vi.a(this.a.x);
                fj.N(this.b.a.getPageContext().getPageActivity(), view2.getResources().getString(R.string.obfuscated_res_0x7f0f045c));
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class c implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gv7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ String f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;

        public c(gv7 gv7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, String str2, String str3, String str4) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, str2, str3, str4};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gv7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            gv7 gv7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) && (gv7Var = this.a) != null && gv7Var.getThreadInfo() != null) {
                fj.x(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
                Activity pageActivity = this.b.getPageContext().getPageActivity();
                long j = this.d;
                String str = this.e;
                String str2 = this.f;
                String str3 = this.g;
                String leaveMsg = this.c.getLeaveMsg();
                gv7 gv7Var2 = this.a;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(pageActivity, j, str, str2, str3, 0, leaveMsg, dv7.c(gv7Var2, gv7Var2.getThreadInfo().excid.longValue(), this.h).toChatMessageContent())));
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class d implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;
        public final /* synthetic */ ShareThreadView b;

        public d(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
            this.b = shareThreadView;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                fj.x(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class e implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gv7 a;
        public final /* synthetic */ PbChosenActivity b;
        public final /* synthetic */ ShareThreadView c;
        public final /* synthetic */ long d;
        public final /* synthetic */ String e;
        public final /* synthetic */ long f;
        public final /* synthetic */ String g;

        public e(gv7 gv7Var, PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView, long j, String str, long j2, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gv7Var, pbChosenActivity, shareThreadView, Long.valueOf(j), str, Long.valueOf(j2), str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gv7Var;
            this.b = pbChosenActivity;
            this.c = shareThreadView;
            this.d = j;
            this.e = str;
            this.f = j2;
            this.g = str2;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            gv7 gv7Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) && (gv7Var = this.a) != null && gv7Var.getThreadInfo() != null) {
                fj.x(this.b.getPageContext().getPageActivity(), this.c.getChatMsgView());
                Activity pageActivity = this.b.getPageContext().getPageActivity();
                long j = this.d;
                String str = this.e;
                long j2 = this.f;
                String leaveMsg = this.c.getLeaveMsg();
                gv7 gv7Var2 = this.a;
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(pageActivity, j, str, j2, "from_share", leaveMsg, dv7.c(gv7Var2, gv7Var2.getThreadInfo().excid.longValue(), this.g).toChatMessageContent())));
                pu4Var.dismiss();
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class f implements pu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbChosenActivity a;
        public final /* synthetic */ ShareThreadView b;

        public f(PbChosenActivity pbChosenActivity, ShareThreadView shareThreadView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbChosenActivity, shareThreadView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbChosenActivity;
            this.b = shareThreadView;
        }

        @Override // com.baidu.tieba.pu4.e
        public void onClick(pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, pu4Var) == null) {
                fj.x(this.a.getPageContext().getPageActivity(), this.b.getChatMsgView());
                pu4Var.dismiss();
            }
        }
    }

    public dv7(PbChosenActivity pbChosenActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbChosenActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = pbChosenActivity;
    }

    public static ShareFromPBMsgData c(gv7 gv7Var, long j, String str) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{gv7Var, Long.valueOf(j), str})) == null) {
            if (gv7Var == null || gv7Var.getThreadInfo() == null) {
                return null;
            }
            ShareFromPBMsgData shareFromPBMsgData = new ShareFromPBMsgData();
            shareFromPBMsgData.setContent(gv7Var.getThreadInfo()._abstract);
            shareFromPBMsgData.setImageUrl(str);
            shareFromPBMsgData.setForumName(gv7Var.getThreadInfo().forum.forum_name);
            shareFromPBMsgData.setPostId(null);
            shareFromPBMsgData.setThreadId(gv7Var.getThreadInfo().thread_id + "");
            shareFromPBMsgData.setTheNewThemeId(String.valueOf(j));
            shareFromPBMsgData.setTitle(gv7Var.getThreadInfo().title);
            return shareFromPBMsgData;
        }
        return (ShareFromPBMsgData) invokeCommon.objValue;
    }

    public static void d(PbChosenActivity pbChosenActivity, gv7 gv7Var, long j, String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{pbChosenActivity, gv7Var, Long.valueOf(j), str, Long.valueOf(j2), str2}) == null) && gv7Var != null && gv7Var.getThreadInfo() != null) {
            pu4 pu4Var = new pu4(pbChosenActivity.getPageContext().getPageActivity());
            ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.c(str2, false);
            shareThreadView.setTitle(gv7Var.getThreadInfo().title);
            shareThreadView.setDesc(gv7Var.getThreadInfo()._abstract);
            pu4Var.setContentView(shareThreadView);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f115b, new e(gv7Var, pbChosenActivity, shareThreadView, j, str, j2, str2));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new f(pbChosenActivity, shareThreadView));
            pu4Var.setCanceledOnTouchOutside(false);
            pu4Var.create(pbChosenActivity.getPageContext()).show();
        }
    }

    public static void e(PbChosenActivity pbChosenActivity, gv7 gv7Var, long j, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{pbChosenActivity, gv7Var, Long.valueOf(j), str, str2, str3, str4}) == null) && gv7Var != null && gv7Var.getThreadInfo() != null) {
            pu4 pu4Var = new pu4(pbChosenActivity.getPageContext().getPageActivity());
            ShareThreadView shareThreadView = new ShareThreadView(pbChosenActivity.getPageContext().getPageActivity());
            shareThreadView.setTitle(gv7Var.getThreadInfo().title);
            shareThreadView.setDesc(gv7Var.getThreadInfo()._abstract);
            shareThreadView.c(str4, false);
            pu4Var.setContentView(shareThreadView);
            pu4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f115b, new c(gv7Var, pbChosenActivity, shareThreadView, j, str, str2, str3, str4));
            pu4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0375, new d(pbChosenActivity, shareThreadView));
            pu4Var.setCanceledOnTouchOutside(false);
            pu4Var.create(pbChosenActivity.getPageContext()).show();
        }
    }

    public void f(gv7 gv7Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, gv7Var, str) == null) && gv7Var != null && gv7Var.getThreadInfo() != null && gv7Var.getThreadInfo().excid != null) {
            String str2 = gv7Var.getThreadInfo().forum.forum_name;
            String str3 = gv7Var.getThreadInfo().title;
            String str4 = gv7Var.getThreadInfo()._abstract;
            Resources resources = this.a.getPageContext().getPageActivity().getResources();
            String format = MessageFormat.format(resources.getString(R.string.obfuscated_res_0x7f0f1163), str3, str4);
            resources.getString(R.string.obfuscated_res_0x7f0f03e5, str3);
            ShareItem shareItem = new ShareItem();
            shareItem.v = str3;
            shareItem.w = format;
            shareItem.x = TbConfig.TIEBA_ADDRESS + "mo/q/recommendpb?ftid=" + gv7Var.getThreadInfo().excid;
            shareItem.H = str4;
            shareItem.G = Long.toString(gv7Var.getThreadInfo().excid.longValue());
            shareItem.O = Long.toString(gv7Var.getThreadInfo().thread_id.longValue());
            shareItem.a = true;
            if (!StringUtils.isNull(str)) {
                shareItem.z = Uri.parse(str);
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(this.a.getPageContext().getPageActivity(), shareItem, true);
            shareDialogConfig.setIsCopyLink(true);
            shareDialogConfig.addOutsideTextView(R.string.obfuscated_res_0x7f0f0695, R.drawable.icon_share_friends_n, new a(this));
            shareDialogConfig.setCopyLinkListener(new b(this, shareItem));
            this.a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
