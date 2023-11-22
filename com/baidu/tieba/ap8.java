package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.ImShareCardCommonData;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.view.ChatImageWithTailView;
import com.baidu.tieba.im.data.GamePlayOrderMsgData;
import com.baidu.tieba.im.data.GamePlaySendCardMsgData;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.data.ShareChatroomMsgData;
import com.baidu.tieba.im.data.ShareForumMsgData;
import com.baidu.tieba.im.data.ShareThreadMsgData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.tieba.im.sendcard.GamePlaySendCardMsgView;
import com.baidu.tieba.im.widget.GamePlayCardMsgView;
import com.baidu.tieba.im.widget.ShareFromFrsView;
import com.baidu.tieba.im.widget.ShareFromGameCenter;
import com.baidu.tieba.im.widget.ShareFromPBView;
import com.baidu.tieba.im.widget.chatVoiceView.ChatVoiceView;
import com.baidu.tieba.im.widget.sharecard.ChatShareCard;
import com.baidu.tieba.im.widget.sharecard.ChatShareChatroomCard;
import com.baidu.tieba.im.widget.sharecard.ChatShareCommonCard;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class ap8 extends v4<MsglistActivity<?>> {
    public static /* synthetic */ Interceptable $ic;
    public static final String H;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<ReportPrivateMsgData> A;
    public int B;
    public TbCheckBox C;
    public LinearLayout D;
    public AbsMsglistView.j E;
    public int F;
    public ChatMessage G;
    public ua b;
    public va c;
    public long d;
    public Calendar e;
    public int f;
    public long g;
    public Long h;
    public TextView i;
    public TbRichTextView j;
    public ChatVoiceView k;
    public GifView l;
    public ShareFromPBView m;
    public ShareFromFrsView n;
    public ShareFromGameCenter o;
    public ChatImageWithTailView p;
    public ChatShareCard q;
    public GamePlayCardMsgView r;
    public GamePlaySendCardMsgView s;
    public ChatShareChatroomCard t;
    public ChatShareCommonCard u;
    public Boolean v;
    public boolean w;
    public boolean x;
    public boolean y;
    public boolean z;

    public void W(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, view2, chatMessage) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public a(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ap8 ap8Var = this.a;
                ap8Var.c.H(view2, 10, ap8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public b(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ap8 ap8Var = this.a;
                ap8Var.b.u(view2, 15, ap8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public c(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ap8 ap8Var = this.a;
                ap8Var.c.H(view2, 15, ap8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public d(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ap8 ap8Var = this.a;
                ap8Var.b.u(view2, 11, ap8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public e(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ap8 ap8Var = this.a;
                ap8Var.b.u(view2, 12, ap8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public f(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ap8 ap8Var = this.a;
                ap8Var.c.H(view2, 11, ap8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ChatMessage a;
        public final /* synthetic */ ap8 b;

        public g(ap8 ap8Var, ChatMessage chatMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var, chatMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ap8Var;
            this.a = chatMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                view2.setTag(Boolean.valueOf(!((Boolean) view2.getTag()).booleanValue()));
                if (((Boolean) view2.getTag()).booleanValue()) {
                    if (this.b.A.size() < 20) {
                        this.b.C.setChecked(true);
                        this.b.A.add(new ReportPrivateMsgData(String.valueOf(this.a.getMsgId()), p0b.b(this.b.mContext, this.a), String.valueOf(this.a.getTime())));
                        if (this.b.E != null) {
                            this.b.E.a(this.b.A, true);
                        }
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_REPORT_PRIVATE_MSG_CHANGE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        return;
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921670, Boolean.TRUE));
                    return;
                }
                int i = 0;
                this.b.C.setChecked(false);
                while (true) {
                    if (i < this.b.A.size()) {
                        if (this.b.A.get(i) != null && TextUtils.equals(String.valueOf(this.a.getMsgId()), this.b.A.get(i).getMsgId())) {
                            this.b.A.remove(i);
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
                if (this.b.E != null) {
                    this.b.E.a(this.b.A, true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public h(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            TbRichTextView tbRichTextView;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (tbRichTextView = this.a.j) != null && tbRichTextView.getTextView() != null) {
                CharSequence text = this.a.j.getTextView().getText();
                if (!TextUtils.isEmpty(text)) {
                    if (text.toString().contains("删贴") || text.toString().contains("删除")) {
                        if (text.toString().contains("http://") || text.toString().contains("https://")) {
                            UrlManager.getInstance().dealOneLink((TbPageContext) a5.a(view2.getContext()), new String[]{ap8.H});
                            SharedPrefHelper.getInstance().putBoolean(SharedPrefHelper.getSharedPrefKeyWithAccount("key_person_post_recycle_bin_red_tip_show"), false);
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_SITE_SERVICE).param("uid", TbadkCoreApplication.getCurrentAccount()));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class i implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public i(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ap8 ap8Var = this.a;
                ap8Var.c.H(view2, 5, ap8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class j implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public j(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ap8 ap8Var = this.a;
                ap8Var.b.u(view2, 4, ap8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class k implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public k(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ap8 ap8Var = this.a;
                ap8Var.c.H(view2, 4, ap8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class l implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public l(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ap8 ap8Var = this.a;
                ap8Var.b.u(view2, 13, ap8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public m(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ap8 ap8Var = this.a;
                ap8Var.c.H(view2, 3, ap8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class n implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public n(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ap8 ap8Var = this.a;
                ap8Var.b.u(view2, 7, ap8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public o(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                ap8 ap8Var = this.a;
                ap8Var.c.H(view2, 7, ap8Var.f, 0L);
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class p implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ap8 a;

        public p(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ap8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                ap8 ap8Var = this.a;
                ap8Var.b.u(view2, 10, ap8Var.f, 0L);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class q implements TbCheckBox.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;

        public q(ap8 ap8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ap8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = false;
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public void setChecked(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
                this.a = z;
            }
        }

        @Override // com.baidu.tbadk.core.view.TbCheckBox.c
        public boolean isChecked() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.a;
            }
            return invokeV.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622976, "Lcom/baidu/tieba/ap8;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622976, "Lcom/baidu/tieba/ap8;");
                return;
            }
        }
        H = TbConfig.TIEBA_ADDRESS + "mo/q/wise-bawu-core/recycle-station#/recycle-post?noshare=1";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ap8(TbPageContext<MsglistActivity<?>> tbPageContext, int i2) {
        super(tbPageContext, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((BdPageContext) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.f = 0;
        this.g = 0L;
        this.h = null;
        this.v = Boolean.FALSE;
        this.w = true;
        this.x = false;
        this.y = false;
        this.z = false;
        this.F = 3;
        this.d = 0L;
        this.e = null;
        this.mContext = tbPageContext;
    }

    public final void D(ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, chatMessage) == null) && chatMessage != null && chatMessage.getMsgType() == 2) {
            ru5.d();
        }
    }

    public final void G(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, chatMessage) == null) {
            MsgCacheData cacheData = chatMessage.getCacheData();
            if (cacheData == null) {
                MsgCacheData msgCacheData = new MsgCacheData();
                msgCacheData.setVoice_status(1);
                chatMessage.setCacheData(msgCacheData);
            } else if (cacheData.getVoice_status() == 0) {
                cacheData.setVoice_status(1);
            }
        }
    }

    public final boolean I(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j2)) == null) {
            if (j2 < 1000) {
                return false;
            }
            long j3 = this.d;
            if (j3 != 0 && j2 - j3 < 180) {
                return false;
            }
            return true;
        }
        return invokeJ.booleanValue;
    }

    public void K(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.s.setAttention(z);
        }
    }

    public void L(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2) == null) {
            Calendar calendar = Calendar.getInstance();
            this.e = calendar;
            calendar.setTimeInMillis(j2 * 1000);
        }
    }

    public void N(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.z = z;
        }
    }

    public void O(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.p.setVisibility(i2);
        }
    }

    public void P(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            this.y = z;
        }
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048589, this, z) == null) {
            this.x = z;
        }
    }

    public void R(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j2) == null) {
            this.d = j2;
        }
    }

    public void S(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.w = z;
        }
    }

    public void T(ua uaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, uaVar) == null) {
            this.b = uaVar;
        }
    }

    public void U(va vaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, vaVar) == null) {
            this.c = vaVar;
        }
    }

    public void V(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.f = i2;
        }
    }

    public void X(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, arrayList) == null) {
            this.A = arrayList;
            AbsMsglistView.j jVar = this.E;
            if (jVar != null) {
                jVar.a(arrayList, false);
            }
        }
    }

    public void Y(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.B = i2;
        }
    }

    public void a0(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, chatMessage) == null) {
            ShareChatroomMsgData e2 = kw8.e(chatMessage);
            ChatShareChatroomCard chatShareChatroomCard = this.t;
            if (chatShareChatroomCard != null) {
                chatShareChatroomCard.setVisibility(0);
                this.t.b(e2);
            }
        }
    }

    public void c0(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, chatMessage) == null) {
            G(chatMessage);
            ShareForumMsgData f2 = kw8.f(chatMessage);
            this.q.setVisibility(0);
            this.q.setCurrentCardType((short) 33);
            this.q.a(f2);
        }
    }

    public void h0(@NonNull ChatMessage chatMessage) {
        ImShareCardCommonData d2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048606, this, chatMessage) == null) && (d2 = kw8.d(chatMessage)) != null) {
            this.u.setVisibility(0);
            this.u.a(d2);
        }
    }

    public void j0(@NonNull ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, chatMessage) == null) {
            G(chatMessage);
            ShareThreadMsgData g2 = kw8.g(chatMessage);
            this.q.setVisibility(0);
            this.q.setCurrentCardType((short) 32);
            this.q.a(g2);
        }
    }

    public void setUpdateListener(AbsMsglistView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, jVar) == null) {
            this.E = jVar;
        }
    }

    public boolean E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public void J() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.F = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    public final String F(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j2)) == null) {
            if (j2 < 1000) {
                return "";
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j2 * 1000);
            Calendar calendar2 = this.e;
            if (calendar2 != null && calendar2.get(1) == calendar.get(1) && this.e.get(6) == calendar.get(6)) {
                return qd.getDateStringHm(calendar.getTime());
            }
            return qd.getDateStringMdHm(calendar.getTime());
        }
        return (String) invokeJ.objValue;
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.i = (TextView) g(R.id.tex_msgitem_time);
            TbRichTextView tbRichTextView = (TbRichTextView) g(R.id.tex_msgitem_text);
            this.j = tbRichTextView;
            tbRichTextView.setLinkTextColor(-14845754);
            this.j.setFaceSize(TbadkApplication.getInst().getResources().getDimension(R.dimen.T_X04));
            this.p = (ChatImageWithTailView) g(R.id.img_msgitem_image);
            this.C = (TbCheckBox) g(R.id.ckb_select);
            this.D = (LinearLayout) g(R.id.ll_ckb_select);
            this.m = (ShareFromPBView) g(R.id.lay_msgitem_share_view);
            this.n = (ShareFromFrsView) g(R.id.lay_msgitem_share_frs);
            this.o = (ShareFromGameCenter) g(R.id.lay_msgitem_share_game);
            this.r = (GamePlayCardMsgView) g(R.id.lay_msgitem_gameplay_card);
            this.s = (GamePlaySendCardMsgView) g(R.id.lay_msgitem_gameplay_send_card);
            ChatVoiceView chatVoiceView = (ChatVoiceView) g(R.id.lay_msgitem_voice);
            this.k = chatVoiceView;
            chatVoiceView.setClickable(true);
            ChatVoiceView chatVoiceView2 = this.k;
            chatVoiceView2.setOnClickListener(chatVoiceView2);
            ChatShareCard chatShareCard = (ChatShareCard) g(R.id.share_card_container);
            this.q = chatShareCard;
            chatShareCard.V = 2;
            ChatShareChatroomCard chatShareChatroomCard = (ChatShareChatroomCard) g(R.id.share_group_card);
            this.t = chatShareChatroomCard;
            chatShareChatroomCard.setScene(2);
            ChatShareCommonCard chatShareCommonCard = (ChatShareCommonCard) g(R.id.share_common_card);
            this.u = chatShareCommonCard;
            chatShareCommonCard.setScene(2);
            J();
            this.j.setOnClickListener(new h(this));
            this.k.setLongClickable(true);
            this.k.setOnLongClickListener(new i(this));
            this.p.getImage().setClickable(true);
            this.p.getImage().setOnClickListener(new j(this));
            this.p.getImage().setLongClickable(true);
            this.p.getImage().setOnLongClickListener(new k(this));
            this.p.getTail().setClickable(true);
            this.p.getTail().setOnClickListener(new l(this));
            this.j.setLongClickable(true);
            this.j.setOnLongClickListener(new m(this));
            GifView gifView = (GifView) g(R.id.emotion_msgitem_image);
            this.l = gifView;
            gifView.setSupportNoImage(false);
            this.l.setOnClickListener(new n(this));
            this.l.setLongClickable(true);
            this.l.setOnLongClickListener(new o(this));
            this.m.setClickable(true);
            this.m.setOnClickListener(new p(this));
            this.m.setLongClickable(true);
            this.m.setOnLongClickListener(new a(this));
            this.n.setClickable(true);
            this.n.setOnClickListener(new b(this));
            this.n.setLongClickable(true);
            this.n.setOnLongClickListener(new c(this));
            this.o.getContentBody().setClickable(true);
            this.o.getContentBody().setOnClickListener(new d(this));
            this.o.getTail().setClickable(true);
            this.o.getTail().setOnClickListener(new e(this));
            this.o.getContentBody().setLongClickable(true);
            this.o.getContentBody().setOnLongClickListener(new f(this));
        }
    }

    public void M(View view2, ChatMessage chatMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, view2, chatMessage) == null) {
            ChatMessage chatMessage2 = this.G;
            if (chatMessage2 == null || (chatMessage != null && chatMessage2.getMsgId() != chatMessage.getMsgId())) {
                D(chatMessage);
            }
            this.G = chatMessage;
            if (chatMessage != null) {
                chatMessage.setItemView(this);
                this.h = Long.valueOf(chatMessage.getMsgId());
            }
        }
    }

    public void Z(ChatMessage chatMessage, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048598, this, chatMessage, z) == null) {
            dp8.b(this.mContext.getContext(), this.l, chatMessage, z);
        }
    }

    public void k0(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048609, this, chatMessage, str) == null) {
            dp8.g(this.mContext.getContext(), this.k, chatMessage, str);
        }
    }

    public void b0(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048600, this, view2, chatMessage, str) == null) {
            dp8.c(this.mContext.getContext(), view2, this.m, this.n, this.o, chatMessage, str);
        }
    }

    public void g0(View view2, ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048605, this, view2, chatMessage, str) == null) {
            dp8.e(this.mContext.getContext(), view2, this.p, chatMessage, this.g, str);
        }
    }

    public void d0(@NonNull ChatMessage chatMessage) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, chatMessage) == null) {
            if (!this.v.booleanValue() && (runTask = MessageManager.getInstance().runTask(2921735, null, null)) != null && runTask.getData() != null) {
                this.v = (Boolean) runTask.getData();
            }
            G(chatMessage);
            GamePlayOrderMsgData b2 = kw8.b(chatMessage);
            this.r.setVisibility(0);
            this.r.setData(b2);
        }
    }

    public void e0(@NonNull ChatMessage chatMessage, String str) {
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048603, this, chatMessage, str) == null) {
            if (!this.v.booleanValue() && (runTask = MessageManager.getInstance().runTask(2921735, null, null)) != null && runTask.getData() != null) {
                this.v = (Boolean) runTask.getData();
            }
            GamePlaySendCardMsgData c2 = kw8.c(chatMessage);
            this.s.setVisibility(0);
            this.s.setPageContext((TbPageContext) getPageContext());
            this.s.setData(c2, chatMessage.getUserInfo().getPortrait(), String.valueOf(chatMessage.getToUserId()));
            this.s.setTag(str);
        }
    }

    public void i0(ChatMessage chatMessage, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048607, this, chatMessage, str) == null) {
            dp8.f(this.j, chatMessage, str, this.B);
            if (chatMessage != null && chatMessage.getContent() != null) {
                String[] split = chatMessage.getContent().split("#");
                StringBuffer stringBuffer = new StringBuffer();
                for (String str2 : split) {
                    stringBuffer.append(str2);
                }
                this.j.setContentDescription(stringBuffer.toString());
                this.j.getTextView().setContentDescription(stringBuffer.toString());
            }
        }
    }

    public void f0(ChatMessage chatMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, chatMessage) == null) {
            if (chatMessage.getCacheData() != null && chatMessage.getCacheData().getIs_show_time() == 1) {
                z = true;
            } else {
                z = false;
            }
            boolean I = I(chatMessage.getTime());
            if (!z && !I) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
                this.i.setText(F(chatMessage.getTime()));
            }
            if (!z && I) {
                MsgCacheData cacheData = chatMessage.getCacheData();
                if (cacheData == null) {
                    MsgCacheData msgCacheData = new MsgCacheData();
                    msgCacheData.setIs_show_time(1);
                    chatMessage.setCacheData(msgCacheData);
                    return;
                }
                cacheData.setIs_show_time(1);
            }
        }
    }

    public void l0(ChatMessage chatMessage) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, chatMessage) == null) {
            if (this.A == null) {
                this.A = new ArrayList<>();
            }
            if (this.z) {
                this.D.setVisibility(0);
                int i2 = 0;
                while (true) {
                    if (i2 < this.A.size()) {
                        ReportPrivateMsgData reportPrivateMsgData = this.A.get(i2);
                        if (reportPrivateMsgData != null && TextUtils.equals(String.valueOf(chatMessage.getMsgId()), reportPrivateMsgData.getMsgId())) {
                            z = true;
                            break;
                        }
                        i2++;
                    } else {
                        z = false;
                        break;
                    }
                }
                this.D.setTag(Boolean.valueOf(z));
                this.C.setTagData(new q(this));
                this.C.setBackgroundDrawableIdIsWebP(true);
                this.C.setClickable(false);
                this.C.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
                this.C.setChecked(((Boolean) this.D.getTag()).booleanValue());
                this.D.setOnClickListener(new g(this, chatMessage));
                return;
            }
            this.D.setVisibility(8);
        }
    }
}
